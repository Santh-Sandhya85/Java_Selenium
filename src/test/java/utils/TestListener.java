package utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    private static final DateTimeFormatter FILE_TIMESTAMP =
            DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");

    @Override
    public void onTestFailure(ITestResult result) {
        if (DriverFactory.getDriver() == null) {
            return;
        }

        Path screenshotDirectory = Paths.get("screenshots");
        String fileName = "failed_" + result.getMethod().getMethodName() + "_"
                + LocalDateTime.now().format(FILE_TIMESTAMP) + ".png";

        try {
            Files.createDirectories(screenshotDirectory);
            byte[] screenshot = ((TakesScreenshot) DriverFactory.getDriver())
                    .getScreenshotAs(OutputType.BYTES);
            Files.write(screenshotDirectory.resolve(fileName), screenshot);
        } catch (IOException | RuntimeException exception) {
            System.err.println("Could not save failure screenshot: " + exception.getMessage());
        }
    }
}
