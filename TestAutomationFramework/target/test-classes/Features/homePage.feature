#Author: javatechguru2809@gmail.coma
@Homepage
Feature: Validate the homepage functionality

  Background: User is Logged In
    Given User navigate to the login page
    When User submit username "<username>"
    And User submit password "<password>"
    Then User has landed on homepage

  @Regression @TestCase001
  Scenario: Validate all items in homepage
    When user checks the secondary header label
    Then validate all the items labels
