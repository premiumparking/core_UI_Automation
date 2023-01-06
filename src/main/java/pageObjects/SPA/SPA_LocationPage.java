package pageObjects.SPA;

import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import components.BaseClass;
import dataModel.SPA.Vehicle;

/*
 * Class which contains the web elements and performs Spa Location page activities (methods)
 *
 * Extends : BaseClass
 *
 * Author : Venu Thota(venu.t@comakeit.com)
 */
public class SPA_LocationPage extends BaseClass {

	// ****************** WEB ELEMENTS ****************************//
	By textbox_Search_Location = By.id("address-search");
	By button_Search = By.xpath("//button[@data-testid='destination-search-button']");
	By button_Sessions = By.xpath("//button[normalize-space()='Pay to Park Now']");
	By button_Reservations = By.xpath("//a[normalize-space()='Reserve Parking in Advance']");
	By button_ViewRate = By.xpath("//button[normalize-space()='View rate']");
	By button_ParkHere = By.xpath("//button[normalize-space()='Park here']");
	By label_Total = By.xpath("//strong[normalize-space()='Total']");
	By textbox_LicensePlateNumber = By.id("license_plate-for-1");
	By dropdown_state = By.id("state-for-1");
	// By existing_card = By.xpath("//div[contains(text(),'Visa * * * * 4242')]");
	By existing_card = By.xpath("//div[@data-testid='test-cards-select']//div[contains(@class,'singleValue')]");
	By select_promocode = By.xpath("//button[normalize-space()='Have a promotion code?']");
	By textbox_promocode = By.id("checkout-promocode");
	By button_addPromocode = By.xpath("//button[@data-testid='add-promo-code-button']");
	By select_AnotherCard = By.xpath("//button[normalize-space()='another card']");
	By button_Start_Parking = By.xpath("//button[@type='submit' and contains(text(),'Start Parking')]");
	By textbox_CardNumber = By.name("cardnumber");
	By textbox_ExpDate = By.name("exp-date");
	By textbox_CVC = By.name("cvc");
	By textbox_ZipCode = By.id("zip");
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
	By button_Pay = By.xpath("//button[@data-testid='pay-now-button']");
	By label_Promo_Discount = By.xpath("//p[@data-cy='have-a-promo-code']");

	public By duration_Bar = By.xpath("//input[@id='custom-duration']");

	// Extend elements
	By logo_Location = By.xpath("//a[@data-cy='test-location-nav-bar-title']");
	By label_Extend_Message = By.xpath("//header[@data-testid='test-summary-header']");

	// ****************** ACTIONS ****************************//

	/*
	 * Method to purchase a Session
	 *
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public void purchase_Session(Vehicle vehicle) {
		stepInfo(" <b> ****Purchasing Session ****</b>");
		waitForElementTobeDisplayed(button_Sessions);
		clickOnButton(button_Sessions, "Pay to Park Now");
		clickOnButton(button_ViewRate, "View Rate");
		clickOnButton(button_ParkHere, "Park Here");
		waitForElementTobeDisplayed(label_Total);

		// Vehicle check
		if (vehicle.getIsItNewVehicle()) {
			enterText(textbox_LicensePlateNumber, vehicle.getLicensePlateNumber(), "License Plate Number Textbox");
			selectFromSearch(dropdown_state, vehicle.getState(), "existing License Plate State dropdown");
		} else {
			selectFromSearch(textbox_LicensePlateNumber, vehicle.getLicensePlateNumber(),
					"License Plate Number Textbox");
		}

		// Payment check ## Card
		if (vehicle.getPayOption().equalsIgnoreCase("card")) {
			if (vehicle.getIsItNewCard()) {
				try {
					if (isElementDisplayed(select_AnotherCard))
						clickOnButton(select_AnotherCard, "Pay with another card");
				} catch (Exception ex) {
				}
				addNewCard(vehicle);
			} else {
				try {
					if (isElementDisplayed(existing_card))
						passStep("Existing card :" + getElementText(existing_card));
				} catch (Exception ex) {
					failStep("Account doesn't have the saved cards. Please check !!!");
				}
			}
		}
		// Payment check ## Card
		else if (vehicle.getPayOption().equalsIgnoreCase("promocode")) {
			addPromoCode(vehicle.getPromoCode());
			waitForElementTobeDisplayed(label_Promo_Discount);
			passStep(getElementText(label_Promo_Discount));
		}

		vehicle.setAmount(getElementText(total_amount));

		isElementDisplayed(button_Pay);
		clickOnButton(button_Pay, getElementText(button_Pay));
		waitForPageLoad(3);

	}

	/*
	 * Method to extend Session
	 *
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public void extend_Session(Vehicle vehicle) {
		stepInfo(" <b> ****Extending Session ****</b>");
		waitForElementTobeDisplayed(logo_Location);
		clickOnButton(logo_Location);

		waitForElementTobeDisplayed(button_Sessions);
		clickOnButton(button_Sessions, "Pay to Park Now");
		clickOnButton(button_ViewRate, "View Rate");
		clickOnButton(button_ParkHere, "Park Here");
		waitForElementTobeDisplayed(label_Total);
		// Choosing existing Vehicle.
		selectFromSearch(textbox_LicensePlateNumber, vehicle.getLicensePlateNumber(), "License Plate Number Textbox");
		waitForPageLoad(3);
		waitForElementTobeDisplayed(label_Extend_Message);
		assertEquals(getElementText(label_Extend_Message).toUpperCase(),
				"EXTEND EXISTING SESSION AT LOT # " + vehicle.getLocationNumber() + "");
		passStep(getElementText(label_Extend_Message));
		// Payment check ## Card
		if (vehicle.getPayOption().equalsIgnoreCase("card")) {
			if (vehicle.getIsItNewCard()) {
				try {
					if (isElementDisplayed(select_AnotherCard))
						clickOnButton(select_AnotherCard, "Pay with another card");
				} catch (Exception ex) {
				}
				addNewCard(vehicle);
			} else {
				try {
					if (isElementDisplayed(existing_card))
						passStep("Existing card :" + getElementText(existing_card));
				} catch (Exception ex) {
					failStep("Account doesn't have the saved cards. Please check !!!");
				}
			}
		}
		// Payment check ## Card
		else if (vehicle.getPayOption().equalsIgnoreCase("promocode")) {
			addPromoCode(vehicle.getPromoCode());
			waitForElementTobeDisplayed(label_Promo_Discount);
			passStep(getElementText(label_Promo_Discount));
		}

		vehicle.setAmount(getElementText(total_amount));

		isElementDisplayed(button_Pay);
		clickOnButton(button_Pay, getElementText(button_Pay));
	}

	/*
	 * Method to add Promocode
	 *
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public void addPromoCode(String promocode) {
		isElementDisplayed(select_promocode);
		clickOnButton(select_promocode, "Add Promocode");
		enterText(textbox_promocode, promocode, "Promo Code Textbox");
		waitForElementTobeDisplayed(button_addPromocode);
		clickOnButton(button_addPromocode, "Add Promo Code Button");
	}

	/*
	 * Method to add New Card
	 *
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public void addNewCard(Vehicle vehicle) {
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

	public void purchase_Reservation(Vehicle vehicle, Boolean isNewVehicle, Boolean isNewCard, Boolean isPromoCode,
			Boolean isPayButton) {
		waitForElementTobeDisplayed(button_Reservations);
		clickOnButton(button_Reservations, "Reserve Parking in Advance");
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
		} else {
			isElementDisplayed(existing_card);
		}
		if (isPromoCode) {
			isElementDisplayed(select_promocode);
			clickOnButton(select_promocode, "Add Promocode");
			enterText(textbox_promocode, vehicle.getPromoCode(), "Promo Code Textbox");
			waitForElementTobeDisplayed(button_addPromocode);
			clickOnButton(button_addPromocode, "Add Promo Code Button");
		}
		vehicle.setAmount(getElementText(total_amount));
		if (isPayButton) {
			isElementDisplayed(button_Pay);
			clickOnButton(button_Pay, "Pay Button");
		} else {
			waitForElementTobeDisplayed(button_Start_Parking);
			isElementDisplayed(button_Start_Parking);
			clickOnButton(button_Start_Parking, "Start Parking Button");
		}
	}

	public void verify_Purchase_Details(Vehicle vehicle) {
		waitForElementTobeDisplayed(label_confirmationTitle);
		if (isElementDisplayed(label_confirmationTitle)) {
			passStep("Confirmation message is : " + getElementText(label_confirmationTitle));
			assertEquals(getElementText(label_PurchaseDetails), "Purchase Details");
			stepInfo("<b> **** " + getElementText(label_PurchaseDetails) + "**** </b> ");
			if (vehicle.getIsItNewSession()) {
				assertEquals(getElementText(label_purchaseType), "NEW SESSION");
				passStep("Session Type :" + getElementText(label_purchaseType));
				// assertEquals(getElementText(label_rateName), "24 Hrs");
			}
			if (vehicle.getIsItNewnewReservation()) {
				assertEquals(getElementText(label_purchaseType), "NEW RESERVATION");
				passStep("Reservation Type :" + getElementText(label_purchaseType));
				assertEquals(getElementText(label_rateName), "24 Hrs");
			}
			passStep("Rate name :" + getElementText(label_rateName));
			assertEquals(getElementText(label_lecencePlateName), vehicle.getLicensePlateNumber());
			passStep("Licence Plate :" + getElementText(label_lecencePlateName));
			assertEquals(getElementText(label_location), "Location Number:" + vehicle.getLocationNumber());
			passStep(getElementText(label_location));
			passStep(getElementText(label_startTime));
			passStep(getElementText(label_endTime));
			assertEquals(getElementText(label_amountCharged), vehicle.getAmount());
			passStep("Amount Charged :" + getElementText(label_amountCharged));
			if (vehicle.getPayOption().equalsIgnoreCase("promocode")) {
				assertEquals(vehicle.getAmount(), "$0.00");
			}
		}
	}
}
