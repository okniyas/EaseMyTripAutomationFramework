package com.automation.pages.interfaces;

public interface BusHomePage {

    void clickOnBusFromNavBar();

    boolean verifyUserIsOnBusHomePage();

    void enterTheSourceCity(String sourceCity);

    void enterTheDestinationCity(String destinationCity);

    void selectDepartureDate(String date);

    void clickOnSearchBtnOnBusPage();
}
