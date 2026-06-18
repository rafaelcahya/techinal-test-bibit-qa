package stepDefinitions.android;

import io.cucumber.java.en.*;
import pages.android.ShippingAddressPage;
import utils.AppiumManager;

public class ShippingAddressSteps {

    private ShippingAddressPage shippingAddressPage() {
        return new ShippingAddressPage(AppiumManager.getAndroidDriver());
    }

    @When("I fill full name with {string}")
    public void iFillFullNameWith(String value) {
        shippingAddressPage().fillFullName(value);
    }

    @When("I fill address with {string}")
    public void iFillAddressWith(String value) {
        shippingAddressPage().fillAddress(value);
    }

    @When("I fill city with {string}")
    public void iFillCityWith(String value) {
        shippingAddressPage().fillCity(value);
    }

    @When("I fill zip code with {string}")
    public void iFillZipCodeWith(String value) {
        shippingAddressPage().fillZipCode(value);
    }

    @When("I fill country with {string}")
    public void iFillCountryWith(String value) {
        shippingAddressPage().fillCountry(value);
    }

    @When("I tap to payment button")
    public void iTapToPaymentButton() {
        shippingAddressPage().tapToPayment();
    }
}
