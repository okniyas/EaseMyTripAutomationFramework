@web
Feature: Validate live station

  Scenario: verify live station
    Given user opens the website
    Then verify user is on home page
    When user click on train menu
    Then verify train home page is displayed
    When user click on live station
    And user enter train details
      | live.source.station |
      | live.destination    |
      | live.time           |
      | live.types          |
    And user click on search button for trains
    Then verify train listing page is displayed


