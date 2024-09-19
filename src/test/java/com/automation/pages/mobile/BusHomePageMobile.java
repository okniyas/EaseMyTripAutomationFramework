package com.automation.pages.mobile;

import com.automation.pages.interfaces.BusHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BusHomePageMobile extends BasePageMobile implements BusHomePage {

    @FindBy(xpath = "//android.widget.TextView[@text='Bus']")
    WebElement busNavBar;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.easemytrip.android:id/tv_sourcecity_fullname']")
    WebElement sourceCityBx;

    @FindBy(xpath = "//android.widget.EditText[@resource-id='com.easemytrip.android:id/search']")
    WebElement sourceCityInput;

    @FindBy(xpath = "//android.widget.EditText[@resource-id='com.easemytrip.android:id/search']")
    WebElement destinationCityInput;

//    @FindBy(xpath = "//android.widget.ListView[@resource-id='com.easemytrip.android:id/search_airport_list']/android.widget.LinearLayout")
//    WebElement sourceCityOption;

//    @FindBy(xpath = "//android.widget.ListView[@resource-id='com.easemytrip.android:id/search_airport_list']/android.widget.LinearLayout")
//    WebElement cityOption;

    @FindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.easemytrip.android:id/layout_onward_DateTV']")
    WebElement dateInput;

    String XPATH_DAY = "//android.widget.TextView[@resource-id='com.easemytrip.android:id/tvMonthName']/following-sibling::androidx.recyclerview.widget.RecyclerView[@resource-id='com.easemytrip.android:id/rvDateGrid']//android.widget.TextView[@text='%s']";

    @FindBy(xpath = "//android.widget.Button[@resource-id='com.easemytrip.android:id/btn_bus_search']")
    WebElement searchBtn;

    WebElement monthFullContainer;

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.easemytrip.android:id/tvMonthName']")
    WebElement monthElement;

    @FindBy(xpath = "//android.widget.TextView[@text='ONLINE BUS TICKETS']")
    WebElement busTitleText;


    public void clickOnBusFromNavBar() {
        busNavBar.click();
    }

    public boolean verifyUserIsOnBusHomePage() {
        return isPresent(busTitleText) && isPresent(sourceCityBx);
    }

    public void enterTheSourceCity(String sourceCity) {
        sourceCityBx.click();

        sourceCityInput.sendKeys(sourceCity);
        driver.findElement(By.xpath("//android.widget.ListView[@resource-id='com.easemytrip.android:id/search_airport_list']/android.widget.LinearLayout")).click();
//        waitForElementToBePresentNotVisible("//android.widget.ListView[@resource-id='com.easemytrip.android:id/search_airport_list']/android.widget.LinearLayout");
//        sourceCityOption.click();
//        waitForElementToBeVisible(cityOption);
//        cityOption.click();
    }

    public void enterTheDestinationCity(String destinationCity) {
        waitForElementToBeVisible(destinationCityInput);
        destinationCityInput.sendKeys(destinationCity);
        waitForElementToBePresentNotVisible("//android.widget.ListView[@resource-id='com.easemytrip.android:id/search_airport_list']/android.widget.LinearLayout");
//        destinationCityOption.click();
//        cityOption.click();
        driver.findElement(By.xpath("//android.widget.ListView[@resource-id='com.easemytrip.android:id/search_airport_list']/android.widget.LinearLayout")).click();

    }

    public void selectDepartureDate(String date) {
        dateInput.click();

        String day = date.substring(0, date.indexOf(" "));
        String month = date.substring(date.indexOf(" ") + 1, date.lastIndexOf(" "));
        String year = date.substring(date.lastIndexOf(" ") + 1);

        String monthYear = month + " " + year;

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

    public void clickOnSearchBtnOnBusPage() {
        searchBtn.click();
    }
}
