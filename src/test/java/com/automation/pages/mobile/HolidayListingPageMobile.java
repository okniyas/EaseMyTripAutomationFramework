package com.automation.pages.mobile;

import com.automation.pages.interfaces.HolidayListingPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
    String XPATH_FILTER_MOBILE = "//android.widget.TextView[contains(@text,'Low to High')]//parent::android.view.View";

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

    public boolean verifyListingPageHasResultsInAscendingOrder() {

        int x = firstHolidayPackageContainer.getLocation().getX();
        int y = firstHolidayPackageContainer.getLocation().getY();
        int width = firstHolidayPackageContainer.getSize().getWidth();
        int height = firstHolidayPackageContainer.getSize().getHeight();

        int xPage = holidayPageContainer.getLocation().getX();
        int yPage = holidayPageContainer.getLocation().getY();
        int widthPage = holidayPageContainer.getSize().getWidth();
        int heightPage = holidayPageContainer.getSize().getHeight();

        System.out.println(x);
        System.out.println(y);
        System.out.println(width);
        System.out.println(xPage);
        System.out.println(yPage);
        System.out.println(widthPage);

//        int count = 0;
//        do {
            scrollOrSwipe((x + width) / 2, y, (x + width) / 2, yPage);
//            count++;
//        } while (count < 4);

//        List<WebElement> listOfPricesElements = driver.findElements(By.xpath("//div[@class='listpnl']/div//span[@class='prc-ttl']/span[1]"));
//        List<Integer> listOfPrices = new ArrayList<>();
//        for(WebElement eachPrice : listOfPricesElements){
//            int price = Integer.parseInt(eachPrice.getText().split("₹ ")[1]);
//            System.out.println(price);
//            listOfPrices.add(price);
//        }
//
//        List<Integer> listOfPricesCopy = new ArrayList<>(listOfPrices);
//        Collections.sort(listOfPricesCopy);

        System.out.println("list : ");

        return true;
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
