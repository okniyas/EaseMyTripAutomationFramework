package com.automation.steps;

import com.automation.pages.interfaces.BusSeatingPage;
import com.automation.pages.mobile.BusListingPageMobile;
import com.automation.pages.mobile.BusSeatingPageMobile;
import com.automation.pages.web.BusListingPageWeb;
import com.automation.pages.web.BusSeatingPageWeb;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class BusSeatingSteps {
    BusSeatingPage busSeatingPage;
    public BusSeatingSteps(){
        String env = ConfigReader.getConfigValue("application.type");

        if(env.equals("mobile")) {
            busSeatingPage = new BusSeatingPageMobile();
        }else{
            busSeatingPage = new BusSeatingPageWeb();
        }
    }
//    BusSeatingPageWeb busSeatingPage = new BusSeatingPageWeb();


    @And("select the first available seat")
    public void selectTheFirstAvailableSeat() {
        busSeatingPage.selectTheFirstAvailableSeat();
    }

    @Then("verify the seat is selected")
    public void verifyTheSeatIsSelected() {
        Assert.assertTrue(busSeatingPage.verifyTheSeatIsSelected());
    }

    @And("user select the first boarding point")
    public void userSelectTheFirstBoardingPoint() {
        busSeatingPage.selectTheBoardingPoint();
    }

    @And("user select the first dropping point")
    public void userSelectTheFirstDroppingPoint() {
        busSeatingPage.selectTheDroppingPoint();
    }

    @And("user click on continue button")
    public void userClickOnContinueButton() {
        busSeatingPage.clickOnContinueBtn();
    }

}
