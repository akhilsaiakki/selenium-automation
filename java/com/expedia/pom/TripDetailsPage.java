package com.expedia.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.expedia.utils.BasePage;




public class TripDetailsPage extends BasePage{
	WebDriver driver;

	public TripDetailsPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[text()='Continue Booking']")
	public WebElement continueBookingButton;
	@FindBy(xpath = "//a[text()='Checkout as guest']")
	public WebElement continueAsGuestButton;
	
	public FlightsPaymentPage clickContinueBook() {
		try {
			exWait.until(ExpectedConditions.visibilityOf(continueAsGuestButton));
			System.out.println("Continue Guest or signin Asked");
			continueAsGuestButton.click();
			System.out.println("Going as Guest");
		} catch (Exception e) {
			System.out.println("Continue Guest or signin Not Asked");
		}
		System.out.println(driver.getTitle());
		clickElement(continueBookingButton);
		return new FlightsPaymentPage(driver);
	}
}
