Feature: Validate bus functionalities

  Background:
    Given user opens the website
    Then verify user is on home page
    When the user clicks on Bus from the navigation bar
    Then verify the user is on the bus home page
    When user enter the source city "bus.source.city"
    And user enter the destination city "bus.destination.city"
    And user select departure date as "bus.booking.checkout.date"
    And user click on search button on the bus page

  @web @mobile
  Scenario: Verify bus booking

    Then verify user is on listing page of the bus page

  @web
  Scenario: Verify bus booking checkout

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
      | bus.booking.title      |
      | bus.booking.first.name |
      | bus.booking.last.name  |
      | bus.booking.age        |

    And user enter the mobile number
    And user click on continue button in travellers booking page
    Then verify user is on payment booking page

  @mobile
  Scenario: Verify bus booking checkout mobile

    Then verify user is on listing page of the bus page
    When user click on select seat button for the first bus displayed on listing page
    And select the first available seat
    Then verify the seat is selected
    And user select the first boarding point
    And user select the first dropping point
    And user click on continue button
    Then verify user is on bus booking review page
    Then verify user is on bus booking travellers page
    When user enter the traveller details
      | bus.booking.title      |
      | bus.booking.first.name |
      | bus.booking.last.name  |
      | bus.booking.age        |
      | bus.booking.email      |
      | bus.booking.mobile     |

    When user click on "Secure My Trip"
    And user click on continue button in review booking page
    And user click on continue button in travellers booking page
    Then verify user is on payment booking page


