/**
 * 
 */
package com.auto.amazon.enums;

/**
 * @author Umar Khan
 *
 */
public enum BrowserNames {

	FIREFOX("firefox"),
	CHROME("chrome");
	
	private String browser;
	
	private BrowserNames(String name) {
		
		this.browser = name;
	}
	
	public String getBrowserName() {
		
		return browser;
	}
	
}
