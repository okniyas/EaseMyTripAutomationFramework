package com.automation.pages.mobile;

import com.automation.pages.interfaces.HotelBookingPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HotelBookingPageMobile extends BasePageMobile implements HotelBookingPage {

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.easemytrip.android:id/button_BookNow']")
    WebElement selectYourRoomBtn;
    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.easemytrip.android:id/button_BookNow']")
    WebElement continueBtn;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.easemytrip.android:id/grand_total_traveller']")
    WebElement roomPriceBtn;

    public boolean isHotelBookingPageDisplayed() {
        waitForElementToBeVisible(selectYourRoomBtn);
        return isDisplay(selectYourRoomBtn);
    }

    public void clickOnBookNow() {
        selectYourRoomBtn.click();
        continueBtn.click();
        waitForElementToBeVisible(roomPriceBtn);
        roomPriceBtn.click();
    }


}
