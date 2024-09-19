package com.automation.pages.web;

import com.automation.pages.interfaces.TrainHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class TrainHomePageWeb extends BasePageWeb implements TrainHomePage {
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

    @FindBy(id = "lbl3")
    WebElement trainLiveStatusBtn;

    @FindBy(id = "li4")
    WebElement liveStationBtn;

    @FindBy(id = "txtLiveStn")
    WebElement sourceInput;

    @FindBy(id = "txtLiveDest")
    WebElement destinationInput;

    @FindBy(id = "ddlHoursSelect")
    WebElement hoursSelect;

    @FindBy(id = "selTrnTypViaStn")
    WebElement trainTypeSelect;

    @FindBy(xpath = "//div[@ng-click='checkLiveStation()']")
    WebElement liveStationSearchBtn;

    public void clickOnTrainMenu() {
        trainMenuBtn.click();
    }

    public boolean isTrainHomePageDisplayed() {
        return isDisplay(searchTrainsOption);
    }

    public void enterSourceStation(String fromStation) {
        fromCityInput.sendKeys(fromStation);
        WebElement fromCity = driver.findElement(By.xpath(String.format("//li//div[contains(text(),'%s')]", fromStation)));
        fromCity.click();
    }

    public void enterDestinationStation(String toStation) {
        toCityInput.sendKeys(toStation);
        WebElement toCity = driver.findElement(By.xpath(String.format("//li//div[contains(text(),'%s')]", toStation)));
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

    public void enterTrainDetails(String source, String destination, String time, String type) {
        sourceInput.sendKeys(source);
        WebElement sourceKey = driver.findElement(By.xpath(String.format("(//strong[text()='%s'])[1]", source.toUpperCase())));
        sourceKey.click();
        destinationInput.sendKeys(destination);
        WebElement destinationKey = driver.findElement(By.xpath(String.format("(//strong[text()='%s'])[1]", destination.toUpperCase())));
        destinationKey.click();
        Select timeHrs = new Select(hoursSelect);
        timeHrs.selectByValue(time);
        Select trainType = new Select(trainTypeSelect);
        trainType.selectByValue(type);

    }

    ;

    public void clickOnLiveStation() {
        liveStationBtn.click();
    }

    public void clickOnLiveStationSearch() {
        if (liveStationSearchBtn.isEnabled()) {
            liveStationSearchBtn.click();
        }
    }
}
