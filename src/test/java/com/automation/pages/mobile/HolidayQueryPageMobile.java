package com.automation.pages.mobile;

import com.automation.pages.interfaces.HolidayQueryPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HolidayQueryPageMobile extends BasePageMobile implements HolidayQueryPage {

    @FindBy(xpath = "//div[@class='form_box']//h4")
    WebElement formTitle;

    @FindBy(id = "PackageName")
    WebElement destinationInput;

    @FindBy(xpath = "//input[@name='datepicker']")
    WebElement dateBtn;

    @FindBy(id = "PackageDepartureCity")
    WebElement departCityInput;

    @FindBy(id = "ContactName")
    WebElement nameInput;

    @FindBy(id = "MobileNo")
    WebElement mobileNoInput;

    @FindBy(id = "ContactEmail")
    WebElement emailInput;

    @FindBy(id = "addr")
    WebElement adultAddBtn;

    @FindBy(xpath = "//span[@class='ui-datepicker-month']")
    WebElement monthElement;

    @FindBy(xpath = "//a[@title='Next']")
    WebElement nextMonthBtn;

    @FindBy(xpath = "//span[@class='ui-datepicker-year']")
    WebElement yearElement;

    @FindBy(id = "Button2")
    WebElement submitBtn;

    @FindBy(xpath = "//p/strong")
    WebElement queryNo;

    public boolean isQueryFormDisplayed() {
        return isDisplay(formTitle);
    }

    public void enterTripDetails(String destination,String date,String city,String name,String phone,String email,String count) {
        waitForElementToBeVisible(destinationInput);
        destinationInput.sendKeys(destination);
        String loc="//li[contains(text(),'%s')]";
        WebElement selectDestination=driver.findElement(By.xpath(String.format(loc,destination)));
        clickByJS(selectDestination);
        dateBtn.click();
        selectDate(date);
        departCityInput.sendKeys(city);
        WebElement selectCity= driver.findElement(By.xpath(String.format(loc,city.toUpperCase())));
        clickByJS(selectCity);
        nameInput.sendKeys(name);
        mobileNoInput.sendKeys(phone);
        emailInput.sendKeys(email);
        updateNoOfAdults(count);

    }

    public void clickOnSubmitForm() {
        clickByJS(submitBtn);
    }

    public boolean isQuerySuccessMsgDisplayed() {
        return isDisplay(queryNo);
    }
    public void selectDate(String date){
        String day = date.substring(0, date.indexOf("-"));
        String month = date.substring(date.indexOf("-") + 1, date.lastIndexOf("-"));
        String year = date.substring(date.lastIndexOf("-")+1);

        while (!yearElement.getText().contains(year)){
            clickByJS(nextMonthBtn);

        }
        while (!monthElement.getText().contains(month)) {
            clickByJS(nextMonthBtn);
        }

        String dayPath = "//td[@data-handler='selectDay']/a[text()='%s']";
        WebElement dayElement = driver.findElement(By.xpath(String.format(dayPath, day)));
        clickByJS(dayElement);
    }
    public void updateNoOfAdults(String count){
        int adults=Integer.parseInt(count);
        for (int i=2;i<adults;i++){
            clickByJS(adultAddBtn);
        }
    }
}
