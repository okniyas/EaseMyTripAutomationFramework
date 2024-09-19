package com.automation.pages.interfaces;

public interface MetroBookingPage {


    default void clickOnMetroOption() {
    }

    default void selectMetroCityAs(String metroCity) {
    }

    default void selectDepartureStation(String departureStation) {

    }

    default void selectDestinationStation(String destinationStation) {
    }

    default void enterNoOfPassengers(String noOfPassengers) {

    }

    default void clickOnAgreeTermsAndConditions() {

    }

    default void clickOnProceedToPayBtn() {

    }

    default boolean contactDetailsPopupIsDisplayed() {
        return false;
    }

    default void enterContactDetails(String email, String mobileNumber) {
    }

    default void clickOnContinueBtnOfContactDetails() {

    }
}
