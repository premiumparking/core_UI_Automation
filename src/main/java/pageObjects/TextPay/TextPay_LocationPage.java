package pageObjects.TextPay;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import components.BaseClass;
import dataModel.SPA.Vehicle;

/*
 * Class which contains the web elements and performs Spa Location page activities (methods)
 *
 * Extends : BaseClass
 *
 * Author : Venu Thota(venu.t@comakeit.com)
 */
public class TextPay_LocationPage extends BaseClass {

	// ****************** WEB ELEMENTS ****************************//
	By textbox_Search_Location = By.id("address-search");

	By textbox_SearchLocation = By.id("address-search");
	By button_Search = By.xpath("//button[@data-testid='destination-search-button']");
	By button_Sessions = By.xpath("//button[normalize-space()='Pay to Park Now']");
	By button_ViewRate = By.xpath("//button[normalize-space()='View rate']");
	By button_ParkHere = By.xpath("//button[normalize-space()='Park here']");
	By label_Total = By.xpath("//strong[normalize-space()='Total']");
	By textbox_LicensePlateNumber = By.id("license_plate-for-1");
	By dropdown_state = By.id("state-for-1");
	By select_AnotherCard = By.xpath("//button[normalize-space()='another card']");
	By textbox_CardNumber = By.name("cardnumber");
	By textbox_ExpDate = By.name("exp-date");
	By textbox_CVC = By.name("cvc");
	By textbox_ZipCode = By.id("zip");
	By button_Pay = By.xpath("//button[@type='submit' and contains(text(),'Pay')]");
	By iframe_cardNumber = By.xpath("//iframe[@title='Secure card number input frame']");
	By iframe_expDate = By.xpath("//iframe[@title='Secure expiration date input frame']");
	By iframe_CVC = By.xpath("//iframe[@title='Secure CVC input frame']");
	By total_amount = By.xpath("//strong[@data-cy='parking-total-amount']");

	By label_confirmationTitle = By.xpath("//h2[@data-cy='confirmation-title']");
	By label_PurchaseDetails = By.xpath("//h3[normalize-space()='Purchase Details']");
	By label_purchaseType = By.xpath("//header[@data-cy='purchase-details-header']");
	By label_rateName = By.xpath("//h3[@data-cy='rate-name']");
	By label_lecencePlateName = By.xpath("//span[@data-cy='vehicle-license-plate-number']");
	By label_location = By.xpath("//li[@data-testid='test-location_number']");
	By label_startTime = By.xpath("//li[@data-testid='test-start_time']");
	By label_endTime = By.xpath("//li[@data-testid='test-end_time']");
	By label_amountCharged = By.xpath("//div[@data-cy='purchase-details-total']/h4[2]");

	// ****************** ACTIONS ****************************//
	/*
	 * Method to purchase a new session
	 *
	 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
	 */
	public void purchase_Session(Vehicle vehicle, Boolean isNewVehicle, Boolean isNewCard) {
		waitForElementTobeDisplayed(button_Sessions);
		clickOnButton(button_Sessions, "Pay to Park Now");
		clickOnButton(button_ViewRate, "View Rate");
		clickOnButton(button_ParkHere, "Park Here");
		waitForElementTobeDisplayed(label_Total);
		if (isNewVehicle) {
			enterText(textbox_LicensePlateNumber, vehicle.getLicensePlateNumber(), "License Plate Number Textbox");
			selectFromSearch(dropdown_state, vehicle.getState(), "License Plate State dropdown");
		} else {
			selectFromSearch(textbox_LicensePlateNumber, vehicle.getLicensePlateNumber(),
					"License Plate Number Textbox");
		}
		if (isNewCard) {
			try {
				if (isElementDisplayed(select_AnotherCard))
					clickOnButton(select_AnotherCard, "Pay with another card");
			} catch (Exception ex) {

			}

			switchToIframe(iframe_cardNumber);
			enterText(textbox_CardNumber, vehicle.getCcNumber(), "Card Number Textbox");
			BaseClass.driver.switchTo().defaultContent();
			switchToIframe(iframe_expDate);
			enterText(textbox_ExpDate, vehicle.getExpiry(), "Expiry Date Textbox");
			BaseClass.driver.switchTo().defaultContent();
			switchToIframe(iframe_CVC);
			enterText(textbox_CVC, vehicle.getCvc(), "CC_CVC code Textbox");
			BaseClass.driver.switchTo().defaultContent();
			enterText(textbox_ZipCode, vehicle.getZip(), "Zip Code Textbox");
		}
		vehicle.setAmount(getElementText(total_amount));
		clickOnButton(button_Pay, "Pay Button");
	}

	public void verify_Purchase_Details(Vehicle vehicle, boolean newSession) {
		waitForElementTobeDisplayed(label_confirmationTitle);
		if (isElementDisplayed(label_confirmationTitle)) {
			passStep("Displayed : " + getElementText(label_confirmationTitle));
			assertEquals(getElementText(label_PurchaseDetails), "Purchase Details");
			passStep("Displayed : Purchase Details");
			if (newSession) {
				assertEquals(getElementText(label_purchaseType), "NEW SESSION");
				passStep("Session Type :" + getElementText(label_purchaseType));
			}
			assertEquals(getElementText(label_rateName), "24 Hours");
			passStep("Rate name :" + getElementText(label_rateName));
			assertEquals(getElementText(label_lecencePlateName), vehicle.getLicensePlateNumber());
			passStep("Licence Plate :" + getElementText(label_lecencePlateName));
			assertEquals(getElementText(label_location), "Location Number:"+vehicle.getLocationNumber());
			passStep("Location name :" + getElementText(label_location));
			passStep("Session Start time :" + getElementText(label_startTime));
			passStep("Session End time :" + getElementText(label_endTime));
			assertEquals(getElementText(label_amountCharged), vehicle.getAmount());
			passStep("Amount Charged :" + getElementText(label_amountCharged));

		}
	}
}
