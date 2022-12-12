package testcases.OD;

import org.testng.annotations.Test;

import components.BaseClass;
import dataModel.Market;
import pageObjects.OD.MarketsPage;
import utils.XML_Operations;

public class Manage_Menu_Testcases extends BaseClass {
	XML_Operations xml_Ops = new XML_Operations();
	MarketsPage marketsPage = new MarketsPage();

	/*
	 * This is a test case to create Market
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	@Test(priority = 1)
	public void TC_01_CreateMarket() {
		loginPage = launchApplication();
		Market market = xml_Ops.getMarketTestData();
		System.out.println(market);
		// homePage = loginPage.login();
		// marketsPage = homePage.navigateToMarketsPage();

	}

}
