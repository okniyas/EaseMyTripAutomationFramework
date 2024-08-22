package com.automation.steps;

import com.automation.pages.HolidayQueryPage;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class HolidayQuerySteps {
    
    HolidayQueryPage holidayQueryPage=new HolidayQueryPage();

    @Then("verify plan form is displayed")
    public void verify_plan_form_is_displayed() {
        Assert.assertTrue(holidayQueryPage.isQueryFormDisplayed());
    }

    @When("user enter the trip details")
    public void user_enter_the_trip_details() {
        holidayQueryPage.enterTripDetails(
                ConfigReader.getConfigValue("holiday.destination"),
                ConfigReader.getConfigValue("holiday.departure.date"),
                ConfigReader.getConfigValue("holiday.departure.city"),
                ConfigReader.getConfigValue("holiday.user.name"),
                ConfigReader.getConfigValue("holiday.user.phone"),
                ConfigReader.getConfigValue("holiday.user.email"),
                ConfigReader.getConfigValue("holiday.adult.count")
        );
    }

    @When("user click on submit button")
    public void user_click_on_submit_button() {
        holidayQueryPage.clickOnSubmitForm();
    }

    @Then("verify query success message is displayed")
    public void verify_query_success_message_is_displayed() {
        Assert.assertTrue(holidayQueryPage.isQuerySuccessMsgDisplayed());
    }
}
