package com.expedia.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.expedia.utils.BasePage;

public class SigninPopup extends BasePage{
	WebDriver driver;

	public SigninPopup(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(text(),'Sign in')]")
	public WebElement signinButton;
	@FindBy(xpath = "//a[contains(text(),'free')]")
	public WebElement createAccountButton;

	public SigninPage clickSigninButton() {
		clickElement(signinButton);
		return new SigninPage(driver);
	}
	public RegistrationPage clickCreateAccount() {
		clickElement(createAccountButton);
		return new RegistrationPage(driver);
	}
}
