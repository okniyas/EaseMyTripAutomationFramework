package com.automation.steps;

import com.automation.pages.TrainListingPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class TrainListingSteps {

    TrainListingPage trainListingPage=new TrainListingPage();
    @Then("verify train list is displayed")

    public void verify_train_list_is_displayed() {
        trainListingPage.isTrainListingDisplayed();
    }

    @When("user click on sort by name A to Z")
    public void userClickOnSortByNameAToZ() throws InterruptedException {
        trainListingPage.sortByNameAtoZ();
    }

    @Then("verify sort by name A to Z")
    public void verifySortByNameAToZ() {
        trainListingPage.isSortingByNameAToZDisplayed();
    }
}
