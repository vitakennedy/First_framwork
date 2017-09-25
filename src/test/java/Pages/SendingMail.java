package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



/**
 * Created by Alex on 10.09.2017.
 */
public class SendingMail extends BasePage {

    @FindBy(xpath = "//textarea[@id='compose_to']")
    private WebElement inputTo;

    @FindBy(xpath = "//input[@name='subject']")
    private WebElement inputSubject;

    @FindBy(xpath = "//textarea[@id='compose_text']")
    private WebElement inputText;

    @FindBy(xpath = "//input[contains(@tabindex,'12')]")
    private WebElement btnCompose;

    @FindBy(xpath="//div[contains(.,'Письмо успешно отправлено адресатам')]")
    private WebElement textSuccessfullySendMail;


    public String sendMail(String email, String subject, String text) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        inputTo.sendKeys(email);
        inputSubject.sendKeys(subject);
        inputText.sendKeys(text);
        btnCompose.click();
       return textSuccessfullySendMail.getText();
    }



}
