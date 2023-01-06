package pageObjects.TextPay;

import components.BaseClass;
import dataModel.SPA.Vehicle;
import dataModel.TextPay.Guest;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;

/*
 * Class which contains the web elements and performs Home page activities (methods)
 *
 * Extends : BaseClass
 *
 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
 */
public class TextPay_HomePage extends BaseClass {

	// ****************** WEB ELEMENTS ****************************//

	public By link_Guest = By.xpath("//a[normalize-space()='Continue as a Guest']");
	By location_searchBox = By.xpath("//input[@data-testid='test-search-input']");
	By location_searchResult = By.xpath("//button[@data-testid='test-location-search-result']");
	By textBox_LicencePlate = By.xpath("//input[@id='license-plate-number']");
	By dd_LicenceState = By.xpath("//select[@id='plate-state-select']");
	By label_StateOnFrame = By.xpath("//div[@data-testid='test-plate-state-frame']");
	By label_PlateOnFrame = By.xpath("//div[@data-testid='test-plate-number-frame']");
	By button_Continue_1of4 = By.xpath("//button[normalize-space()='Continue']");
	By button_Continue_3of4 = By.xpath("//a[normalize-space()='Continue']");
	By button_RegularSpace = By.xpath("//strong[normalize-space()='Regular Space']");
	By button_StarSpace = By.xpath("//strong[normalize-space()='Star Space']]");
	By button_ChargingSpace = By.xpath("//strong[normalize-space()='Charging Space']");
	By button_ViewRate = By.xpath("//button[normalize-space()='View Rate']");
	By label_Time = By.xpath("//span[@data-testid='test-time-unit']");
	By label_Cost = By.xpath("//span[normalize-space()='Total']/following-sibling::span");
	public By duration_Bar = By.xpath("//input[@id='custom-duration']");
	By label_Ends = By.xpath("//p[contains(text(),'Ends:')]");
	By label_LocationName = By.xpath("//span[normalize-space()='Location Number:']/following-sibling::div");
	By label_SpaceType = By.xpath("//span[normalize-space()='Space Type:']/following-sibling::strong");
	By label_Address = By.xpath("//span[normalize-space()='Address:']/following-sibling::strong");
	By label_licencePlateInfo = By.xpath("//strong[@data-testid='test-license-info']");
	By label_Total = By.xpath("//div[@data-testid='test-total']");
	By button_Pay = By.xpath("//button[@data-testid='pay-button']");
	By button_startParking= By.xpath("//button[normalize-space()='Start parking']");

	By link_PromoCode = By.xpath("//button[normalize-space()='Promo Code']");
	By textbox_CardNumber = By.name("cardnumber");
	By textbox_ExpDate = By.name("exp-date");
	By textbox_CVC = By.name("cvc");
	By textbox_ZipCode = By.id("zip");

	By textBox_Promocode = By.id("promoCode");
	By button_add_Promocode = By.xpath("//button[@data-testid='test-add-promo-code-button']");
	By iframe_cardNumber = By.xpath("//iframe[@title='Secure card number input frame']");
	By iframe_expDate = By.xpath("//iframe[@title='Secure expiration date input frame']");
	By iframe_CVC = By.xpath("//iframe[@title='Secure CVC input frame']");
	By total_amount = By.xpath("//strong[@data-cy='parking-total-amount']");

	public String timeBar_ID = "custom-duration";

	By label_confirmationTitle = By.xpath("//h1[contains(text(),'All set')]");
	By label_PurchaseDetails = By.xpath("//h3[normalize-space()='Purchase Details']");

	By label_conf_duration = By.xpath("//span[@data-testid='test-time-unit']");
	By label_conf_endTime = By.xpath("//span[@data-testid='test-time-unit']/parent::p/following-sibling::p");
	By label_conf_location = By.xpath("//li[@data-testid='test-location-number']");
	By label_conf_spaceType = By.xpath("//li[@data-testid='test-space-type']");
	By label_conf_address = By.xpath("//li[@data-testid='test-address']");
	By label_conf_vehicleData = By.xpath("//li[@data-testid='test-vehicle-data']");
	By label_conf_licencePlateInfo = By.xpath("//strong[@data-testid='test-license-info']");
	By label_conf_confirmationNumber = By.xpath("//li[@data-testid='test-confirmation-number']");

	By label_amountCharged = By.xpath("//div[@data-testid='test-total']/span[2]");

	/*
	 * Method to navigate to Location Page
	 *
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public void purchase_Session_AsGuest(Guest guest) {
		clickOnButton(link_Guest);
		waitForElementTobeClickable(location_searchBox);
		enterText(location_searchBox, guest.getLocationNumber(), "Location Searchbox");
		waitForElementTobeClickable(location_searchResult);
		clickOnButton(location_searchResult, getElementText(location_searchResult));
		enterText(textBox_LicencePlate, guest.getLicensePlateNumber(), "Licence Plate box");
		selectDropdown(dd_LicenceState, guest.getState(), "Licence State dropdown");
		String state = guest.getState().split("-")[1].trim().toUpperCase(); // AK - Alaska --> ALASKA
		assertEquals(getElementText(label_StateOnFrame), state);
		assertEquals(getElementText(label_PlateOnFrame), guest.getLicensePlateNumber());
		clickOnButton(button_Continue_1of4, "Contine button");
		if (guest.getParkingType().equalsIgnoreCase("Regular Space")) {
			waitForElementTobeClickable(button_RegularSpace);
			clickOnButton(button_RegularSpace, "Regular Space");
			waitForElementTobeDisplayed(button_ViewRate);
			// changeTime(timeBar_ID, guest.getTimeInHours());
			changeTime(guest.getTimeInHours());
			clickOnButton(button_ViewRate, "View Rate button");
		}
		waitForElementTobeClickable(label_Time);
		assertEquals(getElementText(label_Time), guest.getTimeInHours() + " Hours");
		guest.setAmount(getElementText(label_Cost));
		clickOnButton(button_Continue_3of4, "continue button");
		assertEquals(getElementText(label_Time), guest.getTimeInHours() + " Hours");

		// Payment
		if (guest.getPaymentVia().equalsIgnoreCase("card")) {
			waitForElementTobeDisplayed(iframe_cardNumber);
			switchToIframe(iframe_cardNumber);
			enterText(textbox_CardNumber, guest.getCcNumber(), "Card Number Textbox");
			BaseClass.driver.switchTo().defaultContent();
			switchToIframe(iframe_expDate);
			enterText(textbox_ExpDate, guest.getExpiry(), "Expiry Date Textbox");
			BaseClass.driver.switchTo().defaultContent();
			switchToIframe(iframe_CVC);
			enterText(textbox_CVC, guest.getCvc(), "CC_CVC code Textbox");
			BaseClass.driver.switchTo().defaultContent();
			enterText(textbox_ZipCode, guest.getZip(), "Zip Code Textbox");
			waitForElementTobeClickable(button_Pay);
			clickOnButton(button_Pay, "Pay button");
		}
		else if(guest.getPaymentVia().equalsIgnoreCase("promocode")) {
			waitForElementTobeClickable(link_PromoCode);
			clickOnButton(link_PromoCode,"Promo code link");
			waitForElementTobeDisplayed(textBox_Promocode);
			enterText(textBox_Promocode, guest.getPromocode(),"Promo Code box");
			clickOnButton(button_add_Promocode,"Add Promo Code");
		}
		

	}

	public void verify_Purchase_Details(Guest guest) {
		waitForElementTobeDisplayed(label_confirmationTitle);
		if (isElementDisplayed(label_confirmationTitle)) {
			passStep("Displayed : " + getElementText(label_confirmationTitle));
			assertEquals(getElementText(label_PurchaseDetails), "Purchase Details");
			passStep("Displayed : Purchase Details");
			assertEquals(getElementText(label_conf_duration), guest.getTimeInHours() + " Hours");
			passStep("Parking Duration :" + getElementText(label_conf_duration));

			passStep(getElementText(label_conf_endTime));
			assertEquals(getElementText(label_conf_location), "Location Number:P" + guest.getLocationNumber());
			passStep(getElementText(label_conf_location));

			if (guest.getParkingType().equalsIgnoreCase("Regular Space"))
				assertEquals(getElementText(label_conf_spaceType), "Space Type:Regular");
			passStep(getElementText(label_conf_spaceType));
			passStep(getElementText(label_conf_address));

			String licencePlateInfo = guest.getLicensePlateNumber() + "/" + guest.getState().split(" ")[0];
			assertEquals(getElementText(label_conf_licencePlateInfo), licencePlateInfo);
			passStep(getElementText(label_conf_vehicleData));
			passStep(getElementText(label_conf_confirmationNumber));
			assertEquals(getElementText(label_amountCharged), guest.getAmount());
			passStep("Amount Charged :" + getElementText(label_amountCharged));

		}
	}

}
