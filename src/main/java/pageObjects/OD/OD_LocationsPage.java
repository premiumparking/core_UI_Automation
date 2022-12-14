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
public class OD_LocationsPage extends BaseClass {

	// ****************** CLASS INSTANCES ****************************//
	OD_HomePage homepage = new OD_HomePage();

	// ****************** WEB ELEMENTS ****************************//
	By label_OperatorDashboard = By.xpath("//span[contains(text(),'Operator Dashboard')]");
	By label_Locations = By.xpath("//h2[contains(text(),'Locations')]");
	By button_New = By.xpath("//a[contains(text(),'New')]");
	By textBox_search_Location = By.id("location_search");
	By label_NewLocation = By.xpath("//h1[contains(text(),'New Location')]");
	By radioButton_rates_live = By.id("location_dead_rate_false");
	By radioButton_rates_dead = By.id("location_dead_rate_true");
	By radioButton_reservations_Enabled = By.id("location_allows_reservations_true");
	By radioButton_reservations_Disabled = By.id("location_allows_reservations_false");
	By radioButton_durations_Enabled = By.id("location_allows_durations_true");
	By radioButton_durations_Disabled = By.id("location_allows_durations_false");
	By radioButton_Cruise = By.id("location_cruise_true");
	By radioButton_NormalLocation = By.id("location_cruise_false");
	By checkBox_MonthlyParkingURL = By.id("location_show_monthly_parking_box");
	By dd_locationMarket = By.id("location_market_id");
	By textBox_location_name = By.id("location_name");
	By textBox_location_address = By.id("location_address");
	By textBox_location_city = By.id("location_city");
	By textBox_location_zip = By.id("location_zip");
	By textBox_location_latitude = By.id("location_latitude");
	By textBox_location_longitude = By.id("location_longitude");
	By button_create_location = By.xpath("//input[@value='Create Location']");

	// ****************** ACTIONS ****************************//

	/*
	 * Method to create a new Location
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public void create_Location(Location location) {
		waitForElementTobeDisplayed(button_New);
		clickOnButton(button_New, "Button new");
		waitForElementTobeDisplayed(label_NewLocation);
		if (location.getRates().equalsIgnoreCase("Live"))
			select_Radiobutton(radioButton_rates_live, "Rates Live");
		else
			select_Radiobutton(radioButton_rates_dead, "Rates Dead");
		if (location.getReservations().equalsIgnoreCase("Enabled"))
			select_Radiobutton(radioButton_reservations_Enabled, "Reservations Enabled");
		else
			select_Radiobutton(radioButton_reservations_Disabled, "Reservations Disabled");
		if (location.getDurations().equalsIgnoreCase("Enabled"))
			select_Radiobutton(radioButton_durations_Enabled, "Durations Enabled");
		else
			select_Radiobutton(radioButton_durations_Disabled, "Durations Disabled");
		if (location.getLocationType().equalsIgnoreCase("Normal Location"))
			select_Radiobutton(radioButton_NormalLocation, "Normal Location");
		else
			select_Radiobutton(radioButton_Cruise, "Cruise Location");
		unselect_Checkbox(checkBox_MonthlyParkingURL, "Request Monthly Parking Box");
		selectDropdown(dd_locationMarket, location.getMarket(), "Market dropdown");
		enterText(textBox_location_name, location.getName(), "Name Textbox");
		enterText(textBox_location_address, location.getAddress(), "Address Textbox");
		enterText(textBox_location_city, location.getCity(), "City Textbox");
		enterText(textBox_location_zip, location.getZip(), "Zip Textbox");
		enterText(textBox_location_latitude, location.getLatitude(), "Latitude Textbox");
		enterText(textBox_location_longitude, location.getLongitude(), "Longitude Textbox");
		clickOnButton(button_create_location, "Create Location button");
		waitForPageLoad(3);
		homepage.navigateToLocationsPage();

		waitForElementTobeDisplayed(textBox_search_Location);
		enterText(textBox_search_Location, location.getName(), "Search box");
		// hitEnter(textBox_search_Location);

		By locaionNameOnGrid = By.xpath("//a[contains(text(),'" + location.getName() + "')]");
		waitForElementTobeDisplayed(locaionNameOnGrid);
		if (isElementDisplayed(locaionNameOnGrid)) {
			passStep("Location " + location.getName() + " has been displayed on grid");
			passStep("Location creation is successful ...!!!");
		}

	}

}
