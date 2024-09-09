package com.automation.steps;

import com.automation.pages.interfaces.GiftCardHomePage;
import com.automation.pages.mobile.GiftCardHomePageMobile;
import com.automation.pages.web.GiftCardHomePageWeb;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.When;

public class GiftCardHomeSteps {
    GiftCardHomePage giftCardHomePage;

    public GiftCardHomeSteps(){
        String env = ConfigReader.getConfigValue("application.type");

        if(env.equals("mobile")) {
            giftCardHomePage = new GiftCardHomePageMobile();
        }else{
            giftCardHomePage = new GiftCardHomePageWeb();
        }
    }


    @When("the user clicks on gift card menu")
    public void the_user_clicks_on_gift_card_menu() {
        giftCardHomePage.clickOnGiftCardMenu();
        
    }

    @When("user select the gift card type {string}")
    public void user_select_the_gift_card_type(String giftCardTypeKey) {
        giftCardHomePage.selectGiftCardType(ConfigReader.getConfigValue(giftCardTypeKey));
        
    }


}
