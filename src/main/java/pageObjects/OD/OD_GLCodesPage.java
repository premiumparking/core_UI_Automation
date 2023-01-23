package pageObjects.OD;

import components.BaseClass;
import dataModel.OD.GLCode;
import org.openqa.selenium.By;

/*
 * Class which contains the web elements and performs GL Codes page activities (methods)
 *
 * Extends : BaseClass
 *
 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
 */
public class OD_GLCodesPage extends BaseClass {
    // ****************** CLASS INSTANCES ****************************//
    OD_HomePage homepage = new OD_HomePage();

    // ****************** WEB ELEMENTS ****************************//
    By label_OperatorDashboard = By.xpath("//span[contains(text(),'Operator Dashboard')]");
    By label_GLCodes = By.xpath("//h2[contains(text(),'GL Codes')]");
    By button_New = By.xpath("//a[contains(text(),'New')]");
    By label_NewGLCode = By.xpath("//h1[contains(text(),'New GL Code')]");
    By textBox_glCode = By.id("gl_code_code");
    By dd_product_type = By.id("gl_code_product_type-selectized");
    By dd_channel_type = By.id("gl_code_channel_type-selectized");
    By dd_subChannel_type = By.id("gl_code_subchannel_type-selectized");
    By button_create_glCode = By.xpath("//input[@value='Save']");

    // ****************** ACTIONS ****************************//

    /*
     * Method to create a new GL Code
     *
     * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
     */
    public void create_glCode(GLCode glCode) {
        waitForElementTobeDisplayed(button_New);
        clickOnButton(button_New, "Button new");
        waitForElementTobeDisplayed(label_NewGLCode);
        enterText(textBox_glCode, glCode.getCode(), " GL Code Textbox");
        selectFromSearch(dd_product_type, glCode.getProductType(), "Product Type Dropdown");
        selectFromSearch(dd_channel_type, glCode.getChannelType(), "Channel Type Dropdown");
        selectFromSearch(dd_subChannel_type, glCode.getSubChannelType(), "Sub Channel Type Dropdown");
        clickOnButton(button_create_glCode, "Save Button");

        By glCodeOnGrid = By.xpath("//td[contains(text(),'" + glCode.getCode() + "')]");
        waitForElementTobeDisplayed(glCodeOnGrid);
        if (isElementDisplayed(glCodeOnGrid)) {
            passStep("GL Code " + glCode.getCode() + " has been displayed on grid");
            passStep("GL Code creation is successful ...!!!");
        }
    }
}
