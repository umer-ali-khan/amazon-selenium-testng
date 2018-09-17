package com.amazon.auto.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import com.amazon.auto.superpage.PageScreen;
import com.amazon.auto.utils.AmazonUtils;

public class KindleOrderPopoverSegment extends PageScreen {

	@FindBy(css = ".a-popover-header-content")
	private WebElement kindleOrderPopupHeaderTitle;
	
	@FindBy(css = ".a-popover-wrapper")
	private WebElement popoverDetails;
	
	@FindBy(xpath = "//a[contains(text(),'Amazon Kindle Paperwhite')]")
	private WebElement popoverTitle;
	
	@FindBy(xpath = "//*[contains(text(), 'CDN')]")
	private WebElement popoverPrice;
	
	@FindBy(xpath = "//*[contains(text(), 'Price:')]")
	private WebElement popoverPriceLabel;
	
	@FindBy(xpath = "//*[contains(@id, 'intl_pop_addToOrder')]")
	private WebElement kindleOrderPopupAddToOrderButton;
	
	/**
	 * @param driver
	 */
	public KindleOrderPopoverSegment(RemoteWebDriver driver) {
		super(driver);
		
	}

	public String getOrderPopupHeaderTitleText() {
		
		return kindleOrderPopupHeaderTitle.getText();
	}
	
	public String getOrderPopupOrderTitleText() {
		
		return popoverTitle.getText();
		
	}
	
	public String getOrderPopupPriceLabelText() {
		
		return popoverPriceLabel.getText();
		
	}
	
	public String getOrderPopupPrice() {
		
		return popoverPrice.getText();
		
	}
	
	public AmazonShoppingCartMainPage clickAddToOrderButton() {
		AmazonUtils.waitForElementToDisplay(getDriverInstance(), kindleOrderPopupAddToOrderButton);
		kindleOrderPopupAddToOrderButton.click();
		
		return new AmazonShoppingCartMainPage(getDriverInstance());
	}
	
	
}
