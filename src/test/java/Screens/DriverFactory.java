package Screens;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
    private static WebDriver driver;

    public static WebDriver getDriverInstance() throws Exception {
        if (driver != null) {
            return getDriver();
        }
        if (BuyMeTest.getData("browserType").equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else {
            driver = new ChromeDriver();
        }
        return driver;
    }

    private static WebDriver getDriver() {
        return driver;
    }
}

