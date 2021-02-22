package com.expedia.test;

import org.testng.annotations.Test;

import com.expedia.pom.ExpediaHome;
import com.expedia.pom.Flights;
import com.expedia.pom.Multicity;
import com.expedia.pom.Oneway;
import com.expedia.pom.RegistrationPage;
import com.expedia.pom.SigninPage;
import com.expedia.pom.Roundtrip;
import com.expedia.pom.SigninPage;
import com.expedia.pom.SigninPopup;
import com.expedia.pom.Stays;
import com.expedia.utils.Base;
import com.expedia.utils.TravelerCountSet;

public class TestExample extends Base {
	
	@Test(description = "Testing Login Functionality")
	public void f() {
		driver.get(prop.getProperty("url"));
		ExpediaHome home = new ExpediaHome(driver);
		SigninPopup spop = home.ClickSigninLink();
		SigninPage sp = spop.clickSigninButton();
		
	}
	
	
	
	@Test(description = "Testing Registration Functionality",enabled = true)
	public void regTest() {
		driver.get(prop.getProperty("url"));
		ExpediaHome home = new ExpediaHome(driver);
		SigninPopup spop = home.ClickSigninLink();
		RegistrationPage rp = spop.clickCreateAccount();
	}

	
	@Test(enabled = false,description = "Testing Round Trip Module")
	public void f1() {
		driver.get(prop.getProperty("url"));
		ExpediaHome home = new ExpediaHome(driver);
		Flights flightshome = home.clickFlights();
		Roundtrip round = flightshome.clickRoundtrip();
		int adult = Integer.parseInt(prop.getProperty("adultTravelerNumber"));
		int child= Integer.parseInt(prop.getProperty("childTravelerNumber"));
		int infant = Integer.parseInt(prop.getProperty("infantTravelerNumber"));
		flightshome.travelerSet();
		int economyOption = Integer.parseInt(prop.getProperty("economyOption"));
		flightshome.setEconomy(economyOption);
		round.setRound();	//THis step  we could modify based on Test case
		home.searchButton.click();
	}
	
	
	@Test(description = "Testing One Way Module",enabled = false)
	public void f2() {
		driver.get(prop.getProperty("url"));
		ExpediaHome home = new ExpediaHome(driver);
		Flights flightsPage = home.clickFlights();
		Oneway onewayPage = flightsPage.clickOneway();
		flightsPage.travelerSet();
		
		int economyOption = Integer.parseInt(prop.getProperty("economyOption"));
		flightsPage.setEconomy(economyOption);

		onewayPage.setOneWay();	//This step Modify based on Test case
		home.searchButton.click();
	}
	
	
	@Test(description = "Testing Multi city Module",enabled = true)
	public void f3() {
		driver.get(prop.getProperty("url"));
		ExpediaHome home = new ExpediaHome(driver);
		Flights flightsPage = home.clickFlights();
		Multicity multicityPage = flightsPage.clickMulticity();
		flightsPage.travelerSet();
		int economyOption = Integer.parseInt(prop.getProperty("economyOption"));
		flightsPage.setEconomy(economyOption);
		multicityPage.setMulti();	//This step Modify based on Test case
		home.searchButton.click();
	}

	@Test(description = "Testing Stays Module",enabled = true)
	public void f0() {
		driver.get("https://expedia.com");
		ExpediaHome home = new ExpediaHome(driver);
		Stays staysPage = home.clickStays();
		staysPage.doStays();
		staysPage.setTravelerStays();
		home.searchButton.click();
	}

}
