# encoding: UTF-8

Feature: Member API
  In order to administer membership information
  As a client of the Member API
  I want to be able to Create, Read, Update, Delete and List members

  Scenario: Create new member
    Given the following member-information
      | firstName | John              |
      | lastName  | Doe               |
      | email     | email@example.com |
    When the client posts the input to "http://localhost:8080/ClubMemberService/"
    Then a Created status should be returned
    When the client gets the member by header location
    Then the saved member matches the inputs
    And the saved member has an id
