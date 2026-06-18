package stepDefinitions.android;

import io.cucumber.java.en.*;
import pages.android.ProductDetailPage;
import utils.AppiumManager;

public class ProductDetailSteps {

    private ProductDetailPage productDetailPage() {
        return new ProductDetailPage(AppiumManager.getAndroidDriver());
    }

    @When("I select color {string}")
    public void iSelectColor(String color) {
        productDetailPage().selectColor(color);
    }

    @When("I set quantity to {int}")
    public void iSetQuantityTo(int quantity) {
        productDetailPage().setQuantity(quantity);
    }

    @When("I add the product to cart")
    public void iAddTheProductToCart() {
        productDetailPage().addToCart();
    }
}
