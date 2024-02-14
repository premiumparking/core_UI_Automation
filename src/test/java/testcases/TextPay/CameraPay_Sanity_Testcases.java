package testcases.TextPay;

import org.apache.batik.transcoder.TranscoderException;
import org.testng.annotations.Test;
import components.BaseClass;
import components.Constants;
import dataModel.TextPay.Guest;
import dataModel.TextPay.PurchaseDetails;

import pageObjects.TextPay.TextPay_HomePage;
import utils.Email_Verification;
import utils.PrepareTestData;
import utils.XML_Operations;

public class CameraPay_Sanity_Testcases extends BaseClass {

	// *******************TEST CASES******************************* //

	/*
	 * TC_01_Purchase_RegularSpace_withPhoneNumber_WithNewCard_NewVehicle_VerifyMail
	 * TC_02_Purchase_RegularSpecialSpace_withPhoneNumber_FullDiscountPromoCode_UnknownVehicle_VerifyMail
	 * TC_03_Purchase_RegularSpace_asGuest_WithCard_UnknownVehicle_VerifyMail
	 * TC_04_Purchase_RegularSpace_asGuest_withFullDiscountPromoCode_NewVehicle_VerifyMail
	 * TC_05_Purchase_StarSpace_asGuest_WithCard_NewVehicle_VerifyMail
	 * TC_06_Purchase_StarSpace_withPhoneNumber_FullDiscountPromoCode_UnknownVehicle_VerifyMail
	 * TC_07_Purchase_StarSpace_asGuest_WithCard_UnknownVehicle_VerifyMail
	 * TC_08_Purchase_StarSpace_withPhoneNumber_FullDiscountPromoCode_NewVehicle_VerifyMail
	 * TC_09_Purchase_ChargingSpace_asGuest_WithCard_NewVehicle_VerifyMail
	 * TC_10_Purchase_ChargingSpace_withPhoneNumber_FullDiscountPromoCode_UnknownVehicle_VerifyMail
	 * TC_11_Purchase_ChargingSpace_asGuest_WithCard_UnknownVehicle_VerifyMail
	 * TC_12_Purchase_ChargingSpace_withPhoneNumber_FullDiscountPromoCode_NewVehicle_VerifyMail
	 */

	// ****************** CLASS INSTANCES ****************************//
	XML_Operations xml_Ops = new XML_Operations();
	TextPay_HomePage tp_HomePage = new TextPay_HomePage();
	PurchaseDetails purchaseDetails = new PurchaseDetails();
	Email_Verification emailPage = new Email_Verification();
	PrepareTestData testData = new PrepareTestData();

	// ****************** TEST DATA ****************************//
	Guest user = (Guest) xml_Ops.getTestData("guest");

	// ****************** TEST SCRIPTS ****************************//

	/*
	 * This is a test case to purchase regular space session with phone number, with
	 * new vehicle and through card payment
	 *
	 * Author : Venu Thota(venu.thota@xebia.com)
	 */

	@Test(groups = { "smoke", "regression" })
	public void TC_01_Purchase_RegularSpace_withPhoneNumber_WithNewCard_NewVehicle_VerifyMail()
			throws TranscoderException {

		// Test data setup
		user = testData.get_User_Testdata(false, Constants.NEW_VEHICLE, Constants.REGULAR_SPACE, 12, true,
				Constants.CARD);

		// Test steps
		tp_HomePage = launch_TextPay_Application_withLocation_QR_code();
		tp_HomePage.purchase_Session(user, Constants.CAMERAPAY);
		tp_HomePage.send_Receipt_to_Email(user.getEmail());

		// Verification
		tp_HomePage.verify_Purchase_Details(user, purchaseDetails);
		tp_HomePage.verify_LocationRevenuePage(purchaseDetails);
		emailPage.verify_PurchaseDetails_On_Email(purchaseDetails);

	}

	/*
	 * This is a test case to purchase regular space special rate session with phone
	 * number,with new vehicle and through promocode
	 *
	 * Author : Venu Thota(venu.thota@xebia.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_02_Purchase_RegularSpecialSpace_withPhoneNumber_FullDiscountPromoCode_UnknownVehicle_VerifyMail()
			throws TranscoderException {

		// Test data setup
		user = testData.get_User_Testdata(false, Constants.UNKNOWN_VEHICLE, Constants.SPECIAL_RATE, 12, false,
				Constants.PROMOCODE);

		// Test steps
		tp_HomePage = launch_TextPay_Application_withLocation_QR_code();
		tp_HomePage.purchase_Session(user, Constants.CAMERAPAY);
		tp_HomePage.send_Receipt_to_Email(user.getEmail());

		// Verification
		tp_HomePage.verify_Purchase_Details(user, purchaseDetails);
		tp_HomePage.verify_LocationRevenuePage(purchaseDetails);
		emailPage.verify_PurchaseDetails_On_Email(purchaseDetails);

	}

	/*
	 * This is a test case to purchase regular space with special rate session as
	 * Guest, with Unknown vehicle and through card payment
	 *
	 * Author : Venu Thota(venu.thota@xebia.com)
	 */

	@Test(groups = { "smoke", "regression" })
	public void TC_03_Purchase_RegularSpace_asGuest_WithCard_UnknownVehicle_VerifyMail() throws TranscoderException {

		// Test data setup
		user = testData.get_User_Testdata(true, Constants.UNKNOWN_VEHICLE, Constants.SPECIAL_RATE, 5, true,
				Constants.CARD);

		// Test steps
		tp_HomePage = launch_TextPay_Application_withLocation_QR_code();
		tp_HomePage.purchase_Session(user, Constants.CAMERAPAY);
		tp_HomePage.send_Receipt_to_Email(user.getEmail());

		// Verification
		tp_HomePage.verify_Purchase_Details(user, purchaseDetails);
		tp_HomePage.verify_LocationRevenuePage(purchaseDetails);
		emailPage.verify_PurchaseDetails_On_Email(purchaseDetails);
	}

	/*
	 * This is a test case to purchase regular space session as guest,with new
	 * vehicle and through promocode
	 *
	 * Author : Venu Thota(venu.thota@xebia.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_04_Purchase_RegularSpace_asGuest_withFullDiscountPromoCode_NewVehicle_VerifyMail()
			throws TranscoderException {
		// Test data setup
		user = testData.get_User_Testdata(true, Constants.NEW_VEHICLE, Constants.REGULAR_SPACE, 12, false,
				Constants.PROMOCODE);

		// Test steps
		tp_HomePage = launch_TextPay_Application_withLocation_QR_code();
		tp_HomePage.purchase_Session(user, Constants.CAMERAPAY);
		tp_HomePage.send_Receipt_to_Email(user.getEmail());

		// Verification
		tp_HomePage.verify_Purchase_Details(user, purchaseDetails);
		tp_HomePage.verify_LocationRevenuePage(purchaseDetails);
		emailPage.verify_PurchaseDetails_On_Email(purchaseDetails);
	}

	/*
	 * This is a test case to purchase star space session as Guest, with new vehicle
	 * and through card payment
	 *
	 * Author : Venu Thota(venu.thota@xebia.com)
	 */

	@Test(groups = { "smoke", "regression" })
	public void TC_05_Purchase_StarSpace_asGuest_WithCard_NewVehicle_VerifyMail() throws TranscoderException {

		// Test data setup
		user = testData.get_User_Testdata(true, Constants.NEW_VEHICLE, Constants.STAR_SPACE, 2, true, Constants.CARD);

		// Test steps
		tp_HomePage = launch_TextPay_Application_withLocation_QR_code();
		tp_HomePage.purchase_Session(user, Constants.CAMERAPAY);
		tp_HomePage.send_Receipt_to_Email(user.getEmail());

		// Verification
		tp_HomePage.verify_Purchase_Details(user, purchaseDetails);
		tp_HomePage.verify_LocationRevenuePage(purchaseDetails);
		emailPage.verify_PurchaseDetails_On_Email(purchaseDetails);
	}

	/*
	 * This is a test case to purchase Star space session with phone number,with
	 * unknown vehicle and through promocode
	 *
	 * Author : Venu Thota(venu.thota@xebia.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_06_Purchase_StarSpace_withPhoneNumber_FullDiscountPromoCode_UnknownVehicle_VerifyMail()
			throws TranscoderException {

		// Test data setup
		user = testData.get_User_Testdata(false, Constants.UNKNOWN_VEHICLE, Constants.STAR_SPACE, 2, false,
				Constants.PROMOCODE);

		// Test steps
		tp_HomePage = launch_TextPay_Application_withLocation_QR_code();
		tp_HomePage.purchase_Session(user, Constants.CAMERAPAY);
		tp_HomePage.send_Receipt_to_Email(user.getEmail());

		// Verification
		tp_HomePage.verify_Purchase_Details(user, purchaseDetails);
		tp_HomePage.verify_LocationRevenuePage(purchaseDetails);
		emailPage.verify_PurchaseDetails_On_Email(purchaseDetails);

	}

	/*
	 * This is a test case to purchase Star space session with phone number, with
	 * Unknown vehicle and through card payment
	 *
	 * Author : Venu Thota(venu.thota@xebia.com)
	 */

	@Test(groups = { "smoke", "regression" })
	public void TC_07_Purchase_StarSpace_asGuest_WithCard_UnknownVehicle_VerifyMail() throws TranscoderException {

		// Test data setup
		user = testData.get_User_Testdata(true, Constants.UNKNOWN_VEHICLE, Constants.STAR_SPACE, 5, true,
				Constants.CARD);

		// Test steps
		tp_HomePage = launch_TextPay_Application_withLocation_QR_code();
		tp_HomePage.purchase_Session(user, Constants.CAMERAPAY);
		tp_HomePage.send_Receipt_to_Email(user.getEmail());

		// Verification
		tp_HomePage.verify_Purchase_Details(user, purchaseDetails);
		tp_HomePage.verify_LocationRevenuePage(purchaseDetails);
		emailPage.verify_PurchaseDetails_On_Email(purchaseDetails);

	}

	/*
	 * This is a test case to purchase star space session with phone number,with new
	 * vehicle and through promocode
	 *
	 * Author : Venu Thota(venu.thota@xebia.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_08_Purchase_StarSpace_withPhoneNumber_FullDiscountPromoCode_NewVehicle_VerifyMail()
			throws TranscoderException {

		// Test data setup
		user = testData.get_User_Testdata(false, Constants.NEW_VEHICLE, Constants.STAR_SPACE, 1, false,
				Constants.PROMOCODE);

		// Test steps
		tp_HomePage = launch_TextPay_Application_withLocation_QR_code();
		tp_HomePage.purchase_Session(user, Constants.CAMERAPAY);
		tp_HomePage.send_Receipt_to_Email(user.getEmail());

		// Verification
		tp_HomePage.verify_Purchase_Details(user, purchaseDetails);
		tp_HomePage.verify_LocationRevenuePage(purchaseDetails);
		emailPage.verify_PurchaseDetails_On_Email(purchaseDetails);

	}
	/*
	 * This is a test case to purchase Charging space session as Guest, with new
	 * vehicle and through card payment
	 *
	 * Author : Venu Thota(venu.thota@xebia.com)
	 */

	@Test(groups = { "smoke", "regression" })
	public void TC_09_Purchase_ChargingSpace_asGuest_WithCard_NewVehicle_VerifyMail() throws TranscoderException {

		// Test data setup
		user = testData.get_User_Testdata(true, Constants.NEW_VEHICLE, Constants.CHARGING_SPACE, 5, true,
				Constants.CARD);

		// Test steps
		tp_HomePage = launch_TextPay_Application_withLocation_QR_code();
		tp_HomePage.purchase_Session(user, Constants.CAMERAPAY);
		tp_HomePage.send_Receipt_to_Email(user.getEmail());

		// Verification
		tp_HomePage.verify_Purchase_Details(user, purchaseDetails);
		tp_HomePage.verify_LocationRevenuePage(purchaseDetails);
		emailPage.verify_PurchaseDetails_On_Email(purchaseDetails);

	}

	/*
	 * This is a test case to purchase Charging space session with phone number,with
	 * unknown vehicle and through promocode
	 *
	 * Author : Venu Thota(venu.thota@xebia.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_10_Purchase_ChargingSpace_withPhoneNumber_FullDiscountPromoCode_UnknownVehicle_VerifyMail()
			throws TranscoderException {

		// Test data setup
		user = testData.get_User_Testdata(false, Constants.UNKNOWN_VEHICLE, Constants.CHARGING_SPACE, 5, false,
				Constants.PROMOCODE);

		// Test steps
		tp_HomePage = launch_TextPay_Application_withLocation_QR_code();
		tp_HomePage.purchase_Session(user, Constants.CAMERAPAY);
		tp_HomePage.send_Receipt_to_Email(user.getEmail());

		// Verification
		tp_HomePage.verify_Purchase_Details(user, purchaseDetails);
		tp_HomePage.verify_LocationRevenuePage(purchaseDetails);
		emailPage.verify_PurchaseDetails_On_Email(purchaseDetails);

	}

	/*
	 * This is a test case to purchase Charging space session as Guest, with Unknown
	 * vehicle and through card payment
	 *
	 * Author : Venu Thota(venu.thota@xebia.com)
	 */

	@Test(groups = { "smoke", "regression" })
	public void TC_11_Purchase_ChargingSpace_asGuest_WithCard_UnknownVehicle_VerifyMail() throws TranscoderException {

		// Test data setup
		user = testData.get_User_Testdata(true, Constants.UNKNOWN_VEHICLE, Constants.CHARGING_SPACE, 12, true,
				Constants.CARD);

		// Test steps
		tp_HomePage = launch_TextPay_Application_withLocation_QR_code();
		tp_HomePage.purchase_Session(user, Constants.CAMERAPAY);
		tp_HomePage.send_Receipt_to_Email(user.getEmail());

		// Verification
		tp_HomePage.verify_Purchase_Details(user, purchaseDetails);
		tp_HomePage.verify_LocationRevenuePage(purchaseDetails);
		emailPage.verify_PurchaseDetails_On_Email(purchaseDetails);

	}

	/*
	 * This is a test case to purchase Charging space session with phone number,with
	 * new vehicle and through promocode
	 *
	 * Author : Venu Thota(venu.thota@xebia.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_12_Purchase_ChargingSpace_withPhoneNumber_FullDiscountPromoCode_NewVehicle_VerifyMail()
			throws TranscoderException {

		// Test data setup
		user = testData.get_User_Testdata(false, Constants.NEW_VEHICLE, Constants.CHARGING_SPACE, 2, false,
				Constants.PROMOCODE);

		// Test steps
		tp_HomePage = launch_TextPay_Application_withLocation_QR_code();
		tp_HomePage.purchase_Session(user, Constants.CAMERAPAY);
		tp_HomePage.send_Receipt_to_Email(user.getEmail());

		// Verification
		tp_HomePage.verify_Purchase_Details(user, purchaseDetails);
		tp_HomePage.verify_LocationRevenuePage(purchaseDetails);
		emailPage.verify_PurchaseDetails_On_Email(purchaseDetails);

	}

}
