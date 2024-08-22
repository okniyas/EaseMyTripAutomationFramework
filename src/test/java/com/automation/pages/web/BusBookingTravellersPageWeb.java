package com.automation.pages.web;

import com.automation.pages.interfaces.BusBookingTravellersPage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BusBookingTravellersPageWeb extends BasePageWeb implements BusBookingTravellersPage {

    @FindBy(xpath = "//input[@value='Continue Booking']")
    WebElement continueBookingBtnInTravellersPage;

    @FindBy(xpath = "//div/label[text()='Title']/following-sibling::select")
    WebElement titleInput;

    @FindBy(id = "firstname0")
    WebElement firstNameInput;

    @FindBy(id = "lastname0")
    WebElement lastNameInput;

    @FindBy(id = "age0")
    WebElement ageInput;

    @FindBy(id = "TrvlMobileNo")
    WebElement mobileInput;

    @FindBy(className = "main-pymnt-bx")
    WebElement paymentMainBox;

    @FindBy(xpath = "//div[@class='main-pymnt-bx']/div[contains(@class, 'timer')]")
    WebElement paymentTimer;

    @FindBy(xpath = "//p[@id='Sec']//span")
    WebElement paymentPageSuccess;

    @FindBy(xpath = "//div[@class='loadtxtfl']")
    WebElement paymentPageLoader;


    public boolean verifyOnBusBookingTravellersPage() {
        return isPresent(continueBookingBtnInTravellersPage) && isDisplay(firstNameInput) && isDisplay(mobileInput);
    }

    public void enterTheTravellerDetails() {

        selectByValue(titleInput, ConfigReader.getConfigValue("bus.booking.title"));

        firstNameInput.sendKeys(ConfigReader.getConfigValue("bus.booking.first.name"));
        lastNameInput.sendKeys(ConfigReader.getConfigValue("bus.booking.last.name"));
        ageInput.sendKeys(ConfigReader.getConfigValue("bus.booking.age"));
    }

    public void enterTheMobileNumber() {
        mobileInput.sendKeys(ConfigReader.getConfigValue("bus.booking.mobile"));
    }

    public void clickOnContinueBtnInTravellersBookingPage() {

        if(continueBookingBtnInTravellersPage.isEnabled()){
            continueBookingBtnInTravellersPage.click();
        }
    }

    public boolean verifyIsOnPaymentBookingPage() {
        wait.until(ExpectedConditions.invisibilityOf(paymentPageLoader));
        return isDisplay(paymentPageSuccess);
//        return isPresent(paymentMainBox) && isPresent(paymentTimer);
    }
}
