package Tests;

import Pages.InputMail;
import Pages.MailPage;
import Pages.SendingMail;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static Driver.DriverFactory.driver;



/**
 * Created by Alex on 10.09.2017.
 */
public class EmailTest extends BaseTest{
    @Test
    public void testName() throws Exception {
        app.login.loginValidUser();
        String userName=app.mail.getTextUserName();
        Assert.assertEquals(userName,"Vita","Current user name "+userName+"is not correct");


    }



    @Test
    public void testSendingMail() throws Exception {
        app.login.loginValidUser();

        Date startTime= new Date();

        MailPage mailPage = new MailPage();
        mailPage.createMail();
        SendingMail sendingMail = new SendingMail();
        String textAfterSending =sendingMail.sendMail("vitakennedy@gmail.com", "testing", "Hello!");
        Assert.assertEquals(textAfterSending, "Письмо успешно отправлено адресатам");

        sendingMail.clickInputMails();

        InputMail inputMail = new InputMail();
        Date emailTime=inputMail.getMailTime();

        Assert.assertTrue(startTime.before(emailTime));
    }


    @Test
    public void testing() throws Exception {
        app.login.loginValidUser();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<WebElement> inputEmails =  driver.findElements(By.xpath("//div[@class='messages']/div/div"));

        for (int i = 0; i < inputEmails.size(); i++) {
            Date newDate = null;
            Date newestDate = null;
            //Iterator<WebElement> iter = inputEmails.iterator();
            String string = inputEmails.get(i).getText();
            String cutDate = string.substring(0, string.indexOf("\n"));

            Locale rusLocale = new Locale.Builder().setLanguage("ru").setScript("Cyrl").build();
            SimpleDateFormat validFormat = new SimpleDateFormat("dd MMM, hh:mm", rusLocale);
            SimpleDateFormat  invalidFormat = new SimpleDateFormat("hh:mm", rusLocale);
            //cal.set(Calendar.HOUR_OF_DAY, );
           if (isInValidFormat(cutDate,validFormat)) {
               newDate = validFormat.parse(cutDate);
           } else {
               SimpleDateFormat  format = new SimpleDateFormat("dd MMM", rusLocale);
               Calendar cal = Calendar.getInstance();
               cutDate = format.format(cal.getTime())+","+cutDate;
               newDate = validFormat.parse(cutDate);
                          }
                System.out.println("The date in string format is: " + newDate.toString());
            }
        }

    public boolean isInValidFormat(String dateToCheckInSting, SimpleDateFormat dateFormat) {

        try {
            dateFormat.parse(dateToCheckInSting);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

        }

