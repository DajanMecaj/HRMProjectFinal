package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class BaseInformation {
    private static WebDriver driver;

    public BaseInformation() {
    }

    public static BaseInformation getBaseInformation() {
        return new BaseInformation();
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            switch (ConfigurationReader.getProperty("browser")) {
                case "chrome":
                    System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    System.setProperty("", "");
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10L, TimeUnit.SECONDS);
            }
        }

        return driver;
    }

    public static void quit() {
        driver.quit();
    }
}

