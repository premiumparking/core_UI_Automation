package pageObjects.OD;

import org.openqa.selenium.By;

import components.BaseClass;
import dataModel.OD.Location;

/*
 * Class which contains the web elements and performs Locations page activities (methods)
 * 
 * Extends : BaseClass
 * 
 * Author : Venu Thota(venu.t@comakeit.com)
 */
public class VirtualLocationsPage extends BaseClass {

	// ****************** CLASS INSTANCES ****************************//
	HomePage homepage = new HomePage();

	// ****************** WEB ELEMENTS ****************************//
	By label_OperatorDashboard = By.xpath("//span[contains(text(),'Operator Dashboard')]");
	By label_VirtualLocations = By.xpath("//h2[contains(text(),'Virtual Locations')]");
	By button_New = By.xpath("//a[contains(text(),'New')]");
	By label_NewVirtualLocation = By.xpath("//h1[contains(text(),'New Virtual Location')]");
	By textBox_virtual_location_name = By.id("virtual_location_name");
	By textBox_locations = By.id("virtual_location_location_ids-selectized");

	By button_create_VLocation = By.xpath("//input[@value='Save']");

	// ****************** ACTIONS ****************************//

	/*
	 * Method to create a new Location
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public void create_VirtualLocation(String name, String[] locations) {
		waitForElementTobeDisplayed(button_New);
		clickOnButton(button_New, "Button new");
		waitForElementTobeDisplayed(label_NewVirtualLocation);
		enterText(textBox_virtual_location_name, name, "Name Textbox");
		for (String location : locations)
			selectFromSearch(textBox_locations, location, "Input Locations");

		clickOnButton(textBox_virtual_location_name);
		clickOnButton(button_create_VLocation, "Save Button");

		By locaionNameOnGrid = By.xpath("//td[contains(text(),'" + name + "')]");
		waitForElementTobeDisplayed(locaionNameOnGrid);
		if (isElementDisplayed(locaionNameOnGrid)) {
			passStep("Virtual Location " + name + " has been displayed on grid");
			passStep("Virtual Location creation is successful ...!!!");
		}

	}

}
