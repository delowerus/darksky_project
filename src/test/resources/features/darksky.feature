@web @login
Feature: Login feature

  Background:
    Given I am on Dark Sky home page

  @login-successful
  Scenario: Verify successful login
    When I click on Dark Sky Api link on home page
    And I click on LOG IN link on Dark Sky Api page
    And I enter delowerus@gmail.com into email text field on login page
    And I enter Orno2020 into password field on login page
    And I click on login button on login page
    Then I verify header text
