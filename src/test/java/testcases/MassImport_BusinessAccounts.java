package testcases;

import java.util.List;

import org.testng.annotations.Test;

import components.BaseClass;
import dataModel.Profile;
import pageObjects.BusinessAccountsPage;
import utils.Excel_Operations;

/*
 * Class which contains the actual test scripts 
 * 
 * Extends : BaseClass
 * 
 * Author : Venu Thota(venu.t@comakeit.com)
 */
public class MassImport_BusinessAccounts extends BaseClass {

	Excel_Operations excel_Ops = new Excel_Operations();
	BusinessAccountsPage businessAccountsPage = new BusinessAccountsPage();

	List<Profile> profiles;
	String fileName = "Test.xlsx";

	/*
	 * This is a test case to create profile
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	@Test(priority = 1)
	public void TC_01_CreateProfile() {
		loginPage = launchApplication();
		homePage = loginPage.login();
		profilePage = homePage.navigateToProfilesPage();
		List<Profile> profiles = excel_Ops.load_ProfilesData_From_ExcelSheet(fileName, "Original");
		for (Profile profile : profiles) {
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
		loginPage = launchApplication();
		homePage = loginPage.login();
		businessAccountsPage = homePage.navigateToBusinessAccountsPage();
		List<String> sheets = excel_Ops.get_Total_Sheets(fileName);
		for (String sheet : sheets.subList(1, sheets.size())) {
			List<Profile> profiles = excel_Ops.load_ProfilesData_From_ExcelSheet(fileName, sheet);
			if (businessAccountsPage.isBusinessAccountExist(profiles.get(0).getBusinessAccountName(),
					profiles.get(0).getLocation())) {
				businessAccountsPage.imporsonateBusinessAccount(profiles.get(0));
				for (Profile profile : profiles) {
					if (!businessAccountsPage.isMembertExist(profile)) {
						businessAccountsPage.add_Member(profile);
					}
					businessAccountsPage.add_Vehicle(profile.getLpNumber());
				}
			}
			businessAccountsPage.navigate_To_BusinaessAcounts_Page();
		}

	}

}
