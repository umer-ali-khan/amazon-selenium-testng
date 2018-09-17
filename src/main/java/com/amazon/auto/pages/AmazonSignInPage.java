package com.amazon.auto.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import com.amazon.auto.superpage.PageScreen;
import com.amazon.auto.utils.AmazonUtils;


public class AmazonSignInPage extends PageScreen {
	
	@FindBy(id = "ap_email")
	private WebElement signInEmail;
	
	@FindBy(id = "continue")
	private WebElement continueButton;
	
	@FindBy(xpath = "//*[contains(@class, 'a-form-label')]")
	private WebElement emailOrPhoneLabel;
	
	
	public static final String EMAIL_OR_PHONE_LABEL = "E-mail address or mobile phone number";
	
	/**
	 * @param driver
	 */
	public AmazonSignInPage(RemoteWebDriver driver) {
		super(driver);
		
	}

	public String getEmailOrPhoneLabel() {
		
		return emailOrPhoneLabel.getText();
	}
	
	public boolean isSignInEmailFieldDisplayed() {
		
		return AmazonUtils.isElementDisplayed(signInEmail);
	}
	
}
