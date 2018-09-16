package com.amazon.automation.pagetests;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.amazon.auto.constants.Constants;
import com.amazon.auto.pages.AmazonMainPage;
import com.amazon.auto.supertest.AmazonSuperTest;
import com.amazon.auto.utils.PropertiesManager;


public class MainLoginScreenTest extends AmazonSuperTest {

	AmazonMainPage mainPage;
	
	@BeforeClass
	public void openAmazonHomePage() throws Exception {
		
		getDriver().get(PropertiesManager.getProperty("com.amazon.web.url"));
		getDriver().manage().window().maximize();
		mainPage = new AmazonMainPage(getDriver());
	}
	
	
	@Test
	public void testGoogle() throws Exception {
		
		mainPage.mouseOverShopByAll();
		mainPage.clickKindle();
		
		
		
	}

}
