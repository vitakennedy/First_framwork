package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;



/**
 * Created by Alex on 10.09.2017.
 */
public class SendingMail extends BasePage {

    @FindBy(xpath = "//span/textarea[@id='compose_to']")
    private WebElement inputTo;

    @FindBy(xpath = "//input[@name='subject']")
    private WebElement inputSubject;

    @FindBy(xpath = "//textarea[@id='compose_text']")
    private WebElement inputText;

    @FindBy(xpath = "//input[contains(@tabindex,'12')]")
    private WebElement btnCompose;

    @FindBy(xpath="//div[@class='block_confirmation']/div[@class='content clear']")
    private WebElement textSuccessfullySendMail;

    @FindBy(xpath = "//ul[@id='foldersContainer']/li[@class='current new']/a")
    private WebElement btnInputMails;

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
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       return textSuccessfullySendMail.getText();
    }
    public void clickInputMails() {
        btnInputMails.click();
    }


}
