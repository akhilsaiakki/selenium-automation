package com.expedia.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.expedia.utils.BasePage;

public class RegistrationPage extends BasePage{
	WebDriver driver;

	public RegistrationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	/////////////////WHen Create Account is visible
	@FindBy(id = "create-account-firstname")
	public WebElement createFirstNameField; 
	@FindBy(id = "create-account-lastname")
	public WebElement createLastNameField; 
	@FindBy(id = "create-account-emailId")
	public WebElement createEmailField; 
	@FindBy(id = "create-account-password")
	public WebElement createPasswordField; 
	@FindBy(id = "create-account-confirm-password")
	public WebElement createPasswordConfirmField; 
	@FindBy(id = "create-account-expedia-policy")
	public WebElement agreeTickBox;
	@FindBy(id="create-account-submit-button")
	public WebElement createAccountButton;
	////////////////////When Sign Up its free is visible
	@FindBy(xpath = "//input[@id='emailAddress']")
	public WebElement signupEmailTextField;
	@FindBy(id = "unifiedFormContinueBtn")
	public WebElement signupContinueButton;
	@FindBy(xpath = "//input[@id='signUpPassword']")
	public WebElement signupPasswordTextField;
	@FindBy(id="signUpBtn")
	public WebElement signupButton;

	
	
	
}
