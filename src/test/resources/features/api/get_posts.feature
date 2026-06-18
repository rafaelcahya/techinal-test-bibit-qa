Feature: JSONPlaceholder API - Get Posts
  As a developer, I want to verify that GET /posts returns correct response

  Scenario: Get all posts and verify each post has a non-null id
    Given the base URL is "jsonplaceholder"
    When I send a GET request to "/posts"
    Then the response status code should be 200
    And each post should have a non-null id field
    And the response should match JSON schema "posts_list_schema.json"
