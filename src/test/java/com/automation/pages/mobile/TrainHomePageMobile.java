package com.automation.pages.mobile;

import com.automation.pages.interfaces.TrainHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TrainHomePageMobile extends BasePageMobile implements TrainHomePage {
    @FindBy(xpath = "//li[@class='trains mainMenu']")
    WebElement trainMenuBtn;

    @FindBy(xpath = "//li[@id='li1']")
    WebElement searchTrainsOption;

    @FindBy(id = "txtfromcity")
    WebElement fromCityInput;

    @FindBy(id = "txtdesticity")
    WebElement toCityInput;

    @FindBy(xpath = "//input[@name='txtDate']")
    WebElement dateBtn;

    @FindBy(xpath = "//div[contains(@class,'corner-left')]//span[@class='ui-datepicker-month']")
    WebElement monthElement;

    @FindBy(xpath = "//a[@title='Next']")
    WebElement nextMonthBtn;

    @FindBy(xpath = "//input[@class='bsrc-btn']")
    WebElement trainSearchBtn;

    public void clickOnTrainMenu() {
        trainMenuBtn.click();
    }

    public boolean isTrainHomePageDisplayed() {
        return isDisplay(searchTrainsOption);
    }

    public void enterSourceStation(String fromStation) {
        fromCityInput.sendKeys(fromStation);
        WebElement fromCity=driver.findElement(By.xpath(String.format("//li//div[contains(text(),'%s')]", fromStation)));
        fromCity.click();
    }

    public void enterDestinationStation(String toStation) {
        toCityInput.sendKeys(toStation);
        WebElement toCity=driver.findElement(By.xpath(String.format("//li//div[contains(text(),'%s')]", toStation)));
        toCity.click();
    }

    public void enterDepartDate(String date) {
        dateBtn.click();
        String day = date.substring(0, date.indexOf(" "));
        String month = date.substring(date.indexOf(" ") + 1, date.lastIndexOf(" "));
        while (!monthElement.getText().contains(month)) {
            nextMonthBtn.click();
        }
        String dayPath = "//div[contains(@class,'corner-left')]/..//a[text()='%s']";
        WebElement dayElement = driver.findElement(By.xpath(String.format(dayPath, day)));
        dayElement.click();
    }

    public void clickOnTrainSearchBtn() {
        if (trainSearchBtn.isDisplayed() && trainSearchBtn.isEnabled()) {
            trainSearchBtn.click();
        }
    }
}
