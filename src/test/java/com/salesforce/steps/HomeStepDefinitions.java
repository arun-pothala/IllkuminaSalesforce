package com.salesforce.steps;

import com.salesforce.DriverInstance;
import com.salesforce.pages.HomePage;
import com.salesforce.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class HomeStepDefinitions {

    HomePage homePage;

    @And("user search with {string}")
    public void userSearchWith(String searchKeyword) {
        homePage =  new HomePage(DriverInstance.getDriver());
        homePage.enterSearchKeyword(searchKeyword);
    }

    @Then("verify search result shows {string}")
    public void verifySearchResultShows(String searchKeyword) {
        List<String> results = homePage.getSearchResultsText();
        for (String result : results) {
            Assert.assertTrue(result.contains(searchKeyword));
        }
    }

    @When("user clicks on user profile icon")
    public void userClicksOnUserProfileIcon() {
        homePage =  new HomePage(DriverInstance.getDriver());
        homePage.clickUserProfile();
    }

    @And("user clicks on logout")
    public void userClicksOnLogout() {
        homePage.clickLogout();
    }
}
