Feature: JSONPlaceholder API - Delete Post
  As a developer, I want to verify that DELETE /posts/1 deletes the post correctly

  Scenario: Delete post with id 1
    Given the base URL is "jsonplaceholder"
    When I send a DELETE request to "/posts/1"
    Then the response status code should be 200
    And the response body should be an empty object
    And the response should match JSON schema "delete_post_schema.json"
