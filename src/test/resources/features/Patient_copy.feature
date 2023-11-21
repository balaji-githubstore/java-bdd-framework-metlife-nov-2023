#@patient
#Feature: Patient
#  In order to maintain the patient details
#  As a admin
#  I want to add,edit,delete patient records
#
#  @addpatient
#  Scenario: Add Patient
#    Given I have browser with OpenEMR application
#    When I enter username as 'admin'
#    And I enter password as 'pass'
#    And I select language as 'English (Indian)'
#    And I click on login
#    And I click on patient menu
#    And I click on new-search menu
#    And I fill the patient details
#      | firstname | lastname | dob        | gender |
#      | john      | wick     | 2023-11-20 | Female |
#    And I click on create new patient
#    And I click on confirm create new patient
#    And I handle the alert
#    And I close the happy birthday popup if avaiable
#    Then I should get the added patient name as 'Medical Record Dashboard - john wick'
#
#  Scenario: Add Patient2
#    Given I have browser with OpenEMR application
#    When I enter username as 'admin'
#    And I enter password as 'pass'
#    And I select language as 'English (Indian)'
#    And I click on login
#    And I click on patient menu
#    And I click on new-search menu
#    And I fill the patient details
#      | firstname | lastname | dob        | gender |
#      | ken       | wick     | 2023-11-20 | Male   |
#    And I click on create new patient
#    And I click on confirm create new patient
#    And I handle the alert
#    And I close the happy birthday popup if avaiable
#    Then I should get the added patient name as 'Medical Record Dashboard - ken wick'
