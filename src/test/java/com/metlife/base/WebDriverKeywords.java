package com.metlife.base;

import jakarta.annotation.PostConstruct;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;

//@Component
public class WebDriverKeywords {
    @Autowired
    protected WebDriver driver;
    private FluentWait<WebDriver> wait;

    @PostConstruct
    public void WebDriverKeywords() {
        wait=new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(20));
        wait.ignoring(Exception.class);
    }

    public WebElement waitForElement(By locator,int timeInSeconds)
    {
        wait=new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(timeInSeconds));
        wait.ignoring(Exception.class);

       WebElement ele= wait.until(x->x.findElement(locator));
       return ele;
    }

    public void clickOnElement(By locator) {
//        driver.findElement(locator).click();
        wait.until(x->x.findElement(locator)).click();
    }

    public void typeOnElement(By locator, String text) {
        driver.findElement(locator).sendKeys(text);

        waitForElement(locator,20).sendKeys(text);
    }

    public void typeOnElement1(By locator, String text) {
//        driver.findElement(locator).sendKeys(text);

        wait.until(x->x.findElement(locator)).sendKeys(text);
    }
}
