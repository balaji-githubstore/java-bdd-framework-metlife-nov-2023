package com.metlife.steps;

import com.metlife.base.AutomationWrapper;
import com.metlife.pages.LoginPage;
import com.metlife.pages.MainPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class PatientSteps {

    private static String actualAlertText;
    @Autowired
    private WebDriver driver;
//    private AutomationWrapper wrapper;
    @Autowired
    private MainPage mainPage;

//    public PatientSteps(AutomationWrapper wrapper)
//    {
//        this.wrapper=wrapper;
//        System.out.println(count);
//    }

//    public void initPageObjects()
//    {
//         mainPage = new MainPage(driver);
//    }

    @When("I click on patient menu")
    public void i_click_on_patient_menu() {

//        driver.findElement(By.xpath("//div[text()='Patient']")).click();
        mainPage.clickOnPatientMenu();
    }

    @When("I click on new-search menu")
    public void i_click_on_new_search_menu() {
//        driver.findElement(By.xpath("//div[text()='New/Search']")).click();
        mainPage.clickOnPatientMenu();
    }

    @When("I fill the patient details")
    public void i_fill_the_patient_details(io.cucumber.datatable.DataTable dataTable) {

        List<Map<String, String>> lists = dataTable.asMaps();
        System.out.println(lists);
        System.out.println(lists.get(0));

        System.out.println(lists.get(0).get("firstname"));
        System.out.println(lists.get(0).get("lastname"));
        System.out.println(lists.get(0).get("dob"));
        System.out.println(lists.get(0).get("gender"));

       driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pat']")));

        driver.findElement(By.id("form_fname")).sendKeys(lists.get(0).get("firstname"));
        driver.findElement(By.id("form_lname")).sendKeys(lists.get(0).get("lastname"));
        driver.findElement(By.id("form_DOB")).sendKeys(lists.get(0).get("dob"));

        Select selectGender = new Select(driver.findElement(By.id("form_sex")));
        selectGender.selectByVisibleText(lists.get(0).get("gender"));
    }

    @When("I click on create new patient")
    public void i_click_on_create_new_patient() {
        driver.findElement(By.id("create")).click();
        driver.switchTo().defaultContent();
    }

    @When("I click on confirm create new patient")
    public void i_click_on_confirm_create_new_patient() {
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='modalframe']")));
        driver.findElement(By.xpath("//button[normalize-space()='Confirm Create New Patient']")).click();
        driver.switchTo().defaultContent();
    }

    @When("I handle the alert")
    public void i_handle_the_alert() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.alertIsPresent());

        actualAlertText = driver.switchTo().alert().getText();
        System.out.println(actualAlertText);

        driver.switchTo().alert().accept();
    }

    @When("I close the happy birthday popup if avaiable")
    public void i_close_the_happy_birthday_popup_if_avaiable() {

        //presence
        if (driver.findElements(By.xpath("//div[@class='closeDlgIframe']")).size() > 0) {
            //visiblity
            if (driver.findElement(By.xpath("//div[@class='closeDlgIframe']")).isDisplayed()) {
                driver.findElement(By.xpath("//div[@class='closeDlgIframe']")).click();
            }
        }

    }

    @Then("I should get the added patient name as {string} and alert as {string}")
    public void i_should_get_the_added_patient_name_as_and_alert_as(String expectedName, String expectedAlert) {

        Assert.assertTrue(actualAlertText.contains(expectedAlert));

        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pat']")));
        String actualPatientName = driver.findElement(By.xpath("//span[contains(text(),'Medical Record')]")).getText();
        Assert.assertTrue(actualPatientName.contains(expectedName));
        driver.switchTo().defaultContent();
    }
}
