package com.automation.pages.interfaces;

public interface HolidayListingPage {

    boolean verifyListingPageHasResultsForTheGivenDestination(String destination);

    void selectSortingOption(String sortingOption);

    boolean verifyListingPageHasResultsInAscendingOrder(String sortingType);

    void clickOnFilterOptionInHolidayListingPage();

    void selectThemeOfHolidayType(String tripTheme);

    boolean verifyHolidaysListingPageShowsResultForTripTheme(String themeType);
}
