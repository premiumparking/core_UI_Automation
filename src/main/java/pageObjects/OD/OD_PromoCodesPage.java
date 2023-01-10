package pageObjects.OD;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import components.BaseClass;
import components.Constants;
import dataModel.OD.PromoCode_Bulk;

/*
 * Class which contains the web elements and performs Markets page activities (methods)
 * 
 * Extends : BaseClass
 * 
 * Author : Venu Thota(venu.t@comakeit.com)
 */
public class OD_PromoCodesPage extends BaseClass {

	// ****************** WEB ELEMENTS ****************************//
	By label_OperatorDashboard = By.xpath("//span[contains(text(),'Operator Dashboard')]");
	By textBox_PromocodeSearch = By.id("discounts_search");
	By button_Find = By.xpath("//input[@value='Find']");
	By totalRows = By.xpath("//tr[@class='discounts-item']");

	By label_PromoCodes = By.xpath("//h1[normalize-space()='Promo Codes']");
	By button_New = By.xpath("//a[normalize-space()='New']");
	By label_NewPromoCode = By.xpath("//h1[normalize-space()='New Promo Code']");
	By radioButton_CustomCodeName = By.xpath("//input[@id='discount_form_generation_type_single']");
	By radioButton_AutoGenerateCode = By.xpath("//input[@id='discount_form_generation_type_multiple']");
	By textBox_PromoCode = By.id("discount_form_promo_code");
	By textBox_AmountOfUsers = By.id("discount_form_max_use_count");
	By textBox_Discount = By.id("discount_form_amount");
	By dd_DiscountType = By.id("discount_form_amount_type");
	By textBox_MinHours = By.id("discount_form_min_hours");
	By textBox_MaxHours = By.id("discount_form_max_hours");
	By dd_BusinessAccount = By.id("discount_form_payer_id-selectized");
	By textBox_DiscountFee = By.id("discount_form_payer_fee_amount");
	By textBox_StartsAt = By.id("discount_form_starts_at");
	By textBox_EndsAt = By.id("discount_form_ends_at");
	By dd_OncePerUser = By.id("discount_form_once_per_user-selectized");
	By dd_OncePerUser_No = By.xpath(
			"//input[@id='discount_form_once_per_user-selectized']/parent::div/following-sibling::div//div[normalize-space()='No'] ");
	By dd_OncePerUser_Yes = By.xpath(
			"//input[@id='discount_form_once_per_user-selectized']/parent::div/following-sibling::div//div[normalize-space()='Yes'] ");
	By dd_BeforeParkingStarts = By.id("discount_form_before_parking_starts-selectized");
	By dd_BFS_Yes = By.xpath(
			"//input[@id='discount_form_before_parking_starts-selectized']/parent::div/following-sibling::div//div[normalize-space()='Yes'] ");
	By dd_BFS_No = By.xpath(
			"//input[@id='discount_form_before_parking_starts-selectized']/parent::div/following-sibling::div//div[normalize-space()='No'] ");
	By dd_EventExcempt = By.id("discount_form_event_exempt-selectized");
	By dd_EventExcempt_Yes = By.xpath(
			"//input[@id='discount_form_event_exempt-selectized']/parent::div/following-sibling::div//div[normalize-space()='Yes'] ");
	By dd_EventExcempt_No = By.xpath(
			"//input[@id='discount_form_event_exempt-selectized']/parent::div/following-sibling::div//div[normalize-space()='No'] ");

	By dd_RefundServiceFee = By.id("discount_form_refund_service_fee-selectized");
	By dd_RSF_Yes = By.xpath(
			"//input[@id='discount_form_refund_service_fee-selectized']/parent::div/following-sibling::div//div[normalize-space()='Yes'] ");
	By dd_RSF_No = By.xpath(
			"//input[@id='discount_form_refund_service_fee-selectized']/parent::div/following-sibling::div//div[normalize-space()='No'] ");

	By checkBox_NoDiscount = By.id("discount_form_no_discount_or_validation_restrictions");
	By textBox_AvailableTypes = By.xpath("//select[@id='discount_form_available_types']");
	By dd_AvailableTypes = By.id("discount_form_available_types-selectized");
	By dd_Option_Session = By.xpath("//div[@data-value='session']");
	By dd_Option_Reservation = By.xpath("//div[@data-value='reservation']");
	By textBox_SubscriptionValidPeriods = By.id("discount_form_valid_periods_count");
	By textBox_AvailableLocations = By.id("discount_form_available_locations-selectized");
	By textBox_Tag = By.id("discount_form_license_plate_tag");
	By button_AddStarIcon = By.xpath("//button[normalize-space()='Add Star Icon']");
	By textBox_Notes = By.id("discount_form_notes");
	By textBox_Quantity = By.id("discount_form_max_active_parkings_count");
	By textBox_GracePeriod = By.id("discount_form_active_same_time_grace_period");
	By textBox_Weekdays = By.id("discount_form_active_week_days-selectized");

	By button_Save = By.xpath("//input[@value='Save']");
	By button_Cancel = By.xpath("//a[normalize-space()='Cancel']");

	// ****************** ACTIONS ****************************//

	/*
	 * Method to create a new Market
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public void create_PromoCode(PromoCode_Bulk promocode) {
		stepInfo("<b>Creating PromoCode : " + promocode.getPromoCode() + "</b>");
		waitForElementTobeDisplayed(button_New);
		clickOnButton(button_New, "Button new");
		waitForElementTobeDisplayed(label_NewPromoCode);
		select_Radiobutton(radioButton_CustomCodeName, "Custom Code Name");
		waitForElementTobeDisplayed(textBox_PromoCode);
		enterText(textBox_PromoCode, promocode.getPromoCode(), "Promo Code text box");
		enterText(textBox_AmountOfUsers, promocode.getAmountOfUsers(), "Amount Of Users text box");
		String discount = promocode.getDiscount().split("%")[0];
		enterText(textBox_Discount, discount, "Discount text box");
		selectDropdown(dd_DiscountType, "%", "Discount Type");
		passStep("Selected Min Hours : Unlimited"); // If we don't enter any, it is unlimited by default
		//enterText(textBox_MaxHours, promocode.getMaxHours(), "Max Hours text box");
		String BA_Name = promocode.getBusinessAccountName().equalsIgnoreCase("VIP") ? "5578"
				: promocode.getBusinessAccountName(); // ID of VIP is 5578
		selectFromSearch(dd_BusinessAccount, BA_Name, "Businaess Account Name");

		for (String weekday : Constants.WEEKDAYS) {
			By day = By.xpath(
					"//input[@id='discount_form_active_week_days-selectized']/preceding-sibling::div[normalize-space(text())='"
							+ weekday + "']");
			try {
				if (isElementDisplayed(day)) {
					passStep("Active weekday : '" + getElementText(day) + "' is selected");
				}
			} catch (Exception ex) {
				selectFromSearch(textBox_Weekdays, weekday, "Active weekday");
			}
		}
		String startDate = promocode.getStartDate().split(" ")[0]; // 01/01/2023 12:00 AM (CST)
		String endDate = promocode.getEndDate().split(" ")[0];
		enterText(textBox_StartsAt, startDate, "Start Date");
		enterText(textBox_EndsAt, endDate, "End Date");

		clickOnButton(dd_OncePerUser, "Once Per User dropdown");
		By dd_OPU = promocode.getOncePerAccount().equalsIgnoreCase("Yes") ? dd_OncePerUser_Yes : dd_OncePerUser_No;
		clickOnButton(dd_OPU, getElementText(dd_OPU) + " on Once Per User dropdown");

		clickOnButton(dd_BeforeParkingStarts, "Before Parking Starts dropdown");
		By dd_BFS = promocode.getBeforeParkingStarts().equalsIgnoreCase("Yes") ? dd_BFS_Yes : dd_BFS_No;
		clickOnButton(dd_BFS, getElementText(dd_BFS) + " on Before Parking Starts dropdown");

		clickOnButton(dd_EventExcempt, "Event Excempt dropdown");
		By dd_EE = promocode.getEventExempt().equalsIgnoreCase("Yes") ? dd_EventExcempt_Yes : dd_EventExcempt_No;
		clickOnButton(dd_EE, getElementText(dd_EE) + " on Event Excepmt dropdown");

		clickOnButton(dd_RefundServiceFee, "Refund Service Fee Dropdown");
		By dd_RSF = promocode.getRefundServiceFee().equalsIgnoreCase("Yes") ? dd_RSF_Yes : dd_RSF_No;
		clickOnButton(dd_RSF, getElementText(dd_RSF) + " on Refund Service Fee dropdown");

		if (promocode.getNoDiscount().equalsIgnoreCase("No"))
			unselect_Checkbox(checkBox_NoDiscount, "Check Box : 'No discount or validation restrictions'");
		else
			select_Checkbox(checkBox_NoDiscount, endDate);
		try {
			if (isElementDisplayed(dd_Option_Session)) {
				passStep("Available Type : 'Session' is selected");
			}
		} catch (Exception ex) {
			selectFromSearch(dd_AvailableTypes, "Session", "Available Types input");
		}

		try {
			if (isElementDisplayed(dd_Option_Reservation)) {
				passStep("Available Type : 'Reservation' is selected");
			}
		} catch (Exception ex) {
			selectFromSearch(dd_Option_Reservation, "Reservation", "Available Types input");
		}
		passStep("Selected Subscription Valid Periods : Unlimited"); // If we don't enter any, it is unlimited by
																		// default
		passStep("Selected Available locations : Unlimited"); // If we don't enter any, it is unlimited by default
		enterText(textBox_Notes, promocode.getNotes(), "Notes field");
		passStep("Selected Quantity : Unlimited"); // If we don't enter any, it is unlimited by default
		waitForElementTobeClickable(button_Save);
		// clickOnButton(button_Save, "Save button");
		waitForElementTobeDisplayed(label_PromoCodes);
		assertEquals(isPromoCodeExist(promocode.getPromoCode()), true);
	}

	/*
	 * Method to navigate to check if the PromoCode exist
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public boolean isPromoCodeExist(String promocode) {
		stepInfo("<b>Verifying PromoCode : " + promocode + "</b>");
		waitForElementTobeDisplayed(textBox_PromocodeSearch);
		enterText(textBox_PromocodeSearch, promocode, "Search box");
		clickOnButton(button_Find, "Find button");
		waitForPageLoad(3);
		List<WebElement> searchResult = BaseClass.driver.findElements(totalRows);
		if (searchResult.size() >= 1) {
			for (int i = 1; i <= searchResult.size(); i++) {
				try {
					By row = By.xpath(
							"(//tr[@class='discounts-item'])[" + i + "]/td[normalize-space()='" + promocode + "']");
					if (isElementDisplayed(row)) {
						highlightElement(BaseClass.driver.findElement(row));
						passStep("Promo Code : " + promocode + " is available");
						waitForPageLoad(1);
						return true;
					}
				} catch (Exception ex) {

				}
			}
			failStep("Somewthing wrong with Searchresult ... !!!");
		} else {
			passStep("Promo Code " + promocode + " is NOT available");
			return false;
		}

		return false;
	}

}
