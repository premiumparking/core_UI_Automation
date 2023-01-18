package pageObjects.OD;

import components.BaseClass;
import dataModel.OD.Blackout;
import org.openqa.selenium.By;

/*
 * Class which contains the web elements and performs Blackouts page activities (methods)
 *
 * Extends : BaseClass
 *
 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
 */
public class OD_BlackoutsPage extends BaseClass {
    // ****************** CLASS INSTANCES ****************************//
    OD_HomePage homepage = new OD_HomePage();

    // ****************** WEB ELEMENTS ****************************//
    By label_OperatorDashboard = By.xpath("//span[contains(text(),'Operator Dashboard')]");
    By label_Blackouts = By.xpath("//h2[contains(text(),'Blackouts')]");
    By button_New = By.xpath("//a[contains(text(),'New')]");
    By label_NewBlackout = By.xpath("//h1[contains(text(),'New Blackout')]");
    By dd_Market = By.id("blackout_market_id");
    By textBox_blackout_name = By.id("blackout_name");
    By blackout_starts = By.id("blackout_starts");
    By blackout_ends = By.id("blackout_ends");
    By textBox_blackout_locations = By.xpath("(//input[@id='blackout_location_ids-selectized'])[1]");
    By button_create_Blackout = By.xpath("//input[@value='Create Blackout']");

    // ****************** ACTIONS ****************************//

    /*
     * Method to create a new Blackout
     *
     * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
     */
    public void create_Blackout(Blackout blackout) {
        waitForElementTobeDisplayed(button_New);
        clickOnButton(button_New, "Button new");
        waitForElementTobeDisplayed(label_NewBlackout);
        selectDropdown(dd_Market, blackout.getMarket(),"Blackout Market Dropdown");
        enterText(textBox_blackout_name, blackout.getBlackoutName(), "Blackout Name Textbox");
        selectFromSearch(textBox_blackout_locations, blackout.getBlackoutLocation(), "Blackout Location");
        enterText(blackout_ends, blackout.getBlackoutEndTime(), "Blackout End Time Calendar");
        enterText(blackout_starts, blackout.getBlackoutStartTime(), "Blackout Start Time Calendar");
        waitForElementTobeClickable(button_create_Blackout);
        clickOnButton(button_create_Blackout, "Create Blackout Button");

        By blackoutNameOnGrid = By.xpath("//td[contains(text(),'" + blackout.getBlackoutName() + "')]");
        waitForElementTobeDisplayed(blackoutNameOnGrid);
        if (isElementDisplayed(blackoutNameOnGrid)) {
            passStep("Blackout " + blackout.getBlackoutName() + " has been displayed on grid");
            passStep("Blackout creation is successful ...!!!");
        }

    }
}
