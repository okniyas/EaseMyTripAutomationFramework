package com.automation.steps;

import com.automation.pages.interfaces.GiftCardDetailsPage;
import com.automation.pages.interfaces.GiftCardHomePage;
import com.automation.pages.mobile.GiftCardDetailsPageMobile;
import com.automation.pages.mobile.GiftCardHomePageMobile;
import com.automation.pages.web.GiftCardDetailsPageWeb;
import com.automation.pages.web.GiftCardHomePageWeb;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class GiftCardDetailsSteps {
    GiftCardDetailsPage giftCardDetailsPage;

    public GiftCardDetailsSteps(){
        String env = ConfigReader.getConfigValue("application.type");

        if(env.equals("mobile")) {
            giftCardDetailsPage = new GiftCardDetailsPageMobile();
        }else{
            giftCardDetailsPage = new GiftCardDetailsPageWeb();
        }
    }
    @When("user enter the gift card details")
    public void user_enter_the_gift_card_details(List<String> giftCardDetails) {
        giftCardDetailsPage.enterGiftCardDetails(
                ConfigReader.getConfigValue(giftCardDetails.get(0)),
                ConfigReader.getConfigValue(giftCardDetails.get(1))
        );
    }

    @When("user enter the sender and receiver details")
    public void user_enter_the_sender_and_receiver_details(List<String> senderAndReceiverDetails) {
        giftCardDetailsPage.enterSenderAndReceiverDetails(
                ConfigReader.getConfigValue(senderAndReceiverDetails.get(0)),
                ConfigReader.getConfigValue(senderAndReceiverDetails.get(1)),
                ConfigReader.getConfigValue(senderAndReceiverDetails.get(2)),
                ConfigReader.getConfigValue(senderAndReceiverDetails.get(3)),
                ConfigReader.getConfigValue(senderAndReceiverDetails.get(4)),
                ConfigReader.getConfigValue(senderAndReceiverDetails.get(5)),
                ConfigReader.getConfigValue(senderAndReceiverDetails.get(6))
        );
    }

    @When("user click on accept terms and conditions")
    public void user_click_on_accept_terms_and_conditions() {
        giftCardDetailsPage.clickOnAcceptTermsAndConditions();

    }

    @When("user click on pay now button")
    public void user_click_on_pay_now_button() {
        giftCardDetailsPage.clickOnPayNowBtn();

    }

    @Then("verify enter OTP code field is displayed")
    public void verify_enter_otp_code_field_is_displayed() {
        Assert.assertTrue(giftCardDetailsPage.isVerifyOTPCodeFieldIsDisplayed());

    }
}
