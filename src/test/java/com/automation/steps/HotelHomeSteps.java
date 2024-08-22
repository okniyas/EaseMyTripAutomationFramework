package com.automation.steps;

import com.automation.pages.interfaces.HotelHomePage;
import com.automation.pages.mobile.HotelBookingPageMobile;
import com.automation.pages.mobile.HotelHomePageMobile;
import com.automation.pages.web.HotelBookingPageWeb;
import com.automation.pages.web.HotelHomePageWeb;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class HotelHomeSteps {
    HotelHomePage hotelHomePage;

    public HotelHomeSteps(){
        String env = ConfigReader.getConfigValue("application.type");

        if(env.equals("mobile")) {
            hotelHomePage = new HotelHomePageMobile();
        }else{
            hotelHomePage = new HotelHomePageWeb();
        }
    }
//    HotelHomePageWeb hotelHomePage=new HotelHomePageWeb();

    @When("user click on hotel menu")
    public void user_click_on_hotel_menu() {
        hotelHomePage.clickOnHotelMenu();
    }

    @Then("verify hotel home page is displayed")
    public void verify_hotel_home_page_is_displayed() {
        Assert.assertTrue(hotelHomePage.isHotelHomePageDisplayed());
    }

    @When("user select the destination as {string}")
    public void user_select_the_destination_as(String city) {
        hotelHomePage.selectDestinationCity(city);
    }

    @When("user enter the check in date as {string}")
    public void user_enter_the_check_in_date_as(String checkIn) {
        hotelHomePage.selectCheckInDate(checkIn);
    }

    @When("user enter the check out date as {string}")
    public void user_enter_the_check_out_date_as(String checkOut) {
        hotelHomePage.selectCheckOutDate(checkOut);
    }

    @When("user click on hotel search")
    public void user_click_on_hotel_search() {
        hotelHomePage.clickOnHotelSearch();
    }

    @And("user click on room select")
    public void userClickOnRoomSelect() {
        hotelHomePage.clickOnRoomsDone();
    }
}
