package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.DriverFactory;

public class LoginTest extends BaseTest {

    @Test
    public void validLoginTest() {

        LoginPage loginPage =
                new LoginPage(DriverFactory.getDriver());

        loginPage.login(
                "REMOVED_USERNAME",
                "REMOVED_PASSWORD"
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
                {"REMOVED_INVALID_USERNAME", "REMOVED_INVALID_PASSWORD"},
                {"REMOVED_USERNAME", "REMOVED_INVALID_PASSWORD"}
        };
    }

    @Test(dataProvider = "invalidLoginData")
    public void invalidLoginTest(
            String username,
            String password) {

        LoginPage loginPage =
                new LoginPage(DriverFactory.getDriver());

        loginPage.login(username, password);

        Assert.assertTrue(
                loginPage.getErrorMessage()
                        .contains("Username and password do not match")
        );
    }
}