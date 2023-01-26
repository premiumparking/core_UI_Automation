package pageObjects.OD;

import components.BaseClass;
import org.openqa.selenium.By;

/*
 * Class which contains the web elements and performs settings page activities (methods)
 *
 * Extends : BaseClass
 *
 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
 */
public class OD_SettingsPage extends BaseClass {
    // ****************** CLASS INSTANCES ****************************//
    OD_HomePage homepage = new OD_HomePage();

    // ****************** WEB ELEMENTS ****************************//
    By label_OperatorDashboard = By.xpath("//span[contains(text(),'Operator Dashboard')]");
    By label_Settings = By.xpath("//h2[contains(text(),'Settings')]");
    By button_New = By.xpath("//a[contains(text(),'New')]");
    By label_NewSetting = By.xpath("//h1[contains(text(),'New Setting')]");
    By textBox_SettingKey = By.id("setting_key-selectized");
    By textBox_SettingValue = By.id("setting_value");
    By button_save_setting = By.xpath("//input[@value='Save']");

    // ****************** ACTIONS ****************************//

    /*
     * Method to create a new setting
     *
     * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
     */
    public void create_Setting(String key) {
        waitForElementTobeDisplayed(button_New);
        clickOnButton(button_New, "Button new");
        waitForElementTobeDisplayed(label_NewSetting);
        selectFromSearch(textBox_SettingKey, key, " Settings Key Textbox");
        enterText(textBox_SettingValue, "Dummy Test Data", "Settings Value Textbox");
        clickOnButton(button_save_setting, "Save Button");

        By settingKeyOnGrid = By.xpath("//td[contains(text(),'" + key + "')]");
        waitForElementTobeDisplayed(settingKeyOnGrid);
        if (isElementDisplayed(settingKeyOnGrid)) {
            passStep("Settings key " + key + " has been displayed on grid");
            passStep("Setting creation is successful ...!!!");
        }

    }
}
