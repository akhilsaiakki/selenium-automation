package com.expedia.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DatePicker {
	static WebDriver driver;

	public DatePicker(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id='d1-btn']")
	public WebElement fromDateButton; // Button
	@FindBy(xpath = "//*[@id='d2-btn']")
	public WebElement toDateButton; // Button
	@FindBy(xpath = "//*[@data-stid='apply-date-picker']") // Button
	public WebElement doneDateButtonButton;
	@FindBy(xpath = "//*[@class='uitk-new-date-picker-month'][1]/h2") // Title
	public WebElement monthYearCalendar1;
	@FindBy(xpath = "//*[@id='nextMonth-title']/../..") // Button
	public WebElement nextMonthButton;
	@FindBy(xpath = "//*[@id='prevMonth-title']/../..") // Button
	public WebElement previousMonthButton;

	public void setDatesTemp(String inputDate, String inputMonthYear) {
		while (true) {
			System.out.println();
			String calenderInputMonthYear = monthYearCalendar1.getText();
			if (calenderInputMonthYear.equals(inputMonthYear)) {
				break;
			} else {
				nextMonthButton.click();
			}
		}
		elementClicker(driver.findElement(By.xpath("//*[table][1]//td//button[@data-day='" + inputDate + "']")));
		elementClicker(doneDateButtonButton);
	}

	public static void elementClicker(WebElement element) {
		JavascriptExecutor je = (JavascriptExecutor) driver;
		je.executeScript("arguments[0].click();", element);
	}

	public void clickFromDateButtom() {
		elementClicker(fromDateButton);
	}

	public void clickToDateButton() {
		elementClicker(toDateButton);
	}

}
