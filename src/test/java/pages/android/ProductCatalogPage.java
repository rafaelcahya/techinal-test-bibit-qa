package pages.android;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ProductCatalogPage {

    private final AndroidDriver driver;
    private final WebDriverWait wait;

    private static final By PRODUCT_TITLE = By.id("com.saucelabs.mydemoapp.android:id/productTV");
    private static final By PRODUCT_RV    = By.id("com.saucelabs.mydemoapp.android:id/productRV");
    private static final By SORT_BUTTON   = By.id("com.saucelabs.mydemoapp.android:id/sortIV");

    public ProductCatalogPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait   = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public boolean isDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(PRODUCT_TITLE)).isDisplayed();
    }

    public void sortProducts(String field, String order) {
        wait.until(ExpectedConditions.elementToBeClickable(SORT_BUTTON)).click();
        By option = By.xpath("//android.widget.TextView[@text='" + field + " - " + order + "']");
        wait.until(ExpectedConditions.elementToBeClickable(option)).click();
    }

    public void tapProduct(String productName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(PRODUCT_RV));

        try {
            driver.findElement(AppiumBy.androidUIAutomator(
                    "new UiScrollable(new UiSelector()" +
                    ".resourceId(\"com.saucelabs.mydemoapp.android:id/productRV\"))" +
                    ".scrollIntoView(new UiSelector().textContains(\"" + productName + "\"))"));
        } catch (Exception ignored) {}

        By productCard = By.xpath(
                "//android.widget.TextView[contains(@text,'" + productName + "')]/..");
        wait.until(ExpectedConditions.elementToBeClickable(productCard)).click();
    }
}
