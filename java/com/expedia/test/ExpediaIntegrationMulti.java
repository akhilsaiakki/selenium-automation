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

public class ExpediaIntegrationMulti extends Base {
	@Test(description = "Testing Multi integration test")
	public void multiIntegration() {
		driver.get(prop.getProperty("url"));
		ExpediaHome home = new ExpediaHome(driver);
		Flights flightsPage = home.clickFlights();
		Multicity multiPage = flightsPage.clickMulticity();
		
		flightsPage.travelerSet();
		int economyOption = Integer.parseInt(prop.getProperty("economyOption"));
		flightsPage.setEconomy(economyOption);

		multiPage.setMulti();// This step Modify based on Test case
		FlightsSearchPage flightsSearchPage = flightsPage.clickSearchFlights();
		TripDetailsPage tripDetailsPage = flightsSearchPage.doMultiOrRound();

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
		FlightsPaymentPage flightsPaymentPage = tripDetailsPage.clickContinueBook();

	}
}
