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
public class OD_HomePage extends BaseClass {

	// ****************** WEB ELEMENTS ****************************//
	By label_OperatorDashboard = By.xpath("//span[contains(text(),'Operator Dashboard')]");
	By dd_Manage = By.xpath("//a[contains(text(),'Manage')]");
	By link_BusinessAccounts = By.xpath("//a[@href='/businessaccounts']");
	By link_Markets = By.xpath("//a[normalize-space(text())='Markets']");
	By link_Locations = By.xpath("//a[normalize-space(text())='Locations']");
	By link_VirtualLocations = By.xpath("//a[normalize-space(text())='Virtual Locations']");
	By link_EventRates = By.xpath("//a[normalize-space(text())='Event Rates']");
	By link_Blackouts = By.xpath("//a[normalize-space(text())='Blackouts']");
	By link_Whitelist = By.xpath("//a[normalize-space(text())='Whitelist']");
	By link_PromoCodes = By.xpath("//a[normalize-space(text())='Promo Codes']");
	By link_Users = By.xpath("//a[normalize-space(text())='Users']");
	By link_Profiles = By.xpath("//a[normalize-space(text())='Profiles']");

	By dd_Content = By.xpath("//a[normalize-space()='Content']");
	By link_Venues = By.xpath("//a[normalize-space()='Venues']");

	// ****************** ACTIONS ****************************//

	/*
	 * Method to navigate to Markets page from home page
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public OD_MarketsPage navigateToMarketsPage() {
		waitForElementTobeDisplayed(dd_Manage);
		clickOnButton(dd_Manage, "Manage menu");
		clickOnButton(link_Markets, "Markets Link");
		OD_MarketsPage marketsPage = new OD_MarketsPage();
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
	public OD_LocationsPage navigateToLocationsPage() {
		waitForElementTobeDisplayed(dd_Manage);
		clickOnButton(dd_Manage, "Manage menu");
		clickOnButton(link_Locations, "Locations Link");
		OD_LocationsPage locationsPage = new OD_LocationsPage();
		waitForElementTobeDisplayed(locationsPage.label_Locations);
		if (isElementDisplayed(locationsPage.label_Locations)) {
			passStep("Locations page has been loaded");
		}
		return locationsPage;
	}

	/*
	 * Method to navigate to Virtual Locations page from home page
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public OD_VirtualLocationsPage navigateToVirtualLocationsPage() {
		waitForElementTobeDisplayed(dd_Manage);
		clickOnButton(dd_Manage, "Manage menu");
		clickOnButton(link_VirtualLocations, "Virtul Locations Link");
		OD_VirtualLocationsPage v_locationsPage = new OD_VirtualLocationsPage();
		waitForElementTobeDisplayed(v_locationsPage.label_VirtualLocations);
		if (isElementDisplayed(v_locationsPage.label_VirtualLocations)) {
			passStep("Virtual Locations page has been loaded");
		}
		return v_locationsPage;
	}

	/*
	 * Method to navigate to Event Rates page from home page
	 *
	 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
	 */
	public OD_EventRatesPage navigateToEventRatesPage() {
		waitForElementTobeDisplayed(dd_Manage);
		clickOnButton(dd_Manage, "Manage menu");
		clickOnButton(link_EventRates, "Event Rates Link");
		OD_EventRatesPage eventRatesPage = new OD_EventRatesPage();
		waitForElementTobeDisplayed(eventRatesPage.label_EventRates);
		if (isElementDisplayed(eventRatesPage.label_EventRates)) {
			passStep("Event Rates page has been loaded");
		}
		return eventRatesPage;
	}

	/*
	 * Method to navigate to Blackouts page from home page
	 *
	 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
	 */
	public OD_BlackoutsPage navigateToBlackoutsPage() {
		waitForElementTobeDisplayed(dd_Manage);
		clickOnButton(dd_Manage, "Manage menu");
		clickOnButton(link_Blackouts, "Blackouts Link");
		OD_BlackoutsPage blackoutsPage = new OD_BlackoutsPage();
		waitForElementTobeDisplayed(blackoutsPage.label_Blackouts);
		if (isElementDisplayed(blackoutsPage.label_Blackouts)) {
			passStep("Blackouts page has been loaded");
		}
		return blackoutsPage;
	}

	/*
	 * Method to navigate to Whitelists page from home page
	 *
	 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
	 */
	public OD_WhitelistPage navigateToWhitelistsPage() {
		waitForElementTobeDisplayed(dd_Manage);
		clickOnButton(dd_Manage, "Manage menu");
		clickOnButton(link_Whitelist, "Whitelist Link");
		OD_WhitelistPage whitelistPage = new OD_WhitelistPage();
		waitForElementTobeDisplayed(whitelistPage.label_Whitelists);
		if (isElementDisplayed(whitelistPage.label_Whitelists)) {
			passStep("Whitelists page has been loaded");
		}
		return whitelistPage;
	}

	/*
	 * Method to navigate to profiles page from home page
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public OD_ProfilesPage navigateToProfilesPage() {
		waitForElementTobeDisplayed(dd_Manage);
		clickOnButton(dd_Manage, "Manage menu");
		clickOnButton(link_Profiles, "Profiles sub-menu");
		return new OD_ProfilesPage();
	}

	/*
	 * Method to navigate to Virtual Locations page from home page
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public OD_PromoCodesPage navigateToPromoCodesPage() {
		waitForElementTobeDisplayed(dd_Manage);
		clickOnButton(dd_Manage, "Manage menu");
		clickOnButton(link_PromoCodes, "menu : " + getElementText(link_PromoCodes));
		OD_PromoCodesPage promoCodePage = new OD_PromoCodesPage();
		waitForElementTobeDisplayed(promoCodePage.label_PromoCodes);
		if (isElementDisplayed(promoCodePage.label_PromoCodes)) {
			passStep("Promo Codes page has been loaded");
		}
		return promoCodePage;
	}

	/*
	 * Method to navigate to BusinessAccounts page from home page
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public OD_BusinessAccountsPage navigateToBusinessAccountsPage() {
		waitForElementTobeDisplayed(dd_Manage);
		clickOnButton(dd_Manage, "Manage menu");
		clickOnButton(link_BusinessAccounts, "Business Accounts sub-menu");
		return new OD_BusinessAccountsPage();
	}

	/*
	 * Method to navigate to Venues page from home page
	 * 
	 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
	 */
	public OD_VenuesPage navigateToVenuesPage() {
		waitForElementTobeDisplayed(dd_Content);
		clickOnButton(dd_Content, "Content menu");
		clickOnButton(link_Venues, "Venues Link");
		OD_VenuesPage venuesPage = new OD_VenuesPage();
		waitForElementTobeDisplayed(venuesPage.label_Venues);
		if (isElementDisplayed(venuesPage.label_Venues)) {
			passStep("Venues page has been loaded");
		}
		return venuesPage;
	}

}
