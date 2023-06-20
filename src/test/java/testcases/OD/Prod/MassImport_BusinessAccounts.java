package testcases.OD.Prod;

import java.util.List;

import org.testng.annotations.Test;

import components.BaseClass;
import dataModel.OD.Profile_Bulk;
import pageObjects.OD.OD_BusinessAccountsPage;
import pageObjects.OD.OD_HomePage;
import pageObjects.OD.OD_LoginPage;
import pageObjects.OD.OD_BulkProfilesPage;
import utils.Excel_Operations;

/*
 * Class which contains the actual test scripts 
 * 
 * Extends : BaseClass
 * 
 * Author : Venu Thota(venu.t@comakeit.com)
 */
public class MassImport_BusinessAccounts extends BaseClass {

	// ****************** CLASS INSTANCES ****************************//
	OD_HomePage homePage = new OD_HomePage();
	OD_BulkProfilesPage profilePage = new OD_BulkProfilesPage();
	Excel_Operations excel_Ops = new Excel_Operations();
	OD_LoginPage loginPage = new OD_LoginPage();
	OD_BusinessAccountsPage businessAccountsPage = new OD_BusinessAccountsPage();

	List<Profile_Bulk> profiles;
	// String fileName = "AnnapolisResidentPermits_2022_2023_Initial.xlsx";
	String fileName = "//prod//WestHavenPlatelist_P2232.xlsx";

	// ****************** TEST SCRIPTS ****************************//
	/*
	 * This is a test case to create profile
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	//@Test(priority = 1)
	public void TC_01_CreateProfile() {
		loginPage = launch_OD_Application();
		homePage = loginPage.login();
		profilePage = homePage.navigateToBulkProfilesPage();
		List<Profile_Bulk> profiles = excel_Ops.load_ProfilesData_From_ExcelSheet(fileName, "1st100");
		if (profiles != null) {
			for (Profile_Bulk profile : profiles) {
				// if (!profilePage.isPrfileExist(profile.getEmail())) {
				profilePage.createProfile(profile);
				// }
			}
		}
	}

	/*
	 * This is a test case imporsonate Business Account
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	//@Test(priority = 2)
	public void TC_02_ImpersonateBusinessAccount() {
		loginPage = launch_OD_Application();
		homePage = loginPage.login();
		businessAccountsPage = homePage.navigateToBusinessAccountsPage();
		// List<String> sheets = excel_Ops.get_Total_Sheets(fileName);
		List<Profile_Bulk> profiles = excel_Ops.load_ProfilesData_From_ExcelSheet(fileName, "1st100");
		if (businessAccountsPage.isBusinessAccountExist("6548")) {
			// West Haven Rocks -> 6548
			businessAccountsPage.imporsonateBusinessAccount(profiles.get(0));
			for (Profile_Bulk profile : profiles) {
				if (!businessAccountsPage.isMember_Exist(profile)) {
					businessAccountsPage.add_Member(profile);
				}
				if (businessAccountsPage.isMember_Not_Activated()) {
					if (businessAccountsPage.is_CopyLink_displayed()) {
						businessAccountsPage.activate_Member(profile);
						// businessAccountsPage.navigate_To_BusinessAcounts_Page();
					} else {
						businessAccountsPage.add_Vehicle(profile.getLpNumber());
					}
				}
			}
		}
	}

	/*
	 * 
	 * This is a test case to validate the license plates of business account Author
	 * : Venu Thota(venu.t@comakeit.com)
	 * 
	 */

	//@Test(priority = 3)
	public void TC_03_ValidateLicensePlate() {
		loginPage = launch_OD_Application();
		homePage = loginPage.login();
		businessAccountsPage = homePage.navigateToBusinessAccountsPage();
		// List<String> sheets = excel_Ops.get_Total_Sheets(fileName);
		List<Profile_Bulk> profiles = excel_Ops.load_ProfilesData_From_ExcelSheet(fileName, "original");
		if (businessAccountsPage.isBusinessAccountExist("6548")) {
			// West Haven Rocks -> 6548
			businessAccountsPage.imporsonateBusinessAccount(profiles.get(0));
			businessAccountsPage.validateLicensePlate(profiles);
		}
	}
	
	@Test(priority = 4)
	public void TC_04_ValidateLicensePlate() {
		loginPage = launch_OD_Application();
		homePage = loginPage.login();
		businessAccountsPage = homePage.navigateToBusinessAccountsPage();
		// List<String> sheets = excel_Ops.get_Total_Sheets(fileName);
		List<Profile_Bulk> profiles = excel_Ops.load_ProfilesData_From_ExcelSheet(fileName, "2ndHalf_1");
		if (businessAccountsPage.isBusinessAccountExist("6548")) {
			// West Haven Rocks -> 6548
			businessAccountsPage.imporsonateBusinessAccount(profiles.get(0));
			businessAccountsPage.validateLicensePlate(profiles);
		}
	}
	
		
	@Test(priority = 5)
	public void TC_05_ValidateLicensePlate() {
		loginPage = launch_OD_Application();
		homePage = loginPage.login();
		businessAccountsPage = homePage.navigateToBusinessAccountsPage();
		// List<String> sheets = excel_Ops.get_Total_Sheets(fileName);
		List<Profile_Bulk> profiles = excel_Ops.load_ProfilesData_From_ExcelSheet(fileName, "2ndHalf_2");
		if (businessAccountsPage.isBusinessAccountExist("6548")) {
			// West Haven Rocks -> 6548
			businessAccountsPage.imporsonateBusinessAccount(profiles.get(0));
			businessAccountsPage.validateLicensePlate(profiles);
		}
	}
	
	@Test(priority = 6)
	public void TC_06_ValidateLicensePlate() {
		loginPage = launch_OD_Application();
		homePage = loginPage.login();
		businessAccountsPage = homePage.navigateToBusinessAccountsPage();
		// List<String> sheets = excel_Ops.get_Total_Sheets(fileName);
		List<Profile_Bulk> profiles = excel_Ops.load_ProfilesData_From_ExcelSheet(fileName, "2ndHalf_3");
		if (businessAccountsPage.isBusinessAccountExist("6548")) {
			// West Haven Rocks -> 6548
			businessAccountsPage.imporsonateBusinessAccount(profiles.get(0));
			businessAccountsPage.validateLicensePlate(profiles);
		}
	}
	
	@Test(priority = 7)
	public void TC_07_ValidateLicensePlate() {
		loginPage = launch_OD_Application();
		homePage = loginPage.login();
		businessAccountsPage = homePage.navigateToBusinessAccountsPage();
		// List<String> sheets = excel_Ops.get_Total_Sheets(fileName);
		List<Profile_Bulk> profiles = excel_Ops.load_ProfilesData_From_ExcelSheet(fileName, "2ndHalf_4");
		if (businessAccountsPage.isBusinessAccountExist("6548")) {
			// West Haven Rocks -> 6548
			businessAccountsPage.imporsonateBusinessAccount(profiles.get(0));
			businessAccountsPage.validateLicensePlate(profiles);
		}
	}
}
