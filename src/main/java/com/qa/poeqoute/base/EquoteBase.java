package com.qa.poeqoute.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.qa.poequote.utilities.TestUtil;
import com.qa.poequote.utilities.WebEventListener;

public class EquoteBase {

	public static WebDriver driver;
	public static Properties prop;
	public static FileInputStream fis;
	public static EventFiringWebDriver e_driver;
	public static WebDriverEventListener e_listener;

	public EquoteBase() throws IOException {

		String path = System.getProperty("user.dir");
		fis = new FileInputStream(path + "\\src\\main\\java\\com\\qa\\poequote\\properties\\data.properties");
		prop = new Properties();
		prop.load(fis);

	}

	public static void intialize() throws IOException {

		if (driver == null) {

			if (prop.getProperty("browser").trim().equalsIgnoreCase("chrome")) {

				String path = System.getProperty("user.dir");

				System.setProperty("webdriver.chrome.driver",
						path + "\\src\\main\\java\\com\\qa\\poequote\\drivers\\chromedriver.exe");

				DesiredCapabilities capabilities = DesiredCapabilities.chrome();
				capabilities.setCapability(CapabilityType.ForSeleniumServer.ENSURING_CLEAN_SESSION, true);

				ChromeOptions options = new ChromeOptions();
				options.merge(capabilities);

				driver = new ChromeDriver();

			}

			else if (prop.getProperty("browser").equalsIgnoreCase("FF")) {

				String path = System.getProperty("user.dir");

				System.setProperty("webdriver.gecko.driver",
						path + "\\src\\main\\java\\com\\qa\\poequote\\drivers\\geckodriver.exe");

				driver = new FirefoxDriver();

			}

			else if (prop.getProperty("browser").trim().equalsIgnoreCase("IE")) {

				System.err.println("Not a valid browser");

			}

		}

		e_driver = new EventFiringWebDriver(driver);
		e_listener = new WebEventListener();
		e_driver.register(e_listener);

		driver = e_driver;

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url").trim());

	}

}
