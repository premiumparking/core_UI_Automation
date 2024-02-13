package pageObjects.TextPay;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;

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
	public By duration_Bar = By.xpath("//input[@id='custom-duration']");

	// Hotel Parking
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
	By link_AnotherCard = By.xpath("//button[normalize-space()='another card']");
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

	By link_SendReceipt = By.xpath("//button[normalize-space()='Would you like a receipt?']");
	By textBox_Email = By.xpath("//input[@placeholder='Email Address']");
	By button_Send = By.xpath("//input[@placeholder='Email Address']/following-sibling::button/span");
	By label_EmailSent = By.xpath("//h4[@data-testid='test-remind-text']");

	/*
	 * Method to navigate to Location Page
	 *
	 * Author : Venu Thota(venu.thota@xebia.com)
	 */
	public void purchase_Session(Guest user, String application) {
		// Login

		boolean skipLocationSearch = false;
		if (application.equalsIgnoreCase(Constants.CAMERAPAY)) {
			skipLocationSearch = true;
			user.setChannel(Constants.CAMERAPAY);
		}

		login_and_SelectLocation_and_Continue(user, skipLocationSearch);

		// Vehicle Type
		select_VehicleType_and_Continue(user);

		// Space Type
		switch (user.getParkingType()) {

		case Constants.REGULAR_SPACE:
			choose_regularSpace_and_Continue(user);
			break;

		case Constants.STAR_SPACE:
			choose_starSpace_and_Continue(user);
			break;

		case Constants.CHARGING_SPACE:
			choose_chargingSpace_and_Continue(user);
			break;

		case Constants.SPECIAL_RATE:
			choose_regularSpace_SpecialRate_and_Continue(user);
			break;

		default:
			break;
		}

		// Payment
		doPayment(user);
	}

	public void select_VehicleType_and_Continue(Guest user) {
		if (user.getVehicleType().equalsIgnoreCase(Constants.NEW_VEHICLE)) {
			addNewVehicle(user);
		} else if (user.getVehicleType().equalsIgnoreCase(Constants.UNKNOWN_VEHICLE)) {
			addUnknownVehicle(user);
		}
		clickOnButton(button_Continue_1of4, "Continue button");
	}

	public void login_and_SelectLocation_and_Continue(Guest user, boolean skipLocationSearch) {
		if (user.isGuestRole()) {
			stepInfo(" <b> **** Purchasing Session as Guest ****</b>");
			clickOnButton(link_Guest);
		} else {
			stepInfo(" <b> **** Purchasing Session with Phone number " + user.getMobileNumber() + " ****</b>");
			login_with_phoneNumber(user);
		}

		if (!skipLocationSearch) {
			waitForElementTobeClickable(location_searchBox);
			enterText(location_searchBox, user.getLocationNumber(), "Location Searchbox");
			waitForElementTobeClickable(location_searchResult);
			clickOnButton(location_searchResult, getElementText(location_searchResult));
		}
	}

	public void addNewVehicle(Guest user) {
		if (user.getVehicleType().equalsIgnoreCase(Constants.NEW_VEHICLE)) {
			waitForPageLoad(3);
			if (isElementDisplayed(button_AddNewVehicle))
				clickOnButton(button_AddNewVehicle, "Add New Vehicle link");
			waitForElementTobeDisplayed(textBox_LicencePlate);
			waitForElementTobeClickable(textBox_LicencePlate);
		}
		enterText(textBox_LicencePlate, user.getLicensePlateNumber(), "Licence Plate box");
		waitForPageLoad(2);
		selectDropdown(dd_LicenceState, user.getState(), "Licence State dropdown");
		String state = user.getState().split("-")[1].trim().toUpperCase(); // AK - Alaska --> ALASKA
		assertEquals(getElementText(label_StateOnFrame), state);
		assertEquals(getElementText(label_PlateOnFrame), user.getLicensePlateNumber());
	}

	public void addUnknownVehicle(Guest user) {
		waitForPageLoad(2);
		if (isElementDisplayed(button_AddNewVehicle))
			clickOnButton(button_AddNewVehicle, "Add New Vehicle link");
		waitForElementTobeDisplayed(button_Unknown_Vehicle);
		waitForElementTobeClickable(button_Unknown_Vehicle);

		clickOnButton(button_Unknown_Vehicle, "I don't know my License Plate");
		waitForElementTobeDisplayed(dd_Vehicle_Make);
		selectFromSearch(dd_Vehicle_Make, user.getMake(), "Vehicle Make");
		selectFromSearch(dd_Vehicle_Type, user.getType(), "Vehicle Type");
		selectFromSearch(dd_Vehicle_Color, user.getColor(), "Vehicle Color");
	}

	public void choose_regularSpace_and_Continue(Guest user) {
		waitForElementTobeClickable(button_RegularSpace);
		clickOnButton(button_RegularSpace, "Regular Space");
		waitForPageLoad(3);
		waitForElementTobeDisplayed(button_ViewRate);
		clickOnButton(button_ViewRate, "View Rate button");
		waitForPageLoad(3);
		waitForElementTobeClickable(label_Time_Regular_Space);
		assertEquals(getElementText(label_Time_Regular_Space), user.getTimeInHours() + " Hours");
		clickOnButton(button_Continue_3of4, getElementText(button_Continue_3of4));
		waitForElementTobeDisplayed(label_Review_Pay);
	}

	public void choose_regularSpace_SpecialRate_and_Continue(Guest user) {
		waitForElementTobeClickable(button_RegularSpace);
		clickOnButton(button_RegularSpace, "Regular Space");
		waitForPageLoad(3);
		waitForElementTobeDisplayed(button_ViewRate);
		waitForPageLoad(3);
		clickOnButton(getSpecialRateTime(user.getTimeInHours()),
				getElementText(getSpecialRateTime(user.getTimeInHours())));

		if (user.getTimeInHours().equalsIgnoreCase("1"))
			assertEquals(getElementText(getSpecialRateTimeLable(user.getTimeInHours())),
					"Special " + user.getTimeInHours() + " Hr");
		else
			assertEquals(getElementText(getSpecialRateTimeLable(user.getTimeInHours())),
					"Special " + user.getTimeInHours() + " Hrs");

		clickOnButton(button_Continue_3of4, "continue button");
		waitForElementTobeDisplayed(label_Review_Pay);
		if (user.getTimeInHours().equalsIgnoreCase("1"))
			assertEquals(getElementText(getSpecialRateTimeLable(user.getTimeInHours())),
					"Special " + user.getTimeInHours() + " Hr");
		else
			assertEquals(getElementText(getSpecialRateTimeLable(user.getTimeInHours())),
					"Special " + user.getTimeInHours() + " Hrs");
	}

	public void choose_starSpace_and_Continue(Guest user) {
		waitForElementTobeClickable(button_StarSpace);
		clickOnButton(button_StarSpace, "Star Space");
		waitForPageLoad(5);

		clickOnButton(getStarTime(user.getTimeInHours()), getElementText(getStarTime(user.getTimeInHours())));
		if (user.getTimeInHours().equalsIgnoreCase("1"))
			assertEquals(getElementText(getStarTimeLable(user.getTimeInHours())),
					"Star " + user.getTimeInHours() + " Hr");
		else
			assertEquals(getElementText(getStarTimeLable(user.getTimeInHours())),
					"Star " + user.getTimeInHours() + " Hrs");

		clickOnButton(button_Continue_3of4, "continue button");
		waitForElementTobeDisplayed(label_Review_Pay);
		if (user.getTimeInHours().equalsIgnoreCase("1"))
			assertEquals(getElementText(getStarTimeLable(user.getTimeInHours())),
					"Star " + user.getTimeInHours() + " Hr");
		else
			assertEquals(getElementText(getStarTimeLable(user.getTimeInHours())),
					"Star " + user.getTimeInHours() + " Hrs");

	}

	public void choose_chargingSpace_and_Continue(Guest user) {
		waitForElementTobeClickable(button_ChargingSpace);
		clickOnButton(button_ChargingSpace, "Charging Space");
		waitForPageLoad(5);
		waitForElementTobeDisplayed(getChargingTime(user.getTimeInHours()));

		clickOnButton(getChargingTime(user.getTimeInHours()), getElementText(getChargingTime(user.getTimeInHours())));
		if (user.getTimeInHours().equalsIgnoreCase("1"))
			assertEquals(getElementText(getChargingTimeLable(user.getTimeInHours())),
					"Charging " + user.getTimeInHours() + " Hr");
		else
			assertEquals(getElementText(getChargingTimeLable(user.getTimeInHours())),
					"Charging " + user.getTimeInHours() + " Hrs");

		clickOnButton(button_Continue_3of4, "continue button");
		waitForElementTobeDisplayed(label_Review_Pay);
		if (user.getTimeInHours().equalsIgnoreCase("1"))
			assertEquals(getElementText(getChargingTimeLable(user.getTimeInHours())),
					"Charging " + user.getTimeInHours() + " Hr");
		else
			assertEquals(getElementText(getChargingTimeLable(user.getTimeInHours())),
					"Charging " + user.getTimeInHours() + " Hrs");
	}

	public void doPayment(Guest user) {
		if (user.getPaymentVia().equalsIgnoreCase(Constants.CARD)) {
			payWithCard(user);
		} else if (user.getPaymentVia().equalsIgnoreCase(Constants.PROMOCODE)) {
			addPromoCode(user);
			if (user.getPromocode().equalsIgnoreCase(Constants.PROMO50)) {
				payWithCard(user);
			} else {
				waitForElementTobeClickable(button_startParking);
				waitForElementTobeDisplayed(label_Cost);
				user.setAmount(getElementText(label_Cost));
				clickOnButton(button_startParking, "Start Parking button");
			}
		}

	}

	public void payWithCard(Guest user) {
		try {
			waitForPageLoad(5);
			if (isElementDisplayed(button_payWithCard)) {
				clickOnButton(button_payWithCard, getElementText(button_payWithCard));

				addNewCard(user);
				waitForElementTobeClickable(button_Pay);
				waitForElementTobeDisplayed(label_Cost);
				user.setAmount(getElementText(label_Cost));
				clickOnButton(button_Pay, "Pay button");

			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void addPromoCode(Guest user) {
		waitForElementTobeClickable(link_PromoCode);
		clickOnButton(link_PromoCode, "Promo code link");
		waitForElementTobeDisplayed(textBox_Promocode);
		enterText(textBox_Promocode, user.getPromocode(), "Promo Code box");
		clickOnButton(button_add_Promocode, "Add Promo Code");
	}

	public void addNewCard(Guest user) {
		if (user.isNewPayment()) {
			if (isElementDisplayed(link_AnotherCard))
				clickOnButton(link_AnotherCard);
			waitForElementTobeDisplayed(iframe_cardNumber);
			switchToIframe(iframe_cardNumber);
			enterText(textbox_CardNumber, user.getCcNumber(), "Card Number Textbox");
			comeOutFromFrame();
			switchToIframe(iframe_expDate);
			enterText(textbox_ExpDate, user.getExpiry(), "Expiry Date Textbox");
			comeOutFromFrame();
			switchToIframe(iframe_CVC);
			enterText(textbox_CVC, user.getCvc(), "CC_CVC code Textbox");
			comeOutFromFrame();
			enterText(textbox_ZipCode, user.getZip(), "Zip Code Textbox");
		}
	}

	public void verify_Purchase_Details(Guest user, PurchaseDetails purchaseDetails) {
		stepInfo(" <b> **** Verifying Purchase Details ****</b>");
		waitForElementTobeDisplayed(label_confirmationTitle);
		if (isElementDisplayed(label_confirmationTitle)) {
			highlightElement(label_confirmationTitle);
			passStep("Displayed : " + getElementText(label_confirmationTitle));

			highlightElement(label_PurchaseDetails);
			assertEquals(getElementText(label_PurchaseDetails), "Purchase Details",
					"Purchase details title mismatch ...");
			passStep("Displayed : Purchase Details");

			highlightElement(label_conf_duration);
			passStep("Parking Duration :" + getElementText(label_conf_duration));
			if (user.getTimeInHours().equalsIgnoreCase("1"))
				assertEquals(getElementText(label_conf_duration), user.getTimeInHours() + " Hour",
						"Duration mismatch ...");
			else
				assertEquals(getElementText(label_conf_duration), user.getTimeInHours() + " Hours",
						"Duration mismatch ...");

			highlightElement(label_conf_endTime);
			passStep(getElementText(label_conf_endTime));

			highlightElement(label_conf_location);
			passStep(getElementText(label_conf_location));
			assertEquals(getElementText(label_conf_location), "Location Number:P" + user.getLocationNumber(),
					"Location name mismatch");

			highlightElement(label_conf_spaceType);
			passStep(getElementText(label_conf_spaceType));
			if (user.getParkingType().equalsIgnoreCase(Constants.REGULAR_SPACE)
					|| user.getParkingType().equalsIgnoreCase(Constants.SPECIAL_RATE)) {
				assertEquals(getElementText(label_conf_spaceType), "Space Type:Regular", "Space Type mismatch");
				purchaseDetails.setSpaceType("On Demand");
			} else if (user.getParkingType().equalsIgnoreCase(Constants.STAR_SPACE)) {
				assertEquals(getElementText(label_conf_spaceType), "Space Type:Star", "Space Type mismatch");
				purchaseDetails.setSpaceType("Star Spaces");
			} else if (user.getParkingType().equalsIgnoreCase(Constants.CHARGING_SPACE)) {
				assertEquals(getElementText(label_conf_spaceType), "Space Type:Charging", "Space Type mismatch");
				purchaseDetails.setSpaceType("On Demand");
			}

			highlightElement(label_conf_address);
			passStep(getElementText(label_conf_address));

			String licencePlateInfo;
			if (user.getVehicleType().equalsIgnoreCase(Constants.UNKNOWN_VEHICLE)) {
				licencePlateInfo = user.getColor() + " " + user.getType() + " " + user.getMake();
				purchaseDetails.setUnKnownVehicle(true);
				purchaseDetails.setLicencePlate(licencePlateInfo);
			} else {
				licencePlateInfo = user.getLicensePlateNumber() + "/" + user.getState().split(" ")[0];
				purchaseDetails.setUnKnownVehicle(false);
				purchaseDetails.setLicencePlate(user.getLicensePlateNumber());
			}
			passStep(getElementText(label_conf_vehicleData));
			passStep(getElementText(label_conf_vehicleInfo));
			highlightElement(label_conf_vehicleData);
			highlightElement(label_conf_vehicleInfo);
			assertEquals(getElementText(label_conf_vehicleInfo), licencePlateInfo,
					"Vehicle mismatch ... <a href=\"https://app.clickup.com/t/14266108/ENG-3849\">Clickup defect Ticket -> ENG-3849</a> \n\n");

			highlightElement(label_conf_confirmationNumber);
			passStep(getElementText(label_conf_confirmationNumber));

			highlightElement(label_amountCharged);
			passStep("Amount Charged :" + getElementText(label_amountCharged));
			assertEquals(getElementText(label_amountCharged), user.getAmount(), "Amount mismatch ...");

			if (user.getPaymentVia().equalsIgnoreCase(Constants.PROMOCODE)) {
				purchaseDetails.setPaymentOption(Constants.PROMOCODE);
				purchaseDetails.setPromocode(Constants.PROMO100);
			}
			if (user.getPaymentVia().equalsIgnoreCase(Constants.CARD)) {
				purchaseDetails.setPaymentOption(Constants.CARD);
				purchaseDetails.setPaymentMethod(Constants.VISA_CARD_TYPE);
			}

			purchaseDetails.setEmail(user.getEmail());
			purchaseDetails.setChannel(user.getChannel());
			purchaseDetails.setOrderNumber(getElementText(confirmationNumber));
			purchaseDetails.setPurchaseType("Session");

			purchaseDetails.setLocationNumber(user.getLocationNumber());
			purchaseDetails.setDurationInWords(getElementText(label_conf_duration));
			purchaseDetails.setAmountCharged(user.getAmount());

		}
	}

	public void verify_Purchase_Details_Hotel(Guest user, PurchaseDetails purchaseDetails) {
		stepInfo(" <b> **** Verifying Purchase Details ****</b>");
		waitForElementTobeDisplayed(label_confirmationTitle);
		if (isElementDisplayed(label_confirmationTitle)) {
			passStep("Displayed : " + getElementText(label_confirmationTitle));
			assertEquals(getElementText(label_PurchaseDetails), "Purchase Details");
			passStep("Displayed : Purchase Details");
			passStep("Parking Duration :" + getElementText(label_conf_duration));

			passStep(getElementText(label_conf_endTime));
			assertEquals(getElementText(label_conf_location), "Location Number:P" + user.getLocationNumber());
			passStep(getElementText(label_conf_location));

			if (user.getParkingType().equalsIgnoreCase("Regular Space")) {
				assertEquals(getElementText(label_conf_spaceType), "Space Type:Regular");
				purchaseDetails.setSpaceType("On Demand");
			} else if (user.getParkingType().equalsIgnoreCase("Star Space")) {
				assertEquals(getElementText(label_conf_spaceType), "Space Type:Star");
				purchaseDetails.setSpaceType("Star Spaces");
			} else if (user.getParkingType().equalsIgnoreCase("Charging Space")) {
				assertEquals(getElementText(label_conf_spaceType), "Space Type:Charging");
				purchaseDetails.setSpaceType("On Demand");
			}
			passStep(getElementText(label_conf_spaceType));
			passStep(getElementText(label_conf_address));

			String licencePlateInfo;
			if (user.getVehicleType().equalsIgnoreCase("unknownVehicle"))
				licencePlateInfo = user.getColor() + " " + user.getType() + " " + user.getMake();

			else
				licencePlateInfo = user.getLicensePlateNumber() + "/" + user.getState().split(" ")[0];
			assertEquals(getElementText(label_conf_vehicleInfo), licencePlateInfo);
			passStep(getElementText(label_conf_vehicleData));
			passStep(getElementText(label_conf_confirmationNumber));
			assertEquals(getElementText(label_amountCharged), user.getAmount());
			passStep("Amount Charged :" + getElementText(label_amountCharged));

			purchaseDetails.setChannel("TextPay");
			purchaseDetails.setOrderNumber(getElementText(confirmationNumber));
			purchaseDetails.setPurchaseType("Session");
			purchaseDetails.setLocationNumber(user.getLocationNumber());
			purchaseDetails.setLicencePlate(user.getLicensePlateNumber());
			purchaseDetails.setDurationInWords(getElementText(label_conf_duration));
			purchaseDetails.setAmountCharged(user.getAmount());

		}

	}

	public void verify_LocationRevenuePage(PurchaseDetails purchaseDetails) {
		waitForPageLoad(4);
		stepInfo(" <b> **** Verifying Location Revenue Details ****</b>");

		if (purchaseDetails.getChannel().equalsIgnoreCase(Constants.CAMERAPAY)) {
			ArrayList<String> all_open_tabs = getAllTabs();
			switch_to_Tab(all_open_tabs, 0);
			waitForPageLoad(3);
		}
		if (purchaseDetails.getChannel().equalsIgnoreCase(Constants.TEXTPAY)) {
			openNewTab();
			od_loginPage = launch_OD_Application();
			od_homePage = od_loginPage.login();
		}

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
	 * Author : Venu Thota(venu.thota@xebia.com)
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
		if (textPayUser.getVehicleType().equalsIgnoreCase(Constants.NEW_VEHICLE)) {
			waitForPageLoad(5);
			clickOnButton(button_AddNewVehicle, getElementText(button_AddNewVehicle));
			addNewVehicle(textPayUser);
		} else if (textPayUser.getVehicleType().equalsIgnoreCase(Constants.UNKNOWN_VEHICLE)) {
			addUnknownVehicle(textPayUser);
		}

		clickOnButton(button_Continue, getElementText(button_Continue));
		clickOnButton(button_RegularSpace, "Regular Space");
		clickOnButton(button_HotelRate, getElementText(button_HotelRate));
		clickOnButton(button_Cal_nextMonth, "Next month button(>)");
		clickOnButton(date_17, "17th date");
		clickOnButton(button_Confirm, getElementText(button_Confirm));
		clickOnButton(button_Charge_to_room, getElementText(button_Charge_to_room));

		waitForElementTobeDisplayed(label_Cost);
		textPayUser.setAmount(getElementText(label_Cost));

		enterText(textbox_FirstName, textPayUser.getFirstName(), "First Name");
		enterText(textbox_LastName, textPayUser.getLastName(), "Last Name");
		enterText(textbox_RoomNumber, textPayUser.getRoomNumber(), "Room Number");
		clickOnButton(button_Charge_to_room, getElementText(button_Charge_to_room));

	}

	public void login_with_phoneNumber(Guest user) {
		stepInfo("Login with Phone number");
		enterText(textbox_MobileNumber, user.getMobileNumber(), "Mobile Number textbox");
		clickOnButton(button_Continue_Login, getElementText(button_Continue_Login));
		enterText(textBox_OTP, user.getOtp(), "OTP textbox");
		clickOnButton(button_Verify, getElementText(button_Verify));

		// waitForElementTobeClickable(location_searchBox);

	}

	public void send_Receipt_to_Email(String email) {
		waitForElementTobeDisplayed(link_SendReceipt);
		waitForElementTobeClickable(link_SendReceipt);
		clickOnButton(link_SendReceipt, getElementText(link_SendReceipt));
		enterText(textBox_Email, email, "Email ID");
		clickOnButton(button_Send, "Send button");
		waitForElementTobeDisplayed(label_EmailSent);
		if (isElementDisplayed(label_EmailSent))
			passStep(getElementText(label_EmailSent));
		else
			failStep("Email sent confirmation message not displayed");
		// Assert.assertEquals(isElementDisplayed(label_EmailSent), true, "Email sent
		// confirmation message not displayed");

	}

}
