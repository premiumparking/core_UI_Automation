package testcases.TextPay;

import components.BaseClass;
import dataModel.TextPay.Guest;

import org.testng.annotations.Test;

import pageObjects.TextPay.TextPay_HomePage;
import utils.XML_Operations;

public class TextPay_Sessions_Testcases extends BaseClass {
	// ****************** CLASS INSTANCES ****************************//
	XML_Operations xml_Ops = new XML_Operations();
	TextPay_HomePage tp_HomePage = new TextPay_HomePage();

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
	public void TC_01_Purchase_Session_With_NewCard() {

		Guest guest = (Guest) xml_Ops.getTestData("guest");
		guest.setLicensePlateNumber(getRandomLicencePlate());
		guest.setTimeInHours("2");
		guest.setParkingType("Regular Space");
		guest.setPaymentVia("card");
		tp_HomePage = launch_TextPay_Application();
		tp_HomePage.purchase_Session_AsGuest(guest);
		tp_HomePage.verify_Purchase_Details(guest);
		// waitForPageLoad(10);

	}


}
