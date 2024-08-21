package com.automation.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HotelPaymentPage extends BasePage{

    @FindBy(xpath = "//div[@class='price_hed-INR']")
    WebElement roomPriceDetailsHeader;

    @FindBy(xpath = "//span[contains(@ng-bind,'RoomPrice.price')and not(@id)]")
    WebElement roomPriceElement;

    @FindBy(xpath = "//span[contains(@ng-bind,'RoomPrice.discountMarkupValue+CpnValue')and not(@id)]")
    WebElement discountPriceElement;

    @FindBy(xpath = "//span[@id='spnTravellerBaseFare']")
    WebElement priceAfterDiscountElement;

    @FindBy(xpath = "//span[@id='spnTravellerSurchargeTotal']")
    WebElement taxElement;

    @FindBy(xpath = "//span[@id='lblGrandTotal']")
    WebElement totalPriceElement;

    public boolean isHotelPaymentPageDisplayed() {
        return isDisplay(roomPriceDetailsHeader);
    }

    public void isPriceSummaryCorrect() {

        final double DELTA = 1e-10; // Tolerance value
        double roomPrice=Double.parseDouble(roomPriceElement.getText());
        double discount=Double.parseDouble(discountPriceElement.getText());
        double priceAfterDiscount=Double.parseDouble(priceAfterDiscountElement.getText());
        double tax=Double.parseDouble(taxElement.getText());
        double grandTotal=Double.parseDouble(totalPriceElement.getText());

        double expectedPrice=roomPrice-discount;
        double expectedTotal=priceAfterDiscount+tax;

        Assert.assertEquals(expectedPrice,priceAfterDiscount,DELTA);
        Assert.assertEquals(expectedTotal,grandTotal,DELTA);
    }

}
