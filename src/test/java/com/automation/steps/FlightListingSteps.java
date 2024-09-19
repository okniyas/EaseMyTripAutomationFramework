package com.automation.steps;

import com.automation.pages.interfaces.FlightListingPage;
import com.automation.pages.mobile.FlightListingPageMobile;
import com.automation.pages.web.FlightListingPageWeb;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class FlightListingSteps {
    FlightListingPage flightListingPage;

    public FlightListingSteps(){
        String env = ConfigReader.getConfigValue("application.type");

        if(env.equals("mobile")) {
            flightListingPage = new FlightListingPageMobile();
        }else{
            flightListingPage = new FlightListingPageWeb();
        }
    }
//    FlightListingPageWeb flightListingPage = new FlightListingPageWeb();

    @Then("verify on flight list page")
    public void verify_on_flight_list_page() {
        Assert.assertTrue(flightListingPage.verifyOnFlightListPage());

    }

    @When("user unTicks all the flights except the flight to be filtered {string}")
    public void userUnTicksAllTheFlightsExceptTheFlightToBeFiltered(String flightNameKey) {
        flightListingPage.userUnTickFlightsExceptOneToBeFiltered(ConfigReader.getConfigValue(flightNameKey));

    }

    @Then("verify that only the filtered flight {string} is present on the flight listing page")
    public void verifyThatOnlyTheFilteredFlightIsPresentOnTheFlightListingPage(String flightName) {
        Assert.assertTrue(flightListingPage.verifyOnlyTheFilteredFlightIsPresent(ConfigReader.getConfigValue(flightName)));
    }
}
