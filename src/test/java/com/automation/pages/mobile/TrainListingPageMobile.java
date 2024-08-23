package com.automation.pages.mobile;

import com.automation.pages.interfaces.TrainListingPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TrainListingPageMobile extends BasePageMobile implements TrainListingPage {

    @FindBy(xpath = "//android.widget.TextView[contains(@resource-id,'TrainName')]")
    List<WebElement> trainNameList;

    @FindBy(xpath = "//android.widget.TextView[@text='TRAIN NAME']")
    WebElement trainNameSortBtn;

    @FindBy(xpath = "//androidx.recyclerview.widget.RecyclerView[contains(@resource-id,'trainListView')]/android.widget.RelativeLayout[1]")
    WebElement trainContainer;

    @FindBy(xpath = "//li[@id='b']")
    WebElement nameDescBtn;

    @FindBy(xpath = "//li[@id='a']")
    WebElement nameAscBtn;

    @FindBy(id = "divTrainLoader")
    WebElement trainLoader;

    public void isTrainListingDisplayed() {
        Assert.assertTrue("Train Listing page not loaded",trainNameSortBtn.isDisplayed());
        Assert.assertFalse("Train List is null", trainNameList.isEmpty());
    }

    public void sortByNameAtoZ() {

        trainNameSortBtn.click();
        trainNameSortBtn.click();
//        waitForElementToBeInvisible(trainLoader);

    }

    public void isSortingByNameAToZDisplayed() {
        List<String> trainNames = new ArrayList<>();

        List<WebElement> nameElements = driver.findElements(By.xpath("//div[contains(@class,'tr-name')]"));
        for (WebElement name : nameElements) {
            trainNames.add(name.getText());
        }

        List<String> namesCopy = new ArrayList<>(trainNames);
        Collections.sort(namesCopy);
        Assert.assertEquals(namesCopy, trainNames);
    }

    public void sortByNameZtoA() {
        trainNameSortBtn.click();

    }

    public void isSortingByNameZToADisplayed() {
        List<String> trainNamesDesc = new ArrayList<>();
        List<WebElement> elements = driver.findElements(By.xpath("//div[contains(@class,'tr-name')]"));
        for (WebElement name : elements) {
            trainNamesDesc.add(name.getText());
        }

        List<String> copy = new ArrayList<>(trainNamesDesc);
        copy.sort(Collections.reverseOrder());

        Assert.assertEquals(copy, trainNamesDesc);

    }
}
