package com.automation.pages.web;

import com.automation.pages.interfaces.HotelHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HotelHomePageWeb extends BasePageWeb implements HotelHomePage {

    @FindBy(xpath = "//li[@class='hotels mainMenu']")
    WebElement hotelMenuBtn;

    @FindBy(id = "btnSearch")
    WebElement hotelSearchBtn;

    @FindBy(xpath = "//span[@class='hp_city']")
    WebElement destinationBtn;

    @FindBy(id = "txtCity")
    WebElement destinationInput;

    @FindBy(className = "close_o_pp")
    WebElement adPopUp;

    @FindBy(xpath = "//select[@data-handler='selectMonth']")
    WebElement monthElement;

    @FindBy(xpath = "//select[@data-handler='selectYear']")
    WebElement yearElement;

    @FindBy(id = "exithotelroom")
    WebElement roomsDoneBtn;

    public void clickOnHotelMenu() {
        hotelMenuBtn.click();
    }

    public boolean isHotelHomePageDisplayed() {

        if (isPresent(adPopUp)) {
            adPopUp.click();
        }

        return isDisplay(hotelSearchBtn);
    }

    public void selectDestinationCity(String city) {
        clickByJS(destinationBtn);
        destinationInput.sendKeys(city);

        String loc = "//ul[contains(@class,'auto_sugg_hotel')]//div[contains(text(),'%s')]";
        WebElement selectCity = driver.findElement(By.xpath(String.format(loc, city)));
        clickByJS(selectCity);

    }

    public void selectCheckInDate(String checkIn) {
        selectDate(checkIn);
    }

    public void selectCheckOutDate(String checkOut) {
        selectDate(checkOut);
    }

    public void clickOnHotelSearch() {
        clickByJS(hotelSearchBtn);
    }

    public void selectDate(String date) {
        String day = date.substring(0, date.indexOf(" "));
        String month = date.substring(date.indexOf(" ") + 1, date.lastIndexOf(" "));
        String year = date.substring(date.lastIndexOf(" ") + 1);

        Select yearDropDown = new Select(yearElement);
        yearDropDown.selectByValue(year);
        Select monthDropDown = new Select(monthElement);
        monthDropDown.selectByVisibleText(month);

        String dayPath = "//div[contains(@class,'corner-left')]/..//a[text()='%s']";
        WebElement dayElement = driver.findElement(By.xpath(String.format(dayPath, day)));
        clickByJS(dayElement);
    }

    public void clickOnRoomsDone() {
        roomsDoneBtn.click();
    }
}
