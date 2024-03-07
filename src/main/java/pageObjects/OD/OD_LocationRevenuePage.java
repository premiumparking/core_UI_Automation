package pageObjects.OD;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.testng.Assert;

import components.BaseClass;
import components.Constants;
import dataModel.TextPay.PurchaseDetails;

/*
 * Class which contains the web elements and performs Markets page activities (methods)
 * 
 * Extends : BaseClass
 * 
 * Author : Venu Thota(venu.thota@xebia.com)
 */
public class OD_LocationRevenuePage extends BaseClass {

	// ****************** WEB ELEMENTS ****************************//
	By label_OperatorDashboard = By.xpath("//span[contains(text(),'Operator Dashboard')]");
	By label_LocationRevenues = By.xpath("//h1[normalize-space()='Location Revenues']");
	By searchBox = By.id("location_revenue_search_order_invoice_lp");
	By button_Find = By.xpath("//input[@value='Find']");
	By orderNumber, locationName, channel, licencePlate, descriptive, durationInWords, totalAmount, transactionType,
			promoCode, paymentMethod, product, rateName;

	// ****************** ACTIONS ****************************//

	/*
	 * Method to verify transaction entry in the location revenue table
	 * 
	 * Author : Venu Thota(venu.thota@xebia.com)
	 */
	public void verify_LocationRevenueData(PurchaseDetails purchaseDetails) {

		String orderNum = purchaseDetails.getOrderNumber();

		if (purchaseDetails.getPaymentOption().equalsIgnoreCase(Constants.CARD)) {
			orderNumber = By.xpath("//a[normalize-space()='" + orderNum + "']");

			locationName = By.xpath("//a[normalize-space()='" + orderNum + "']/parent::td/following-sibling::td[1]");
			channel = By.xpath("//a[normalize-space()='" + orderNum + "']/parent::td/following-sibling::td[4]");
			product = By.xpath("//a[normalize-space()='" + orderNum + "']/parent::td/following-sibling::td[3]");
			licencePlate = By.xpath("//a[normalize-space()='" + orderNum + "']/parent::td/following-sibling::td[12]");
			descriptive = By.xpath("//a[normalize-space()='" + orderNum + "']/parent::td/following-sibling::td[13]");
			durationInWords = By
					.xpath("//a[normalize-space()='" + orderNum + "']/parent::td/following-sibling::td[18]");
			rateName = By.xpath("//a[normalize-space()='" + orderNum + "']/parent::td/following-sibling::td[19]");
			totalAmount = By.xpath("//a[normalize-space()='" + orderNum + "']/parent::td/following-sibling::td[23]");
			transactionType = By
					.xpath("//a[normalize-space()='" + orderNum + "']/parent::td/following-sibling::td[38]");
			promoCode = By.xpath("//a[normalize-space()='" + orderNum + "']/parent::td/following-sibling::td[63]");
			paymentMethod = By.xpath("//a[normalize-space()='" + orderNum + "']/parent::td/following-sibling::td[10]");
		} else {
			orderNumber = By.xpath("(//a[normalize-space()='" + orderNum + "'])[2]");

			locationName = By
					.xpath("(//a[normalize-space()='" + orderNum + "'])[2]/parent::td/following-sibling::td[1]");
			product = By.xpath("(//a[normalize-space()='" + orderNum + "'])[2]/parent::td/following-sibling::td[3]");
			channel = By.xpath("(//a[normalize-space()='" + orderNum + "'])[2]/parent::td/following-sibling::td[4]");
			licencePlate = By
					.xpath("(//a[normalize-space()='" + orderNum + "'])[2]/parent::td/following-sibling::td[12]");
			descriptive = By
					.xpath("(//a[normalize-space()='" + orderNum + "'])[2]/parent::td/following-sibling::td[13]");
			durationInWords = By
					.xpath("(//a[normalize-space()='" + orderNum + "'])[2]/parent::td/following-sibling::td[18]");
			rateName = By.xpath("//a[normalize-space()='" + orderNum + "']/parent::td/following-sibling::td[19]");
			totalAmount = By.xpath("//a[normalize-space()='" + orderNum + "']/parent::td/following-sibling::td[23]");
			transactionType = By
					.xpath("(//a[normalize-space()='" + orderNum + "'])[2]/parent::td/following-sibling::td[38]");
			promoCode = By.xpath("(//a[normalize-space()='" + orderNum + "'])[2]/parent::td/following-sibling::td[63]");
			paymentMethod = By
					.xpath("(//a[normalize-space()='" + orderNum + "'])[2]/parent::td/following-sibling::td[10]");
		}
		waitForElementTobeDisplayed(searchBox);
		enterText(searchBox, purchaseDetails.getOrderNumber(), "Search box");
		waitForElementTobeClickable(button_Find);
		clickOnButton(button_Find, "Find button");

		int maxClicks = 18;
		int clickCount = 0;
		while (!isElementDisplayed(orderNumber) && clickCount < maxClicks) {

			// If not displayed, click find button
			waitForPageLoad(10);
			passStep("awaited for 10 sec ...");
			clickOnButton(button_Find, "Find button");
			clickCount++;

		}

		Assert.assertTrue(isElementDisplayed(orderNumber), "Order number not displayed even after 3 minutes");
		passStep("Order Number : " + getElementText(orderNumber));
		highlightElement(orderNumber);
		passStep("Location Name : " + getElementText(locationName));
		highlightElement(locationName);
		passStep("Product : " + getElementText(product));
		highlightElement(product);
		passStep("Channel : " + getElementText(channel));
		highlightElement(channel);
		passStep("Licence Plate : " + getElementText(licencePlate));
		highlightElement(licencePlate);
		if (purchaseDetails.isUnKnownVehicle()) {
			passStep("Descriptive : " + getElementText(descriptive));
			highlightElement((descriptive));
		}
		passStep("Duration in words : " + getElementText(durationInWords));
		highlightElement(durationInWords);
		passStep("Rate Name : " + getElementText(rateName));
		highlightElement(rateName);
		passStep("Total AMount : " + getElementText(totalAmount));
		highlightElement(totalAmount);
		passStep("Transaction Type : " + getElementText(transactionType));
		scrollToElement(transactionType);
		highlightElement(transactionType);

		assertEquals(getElementText(orderNumber), purchaseDetails.getOrderNumber());
		if (purchaseDetails.getLocationNumber().length() == 3)
			assertEquals(getElementText(locationName), "P0" + purchaseDetails.getLocationNumber(),
					"Location name mismatch...");
		else
			assertEquals(getElementText(locationName), "P" + purchaseDetails.getLocationNumber(),
					"Location name mismatch...");
		assertEquals(getElementText(product), purchaseDetails.getSpaceType(), "Product mismatch...");
		assertEquals(getElementText(channel), purchaseDetails.getChannel(), "Channel mismatch...");
		if (purchaseDetails.isUnKnownVehicle()) {
			assertEquals(getElementText(licencePlate), "UNKNOWN", "Licence Plate mismatch...");
			assertEquals(getElementText(descriptive), purchaseDetails.getLicensePlate(), "Licence Plate mismatch...");
			highlightElement(descriptive);
		} else
			assertEquals(getElementText(licencePlate), purchaseDetails.getLicensePlate(), "Descriptive mismatch...");
		assertEquals(getElementText(durationInWords).toLowerCase(), purchaseDetails.getDurationInWords().toLowerCase(),
				"Duration mismatch...");
		highlightElement(durationInWords);
		assertEquals(getElementText(totalAmount), purchaseDetails.getAmountCharged(), "Total amount mismatch...");
		assertEquals(getElementText(transactionType).toLowerCase(), purchaseDetails.getPurchaseType().toLowerCase(),
				"Purchase type mismatch...");
		highlightElement(licencePlate);
		highlightElement(totalAmount);
		scrollToElement(transactionType);
		highlightElement(transactionType);
		scrollToElement(promoCode);
		if (purchaseDetails.getPaymentOption().equalsIgnoreCase(Constants.PROMOCODE)) {
			assertEquals(getElementText(promoCode), purchaseDetails.getPromocode(), "Payment method mismatch...");
			highlightElement(promoCode);
			passStep("Promo code : " + getElementText(promoCode));
		} else {
			assertEquals(getElementText(paymentMethod), purchaseDetails.getPaymentMethod(),
					"Payment method mismatch...");
			highlightElement(paymentMethod);
			passStep("Payment Method : " + getElementText(paymentMethod));
		}

	}

}
