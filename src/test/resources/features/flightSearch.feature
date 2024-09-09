@web @mobile
Feature: Validate flight search

  Scenario: Verify flight search
    Given user opens the website
    Then verify user is on home page
    When user click on from city
    And user enter from city "flight.source.city"
    And user click on to city
    And user enter to city "flight.destination.city"
    And click on departure date
    And select date "flight.booking.date"
    And click on search button
    Then verify on flight list page