package ro.siit.aut.gr4.exam.test.pages;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CookiePage {


    @FindBy(how = How.ID, using = "set-cookie")
    private WebElement setTheCookieButton;

    @FindBy(how = How.ID, using = "delete-cookie")
    private WebElement removeTheCookieButton;

    @FindBy(how = How.ID, using = "cookie-value")
    private WebElement cookieValueLabel;

    public WebElement getSetTheCookieButton() {
        return setTheCookieButton;
    }

    public WebElement getRemoveTheCookieButton() {
        return removeTheCookieButton;
    }

    public WebElement getCookieValueLabel() {
        return cookieValueLabel;
    }

    public Cookie getCookieName(String name, WebDriver driver) {

        Cookie cookie = null;

        try {
            cookie = driver.manage().getCookieNamed(name);
        } catch (NullPointerException e) {
            System.out.println("Cookie not found, try another one");
        }

        return cookie;
    }

}