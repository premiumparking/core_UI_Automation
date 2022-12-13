package testcases.OD;

import org.testng.annotations.Test;

import components.BaseClass;
import dataModel.OD.Location;
import dataModel.OD.Market;
import pageObjects.OD.LoginPage;
import pageObjects.OD.MarketsPage;
import pageObjects.OD.LocationsPage;
import utils.XML_Operations;

public class Manage_Menu_Testcases extends BaseClass {
	XML_Operations xml_Ops = new XML_Operations();
	LoginPage loginPage = new LoginPage();
	MarketsPage marketsPage = new MarketsPage();
	LocationsPage locationsPage = new LocationsPage();

	/*
	 * This is a test case to create Market
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	@Test(priority = 1)
	public void TC_01_CreateMarket() {

		loginPage = launchApplication();
		homePage = loginPage.login();
		marketsPage = homePage.navigateToMarketsPage();
		Market market = xml_Ops.getMarketTestData();
		market.setName(market.getName() + getTimestamp());
		marketsPage.create_Market(market);

	}

	/*
	 * This is a test case to create Location
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	@Test(priority = 2)
	public void TC_02_CreateLocation() {
		String pNumber = "P" + get4DigitRandomNumber();
		loginPage = launchApplication();
		homePage = loginPage.login();
		locationsPage = homePage.navigateToLocationsPage();
		Location location = xml_Ops.getLocationTestData();
		System.out.println(location);
		// Setting location test data
		location.setName(pNumber);
		location.setPropertyName(location.getPropertyName() + getTimestamp());
		location.setAddress(location.getAddress() + getTimestamp());

		// Creating location
		locationsPage.create_Location(location);

	}

	/*
	 * This is a test case to create Location
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	@Test(priority = 3)
	public void TC_02_CreateLocation1() {

		loginPage = launchApplication();
		homePage = loginPage.login();
		// locationsPage = homePage.navigateToLocationsPage();
		// Location location = xml_Ops.getLocationTestData();
		// location.setName(location.getName() + getTimestamp());
		// marketsPage.create_Market(market);

	}

}
