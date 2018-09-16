package com.amazon.auto.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import com.amazon.auto.superpage.PageScreen;
import com.amazon.auto.utils.AmazonUtils;

public class AmazonMainPage extends PageScreen {

	
	@FindBy(id = "nav-link-shopall")
	private WebElement shopByAll;
	
	@FindBy(xpath = "//span[text()='Kindle']")
	private WebElement kindle;
	
	/**
	 * @param driver
	 */
	public AmazonMainPage(RemoteWebDriver driver) {
		super(driver);
		
	}

	public void clickShopByAll() {
		
		shopByAll.click();
	}
	
	public void mouseOverShopByAll() {
		
		AmazonUtils.mouseHoover(getDriverInstance(), shopByAll);
	}
	
	public void clickKindle() {
		
		AmazonUtils.presentScrollClick(getDriverInstance(), kindle);
		
	}
	
}
