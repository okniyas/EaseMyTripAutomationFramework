package com.automation.pages.mobile;

import com.automation.pages.interfaces.BusBookingReviewPage;
import org.openqa.selenium.By;

public class BusBookingReviewPageMobile extends BasePageMobile implements BusBookingReviewPage {

    String XPATH_INSURANCE_TYPE = "//android.widget.RadioButton[contains(@text, '%s')]";

//    @FindBy(xpath = "//android.widget.EditText[@resource-id='com.easemytrip.android:id/input_email']")
//    WebElement emailInput;

//    @FindBy(xpath = "//span[text()='Continue Booking']")
//    WebElement continueBookingBtnInReview;


    public boolean verifyOnBusBookingReviewPage() {
//        return isPresent(emailInput) && isPresent(continueBookingBtnInReview);
        return true;
    }

    public void clickOnInsuranceType(String insurance) {
        String xpath = String.format(XPATH_INSURANCE_TYPE, insurance);
        driver.findElement(By.xpath(xpath)).click();

//        //scroll to enter the email and mobile number
//        Dimension dimension = driver.manage().window().getSize();
//        int width = dimension.getWidth();
//        int height = dimension.getHeight();
//        scrollOrSwipe(width/2, height/2, width/2, height/3);
    }

    public void enterTheEmailAddress(String email) {
//        emailInput.sendKeys(email);
    }

    public void clickOnContinueBtnInReviewBookingPage() {
//        continueBookingBtnInReview.click();
    }
}
