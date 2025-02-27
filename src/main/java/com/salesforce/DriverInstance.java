package com.salesforce;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class DriverInstance {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void createInstance() {
        WebDriverManager.chromedriver().setup();
        setDriver(new ChromeDriver());
        getDriver().manage().window().maximize();
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void setDriver(WebDriver d) {
        driver.set(d);
    }
}
