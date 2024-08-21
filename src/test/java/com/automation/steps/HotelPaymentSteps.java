package com.automation.steps;

import com.automation.pages.HotelPaymentPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class HotelPaymentSteps {

    HotelPaymentPage hotelPaymentPage=new HotelPaymentPage();

    @Then("verify the price summary calculations")
    public void verify_the_price_summary_calculations() {
        hotelPaymentPage.isPriceSummaryCorrect();
    }


    @Then("verify hotel payment page is displayed")
    public void verifyHotelPaymentPageIsDisplayed() {
        Assert.assertTrue(hotelPaymentPage.isHotelPaymentPageDisplayed());
    }
}
