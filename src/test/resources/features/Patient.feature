@patient
Feature: Patient
  In order to maintain the patient details
  As a admin
  I want to add,edit,delete patient records

  @addpatient
  Scenario Outline: Add Patient
    Given I have browser with OpenEMR application
    When I enter username as '<username>'
    And I enter password as '<password>'
    And I select language as '<language>'
    And I click on login
    And I click on patient menu
    And I click on new-search menu
    And I fill the patient details
      | firstname | lastname | dob   | gender   |
      | <fname>   | <lname>  | <dob> | <gender> |
    And I click on create new patient
    And I click on confirm create new patient
    And I handle the alert
    And I close the happy birthday popup if avaiable
    Then I should get the added patient name as '<expected_patient_name>'
    Examples:
      | username | password | language         | fname | lname | dob        | gender | expected_patient_name                 |
      | admin    | pass     | English (Indian) | john  | wick  | 2023-11-20 | Male   | Medical Record Dashboard - john wick  |
      | admin    | pass     | English (Indian) | peter | wick  | 2023-11-21 | Male   | Medical Record Dashboard - peter wick |