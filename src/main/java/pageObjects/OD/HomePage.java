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
	By dd_Content = By.xpath("//li[contains(.,'Content')]");
	By link_Venues = By.xpath("//li//a[contains(.,'Venues')]");
	By link_Profiles = By.xpath("//a[@href='/profiles']");
	By link_BusinessAccounts = By.xpath("//a[@href='/businessaccounts']");
	By link_Marketts = By.xpath("//a[@href='/markets']");

	// ****************** ACTIONS ****************************//
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
	
	/*
	 * Method to navigate to Markets page from home page
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public MarketsPage navigateToMarketsPage() {
		waitForElementTobeDisplayed(dd_Manage);
		clickOnButton(dd_Manage, "Manage menu");
		clickOnButton(link_Marketts, "Markets");
		return new MarketsPage();
	}

	public VenuesPage navigateToVenuesPage() {
		waitForElementTobeDisplayed(dd_Content);
		clickOnButton(dd_Content, "Content menu");
		clickOnButton(link_Venues, "Venues");
		return new VenuesPage();
	}

}
