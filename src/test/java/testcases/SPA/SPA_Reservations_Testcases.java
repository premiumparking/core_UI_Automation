package testcases.SPA;

import org.testng.annotations.Test;
import components.BaseClass;
import dataModel.SPA.Vehicle;
import org.testng.annotations.Test;
import pageObjects.SPA.SPA_AccountsPage;
import pageObjects.SPA.SPA_HomePage;
import pageObjects.SPA.SPA_LocationPage;
import pageObjects.SPA.SPA_LoginPage;
import utils.XML_Operations;

public class SPA_Reservations_Testcases extends BaseClass {
	// ****************** CLASS INSTANCES ****************************//
	XML_Operations xml_Ops = new XML_Operations();
	SPA_HomePage spaHomePage = new SPA_HomePage();
	SPA_LoginPage spaLoginPage = new SPA_LoginPage();
	SPA_AccountsPage accountsPage = new SPA_AccountsPage();
	SPA_LocationPage locationPage = new SPA_LocationPage();

	// ****************** TEST DATA ****************************//
	Vehicle vehicle = (Vehicle) xml_Ops.getTestData("vehicle");

	// ****************** TEST SCRIPTS ****************************//

	/*
	 * TC_01_Purchase_Reservation_With_NewCard_and_NewVehicle
	 * TC_02_Purchase_Reservation_With_NewCard_and_ExistingVehicle
	 * TC_03_Purchase_Reservation_With_ExistingCard_and_NewVehicle
	 * TC_04_Purchase_Reservation_With_ExistingCard_and_ExistingVehicle
	 * TC_05_Purchase_Reservation_With_100%Discount_PromoCode_and_NewVehicle
	 * TC_06_Purchase_Reservation_With_100%Discount_PromoCode_and_ExistingVehicle
	 * TC_07_Purchase_Future_Reservation_With_NewCard_and_NewVehicle
	 * TC_08_Purchase_Future_Reservation_With_NewCard_and_ExistingVehicle
	 * TC_09_Purchase_Future_Reservation_With_ExistingCard_and_NewVehicle
	 * TC_10_Purchase_Future_Reservation_With_ExistingCard_and_ExistingVehicle
	 * TC_11_Purchase_Future_Reservation_With_100%Discount_PromoCode_and_NewVehicle
	 * TC_12_Purchase_Future_Reservation_With_100%Discount_PromoCode_and_ExistingVehicle
	 * TC_13_Purchase_Reservation_With_Fixed_Discount_PromoCode_and_NewVehicle
	 * TC_14_Purchase_Reservation_With_Fixed_Discount_PromoCode_and_ExistingVehicle
	 * TC_15_Purchase_Future_Reservation_With_Fixed_Discount_PromoCode_and_NewVehicle
	 * TC_16_Purchase_Future_Reservation_With_Fixed_Discount_PromoCode_and_ExistingVehicle
	 */

	/*
	 * This is a test case to purchase reservation with new vehicle and new card payment method
	 *
	 * Author : Pavan Prasad(pavanprasad.v@comakeit.com)
	 */

	@Test(groups = { "smoke", "regression" })
	public void TC_01_Purchase_Reservation_With_NewCard_and_NewVehicle() {
		vehicle.setLocationNumber(getRandomLocation());
		vehicle.setIsItFutureReservation(false);
		vehicle.setIsItNewCard(true);
		vehicle.setIsItNewVehicle(true);
		vehicle.setIsItNewSession(false);
		vehicle.setIsItNewReservation(true);
		vehicle.setPayOption("card");
		vehicle.setLicensePlateNumber(getRandomLicencePlate());

		spaLoginPage = launch_SPA_Application();
		accountsPage = spaLoginPage.login();
		spaHomePage = accountsPage.navigateToHomePage();
		locationPage = spaHomePage.navigate_To_LocationPage(vehicle.getLocationNumber());

		locationPage.purchase_Reservation(vehicle);
		locationPage.verify_Purchase_Details(vehicle);
	}

	/*
	 * This is a test case to purchase reservation with existing vehicle and new card payment method
	 *
	 * Author : Pavan Prasad(pavanprasad.v@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_02_Purchase_Reservation_With_NewCard_and_ExistingVehicle() {

		vehicle.setLocationNumber(getRandomLocation());
		vehicle.setIsItFutureReservation(false);
		vehicle.setIsItNewCard(true);
		vehicle.setIsItNewVehicle(false);
		vehicle.setIsItNewSession(false);
		vehicle.setIsItNewReservation(true);
		vehicle.setPayOption("card");
		vehicle.setLicensePlateNumber(Add_NewVehicle());
		spaHomePage = accountsPage.navigateToHomePage();
		locationPage = spaHomePage.navigate_To_LocationPage(vehicle.getLocationNumber());

		locationPage.purchase_Reservation(vehicle);
		locationPage.verify_Purchase_Details(vehicle);
	}

	/*
	 * This is a test case to purchase reservation with new vehicle and existing card payment method
	 *
	 * Author : Pavan Prasad(pavanprasad.v@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_03_Purchase_Reservation_With_ExistingCard_and_NewVehicle() {
		vehicle.setLocationNumber(getRandomLocation());
		vehicle.setIsItFutureReservation(false);
		vehicle.setIsItNewCard(false);
		vehicle.setIsItNewVehicle(true);
		vehicle.setIsItNewSession(false);
		vehicle.setIsItNewReservation(true);
		vehicle.setPayOption("card");
		vehicle.setLicensePlateNumber(getRandomLicencePlate());

		spaLoginPage = launch_SPA_Application();
		accountsPage = spaLoginPage.login();
		spaHomePage = accountsPage.navigateToHomePage();
		locationPage = spaHomePage.navigate_To_LocationPage(vehicle.getLocationNumber());

		locationPage.purchase_Reservation(vehicle);
		locationPage.verify_Purchase_Details(vehicle);
	}

	/*
	 * This is a test case to purchase reservation with existing vehicle and existing card payment method
	 *
	 * Author : Pavan Prasad(pavanprasad.v@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_04_Purchase_Reservation_With_ExistingCard_and_ExistingVehicle() {
		vehicle.setLocationNumber(getRandomLocation());
		vehicle.setIsItFutureReservation(false);
		vehicle.setLocationNumber("P094");
		vehicle.setIsItNewCard(false);
		vehicle.setIsItNewVehicle(false);
		vehicle.setIsItNewSession(false);
		vehicle.setIsItNewReservation(true);
		vehicle.setPayOption("card");

		vehicle.setLicensePlateNumber(Add_NewVehicle());
		spaHomePage = accountsPage.navigateToHomePage();
		locationPage = spaHomePage.navigate_To_LocationPage(vehicle.getLocationNumber());

		locationPage.purchase_Reservation(vehicle);
		locationPage.verify_Purchase_Details(vehicle);
	}

	/*
	 * This is a test case to purchase reservation with new vehicle and 100% discount promoCode payment method
	 *
	 * Author : Pavan Prasad(pavanprasad.v@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_05_Purchase_Reservation_With_100Percent_Discount_PromoCode_and_NewVehicle() {
		vehicle.setLocationNumber(getRandomLocation());
		vehicle.setIsItFutureReservation(false);
		vehicle.setIsItNewCard(false);
		vehicle.setIsItNewVehicle(true);
		vehicle.setIsItNewSession(false);
		vehicle.setIsItNewReservation(true);
		vehicle.setPayOption("promocode");
		vehicle.setLicensePlateNumber(getRandomLicencePlate());

		spaLoginPage = launch_SPA_Application();
		accountsPage = spaLoginPage.login();
		spaHomePage = accountsPage.navigateToHomePage();
		locationPage = spaHomePage.navigate_To_LocationPage(vehicle.getLocationNumber());

		locationPage.purchase_Reservation(vehicle);
		locationPage.verify_Purchase_Details(vehicle);
	}

	/*
	 * This is a test case to purchase reservation with existing vehicle and 100% discount promoCode payment method
	 *
	 * Author : Pavan Prasad(pavanprasad.v@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_06_Purchase_Reservation_With_100Percent_Discount_PromoCode_and_ExistingVehicle() {

		vehicle.setIsItFutureReservation(false);
		vehicle.setLocationNumber(getRandomLocation());
		vehicle.setIsItFutureReservation(false);
		vehicle.setIsItNewCard(false);
		vehicle.setIsItNewVehicle(false);
		vehicle.setIsItNewSession(false);
		vehicle.setIsItNewReservation(true);
		vehicle.setPayOption("promocode");

		vehicle.setLicensePlateNumber(Add_NewVehicle());
		spaHomePage = accountsPage.navigateToHomePage();

		locationPage = spaHomePage.navigate_To_LocationPage(vehicle.getLocationNumber());

		locationPage.purchase_Reservation(vehicle);
		locationPage.verify_Purchase_Details(vehicle);
	}

	/*
	 * This is a test case to purchase future reservation with new vehicle and new card payment method
	 *
	 * Author : Pavan Prasad(pavanprasad.v@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_07_Purchase_Future_Reservation_With_NewCard_and_NewVehicle() {
		vehicle.setLocationNumber(getRandomLocation());
		vehicle.setIsItFutureReservation(true);
		vehicle.setIsItNewCard(true);
		vehicle.setIsItNewVehicle(true);
		vehicle.setIsItNewSession(false);
		vehicle.setIsItNewReservation(true);
		vehicle.setPayOption("card");
		vehicle.setLicensePlateNumber(getRandomLicencePlate());

		spaLoginPage = launch_SPA_Application();
		accountsPage = spaLoginPage.login();
		spaHomePage = accountsPage.navigateToHomePage();
		locationPage = spaHomePage.navigate_To_LocationPage(vehicle.getLocationNumber());

		locationPage.purchase_Reservation(vehicle);
		locationPage.verify_Purchase_Details(vehicle);
	}

	/*
	 * This is a test case to purchase future reservation with existing vehicle and new card payment method
	 *
	 * Author : Pavan Prasad(pavanprasad.v@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_08_Purchase_Future_Reservation_With_NewCard_and_ExistingVehicle() {

		vehicle.setLocationNumber(getRandomLocation());
		vehicle.setIsItFutureReservation(true);
		vehicle.setIsItNewCard(true);
		vehicle.setIsItNewVehicle(false);
		vehicle.setIsItNewSession(false);
		vehicle.setIsItNewReservation(true);
		vehicle.setPayOption("card");

		vehicle.setLicensePlateNumber(Add_NewVehicle());
		spaHomePage = accountsPage.navigateToHomePage();
		locationPage = spaHomePage.navigate_To_LocationPage(vehicle.getLocationNumber());

		locationPage.purchase_Reservation(vehicle);
		locationPage.verify_Purchase_Details(vehicle);
	}

	/*
	 * This is a test case to purchase future reservation with new vehicle and existing card payment method
	 *
	 * Author : Pavan Prasad(pavanprasad.v@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_09_Purchase_Future_Reservation_With_ExistingCard_and_NewVehicle() {
		vehicle.setLocationNumber(getRandomLocation());
		vehicle.setIsItFutureReservation(true);
		vehicle.setIsItNewCard(false);
		vehicle.setIsItNewVehicle(true);
		vehicle.setIsItNewSession(false);
		vehicle.setIsItNewReservation(true);
		vehicle.setPayOption("card");
		vehicle.setLicensePlateNumber(getRandomLicencePlate());

		spaLoginPage = launch_SPA_Application();
		accountsPage = spaLoginPage.login();
		spaHomePage = accountsPage.navigateToHomePage();
		locationPage = spaHomePage.navigate_To_LocationPage(vehicle.getLocationNumber());

		locationPage.purchase_Reservation(vehicle);
		locationPage.verify_Purchase_Details(vehicle);
	}

	/*
	 * This is a test case to purchase future reservation with existing vehicle and existing card payment method
	 *
	 * Author : Pavan Prasad(pavanprasad.v@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_10_Purchase_Future_Reservation_With_ExistingCard_and_ExistingVehicle() {

		vehicle.setIsItFutureReservation(true);
		vehicle.setLocationNumber(getRandomLocation());
		vehicle.setIsItNewCard(false);
		vehicle.setIsItNewVehicle(false);
		vehicle.setIsItNewSession(false);
		vehicle.setIsItNewReservation(true);
		vehicle.setPayOption("card");

		vehicle.setLicensePlateNumber(Add_NewVehicle());
		spaHomePage = accountsPage.navigateToHomePage();
		locationPage = spaHomePage.navigate_To_LocationPage(vehicle.getLocationNumber());

		locationPage.purchase_Reservation(vehicle);
		locationPage.verify_Purchase_Details(vehicle);
	}

	/*
	 * This is a test case to purchase future reservation with new vehicle and 100% discount promoCode payment method
	 *
	 * Author : Pavan Prasad(pavanprasad.v@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_11_Purchase_Future_Reservation_With_100Percent_Discount_PromoCode_and_NewVehicle() {
		vehicle.setLocationNumber(getRandomLocation());
		vehicle.setIsItFutureReservation(true);
		vehicle.setIsItNewCard(false);
		vehicle.setIsItNewVehicle(true);
		vehicle.setIsItNewSession(false);
		vehicle.setIsItNewReservation(true);
		vehicle.setPayOption("promocode");
		vehicle.setLicensePlateNumber(getRandomLicencePlate());

		spaLoginPage = launch_SPA_Application();
		accountsPage = spaLoginPage.login();
		spaHomePage = accountsPage.navigateToHomePage();
		locationPage = spaHomePage.navigate_To_LocationPage(vehicle.getLocationNumber());

		locationPage.purchase_Reservation(vehicle);
		locationPage.verify_Purchase_Details(vehicle);
	}

	/*
	 * This is a test case to purchase future reservation with existing vehicle and 100% discount promoCode payment method
	 *
	 * Author : Pavan Prasad(pavanprasad.v@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_12_Purchase_Future_Reservation_With_100Percent_Discount_PromoCode_and_ExistingVehicle() {

		vehicle.setLocationNumber(getRandomLocation());
		vehicle.setIsItFutureReservation(true);
		vehicle.setIsItNewCard(false);
		vehicle.setIsItNewVehicle(false);
		vehicle.setIsItNewSession(false);
		vehicle.setIsItNewReservation(true);
		vehicle.setPayOption("promocode");

		vehicle.setLicensePlateNumber(Add_NewVehicle());
		spaHomePage = accountsPage.navigateToHomePage();
		locationPage = spaHomePage.navigate_To_LocationPage(vehicle.getLocationNumber());

		locationPage.purchase_Reservation(vehicle);
		locationPage.verify_Purchase_Details(vehicle);
	}

	/*
	 * This is a test case to purchase reservation with new vehicle and fixed discount promoCode payment method
	 *
	 * Author : Pavan Prasad(pavanprasad.v@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_13_Purchase_Reservation_With_Fixed_Discount_PromoCode_and_NewVehicle() {
		vehicle.setLocationNumber(getRandomLocation());
		vehicle.setIsItFutureReservation(false);
		vehicle.setIsItNewCard(false);
		vehicle.setIsItNewVehicle(true);
		vehicle.setIsItNewSession(false);
		vehicle.setIsItNewReservation(true);
		vehicle.setPayOption("fixedPromoCode");
		vehicle.setLicensePlateNumber(getRandomLicencePlate());

		spaLoginPage = launch_SPA_Application();
		accountsPage = spaLoginPage.login();
		spaHomePage = accountsPage.navigateToHomePage();
		locationPage = spaHomePage.navigate_To_LocationPage(vehicle.getLocationNumber());

		locationPage.purchase_Reservation(vehicle);
		locationPage.verify_Purchase_Details(vehicle);
	}

	/*
	 * This is a test case to purchase reservation with existing vehicle and fixed discount promoCode payment method
	 *
	 * Author : Pavan Prasad(pavanprasad.v@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_14_Purchase_Reservation_With_Fixed_Discount_PromoCode_and_ExistingVehicle() {

		vehicle.setIsItFutureReservation(false);
		vehicle.setLocationNumber(getRandomLocation());
		vehicle.setIsItFutureReservation(false);
		vehicle.setIsItNewCard(false);
		vehicle.setIsItNewVehicle(false);
		vehicle.setIsItNewSession(false);
		vehicle.setIsItNewReservation(true);
		vehicle.setPayOption("fixedPromoCode");

		vehicle.setLicensePlateNumber(Add_NewVehicle());
		spaHomePage = accountsPage.navigateToHomePage();

		locationPage = spaHomePage.navigate_To_LocationPage(vehicle.getLocationNumber());

		locationPage.purchase_Reservation(vehicle);
		locationPage.verify_Purchase_Details(vehicle);
	}

	/*
	 * This is a test case to purchase future reservation with new vehicle and fixed discount promoCode payment method
	 *
	 * Author : Pavan Prasad(pavanprasad.v@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_15_Purchase_Future_Reservation_With_Fixed_Discount_PromoCode_and_NewVehicle() {
		vehicle.setLocationNumber(getRandomLocation());
		vehicle.setIsItFutureReservation(true);
		vehicle.setIsItNewCard(false);
		vehicle.setIsItNewVehicle(true);
		vehicle.setIsItNewSession(false);
		vehicle.setIsItNewReservation(true);
		vehicle.setPayOption("fixedPromoCode");
		vehicle.setLicensePlateNumber(getRandomLicencePlate());

		spaLoginPage = launch_SPA_Application();
		accountsPage = spaLoginPage.login();
		spaHomePage = accountsPage.navigateToHomePage();
		locationPage = spaHomePage.navigate_To_LocationPage(vehicle.getLocationNumber());

		locationPage.purchase_Reservation(vehicle);
		locationPage.verify_Purchase_Details(vehicle);
	}

	/*
	 * This is a test case to purchase future reservation with existing vehicle and fixed discount promoCode payment method
	 *
	 * Author : Pavan Prasad(pavanprasad.v@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_16_Purchase_Future_Reservation_With_Fixed_Discount_PromoCode_and_ExistingVehicle() {

		vehicle.setLocationNumber(getRandomLocation());
		vehicle.setIsItFutureReservation(true);
		vehicle.setIsItNewCard(false);
		vehicle.setIsItNewVehicle(false);
		vehicle.setIsItNewSession(false);
		vehicle.setIsItNewReservation(true);
		vehicle.setPayOption("fixedPromoCode");

		vehicle.setLicensePlateNumber(Add_NewVehicle());
		spaHomePage = accountsPage.navigateToHomePage();
		locationPage = spaHomePage.navigate_To_LocationPage(vehicle.getLocationNumber());

		locationPage.purchase_Reservation(vehicle);
		locationPage.verify_Purchase_Details(vehicle);
	}
}
