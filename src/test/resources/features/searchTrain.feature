Feature: Validate train search

  Scenario: verify list of train is displayed
    Given user opens the website
    Then verify user is on home page
    When user click on train menu
    Then verify train home page is displayed
    When user select source station as "Trivandrum"
    And user select destination station as "Kochi"
    And user select depart date as "12 November 2024"
    And click on train search button
    Then verify train list is displayed