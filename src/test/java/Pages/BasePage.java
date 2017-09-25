package Pages;

import Driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Alex on 10.09.2017.
 */
public abstract class BasePage {
  protected static WebDriver driver= DriverFactory.getDriver();
   // WebDriverWait wait = new WebDriverWait(driver, 30);

   public BasePage() {
        PageFactory.initElements(driver, this);
    }
}
