package com.automation.pages.interfaces;

import java.util.List;

public interface BusBookingTravellersPage {

    boolean verifyOnBusBookingTravellersPage();

    void enterTheTravellerDetails(List<String> travellerDetails);

    void enterTheMobileNumber();

    void clickOnContinueBtnInTravellersBookingPage();

    boolean verifyIsOnPaymentBookingPage();
}
