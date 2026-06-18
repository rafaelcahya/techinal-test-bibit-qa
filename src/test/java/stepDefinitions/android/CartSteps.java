package stepDefinitions.android;

import io.cucumber.java.en.*;
import org.assertj.core.api.Assertions;
import pages.android.CartPage;
import pages.android.HeaderPage;
import utils.AppiumManager;

public class CartSteps {

    private HeaderPage headerPage() {
        return new HeaderPage(AppiumManager.getAndroidDriver());
    }

    private CartPage cartPage() {
        return new CartPage(AppiumManager.getAndroidDriver());
    }

    @When("I tap the cart button")
    public void iTapTheCartButton() {
        headerPage().tapCartButton();
    }

    @Then("the product should be in the cart")
    public void theProductShouldBeInTheCart() {
        Assertions.assertThat(cartPage().isDisplayed())
                .as("My Cart page should show proceed to checkout button")
                .isTrue();
    }

    @When("I tap proceed to checkout")
    public void iTapProceedToCheckout() {
        cartPage().tapProceedToCheckout();
    }
}
