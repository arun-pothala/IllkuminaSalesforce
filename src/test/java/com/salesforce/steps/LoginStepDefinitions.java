package com.salesforce.steps;

import com.salesforce.DriverInstance;
import com.salesforce.pages.HomePage;
import com.salesforce.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefinitions {

    LoginPage loginPage;
    HomePage homePage;

    @Given("user is on the Salesforce login page")
    public void userIsOnTheSalesforceLoginPage() {
        loginPage = new LoginPage(DriverInstance.getDriver());
    }

    @When("user login with username {string} and password {string}")
    public void userLoginWithUsernameAndPassword(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
    }

    @Then("verify salesforce homepage is displayed")
    public void verifySalesforceHomepageIsDisplayed() {
        homePage = new HomePage(DriverInstance.getDriver());
        Assert.assertTrue(homePage.isSalesforceHomePageDisplayed());
    }

    @Then("verify login page is displayed")
    public void verifyLoginPageIsDisplayed() {
        loginPage = new LoginPage(DriverInstance.getDriver());
        Assert.assertTrue(loginPage.isLoginPageDisplayed());
    }
}
