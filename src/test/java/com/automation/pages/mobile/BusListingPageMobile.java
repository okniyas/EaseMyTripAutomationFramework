package com.automation.pages.mobile;

import com.automation.pages.interfaces.BusListingPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BusListingPageMobile extends BasePageMobile implements BusListingPage {

    @FindBy(xpath = "//div[@class='list_box']//div[@class='fare_sec']")
    List<WebElement> listOfBusWithOptionSelectSeats;

    @FindBy(xpath = "//div[@id='myHeader'][@class='bus_info']")
    WebElement busHeaderTags;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.easemytrip.android:id/tvEmpty']")
    WebElement searchResultNotAvailableDivTag;

    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.easemytrip.android:id/top_id']")
    List<WebElement> listOfBuses;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.easemytrip.android:id/tvBusCount']")
    WebElement totalResults;


    public boolean verifyUserIsOnListingPageOfBus() {
        return (listOfBuses.size() > 0 && isPresent(totalResults)) || isPresent(searchResultNotAvailableDivTag);
    }

    public void clickOnSelectSeatBtnOfTheFirstBus() {
        listOfBusWithOptionSelectSeats.get(0).click();
    }
}
