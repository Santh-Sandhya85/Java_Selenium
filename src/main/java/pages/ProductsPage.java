package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {

    private WebDriver driver;

    private By backpack =
            By.id("add-to-cart-sauce-labs-backpack");

    private By cart =
            By.className("shopping_cart_link");

    private By menu =
            By.id("react-burger-menu-btn");

    private By logout =
            By.id("logout_sidebar_link");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addBackpack() {
        driver.findElement(backpack).click();
    }

    public void openCart() {
        driver.findElement(cart).click();
    }

    public void logout() {
        driver.findElement(menu).click();
        driver.findElement(logout).click();
    }
}