package com.automation.steps;

import com.automation.pages.interfaces.FlightHomePage;
import com.automation.pages.mobile.FlightHomePageMobile;
import com.automation.pages.web.FlightHomePageWeb;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class FlightHomeSteps {

    FlightHomePage flightHomePage;

    public FlightHomeSteps(){
        String env = ConfigReader.getConfigValue("application.type");

        if(env.equals("mobile")) {
            flightHomePage = new FlightHomePageMobile();
        }else{
            flightHomePage = new FlightHomePageWeb();
        }
    }

//    FlightHomePageWeb flightHomePage = new FlightHomePageWeb();

    @Given("user opens the website")
    public void user_opens_the_website() {
        flightHomePage.opensTheWebsite();

    }

    @Given("click on search button")
    public void click_on_search_button() {
        flightHomePage.clickOnSearchBtn();

    }

    @And("click on departure date")
    public void clickOnDepartureDate() {
        flightHomePage.clickOnDepartureDate();
    }

    @And("select date {string}")
    public void selectDate(String dateKey) {
        flightHomePage.selectDate(ConfigReader.getConfigValue(dateKey));
    }

    @Then("verify user is on home page")
    public void verifyUserIsOnHomePage() {
        Assert.assertTrue(flightHomePage.verifyOnHomePage());
    }

    @When("user click on from city")
    public void userClickOnFromCity() {
        flightHomePage.clickOnFromCity();
    }

    @And("user click on to city")
    public void userClickOnToCity() {
        flightHomePage.clickOnToCity();
    }

    @And("user enter from city {string}")
    public void userEnterFromCity(String fromCityKey) {
        flightHomePage.enterFromCity(ConfigReader.getConfigValue(fromCityKey));
    }

    @And("user enter to city {string}")
    public void userEnterToCity(String toCityKey) {
        flightHomePage.enterToCity(ConfigReader.getConfigValue(toCityKey));
    }
}
