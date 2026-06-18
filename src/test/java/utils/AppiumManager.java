package utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class AppiumManager {

    private static final ThreadLocal<AndroidDriver> androidDriverThread = new ThreadLocal<>();

    public static AndroidDriver getAndroidDriver() {
        if (androidDriverThread.get() == null) {
            String apkPath = new File(ConfigReader.get("app.path")).getAbsolutePath();
            UiAutomator2Options options = new UiAutomator2Options()
                    .setDeviceName(ConfigReader.get("device.name"))
                    .setApp(apkPath)
                    .setAppPackage(ConfigReader.get("app.package"))
                    .setAppActivity(ConfigReader.get("app.activity"))
                    .setAutoGrantPermissions(true)
                    .setNoReset(false);
            try {
                androidDriverThread.set(new AndroidDriver(new URL(ConfigReader.get("appium.url")), options));
            } catch (MalformedURLException e) {
                throw new RuntimeException("Invalid Appium URL: " + ConfigReader.get("appium.url"), e);
            }
        }
        return androidDriverThread.get();
    }

    public static void quitAndroidDriver() {
        AndroidDriver driver = androidDriverThread.get();
        if (driver != null) {
            driver.quit();
            androidDriverThread.remove();
        }
    }
}
