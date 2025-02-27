package com.salesforce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractBasePage{

    @FindBy(id="username")
    private WebElement usernameField;

    @FindBy(id="password")
    private WebElement passwordField;

    @FindBy(id="Login")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public void enterUsername(String  username) {
        waitForVisibilityOfElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        waitForVisibilityOfElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        waitForVisibilityOfElement(loginButton).click();
    }

    public boolean isLoginPageDisplayed() {
        return isElementVisible(loginButton);
    }

    @Override
    protected void isOnPage() {
        waitForVisibilityOfElement(usernameField);
    }
}
