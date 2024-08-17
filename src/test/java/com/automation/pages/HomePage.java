package com.automation.pages;

import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage{

    @FindBy(className = "srchBtnSe")
    WebElement searchBtn;

    @FindBy(xpath = "//div[@class='top_bar_flgt_1']/div[not (@id) and @price]")
    List<WebElement> flightList;

    @FindBy(id = "ddate")
    WebElement clickDepartureDate;


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
        clickDepartureDate.click();
    }

    public void selectDate(String date) {
        driver.findElement(By.id("frth_2_20/08/2024")).click();
    }
}
