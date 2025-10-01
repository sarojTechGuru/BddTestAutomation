#Author: javatechguru2809@gmail.com/Saroj Kumar
@Login
Feature: Login flow validation

  @Regression @TestCase01
  Scenario: Validate the elements in login page
    Given User has landed on login page
    When User waits for login button to display
    Then Validate the user name and password field is present
    And Login button is enabled

  @Sanity @TestCase02
  Scenario: Validate login flow
    Given User has entered "<username>"
    And user entered "<password>"
    When User clicked on login button
    Then Validate that user landed on homepage
