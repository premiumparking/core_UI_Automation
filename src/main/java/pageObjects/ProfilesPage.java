package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import components.BaseClass;
import dataModel.Profile;

/*
 * Class which contains the web elements and performs Profile page activities (methods)
 * 
 * Extends : BaseClass
 * 
 * Author : Venu Thota(venu.t@comakeit.com)
 */
public class ProfilesPage extends BaseClass {

	// ****************** WEB ELEMENTS ****************************//
	By button_New = By.xpath("//a[contains(text(),'New')]");
	By label_NewProfile = By.xpath("//h1[contains(text(),'New Profile')]");
	By searchBox = By.id("search");
	By button_Find = By.xpath("//input[@value='Find']");
	By totalRows = By.xpath("//tbody/tr");
	By textbox_profile_email = By.id("profile_email");
	By textbox_profile_password = By.id("profile_password");
	By textbox_profile_first_name = By.id("profile_first_name");
	By textbox_profile_last_name = By.id("profile_last_name");
	By textbox_profile_phone = By.id("profile_phone");
	By textbox_profile_address = By.id("profile_address");
	By textbox_profile_account_name = By.id("profile_account_name");
	By textbox_profile_concierge_locations = By.id("profile_concierge_location_ids-selectized");
	By button_Cancel = By.xpath("//a[contains(text(),'Cancel')]");
	By button_Save = By.xpath("//input[@type='submit' and @value='Save']");

	// ****************** ACTIONS ****************************//

	/*
	 * Method to navigate to create a profile
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public void createProfile(Profile profile) {
		passStep("Creating profile : " + profile.getEmail());

		waitForElementTobeDisplayed(button_New);
		clickOnButton(button_New, "New Button");
		waitForElementTobeDisplayed(label_NewProfile);
		enterText(textbox_profile_email, profile.getEmail(), "Email field");
		enterText(textbox_profile_first_name, profile.getFirstName(), "First Name field");
		enterText(textbox_profile_last_name, profile.getLastName(), "Last Name field");
		enterText(textbox_profile_address, profile.getAddress(), "Address field");
		selectFromSearch(textbox_profile_concierge_locations, profile.getLocation(), "Permitted concierge locations");
		performClick(textbox_profile_address);
		waitForPageLoad(1);
		clickOnButton(button_Save, "Save");
		passStep("Profile saved successfully !!!");
		navigate_To_Profiles_Page();
	}

	/*
	 * Method to navigate to check if the profile exist
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public boolean isPrfileExist(String email) {
		stepInfo("Verifying profile : " + email);
		waitForElementTobeDisplayed(searchBox);
		enterText(searchBox, email, "Search box");
		clickOnButton(button_Find, "Find button");
		try {
			List<WebElement> searchResult = BaseClass.driver.findElements(totalRows);
			if (searchResult.size() >= 1) {
				passStep("Profile " + email + " is available");
				return true;
			} else {
				passStep("Profile " + email + " is NOT available");
				return false;
			}
		} catch (Exception e) {
			passStep("Profile " + email + " is NOT available");
			return false;
		}

	}

	/*
	 * Method to navigate to profiles page
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public void navigate_To_Profiles_Page() {
		waitForPageLoad(1);
		BaseClass.driver.get(profilesURL);
		waitForPageLoad(2);
		waitForElementTobeDisplayed(searchBox);
	}

}
