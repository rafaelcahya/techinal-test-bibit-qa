Feature: My Demo App Android - Login
  As a user, I want to verify that login works correctly

  @login
  Scenario: Successful login with valid credentials
    Given the app is launched
    When I navigate to the login page
    And I enter "bob@example.com" in the username field
    And I enter "10203040" in the password field
    And I tap the login button
    Then I should be logged in successfully
