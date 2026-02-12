package tests.smoke;

import framework.base.BaseTest;
import framework.config.Config;
import org.testng.Assert;
import org.testng.annotations.Test;

import static framework.meta.TestGroups.LOGIN;

@Test(groups = LOGIN)
public class BaseUrlTests extends BaseTest {

    @Test(description = "Verify that base URL loads successfully")
    public void shouldOpenBaseURL() {
        driver.get(Config.baseUrl());
        String currentURL = driver.getCurrentUrl();
        Assert.assertTrue(
                currentURL.contains(Config.baseUrl()),
                "Current URL does not contain baseUrl"
        );
    }
}
