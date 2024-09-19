package com.automation.pages.interfaces;

public interface TrainHomePage {

    void clickOnTrainMenu();

    boolean isTrainHomePageDisplayed();

    void enterSourceStation(String fromStation);

    void enterDestinationStation(String toStation);

    void enterDepartDate(String date);

    void clickOnTrainSearchBtn();

    default void clickOnTrainLiveStatus(){

    };

    default void enterTrainDetails(String configValue, String configValue1, String configValue2, String configValue3){

    };

    default void clickOnLiveStation(){};

    default void clickOnLiveStationSearch(){};
}
