Feature: JSONPlaceholder API - Update Post
  As a developer, I want to verify that PUT /posts/1 updates the post correctly

  Scenario: Update post with id 1
    Given the base URL is "jsonplaceholder"
    When I send a PUT request to "/posts/1" with body:
      | title  | Updated Post Title               |
      | body   | This is the updated body content.|
      | userId | 99                               |
    Then the response status code should be 200
    And the response field "title" should be "Updated Post Title"
    And the response field "body" should be "This is the updated body content."
    And the response field "userId" should be 99
    And the response should match JSON schema "update_post_schema.json"
