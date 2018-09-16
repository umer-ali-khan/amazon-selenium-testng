package com.amazon.auto.browsers;


import org.openqa.selenium.firefox.GeckoDriverService;


public final class FirefoxGeckoService {

	private static GeckoDriverService service;
	
	
	public static GeckoDriverService getFirefoxGeckoService () {
		
		System.setProperty(GeckoDriverService.GECKO_DRIVER_EXE_PROPERTY, "//Users//admin//Downloads//geckodriver");
		
		service = GeckoDriverService.createDefaultService();
		
		return service;
		
	}
	
	
	
}
	

