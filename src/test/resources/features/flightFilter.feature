Feature: Validate flight filter

  Scenario: Verify flight listing page with specific flight
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
    When user unTicks all the flights except the flight to be filtered "flight.filter.name"
    Then verify that only the filtered flight "flight.filter.name" is present on the flight listing page
