Feature: Login Functionality

  Background:
    Given Navigate to Web Page

  Scenario: TC:01 - Login with valid username and password
    When User Enter Username "tomsmith" and Password "SuperSecretPassword!" and Click Button
    Then User Should Login Successfully

  Scenario: TC:02 - Login with invalid username and valid password
    When User Enter Username "aziz" and Password "SuperSecretPassword!" and Click Button
    Then User Should Not Login Successfully

  Scenario: TC:03 - Login with valid username and invalid password
    When User Enter Username "tomsmith" and Password "BadPassword" and Click Button
    Then User Should Not Login Successfully