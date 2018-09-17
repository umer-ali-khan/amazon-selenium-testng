package com.amazon.automation.endtoendtests;


import java.util.Properties;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.amazon.auto.constants.Constants;
import com.amazon.auto.pages.AmazonMainPage;
import com.amazon.auto.pages.AmazonShoppingCartMainPage;
import com.amazon.auto.pages.AmazonSignInPage;
import com.amazon.auto.pages.KindleOrderPopoverSegment;
import com.amazon.auto.pages.KindlePaperwhitePage;
import com.amazon.auto.pages.KindleSubMenuSegment;
import com.amazon.auto.supertest.AmazonSuperTest;
import com.amazon.auto.utils.AmazonUtils;
import com.amazon.auto.utils.PropertiesManager;


public class AmazonProceedToOrderTest extends AmazonSuperTest {

	KindlePaperwhitePage kindle;
	
	@BeforeClass
	public void openKindlePaperwhitePage() throws Exception {
		
	  Properties prop = PropertiesManager.getProperties();
	  
		AmazonSuperTest.setDriver(prop.getProperty(Constants.Caps.DC_BROWSER_NAME));
		
		getDriver().get(PropertiesManager.getProperty("com.amazon.web.url"));
		getDriver().manage().window().maximize();
		AmazonMainPage mainPage = new AmazonMainPage(getDriver());
		mainPage.mouseOverShopByAll();
		KindleSubMenuSegment kindleSubMenu = mainPage.mouseOverShopByAllKindle();
		
		kindle = kindleSubMenu.clickKindlePaperWhite();
	}
	
	
	@Test
	public void test_proceed_to_order_kindle_quantity_2() throws Exception {
		
	  SoftAssert softAssert = new SoftAssert();
	  
	  softAssert.assertEquals(AmazonUtils.getPageTitle(getDriver()), Constants.AmazonPageTitles.KINDLE_PAPERWHITE_TITLE);
	  
		kindle.selectQuantity("2");
		KindleOrderPopoverSegment orderPopup = kindle.clickAddToCartButton();
		
		softAssert.assertEquals(orderPopup.getOrderPopupHeaderTitleText(), Constants.AmazonPageTitles.ORDER_POPUP_TITLE);
		
		softAssert.assertEquals(AmazonUtils.getPageTitle(getDriver()), Constants.AmazonPageTitles.ORDER_POPUP_PAGE_TITLE);
		
		AmazonShoppingCartMainPage cart = orderPopup.clickAddToOrderButton();
		
		softAssert.assertEquals(AmazonUtils.getPageTitle(getDriver()), Constants.AmazonPageTitles.CART_TITLE);
		
		AmazonSignInPage signIn = cart.clickProceedToCheckOutButton();
		
		softAssert.assertEquals(AmazonUtils.getPageTitle(getDriver()), Constants.AmazonPageTitles.SIGN_IN_TITLE);
		
		softAssert.assertTrue(signIn.isSignInEmailFieldDisplayed(), "The user is not asked for Sign In Email or Phone");
		softAssert.assertTrue(signIn.getEmailOrPhoneLabel().contains(AmazonSignInPage.EMAIL_OR_PHONE_LABEL), "The email or phone label text does not match.");
		
		softAssert.assertAll();
		
	}
	
	
	@AfterClass
	public void tearDown() {
		
		if(getDriver()!= null)getDriver().close();
	}


}
