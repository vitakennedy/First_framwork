package Tests;

import Helpers.App;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

/**
 * Created by Alex on 16.09.2017.
 */
public abstract class BaseTest {
    App app=new App();

    @BeforeSuite
    public void setSuite() throws Exception {

    }

   /* @AfterSuite
    public void tearDown() throws Exception {
        app.common.appOut();

    }*/
}
