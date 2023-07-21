package pageObjects.TextPay;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;

import components.BaseClass;
import components.Constants;
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

	//Hotel Parking
	By button_AddNewVehicle = By.xpath("//button[normalize-space()='Add New Vehicle']");
	By textbox_MobileNumber = By.xpath("//input[@placeholder='Mobile Phone Number']");
	By button_Continue_Login = By.xpath("//button[@data-testid='login-continue-button']");
	By button_Continue = By.xpath("//button[normalize-space()='Continue']");	
	By textBox_OTP = By.xpath("//input[@placeholder='Verification Code']");
	By button_Verify = By.xpath("//button[normalize-space()='Verify']");	
	By button_HotelRate = By.xpath("(//div[@data-testid='test-rate-hotel-group']/button)[1]");	
	By button_Cal_nextMonth = By.xpath("//button[contains(text(),'›')]");
	By date_17 = By.xpath("//abbr[contains(text(),'17')]");
	By button_Confirm = By.xpath("//button[contains(text(),'Confirm')]");
	By button_Charge_to_room = By.xpath("//button[normalize-space()='Charge to Room']");
	By textbox_FirstName = By.xpath("//input[@name='firstName']");
	By textbox_LastName = By.xpath("//input[@name='lastName']");
	By textbox_RoomNumber = By.xpath("//input[@name='roomNumber']");

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

	By label_Time_Regular_Space = By.xpath("//span[@data-testid='test-time-unit']");

	By label_Cost = By.xpath("//strong[normalize-space()='Total']/following-sibling::strong");
	public By duration_Bar = By.xpath("//input[@id='custom-duration']");
	By label_Ends = By.xpath("//p[contains(text(),'Ends:')]");
	By label_LocationName = By.xpath("//span[normalize-space()='Location Number:']/following-sibling::div");
	By label_SpaceType = By.xpath("//span[normalize-space()='Space Type:']/following-sibling::strong");
	By label_Address = By.xpath("//span[normalize-space()='Address:']/following-sibling::strong");
	By label_licencePlateInfo = By.xpath("//strong[@data-testid='test-license-info']");
	By label_Total = By.xpath("//div[@data-testid='test-total']");
	By button_Pay = By.xpath("//button[@data-testid='pay-button']");
	By button_payWithCard = By.xpath("//button[normalize-space()='Pay with card']");
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

	// PEEK Slides
	By slide_1 = By.xpath("//button[normalize-space()='1']");
	// By button_choose_boat_tickets = By.xpath("(//p[normalize-space()='Boat
	// Rental'])[2]//following-sibling::div//button[@data-testid='choose-tickets-button']");
	By button_choose_boat_tickets = By.xpath(
			"(//p[normalize-space()='Boat Rental'])[2]//following-sibling::div//button[@data-testid='choose-tickets-button']");
	// By button_choose_boat_tickets = By.xpath("//div[@class='slick-slide
	// slick-active
	// slick-current']//div//button[@type='button'][normalize-space()='Choose
	// Tickets']");
	By button_plus = By.xpath("(//button[@type='button'][normalize-space()='+'])[1]");
	By button_Apply = By.xpath("//button[normalize-space()='Apply']");
	By peek_confirmation_Message = By.xpath("//strong[normalize-space()='Added to Order']");

	/*
	 * Method to navigate to Location Page
	 *
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public void purchase_Session_AsGuest(Guest guest, Boolean peek) {
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
			choose_regularSpace();
			waitForElementTobeClickable(label_Time_Regular_Space);
			assertEquals(getElementText(label_Time_Regular_Space), guest.getTimeInHours() + " Hours");
			if (peek)
				add_PEEK_Tickets();
			clickOnButton(button_Continue_3of4, getElementText(button_Continue_3of4));
			assertEquals(getElementText(label_Time_Regular_Space), guest.getTimeInHours() + " Hours");
			waitForElementTobeDisplayed(label_Review_Pay);
		} else if (guest.getParkingType().equalsIgnoreCase(Constants.SPECIAL_RATE)) {
			choose_regularSpace_SpecialRate();
			clickOnButton(getSpecialRateTime(guest.getTimeInHours()),
					getElementText(getSpecialRateTime(guest.getTimeInHours())));

			if (guest.getTimeInHours().equalsIgnoreCase("1"))
				assertEquals(getElementText(getSpecialRateTimeLable(guest.getTimeInHours())),
						"Special " + guest.getTimeInHours() + " Hr");
			else
				assertEquals(getElementText(getSpecialRateTimeLable(guest.getTimeInHours())),
						"Special " + guest.getTimeInHours() + " Hrs");
			if (peek)
				add_PEEK_Tickets();
			clickOnButton(button_Continue_3of4, "continue button");
			waitForElementTobeDisplayed(label_Review_Pay);
			if (guest.getTimeInHours().equalsIgnoreCase("1"))
				assertEquals(getElementText(getSpecialRateTimeLable(guest.getTimeInHours())),
						"Special " + guest.getTimeInHours() + " Hr");
			else
				assertEquals(getElementText(getSpecialRateTimeLable(guest.getTimeInHours())),
						"Special " + guest.getTimeInHours() + " Hrs");
		} else if (guest.getParkingType().equalsIgnoreCase("Star Space")) {
			choose_starSpace();
			clickOnButton(getStarTime(guest.getTimeInHours()), getElementText(getStarTime(guest.getTimeInHours())));
			if (guest.getTimeInHours().equalsIgnoreCase("1"))
				assertEquals(getElementText(getStarTimeLable(guest.getTimeInHours())),
						"Star " + guest.getTimeInHours() + " Hr");
			else
				assertEquals(getElementText(getStarTimeLable(guest.getTimeInHours())),
						"Star " + guest.getTimeInHours() + " Hrs");
			if (peek)
				add_PEEK_Tickets();
			clickOnButton(button_Continue_3of4, "continue button");
			waitForElementTobeDisplayed(label_Review_Pay);
			if (guest.getTimeInHours().equalsIgnoreCase("1"))
				assertEquals(getElementText(getStarTimeLable(guest.getTimeInHours())),
						"Star " + guest.getTimeInHours() + " Hr");
			else
				assertEquals(getElementText(getStarTimeLable(guest.getTimeInHours())),
						"Star " + guest.getTimeInHours() + " Hrs");
		} else if (guest.getParkingType().equalsIgnoreCase("Charging Space")) {
			choose_chargingSpace();
			clickOnButton(getChargingTime(guest.getTimeInHours()),
					getElementText(getChargingTime(guest.getTimeInHours())));
			if (guest.getTimeInHours().equalsIgnoreCase("1"))
				assertEquals(getElementText(getChargingTimeLable(guest.getTimeInHours())),
						"Charging " + guest.getTimeInHours() + " Hr");
			else
				assertEquals(getElementText(getChargingTimeLable(guest.getTimeInHours())),
						"Charging " + guest.getTimeInHours() + " Hrs");

			if (peek)
				add_PEEK_Tickets();
			clickOnButton(button_Continue_3of4, "continue button");
			waitForElementTobeDisplayed(label_Review_Pay);
			if (guest.getTimeInHours().equalsIgnoreCase("1"))
				assertEquals(getElementText(getChargingTimeLable(guest.getTimeInHours())),
						"Charging " + guest.getTimeInHours() + " Hr");
			else
				assertEquals(getElementText(getChargingTimeLable(guest.getTimeInHours())),
						"Charging " + guest.getTimeInHours() + " Hrs");
		}

		// Payment
		if (guest.getPaymentVia().equalsIgnoreCase("card")) {
			payWithCard(guest);
		} else if (guest.getPaymentVia().equalsIgnoreCase("promocode")) {
			addPromoCode(guest);
			if (guest.getPromocode().equalsIgnoreCase(Constants.PROMO50)) {
				payWithCard(guest);
			} else {
				waitForElementTobeClickable(button_startParking);
				waitForElementTobeDisplayed(label_Cost);
				guest.setAmount(getElementText(label_Cost));
				clickOnButton(button_startParking, "Start Parking button");
			}
		}
	}

	public void payWithCard(Guest guest) {
		try {
			if (isElementDisplayed(button_payWithCard)) {
				clickOnButton(button_payWithCard, getElementText(button_payWithCard));

				addNewCard(guest);
				waitForElementTobeClickable(button_Pay);
				waitForElementTobeDisplayed(label_Cost);
				guest.setAmount(getElementText(label_Cost));
				clickOnButton(button_Pay, "Pay button");

			}
		} catch (Exception e) {
			// TODO: handle exception
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

	public void choose_regularSpace() {
		waitForElementTobeClickable(button_RegularSpace);
		clickOnButton(button_RegularSpace, "Regular Space");
		waitForPageLoad(3);
		waitForElementTobeDisplayed(button_ViewRate);
		// changeTime(timeBar_ID, guest.getTimeInHours());
		// changeTime(guest.getTimeInHours());
		clickOnButton(button_ViewRate, "View Rate button");
	}

	public void choose_regularSpace_SpecialRate() {
		waitForElementTobeClickable(button_RegularSpace);
		clickOnButton(button_RegularSpace, "Regular Space");
		waitForPageLoad(3);
		waitForElementTobeDisplayed(button_ViewRate);
	}

	public void choose_starSpace() {
		waitForElementTobeClickable(button_StarSpace);
		clickOnButton(button_StarSpace, "Star Space");

	}

	public void choose_chargingSpace() {
		waitForElementTobeClickable(button_ChargingSpace);
		clickOnButton(button_ChargingSpace, "Charging Space");
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
			if (guest.getTimeInHours().equalsIgnoreCase("1"))
				assertEquals(getElementText(label_conf_duration), guest.getTimeInHours() + " Hour");
			else
				assertEquals(getElementText(label_conf_duration), guest.getTimeInHours() + " Hours");
			passStep("Parking Duration :" + getElementText(label_conf_duration));

			passStep(getElementText(label_conf_endTime));
			assertEquals(getElementText(label_conf_location), "Location Number:P" + guest.getLocationNumber());
			passStep(getElementText(label_conf_location));

			if (guest.getParkingType().equalsIgnoreCase("Regular Space")) {
				assertEquals(getElementText(label_conf_spaceType), "Space Type:Regular");
				purchaseDetails.setSpaceType("On Demand");
			} else if (guest.getParkingType().equalsIgnoreCase("Star Space")) {
				assertEquals(getElementText(label_conf_spaceType), "Space Type:Star");
				purchaseDetails.setSpaceType("Star Spaces");
			} else if (guest.getParkingType().equalsIgnoreCase("Charging Space")) {
				assertEquals(getElementText(label_conf_spaceType), "Space Type:Charging");
				purchaseDetails.setSpaceType("On Demand");
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
		
		public void verify_Purchase_Details_Hotel(Guest guest, PurchaseDetails purchaseDetails) {
			stepInfo(" <b> **** Verifying Purchase Details ****</b>");
			waitForElementTobeDisplayed(label_confirmationTitle);
			if (isElementDisplayed(label_confirmationTitle)) {
				passStep("Displayed : " + getElementText(label_confirmationTitle));
				assertEquals(getElementText(label_PurchaseDetails), "Purchase Details");
				passStep("Displayed : Purchase Details");				
				passStep("Parking Duration :" + getElementText(label_conf_duration));

				passStep(getElementText(label_conf_endTime));
				assertEquals(getElementText(label_conf_location), "Location Number:P" + guest.getLocationNumber());
				passStep(getElementText(label_conf_location));

				if (guest.getParkingType().equalsIgnoreCase("Regular Space")) {
					assertEquals(getElementText(label_conf_spaceType), "Space Type:Regular");
					purchaseDetails.setSpaceType("On Demand");
				} else if (guest.getParkingType().equalsIgnoreCase("Star Space")) {
					assertEquals(getElementText(label_conf_spaceType), "Space Type:Star");
					purchaseDetails.setSpaceType("Star Spaces");
				} else if (guest.getParkingType().equalsIgnoreCase("Charging Space")) {
					assertEquals(getElementText(label_conf_spaceType), "Space Type:Charging");
					purchaseDetails.setSpaceType("On Demand");
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

	public By getStarTime(String time) {
		if (time.equalsIgnoreCase("1"))
			return By.xpath("//strong[normalize-space()='Star " + time + " Hr']");
		else
			return By.xpath("//strong[normalize-space()='Star " + time + " Hrs']");

	}

	public By getChargingTime(String time) {
		if (time.equalsIgnoreCase("1"))
			return By.xpath("//strong[normalize-space()='Charging " + time + " Hr']");
		else
			return By.xpath("//strong[normalize-space()='Charging " + time + " Hrs']");

	}

	public By getSpecialRateTime(String time) {
		if (time.equalsIgnoreCase("1"))
			return By.xpath("//strong[normalize-space()='Special " + time + " Hr']");
		else
			return By.xpath("//strong[normalize-space()='Special " + time + " Hrs']");

	}

	public By getStarTimeLable(String time) {
		if (time.equalsIgnoreCase("1"))
			return By.xpath("//p[normalize-space()='Star " + time + " Hr']");
		else
			return By.xpath("//p[normalize-space()='Star " + time + " Hrs']");

	}

	public By getChargingTimeLable(String time) {
		if (time.equalsIgnoreCase("1"))
			return By.xpath("//p[normalize-space()='Charging " + time + " Hr']");
		else
			return By.xpath("//p[normalize-space()='Charging " + time + " Hrs']");

	}

	public By getSpecialRateTimeLable(String time) {
		if (time.equalsIgnoreCase("1"))
			return By.xpath("//p[normalize-space()='Special " + time + " Hr']");
		else
			return By.xpath("//p[normalize-space()='Special " + time + " Hrs']");

	}

	public void add_PEEK_Tickets() {
		clickOnButton(slide_1, "slide 1");
		clickOnButton_using_Actions(button_choose_boat_tickets, "Choose Tickets for Boat Rental");
		clickOnButton_using_JSE(button_choose_boat_tickets, "Choose Tickets for Boat Rental");
		waitForElementTobeClickable(button_plus);
		clickOnButton(button_plus, getElementText(button_plus));
		clickOnButton(button_plus, getElementText(button_plus));
		passStep("Added 2 tickets");
		waitForElementTobeClickable(button_Apply);
		clickOnButton(button_Apply, getElementText(button_Apply));
		waitForElementTobeDisplayed(peek_confirmation_Message);
		passStep("confimation message is displayed as : " + getElementText(peek_confirmation_Message));
		assertEquals(getElementText(peek_confirmation_Message), "Added to Order");

	}

	public Guest prepare_testData(Guest textpayUser) {
		textpayUser.setLocationNumber(Constants.HOTEL_LOCATION);
		String licencePlate = getRandomLicencePlate();
		textpayUser.setLicensePlateNumber(licencePlate);
		textpayUser.setVehicleType(Constants.NEW_VEHICLE);
		textpayUser.setParkingType(Constants.REGULAR_SPACE);
		textpayUser.setPaymentVia(Constants.CARD);
		textpayUser.setCcNumber(Constants.VISA_CARD_NUMBER);
		return textpayUser;

	}

	/*
	 * Method to Purchase a Session as Guest
	 *
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public void purchase_Session_With_Hotel_AsRegisterdUser(Guest textPayUser) {
		stepInfo(" <b> **** Purchasing Session with Hotel as Registered user ****</b>");
		enterText(textbox_MobileNumber, textPayUser.getMobileNumber(), "Mobile Number textbox");
		clickOnButton(button_Continue_Login, getElementText(button_Continue_Login));
		enterText(textBox_OTP, textPayUser.getOtp(), "OTP textbox");
		clickOnButton(button_Verify, getElementText(button_Verify));

		waitForElementTobeClickable(location_searchBox);
		enterText(location_searchBox, textPayUser.getLocationNumber(), "Location Searchbox");
		waitForElementTobeClickable(location_searchResult);
		clickOnButton(location_searchResult, getElementText(location_searchResult));
		waitForPageLoad(5);
		// Vehicle Type
		if (textPayUser.getVehicleType().equalsIgnoreCase("newVehicle")) {
			clickOnButton(button_AddNewVehicle, getElementText(button_AddNewVehicle));
			addNewVehicle(textPayUser);
		} else if (textPayUser.getVehicleType().equalsIgnoreCase("unknownVehicle")) {
			addUnknownVehicle(textPayUser);
		}
		
		clickOnButton(button_Continue,getElementText(button_Continue));
		clickOnButton(button_RegularSpace, "Regular Space");
		clickOnButton(button_HotelRate,getElementText(button_HotelRate));
		clickOnButton(button_Cal_nextMonth,"Next month button(>)");
		clickOnButton(date_17, "17th date");
		clickOnButton(button_Confirm, getElementText(button_Confirm));
		clickOnButton(button_Charge_to_room,getElementText(button_Charge_to_room));
		
		waitForElementTobeDisplayed(label_Cost);
		textPayUser.setAmount(getElementText(label_Cost));
		
		enterText(textbox_FirstName, textPayUser.getFirstName(),"First Name");
		enterText(textbox_LastName, textPayUser.getLastName(),"Last Name");
		enterText(textbox_RoomNumber, textPayUser.getRoomNumber(),"Room Number");
		clickOnButton(button_Charge_to_room,getElementText(button_Charge_to_room));		
		
	}

}
