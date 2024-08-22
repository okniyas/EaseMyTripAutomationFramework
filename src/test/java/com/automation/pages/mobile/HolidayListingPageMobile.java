package com.automation.pages.mobile;

import com.automation.pages.interfaces.HolidayListingPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HolidayListingPageMobile extends BasePageMobile implements HolidayListingPage {

    @FindBy(xpath = "//div[@class='listpnl']/div//div[contains(@class, 'pkgName')]")
    List<WebElement> packageWithName;

    @FindBy(xpath = "//div[@class='listpnl']/div//div//a[text()='View Package  ']")
    WebElement viewPackage;

    @FindBy(xpath = "//div[@class='topFilter']//select")
    WebElement selectSortingOption;

    @FindBy(id = "openfilter")
    WebElement moreFilterOption;

    String XPATH_OF_THEME = "//div[@class='topFilterv2']//span[@class='checkmark_f2']/parent::label[contains(text(), '%s')]";

    @FindBy(xpath = "//android.widget.Image[@text='searchicon']")
    WebElement searchBtn;

    @FindBy(xpath = "//android.widget.TextView[@text='Going To']")
    WebElement goingToFilter;

    public boolean verifyListingPageHasResultsForTheGivenDestination(String destination) {
        return isPresent(goingToFilter) && isPresent(searchBtn);
    }

    public void selectSortingOption(String sortingOption) {
        Select selectOption = new Select(selectSortingOption);
        selectOption.selectByVisibleText(sortingOption);

    }

    public boolean verifyListingPageHasResultsInAscendingOrder() {
        List<WebElement> listOfPricesElements = driver.findElements(By.xpath("//div[@class='listpnl']/div//span[@class='prc-ttl']/span[1]"));
        List<Integer> listOfPrices = new ArrayList<>();
        for(WebElement eachPrice : listOfPricesElements){
            int price = Integer.parseInt(eachPrice.getText().split("₹ ")[1]);
            System.out.println(price);
            listOfPrices.add(price);
        }

        List<Integer> listOfPricesCopy = new ArrayList<>(listOfPrices);
        Collections.sort(listOfPricesCopy);

        System.out.println("list : "+ listOfPrices);
        System.out.println("list copy : "+ listOfPricesCopy);

        return listOfPrices.equals(listOfPricesCopy);
    }

    public void clickOnFilterOptionInHolidayListingPage() {
        moreFilterOption.click();
    }

    public void selectThemeOfHolidayType(String tripTheme) {
        String xpath = String.format(XPATH_OF_THEME, tripTheme);
        driver.findElement(By.xpath(xpath)).click();
    }

    public boolean verifyHolidaysListingPageShowsResultForTripTheme() {
        return packageWithName.size() > 0 && isPresent(viewPackage);
    }
}
