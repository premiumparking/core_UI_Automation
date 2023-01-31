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
	OD_ClientsPage clientsPage = new OD_ClientsPage();
	OD_FeesPage feesPage = new OD_FeesPage();
	OD_TextPayJobsPage textPayJobsPage = new OD_TextPayJobsPage();
	OD_GLCodesPage glCodesPage = new OD_GLCodesPage();
	OD_TextPayRequestsPage textPayRequestsPage = new OD_TextPayRequestsPage();
	OD_RolesPage rolesPage = new OD_RolesPage();
	OD_InvoicesPage invoicesPage = new OD_InvoicesPage();
	OD_PartnerSalesPage partnerSalesPage = new OD_PartnerSalesPage();
	OD_CashDepositsPage cashDepositsPage = new OD_CashDepositsPage();

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
	 * TC_12_Create_TextPay_Job
	 * TC_13_Create_GL_Code
	 * TC_14_Create_TextPay_Request
	 * TC_15_Create_Role
	 * TC_16_Create_Invoice
	 * TC_17_Create_Partner_Sale
	 * TC_18_Create_Cash_Deposit
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
		Market market = (Market) xml_Ops.getTestData("market");
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
		Location location = (Location) xml_Ops.getTestData("location");

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
		promoCodePage.create_CustomPromoCode(promoCode);
		promoCode.setBatchName(promoCode.getBatchName() + getTimestamp());
		promoCodePage.create_AutoGeneratePromoCode(promoCode);

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

	/*
	 * This is a test case to create Client
	 *
	 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_10_Create_Client() {

		loginPage = launch_OD_Application();
		homePage = loginPage.login();
		clientsPage = homePage.navigateToClientsPage();
		Client client = (Client) xml_Ops.getTestData("client");
		client.setClientName(client.getClientName() + getTimestamp());
		clientsPage.create_client(client);

	}

	/*
	 * This is a test case to create Fee
	 *
	 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_11_Create_Fee() {

		loginPage = launch_OD_Application();
		homePage = loginPage.login();
		feesPage = homePage.navigateToFeesPage();
		Fee fee = (Fee) xml_Ops.getTestData("fee");
		fee.setFeeLocation(getRandomLocation());
		fee.setPercentage(getRandomNumber());
		fee.setAmount(getRandomNumber());
		feesPage.create_Fee(fee);

	}

	/*
	 * This is a test case to create text pay job
	 *
	 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_12_Create_TextPay_Job() {

		loginPage = launch_OD_Application();
		homePage = loginPage.login();
		textPayJobsPage = homePage.navigateToTextPayJobsPage();
		String TP_Job_name = "TextPay_Job_" + getTimestamp();
		textPayJobsPage.create_TextPayJob(TP_Job_name);

	}

	/*
	 * This is a test case to create GL Code
	 *
	 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_13_Create_GL_Code() {

		loginPage = launch_OD_Application();
		homePage = loginPage.login();
		glCodesPage = homePage.navigateToGLCodesPage();
		GLCode glCode = (GLCode) xml_Ops.getTestData("glcode");
		glCode.setCode(glCode.getCode() + getTimestamp());
		glCodesPage.create_glCode(glCode);

	}

	/*
	 * This is a test case to send text pay request
	 *
	 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_14_Create_TextPay_Request() {

		loginPage = launch_OD_Application();
		homePage = loginPage.login();
		textPayRequestsPage = homePage.navigateToTextPayRequestsPage();
		String TPR_phone = getRandomPhoneNumber();
		String TPR_location = getRandomLocation();
		textPayRequestsPage.create_TextPayRequest(TPR_phone, TPR_location);

	}

	/*
	 * This is a test case to create role
	 *
	 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_15_Create_Role() {

		loginPage = launch_OD_Application();
		homePage = loginPage.login();
		rolesPage = homePage.navigateToRolesPage();
		Role role = (Role) xml_Ops.getTestData("role");
		role.setRoleName(role.getRoleName() + getTimestamp());
		rolesPage.create_Role(role);
	}

	/*
	 * This is a test case to create invoice
	 *
	 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_16_Create_Invoice() {

		loginPage = launch_OD_Application();
		homePage = loginPage.login();
		invoicesPage = homePage.navigateToInvoicesPage();
		Invoice invoice = (Invoice) xml_Ops.getTestData("invoice");
		invoice.setInvoiceLocation(getRandomLocation());
		invoicesPage.create_Invoice(invoice);
	}

	/*
	 * This is a test case to create partner product
	 *
	 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_17_Create_Partner_Sale() {

		loginPage = launch_OD_Application();
		homePage = loginPage.login();
		partnerSalesPage = homePage.navigateToPartnerSalesPage();
		PartnerSale partnerSale = (PartnerSale) xml_Ops.getTestData("partner");
		partnerSale.setCompanyName(partnerSale.getCompanyName() + getTimestamp());
		partnerSale.setProductName(partnerSale.getProductName() + getTimestamp());
		partnerSale.setEmail(partnerSale.getEmail() + getTimestamp() + "@yopmail.com");
		partnerSalesPage.create_partnerProduct(partnerSale);

	}

	/*
	 * This is a test case to create cash deposit
	 *
	 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_18_Create_Cash_Deposit() {

		loginPage = launch_OD_Application();
		homePage = loginPage.login();
		cashDepositsPage = homePage.navigateToCashDepositsPage();
		CashDeposit cashDeposit = (CashDeposit) xml_Ops.getTestData("cash_deposit");
		cashDeposit.setBagNumber(getTimestamp());
		cashDepositsPage.create_CashDeposit(cashDeposit);

	}

}
