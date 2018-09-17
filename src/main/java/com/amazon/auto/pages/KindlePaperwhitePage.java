package com.amazon.auto.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.amazon.auto.superpage.PageScreen;
import com.amazon.auto.utils.AmazonUtils;

public class KindlePaperwhitePage extends PageScreen {

	
	@FindBy(id = "quantity")
	private WebElement selectQuantity;
	
	@FindBy(id = "add-to-cart-button")
	private WebElement addToCartButton;
	
	
	
	private Select dropdown;
	/**
	 * @param driver
	 */
	public KindlePaperwhitePage(RemoteWebDriver driver) {
		super(driver);
		
		dropdown = new Select(selectQuantity);
		
	}

	public void selectQuantity(String qty) {
		
		AmazonUtils.waitForElementToDisplay(getDriverInstance(), selectQuantity);
		dropdown.selectByVisibleText(qty);
	}
	
	public KindleOrderPopoverSegment clickAddToCartButton() {
		
		AmazonUtils.waitForElementToDisplay(getDriverInstance(), addToCartButton);
		addToCartButton.click();
		
		return new KindleOrderPopoverSegment(getDriverInstance());
		
	}
	
	public String getAddToCartButtonText() {
		
		return addToCartButton.getText();
	}
	
}
