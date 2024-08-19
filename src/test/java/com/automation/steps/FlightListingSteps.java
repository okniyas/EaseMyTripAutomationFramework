package com.automation.steps;

import com.automation.pages.FlightListingPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class FlightListingSteps {
    FlightListingPage flightListingPage = new FlightListingPage();

    @Then("verify on flight list page")
    public void verify_on_flight_list_page() {
        Assert.assertTrue(flightListingPage.verifyOnFlightListPage());

    }

    @When("user unTicks all the flights except the flight to be filtered {string}")
    public void userUnTicksAllTheFlightsExceptTheFlightToBeFiltered(String flightName) {
        flightListingPage.userUnTickFlightsExceptOneToBeFiltered(flightName);

    }

    @Then("verify that only the filtered flight {string} is present on the flight listing page")
    public void verifyThatOnlyTheFilteredFlightIsPresentOnTheFlightListingPage(String flightName) {
        Assert.assertTrue(flightListingPage.verifyOnlyTheFilteredFlightIsPresent(flightName));
    }
}
