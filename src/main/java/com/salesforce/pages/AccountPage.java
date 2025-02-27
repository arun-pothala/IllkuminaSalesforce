package com.salesforce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class AccountPage extends AbstractBasePage {

    @FindBy(xpath = "//*[@title='Accounts']")
    private WebElement accountsTitle;

    @FindBy(xpath = "//*[@title='New']")
    private WebElement newButton;

    @FindBy(xpath = "//input[@name='Name']")
    private WebElement nameField;

    @FindBy(xpath = "//button[@name='SaveEdit']")
    private WebElement saveButton;

    @FindBy(xpath = "//slot[contains(@class,'slds-page-header__title')]/lightning-formatted-text")
    private WebElement pageTitleText;

    @FindBy(xpath = "//*[@name='Global.NewContact']")
    private WebElement newContactButton;

    @FindBy(xpath = "//input[contains(@class,'lastName')]")
    private WebElement lastNameField;

    @FindBy(xpath = "//footer//button/span[text()='Save']")
    private WebElement newContactSaveButton;

    @FindBy(xpath = "//*[@aria-label='Contacts']//article")
    private WebElement contactName;

    @FindBy(xpath = "//a[@data-refid='recordId']")
    private WebElement firstAccount;

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    public void clickNewAccount() {
        waitForVisibilityOfElement(newButton).click();
    }

    public void enterAccountName(String name) {
        waitForVisibilityOfElement(nameField).sendKeys(name);
    }

    public void clickAccountSave() {
        waitForVisibilityOfElement(saveButton).click();
    }

    public String getPageTitleText() {
        return waitForVisibilityOfElement(pageTitleText).getText();
    }

    public void clickNewContact() {
        waitForVisibilityOfElement(newContactButton).click();
    }

    public void enterLastName(String lastName) {
        waitForVisibilityOfElement(lastNameField).sendKeys(lastName);
    }

    public void clickContactSave() {
        waitForVisibilityOfElement(newContactSaveButton).click();
    }

    public String getContactName() {
        return waitForVisibilityOfElement(contactName).getDomAttribute("aria-label");
    }

    public void clickFirstAccount() {
        waitForVisibilityOfElement(firstAccount).click();
    }

    @Override
    protected void isOnPage() {
        waitForVisibilityOfElement(accountsTitle);
    }
}
