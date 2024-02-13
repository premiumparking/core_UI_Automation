package testcases.TextPay;

import org.testng.annotations.Test;

import components.BaseClass;
import components.Constants;
import dataModel.TextPay.Guest;
import dataModel.TextPay.PurchaseDetails;
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
	 * This is a test case to purchase regular space session as a guest with new
	 * vehicle and through card payment
	 *
	 * Author : Venu Thota(venu.thota@xebia.com)
	 */

	@Test(groups = { "smoke", "regression" })
	public void TC_01_Purchase_Regular_Space_as_Guest_With_NewCard_and_NewVehicle() {

		guest.setLocationNumber(getRandomLocation());
		String licencePlate = getRandomLicencePlate();
		guest.setLicensePlateNumber(licencePlate);
		guest.setVehicleType("newVehicle");
		guest.setParkingType(Constants.REGULAR_SPACE);
		guest.setPaymentVia(Constants.CARD);
		guest.setCcNumber(Constants.VISA_CARD_NUMBER);
		tp_HomePage = launch_TextPay_Application();
		tp_HomePage.purchase_Session(guest, Constants.TEXTPAY);
		tp_HomePage.verify_Purchase_Details(guest, purchaseDetails);

		// Set the purchase details for location revenue page verification
		purchaseDetails.setPaymentOption(Constants.CARD);
		purchaseDetails.setPaymentMethod(Constants.VISA_CARD_TYPE);
		// tp_HomePage.verify_LocationRevenuePage(purchaseDetails);

	}

	/*
	 * This is a test case to purchase regular space session as a guest with new
	 * vehicle and through promocode
	 *
	 * Author : Venu Thota(venu.thota@xebia.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_02_Purchase_Regular_Space_as_Guest_With_PromoCode_and_NewVehicle() {

		guest.setLocationNumber(getRandomLocation());
		guest.setLicensePlateNumber(getRandomLicencePlate());
		guest.setVehicleType("newVehicle");
		guest.setParkingType(Constants.REGULAR_SPACE);
		guest.setPaymentVia("promocode");
		guest.setPromocode(Constants.PROMO100);
		tp_HomePage = launch_TextPay_Application();
		tp_HomePage.purchase_Session(guest, Constants.TEXTPAY);
		tp_HomePage.verify_Purchase_Details(guest, purchaseDetails);

		// Set the purchase details for location revenue page verification
		purchaseDetails.setPaymentOption("promocode");
		purchaseDetails.setPromocode(guest.getPromocode());
		// tp_HomePage.verify_LocationRevenuePage(purchaseDetails);

	}

	/*
	 * This is a test case to purchase regular space session as a guest for unknown
	 * vehicle and  through card payment
	 *
	 * Author : Venu Thota(venu.thota@xebia.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_03_Purchase_Regular_Space_as_Guest_for_UnknownVehicle_with_NewCard() {

		guest.setLocationNumber(getRandomLocation());
		guest.setLicensePlateNumber(Constants.UNKNOWN);
		guest.setVehicleType("unknownVehicle");
		guest.setParkingType(Constants.REGULAR_SPACE);
		guest.setPaymentVia(Constants.CARD);
		guest.setCcNumber(Constants.VISA_CARD_NUMBER);
		tp_HomePage = launch_TextPay_Application();
		tp_HomePage.purchase_Session(guest, Constants.TEXTPAY);
		tp_HomePage.verify_Purchase_Details(guest, purchaseDetails);

		// Set the purchase details for location revenue page verification
		purchaseDetails.setPaymentOption(Constants.CARD);
		purchaseDetails.setPaymentMethod(Constants.VISA_CARD_TYPE);

		// tp_HomePage.verify_LocationRevenuePage(purchaseDetails);
	}

	/*
	 * This is a test case to purchase regular space session as a guest for unknown
	 * vehicle and through promocode
	 *
	 * Author : Venu Thota(venu.thota@xebia.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_04_Purchase_Regular_Space_as_Guest_for_UnknownVehicle_with_PromoCode() {

		guest.setLocationNumber(getRandomLocation());
		guest.setLicensePlateNumber(Constants.UNKNOWN);
		guest.setVehicleType("unknownVehicle");
		guest.setParkingType(Constants.REGULAR_SPACE);
		guest.setPaymentVia("promocode");
		guest.setPromocode(Constants.PROMO100);
		tp_HomePage = launch_TextPay_Application();
		tp_HomePage.purchase_Session(guest, Constants.TEXTPAY);
		tp_HomePage.verify_Purchase_Details(guest, purchaseDetails);

		// Set the purchase details for location revenue page verification
		purchaseDetails.setPaymentOption("promocode");
		purchaseDetails.setPromocode(guest.getPromocode());

		// tp_HomePage.verify_LocationRevenuePage(purchaseDetails);
	}

	/*
	 * This is a test case to purchase star space session as a guest for unknown
	 * vehicle and through promocode
	 *
	 * Author : Venu Thota(venu.thota@xebia.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_05_Purchase_Star_Space_as_Guest_With_NewCard_and_NewVehicle() {

		guest.setLocationNumber(getRandomLocation());
		guest.setLicensePlateNumber(getRandomLicencePlate());
		guest.setVehicleType("newVehicle");
		guest.setParkingType(Constants.STAR_SPACE);
		guest.setPaymentVia(Constants.CARD);
		guest.setTimeInHours(Constants._2_Hrs);
		guest.setCcNumber(Constants.VISA_CARD_NUMBER);
		tp_HomePage = launch_TextPay_Application();
		tp_HomePage.purchase_Session(guest, Constants.TEXTPAY);
		tp_HomePage.verify_Purchase_Details(guest, purchaseDetails);

		// Set the purchase details for location revenue page verification
		purchaseDetails.setPaymentOption(Constants.CARD);
		purchaseDetails.setPaymentMethod(Constants.VISA_CARD_TYPE);

		// tp_HomePage.verify_LocationRevenuePage(purchaseDetails);
	}

	/*
	 * This is a test case to purchase star space session as a guest with new
	 * vehicle and promocode payment method
	 *
	 * Author : Venu Thota(venu.thota@xebia.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_06_Purchase_Star_Space_as_Guest_With_PromoCode_and_NewVehicle() {

		guest.setLocationNumber(getRandomLocation());
		guest.setLicensePlateNumber(getRandomLicencePlate());
		guest.setVehicleType("newVehicle");
		guest.setParkingType(Constants.STAR_SPACE);
		guest.setPaymentVia("promocode");
		guest.setPromocode(Constants.PROMO100);
		guest.setTimeInHours(Constants._5_Hrs);
		tp_HomePage = launch_TextPay_Application();
		tp_HomePage.purchase_Session(guest, Constants.TEXTPAY);
		tp_HomePage.verify_Purchase_Details(guest, purchaseDetails);

		// Set the purchase details for location revenue page verification
		purchaseDetails.setPaymentOption("promocode");
		purchaseDetails.setPromocode(guest.getPromocode());
		// tp_HomePage.verify_LocationRevenuePage(purchaseDetails);
	}

	/*
	 * This is a test case to purchase star space session as a guest for unknown
	 * vehicle with new card payment method
	 *
	 * Author : Venu Thota(venu.thota@xebia.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_07_Purchase_Star_Space_as_Guest_for_UnknownVehicle_with_NewCard() {

		guest.setLocationNumber(getRandomLocation());
		guest.setLicensePlateNumber(Constants.UNKNOWN);
		guest.setVehicleType("unknownVehicle");
		guest.setParkingType(Constants.STAR_SPACE);
		guest.setPaymentVia(Constants.CARD);
		guest.setTimeInHours(Constants._1_Hr);
		guest.setCcNumber(Constants.VISA_CARD_NUMBER);
		tp_HomePage = launch_TextPay_Application();
		tp_HomePage.purchase_Session(guest, Constants.TEXTPAY);
		tp_HomePage.verify_Purchase_Details(guest, purchaseDetails);

		// Set the purchase details for location revenue page verification
		purchaseDetails.setPaymentOption(Constants.CARD);
		purchaseDetails.setPaymentMethod(Constants.VISA_CARD_TYPE);

		// tp_HomePage.verify_LocationRevenuePage(purchaseDetails);
	}

	/*
	 * This is a test case to purchase star space session as a guest for unknown
	 * vehicle and through promocode
	 *
	 * Author : Venu Thota(venu.thota@xebia.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_08_Purchase_Star_Space_as_Guest_for_UnknownVehicle_with_PromoCode() {

		guest.setLocationNumber(getRandomLocation());
		guest.setLicensePlateNumber(Constants.UNKNOWN);
		guest.setVehicleType("unknownVehicle");
		guest.setParkingType(Constants.STAR_SPACE);
		guest.setPaymentVia("promocode");
		guest.setPromocode(Constants.PROMO100);
		guest.setTimeInHours(Constants._2_Hrs);
		tp_HomePage = launch_TextPay_Application();
		tp_HomePage.purchase_Session(guest, Constants.TEXTPAY);
		tp_HomePage.verify_Purchase_Details(guest, purchaseDetails);

		// Set the purchase details for location revenue page verification
		purchaseDetails.setPaymentOption("promocode");
		purchaseDetails.setPromocode(guest.getPromocode());
		// tp_HomePage.verify_LocationRevenuePage(purchaseDetails);
	}

	/*
	 * This is a test case to purchase charging space session as a guest for unknown
	 * vehicle and through promocode
	 *
	 * Author : Venu Thota(venu.thota@xebia.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_09_Purchase_Charging_Space_as_Guest_With_NewCard_and_NewVehicle() {

		guest.setLocationNumber(getRandomLocation());
		guest.setLicensePlateNumber(getRandomLicencePlate());
		guest.setVehicleType("newVehicle");
		guest.setParkingType(Constants.CHARGING_SPACE);
		guest.setPaymentVia(Constants.CARD);
		guest.setCcNumber(Constants.VISA_CARD_NUMBER);
		guest.setTimeInHours(Constants._2_Hrs);
		tp_HomePage = launch_TextPay_Application();
		tp_HomePage.purchase_Session(guest, Constants.TEXTPAY);
		tp_HomePage.verify_Purchase_Details(guest, purchaseDetails);

		// Set the purchase details for location revenue page verification
		purchaseDetails.setPaymentOption(Constants.CARD);
		purchaseDetails.setPaymentMethod(Constants.VISA_CARD_TYPE);

		// tp_HomePage.verify_LocationRevenuePage(purchaseDetails);
	}

	/*
	 * This is a test case to purchase charging space session as a guest with new
	 * vehicle and promocode payment method
	 *
	 * Author : Venu Thota(venu.thota@xebia.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_10_Charging_Space_as_Guest_With_PromoCode_and_NewVehicle() {

		guest.setLocationNumber(getRandomLocation());
		guest.setLicensePlateNumber(getRandomLicencePlate());
		guest.setVehicleType("newVehicle");
		guest.setParkingType(Constants.CHARGING_SPACE);
		guest.setPaymentVia("promocode");
		guest.setPromocode(Constants.PROMO100);
		guest.setTimeInHours(Constants._5_Hrs);
		tp_HomePage = launch_TextPay_Application();
		tp_HomePage.purchase_Session(guest, Constants.TEXTPAY);
		tp_HomePage.verify_Purchase_Details(guest, purchaseDetails);

		// Set the purchase details for location revenue page verification
		purchaseDetails.setPaymentOption("promocode");
		purchaseDetails.setPromocode(guest.getPromocode());
		// tp_HomePage.verify_LocationRevenuePage(purchaseDetails);
	}

	/*
	 * This is a test case to purchase charging space session as a guest for unknown
	 * vehicle with new card payment method
	 *
	 * Author : Venu Thota(venu.thota@xebia.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_11_Charging_Space_as_Guest_for_UnknownVehicle_with_NewCard() {

		guest.setLocationNumber(getRandomLocation());
		guest.setLicensePlateNumber(Constants.UNKNOWN);
		guest.setVehicleType("unknownVehicle");
		guest.setParkingType(Constants.CHARGING_SPACE);
		guest.setPaymentVia(Constants.CARD);
		guest.setCcNumber(Constants.VISA_CARD_NUMBER);
		guest.setTimeInHours(Constants._1_Hr);
		tp_HomePage = launch_TextPay_Application();
		tp_HomePage.purchase_Session(guest, Constants.TEXTPAY);
		tp_HomePage.verify_Purchase_Details(guest, purchaseDetails);

		// Set the purchase details for location revenue page verification
		purchaseDetails.setPaymentOption(Constants.CARD);
		purchaseDetails.setPaymentMethod(Constants.VISA_CARD_TYPE);

		// tp_HomePage.verify_LocationRevenuePage(purchaseDetails);
	}

	/*
	 * This is a test case to purchase charging space session as a guest for unknown
	 * vehicle and through promocode
	 *
	 * Author : Venu Thota(venu.thota@xebia.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_12_Charging_Star_Space_as_Guest_for_UnknownVehicle_with_PromoCode() {

		guest.setLocationNumber(getRandomLocation());
		guest.setLicensePlateNumber(Constants.UNKNOWN);
		guest.setVehicleType("unknownVehicle");
		guest.setParkingType(Constants.CHARGING_SPACE);
		guest.setPaymentVia("promocode");
		guest.setPromocode(Constants.PROMO100);
		guest.setTimeInHours(Constants._2_Hrs);
		tp_HomePage = launch_TextPay_Application();
		tp_HomePage.purchase_Session(guest, Constants.TEXTPAY);
		tp_HomePage.verify_Purchase_Details(guest, purchaseDetails);

		// Set the purchase details for location revenue page verification
		purchaseDetails.setPaymentOption("promocode");
		purchaseDetails.setPromocode(guest.getPromocode());
		// tp_HomePage.verify_LocationRevenuePage(purchaseDetails);
	}

	/*
	 * This is a test case to purchase regular space session as a guest with new
	 * vehicle and through card payment
	 *
	 * Author : Venu Thota(venu.thota@xebia.com)
	 */

	@Test(groups = { "smoke", "regression" })
	public void TC_13_Purchase_SpecialRate_Session_as_Guest_With_NewCard_and_NewVehicle() {

		guest.setLocationNumber(getRandomLocation());
		String licencePlate = getRandomLicencePlate();
		guest.setLicensePlateNumber(licencePlate);
		guest.setVehicleType("newVehicle");
		guest.setParkingType(Constants.SPECIAL_RATE);
		guest.setPaymentVia(Constants.CARD);
		guest.setTimeInHours(Constants._2_Hrs);
		guest.setCcNumber(Constants.VISA_CARD_NUMBER);
		tp_HomePage = launch_TextPay_Application();
		tp_HomePage.purchase_Session(guest, Constants.TEXTPAY);
		tp_HomePage.verify_Purchase_Details(guest, purchaseDetails);

		// Set the purchase details for location revenue page verification
		purchaseDetails.setPaymentOption(Constants.CARD);
		purchaseDetails.setPaymentMethod(Constants.VISA_CARD_TYPE);
		// tp_HomePage.verify_LocationRevenuePage(purchaseDetails);

	}

	/*
	 * This is a test case to purchase regular space session as a guest with new
	 * vehicle and promocode payment method
	 *
	 * Author : Venu Thota(venu.thota@xebia.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_14_Purchase_SpecialRate_Session_as_Guest_With_PromoCode_and_NewVehicle() {

		guest.setLocationNumber(getRandomLocation());
		guest.setLicensePlateNumber(getRandomLicencePlate());
		guest.setVehicleType("newVehicle");
		guest.setParkingType(Constants.SPECIAL_RATE);
		guest.setPaymentVia("promocode");
		guest.setPromocode(Constants.PROMO100);
		guest.setTimeInHours(Constants._1_Hr);
		tp_HomePage = launch_TextPay_Application();
		tp_HomePage.purchase_Session(guest, Constants.TEXTPAY);
		tp_HomePage.verify_Purchase_Details(guest, purchaseDetails);

		// Set the purchase details for location revenue page verification
		purchaseDetails.setPaymentOption("promocode");
		purchaseDetails.setPromocode(guest.getPromocode());
		// tp_HomePage.verify_LocationRevenuePage(purchaseDetails);

	}

	/*
	 * This is a test case to purchase regular space session as a guest for unknown
	 * vehicle with new card payment method
	 *
	 * Author : Venu Thota(venu.thota@xebia.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_15_Purchase_SpecialRate_Session_as_Guest_for_UnknownVehicle_with_NewCard() {

		guest.setLocationNumber(getRandomLocation());
		guest.setLicensePlateNumber(Constants.UNKNOWN);
		guest.setVehicleType("unknownVehicle");
		guest.setParkingType(Constants.SPECIAL_RATE);
		guest.setPaymentVia(Constants.CARD);
		guest.setTimeInHours(Constants._5_Hrs);
		guest.setCcNumber(Constants.VISA_CARD_NUMBER);
		tp_HomePage = launch_TextPay_Application();
		tp_HomePage.purchase_Session(guest, Constants.TEXTPAY);
		tp_HomePage.verify_Purchase_Details(guest, purchaseDetails);

		// Set the purchase details for location revenue page verification
		purchaseDetails.setPaymentOption(Constants.CARD);
		purchaseDetails.setPaymentMethod(Constants.VISA_CARD_TYPE);

		 tp_HomePage.verify_LocationRevenuePage(purchaseDetails);
	}

	/*
	 * This is a test case to purchase regular space session as a guest for unknown
	 * vehicle and through promocode
	 *
	 * Author : Venu Thota(venu.thota@xebia.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_16_Purchase_SpecialRate_Session_as_Guest_for_UnknownVehicle_with_PromoCode() {

		guest.setLocationNumber(getRandomLocation());
		guest.setLicensePlateNumber(Constants.UNKNOWN);
		guest.setVehicleType("unknownVehicle");
		guest.setParkingType(Constants.SPECIAL_RATE);
		guest.setPaymentVia("promocode");
		guest.setPromocode(Constants.PROMO100);
		guest.setTimeInHours(Constants._2_Hrs);
		tp_HomePage = launch_TextPay_Application();
		tp_HomePage.purchase_Session(guest, Constants.TEXTPAY);
		tp_HomePage.verify_Purchase_Details(guest, purchaseDetails);

		// Set the purchase details for location revenue page verification
		purchaseDetails.setPaymentOption("promocode");
		purchaseDetails.setPromocode(guest.getPromocode());

		// tp_HomePage.verify_LocationRevenuePage(purchaseDetails);
	}
	
	/*
	 * This is a test case to purchase regular space session as a guest with new
	 * vehicle and through fixed discount promocode
	 *
	 * Author : Venu Thota(venu.thota@xebia.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_17_Purchase_Regular_Space_as_Guest_With_FixedDiscountPromoCode_and_NewVehicle() {

		guest.setLocationNumber(getRandomLocation());
		guest.setLicensePlateNumber(getRandomLicencePlate());
		guest.setVehicleType("newVehicle");
		guest.setParkingType(Constants.REGULAR_SPACE);
		guest.setTimeInHours(Constants._12_Hrs);
		guest.setPaymentVia("promocode");
		guest.setPromocode(Constants.PROMO50);
		tp_HomePage = launch_TextPay_Application();
		tp_HomePage.purchase_Session(guest, Constants.TEXTPAY);
		tp_HomePage.verify_Purchase_Details(guest, purchaseDetails);

		// Set the purchase details for location revenue page verification
		purchaseDetails.setPaymentOption("promocode");
		purchaseDetails.setPromocode(guest.getPromocode());
		// tp_HomePage.verify_LocationRevenuePage(purchaseDetails);

	}

	/*
	 * This is a test case to purchase regular space session as a guest for unknown
	 * vehicle and through promocode
	 *
	 * Author : Venu Thota(venu.thota@xebia.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_18_Purchase_Regular_Space_as_Guest_for_UnknownVehicle_with_FixedDiscountPromoCode() {

		guest.setLocationNumber(getRandomLocation());
		guest.setLicensePlateNumber(Constants.UNKNOWN);
		guest.setVehicleType("unknownVehicle");
		guest.setParkingType(Constants.REGULAR_SPACE);
		guest.setTimeInHours(Constants._12_Hrs);
		guest.setPaymentVia("promocode");
		guest.setPromocode(Constants.PROMO50);
		tp_HomePage = launch_TextPay_Application();
		tp_HomePage.purchase_Session(guest, Constants.TEXTPAY);
		tp_HomePage.verify_Purchase_Details(guest, purchaseDetails);

		// Set the purchase details for location revenue page verification
		purchaseDetails.setPaymentOption("promocode");
		purchaseDetails.setPromocode(guest.getPromocode());

		// tp_HomePage.verify_LocationRevenuePage(purchaseDetails);
	}
	
	/*
	 * This is a test case to purchase Star space session as a guest with new
	 * vehicle and through fixed discount promocode
	 *
	 * Author : Venu Thota(venu.thota@xebia.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_19_Purchase_Star_Space_as_Guest_With_FixedDiscountPromoCode_and_NewVehicle() {

		guest.setLocationNumber(getRandomLocation());
		guest.setLicensePlateNumber(getRandomLicencePlate());
		guest.setVehicleType("newVehicle");
		guest.setParkingType(Constants.STAR_SPACE);
		guest.setTimeInHours(Constants._2_Hrs);
		guest.setPaymentVia("promocode");
		guest.setPromocode(Constants.PROMO50);
		tp_HomePage = launch_TextPay_Application();
		tp_HomePage.purchase_Session(guest, Constants.TEXTPAY);
		tp_HomePage.verify_Purchase_Details(guest, purchaseDetails);

		// Set the purchase details for location revenue page verification
		purchaseDetails.setPaymentOption("promocode");
		purchaseDetails.setPromocode(guest.getPromocode());
		// tp_HomePage.verify_LocationRevenuePage(purchaseDetails);

	}

	/*
	 * This is a test case to purchase Star space session as a guest for unknown
	 * vehicle and through promocode
	 *
	 * Author : Venu Thota(venu.thota@xebia.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_20_Purchase_Star_Space_as_Guest_for_UnknownVehicle_with_FixedDiscountPromoCode() {

		guest.setLocationNumber(getRandomLocation());
		guest.setLicensePlateNumber(Constants.UNKNOWN);
		guest.setVehicleType("unknownVehicle");
		guest.setParkingType(Constants.STAR_SPACE);
		guest.setTimeInHours(Constants._2_Hrs);
		guest.setPaymentVia("promocode");
		guest.setPromocode(Constants.PROMO50);
		tp_HomePage = launch_TextPay_Application();
		tp_HomePage.purchase_Session(guest, Constants.TEXTPAY);
		tp_HomePage.verify_Purchase_Details(guest, purchaseDetails);

		// Set the purchase details for location revenue page verification
		purchaseDetails.setPaymentOption("promocode");
		purchaseDetails.setPromocode(guest.getPromocode());

		// tp_HomePage.verify_LocationRevenuePage(purchaseDetails);
	}
	
	/*
	 * This is a test case to purchase Charging space session as a guest with new
	 * vehicle and through fixed discount promocode
	 *
	 * Author : Venu Thota(venu.thota@xebia.com)
	 */
	//@Test(groups = { "smoke", "regression" })
	public void TC_21_Purchase_Charging_Space_as_Guest_With_FixedDiscountPromoCode_and_NewVehicle() {

		guest.setLocationNumber(getRandomLocation());
		guest.setLicensePlateNumber(getRandomLicencePlate());
		guest.setVehicleType("newVehicle");
		guest.setParkingType(Constants.CHARGING_SPACE);
		guest.setTimeInHours(Constants._2_Hrs);
		guest.setPaymentVia("promocode");
		guest.setPromocode(Constants.PROMO50);
		tp_HomePage = launch_TextPay_Application();
		tp_HomePage.purchase_Session(guest, Constants.TEXTPAY);
		tp_HomePage.verify_Purchase_Details(guest, purchaseDetails);

		// Set the purchase details for location revenue page verification
		purchaseDetails.setPaymentOption("promocode");
		purchaseDetails.setPromocode(guest.getPromocode());
		// tp_HomePage.verify_LocationRevenuePage(purchaseDetails);

	}

	/*
	 * This is a test case to purchase Star space session as a guest for unknown
	 * vehicle and through promocode
	 *
	 * Author : Venu Thota(venu.thota@xebia.com)
	 */
	//@Test(groups = { "smoke", "regression" })
	public void TC_22_Purchase_Charging_Space_as_Guest_for_UnknownVehicle_with_FixedDiscountPromoCode() {

		guest.setLocationNumber(getRandomLocation());
		guest.setLicensePlateNumber(Constants.UNKNOWN);
		guest.setVehicleType("unknownVehicle");
		guest.setParkingType(Constants.CHARGING_SPACE);
		guest.setTimeInHours(Constants._2_Hrs);
		guest.setPaymentVia("promocode");
		guest.setPromocode(Constants.PROMO50);
		tp_HomePage = launch_TextPay_Application();
		tp_HomePage.purchase_Session(guest, Constants.TEXTPAY);
		tp_HomePage.verify_Purchase_Details(guest, purchaseDetails);

		// Set the purchase details for location revenue page verification
		purchaseDetails.setPaymentOption("promocode");
		purchaseDetails.setPromocode(guest.getPromocode());

		// tp_HomePage.verify_LocationRevenuePage(purchaseDetails);
	}
	
	/*
	 * This is a test case to purchase Charging space session as a guest with new
	 * vehicle and through fixed discount promocode
	 *
	 * Author : Venu Thota(venu.thota@xebia.com)
	 */
	//@Test(groups = { "smoke", "regression" })
	public void TC_23_Purchase_SpecialRate_Session_as_Guest_With_FixedDiscountPromoCode_and_NewVehicle() {

		guest.setLocationNumber(getRandomLocation());
		guest.setLicensePlateNumber(getRandomLicencePlate());
		guest.setVehicleType("newVehicle");
		guest.setParkingType(Constants.SPECIAL_RATE);
		guest.setTimeInHours(Constants._2_Hrs);
		guest.setPaymentVia("promocode");
		guest.setPromocode(Constants.PROMO50);
		tp_HomePage = launch_TextPay_Application();
		tp_HomePage.purchase_Session(guest, Constants.TEXTPAY);
		tp_HomePage.verify_Purchase_Details(guest, purchaseDetails);

		// Set the purchase details for location revenue page verification
		purchaseDetails.setPaymentOption("promocode");
		purchaseDetails.setPromocode(guest.getPromocode());
		// tp_HomePage.verify_LocationRevenuePage(purchaseDetails);

	}

	/*
	 * This is a test case to purchase Star space session as a guest for unknown
	 * vehicle and through promocode
	 *
	 * Author : Venu Thota(venu.thota@xebia.com)
	 */
	//@Test(groups = { "smoke", "regression" })
	public void TC_24_Purchase_SpecialRate_Session_as_Guest_for_UnknownVehicle_with_FixedDiscountPromoCode() {

		guest.setLocationNumber(getRandomLocation());
		guest.setLicensePlateNumber(Constants.UNKNOWN);
		guest.setVehicleType("unknownVehicle");
		guest.setParkingType(Constants.SPECIAL_RATE);
		guest.setTimeInHours(Constants._2_Hrs);
		guest.setPaymentVia("promocode");
		guest.setPromocode(Constants.PROMO50);
		tp_HomePage = launch_TextPay_Application();
		tp_HomePage.purchase_Session(guest, Constants.TEXTPAY);
		tp_HomePage.verify_Purchase_Details(guest, purchaseDetails);

		// Set the purchase details for location revenue page verification
		purchaseDetails.setPaymentOption("promocode");
		purchaseDetails.setPromocode(guest.getPromocode());

		// tp_HomePage.verify_LocationRevenuePage(purchaseDetails);
	}

	/*
	 * This is a test case to purchase regular space session as a guest with new
	 * vehicle and through card payment
	 *
	 * Author : Venu Thota(venu.thota@xebia.com)
	 */

	// @Test(groups = { "smoke", "regression" })
	public void TC_17_Purchase_Regular_Space_with_PEEKProduct_as_Guest_With_NewCard_and_NewVehicle() {

		guest.setLocationNumber(getRandom_PEEK_Location());
		String licencePlate = getRandomLicencePlate();
		guest.setLicensePlateNumber(licencePlate);
		guest.setVehicleType("newVehicle");
		guest.setParkingType(Constants.REGULAR_SPACE);
		guest.setPaymentVia(Constants.CARD);
		guest.setCcNumber(Constants.VISA_CARD_NUMBER);
		tp_HomePage = launch_TextPay_Application();
		tp_HomePage.purchase_Session(guest, Constants.TEXTPAY);
		tp_HomePage.verify_Purchase_Details(guest, purchaseDetails);

		// Set the purchase details for location revenue page verification
		purchaseDetails.setPaymentOption(Constants.CARD);
		purchaseDetails.setPaymentMethod(Constants.VISA_CARD_TYPE);
		// tp_HomePage.verify_LocationRevenuePage(purchaseDetails);

	}

}
