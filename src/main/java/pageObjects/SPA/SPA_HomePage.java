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
	By textbox_Search_By_Market = By.id("market-select");
	By button_Search = By.id("destination-search-button");
	By button_Sessions = By.xpath("//button[normalize-space()='Pay to Park Now']");

	/*
	 * Method to navigate to Location Page
	 *
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public SPA_LocationPage navigate_To_LocationPage(String locationName) {
		selectFromSearch(textbox_Search_By_Location, locationName, "Location Search Box");
		SPA_LocationPage locationPage = new SPA_LocationPage();
		waitForElementTobeDisplayed(locationPage.textbox_Search_Location);
		passStep("Location page has been loaded ");
		return locationPage;

	}

}
