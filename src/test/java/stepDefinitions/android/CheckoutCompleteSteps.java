package stepDefinitions.android;

import io.cucumber.java.en.*;
import org.assertj.core.api.Assertions;
import pages.android.CheckoutCompletePage;
import utils.AppiumManager;

public class CheckoutCompleteSteps {

    private CheckoutCompletePage checkoutCompletePage() {
        return new CheckoutCompletePage(AppiumManager.getAndroidDriver());
    }

    @Then("I should see checkout complete")
    public void iShouldSeeCheckoutComplete() {
        Assertions.assertThat(checkoutCompletePage().isCheckoutComplete())
                .as("Checkout Complete text should be displayed")
                .isTrue();
    }
}
