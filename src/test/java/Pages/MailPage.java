package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Alex on 10.09.2017.
 */
public class MailPage extends BasePage {

    @FindBy(xpath="//span[contains(.,'Vita')]")
    private WebElement textUserName;

   @FindBy(xpath="//p[@class='make_message']/a")
   private WebElement btnCreateEmail;

    public String getTextUserName(){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return textUserName.getText();
    }

    public void createMail() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        btnCreateEmail.click();
    }

}
