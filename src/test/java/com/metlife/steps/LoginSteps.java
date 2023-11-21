package com.metlife.steps;

import com.metlife.base.AutomationWrapper;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class LoginSteps {

    private AutomationWrapper wrapper;
    public LoginSteps(AutomationWrapper wrapper)
    {
        this.wrapper=wrapper;
    }

    @Given("I have browser with OpenEMR application")
    public void i_have_browser_with_open_emr_application() {
        this.wrapper.driver=new ChromeDriver();
        wrapper.driver.manage().window().maximize();
        wrapper.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wrapper.driver.get("https://demo.openemr.io/b/openemr");
    }
    @When("I enter username as {string}")
    public void i_enter_username_as(String username) {
        wrapper.driver.findElement(By.id("authUser")).sendKeys(username);
    }
    @When("I enter password as {string}")
    public void i_enter_password_as(String password) {
        wrapper.driver.findElement(By.cssSelector("#clearPass")).sendKeys(password);
    }
    @When("I select language as {string}")
    public void i_select_language_as(String language) {
        System.out.println(language);
    }
    @When("I click on login")
    public void i_click_on_login() {
        wrapper.driver.findElement(By.id("login-button")).click();
    }
    @Then("I should access the dashboard with title {string}")
    public void i_should_access_the_dashboard_with_title(String expectedTitle) {
        Assert.assertEquals(wrapper.driver.getTitle(),expectedTitle);
    }

    @Then("I should not get access to dashboard with error as {string}")
    public void i_should_not_get_access_to_dashboard_with_error_as(String expectedError) {

        String actualError=wrapper.driver.findElement(By.xpath("//p[contains(text(),'Invalid')]")).getText();
        Assert.assertEquals(actualError,expectedError);
    }
}
