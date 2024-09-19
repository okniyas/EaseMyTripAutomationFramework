package com.automation.pages.interfaces;

public interface HotelHomePage {

    void clickOnHotelMenu();

    boolean isHotelHomePageDisplayed();

    void selectDestinationCity(String city);

    void selectCheckInDate(String checkIn);

    void selectCheckOutDate(String checkOut);

    void clickOnHotelSearch();

    void selectDate(String date);

    void clickOnRoomsDone();
}
