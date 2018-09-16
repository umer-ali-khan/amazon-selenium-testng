package com.amazon.auto.superpage;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.DefaultElementLocatorFactory;


public abstract class PageScreen {

	protected RemoteWebDriver mDriver;

	public PageScreen(RemoteWebDriver driver) {

		this.mDriver = driver;
		this.initializeScreenElements();

	}

	protected void initializeScreenElements() {

		DefaultElementLocatorFactory decorator = new DefaultElementLocatorFactory(mDriver);

		PageFactory.initElements(decorator, this);

	}

	public RemoteWebDriver getDriverInstance() {

		return mDriver;
	}

}
