package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import utils.DriverFactory;
import utils.TestListener;

@Listeners(TestListener.class)
public class BaseTest {

    @BeforeMethod
    public void setUp() {
        DriverFactory.startDriver();
        DriverFactory.getDriver().get("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void tearDown() {
        try {
            Thread.sleep(Long.parseLong(System.getProperty("test.pause.ms", "1000")));
        } catch (InterruptedException exception) {
            Thread.currentThread().interrupt();
        }
        DriverFactory.quitDriver();
    }
}