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
public class HomePage extends BaseClass {

	// ****************** WEB ELEMENTS ****************************//
	By label_OperatorDashboard = By.xpath("//span[contains(text(),'Operator Dashboard')]");
	By dd_Manage = By.xpath("//a[contains(text(),'Manage')]");
	By link_BusinessAccounts = By.xpath("//a[@href='/businessaccounts']");
	By link_Markets = By.xpath("//a[normalize-space(text())='Markets']");
	By link_Locations = By.xpath("//a[normalize-space(text())='Locations']");
	By link_VirtualLocations = By.xpath("//a[normalize-space(text())='Virtual Locations']");
	By link_EventRates = By.xpath("//a[normalize-space(text())='Event Rates']");
	By link_Blackouts = By.xpath("//a[normalize-space(text())='Blackouts']");
	By link_PromoCodes = By.xpath("//a[normalize-space(text())='Promo Codes']");
	By link_Users = By.xpath("//a[normalize-space(text())='Users']");
	By link_Profiles = By.xpath("//a[normalize-space(text())='Profiles']");

	// ****************** ACTIONS ****************************//

	/*
	 * Method to navigate to Markets page from home page
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public MarketsPage navigateToMarketsPage() {
		waitForElementTobeDisplayed(dd_Manage);
		clickOnButton(dd_Manage, "Manage menu");
		clickOnButton(link_Markets, "Markets Link");
		MarketsPage marketsPage = new MarketsPage();
		waitForElementTobeDisplayed(marketsPage.label_Markets);
		if (isElementDisplayed(marketsPage.label_Markets)) {
			passStep("Markets page has been loaded");
		}
		return marketsPage;
	}

	/*
	 * Method to navigate to Locations page from home page
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public LocationsPage navigateToLocationsPage() {
		waitForElementTobeDisplayed(dd_Manage);
		clickOnButton(dd_Manage, "Manage menu");
		clickOnButton(link_Locations, "Locations Link");
		LocationsPage locationsPage = new LocationsPage();
		waitForElementTobeDisplayed(locationsPage.label_Locations);
		if (isElementDisplayed(locationsPage.label_Locations)) {
			passStep("Locations page has been loaded");
		}
		return locationsPage;
	}

	/*
	 * Method to navigate to profiles page from home page
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public ProfilesPage navigateToProfilesPage() {
		waitForElementTobeDisplayed(dd_Manage);
		clickOnButton(dd_Manage, "Manage menu");
		clickOnButton(link_Profiles, "Profiles sub-menu");
		return new ProfilesPage();
	}

	/*
	 * Method to navigate to BusinessAccounts page from home page
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public BusinessAccountsPage navigateToBusinessAccountsPage() {
		waitForElementTobeDisplayed(dd_Manage);
		clickOnButton(dd_Manage, "Manage menu");
		clickOnButton(link_BusinessAccounts, "Business Accounts sub-menu");
		return new BusinessAccountsPage();
	}

}
