package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    private WebDriver driver;

    private By backpack =
            By.id("item_4_title_link");

    private By checkout =
            By.id("checkout");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isBackpackDisplayed() {
        return driver.findElement(backpack).isDisplayed();
    }

    public void clickCheckout() {
        driver.findElement(checkout).click();
    }
}