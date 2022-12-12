package pageObjects.OD;

import org.openqa.selenium.By;

import components.BaseClass;

/*
 * Class which contains the web elements and performs Home page activities (methods)
 * 
 * Extends : BaseClass
 * 
 * Author : Venu Thota(venu.t@comakeit.com)
 */
public class LoginPage extends BaseClass {

	// ****************** WEB ELEMENTS ****************************//
	By textbox_UserName = By.id("user_email");
	By textbox_Password = By.id("user_password");
	By button_SignIn = By.xpath(".//input[@value='Sign In']");

	// ****************** ACTIONS ****************************//
	/*
	 * Method to navigate to perform login
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public HomePage login() {
		_enterText(textbox_UserName, BaseClass.username, "Username field");
		_enterText(textbox_Password, BaseClass.password, "Password field");
		clickOnButton(button_SignIn, "Sign In button");
		HomePage homePage = new HomePage();
		waitForElementTobeDisplayed(homePage.label_OperatorDashboard);
		passStep("Logged in with Brendan Bodensteiner 's credentials");
		return new HomePage();

	}

}
