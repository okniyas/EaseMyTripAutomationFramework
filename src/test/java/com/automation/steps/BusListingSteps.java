package com.automation.steps;

import com.automation.pages.BusListingPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class BusListingSteps {

    BusListingPage busListingPage = new BusListingPage();

    @Then("verify user is on listing page of the bus page")
    public void verify_user_is_on_listing_page_of_the_bus_page() {
        Assert.assertTrue(busListingPage.verifyUserIsOnListingPageOfBus());

    }

    @When("user click on select seat button for the first bus displayed on listing page")
    public void userClickOnSelectSeatButtonForTheFirstBusDisplayedOnListingPage() {
        busListingPage.clickOnSelectSeatBtnOfTheFirstBus();
    }
}
