@test
Feature: Contacts  scenarios

Scenario: Contact details
  When I enter username as "jose.virgen+02@grandpad.net"
  And I enter password as "Test12345!"
  And I enter submit button
  Then I should be logged in

  And I click on contacts button