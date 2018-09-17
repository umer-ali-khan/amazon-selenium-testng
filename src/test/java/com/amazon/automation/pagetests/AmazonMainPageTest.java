package com.amazon.automation.pagetests;


import org.testng.Assert;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.Test;

import com.amazon.auto.constants.Constants;
import com.amazon.auto.pages.AmazonMainPage;
import com.amazon.auto.supertest.AmazonSuperTest;
import com.amazon.auto.utils.PropertiesManager;


public class AmazonMainPageTest extends AmazonSuperTest {

	AmazonMainPage mainPage;
	
	@BeforeClass
	public void openAmazonHomePage() throws Exception {
		
		AmazonSuperTest.setDriver(PropertiesManager.getProperty(Constants.Caps.DC_BROWSER_NAME));
		getDriver().get(PropertiesManager.getProperty("com.amazon.web.url"));
		AmazonSuperTest.getDriver().manage().window().maximize();
		mainPage = new AmazonMainPage(getDriver());
	}
	
	
	@Test
	public void test_shop_by_all_displayed() throws Exception {
		
		Assert.assertTrue(mainPage.isShopByAllDisplayed(), "The Shop By All did not display.");
		
	}
	
	@Test
	public void test_kindle_sub_menu_item_displayed() throws Exception {
		
		mainPage.mouseOverShopByAll();
		Assert.assertTrue(mainPage.isKindleDisplayed(), "The Shop By All -> Kindle did not display.");
		mainPage.hideMenu();
		
	}
	
	

}
