package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;
import utils.TestConfig;
import utils.DriverFactory;

public class CartTest extends BaseTest {

    @Test
    public void addProductToCartTest() {

        LoginPage loginPage =
                new LoginPage(DriverFactory.getDriver());

        loginPage.login(
                TestConfig.get("SAUCE_USERNAME"),
                TestConfig.get("SAUCE_PASSWORD")
        );

        ProductsPage productsPage =
                new ProductsPage(DriverFactory.getDriver());

        productsPage.addBackpack();
        productsPage.openCart();

        Assert.assertTrue(
                DriverFactory.getDriver()
                        .getCurrentUrl()
                        .contains("cart")
        );

        CartPage cartPage =
                new CartPage(DriverFactory.getDriver());

        Assert.assertTrue(
                cartPage.isBackpackDisplayed()
        );
    }
}