package com.amazon.auto.supertest;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.amazon.auto.browsers.BrowserFactory;
import com.amazon.auto.constants.Constants;
import com.amazon.auto.utils.PropertiesManager;
import com.auto.amazon.enums.BrowserNames;

/**
 * Year: 2018-19
 *
 * @author Umar Khan
 * 
 */

public abstract class AmazonSuperTest {

	private static RemoteWebDriver webDriver;

	private final static DesiredCapabilities capabilities = new DesiredCapabilities();

	private final static int IMPLICIT_WAIT = 30;

	private Properties properties = new Properties();
	private String browserType;

	@BeforeClass
	public void initialTestSetUp() throws Exception {

		properties = PropertiesManager.getProperties();

		browserType = properties.getProperty(Constants.Caps.DC_BROWSER_NAME);	
		
		setCapabilities();
		
		try {

			if (webDriver == null) {

				webDriver = (RemoteWebDriver) BrowserFactory.getDriver(getBrowserTypeEnumValue(browserType), capabilities);

			}
		} catch (Exception e) {

			System.out.println(
					"Web Driver is not created..!, Please check capabilities.");
		}


	}
	

	public static RemoteWebDriver getDriver() {

		return webDriver;
	}

	public static WebDriver getScreenshotableWebDriver() {
		final WebDriver augmentedDriver = new Augmenter().augment(getDriver());
		return augmentedDriver;
	}

	public static DesiredCapabilities getCapabilities() {
		return capabilities;
	}

	@AfterClass
	public void closeTests() {

		if (getDriver() != null) {
			getDriver().quit();

		}

	}

	// private methods


	private BrowserNames getBrowserTypeEnumValue(String browser) {

		BrowserNames type = null;

		for (BrowserNames b : BrowserNames.values()) {

			if (b.toString().equalsIgnoreCase(browser)) {
				type = b;
				break;
			}

		}

		return type;

	}

	private void setCapabilities() throws Exception {

		capabilities.setAcceptInsecureCerts(Boolean.parseBoolean(properties.getProperty(Constants.Caps.DC_ACCEPT_SSL_CERTS)));
		capabilities.setCapability("browserName", properties.getProperty(Constants.Caps.DC_BROWSER_NAME));
		capabilities.setCapability("platform", properties.getProperty(Constants.Caps.DC_BROWSER_PLATFORM));
		capabilities.setCapability("version", properties.getProperty(Constants.Caps.DC_BROWSER_VERSION));
		capabilities.setCapability("cssSelectorsEnabled",
				Boolean.parseBoolean(properties.getProperty(Constants.Caps.DC_CSS_SELECTORS)));
		capabilities.setCapability("headless", Boolean.parseBoolean(properties.getProperty(Constants.Caps.DC_HEAD_LESS)));
		capabilities.setCapability("timeoutInSeconds", IMPLICIT_WAIT);

	}

}
