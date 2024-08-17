Feature: Validate flight search

  Scenario: Verify flight search
    Given user opens the website
    And click on departure date
    And select date "20 Aug 2024"
    And click on search button
    Then verify on flight list page