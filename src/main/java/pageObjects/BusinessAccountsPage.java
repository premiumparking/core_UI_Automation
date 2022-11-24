package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import components.BaseClass;
import dataModel.Profile;

/*
 * Class which contains the web elements and performs Business accounts page activities (methods)
 * 
 * Extends : BaseClass
 * 
 * Author : Venu Thota(venu.t@comakeit.com)
 */
public class BusinessAccountsPage extends BaseClass {

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
		stepInfo("Verifying Business account : " + accountName);
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

		stepInfo("Verifying Member account : " + profile.getEmail());
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
		clickOnButton(button_AddSubscription, "Add Subscription");
		clickOnButton_using_Actions(dd_AvailabelPlans, "Availabel Plans");
		selectFromSearch(dd_AvailabelPlans, profile.getSubRateName(), "Available Plans");
		enterText(textBox_date, profile.getStartDate(), "Subscription Start Date");
		clickOnButton(button_Save, "Save button");
		waitForElementTobeDisplayed(button_Confirm);
		clickOnButton(button_Confirm, "Confirm");
		waitForPageLoad(3);
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
		stepInfo("Adding Vehicle : " + licence_Plate);
		waitForElementTobeDisplayed(link_AddVehicle);
		clickOnButton(link_AddVehicle, "Add Vehicle");
		waitForElementTobeDisplayed(textBox_licencePlate);
		enterText(textBox_licencePlate, licence_Plate, "Licence Palte text box");
		clickOnButton(button_Add, "Add BUtton");

	}

	/*
	 * Method to navigate to business accounts page
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public void navigate_To_BusinaessAcounts_Page() {
		BaseClass.driver.get(businessAccountURL);
		waitForPageLoad(2);
		waitForElementTobeDisplayed(textBox_SearchByID_or_Name);
	}

}
