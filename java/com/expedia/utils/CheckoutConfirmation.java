package com.expedia.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.expedia.pom.StaysPaymentPage;

public class CheckoutConfirmation extends BasePage{
	WebDriver driver;

	public CheckoutConfirmation(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@data-stid='checkoutAsGuest-button']")
	public WebElement continueGuestButton;

	public void clickContinueGuest() {
		clickElement(continueGuestButton);
	}
}
