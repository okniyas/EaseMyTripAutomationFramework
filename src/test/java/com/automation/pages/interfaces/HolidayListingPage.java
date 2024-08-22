package com.automation.pages.interfaces;

public interface HolidayListingPage {

    boolean verifyListingPageHasResultsForTheGivenDestination(String destination);

    void selectSortingOption(String sortingOption);

    boolean verifyListingPageHasResultsInAscendingOrder();

    void clickOnFilterOptionInHolidayListingPage();

    void selectThemeOfHolidayType(String tripTheme);

    boolean verifyHolidaysListingPageShowsResultForTripTheme();
}
