package com.automation.pages.mobile;

import com.automation.pages.interfaces.HotelHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;

public class HotelHomePageMobile extends BasePageMobile implements HotelHomePage {

    @FindBy(xpath = "(//android.widget.TextView[@text='Hotels'])[1]/..")
    WebElement hotelMenuBtn;

    @FindBy(xpath = "//android.widget.Button[contains(@resource-id,'Hotel_Search')]")
    WebElement hotelSearchBtn;

    @FindBy(xpath = "//android.widget.TextView[contains(@resource-id,'searchCity')]")
    WebElement destinationBtn;

    @FindBy(xpath = "//android.widget.AutoCompleteTextView[contains(@resource-id,'edit_text')]")
    WebElement destinationInput;

    @FindBy(xpath = "//android.widget.RelativeLayout[contains(@resource-id,'checkInLayout')]")
    WebElement checkInBtn;

    @FindBy(xpath = "//android.widget.Button[contains(@resource-id,'btnDone')]")
    WebElement doneBtn;

    @FindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[contains(@resource-id,'Calendar')]/android.widget.FrameLayout[1]/android.widget.LinearLayout")
    WebElement calendarContainer;

    //niyas
    @FindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.easemytrip.android:id/layout_onward_DateTV']")
    WebElement dateInput;

    String XPATH_DAY = "//android.widget.TextView[@resource-id='com.easemytrip.android:id/tvMonthName']/following-sibling::androidx.recyclerview.widget.RecyclerView[@resource-id='com.easemytrip.android:id/rvDateGrid']//android.widget.TextView[@text='%s']";

    WebElement monthFullContainer;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.easemytrip.android:id/tvMonthName']")
    WebElement monthElement;

    public void clickOnHotelMenu() {
        hotelMenuBtn.click();

    }

    public boolean isHotelHomePageDisplayed() {
        return isDisplay(checkInBtn);
    }

    public void selectDestinationCity(String city) {
        destinationBtn.click();
        waitForElementToBeVisible(destinationInput);
        destinationInput.sendKeys(city);

        String loc = "(//android.widget.TextView[contains(@text,%s)and  contains(@resource-id,'city')])[1]";
        WebElement selectCity = driver.findElement(By.xpath(String.format(loc, city)));
        selectCity.click();

    }

    public void selectCheckInDate(String checkIn) {
        checkInBtn.click();
        selectDate(checkIn);
    }

    public void selectCheckOutDate(String checkOut) {
        selectDate(checkOut);
    }

    public void clickOnHotelSearch() {
        hotelSearchBtn.click();
    }

//    public void selectDate(String date) {
//        String day = date.substring(0, date.indexOf(" "));
//        String month = date.substring(date.indexOf(" ") + 1);
//
//        WebElement monthElement = driver.findElement(By.xpath("//androidx.recyclerview.widget.RecyclerView[contains(@resource-id,'Calendar')]/android.widget.FrameLayout[2]//android.widget.TextView"));
//
//        int w = calendarContainer.getSize().getWidth();
//        int h = calendarContainer.getSize().getHeight();
//
//        int x = calendarContainer.getLocation().getX();
//        int y = calendarContainer.getLocation().getY();
//
//        while (!monthElement.getText().contains(month)) {
//            scrollOrSwipe(x + w / 2, y + h, x + w / 2, y);
//            monthElement = driver.findElement(By.xpath("//androidx.recyclerview.widget.RecyclerView[contains(@resource-id,'Calendar')]/android.widget.FrameLayout[2]//android.widget.TextView"));
//
//        }
//        String dayPath = "//androidx.recyclerview.widget.RecyclerView[contains(@resource-id,'Calendar')]/android.widget.FrameLayout[2]//android.widget.TextView[contains(@content-desc,'%s')]";
//        WebElement dayElement = driver.findElement(By.xpath(String.format(dayPath, day)));
//        dayElement.click();
//    }
    public void selectDate(String date) {
        String day = date.substring(0, date.indexOf(" "));
        String month = date.substring(date.indexOf(" ") + 1, date.lastIndexOf(" "));
        String year = date.substring(date.lastIndexOf(" ") + 1);

        Map<String, String> monthMap = new HashMap<>();
        monthMap.put("Jan", "January");
        monthMap.put("Feb", "February");
        monthMap.put("Mar", "March");
        monthMap.put("Apr", "April");
        monthMap.put("May", "May");
        monthMap.put("Jun", "June");
        monthMap.put("Jul", "July");
        monthMap.put("Aug", "August");
        monthMap.put("Sep", "September");
        monthMap.put("Oct", "October");
        monthMap.put("Nov", "November");
        monthMap.put("Dec", "December");

        String fullMonthName = monthMap.get(month);
        String monthYear = fullMonthName + " " + year;

        while (!monthElement.getText().equals(monthYear)) {
            monthFullContainer = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.easemytrip.android:id/tvMonthName']/following-sibling::androidx.recyclerview.widget.RecyclerView"));

            int x = monthFullContainer.getLocation().getX();
            int y = monthFullContainer.getLocation().getY();
            int width = monthFullContainer.getSize().getWidth();
            int height = monthFullContainer.getSize().getHeight();

            scrollOrSwipe(x + width / 2, y + height, x + width / 2, y);

            monthElement = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.easemytrip.android:id/tvMonthName']"));
        }
        String xpathDay = String.format(XPATH_DAY, day);
        WebElement dayElement = driver.findElement(By.xpath(xpathDay));
        dayElement.click();
    }

    public void clickOnRoomsDone() {
        doneBtn.click();
    }
}
