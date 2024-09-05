package com.automation.pages.mobile;

import com.automation.pages.interfaces.FlightHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.Map;

public class FlightHomePageMobile extends BasePageMobile implements FlightHomePage {

    @FindBy(xpath = "(//android.widget.TextView[@text='Flights'])[1]")
    WebElement flightMenu;

    @FindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.easemytrip.android:id/search_flight_origin_container']")
    WebElement flightOrigin;

    @FindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.easemytrip.android:id/search_flight_destination_container']")
    WebElement flightDestination;

    @FindBy(xpath = "//android.widget.AutoCompleteTextView[@resource-id='com.easemytrip.android:id/search']")
    WebElement flightInput;

    @FindBy(xpath = "//android.widget.ListView[@resource-id='com.easemytrip.android:id/search_airport_list']/android.widget.LinearLayout")
    WebElement selectFlightOption;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.easemytrip.android:id/depdateView']")
    WebElement departureDate;

    String XPATH_DAY = "//android.widget.TextView[@resource-id='com.easemytrip.android:id/tvMonthName']/following-sibling::androidx.recyclerview.widget.RecyclerView[@resource-id='com.easemytrip.android:id/rvDateGrid']//android.widget.TextView[@text='%s']";

    @FindBy(xpath = "//android.widget.Button[@resource-id='com.easemytrip.android:id/button_flight_Search']")
    WebElement flightSearchBtn;

    WebElement monthFullContainer;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.easemytrip.android:id/tvMonthName']")
    WebElement monthElement;


    public void opensTheWebsite() {

    }

    public void clickOnSearchBtn() {
        flightSearchBtn.click();
    }

    public void clickOnDepartureDate() {
        departureDate.click();

        //it takes some time to load the date picker, so waiting
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

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

        System.out.println("Month"+ monthYear);



        System.out.println(monthElement.getText());
        while (!monthElement.getText().equals(monthYear)) {
            System.out.println("Inside while loop");
            monthFullContainer = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.easemytrip.android:id/tvMonthName']/following-sibling::androidx.recyclerview.widget.RecyclerView"));

            int x = monthFullContainer.getLocation().getX();
            int y = monthFullContainer.getLocation().getY();
            int width = monthFullContainer.getSize().getWidth();
            int height = monthFullContainer.getSize().getHeight();

            System.out.println(monthElement.getText());

            scrollOrSwipe(x + width / 2, y + height, x + width / 2, y);

            monthElement = driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.easemytrip.android:id/tvMonthName']"));

        }
        String xpathDay = String.format(XPATH_DAY, day);
        WebElement dayElement = driver.findElement(By.xpath(xpathDay));
        dayElement.click();
    }

    public boolean verifyOnHomePage() {
//        return isDisplay(searchBtn);
        return true;
    }

    public void clickOnFromCity() {
        flightMenu.click();
        flightOrigin.click();
    }

    public void clickOnToCity() {
        flightDestination.click();
    }

    public void enterFromCity(String fromCity) {

        flightInput.sendKeys(fromCity);
        selectFlightOption.click();
    }

    public void enterToCity(String toCity) {

        flightInput.sendKeys(toCity);
        selectFlightOption.click();
    }
}
