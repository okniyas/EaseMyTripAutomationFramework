package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomeFlightPage extends BasePage {

    @FindBy(className = "srchBtnSe")
    WebElement searchBtn;

    //    @FindBy(xpath = "//div[@class='lis']")
    @FindBy(xpath = "//div[@class='top_bar_flgt_1']/div[not (@id) and @price]")
    List<WebElement> flightList;

    @FindBy(xpath = "//input[@id='ddate']")
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

    public boolean verifyOnFlightListPage() {
        return flightList.size() > 0;
    }

    public void clickOnDepartureDate() {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].click();", departureDateBtn);
//        departureDateBtn.click();
    }

    public void selectDate(String date) {

        String day = date.substring(0, date.indexOf(" "));
        String monthYear = date.substring(date.indexOf(" ") + 1);

        WebElement monthAndYear = driver.findElement(By.xpath("//div[@class='main']/div[@class='box']//div[@class='month2']"));
        WebElement nextMonth = driver.findElement(By.xpath("//div[@class='main1']/div[@class='box1']//div[@class='month3']"));

        while (!monthAndYear.getText().toLowerCase().contains(monthYear.toLowerCase())) {

            nextMonth.click();
            monthAndYear = driver.findElement(By.xpath("//div[@class='main']/div[@class='box']//div[@class='month2']"));
        }
        String xpathDay = String.format(XPATH_FOR_DAY, day);
        driver.findElement(By.xpath(xpathDay)).click();
    }

    public boolean verifyOnHomePage() {
        return isDisplay(searchBtn);
    }

    public void clickOnFromCity() {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].click();", fromCityBtn);
//        fromCityBtn.click();
    }

    public void clickOnToCity() {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].click();", toCityBtn);
//        toCityBtn.click();
    }

    public void enterFromCity(String fromCity) {
        fromCityInput.sendKeys(fromCity);

        String fromXpath = String.format("//span[contains(text(),'%s')]", fromCity);
        WebElement dropdown = driver.findElement(By.xpath(fromXpath));
        if (isPresent(dropdown)) {
            dropdown.click();
        }
    }

    public void enterToCity(String toCity) {

        toCityInput.sendKeys(toCity);

        String toXpath = String.format("//span[contains(text(),'%s')]", toCity);
        WebElement dropdown = driver.findElement(By.xpath(toXpath));
        if (isPresent(dropdown)) {
            dropdown.click();
        }
    }
}
