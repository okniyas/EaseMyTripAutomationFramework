package com.automation.pages;

import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage{

    @FindBy(className = "srchBtnSe")
    WebElement searchBtn;

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
        departureDateBtn.click();
    }

    public void selectDate(String date) {
        driver.findElement(By.id("frth_2_20/08/2024")).click();
    }

    public boolean verifyOnHomePage() {
        return isDisplay(searchBtn);
    }

    public void clickOnFromCity() {
        fromCityBtn.click();
    }

    public void clickOnToCity() {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].click();", toCityBtn);
//        toCityBtn.click();
    }

    public void enterFromCity(String fromCity) {
        fromCityInput.sendKeys(fromCity);
        String fromXpath = String.format("//span[contains(text(),'%s')]", fromCity);
        driver.findElement(By.xpath(fromXpath)).click();


    }

    public void enterToCity(String toCity) {
        toCityInput.sendKeys(toCity);
        String toXpath = String.format("//span[contains(text(),'%s')]", toCity);
        System.out.println(toXpath);
        driver.findElement(By.xpath(toXpath)).click();

    }
}
