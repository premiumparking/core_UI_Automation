package pageObjects.Admiral;

import org.openqa.selenium.By;

import components.BaseClass;

/*
 * Class which contains the web elements and performs Login page activities (methods)
 * 
 * Extends : BaseClass
 * 
 * Author : Venu Thota(venu.thota@xebia.com)
 */
public class Adm_LoginPage extends BaseClass {

	// ****************** WEB ELEMENTS ****************************//
	public By textbox_UserName = By.id("user_email");
	By textbox_Password = By.id("user_password");
	By button_SignIn = By.xpath("//button[contains(text(),'Login')]");

	// ****************** ACTIONS ****************************//
	/*
	 * Method to perform login
	 * 
	 * Author : Venu Thota(venu.thota@xebia.com)
	 */
	public Adm_HomePage login() {
		enterText(textbox_UserName, BaseClass.adm_username);
		enterText(textbox_Password, BaseClass.adm_password);
		clickOnButton(button_SignIn, "Login In button");
		Adm_HomePage homePage = new Adm_HomePage();
		waitForElementTobeDisplayed(homePage.menu_Citations);
		if (isElementDisplayed(homePage.menu_Citations))
			passStep("Login successfull ...!!!");
		return new Adm_HomePage();

	}

}
