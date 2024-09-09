package com.automation.pages.mobile;

import com.automation.pages.interfaces.HolidayHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HolidayHomePageMobile extends BasePageMobile implements HolidayHomePage {

    @FindBy(xpath = "//android.widget.TextView[@text='Holidays']")
    WebElement holidayNavBar;

//    @FindBy(xpath = "//android.widget.EditText[@resource-id='txtDesCity']")
    @FindBy(xpath = "//android.widget.Image[@text='search']/following-sibling::android.widget.EditText")
    WebElement destinationSearchBx;

    String XPATH_DESTINATION_DROPDOWN = "//android.widget.ListView//android.view.View[@content-desc='%s']";

    @FindBy(xpath = "//button[@class='subm_btn']")
    WebElement searchBtn;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='android:id/alertTitle']")
    WebElement SSLAlert;

//    @FindBy(xpath = "//android.widget.Button[@text='CONTINUE']")
//    WebElement SSLAlertContinueBtn;

    @FindBy(xpath = "//a[@class='modal_btn fancy']/span")
    WebElement planYourTripBtn;

    public void clickOnHolidaysFromNavBar() {
        holidayNavBar.click();
    }

    public boolean verifyOnHolidaysHomePage() {

//        while(isPresent(SSLAlert)){
//            WebElement SSLAlertContinueBtn = driver.findElement(By.xpath("//android.widget.Button[@text='CONTINUE']"));
//            SSLAlertContinueBtn.click();
//        }
        waitForElementToBePresentNotVisible("//android.widget.Image[@text='search']/following-sibling::android.widget.EditText");
        return isPresent(destinationSearchBx);
    }

    public void enterTheDestination(String destination) {
//        waitForElementToBeInvisible(driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.easemytrip.android:id/pro']")));
        waitForElementToBeVisible(destinationSearchBx);
        destinationSearchBx.sendKeys(destination);
        selectTheDestinationFromDropDownListMobile(destination);

    }

    public void selectTheDestinationFromDropDownList() {

    }

    public void selectTheDestinationFromDropDownListMobile(String destination) {
        String xpathDropdown = String.format(XPATH_DESTINATION_DROPDOWN, destination);
        waitForElementToBeVisible(driver.findElement(By.xpath(xpathDropdown)));
        driver.findElement(By.xpath(xpathDropdown)).click();
    }
    public void clickOnPlanYourTripIcon() {
        planYourTripBtn.click();
    }
}
