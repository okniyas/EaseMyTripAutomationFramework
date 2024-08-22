package com.automation.pages.interfaces;

public interface TrainHomePage {

    void clickOnTrainMenu();

    boolean isTrainHomePageDisplayed();

    void enterSourceStation(String fromStation);

    void enterDestinationStation(String toStation);

    void enterDepartDate(String date);

    void clickOnTrainSearchBtn();
}
