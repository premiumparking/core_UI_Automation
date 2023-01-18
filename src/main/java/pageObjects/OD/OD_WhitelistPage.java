package pageObjects.OD;

import components.BaseClass;
import dataModel.OD.Whitelist;
import org.openqa.selenium.By;

/*
 * Class which contains the web elements and performs Whitelists page activities (methods)
 *
 * Extends : BaseClass
 *
 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
 */
public class OD_WhitelistPage extends BaseClass {
    // ****************** CLASS INSTANCES ****************************//
    OD_HomePage homepage = new OD_HomePage();

    // ****************** WEB ELEMENTS ****************************//
    By label_OperatorDashboard = By.xpath("//span[contains(text(),'Operator Dashboard')]");
    By label_Whitelists = By.xpath("//h2[contains(text(),'Whitelists')]");
    By button_New = By.xpath("//a[contains(text(),'New')]");
    By label_NewWhitelist = By.xpath("//h1[contains(text(),'New Whitelist')]");
    By textBox_whitelist_state = By.id("whitelist_state");
    By textBox_whitelist_ac_number = By.id("whitelist_account_number");
    By textBox_whitelist_name = By.id("whitelist_name");
    By textBox_whitelist_v_make = By.id("whitelist_vehicle_make");
    By textBox_whitelist_v_color = By.id("whitelist_vehicle_color");
    By textBox_whitelist_l_plate = By.id("whitelist_license_plate");
    By textBox_whitelist_a_level = By.id("whitelist_access_level");
    By textBox_whitelist_p_number = By.id("whitelist_permit_number");
    By textBox_whitelist_location = By.id("whitelist_location_id");
    By button_create_Whitelist = By.xpath("//input[@value='Create Whitelist']");

    // ****************** ACTIONS ****************************//

    /*
     * Method to create a new Whitelist
     *
     * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
     */
    public void create_Whitelist(Whitelist whitelist) {
        waitForElementTobeDisplayed(button_New);
        clickOnButton(button_New, "Button new");
        waitForElementTobeDisplayed(label_NewWhitelist);
        enterText(textBox_whitelist_state, whitelist.getState(), "Whitelist State Textbox");
        enterText(textBox_whitelist_l_plate, whitelist.getLicensePlate(), "Whitelist License Plate Textbox");
        enterText(textBox_whitelist_ac_number, whitelist.getAccountNumber(), "Whitelist Account Number Textbox");
        enterText(textBox_whitelist_name, whitelist.getName(), "Whitelist Name Textbox");
        enterText(textBox_whitelist_v_make, whitelist.getVehicleMake(), "Whitelist Vehicle Make Textbox");
        enterText(textBox_whitelist_v_color, whitelist.getVehicleColor(), "Whitelist Vehicle Color Textbox");
        enterText(textBox_whitelist_a_level, whitelist.getAccessLevel(), "Whitelist Access Level Textbox");
        enterText(textBox_whitelist_p_number, whitelist.getPermitNumber(), "Whitelist Permit Number Textbox");
        enterText(textBox_whitelist_location, whitelist.getLocation(), "Whitelist Location Textbox");
        clickOnButton(button_create_Whitelist, "Create Blackout Button");

        By whitelistNameOnGrid = By.xpath("//td[contains(text(),'" + whitelist.getName() + "')]");
        waitForElementTobeDisplayed(whitelistNameOnGrid);
        if (isElementDisplayed(whitelistNameOnGrid)) {
            passStep("Whitelist " + whitelist.getName() + " has been displayed on grid");
            passStep("Whitelist creation is successful ...!!!");
        }

    }
}
