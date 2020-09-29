@web @darkSky
Feature: DarkSky feature

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

  @DarkSkyCurrentTemp
  Scenario: Verify Current Temperature should not be greater or less than the Temperature from Daily Timeline
    Then I verify current temp is not greater or less then temps from daily timeline

  @DarkSkyTimelineHours
  Scenario: Verify timeline is displayed in correct format
    Then I verify timeline is displayed with two hours incremented

  @DarkSkyTodayTimeline
  Scenario: Verify individual day temp timeline
    When I expand today's timeline
    Then I verify lowest and highest temp is displayed correct
