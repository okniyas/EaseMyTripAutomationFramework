package com.automation.steps;

import com.automation.pages.interfaces.HotelBookingPage;
import com.automation.pages.mobile.HolidayListingPageMobile;
import com.automation.pages.mobile.HotelBookingPageMobile;
import com.automation.pages.web.HolidayListingPageWeb;
import com.automation.pages.web.HotelBookingPageWeb;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class HotelBookingSteps {
    HotelBookingPage hotelBookingPage;

    public HotelBookingSteps(){
        String env = ConfigReader.getConfigValue("application.type");

        if(env.equals("mobile")) {
            hotelBookingPage = new HotelBookingPageMobile();
        }else{
            hotelBookingPage = new HotelBookingPageWeb();
        }
    }
//    HotelBookingPageWeb hotelBookingPage=new HotelBookingPageWeb();

    @When("click on book now")
    public void click_on_book_now() {
        hotelBookingPage.clickOnBookNow();
    }

    @Then("verify hotel booking page is displayed")
    public void verifyHotelBookingPageIsDisplayed() {
        Assert.assertTrue(hotelBookingPage.isHotelBookingPageDisplayed());
    }
}
