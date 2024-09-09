package com.automation.pages.interfaces;

public interface GiftCardDetailsPage {
    void enterGiftCardDetails(String denomination, String quantity);

    void enterSenderAndReceiverDetails(String senderName, String senderEmail, String senderMobile, String receiverName, String receiverEmail, String receiverReEnterEmail, String receiverMobile);

    void clickOnAcceptTermsAndConditions();

    void clickOnPayNowBtn();

    boolean isVerifyOTPCodeFieldIsDisplayed();
}
