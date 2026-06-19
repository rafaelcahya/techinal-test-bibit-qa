package stepDefinitions.web;

import io.cucumber.java.en.*;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.web.ExplorePage;
import utils.ConfigReader;
import utils.DriverManager;
import java.util.List;

public class WebSteps {

    private WebDriver driver;
    private ExplorePage explorePage;

    @Given("I open the browser and navigate to {string}")
    public void iOpenBrowserAndNavigateTo(String urlKey) {
        driver = DriverManager.getWebDriver();
        explorePage = new ExplorePage(driver);
        String url = ConfigReader.get(urlKey + ".url");
        driver.get(url);
    }

    @When("I enter {string} in the field")
    public void iEnterInTheField(String value) {
        explorePage.enterSearchKeyword(value);
    }

    @Then("all results should contain {string}")
    public void allResultsShouldContain(String keyword) {
        WebElement resultContainer = explorePage.getResultContainer();
        Assertions.assertThat(resultContainer.isDisplayed()).as("Result should be appear").isTrue();

        List<WebElement> results = explorePage.getResultItems();
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
        WebElement emptyState = explorePage.getEmptyState();
        Assertions.assertThat(emptyState.isDisplayed())
                .as("Text 'Produk Tidak Ditemukan' should be displayed")
                .isTrue();
    }

    @When("I click {string} element")
    public void iClickElement(String element) {
        explorePage.clickExploreButton();
    }
}
