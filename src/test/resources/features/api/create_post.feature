Feature: JSONPlaceholder API - Create Post
  I want to verify that POST /posts creates a new post correctly

  Scenario: Create a new post with valid data
    Given the base URL is "jsonplaceholder"
    When I send a POST request to "/posts" with body:
      | title  | Learn API Testing                           |
      | body   | Practicing API testing with JSONPlaceholder |
      | userId | 101                                         |
    Then the response status code should be 201
    And the response field "title" should be "Learn API Testing"
    And the response field "body" should be "Practicing API testing with JSONPlaceholder"
    And the response field "userId" should be 101
    And the response should match JSON schema "post_schema.json"
