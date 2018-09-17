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
	
	@FindBy(css = "a.nav-a nav-a-2 > span.nav-line-2")
	private WebElement department;
	
	@FindBy(id = "navbar")
	private WebElement hideMenu;
	
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
		
		AmazonUtils.waitForElementToDisplay(getDriverInstance(), shopByAll);
		AmazonUtils.mouseHoover(getDriverInstance(), shopByAll);
	}
	
	public KindleSubMenuSegment mouseOverShopByAllKindle() {
		
		AmazonUtils.waitForElementToDisplay(getDriverInstance(), kindle);
		AmazonUtils.mouseHoover(getDriverInstance(), kindle);
		
		return new KindleSubMenuSegment(getDriverInstance());
	}
	
	public KindleSubMenuSegment clickKindle() {
		
		AmazonUtils.presentScrollClick(getDriverInstance(), kindle);
		return new KindleSubMenuSegment(getDriverInstance());
		
	}
	
	public boolean isShopByAllDisplayed() {
		
		AmazonUtils.waitForElementToDisplay(getDriverInstance(), shopByAll);
		return AmazonUtils.isElementDisplayed(shopByAll);
	}
	
	public boolean isKindleDisplayed() {
		
		AmazonUtils.waitForElementToDisplay(getDriverInstance(), kindle);
		return AmazonUtils.isElementDisplayed(kindle);
	}
	
	public String getShopByAllText() {
		
		return shopByAll.getText();
	}
	
	public String getShopByAllKindleText() {
		
		return kindle.getText();
	}
	
	public String getDepartmentText() {
		
		return department.getText();
	}
	
	public void hideMenu() {
		
		AmazonUtils.mouseHoover(getDriverInstance(), hideMenu);
		
	}
	
}
