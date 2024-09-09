package com.automation.pages.mobile;

import com.automation.pages.interfaces.MetroPaymentPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MetroPaymentPageMobile extends BasePageMobile implements MetroPaymentPage {

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.easemytrip.android:id/tv_verify']")
    WebElement verifyAndPayBtn;

    @FindBy(xpath = "//android.widget.RelativeLayout[@resource-id='com.easemytrip.android:id/paynment_top']")
    WebElement paymentOptionText;

    @Override
    public boolean isVerifyOnPaymentsPageOfMetro() {
        return isDisplay(verifyAndPayBtn) && isDisplay(paymentOptionText);
    }
}
