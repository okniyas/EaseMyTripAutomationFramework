package com.automation.pages.mobile;

import com.automation.pages.interfaces.BusBookingTravellersPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class BusBookingTravellersPageMobile extends BasePageMobile implements BusBookingTravellersPage {

    @FindBy(xpath = "//android.widget.Button[@resource-id='com.easemytrip.android:id/button_paymentbooking']")
    WebElement continueBookingBtnInTravellerDetailsPage;

    String XPATH_OF_TITLE = "//android.widget.RadioButton[@text='%s']";

//    @FindBy(xpath = "")
//    WebElement titleInput;

    @FindBy(xpath = "//android.widget.EditText[@resource-id='com.easemytrip.android:id/input_first_name']")
    WebElement firstNameInput;

    @FindBy(xpath = "//android.widget.EditText[@resource-id='com.easemytrip.android:id/input_last_name']")
    WebElement lastNameInput;

    @FindBy(xpath = "//android.widget.EditText[@resource-id='com.easemytrip.android:id/input_age']")
    WebElement ageInput;

    @FindBy(xpath = "//android.widget.EditText[@resource-id='com.easemytrip.android:id/input_mobile']")
    WebElement mobileInput;

    @FindBy(xpath = "//android.widget.EditText[@resource-id='com.easemytrip.android:id/input_email']")
    WebElement emailInput;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.easemytrip.android:id/tv_verify']")
    WebElement upiPaymentVerifyPayBtn;

    @FindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.easemytrip.android:id/layoutTimer']")
    WebElement paymentTimer;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.easemytrip.android:id/tv_loader_title']")
    WebElement paymentWaitLoader;


    public boolean verifyOnBusBookingTravellersPage() {
        return isPresent(continueBookingBtnInTravellerDetailsPage) && isDisplay(firstNameInput);
    }

    public void enterTheTravellerDetails(List<String> travellerDetails) {

        String titleXpath = String.format(XPATH_OF_TITLE, ConfigReader.getConfigValue(travellerDetails.get(0)));
        waitForElementToBePresentNotVisible(titleXpath);
        driver.findElement(By.xpath(titleXpath)).click();

        firstNameInput.sendKeys(ConfigReader.getConfigValue(travellerDetails.get(1)));
        lastNameInput.sendKeys(ConfigReader.getConfigValue(travellerDetails.get(2)));
        ageInput.sendKeys(ConfigReader.getConfigValue(travellerDetails.get(3)));

        //scroll to enter the email and mobile number
        Dimension dimension = driver.manage().window().getSize();
        int width = dimension.getWidth();
        int height = dimension.getHeight();
        scrollOrSwipe(width/2, height/2, width/2, height/3);


        emailInput.sendKeys(ConfigReader.getConfigValue(travellerDetails.get(4)));
        mobileInput.sendKeys(ConfigReader.getConfigValue(travellerDetails.get(5)));


    }

    public void enterTheMobileNumber() {
//        mobileInput.sendKeys(ConfigReader.getConfigValue("bus.booking.mobile"));
    }

    public void clickOnContinueBtnInTravellersBookingPage() {

            continueBookingBtnInTravellerDetailsPage.click();
    }

    public boolean verifyIsOnPaymentBookingPage() {
        wait.until(ExpectedConditions.invisibilityOf(paymentWaitLoader));
        return isDisplay(paymentTimer) && isDisplay(upiPaymentVerifyPayBtn);
    }
}
