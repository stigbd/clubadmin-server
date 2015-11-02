# encoding: UTF-8

Feature: Member API
  In order to administer membership information
  As a client of the Member API
  I want to be able to Create, Read, Update, Delete and List members
  I also want to be able to create relations between one member and multiple family-members

  Scenario: Create new member
    Given the following member-information
      | firstName | John|
      | lastName  | Doe               |
      | email     | email@example.com |
      | sex         | M                 |
      | birthDate   | 01.01.2000        |
      | mobile      | 12345678          |
      | active      | true              |
      | memberSince | 01.01.2010        |
    When the client posts the input to "http://localhost:8080/ClubMemberService/"
    Then a "201" status should be returned
    When the client gets the member by header location
    Then a "200" status should be returned
    And the saved member matches the inputs
    And the saved member has an id

  Scenario: Update an existing member
    Given the following member-information exists
      | firstName | Jane |
      | lastName  | Doe  |
    When the client puts the following updated information
      | firstName | Jane Changed      |
      | lastName  | Does changed      |
      | sex       | F added           |
      | email     | added@example.com |
    Then a "204" status should be returned
    When the client gets the member by header location
    Then the member should contain the updated information

  Scenario: Remove an existing member
    Given the following member-information exists
      | firstName | Jane |
      | lastName  | Doe  |
    When the client deletes the member
    Then a "204" status should be returned
    When the client gets the member by header location
    Then a "404" status should be returned
