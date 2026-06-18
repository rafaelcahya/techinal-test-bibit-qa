package pages.android;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private final AndroidDriver driver;
    private final WebDriverWait wait;

    private static final By MENU_BUTTON    = By.id("com.saucelabs.mydemoapp.android:id/menuIV");
    private static final By LOGIN_NAV_ITEM = By.xpath("//android.widget.TextView[@text='Log In']");
    private static final By USERNAME_FIELD = By.id("com.saucelabs.mydemoapp.android:id/nameET");
    private static final By PASSWORD_FIELD = By.id("com.saucelabs.mydemoapp.android:id/passwordET");
    private static final By LOGIN_BUTTON   = By.id("com.saucelabs.mydemoapp.android:id/loginBtn");

    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait   = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    public void navigateToLoginPage() {
        wait.until(ExpectedConditions.elementToBeClickable(MENU_BUTTON)).click();
        wait.until(ExpectedConditions.elementToBeClickable(LOGIN_NAV_ITEM)).click();
    }

    public void enterUsername(String username) {
        WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(USERNAME_FIELD));
        field.clear();
        field.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(PASSWORD_FIELD));
        field.clear();
        field.sendKeys(password);
    }

    public void tapLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(LOGIN_BUTTON)).click();
    }
}
