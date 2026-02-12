package smoke;

import framework.base.BaseTest;
import framework.config.Config;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SmokeTest extends BaseTest {

    @Test
    public void shouldOpenBaseURL(){

        driver.get(Config.baseUrl());

        String currentURL = driver.getCurrentUrl();

        Assert.assertTrue(
                currentURL.contains(Config.baseUrl()),
                "Current URL does not contain baseUrl"
        );
    }
}
