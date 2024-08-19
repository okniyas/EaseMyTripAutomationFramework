Feature: Validate flight filter

  Scenario: Verify flight listing page with specific flight
    Given user opens the website
    Then verify user is on home page
    When user click on from city
    And user enter from city "Bengaluru"
    And user click on to city
    And user enter to city "Thiruvananthapuram"
    And click on departure date
    And select date "27 Sep 2024"
    And click on search button
    Then verify on flight list page
    When user unTicks all the flights except the flight to be filtered "Indigo"
    Then verify that only the filtered flight "Indigo" is present on the flight listing page
