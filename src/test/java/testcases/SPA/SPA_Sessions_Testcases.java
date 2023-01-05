package testcases.SPA;

import components.BaseClass;
import dataModel.SPA.Vehicle;
import org.testng.annotations.Test;
import pageObjects.SPA.SPA_AccountsPage;
import pageObjects.SPA.SPA_HomePage;
import pageObjects.SPA.SPA_LocationPage;
import pageObjects.SPA.SPA_LoginPage;
import utils.XML_Operations;

public class SPA_Sessions_Testcases extends BaseClass {
	// ****************** CLASS INSTANCES ****************************//
	XML_Operations xml_Ops = new XML_Operations();
	SPA_HomePage spaHomePage = new SPA_HomePage();
	SPA_LoginPage spaLoginPage = new SPA_LoginPage();
	SPA_AccountsPage accountsPage = new SPA_AccountsPage();
	SPA_LocationPage locationPage = new SPA_LocationPage();

	// ****************** TEST SCRIPTS ****************************//

	/*
	 * TC_01_Purchase_Session_With_NewCard_and_NewVehicle
	 * TC_02_Purchase_Session_With_NewCard_and_ExistingVehicle
	 * TC_03_Purchase_Session_With_ExistingCard_and_NewVehicle
	 * TC_04_Purchase_Session_With_ExistingCard_and_ExistingVehicle
	 * TC_05_Purchase_Session_With_PromoCode_and_NewVehicle
	 * TC_06_Purchase_Session_With_PromoCode_and_ExistingVehicle
	 * TC_07_Extend_Session_for_ExistingVehicle_With_NewCard
	 * TC_08_Extend_Session_for_ExistingVehicle_With_ExistingCard
	 * TC_09_Extend_Session_for_ExistingVehicle_With_PromoCode
	 */

	/*
	 * This is a test case to purchase session with new vehicle and new payment method
	 *
	 * Author : Pavan Prasad(pavanprasad.v@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_01_Purchase_Session_With_NewCard_and_NewVehicle() {
		Boolean newCard = true, newVehicle = true, chooseTime = false, newSession = true, newReservation = false, newPromoCode = false, payButton = true;

		spaLoginPage = launch_SPA_Application();
		accountsPage = spaLoginPage.login();
		spaHomePage = accountsPage.navigateToHomePage();
		Vehicle vehicle = xml_Ops.getVehicleTestData();
		vehicle.setLicensePlateNumber(getRandomLicencePlate());
		locationPage = spaHomePage.navigate_To_LocationPage(vehicle.getLocationNumber());

		locationPage.purchase_Session(vehicle, newVehicle, chooseTime, newCard, newPromoCode, payButton);
		locationPage.verify_Purchase_Details(vehicle, newSession, newReservation);
	}

	/*
	 * This is a test case to purchase session with existing vehicle and new payment method
	 *
	 * Author : Pavan Prasad(pavanprasad.v@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_02_Purchase_Session_With_NewCard_and_ExistingVehicle() {
		Boolean newCard = true, newVehicle = false, chooseTime = true, newSession = true, newReservation = false, newPromoCode = false, payButton = true;
		spaLoginPage = launch_SPA_Application();
		accountsPage = spaLoginPage.login();
		spaHomePage = accountsPage.navigateToHomePage();
		Vehicle vehicle = xml_Ops.getVehicleTestData();
		vehicle.setTimeInHours("1");
		vehicle.setLicensePlateNumber("H297G");
		locationPage = spaHomePage.navigate_To_LocationPage(vehicle.getLocationNumber());

		locationPage.purchase_Session(vehicle, newVehicle, chooseTime, newCard, newPromoCode, payButton);
		locationPage.verify_Purchase_Details(vehicle, newSession, newReservation);
	}

	/*
	 * This is a test case to purchase session with new vehicle and existing card payment method
	 *
	 * Author : Pavan Prasad(pavanprasad.v@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_03_Purchase_Session_With_ExistingCard_and_NewVehicle() {
		Boolean newCard = false, newVehicle = true, chooseTime = false, newSession = true, newReservation = false, newPromoCode = false, payButton = true;

		spaLoginPage = launch_SPA_Application();
		accountsPage = spaLoginPage.login();
		spaHomePage = accountsPage.navigateToHomePage();
		Vehicle vehicle = xml_Ops.getVehicleTestData();
		vehicle.setLicensePlateNumber(getRandomLicencePlate());
		locationPage = spaHomePage.navigate_To_LocationPage(vehicle.getLocationNumber());

		locationPage.purchase_Session(vehicle, newVehicle, chooseTime, newCard, newPromoCode, payButton);
		locationPage.verify_Purchase_Details(vehicle, newSession, newReservation);
	}

	/*
	 * This is a test case to purchase session with existing vehicle and existing card payment method
	 *
	 * Author : Pavan Prasad(pavanprasad.v@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_04_Purchase_Session_With_ExistingCard_and_ExistingVehicle() {
		Boolean newCard = false, newVehicle = false, chooseTime = true, newSession = true, newReservation = false, newPromoCode = false, payButton = true;
		spaLoginPage = launch_SPA_Application();
		accountsPage = spaLoginPage.login();
		spaHomePage = accountsPage.navigateToHomePage();
		Vehicle vehicle = xml_Ops.getVehicleTestData();
		vehicle.setTimeInHours("1");
		vehicle.setLicensePlateNumber("U287W");
		locationPage = spaHomePage.navigate_To_LocationPage(vehicle.getLocationNumber());

		locationPage.purchase_Session(vehicle, newVehicle, chooseTime, newCard, newPromoCode, payButton);
		locationPage.verify_Purchase_Details(vehicle, newSession, newReservation);
	}

	/*
	 * This is a test case to purchase session with new vehicle and promocode
	 *
	 * Author : Pavan Prasad(pavanprasad.v@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_05_Purchase_Session_With_PromoCode_and_NewVehicle() {
		Boolean newCard = false, newVehicle = true, chooseTime = false, newSession = true, newReservation = false, newPromoCode = true, payButton = false;

		spaLoginPage = launch_SPA_Application();
		accountsPage = spaLoginPage.login();
		spaHomePage = accountsPage.navigateToHomePage();
		Vehicle vehicle = xml_Ops.getVehicleTestData();
		vehicle.setLicensePlateNumber(getRandomLicencePlate());
		locationPage = spaHomePage.navigate_To_LocationPage(vehicle.getLocationNumber());

		locationPage.purchase_Session(vehicle, newVehicle, chooseTime, newCard, newPromoCode, payButton);
		locationPage.verify_Purchase_Details(vehicle, newSession, newReservation);
	}

	/*
	 * This is a test case to purchase session with existing vehicle and promocode
	 *
	 * Author : Pavan Prasad(pavanprasad.v@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_06_Purchase_Session_With_PromoCode_and_ExistingVehicle() {
		Boolean newCard = false, newVehicle = false, chooseTime = true, newSession = true, newReservation = false, newPromoCode = true, payButton = false;

		spaLoginPage = launch_SPA_Application();
		accountsPage = spaLoginPage.login();
		spaHomePage = accountsPage.navigateToHomePage();
		Vehicle vehicle = xml_Ops.getVehicleTestData();
		vehicle.setTimeInHours("1");
		vehicle.setLicensePlateNumber("TS65HJ");
		locationPage = spaHomePage.navigate_To_LocationPage(vehicle.getLocationNumber());

		locationPage.purchase_Session(vehicle, newVehicle, chooseTime, newCard, newPromoCode, payButton);
		locationPage.verify_Purchase_Details(vehicle, newSession, newReservation);
	}

	/*
	 * This is a test case to extend session with existing vehicle and new card
	 *
	 * Author : Pavan Prasad(pavanprasad.v@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_07_Extend_Session_for_ExistingVehicle_With_NewCard() {
		Boolean newCard = true, newVehicle = false, chooseTime = true, newSession = true, newReservation = false, newPromoCode = false, payButton = true;
		spaLoginPage = launch_SPA_Application();
		accountsPage = spaLoginPage.login();
		spaHomePage = accountsPage.navigateToHomePage();
		Vehicle vehicle = xml_Ops.getVehicleTestData();
		vehicle.setTimeInHours("1");
		vehicle.setLicensePlateNumber("W318T");
		locationPage = spaHomePage.navigate_To_LocationPage(vehicle.getLocationNumber());

		locationPage.purchase_Session(vehicle, newVehicle, chooseTime, newCard, newPromoCode, payButton);
		locationPage.verify_Purchase_Details(vehicle, newSession, newReservation);
	}

	/*
	 * This is a test case to extend session with existing vehicle and existing card
	 *
	 * Author : Pavan Prasad(pavanprasad.v@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_08_Extend_Session_for_ExistingVehicle_With_ExistingCard() {
		Boolean newCard = false, newVehicle = false, chooseTime = true, newSession = true, newReservation = false, newPromoCode = false, payButton = true;
		spaLoginPage = launch_SPA_Application();
		accountsPage = spaLoginPage.login();
		spaHomePage = accountsPage.navigateToHomePage();
		Vehicle vehicle = xml_Ops.getVehicleTestData();
		vehicle.setTimeInHours("1");
		vehicle.setLicensePlateNumber("E358P");
		locationPage = spaHomePage.navigate_To_LocationPage(vehicle.getLocationNumber());

		locationPage.purchase_Session(vehicle, newVehicle, chooseTime, newCard, newPromoCode, payButton);
		locationPage.verify_Purchase_Details(vehicle, newSession, newReservation);
	}

	/*
	 * This is a test case to extend session with existing vehicle and promocode
	 *
	 * Author : Pavan Prasad(pavanprasad.v@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_09_Extend_Session_for_ExistingVehicle_With_PromoCode() {
		Boolean newCard = false, newVehicle = false, chooseTime = true, newSession = true, newReservation = false, newPromoCode = true, payButton = false;

		spaLoginPage = launch_SPA_Application();
		accountsPage = spaLoginPage.login();
		spaHomePage = accountsPage.navigateToHomePage();
		Vehicle vehicle = xml_Ops.getVehicleTestData();
		vehicle.setTimeInHours("1");
		vehicle.setLicensePlateNumber("G873K");
		locationPage = spaHomePage.navigate_To_LocationPage(vehicle.getLocationNumber());

		locationPage.purchase_Session(vehicle, newVehicle, chooseTime, newCard, newPromoCode, payButton);
		locationPage.verify_Purchase_Details(vehicle, newSession, newReservation);
	}
}
