
Feature: Login scenarios

  Scenario: Login with valid user name
    When I enter username as "jose.virgen+02@grandpad.net"
    And I enter password as "Test12345!"
    And I enter submit button
#    And I accept notifications
    Then I should be logged in

#  Scenario: Call Support Number is displayed
#    Then call support number is displayed






