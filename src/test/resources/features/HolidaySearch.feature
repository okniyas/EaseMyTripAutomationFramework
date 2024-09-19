@web @mobile
Feature: Validate holidays functionality

  Background:

    Given user opens the website
    Then verify user is on home page
    When the user clicks on Holidays from the navigation bar
    Then verify the user is on the holidays home page
#    When the user clicks on the search box


  Scenario: Verify holidays search functionality

    When the user enters the destination "holidays.destination"
    And user select the destination from the dropdown list
    Then verify the holidays listing page shows results for the destination "holidays.destination"

  Scenario: Verify holidays by filtering themes trip

    When the user enters the destination "holidays.destination"
    And user select the destination from the dropdown list
    Then verify the holidays listing page shows results for the destination "holidays.destination"
    When user click on more filter option in holidays listing page
    And select the theme of holiday type as "holidays.type"
    Then verify the holidays listing page shows results for the selected trip theme "holidays.type"


  Scenario Outline: Verify holidays package sorting
    When the user enters the destination "holidays.destination"
    And user select the destination from the dropdown list
    Then verify the holidays listing page shows results for the destination "holidays.destination"
    When user select sorting option from "<sorting type>"
    Then verify the holidays listing page shows results in "<sorting type>" order

    Examples:
      | sorting type |
      | Low to High  |
      | High to Low  |
