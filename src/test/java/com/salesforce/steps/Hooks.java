package com.salesforce.steps;

import com.salesforce.DriverInstance;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;

public class Hooks {


    @Before
    public void before() {
        DriverInstance.createInstance();
        DriverInstance.getDriver().get("https://login.salesforce.com/");
    }

    @After
    public void after() {
       DriverInstance.getDriver().quit();
    }
}
