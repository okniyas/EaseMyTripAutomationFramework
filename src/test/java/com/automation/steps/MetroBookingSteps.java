package com.automation.steps;

import com.automation.pages.interfaces.MetroBookingPage;
import com.automation.pages.mobile.MetroBookingPageMobile;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class MetroBookingSteps {

    MetroBookingPage metroBookingPage = new MetroBookingPageMobile();

    @When("the user clicks on Metro option")
    public void the_user_clicks_on_metro_option() {
        metroBookingPage.clickOnMetroOption();
        
    }

    @And("select metro option as {string}")
    public void selectMetroOptionAs(String metroCityKey) {
        metroBookingPage.selectMetroCityAs(ConfigReader.getConfigValue(metroCityKey));
    }

    @When("select departure station {string}")
    public void select_departure_city(String departureStationKey) {
        metroBookingPage.selectDepartureStation(ConfigReader.getConfigValue(departureStationKey));
        
    }

    @When("select destination station {string}")
    public void select_destination_city(String destinationStationKey) {
        metroBookingPage.selectDestinationStation(ConfigReader.getConfigValue(destinationStationKey));
        
    }

    @When("enter the number of passenger {string}")
    public void enter_the_number_of_passenger(String noOfPassengersKey) {
        metroBookingPage.enterNoOfPassengers(ConfigReader.getConfigValue(noOfPassengersKey));
        
    }

    @When("click on agree to terms and conditions")
    public void click_on_agree_to_terms_and_conditions() {
        metroBookingPage.clickOnAgreeTermsAndConditions();
        
    }

    @When("click on proceed to pay button")
    public void click_on_proceed_to_pay_button() {
        metroBookingPage.clickOnProceedToPayBtn();
        
    }

    @Then("verify contact details pop up is displayed")
    public void verify_contact_details_pop_up_is_displayed() {
        Assert.assertTrue(metroBookingPage.contactDetailsPopupIsDisplayed());
        
    }

    @When("the user enter the contact details")
    public void the_user_enter_the_contact_details(List<String> contactDetails) {
        metroBookingPage.enterContactDetails(
                ConfigReader.getConfigValue(contactDetails.get(0)),
                ConfigReader.getConfigValue(contactDetails.get(1))
        );
        
    }

    @When("user click on continue button of contact details")
    public void user_click_on_continue_button_of_contact_details() {
        metroBookingPage.clickOnContinueBtnOfContactDetails();
        
    }

}
