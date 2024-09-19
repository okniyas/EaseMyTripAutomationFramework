package com.automation.pages.interfaces;

public interface HolidayQueryPage {

    boolean isQueryFormDisplayed();

    void enterTripDetails(String destination, String date, String city, String name, String phone, String email, String count);

    void clickOnSubmitForm();

    boolean isQuerySuccessMsgDisplayed();

    void selectDate(String date);

    void updateNoOfAdults(String count);
}
