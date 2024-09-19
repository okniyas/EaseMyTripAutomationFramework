package com.automation.steps;

import com.automation.utils.ConfigReader;
import com.automation.utils.CucumberReportManager;
import com.automation.utils.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    @Before
    public void setUp(Scenario scenario) {
        ConfigReader.initConfig();
        DriverManager.createDriver();
        CucumberReportManager.initReport(scenario);
    }

    @After
    public void cleanUp(Scenario scenario) {
        if (scenario.isFailed()) {
            CucumberReportManager.attachScreenShot();
        }
        DriverManager.getDriver().quit();
    }
}
