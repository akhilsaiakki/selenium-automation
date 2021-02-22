package com.expedia.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.expedia.pom.StaysPaymentPage;

public class PaymentLocation extends BasePage{
	WebDriver driver;

	public PaymentLocation(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//button[text()='Pay now']")
	public WebElement paynowButton;
	@FindBy(xpath = "//button[text()='Pay at property']")
	public WebElement payAtPropertyButton;
	
	public StaysPaymentPage clickPayNow() {
		clickElement(paynowButton);
		return new StaysPaymentPage(driver);
	}
	public StaysPaymentPage clickPayAtProperty() {
		clickElement(payAtPropertyButton);
		return new StaysPaymentPage(driver);
	}
	
}
