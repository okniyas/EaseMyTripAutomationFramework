package com.automation.steps;

import com.automation.pages.BusBookingReviewPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class BusBookingReviewSteps {

    BusBookingReviewPage busBookingReviewPage = new BusBookingReviewPage();

    @Then("verify user is on bus booking review page")
    public void verifyUserIsOnBusBookingReviewPage() {
        Assert.assertTrue(busBookingReviewPage.verifyOnBusBookingReviewPage());
    }


    @When("user click on {string}")
    public void userClickOn(String insurance) {
        busBookingReviewPage.clickOnInsuranceType(insurance);
    }

    @And("enter the email address {string}")
    public void enterTheEmailAddress(String email) {
        busBookingReviewPage.enterTheEmailAddress(email);
    }

    @And("user click on continue button in review booking page")
    public void userClickOnContinueButtonInReviewBookingPage() {
        busBookingReviewPage.clickOnContinueBtnInReviewBookingPage();
    }


}
