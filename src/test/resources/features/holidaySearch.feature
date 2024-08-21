Feature: Validate holidays functionality

  Background:

    Given user opens the website
    Then verify user is on home page
    When the user clicks on Holidays from the navigation bar
    Then verify the user is on the holidays home page
#    When the user clicks on the search box


  Scenario: Verify holidays search functionality

    When the user enters the destination "Kerala"
    And user select the destination from the dropdown list
    Then verify the holidays listing page shows results for the destination "Kerala"

  Scenario: Verify holidays package sorting from low to high
    When the user enters the destination "Kerala"
    And user select the destination from the dropdown list
    Then verify the holidays listing page shows results for the destination "Kerala"
    When user select sorting option from "Low to High"
    Then verify the holidays listing page shows results in ascending order

  Scenario: Verify holidays by filtering themes "solo" trip
    When the user enters the destination "Kerala"
    And user select the destination from the dropdown list
    Then verify the holidays listing page shows results for the destination "Kerala"
    When user click on more filter option in holidays listing page
    And select the theme of holiday type as "Solo"
    Then verify the holidays listing page shows results for the selected trip theme
