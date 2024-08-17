package com.automation.steps;

import com.automation.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class HomeSteps {

    HomePage homePage = new HomePage();

    @Given("user opens the website")
    public void user_opens_the_website() {
        homePage.opensTheWebsite();
        
    }

    @Given("click on search button")
    public void click_on_search_button() {
        homePage.clickOnSearchBtn();
        
    }

    @Then("verify on flight list page")
    public void verify_on_flight_list_page() {
        Assert.assertTrue(homePage.verifyOnFlightListPage());
        
    }

    @And("click on departure date")
    public void clickOnDepartureDate() {
        homePage.clickOnDepartureDate();
    }

    @And("select date {string}")
    public void selectDate(String date) {
        homePage.selectDate(date);
    }
}
