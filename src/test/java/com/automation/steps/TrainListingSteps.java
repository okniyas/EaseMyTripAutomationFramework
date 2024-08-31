package com.automation.steps;

import com.automation.pages.interfaces.TrainListingPage;
import com.automation.pages.mobile.TrainListingPageMobile;
import com.automation.pages.web.TrainListingPageWeb;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TrainListingSteps {

    TrainListingPage trainListingPage;

    public TrainListingSteps(){
        String env = ConfigReader.getConfigValue("application.type");

        if(env.equals("mobile")) {
            trainListingPage = new TrainListingPageMobile();
        }else{
            trainListingPage = new TrainListingPageWeb();
        }
    }

    @Then("verify train list is displayed")
    public void verify_train_list_is_displayed() {
        trainListingPage.isTrainListingDisplayed();
    }

    @When("user click on sort by name A to Z")
    public void userClickOnSortByNameAToZ() {
        trainListingPage.sortByNameAtoZ();
    }

    @Then("verify sort by name A to Z")
    public void verifySortByNameAToZ() {
        trainListingPage.isSortingByNameAToZDisplayed();
    }

    @When("user click on sort by name Z to A")
    public void userClickOnSortByNameZToA() {
        trainListingPage.sortByNameZtoA();
    }

    @Then("verify sort by name Z to A")
    public void verifySortByNameZToA() {
        trainListingPage.isSortingByNameZToADisplayed();
    }
}
