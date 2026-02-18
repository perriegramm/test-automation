package tests.login;

import framework.base.BaseTest;
import framework.components.NavItem;
import framework.pages.HomePage;
import framework.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static framework.driver.DriverManager.getDriver;

@Test
public class RegisterUserTest extends BaseTest {


    public void userCanRegisterNewAccount() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.goToPageName(NavItem.LOGIN_SIGNUP);
        //goToPageName musi zwracac typ odpowiedniej strony
//        LoginPage loginPage = homePage.goToPageName(NavItem.LOGIN_SIGNUP);
//
        LoginPage loginPage = new LoginPage(getDriver());
        Assert.assertTrue(loginPage.isDisplayed(), "Login page is not displayed");


    }
}
