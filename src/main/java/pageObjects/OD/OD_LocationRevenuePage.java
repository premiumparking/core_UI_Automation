package pageObjects.OD;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;

import components.BaseClass;
import dataModel.TextPay.PurchaseDetails;

/*
 * Class which contains the web elements and performs Markets page activities (methods)
 * 
 * Extends : BaseClass
 * 
 * Author : Venu Thota(venu.t@comakeit.com)
 */
public class OD_LocationRevenuePage extends BaseClass {

	// ****************** WEB ELEMENTS ****************************//
	By label_OperatorDashboard = By.xpath("//span[contains(text(),'Operator Dashboard')]");
	By label_LocationRevenues = By.xpath("//h1[normalize-space()='Location Revenues']");
	By searchBox = By.id("location_revenue_search_order_invoice_lp");
	By button_Find = By.xpath("//input[@value='Find']");
	By orderNumber, locationName, channel, licencePlate, durationInWords, totalAmount, transactionType, promoCode,
			paymentMethod, product, rateName;

	// ****************** ACTIONS ****************************//

	/*
	 * Method to verify transaction entry in the location revenue table
	 * 
	 * Author : Venu Thota(venu.t@comakeit.com)
	 */
	public void verify_LocationRevenueData(PurchaseDetails purchaseDetails) {

		String orderNum = purchaseDetails.getOrderNumber();

		
		if (purchaseDetails.getPaymentOption().equalsIgnoreCase("card")) {
			orderNumber = By.xpath("//a[normalize-space()='" + orderNum + "']");

			locationName = By.xpath("//a[normalize-space()='" + orderNum + "']/parent::td/following-sibling::td[1]");
			channel = By.xpath("//a[normalize-space()='" + orderNum + "']/parent::td/following-sibling::td[4]");
			product = By.xpath("//a[normalize-space()='" + orderNum + "']/parent::td/following-sibling::td[3]");
			licencePlate = By.xpath("//a[normalize-space()='" + orderNum + "']/parent::td/following-sibling::td[12]");
			durationInWords = By
					.xpath("//a[normalize-space()='" + orderNum + "']/parent::td/following-sibling::td[18]");
			rateName = By.xpath("//a[normalize-space()='" + orderNum + "']/parent::td/following-sibling::td[19]");
			totalAmount = By.xpath("//a[normalize-space()='" + orderNum + "']/parent::td/following-sibling::td[23]");
			transactionType = By
					.xpath("//a[normalize-space()='" + orderNum + "']/parent::td/following-sibling::td[34]");
			promoCode = By.xpath("//a[normalize-space()='" + orderNum + "']/parent::td/following-sibling::td[59]");
			paymentMethod = By.xpath("//a[normalize-space()='" + orderNum + "']/parent::td/following-sibling::td[10]");
		} else {
			orderNumber = By.xpath("(//a[normalize-space()='" + orderNum + "'])[2]");

			locationName = By
					.xpath("(//a[normalize-space()='" + orderNum + "'])[2]/parent::td/following-sibling::td[1]");
			product = By.xpath("(//a[normalize-space()='" + orderNum + "'])[2]/parent::td/following-sibling::td[3]");
			channel = By.xpath("(//a[normalize-space()='" + orderNum + "'])[2]/parent::td/following-sibling::td[4]");
			licencePlate = By
					.xpath("(//a[normalize-space()='" + orderNum + "'])[2]/parent::td/following-sibling::td[12]");
			durationInWords = By
					.xpath("(//a[normalize-space()='" + orderNum + "'])[2]/parent::td/following-sibling::td[18]");
			rateName = By.xpath("//a[normalize-space()='" + orderNum + "']/parent::td/following-sibling::td[19]");
			totalAmount = By.xpath("//a[normalize-space()='" + orderNum + "']/parent::td/following-sibling::td[23]");
			transactionType = By
					.xpath("(//a[normalize-space()='" + orderNum + "'])[2]/parent::td/following-sibling::td[34]");
			promoCode = By.xpath("(//a[normalize-space()='" + orderNum + "'])[2]/parent::td/following-sibling::td[59]");
			paymentMethod = By
					.xpath("(//a[normalize-space()='" + orderNum + "'])[2]/parent::td/following-sibling::td[10]");
		}
		waitForElementTobeDisplayed(searchBox);
		enterText(searchBox, purchaseDetails.getOrderNumber(), "Search box");
		waitForElementTobeClickable(button_Find);
		clickOnButton_using_Actions(button_Find, "Button Find");
		// clickOnButton(button_Find, "Button Find");
		waitForPageLoad(60);
		clickOnButton_using_Actions(button_Find, "Button Find");
		waitForElementTobeDisplayed(orderNumber);
		passStep("Order Number : " + getElementText(orderNumber));
		passStep("Location Name : " + getElementText(locationName));	
		passStep("Product : " + getElementText(product));
		passStep("Channel : " + getElementText(channel));
		passStep("Licence Plate : " + getElementText(licencePlate));
		passStep("Duration in words : " + getElementText(durationInWords));
		passStep("Rate Name : " + getElementText(rateName));
		passStep("Total AMount : " + getElementText(totalAmount));
		passStep("Transaction Type : " + getElementText(transactionType));

		if (purchaseDetails.getLocationNumber().equalsIgnoreCase("101"))
			purchaseDetails.setLocationNumber("P0101");

		assertEquals(getElementText(orderNumber), purchaseDetails.getOrderNumber());
		assertEquals(getElementText(locationName), purchaseDetails.getLocationNumber());
		assertEquals(getElementText(product), purchaseDetails.getSpaceType());
		assertEquals(getElementText(channel), purchaseDetails.getChannel());
		assertEquals(getElementText(licencePlate), purchaseDetails.getLicencePlate());
		assertEquals(getElementText(durationInWords).toLowerCase(), purchaseDetails.getDurationInWords().toLowerCase());
		assertEquals(getElementText(totalAmount), purchaseDetails.getAmountCharged());
		assertEquals(getElementText(transactionType).toLowerCase(), purchaseDetails.getPurchaseType().toLowerCase());
		if (purchaseDetails.getPaymentOption().equalsIgnoreCase("promocode")) {
			assertEquals(getElementText(promoCode), purchaseDetails.getPromocode());
			passStep("Promo code : " + getElementText(promoCode));
		} else {
			assertEquals(getElementText(paymentMethod), purchaseDetails.getPaymentMethod());
			passStep("Payment Method : " + getElementText(paymentMethod));
		}

	}

}
