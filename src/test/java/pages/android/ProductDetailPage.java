package pages.android;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class ProductDetailPage {

    private final AndroidDriver driver;
    private final WebDriverWait wait;

    private static final By COLOR_RV         = By.id("com.saucelabs.mydemoapp.android:id/colorRV");
    private static final By MINUS_BUTTON     = By.id("com.saucelabs.mydemoapp.android:id/minusIV");
    private static final By PLUS_BUTTON      = By.id("com.saucelabs.mydemoapp.android:id/plusIV");
    private static final By QUANTITY_DISPLAY = By.id("com.saucelabs.mydemoapp.android:id/noTV");
    private static final By ADD_TO_CART_BTN  = By.id("com.saucelabs.mydemoapp.android:id/cartBt");

    // color order inside colorRV: Black=0, Blue=1, Gray=2, Green=3
    private static final Map<String, Integer> COLOR_INDEX = Map.of(
            "Black", 0,
            "Blue",  1,
            "Gray",  2,
            "Green", 3
    );

    public ProductDetailPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait   = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void selectColor(String color) {
        WebElement colorRV = wait.until(ExpectedConditions.visibilityOfElementLocated(COLOR_RV));

        int index = COLOR_INDEX.getOrDefault(color, 1);
        List<WebElement> colorItems = colorRV.findElements(
                By.className("android.view.ViewGroup"));
        colorItems.get(index).click();
    }

    public void setQuantity(int target) {
        WebElement display = wait.until(ExpectedConditions.visibilityOfElementLocated(QUANTITY_DISPLAY));
        int current = Integer.parseInt(display.getText().trim());
        while (current < target) {
            wait.until(ExpectedConditions.elementToBeClickable(PLUS_BUTTON)).click();
            current++;
        }
        while (current > target) {
            wait.until(ExpectedConditions.elementToBeClickable(MINUS_BUTTON)).click();
            current--;
        }
    }

    public void addToCart() {
        wait.until(ExpectedConditions.elementToBeClickable(ADD_TO_CART_BTN)).click();
    }
}
