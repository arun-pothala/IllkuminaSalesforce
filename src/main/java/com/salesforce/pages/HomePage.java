package com.salesforce.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends AbstractBasePage {

    @FindBy(xpath = "//span[@data-aura-class='oneUserProfileCardTrigger']")
    private WebElement userProfileIcon;

    @FindBy(xpath = "//input[@placeholder='Search Setup']")
    private WebElement searchField;

    @FindBy(xpath = "//div[@class='listContent']//li//span[@title]")
    private List<WebElement> searchResults;

    @FindBy(xpath = "//a[text()='Log Out']")
    private WebElement logoutButton;


    //a[text()='Log Out']

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public boolean isSalesforceHomePageDisplayed() {
        return isElementVisible(userProfileIcon);
    }

    public void enterSearchKeyword(String keyword) {
        waitForVisibilityOfElement(searchField).sendKeys(keyword);
    }

    public List<String> getSearchResultsText() {
        List<String> searchResultTextList = new ArrayList<>();
        for (WebElement searchResult : searchResults) {
            searchResultTextList.add(searchResult.getText());
        }
        return searchResultTextList;
    }

    public void clickUserProfile() {
        waitForVisibilityOfElement(userProfileIcon).click();
    }

    public void clickLogout() {
        waitForVisibilityOfElement(logoutButton).click();
    }

    @Override
    protected void isOnPage() {
        waitForVisibilityOfElement(userProfileIcon);
    }
}
