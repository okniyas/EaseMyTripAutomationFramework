package com.automation.steps;


import com.automation.pages.interfaces.TrainHomePage;
import com.automation.pages.mobile.TrainHomePageMobile;
import com.automation.pages.web.TrainHomePageWeb;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class TrainHomeSteps {

    TrainHomePage trainHomePage;

    public TrainHomeSteps(){
        String env = ConfigReader.getConfigValue("application.type");

        if(env.equals("mobile")) {
            trainHomePage = new TrainHomePageMobile();
        }else{
            trainHomePage = new TrainHomePageWeb();
        }
    }
//    TrainHomePageWeb trainHomePage = new TrainHomePageWeb();

    @When("user click on train menu")
    public void user_click_on_train_menu() {
        trainHomePage.clickOnTrainMenu();
    }

    @Then("verify train home page is displayed")
    public void verify_train_home_page_is_displayed() {
        Assert.assertTrue(trainHomePage.isTrainHomePageDisplayed());
    }

    @When("user select source station as {string}")
    public void user_select_source_station_as(String fromStation) {
        trainHomePage.enterSourceStation(fromStation);
    }

    @When("user select destination station as {string}")
    public void user_select_destination_station_as(String toStation) {
        trainHomePage.enterDestinationStation(toStation);
    }

    @When("user select depart date as {string}")
    public void user_select_depart_date_as(String date) {
        trainHomePage.enterDepartDate(date);
    }

    @When("click on train search button")
    public void click_on_train_search_button() {
        trainHomePage.clickOnTrainSearchBtn();
    }


}
