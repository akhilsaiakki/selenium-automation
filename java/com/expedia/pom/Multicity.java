package com.expedia.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.expedia.utils.BasePage;
import com.expedia.utils.DatePicker;
import com.expedia.utils.SetLocation;

public class Multicity extends BasePage{
	WebDriver driver;

	public Multicity(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	//Flight1
	@FindBy(xpath = "(//button[contains(@aria-label,'from')])[1]")
	public WebElement leavingFromButton1;
	@FindBy(xpath = "(//*[contains(@placeholder,'Where are you leaving from')])[1]")
	public WebElement leavingFromTextholder1;
	@FindBy(xpath = "(//button[contains(@aria-label,'Going to')])[1]")
	public WebElement goingToButton1;
	@FindBy(xpath = "(//input[contains(@placeholder,'Where are you going')])[1]")
	public WebElement goingToTextholder1;
	//Flight2
	@FindBy(xpath = "(//button[contains(@aria-label,'from')])[2]")
	public WebElement leavingFromButton2;
	@FindBy(xpath = "(//*[contains(@placeholder,'Where are you leaving from')])[2]")
	public WebElement leavingFromTextholder2;
	@FindBy(xpath = "(//button[contains(@aria-label,'Going to')])[2]")
	public WebElement goingToButton2;
	@FindBy(xpath = "(//input[contains(@placeholder,'Where are you going')])[2]")
	public WebElement goingToTextholder2;
	
	//AddRemove
	@FindBy(xpath = "//button[text()='Add another flight']")
	public WebElement addAnotherFlightButton;
	@FindBy(xpath = "//button[text()='Remove']")
	public WebElement removeFlightButton;
	
	//DepartureDates
	@FindBy(xpath = "(//*[@data-name='d1'])[1]")
	public WebElement departDateButton1;
	@FindBy(xpath = "(//*[@data-name='d1'])[2]")
	public WebElement departDateButton2;
	
	public void setLeavingFrom1() {
		leavingFromButton1.click();
		new SetLocation(driver).setLocation(leavingFromTextholder1, "Delhi", 1);
	}
	public void setGoingTo1() {
		goingToButton1.click();
		new SetLocation(driver).setLocation(goingToTextholder1, "Bengaluru", 1);
	}
	public void setLeavingFrom2() {
		leavingFromButton2.click();
		new SetLocation(driver).setLocation(leavingFromTextholder2, "Pune", 1);
	}
	public void setGoingTo2() {
		goingToButton2.click();
		new SetLocation(driver).setLocation(goingToTextholder2, "Hyderabad", 1);
	}
	public void setDepartingDate1() {
		new DatePicker(driver).setDatesTemp("19", "December 2020");
	}
	public void setDepartingDate2() {
		new DatePicker(driver).setDatesTemp("20", "January 2021");
	}
	public void setMulti() {
		setLeavingFrom1();
		setGoingTo1();
		departDateButton1.click();
		setDepartingDate1();
		setLeavingFrom2();
		setGoingTo2();
		departDateButton2.click();
		setDepartingDate2();
	}

	
	

	
	
	
	
	
}
