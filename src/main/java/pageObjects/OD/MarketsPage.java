package pageObjects.OD;

import org.openqa.selenium.By;

import components.BaseClass;
import dataModel.OD.Market;

/*
 * Class which contains the web elements and performs Markets page activities (methods)
 * 
 * Extends : BaseClass
 * 
 * Author : Venu Thota(venu.t@comakeit.com)
 */
public class MarketsPage extends BaseClass {

	// ****************** WEB ELEMENTS ****************************//
	By label_OperatorDashboard = By.xpath("//span[contains(text(),'Operator Dashboard')]");
	By label_Markets = By.xpath("//h2[contains(text(),'Markets')]");
	By button_New = By.xpath("//a[contains(text(),'New')]");
	By label_NewMarket = By.xpath("//h1[contains(text(),'New Market')]");
	By checkbox_market_visible = By.id("market_visible");
	By textbox_market_name = By.id("market_name");
	By dd_market_state = By.id("market_state");
	By textbox_market_latitude = By.id("market_latitude");
	By textbox_market_longitude = By.id("market_longitude");
	By button_create_market = By.xpath("//input[@value='Create Market']");

	// ****************** ACTIONS ****************************//

	/*
	 * Method to create a new Market
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public void create_Market(Market market) {
		waitForElementTobeDisplayed(button_New);
		clickOnButton(button_New, "Button new");
		waitForElementTobeDisplayed(label_NewMarket);
		if (market.getVisible().equalsIgnoreCase("True"))
			select_Checkbox(checkbox_market_visible, "Checkbox_Visible");
		enterText(textbox_market_name, market.getName(), "Market Name Textbox");
		selectDropdown(dd_market_state, market.getState(), "Market State dropdown");
		enterText(textbox_market_latitude, market.getLatitude(), "Market Lattitude Textbox");
		enterText(textbox_market_longitude, market.getLongitude(), "Market Longitude Textbox");
		clickOnButton(button_create_market, "Button Create Market");

		By marketNameOnMarketsGrid = By.xpath("//td[contains(text(),'" + market.getName() + "')]");
		waitForElementTobeDisplayed(marketNameOnMarketsGrid);
		if (isElementDisplayed(marketNameOnMarketsGrid)) {
			passStep("Market " + market.getName() + " has been displayed on grid");
			passStep("Market creation is successful ...!!!");
		}

	}

}
