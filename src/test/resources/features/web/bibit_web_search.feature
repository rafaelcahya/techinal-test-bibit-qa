Feature: Bibit Website - Search Product
  As a user, I want to verify that search product displays results matching the keyword

  Background:
    Given I open the browser and navigate to "explore"

  Scenario: Search with valid keyword shows matching results
    When I click "explore button" element
    Then I enter "Sucorinvest" in the field
    And all results should contain "Sucorinvest"

  Scenario: Search with invalid keyword shows no results
    When I click "explore button" element
    Then I enter "Sucorinvest123qweasd" in the field
    And no results should be displayed
