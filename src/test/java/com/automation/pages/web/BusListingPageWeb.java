package com.automation.pages.web;

import com.automation.pages.interfaces.BusListingPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class BusListingPageWeb extends BasePageWeb implements BusListingPage {

    @FindBy(xpath = "//div[@class='list_box']//div[@class='fare_sec']")
    List<WebElement> listOfBusWithOptionSelectSeats;

    @FindBy(xpath = "//div[@id='myHeader'][@class='bus_info']")
    WebElement busHeaderTags;

    @FindBy(xpath = "//a[@class='modi-srec3'][text()='Search Again']")
    WebElement searchResultNotAvailableDivTag;


    public boolean verifyUserIsOnListingPageOfBus() {
        return (listOfBusWithOptionSelectSeats.size() > 0 && isPresent(busHeaderTags)) || isPresent(searchResultNotAvailableDivTag);
    }

    public void clickOnSelectSeatBtnOfTheFirstBus() {
        listOfBusWithOptionSelectSeats.get(0).click();
    }
}
