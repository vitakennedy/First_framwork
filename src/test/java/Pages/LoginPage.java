package Pages;

/**
 * Created by Alex on 10.09.2017.
 */

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends BasePage {
    @FindBy(xpath = "//input[@name='login']")
    private WebElement inputLogin;

    @FindBy(xpath = "//input[@name='pass']")
    private WebElement inputPassword;

    @FindBy(xpath = "//input[contains(@tabindex,'5')]")
    private WebElement btnLogin;


    protected void login(String name, String password) {
        inputLogin.sendKeys(name);
        inputPassword.sendKeys(password);
        btnLogin.click();
    }
}
