package com.automation.utils;


import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class CucumberReportManager {
    public static Scenario scenario;

    public static void initReport(Scenario scenario) {
        CucumberReportManager.scenario = scenario;
    }

    public static void attachScreenShot() {
        TakesScreenshot takesScreenshot = (TakesScreenshot) DriverManager.getDriver();
        byte[] screenshot = takesScreenshot.getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", "FailedTestSnap");
    }

    public static void attachLog(String message) {
        scenario.log(message);
    }


}
