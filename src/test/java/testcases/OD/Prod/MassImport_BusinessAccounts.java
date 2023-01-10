package testcases.OD.Prod;

import java.util.List;

import org.testng.annotations.Test;

import components.BaseClass;
import dataModel.OD.Profile_Bulk;
import pageObjects.OD.OD_BusinessAccountsPage;
import pageObjects.OD.OD_HomePage;
import pageObjects.OD.OD_LoginPage;
import pageObjects.OD.OD_ProfilesPage;
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
	OD_ProfilesPage profilePage = new OD_ProfilesPage();
	Excel_Operations excel_Ops = new Excel_Operations();
	OD_LoginPage loginPage = new OD_LoginPage();
	OD_BusinessAccountsPage businessAccountsPage = new OD_BusinessAccountsPage();

	List<Profile_Bulk> profiles;
	// String fileName = "AnnapolisResidentPermits_2022_2023_Initial.xlsx";
	String fileName = "Missing_emails.xlsx";

	// ****************** TEST SCRIPTS ****************************//
	/*
	 * This is a test case to create profile
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	@Test(priority = 1)
	public void TC_01_CreateProfile() {
		loginPage = launch_OD_Application();
		homePage = loginPage.login();
		profilePage = homePage.navigateToProfilesPage();
		List<Profile_Bulk> profiles = excel_Ops.load_ProfilesData_From_ExcelSheet(fileName, "BA2");
		for (Profile_Bulk profile : profiles) {
			if (!profilePage.isPrfileExist(profile.getEmail())) {
				profilePage.createProfile(profile);
			}
		}
	}

	/*
	 * This is a test case imporsonate Business Account
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	@Test(priority = 2)
	public void TC_02_ImpersonateBusinessAccount() {
		loginPage = launch_OD_Application();
		homePage = loginPage.login();
		businessAccountsPage = homePage.navigateToBusinessAccountsPage();
		// List<String> sheets = excel_Ops.get_Total_Sheets(fileName);
		List<Profile_Bulk> profiles = excel_Ops.load_ProfilesData_From_ExcelSheet(fileName, "BA1");
		if (businessAccountsPage.isBusinessAccountExist(profiles.get(0).getBusinessAccountName(),
				profiles.get(0).getLocation())) {
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
	// businessAccountsPage.navigate_To_BusinessAcounts_Page();

}
