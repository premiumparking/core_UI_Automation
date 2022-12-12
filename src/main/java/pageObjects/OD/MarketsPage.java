package pageObjects.OD;

import org.openqa.selenium.By;

import components.BaseClass;

/*
 * Class which contains the web elements and performs Home page activities (methods)
 * 
 * Extends : BaseClass
 * 
 * Author : Venu Thota(venu.t@comakeit.com)
 */
public class MarketsPage extends BaseClass {

	// ****************** WEB ELEMENTS ****************************//
	By label_OperatorDashboard = By.xpath("//span[contains(text(),'Operator Dashboard')]");
	By label_Markets = By.xpath("//h2[contains(text(),'Markets')]");
	By button_New = By.xpath("//a[contains(text(),'New')]");


	// ****************** ACTIONS ****************************//

	
	/*
	 * Method to navigate to BusinessAccounts page from home page
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public MarketsPage navigateToMarketsPage() {
	return null;
	}

}
