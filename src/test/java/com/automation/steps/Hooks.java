package com.automation.steps;

import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManagerMobile;
import com.automation.utils.DriverManagerWeb;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void setUp() {
        ConfigReader.initConfig();
        if (ConfigReader.getConfigValue("application.type").equals("mobile")) {
            DriverManagerMobile.createDriver();
        } else {
            DriverManagerWeb.createDriver();
        }
    }

    @After
    public void cleanUp() {
        if (ConfigReader.getConfigValue("application.type").equals("mobile")) {
//            DriverManagerMobile.getDriver().quit();
        } else {
            DriverManagerWeb.getDriver().quit();
        }
    }
}
