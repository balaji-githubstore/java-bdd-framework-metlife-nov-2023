@login
Feature: Login
  In order to maintain medical records
  As a user
  I want to access the OpenEMR dashboard

  Background:
    Given I have browser with OpenEMR application

  @invalid  @smoke
  Scenario: Invalid Login
    When I enter username as 'john'
    And I enter password as 'john123'
    And I select language as 'English (Indian)'
    And I click on login
    Then I should not get access to dashboard with error as 'Invalid username or password'

    @valid
  Scenario Outline: Valid Login
    When I enter username as '<username>'
    And I enter password as '<password>'
    And I select language as '<language>'
    And I click on login
    Then I should access the dashboard with title '<expected_title>'
    Examples:
      | username   | password   | language         | expected_title |
      | admin      | pass       | English (Indian) | OpenEMR        |
      | accountant | accountant | English (Indian) | OpenEMR        |







