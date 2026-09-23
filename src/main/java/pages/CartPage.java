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

    public String getProductName() {
        return driver.findElement(backpack).getText();
    }

    public void clickCheckout() {
        driver.findElement(checkout).click();
    }

    public boolean isCheckoutPageDisplayed() {
        return driver.getCurrentUrl().contains("checkout-step-one");
    }
}