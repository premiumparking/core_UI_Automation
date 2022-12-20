package pageObjects.SPA;

import components.BaseClass;
import org.openqa.selenium.By;

/*
 * Class which contains the web elements and performs Spa Accoounts page activities (methods)
 *
 * Extends : BaseClass
 *
 * Author : Venu Thota(venu.t@comakeit.com)
 */
public class SPA_AccountsPage extends BaseClass {
	// ****************** WEB ELEMENTS ****************************//
	public By logo_PP = By.xpath("//a[@class='navbar-brand']");

	// ****************** ACTIONS ****************************//
	/*
	 * Method to navigate to Home page from Accounts page
	 *
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public SPA_HomePage navigateToHomePage() {
		clickOnButton(logo_PP, "Logo");
		SPA_HomePage homePage = new SPA_HomePage();
		waitForElementTobeDisplayed(homePage.textbox_Search_By_Location);
		if (isElementDisplayed(homePage.textbox_Search_By_Location)) {
			passStep("Navigated to HomePage");
		}
		return homePage;

	}

}
