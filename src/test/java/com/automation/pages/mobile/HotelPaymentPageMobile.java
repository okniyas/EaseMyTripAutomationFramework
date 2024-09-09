package com.automation.pages.mobile;

import com.automation.pages.interfaces.HotelPaymentPage;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HotelPaymentPageMobile extends BasePageMobile implements HotelPaymentPage {

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.easemytrip.android:id/fareHeading']")
    WebElement fareHeading;
    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.easemytrip.android:id/tv_price']")
    WebElement roomPriceElement;
    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.easemytrip.android:id/tv_taxRate']")
    WebElement promoDiscountElement;
    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.easemytrip.android:id/tv_Discount']")
    WebElement emtDiscountElement;
    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.easemytrip.android:id/tv_emt_tax']")
    WebElement taxElement;
    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.easemytrip.android:id/tv_GrandTotal']")
    WebElement totalPriceElement;

    public boolean isHotelPaymentPageDisplayed() {
        waitForElementToBeVisible(fareHeading);
        return isDisplay(fareHeading);
    }

    public void isPriceSummaryCorrect() {

        final double DELTA = 1e-10;
        double roomPrice=Double.parseDouble(roomPriceElement.getText());
        double hotelDiscount=Double.parseDouble(promoDiscountElement.getText());
        double emtDiscount=Double.parseDouble(emtDiscountElement.getText());
        double tax=Double.parseDouble(taxElement.getText());
        double grandTotal=Double.parseDouble(totalPriceElement.getText());

        double priceAfterDiscount=roomPrice-hotelDiscount-emtDiscount;
        double expectedTotal=priceAfterDiscount+tax;

        Assert.assertEquals(expectedTotal,grandTotal,DELTA);
    }

}
