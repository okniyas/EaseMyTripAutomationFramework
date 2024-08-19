package com.automation.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TrainListingPage extends BasePage{

    @FindBy(xpath = "//div[@class='trlist']")
    List<WebElement>trainList;

    @FindBy(xpath = "//a[@class='mdf_btn']")
    WebElement modifySearchBtn;

    @FindBy(xpath = "//li[@id='b']")
    WebElement nameDescBtn;

    @FindBy(xpath = "//li[@id='a']")
    WebElement nameAscBtn;


    List<String>trainNames=new ArrayList<>();

    public void isTrainListingDisplayed() {
        Assert.assertTrue(modifySearchBtn.isDisplayed());
        Assert.assertTrue(trainList.size()>1);
    }

    public void sortByNameAtoZ() throws InterruptedException {

        nameAscBtn.click();
        Thread.sleep(2000);

    }

    public void isSortingByNameAToZDisplayed() {

        List<WebElement>nameElements= driver.findElements(By.xpath("//div[contains(@class,'tr-name')]"));
        for (WebElement name:nameElements){
            trainNames.add(name.getText());
        }

        List<String>namesCopy=new ArrayList<>(trainNames);
        Collections.sort(namesCopy);
        Assert.assertEquals(namesCopy,trainNames);
    }
}
