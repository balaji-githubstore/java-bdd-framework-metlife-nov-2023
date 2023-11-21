package com.metlife.base;

import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;

public class AutomationWrapper {
    public WebDriver driver;
    public int count=0;

    @After
    public void endScenario()
    {
        if(driver !=null)
        {
            driver.quit();
        }
    }
}
