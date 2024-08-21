package com.automation.steps;

import com.automation.pages.HotelBookingPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class HotelBookingSteps {

    HotelBookingPage hotelBookingPage=new HotelBookingPage();

    @When("click on book now")
    public void click_on_book_now() {
        hotelBookingPage.clickOnBookNow();
    }

    @Then("verify hotel booking page is displayed")
    public void verifyHotelBookingPageIsDisplayed() {
        Assert.assertTrue(hotelBookingPage.isHotelBookingPageDisplayed());
    }
}
