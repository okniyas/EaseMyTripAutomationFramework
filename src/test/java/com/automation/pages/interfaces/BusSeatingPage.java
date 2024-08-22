package com.automation.pages.interfaces;

public interface BusSeatingPage {

    void selectTheFirstAvailableSeat();

    boolean verifyTheSeatIsSelected();

    void selectTheBoardingPoint();

    void selectTheDroppingPoint();

    void clickOnContinueBtn();
}
