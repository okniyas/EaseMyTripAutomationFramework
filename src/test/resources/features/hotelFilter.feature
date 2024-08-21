Feature: validate filter functionality for hotels

  Background:
    Given user opens the website
    Then verify user is on home page
    When user click on hotel menu
    Then verify hotel home page is displayed
    When user select the destination as "Trivandrum"
    And user enter the check in date as "12 Dec 2024"
    And user enter the check out date as "13 Dec 2024"
    And user click on room select
    And user click on hotel search
    Then verify user is on hotel listing page

  Scenario: filter by price low to high
    When user click on filter
    And user select filter by price low to high
    Then verify price listing is from low to high

  Scenario: filter by price high to low
    When user click on filter
    And user select filter by price high to low
    Then verify price listing is from high to low

