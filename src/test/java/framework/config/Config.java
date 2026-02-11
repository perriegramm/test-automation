package framework.config;

import framework.driver.BrowserType;

public class Config {

    private Config() {
    }

    public static BrowserType browser() {
        return BrowserType.valueOf(ConfigReader.get("browser").trim().toUpperCase());
    }

    public static boolean headless() {
        return Boolean.parseBoolean(ConfigReader.get("headless").trim());
    }

    public static String baseUrl() {
        return ConfigReader.get("baseUrl").trim();
    }
}
