package com.automation.pages.mobile;

import com.automation.pages.interfaces.GiftCardHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GiftCardHomePageMobile extends BasePageMobile implements GiftCardHomePage {

    @FindBy(xpath = "//android.widget.TextView[@text='Gift Card']")
    WebElement giftCardIcon;

    String XPATH_GIFT_CARD_TYPE = "//android.widget.TextView[@text='%s ']";

//    @FindBy(xpath = "//android.view.View[@resource-id='All']//android.widget.TextView")
//    @FindBy(xpath = "//android.webkit.WebView[@text='Gift Cards - EaseMyTrip']/android.view.View/android.view.View/android.view.View[6]//android.widget.TextView")
    List<WebElement> listOfGiftCardType;

    @FindBy(xpath = "//android.webkit.WebView[@text='Gift Cards - EaseMyTrip']")
    WebElement giftCardPageContainer;


    public void clickOnGiftCardMenu() {
        giftCardIcon.click();
    }

    public void selectGiftCardType(String giftCardType) {
//        String xpathGiftCardType = String.format(XPATH_GIFT_CARD_TYPE, giftCardType);
//        System.out.println(xpathGiftCardType);
//        driver.findElement(By.xpath(xpathGiftCardType)).click();

//        for(int i=0; i< listOfGiftCardType.size();i++){
//
//        }
        int startX = giftCardPageContainer.getLocation().getX();
        int width = giftCardPageContainer.getSize().getWidth();
        int startY = giftCardPageContainer.getLocation().getY();
        int height = giftCardPageContainer.getSize().getHeight();

        System.out.println(startX);
        System.out.println(width);
        System.out.println(startY);
        System.out.println(height);

        waitForElementToBeVisible(driver.findElement(By.xpath("//android.webkit.WebView[@text='Gift Cards - EaseMyTrip']/android.view.View/android.view.View/android.view.View[6]//android.widget.TextView")));

        boolean present = true;
        while (present) {
//            listOfGiftCardType = driver.findElements(By.xpath("//android.view.View[@resource-id='All']//android.widget.TextView"));
            listOfGiftCardType = driver.findElements(By.xpath("//android.widget.Image[@text]/preceding-sibling::android.widget.TextView"));
            for (WebElement type : listOfGiftCardType) {
                System.out.println(type.getText());
                if (type.getText().equals(giftCardType + " ")) {
                    type.click();
                    present = false;
                    break;
                }
            }
            if (present) {
                scrollOrSwipe((startX + width) / 2, (startY + height)-50, (startX + width) / 2, startY);
            }
        }

    }
}
