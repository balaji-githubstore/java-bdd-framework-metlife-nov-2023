package com.metlife.pages;

import com.metlife.base.WebDriverKeywords;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends WebDriverKeywords {

    private WebDriver driver;

    public MainPage(WebDriver driver)
    {
        super(driver);
        this.driver=driver;
    }


    public void clickOnPatientMenu(){
        driver.findElement(By.xpath("//div[text()='Patient']")).click();
    }
    public void clickOnNewSearchMenu(){
        driver.findElement(By.xpath("//div[text()='New/Search']")).click();
    }

    public String getMainPageTitle()
    {
        return driver.getTitle();
    }
}
