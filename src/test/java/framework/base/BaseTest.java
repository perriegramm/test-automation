package framework.base;

import framework.driver.DriverManager;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest {

    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        DriverManager.initDriver();
        driver = DriverManager.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(org.testng.ITestResult result) {

        if (!result.isSuccess()) {
            attachScreenshot();
            attachPageSource();
        }

        DriverManager.quitDriver();
    }

    // TODO: consider replacing @Attachment with Allure.addAttachment for better control
    @SuppressWarnings("UnusedReturnValue")
    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] attachScreenshot() {
        return ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.BYTES);
    }

    @SuppressWarnings("UnusedReturnValue")
    @Attachment(value = "Page source", type = "text/html")
    public String attachPageSource() {
        return driver.getPageSource();
    }
}
