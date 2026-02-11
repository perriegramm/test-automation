package framework.driver;

import framework.config.Config;
import org.openqa.selenium.WebDriver;

public class DriverManager {

    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal<>();

    private DriverManager() {
    }

    public static WebDriver getDriver() {
        WebDriver driver = DRIVER.get();
        if (driver == null) {
            throw new IllegalStateException("WebDriver is not initialized. Call DriverManager.initDriver(...) first.");
        }
        return driver;
    }

    public static void initDriver() {
        initDriver(Config.browser());
    }

    public static void initDriver(BrowserType browserType) {
        if (DRIVER.get() != null) {
            return;
        }
        DRIVER.set(DriverFactory.createDriver(browserType));
    }

    public static void quitDriver() {
        WebDriver driver = DRIVER.get();
        if (driver != null) {
            try {
                driver.quit();
            } finally {
                DRIVER.remove();
            }
        }
    }
}
