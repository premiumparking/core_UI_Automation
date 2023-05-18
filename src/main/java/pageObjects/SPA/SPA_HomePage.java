package pageObjects.SPA;

import components.BaseClass;
import org.openqa.selenium.By;

/*
 * Class which contains the web elements and performs Home page activities (methods)
 *
 * Extends : BaseClass
 *
 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
 */
public class SPA_HomePage extends BaseClass {

	// ****************** WEB ELEMENTS ****************************//

	By textbox_Search_By_Location = By.id("address-search");
	By dropdown_Markets = By.id("market-select");
	By button_View_Map = By.xpath("//a[contains(normalize-space(),'View map')]");
	By button_Park_Here = By.xpath("(//button[contains(normalize-space(),'Park here')])[3]");
	By textbox_Search_By_Market = By.id("market-select");
	By button_Search = By.id("destination-search-button");
	By button_Sessions = By.xpath("//button[normalize-space()='Pay to Park Now']");

	/*
	 * Method to navigate to Location Page
	 *
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public SPA_LocationPage navigate_To_LocationPage(String locationName) {
		waitForPageLoad(2);
		selectFromSearch(textbox_Search_By_Location, locationName, "Location Search Box");
		waitForPageLoad(2);
		SPA_LocationPage locationPage = new SPA_LocationPage();
		waitForElementTobeDisplayed(locationPage.textbox_Search_Location);
		passStep("Location page has been loaded ");
		return locationPage;
	}

	/*
	 * Method to navigate to Location Page through maps label
	 *
	 * Author : Pavan Prasad(pavanprasad.v@comakeit.com)
	 */
	public SPA_LocationPage navigate_To_LocationPage_ThroughMaps(String locationName) {
		waitForPageLoad(2);
		selectFromSearch(textbox_Search_By_Location, locationName, "Location Search Box");
		clickOnButton(button_View_Map, " View Map Button ");
		clickOnButton(button_Park_Here, "Park Here Button ");
		waitForPageLoad(2);
		SPA_LocationPage locationPage = new SPA_LocationPage();
		waitForElementTobeDisplayed(locationPage.textbox_Search_Location);
		passStep("Location page has been loaded ");
		return locationPage;
	}

	/*
	 * Method to navigate to Location Page through markets
	 *
	 * Author : Pavan Prasad(pavanprasad.v@comakeit.com)
	 */
	public SPA_LocationPage navigate_To_LocationPage_ThroughMarkets(String locationName) {
		waitForPageLoad(2);
		selectDropdown(dropdown_Markets, locationName, "Markets Dropdown");
		clickOnButton(button_View_Map, " View Map Button ");
		clickOnButton(button_Park_Here, "Park Here Button ");
		waitForPageLoad(2);
		SPA_LocationPage locationPage = new SPA_LocationPage();
		waitForElementTobeDisplayed(locationPage.textbox_Search_Location);
		passStep("Location page has been loaded ");
		return locationPage;

	}

}
