package testcases.Admiral;

import org.testng.annotations.Test;
import java.util.List;

import org.testng.annotations.Test;

import components.BaseClass;
import dataModel.Admiral.Citation;
import pageObjects.Admiral.Adm_HomePage;
import pageObjects.Admiral.Adm_LoginPage;
import pageObjects.Admiral.Adm_CitationsPage;
import pageObjects.OD.OD_BusinessAccountsPage;
import utils.Excel_Operations;

/*
 * Class which contains the actual test scripts 
 * 
 * Extends : BaseClass
 * 
 * Author : Venu Thota(venu.t@comakeit.com)
 */
public class AdmiralEnforcement extends BaseClass {

	Excel_Operations excel_Ops = new Excel_Operations();
	OD_BusinessAccountsPage businessAccountsPage = new OD_BusinessAccountsPage();
	Adm_LoginPage adm_LoginPage = new Adm_LoginPage();
	Adm_HomePage adm_HomePage = new Adm_HomePage();
	Adm_CitationsPage citationPage = new Adm_CitationsPage();

	List<Citation> Citations;
	String fileName = "AdmiralPaymentLinkTransactions.xlsx";

	/*
	 * This is a test case to Verify Citation status and Pay Citation if not paid
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	@Test(priority = 1)
	public void TC_01_update_Admiral_CItation_Payments() {
		adm_LoginPage = launch_AdmiralEnforcement_Application();
		adm_HomePage = adm_LoginPage.login();
		citationPage = adm_HomePage.navigateToCitationsPage();
		List<Citation> citations = excel_Ops.load_CitationData_From_ExcelSheet(fileName, "Original");

		for (Citation citation : citations) {
			String[] desc = citation.getDescription().split(" ");
			String amount = citation.getTotalCollected().replaceAll("$", "");
			String citationNumber = desc[(desc.length - 1)];
			if (!citationPage.isCitationPaid(citationNumber)) {
				citationPage.payCitation(amount);
			}
		}

	}
}
