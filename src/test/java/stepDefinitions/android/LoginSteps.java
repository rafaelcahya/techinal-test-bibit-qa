package stepDefinitions.android;

import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.*;
import org.assertj.core.api.Assertions;
import pages.android.LoginPage;
import pages.android.ProductCatalogPage;
import utils.AppiumManager;

public class LoginSteps {

    private AndroidDriver driver;
    private LoginPage loginPage;
    private ProductCatalogPage productCatalogPage;

    @Given("the app is launched")
    public void theAppIsLaunched() {
        driver             = AppiumManager.getAndroidDriver();
        loginPage          = new LoginPage(driver);
        productCatalogPage = new ProductCatalogPage(driver);
    }

    @When("I navigate to the login page")
    public void iNavigateToTheLoginPage() {
        loginPage.navigateToLoginPage();
    }

    @When("I enter {string} in the username field")
    public void iEnterInTheUsernameField(String username) {
        loginPage.enterUsername(username);
    }

    @When("I enter {string} in the password field")
    public void iEnterInThePasswordField(String password) {
        loginPage.enterPassword(password);
    }

    @When("I tap the login button")
    public void iTapTheLoginButton() {
        loginPage.tapLoginButton();
    }

    @Then("I should be logged in successfully")
    public void iShouldBeLoggedInSuccessfully() {
        Assertions.assertThat(productCatalogPage.isDisplayed())
                .as("Product catalog should be visible after successful login")
                .isTrue();
    }
}
