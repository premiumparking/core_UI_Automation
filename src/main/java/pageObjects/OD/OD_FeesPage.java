package pageObjects.OD;

import components.BaseClass;
import dataModel.OD.Fee;
import org.openqa.selenium.By;

/*
 * Class which contains the web elements and performs fees page activities (methods)
 *
 * Extends : BaseClass
 *
 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
 */
public class OD_FeesPage extends BaseClass {
    // ****************** CLASS INSTANCES ****************************//
    OD_HomePage homepage = new OD_HomePage();

    // ****************** WEB ELEMENTS ****************************//
    By label_OperatorDashboard = By.xpath("//span[contains(text(),'Operator Dashboard')]");
    By label_Fees = By.xpath("//h2[contains(text(),'Fees')]");
    By button_New = By.xpath("//a[contains(text(),'New')]");
    By label_NewFee = By.xpath("//h1[contains(text(),'New')]");
    By textBox_fee_location = By.id("fee_location_id-selectized");
    By textBox_fee_percentage = By.id("fee_percentage");
    By textBox_fee_amount = By.id("fee_amount");
    By button_create_fee = By.xpath("//input[@value='Save']");

    // ****************** ACTIONS ****************************//

    /*
     * Method to create a new fee
     *
     * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
     */
    public void create_Fee(Fee fee) {
        waitForElementTobeDisplayed(button_New);
        clickOnButton(button_New, "Button new");
        waitForElementTobeDisplayed(label_NewFee);
        selectFromSearch(textBox_fee_location, fee.getFeeLocation()," Fee Locations Dropdown");
        enterText(textBox_fee_percentage, fee.getPercentage(), "Fee Percentage Textbox");
        enterText(textBox_fee_amount, fee.getAmount()," Fee Amount Dropdown");
        clickOnButton(button_create_fee, "Create Client Button");

        By feeLocationOnGrid = By.xpath("//td[contains(text(),'" + fee.getFeeLocation() + "')]");
        waitForElementTobeDisplayed(feeLocationOnGrid);
        if (isElementDisplayed(feeLocationOnGrid)) {
            passStep(" Fee Location " + fee.getFeeLocation() + " has been displayed on grid");
        }
        By feeDetailsOnGrid = By.xpath("//td[contains(text(),'" + fee.getPercentage() + "% + $" + fee.getAmount() + ".00')]");
        waitForElementTobeDisplayed(feeDetailsOnGrid);
        if (isElementDisplayed(feeDetailsOnGrid)) {
            passStep(" Fee Percentage " + fee.getPercentage() + "% and Fee Amount " + fee.getAmount() + ".00 has been displayed on grid");
            passStep("Fee creation is successful ...!!!");
        }
    }
}
