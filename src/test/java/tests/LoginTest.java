package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.DriverFactory;
import utils.TestConfig;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {

        LoginPage loginPage =
                new LoginPage(DriverFactory.getDriver());

        loginPage.login(
                TestConfig.get("SAUCE_USERNAME"),
                TestConfig.get("SAUCE_PASSWORD")
        );

        Assert.assertTrue(
                DriverFactory.getDriver()
                        .getCurrentUrl()
                        .contains("inventory")
        );
    }

    @DataProvider(name = "invalidLoginData")
    public Object[][] invalidLoginData() {

        return new Object[][] {
                {"invalid_user", "secret_sauce", "Username and password do not match"},
                {"locked_out_user", "secret_sauce", "Sorry, this user has been locked out"}
        };
    }

    @Test(dataProvider = "invalidLoginData")
    public void invalidLoginTest(
            String username,
            String password,
            String expectedError) {

        LoginPage loginPage =
                new LoginPage(DriverFactory.getDriver());

        loginPage.login(username, password);

        Assert.assertTrue(
                loginPage.getErrorMessage()
                        .contains(expectedError)
        );
    }
}