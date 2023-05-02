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

	// ****************** TEST DATA ****************************//
	Vehicle vehicle = (Vehicle) xml_Ops.getTestData("vehicle");

	// ****************** TEST SCRIPTS ****************************//

	/*
	 * TC_01_Purchase_Session_With_NewCard_and_NewVehicle
	 * TC_02_Purchase_Session_With_NewCard_and_ExistingVehicle
	 * TC_03_Purchase_Session_With_ExistingCard_and_NewVehicle
	 * TC_04_Purchase_Session_With_ExistingCard_and_ExistingVehicle
	 * TC_05_Purchase_Session_With_100%Discount_PromoCode_and_NewVehicle
	 * TC_06_Purchase_Session_With_100%Discount_PromoCode_and_ExistingVehicle
	 * TC_07_Purchase_And_Extend_Session_With_NewCard
	 * TC_08_Purchase_And_Extend_Session_With_ExistingCard
	 * TC_09_Purchase_Session_With_NewCard_and_Extend_with_ExistingCard
	 * TC_10_Purchase_Session_With_NewCard_and_Extend_with_100%Discount_PromoCode
	 * TC_11_Purchase_Session_With_ExistingCard_and_Extend_with_NewCard
	 * TC_12_Purchase_Session_With_ExistingCard_and_Extend_with_100%Discount_PromoCode
	 * TC_13_Purchase_Session_With_100%Discount_PromoCode_and_Extend_with_NewCard
	 * TC_14_Purchase_Session_With_100%Discount_PromoCode_and_Extend_with_ExistingCard
	 * TC_15_Purchase_Session_With_Fixed_Discount_PromoCode_and_NewVehicle
	 * TC_16_Purchase_Session_With_Fixed_Discount_PromoCode_and_ExistingVehicle
	 * TC_17_Purchase_Session_With_NewCard_and_Extend_with_Fixed_Discount_PromoCode
	 * TC_18_Purchase_Session_With_ExistingCard_and_Extend_with_Fixed_Discount_PromoCode
	 * TC_19_Purchase_Session_With_Fixed_Discount_PromoCode_and_Extend_with_NewCard
	 * TC_20_Purchase_Session_With_Fixed_Discount_PromoCode_and_Extend_with_ExistingCard
	 */

	/*
	 * This is a test case to purchase session with new vehicle and new card payment method
	 *
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_01_Purchase_Session_With_NewCard_and_NewVehicle() {

		vehicle.setIsItNewCard(true);
		vehicle.setIsItNewVehicle(true);
		vehicle.setIsItNewSession(true);
		vehicle.setIsItNewReservation(false);
		vehicle.setPayOption("card");
		vehicle.setLocationNumber(getRandomLocation());
		vehicle.setLicensePlateNumber(getRandomLicencePlate());

		spaLoginPage = launch_SPA_Application();
		accountsPage = spaLoginPage.login();
		spaHomePage = accountsPage.navigateToHomePage();
		locationPage = spaHomePage.navigate_To_LocationPage(vehicle.getLocationNumber());

		locationPage.purchase_Session(vehicle);
		locationPage.verify_Purchase_Details(vehicle);
	}

	/*
	 * This is a test case to purchase session with existing vehicle and new card payment method
	 *
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_02_Purchase_Session_With_NewCard_and_ExistingVehicle() {
		vehicle.setLocationNumber(getRandomLocation());
		vehicle.setIsItNewCard(true);
		vehicle.setIsItNewVehicle(false);
		vehicle.setIsItNewSession(true);
		vehicle.setIsItNewReservation(false);
		vehicle.setPayOption("card");
		vehicle.setTimeInHours("1");
		vehicle.setLicensePlateNumber(Add_NewVehicle());
		spaHomePage = accountsPage.navigateToHomePage();
		locationPage = spaHomePage.navigate_To_LocationPage(vehicle.getLocationNumber());

		locationPage.purchase_Session(vehicle);
		locationPage.verify_Purchase_Details(vehicle);
	}

	/*
	 * This is a test case to purchase session with new vehicle and existing card payment method
	 *
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_03_Purchase_Session_With_ExistingCard_and_NewVehicle() {
		vehicle.setLocationNumber(getRandomLocation());
		vehicle.setIsItNewCard(false);
		vehicle.setIsItNewVehicle(true);
		vehicle.setIsItNewSession(true);
		vehicle.setIsItNewReservation(false);
		vehicle.setPayOption("card");
		vehicle.setLicensePlateNumber(getRandomLicencePlate());

		spaLoginPage = launch_SPA_Application();
		accountsPage = spaLoginPage.login();
		spaHomePage = accountsPage.navigateToHomePage();
		locationPage = spaHomePage.navigate_To_LocationPage(vehicle.getLocationNumber());

		locationPage.purchase_Session(vehicle);
		locationPage.verify_Purchase_Details(vehicle);
	}

	/*
	 * This is a test case to purchase session with existing vehicle and existing card payment method
	 *
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_04_Purchase_Session_With_ExistingCard_and_ExistingVehicle() {

		vehicle.setLocationNumber(getRandomLocation());
		vehicle.setIsItNewCard(false);
		vehicle.setIsItNewVehicle(false);
		vehicle.setIsItNewSession(true);
		vehicle.setIsItNewReservation(false);
		vehicle.setPayOption("card");
		vehicle.setTimeInHours("1");
		
		vehicle.setLicensePlateNumber(Add_NewVehicle());
		spaHomePage = accountsPage.navigateToHomePage();

		locationPage = spaHomePage.navigate_To_LocationPage(vehicle.getLocationNumber());

		locationPage.purchase_Session(vehicle);
		locationPage.verify_Purchase_Details(vehicle);
	}

	/*
	 * This is a test case to purchase session with new vehicle and 100% discount promoCode
	 *
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_05_Purchase_Session_With_100Percent_Discount_PromoCode_and_NewVehicle() {
		vehicle.setLocationNumber(getRandomLocation());
		vehicle.setIsItNewCard(true);
		vehicle.setIsItNewVehicle(true);
		vehicle.setIsItNewSession(true);
		vehicle.setIsItNewReservation(false);
		vehicle.setPayOption("promocode");
		vehicle.setTimeInHours("1");
		vehicle.setLicensePlateNumber(getRandomLicencePlate());

		spaLoginPage = launch_SPA_Application();
		accountsPage = spaLoginPage.login();
		spaHomePage = accountsPage.navigateToHomePage();

		locationPage = spaHomePage.navigate_To_LocationPage(vehicle.getLocationNumber());

		locationPage.purchase_Session(vehicle);
		locationPage.verify_Purchase_Details(vehicle);
	}

	/*
	 * This is a test case to purchase session with existing vehicle and 100% discount promoCode
	 *
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_06_Purchase_Session_With_100Percent_Discount_PromoCode_and_ExistingVehicle() {
		vehicle.setLocationNumber(getRandomLocation());
		vehicle.setIsItNewCard(true);
		vehicle.setIsItNewVehicle(false);
		vehicle.setIsItNewSession(true);
		vehicle.setIsItNewReservation(false);
		vehicle.setPayOption("promocode");
		vehicle.setTimeInHours("1");
		
		vehicle.setLicensePlateNumber(Add_NewVehicle());
		spaHomePage = accountsPage.navigateToHomePage();
		locationPage = spaHomePage.navigate_To_LocationPage(vehicle.getLocationNumber());

		locationPage.purchase_Session(vehicle);
		locationPage.verify_Purchase_Details(vehicle);
	}

	/*
	 * This is a test case to purchase and extend session using new card payment
	 *
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_07_Purchase_And_Extend_Session_With_NewCard() {
		vehicle.setLocationNumber(getRandomLocation());
		vehicle.setIsItNewCard(true);
		vehicle.setIsItNewVehicle(true);
		vehicle.setIsItNewSession(true);
		vehicle.setIsItNewReservation(false);
		vehicle.setPayOption("card");
		vehicle.setLicensePlateNumber(getRandomLicencePlate());

		spaLoginPage = launch_SPA_Application();
		accountsPage = spaLoginPage.login();
		spaHomePage = accountsPage.navigateToHomePage();
		locationPage = spaHomePage.navigate_To_LocationPage(vehicle.getLocationNumber());

		locationPage.purchase_Session(vehicle);
		locationPage.verify_Purchase_Details(vehicle);
		locationPage.extend_Session(vehicle);
		locationPage.verify_Purchase_Details(vehicle);
	}

	/*
	 * This is a test case to purchase and extend session using existing card payment
	 *
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_08_Purchase_And_Extend_Session_With_ExistingCard() {
		vehicle.setLocationNumber(getRandomLocation());
		vehicle.setIsItNewCard(false);
		vehicle.setIsItNewVehicle(true);
		vehicle.setIsItNewSession(true);
		vehicle.setIsItNewReservation(false);
		vehicle.setPayOption("card");
		vehicle.setLicensePlateNumber(getRandomLicencePlate());

		spaLoginPage = launch_SPA_Application();
		accountsPage = spaLoginPage.login();
		spaHomePage = accountsPage.navigateToHomePage();
		locationPage = spaHomePage.navigate_To_LocationPage(vehicle.getLocationNumber());

		locationPage.purchase_Session(vehicle);
		locationPage.verify_Purchase_Details(vehicle);
		locationPage.extend_Session(vehicle);
		locationPage.verify_Purchase_Details(vehicle);
	}

	/*
	 * This is a test case to purchase session with new card payment and extend with existing card
	 *
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_09_Purchase_Session_With_NewCard_and_Extend_with_ExistingCard() {
		vehicle.setLocationNumber(getRandomLocation());
		vehicle.setIsItNewCard(true);
		vehicle.setIsItNewVehicle(true);
		vehicle.setIsItNewSession(true);
		vehicle.setIsItNewReservation(false);
		vehicle.setPayOption("card");
		vehicle.setLicensePlateNumber(getRandomLicencePlate());

		spaLoginPage = launch_SPA_Application();
		accountsPage = spaLoginPage.login();
		spaHomePage = accountsPage.navigateToHomePage();
		locationPage = spaHomePage.navigate_To_LocationPage(vehicle.getLocationNumber());

		locationPage.purchase_Session(vehicle);
		locationPage.verify_Purchase_Details(vehicle);
		vehicle.setIsItNewCard(false);
		locationPage.extend_Session(vehicle);
		locationPage.verify_Purchase_Details(vehicle);
	}

	/*
	 * This is a test case to purchase session with new card payment and extend with 100% discount promoCode
	 *
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_10_Purchase_Session_With_NewCard_and_Extend_with_100Percent_Discount_PromoCode() {
		vehicle.setLocationNumber(getRandomLocation());
		vehicle.setIsItNewCard(true);
		vehicle.setIsItNewVehicle(true);
		vehicle.setIsItNewSession(true);
		vehicle.setIsItNewReservation(false);
		vehicle.setPayOption("card");
		vehicle.setLicensePlateNumber(getRandomLicencePlate());

		spaLoginPage = launch_SPA_Application();
		accountsPage = spaLoginPage.login();
		spaHomePage = accountsPage.navigateToHomePage();
		locationPage = spaHomePage.navigate_To_LocationPage(vehicle.getLocationNumber());

		locationPage.purchase_Session(vehicle);
		locationPage.verify_Purchase_Details(vehicle);
		vehicle.setIsItNewCard(false);
		vehicle.setPayOption("promocode");
		locationPage.extend_Session(vehicle);
		locationPage.verify_Purchase_Details(vehicle);
	}

	/*
	 * This is a test case to purchase session with existing card payment and extend with new card
	 *
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_11_Purchase_Session_With_ExistingCard_and_Extend_with_NewCard() {
		vehicle.setLocationNumber(getRandomLocation());
		vehicle.setIsItNewCard(false);
		vehicle.setIsItNewVehicle(true);
		vehicle.setIsItNewSession(true);
		vehicle.setIsItNewReservation(false);
		vehicle.setPayOption("card");
		vehicle.setLicensePlateNumber(getRandomLicencePlate());

		spaLoginPage = launch_SPA_Application();
		accountsPage = spaLoginPage.login();
		spaHomePage = accountsPage.navigateToHomePage();
		locationPage = spaHomePage.navigate_To_LocationPage(vehicle.getLocationNumber());

		locationPage.purchase_Session(vehicle);
		locationPage.verify_Purchase_Details(vehicle);
		vehicle.setIsItNewCard(true);
		locationPage.extend_Session(vehicle);
		locationPage.verify_Purchase_Details(vehicle);
	}

	/*
	 * This is a test case to purchase session with existing card payment and extend with 100% discount promoCode
	 *
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_12_Purchase_Session_With_ExistingCard_and_Extend_with_100Percent_Discount_PromoCode() {
		vehicle.setLocationNumber(getRandomLocation());
		vehicle.setIsItNewCard(false);
		vehicle.setIsItNewVehicle(true);
		vehicle.setIsItNewSession(true);
		vehicle.setIsItNewReservation(false);
		vehicle.setPayOption("card");
		vehicle.setLicensePlateNumber(getRandomLicencePlate());

		spaLoginPage = launch_SPA_Application();
		accountsPage = spaLoginPage.login();
		spaHomePage = accountsPage.navigateToHomePage();
		locationPage = spaHomePage.navigate_To_LocationPage(vehicle.getLocationNumber());

		locationPage.purchase_Session(vehicle);
		locationPage.verify_Purchase_Details(vehicle);
		vehicle.setPayOption("promocode");
		locationPage.extend_Session(vehicle);
		locationPage.verify_Purchase_Details(vehicle);
	}

	/*
	 * This is a test case to purchase session with 100% discount promoCode card payment and extend with new card
	 *
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_13_Purchase_Session_With_100Percent_Discount_PromoCode_and_Extend_with_NewCard() {
		vehicle.setLocationNumber(getRandomLocation());
		vehicle.setIsItNewCard(false);
		vehicle.setIsItNewVehicle(true);
		vehicle.setIsItNewSession(true);
		vehicle.setIsItNewReservation(false);
		vehicle.setPayOption("promocode");
		vehicle.setLicensePlateNumber(getRandomLicencePlate());

		spaLoginPage = launch_SPA_Application();
		accountsPage = spaLoginPage.login();
		spaHomePage = accountsPage.navigateToHomePage();
		locationPage = spaHomePage.navigate_To_LocationPage(vehicle.getLocationNumber());

		locationPage.purchase_Session(vehicle);
		locationPage.verify_Purchase_Details(vehicle);
		vehicle.setPayOption("card");
		vehicle.setIsItNewCard(true);
		locationPage.extend_Session(vehicle);
		locationPage.verify_Purchase_Details(vehicle);
	}

	/*
	 * This is a test case to purchase session with existing card payment and extend with 100% discount promoCode
	 *
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_14_Purchase_Session_With_100Percent_Discount_PromoCode_and_Extend_with_ExistingCard() {
		vehicle.setLocationNumber(getRandomLocation());
		vehicle.setIsItNewCard(false);
		vehicle.setIsItNewVehicle(true);
		vehicle.setIsItNewSession(true);
		vehicle.setIsItNewReservation(false);
		vehicle.setPayOption("promocode");
		vehicle.setLicensePlateNumber(getRandomLicencePlate());

		spaLoginPage = launch_SPA_Application();
		accountsPage = spaLoginPage.login();
		spaHomePage = accountsPage.navigateToHomePage();
		locationPage = spaHomePage.navigate_To_LocationPage(vehicle.getLocationNumber());

		locationPage.purchase_Session(vehicle);
		locationPage.verify_Purchase_Details(vehicle);
		vehicle.setPayOption("card");
		vehicle.setIsItNewCard(false);
		locationPage.extend_Session(vehicle);
		locationPage.verify_Purchase_Details(vehicle);
	}

	/*
	 * This is a test case to purchase session with fixed discount promoCode and new vehicle
	 *
	 * Author : Pavan Prasad(pavanprasad.v@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_15_Purchase_Session_With_Fixed_Discount_PromoCode_and_NewVehicle() {
		vehicle.setLocationNumber(getRandomLocation());
		vehicle.setIsItNewCard(false);
		vehicle.setIsItNewVehicle(true);
		vehicle.setIsItNewSession(true);
		vehicle.setIsItNewReservation(false);
		vehicle.setPayOption("fixedPromoCode");
		vehicle.setTimeInHours("1");
		vehicle.setLicensePlateNumber(getRandomLicencePlate());

		spaLoginPage = launch_SPA_Application();
		accountsPage = spaLoginPage.login();
		spaHomePage = accountsPage.navigateToHomePage();

		locationPage = spaHomePage.navigate_To_LocationPage(vehicle.getLocationNumber());

		locationPage.purchase_Session(vehicle);
		locationPage.verify_Purchase_Details(vehicle);
	}

	/*
	 * This is a test case to purchase session with fixed discount promoCode and existing vehicle
	 *
	 * Author : Pavan Prasad(pavanprasad.v@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_16_Purchase_Session_With_Fixed_Discount_PromoCode_and_ExistingVehicle() {
		vehicle.setLocationNumber(getRandomLocation());
		vehicle.setIsItNewCard(false);
		vehicle.setIsItNewVehicle(false);
		vehicle.setIsItNewSession(true);
		vehicle.setIsItNewReservation(false);
		vehicle.setPayOption("fixedPromoCode");
		vehicle.setTimeInHours("1");

		vehicle.setLicensePlateNumber(Add_NewVehicle());
		spaHomePage = accountsPage.navigateToHomePage();
		locationPage = spaHomePage.navigate_To_LocationPage(vehicle.getLocationNumber());

		locationPage.purchase_Session(vehicle);
		locationPage.verify_Purchase_Details(vehicle);
	}

	/*
	 * This is a test case to purchase session with new card and extend with fixed discount promoCode
	 *
	 * Author : Pavan Prasad(pavanprasad.v@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_17_Purchase_Session_With_NewCard_and_Extend_with_Fixed_Discount_PromoCode() {
		vehicle.setLocationNumber(getRandomLocation());
		vehicle.setIsItNewCard(true);
		vehicle.setIsItNewVehicle(true);
		vehicle.setIsItNewSession(true);
		vehicle.setIsItNewReservation(false);
		vehicle.setPayOption("card");
		vehicle.setLicensePlateNumber(getRandomLicencePlate());

		spaLoginPage = launch_SPA_Application();
		accountsPage = spaLoginPage.login();
		spaHomePage = accountsPage.navigateToHomePage();
		locationPage = spaHomePage.navigate_To_LocationPage(vehicle.getLocationNumber());

		locationPage.purchase_Session(vehicle);
		locationPage.verify_Purchase_Details(vehicle);
		vehicle.setIsItNewCard(false);
		vehicle.setPayOption("fixedPromoCode");
		locationPage.extend_Session(vehicle);
		locationPage.verify_Purchase_Details(vehicle);
	}

	/*
	 * This is a test case to purchase session with existing card and extend with fixed discount promoCode
	 *
	 * Author : Pavan Prasad(pavanprasad.v@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_18_Purchase_Session_With_ExistingCard_and_Extend_with_Fixed_Discount_PromoCode() {
		vehicle.setLocationNumber(getRandomLocation());
		vehicle.setIsItNewCard(false);
		vehicle.setIsItNewVehicle(true);
		vehicle.setIsItNewSession(true);
		vehicle.setIsItNewReservation(false);
		vehicle.setPayOption("card");
		vehicle.setLicensePlateNumber(getRandomLicencePlate());

		spaLoginPage = launch_SPA_Application();
		accountsPage = spaLoginPage.login();
		spaHomePage = accountsPage.navigateToHomePage();
		locationPage = spaHomePage.navigate_To_LocationPage(vehicle.getLocationNumber());

		locationPage.purchase_Session(vehicle);
		locationPage.verify_Purchase_Details(vehicle);
		vehicle.setIsItNewCard(false);
		vehicle.setPayOption("fixedPromoCode");
		locationPage.extend_Session(vehicle);
		locationPage.verify_Purchase_Details(vehicle);
	}

	/*
	 * This is a test case to purchase session with existing card and extend with fixed discount promoCode
	 *
	 * Author : Pavan Prasad(pavanprasad.v@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_19_Purchase_Session_With_Fixed_Discount_PromoCode_and_Extend_with_NewCard() {
		vehicle.setLocationNumber(getRandomLocation());
		vehicle.setIsItNewCard(false);
		vehicle.setIsItNewVehicle(true);
		vehicle.setIsItNewSession(true);
		vehicle.setIsItNewReservation(false);
		vehicle.setPayOption("fixedPromoCode");
		vehicle.setLicensePlateNumber(getRandomLicencePlate());

		spaLoginPage = launch_SPA_Application();
		accountsPage = spaLoginPage.login();
		spaHomePage = accountsPage.navigateToHomePage();
		locationPage = spaHomePage.navigate_To_LocationPage(vehicle.getLocationNumber());

		locationPage.purchase_Session(vehicle);
		locationPage.verify_Purchase_Details(vehicle);
		vehicle.setIsItNewCard(true);
		vehicle.setPayOption("card");
		locationPage.extend_Session(vehicle);
		locationPage.verify_Purchase_Details(vehicle);
	}

	/*
	 * This is a test case to purchase session with existing card payment and extend with fixed discount promoCode
	 *
	 * Author : Pavan Prasad(pavanprasad.v@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_20_Purchase_Session_With_Fixed_Discount_PromoCode_and_Extend_with_ExistingCard() {
		vehicle.setLocationNumber(getRandomLocation());
		vehicle.setIsItNewCard(false);
		vehicle.setIsItNewVehicle(true);
		vehicle.setIsItNewSession(true);
		vehicle.setIsItNewReservation(false);
		vehicle.setPayOption("fixedPromoCode");
		vehicle.setLicensePlateNumber(getRandomLicencePlate());

		spaLoginPage = launch_SPA_Application();
		accountsPage = spaLoginPage.login();
		spaHomePage = accountsPage.navigateToHomePage();
		locationPage = spaHomePage.navigate_To_LocationPage(vehicle.getLocationNumber());

		locationPage.purchase_Session(vehicle);
		locationPage.verify_Purchase_Details(vehicle);
		vehicle.setIsItNewCard(false);
		vehicle.setPayOption("card");
		locationPage.extend_Session(vehicle);
		locationPage.verify_Purchase_Details(vehicle);
	}

}



















































