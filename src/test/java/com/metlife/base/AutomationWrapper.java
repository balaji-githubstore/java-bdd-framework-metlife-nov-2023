package com.metlife.base;

import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;

//@Component
public class AutomationWrapper {
    @Autowired
    public WebDriver driver;
//    public int count=0;
//
//    public void launchBrowser()
//    {
//        driver=new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        driver.get("https://demo.openemr.io/b/openemr");
//    }
    @After
    public void endScenario()
    {
        if(driver !=null)
        {
            driver.quit();
        }
    }
}
