package com.automation.steps;

import com.automation.pages.interfaces.HolidayHomePage;
import com.automation.pages.mobile.HolidayHomePageMobile;
import com.automation.pages.web.HolidayHomePageWeb;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class HolidayHomeSteps {
    HolidayHomePage holidayHomePage;
    public HolidayHomeSteps(){
        String env = ConfigReader.getConfigValue("application.type");

        if(env.equals("mobile")) {
            holidayHomePage = new HolidayHomePageMobile();
        }else{
            holidayHomePage = new HolidayHomePageWeb();
        }
    }
//    HolidayHomePageWeb holidayHomePage = new HolidayHomePageWeb();

    @When("the user clicks on Holidays from the navigation bar")
    public void the_user_clicks_on_holidays_from_the_navigation_bar() {
        holidayHomePage.clickOnHolidaysFromNavBar();
        
    }

    @Then("verify the user is on the holidays home page")
    public void verify_the_user_is_on_the_holidays_home_page() {
        Assert.assertTrue(holidayHomePage.verifyOnHolidaysHomePage());
        
    }

    @When("the user enters the destination {string}")
    public void the_user_enters_the_destination(String destinationKey) {
        holidayHomePage.enterTheDestination(ConfigReader.getConfigValue(destinationKey));
        
    }


    @And("user select the destination from the dropdown list")
    public void userSelectTheDestinationFromTheDropdownList() {
        holidayHomePage.selectTheDestinationFromDropDownList();
    }

    @When("user click on plan your trip icon")
    public void user_click_on_plan_your_trip_icon() {
        holidayHomePage.clickOnPlanYourTripIcon();
    }

}
