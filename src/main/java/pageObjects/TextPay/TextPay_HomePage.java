package pageObjects.TextPay;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;

import components.BaseClass;
import dataModel.TextPay.Guest;
import dataModel.TextPay.PurchaseDetails;
import pageObjects.OD.OD_HomePage;
import pageObjects.OD.OD_LocationRevenuePage;
import pageObjects.OD.OD_LoginPage;

/*
 * Class which contains the web elements and performs Home page activities (methods)
 *
 * Extends : BaseClass
 *
 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
 */
public class TextPay_HomePage extends BaseClass {

	// ****************** CLASS OBJECTS ****************************//
	OD_HomePage od_homePage = new OD_HomePage();
	OD_LoginPage od_loginPage = new OD_LoginPage();
	OD_LocationRevenuePage od_locRevenuePage = new OD_LocationRevenuePage();

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
	By button_StarSpace = By.xpath("//strong[normalize-space()='Star Space']");
	By button_ChargingSpace = By.xpath("//strong[normalize-space()='Charging Space']");
	By button_ViewRate = By.xpath("//button[normalize-space()='View Rate']");
	By choose_Star_Space_Duration = By
			.xpath("//a[@data-testid='test-star-rate-link']//span[contains(.,'STAR 12 Hours')]");
	By choose_Charging_Space_Duration = By
			.xpath("//a[@data-testid='test-charging-rate-link']//span[contains(.,'2 hour')]");
	By label_Time_Regular_Space = By.xpath("//span[@data-testid='test-time-unit']");
	By label_Time_Star_Space = By.xpath("//p[contains(normalize-space(),'STAR 12 Hours')]");
	By label_Time_Charging_Space = By.xpath("//p[contains(normalize-space(),'2 hour')]");
	By label_Cost = By.xpath("//strong[normalize-space()='Total']/following-sibling::strong");
	public By duration_Bar = By.xpath("//input[@id='custom-duration']");
	By label_Ends = By.xpath("//p[contains(text(),'Ends:')]");
	By label_LocationName = By.xpath("//span[normalize-space()='Location Number:']/following-sibling::div");
	By label_SpaceType = By.xpath("//span[normalize-space()='Space Type:']/following-sibling::strong");
	By label_Address = By.xpath("//span[normalize-space()='Address:']/following-sibling::strong");
	By label_licencePlateInfo = By.xpath("//strong[@data-testid='test-license-info']");
	By label_Total = By.xpath("//div[@data-testid='test-total']");
	By button_Pay = By.xpath("//button[@data-testid='pay-button']");
	By button_startParking = By.xpath("//button[normalize-space()='Start parking']");

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
	By label_conf_vehicleInfo = By.xpath("//li[@data-testid='test-vehicle-data']/child::strong");
	By label_conf_confirmationNumber = By.xpath("//li[@data-testid='test-confirmation-number']");
	By confirmationNumber = By.xpath("//li[@data-testid='test-confirmation-number']/strong");

	By label_amountCharged = By.xpath("//div[@data-testid='test-total']/span[2]");
	By label_Review_Pay = By.xpath("//h2[contains(normalize-space(),'Review and Pay')]");
	By button_Unknown_Vehicle = By.xpath("//button[@data-testid='test-not-know-license-link']");
	By dd_Vehicle_Make = By.id("make");
	By dd_Vehicle_Type = By.id("type");
	By dd_Vehicle_Color = By.id("color");

	/*
	 * Method to navigate to Location Page
	 *
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public void purchase_Session_AsGuest(Guest guest) {
		stepInfo(" <b> **** Purchasing Session as Guest ****</b>");
		clickOnButton(link_Guest);
		waitForElementTobeClickable(location_searchBox);
		enterText(location_searchBox, guest.getLocationNumber(), "Location Searchbox");
		waitForElementTobeClickable(location_searchResult);
		clickOnButton(location_searchResult, getElementText(location_searchResult));
		// Vehicle Type
		if (guest.getVehicleType().equalsIgnoreCase("newVehicle")) {
			addNewVehicle(guest);
		} else if (guest.getVehicleType().equalsIgnoreCase("unknownVehicle")) {
			addUnknownVehicle(guest);
		}
		clickOnButton(button_Continue_1of4, "Continue button");

		// Space Type
		if (guest.getParkingType().equalsIgnoreCase("Regular Space")) {
			regularSpace();
			waitForElementTobeClickable(label_Time_Regular_Space);
			assertEquals(getElementText(label_Time_Regular_Space), guest.getTimeInHours() + " Hours");
			clickOnButton(button_Continue_3of4, "continue button");
			waitForElementTobeDisplayed(label_Review_Pay);
			assertEquals(getElementText(label_Time_Regular_Space), guest.getTimeInHours() + " Hours");
		} else if (guest.getParkingType().equalsIgnoreCase("Star Space")) {
			starSpace();
			waitForElementTobeClickable(label_Time_Star_Space);
			assertEquals(getElementText(label_Time_Star_Space), "STAR " + guest.getTimeInHours() + " Hours");
			clickOnButton(button_Continue_3of4, "continue button");
			waitForElementTobeDisplayed(label_Review_Pay);
			assertEquals(getElementText(label_Time_Star_Space), "STAR " + guest.getTimeInHours() + " Hours");
		} else if (guest.getParkingType().equalsIgnoreCase("Charging Space")) {
			chargingSpace();
			waitForElementTobeClickable(label_Time_Charging_Space);
			assertEquals(getElementText(label_Time_Charging_Space), guest.getTimeInHours() + " hour");
			clickOnButton(button_Continue_3of4, "continue button");
			waitForElementTobeDisplayed(label_Review_Pay);
			assertEquals(getElementText(label_Time_Charging_Space), guest.getTimeInHours() + " hour");
		}

		// Payment
		if (guest.getPaymentVia().equalsIgnoreCase("card")) {
			addNewCard(guest);
			waitForElementTobeClickable(button_Pay);
			waitForElementTobeDisplayed(label_Cost);
			guest.setAmount(getElementText(label_Cost));
			clickOnButton(button_Pay, "Pay button");
		} else if (guest.getPaymentVia().equalsIgnoreCase("promocode")) {
			addPromoCode(guest);
			waitForElementTobeClickable(button_startParking);
			waitForElementTobeDisplayed(label_Cost);
			guest.setAmount(getElementText(label_Cost));
			clickOnButton(button_startParking, "Start Parking button");
		}
	}

	public void addNewVehicle(Guest guest) {
		enterText(textBox_LicencePlate, guest.getLicensePlateNumber(), "Licence Plate box");
		waitForPageLoad(2);
		selectDropdown(dd_LicenceState, guest.getState(), "Licence State dropdown");
		String state = guest.getState().split("-")[1].trim().toUpperCase(); // AK - Alaska --> ALASKA
		assertEquals(getElementText(label_StateOnFrame), state);
		assertEquals(getElementText(label_PlateOnFrame), guest.getLicensePlateNumber());
	}

	public void addUnknownVehicle(Guest guest) {
		clickOnButton(button_Unknown_Vehicle, "I don't know my License Plate");
		waitForElementTobeDisplayed(dd_Vehicle_Make);
		selectFromSearch(dd_Vehicle_Make, guest.getMake(), "Vehicle Make");
		selectFromSearch(dd_Vehicle_Type, guest.getType(), "Vehicle Type");
		selectFromSearch(dd_Vehicle_Color, guest.getColor(), "Vehicle Color");
	}

	public void regularSpace() {
		waitForElementTobeClickable(button_RegularSpace);
		clickOnButton(button_RegularSpace, "Regular Space");
		waitForPageLoad(3);
		waitForElementTobeDisplayed(button_ViewRate);
		// changeTime(timeBar_ID, guest.getTimeInHours());
		// changeTime(guest.getTimeInHours());
		clickOnButton(button_ViewRate, "View Rate button");
	}

	public void starSpace() {
		waitForElementTobeClickable(button_StarSpace);
		clickOnButton(button_StarSpace, "Star Space");
		waitForPageLoad(3);
		waitForElementTobeDisplayed(choose_Star_Space_Duration);
		clickOnButton(choose_Star_Space_Duration, "Choose Star Space Duration");

	}

	public void chargingSpace() {
		waitForElementTobeClickable(button_ChargingSpace);
		clickOnButton(button_ChargingSpace, "Charging Space");
		waitForPageLoad(3);
		waitForElementTobeDisplayed(choose_Charging_Space_Duration);
		clickOnButton(choose_Charging_Space_Duration, "Choose Charging Space Duration");
	}

	public void addPromoCode(Guest guest) {
		waitForElementTobeClickable(link_PromoCode);
		clickOnButton(link_PromoCode, "Promo code link");
		waitForElementTobeDisplayed(textBox_Promocode);
		enterText(textBox_Promocode, guest.getPromocode(), "Promo Code box");
		clickOnButton(button_add_Promocode, "Add Promo Code");
	}

	public void addNewCard(Guest guest) {
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

	}

	public void verify_Purchase_Details(Guest guest, PurchaseDetails purchaseDetails) {
		stepInfo(" <b> **** Verifying Purchase Details ****</b>");
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

			if (guest.getParkingType().equalsIgnoreCase("Regular Space")) {
				assertEquals(getElementText(label_conf_spaceType), "Space Type:Regular");
				purchaseDetails.setSpaceType("On Demand");
			}
			else if (guest.getParkingType().equalsIgnoreCase("Star Space")) {
				assertEquals(getElementText(label_conf_spaceType), "Space Type:Star");
				purchaseDetails.setSpaceType("Star Spaces");
			}
			else if (guest.getParkingType().equalsIgnoreCase("Charging Space")) {
				assertEquals(getElementText(label_conf_spaceType), "Space Type:Charging");
				purchaseDetails.setSpaceType("Charging Spaces");
			}
			passStep(getElementText(label_conf_spaceType));
			passStep(getElementText(label_conf_address));

			String licencePlateInfo;
			if (guest.getVehicleType().equalsIgnoreCase("unknownVehicle"))
				licencePlateInfo = guest.getColor() + " " + guest.getType() + " " + guest.getMake();

			else
				licencePlateInfo = guest.getLicensePlateNumber() + "/" + guest.getState().split(" ")[0];
			assertEquals(getElementText(label_conf_vehicleInfo), licencePlateInfo);
			passStep(getElementText(label_conf_vehicleData));
			passStep(getElementText(label_conf_confirmationNumber));
			assertEquals(getElementText(label_amountCharged), guest.getAmount());
			passStep("Amount Charged :" + getElementText(label_amountCharged));

			purchaseDetails.setChannel("TextPay");	
			purchaseDetails.setOrderNumber(getElementText(confirmationNumber));
			purchaseDetails.setPurchaseType("Session");
			purchaseDetails.setLocationNumber(guest.getLocationNumber());
			purchaseDetails.setLicencePlate(guest.getLicensePlateNumber());
			purchaseDetails.setDurationInWords(getElementText(label_conf_duration));
			purchaseDetails.setAmountCharged(guest.getAmount());

		}

	}

	public void verify_LocationRevenuePage(PurchaseDetails purchaseDetails) {
		stepInfo(" <b> **** Verifying Location Revenue Details ****</b>");

		od_loginPage = launch_OD_Application();
		od_homePage = od_loginPage.login();
		od_locRevenuePage = od_homePage.navigateToLocationRevenuePage();
		od_locRevenuePage.verify_LocationRevenueData(purchaseDetails);

	}

}
