package testcases.OD;

import dataModel.OD.*;
import org.testng.annotations.Test;

import components.BaseClass;
import components.Constants;
import pageObjects.OD.*;
import utils.XML_Operations;

public class Manage_Menu_Testcases extends BaseClass {
	// ****************** CLASS INSTANCES ****************************//
	XML_Operations xml_Ops = new XML_Operations();
	OD_HomePage homePage = new OD_HomePage();
	OD_LoginPage loginPage = new OD_LoginPage();
	OD_MarketsPage marketsPage = new OD_MarketsPage();
	OD_VenuesPage venuesPage = new OD_VenuesPage();
	OD_LocationsPage locationsPage = new OD_LocationsPage();
	OD_VirtualLocationsPage vl_Page = new OD_VirtualLocationsPage();
	OD_EventRatesPage eventRatesPage = new OD_EventRatesPage();
	OD_BlackoutsPage blackoutsPage = new OD_BlackoutsPage();
	OD_WhitelistPage whitelistPage = new OD_WhitelistPage();
	OD_PromoCodesPage promoCodePage = new OD_PromoCodesPage();
	OD_UsersPage usersPage = new OD_UsersPage();
	OD_ProfilesPage profilesPage = new OD_ProfilesPage();

	
	// ****************** TEST SCRIPTS ****************************//

	/*
	 * TC_01_Create_Market
	 * TC_02_Create_Location
	 * TC_03_Create_VirtualLocation
	 * TC_04_Create_EventRate
	 * TC_05_Create_Blackout
	 * TC_06_Create_Whitelist
	 * TC_07_Create_PromoCode
	 * TC_08_Create_User
	 * TC_09_Create_Profile
	 * TC_10_Create_Client
	 * TC_11_Create_Fee
	 *
	 */

	/*
	 * This is a test case to create Market
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_01_Create_Market() {

		loginPage = launch_OD_Application();
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
	@Test(groups = { "smoke", "regression" })
	public void TC_02_Create_Location() {
		String pNumber = "P" + get4DigitRandomNumber();
		loginPage = launch_OD_Application();
		homePage = loginPage.login();
		locationsPage = homePage.navigateToLocationsPage();
		Location location = xml_Ops.getLocationTestData();

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
	@Test(groups = { "smoke", "regression" })
	public void TC_03_Create_VirtualLocation() {

		loginPage = launch_OD_Application();
		homePage = loginPage.login();
		vl_Page = homePage.navigateToVirtualLocationsPage();
		String vl_name = "Test_Virtual_Location_" + getTimestamp();
		vl_Page.create_VirtualLocation(vl_name, Constants.VIRTUAL_LOCATIONS);

	}

	/*
	 * This is a test case to create Event Rates
	 *
	 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_04_Create_EventRate() {

		loginPage = launch_OD_Application();
		homePage = loginPage.login();
		eventRatesPage = homePage.navigateToEventRatesPage();
		EventRates eventRates = (EventRates) xml_Ops.getTestData("event_rates");
		eventRates.setExternalName(eventRates.getExternalName() + getTimestamp());
		eventRates.setRateGroupTitle(eventRates.getRateGroupTitle() + getTimestamp());
		eventRates.setRateName(eventRates.getRateName() + getTimestamp());
		eventRatesPage.create_EventRates(eventRates);
	}

	/*
	 * This is a test case to create Blackout
	 *
	 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_05_Create_Blackout() {

		loginPage = launch_OD_Application();
		homePage = loginPage.login();
		blackoutsPage = homePage.navigateToBlackoutsPage();
		Blackout blackout = (Blackout) xml_Ops.getTestData("blackout");
		blackout.setBlackoutName(blackout.getBlackoutName() + getTimestamp());
		blackout.setBlackoutStartTime(getTimestamp());
		blackout.setBlackoutEndTime(getTimestamp());
		blackoutsPage.create_Blackout(blackout);
	}

	/*
	 * This is a test case to create Whitelist
	 *
	 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_06_Create_Whitelist() {

		loginPage = launch_OD_Application();
		homePage = loginPage.login();
		whitelistPage = homePage.navigateToWhitelistsPage();
		Whitelist whitelist = (Whitelist) xml_Ops.getTestData("whitelist");
		whitelist.setLicensePlate(getRandomLicencePlate());
		whitelist.setName(whitelist.getName() + getTimestamp());
		whitelistPage.create_Whitelist(whitelist);
	}
	
	/*
	 * This is a test case to create PromoCode
	 * 
	 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_07_Create_PromoCode() {

		loginPage = launch_OD_Application();
		homePage = loginPage.login();
		promoCodePage = homePage.navigateToPromoCodesPage();
		PromoCode promoCode = (PromoCode) xml_Ops.getTestData("promocode");
		promoCode.setPromoCode(getRandomPromoCode());
		promoCodePage.create_PromoCode(promoCode);

	}

	/*
	 * This is a test case to create User
	 *
	 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_08_Create_User() {

		loginPage = launch_OD_Application();
		homePage = loginPage.login();
		usersPage = homePage.navigateToUsersPage();
		User user = (User) xml_Ops.getTestData("user");
		user.setLastName(user.getLastName() + getTimestamp());
		user.setEmail(user.getEmail() + getTimestamp() + "@yopmail.com");
		usersPage.create_User(user);

	}

	/*
	 * This is a test case to create Profile
	 *
	 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_09_Create_Profile() {

		loginPage = launch_OD_Application();
		homePage = loginPage.login();
		profilesPage = homePage.navigateToProfilesPage();
		Profile profile = (Profile) xml_Ops.getTestData("profile");
		profile.setLastName(profile.getLastName() + getTimestamp());
		profile.setEmail(profile.getEmail() + getTimestamp() + "@yopmail.com");
		profile.setPhone(getRandomPhoneNumber());
		profilesPage.create_Profile(profile);


	}

}
