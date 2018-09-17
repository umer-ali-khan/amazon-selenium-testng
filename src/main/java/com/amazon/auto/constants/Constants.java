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
	
	public static final class AmazonPageTitles{
    
    private AmazonPageTitles() {}
    
    public static final String MAIN_PAGE_TITLE = "Amazon.ca: Online shopping in Canada - books, electronics, Kindle, home & garden, DVDs, tools, music, health & beauty, watches, baby, sporting goods & more";
    public static final String KINDLE_PAPERWHITE_TITLE = "Kindle Paperwhite e-reader – Amazon.ca’s Official Site – Learn More";
    public static final String ORDER_POPUP_TITLE = "Add to your Kindle order";
    public static final String CART_TITLE = "Amazon.ca Shopping Cart";
    public static final String SIGN_IN_TITLE = "Amazon Sign In";
    public static final String ORDER_POPUP_PAGE_TITLE = "Kindle Paperwhite e-reader – Amazon.ca’s Official Site – Learn More";
    
	}
	
}
