package com.automation.pages.mobile;

import com.automation.pages.interfaces.FlightListingPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class FlightListingPageMobile extends BasePageMobile implements FlightListingPage {

    //    @FindBy(xpath = "//div[@class='lis']")
    @FindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.easemytrip.android:id/flight_details']")
    List<WebElement> flightList;

//    String XPATH_FLIGHT_FILTER_CONTAINER = "//span[contains(@ng-bind,'GetAirLineName')][text()='%s']";

    @FindBy(xpath = "//div[@class='prc_flt']//input[@type='checkbox' and @name='ppAirline']")
    List<WebElement> airlineFilters;


    String XPATH_FLIGHT_FILTER_LISTING_PAGE = "//span[contains(@ng-bind,'GetAirLineName')][text()='%s']";

    @FindBy(xpath = "//android.widget.ImageView[@resource-id='com.easemytrip.android:id/filterView']")
    WebElement filterMenu;

    String XPATH_FLIGHT_FILTER = "//android.widget.TextView[@resource-id='com.easemytrip.android:id/tv_name_Airline' and @text='%s']";

    @FindBy(xpath = "//android.widget.Button[@resource-id='com.easemytrip.android:id/btn_ApplyFilter']")
    WebElement applyBtnFilter;


    public boolean verifyOnFlightListPage() {
        return flightList.size() > 0;
    }

    public void userUnTickFlightsExceptOneToBeFiltered(String flightName) {

        filterMenu.click();

        // Scroll Logic
        Dimension dimension = driver.manage().window().getSize();
        int width = dimension.getWidth();
        int height = dimension.getHeight();

        scrollOrSwipe(width / 2, height * 3 / 4, width / 2, height / 4);

        String xpathFilter = String.format(XPATH_FLIGHT_FILTER, flightName);
        driver.findElement(By.xpath(xpathFilter)).click();

        applyBtnFilter.click();


//        for (int i = 0; i < airlineFilters.size(); i++) {
//            int eleLocator = i + 1;
//            WebElement each = driver.findElement(By.xpath("(//div[@class='prc_flt']//input[@type='checkbox' and @name='ppAirline'])[" + eleLocator + "]"));
//            if (!each.getAccessibleName().equalsIgnoreCase(flightName)) {
//                if (each.isSelected()) {
//                    each.click();
//                }
//            }
//        }

    }

    public boolean verifyOnlyTheFilteredFlightIsPresent(String flightName) {

        List<String> flights = new ArrayList<>(getListOfFlightNames());

        boolean isFlightListedSame = true;

        for (String flight : flights) {
            if (!flight.contains(flightName)) {
                isFlightListedSame = false;
                break;
            }
        }
        return isFlightListedSame;
    }

    public List<String> getListOfFlightNames() {

        List<String> flightNames = new ArrayList<>();

//        WebElement flightNoElement = driver.findElement(By.xpath("(//android.widget.TextView[@resource-id='com.easemytrip.android:id/tvTrainNumber'])[1]"));
        WebElement flightDetailsContainer = driver.findElement(By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id='com.easemytrip.android:id/onewayrecyclerview']/android.widget.RelativeLayout[1]"));

        WebElement calendarContainer;
        WebElement flightNameElement = driver.findElement(By.xpath("(//android.widget.TextView[@resource-id='com.easemytrip.android:id/tv_flight_name'])[1]"));
        String flightName;

        String prevFlightNo = "";
        String currentFlightNo = flightNameElement.getText();

        while (!prevFlightNo.equals(currentFlightNo)) {

//            calendarContainer = driver.findElement(By.xpath("//androidx.recyclerview.widget.RecyclerView[contains(@resource-id,'calendar_recycle')]"));
//            flightNameAndNumberElement = driver.findElement(By.xpath("(//android.widget.TextView[@resource-id='com.easemytrip.android:id/tv_flight_name'])[1]"));

            flightName = flightNameElement.getText();
            System.out.println(flightName);
            flightNames.add(flightName);

            int startX = flightDetailsContainer.getLocation().getX();
            int startY = flightDetailsContainer.getLocation().getY();
            int width = flightDetailsContainer.getSize().getWidth();
            int height = flightDetailsContainer.getSize().getHeight();


            System.out.println(startX);
            System.out.println(startY);
            System.out.println(width);
            System.out.println(height);


            scrollOrSwipe(startX + (width / 2), startY + height, startX + (width / 2), startY);

            prevFlightNo = currentFlightNo;
            flightNameElement = driver.findElement(By.xpath("(//android.widget.TextView[@resource-id='com.easemytrip.android:id/tv_flight_name'])[1]"));
            currentFlightNo = flightNameElement.getText();
            flightDetailsContainer = driver.findElement(By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id='com.easemytrip.android:id/onewayrecyclerview']/android.widget.RelativeLayout[1]"));


        }

        List<WebElement> flightList = driver.findElements(By.xpath("//android.widget.TextView[@resource-id='com.easemytrip.android:id/tv_flight_name']"));

        for (WebElement flight : flightList) {
            flightNames.add(flight.getText());
        }
        System.out.println(flightNames);

        return flightNames;
    }

}
