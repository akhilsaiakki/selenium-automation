package com.expedia.test;

import java.util.Iterator;
import java.util.Set;

import org.testng.annotations.Test;

import com.expedia.pom.ExpediaHome;
import com.expedia.pom.Flights;
import com.expedia.pom.FlightsPaymentPage;
import com.expedia.pom.FlightsSearchPage;
import com.expedia.pom.Oneway;
import com.expedia.pom.Roundtrip;
import com.expedia.pom.StaysSearchPage;
import com.expedia.pom.TripDetailsPage;
import com.expedia.utils.Base;

public class ExpediaIntegrationRoundTrip extends Base {
	@Test(description = "Testing Round Trip integration test")
	public void roundtripIntegration() {
		driver.get(prop.getProperty("url"));
		ExpediaHome home = new ExpediaHome(driver);
		Flights flightsPage = home.clickFlights();
		Roundtrip rp = flightsPage.clickRoundtrip();
		flightsPage.travelerSet();
		int economyOption = Integer.parseInt(prop.getProperty("economyOption"));
		flightsPage.setEconomy(economyOption);
		rp.setRound();
		FlightsSearchPage flightsSearchPage = flightsPage.clickSearchFlights();
		TripDetailsPage tripDetailsPage = flightsSearchPage.doMultiOrRound();
		//Here New tab opens
		
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
