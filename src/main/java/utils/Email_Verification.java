package utils;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;

import components.BaseClass;
import components.Constants;
import dataModel.TextPay.PurchaseDetails;

/*
 * Class is to handle the test data manipulations
 * 
 * 
 * Author : Venu Thota(venu.thota@xebia.com)
 */
public class Email_Verification extends BaseClass {

	// ****************** WEB ELEMENTS ****************************//

	public By textBox_Email = By.xpath("//input[@id='login']");

	By button_Arrow = By.xpath("//i[@class='material-icons-outlined f36']");

	By iframe_inbox = By.xpath("//iframe[@id='ifinbox']");
	By iframe_mailBody = By.xpath("//iframe[@id='ifmail']");
	By mailItem_Subject = By.className("lms");

	By locationNumner = By.xpath("");
	By checkbox_Recaptha = By.xpath("//div[@class='recaptcha-checkbox-checkmark']");

	/*
	 * This method is verify email content return the Operator object
	 * 
	 * Author : Venu Thota(venu.thota@xebia.com)
	 */
	public void verify_Email_PurchaseDetails(PurchaseDetails purchaseDetails) {
		if (Boolean.parseBoolean(headless)) {
			launch_yopmail();
			verify_Email_Content(purchaseDetails);
		}
	}

	/*
	 * This method is verify email content return the Operator object
	 * 
	 * Author : Venu Thota(venu.thota@xebia.com)
	 */
	public void verify_Email_Content(PurchaseDetails purchaseDetails) {

		waitForElementTobeDisplayed(textBox_Email);
		enterText(textBox_Email, purchaseDetails.getEmail());
		clickOnButton(button_Arrow);

		if (isElementDisplayed(checkbox_Recaptha))
			clickOnButton(checkbox_Recaptha);
		waitForPageLoad(3);
		switchToIframe(iframe_inbox);
		waitForElementTobeDisplayed(mailItem_Subject);
		if (isElementDisplayed(mailItem_Subject)) {
			passStep("Mail received with the subject :: " + getElementText(mailItem_Subject));
			clickOnButton(mailItem_Subject, getElementText(mailItem_Subject));
			comeOutFromFrame();
			switchToIframe(iframe_mailBody);

			stepInfo("<b> **** Verifying Email Body of " + purchaseDetails.getEmail() + "****</b>");

			String location = getElementText(getRowElement("Location"));
			passStep(location);
			highlightElement((getRowElement("Location")));

			String address = getElementText(getRowElement("Address"));
			passStep(address);
			highlightElement((getRowElement("Address")));

			String order_Number = getElementText(getRowElement("Confirmation Number"));
			passStep(order_Number);
			highlightElement((getRowElement("Confirmation Number")));

			String amount = getElementText(getRowElement("Amount"));
			passStep(amount);
			highlightElement((getRowElement("Amount")));

			String duration = getElementText(getRowElement("Duration"));
			passStep(duration);
			highlightElement((getRowElement("Duration")));

			String start = getElementText(getRowElement("Start"));
			passStep(start);
			highlightElement((getRowElement("Start")));

			String end = getElementText(getRowElement("End"));
			passStep(end);
			highlightElement((getRowElement("End")));

			String vehicle = getElementText(getRowElement("Vehicle"));
			passStep(vehicle);
			highlightElement((getRowElement("Vehicle")));

			String source = getElementText(getRowElement("Source"));
			passStep(source);
			highlightElement((getRowElement("Source")));

			String paymentMethod = getElementText(getRowElement("Payment Method"));
			passStep(paymentMethod);
			highlightElement((getRowElement("Payment Method")));

			assertEquals(location, "• Location: P" + purchaseDetails.getLocationNumber(), "Location name mismatch...");
			assertEquals(order_Number, "• Confirmation Number: " + purchaseDetails.getOrderNumber(),
					"Order number mismatch...");
			assertEquals(amount, "• Amount: " + purchaseDetails.getAmountCharged(), "Amount mismatch...");
			assertEquals(duration, "• Duration: " + purchaseDetails.getDurationInWords().toLowerCase(),
					"Duration mismatch...");

			if (purchaseDetails.isUnKnownVehicle())
				assertEquals(vehicle, "• Vehicle: " + purchaseDetails.getLicencePlate(), "Vehicle mismatch...");
			else
				assertEquals(vehicle, "• Vehicle: Alaska, " + purchaseDetails.getLicencePlate(), "Vehicle mismatch...");

			assertEquals(source.toLowerCase(), "• source: " + purchaseDetails.getChannel().toLowerCase(),
					"Source mismatch...");

			if (purchaseDetails.getPaymentOption().equalsIgnoreCase(Constants.PROMOCODE)) {
				assertEquals(paymentMethod, "• Payment Method: Wallet", "Payment method mismatch...");

			} else {
				assertEquals(paymentMethod, "• Payment Method: Visa 4242", "Payment method mismatch...");

			}

		}
		comeOutFromFrame();

	}

	public By getRowElement(String name) {
		return By.xpath("//strong[normalize-space()='" + name + ":']/parent::td");
	}
}
