package com.automation.steps;

import com.automation.pages.HolidayListingPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class HolidayListingSteps {

    HolidayListingPage holidayListingPage = new HolidayListingPage();

    @Then("verify the holidays listing page shows results for the destination {string}")
    public void verify_the_holidays_listing_page_shows_results_for_the_destination(String destination) {
        Assert.assertTrue(holidayListingPage.verifyListingPageHasResultsForTheGivenDestination(destination));

    }

    @When("user select sorting option from {string}")
    public void userSelectSortingOptionFrom(String sortingOption) {
        holidayListingPage.selectSortingOption(sortingOption);
    }

    @Then("verify the holidays listing page shows results in ascending order")
    public void verifyTheHolidaysListingPageShowsResultsInAscendingOrder() {
        Assert.assertTrue(holidayListingPage.verifyListingPageHasResultsInAscendingOrder());
    }

    @When("user click on more filter option in holidays listing page")
    public void userClickOnMoreFilterOptionInHolidaysListingPage() {
        holidayListingPage.clickOnFilterOptionInHolidayListingPage();
    }

    @And("select the theme of holiday type as {string}")
    public void selectTheThemeOfHolidayTypeAs(String tripTheme) {
        holidayListingPage.selectThemeOfHolidayType(tripTheme);
    }

    @Then("verify the holidays listing page shows results for the selected trip theme")
    public void verifyTheHolidaysListingPageShowsResultsForTheSelectedTripTheme() {
        Assert.assertTrue(holidayListingPage.verifyHolidaysListingPageShowsResultForTripTheme());
    }
}
