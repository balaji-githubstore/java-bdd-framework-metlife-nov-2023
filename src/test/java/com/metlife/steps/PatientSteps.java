package com.metlife.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class PatientSteps {

    @When("I click on patient menu")
    public void i_click_on_patient_menu() {
        
    }
    @When("I click on new-search menu")
    public void i_click_on_new_search_menu() {
        
    }
    @When("I fill the patient details")
    public void i_fill_the_patient_details(io.cucumber.datatable.DataTable dataTable) {

       List<Map<String,String>> lists=  dataTable.asMaps();
        System.out.println(lists);

        System.out.println(lists.get(0));

        System.out.println(lists.get(0).get("firstname"));
        System.out.println(lists.get(0).get("lastname"));
        System.out.println(lists.get(0).get("dob"));
        System.out.println(lists.get(0).get("gender"));
    }
    @When("I click on create new patient")
    public void i_click_on_create_new_patient() {
        
    }
    @When("I click on confirm create new patient")
    public void i_click_on_confirm_create_new_patient() {
        
    }
    @When("I handle the alert")
    public void i_handle_the_alert() {
        
    }
    @When("I close the happy birthday popup if avaiable")
    public void i_close_the_happy_birthday_popup_if_avaiable() {
        
    }
    @Then("I should get the added patient name as {string}")
    public void i_should_get_the_added_patient_name_as(String string) {
        
    }

}
