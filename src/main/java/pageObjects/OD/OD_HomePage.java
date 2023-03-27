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
	By link_clients = By.xpath("//a[normalize-space(text())='Clients']");
	By link_fees = By.xpath("//a[normalize-space(text())='Fees']");
	By link_textPay_jobs = By.xpath("//a[normalize-space(text())='TextPay Jobs']");
	By link_glCodes = By.xpath("//a[normalize-space(text())='GL Codes']");
	By link_textPay_requests = By.xpath("//a[normalize-space(text())='TextPay Requests']");
	By link_roles = By.xpath("//a[normalize-space(text())='Roles']");
	By link_invoices = By.xpath("//a[normalize-space(text())='Invoices']");
	By link_partnerSales = By.xpath("//a[normalize-space(text())='Partner Sales']");
	By link_cashDeposits = By.xpath("//a[normalize-space(text())='Cash Deposits']");

	By dd_Content = By.xpath("//a[normalize-space()='Content']");
	By link_Venues = By.xpath("//a[normalize-space()='Venues']");
	By link_Features = By.xpath("//a[normalize-space()='Features']");
	By link_Banners = By.xpath("//a[normalize-space()='Banners']");
	By link_Help = By.xpath("//a[normalize-space()='Help']");
	By link_Jobs = By.xpath("//a[normalize-space()='Jobs']");
	By link_Settings = By.xpath("//a[normalize-space()='Settings']");
	By link_ColorThemes = By.xpath("//a[normalize-space()='Color Themes']");
	By link_ParkingOperators = By.xpath("//a[normalize-space()='Parking Operators']");
	By link_StaticPageGroups = By.xpath("//a[normalize-space()='Static Page Groups']");
	By link_ContactReasons = By.xpath("//a[normalize-space()='Contact Reasons']");
	By link_SupportArticles = By.xpath("//a[normalize-space()='Support Articles']");


	By dd_Reports = By.xpath("//a[normalize-space()='Reports']");
	By link_LocationRevenues = By.xpath("//a[normalize-space()='Location Revenues']");

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
	 * Method to navigate to Promo codes page from home page
	 *
	 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
	 */
	public OD_PromoCodesPage navigateToPromoCodesPage() {
		waitForElementTobeDisplayed(dd_Manage);
		clickOnButton(dd_Manage, "Manage menu");
		clickOnButton(link_PromoCodes, "Promo Codes Link");
		OD_PromoCodesPage promoCodePage = new OD_PromoCodesPage();
		waitForElementTobeDisplayed(promoCodePage.label_PromoCodes);
		if (isElementDisplayed(promoCodePage.label_PromoCodes)) {
			passStep("Promo codes page has been loaded");
		}
		return promoCodePage;
	}

	/*
	 * Method to navigate to Users page from home page
	 *
	 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
	 */
	public OD_UsersPage navigateToUsersPage() {
		waitForElementTobeDisplayed(dd_Manage);
		clickOnButton(dd_Manage, "Manage menu");
		clickOnButton(link_Users, "Users Link");
		OD_UsersPage usersPage = new OD_UsersPage();
		waitForElementTobeDisplayed(usersPage.label_Users);
		if (isElementDisplayed(usersPage.label_Users)) {
			passStep("Users page has been loaded");
		}
		return usersPage;
	}

	/*
	 * Method to navigate to Profiles page from home page
	 *
	 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
	 */
	public OD_ProfilesPage navigateToProfilesPage() {
		waitForElementTobeDisplayed(dd_Manage);
		clickOnButton(dd_Manage, "Manage menu");
		clickOnButton(link_Profiles, "Profiles Link");
		OD_ProfilesPage profilesPage = new OD_ProfilesPage();
		waitForElementTobeDisplayed(profilesPage.label_Profiles);
		if (isElementDisplayed(profilesPage.label_Profiles)) {
			passStep("Profiles page has been loaded");
		}
		return profilesPage;
	}

	/*
	 * Method to navigate to Clients page from home page
	 *
	 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
	 */
	public OD_ClientsPage navigateToClientsPage() {
		waitForElementTobeDisplayed(dd_Manage);
		clickOnButton(dd_Manage, "Manage menu");
		clickOnButton(link_clients, "Clients Link");
		OD_ClientsPage clientsPage = new OD_ClientsPage();
		waitForElementTobeDisplayed(clientsPage.label_Clients);
		if (isElementDisplayed(clientsPage.label_Clients)) {
			passStep("Clients page has been loaded");
		}
		return clientsPage;
	}

	/*
	 * Method to navigate to Fees page from home page
	 *
	 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
	 */
	public OD_FeesPage navigateToFeesPage() {
		waitForElementTobeDisplayed(dd_Manage);
		clickOnButton(dd_Manage, "Manage menu");
		clickOnButton(link_fees, "Fees Link");
		OD_FeesPage feesPage = new OD_FeesPage();
		waitForElementTobeDisplayed(feesPage.label_Fees);
		if (isElementDisplayed(feesPage.label_Fees)) {
			passStep("Fees page has been loaded");
		}
		return feesPage;
	}

	/*
	 * Method to navigate to Text Pay Jobs page from home page
	 *
	 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
	 */
	public OD_TextPayJobsPage navigateToTextPayJobsPage() {
		waitForElementTobeDisplayed(dd_Manage);
		clickOnButton(dd_Manage, "Manage menu");
		scrollToElement(link_textPay_jobs);
		clickOnButton(link_textPay_jobs, "Text Pay Jobs Link");
		OD_TextPayJobsPage textPayJobsPage = new OD_TextPayJobsPage();
		waitForElementTobeDisplayed(textPayJobsPage.label_TextPayJobs);
		if (isElementDisplayed(textPayJobsPage.label_TextPayJobs)) {
			passStep("Text Pay Jobs page has been loaded");
		}
		return textPayJobsPage;
	}

	/*
	 * Method to navigate to GL Codes page from home page
	 *
	 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
	 */
	public OD_GLCodesPage navigateToGLCodesPage() {
		waitForElementTobeDisplayed(dd_Manage);
		clickOnButton(dd_Manage, "Manage menu");
		scrollToElement(link_glCodes);
		clickOnButton(link_glCodes, "GL Codes Link");
		OD_GLCodesPage glCodesPage = new OD_GLCodesPage();
		waitForElementTobeDisplayed(glCodesPage.label_GLCodes);
		if (isElementDisplayed(glCodesPage.label_GLCodes)) {
			passStep("GL Codes page has been loaded");
		}
		return glCodesPage;
	}

	/*
	 * Method to navigate to Text Pay Requests page from home page
	 *
	 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
	 */
	public OD_TextPayRequestsPage navigateToTextPayRequestsPage() {
		waitForElementTobeDisplayed(dd_Manage);
		clickOnButton(dd_Manage, "Manage menu");
		scrollToElement(link_textPay_requests);
		clickOnButton(link_textPay_requests, "Text Pay Requests Link");
		OD_TextPayRequestsPage textPayRequestsPage = new OD_TextPayRequestsPage();
		waitForElementTobeDisplayed(textPayRequestsPage.label_TextPayRequests);
		if (isElementDisplayed(textPayRequestsPage.label_TextPayRequests)) {
			passStep("Text Pay Requests page has been loaded");
		}
		return textPayRequestsPage;
	}

	/*
	 * Method to navigate to Roles page from home page
	 *
	 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
	 */
	public OD_RolesPage navigateToRolesPage() {
		waitForElementTobeDisplayed(dd_Manage);
		clickOnButton(dd_Manage, "Manage menu");
		scrollToElement(link_roles);
		clickOnButton(link_roles, "Roles Link");
		OD_RolesPage rolesPage = new OD_RolesPage();
		waitForElementTobeDisplayed(rolesPage.label_Roles);
		if (isElementDisplayed(rolesPage.label_Roles)) {
			passStep("Roles page has been loaded");
		}
		return rolesPage;
	}

	/*
	 * Method to navigate to Invoices page from home page
	 *
	 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
	 */
	public OD_InvoicesPage navigateToInvoicesPage() {
		waitForElementTobeDisplayed(dd_Manage);
		clickOnButton(dd_Manage, "Manage menu");
		clickOnButton(link_invoices, "Invoices Link");
		OD_InvoicesPage invoicesPage = new OD_InvoicesPage();
		waitForElementTobeDisplayed(invoicesPage.label_Invoices);
		if (isElementDisplayed(invoicesPage.label_Invoices)) {
			passStep("Invoices page has been loaded");
		}
		return invoicesPage;
	}

	/*
	 * Method to navigate to partner sales page from home page
	 *
	 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
	 */
	public OD_PartnerSalesPage navigateToPartnerSalesPage() {
		waitForElementTobeDisplayed(dd_Manage);
		clickOnButton(dd_Manage, "Manage menu");
		scrollToElement(link_partnerSales);
		clickOnButton(link_partnerSales, "Partner Sales Link");
		OD_PartnerSalesPage partnerSalesPage = new OD_PartnerSalesPage();
		waitForElementTobeDisplayed(partnerSalesPage.label_PartnerSales);
		if (isElementDisplayed(partnerSalesPage.label_PartnerSales)) {
			passStep("Partner Sales page has been loaded");
		}
		return partnerSalesPage;
	}

	/*
	 * Method to navigate to partner cash deposits page from home page
	 *
	 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
	 */
	public OD_CashDepositsPage navigateToCashDepositsPage() {
		waitForElementTobeDisplayed(dd_Manage);
		clickOnButton(dd_Manage, "Manage menu");
		scrollToElement(link_cashDeposits);
		clickOnButton(link_cashDeposits, "Cash Deposits Link");
		OD_CashDepositsPage cashDepositsPage = new OD_CashDepositsPage();
		waitForElementTobeDisplayed(cashDepositsPage.label_CashDeposits);
		if (isElementDisplayed(cashDepositsPage.label_CashDeposits)) {
			passStep("Cash Deposits page has been loaded");
		}
		return cashDepositsPage;
	}

	/*
	 * Method to navigate to profiles page from home page
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public OD_BulkProfilesPage navigateToBulkProfilesPage() {
		waitForElementTobeDisplayed(dd_Manage);
		clickOnButton(dd_Manage, "Manage menu");
		clickOnButton(link_Profiles, "Profiles sub-menu");
		return new OD_BulkProfilesPage();
	}

	/*
	 * Method to navigate to Virtual Locations page from home page
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public OD_BulkPromoCodesPage navigateToBulkPromoCodesPage() {
		waitForElementTobeDisplayed(dd_Manage);
		clickOnButton(dd_Manage, "Manage menu");
		clickOnButton(link_PromoCodes, "menu : " + getElementText(link_PromoCodes));
		OD_BulkPromoCodesPage promoCodePage = new OD_BulkPromoCodesPage();
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

	/*
	 * Method to navigate to Features page from home page
	 *
	 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
	 */
	public OD_FeaturesPage navigateToFeaturesPage() {
		waitForElementTobeDisplayed(dd_Content);
		clickOnButton(dd_Content, "Content menu");
		clickOnButton(link_Features, "Features Link");
		OD_FeaturesPage featuresPage = new OD_FeaturesPage();
		waitForElementTobeDisplayed(featuresPage.label_Features);
		if (isElementDisplayed(featuresPage.label_Features)) {
			passStep("Features page has been loaded");
		}
		return featuresPage;
	}

	/*
	 * Method to navigate to Help page from home page
	 *
	 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
	 */
	public OD_HelpPage navigateToHelpPage() {
		waitForElementTobeDisplayed(dd_Content);
		clickOnButton(dd_Content, "Content menu");
		clickOnButton(link_Help, "Help Link");
		OD_HelpPage helpPage = new OD_HelpPage();
		waitForElementTobeDisplayed(helpPage.label_Helps);
		if (isElementDisplayed(helpPage.label_Helps)) {
			passStep("Features page has been loaded");
		}
		return helpPage;
	}

	/*
	 * Method to navigate to Jobs page from home page
	 *
	 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
	 */
	public OD_JobsPage navigateToJobsPage() {
		waitForElementTobeDisplayed(dd_Content);
		clickOnButton(dd_Content, "Content menu");
		clickOnButton(link_Jobs, "Jobs Link");
		OD_JobsPage jobsPage = new OD_JobsPage();
		waitForElementTobeDisplayed(jobsPage.label_Jobs);
		if (isElementDisplayed(jobsPage.label_Jobs)) {
			passStep("Jobs page has been loaded");
		}
		return jobsPage;
	}

	/*
	 * Method to navigate to Settings page from home page
	 *
	 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
	 */
	public OD_SettingsPage navigateToSettingsPage() {
		waitForElementTobeDisplayed(dd_Content);
		clickOnButton(dd_Content, "Content menu");
		clickOnButton(link_Settings, "Settings Link");
		OD_SettingsPage settingsPage = new OD_SettingsPage();
		waitForElementTobeDisplayed(settingsPage.label_Settings);
		if (isElementDisplayed(settingsPage.label_Settings)) {
			passStep("Settings page has been loaded");
		}
		return settingsPage;
	}

	/*
	 * Method to navigate to Banners page from home page
	 *
	 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
	 */
	public OD_BannersPage navigateToBannersPage() {
		waitForElementTobeDisplayed(dd_Content);
		clickOnButton(dd_Content, "Content menu");
		clickOnButton(link_Banners, "Banners Link");
		OD_BannersPage bannersPage = new OD_BannersPage();
		waitForElementTobeDisplayed(bannersPage.label_Banners);
		if (isElementDisplayed(bannersPage.label_Banners)) {
			passStep("Banners page has been loaded");
		}
		return bannersPage;
	}

	/*
	 * Method to navigate to Color Themes page from home page
	 *
	 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
	 */
	public OD_ColorThemesPage navigateToColorThemesPage() {
		waitForElementTobeDisplayed(dd_Content);
		clickOnButton(dd_Content, "Content menu");
		clickOnButton(link_ColorThemes, "Color Themes Link");
		OD_ColorThemesPage colorThemesPage = new OD_ColorThemesPage();
		waitForElementTobeDisplayed(colorThemesPage.label_ColorThemes);
		if (isElementDisplayed(colorThemesPage.label_ColorThemes)) {
			passStep("Color Themes Page has been loaded");
		}
		return colorThemesPage;
	}

	/*
	 * Method to navigate to Parking Operators page from home page
	 *
	 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
	 */
	public OD_ParkingOperatorsPage navigateToParkingOperatorsPage() {
		waitForElementTobeDisplayed(dd_Content);
		clickOnButton(dd_Content, "Content menu");
		clickOnButton(link_ParkingOperators, "Parking Operators Link");
		OD_ParkingOperatorsPage parkingOperatorsPage = new OD_ParkingOperatorsPage();
		waitForElementTobeDisplayed(parkingOperatorsPage.label_ParkingOperators);
		if (isElementDisplayed(parkingOperatorsPage.label_ParkingOperators)) {
			passStep("Parking Operators Page has been loaded");
		}
		return parkingOperatorsPage;
	}

	/*
	 * Method to navigate to Static Page Groups page from home page
	 *
	 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
	 */
	public OD_StaticPageGroupsPage navigateToStaticPageGroupsPage() {
		waitForElementTobeDisplayed(dd_Content);
		clickOnButton(dd_Content, "Content menu");
		clickOnButton(link_StaticPageGroups, "Static Page Groups Link");
		OD_StaticPageGroupsPage staticPageGroupsPage = new OD_StaticPageGroupsPage();
		waitForElementTobeDisplayed(staticPageGroupsPage.label_StaticPageGroup);
		if (isElementDisplayed(staticPageGroupsPage.label_StaticPageGroup)) {
			passStep("Static Page Groups Page has been loaded");
		}
		return staticPageGroupsPage;
	}

	/*
	 * Method to navigate to contact reasons page from home page
	 *
	 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
	 */
	public OD_ContactReasonsPage navigateToContactReasonsPage() {
		waitForElementTobeDisplayed(dd_Content);
		clickOnButton(dd_Content, "Content menu");
		clickOnButton(link_ContactReasons, "Contact Reasons Link");
		OD_ContactReasonsPage contactReasonsPage = new OD_ContactReasonsPage();
		waitForElementTobeDisplayed(contactReasonsPage.label_ContactReasons);
		if (isElementDisplayed(contactReasonsPage.label_ContactReasons)) {
			passStep("Contact Reasons Page has been loaded");
		}
		return contactReasonsPage;
	}

	/*
	 * Method to navigate to support articles page from home page
	 *
	 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
	 */
	public OD_SupportArticlesPage navigateToSupportArticlesPage() {
		waitForElementTobeDisplayed(dd_Content);
		clickOnButton(dd_Content, "Content menu");
		clickOnButton(link_SupportArticles, "Support Articles Link");
		OD_SupportArticlesPage supportArticlesPage = new OD_SupportArticlesPage();
		waitForElementTobeDisplayed(supportArticlesPage.label_SupportArticles);
		if (isElementDisplayed(supportArticlesPage.label_SupportArticles)) {
			passStep("Support Articles Page has been loaded");
		}
		return supportArticlesPage;
	}

	/*
	 * Method to navigate to Location Revenue Page under reports
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public OD_LocationRevenuePage navigateToLocationRevenuePage() {
		waitForElementTobeDisplayed(dd_Reports);
		clickOnButton(dd_Reports, "Reports menu");
		clickOnButton(link_LocationRevenues, "Location Revenues sub-menu");
		OD_LocationRevenuePage loc_Rev_Page = new OD_LocationRevenuePage();
		waitForElementTobeDisplayed(loc_Rev_Page.label_LocationRevenues);
		return loc_Rev_Page;
	}

}
