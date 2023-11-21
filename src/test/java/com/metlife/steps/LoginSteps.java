package com.metlife.steps;

import com.metlife.base.AutomationWrapper;
import com.metlife.pages.LoginPage;
import com.metlife.pages.MainPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class LoginSteps {

    private AutomationWrapper wrapper;
    private LoginPage loginPage;
    private MainPage mainPage;
    public LoginSteps(AutomationWrapper wrapper)
    {
        this.wrapper=wrapper;
        System.out.println(wrapper.count);
        wrapper.count=1;
    }

    public void initPageObjects()
    {
         loginPage=new LoginPage(wrapper.driver);
         mainPage=new MainPage(wrapper.driver);
    }

    @Given("I have browser with OpenEMR application")
    public void i_have_browser_with_open_emr_application() {
        wrapper.launchBrowser();
        initPageObjects();
    }
    @When("I enter username as {string}")
    public void i_enter_username_as(String username) {
        //wrapper.driver.findElement(By.id("authUser")).sendKeys(username);
        loginPage.enterUsername(username);
    }
    @When("I enter password as {string}")
    public void i_enter_password_as(String password) {
//        wrapper.driver.findElement(By.cssSelector("#clearPass")).sendKeys(password);
        loginPage.enterPassword(password);
    }
    @When("I select language as {string}")
    public void i_select_language_as(String language) {
        System.out.println(language);
    }
    @When("I click on login")
    public void i_click_on_login() {
//        wrapper.driver.findElement(By.id("login-button")).click();
        loginPage.clickOnLogin();
    }
    @Then("I should access the dashboard with title {string}")
    public void i_should_access_the_dashboard_with_title(String expectedTitle) {
//        Assert.assertEquals(wrapper.driver.getTitle(),expectedTitle);
        Assert.assertEquals(mainPage.getMainPageTitle(),expectedTitle);
    }

    @Then("I should not get access to dashboard with error as {string}")
    public void i_should_not_get_access_to_dashboard_with_error_as(String expectedError) {

//        String actualError=wrapper.driver.findElement(By.xpath("//p[contains(text(),'Invalid')]")).getText();
        String actualError=loginPage.getInvalidErrorMessage();
        Assert.assertEquals(actualError,expectedError);
    }
}
