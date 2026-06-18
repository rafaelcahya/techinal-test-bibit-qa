package stepDefinitions.android;

import io.cucumber.java.en.*;
import org.assertj.core.api.Assertions;
import pages.android.ProductCatalogPage;
import utils.AppiumManager;

public class ProductCatalogSteps {

    private ProductCatalogPage productCatalogPage() {
        return new ProductCatalogPage(AppiumManager.getAndroidDriver());
    }

    @When("I sort products by {string} in {string} order")
    public void iSortProductsBy(String field, String order) {
        productCatalogPage().sortProducts(field, order);
    }

    @When("I tap on product {string}")
    public void iTapOnProduct(String productName) {
        productCatalogPage().tapProduct(productName);
    }

    @Then("the product catalog is displayed")
    public void theProductCatalogIsDisplayed() {
        Assertions.assertThat(productCatalogPage().isDisplayed())
                .as("Product catalog should be visible")
                .isTrue();
    }
}
