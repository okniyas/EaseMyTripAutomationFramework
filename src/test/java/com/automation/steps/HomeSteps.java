package com.automation.steps;

import com.automation.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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

    @Then("verify user is on home page")
    public void verifyUserIsOnHomePage() {
        Assert.assertTrue(homePage.verifyOnHomePage());
    }

    @When("user click on from city")
    public void userClickOnFromCity() {
        homePage.clickOnFromCity();
    }

    @And("user click on to city")
    public void userClickOnToCity() {
        homePage.clickOnToCity();
    }

    @And("user enter from city {string}")
    public void userEnterFromCity(String fromCity) {
        homePage.enterFromCity(fromCity);
    }

    @And("user enter to city {string}")
    public void userEnterToCity(String toCity) {
        homePage.enterToCity(toCity);
    }
}
