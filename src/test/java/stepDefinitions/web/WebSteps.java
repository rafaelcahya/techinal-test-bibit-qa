package stepDefinitions.web;

import io.cucumber.java.en.*;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.ConfigReader;
import utils.DriverManager;
import java.util.List;

public class WebSteps {

    private WebDriver driver;

    @Given("I open the browser and navigate to {string}")
    public void iOpenBrowserAndNavigateTo(String urlKey) {
        driver = DriverManager.getWebDriver();
        String url = ConfigReader.get(urlKey + ".url");
        driver.get(url);
    }

    @When("I enter {string} in the field")
    public void iEnterInTheField(String value) {
        WebElement searchField = driver.findElement(By.cssSelector(".custom-input-search"));
        searchField.clear();
        searchField.sendKeys(value);
    }

    @Then("all results should contain {string}")
    public void allResultsShouldContain(String keyword) {
        WebElement resultContainer = driver.findElement(By.cssSelector(".ExploreSaham_watchlist-item-full__r66lZ"));
        Assertions.assertThat(resultContainer.isDisplayed()).as("Result should be appear").isTrue();

        List<WebElement> results = driver.findElements(By.cssSelector(".ExploreSaham_stock-details-item__d5BDU"));
        Assertions.assertThat(results)
                .as("Search results should not be empty")
                .isNotEmpty();

        for (WebElement result : results) {
            Assertions.assertThat(result.getText())
                    .as("Result '" + result.getText() + "' should contain keyword: " + keyword)
                    .containsIgnoringCase(keyword);
        }
    }

    @Then("no results should be displayed")
    public void noResultsShouldBeDisplayed() {
        WebElement emptyStateTextContainer = driver.findElement(By.cssSelector(".SearchEmptyState_search-content-empty__kcFoj"));
        Assertions.assertThat(emptyStateTextContainer.isDisplayed())
                .as("Text 'Produk Tidak Ditemukan' should be displayed")
                .isTrue();
    }

    @When("I click {string} element")
    public void iClickElement(String element) {
        driver.findElement(By.cssSelector(".ExploreSaham_bit-explore-button__XEn5W")).click();
    }
}
