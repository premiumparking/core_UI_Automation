package testcases.TextPay;

import org.testng.annotations.Test;
import components.BaseClass;
import components.Constants;
import dataModel.TextPay.Guest;
import dataModel.TextPay.PurchaseDetails;

import pageObjects.TextPay.TextPay_HomePage;
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

	// ****************** TEST DATA ****************************//
	Guest user = (Guest) xml_Ops.getTestData("guest");

	// ****************** TEST SCRIPTS ****************************//

	/*
	 * This is a test case to purchase regular space session as a guest with new
	 * vehicle and through card payment
	 *
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */

	@Test(groups = { "smoke", "regression" })
	public void TC_01_Purchase_RegularSpace_withPhoneNumber_WithNewCard_NewVehicle_VerifyMail() {

		// Test data setup
		user.setLocationNumber(getRandomLocation());
		String licencePlate = getRandomLicencePlate();
		String us_Phone_number = getRandomUSPhoneNumber();
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
		tp_HomePage.verify_Purchase_Details(user, purchaseDetails);

		// Set the purchase details for location revenue page verification
		purchaseDetails.setPaymentOption(Constants.CARD);
		purchaseDetails.setPaymentMethod(Constants.VISA_CARD_TYPE);
		//tp_HomePage.verify_LocationRevenuePage(purchaseDetails);

	}
//
//	/*
//	 * This is a test case to purchase regular space session as a guest with new
//	 * vehicle and through promocode
//	 *
//	 * Author : Venu Thota(venu.t@comakeit.com)
//	 */
//	@Test(groups = { "smoke", "regression" })
//	public void TC_02_Purchase_Regular_Space_as_Guest_With_PromoCode_and_NewVehicle() {
//
//		user.setLocationNumber(getRandomLocation());
//		user.setLicensePlateNumber(getRandomLicencePlate());
//		user.setVehicleType("newVehicle");
//		user.setParkingType(Constants.REGULAR_SPACE);
//		user.setPaymentVia("promocode");
//		user.setPromocode(Constants.PROMO100);
//		tp_HomePage = launch_TextPay_Application();
//		tp_HomePage.purchase_Session(user);
//		tp_HomePage.verify_Purchase_Details(user, purchaseDetails);
//
//		// Set the purchase details for location revenue page verification
//		purchaseDetails.setPaymentOption("promocode");
//		purchaseDetails.setPromocode(user.getPromocode());
//		// tp_HomePage.verify_LocationRevenuePage(purchaseDetails);
//
//	}
//
//	/*
//	 * This is a test case to purchase regular space session as a guest for unknown
//	 * vehicle and through card payment
//	 *
//	 * Author : Venu Thota(venu.t@comakeit.com)
//	 */
//	@Test(groups = { "smoke", "regression" })
//	public void TC_03_Purchase_Regular_Space_as_Guest_for_UnknownVehicle_with_NewCard() {
//
//		user.setLocationNumber(getRandomLocation());
//		user.setLicensePlateNumber(Constants.UNKNOWN);
//		user.setVehicleType("unknownVehicle");
//		user.setParkingType(Constants.REGULAR_SPACE);
//		user.setPaymentVia(Constants.CARD);
//		user.setCcNumber(Constants.VISA_CARD_NUMBER);
//		tp_HomePage = launch_TextPay_Application();
//		tp_HomePage.purchase_Session(user);
//		tp_HomePage.verify_Purchase_Details(user, purchaseDetails);
//
//		// Set the purchase details for location revenue page verification
//		purchaseDetails.setPaymentOption(Constants.CARD);
//		purchaseDetails.setPaymentMethod(Constants.VISA_CARD_TYPE);
//
//		// tp_HomePage.verify_LocationRevenuePage(purchaseDetails);
//	}
//
//	/*
//	 * This is a test case to purchase regular space session as a guest for unknown
//	 * vehicle and through promocode
//	 *
//	 * Author : Venu Thota(venu.t@comakeit.com)
//	 */
//	@Test(groups = { "smoke", "regression" })
//	public void TC_04_Purchase_Regular_Space_as_Guest_for_UnknownVehicle_with_PromoCode() {
//
//		user.setLocationNumber(getRandomLocation());
//		user.setLicensePlateNumber(Constants.UNKNOWN);
//		user.setVehicleType("unknownVehicle");
//		user.setParkingType(Constants.REGULAR_SPACE);
//		user.setPaymentVia("promocode");
//		user.setPromocode(Constants.PROMO100);
//		tp_HomePage = launch_TextPay_Application();
//		tp_HomePage.purchase_Session(user);
//		tp_HomePage.verify_Purchase_Details(user, purchaseDetails);
//
//		// Set the purchase details for location revenue page verification
//		purchaseDetails.setPaymentOption("promocode");
//		purchaseDetails.setPromocode(user.getPromocode());
//
//		// tp_HomePage.verify_LocationRevenuePage(purchaseDetails);
//	}
//
//	/*
//	 * This is a test case to purchase star space session as a guest for unknown
//	 * vehicle and through promocode
//	 *
//	 * Author : Venu Thota(venu.t@comakeit.com)
//	 */
//	@Test(groups = { "smoke", "regression" })
//	public void TC_05_Purchase_Star_Space_as_Guest_With_NewCard_and_NewVehicle() {
//
//		user.setLocationNumber(getRandomLocation());
//		user.setLicensePlateNumber(getRandomLicencePlate());
//		user.setVehicleType("newVehicle");
//		user.setParkingType(Constants.STAR_SPACE);
//		user.setPaymentVia(Constants.CARD);
//		user.setTimeInHours(Constants._2_Hrs);
//		user.setCcNumber(Constants.VISA_CARD_NUMBER);
//		tp_HomePage = launch_TextPay_Application();
//		tp_HomePage.purchase_Session(user);
//		tp_HomePage.verify_Purchase_Details(user, purchaseDetails);
//
//		// Set the purchase details for location revenue page verification
//		purchaseDetails.setPaymentOption(Constants.CARD);
//		purchaseDetails.setPaymentMethod(Constants.VISA_CARD_TYPE);
//
//		// tp_HomePage.verify_LocationRevenuePage(purchaseDetails);
//	}
//
//	/*
//	 * This is a test case to purchase star space session as a guest with new
//	 * vehicle and promocode payment method
//	 *
//	 * Author : Venu Thota(venu.t@comakeit.com)
//	 */
//	@Test(groups = { "smoke", "regression" })
//	public void TC_06_Purchase_Star_Space_as_Guest_With_PromoCode_and_NewVehicle() {
//
//		user.setLocationNumber(getRandomLocation());
//		user.setLicensePlateNumber(getRandomLicencePlate());
//		user.setVehicleType("newVehicle");
//		user.setParkingType(Constants.STAR_SPACE);
//		user.setPaymentVia("promocode");
//		user.setPromocode(Constants.PROMO100);
//		user.setTimeInHours(Constants._5_Hrs);
//		tp_HomePage = launch_TextPay_Application();
//		tp_HomePage.purchase_Session(user);
//		tp_HomePage.verify_Purchase_Details(user, purchaseDetails);
//
//		// Set the purchase details for location revenue page verification
//		purchaseDetails.setPaymentOption("promocode");
//		purchaseDetails.setPromocode(user.getPromocode());
//		// tp_HomePage.verify_LocationRevenuePage(purchaseDetails);
//	}
//
//	/*
//	 * This is a test case to purchase star space session as a guest for unknown
//	 * vehicle with new card payment method
//	 *
//	 * Author : Venu Thota(venu.t@comakeit.com)
//	 */
//	@Test(groups = { "smoke", "regression" })
//	public void TC_07_Purchase_Star_Space_as_Guest_for_UnknownVehicle_with_NewCard() {
//
//		user.setLocationNumber(getRandomLocation());
//		user.setLicensePlateNumber(Constants.UNKNOWN);
//		user.setVehicleType("unknownVehicle");
//		user.setParkingType(Constants.STAR_SPACE);
//		user.setPaymentVia(Constants.CARD);
//		user.setTimeInHours(Constants._1_Hr);
//		user.setCcNumber(Constants.VISA_CARD_NUMBER);
//		tp_HomePage = launch_TextPay_Application();
//		tp_HomePage.purchase_Session(user);
//		tp_HomePage.verify_Purchase_Details(user, purchaseDetails);
//
//		// Set the purchase details for location revenue page verification
//		purchaseDetails.setPaymentOption(Constants.CARD);
//		purchaseDetails.setPaymentMethod(Constants.VISA_CARD_TYPE);
//
//		// tp_HomePage.verify_LocationRevenuePage(purchaseDetails);
//	}
//
//	/*
//	 * This is a test case to purchase star space session as a guest for unknown
//	 * vehicle and through promocode
//	 *
//	 * Author : Venu Thota(venu.t@comakeit.com)
//	 */
//	@Test(groups = { "smoke", "regression" })
//	public void TC_08_Purchase_Star_Space_as_Guest_for_UnknownVehicle_with_PromoCode() {
//
//		user.setLocationNumber(getRandomLocation());
//		user.setLicensePlateNumber(Constants.UNKNOWN);
//		user.setVehicleType("unknownVehicle");
//		user.setParkingType(Constants.STAR_SPACE);
//		user.setPaymentVia("promocode");
//		user.setPromocode(Constants.PROMO100);
//		user.setTimeInHours(Constants._2_Hrs);
//		tp_HomePage = launch_TextPay_Application();
//		tp_HomePage.purchase_Session(user);
//		tp_HomePage.verify_Purchase_Details(user, purchaseDetails);
//
//		// Set the purchase details for location revenue page verification
//		purchaseDetails.setPaymentOption("promocode");
//		purchaseDetails.setPromocode(user.getPromocode());
//		// tp_HomePage.verify_LocationRevenuePage(purchaseDetails);
//	}
//
//	/*
//	 * This is a test case to purchase charging space session as a guest for unknown
//	 * vehicle and through promocode
//	 *
//	 * Author : Venu Thota(venu.t@comakeit.com)
//	 */
//	@Test(groups = { "smoke", "regression" })
//	public void TC_09_Purchase_Charging_Space_as_Guest_With_NewCard_and_NewVehicle() {
//
//		user.setLocationNumber(getRandomLocation());
//		user.setLicensePlateNumber(getRandomLicencePlate());
//		user.setVehicleType("newVehicle");
//		user.setParkingType(Constants.CHARGING_SPACE);
//		user.setPaymentVia(Constants.CARD);
//		user.setCcNumber(Constants.VISA_CARD_NUMBER);
//		user.setTimeInHours(Constants._2_Hrs);
//		tp_HomePage = launch_TextPay_Application();
//		tp_HomePage.purchase_Session(user);
//		tp_HomePage.verify_Purchase_Details(user, purchaseDetails);
//
//		// Set the purchase details for location revenue page verification
//		purchaseDetails.setPaymentOption(Constants.CARD);
//		purchaseDetails.setPaymentMethod(Constants.VISA_CARD_TYPE);
//
//		// tp_HomePage.verify_LocationRevenuePage(purchaseDetails);
//	}
//
//	/*
//	 * This is a test case to purchase charging space session as a guest with new
//	 * vehicle and promocode payment method
//	 *
//	 * Author : Venu Thota(venu.t@comakeit.com)
//	 */
//	@Test(groups = { "smoke", "regression" })
//	public void TC_10_Charging_Space_as_Guest_With_PromoCode_and_NewVehicle() {
//
//		user.setLocationNumber(getRandomLocation());
//		user.setLicensePlateNumber(getRandomLicencePlate());
//		user.setVehicleType("newVehicle");
//		user.setParkingType(Constants.CHARGING_SPACE);
//		user.setPaymentVia("promocode");
//		user.setPromocode(Constants.PROMO100);
//		user.setTimeInHours(Constants._5_Hrs);
//		tp_HomePage = launch_TextPay_Application();
//		tp_HomePage.purchase_Session(user);
//		tp_HomePage.verify_Purchase_Details(user, purchaseDetails);
//
//		// Set the purchase details for location revenue page verification
//		purchaseDetails.setPaymentOption("promocode");
//		purchaseDetails.setPromocode(user.getPromocode());
//		// tp_HomePage.verify_LocationRevenuePage(purchaseDetails);
//	}
//
//	/*
//	 * This is a test case to purchase charging space session as a guest for unknown
//	 * vehicle with new card payment method
//	 *
//	 * Author : Venu Thota(venu.t@comakeit.com)
//	 */
//	@Test(groups = { "smoke", "regression" })
//	public void TC_11_Charging_Space_as_Guest_for_UnknownVehicle_with_NewCard() {
//
//		user.setLocationNumber(getRandomLocation());
//		user.setLicensePlateNumber(Constants.UNKNOWN);
//		user.setVehicleType("unknownVehicle");
//		user.setParkingType(Constants.CHARGING_SPACE);
//		user.setPaymentVia(Constants.CARD);
//		user.setCcNumber(Constants.VISA_CARD_NUMBER);
//		user.setTimeInHours(Constants._1_Hr);
//		tp_HomePage = launch_TextPay_Application();
//		tp_HomePage.purchase_Session(user);
//		tp_HomePage.verify_Purchase_Details(user, purchaseDetails);
//
//		// Set the purchase details for location revenue page verification
//		purchaseDetails.setPaymentOption(Constants.CARD);
//		purchaseDetails.setPaymentMethod(Constants.VISA_CARD_TYPE);
//
//		// tp_HomePage.verify_LocationRevenuePage(purchaseDetails);
//	}
//
//	/*
//	 * This is a test case to purchase charging space session as a guest for unknown
//	 * vehicle and through promocode
//	 *
//	 * Author : Venu Thota(venu.t@comakeit.com)
//	 */
//	@Test(groups = { "smoke", "regression" })
//	public void TC_12_Charging_Star_Space_as_Guest_for_UnknownVehicle_with_PromoCode() {
//
//		user.setLocationNumber(getRandomLocation());
//		user.setLicensePlateNumber(Constants.UNKNOWN);
//		user.setVehicleType("unknownVehicle");
//		user.setParkingType(Constants.CHARGING_SPACE);
//		user.setPaymentVia("promocode");
//		user.setPromocode(Constants.PROMO100);
//		user.setTimeInHours(Constants._2_Hrs);
//		tp_HomePage = launch_TextPay_Application();
//		tp_HomePage.purchase_Session(user);
//		tp_HomePage.verify_Purchase_Details(user, purchaseDetails);
//
//		// Set the purchase details for location revenue page verification
//		purchaseDetails.setPaymentOption("promocode");
//		purchaseDetails.setPromocode(user.getPromocode());
//		// tp_HomePage.verify_LocationRevenuePage(purchaseDetails);
//	}
//
//	/*
//	 * This is a test case to purchase regular space session as a guest with new
//	 * vehicle and through card payment
//	 *
//	 * Author : Venu Thota(venu.t@comakeit.com)
//	 */
//
//	@Test(groups = { "smoke", "regression" })
//	public void TC_13_Purchase_SpecialRate_Session_as_Guest_With_NewCard_and_NewVehicle() {
//
//		user.setLocationNumber(getRandomLocation());
//		String licencePlate = getRandomLicencePlate();
//		user.setLicensePlateNumber(licencePlate);
//		user.setVehicleType("newVehicle");
//		user.setParkingType(Constants.SPECIAL_RATE);
//		user.setPaymentVia(Constants.CARD);
//		user.setTimeInHours(Constants._2_Hrs);
//		user.setCcNumber(Constants.VISA_CARD_NUMBER);
//		tp_HomePage = launch_TextPay_Application();
//		tp_HomePage.purchase_Session(user);
//		tp_HomePage.verify_Purchase_Details(user, purchaseDetails);
//
//		// Set the purchase details for location revenue page verification
//		purchaseDetails.setPaymentOption(Constants.CARD);
//		purchaseDetails.setPaymentMethod(Constants.VISA_CARD_TYPE);
//		// tp_HomePage.verify_LocationRevenuePage(purchaseDetails);
//
//	}
//
//	/*
//	 * This is a test case to purchase regular space session as a guest with new
//	 * vehicle and promocode payment method
//	 *
//	 * Author : Venu Thota(venu.t@comakeit.com)
//	 */
//	@Test(groups = { "smoke", "regression" })
//	public void TC_14_Purchase_SpecialRate_Session_as_Guest_With_PromoCode_and_NewVehicle() {
//
//		user.setLocationNumber(getRandomLocation());
//		user.setLicensePlateNumber(getRandomLicencePlate());
//		user.setVehicleType("newVehicle");
//		user.setParkingType(Constants.SPECIAL_RATE);
//		user.setPaymentVia("promocode");
//		user.setPromocode(Constants.PROMO100);
//		user.setTimeInHours(Constants._1_Hr);
//		tp_HomePage = launch_TextPay_Application();
//		tp_HomePage.purchase_Session(user);
//		tp_HomePage.verify_Purchase_Details(user, purchaseDetails);
//
//		// Set the purchase details for location revenue page verification
//		purchaseDetails.setPaymentOption("promocode");
//		purchaseDetails.setPromocode(user.getPromocode());
//		// tp_HomePage.verify_LocationRevenuePage(purchaseDetails);
//
//	}
//
//	/*
//	 * This is a test case to purchase regular space session as a guest for unknown
//	 * vehicle with new card payment method
//	 *
//	 * Author : Venu Thota(venu.t@comakeit.com)
//	 */
//	@Test(groups = { "smoke", "regression" })
//	public void TC_15_Purchase_SpecialRate_Session_as_Guest_for_UnknownVehicle_with_NewCard() {
//
//		user.setLocationNumber(getRandomLocation());
//		user.setLicensePlateNumber(Constants.UNKNOWN);
//		user.setVehicleType("unknownVehicle");
//		user.setParkingType(Constants.SPECIAL_RATE);
//		user.setPaymentVia(Constants.CARD);
//		user.setTimeInHours(Constants._5_Hrs);
//		user.setCcNumber(Constants.VISA_CARD_NUMBER);
//		tp_HomePage = launch_TextPay_Application();
//		tp_HomePage.purchase_Session(user);
//		tp_HomePage.verify_Purchase_Details(user, purchaseDetails);
//
//		// Set the purchase details for location revenue page verification
//		purchaseDetails.setPaymentOption(Constants.CARD);
//		purchaseDetails.setPaymentMethod(Constants.VISA_CARD_TYPE);
//
//		tp_HomePage.verify_LocationRevenuePage(purchaseDetails);
//	}
//
//	/*
//	 * This is a test case to purchase regular space session as a guest for unknown
//	 * vehicle and through promocode
//	 *
//	 * Author : Venu Thota(venu.t@comakeit.com)
//	 */
//	@Test(groups = { "smoke", "regression" })
//	public void TC_16_Purchase_SpecialRate_Session_as_Guest_for_UnknownVehicle_with_PromoCode() {
//
//		user.setLocationNumber(getRandomLocation());
//		user.setLicensePlateNumber(Constants.UNKNOWN);
//		user.setVehicleType("unknownVehicle");
//		user.setParkingType(Constants.SPECIAL_RATE);
//		user.setPaymentVia("promocode");
//		user.setPromocode(Constants.PROMO100);
//		user.setTimeInHours(Constants._2_Hrs);
//		tp_HomePage = launch_TextPay_Application();
//		tp_HomePage.purchase_Session(user);
//		tp_HomePage.verify_Purchase_Details(user, purchaseDetails);
//
//		// Set the purchase details for location revenue page verification
//		purchaseDetails.setPaymentOption("promocode");
//		purchaseDetails.setPromocode(user.getPromocode());
//
//		// tp_HomePage.verify_LocationRevenuePage(purchaseDetails);
//	}
//
//	/*
//	 * This is a test case to purchase regular space session as a guest with new
//	 * vehicle and through fixed discount promocode
//	 *
//	 * Author : Venu Thota(venu.t@comakeit.com)
//	 */
//	@Test(groups = { "smoke", "regression" })
//	public void TC_17_Purchase_Regular_Space_as_Guest_With_FixedDiscountPromoCode_and_NewVehicle() {
//
//		user.setLocationNumber(getRandomLocation());
//		user.setLicensePlateNumber(getRandomLicencePlate());
//		user.setVehicleType("newVehicle");
//		user.setParkingType(Constants.REGULAR_SPACE);
//		user.setTimeInHours(Constants._12_Hrs);
//		user.setPaymentVia("promocode");
//		user.setPromocode(Constants.PROMO50);
//		tp_HomePage = launch_TextPay_Application();
//		tp_HomePage.purchase_Session(user);
//		tp_HomePage.verify_Purchase_Details(user, purchaseDetails);
//
//		// Set the purchase details for location revenue page verification
//		purchaseDetails.setPaymentOption("promocode");
//		purchaseDetails.setPromocode(user.getPromocode());
//		// tp_HomePage.verify_LocationRevenuePage(purchaseDetails);
//
//	}
//
//	/*
//	 * This is a test case to purchase regular space session as a guest for unknown
//	 * vehicle and through promocode
//	 *
//	 * Author : Venu Thota(venu.t@comakeit.com)
//	 */
//	@Test(groups = { "smoke", "regression" })
//	public void TC_18_Purchase_Regular_Space_as_Guest_for_UnknownVehicle_with_FixedDiscountPromoCode() {
//
//		user.setLocationNumber(getRandomLocation());
//		user.setLicensePlateNumber(Constants.UNKNOWN);
//		user.setVehicleType("unknownVehicle");
//		user.setParkingType(Constants.REGULAR_SPACE);
//		user.setTimeInHours(Constants._12_Hrs);
//		user.setPaymentVia("promocode");
//		user.setPromocode(Constants.PROMO50);
//		tp_HomePage = launch_TextPay_Application();
//		tp_HomePage.purchase_Session(user);
//		tp_HomePage.verify_Purchase_Details(user, purchaseDetails);
//
//		// Set the purchase details for location revenue page verification
//		purchaseDetails.setPaymentOption("promocode");
//		purchaseDetails.setPromocode(user.getPromocode());
//
//		// tp_HomePage.verify_LocationRevenuePage(purchaseDetails);
//	}
//
//	/*
//	 * This is a test case to purchase Star space session as a guest with new
//	 * vehicle and through fixed discount promocode
//	 *
//	 * Author : Venu Thota(venu.t@comakeit.com)
//	 */
//	@Test(groups = { "smoke", "regression" })
//	public void TC_19_Purchase_Star_Space_as_Guest_With_FixedDiscountPromoCode_and_NewVehicle() {
//
//		user.setLocationNumber(getRandomLocation());
//		user.setLicensePlateNumber(getRandomLicencePlate());
//		user.setVehicleType("newVehicle");
//		user.setParkingType(Constants.STAR_SPACE);
//		user.setTimeInHours(Constants._2_Hrs);
//		user.setPaymentVia("promocode");
//		user.setPromocode(Constants.PROMO50);
//		tp_HomePage = launch_TextPay_Application();
//		tp_HomePage.purchase_Session(user);
//		tp_HomePage.verify_Purchase_Details(user, purchaseDetails);
//
//		// Set the purchase details for location revenue page verification
//		purchaseDetails.setPaymentOption("promocode");
//		purchaseDetails.setPromocode(user.getPromocode());
//		// tp_HomePage.verify_LocationRevenuePage(purchaseDetails);
//
//	}
//
//	/*
//	 * This is a test case to purchase Star space session as a guest for unknown
//	 * vehicle and through promocode
//	 *
//	 * Author : Venu Thota(venu.t@comakeit.com)
//	 */
//	@Test(groups = { "smoke", "regression" })
//	public void TC_20_Purchase_Star_Space_as_Guest_for_UnknownVehicle_with_FixedDiscountPromoCode() {
//
//		user.setLocationNumber(getRandomLocation());
//		user.setLicensePlateNumber(Constants.UNKNOWN);
//		user.setVehicleType("unknownVehicle");
//		user.setParkingType(Constants.STAR_SPACE);
//		user.setTimeInHours(Constants._2_Hrs);
//		user.setPaymentVia("promocode");
//		user.setPromocode(Constants.PROMO50);
//		tp_HomePage = launch_TextPay_Application();
//		tp_HomePage.purchase_Session(user);
//		tp_HomePage.verify_Purchase_Details(user, purchaseDetails);
//
//		// Set the purchase details for location revenue page verification
//		purchaseDetails.setPaymentOption("promocode");
//		purchaseDetails.setPromocode(user.getPromocode());
//
//		// tp_HomePage.verify_LocationRevenuePage(purchaseDetails);
//	}
//
//	/*
//	 * This is a test case to purchase Charging space session as a guest with new
//	 * vehicle and through fixed discount promocode
//	 *
//	 * Author : Venu Thota(venu.t@comakeit.com)
//	 */
//	// @Test(groups = { "smoke", "regression" })
//	public void TC_21_Purchase_Charging_Space_as_Guest_With_FixedDiscountPromoCode_and_NewVehicle() {
//
//		user.setLocationNumber(getRandomLocation());
//		user.setLicensePlateNumber(getRandomLicencePlate());
//		user.setVehicleType("newVehicle");
//		user.setParkingType(Constants.CHARGING_SPACE);
//		user.setTimeInHours(Constants._2_Hrs);
//		user.setPaymentVia("promocode");
//		user.setPromocode(Constants.PROMO50);
//		tp_HomePage = launch_TextPay_Application();
//		tp_HomePage.purchase_Session(user);
//		tp_HomePage.verify_Purchase_Details(user, purchaseDetails);
//
//		// Set the purchase details for location revenue page verification
//		purchaseDetails.setPaymentOption("promocode");
//		purchaseDetails.setPromocode(user.getPromocode());
//		// tp_HomePage.verify_LocationRevenuePage(purchaseDetails);
//
//	}
//
//	/*
//	 * This is a test case to purchase Star space session as a guest for unknown
//	 * vehicle and through promocode
//	 *
//	 * Author : Venu Thota(venu.t@comakeit.com)
//	 */
//	// @Test(groups = { "smoke", "regression" })
//	public void TC_22_Purchase_Charging_Space_as_Guest_for_UnknownVehicle_with_FixedDiscountPromoCode() {
//
//		user.setLocationNumber(getRandomLocation());
//		user.setLicensePlateNumber(Constants.UNKNOWN);
//		user.setVehicleType("unknownVehicle");
//		user.setParkingType(Constants.CHARGING_SPACE);
//		user.setTimeInHours(Constants._2_Hrs);
//		user.setPaymentVia("promocode");
//		user.setPromocode(Constants.PROMO50);
//		tp_HomePage = launch_TextPay_Application();
//		tp_HomePage.purchase_Session(user);
//		tp_HomePage.verify_Purchase_Details(user, purchaseDetails);
//
//		// Set the purchase details for location revenue page verification
//		purchaseDetails.setPaymentOption("promocode");
//		purchaseDetails.setPromocode(user.getPromocode());
//
//		// tp_HomePage.verify_LocationRevenuePage(purchaseDetails);
//	}
//
//	/*
//	 * This is a test case to purchase Charging space session as a guest with new
//	 * vehicle and through fixed discount promocode
//	 *
//	 * Author : Venu Thota(venu.t@comakeit.com)
//	 */
//	// @Test(groups = { "smoke", "regression" })
//	public void TC_23_Purchase_SpecialRate_Session_as_Guest_With_FixedDiscountPromoCode_and_NewVehicle() {
//
//		user.setLocationNumber(getRandomLocation());
//		user.setLicensePlateNumber(getRandomLicencePlate());
//		user.setVehicleType("newVehicle");
//		user.setParkingType(Constants.SPECIAL_RATE);
//		user.setTimeInHours(Constants._2_Hrs);
//		user.setPaymentVia("promocode");
//		user.setPromocode(Constants.PROMO50);
//		tp_HomePage = launch_TextPay_Application();
//		tp_HomePage.purchase_Session(user);
//		tp_HomePage.verify_Purchase_Details(user, purchaseDetails);
//
//		// Set the purchase details for location revenue page verification
//		purchaseDetails.setPaymentOption("promocode");
//		purchaseDetails.setPromocode(user.getPromocode());
//		// tp_HomePage.verify_LocationRevenuePage(purchaseDetails);
//
//	}
//
//	/*
//	 * This is a test case to purchase Star space session as a guest for unknown
//	 * vehicle and through promocode
//	 *
//	 * Author : Venu Thota(venu.t@comakeit.com)
//	 */
//	// @Test(groups = { "smoke", "regression" })
//	public void TC_24_Purchase_SpecialRate_Session_as_Guest_for_UnknownVehicle_with_FixedDiscountPromoCode() {
//
//		user.setLocationNumber(getRandomLocation());
//		user.setLicensePlateNumber(Constants.UNKNOWN);
//		user.setVehicleType("unknownVehicle");
//		user.setParkingType(Constants.SPECIAL_RATE);
//		user.setTimeInHours(Constants._2_Hrs);
//		user.setPaymentVia("promocode");
//		user.setPromocode(Constants.PROMO50);
//		tp_HomePage = launch_TextPay_Application();
//		tp_HomePage.purchase_Session(user);
//		tp_HomePage.verify_Purchase_Details(user, purchaseDetails);
//
//		// Set the purchase details for location revenue page verification
//		purchaseDetails.setPaymentOption("promocode");
//		purchaseDetails.setPromocode(user.getPromocode());
//
//		// tp_HomePage.verify_LocationRevenuePage(purchaseDetails);
//	}
//
//	/*
//	 * This is a test case to purchase regular space session as a guest with new
//	 * vehicle and through card payment
//	 *
//	 * Author : Venu Thota(venu.t@comakeit.com)
//	 */
//
//	// @Test(groups = { "smoke", "regression" })
//	public void TC_17_Purchase_Regular_Space_with_PEEKProduct_as_Guest_With_NewCard_and_NewVehicle() {
//
//		user.setLocationNumber(getRandom_PEEK_Location());
//		String licencePlate = getRandomLicencePlate();
//		user.setLicensePlateNumber(licencePlate);
//		user.setVehicleType("newVehicle");
//		user.setParkingType(Constants.REGULAR_SPACE);
//		user.setPaymentVia(Constants.CARD);
//		user.setCcNumber(Constants.VISA_CARD_NUMBER);
//		tp_HomePage = launch_TextPay_Application();
//		tp_HomePage.purchase_Session(user);
//		tp_HomePage.verify_Purchase_Details(user, purchaseDetails);
//
//		// Set the purchase details for location revenue page verification
//		purchaseDetails.setPaymentOption(Constants.CARD);
//		purchaseDetails.setPaymentMethod(Constants.VISA_CARD_TYPE);
//		// tp_HomePage.verify_LocationRevenuePage(purchaseDetails);
//
//	}

}
