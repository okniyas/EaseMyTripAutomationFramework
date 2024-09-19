package com.automation.pages.web;

import com.automation.pages.interfaces.BusBookingReviewPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BusBookingReviewPageWeb extends BasePageWeb implements BusBookingReviewPage {

    String XPATH_INSURANCE_TYPE = "//div[@class='insurencediv']//label[contains(text(), '%s')]";

    @FindBy(id = "trvlEmail")
    WebElement emailInput;

    @FindBy(xpath = "//span[text()='Continue']")
    WebElement continueBookingBtnInReview;


    public boolean verifyOnBusBookingReviewPage() {
        return isPresent(emailInput) && isPresent(continueBookingBtnInReview);
    }

    public void clickOnInsuranceType(String insurance) {
        String xpath = String.format(XPATH_INSURANCE_TYPE, insurance);
        driver.findElement(By.xpath(xpath)).click();
    }

    public void enterTheEmailAddress(String email) {
        emailInput.sendKeys(email);
    }

    public void clickOnContinueBtnInReviewBookingPage() {
        continueBookingBtnInReview.click();
    }
}
