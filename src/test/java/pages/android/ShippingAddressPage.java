package pages.android;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ShippingAddressPage {

    private final WebDriverWait wait;

    private static final By FULL_NAME_FIELD  = By.id("com.saucelabs.mydemoapp.android:id/fullNameRL");
    private static final By ADDRESS_FIELD    = By.id("com.saucelabs.mydemoapp.android:id/address1RL");
    private static final By CITY_FIELD       = By.id("com.saucelabs.mydemoapp.android:id/cityRL");
    private static final By ZIP_FIELD        = By.id("com.saucelabs.mydemoapp.android:id/zipRL");
    private static final By COUNTRY_FIELD    = By.id("com.saucelabs.mydemoapp.android:id/countryRL");
    private static final By TO_PAYMENT_BTN   = By.id("com.saucelabs.mydemoapp.android:id/paymentBtn");

    public ShippingAddressPage(AndroidDriver driver) {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void fillFullName(String value) {
        fillInput(FULL_NAME_FIELD, value);
    }

    public void fillAddress(String value) {
        fillInput(ADDRESS_FIELD, value);
    }

    public void fillCity(String value) {
        fillInput(CITY_FIELD, value);
    }

    public void fillZipCode(String value) {
        fillInput(ZIP_FIELD, value);
    }

    public void fillCountry(String value) {
        fillInput(COUNTRY_FIELD, value);
    }

    public void tapToPayment() {
        wait.until(ExpectedConditions.elementToBeClickable(TO_PAYMENT_BTN)).click();
    }

    private void fillInput(By containerLocator, String value) {
        WebElement container = wait.until(ExpectedConditions.visibilityOfElementLocated(containerLocator));
        WebElement input = container.findElement(By.className("android.widget.EditText"));
        input.clear();
        input.sendKeys(value);
    }
}
