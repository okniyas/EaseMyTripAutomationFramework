package com.automation.steps;

import com.automation.pages.interfaces.MetroPaymentPage;
import com.automation.pages.mobile.MetroPaymentPageMobile;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class MetroPaymentSteps {

    MetroPaymentPage metroPaymentPage = new MetroPaymentPageMobile();

    @Then("verify user is on payment booking page of metro")
    public void verifyUserIsOnPaymentBookingPageOfMetro() {
        Assert.assertTrue(metroPaymentPage.isVerifyOnPaymentsPageOfMetro());
    }
}
