package pageObjects.OD;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import components.BaseClass;
import dataModel.OD.Profile;

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

// ****************** ACTIONS ****************************//

	/*
	 * Method to navigate to imporsonate Business Account
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public void imporsonateBusinessAccount(Profile profile) {

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
	 * Method to navigate to check if the member is exist or not
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public boolean isMembertExist(Profile profile) {

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
	public void add_Member(Profile profile) {
		stepInfo("Adding member : " + profile.getEmail());
		waitForElementTobeDisplayed(button_AddMember);
		clickOnButton(button_AddMember, "Add Member");
		waitForElementTobeDisplayed(textBox_Email);
		enterText(textBox_Email, profile.getEmail(), "Email");
		enterText(textBox_FirstName, profile.getFirstName(), "First Name");
		enterText(textBox_LastName, profile.getLastName(), "Last Name");
		String[] lpNumbers = profile.getLpNumber().split(",");
		for (String lpNumber : lpNumbers) {
			clickOnButton(button_AddSubscription, "Add Subscription");
			By dd_AvailabelPlans = By.xpath("//input[contains(@id,'item-selectized')][1]");
			clickOnButton_using_Actions(dd_AvailabelPlans, "Availabel Plans");
			selectFromSearch(dd_AvailabelPlans, profile.getSubRateName(), "Available Plans");

		}
		// clickOnButton(button_AddSubscription, "Add Subscription");
		// clickOnButton_using_Actions(dd_AvailabelPlans, "Availabel Plans");
		// selectFromSearch(dd_AvailabelPlans, profile.getSubRateName(), "Available
		// Plans");
		// enterText(textBox_date, profile.getStartDate(), "Subscription Start Date");
		clickOnButton(button_Save, "Save button");
		waitForElementTobeDisplayed(button_Confirm);
		clickOnButton(button_Confirm, "Confirm");
		waitForPageLoad(3);
		passStep("<b>Member : " + profile.getEmail() + " added successfully !!! </b>");
		waitForElementTobeDisplayed(link_Members);
		clickOnButton(link_Members, "Members menu");
		waitForPageLoad(3);
		isMembertExist(profile);

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

	public void activate_Member(Profile profile) {
		By link_CopyLnk = By.xpath(".//a[contains(text(),'copy link')]");
		//List<WebElement> link_CopyLinks = BaseClass.driver.findElements(link_CopyLnk);
		// for (int i = 0; i < link_CopyLinks.size(); i++) {
		// link_CopyLink = By.xpath(".//a[contains(text(),'copy link')][1]");

		clickOnButton(link_CopyLink, "Copy Link");
		String u = BaseClass.driver.findElement(link_CopyLink).getAttribute("href");
		BaseClass.driver.get(u);
		waitForPageLoad(5);
		try {
			// waitForElementTobeDisplayed(textBox_new_Password);
			enterText(textBox_new_Password, profile.getEmail(), "New Password");
			enterText(textBox_Confirm_new_Password, profile.getEmail(), "Confirm New Password");
			clickOnButton(button_Create_Account, "Create Account");
		} catch (Exception e) {
			// TODO: handle exception
		}
		String[] lpns = profile.getLpNumber().split(",");
		waitForElementTobeDisplayed(input_licencePlate);
		enterText(input_licencePlate, lpns[0], "Licence Plate");
		waitForElementTobeDisplayed(button_Verify);
		clickOnButton(button_Verify, "Verify");
		waitForPageLoad(4);
		BaseClass.driver.navigate().back();
		waitForPageLoad(4);
		// }

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

}
