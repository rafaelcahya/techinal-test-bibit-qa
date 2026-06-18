Feature: Bibit Website - Login
  As a user, I want to verify that login features work correctly

  Scenario: Open Login Page
    Given I open the browser and navigate to "https://bibit.id/"
    Then i click login button
    Then login page is opened
    And show title "Login"
    And the url is "https://app.bibit.id/login"
