package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HolidayHomePage extends BasePage{

    @FindBy(xpath = "//ul[@id='homepagemenuUL']/li[contains(@class, 'holidays')]")
    WebElement holidayNavBar;

    @FindBy(id = "txtDesCity")
    WebElement destinationSearchBx;

    @FindBy(xpath = "//ul[@ng-show='citytrue']/li//p")
    WebElement destinationDropdown;

    @FindBy(xpath = "//button[@class='subm_btn']")
    WebElement searchBtn;

    @FindBy(xpath = "//a[@class='modal_btn fancy']/span")
    WebElement planYourTripBtn;

    public void clickOnHolidaysFromNavBar() {
        holidayNavBar.click();
    }

    public boolean verifyOnHolidaysHomePage() {
        return isPresent(destinationSearchBx) && isPresent(searchBtn);
    }

    public void enterTheDestination(String destination) {
        destinationSearchBx.sendKeys(destination);
    }

    public void selectTheDestinationFromDropDownList() {
        waitForElementToBePresentNotVisible("//ul[@ng-show='citytrue']/li//p");
//        waitForElementToBeVisible(destinationDropdown);
        destinationDropdown.click();
    }

    public void clickOnPlanYourTripIcon() {
        planYourTripBtn.click();
    }
}
