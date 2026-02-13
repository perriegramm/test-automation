package framework.pages;

import framework.components.NavigationBar;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private WebDriver driver;
    private NavigationBar navigationBar;
    private static final String URL = "https://automationexercise.com/";

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("User opens home page")
    public void open() {
        driver.get(URL);
    }



}
