package com.expedia.pom;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.expedia.utils.BasePage;

public class ExpediaHome extends BasePage {
	WebDriver driver;

	public ExpediaHome(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[text()='Stays']/..")
	public WebElement staysButtonMain;
	@FindBy(xpath = "//span[text()='Flights']/..")
	public WebElement flightsButtonMain;
	@FindBy(xpath = "//div[contains(text(),'Sign in')]")
	public WebElement signinLinkButton;
	@FindBy(xpath = "//button[text()='Search']")
	public WebElement searchButton;

	public Stays clickStays() {
		staysButtonMain.click();
		return new Stays(driver);
	}

	public Flights clickFlights() {
		flightsButtonMain.click();
		return new Flights(driver);
	}

	public SigninPopup ClickSigninLink() {
		clickElement(signinLinkButton);
		try {
			Thread.sleep(2000);
			clickElement(signinLinkButton);
		} catch (Exception e) {

		}
		return new SigninPopup(driver);
	}

	public void clickSearch() {
		clickElement(searchButton);
	}

}
