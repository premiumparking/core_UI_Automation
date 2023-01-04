package pageObjects.TextPay;

import components.BaseClass;
import dataModel.TextPay.Guest;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;

/*
 * Class which contains the web elements and performs Home page activities (methods)
 *
 * Extends : BaseClass
 *
 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
 */
public class TextPay_HomePage extends BaseClass {

	// ****************** WEB ELEMENTS ****************************//

	public By link_Guest = By.xpath("//a[normalize-space()='Continue as a Guest']");
	public By location_searchBox = By.xpath("//input[@data-testid='test-search-input']");
	public By location_searchResult = By.xpath("//button[@data-testid='test-location-search-result']");
	public By textBox_LicencePlate = By.xpath("//input[@id='license-plate-number']");
	public By dd_LicenceState = By.xpath("//select[@id='plate-state-select']");
	public By label_StateOnFrame = By.xpath("//div[@data-testid='test-plate-state-frame']");
	public By label_PlateOnFrame = By.xpath("//div[@data-testid='test-plate-number-frame']");
	public By button_Continue = By.xpath("//button[normalize-space()='Continue']");
	public By button_RegularSpace = By.xpath("//strong[normalize-space()='Regular Space']");
	public By button_StarSpace = By.xpath("//strong[normalize-space()='Star Space']]");
	public By button_ChargingSpace = By.xpath("//strong[normalize-space()='Charging Space']");
	public By button_ViewRate = By.xpath("//button[normalize-space()='View Rate']");
	public By label_Time = By.xpath("//span[@data-testid='test-time-unit']");
	public By label_Cost = By.xpath("//span[normalize-space()='Total']/following-sibling::span");
	
	
	
	public String timeBar_ID ="custom-duration";

	/*
	 * Method to navigate to Location Page
	 *
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public void purchase_Session_AsGuest(Guest guest) {
		clickOnButton(link_Guest);
		waitForElementTobeClickable(location_searchBox);
		enterText(location_searchBox, guest.getLocationNumber(), "Location Searchbox");
		waitForElementTobeClickable(location_searchResult);
		clickOnButton(location_searchResult, getElementText(location_searchResult));
		enterText(textBox_LicencePlate, guest.getLicensePlateNumber(), "Licence Plate box");
		selectDropdown(dd_LicenceState, guest.getState(), "Licence State dropdown");
		String state = guest.getState().split("-")[1].trim().toUpperCase(); // AK - Alaska --> ALASKA
		assertEquals(getElementText(label_StateOnFrame), state);
		assertEquals(getElementText(label_PlateOnFrame), guest.getLicensePlateNumber());
		clickOnButton(button_Continue,"Contine button");
		if(guest.getParkingType().equalsIgnoreCase("Regular Space")) {
			waitForElementTobeClickable(button_RegularSpace);
			clickOnButton(button_RegularSpace, "Regular Space");
			waitForPageLoad(3);
			changeTime(timeBar_ID, guest.getTimeInHours());
			clickOnButton(button_ViewRate,"View Rate button");
			waitForElementTobeClickable(label_Time);
			assertEquals(getElementText(label_Time), guest.getTimeInHours()+" Hours");
			guest.setAmount(getElementText(label_Cost));
			clickOnButton(button_Continue,"continue button");
		}
	}

}
