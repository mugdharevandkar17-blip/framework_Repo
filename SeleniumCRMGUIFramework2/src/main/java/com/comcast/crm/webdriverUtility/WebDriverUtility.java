package com.comcast.crm.webdriverUtility;

import java.time.Duration;
import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	public void waitForPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	
	public void waitForElement(WebDriver driver,WebElement element) {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void switchToTabURL(WebDriver driver,String partialUrl) {
		Set<String> windows = driver.getWindowHandles();
		for(String a:windows) {
			driver.switchTo().window(a);
			@Nullable
			String URL = driver.getCurrentUrl();
			if(URL.contains(partialUrl)) {
				break;
			}
		}
		
	}
	
	public void switchToTabOnTitle(WebDriver driver,String title) {
		Set<String> windows = driver.getWindowHandles();
		for(String a:windows) {
			driver.switchTo().window(a);
			@Nullable
			String Title = driver.getTitle();
			if(Title.contains(title)) {
				break;
			}
		}
	}
	
	
	

}
