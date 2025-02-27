package com.salesforce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public abstract class AbstractBasePage {

    protected WebDriver driver;
    protected WebDriverWait wait, smallerWait;

    public AbstractBasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
        this.smallerWait = new WebDriverWait(this.driver, Duration.ofSeconds(5));
        PageFactory.initElements(driver, this);
        isOnPage();
    }

    protected WebElement waitForVisibilityOfElement(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected boolean isElementVisible(WebElement element) {
        try {
            return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    protected void clickElementByJS(WebElement element) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].click();", element);
    }

    protected abstract void isOnPage();
}
