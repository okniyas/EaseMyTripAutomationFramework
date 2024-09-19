package com.automation.pages.interfaces;

public interface HotelListingPage {

    boolean isHotelListingPageDisplayed();

    void clickOnFilter();

    void selectFilterPriceLowToHigh();

    void isPriceListingFromLowToHigh();

    void selectFilterPriceHighToLow();

    void isPriceListingFromHighToLow();

    void selectHotel();
}
