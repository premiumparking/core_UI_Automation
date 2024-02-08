package pageObjects.Admiral;

import org.openqa.selenium.By;
import components.BaseClass;

/*
 * Class which contains the web elements and performs Adm_CitationsPage  activities (methods)
 * 
 * Extends : BaseClass
 * 
 * Author : Venu Thota(venu.thota@xebia.com)
 */
public class Adm_CitationsPage extends BaseClass {

	// ****************** WEB ELEMENTS ****************************//
	By input_Search = By.id("search-input-block");
	By text_paid = By.xpath("//p[contains(text(),'Paid')]");
	By link_Details = By.xpath("//p[contains(text(),'Details')]");
	By button_Citationcloseoutform = By.xpath("//a[contains(text(),'Citation close out form')]");
	By button_Edit = By.xpath("//button[contains(text(),'Edit')]");
	By button_Update = By.xpath("//button[contains(text(),'Update')]");
	By dd_PaymentType = By.id("payment-type-change");
	By textbox_TotalPaid = By.xpath("//input[@name='paid_amount']");

	// ****************** ACTIONS ****************************//

	/*
	 * Method to verify Citation payment status
	 * 
	 * Author : Venu Thota(venu.thota@xebia.com)
	 */
	public Boolean isCitationPaid(String citation) {
		passStep("Verifying Citation: " + citation + " Status");
		waitForElementTobeDisplayed(input_Search);
		enterText(input_Search, citation, "Search");
		hitEnter(input_Search);
		waitForElementTobeDisplayed(link_Details);
		waitForPageLoad(1);
		try {
			if (isElementDisplayed(text_paid)) {
				passStep("Payment status displayed as <b>" + getElementText(text_paid) + "</b>");
				return true;
			}
		} catch (Exception ex) {
			return false;
		}
		return false;
	}

	/*
	 * Method to Pay Citation
	 * 
	 * Author : Venu Thota(venu.thota@xebia.com)
	 */
	public void payCitation(String amount) {
		// clickOnButton(link_Details, "Details");
		// clickWithPoints(link_Details);
		waitForElementTobeDisplayed(button_Citationcloseoutform);
		clickOnButton(button_Citationcloseoutform, "Button - Citation close out form");
		waitForElementTobeDisplayed(button_Edit);
		clickOnButton(button_Edit, "Button - Edit");
		waitForElementTobeDisplayed(button_Update);
		selectDropdown(dd_PaymentType, "Card", "Dropdows -> Payment Type");
		enterText(textbox_TotalPaid, amount, "Total Paid");
		clickOnButton(button_Update, "Button - Update");
		waitForElementTobeDisplayed(link_Details);

	}

}
