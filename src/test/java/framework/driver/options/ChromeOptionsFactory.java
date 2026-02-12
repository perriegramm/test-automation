package framework.driver.options;

import framework.config.Config;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeOptionsFactory {

    private ChromeOptionsFactory() {
    }

    public static ChromeOptions create() {
        ChromeOptions options = new ChromeOptions();
        applyBaseConfiguration(options);

        if (Config.headless()) {
            options.addArguments("--headless=new");
        }

        return options;
    }

    private static void applyBaseConfiguration(ChromeOptions options) {
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--start-maximized");
    }
}
