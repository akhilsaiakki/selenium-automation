package com.expedia.test;

import java.util.Iterator;
import java.util.Set;

import org.testng.annotations.Test;

import com.expedia.pom.ExpediaHome;
import com.expedia.pom.FlightDetails;
import com.expedia.pom.Flights;
import com.expedia.pom.FlightsPaymentPage;
import com.expedia.pom.FlightsSearchPage;
import com.expedia.pom.Multicity;
import com.expedia.pom.Oneway;
import com.expedia.pom.StaysSearchPage;
import com.expedia.pom.TripDetailsPage;
import com.expedia.utils.Base;

public class ExpediaIntegrationOneway extends Base {
	@Test(description = "Testing One way integration test")
	public void oneWayIntegration() {
		driver.get(prop.getProperty("url"));
		ExpediaHome home = new ExpediaHome(driver);
		Flights flightsPage = home.clickFlights();
		Oneway onewayPage = flightsPage.clickOneway();
		flightsPage.travelerSet();
		int economyOption = Integer.parseInt(prop.getProperty("economyOption"));
		flightsPage.setEconomy(economyOption);
		onewayPage.setOneWay();

		FlightsSearchPage flightsSearchPage = flightsPage.clickSearchFlights();
		FlightDetails flightDetails = flightsSearchPage.doOneWay();
		// Switch to Next Windows
		String parent = driver.getWindowHandle();
		Set<String> allTabs = driver.getWindowHandles();
		Iterator<String> I1 = allTabs.iterator();
		while (I1.hasNext()) {
			String childWindow = I1.next();
			if (!parent.equals(childWindow)) {
				driver.switchTo().window(childWindow);
				break;
			}
		}
		FlightsPaymentPage flightsPaymentPage = flightDetails.clickCheckOut();
	}
}
