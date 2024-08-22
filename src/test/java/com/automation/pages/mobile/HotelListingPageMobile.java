package com.automation.pages.mobile;

import com.automation.pages.interfaces.HotelListingPage;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HotelListingPageMobile extends BasePageMobile implements HotelListingPage {

    @FindBy(className = "btnsrch")
    WebElement modifySearchBtn;

    @FindBy(xpath = "//span[@class='CurrncyCD_INR']/following-sibling::span[@ng-bind]")
    List<WebElement> priceElements;

    @FindBy(xpath = "//div[@class='drpdowns']")
    WebElement filterBtn;

    @FindBy(id = "lth")
    WebElement filterLowToHigh;

    @FindBy(id = "htl")
    WebElement filterHighToLow;

    @FindBy(id = "Loader")
    WebElement filterLoader;

    @FindBy(xpath = "//div[@class='htl_ttl']")
    List<WebElement>hotelTitles;

    public boolean isHotelListingPageDisplayed() {
        return isDisplay(modifySearchBtn);
    }

    public void clickOnFilter() {
        clickByJS(filterBtn);
    }

    public void selectFilterPriceLowToHigh() {
        filterLowToHigh.click();
        waitForElementToBeInvisible(filterLoader);
    }

    public void isPriceListingFromLowToHigh() {
        List<Double> priceList = new ArrayList<>();

        for (WebElement element : priceElements) {
            priceList.add(Double.parseDouble(element.getText()));
        }

        List<Double> priceCopy = new ArrayList<>(priceList);
        Collections.sort(priceCopy);
        Assert.assertEquals(priceCopy, priceList);

    }

    public void selectFilterPriceHighToLow() {
        filterHighToLow.click();
        waitForElementToBeInvisible(filterLoader);
    }

    public void isPriceListingFromHighToLow() {
        List<Double> priceList = new ArrayList<>();

        for (WebElement element : priceElements) {
            priceList.add(Double.parseDouble(element.getText()));
        }

        List<Double> priceCopy = new ArrayList<>(priceList);
        priceCopy.sort(Collections.reverseOrder());
        Assert.assertEquals(priceCopy, priceList);
    }

    public void selectHotel() {
        hotelTitles.get(0).click();
    }
}
