package framework.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(xpath = "//h2[text()='Login to your account']")
    private WebElement loginHeader;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @Step("Verify user is on login sign-up page")
    public boolean isDisplayed() {
        return loginHeader.isDisplayed();
    }
}
