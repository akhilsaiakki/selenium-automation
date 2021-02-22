package com.expedia.pom;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.expedia.utils.BasePage;
import com.expedia.utils.DatePicker;
import com.expedia.utils.SetLocation;
import com.expedia.utils.TravelerCountSet;

public class Stays extends BasePage {
	static WebDriver driver;

	public Stays(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//button[contains(@aria-label,'Going to')])[1]")
	public WebElement goingToButton;
	@FindBy(xpath = "(//input[contains(@placeholder,'Where are you going')])[1]")
	public WebElement goingToTextField;

	@FindBy(xpath = "(//*[@data-name='d1'])[1]")
	public WebElement checkinButton;
	@FindBy(xpath = "(//*[@data-name='d2'])[1]")
	public WebElement checkoutButton;

	// We try both whichever is visible
	@FindBy(xpath = "//button[contains(@data-testid,'travelers')]")
	public WebElement travelerButton;
	@FindBy(xpath = "//a[contains(@data-testid,'travelers')]")
	public WebElement travelerLink;
	
	@FindBy(xpath = "//button[text()='Search']")
	public WebElement searchButton;
	
	@FindBy(xpath = "//a[contains(text(),'guest')]")
	public WebElement continueAsGuestButton;

	public void clickGoingTo() {
		goingToButton.click();
	}

	public void setLocation() {
		new SetLocation(driver).setLocation(goingToTextField, "Hyderabad", 3);
	}

	public void setCheckin() {
		checkinButton.click();
		new DatePicker(driver).setDatesTemp("24", "December 2020");
	}

	public void setCheckout() {
		checkoutButton.click();
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
		}
		new DatePicker(driver).setDatesTemp("6", "January 2021");
	}
	public void setTravelerStays() {
		new TravelerCountSet(driver).setTravelerStays();
	}
	
	public StaysSearchPage clickSearchStays() {
		clickElement(searchButton);
		return new StaysSearchPage(driver);
	}

	public void doStays() {
		clickGoingTo();
		setLocation();
		setCheckin();
		setCheckout();
		try {
//			exWait.until(ExpectedConditions.visibilityOf(travelerLink));
			travelerLink.click();
			System.out.println("Traveler Link in stays Appeared");
		} catch (Exception e) {
//			exWait.until(ExpectedConditions.visibilityOf(travelerButton));
			travelerButton.click();
			System.out.println("Traveler Button in stays Appeared");
		}
		try {
//			exWait.until(ExpectedConditions.visibilityOf(continueAsGuestButton));
			clickElement(continueAsGuestButton);
			System.out.println("Check out as guest or Signin asked");
			
		} catch (Exception e) {
			System.out.println("Checkout as guest or signin not asked");
		}
		
	}

}
