package com.expedia.pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.expedia.utils.Base;
import com.expedia.utils.BasePage;
import com.expedia.utils.TravelerCountSet;


public class Flights extends BasePage {
	WebDriver driver;

	public Flights(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//span[text()='Roundtrip']/..")
	public WebElement roundtrip;
	@FindBy(xpath = "//span[text()='One-way']/..")
	public WebElement oneway;
	@FindBy(xpath = "//span[text()='Multi-city']/..")
	public WebElement multicity;
	@FindBy(xpath = "//a[contains(@data-testid,'travelers')]")
	public WebElement travelerLink;
	@FindBy(xpath = "//a[contains(@aria-label,'Economy')]")
	public WebElement economyLink;
	@FindBy(xpath = "//*[@id='preferred-class-input']//div/a")
	public List<WebElement> economyList;
	@FindBy(xpath = "//button[text()='Search']")
	public WebElement searchButton;

	public Roundtrip clickRoundtrip() {
		roundtrip.click();
		return new Roundtrip(driver);
	}
	public Oneway clickOneway() {
		oneway.click();
		return new Oneway(driver);
	}
	public Multicity clickMulticity() {
		multicity.click();
		return new Multicity(driver);
	}
	public void setEconomy(int optionNumber) {
		economyLink.click();
		economyList.get(optionNumber-1).click();	//We Chose to select Option number 2 we can change later-->Here 2 is "Bussiness class"
	}
	public void travelerSet() {
		travelerLink.click();
		new TravelerCountSet(driver).setTravelerFlights();
	}
	public FlightsSearchPage clickSearchFlights() {
		clickElement(searchButton);
		return new FlightsSearchPage(driver);
	}
}
