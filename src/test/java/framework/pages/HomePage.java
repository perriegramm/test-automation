package framework.pages;

import framework.components.NavItem;
import framework.components.NavigationBar;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {

    private WebDriver driver;
    private NavigationBar navigationBar;
    private static final String URL = "https://automationexercise.com/";

    public HomePage(WebDriver driver) {
        this.driver = driver;
        this.navigationBar = new NavigationBar(driver);
    }

    @Step("User opens home page")
    public void open() {
        driver.get(URL);
    }

    @Step("User navigates to {pageName} via navigation bar")
    public void goToPageName(NavItem pageName) {
        consentToUseData();
        navigationBar.goTo(pageName);
    }

    private void consentToUseData() {
        List<WebElement> frames = driver.findElements(By.name("googlefcPresent"));
        if (!frames.isEmpty()) {
            WebElement consentButton = driver.findElement(
                    By.xpath("//button[.='Consent']"));

            consentButton.click();
            driver.switchTo().defaultContent();
        }
    }
}
