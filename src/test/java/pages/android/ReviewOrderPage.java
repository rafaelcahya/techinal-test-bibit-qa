package pages.android;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ReviewOrderPage {

    private final WebDriverWait wait;

    private static final By PLACE_ORDER_BTN = By.id("com.saucelabs.mydemoapp.android:id/paymentBtn");

    public ReviewOrderPage(AndroidDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void tapPlaceOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(PLACE_ORDER_BTN)).click();
    }
}
