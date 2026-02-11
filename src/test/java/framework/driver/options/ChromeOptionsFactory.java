package framework.driver.options;

import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeOptionsFactory {

    private ChromeOptionsFactory() {
    }

    public static ChromeOptions createDefault() {
        ChromeOptions options = new ChromeOptions();
        applyBaseConfiguration(options);
        return options;
    }

    public static ChromeOptions createHeadless() {
        ChromeOptions options = new ChromeOptions();
        applyBaseConfiguration(options);
        options.addArguments("--headless=new");
        return options;
    }

    private static void applyBaseConfiguration(ChromeOptions options) {
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--start-maximized");
    }
}
