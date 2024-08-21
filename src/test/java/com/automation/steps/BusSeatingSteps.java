package com.automation.steps;

import com.automation.pages.BusSeatingPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class BusSeatingSteps {

    BusSeatingPage busSeatingPage = new BusSeatingPage();


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
