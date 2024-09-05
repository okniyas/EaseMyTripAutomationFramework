package com.automation.pages.mobile;

import com.automation.pages.interfaces.HolidayListingPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HolidayListingPageMobile extends BasePageMobile implements HolidayListingPage {

    @FindBy(xpath = "//div[@class='listpnl']/div//div[contains(@class, 'pkgName')]")
    List<WebElement> packageWithName;

    @FindBy(xpath = "//div[@class='listpnl']/div//div//a[text()='View Package  ']")
    WebElement viewPackage;

    @FindBy(xpath = "//div[@class='topFilter']//select")
    WebElement selectSortingOption;

    @FindBy(xpath = "//android.widget.TextView[@text='Sort by']")
    WebElement sortBy;

    //    String XPATH_FILTER_MOBILE = "//android.widget.TextView[contains(@text,'%s')]";
    String XPATH_FILTER_MOBILE = "//android.widget.TextView[contains(@text,'%s')]//parent::android.view.View";

    String XPATH_OF_THEME = "//div[@class='topFilterv2']//span[@class='checkmark_f2']/parent::label[contains(text(), '%s')]";

    @FindBy(xpath = "//android.widget.Image[@text='searchicon']")
    WebElement searchBtn;

    @FindBy(xpath = "//android.widget.TextView[@text='Going To']")
    WebElement goingToFilter;

    //    @FindBy(xpath = "//androidx.viewpager.widget.ViewPager[@resource-id='com.easemytrip.android:id/vpPager']//android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[3]/android.view.View[2]")
    @FindBy(xpath = "//androidx.viewpager.widget.ViewPager[@resource-id='com.easemytrip.android:id/vpPager']//android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[5]")
    WebElement firstHolidayPackageContainer;

    @FindBy(xpath = "//androidx.viewpager.widget.ViewPager[@resource-id='com.easemytrip.android:id/vpPager']//android.webkit.WebView/android.webkit.WebView/android.view.View")
    WebElement holidayPageContainer;

    @FindBy(xpath = "//android.widget.RelativeLayout[@resource-id='com.easemytrip.android:id/progress_layout']")
    WebElement waitClock;

    public boolean verifyListingPageHasResultsForTheGivenDestination(String destination) {
//        waitForElementToBeVisible(goingToFilter);
        waitForElementToBeInvisible(waitClock);
        return isPresent(goingToFilter) && isPresent(searchBtn);
    }

    public void selectSortingOption(String sortingOption) {

        sortBy.click();
        String xpath = String.format(XPATH_FILTER_MOBILE, sortingOption);
        driver.findElement(By.xpath(xpath)).click();
    }

    public boolean verifyListingPageHasResultsInAscendingOrder(String sortingType) {

        int x = firstHolidayPackageContainer.getLocation().getX();
        int y = firstHolidayPackageContainer.getLocation().getY();
        int width = firstHolidayPackageContainer.getSize().getWidth();
        int height = firstHolidayPackageContainer.getSize().getHeight();

//// Scroll Logic
//        Dimension dimension = driver.manage().window().getSize();
//        int xPage = dimension.getWidth();
//        int yPage = dimension.getHeight();

        int xPage = holidayPageContainer.getLocation().getX();
        int yPage = holidayPageContainer.getLocation().getY();
        int xWidthTotal = holidayPageContainer.getSize().getWidth();
        int yHeightTotal = holidayPageContainer.getSize().getHeight();

        System.out.println(x);
        System.out.println(y);
        System.out.println(width);
        System.out.println(xPage);
        System.out.println(yPage);
//        System.out.println(widthPage);

//        int count = 0;
//        do {
        if (firstHolidayPackageContainer.isDisplayed()) {
            scrollOrSwipe((x + width) / 2, y, (x + width) / 2, yPage);
        } else {
            while (!firstHolidayPackageContainer.isDisplayed()) {
                scrollOrSwipe(xPage / 2, yPage + yHeightTotal, xPage / 2, yPage);
            }
        }
        List<Double> holidayPrices = getListOfHolidays();
        System.out.println("list : " + holidayPrices);
        List<Double> holidayCopy = new ArrayList<>(holidayPrices);
        System.out.println("copy"+ holidayCopy);
        if(sortingType.contains("Low to High")){
            Collections.sort(holidayPrices);
        }else{
            holidayPrices.sort(Collections.reverseOrder());
            System.out.println("After reverse: "+ holidayPrices);
        }


        return holidayPrices.equals(holidayCopy);
    }

    public List<Double> getListOfHolidays() {

        List<Double> holidayPrices = new ArrayList<>();

        WebElement holidayNameElement = driver.findElement(By.xpath("//android.view.View[@resource-id='btn123']/android.view.View[2]/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.widget.TextView"));
        WebElement holidayDetailsContainer;
        WebElement calendarContainer;
        WebElement holidayPriceElement;
        Double holidayPrice;

        String prevHolidayName = "";
        String currentHolidayName = holidayNameElement.getText();

        int totalCount=1;
        while (!prevHolidayName.equals(currentHolidayName) && totalCount <=10 ) {

            holidayDetailsContainer = driver.findElement(By.xpath("//android.view.View[@resource-id='btn123']/android.view.View[2]/android.view.View/android.view.View/android.view.View[1]"));
//            holidayPriceElement = driver.findElement(By.xpath("//android.view.View[@resource-id='btn123']/android.view.View[2]/android.view.View/android.view.View/android.view.View[1]/android.view.View[4]/android.widget.TextView[@resource-id]"));
            holidayPriceElement = driver.findElement(By.xpath("//android.widget.TextView[@text='Starting from']/following-sibling::android.widget.TextView[@resource-id]"));

            holidayPrice = Double.parseDouble(holidayPriceElement.getText().split("₹")[1]);
            System.out.println(holidayPrice);
            holidayPrices.add(holidayPrice);

            int startX = holidayDetailsContainer.getLocation().getX();
            int startY = holidayDetailsContainer.getLocation().getY();
            int width = holidayDetailsContainer.getSize().getWidth();
            int height = holidayDetailsContainer.getSize().getHeight();

            System.out.println("Before/Outside");
            System.out.println(startX + (width / 2));
            System.out.println(startY + height);
            System.out.println(startX + (width / 2));
            System.out.println(startY - 10);
            System.out.println("Finished Before");


            scrollOrSwipe(startX + (width / 2), startY + height, startX + (width / 2), startY - 10);

            prevHolidayName = currentHolidayName;
            try {
                holidayNameElement = driver.findElement(By.xpath("//android.view.View[@resource-id='btn123']/android.view.View[2]/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.widget.TextView"));

            } catch (Exception e) {
                System.out.println("Exception: " + Arrays.toString(e.getStackTrace()));

                Dimension dimension = driver.manage().window().getSize();
                int xPage = dimension.getWidth();
                int yPage = dimension.getHeight();

                System.out.println("Inside exception");
                System.out.println(xPage/2);
                System.out.println(yPage/2);
                System.out.println(xPage/2);
                System.out.println(yPage/2 - 200);
//                scrollOrSwipe(startX + (width / 2), startY + height, startX + (width / 2), startY + height - 50);
                scrollOrSwipe(xPage / 2, yPage /2, xPage/ 2, yPage / 2 - 200);
                holidayNameElement = driver.findElement(By.xpath("//android.view.View[@resource-id='btn123']/android.view.View[2]/android.view.View/android.view.View/android.view.View[1]/android.view.View[2]/android.widget.TextView"));

            }
            currentHolidayName = holidayNameElement.getText();

            System.out.println("previous = " + prevHolidayName + "=====>>>  current = " + currentHolidayName);
            totalCount++;

        }

//        List<WebElement> holidayList = driver.findElements(By.xpath("//android.view.View[@resource-id='btn123']/android.view.View[2]/android.view.View/android.view.View/android.view.View[1]/android.view.View[4]/android.widget.TextView[@resource-id]"));
//
//        for (WebElement holiday : holidayList) {
//            holidayPrices.add(holiday.getText());
//        }

        return holidayPrices;
    }

    public void clickOnFilterOptionInHolidayListingPage() {
//        moreFilterOption.click();
    }

    public void selectThemeOfHolidayType(String tripTheme) {
        String xpath = String.format(XPATH_OF_THEME, tripTheme);
        driver.findElement(By.xpath(xpath)).click();
    }

    public boolean verifyHolidaysListingPageShowsResultForTripTheme() {
        return packageWithName.size() > 0 && isPresent(viewPackage);
    }
}
