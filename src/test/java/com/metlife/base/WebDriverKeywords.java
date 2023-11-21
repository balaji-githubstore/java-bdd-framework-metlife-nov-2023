package com.metlife.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WebDriverKeywords {
    protected WebDriver driver;

    public WebDriverKeywords(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnElement(By locator) {
        driver.findElement(locator).click();
    }

    public void typeOnElement(By locator, String text) {
        driver.findElement(locator).sendKeys(text);
    }
}
