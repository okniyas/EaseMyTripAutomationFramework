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


    public void isTrainListingDisplayed() {
        Assert.assertTrue("Train Listing page not loaded", trainNameSortBtn.isDisplayed());
        Assert.assertFalse("Train List is null", trainNameList.isEmpty());
    }

    public void sortByNameAtoZ() {

        trainNameSortBtn.click();
        trainNameSortBtn.click();

    }

    public void isSortingByNameAToZDisplayed() {

        List<String> ascNameList = getListOfTrainNames();
        System.out.println(ascNameList);

        List<String> ascNamesCopy = new ArrayList<>(ascNameList);
        Collections.sort(ascNamesCopy);

        Assert.assertEquals(ascNamesCopy, ascNameList);
    }

    public void sortByNameZtoA() {
        trainNameSortBtn.click();

    }

    public void isSortingByNameZToADisplayed() {
        List<String> descNameList = getListOfTrainNames();
        System.out.println(descNameList);

        List<String> descNamesCopy = new ArrayList<>(descNameList);
        descNamesCopy.sort(Collections.reverseOrder());

        Assert.assertEquals(descNamesCopy, descNameList);
    }

    public List<String> getListOfTrainNames() {

        List<String> trainNames = new ArrayList<>();

        WebElement trainNoElement = driver.findElement(By.xpath("(//android.widget.TextView[@resource-id='com.easemytrip.android:id/tvTrainNumber'])[1]"));
        WebElement trainDetailsContainer;
        WebElement calendarContainer;
        WebElement trainNameElement;
        String trainName;

        String prevTrainNo = "";
        String currentTrainNo = trainNoElement.getText();

        while (!prevTrainNo.equals(currentTrainNo)) {

            trainDetailsContainer = driver.findElement(By.xpath("//androidx.recyclerview.widget.RecyclerView[contains(@resource-id,'trainListView')]/android.widget.RelativeLayout[1]"));
            calendarContainer = driver.findElement(By.xpath("//androidx.recyclerview.widget.RecyclerView[contains(@resource-id,'calendar_recycle')]"));
            trainNameElement = driver.findElement(By.xpath("(//android.widget.TextView[@resource-id='com.easemytrip.android:id/tvTrainName'])[1]"));

            trainName = trainNameElement.getText();
            trainNames.add(trainName);

            int startW = trainDetailsContainer.getSize().getWidth();
            int startH = trainDetailsContainer.getSize().getHeight();
            int endW = calendarContainer.getSize().getWidth();

            int startX = trainDetailsContainer.getLocation().getX();
            int startY = trainDetailsContainer.getLocation().getY();
            int endX = calendarContainer.getLocation().getX();
            int endY = calendarContainer.getLocation().getY();

            scrollOrSwipe(startX + (startW / 2), startY + startH, endX + (endW / 2), endY);

            prevTrainNo = currentTrainNo;
            trainNoElement = driver.findElement(By.xpath("(//android.widget.TextView[@resource-id='com.easemytrip.android:id/tvTrainNumber'])[1]"));
            currentTrainNo = trainNoElement.getText();

        }

        List<WebElement> trainList = driver.findElements(By.xpath("//android.widget.TextView[@resource-id='com.easemytrip.android:id/tvTrainName']"));

        for (WebElement train : trainList) {
            trainNames.add(train.getText());
        }

        return trainNames;
    }

}
