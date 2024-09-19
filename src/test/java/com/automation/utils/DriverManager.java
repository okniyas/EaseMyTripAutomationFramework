package com.automation.utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.time.Duration;

public class DriverManager {

    static WebDriver driver;

    public static void createDriver() {

        if (ConfigReader.getConfigValue("application.type").equals("mobile")) {
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("platformName", ConfigReader.getConfigValue("platform.name"));
            capabilities.setCapability("deviceName", ConfigReader.getConfigValue("device.name"));
            capabilities.setCapability("automationName", ConfigReader.getConfigValue("automation.name"));
            capabilities.setCapability("app", ConfigReader.getConfigValue("app.path"));
            capabilities.setCapability("appActivity", ConfigReader.getConfigValue("app.activity"));
            capabilities.setCapability("appPackage", ConfigReader.getConfigValue("app.package"));
            capabilities.setCapability("autoGrantPermissions", true);

            driver = new AppiumDriver(capabilities);
        } else {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            driver = new ChromeDriver(options);
            driver.manage().window().maximize();

        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(45));
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
