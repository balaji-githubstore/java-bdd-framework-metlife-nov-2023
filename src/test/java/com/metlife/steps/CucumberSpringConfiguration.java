package com.metlife.steps;

import com.metlife.base.WebDriverLibrary;
import com.metlife.pages.LoginPage;
import com.metlife.pages.MainPage;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = {WebDriverLibrary.class, LoginPage.class, MainPage.class})
public class CucumberSpringConfiguration {
}
