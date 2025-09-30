#Author: javatechguru2809@gmail.com/Saroj Kumar

@Regression
Feature: Login flow validation

  @sanity
  Scenario:Validate login flow
    Given User has entered "<username>"
    And user entered "<password>"
    When User clicked on login button
    Then Validate that user laned on homepage