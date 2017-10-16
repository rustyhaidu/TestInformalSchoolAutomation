package ro.siit.aut.gr4.exam.test.functional;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ro.siit.aut.gr4.exam.test.browsers.Browsers;
import ro.siit.aut.gr4.exam.test.browsers.WebBrowser;
import ro.siit.aut.gr4.exam.test.pages.CookiePage;

import java.util.concurrent.TimeUnit;

public class Solution3Test extends BaseTest {

    private CookiePage cookiePage;


    @BeforeMethod
    public void setUpCookies() {
        driver = WebBrowser.getDriver(Browsers.CHROME);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


        driver.get("http://ec2-35-159-5-67.eu-central-1.compute.amazonaws.com/cookie.html");
        driver.manage().deleteAllCookies();
        cookiePage = PageFactory.initElements(driver, CookiePage.class);

    }

    @Test
    public void click20TimesTest() {
        cookiePage.getSetTheCookieButton().click();

        String previousCookieName = "";
        boolean cookieValuesAreEqual = false;
        String firstCookie = cookiePage.getCookieValueLabel().getText();
        System.out.println(firstCookie);
        for (int i = 0; i < 20; i++) {

            cookiePage.getSetTheCookieButton().click();
            String cookieValue = cookiePage.getCookieValueLabel().getText();
            if (i == 0) {
                previousCookieName = firstCookie;
            }

            if (previousCookieName.equals(cookieValue)) {
                cookieValuesAreEqual = true;
            }
            System.out.println("\"Previous:\"" + previousCookieName + " \"Current:\"" + cookieValue);
            Assert.assertFalse(cookieValuesAreEqual);
            previousCookieName = cookieValue;
        }
    }
}
