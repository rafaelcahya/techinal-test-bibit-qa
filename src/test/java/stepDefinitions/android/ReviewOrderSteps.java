package stepDefinitions.android;

import io.cucumber.java.en.*;
import pages.android.ReviewOrderPage;
import utils.AppiumManager;

public class ReviewOrderSteps {

    private ReviewOrderPage reviewOrderPage() {
        return new ReviewOrderPage(AppiumManager.getAndroidDriver());
    }

    @When("I tap place order button")
    public void iTapPlaceOrderButton() {
        reviewOrderPage().tapPlaceOrder();
    }
}
