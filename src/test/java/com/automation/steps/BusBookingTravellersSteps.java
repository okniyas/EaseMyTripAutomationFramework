package com.automation.steps;

import com.automation.pages.BusBookingTravellersPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class BusBookingTravellersSteps {

    BusBookingTravellersPage busBookingTravellersPage = new BusBookingTravellersPage();

    @Then("verify user is on bus booking travellers page")
    public void verifyUserIsOnBusBookingTravellersPage() {
        Assert.assertTrue(busBookingTravellersPage.verifyOnBusBookingTravellersPage());
    }

    @When("user enter the traveller details")
    public void userEnterTheTravellerDetails() {
        busBookingTravellersPage.enterTheTravellerDetails();
    }

    @And("user enter the mobile number")
    public void userEnterTheMobileNumber() {
        busBookingTravellersPage.enterTheMobileNumber();
    }

    @And("user click on continue button in travellers booking page")
    public void userClickOnContinueButtonInTravellersBookingPage() {
        busBookingTravellersPage.clickOnContinueBtnInTravellersBookingPage();
    }

    @Then("verify user is on payment booking page")
    public void verifyUserIsOnPaymentBookingPage() {
        Assert.assertTrue(busBookingTravellersPage.verifyIsOnPaymentBookingPage());
    }
}
