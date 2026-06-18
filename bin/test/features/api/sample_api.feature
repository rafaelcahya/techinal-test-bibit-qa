Feature: Sample API Testing
  As a developer, I want to verify that REST APIs return correct responses

  Scenario: Get user list from JSONPlaceholder
    Given the base URL is "https://jsonplaceholder.typicode.com"
    When I send a GET request to "/users"
    Then the response status code should be 200
    And the response body should not be empty
