package com.automation.pages.mobile;

import com.automation.pages.interfaces.HolidayQueryPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HolidayQueryPageMobile extends BasePageMobile implements HolidayQueryPage {

    @FindBy(xpath = "//android.widget.TextView[@text='Want To Go For A Memorable Holiday?']")
    WebElement formTitle;

    @FindBy(xpath = "//android.view.View[@text='Destination']/following-sibling::android.view.View[1]/android.widget.EditText")
    WebElement destinationInput;

    @FindBy(xpath = "//android.view.View[@text='Date of Departur']/following-sibling::android.view.View[1]/android.widget.EditText")
    WebElement dateBtn;

    @FindBy(xpath = "//android.view.View[@text='City of Departure']/following-sibling::android.widget.EditText")
    WebElement departCityInput;

    @FindBy(xpath = "//android.view.View[@text='Name']/following-sibling::android.view.View[1]/android.widget.EditText")
    WebElement nameInput;

    @FindBy(xpath = "//android.view.View[@text='Phone Number']/following-sibling::android.view.View[1]/android.widget.EditText")
    WebElement mobileNoInput;

    @FindBy(xpath = "//android.view.View[@text='Email ID']/following-sibling::android.view.View[1]/android.widget.EditText")
    WebElement emailInput;

    @FindBy(xpath = "(//android.widget.Button[@text='+'])[1]")
    WebElement adultAddBtn;

    @FindBy(xpath = "//android.view.View[@content-desc='Next']")
    WebElement nextMonthBtn;

    @FindBy(xpath = "//android.widget.Button[@text='Submit Your Query']")
    WebElement submitBtn;

    @FindBy(xpath = "//android.widget.TextView[contains(@text,'Your Query Number is ')]/following-sibling::android.view.View")
    WebElement queryNo;

    @FindBy(xpath = "//android.view.View[@content-desc='Next']/following-sibling::android.widget.TextView")
    WebElement monthElement;

    public boolean isQueryFormDisplayed() {
        return isDisplay(formTitle);
    }

    public void enterTripDetails(String destination, String date, String city, String name, String phone, String email, String count) {
        waitForElementToBeVisible(destinationInput);
        destinationInput.sendKeys(destination);
        String loc = "//android.view.View[@text='Destination']/following-sibling::android.view.View[1]/android.widget.ListView/android.view.View[contains(@text,'%s')]";
        WebElement selectDestination = driver.findElement(By.xpath(String.format(loc, destination)));
        selectDestination.click();
        dateBtn.click();
        selectDate(date);
        departCityInput.sendKeys(city);
        WebElement selectCity = driver.findElement(By.xpath(String.format("//android.view.View[@text='City of Departure']/following-sibling::android.widget.ListView/android.view.View[contains(@text,'%s')]", city.toUpperCase())));
        selectCity.click();
        nameInput.sendKeys(name);
        mobileNoInput.sendKeys(phone);
        emailInput.sendKeys(email);
        updateNoOfAdults(count);

    }

    public void clickOnSubmitForm() {
        submitBtn.click();
    }

    public boolean isQuerySuccessMsgDisplayed() {
        return isDisplay(queryNo);
    }

    public void selectDate(String date) {
        String day = date.substring(0, date.indexOf("-"));
        String month = date.substring(date.indexOf("-") + 1, date.lastIndexOf("-"));
        String year = date.substring(date.lastIndexOf("-") + 1);

        while (!monthElement.getText().contains(year)) {
            nextMonthBtn.click();
            monthElement = driver.findElement(By.xpath("//android.view.View[@content-desc='Next']/following-sibling::android.widget.TextView"));

        }
        while (!(monthElement.getText().contains(month))) {
            nextMonthBtn.click();
            monthElement = driver.findElement(By.xpath("//android.view.View[@content-desc='Next']/following-sibling::android.widget.TextView"));
        }

        String dayPath = "//android.widget.TextView[@text='%s']";
        WebElement dayElement = driver.findElement(By.xpath(String.format(dayPath, day)));
        dayElement.click();
    }

    public void updateNoOfAdults(String count) {
        int adults = Integer.parseInt(count);
        for (int i = 2; i < adults; i++) {
            adultAddBtn.click();
        }
    }
}
