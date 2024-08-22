package com.automation.pages.web;

import com.automation.pages.interfaces.FlightHomePage;
import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlightHomePageWeb extends BasePageWeb implements FlightHomePage {

    @FindBy(className = "srchBtnSe")
    WebElement searchBtn;

    @FindBy(xpath = "//input[@id='ddate']/parent::div")
    WebElement departureDateBtn;

    @FindBy(id = "tocity")
    WebElement toCityBtn;

    @FindBy(id = "frmcity")
    WebElement fromCityBtn;

    @FindBy(id = "a_FromSector_show")
    WebElement fromCityInput;

    @FindBy(id = "a_Editbox13_show")
    WebElement toCityInput;

    String XPATH_FOR_DAY = "//div[@class='main']/div[@class='box']//div[@class='days']//li[contains(@id,'%s')]";

//    String XPATH_FOR_CITY_DROPDOWN = "//span[contains(text(),'%s')]";


    public void opensTheWebsite() {
        driver.get(ConfigReader.getConfigValue("application.url"));
    }

    public void clickOnSearchBtn() {
        searchBtn.click();
    }

    public void clickOnDepartureDate() {
//        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
//        javascriptExecutor.executeScript("arguments[0].click();", departureDateBtn);
        if (departureDateBtn.isEnabled()) {
//            departureDateBtn.click();
            clickByJS(departureDateBtn);
        }

    }

    public void selectDate(String date) {

        String day = date.substring(0, date.indexOf(" "));
        String monthYear = date.substring(date.indexOf(" ") + 1);

        WebElement monthAndYear = driver.findElement(By.xpath("//div[@class='main']/div[@class='box']//div[@class='month2']"));
        WebElement nextMonth = driver.findElement(By.xpath("//div[@class='main1']/div[@class='box1']//div[@class='month3']"));

        while (!monthAndYear.getText().toLowerCase().contains(monthYear.toLowerCase())) {

//            nextMonth.click();
            clickByJS(nextMonth);
            monthAndYear = driver.findElement(By.xpath("//div[@class='main']/div[@class='box']//div[@class='month2']"));
        }
        String xpathDay = String.format(XPATH_FOR_DAY, day);
//        driver.findElement(By.xpath(xpathDay)).click();
        WebElement clickDay = driver.findElement(By.xpath(xpathDay));
        clickByJS(clickDay);
    }

    public boolean verifyOnHomePage() {
        return isDisplay(searchBtn);
    }

    public void clickOnFromCity() {
        clickByJS(fromCityBtn);
//        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
//        javascriptExecutor.executeScript("arguments[0].click();", fromCityBtn);
//        fromCityBtn.click();
    }

    public void clickOnToCity() {
        clickByJS(toCityBtn);
//        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
//        javascriptExecutor.executeScript("arguments[0].click();", toCityBtn);
//        toCityBtn.click();
    }

    public void enterFromCity(String fromCity) {
        fromCityInput.sendKeys(fromCity);

        String fromXpath = String.format("//span[contains(text(),'%s')]", fromCity);
        waitForElementToPresent(fromXpath);
        WebElement dropdown = driver.findElement(By.xpath(fromXpath));
        if (isPresent(dropdown)) {
            clickByJS(dropdown);
        }
    }

    public void enterToCity(String toCity) {

        toCityInput.sendKeys(toCity);
        String toXpath = String.format("//span[contains(text(),'%s')]", toCity);
        waitForElementToPresent(toXpath);
        WebElement dropdown = driver.findElement(By.xpath(toXpath));
        if (isPresent(dropdown)) {
            clickByJS(dropdown);
        }
    }
}
