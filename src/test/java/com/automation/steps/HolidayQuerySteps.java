package com.automation.steps;

import com.automation.pages.interfaces.HolidayQueryPage;
import com.automation.pages.mobile.HolidayListingPageMobile;
import com.automation.pages.mobile.HolidayQueryPageMobile;
import com.automation.pages.web.HolidayListingPageWeb;
import com.automation.pages.web.HolidayQueryPageWeb;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class HolidayQuerySteps {

    HolidayQueryPage holidayQueryPage;

    public HolidayQuerySteps(){
        String env = ConfigReader.getConfigValue("application.type");

        if(env.equals("mobile")) {
            holidayQueryPage = new HolidayQueryPageMobile();
        }else{
            holidayQueryPage = new HolidayQueryPageWeb();
        }
    }
//    HolidayQueryPageWeb holidayQueryPageWeb =new HolidayQueryPageWeb();

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
