package com.automation.pages.web;

import com.automation.pages.interfaces.FlightListingPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FlightListingPageWeb extends BasePageWeb implements FlightListingPage {

    //    @FindBy(xpath = "//div[@class='lis']")
    @FindBy(xpath = "//div[@class='top_bar_flgt_1']/div[not (@id) and @price]")
    List<WebElement> flightList;

//    String XPATH_FLIGHT_FILTER_CONTAINER = "//span[contains(@ng-bind,'GetAirLineName')][text()='%s']";

    @FindBy(xpath = "//div[@class='prc_flt']//input[@type='checkbox' and @name='ppAirline']")
    List<WebElement> airlineFilters;


    String XPATH_FLIGHT_FILTER_LISTING_PAGE = "//span[contains(@ng-bind,'GetAirLineName')][text()='%s']";


    public boolean verifyOnFlightListPage() {
        return flightList.size() > 0;
    }

    public void userUnTickFlightsExceptOneToBeFiltered(String flightName) {

        for (int i = 0; i < airlineFilters.size(); i++) {
            int eleLocator = i + 1;
            WebElement each = driver.findElement(By.xpath("(//div[@class='prc_flt']//input[@type='checkbox' and @name='ppAirline'])[" + eleLocator + "]"));
            if (!each.getAccessibleName().equalsIgnoreCase(flightName)) {
                if (each.isSelected()) {
                    each.click();
                }
            }
        }

    }

    public boolean verifyOnlyTheFilteredFlightIsPresent(String flightName) {
        String xpath = String.format(XPATH_FLIGHT_FILTER_LISTING_PAGE, flightName);
        List<WebElement> filteredFlights = driver.findElements(By.xpath(xpath));
        return filteredFlights.size() > 0;
    }
}
