package pages.android;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {

    private final WebDriverWait wait;

    private static final By PROCEED_TO_CHECKOUT_BTN = By.id("com.saucelabs.mydemoapp.android:id/cartBt");

    public CartPage(AndroidDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public boolean isDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(PROCEED_TO_CHECKOUT_BTN)).isDisplayed();
    }

    public void tapProceedToCheckout() {
        wait.until(ExpectedConditions.elementToBeClickable(PROCEED_TO_CHECKOUT_BTN)).click();
    }
}
