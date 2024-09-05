Feature: Validate bus functionalities

  Scenario: Verify bus booking checkout
    Given user opens the website
    Then verify user is on home page
    When the user clicks on Bus from the navigation bar
    Then verify the user is on the bus home page
    When user enter the source city "bus.source.city"
    And user enter the destination city "bus.destination.city"
    And user select departure date as "bus.booking.checkout.date"
    And user click on search button on the bus page
    Then verify user is on listing page of the bus page

    When user click on select seat button for the first bus displayed on listing page
    And select the first available seat
    Then verify the seat is selected
    And user select the first boarding point
    And user select the first dropping point
    And user click on continue button
    Then verify user is on bus booking review page
    When user click on "secure my trip with insurance"
    And enter the email address "bus.booking.email"
    And user click on continue button in review booking page

    Then verify user is on bus booking travellers page
    When user enter the traveller details
    And user enter the mobile number
    And user click on continue button in travellers booking page
    Then verify user is on payment booking page

  Scenario: Verify bus booking
    Given user opens the website
    Then verify user is on home page
    When the user clicks on Bus from the navigation bar
    Then verify the user is on the bus home page
    When user enter the source city "bus.source.city"
    And user enter the destination city "bus.destination.city"
    And user select departure date as "bus.booking.date"
    And user click on search button on the bus page
    Then verify user is on listing page of the bus page


