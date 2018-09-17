package com.amazon.auto.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import com.amazon.auto.superpage.PageScreen;
import com.amazon.auto.utils.AmazonUtils;

public class KindleSubMenuSegment extends PageScreen {

	
	@FindBy(xpath = "//span[text()='Kindle Paperwhite']")
	private WebElement kindlePaperwhite;
	
	/**
	 * @param driver
	 */
	public KindleSubMenuSegment(RemoteWebDriver driver) {
		super(driver);
		
	}

	public KindlePaperwhitePage clickKindlePaperWhite() {
		
		AmazonUtils.waitForElementToDisplay(getDriverInstance(), kindlePaperwhite);
		kindlePaperwhite.click();
		
		
		return new KindlePaperwhitePage(getDriverInstance());
	}
	
	public boolean isKindlePaperwhiteDisplayed() {
		
		AmazonUtils.waitForElementToDisplay(getDriverInstance(), kindlePaperwhite);
		return AmazonUtils.isElementDisplayed(kindlePaperwhite);
	}
	
	public String getKindlePaperwhiteText() {
		
		return kindlePaperwhite.getText();
	}
	
}
