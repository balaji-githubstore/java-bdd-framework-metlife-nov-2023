package com.metlife.base;

import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;

public class AutomationWrapper {
    public static WebDriver driver;

    @After
    public void endScenario()
    {
        if(driver !=null)
        {
            driver.quit();
        }
    }
}
