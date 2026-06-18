package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.AppiumManager;
import utils.DriverManager;

public class Hooks {

    @Before(order = 1)
    public void setUp(Scenario scenario) {
        System.out.println("Starting scenario: " + scenario.getName());
    }

    @After(order = 1)
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            System.out.println("Scenario FAILED: " + scenario.getName());
        }
        DriverManager.quitDriver();
        AppiumManager.quitAndroidDriver();
    }
}
