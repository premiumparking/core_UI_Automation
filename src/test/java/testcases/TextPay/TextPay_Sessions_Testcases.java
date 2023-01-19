package testcases.TextPay;

import components.BaseClass;
import dataModel.TextPay.Guest;
import dataModel.TextPay.PurchaseDetails;

import org.testng.annotations.Test;

import pageObjects.TextPay.TextPay_HomePage;
import utils.XML_Operations;

public class TextPay_Sessions_Testcases extends BaseClass {
	// ****************** CLASS INSTANCES ****************************//
	XML_Operations xml_Ops = new XML_Operations();
	TextPay_HomePage tp_HomePage = new TextPay_HomePage();
	PurchaseDetails purchaseDetails = new PurchaseDetails();

	// ****************** TEST DATA ****************************//
	Guest guest = (Guest) xml_Ops.getTestData("guest");

	// ****************** TEST SCRIPTS ****************************//

	/*
	 * TC_01_Purchase_Regular_Space_as_Guest_With_NewCard_and_NewVehicle
	 * TC_02_Purchase_Regular_Space_as_Guest_With_PromoCode_and_NewVehicle
	 * TC_03_Purchase_Regular_Space_as_Guest_for_UnknownVehicle_with_NewCard
	 * TC_04_Purchase_Regular_Space_as_Guest_for_UnknownVehicle_with_PromoCode
	 * TC_05_Purchase_Star_Space_as_Guest_With_NewCard_and_NewVehicle
	 * TC_06_Purchase_Star_Space_as_Guest_With_PromoCode_and_NewVehicle
	 * TC_07_Purchase_Star_Space_as_Guest_for_UnknownVehicle_with_NewCard
	 * TC_08_Purchase_Star_Space_as_Guest_for_UnknownVehicle_with_PromoCode
	 * TC_09_Purchase_Charging_Space_as_Guest_With_NewCard_and_NewVehicle
	 * TC_10_Purchase_Charging_Space_as_Guest_With_PromoCode_and_NewVehicle
	 * TC_11_Purchase_Charging_Space_as_Guest_for_UnknownVehicle_with_NewCard
	 * TC_12_Purchase_Charging_Space_as_Guest_for_UnknownVehicle_with_PromoCode
	 */

	/*
	 * This is a test case to purchase regular space session as a guest with new
	 * vehicle and new payment method
	 *
	 * Author : Pavan Prasad(pavanprasad.v@comakeit.com)
	 */

	@Test(groups = { "smoke", "regression" })
	public void TC_01_Purchase_Regular_Space_as_Guest_With_NewCard_and_NewVehicle() {

		String licencePlate = getRandomLicencePlate();
		guest.setLicensePlateNumber(licencePlate);
		guest.setVehicleType("newVehicle");
		guest.setParkingType("Regular Space");
		guest.setPaymentVia("card");
		guest.setCcNumber("4242424242424242");
		tp_HomePage = launch_TextPay_Application();
		tp_HomePage.purchase_Session_AsGuest(guest);
		tp_HomePage.verify_Purchase_Details(guest, purchaseDetails);

		// Set the purchase details for location revenue page verification
		purchaseDetails.setChannel("TextPay");
		purchaseDetails.setPurchaseType("Session");
		purchaseDetails.setPaymentOption("card");
		purchaseDetails.setPaymentOption("card");
		purchaseDetails.setPaymentMethod("Visa **** 4242");

		tp_HomePage.verify_LocationRevenuePage(purchaseDetails);

	}

	/*
	 * This is a test case to purchase regular space session as a guest with new
	 * vehicle and promocode payment method
	 *
	 * Author : Pavan Prasad(pavanprasad.v@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_02_Purchase_Regular_Space_as_Guest_With_PromoCode_and_NewVehicle() {

		guest.setLicensePlateNumber(getRandomLicencePlate());
		guest.setVehicleType("newVehicle");
		guest.setParkingType("Regular Space");
		guest.setPaymentVia("promocode");
		tp_HomePage = launch_TextPay_Application();
		tp_HomePage.purchase_Session_AsGuest(guest);
		tp_HomePage.verify_Purchase_Details(guest, purchaseDetails);
		
		// Set the purchase details for location revenue page verification
		purchaseDetails.setChannel("TextPay");
		purchaseDetails.setPurchaseType("Session");
		purchaseDetails.setPaymentOption("promocode");
		purchaseDetails.setPromocode("PROMO100");

		tp_HomePage.verify_LocationRevenuePage(purchaseDetails);

	}

	/*
	 * This is a test case to purchase regular space session as a guest for unknown
	 * vehicle with new card payment method
	 *
	 * Author : Pavan Prasad(pavanprasad.v@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_03_Purchase_Regular_Space_as_Guest_for_UnknownVehicle_with_NewCard() {

		guest.setLicensePlateNumber(getRandomLicencePlate());
		guest.setVehicleType("unknownVehicle");
		guest.setParkingType("Regular Space");
		guest.setPaymentVia("card");
		tp_HomePage = launch_TextPay_Application();
		tp_HomePage.purchase_Session_AsGuest(guest);
		tp_HomePage.verify_Purchase_Details(guest, purchaseDetails);
	}

	/*
	 * This is a test case to purchase regular space session as a guest for unknown
	 * vehicle with promocode payment method
	 *
	 * Author : Pavan Prasad(pavanprasad.v@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_04_Purchase_Regular_Space_as_Guest_for_UnknownVehicle_with_PromoCode() {

		guest.setLicensePlateNumber(getRandomLicencePlate());
		guest.setVehicleType("unknownVehicle");
		guest.setParkingType("Regular Space");
		guest.setPaymentVia("promocode");
		tp_HomePage = launch_TextPay_Application();
		tp_HomePage.purchase_Session_AsGuest(guest);
		tp_HomePage.verify_Purchase_Details(guest, purchaseDetails);
	}

	/*
	 * This is a test case to purchase star space session as a guest for unknown
	 * vehicle with promocode payment method
	 *
	 * Author : Pavan Prasad(pavanprasad.v@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_05_Purchase_Star_Space_as_Guest_With_NewCard_and_NewVehicle() {

		guest.setLicensePlateNumber(getRandomLicencePlate());
		guest.setVehicleType("newVehicle");
		guest.setParkingType("Star Space");
		guest.setPaymentVia("card");
		tp_HomePage = launch_TextPay_Application();
		tp_HomePage.purchase_Session_AsGuest(guest);
		tp_HomePage.verify_Purchase_Details(guest, purchaseDetails);
	}

	/*
	 * This is a test case to purchase star space session as a guest with new
	 * vehicle and promocode payment method
	 *
	 * Author : Pavan Prasad(pavanprasad.v@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_06_Purchase_Star_Space_as_Guest_With_PromoCode_and_NewVehicle() {

		guest.setLicensePlateNumber(getRandomLicencePlate());
		guest.setVehicleType("newVehicle");
		guest.setParkingType("Star Space");
		guest.setPaymentVia("promocode");
		tp_HomePage = launch_TextPay_Application();
		tp_HomePage.purchase_Session_AsGuest(guest);
		tp_HomePage.verify_Purchase_Details(guest, purchaseDetails);
	}

	/*
	 * This is a test case to purchase star space session as a guest for unknown
	 * vehicle with new card payment method
	 *
	 * Author : Pavan Prasad(pavanprasad.v@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_07_Purchase_Star_Space_as_Guest_for_UnknownVehicle_with_NewCard() {

		guest.setLicensePlateNumber(getRandomLicencePlate());
		guest.setVehicleType("unknownVehicle");
		guest.setParkingType("Star Space");
		guest.setPaymentVia("card");
		tp_HomePage = launch_TextPay_Application();
		tp_HomePage.purchase_Session_AsGuest(guest);
		tp_HomePage.verify_Purchase_Details(guest, purchaseDetails);
	}

	/*
	 * This is a test case to purchase star space session as a guest for unknown
	 * vehicle with promocode payment method
	 *
	 * Author : Pavan Prasad(pavanprasad.v@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_08_Purchase_Star_Space_as_Guest_for_UnknownVehicle_with_PromoCode() {

		guest.setLicensePlateNumber(getRandomLicencePlate());
		guest.setVehicleType("unknownVehicle");
		guest.setParkingType("Star Space");
		guest.setPaymentVia("promocode");
		tp_HomePage = launch_TextPay_Application();
		tp_HomePage.purchase_Session_AsGuest(guest);
		tp_HomePage.verify_Purchase_Details(guest, purchaseDetails);
	}

	/*
	 * This is a test case to purchase charging space session as a guest for unknown
	 * vehicle with promocode payment method
	 *
	 * Author : Pavan Prasad(pavanprasad.v@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_09_Purchase_Charging_Space_as_Guest_With_NewCard_and_NewVehicle() {

		guest.setLicensePlateNumber(getRandomLicencePlate());
		guest.setVehicleType("newVehicle");
		guest.setParkingType("Charging Space");
		guest.setPaymentVia("card");
		guest.setTimeInHours("2");
		tp_HomePage = launch_TextPay_Application();
		tp_HomePage.purchase_Session_AsGuest(guest);
		tp_HomePage.verify_Purchase_Details(guest, purchaseDetails);
	}

	/*
	 * This is a test case to purchase charging space session as a guest with new
	 * vehicle and promocode payment method
	 *
	 * Author : Pavan Prasad(pavanprasad.v@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_10_Charging_Star_Space_as_Guest_With_PromoCode_and_NewVehicle() {

		guest.setLicensePlateNumber(getRandomLicencePlate());
		guest.setVehicleType("newVehicle");
		guest.setParkingType("Charging Space");
		guest.setPaymentVia("promocode");
		guest.setTimeInHours("2");
		tp_HomePage = launch_TextPay_Application();
		tp_HomePage.purchase_Session_AsGuest(guest);
		tp_HomePage.verify_Purchase_Details(guest, purchaseDetails);
	}

	/*
	 * This is a test case to purchase charging space session as a guest for unknown
	 * vehicle with new card payment method
	 *
	 * Author : Pavan Prasad(pavanprasad.v@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_11_Charging_Star_Space_as_Guest_for_UnknownVehicle_with_NewCard() {

		guest.setLicensePlateNumber(getRandomLicencePlate());
		guest.setVehicleType("unknownVehicle");
		guest.setParkingType("Charging Space");
		guest.setPaymentVia("card");
		guest.setTimeInHours("2");
		tp_HomePage = launch_TextPay_Application();
		tp_HomePage.purchase_Session_AsGuest(guest);
		tp_HomePage.verify_Purchase_Details(guest, purchaseDetails);
	}

	/*
	 * This is a test case to purchase charging space session as a guest for unknown
	 * vehicle with promocode payment method
	 *
	 * Author : Pavan Prasad(pavanprasad.v@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_12_Charging_Star_Space_as_Guest_for_UnknownVehicle_with_PromoCode() {

		guest.setLicensePlateNumber(getRandomLicencePlate());
		guest.setVehicleType("unknownVehicle");
		guest.setParkingType("Charging Space");
		guest.setPaymentVia("promocode");
		guest.setTimeInHours("2");
		tp_HomePage = launch_TextPay_Application();
		tp_HomePage.purchase_Session_AsGuest(guest);
		tp_HomePage.verify_Purchase_Details(guest, purchaseDetails);
	}

}
