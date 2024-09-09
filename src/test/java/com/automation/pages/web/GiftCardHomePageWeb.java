package com.automation.pages.web;

import com.automation.pages.interfaces.GiftCardHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class GiftCardHomePageWeb extends BasePageWeb implements GiftCardHomePage {

    @FindBy(xpath = "//span[contains(@class, 'moremenuico')]")
    WebElement moreMenuIcon;

    @FindBy(xpath = "//span[contains(text(), 'Gift Card')]")
    WebElement giftCardIcon;

    String XPATH_GIFT_CARD_TYPE = "//div[@id='All']//div[text()='%s ']/parent::div/preceding-sibling::div";


    public void clickOnGiftCardMenu() {
        Actions actions = new Actions(driver);
        actions.moveToElement(moreMenuIcon).build().perform();

        waitForElementToBeVisible(giftCardIcon);
        giftCardIcon.click();
    }


    public void selectGiftCardType(String giftCardType) {
        String xpathGiftCardType = String.format(XPATH_GIFT_CARD_TYPE, giftCardType);
        System.out.println(xpathGiftCardType);
//        clickByJS(driver.findElement(By.xpath(xpathGiftCardType)));
        driver.findElement(By.xpath(xpathGiftCardType)).click();
    }

}
