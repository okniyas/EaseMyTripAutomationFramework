Feature: validate plan your trip functionality

  Background:
    Given user opens the website
    Then verify user is on home page
    When the user clicks on Holidays from the navigation bar
    Then verify the user is on the holidays home page

  Scenario: verify user can submit query for plan your trip
    When user click on plan your trip icon
    Then verify plan form is displayed
    When user enter the trip details
    And user click on submit button
    Then verify query success message is displayed
