package com.salesforce.steps;

import com.salesforce.DriverInstance;
import com.salesforce.pages.AccountPage;
import com.salesforce.pages.HomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class AccountStepDefinitions {

    AccountPage accountPage;

    @And("user clicks on new account")
    public void userClicksOnNewAccount() {
        accountPage = new AccountPage(DriverInstance.getDriver());
        accountPage.clickNewAccount();
    }

    @And("user enter account name {string}")
    public void userEnterAccountName(String accountName) {
        accountPage.enterAccountName(accountName);
    }

    @And("user click on save on Create Account modal")
    public void userClickOnSaveOnCreateAccountModal() {
        accountPage.clickAccountSave();
    }

    @Then("Verify the account is created successfully with {string}")
    public void verifyTheAccountIsCreatedSuccessfullyWith(String accountName) {
        Assert.assertEquals(accountPage.getPageTitleText(), accountName);
    }

    @And("user clicks on first Account")
    public void userClicksOnFirstAccount() {
        accountPage = new AccountPage(DriverInstance.getDriver());
        accountPage.clickFirstAccount();
    }

    @And("user clicks on create new contact")
    public void userClicksOnCreateNewContact() {
        accountPage.clickNewContact();
    }

    @And("user enter the contact lastName {string}")
    public void userEnterTheContactLastName(String lastName) {
        accountPage.enterLastName(lastName);
    }

    @And("user click on save in create contact modal")
    public void userClickOnSaveInCreateContactModal() {
        accountPage.clickContactSave();
    }

    @Then("verify the contact {string} reflects in contacts section")
    public void verifyTheContactReflectsInContactsSection(String lastName) {
        Assert.assertEquals(accountPage.getContactName(), lastName);
    }


}
