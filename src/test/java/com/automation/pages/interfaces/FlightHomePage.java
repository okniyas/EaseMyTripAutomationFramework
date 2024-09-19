package com.automation.pages.interfaces;

public interface FlightHomePage {

    void opensTheWebsite();

    void clickOnSearchBtn();

    void clickOnDepartureDate();

    void selectDate(String date);


    boolean verifyOnHomePage();

    void clickOnFromCity();

    void clickOnToCity();

    void enterFromCity(String fromCity);

    void enterToCity(String toCity);
}
