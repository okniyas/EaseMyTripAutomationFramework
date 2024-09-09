@mobile
Feature: Validate metro checkout functionality

  Scenario: Verify metro booking checkout
    Given user opens the website
    Then verify user is on home page
    When the user clicks on Metro option
    And select metro option as "metro.city"
    And select departure station "metro.departure.station"
    And select destination station "metro.destination.station"
    And enter the number of passenger "metro.passenger.count"
    And click on agree to terms and conditions
    And click on proceed to pay button
    Then verify contact details pop up is displayed
    When the user enter the contact details
      | metro.email  |
      | metro.mobile |
    And user click on continue button of contact details
    Then verify user is on payment booking page of metro