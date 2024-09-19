package com.automation.pages.mobile;

import com.automation.pages.interfaces.MetroBookingPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MetroBookingPageMobile extends BasePageMobile implements MetroBookingPage {

    @FindBy(xpath = "//android.widget.TextView[@text='Metro']")
    WebElement metroOption;

    String XPATH_OF_METRO_CITY = "//android.widget.TextView[@text='Kochi Metro']";

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.easemytrip.android:id/tvSourceName']")
    WebElement sourceStation;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.easemytrip.android:id/tvDestinationName']")
    WebElement destStation;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.easemytrip.android:id/stationNameTV']")
    List<WebElement> stationsInput;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.easemytrip.android:id/tvTotalCount']")
    WebElement passengerCountInput;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.easemytrip.android:id/tvPlus']")
    WebElement passengerCountPlusInput;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.easemytrip.android:id/tv_loader_title']")
    WebElement pageLoader;

    @FindBy(xpath = "//android.widget.CheckBox")
    WebElement agreeTermsBx;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.easemytrip.android:id/tvProceed']")
    WebElement proceedToPayBtn;

    @FindBy(xpath = "//android.widget.EditText[@resource-id='com.easemytrip.android:id/etEmailId']")
    WebElement emailInput;

    @FindBy(xpath = "//android.widget.EditText[@resource-id='com.easemytrip.android:id/etMobileNo']")
    WebElement mobileInput;

    @FindBy(xpath = "//android.widget.Button[@content-desc='Search']")
    WebElement continueBtn;


    @Override
    public void clickOnMetroOption() {
        metroOption.click();
    }

    @Override
    public void selectMetroCityAs(String metroCity) {
        String xpathMetroCity = String.format(XPATH_OF_METRO_CITY, metroCity);
        driver.findElement(By.xpath(xpathMetroCity)).click();
    }

    @Override
    public void selectDepartureStation(String departureStation) {
        sourceStation.click();
        int ele;
        WebElement station;
        for (int i = 0; i < stationsInput.size(); i++) {
            ele = i + 1;
            station = driver.findElement(By.xpath("(//android.widget.TextView[@resource-id='com.easemytrip.android:id/stationNameTV'])[" + ele + "]"));

            if (station.getText().equals(departureStation)) {
                station.click();
                break;
            }
        }
    }

    @Override
    public void selectDestinationStation(String destinationStation) {
//        waitForElementToBeInvisible(pageLoader);

        destStation.click();
        int ele;
        WebElement station;
        for (int i = 0; i < stationsInput.size(); i++) {
            ele = i + 1;
            station = driver.findElement(By.xpath("(//android.widget.TextView[@resource-id='com.easemytrip.android:id/stationNameTV'])[" + ele + "]"));

            if (station.getText().equals(destinationStation)) {
                station.click();
                break;
            }
        }
    }

    @Override
    public void enterNoOfPassengers(String noOfPassengers) {
        waitForElementToBeInvisible(pageLoader);

        while (!passengerCountInput.getText().equals(noOfPassengers)) {
            passengerCountPlusInput.click();
            passengerCountInput = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.easemytrip.android:id/tvTotalCount']"));
        }
    }

    @Override
    public void clickOnAgreeTermsAndConditions() {
        agreeTermsBx.click();
    }

    @Override
    public void clickOnProceedToPayBtn() {
        proceedToPayBtn.click();
    }

    @Override
    public boolean contactDetailsPopupIsDisplayed() {
        return isPresent(emailInput) && isPresent(continueBtn);
    }

    @Override
    public void enterContactDetails(String email, String mobileNumber) {
        emailInput.sendKeys(email);
        mobileInput.sendKeys(mobileNumber);
    }

    @Override
    public void clickOnContinueBtnOfContactDetails() {
        continueBtn.click();
    }
}
