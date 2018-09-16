package com.amazon.auto.browsers;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.auto.amazon.enums.BrowserNames;

public abstract class BrowserFactory {

	protected static RemoteWebDriver mDriver;

	public static RemoteWebDriver getDriver(BrowserNames name, DesiredCapabilities cap) {

		FirefoxOptions ff_options = new FirefoxOptions();
		
		switch (name.toString()) {

		case "FIREFOX": {

			mDriver = new FirefoxDriver(FirefoxGeckoService.getFirefoxGeckoService(), ff_options);

			break;
		}

		case "CHROME": {

			ChromeOptions ch_options = new ChromeOptions();
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
