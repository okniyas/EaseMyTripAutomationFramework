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

    String XPATH_FOR_CITY_DROPDOWN = "//span[contains(text(),'%s')]";

    //div[@class='main']/div[@class='box']//div[@class='month2']  //Aug 2024

    //div[@class='main']/div[@class='box']//div[@class='days']//li[@id='frth_4_22/08/2024']  date

    //div[@class='main']/div[@class='box']//div[@class='days']//li[contains(@id,'22')] date only


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
          //Aug 2024
//        String day =
//        WebElement monthYear = driver.findElement(By.xpath("//div[@class='main']/div[@class='box']//div[@class='month2']"));


        driver.findElement(By.id("frth_2_20/08/2024")).click();
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

    public void enterFromCity(String fromCity) throws InterruptedException {
        fromCityInput.sendKeys(fromCity);

        String fromXpath = String.format("//span[contains(text(),'%s')]", fromCity);
        WebElement dropdown = driver.findElement(By.xpath(fromXpath));
        if(isPresent(dropdown)){
            dropdown.click();
        }
    }

    public void enterToCity(String toCity) throws InterruptedException {

        toCityInput.sendKeys(toCity);

        String toXpath = String.format("//span[contains(text(),'%s')]", toCity);
        WebElement dropdown = driver.findElement(By.xpath(toXpath));
        if(isPresent(dropdown)){
            dropdown.click();
        }
    }
}
