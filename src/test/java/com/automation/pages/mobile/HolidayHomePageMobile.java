package com.automation.pages.mobile;

import com.automation.pages.interfaces.HolidayHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HolidayHomePageMobile extends BasePageMobile implements HolidayHomePage {

    @FindBy(xpath = "//android.widget.TextView[@text='Holidays']")
    WebElement holidayNavBar;

    @FindBy(xpath = "//android.widget.EditText")
    WebElement destinationSearchBx;

    String XPATH_DESTINATION_DROPDOWN = "//android.widget.ListView//android.view.View[@content-desc='%s']";

    @FindBy(xpath = "//button[@class='subm_btn']")
    WebElement searchBtn;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='android:id/alertTitle']")
    WebElement SSLAlert;

    @FindBy(xpath = "//android.widget.Button[@text='CONTINUE']")
    WebElement SSLAlertContinueBtn;

    public void clickOnHolidaysFromNavBar() {
        holidayNavBar.click();
    }

    public boolean verifyOnHolidaysHomePage() {
        while(isPresent(SSLAlert)){
            SSLAlertContinueBtn.click();
        }
        return isPresent(destinationSearchBx);
    }

    public void enterTheDestination(String destination) {
        destinationSearchBx.sendKeys(destination);
        selectTheDestinationFromDropDownListMobile(destination);

    }

    public void selectTheDestinationFromDropDownList() {

    }

    public void selectTheDestinationFromDropDownListMobile(String destination) {
        String xpath = String.format(XPATH_DESTINATION_DROPDOWN, destination);
        driver.findElement(By.xpath(xpath)).click();
    }
}
