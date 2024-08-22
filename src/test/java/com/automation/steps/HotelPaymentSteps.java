package com.automation.steps;

import com.automation.pages.interfaces.HotelPaymentPage;
import com.automation.pages.mobile.HotelListingPageMobile;
import com.automation.pages.mobile.HotelPaymentPageMobile;
import com.automation.pages.web.HotelListingPageWeb;
import com.automation.pages.web.HotelPaymentPageWeb;
import com.automation.utils.ConfigReader;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class HotelPaymentSteps {
    HotelPaymentPage hotelPaymentPage;

    public HotelPaymentSteps(){
        String env = ConfigReader.getConfigValue("application.type");

        if(env.equals("mobile")) {
            hotelPaymentPage = new HotelPaymentPageMobile();
        }else{
            hotelPaymentPage = new HotelPaymentPageWeb();
        }
    }
//    HotelPaymentPageWeb hotelPaymentPage=new HotelPaymentPageWeb();

    @Then("verify the price summary calculations")
    public void verify_the_price_summary_calculations() {
        hotelPaymentPage.isPriceSummaryCorrect();
    }


    @Then("verify hotel payment page is displayed")
    public void verifyHotelPaymentPageIsDisplayed() {
        Assert.assertTrue(hotelPaymentPage.isHotelPaymentPageDisplayed());
    }
}
