package com.expedia.test;

import java.util.Iterator;
import java.util.Set;

import org.testng.annotations.Test;

import com.expedia.pom.ExpediaHome;
import com.expedia.pom.Stays;
import com.expedia.pom.StaysPaymentPage;
import com.expedia.pom.StaysReservationPage;
import com.expedia.pom.StaysSearchPage;
import com.expedia.utils.Base;
import com.expedia.utils.TravelerCountSet;

public class ExpediaIntegrationStays extends Base {

	@Test(description = "Testing Stays Booking Integration")
	public void f() {
		driver.get("https://expedia.com");
		ExpediaHome home = new ExpediaHome(driver);
		Stays staysPage = home.clickStays();
		staysPage.doStays();
		staysPage.setTravelerStays();
		StaysSearchPage searchPage = staysPage.clickSearchStays();
		StaysReservationPage reservationPage = searchPage.chooseStayOption();

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
		StaysPaymentPage staysPaymentPage = reservationPage.clickReserveButton();
	}
}
