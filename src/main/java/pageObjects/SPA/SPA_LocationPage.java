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
	By button_Sessions = By.xpath("//button[@data-testid='test-pay-to-park-now']");
	By button_Reservations = By.xpath("//a[@data-testid='test-reserve-parking-in-advance']");
	By button_ViewRate = By.xpath("//button[normalize-space()='View rate']");
	By button_ParkHere = By.xpath("//button[normalize-space()='Park here']");
	By label_Total = By.xpath("//p[@data-testid='test-total']//strong[1]");
	By textbox_LicensePlateNumber = By.id("license_plate-for-1");
	By dropdown_state = By.id("state-for-1");
	By existing_card = By.xpath("//div[@data-testid='test-cards-select']//div[contains(@class,'singleValue')]");
	By select_promocode = By.xpath("//button[@data-testid='apply-promo-code-link']");
	By textbox_promocode = By.id("checkout-promocode");
	By button_addPromocode = By.xpath("//button[@data-testid='add-promo-code-button']");
	By select_AnotherCard = By.xpath("//button[@data-testid='test-another-card']");
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
	By calendar_Start_Date = By.xpath("//input[@data-cy='start-date-input']");
	By select_Next_Month = By.xpath("//span[contains(normalize-space(),'Next Month')]");
	By select_Calendar_Date = By.xpath("//div[normalize-space()='9']");
	public By duration_Bar = By.xpath("//input[@id='custom-duration']");
	By button_StarSpace = By.xpath("//a[@data-testid='test-pay-to-park-now-star-space']");
	By button_ChargingSpace = By.xpath("//a[@data-testid='test-pay-to-park-now-charging-space']");
	By choose_Star_Space_Duration = By.xpath("//div[@data-testid='test-star-session-form']//a[1]");
	By choose_Charging_Space_Duration = By.xpath("//div[@data-testid='test-charging-session-form']//a[1]");
	By label_Star_Rate = By.xpath("//div//h2[normalize-space()='Star']");
	By button_Choose_Star_Rate = By.xpath("//div//h2[normalize-space()='Star']/following-sibling::a[@data-cy='test-rate-link'][1]");

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
		// Payment check ## Promo Code
		else if (vehicle.getPayOption().equalsIgnoreCase("promocode")) {
			addPromoCode(vehicle.getPromoCode());
			waitForElementTobeDisplayed(label_Promo_Discount);
			passStep(getElementText(label_Promo_Discount));
		}
		else if (vehicle.getPayOption().equalsIgnoreCase("fixedPromoCode")) {
			addPromoCode(vehicle.getFixedPromoCode());
			waitForElementTobeDisplayed(label_Promo_Discount);
			passStep(getElementText(label_Promo_Discount));
		}
		waitForPageLoad(3);
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
		// Payment check ## Promo Code
		else if (vehicle.getPayOption().equalsIgnoreCase("promocode")) {
			addPromoCode(vehicle.getPromoCode());
			waitForElementTobeDisplayed(label_Promo_Discount);
			passStep(getElementText(label_Promo_Discount));
		}
		else if (vehicle.getPayOption().equalsIgnoreCase("fixedPromoCode")) {
			addPromoCode(vehicle.getFixedPromoCode());
			waitForElementTobeDisplayed(label_Promo_Discount);
			passStep(getElementText(label_Promo_Discount));
		}
		waitForPageLoad(3);
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
		waitForElementTobeDisplayed(select_promocode);
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
		waitForElementTobeDisplayed(iframe_cardNumber);
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

	/*
	 * Method to purchase reservation
	 *
	 * Author : Author : Pavan Prasad(pavanprasad.v@comakeit.com)
	 */
	public void purchase_Reservation(Vehicle vehicle) {
		stepInfo(" <b> ****Purchasing Reservation ****</b>");
		waitForElementTobeDisplayed(button_Reservations);
		clickOnButton(button_Reservations, "Reserve Parking in Advance");
		waitForPageLoad(3);
		if (vehicle.getIsItFutureReservation()) {
			clickOnButton(calendar_Start_Date, "Calendar Start Date");
			clickOnButton(select_Next_Month, "Calendar Next Month Icon");
			clickOnButton(select_Calendar_Date, "Calendar Next Month Date");
		}
		clickOnButton(button_ViewRate, "View Rate");
		clickOnButton(button_ParkHere, "Park Here");
		waitForElementTobeDisplayed(label_Total);

		// Vehicle check
		if (vehicle.getIsItNewVehicle()) {
			enterText(textbox_LicensePlateNumber, vehicle.getLicensePlateNumber(), "License Plate Number Textbox");
			selectFromSearch(dropdown_state, vehicle.getState(), "Existing License Plate State dropdown");
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
		// Payment check ## Promo Code
		else if (vehicle.getPayOption().equalsIgnoreCase("promocode")) {
			addPromoCode(vehicle.getPromoCode());
			waitForElementTobeDisplayed(label_Promo_Discount);
			passStep(getElementText(label_Promo_Discount));
		}
		else if (vehicle.getPayOption().equalsIgnoreCase("fixedPromoCode")) {
			addPromoCode(vehicle.getFixedPromoCode());
			waitForElementTobeDisplayed(label_Promo_Discount);
			passStep(getElementText(label_Promo_Discount));
		}
		waitForPageLoad(3);
		vehicle.setAmount(getElementText(total_amount));
		isElementDisplayed(button_Pay);
		clickOnButton(button_Pay, getElementText(button_Pay));
		waitForPageLoad(3);
	}

	/*
	 * Method to purchase Star Space
	 *
	 * Author : Author : Pavan Prasad(pavanprasad.v@comakeit.com)
	 */
	public void purchase_StarSpace(Vehicle vehicle) {
		stepInfo(" <b> ****Purchasing Star Space ****</b>");
		waitForElementTobeDisplayed(button_StarSpace);
		clickOnButton(button_StarSpace, "Pay to Park Now(Star Space)");
		clickOnButton(choose_Star_Space_Duration, "Choose Star Space Duration");

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
		// Payment check ## Promo Code
		else if (vehicle.getPayOption().equalsIgnoreCase("promocode")) {
			addPromoCode(vehicle.getPromoCode());
			waitForElementTobeDisplayed(label_Promo_Discount);
			passStep(getElementText(label_Promo_Discount));
		}
		else if (vehicle.getPayOption().equalsIgnoreCase("fixedPromoCode")) {
			addPromoCode(vehicle.getFixedPromoCode());
			waitForElementTobeDisplayed(label_Promo_Discount);
			passStep(getElementText(label_Promo_Discount));
		}
		waitForPageLoad(3);
		vehicle.setAmount(getElementText(total_amount));
		isElementDisplayed(button_Pay);
		clickOnButton(button_Pay, getElementText(button_Pay));
		waitForPageLoad(3);

	}

	/*
	 * Method to extend Star Space
	 *
	 * Author : Author : Pavan Prasad(pavanprasad.v@comakeit.com)
	 */
	public void extend_Star_Space(Vehicle vehicle) {
		stepInfo(" <b> ****Extending Star Space ****</b>");
		waitForElementTobeDisplayed(logo_Location);
		clickOnButton(logo_Location);

		waitForElementTobeDisplayed(button_StarSpace);
		clickOnButton(button_StarSpace, "Pay to Park Now(Star Space)");
		clickOnButton(choose_Star_Space_Duration, "Choose Star Space Duration");
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
		// Payment check ## Promo Code
		else if (vehicle.getPayOption().equalsIgnoreCase("promocode")) {
			addPromoCode(vehicle.getPromoCode());
			waitForElementTobeDisplayed(label_Promo_Discount);
			passStep(getElementText(label_Promo_Discount));
		}
		else if (vehicle.getPayOption().equalsIgnoreCase("fixedPromoCode")) {
			addPromoCode(vehicle.getFixedPromoCode());
			waitForElementTobeDisplayed(label_Promo_Discount);
			passStep(getElementText(label_Promo_Discount));
		}
		waitForPageLoad(3);
		vehicle.setAmount(getElementText(total_amount));
		isElementDisplayed(button_Pay);
		clickOnButton(button_Pay, getElementText(button_Pay));
	}

	/*
	 * Method to purchase Charging Space
	 *
	 * Author : Author : Pavan Prasad(pavanprasad.v@comakeit.com)
	 */
	public void purchase_ChargingSpace(Vehicle vehicle) {
		stepInfo(" <b> ****Purchasing Charging Space ****</b>");
		waitForElementTobeDisplayed(button_ChargingSpace);
		clickOnButton(button_ChargingSpace, "Pay to Park Now(Charging Space)");
		clickOnButton(choose_Charging_Space_Duration, "Choose Charging Space Duration");

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
		// Payment check ## Promo Code
		else if (vehicle.getPayOption().equalsIgnoreCase("promocode")) {
			addPromoCode(vehicle.getPromoCode());
			waitForElementTobeDisplayed(label_Promo_Discount);
			passStep(getElementText(label_Promo_Discount));
		}
		else if (vehicle.getPayOption().equalsIgnoreCase("fixedPromoCode")) {
			addPromoCode(vehicle.getFixedPromoCode());
			waitForElementTobeDisplayed(label_Promo_Discount);
			passStep(getElementText(label_Promo_Discount));
		}
		waitForPageLoad(3);
		vehicle.setAmount(getElementText(total_amount));
		isElementDisplayed(button_Pay);
		clickOnButton(button_Pay, getElementText(button_Pay));
		waitForPageLoad(3);

	}

	/*
	 * Method to extend Charging Space
	 *
	 * Author : Author : Pavan Prasad(pavanprasad.v@comakeit.com)
	 */
	public void extend_Charging_Space(Vehicle vehicle) {
		stepInfo(" <b> ****Extending Charging Space ****</b>");
		waitForElementTobeDisplayed(logo_Location);
		clickOnButton(logo_Location);

		waitForElementTobeDisplayed(button_ChargingSpace);
		clickOnButton(button_ChargingSpace, "Pay to Park Now(Charging Space)");
		clickOnButton(choose_Charging_Space_Duration, "Choose Charging Space Duration");
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
		// Payment check ## Promo Code
		else if (vehicle.getPayOption().equalsIgnoreCase("promocode")) {
			addPromoCode(vehicle.getPromoCode());
			waitForElementTobeDisplayed(label_Promo_Discount);
			passStep(getElementText(label_Promo_Discount));
		}
		else if (vehicle.getPayOption().equalsIgnoreCase("fixedPromoCode")) {
			addPromoCode(vehicle.getFixedPromoCode());
			waitForElementTobeDisplayed(label_Promo_Discount);
			passStep(getElementText(label_Promo_Discount));
		}
		waitForPageLoad(3);
		vehicle.setAmount(getElementText(total_amount));
		isElementDisplayed(button_Pay);
		clickOnButton(button_Pay, getElementText(button_Pay));
	}

	public void verify_Purchase_Details(Vehicle vehicle) {
		stepInfo(" <b> ****Verifying Purchase Details ****</b>");
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
			if (vehicle.getIsItNewReservation()) {
				assertEquals(getElementText(label_purchaseType), "NEW RESERVATION");
				passStep("Reservation Type :" + getElementText(label_purchaseType));
				// assertEquals(getElementText(label_rateName), "24 Hrs");
			}
			passStep("Rate name :" + getElementText(label_rateName));
			assertEquals(getElementText(label_lecencePlateName), vehicle.getLicensePlateNumber());
			passStep("Licence Plate :" + getElementText(label_lecencePlateName));
			String locName = Integer.parseInt(vehicle.getLocationNumber().split("P")[1]) + "";
			assertEquals(getElementText(label_location), "Location Number:P" + locName);
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

	/*
	 * Method to purchase Star Space by Star Rate
	 *
	 * Author : Author : Pavan Prasad (pavanprasad.v@comakeit.com)
	 */
	public void purchase_StarSpace_By_Rate(Vehicle vehicle) {
		stepInfo(" <b> ****Purchasing Star Space By Rate ****</b>");
		waitForElementTobeDisplayed(label_Star_Rate);
		try {
			if (isElementDisplayed(label_Star_Rate))
				passStep("Star Rates are visible");
		} catch (Exception ex) {
			failStep("Account doesn't have the star rates");
		}
		clickOnButton(button_Choose_Star_Rate, "Star Space by Rate");

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
		// Payment check ## Promo Code
		else if (vehicle.getPayOption().equalsIgnoreCase("promocode")) {
			addPromoCode(vehicle.getPromoCode());
			waitForElementTobeDisplayed(label_Promo_Discount);
			passStep(getElementText(label_Promo_Discount));
		} else if (vehicle.getPayOption().equalsIgnoreCase("fixedPromoCode")) {
			addPromoCode(vehicle.getFixedPromoCode());
			waitForElementTobeDisplayed(label_Promo_Discount);
			passStep(getElementText(label_Promo_Discount));
		}
		waitForPageLoad(3);
		vehicle.setAmount(getElementText(total_amount));
		isElementDisplayed(button_Pay);
		clickOnButton(button_Pay, getElementText(button_Pay));
		waitForPageLoad(3);

	}

	/*
	 * Method to extend Star Space by Rate
	 *
	 * Author : Author : Pavan Prasad(pavanprasad.v@comakeit.com)
	 */
	public void extend_Star_Space_By_Rate(Vehicle vehicle) {
		stepInfo(" <b> ****Extending Star Space ****</b>");
		waitForElementTobeDisplayed(logo_Location);
		clickOnButton(logo_Location);

		waitForElementTobeDisplayed(label_Star_Rate);
		try {
			if (isElementDisplayed(label_Star_Rate))
				passStep("Star Rates are visible");
		} catch (Exception ex) {
			failStep("Account doesn't have the star rates");
		}
		clickOnButton(button_Choose_Star_Rate, "Star Space by Rate");

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
		// Payment check ## Promo Code
		else if (vehicle.getPayOption().equalsIgnoreCase("promocode")) {
			addPromoCode(vehicle.getPromoCode());
			waitForElementTobeDisplayed(label_Promo_Discount);
			passStep(getElementText(label_Promo_Discount));
		}
		else if (vehicle.getPayOption().equalsIgnoreCase("fixedPromoCode")) {
			addPromoCode(vehicle.getFixedPromoCode());
			waitForElementTobeDisplayed(label_Promo_Discount);
			passStep(getElementText(label_Promo_Discount));
		}
		waitForPageLoad(3);
		vehicle.setAmount(getElementText(total_amount));
		isElementDisplayed(button_Pay);
		clickOnButton(button_Pay, getElementText(button_Pay));
	}

}
