package testcases.OD.Prod;

import java.util.List;

import org.testng.annotations.Test;

import components.BaseClass;
import dataModel.OD.PromoCode_Bulk;
import pageObjects.OD.OD_HomePage;
import pageObjects.OD.OD_LoginPage;
import pageObjects.OD.OD_PromoCodesPage;
import utils.Excel_Operations;

/*
 * Class which contains the actual test scripts 
 * 
 * Extends : BaseClass
 * 
 * Author : Venu Thota(venu.t@comakeit.com)
 */
public class Bulk_Creation_Of_PromoCodes extends BaseClass {

	// ****************** CLASS INSTANCES ****************************//
	OD_HomePage homePage = new OD_HomePage();
	OD_PromoCodesPage promoCodePage = new OD_PromoCodesPage();
	Excel_Operations excel_Ops = new Excel_Operations();
	OD_LoginPage loginPage = new OD_LoginPage();

	List<PromoCode_Bulk> promoCodes;
	String fileName = "2023 PremiumVIP Promo - Product Import.xlsx";

	// ****************** TEST SCRIPTS ****************************//
	/*
	 * This is a test case to create Bulk PromoCodes
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	@Test(priority = 1)
	public void TC_01_CreateBulkPromoCode() {
		loginPage = launch_OD_Application();
		homePage = loginPage.login();
		promoCodePage = homePage.navigateToPromoCodesPage();
		List<PromoCode_Bulk> promoCodes = excel_Ops.load_BulkPromoCodes_From_ExcelSheet(fileName, "VIP Promos");
		for (PromoCode_Bulk promoCode : promoCodes) {
			if (!promoCodePage.isPromoCodeExist(promoCode.getPromoCode())) {
				promoCodePage.create_PromoCode(promoCode);
			}
		}
	}

}
