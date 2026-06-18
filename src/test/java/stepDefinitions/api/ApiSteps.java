package stepDefinitions.api;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import utils.ConfigReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApiSteps {

    private Response response;

    @Given("the base URL is {string}")
    public void theBaseURLIs(String urlKey) {
        RestAssured.baseURI = ConfigReader.get(urlKey + ".url");
    }

    @When("I send a GET request to {string}")
    public void iSendGetRequestTo(String endpoint) {
        response = RestAssured.given()
                .header("Content-Type", "application/json")
                .when()
                .get(endpoint);
    }

    @When("I send a POST request to {string} with body:")
    public void iSendPostRequestTo(String endpoint, DataTable dataTable) {
        Map<String, String> rawData = dataTable.asMap(String.class, String.class);
        Map<String, Object> body = new HashMap<>();
        body.put("title", rawData.get("title"));
        body.put("body", rawData.get("body"));
        body.put("userId", Integer.parseInt(rawData.get("userId")));

        response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .post(endpoint);
    }

    @Then("the response status code should be {int}")
    public void theResponseStatusCodeShouldBe(int expectedStatus) {
        Assertions.assertThat(response.getStatusCode())
                .as("Response status code")
                .isEqualTo(expectedStatus);
    }

    @Then("the response body should not be empty")
    public void theResponseBodyShouldNotBeEmpty() {
        Assertions.assertThat(response.getBody().asString())
                .as("Response body should not be empty")
                .isNotBlank();
    }

    @Then("the response field {string} should be {string}")
    public void theResponseFieldShouldBeString(String field, String expectedValue) {
        String actualValue = response.jsonPath().getString(field);
        Assertions.assertThat(actualValue)
                .as("Response field '" + field + "'")
                .isEqualTo(expectedValue);
    }

    @Then("the response field {string} should be {int}")
    public void theResponseFieldShouldBeInt(String field, int expectedValue) {
        int actualValue = response.jsonPath().getInt(field);
        Assertions.assertThat(actualValue)
                .as("Response field '" + field + "'")
                .isEqualTo(expectedValue);
    }

    @Then("the response should match JSON schema {string}")
    public void theResponseShouldMatchJsonSchema(String schemaFile) {
        response.then()
                .assertThat()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schemas/" + schemaFile));
    }

    @When("I send a PUT request to {string} with body:")
    public void iSendPutRequestTo(String endpoint, DataTable dataTable) {
        Map<String, String> rawData = dataTable.asMap(String.class, String.class);
        Map<String, Object> body = new HashMap<>();
        body.put("title", rawData.get("title"));
        body.put("body", rawData.get("body"));
        body.put("userId", Integer.parseInt(rawData.get("userId")));

        response = RestAssured.given()
                .header("Content-Type", "application/json")
                .body(body)
                .when()
                .put(endpoint);
    }

    @When("I send a DELETE request to {string}")
    public void iSendDeleteRequestTo(String endpoint) {
        response = RestAssured.given()
                .header("Content-Type", "application/json")
                .when()
                .delete(endpoint);
    }

    @Then("the response body should be an empty object")
    public void theResponseBodyShouldBeEmptyObject() {
        String body = response.getBody().asString().trim();
        Assertions.assertThat(body)
                .as("Response body should be an empty object")
                .isEqualTo("{}");
    }

    @Then("each post should have a non-null id field")
    public void eachPostShouldHaveNonNullIdField() {
        List<Map<String, Object>> posts = response.jsonPath().getList("$");

        Assertions.assertThat(posts)
                .as("Posts list should not be empty")
                .isNotEmpty();

        for (int i = 0; i < posts.size(); i++) {
            Object id = posts.get(i).get("id");
            Assertions.assertThat(id)
                    .as("Post at index [" + i + "] should have a non-null id")
                    .isNotNull();
        }
    }
}
