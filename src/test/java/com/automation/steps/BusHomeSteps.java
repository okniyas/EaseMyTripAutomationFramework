package com.automation.steps;

import com.automation.pages.interfaces.BusHomePage;
import com.automation.pages.mobile.BusBookingTravellersPageMobile;
import com.automation.pages.mobile.BusHomePageMobile;
import com.automation.pages.web.BusBookingTravellersPageWeb;
import com.automation.pages.web.BusHomePageWeb;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class BusHomeSteps {
    BusHomePage busHomePage;
    public BusHomeSteps(){
        String env = ConfigReader.getConfigValue("application.type");

        if(env.equals("mobile")) {
            busHomePage = new BusHomePageMobile();
        }else{
            busHomePage = new BusHomePageWeb();
        }
    }
//    BusHomePageWeb busHomePage = new BusHomePageWeb();

    @When("the user clicks on Bus from the navigation bar")
    public void the_user_clicks_on_bus_from_the_navigation_bar() {
        busHomePage.clickOnBusFromNavBar();
        
    }

    @Then("verify the user is on the bus home page")
    public void verify_the_user_is_on_the_bus_home_page() {
        Assert.assertTrue(busHomePage.verifyUserIsOnBusHomePage());
        
    }

    @When("user enter the source city {string}")
    public void user_enter_the_source_city(String sourceCity) {
        busHomePage.enterTheSourceCity(sourceCity);
        
    }

    @When("user enter the destination city {string}")
    public void user_enter_the_destination_city(String destinationCity) {
        busHomePage.enterTheDestinationCity(destinationCity);
        
    }

    @When("user select departure date as {string}")
    public void user_select_departure_date_as(String date) {
        busHomePage.selectDepartureDate(date);
        
    }

    @When("user click on search button on the bus page")
    public void user_click_on_search_button_on_the_bus_page() {
        busHomePage.clickOnSearchBtnOnBusPage();
        
    }

}
