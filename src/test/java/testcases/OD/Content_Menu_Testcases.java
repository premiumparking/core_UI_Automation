package testcases.OD;

import dataModel.OD.*;
import org.testng.annotations.Test;

import components.BaseClass;
import pageObjects.OD.*;
import utils.XML_Operations;

public class Content_Menu_Testcases extends BaseClass {
	// ****************** CLASS INSTANCES ****************************//
	XML_Operations xml_Ops = new XML_Operations();
	OD_HomePage homePage = new OD_HomePage();
	OD_LoginPage loginPage = new OD_LoginPage();
	OD_MarketsPage marketsPage = new OD_MarketsPage();
	OD_VenuesPage venuesPage = new OD_VenuesPage();
	OD_FeaturesPage featuresPage = new OD_FeaturesPage();
	OD_HelpPage helpPage = new OD_HelpPage();
	OD_JobsPage jobsPage = new OD_JobsPage();
	OD_SettingsPage settingsPage = new OD_SettingsPage();
	OD_BannersPage bannersPage = new OD_BannersPage();
	OD_ColorThemesPage colorThemesPage = new OD_ColorThemesPage();
	OD_ParkingOperatorsPage parkingOperatorsPage = new OD_ParkingOperatorsPage();
	OD_StaticPageGroupsPage staticPageGroupsPage = new OD_StaticPageGroupsPage();
	OD_ContactReasonsPage contactReasonsPage = new OD_ContactReasonsPage();
	OD_SupportArticlesPage supportArticlesPage = new OD_SupportArticlesPage();


	// ****************** TEST SCRIPTS ****************************//

	/*
	 * TC_01_Create_Venue
	 * TC_02_Create_Feature
	 * TC_03_Create_Help
	 * TC_04_Create_Job
	 * TC_05_Create_Setting
	 * TC_06_Create_Banner
	 * TC_07_Create_Color_Theme
	 * TC_08_Create_Parking_Operator
	 * TC_09_Create_Static_Page_Group
	 * TC_10_Create_Contact_Reason
	 * TC_11_Create_Support_Article
	 *
	 */

	/*
	 * This is a test case to create venue
	 *
	 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_01_Create_Venue() {

		loginPage = launch_OD_Application();
		homePage = loginPage.login();
		venuesPage = homePage.navigateToVenuesPage();
		Venue venue = (Venue) xml_Ops.getTestData("venue");
		venue.setName(venue.getName() + getTimestamp());
		venuesPage.create_Venue(venue);
	}

	/*
	 * This is a test case to create feature
	 *
	 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_02_Create_Feature() {

		loginPage = launch_OD_Application();
		homePage = loginPage.login();
		featuresPage = homePage.navigateToFeaturesPage();
		Feature feature = (Feature) xml_Ops.getTestData("feature");
		feature.setFeatureTitle(feature.getFeatureTitle() + getTimestamp());
		featuresPage.create_Feature(feature);
	}

	/*
	 * This is a test case to create help request
	 *
	 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_03_Create_Help() {

		loginPage = launch_OD_Application();
		homePage = loginPage.login();
		helpPage = homePage.navigateToHelpPage();
		String help_title = "Test_Title_" + getTimestamp();
		helpPage.create_HelpRequest(help_title);
	}

	/*
	 * This is a test case to create job
	 *
	 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_04_Create_Job() {

		loginPage = launch_OD_Application();
		homePage = loginPage.login();
		jobsPage = homePage.navigateToJobsPage();
		Job job = (Job) xml_Ops.getTestData("job");
		job.setJobTitle(job.getJobTitle() + getTimestamp());
		job.setJobLocation(getRandomLocation());
		jobsPage.create_Job(job);
	}

	/*
	 * This is a test case to create setting
	 *
	 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_05_Create_Setting() {

		loginPage = launch_OD_Application();
		homePage = loginPage.login();
		settingsPage = homePage.navigateToSettingsPage();
		String setting_key = "Test_Settings_" + getTimestamp();
		settingsPage.create_Setting(setting_key);
	}

	/*
	 * This is a test case to create banner
	 *
	 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_06_Create_Banner() {

		loginPage = launch_OD_Application();
		homePage = loginPage.login();
		bannersPage = homePage.navigateToBannersPage();
		Banner banner = (Banner) xml_Ops.getTestData("banner");
		banner.setBannerStartsAt(getTimestamp());
		banner.setBannerTitle(banner.getBannerTitle() + getTimestamp());
		bannersPage.create_Banner(banner);
	}

	/*
	 * This is a test case to create color theme
	 *
	 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_07_Create_Color_Theme() {

		loginPage = launch_OD_Application();
		homePage = loginPage.login();
		colorThemesPage = homePage.navigateToColorThemesPage();
		ColorTheme colorTheme = (ColorTheme) xml_Ops.getTestData("color_theme");
		colorTheme.setThemeName(colorTheme.getThemeName() + getTimestamp());
		colorThemesPage.create_ColorTheme(colorTheme);
	}

	/*
	 * This is a test case to create parking operator
	 *
	 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_08_Create_Parking_Operator() {

		loginPage = launch_OD_Application();
		homePage = loginPage.login();
		parkingOperatorsPage = homePage.navigateToParkingOperatorsPage();
		String name = "Test_Parking_Operator_" + getTimestamp();
		String locations = getRandomLocation();
		parkingOperatorsPage.create_ParkingOperator(name, locations);

	}

	/*
	 * This is a test case to create static page group
	 *
	 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_09_Create_Static_Page_Group() {

		loginPage = launch_OD_Application();
		homePage = loginPage.login();
		staticPageGroupsPage = homePage.navigateToStaticPageGroupsPage();
		String title = "Test_Static_Page_Group_" + getTimestamp();
		String slug = "Test-static-group-" + getTimestamp();
		staticPageGroupsPage.create_staticPageGroup(title, slug);

	}

	/*
	 * This is a test case to create contact reason
	 *
	 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_10_Create_Contact_Reason() {

		loginPage = launch_OD_Application();
		homePage = loginPage.login();
		contactReasonsPage = homePage.navigateToContactReasonsPage();
		String label = "Test_Contact_Reason_" + getTimestamp();
		contactReasonsPage.create_contactReason(label);
	}

	/*
	 * This is a test case to create support article
	 *
	 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
	 */
	@Test(groups = { "smoke", "regression" })
	public void TC_11_Create_Support_Article() {

		loginPage = launch_OD_Application();
		homePage = loginPage.login();
		supportArticlesPage = homePage.navigateToSupportArticlesPage();
		String title = "Test_Support_Article_" + getTimestamp();
		supportArticlesPage.create_supportArticle(title);
	}

}
