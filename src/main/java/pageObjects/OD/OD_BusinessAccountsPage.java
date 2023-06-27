package pageObjects.OD;

import java.util.ArrayList;
import java.util.List;

import dataModel.OD.DynamicLayout;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import components.BaseClass;
import dataModel.OD.Profile_Bulk;

import static org.testng.Assert.assertEquals;

/*
 * Class which contains the web elements and performs Business accounts page activities (methods)
 * 
 * Extends : BaseClass
 * 
 * Author : Venu Thota(venu.t@comakeit.com)
 */
public class OD_BusinessAccountsPage extends BaseClass {

	// ****************** WEB ELEMENTS ****************************//
	By textBox_SearchByID_or_Name = By.id("groups_search");
	By searchbox_Locations = By.xpath("//input[@type='select-multiple']");
	By button_Find = By.xpath("//input[@name='commit']");
	By totalRows = By.xpath("//tbody/tr");
	By row_1 = By.xpath("(//tbody/tr/td)[1]");
	By button_Imporsonate = By.xpath("//a[contains(text(),'Impersonate')]");

	// business accounts - group_memberships page (via Impersonate)
	By link_Members = By.xpath("//a[contains(text(),'Members')]");
	By textBox_Search = By.id("search");
	By button_Search = By.xpath("//input[@value='Search']");
	By member_Status = By.xpath("//span[@class='people__payment-hint']");
	By button_AddMember = By.xpath("//a[contains(text(),'Add Member')]");
	By textBox_Email = By.id("group_membership_profile_attributes_email");
	By textBox_FirstName = By.id("group_membership_profile_attributes_first_name");
	By textBox_LastName = By.id("group_membership_profile_attributes_last_name");
	By button_AddSubscription = By.xpath("//a[contains(text(),'Assign Subscription')]");
	By dd_AvailabelPlans = By.xpath("//input[contains(@id,'item-selectized')]");
	By textBox_date = By.xpath("//input[@data-format='m/d/Y']");
	By button_Save = By.xpath("//input[@value='Save']");
	By button_Confirm = By.xpath("//a[contains(text(),'Confirm')]");

	By link_AddVehicle = By.xpath("//a[contains(text(),'add vehicle')]");
	By textBox_licencePlate = By.xpath("(//input[@name ='vehicle[license_plate]'])[1]");
	By button_Add = By.xpath("(//input[@value='Add'])[1]");

	By link_CopyLink = By.xpath(".//a[contains(text(),'copy link')][1]");
	By input_licencePlate = By.id("subscription_license_plate");
	By button_Verify = By.xpath("//button[contains(text(),'Verify')]");

	By textBox_new_Password = By.id("new_password");
	By textBox_Confirm_new_Password = By.id("confirm_new_password");
	By button_Create_Account = By.id("change_password");

	By link_BAName = By.xpath("//div[@class='menu__level']");
	By link_MyAccount = By.xpath("//strong[normalize-space()='My Account']");
	By link_Validations = By.xpath("//a[@href='/my/validations']");
	By button_KioskMode = By.xpath("//a[normalize-space()='Kiosk Mode']");
	By textBox_LicensePlate = By.xpath("//input[@id='validation_form_license_plate']");
	By button_Validate = By.xpath("//button[@id='self-serve-validation-btn']");
	By msg_Error = By.xpath("//h4[@id='error-mesg']");
	By msg_Thankyou = By.xpath("//h1[normalize-space()='Thank You']");
	By button_NOThanks = By.xpath("//a[normalize-space()='No, thank you']");

	By dynamic_Layouts_Label = By.xpath("//tr//td[contains(normalize-space(),'Dynamic Layouts:')]");
	By dynamic_Layouts_Status = By
			.xpath("//tr//td[contains(normalize-space(),'Dynamic Layouts:')]/following-sibling::td");
	By BA_Edit_Button = By.xpath("//tr//td//div//a[contains(normalize-space(),'Edit')]");
	By dynamic_Layouts_Section = By.xpath("//div//h4[contains(normalize-space(),'Dynamic Layouts')]");
	By label_AllowTo_Assign_Spaces = By.xpath("//div//label[contains(normalize-space(),'Allow to assign spaces')]");
	By checkbox_AllowTo_Assign_Spaces = By.id("group_allow_assign_spaces");
	By label_Permitted_Locations = By.xpath("//label[@for='group_dynamic_layout_permitted_location_ids-selectized']");
	By textBox_Permitted_Locations = By.id("group_dynamic_layout_permitted_location_ids-selectized");
	By button_Update_BA = By.xpath("//input[@type='submit']");
// ****************** ACTIONS ****************************//

	/*
	 * Method to navigate to imporsonate Business Account
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public void imporsonateBusinessAccount(Profile_Bulk profile) {

		try {
			List<WebElement> searchResult = BaseClass.driver.findElements(totalRows);
			if (searchResult.size() >= 1) {
				By id = By.xpath(
						"//td[contains(text(),'" + profile.getBusinessAccountName() + "')]/preceding-sibling::td/a");
				clickOnButton(id, "ID: " + getElementText(row_1));
				clickOnButton(button_Imporsonate, "Impersonate");
				acceptAlert();
				waitForPageLoad(5);
			}
			// return true;
		} catch (Exception e) {
			// return false;
		}

	}

	/*
	 * Method to navigate to check if the business account exist
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public boolean isBusinessAccountExist(String accountName, String location) {
		stepInfo("<b>Verifying Business account : " + accountName + "</b>");
		waitForElementTobeDisplayed(textBox_SearchByID_or_Name);
		enterText(textBox_SearchByID_or_Name, accountName, "Search By ID box");
		selectFromSearch(searchbox_Locations, location, "Location Search results");
		performClick(textBox_SearchByID_or_Name);
		clickOnButton(button_Find, "Find button");
		try {

			WebElement name = BaseClass.driver.findElement(By.xpath("//td[contains(text(),'" + accountName + "')]"));
			if (name.isDisplayed()) {
				passStep(name.getText() + " has been displayed on the search result");
				highlightElement(name);
				return true;
			} else {
				failStep(name.getText() + " is displayed on the search result, But expected is " + accountName);
				return false;
			}

		} catch (Exception e) {
			failStep(accountName + " is NOT displayed on the search result");
			return false;
		}
	}

	/*
	 * Method to navigate to check if the business account exist
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public boolean isBusinessAccountExist(String businessAccountId) {

		waitForElementTobeDisplayed(textBox_SearchByID_or_Name);
		enterText(textBox_SearchByID_or_Name, businessAccountId, "Search By ID box");

		performClick(textBox_SearchByID_or_Name);
		clickOnButton(button_Find, "Find button");
		try {

			// WebElement id =
			// BaseClass.driver.findElement(By.xpath("//td/a[contains(text(),'" +
			// businessAccountId + "')]"));
			WebElement name = BaseClass.driver.findElement(By.xpath(
					"(//td/a[contains(text(),'" + businessAccountId + "')]/parent::td/following-sibling::td)[1]"));
			if (name.isDisplayed()) {
				passStep(name.getText() + " has been displayed on the search result");
				highlightElement(name);
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			failStep(businessAccountId + " is NOT displayed on the search result");
			return false;
		}
	}

	public Boolean isMember_Not_Activated() {
		Boolean status = false;
		try {
			status = isElementDisplayed(member_Status) || isElementDisplayed(link_CopyLink);
		} catch (Exception ex) {
			return status;
		}
		return status;
	}

	/*
	 * Method to navigate to check if the member is exist or not
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public boolean isMember_Exist(Profile_Bulk profile) {

		stepInfo("<b>Verifying Member : " + profile.getEmail() + "</b>");
		waitForElementTobeDisplayed(textBox_Search);
		enterText(textBox_Search, profile.getEmail(), "Search Box");
		clickOnButton(button_Search, "Search button");
		waitForPageLoad(2);
		try {

			WebElement name = BaseClass.driver.findElement(By.xpath("//a[contains(text(),'"
					+ profile.getFirstName().trim() + " " + profile.getLastName().trim() + "')]"));
			if (name.isDisplayed()) {
				passStep(name.getText() + " has been displayed on the search result");
				highlightElement(name);
				return true;
			} else {
				failStep(name.getText() + " is displayed on the search result, But expected is "
						+ profile.getFirstName() + " " + profile.getLastName());
				return false;
			}

		} catch (Exception e) {
			passStep(profile.getEmail() + " is NOT displayed on the search result");
			return false;
		}
	}

	/*
	 * Method to navigate to members to the business account
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public void add_Member(Profile_Bulk profile) {
		stepInfo("Adding member : " + profile.getEmail());
		waitForElementTobeDisplayed(button_AddMember);
		clickOnButton(button_AddMember, "Add Member");
		waitForElementTobeDisplayed(textBox_Email);
		enterText(textBox_Email, profile.getEmail(), "Email");
		enterText(textBox_FirstName, profile.getFirstName(), "First Name");
		enterText(textBox_LastName, profile.getLastName(), "Last Name");
		String[] lpNumbers = profile.getLpNumber().split(",");

		for (int i = 1; i <= lpNumbers.length; i++) {
			clickOnButton(button_AddSubscription, "Add Subscription");
			By dd_AvailabelPlans = By.xpath("//input[contains(@id,'item-selectized')][1]");
			clickOnButton_using_Actions(dd_AvailabelPlans, "Availabel Plans");
			selectFromSearch(dd_AvailabelPlans, profile.getSubRateName(), "Available Plans");
		}

		// enterText(textBox_date, profile.getStartDate(), "Subscription Start Date");
		clickOnButton(button_Save, "Save button");
		waitForElementTobeDisplayed(button_Confirm);
		clickOnButton(button_Confirm, "Confirm");
		waitForPageLoad(3);
		passStep("<b>Member : " + profile.getEmail() + " added successfully !!! </b>");
		waitForElementTobeDisplayed(link_Members);
		clickOnButton(link_Members, "Members menu");
		waitForPageLoad(3);
		isMember_Exist(profile);

	}

	/*
	 * Method to add a vehicle to the member
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public void add_Vehicle(String licence_Plate) {
		try {
			if (isElementDisplayed(link_AddVehicle)) {
				stepInfo("Adding Vehicle : " + licence_Plate);
				clickOnButton(link_AddVehicle, "Add Vehicle");
				waitForElementTobeDisplayed(textBox_licencePlate);
				enterText(textBox_licencePlate, licence_Plate, "Licence Palte text box");
				clickOnButton(button_Add, "Add BUtton");
				passStep("Licence_Plate <b>" + licence_Plate + "</b> added successfully !!! </b>");
			}
		} catch (Exception e) {

		}
	}

	public boolean is_CopyLink_displayed() {
		try {
			return isElementDisplayed(link_CopyLink);
		} catch (Exception ex) {
			return false;
		}
	}

	public void activate_Member(Profile_Bulk profile) {
		By link_CopyLnk = By.xpath(".//a[contains(text(),'copy link')]");
		List<WebElement> link_CopyLinks = BaseClass.driver.findElements(link_CopyLnk);
		for (int i = 0; i < link_CopyLinks.size(); i++) {
			link_CopyLink = By.xpath("(.//a[contains(text(),'copy link')])[" + (i + 1) + "]");
			clickOnButton(link_CopyLink, "Copy Link");
			String url = BaseClass.driver.findElement(link_CopyLink).getAttribute("href");
			openNewTab(url);
			ArrayList<String> tabs = getAllTabs();
			switch_to_Tab(tabs, 0);
			// BaseClass.driver.get(u);
		}
		waitForPageLoad(5);
		ArrayList<String> tabs = getAllTabs();
		if (tabs.size() > 1) {
			for (int j = 0; j < tabs.size() - 1; j++) {
				switch_to_Tab(tabs, (j + 1));

				try {
					// waitForElementTobeDisplayed(textBox_new_Password);
					if (isElementDisplayed(textBox_new_Password)) {
						enterText(textBox_new_Password, profile.getEmail(), "New Password");
						enterText(textBox_Confirm_new_Password, profile.getEmail(), "Confirm New Password");
						clickOnButton(button_Create_Account, "Create Account");
					}
				} catch (Exception e) {
					// TODO: handle exception
				}
				String[] lpns = profile.getLpNumber().split(",");
				waitForElementTobeDisplayed(input_licencePlate);
				enterText(input_licencePlate, lpns[j], "Licence Plate");
				waitForElementTobeDisplayed(button_Verify);
				clickOnButton(button_Verify, "Verify");
				waitForPageLoad(4);
				close_Tab(tabs, (j + 1));
				// BaseClass.driver.navigate().back();
			}
		}

		switch_to_Tab(tabs, 0); // Main Tab
		refresh_Page();
		waitForPageLoad(3);
	}

	/*
	 * Method to navigate to business accounts page
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public void navigate_To_BusinessAcounts_Page() {
		BaseClass.driver.get(businessAccountURL);
		waitForPageLoad(2);
		waitForElementTobeDisplayed(textBox_SearchByID_or_Name);
	}

	/*
	 * 
	 * Method to validate the license plates *
	 * 
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 * 
	 */

	public void validateLicensePlate(List<Profile_Bulk> profiles) {

		waitForPageLoad(2);
		waitForElementTobeDisplayed(link_BAName);
		clickOnButton(link_BAName, "Business Account link");
		waitForElementTobeDisplayed(link_MyAccount);
		clickOnButton(link_MyAccount, "My Account link");
		waitForElementTobeDisplayed(link_Validations);
		clickOnButton(link_Validations, "Validations link");
		waitForElementTobeDisplayed(button_KioskMode);
		clickOnButton(button_KioskMode, "KIOSK MODE Button");

		waitForPageLoad(5);
		ArrayList<String> tabs = getAllTabs();
		if (tabs.size() > 1) {

			switch_to_Tab(tabs, 1);
			try {
				By button_Location = By.xpath("//strong[contains(text(),'P2237')]");
				waitForElementTobeDisplayed(button_Location);
				clickOnButton(button_Location, getElementText(button_Location));
				waitForElementTobeDisplayed(textBox_LicensePlate);
				for (Profile_Bulk profile : profiles) {
					String currentURL = BaseClass.driver.getCurrentUrl();
					enterText(textBox_LicensePlate, profile.getLpNumber(), "Licence Box");
					waitForElementTobeClickable(button_Validate);
					clickOnButton(button_Validate, "VALIDATE button");
					try {
						if (isElementDisplayed(msg_Error)) {
							passStep(profile.getLpNumber() + " has already validated");
							// gotoBackPage();
							// waitForElementTobeDisplayed(textBox_LicensePlate);
							// gotoBackPage();
							// waitForElementTobeDisplayed(button_Location);
							// break;
						}
					} catch (Exception e) {
						// failStep(e.getMessage());
					}
					try {
						if (isElementDisplayed(msg_Thankyou)) {
							passStep(profile.getLpNumber() + " has been validated successfully");
							waitForElementTobeDisplayed(button_NOThanks);
							// clickOnButton(button_NOThanks, getElementText(button_NOThanks));
						}

					} catch (Exception e) {
						// failStep(e.getMessage());
					}
					BaseClass.driver.get(currentURL);
				}

			} catch (Exception e) {
				failStep(e.getMessage());
			}
		}

		switch_to_Tab(tabs, 0); // Main Tab
		refresh_Page();
		waitForPageLoad(3);

	}

	/*
	 * 
	 * Method to verify dynamic layouts
	 *
	 * Author : Pavan Prasad(pavanprasad.v@comakeit.com)
	 */
	public void verify_Dynamic_Layouts(DynamicLayout dynamicLayout) {
		stepInfo("<b>Verifying Business account : " + dynamicLayout.getBAName() + "</b>");
		waitForElementTobeDisplayed(textBox_SearchByID_or_Name);
		enterText(textBox_SearchByID_or_Name, dynamicLayout.getBAName(), "Search By ID box");
		clickOnButton(button_Find, "Find button");
		clickOnButton(row_1, "ID: " + getElementText(row_1));

		stepInfo("<b>Verifying whether user can see Dynamic Layouts label on BA details screen</b>");
		assertEquals(getElementText(dynamic_Layouts_Label), "Dynamic Layouts:");
		passStep(getElementText(dynamic_Layouts_Label) + " label has been displayed on the BA details screen");

		stepInfo("<b>Verifying Verify whether user can edit business account</b>");
		clickOnButton(BA_Edit_Button, "Edit Business Account Button");

		stepInfo("<b>Verifying whether user can see Dynamic Layouts section on the BA edit screen");
		assertEquals(getElementText(dynamic_Layouts_Section), "Dynamic Layouts");
		passStep(getElementText(dynamic_Layouts_Section) + " section has been displayed on the BA edit screen");

		stepInfo("<b>Verifying whether user can see Allow to assign spaces check box in BA edit screen");
		assertEquals(getElementText(label_AllowTo_Assign_Spaces), "Allow to assign spaces");
		passStep(getElementText(label_AllowTo_Assign_Spaces) + " check box has been displayed on the BA edit screen");

		stepInfo(
				"<b>Verifying whether user can click on the 'Allow to assign spaces' checkbox under the dynamic layouts section</b>");
		if (isCheckBoxChecked(checkbox_AllowTo_Assign_Spaces))
			passStep("Allow to assign spaces checkbox is checked");
		else
			select_Checkbox(checkbox_AllowTo_Assign_Spaces, "Allow to assign spaces checkbox");

		stepInfo("<b>Verifying whether user can see 'Permitted Locations' label under the dynamic layouts section");
		assertEquals(getElementText(label_Permitted_Locations), "Permitted Locations");
		passStep(getElementText(label_Permitted_Locations)
				+ " label has been displayed under the dynamic layouts section");

		stepInfo(
				"<b>Verifying whether user can select the locations available with dynamic layouts from 'Permitted Locations' dropdown.</b>");
		clearText(textBox_Permitted_Locations);
		selectFromSearch(textBox_Permitted_Locations, "P0373", "Permitted Locations Dropdown");
		clickOnButton(dynamic_Layouts_Section, "Dynamic Layouts");

		stepInfo("<b>Verifying whether user can save the dynamic layout changes.</b>");
		clickOnButton(button_Update_BA, "Update Business Account Button");

		stepInfo(
				"<b>Verifying whether user can see dynamic layouts as 'active' in the BA details screen when updating with 'Allow to assign spaces' checkbox.");
		assertEquals(getElementText(dynamic_Layouts_Status), "active");
		passStep("Dynamic layouts status as " + getElementText(dynamic_Layouts_Status)
				+ " displayed in the BA details screen");

		stepInfo(
				"<b>Verifying whether user can see dynamic layouts as 'inactive' in the BA details screen when un checking with 'Allow to assign spaces' checkbox.");
		clickOnButton(BA_Edit_Button, "Edit Business Account Button");
		unselect_Checkbox(checkbox_AllowTo_Assign_Spaces, "Allow to assign spaces checkbox");
		clearText(textBox_Permitted_Locations);
		clickOnButton(button_Update_BA, "Update Business Account Button");
		assertEquals(getElementText(dynamic_Layouts_Status), "inactive");
		passStep("Dynamic layouts status as " + getElementText(dynamic_Layouts_Status)
				+ " displayed in the BA details screen");

	}

}
