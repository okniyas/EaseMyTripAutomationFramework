@web @mobile
Feature: Validate gift card checkout functionality

  Scenario Outline: Verify gift card booking checkout
    Given user opens the website
    Then verify user is on home page
    When the user clicks on gift card menu
    And user select the gift card type "<gift.card.type>"
    And user enter the gift card details

      | gift.card.denomination |
      | gift.card.quantity     |

    And user enter the sender and receiver details

      | gift.card.sender.name           |
      | gift.card.sender.email          |
      | gift.card.sender.mobile         |
      | gift.card.receiver.name         |
      | gift.card.receiver.email        |
      | gift.card.retype.receiver.email |
      | gift.card.receiver.mobile       |

    And user click on accept terms and conditions
    And user click on pay now button
    Then verify enter OTP code field is displayed

    Examples:
      | gift.card.type   |
      | gift.card.type.1 |
      | gift.card.type.2 |
      | gift.card.type.3 |
      | gift.card.type.4 |
      | gift.card.type.5 |
