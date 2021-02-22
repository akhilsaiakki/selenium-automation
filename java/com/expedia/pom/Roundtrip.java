package com.expedia.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.expedia.utils.BasePage;
import com.expedia.utils.DatePicker;
import com.expedia.utils.SetLocation;

import bsh.This;

public class Roundtrip extends BasePage{

	public Roundtrip(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	// From
	@FindBy(xpath = "(//button[contains(@aria-label,'from')])[1]")
	public WebElement leavingFromButton;
	@FindBy(xpath = "(//*[contains(@placeholder,'Where are you leaving from')])[1]")
	public WebElement leavingFromTextfield;
	// To
	@FindBy(xpath = "(//button[contains(@aria-label,'Going to')])[1]")
	public WebElement goingToButton;
	@FindBy(xpath = "(//input[contains(@placeholder,'Where are you going')])[1]")
	public WebElement goingToTextfield;
	// Dates
	@FindBy(xpath = "(//*[@data-name='d1'])[1]")
	public WebElement departDateButton;
	@FindBy(xpath = "(//*[@data-name='d2'])[1]")
	public WebElement returnDateButton;

	public void setLeavingFrom() {
		leavingFromButton.click();
		new SetLocation(driver).setLocation(leavingFromTextfield, "Bombay", 2);
	}

	public void setGoingTo() {
		goingToButton.click();
		new SetLocation(driver).setLocation(goingToTextfield, "Bombay", 3);
	}

	public void setRound() {
		setLeavingFrom();
		setGoingTo();
		departDateButton.click();
		// SetDepartingDate
		new DatePicker(driver).setDatesTemp("20", "January 2021");
		returnDateButton.click();
		try {
			Thread.sleep(2000);
		} catch (Exception e) {

		}
		new DatePicker(driver).setDatesTemp("28", "January 2021");
	}

}
