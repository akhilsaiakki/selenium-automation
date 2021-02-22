package com.expedia.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.expedia.utils.BasePage;

public class SigninPage extends BasePage{
	WebDriver driver;

	public SigninPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


///////////////////when Create an account or When all fields appear in one page at once////////
	@FindBy(id = "signin-loginid")
	public WebElement loginEmailTextBox;
	@FindBy(id = "signin-password")														//Make Code whenever this part comes visible
	public WebElement loginPasswordTextBox;												//This comes only few times
	@FindBy(id = "signin-loggedin")
	public WebElement loginKeepMeSignedInTickBox;
	@FindBy(id = "submitButton")
	public WebElement loginSignInSubmitButton;
/////////////////when SignUp Its free or when all fields come one after another
	@FindBy(id = "emailAddress")
	public WebElement loginEmailTextField;
	@FindBy(xpath = "//button[text()='Continue']")
	public WebElement loginContinueButton;
	@FindBy(id = "signInPassword")
	public WebElement loginPasswordTextField;
	@FindBy(id = "signInKeepMeSignedIn")
	public WebElement loginKeepmeSignedInTick;
	@FindBy(id="signInBtn")
	public WebElement signInButton;
	
	
	
}
