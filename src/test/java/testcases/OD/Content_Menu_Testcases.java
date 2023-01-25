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

	// ****************** TEST SCRIPTS ****************************//

	/*
	 * TC_01_Create_Venue
	 * TC_02_Create_Feature
	 * TC_03_Create_Help
	 * TC_04_Create_Job
	 * TC_05_Create_Setting
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


}
