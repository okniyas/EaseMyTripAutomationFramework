package com.automation.pages.mobile;

import com.automation.pages.interfaces.TrainHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TrainHomePageMobile extends BasePageMobile implements TrainHomePage {

    @FindBy(xpath = "//android.widget.TextView[@text='Trains']")
    WebElement trainMenuBtn;

    @FindBy(xpath = "//android.widget.Button[@content-desc='Show Trains']")
    WebElement showTrainsBtn;

    @FindBy(xpath = "//android.widget.LinearLayout[contains(@resource-id,'origin')]")
    WebElement fromCityBtn;

    @FindBy(xpath = "//android.widget.EditText[@text='Enter city or Station name']")
    WebElement cityInput;

    @FindBy(xpath = "//android.widget.LinearLayout[contains(@resource-id,'destination')]")
    WebElement toCityBtn;

    @FindBy(xpath = "//android.widget.TextView[@content-desc='Departure Date']")
    WebElement dateBtn;

    @FindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[contains(@resource-id,'Calendar')]/android.widget.FrameLayout[2]/android.widget.LinearLayout")
    WebElement calendarContainer;

    public void clickOnTrainMenu() {
        trainMenuBtn.click();
    }

    public boolean isTrainHomePageDisplayed() {
        return isDisplay(showTrainsBtn);
    }

    public void enterSourceStation(String fromStation) {
        fromCityBtn.click();
        cityInput.sendKeys(fromStation);
        WebElement fromCity = driver.findElement(By.xpath(String.format("//android.widget.TextView[contains(@text,'%s')]", fromStation)));
        fromCity.click();
    }

    public void enterDestinationStation(String toStation) {
        toCityBtn.click();
        cityInput.sendKeys(toStation);
        WebElement toCity = driver.findElement(By.xpath(String.format("//android.widget.TextView[contains(@text,'%s')]", toStation)));
        toCity.click();
    }

    public void enterDepartDate(String date) {
        dateBtn.click();
        String day = date.substring(0, date.indexOf(" "));
        String month = date.substring(date.indexOf(" ") + 1);

        WebElement monthElement = driver.findElement(By.xpath("//androidx.recyclerview.widget.RecyclerView[contains(@resource-id,'Calendar')]/android.widget.FrameLayout[2]//android.widget.TextView"));

        int w = calendarContainer.getSize().getWidth();
        int h = calendarContainer.getSize().getHeight();

        int x = calendarContainer.getLocation().getX();
        int y = calendarContainer.getLocation().getY();

        while (!monthElement.getText().contains(month)) {
            scrollOrSwipe(x + w / 2, y + h, x + w / 2, y);
            monthElement = driver.findElement(By.xpath("//androidx.recyclerview.widget.RecyclerView[contains(@resource-id,'Calendar')]/android.widget.FrameLayout[2]//android.widget.TextView"));

        }
        String dayPath = "//androidx.recyclerview.widget.RecyclerView[contains(@resource-id,'Calendar')]/android.widget.FrameLayout[2]//android.widget.TextView[contains(@content-desc,'%s')]";
        WebElement dayElement = driver.findElement(By.xpath(String.format(dayPath, day)));
        dayElement.click();
    }

    public void clickOnTrainSearchBtn() {
        if (showTrainsBtn.isDisplayed() && showTrainsBtn.isEnabled()) {
            showTrainsBtn.click();
        }
    }
}
