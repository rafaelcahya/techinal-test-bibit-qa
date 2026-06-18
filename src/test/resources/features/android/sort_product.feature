Feature: Sort Product on My Demo App Android

  Background:
    Given the app is launched
    When I navigate to the login page
    And I enter "bob@example.com" in the username field
    And I enter "10203040" in the password field
    And I tap the login button

  @sort
  Scenario: Sort Product By Name Descending
    When I sort products by "Name" in "Descending" order
    Then the product catalog is displayed

  @sort
  Scenario: Sort Product By Price Ascending
    When I sort products by "Price" in "Ascending" order
    Then the product catalog is displayed
