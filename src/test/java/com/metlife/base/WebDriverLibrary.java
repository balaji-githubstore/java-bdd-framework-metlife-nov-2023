package com.metlife.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.time.Duration;

//@Component
public class WebDriverLibrary {

    @Value("${app.browser}")
    private String browserName;

    @Value("${app.url}")
    private String appUrl;

    @Bean
    @Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
    public WebDriver getDriver()
    {
        WebDriver driver=null;

        if (browserName.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else if (browserName.equalsIgnoreCase("ff")) {
            driver = new FirefoxDriver();
        } else {
            driver = new ChromeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get(appUrl);

        return driver;
    }
}
