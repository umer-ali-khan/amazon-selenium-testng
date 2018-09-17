package com.amazon.auto.browsers;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.amazon.auto.constants.Constants;
import com.amazon.auto.utils.PropertiesManager;
import com.auto.amazon.enums.BrowserNames;

public abstract class BrowserFactory {

	protected static RemoteWebDriver mDriver;

	public static RemoteWebDriver getDriver(BrowserNames name, DesiredCapabilities cap) throws Exception {

		FirefoxOptions ff_options = new FirefoxOptions();
		
		ff_options.setHeadless(Boolean.parseBoolean(PropertiesManager.getProperty(Constants.Caps.DC_HEAD_LESS)));
		
		switch (name.toString().toUpperCase()) {

		case "FIREFOX": {

			mDriver = new FirefoxDriver(FirefoxGeckoService.getFirefoxGeckoService(), ff_options);

			break;
		}

		case "CHROME": {

			System.setProperty("webdriver.chrome.driver", "//Users//admin//Downloads//chromedriver");
			ChromeOptions ch_options = new ChromeOptions();
			ch_options.setHeadless(Boolean.parseBoolean(PropertiesManager.getProperty(Constants.Caps.DC_HEAD_LESS)));
			
			mDriver = new ChromeDriver(ch_options);
			break;
		}

		default: {

			mDriver = new FirefoxDriver(FirefoxGeckoService.getFirefoxGeckoService(), ff_options);
			break;
		}

		}
		return mDriver;

	}
}
