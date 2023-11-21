package com.metlife.steps;

import com.metlife.base.AutomationWrapper;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class PatientSteps {

    private static String actualAlertText;
    private AutomationWrapper wrapper;

    public PatientSteps(AutomationWrapper wrapper)
    {
        this.wrapper=wrapper;
        System.out.println(wrapper.count);
    }

    @When("I click on patient menu")
    public void i_click_on_patient_menu() {
        wrapper.driver.findElement(By.xpath("//div[text()='Patient']")).click();
    }

    @When("I click on new-search menu")
    public void i_click_on_new_search_menu() {
        wrapper.driver.findElement(By.xpath("//div[text()='New/Search']")).click();
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

        wrapper.driver.switchTo().frame(wrapper.driver.findElement(By.xpath("//iframe[@name='pat']")));

        wrapper.driver.findElement(By.id("form_fname")).sendKeys(lists.get(0).get("firstname"));
        wrapper.driver.findElement(By.id("form_lname")).sendKeys(lists.get(0).get("lastname"));
        wrapper.driver.findElement(By.id("form_DOB")).sendKeys(lists.get(0).get("dob"));

        Select selectGender = new Select(wrapper.driver.findElement(By.id("form_sex")));
        selectGender.selectByVisibleText(lists.get(0).get("gender"));
    }

    @When("I click on create new patient")
    public void i_click_on_create_new_patient() {
        wrapper.driver.findElement(By.id("create")).click();
        wrapper.driver.switchTo().defaultContent();
    }

    @When("I click on confirm create new patient")
    public void i_click_on_confirm_create_new_patient() {
        wrapper.driver.switchTo().frame(wrapper.driver.findElement(By.xpath("//iframe[@id='modalframe']")));
        wrapper.driver.findElement(By.xpath("//button[normalize-space()='Confirm Create New Patient']")).click();
        wrapper.driver.switchTo().defaultContent();
    }

    @When("I handle the alert")
    public void i_handle_the_alert() {
        WebDriverWait wait = new WebDriverWait(wrapper.driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.alertIsPresent());

        actualAlertText = wrapper.driver.switchTo().alert().getText();
        System.out.println(actualAlertText);

        wrapper.driver.switchTo().alert().accept();
    }

    @When("I close the happy birthday popup if avaiable")
    public void i_close_the_happy_birthday_popup_if_avaiable() {

        //presence
        if (wrapper.driver.findElements(By.xpath("//div[@class='closeDlgIframe']")).size() > 0) {
            //visiblity
            if (wrapper.driver.findElement(By.xpath("//div[@class='closeDlgIframe']")).isDisplayed()) {
                wrapper.driver.findElement(By.xpath("//div[@class='closeDlgIframe']")).click();
            }
        }

    }

    @Then("I should get the added patient name as {string} and alert as {string}")
    public void i_should_get_the_added_patient_name_as_and_alert_as(String expectedName, String expectedAlert) {

        Assert.assertTrue(actualAlertText.contains(expectedAlert));

        wrapper.driver.switchTo().frame(wrapper.driver.findElement(By.xpath("//iframe[@name='pat']")));
        String actualPatientName = wrapper.driver.findElement(By.xpath("//span[contains(text(),'Medical Record')]")).getText();
        Assert.assertTrue(actualPatientName.contains(expectedName));
        wrapper.driver.switchTo().defaultContent();
    }
}
