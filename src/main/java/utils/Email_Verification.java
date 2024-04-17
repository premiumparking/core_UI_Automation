package utils;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import com.mailosaur.MailosaurClient;
import com.mailosaur.MailosaurException;
import com.mailosaur.models.*;
import components.BaseClass;
import components.Constants;
import org.testng.Assert;
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
	public void verify_PurchaseDetails_On_Email(PurchaseDetails purchaseDetails) {
		if (Boolean.parseBoolean(verifymail)) {
			waitForPageLoad(4);
			if (Boolean.parseBoolean(yopmail)) {
				launch_yopmail();
				verify_Email_Content(purchaseDetails);
			} else
				try {
					verify_Mailosaur_Email_Content(purchaseDetails);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (MailosaurException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
				assertEquals(vehicle, "• Vehicle: " + purchaseDetails.getLicensePlate(), "Vehicle mismatch...");
			else
				assertEquals(vehicle, "• Vehicle: Alaska, " + purchaseDetails.getLicensePlate(), "Vehicle mismatch...");

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

	public void verify_Mailosaur_Email_Content(PurchaseDetails purchaseDetails) throws IOException, MailosaurException {
		stepInfo("<b> **** Verifying Email Content of " + purchaseDetails.getEmail() + "****</b>");

		MailosaurClient mailosaur = new MailosaurClient(mailosaur_apiKey);

		MessageSearchParams params = new MessageSearchParams();
		params.withServer(mailosaur_serverId);

		SearchCriteria criteria = new SearchCriteria();
		criteria.withSentTo(purchaseDetails.getEmail());

		Message message = mailosaur.messages().get(params, criteria);
		Assert.assertEquals(message.from().get(0).email(), "noreply@premiumparking.com", "From mail mismatch...");
		passStep("From Email :: " + message.from().get(0).email());
		Assert.assertEquals(message.from().get(0).name(), "Premium Parking", "From name mismatch...");
		passStep("From Email name :: " + message.from().get(0).name());

		Assert.assertNotNull(message);
		Assert.assertTrue(
				message.subject().contains("Premium Parking Receipt at P" + purchaseDetails.getLocationNumber()),
				"Subject mismatch");
		passStep("Subject is :: " + message.subject());

		Assert.assertTrue(
				message.html().body().contains("<strong>Location:</strong> P" + purchaseDetails.getLocationNumber()),
				"Location mismatch");

		passStep("Location : P" + purchaseDetails.getLocationNumber());

		Assert.assertTrue(
				message.html().body()
						.contains("<strong>Confirmation Number:</strong> " + purchaseDetails.getOrderNumber()),
				"Confirmation number mismatch");

		passStep("Confirmation number : " + purchaseDetails.getOrderNumber());

		Assert.assertTrue(
				message.html().body().contains("<strong>Amount:</strong> " + purchaseDetails.getAmountCharged()),
				"Amount mismatch");

		passStep("Amount : " + purchaseDetails.getAmountCharged());

		Assert.assertTrue(
				message.html().body()
						.contains("<strong>Duration:</strong> " + purchaseDetails.getDurationInWords().toLowerCase()),
				"Duration mismatch");

		passStep("Duration : " + purchaseDetails.getDurationInWords());

		Assert.assertTrue(message.html().body().contains("<strong>Start:</strong> "), "Starts mismatch");

		if (purchaseDetails.isUnKnownVehicle()) {
			Assert.assertTrue(
					message.html().body().contains("<strong>Vehicle:</strong> " + purchaseDetails.getLicensePlate()),
					"Vehicle mismatch...");
			passStep("Vehicle: " + purchaseDetails.getLicensePlate());
		} else {
			Assert.assertTrue(
					message.html().body()
							.contains("<strong>Vehicle:</strong> Alaska, " + purchaseDetails.getLicensePlate()),
					"Vehicle mismatch...");
			passStep("Vehicle: Alaska, " + purchaseDetails.getLicensePlate());
		}
		if (purchaseDetails.getChannel().equalsIgnoreCase("TextPay"))
			purchaseDetails.setChannel("Textpay");
		if (purchaseDetails.getChannel().equalsIgnoreCase("Camerapay"))
			purchaseDetails.setChannel("Camerapay");
		Assert.assertTrue(message.html().body().contains("<strong>Source:</strong> " + purchaseDetails.getChannel()),
				"Source mismatch");

		passStep("Source : " + purchaseDetails.getChannel());

		if (purchaseDetails.getPaymentOption().equalsIgnoreCase(Constants.PROMOCODE)) {
			Assert.assertTrue(message.html().body().contains("<strong>Payment Method:</strong> Wallet"),
					"Payment Method mismatch");
			passStep("Payment Method: Wallet");

		} else {
			Assert.assertTrue(message.html().body().contains("<strong>Payment Method:</strong> Visa 4242"),
					"Payment Method mismatch");
			passStep("Payment Method: Visa 4242");

		}

	}

}
