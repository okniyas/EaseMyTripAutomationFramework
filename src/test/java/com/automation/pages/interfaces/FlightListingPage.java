package com.automation.pages.interfaces;

public interface FlightListingPage {

    boolean verifyOnFlightListPage();

    void userUnTickFlightsExceptOneToBeFiltered(String flightName);

    boolean verifyOnlyTheFilteredFlightIsPresent(String flightName);
}
