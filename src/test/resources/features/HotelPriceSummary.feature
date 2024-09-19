@web @mobile
Feature: validate the booking price summary

  Background:
    Given user opens the website
    Then verify user is on home page
    When user click on hotel menu
    Then verify hotel home page is displayed
    When user select the destination as "Trivandrum"
    And user enter the check in date as "12 Dec 2024"
    And user enter the check out date as "13 Dec 2024"
    And user click on room select
    And user click on hotel search
    Then verify user is on hotel listing page

  Scenario: verify the price summary for hotel booking
    When user select a hotel
    Then verify hotel booking page is displayed
    When click on book now
    Then verify hotel payment page is displayed
    And verify the price summary calculations
