package com.automation.steps;

import com.automation.pages.interfaces.HotelListingPage;
import com.automation.pages.mobile.HotelHomePageMobile;
import com.automation.pages.mobile.HotelListingPageMobile;
import com.automation.pages.web.HotelHomePageWeb;
import com.automation.pages.web.HotelListingPageWeb;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class HotelListingSteps {

    HotelListingPage hotelListingPage;

    public HotelListingSteps(){
        String env = ConfigReader.getConfigValue("application.type");

        if(env.equals("mobile")) {
            hotelListingPage = new HotelListingPageMobile();
        }else{
            hotelListingPage = new HotelListingPageWeb();
        }
    }
//    HotelListingPageWeb hotelListingPage= new HotelListingPageWeb();

    @Then("verify user is on hotel listing page")
    public void verify_user_is_on_hotel_listing_page() {
        Assert.assertTrue(hotelListingPage.isHotelListingPageDisplayed());
    }

    @When("user click on filter")
    public void user_click_on_filter() {
        hotelListingPage.clickOnFilter();
    }

    @When("user select filter by price low to high")
    public void user_select_filter_by_price_low_to_high() {
        hotelListingPage.selectFilterPriceLowToHigh();
    }

    @Then("verify price listing is from low to high")
    public void verify_price_listing_is_from_low_to_high() {
        hotelListingPage.isPriceListingFromLowToHigh();
    }

    @When("user select filter by price high to low")
    public void user_select_filter_by_price_high_to_low() {
        hotelListingPage.selectFilterPriceHighToLow();
    }

    @Then("verify price listing is from high to low")
    public void verify_price_listing_is_from_high_to_low() {
        hotelListingPage.isPriceListingFromHighToLow();
    }

    @When("user select a hotel")
    public void user_select_a_hotel() {
        hotelListingPage.selectHotel();
    }

}
