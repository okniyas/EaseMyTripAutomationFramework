package com.automation.pages.web;

import com.automation.pages.interfaces.HotelBookingPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Set;


public class HotelBookingPageWeb extends BasePageWeb implements HotelBookingPage {

    @FindBy(xpath = "//a[@id='room']/following-sibling::a")
    WebElement bookNowBtn;

    public boolean isHotelBookingPageDisplayed() {

        Set<String> handles=driver.getWindowHandles();
        String currentHandle= driver.getWindowHandle();

        for (String handle:handles){
            if (!handle.equals(currentHandle)){
                driver.switchTo().window(handle);
            }
        }
        wait.until(ExpectedConditions.visibilityOf(bookNowBtn));
        return isDisplay(bookNowBtn);
    }

    public void clickOnBookNow() {
        bookNowBtn.click();
    }


}
