package com.expedia.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.expedia.utils.BasePage;
import com.expedia.utils.DatePicker;
import com.expedia.utils.SetLocation;

public class Oneway extends BasePage{
	WebDriver driver;

	public Oneway(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	//From
	@FindBy(xpath = "(//button[contains(@aria-label,'from')])[1]")
	public WebElement leavingFromButton;
	@FindBy(xpath = "(//*[contains(@placeholder,'Where are you leaving from')])[1]")
	public WebElement leavingFromTextfield;
	//To
	@FindBy(xpath = "(//button[contains(@aria-label,'Going to')])[1]")
	public WebElement goingToButton;
	@FindBy(xpath = "(//input[contains(@placeholder,'Where are you going')])[1]")
	public WebElement goingToTextfield;
	//Date
	@FindBy(xpath = "(//*[@data-name='d1'])[1]")
	public WebElement departDateButton;
	
	
	public void setLeavingFrom() {
		leavingFromButton.click();
		new SetLocation(driver).setLocation(leavingFromTextfield, "Bangalore", 2);
	}
	public void setGoingTo() {
		goingToButton.click();
		new SetLocation(driver).setLocation(goingToTextfield, "Hyderabad", 3);
	}
	public void setOneWay() {
		setLeavingFrom();
		setGoingTo();
		departDateButton.click();
		//SetDepartingDate
		new DatePicker(driver).setDatesTemp("20", "January 2021");
	}
	
}
