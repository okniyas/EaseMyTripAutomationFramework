package com.automation.pages.web;

import com.automation.pages.interfaces.GiftCardDetailsPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GiftCardDetailsPageWeb extends BasePageWeb implements GiftCardDetailsPage {

    @FindBy(xpath = "//label[text()='Enter Denomination']/following-sibling::input")
    WebElement denominationInput;

    @FindBy(xpath = "//label[text()='Select Quantity ']/following-sibling::select")
    WebElement quantityInput;

    @FindBy(xpath = "//input[@placeholder=\"Sender's name*\"]")
    WebElement senderNameInput;

    @FindBy(id = "txtEmailId")
    WebElement senderEmailInput;

    @FindBy(xpath = "//input[@placeholder=\"Sender's 10 digits mobile number*\"]")
    WebElement senderMobileInput;

    @FindBy(id = "rcnm")
    WebElement receiverNameInput;

    @FindBy(id = "rceml")
    WebElement receiverEmailInput;

    @FindBy(id = "rcteml")
    WebElement receiverReEmailInput;

    @FindBy(id = "rcephn")
    WebElement receiverMobileInput;

    @FindBy(xpath = "//a[@id='myBtn']//preceding-sibling::input")
    WebElement acceptTermsAndConditions;

    @FindBy(xpath = "//div[@id='pny']")
    WebElement payNowBtn;

    @FindBy(xpath = "//input[@placeholder='Enter OTP code']")
    WebElement enterOtpCodeField;

    @FindBy(xpath = "//div[text()='Verify Now']")
    WebElement verifyNowBtn;


    public void enterGiftCardDetails(String denomination, String quantity) {
        denominationInput.sendKeys(denomination);
        quantityInput.sendKeys(quantity);
    }


    public void enterSenderAndReceiverDetails(String senderName, String senderEmail, String senderMobile, String receiverName, String receiverEmail, String receiverReEnterEmail, String receiverMobile) {
        senderNameInput.sendKeys(senderName);
        senderEmailInput.sendKeys(senderEmail);
        senderMobileInput.sendKeys(senderMobile);

        receiverNameInput.sendKeys(receiverName);
        receiverEmailInput.sendKeys(receiverEmail);
        receiverReEmailInput.sendKeys(receiverReEnterEmail);
        receiverMobileInput.sendKeys(receiverMobile);
    }


    public void clickOnAcceptTermsAndConditions() {
        acceptTermsAndConditions.click();
    }


    public void clickOnPayNowBtn() {
        payNowBtn.click();
    }


    public boolean isVerifyOTPCodeFieldIsDisplayed() {
        waitForElementToBeVisible(enterOtpCodeField);
        return isPresent(enterOtpCodeField) && isPresent(verifyNowBtn);
    }
}
