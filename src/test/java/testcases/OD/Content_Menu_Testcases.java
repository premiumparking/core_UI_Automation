package testcases.OD;

import dataModel.OD.Venue;
import org.testng.annotations.Test;

import components.BaseClass;
import pageObjects.OD.*;
import utils.XML_Operations;

public class Content_Menu_Testcases extends BaseClass {
	// ****************** CLASS INSTANCES ****************************//
	XML_Operations xml_Ops = new XML_Operations();
	OD_HomePage homePage = new OD_HomePage();
	OD_LoginPage loginPage = new OD_LoginPage();
	OD_MarketsPage marketsPage = new OD_MarketsPage();
	OD_VenuesPage venuesPage = new OD_VenuesPage();

	// ****************** TEST SCRIPTS ****************************//
	@Test(groups = { "smoke", "regression" })
	public void TC_01_Create_Venue() {

		loginPage = launch_OD_Application();
		homePage = loginPage.login();
		venuesPage = homePage.navigateToVenuesPage();
		Venue venue = xml_Ops.getVenueTestData();
		venue.setName(venue.getName() + getTimestamp());
		venuesPage.create_Venue(venue);

	}

}
