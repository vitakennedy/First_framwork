package Driver;

import Common.Constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.util.concurrent.TimeUnit;

import static Common.Constants.BASE_URL;

/**
 * Created by Alex on 19.09.2017.
 */
public class DriverFactory {
    public static WebDriver driver = null;

    public static WebDriver getDriver() {
        String driverName = System.getProperty("driver");
        if ("firefox".equals(driverName)) {
            System.setProperty("webdriver.gecko.driver", "driver/geckodriver.exe");
            driver = new FirefoxDriver();
        } else if ("IE".equals(driverName)) {
            System.setProperty("webdriver.ie.driver", "driver/IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        } else if ("Chrome".equals(driverName)) {
            System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
            driver = new ChromeDriver();
        } else if ("Opera".equals(driverName)) {
            System.setProperty("webdriver.opera.driver", "driver/operadriver.exe");
            driver = new OperaDriver();
        } else {
            System.setProperty("webdriver.gecko.driver", "driver/geckodriver.exe");
            driver = new FirefoxDriver();
        }
      /*  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().fullscreen();*/
        driver.get(BASE_URL);
        return driver;
    }
}
