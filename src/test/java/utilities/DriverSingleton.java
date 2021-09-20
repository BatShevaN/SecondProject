package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utilities.XMLReader;

public class DriverSingleton {
    private static WebDriver driver;

    public static WebDriver getDriverInstance() throws Exception {
        if (driver != null) {
            return getDriver();
        }
        if (XMLReader.getData("browserType").equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else {
            driver = new FirefoxDriver();
        }
        return driver;
    }

    private static WebDriver getDriver() {
        return driver;
    }
}

