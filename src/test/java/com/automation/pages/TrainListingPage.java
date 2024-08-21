package com.automation.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TrainListingPage extends BasePage {

    @FindBy(xpath = "//div[@class='trlist']")
    List<WebElement> trainList;

    @FindBy(xpath = "//a[@class='mdf_btn']")
    WebElement modifySearchBtn;

    @FindBy(xpath = "//li[@id='b']")
    WebElement nameDescBtn;

    @FindBy(xpath = "//li[@id='a']")
    WebElement nameAscBtn;

    @FindBy(id = "divTrainLoader")
    WebElement trainLoader;

    public void isTrainListingDisplayed() {
        Assert.assertTrue(modifySearchBtn.isDisplayed());
        Assert.assertTrue(trainList.size() > 1);
    }

    public void sortByNameAtoZ() {

        nameAscBtn.click();
        waitForElementToBeInvisible(trainLoader);

    }

    public void isSortingByNameAToZDisplayed() {
        List<String> trainNames = new ArrayList<>();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[contains(@class,'tr-name')]")));
        List<WebElement> nameElements = driver.findElements(By.xpath("//div[contains(@class,'tr-name')]"));
        for (WebElement name : nameElements) {
            trainNames.add(name.getText());
        }

        List<String> namesCopy = new ArrayList<>(trainNames);
        Collections.sort(namesCopy);
        Assert.assertEquals(namesCopy, trainNames);
    }

    public void sortByNameZtoA() {
        nameAscBtn.click();
        waitForElementToBeInvisible(trainLoader);
        nameDescBtn.click();
        waitForElementToBeInvisible(trainLoader);

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
