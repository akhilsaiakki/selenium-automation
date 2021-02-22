package com.expedia.utils;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SetLocation {
	WebDriver driver;

	public SetLocation(WebDriver driver) {
		super();
		this.driver = driver;
	}
	public void setLocation(WebElement textHolder,String location,int locationNumber) {
		textHolder.sendKeys(location);
		Actions a = new Actions(driver);
		for (int i = 0; i < locationNumber; i++) {
			a.sendKeys(Keys.ARROW_DOWN);
			a.perform();
		}
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
			System.out.println("Error");
		}
		a.sendKeys(Keys.ENTER);
		a.perform();
	}
	
}
