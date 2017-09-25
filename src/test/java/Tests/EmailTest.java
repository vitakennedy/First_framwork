package Tests;

import Pages.MailPage;
import Pages.SendingMail;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Alex on 10.09.2017.
 */
public class EmailTest extends BaseTest{
    @Test(priority = 1)
    public void testName() throws Exception {
        app.login.loginValidUser();
        String userName=app.mail.getTextUserName();
        Assert.assertEquals(userName,"Vita","Current user name "+userName+"is not correct");


    }

/*    @Test
    public void testSendingMail() throws Exception {
        MailPage mailPage = new MailPage();
        SendingMail sendingMail = new SendingMail();
        String textAfterSending =sendingMail.sendMail("vitakennedy@gmail.com", "testing", "Hello!");
        Assert.assertEquals(textAfterSending, "Письмо успешно отправлено адресатам");
    }*/
}