package testcases.SPA;

import components.BaseClass;
import components.Constants;
import dataModel.SPA.Vehicle;
import org.testng.annotations.Test;

import pageObjects.SPA.SPA_AccountsPage;
import pageObjects.SPA.SPA_HomePage;
import pageObjects.SPA.SPA_LocationPage;
import pageObjects.SPA.SPA_LoginPage;
import pageObjects.SPA.SPA_SessionsPage;
import utils.XML_Operations;

public class Sessions_Testcases extends BaseClass {
	// ****************** CLASS INSTANCES ****************************//
	XML_Operations xml_Ops = new XML_Operations();
	SPA_HomePage spaHomePage = new SPA_HomePage();
	SPA_LoginPage spaLoginPage = new SPA_LoginPage();
	SPA_SessionsPage spaSessionsPage = new SPA_SessionsPage();
	SPA_AccountsPage accountsPage = new SPA_AccountsPage();
	SPA_LocationPage locationPage = new SPA_LocationPage();

	// ****************** TEST SCRIPTS ****************************//

	/*
	 * TC_01_Purchase_Session_With_NewCard_and_NewVehicle
	 * TC_02_Purchase_Session_With_NewCard_and_ExistingVehicle
	 * TC_03_Purchase_Session_With_ExistingCard_and_NewVehicle
	 * TC_04_Purchase_Session_With_ExistingCard_and_ExistingVehicle
	 */

	/*
	 * This is a test case to purchase session with new vehicle and new payment
	 * method
	 *
	 * Author : Pavan Prasad(pavanprasad.v@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_01_Purchase_Session_With_NewCard_and_NewVehicle() {
		Boolean newCard = true, newVehicle = true, newSession = true;

		spaLoginPage = launch_SPA_Application();
		accountsPage = spaLoginPage.login();
		spaHomePage = accountsPage.navigateToHomePage();
		Vehicle vehicle = xml_Ops.getVehicleTestData();
		vehicle.setLicensePlateNumber(getRandomLicencePlate());
		locationPage = spaHomePage.navigate_To_LocationPage(vehicle.getLocationNumber());

		locationPage.purchase_Session(vehicle, newVehicle, newCard);
		locationPage.verify_Purchase_Details(vehicle, newSession);
	}

	/*
	 * This is a test case to purchase session with new vehicle and new payment
	 * method
	 *
	 * Author : Pavan Prasad(pavanprasad.v@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_02_Purchase_Session_With_NewCard_and_ExistingVehicle() {
		Boolean newCard = true, newVehicle = false, newSession = true;
		spaLoginPage = launch_SPA_Application();
		accountsPage = spaLoginPage.login();
		spaHomePage = accountsPage.navigateToHomePage();
		Vehicle vehicle = xml_Ops.getVehicleTestData();
		vehicle.setLicensePlateNumber("TS65HJ");
		locationPage = spaHomePage.navigate_To_LocationPage(vehicle.getLocationNumber());

		locationPage.purchase_Session(vehicle, newVehicle, newCard);
		locationPage.verify_Purchase_Details(vehicle, newSession);
	}

}
