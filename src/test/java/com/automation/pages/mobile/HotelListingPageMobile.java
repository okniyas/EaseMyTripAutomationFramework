package com.automation.pages.mobile;

import com.automation.pages.interfaces.HotelListingPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HotelListingPageMobile extends BasePageMobile implements HotelListingPage {

    @FindBy(xpath = "//android.widget.TextView[contains(@resource-id,'HotelList')]")
    WebElement propertiesListTitle;

    @FindBy(xpath = "//android.widget.TextView[@text='Sort']")
    WebElement sortBtn;

    @FindBy(xpath = "//android.widget.LinearLayout[contains(@resource-id,'LowToHigh')]")
    WebElement sortLowToHigh;

    @FindBy(xpath = "//android.widget.LinearLayout[contains(@resource-id,'HighToLow')]")
    WebElement sortHighToLow;

    WebElement container;
    WebElement priceElement;

    @FindBy(xpath = "//div[@class='htl_ttl']")
    List<WebElement>hotelTitles;

    public boolean isHotelListingPageDisplayed() {
        return isDisplay(propertiesListTitle);
    }

    public void clickOnFilter() {
        sortBtn.click();
    }

    public void selectFilterPriceLowToHigh() {
        sortLowToHigh.click();

    }

    public void isPriceListingFromLowToHigh() {
        List<Double> priceList =getPriceList();
        System.out.println(priceList);
        List<Double> priceCopy = new ArrayList<>(priceList);
        Collections.sort(priceCopy);
        Assert.assertEquals(priceCopy, priceList);

    }

    public void selectFilterPriceHighToLow() {
        sortHighToLow.click();
    }

    public void isPriceListingFromHighToLow() {
        List<Double> priceList =getPriceList();
        System.out.println(priceList);
        List<Double> priceCopy = new ArrayList<>(priceList);
        priceCopy.sort(Comparator.reverseOrder());
        Assert.assertEquals(priceCopy, priceList);
    }

    public void selectHotel() {
        hotelTitles.get(0).click();
    }
    public List<Double> getPriceList(){
        List<Double>priceList=new ArrayList<>();

        for(int i=0;i<10;i++){
            priceElement= driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.easemytrip.android:id/tv_orignal_price']"));
            String priceText=priceElement.getText().substring(1);
            double price=Double.parseDouble(priceText);
            priceList.add(price);

            container= driver.findElement(By.xpath("//android.widget.TextView[@resource-id='com.easemytrip.android:id/tv_orignal_price']/ancestor::android.widget.FrameLayout[@resource-id='com.easemytrip.android:id/hotel_item_card']/parent::android.widget.LinearLayout"));
            int x = container.getLocation().getX();
            int y = container.getLocation().getY();

            int width=container.getSize().getWidth();
            int height=container.getSize().getHeight();

            scrollOrSwipe(x+(width/2),y+height,x+(width/2),y);
        }
        return priceList;
    }
}
