package com.automation.pages.mobile;

import com.automation.pages.interfaces.GiftCardDetailsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GiftCardDetailsPageMobile extends BasePageMobile implements GiftCardDetailsPage {

    @FindBy(xpath = "//android.view.View[@text='Enter Denomination']/following-sibling::android.widget.EditText[1]")
    WebElement denominationInput;

    @FindBy(xpath = "//android.view.View[@text='Select Quantity']/following-sibling::android.view.View[1]")
    WebElement quantityInput;

    @FindBy(xpath = "//android.widget.CheckedTextView[@resource-id='android:id/text1']")
    List<WebElement> quantityNumbers;

    @FindBy(xpath = "//android.view.View[@text='Sender details']/following-sibling::android.widget.EditText[1]")
    WebElement senderNameInput;

    //    @FindBy(xpath = "//android.widget.EditText[@resource-id='txtEmailId']")
    @FindBy(xpath = "//android.view.View[@text='Sender details']/following-sibling::android.widget.EditText[2]")
    WebElement senderEmailInput;

    //    @FindBy(xpath = "//android.widget.EditText[@resource-id='txtEmailId']/following-sibling::android.widget.EditText")
    @FindBy(xpath = "//android.view.View[@text='Sender details']/following-sibling::android.widget.EditText[3]")
    WebElement senderMobileInput;

    //    @FindBy(xpath = "//android.widget.EditText[@resource-id='rcnm']")
    @FindBy(xpath = "//android.view.View[@text='Sender details']/following-sibling::android.widget.EditText[4]")
    WebElement receiverNameInput;

    //    @FindBy(xpath = "//android.widget.EditText[@resource-id='rceml']")
    @FindBy(xpath = "//android.view.View[@text='Sender details']/following-sibling::android.widget.EditText[5]")
    WebElement receiverEmailInput;

    //    @FindBy(xpath = "//android.widget.EditText[@resource-id='rcteml']")
    @FindBy(xpath = "//android.view.View[@text='Sender details']/following-sibling::android.widget.EditText[6]")
    WebElement receiverReEmailInput;

    //    @FindBy(xpath = "//android.widget.EditText[@resource-id='rcephn']")
    @FindBy(xpath = "//android.view.View[@text='Sender details']/following-sibling::android.widget.EditText[7]")
    WebElement receiverMobileInput;

    @FindBy(xpath = "//android.view.View[@content-desc='Terms and Conditions']/preceding-sibling::android.widget.CheckBox")
    WebElement acceptTermsAndConditions;

    @FindBy(xpath = "//android.widget.TextView[@text='Pay Now']")
    WebElement payNowBtn;

    //    @FindBy(xpath = "//android.view.View[@resource-id='otr']")
    @FindBy(xpath = "//android.widget.EditText[@hint='Enter OTP code']")
    WebElement enterOtpCodeField;

    @FindBy(xpath = "//android.widget.TextView[@text='Verify Now']")
    WebElement verifyNowBtn;


    public void enterGiftCardDetails(String denomination, String quantity) {

        denominationInput.sendKeys(denomination);
        quantityInput.click();
//        String quantityNumberXpath = String.format();
//        waitForElementToBeVisible(quantityNumbers.get(0));
        WebElement quantityNumber;
        int ele;
        for (int i = 0; i < quantityNumbers.size(); i++) {
            ele = i + 1;
            quantityNumber = driver.findElement(By.xpath("(//android.widget.CheckedTextView[@resource-id='android:id/text1'])[" + ele + "]"));
//            waitForElementToBeVisible(quantityNumber);
            if (quantityNumber.getText().equals(quantity)) {
                quantityNumber.click();
            }
        }

        Dimension dimension = driver.manage().window().getSize();
        int width = dimension.getWidth();
        int height = dimension.getHeight();

        while (!isPresent(payNowBtn)) {
            System.out.println();
            scrollOrSwipe(width / 2, 3 * height / 4, width / 2, (height / 4) - 50);
//            scrollOrSwipe(width / 2, 3 * height / 4, width / 2, (height / 3) + 50);
        }
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
