package pages.android;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutCompletePage {

    private final WebDriverWait wait;

    private static final By COMPLETE_TEXT = By.id("com.saucelabs.mydemoapp.android:id/completeTV");

    public CheckoutCompletePage(AndroidDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public boolean isCheckoutComplete() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(COMPLETE_TEXT));
        return element.isDisplayed() && element.getText().contains("Checkout Complete");
    }
}
