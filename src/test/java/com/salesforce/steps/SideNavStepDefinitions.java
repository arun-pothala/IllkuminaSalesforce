package com.salesforce.steps;

import com.salesforce.DriverInstance;
import com.salesforce.pages.HomePage;
import com.salesforce.pages.SideNav;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class SideNavStepDefinitions {

    SideNav sideNav;

    @When("user clicks on Account")
    public void userClicksOnAccount() {
        sideNav = new SideNav(DriverInstance.getDriver());
        sideNav.clickAccounts();
    }
}
