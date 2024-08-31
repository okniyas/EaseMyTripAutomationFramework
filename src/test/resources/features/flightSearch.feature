Feature: Validate flight search

  Scenario: Verify flight search
    Given user opens the website
    Then verify user is on home page
    When user click on from city
    And user enter from city "Bangalore"
    And user click on to city
    And user enter to city "Thiruvananthapuram"
    And click on departure date
    And select date "27 Dec 2024"
    And click on search button
    Then verify on flight list page