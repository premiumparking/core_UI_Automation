package pageObjects.SPA;

import components.BaseClass;
import org.openqa.selenium.By;

/*
 * Class which contains the web elements and performs Spa Home page activities (methods)
 *
 * Extends : BaseClass
 *
 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
 */
public class SPA_LoginPage extends BaseClass {
	// ****************** WEB ELEMENTS ****************************//
	public By button_SignIn = By.xpath("//span[normalize-space()='Sign in']");
	By textbox_SpaUserName = By.xpath("//input[@placeholder='Email or Mobile Number']");
	By textbox_SpaPassword = By.xpath("//input[@placeholder='Password']");
	By button_Submit = By.xpath("//button[@data-testid='submit-btn']");

	// ****************** ACTIONS ****************************//
	/*
	 * Method to navigate to perform spa login
	 *
	 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
	 */
	public SPA_AccountsPage login() {
		clickOnButton(button_SignIn, "Sign In button");
		enterText(textbox_SpaUserName, BaseClass.spa_username);
		clickOnButton(button_Submit, "Next button after entering username");
		enterText(textbox_SpaPassword, BaseClass.spa_password);
		clickOnButton(button_Submit, "Submit button after entering password ");
		SPA_AccountsPage accountsPage = new SPA_AccountsPage();
		waitForElementTobeDisplayed(accountsPage.logo_PP);
		passStep("Logged in successfully !!!");
		return accountsPage;
	}

}
