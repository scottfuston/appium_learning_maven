
Feature: Login scenarios

  Scenario: Grandpad Logo and Call support is displayed
    Then Grandpad Logo is displayed
    Then call support number is displayed

  Scenario: Login with invalid user name
    When I enter username as "josefake@grandpad.net"
    Then I see an error message

  Scenario: Login with valid user name
    When I enter username as "jose.virgen+02@grandpad.net"
    And I enter password as "Test12345!"
    And I enter submit button
    Then I should be logged in









