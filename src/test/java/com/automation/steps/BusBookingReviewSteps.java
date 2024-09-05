package com.automation.steps;

import com.automation.pages.interfaces.BusBookingReviewPage;
import com.automation.pages.mobile.BusBookingReviewPageMobile;
import com.automation.pages.web.BusBookingReviewPageWeb;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class BusBookingReviewSteps {

    BusBookingReviewPage busBookingReviewPage;

    public BusBookingReviewSteps(){
        String env = ConfigReader.getConfigValue("application.type");

        if(env.equals("mobile")) {
            busBookingReviewPage = new BusBookingReviewPageMobile();
        }else{
            busBookingReviewPage = new BusBookingReviewPageWeb();
        }
    }

//    BusBookingReviewPageWeb busBookingReviewPage = new BusBookingReviewPageWeb();

    @Then("verify user is on bus booking review page")
    public void verifyUserIsOnBusBookingReviewPage() {
        Assert.assertTrue(busBookingReviewPage.verifyOnBusBookingReviewPage());
    }


    @When("user click on {string}")
    public void userClickOn(String insurance) {
        busBookingReviewPage.clickOnInsuranceType(insurance);
    }

    @And("enter the email address {string}")
    public void enterTheEmailAddress(String emailKey) {
        busBookingReviewPage.enterTheEmailAddress(emailKey);
    }

    @And("user click on continue button in review booking page")
    public void userClickOnContinueButtonInReviewBookingPage() {
        busBookingReviewPage.clickOnContinueBtnInReviewBookingPage();
    }


}
