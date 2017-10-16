package ro.siit.aut.gr4.exam.test.browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;


public class WebBrowser {

	public static WebDriver getDriver(String browserName) {
		return getDriver(Browsers.valueOf(browserName));
	}

	public static WebDriver getDriver(Browsers browser) {
		WebDriver driver;

		switch (browser) {
			case CHROME:
				System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("test-type");
				chromeOptions.addArguments("start-maximized");

				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);

				driver = new ChromeDriver(capabilities);
				break;
			case FIREFOX:
				System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
				driver = new FirefoxDriver();
				break;
			case IE:
				System.setProperty("webdriver.ie.driver", "src/test/resources/drivers/IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				break;
			default:
				throw new RuntimeException("Unknown browser: " + browser.toString());

		}

		return driver;
	}
}
