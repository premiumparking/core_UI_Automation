package testcases.TextPay;

import org.testng.annotations.Test;
import components.BaseClass;
import components.Constants;
import dataModel.TextPay.Guest;
import dataModel.TextPay.PurchaseDetails;

import pageObjects.TextPay.TextPay_HomePage;
import utils.Email_Verification;
import utils.XML_Operations;

public class TextPay_Sanity_Testcases extends BaseClass {

	// *******************TEST CASES******************************* //

	/*
	 * TC_01_Purchase_RegularSpace_withPhoneNumber_WithNewCard_NewVehicle_VerifyMail
	 * TC_02_Purchase_RegularSpace_withPhoneNumber_FullDiscountPromoCode_UnknownVehicle_VerifyMail
	 * TC_03_Purchase_RegularSpace_withPhoneNumber_WithCard_UnknownVehicle_VerifyMail
	 * TC_04_Purchase_RegularSpace_withPhoneNumber_FullDiscountPromoCode_NewVehicle_VerifyMail
	 * TC_05_Purchase_StarSpace_withPhoneNumber_WithCard_NewVehicle_VerifyMail
	 * TC_06_Purchase_StarSpace_withPhoneNumber_FullDiscountPromoCode_UnknownVehicle_VerifyMail
	 * TC_07_Purchase_StarSpace_withPhoneNumber_WithCard_UnknownVehicle_VerifyMail
	 * TC_08_Purchase_StarSpace_withPhoneNumber_FullDiscountPromoCode_NewVehicle_VerifyMail
	 * TC_09_Purchase_ChargingSpace_withPhoneNumber_WithCard_NewVehicle_VerifyMail
	 * TC_10_Purchase_ChargingSpace_withPhoneNumber_FullDiscountPromoCode_UnknownVehicle_VerifyMail
	 * TC_11_Purchase_ChargingSpace_withPhoneNumber_WithCard_UnknownVehicle_VerifyMail
	 * TC_12_Purchase_ChargingSpace_withPhoneNumber_FullDiscountPromoCode_NewVehicle_VerifyMail
	 */

	// ****************** CLASS INSTANCES ****************************//
	XML_Operations xml_Ops = new XML_Operations();
	TextPay_HomePage tp_HomePage = new TextPay_HomePage();
	PurchaseDetails purchaseDetails = new PurchaseDetails();
	Email_Verification emailPage = new Email_Verification();

	// ****************** TEST DATA ****************************//
	Guest user = (Guest) xml_Ops.getTestData("guest");

	// ****************** TEST SCRIPTS ****************************//

	/*
	 * This is a test case to purchase regular space session with phone number, with
	 * new vehicle and through card payment
	 *
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */

	//@Test(groups = { "smoke", "regression" })
	public void TC_01_Purchase_RegularSpace_withPhoneNumber_WithNewCard_NewVehicle_VerifyMail() {

		// Test data setup
		user.setLocationNumber(getRandomLocation());
		String licencePlate = getRandomLicencePlate();
		String us_Phone_number = getRandomUSPhoneNumber();
		String email = getRandomEmailAddress();
		user.setGuestRole(false);
		user.setNewPayment(true);
		user.setMobileNumber(us_Phone_number);
		user.setLicensePlateNumber(licencePlate);
		user.setVehicleType(Constants.NEW_VEHICLE);
		user.setParkingType(Constants.REGULAR_SPACE);
		user.setPaymentVia(Constants.CARD);
		user.setCcNumber(Constants.VISA_CARD_NUMBER);

		// Test steps
		tp_HomePage = launch_TextPay_Application();
		tp_HomePage.purchase_Session(user);
		tp_HomePage.send_Receipt_to_Email(email);
		purchaseDetails.setEmail(email);
		tp_HomePage.verify_Purchase_Details(user, purchaseDetails);

		// Set the purchase details for location revenue page verification
		purchaseDetails.setPaymentOption(Constants.CARD);
		purchaseDetails.setPaymentMethod(Constants.VISA_CARD_TYPE);

		tp_HomePage.verify_LocationRevenuePage(purchaseDetails);
		purchaseDetails.setUnKnownVehicle(false);
		emailPage.verify_Email_PurchaseDetails(purchaseDetails);

	}

	/*
	 * This is a test case to purchase regular space session with phone number,with
	 * new vehicle and through promocode
	 *
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_02_Purchase_RegularSpace_withPhoneNumber_FullDiscountPromoCode_UnknownVehicle_VerifyMail() {

		// Test data setup
		user.setLocationNumber(getRandomLocation());
		String us_Phone_number = getRandomUSPhoneNumber();
		String email = getRandomEmailAddress();
		user.setGuestRole(false);
		user.setNewPayment(false);
		user.setPaymentVia(Constants.PROMOCODE);
		user.setPromocode(Constants.PROMO100);
		user.setMobileNumber(us_Phone_number);
		user.setLicensePlateNumber(Constants.UNKNOWN);
		user.setVehicleType(Constants.UNKNOWN_VEHICLE);
		user.setParkingType(Constants.REGULAR_SPACE);
		user.setType(getRandom_Vehicle_Type());
		user.setMake(getRandom_Vehicle_Make());
		user.setColor(getRandom_Vehicle_Color());

		// Test steps
		tp_HomePage = launch_TextPay_Application();
		tp_HomePage.purchase_Session(user);
		tp_HomePage.send_Receipt_to_Email(email);
		purchaseDetails.setEmail(email);
		tp_HomePage.verify_Purchase_Details(user, purchaseDetails);

		// Set the purchase details for location revenue page verification
		purchaseDetails.setPaymentOption(Constants.PROMOCODE);
		purchaseDetails.setPromocode(Constants.PROMO100);

		tp_HomePage.verify_LocationRevenuePage(purchaseDetails);
		purchaseDetails.setUnKnownVehicle(true);
		purchaseDetails.setLicencePlate(user.getColor() + " " + user.getType() + " " + user.getMake());
		emailPage.verify_Email_PurchaseDetails(purchaseDetails);

	}

	/*
	 * This is a test case to purchase regular space session with phone number, with
	 * Unknown vehicle and through card payment
	 *
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */

	//@Test(groups = { "smoke", "regression" })
	public void TC_03_Purchase_RegularSpace_withPhoneNumber_WithCard_UnknownVehicle_VerifyMail() {

		// Test data setup
		user.setLocationNumber(getRandomLocation());
		String us_Phone_number = getRandomUSPhoneNumber();
		String email = getRandomEmailAddress();
		user.setGuestRole(false);
		user.setNewPayment(true);
		user.setMobileNumber(us_Phone_number);
		user.setLicensePlateNumber(Constants.UNKNOWN);
		user.setVehicleType(Constants.UNKNOWN_VEHICLE);
		user.setParkingType(Constants.REGULAR_SPACE);
		user.setPaymentVia(Constants.CARD);
		user.setCcNumber(Constants.VISA_CARD_NUMBER);
		
		user.setType(getRandom_Vehicle_Type());
		user.setMake(getRandom_Vehicle_Make());
		user.setColor(getRandom_Vehicle_Color());

		// Test steps
		tp_HomePage = launch_TextPay_Application();
		tp_HomePage.purchase_Session(user);
		tp_HomePage.send_Receipt_to_Email(email);
		purchaseDetails.setEmail(email);
		tp_HomePage.verify_Purchase_Details(user, purchaseDetails);

		// Set the purchase details for location revenue page verification
		purchaseDetails.setPaymentOption(Constants.CARD);
		purchaseDetails.setPaymentMethod(Constants.VISA_CARD_TYPE);

		tp_HomePage.verify_LocationRevenuePage(purchaseDetails);
		purchaseDetails.setUnKnownVehicle(true);
		purchaseDetails.setLicencePlate(user.getColor() + " " + user.getType() + " " + user.getMake());
		emailPage.verify_Email_PurchaseDetails(purchaseDetails);

	}

	/*
	 * This is a test case to purchase regular space session with phone number,with
	 * new vehicle and through promocode
	 *
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	//@Test(groups = { "smoke", "regression" })
	public void TC_04_Purchase_RegularSpace_withPhoneNumber_FullDiscountPromoCode_NewVehicle_VerifyMail() {

		// Test data setup
		user.setLocationNumber(getRandomLocation());
		String licencePlate = getRandomLicencePlate();
		String us_Phone_number = getRandomUSPhoneNumber();
		String email = getRandomEmailAddress();
		user.setGuestRole(false);
		user.setNewPayment(false);
		user.setPaymentVia(Constants.PROMOCODE);
		user.setPromocode(Constants.PROMO100);
		user.setMobileNumber(us_Phone_number);
		user.setLicensePlateNumber(licencePlate);
		user.setVehicleType(Constants.NEW_VEHICLE);
		user.setParkingType(Constants.REGULAR_SPACE);

		// Test steps
		tp_HomePage = launch_TextPay_Application();
		tp_HomePage.purchase_Session(user);
		tp_HomePage.send_Receipt_to_Email(email);
		purchaseDetails.setEmail(email);
		tp_HomePage.verify_Purchase_Details(user, purchaseDetails);

		// Set the purchase details for location revenue page verification
		purchaseDetails.setPaymentOption(Constants.PROMOCODE);
		purchaseDetails.setPromocode(Constants.PROMO100);

		tp_HomePage.verify_LocationRevenuePage(purchaseDetails);
		purchaseDetails.setUnKnownVehicle(false);
		emailPage.verify_Email_PurchaseDetails(purchaseDetails);

	}

	/*
	 * This is a test case to purchase regular space session with phone number, with
	 * new vehicle and through card payment
	 *
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */

	//@Test(groups = { "smoke", "regression" })
	public void TC_05_Purchase_StarSpace_withPhoneNumber_WithCard_NewVehicle_VerifyMail() {

		// Test data setup
		user.setLocationNumber(getRandomLocation());
		String licencePlate = getRandomLicencePlate();
		String us_Phone_number = getRandomUSPhoneNumber();
		String email = getRandomEmailAddress();
		user.setGuestRole(false);
		user.setNewPayment(true);
		user.setMobileNumber(us_Phone_number);
		user.setLicensePlateNumber(licencePlate);
		user.setVehicleType(Constants.NEW_VEHICLE);
		user.setParkingType(Constants.STAR_SPACE);
		user.setPaymentVia(Constants.CARD);
		user.setCcNumber(Constants.VISA_CARD_NUMBER);
		user.setTimeInHours("2");

		// Test steps
		tp_HomePage = launch_TextPay_Application();
		tp_HomePage.purchase_Session(user);
		tp_HomePage.send_Receipt_to_Email(email);
		purchaseDetails.setEmail(email);
		tp_HomePage.verify_Purchase_Details(user, purchaseDetails);

		// Set the purchase details for location revenue page verification
		purchaseDetails.setPaymentOption(Constants.CARD);
		purchaseDetails.setPaymentMethod(Constants.VISA_CARD_TYPE);

		tp_HomePage.verify_LocationRevenuePage(purchaseDetails);
		purchaseDetails.setUnKnownVehicle(false);
		emailPage.verify_Email_PurchaseDetails(purchaseDetails);

	}

	/*
	 * This is a test case to purchase regular space session with phone number,with
	 * new vehicle and through promocode
	 *
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	//@Test(groups = { "smoke", "regression" })
	public void TC_06_Purchase_StarSpace_withPhoneNumber_FullDiscountPromoCode_UnknownVehicle_VerifyMail() {

		// Test data setup
		user.setLocationNumber(getRandomLocation());
		String us_Phone_number = getRandomUSPhoneNumber();
		String email = getRandomEmailAddress();
		user.setGuestRole(false);
		user.setNewPayment(false);
		user.setPaymentVia(Constants.PROMOCODE);
		user.setPromocode(Constants.PROMO100);
		user.setMobileNumber(us_Phone_number);
		user.setLicensePlateNumber(Constants.UNKNOWN);
		user.setVehicleType(Constants.UNKNOWN_VEHICLE);
		user.setParkingType(Constants.STAR_SPACE);
		user.setTimeInHours("2");
		user.setType(getRandom_Vehicle_Type());
		user.setMake(getRandom_Vehicle_Make());
		user.setColor(getRandom_Vehicle_Color());

		// Test steps
		tp_HomePage = launch_TextPay_Application();
		tp_HomePage.purchase_Session(user);
		tp_HomePage.send_Receipt_to_Email(email);
		purchaseDetails.setEmail(email);
		tp_HomePage.verify_Purchase_Details(user, purchaseDetails);

		// Set the purchase details for location revenue page verification
		purchaseDetails.setPaymentOption(Constants.PROMOCODE);
		purchaseDetails.setPromocode(Constants.PROMO100);

		tp_HomePage.verify_LocationRevenuePage(purchaseDetails);
		purchaseDetails.setUnKnownVehicle(true);
		purchaseDetails.setLicencePlate(user.getColor() + " " + user.getType() + " " + user.getMake());
		emailPage.verify_Email_PurchaseDetails(purchaseDetails);

	}

	/*
	 * This is a test case to purchase regular space session with phone number, with
	 * Unknown vehicle and through card payment
	 *
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */

	//@Test(groups = { "smoke", "regression" })
	public void TC_07_Purchase_StarSpace_withPhoneNumber_WithCard_UnknownVehicle_VerifyMail() {

		// Test data setup
		user.setLocationNumber(getRandomLocation());
		String us_Phone_number = getRandomUSPhoneNumber();
		String email = getRandomEmailAddress();
		user.setGuestRole(false);
		user.setNewPayment(true);
		user.setMobileNumber(us_Phone_number);
		user.setLicensePlateNumber(Constants.UNKNOWN);
		user.setVehicleType(Constants.UNKNOWN_VEHICLE);
		user.setParkingType(Constants.STAR_SPACE);
		user.setPaymentVia(Constants.CARD);
		user.setCcNumber(Constants.VISA_CARD_NUMBER);
		user.setTimeInHours("2");
		user.setType(getRandom_Vehicle_Type());
		user.setMake(getRandom_Vehicle_Make());
		user.setColor(getRandom_Vehicle_Color());

		// Test steps
		tp_HomePage = launch_TextPay_Application();
		tp_HomePage.purchase_Session(user);
		tp_HomePage.send_Receipt_to_Email(email);
		purchaseDetails.setEmail(email);
		tp_HomePage.verify_Purchase_Details(user, purchaseDetails);

		// Set the purchase details for location revenue page verification
		purchaseDetails.setPaymentOption(Constants.CARD);
		purchaseDetails.setPaymentMethod(Constants.VISA_CARD_TYPE);

		tp_HomePage.verify_LocationRevenuePage(purchaseDetails);
		purchaseDetails.setUnKnownVehicle(true);
		purchaseDetails.setLicencePlate(user.getColor() + " " + user.getType() + " " + user.getMake());
		emailPage.verify_Email_PurchaseDetails(purchaseDetails);

	}

	/*
	 * This is a test case to purchase regular space session with phone number,with
	 * new vehicle and through promocode
	 *
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	//@Test(groups = { "smoke", "regression" })
	public void TC_08_Purchase_StarSpace_withPhoneNumber_FullDiscountPromoCode_NewVehicle_VerifyMail() {

		// Test data setup
		user.setLocationNumber(getRandomLocation());
		String licencePlate = getRandomLicencePlate();
		String us_Phone_number = getRandomUSPhoneNumber();
		String email = getRandomEmailAddress();
		user.setGuestRole(false);
		user.setNewPayment(false);
		user.setPaymentVia(Constants.PROMOCODE);
		user.setPromocode(Constants.PROMO100);
		user.setMobileNumber(us_Phone_number);
		user.setLicensePlateNumber(licencePlate);
		user.setVehicleType(Constants.NEW_VEHICLE);
		user.setParkingType(Constants.STAR_SPACE);
		user.setTimeInHours("1");

		// Test steps
		tp_HomePage = launch_TextPay_Application();
		tp_HomePage.purchase_Session(user);
		tp_HomePage.send_Receipt_to_Email(email);
		purchaseDetails.setEmail(email);
		tp_HomePage.verify_Purchase_Details(user, purchaseDetails);

		// Set the purchase details for location revenue page verification
		purchaseDetails.setPaymentOption(Constants.PROMOCODE);
		purchaseDetails.setPromocode(Constants.PROMO100);

		tp_HomePage.verify_LocationRevenuePage(purchaseDetails);
		purchaseDetails.setUnKnownVehicle(false);
		emailPage.verify_Email_PurchaseDetails(purchaseDetails);

	}
	/*
	 * This is a test case to purchase regular space session with phone number, with
	 * new vehicle and through card payment
	 *
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */

	//@Test(groups = { "smoke", "regression" })
	public void TC_09_Purchase_ChargingSpace_withPhoneNumber_WithCard_NewVehicle_VerifyMail() {

		// Test data setup
		user.setLocationNumber(getRandomLocation());
		String licencePlate = getRandomLicencePlate();
		String us_Phone_number = getRandomUSPhoneNumber();
		String email = getRandomEmailAddress();
		user.setGuestRole(false);
		user.setNewPayment(true);
		user.setMobileNumber(us_Phone_number);
		user.setLicensePlateNumber(licencePlate);
		user.setVehicleType(Constants.NEW_VEHICLE);
		user.setParkingType(Constants.CHARGING_SPACE);
		user.setPaymentVia(Constants.CARD);
		user.setCcNumber(Constants.VISA_CARD_NUMBER);
		user.setTimeInHours("5");

		// Test steps
		tp_HomePage = launch_TextPay_Application();
		tp_HomePage.purchase_Session(user);
		tp_HomePage.send_Receipt_to_Email(email);
		purchaseDetails.setEmail(email);
		tp_HomePage.verify_Purchase_Details(user, purchaseDetails);

		// Set the purchase details for location revenue page verification
		purchaseDetails.setPaymentOption(Constants.CARD);
		purchaseDetails.setPaymentMethod(Constants.VISA_CARD_TYPE);

		tp_HomePage.verify_LocationRevenuePage(purchaseDetails);
		purchaseDetails.setUnKnownVehicle(false);
		emailPage.verify_Email_PurchaseDetails(purchaseDetails);

	}

	/*
	 * This is a test case to purchase regular space session with phone number,with
	 * new vehicle and through promocode
	 *
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	//@Test(groups = { "smoke", "regression" })
	public void TC_10_Purchase_ChargingSpace_withPhoneNumber_FullDiscountPromoCode_UnknownVehicle_VerifyMail() {

		// Test data setup
		user.setLocationNumber(getRandomLocation());
		String us_Phone_number = getRandomUSPhoneNumber();
		String email = getRandomEmailAddress();
		user.setGuestRole(false);
		user.setNewPayment(false);
		user.setPaymentVia(Constants.PROMOCODE);
		user.setPromocode(Constants.PROMO100);
		user.setMobileNumber(us_Phone_number);
		user.setLicensePlateNumber(Constants.UNKNOWN);
		user.setVehicleType(Constants.UNKNOWN_VEHICLE);
		user.setParkingType(Constants.CHARGING_SPACE);
		user.setTimeInHours("5");
		user.setType(getRandom_Vehicle_Type());
		user.setMake(getRandom_Vehicle_Make());
		user.setColor(getRandom_Vehicle_Color());

		// Test steps
		tp_HomePage = launch_TextPay_Application();
		tp_HomePage.purchase_Session(user);
		tp_HomePage.send_Receipt_to_Email(email);
		purchaseDetails.setEmail(email);
		tp_HomePage.verify_Purchase_Details(user, purchaseDetails);

		// Set the purchase details for location revenue page verification
		purchaseDetails.setPaymentOption(Constants.PROMOCODE);
		purchaseDetails.setPromocode(Constants.PROMO100);

		tp_HomePage.verify_LocationRevenuePage(purchaseDetails);
		purchaseDetails.setUnKnownVehicle(true);
		purchaseDetails.setLicencePlate(user.getColor() + " " + user.getType() + " " + user.getMake());
		emailPage.verify_Email_PurchaseDetails(purchaseDetails);

	}

	/*
	 * This is a test case to purchase regular space session with phone number, with
	 * Unknown vehicle and through card payment
	 *
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */

	//@Test(groups = { "smoke", "regression" })
	public void TC_11_Purchase_ChargingSpace_withPhoneNumber_WithCard_UnknownVehicle_VerifyMail() {

		// Test data setup
		user.setLocationNumber(getRandomLocation());
		String us_Phone_number = getRandomUSPhoneNumber();
		String email = getRandomEmailAddress();
		user.setGuestRole(false);
		user.setNewPayment(true);
		user.setMobileNumber(us_Phone_number);
		user.setLicensePlateNumber(Constants.UNKNOWN);
		user.setVehicleType(Constants.UNKNOWN_VEHICLE);
		user.setParkingType(Constants.CHARGING_SPACE);
		user.setPaymentVia(Constants.CARD);
		user.setCcNumber(Constants.VISA_CARD_NUMBER);
		user.setTimeInHours("5");
		user.setType(getRandom_Vehicle_Type());
		user.setMake(getRandom_Vehicle_Make());
		user.setColor(getRandom_Vehicle_Color());

		// Test steps
		tp_HomePage = launch_TextPay_Application();
		tp_HomePage.purchase_Session(user);
		tp_HomePage.send_Receipt_to_Email(email);
		purchaseDetails.setEmail(email);
		tp_HomePage.verify_Purchase_Details(user, purchaseDetails);

		// Set the purchase details for location revenue page verification
		purchaseDetails.setPaymentOption(Constants.CARD);
		purchaseDetails.setPaymentMethod(Constants.VISA_CARD_TYPE);

		tp_HomePage.verify_LocationRevenuePage(purchaseDetails);
		purchaseDetails.setUnKnownVehicle(true);
		purchaseDetails.setLicencePlate(user.getColor() + " " + user.getType() + " " + user.getMake());
		emailPage.verify_Email_PurchaseDetails(purchaseDetails);

	}

	/*
	 * This is a test case to purchase regular space session with phone number,with
	 * new vehicle and through promocode
	 *
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	//@Test(groups = { "smoke", "regression" })
	public void TC_12_Purchase_ChargingSpace_withPhoneNumber_FullDiscountPromoCode_NewVehicle_VerifyMail() {

		// Test data setup
		user.setLocationNumber(getRandomLocation());
		String licencePlate = getRandomLicencePlate();
		String us_Phone_number = getRandomUSPhoneNumber();
		String email = getRandomEmailAddress();
		user.setGuestRole(false);
		user.setNewPayment(false);
		user.setPaymentVia(Constants.PROMOCODE);
		user.setPromocode(Constants.PROMO100);
		user.setMobileNumber(us_Phone_number);
		user.setLicensePlateNumber(licencePlate);
		user.setVehicleType(Constants.NEW_VEHICLE);
		user.setParkingType(Constants.CHARGING_SPACE);
		user.setTimeInHours("5");

		// Test steps
		tp_HomePage = launch_TextPay_Application();
		tp_HomePage.purchase_Session(user);
		tp_HomePage.send_Receipt_to_Email(email);
		purchaseDetails.setEmail(email);
		tp_HomePage.verify_Purchase_Details(user, purchaseDetails);

		// Set the purchase details for location revenue page verification
		purchaseDetails.setPaymentOption(Constants.PROMOCODE);
		purchaseDetails.setPromocode(Constants.PROMO100);

		tp_HomePage.verify_LocationRevenuePage(purchaseDetails);
		purchaseDetails.setUnKnownVehicle(false);
		emailPage.verify_Email_PurchaseDetails(purchaseDetails);

	}
}
