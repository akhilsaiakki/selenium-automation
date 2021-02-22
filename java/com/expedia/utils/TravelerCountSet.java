package com.expedia.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TravelerCountSet extends BasePage{
	WebDriver driver;

	public TravelerCountSet(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//label[text()='Adults']/..//button[1]")
	public WebElement adultDecreaseButton;
	@FindBy(xpath = " //label[text()='Adults']/..//input")
	public WebElement adultCount;
	@FindBy(xpath = "//label[text()='Adults']/..//button[2]")
	public WebElement adultIncreaseButton;
	@FindBy(xpath = "//label[text()='Children']/..//button[1]")
	public WebElement childrenDecreaseButton;
	@FindBy(xpath = " //label[text()='Children']/..//input")
	public WebElement childrenCount;
	@FindBy(xpath = "//label[text()='Children']/..//button[2]")
	public WebElement childrenIncreaseButton;
	@FindBy(xpath = "//label[text()='Infants']/..//button[1]")
	public WebElement infantDecreaseButton;
	@FindBy(xpath = " //label[text()='Infants']/..//input")
	public WebElement infantCount;
	@FindBy(xpath = "//label[text()='Infants']/..//button[2]")
	public WebElement infantIncreaseButton;
	@FindBy(xpath = "//button[text()='Done']")
	public WebElement doneButton;

	public void setAdult(int adultNumber) {
		while (true) {
			int currentAdultNumber = Integer.parseInt(adultCount.getAttribute("value"));
			if (currentAdultNumber == adultNumber) {
				break;
			} else if (currentAdultNumber < adultNumber) {
				adultIncreaseButton.click();
			} else if (currentAdultNumber > adultNumber) {
				adultDecreaseButton.click();
			}
		}
	}

	public void setChildren(int childrenNumber) {
		while (true) {
			int currentChildNumber = Integer.parseInt(childrenCount.getAttribute("value"));
			if (currentChildNumber == childrenNumber) {
				break;
			} else if (currentChildNumber < childrenNumber) {
				childrenIncreaseButton.click();
			} else if (currentChildNumber > childrenNumber) {
				childrenDecreaseButton.click();
			}
		}
	}

	public void setInfant(int infantNumber) {
		while (true) {
			int currentInfantNumber = Integer.parseInt(infantCount.getAttribute("value"));
			if (currentInfantNumber == infantNumber) {
				break;
			} else if (currentInfantNumber < infantNumber) {
				infantIncreaseButton.click();
			} else if (currentInfantNumber > infantNumber) {
				infantDecreaseButton.click();
			}
		}
	}

	public void setTravelerFlights() {
		int adult = Integer.parseInt(prop.getProperty("adultTravelerNumber"));
		int child = Integer.parseInt(prop.getProperty("childTravelerNumber"));
		int infant = Integer.parseInt(prop.getProperty("infantTravelerNumber"));
		setAdult(adult);
		setChildren(child);
		setInfant(infant);
		doneButton.click();
	}
	public void setTravelerStays() {
		int adult = Integer.parseInt(prop.getProperty("adultTravelerNumber"));
		int child = Integer.parseInt(prop.getProperty("childTravelerNumber"));
		setAdult(adult);
		setChildren(child);
		doneButton.click();
	}
}
