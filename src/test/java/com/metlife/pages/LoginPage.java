package com.metlife.pages;

import com.metlife.base.WebDriverKeywords;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.stereotype.Component;

//@Component
public class LoginPage extends WebDriverKeywords {
    private By usernameLocator=By.id("authUser");
    private By passwordLocator=By.cssSelector("#clearPass");
    private By loginLocator=By.id("login-button");
    private By errorLocator=By.xpath("//p[contains(text(),'Invalid')]");
    //private WebDriver driver;

//    public LoginPage(WebDriver driver) {
//
//        super(driver);
//       // this.driver = driver;
//    }


    public void enterUsername(String username) {
        //driver.findElement(usernameLocator).sendKeys(username);
        super.typeOnElement(usernameLocator,username);
    }

    public void enterPassword(String password) {
//        driver.findElement(passwordLocator).sendKeys(password);
        typeOnElement(passwordLocator,password);
    }

    public void clickOnLogin() {
//        driver.findElement(loginLocator).click();
        super.clickOnElement(loginLocator);
    }

    public String getInvalidErrorMessage() {
        return
                super.driver.findElement(errorLocator).getText();
    }

    public String getUsernamePlaceholder() {
        return driver.findElement(usernameLocator).getAttribute("placeholder");
    }

    public String getPasswordPlaceholder() {
        return driver.findElement(passwordLocator).getAttribute("placeholder");
    }

}
