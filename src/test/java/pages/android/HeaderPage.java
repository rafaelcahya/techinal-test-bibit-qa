package pages.android;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HeaderPage {

    private final WebDriverWait wait;

    private static final By CART_BUTTON = By.id("com.saucelabs.mydemoapp.android:id/cartRL");

    public HeaderPage(AndroidDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void tapCartButton() {
        wait.until(ExpectedConditions.elementToBeClickable(CART_BUTTON)).click();
    }
}
