require 'net/http'
require 'uri'
require 'rubygems'
require 'json'

Given(/^the following member\-information$/) do |table|
  @inputs = table
  @payload = table.rows_hash.to_json
end

Given(/^the following member\-information exists$/) do |table|
  @inputs = table
  @payload = table.rows_hash.to_json
  url = "http://localhost:8080/ClubMemberService/"
  uri = URI.parse(url)
  req = Net::HTTP::Post.new(uri.path, initheader = {'Content-Type' =>'application/json'})
    req.body = @payload
    @response = Net::HTTP.new(uri.host, uri.port).start {|http| http.request(req) }
end

When(/^the client posts the input to "([^"]*)"$/) do |arg1|
  url = arg1
  uri = URI.parse(url)
  req = Net::HTTP::Post.new(uri.path, initheader = {'Content-Type' =>'application/json'})
    req.body = @payload
    @response = Net::HTTP.new(uri.host, uri.port).start {|http| http.request(req) }
end

Then(/^a "([^"]*)" status should be returned$/) do |arg1|
  assert_equal arg1, @response.code
end

When(/^the client gets the member by header location$/) do
  uri = URI.parse(@response['location'])
  @location_res = Net::HTTP.get_response(uri)
end

Then(/^the saved member matches the inputs$/) do
  input = @inputs.rows_hash
  @saved_member = JSON.parse(@location_res.body)
  input.each do |key, value|
    assert_equal value, @saved_member[key], 'expected input equals saved_member'
  end
end

Then(/^the saved member has an id$/) do
  assert_not_nil(@saved_member['id'], 'expected id field in member')
end

When(/^the client puts the following updated information to "([^"]*)" plus id$/) do |arg1, table|
  # table is a Cucumber::Core::Ast::DataTable
  @uri = URI.parse(@response['location'])
  puts @uri
  @payload = table.rows_hash.to_json
  puts @payload
  req = Net::HTTP::Put.new(@uri.path, initheader = {'Content-Type' =>'application/json'})
  req.body = @payload
  puts req.body
  @response = Net::HTTP.new(@uri.host, @uri.port).start {|http| http.request(req) }
end

When(/^the client gets the member$/) do
  @response = Net::HTTP.get_response(@uri)
end

Then(/^the member should contain the updated information$/) do
  updated_member = JSON.parse(@response.body)
  input = JSON.parse(@payload)
  input.each do |key, value|
      assert_equal value, updated_member[key], 'expected input equals saved_member'
    end
end

When(/^the client deletes the member to "([^"]*)" plus id$/) do |arg1|
  @uri = URI.parse(@response['location'])
  puts @uri
  http = Net::HTTP.new(@uri.host, @uri.port)
  req = Net::HTTP::Delete.new(@uri.path)
  @response = http.request(req)
  puts "deleted #{@response}"
end