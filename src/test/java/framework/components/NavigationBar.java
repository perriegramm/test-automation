package framework.components;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavigationBar {

    private final WebDriver driver;

    @FindBy(css = ".nav a[href='/']")
    private WebElement home;

    @FindBy(css = "a[href='/login']")
    private WebElement signupLogin;

    @FindBy(css = "a[href='/products']")
    private WebElement products;

    @FindBy(css = "a[href='/view_cart']")
    private WebElement cart;

    public NavigationBar(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @Step("User navigates to {pageName} via navigation bar")
    public void goTo(NavItem pageName) {
        switch (pageName) {
            case HOME -> home.click();
            case PRODUCTS -> products.click();
            case CART -> cart.click();
            case LOGIN_SIGNUP -> signupLogin.click();
            default -> throw new IllegalArgumentException("Unknown nav item: " + pageName);
        }
    }

}
