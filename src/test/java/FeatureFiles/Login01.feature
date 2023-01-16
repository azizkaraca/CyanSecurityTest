Feature: Login Functionality

  Background:
    Given Navigate to Web Page

  Scenario: Login with valid username and password
    When User Enter Username and Password and Click Button
    Then User Should Login Successfully

  Scenario: Login with invalid username or password
    When User Enter invalid Username or Password and Click Button
    Then User Should Not Login Successfully