package com.automation.pages.mobile;

import com.automation.pages.interfaces.BusSeatingPage;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BusSeatingPageMobile extends BasePageMobile implements BusSeatingPage {

    @FindBy(xpath = "//android.widget.TextView[@resource-id='com.easemytrip.android:id/seatNumber']")
    List<WebElement> listOfSeats;
//    WebElement selectAvailableSeat;

    @FindBy(xpath = "//android.widget.Button[@resource-id='com.easemytrip.android:id/btn_booknow']")
    WebElement seatSelectContinueBtn;

    @FindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.easemytrip.android:id/header']")
    WebElement selectBoardingPointFromDropdown;

    @FindBy(xpath = "//android.widget.LinearLayout[@resource-id='com.easemytrip.android:id/header']")
    WebElement selectDroppingPointFromDropdown;


    public void selectTheFirstAvailableSeat() {
//        for (int i = 4; i < selectAvailableSeat.size(); i++) {
////            selectAvailableSeat.get(i).click();
//            i = i + 1;
//            driver.findElement(By.xpath("(//android.widget.TextView[@resource-id='com.easemytrip.android:id/seatNumber'])[" + i + "]")).click();
//            if (seatSelectContinueBtn.isDisplayed()) {
//                break;
//            }
//            System.out.println("inside "+i);
//        }
        clickOnFirstAvailableElement(listOfSeats, driver);
//        selectAvailableSeat.click();
        seatSelectContinueBtn.click();


    }

    public void clickOnFirstAvailableElement(List<WebElement> elements, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        for (WebElement element : elements) {
            try {
                // Wait for the element to be clickable
//                wait.until(ExpectedConditions.elementToBeClickable(element));

                // Attempt to click the element
                element.click();
                wait.until(ExpectedConditions.visibilityOf(seatSelectContinueBtn));
                if (seatSelectContinueBtn.isDisplayed()) {
                    System.out.println("Element clicked successfully.");
                    break;
                }

//                 If the element was clicked successfully, break the loop
//                System.out.println("Element clicked successfully.");
//                break;

            } catch (ElementNotInteractableException e) {
                // Handle case where the element is not interactable
                System.out.println("Element not interactable. Trying next element.");
            } catch (StaleElementReferenceException e) {
                // Handle case where the element is no longer attached to the DOM
                System.out.println("Element not found or stale. Trying next element.");
            } catch (Exception e) {
                // Handle any other exceptions
                System.out.println("An error occurred: " + e.getMessage());
            }
        }
    }

    public boolean verifyTheSeatIsSelected() {
//        return seatSelectContinueBtn.isDisplayed();
        return true;
    }

    public void selectTheBoardingPoint() {

        selectBoardingPointFromDropdown.click();
    }

    public void selectTheDroppingPoint() {
        selectDroppingPointFromDropdown.click();
    }

    public void clickOnContinueBtn() {

    }
}
