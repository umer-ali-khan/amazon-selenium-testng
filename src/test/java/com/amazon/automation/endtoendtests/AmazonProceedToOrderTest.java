package com.amazon.automation.endtoendtests;


import org.testng.Assert;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

import com.amazon.auto.constants.Constants;
import com.amazon.auto.pages.AmazonMainPage;
import com.amazon.auto.pages.AmazonShoppingCartMainPage;
import com.amazon.auto.pages.AmazonSignInPage;
import com.amazon.auto.pages.KindleOrderPopoverSegment;
import com.amazon.auto.pages.KindlePaperwhitePage;
import com.amazon.auto.pages.KindleSubMenuSegment;
import com.amazon.auto.supertest.AmazonSuperTest;
import com.amazon.auto.utils.PropertiesManager;


public class AmazonProceedToOrderTest extends AmazonSuperTest {

	KindlePaperwhitePage kindle;
	
	@BeforeClass
	public void openKindlePaperwhitePage() throws Exception {
		
		AmazonSuperTest.setDriver(PropertiesManager.getProperty(Constants.Caps.DC_BROWSER_NAME));
		
		getDriver().get(PropertiesManager.getProperty("com.amazon.web.url"));
		getDriver().manage().window().maximize();
		AmazonMainPage mainPage = new AmazonMainPage(getDriver());
		mainPage.mouseOverShopByAll();
		KindleSubMenuSegment kindleSubMenu = mainPage.mouseOverShopByAllKindle();
		
		kindle = kindleSubMenu.clickKindlePaperWhite();
	}
	
	
	@Test
	public void test_proceed_to_order_kindle_quantity_2() throws Exception {
		
		kindle.selectQuantity("2");
		KindleOrderPopoverSegment orderPopup = kindle.clickAddToCartButton();
		
		AmazonShoppingCartMainPage cart = orderPopup.clickAddToOrderButton();
		
		AmazonSignInPage signIn = cart.clickProceedToCheckOutButton();
		
		Assert.assertTrue(signIn.isSignInEmailFieldDisplayed(), "The user is not asked for Sign In Email or Phone");
		Assert.assertTrue(signIn.getEmailOrPhoneLabel().contains(AmazonSignInPage.EMAIL_OR_PHONE_LABEL), "The email or phone label text does not match.");
	}
	
	
	

}
