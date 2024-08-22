package com.automation.pages.mobile;

import com.automation.pages.interfaces.BusHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BusHomePageMobile extends BasePageMobile implements BusHomePage {

    @FindBy(xpath = "//ul[@id='homepagemenuUL']/li[contains(@class, 'bus')]")
    WebElement busNavBar;

    @FindBy(id = "txtSrcCity")
    WebElement sourceCityInput;

    @FindBy(id = "txtDesCity")
    WebElement destinationCityInput;

    String sourceCityOption = "//ul[@id='srcNav']/li";

    String destinationCityOption = "//ul[@id='desNav']/li";

    @FindBy(id = "datepicker")
    WebElement dateInput;

    @FindBy(className = "ui-datepicker-month")
    WebElement dateMonth;

    @FindBy(className = "ui-datepicker-year")
    WebElement dateYear;

    @FindBy(xpath = "//div[@id='ui-datepicker-div']//a[contains(@class, 'ui-datepicker-next')]")
    WebElement nextMonth;

    String XPATH_DAY = "//table[@class='ui-datepicker-calendar']//td[@data-handler='selectDay']/a[contains(text(), '%s')]";

    @FindBy(id = "srcbtn")
    WebElement searchBtn;


    public void clickOnBusFromNavBar() {
        busNavBar.click();
    }

    public boolean verifyUserIsOnBusHomePage() {
        System.out.println(driver.getCurrentUrl());
        return driver.getCurrentUrl().contains("bus");
    }

    public void enterTheSourceCity(String sourceCity) {
        sourceCityInput.sendKeys(sourceCity);
//        waitForElementToBePresentNotVisible(sourceCityOption);
        driver.findElement(By.xpath(sourceCityOption));
    }

    public void enterTheDestinationCity(String destinationCity) {
        destinationCityInput.sendKeys(destinationCity);
//        waitForElementToBePresentNotVisible(destinationCityOption);
        driver.findElement(By.xpath(destinationCityOption));
    }

    public void selectDepartureDate(String date) {
        dateInput.click();

        String yearInput = date.substring(date.lastIndexOf(" ") + 1);
        String monthInput = date.substring(date.indexOf(" ") + 1, date.lastIndexOf(" "));
        String dayInput = date.substring(0, date.indexOf(" "));

//        WebElement nextMonth = driver.findElement(By.xpath("//div[@id='ui-datepicker-div']//a[contains(@class, 'ui-datepicker-next')]"));

        while (!dateYear.getText().equals(yearInput)) {
            nextMonth.click();
            dateYear = driver.findElement(By.className("ui-datepicker-year"));
        }
        while (!dateMonth.getText().equals(monthInput)) {
            nextMonth.click();
            dateMonth = driver.findElement(By.className("ui-datepicker-month"));
        }

        String dayXpath = String.format(XPATH_DAY, dayInput);
        driver.findElement(By.xpath(dayXpath)).click();
    }

    public void clickOnSearchBtnOnBusPage() {
        searchBtn.click();
    }
}
