/**
 * 
 */
package com.amazon.auto.constants;

/**
 * @author Umar Khan
 *
 */
public final class Constants {

	
	private Constants() {}
	
	
	public static final class Caps{
		
		private Caps() {}
		
		public static final String DC_BROWSER_NAME = "com.amazon.browser.name";
		public static final String DC_BROWSER_VERSION = "com.amazon.browser.version";
		public static final String DC_BROWSER_PLATFORM = "com.amazon.platform";
		public static final String DC_CSS_SELECTORS = "com.amazon.cssselectors";
		public static final String DC_ACCEPT_SSL_CERTS = "com.amazon.accept.ssl";
		public static final String DC_HEAD_LESS = "com.amazon.headless";
		
	}
	
	public static final class JSCode{
		
		private JSCode() {}
		
		public static final String SCROLL_INTO_VIEW = "arguments[0].scrollIntoView(true);";
	}
	
	
	public static final class TimeDuration{
		
		private TimeDuration() {}
		
		public static final int WAIT_FOR_DISPLAY = 10;
	}
	
}
