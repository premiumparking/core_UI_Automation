package testcases.TextPay;

import org.testng.annotations.Test;
import components.BaseClass;
import components.Constants;
import dataModel.TextPay.Guest;
import dataModel.TextPay.PurchaseDetails;

import org.testng.annotations.Test;

import pageObjects.TextPay.TextPay_HomePage;
import utils.XML_Operations;

public class TextPay_Sessions_With_Hotel extends BaseClass {
	// ****************** CLASS INSTANCES ****************************//
	XML_Operations xml_Ops = new XML_Operations();
	TextPay_HomePage tp_HomePage = new TextPay_HomePage();
	PurchaseDetails purchaseDetails = new PurchaseDetails();

	// ****************** TEST DATA ****************************//
	Guest textPayUser = (Guest) xml_Ops.getTestData("guest");

	// ****************** TEST SCRIPTS ****************************//

	/*
	 * This is a test case to purchase regular space session as a guest with new
	 * vehicle and through card payment
	 *
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */

	@Test(groups = { "smoke", "regression" })
	public void TC_01_Purchase_Regular_Space_with_Hotel() {
		
		//getMonthName();

		tp_HomePage = launch_TextPay_Application();
		textPayUser = tp_HomePage.prepare_testData(textPayUser);
		tp_HomePage.purchase_Session_With_Hotel_AsRegisterdUser(textPayUser);
		
		
		tp_HomePage.verify_Purchase_Details_Hotel(textPayUser, purchaseDetails);

		// Set the purchase details for location revenue page verification
		purchaseDetails.setPaymentOption(Constants.CARD);
		purchaseDetails.setPaymentMethod(Constants.VISA_CARD_TYPE);
		// tp_HomePage.verify_LocationRevenuePage(purchaseDetails);

	}

}
