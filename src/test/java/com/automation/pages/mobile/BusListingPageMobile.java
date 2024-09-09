package com.automation.pages.mobile;

import com.automation.pages.interfaces.BusListingPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BusListingPageMobile extends BasePageMobile implements BusListingPage {

    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.easemytrip.android:id/top_id']//android.widget.LinearLayout[@resource-id='com.easemytrip.android:id/top_layout']")
    WebElement busDetail;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.easemytrip.android:id/tvEmpty']")
    WebElement searchResultNotAvailableDivTag;

    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.easemytrip.android:id/top_id']")
    List<WebElement> listOfBuses;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.easemytrip.android:id/tvBusCount']")
    WebElement totalResults;


    public boolean verifyUserIsOnListingPageOfBus() {
        waitForElementToBePresentNotVisible("//android.widget.FrameLayout[@resource-id='com.easemytrip.android:id/top_id']");
        return (!listOfBuses.isEmpty() && isPresent(totalResults)) || isPresent(searchResultNotAvailableDivTag);
    }

    public void clickOnSelectSeatBtnOfTheFirstBus() {
        busDetail.click();
    }
}
