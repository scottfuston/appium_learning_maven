Feature: Settings Feature

  Scenario: Settings
#  puma # C5705, C5706, C350010
#  serval # C9421, C9422, C285833

#  Can click the gear to access the settings menu
  Given I am logged in as  "jose.virgen+02@grandpad.net"
    When  I click the profile icon
    And I click the settings icon
    Then I should be on the settings page
