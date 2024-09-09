package com.automation.steps;

import com.automation.pages.interfaces.HolidayListingPage;
import com.automation.pages.mobile.HolidayListingPageMobile;
import com.automation.pages.web.HolidayListingPageWeb;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class HolidayListingSteps {
    HolidayListingPage holidayListingPage;
    public HolidayListingSteps(){
        String env = ConfigReader.getConfigValue("application.type");

        if(env.equals("mobile")) {
            holidayListingPage = new HolidayListingPageMobile();
        }else{
            holidayListingPage = new HolidayListingPageWeb();
        }
    }
//    HolidayListingPageWeb holidayListingPage = new HolidayListingPageWeb();

    @Then("verify the holidays listing page shows results for the destination {string}")
    public void verify_the_holidays_listing_page_shows_results_for_the_destination(String destinationKey) {
        Assert.assertTrue(holidayListingPage.verifyListingPageHasResultsForTheGivenDestination(ConfigReader.getConfigValue(destinationKey)));

    }

    @When("user select sorting option from {string}")
    public void userSelectSortingOptionFrom(String sortingOption) {
        holidayListingPage.selectSortingOption(sortingOption);
    }

//    @Then("verify the holidays listing page shows results in ascending order")
//    public void verifyTheHolidaysListingPageShowsResultsInAscendingOrder() {
//        Assert.assertTrue(holidayListingPage.verifyListingPageHasResultsInAscendingOrder());
//    }

    @Then("verify the holidays listing page shows results in {string} order")
    public void verifyTheHolidaysListingPageShowsResultsInOrder(String sortingType) {
        Assert.assertTrue(holidayListingPage.verifyListingPageHasResultsInAscendingOrder(sortingType));
    }

    @When("user click on more filter option in holidays listing page")
    public void userClickOnMoreFilterOptionInHolidaysListingPage() {
        holidayListingPage.clickOnFilterOptionInHolidayListingPage();
    }

    @And("select the theme of holiday type as {string}")
    public void selectTheThemeOfHolidayTypeAs(String tripThemeKey) {
        holidayListingPage.selectThemeOfHolidayType(ConfigReader.getConfigValue(tripThemeKey));
    }

//    @Then("verify the holidays listing page shows results for the selected trip theme")
//    public void verifyTheHolidaysListingPageShowsResultsForTheSelectedTripTheme() {
//        Assert.assertTrue(holidayListingPage.verifyHolidaysListingPageShowsResultForTripTheme());
//    }

    @Then("verify the holidays listing page shows results for the selected trip theme {string}")
    public void verifyTheHolidaysListingPageShowsResultsForTheSelectedTripTheme(String themeKey) {
        Assert.assertTrue(holidayListingPage.verifyHolidaysListingPageShowsResultForTripTheme(ConfigReader.getConfigValue(themeKey)));
    }
}
