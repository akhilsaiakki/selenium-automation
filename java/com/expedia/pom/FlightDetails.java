package com.expedia.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.expedia.utils.BasePage;

public class FlightDetails extends BasePage {
	WebDriver driver;

	public FlightDetails(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[text()='Check out']")
	public WebElement checkOutButton;
	@FindBy(xpath = "//a[text()='Checkout as guest']")
	public WebElement continueAsGuestButton;

	public FlightsPaymentPage clickCheckOut() {
		try {
			Thread.sleep(5000);
			checkOutButton.click();
		} catch (Exception e) {
			System.out.println("CheckOut Clicking Failed");
		}
		try {
			System.out.println("Waiting for Guest or Login Prompt");
			exWait.until(ExpectedConditions.visibilityOf(continueAsGuestButton));
			System.out.println("Continue Guest or signin Asked");
			continueAsGuestButton.click();
			System.out.println("Going as Guest");
		} catch (Exception e) {
			System.out.println("Continue Guest or signin Not Asked");
		}
		return new FlightsPaymentPage(driver);
	}

}
