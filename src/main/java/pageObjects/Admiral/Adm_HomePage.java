package pageObjects.Admiral;

import org.openqa.selenium.By;

import components.BaseClass;

/*
 * Class which contains the web elements and performs Home page activities (methods)
 * 
 * Extends : BaseClass
 * 
 * Author : Venu Thota(venu.t@comakeit.com)
 */
public class Adm_HomePage extends BaseClass {

	// ****************** WEB ELEMENTS ****************************//
	
	By menu_Citations = By.xpath("//a[contains(text(),'citations')]");
	By search = By.id("search-input-block");

	// ****************** ACTIONS ****************************//
	/*
	 * Method to navigate to citations page from home page
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public Adm_CitationsPage navigateToCitationsPage() {
		
		clickOnButton(menu_Citations, "Citations menu");
		waitForPageLoad(5);
		
		
		return new Adm_CitationsPage();
	}
	
	

}
