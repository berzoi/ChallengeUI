Feature: SimPals

  Scenario Outline: Check for Notifications
    Given The browser headless is 'false'
    When Page "https://999.md/ru/" is opened
    Then the user skips the consent
    And User is logged in
      | <userName> |
    Then Getting the number of notifications
    Then User is logging out

    Examples:
      | userName  |
      | brinkc    |
      | brinkc2   |


  Scenario: Add commercial ad for Logitech M170
    Given The browser headless is 'false'
    When Page "https://999.md/ru/" is opened
    Then the user skips the consent
    Then User is logged in

      |brinkc|
    And User is adding the 'M170' advertisement

      | Price |
      | 120   |
    Then the main page is opened
    And the draft "Logitech M170" item is displayed
    Then the user is editing the title of the draft "Logitech M170" item to "Logitech M170 - updated"
    And the draft "Logitech M170 - updated" item is displayed
    Then the user removes the draft "Logitech M170" items
    And User is checking no "Logitech M170" are displayed
    And User is checking no "Logitech M170 - updated" are displayed