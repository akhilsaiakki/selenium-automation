package com.expedia.utils;

import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	public WebDriver driver;
	public Properties prop;
	public WebDriverWait exWait;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		prop = PropertyReader.getInstance();
		exWait=new WebDriverWait(driver, 1);
	}

	public void clickElement(WebElement element) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].click();", element);
	}
	public void scrollToView(WebElement element) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].scrollIntoView(true);",element);
		
	}
}
