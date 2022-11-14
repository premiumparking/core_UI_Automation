package testcases;

import org.testng.annotations.Test;

import components.BaseClass;
import components.Constants;
import dataModel.Operator;
import pageObjects.HomePage;
import pageObjects.LocationManagementPage;

public class Location_Management extends BaseClass {

	Operator operator = getOperatorTestData();
	HomePage homePage = new HomePage();
	LocationManagementPage locationManagementPage = new LocationManagementPage();

	@Test
	public void TC_01_CreateLocation_as_PP_Operator_and_DefaultRates() {
		homePage = launchApplication();
		locationManagementPage = homePage.navigateToLocationManagement();
		String locName = locationManagementPage.createLocation(Constants.PREMIUMPARKING, Constants.DEFAULT);
		locationManagementPage.verifyPNumberOnGrid_AfterLocationCreation(locName);

	}

	@Test
	public void TC_02_CreateLocation_as_PP_Operator_and_EVRates() {
		homePage = launchApplication();
		locationManagementPage = homePage.navigateToLocationManagement();
		String locName = locationManagementPage.createLocation(Constants.PREMIUMPARKING, Constants.EV_RATES);
		locationManagementPage.verifyPNumberOnGrid_AfterLocationCreation(locName);

	}

	@Test
	public void TC_03_CreateLocation_as_Other_Operator_and_DefaultRates() {
		homePage = launchApplication();
		locationManagementPage = homePage.navigateToLocationManagement();
		String locName = locationManagementPage.createLocation(Constants.ABC_PARKING, Constants.DEFAULT);
		locationManagementPage.verifyPNumberOnGrid_AfterLocationCreation(locName);

	}

	@Test
	public void TC_04_CreateLocation_as_Other_Operator_and_EVRates() {
		homePage = launchApplication();
		locationManagementPage = homePage.navigateToLocationManagement();
		String locName = locationManagementPage.createLocation(Constants.SPPLUS, Constants.EV_RATES);
		locationManagementPage.verifyPNumberOnGrid_AfterLocationCreation(locName);

	}

	@Test
	public void TC_05_ExportLocation_csv() {
		homePage = launchApplication();
		locationManagementPage = homePage.navigateToLocationManagement();
		locationManagementPage.exportLocation(Constants.CSV);

	}

	@Test
	public void TC_06_ExportLocation_xlsx() {
		homePage = launchApplication();
		locationManagementPage = homePage.navigateToLocationManagement();
		locationManagementPage.exportLocation(Constants.XLSX);

	}

	@Test
	public void TC_07_ExportLocation_pdf() {
		homePage = launchApplication();
		locationManagementPage = homePage.navigateToLocationManagement();
		locationManagementPage.exportLocation(Constants.PDF);

	}

	@Test
	public void TC_08_ExportLocation_txt() {
		homePage = launchApplication();
		locationManagementPage = homePage.navigateToLocationManagement();
		locationManagementPage.exportLocation(Constants.TXT);

	}

}
