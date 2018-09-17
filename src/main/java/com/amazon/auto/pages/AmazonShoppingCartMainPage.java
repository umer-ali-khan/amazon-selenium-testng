package com.amazon.auto.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import com.amazon.auto.superpage.PageScreen;


public class AmazonShoppingCartMainPage extends PageScreen {
	
	@FindBy(xpath = "//*[contains(@class, 'checkout-button')]")
	private WebElement proceedToCheckOutButton;
	
	/**
	 * @param driver
	 */
	public AmazonShoppingCartMainPage(RemoteWebDriver driver) {
		super(driver);
		
	}

	public String getProceedToCheckOutButtonText() {
		
		return proceedToCheckOutButton.getText();
	}
	
	public AmazonSignInPage clickProceedToCheckOutButton() {
		
		 proceedToCheckOutButton.click();
		 
		 return new AmazonSignInPage(getDriverInstance());
	}
	
}
