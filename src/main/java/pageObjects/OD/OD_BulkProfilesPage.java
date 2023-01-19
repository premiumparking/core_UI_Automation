package pageObjects.OD;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import components.BaseClass;
import dataModel.OD.Profile_Bulk;

/*
 * Class which contains the web elements and performs Profile_Bulk page activities (methods)
 * 
 * Extends : BaseClass
 * 
 * Author : Venu Thota(venu.t@comakeit.com)
 */
public class OD_BulkProfilesPage extends BaseClass {

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
	By searched_Rows = By.xpath("//tbody//tr");

	// ****************** ACTIONS ****************************//

	/*
	 * Method to navigate to create a profile
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public void createProfile(Profile_Bulk profile) {
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
		passStep("<b>Profile: " + profile.getEmail() + " created successfully !!! </b>");
		navigate_To_Profiles_Page();
	}

	/*
	 * Method to navigate to check if the profile exist
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public boolean isPrfileExist(String email) {
		stepInfo("<b>Verifying profile : " + email + "</b>");
		waitForElementTobeDisplayed(searchBox);
		enterText(searchBox, email, "Search box");
		clickOnButton(button_Find, "Find button");
		try {
			List<WebElement> searchResult = BaseClass.driver.findElements(totalRows);

			if (searchResult.size() >= 1) {
				for (int i = 1; i <= searchResult.size(); i++) {
					By row = By.xpath("((//tbody//tr)[" + i + "])//a");
					clickOnButton(row);
					waitForPageLoad(2);
					try {
						By elm = By.xpath("//td[normalize-space()='" + email.toLowerCase() + "']");
						if (isElementDisplayed(elm)) {
							highlightElement(BaseClass.driver.findElement(elm));
							passStep("Profile " + email + " is available");
							waitForPageLoad(1);
							BaseClass.driver.navigate().back();
							return true;
						}
					} catch (Exception ex) {
						passStep("Profile " + email + " is NOT available");
						BaseClass.driver.navigate().back();
					}
				}

			} else {
				passStep("Profile " + email + " is NOT available");
				return false;
			}
		} catch (Exception e) {
			passStep("Profile " + email + " is NOT available");
			return false;
		}
		return false;
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
