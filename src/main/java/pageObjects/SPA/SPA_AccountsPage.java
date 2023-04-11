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

	// Vehicles
	public By sideMenu_Vehicles = By.xpath("//a[@href='/my/vehicles']");
	public By button_AddVehicle = By.xpath("//a[@href='/my/vehicles/new']");
	By lable_NewVehicle = By.xpath("//h1[contains(text(),'New Vehicle')]");
	By textBox_LicencePlate = By.id("vehicle_license_plate");
	By dd_State = By.id("vehicle_state-selectized");
	By dd_Make = By.id("vehicle_make-selectized");
	By dd_Type = By.id("vehicle_body_type-selectized");
	By dd_Color = By.id("vehicle_color-selectized");
	By button_SaveVehicle = By.xpath("//input[@value='Save Vehicle']");

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

	/*
	 * Usage : To get random location from list of Locations space
	 * 
	 * Author : Venu Thota (venu.t@comakeit.com)
	 */
	public String add_New_Vehicle() {
		
		String lp =  getRandomLicencePlate();
		
		waitForElementTobeClickable(sideMenu_Vehicles);
		clickOnButton(sideMenu_Vehicles, "Vehicles");
		waitForElementTobeClickable(button_AddVehicle);
		clickOnButton(button_AddVehicle, getElementText(button_AddVehicle));
		
		waitForElementTobeDisplayed(lable_NewVehicle);
		
		enterText(textBox_LicencePlate,lp,"Licence Plate textbox");
		selectFromSearch(dd_State, "Alabama", "State field");
		selectFromSearch(dd_Make, "Audi", "Make field");
		selectFromSearch(dd_Type, "SUV", "Type field");
		selectFromSearch(dd_Color, "Red", "Color field");
		clickOnButton(button_SaveVehicle, getElementText(button_SaveVehicle));
		
		//return "Red  Audi "+lp+" / AL";
		return lp;

	}
}
