package pageObjects.OD;

import components.BaseClass;
import components.Constants;
import dataModel.OD.Banner;
import dataModel.TextPay.PurchaseDetails;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

/*
 * Class which contains the web elements and performs Banners page activities (methods)
 *
 * Extends : BaseClass
 *
 * Author : Venu Thota(venu.thota@xebia.com)
 */
public class OD_EnforcementPage extends BaseClass {
	// ****************** WEB ELEMENTS ****************************//
	public By header_EnfReport = By.xpath("//h3[normalize-space()='Enforcement Report']");
	By dd_LocationInput = By.id("location_id");
	By input_Search = By.id("search");

	By model_Title = By.xpath("//div[@class='navbar navbar-inverse']/h2");
	By header_text = By.xpath("(//tr/th)[1]");

	By iframe = By.className("fancybox-iframe");

	// ****************** ACTIONS ****************************//

	/*
	 * Method to verify licence pate
	 *
	 * Author : Venu Thota(venu.thota@xebia.com)
	 */

	public void verify_LicencePlateDetails(PurchaseDetails purchaseDetails) {
		String lpNumber = null;
		// Upon Search, unknown vehicle details are getting displayed in ColorMakeType
		// format.(Without Spaces)
		if (purchaseDetails.isUnKnownVehicle())
			lpNumber = purchaseDetails.getEnf_licensePlate().toUpperCase();
		else
			lpNumber = purchaseDetails.getLicensePlate();

		clickOnButton(dd_LocationInput, "Location dropdown");
		selectDropdown(dd_LocationInput, "P" + purchaseDetails.getLocationNumber(), "Location drop down");
		waitForElementTobeDisplayed(get_LicensePlate(lpNumber));
		if (Constants.STAR_SPACE.equalsIgnoreCase(purchaseDetails.getSpaceType()))
			Assert.assertEquals(getElementText(get_LicensePlate(lpNumber)), lpNumber + " / ★");
		else
			Assert.assertEquals(getElementText(get_LicensePlate(lpNumber)), lpNumber);
		passStep("Licenceplate displayed as expected -> " + getElementText(get_LicensePlate(lpNumber)));
		highlightElement(get_LicensePlate(lpNumber));
		clickOnButton(button_LicensePlateDetails(lpNumber), "Lisense plate Details button");
		highlightElement(button_LicensePlateDetails(lpNumber));
		switchToIframe(iframe);
		// Assigning back to Color Type Make format (with Spaces)
		lpNumber = purchaseDetails.getLicensePlate();
		waitForElementTobeDisplayed(model_Title);
		String mismatch = "License Plate mismatch on header .. Actual <b>" + getElementText(model_Title)
				+ "</b> does not contain " + lpNumber;
		Assert.assertTrue(getElementText(model_Title).contains(lpNumber), mismatch);
		passStep("Model displayed as " + getElementText(model_Title));
		highlightElement(model_Title);
		waitForElementTobeDisplayed(header_text);
		Assert.assertEquals(getElementText(header_text), purchaseDetails.getPurchaseType(),
				"Purchase Type mismatch ...");
		passStep("Header displayed as " + getElementText(header_text));
		highlightElement(header_text);
		List<WebElement> rows = BaseClass.driver.findElements(By.xpath("//tr/td"));
		for (int i = 1; i <= rows.size(); i++) {
			By row_info = By.xpath("(//tr/td)[" + i + "]");
			highlightElement(row_info);
			if (i == 6) {
				String lp_mismatch = "License Plate mismatch on row " + i + ".. Actual <b>" + getElementText(row_info)
						+ "</b> does not contain " + lpNumber;
				if (purchaseDetails.isUnKnownVehicle())
					Assert.assertEquals(getElementText(row_info), lpNumber, lp_mismatch);
				else
					Assert.assertEquals(getElementText(row_info), "Alaska, " + lpNumber, lp_mismatch);
			}
			if (i == 10) {
				String amount_mismatch = "Amount mismatch on row " + i + ".. Actual <b>" + getElementText(row_info)
						+ "</b> does not contain " + purchaseDetails.getAmountCharged();
				Assert.assertEquals(getElementText(row_info), purchaseDetails.getAmountCharged(), amount_mismatch);
			}
			if (i == 12) {
				String duration_mismatch = "Duration mismatch on row " + i + ".. Actual <b>" + getElementText(row_info)
						+ "</b> does not contain " + purchaseDetails.getDurationInWords();
				Assert.assertEquals(getElementText(row_info).toLowerCase(),
						purchaseDetails.getDurationInWords().toLowerCase(), duration_mismatch);
			}
			passStep(getElementText(row_info));
		}

		comeOutFromFrame();

	}

	public By get_LicensePlate(String lpNumber) {
		return By.xpath("//div[contains(text(),'" + lpNumber + "')]");
	}

	public By button_LicensePlateDetails(String lpNumber) {
		return By.xpath("//div[contains(text(),'" + lpNumber + "')]/parent::div/following-sibling::a/img");
	}
}
