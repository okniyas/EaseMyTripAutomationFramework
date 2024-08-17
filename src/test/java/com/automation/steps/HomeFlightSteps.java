package com.automation.steps;

import com.automation.pages.HomeFlightPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class HomeFlightSteps {

    HomeFlightPage homeFlightPage = new HomeFlightPage();

    @Given("user opens the website")
    public void user_opens_the_website() {
        homeFlightPage.opensTheWebsite();

    }

    @Given("click on search button")
    public void click_on_search_button() {
        homeFlightPage.clickOnSearchBtn();

    }

    @Then("verify on flight list page")
    public void verify_on_flight_list_page() {
        Assert.assertTrue(homeFlightPage.verifyOnFlightListPage());

    }

    @And("click on departure date")
    public void clickOnDepartureDate() {
        homeFlightPage.clickOnDepartureDate();
    }

    @And("select date {string}")
    public void selectDate(String date) {
        homeFlightPage.selectDate(date);
    }

    @Then("verify user is on home page")
    public void verifyUserIsOnHomePage() {
        Assert.assertTrue(homeFlightPage.verifyOnHomePage());
    }

    @When("user click on from city")
    public void userClickOnFromCity() {
        homeFlightPage.clickOnFromCity();
    }

    @And("user click on to city")
    public void userClickOnToCity() {
        homeFlightPage.clickOnToCity();
    }

    @And("user enter from city {string}")
    public void userEnterFromCity(String fromCity) {
        homeFlightPage.enterFromCity(fromCity);
    }

    @And("user enter to city {string}")
    public void userEnterToCity(String toCity) {
        homeFlightPage.enterToCity(toCity);
    }
}
