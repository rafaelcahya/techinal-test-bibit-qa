package pages.android;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PaymentPage {

    private final WebDriverWait wait;

    private static final By NAME_FIELD            = By.id("com.saucelabs.mydemoapp.android:id/nameRL");
    private static final By CARD_NUMBER_FIELD     = By.id("com.saucelabs.mydemoapp.android:id/cardNumberRL");
    private static final By EXPIRATION_DATE_FIELD = By.id("com.saucelabs.mydemoapp.android:id/expirationDateRL");
    private static final By SECURITY_CODE_FIELD   = By.id("com.saucelabs.mydemoapp.android:id/securityCodeRL");
    private static final By REVIEW_ORDER_BTN      = By.id("com.saucelabs.mydemoapp.android:id/paymentBtn");

    public PaymentPage(AndroidDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void fillName(String value) {
        fillInput(NAME_FIELD, value);
    }

    public void fillCardNumber(String value) {
        fillInput(CARD_NUMBER_FIELD, value);
    }

    public void fillExpirationDate(String value) {
        fillInput(EXPIRATION_DATE_FIELD, value);
    }

    public void fillSecurityCode(String value) {
        fillInput(SECURITY_CODE_FIELD, value);
    }

    public void tapReviewOrder() {
        wait.until(ExpectedConditions.elementToBeClickable(REVIEW_ORDER_BTN)).click();
    }

    private void fillInput(By containerLocator, String value) {
        WebElement container = wait.until(ExpectedConditions.visibilityOfElementLocated(containerLocator));
        WebElement input = container.findElement(By.className("android.widget.EditText"));
        input.clear();
        input.sendKeys(value);
    }
}
