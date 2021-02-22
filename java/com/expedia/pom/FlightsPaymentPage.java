package com.expedia.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class FlightsPaymentPage {

	WebDriver driver;

	public FlightsPaymentPage(WebDriver driver) {
		super();
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
}
