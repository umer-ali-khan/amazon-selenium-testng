package com.amazon.auto.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class AmazonUtils {

	public static boolean isElementDisplayed(WebElement ele) {

		if (ele == null)
			return false;

		boolean found = false;

		try {

			if (ele.isDisplayed())
				found = true;

		} catch (NoSuchElementException e) {
			System.out.println("The element " + ele + " not found.");
		}

		return found;
	}

	public static void mouseHoover(RemoteWebDriver driver, WebElement ele) {

		Actions action = new Actions(driver);

		action.moveToElement(ele).build().perform();

	}

	public static void presentScrollClick(RemoteWebDriver driver, WebElement ele) {
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
				JavascriptExecutor js = ((JavascriptExecutor) driver);

				//presence in DOM
				wait.until(ExpectedConditions.visibilityOf(ele));

				//scrolling
		
				js.executeScript("arguments[0].scrollIntoView(true);", ele);

				//clickable
				wait.until(ExpectedConditions.elementToBeClickable(ele));
				
				ele.click();
	}

}
