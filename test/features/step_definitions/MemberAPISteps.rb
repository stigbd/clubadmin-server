require 'net/http'
require 'uri'
require 'rubygems'
require 'json'

Given(/^the following member\-information$/) do |table|
  @inputs = table
  @payload = table.rows_hash.to_json
end

When(/^the client posts the input to "([^"]*)"$/) do |arg1|
  url = arg1
  uri = URI.parse(url)
  req = Net::HTTP::Post.new(uri.path, initheader = {'Content-Type' =>'application/json'})
    req.body = @payload
    @response = Net::HTTP.new(uri.host, uri.port).start {|http| http.request(req) }
end

Then(/^a Created status should be returned$/) do
  assert_equal "201", @response.code, 'expected HTTP 201 Created'
end

When(/^the client gets the member by header location$/) do
  uri = URI.parse(@response['location'])
  @location_res = Net::HTTP.get_response(uri)
end

Then(/^the saved member matches the inputs$/) do
  input = @inputs.rows_hash
  @saved_member = JSON.parse(@location_res.body)
  #todo iterate input-table and check corresponding values in res
  input.each do |key, value|
    assert_equal value, @saved_member[key], 'expected input equals saved_member'
  end
end

Then(/^the saved member has an id$/) do
  assert_not_nil(@saved_member['id'], 'expected id field in member')
end
