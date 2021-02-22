package com.expedia.pom;

import javax.lang.model.element.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.expedia.utils.BasePage;
import com.expedia.utils.CheckoutConfirmation;
import com.expedia.utils.PaymentLocation;

public class StaysReservationPage extends BasePage {
	WebDriver driver;

	public StaysReservationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[text()='Reserve a room']")
	public WebElement reserveARoombutton;

	@FindBy(xpath = "(//button[text()='Reserve'])[2]")
	public WebElement reserveButton;

	public StaysPaymentPage clickReserveButton() {
		System.out.println(driver.getWindowHandles().size());
		System.out.println(driver.getTitle());
		clickElement(reserveButton);
		WebDriverWait wait = new WebDriverWait(driver,5);
		try {
			PaymentLocation payAt = new PaymentLocation(driver);
			wait.until(ExpectedConditions.visibilityOf(payAt.paynowButton));
			new PaymentLocation(driver).clickPayNow();
		} catch (Exception e) {
			System.out.println("PayNow or Pay At Site Not Displayed");
		}try {
			CheckoutConfirmation cc = new CheckoutConfirmation(driver);
			cc.clickContinueGuest();
		}catch (Exception e) {
			System.out.println("Sign in before booking payment is not asked");
		}
		return new StaysPaymentPage(driver);
	}

}
