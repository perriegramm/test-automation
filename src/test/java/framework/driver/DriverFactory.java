package framework.driver;

import framework.driver.options.ChromeOptionsFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    private DriverFactory() {
        // utility class
    }

    public static WebDriver createDriver(BrowserType browserType) {
        return switch (browserType) {
            case CHROME -> {
                WebDriverManager.chromedriver().setup();
                yield new ChromeDriver(ChromeOptionsFactory.createDefault());
            }
            case FIREFOX -> throw new UnsupportedOperationException("Firefox not implemented yet");
            default -> throw new IllegalArgumentException("Unsupported browser type: " + browserType);
        };
    }
}
