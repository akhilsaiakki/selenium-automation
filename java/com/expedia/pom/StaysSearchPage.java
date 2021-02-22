package com.expedia.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.expedia.utils.BasePage;

public class StaysSearchPage extends BasePage {
	WebDriver driver;

	public StaysSearchPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//First Option in Stays Result List
	
	@FindBy(xpath = "(//*[@class='results']//a)[1]")
	public WebElement option;
	
	public StaysReservationPage chooseStayOption() {
		clickElement(option);
		return new StaysReservationPage(driver);
	}

}
