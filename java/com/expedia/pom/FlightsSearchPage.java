package com.expedia.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.expedia.utils.BasePage;

public class FlightsSearchPage extends BasePage{
	WebDriver driver;

	public FlightsSearchPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	////////////////////////	ROUND and MULTI CITY	///////////////////////////
	// departure flight Submit Button	>>> Selecting first Result
	@FindBy(xpath = "(//*[@id='flight-listing-container']//button)[1]")
	public WebElement departureFlightSelectButton;
	// Returning Flight Submit Button	>> Selecting First Result
	@FindBy(xpath = "(//*[@id='flight-listing-container']//button)[1]")
	public WebElement returnFlightSelectButton;
	/////////////////////// 	ONE WAY 	//////////////////////////////
	@FindBy(xpath = "(//button[@data-test-id='select-link'])[1]")
	public WebElement firstResultOneWay;
	@FindBy(xpath = "//button[text()='Continue']")
	public WebElement continueButton;
	
	
	public FlightDetails doOneWay() {	// For OneWay return FlightDetails Object
		clickElement(firstResultOneWay);
		clickElement(continueButton);
		try {
			exWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*//a[text()='No Thanks']"))));
			driver.findElement(By.xpath("//a[text()='No Thanks']")).click();
			System.out.println("Force Choice Appeared");
		} catch (Exception e) {
			System.out.println("Forced Choice not Appeared");
		}
		return new FlightDetails(driver);
	}
	
	
	public TripDetailsPage doMultiOrRound() { 	//For Round and Multi return TripDetails Object
		exWait.until(ExpectedConditions.visibilityOf(departureFlightSelectButton));
		clickElement(departureFlightSelectButton);
		exWait.until(ExpectedConditions.visibilityOf(returnFlightSelectButton));
		clickElement(returnFlightSelectButton);
		try {
			exWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@id='forcedChoiceNoThanks']"))));
			driver.findElement(By.xpath("//*[@id='forcedChoiceNoThanks']")).click();
		} catch (Exception e) {
			System.out.println("Forced Choice not Appeared");
		}
		return new TripDetailsPage(driver);
	}
}
