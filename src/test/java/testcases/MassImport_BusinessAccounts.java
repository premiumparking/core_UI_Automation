package testcases;

import java.util.List;

import org.testng.annotations.Test;

import components.BaseClass;
import dataModel.Profile;
import utils.Excel_Operations;

/*
 * Class which contains the actual test scripts 
 * 
 * Extends : BaseClass
 * 
 * Author : Venu Thota(venu.t@comakeit.com)
 */
public class MassImport_BusinessAccounts extends BaseClass {

	Excel_Operations exo = new Excel_Operations();

	List<Profile> profiles;
	String fileName = "AnnapolisResidentPermits_2022_2023_dup.xlsx";

	/*
	 * This is a test case to create profile
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	@Test
	public void TC_01_CreateProfile() {
		loginPage = launchApplication();
		homePage = loginPage.login();
		profilePage = homePage.navigateToProfilesPage();

		List<Profile> profiles = exo.load_ProfilesData_From_ExcelSheet(fileName);
		for (Profile profile : profiles) {
			if (!profilePage.isPrfileExist(profile.getEmail())) {
				profilePage.createProfile(profile);
			}

		}

	}

}
