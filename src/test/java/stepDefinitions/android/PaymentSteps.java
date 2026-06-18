package stepDefinitions.android;

import io.cucumber.java.en.*;
import pages.android.PaymentPage;
import utils.AppiumManager;

public class PaymentSteps {

    private PaymentPage paymentPage() {
        return new PaymentPage(AppiumManager.getAndroidDriver());
    }

    @When("I fill payment name with {string}")
    public void iFillPaymentNameWith(String value) {
        paymentPage().fillName(value);
    }

    @When("I fill card number with {string}")
    public void iFillCardNumberWith(String value) {
        paymentPage().fillCardNumber(value);
    }

    @When("I fill expiration date with {string}")
    public void iFillExpirationDateWith(String value) {
        paymentPage().fillExpirationDate(value);
    }

    @When("I fill security code with {string}")
    public void iFillSecurityCodeWith(String value) {
        paymentPage().fillSecurityCode(value);
    }

    @When("I tap review order button")
    public void iTapReviewOrderButton() {
        paymentPage().tapReviewOrder();
    }
}
