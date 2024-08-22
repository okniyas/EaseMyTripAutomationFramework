package com.automation.pages.mobile;

import com.automation.pages.interfaces.BusSeatingPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BusSeatingPageMobile extends BasePageMobile implements BusSeatingPage {

    @FindBy(xpath = "//div[@id='myModal']//div[@class='sleeper_normal']")
    WebElement selectAvailableSeat;

    @FindBy(xpath = "//div[@id='myModal']//div[@class='sleeper_normal_select']")
    WebElement selectedSeat;

    @FindBy(id = "selectBoard")
    WebElement clickBoardingPoint;

    @FindBy(xpath = "//ul[@id='seatBpPoint']/li")
    WebElement selectBoardingPointFromDropdown;

    @FindBy(id = "selectDrop")
    WebElement clickDroppingPoint;

    @FindBy(xpath = "//ul[@id='seatDropUL']/li")
    WebElement selectDroppingPointFromDropdown;

    @FindBy(xpath = "//a[@class='btn_cntn']")
    WebElement continueBtn;


    public void selectTheFirstAvailableSeat() {
        selectAvailableSeat.click();
    }

    public boolean verifyTheSeatIsSelected() {
        return isPresent(selectedSeat);
    }

    public void selectTheBoardingPoint() {
        clickByJS(selectBoardingPointFromDropdown);
//        selectBoardingPointFromDropdown.click();
    }

    public void selectTheDroppingPoint() {
        clickByJS(selectDroppingPointFromDropdown);
//        selectDroppingPointFromDropdown.click();
    }

    public void clickOnContinueBtn() {
        continueBtn.click();
    }
}
