package stepDefinitions.web;

import io.cucumber.java.en.*;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigReader;
import utils.DriverManager;
import java.time.Duration;
import java.util.List;

public class WebSteps {

    private WebDriver driver;

    @Given("I open the browser and navigate to {string}")
    public void iOpenBrowserAndNavigateTo(String urlKey) {
        driver = DriverManager.getWebDriver();
        String url = ConfigReader.get(urlKey + ".url");
        driver.get(url);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlToBe(url));
    }

    @When("I enter {string} in the field")
    public void iEnterInTheField(String value) {
        WebElement searchField = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".custom-input-search")));
        searchField.clear();
        searchField.sendKeys(value);
    }

    @Then("all results should contain {string}")
    public void allResultsShouldContain(String keyword) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[data-testid^='search-action-company-']")));

        List<WebElement> results = driver.findElements(By.cssSelector(".textstyled__StyledText-fccmrq"));
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
        WebElement noResultText = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Produk Tidak Ditemukan')]")));

        Assertions.assertThat(noResultText.isDisplayed())
                .as("Text 'Produk Tidak Ditemukan' should be displayed")
                .isTrue();
    }

    @When("I click element")
    public void iClickElement() {
        WebElement button = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Cari produk investasi')]")));
                button.click();
    }
}
