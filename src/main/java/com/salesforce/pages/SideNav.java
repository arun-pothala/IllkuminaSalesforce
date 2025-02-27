package com.salesforce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SideNav extends AbstractBasePage {

//    @FindBy(xpath = "//img[contains(@src,'EasyAccounts')]")
    @FindBy(xpath = "//li[contains(@class,'verticalNavMenuListItem')]//span[text()='Accounts']/ancestor::a")
    private WebElement accountsIcon;

    public SideNav(WebDriver driver) {
        super(driver);
    }

    public AccountPage clickAccounts() {
        clickElementByJS(accountsIcon);
        return new AccountPage(driver);
    }

    @Override
    protected void isOnPage() {
        waitForVisibilityOfElement(accountsIcon);
    }
}
