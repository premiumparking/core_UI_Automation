package pageObjects.OD;

import components.BaseClass;
import org.openqa.selenium.By;

/*
 * Class which contains the web elements and performs parking operators page activities (methods)
 *
 * Extends : BaseClass
 *
 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
 */
public class OD_ParkingOperatorsPage extends BaseClass {
    // ****************** CLASS INSTANCES ****************************//
    OD_HomePage homepage = new OD_HomePage();

    // ****************** WEB ELEMENTS ****************************//
    By label_OperatorDashboard = By.xpath("//span[contains(text(),'Operator Dashboard')]");
    By label_ParkingOperators = By.xpath("//h2[contains(text(),'Parking Operators')]");
    By button_New = By.xpath("//a[contains(text(),'New')]");
    By label_New = By.xpath("//h1[contains(text(),'New')]");
    By textBox_POName = By.id("parking_operator_name");
    By textBox_POLocations = By.id("parking_operator_location_ids-selectized");
    By button_save = By.xpath("//input[@value='Save']");

    // ****************** ACTIONS ****************************//

    /*
     * Method to create a new parking operator
     *
     * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
     */
    public void create_ParkingOperator(String name, String locations) {
        waitForElementTobeDisplayed(button_New);
        clickOnButton(button_New, "Button new");
        waitForElementTobeDisplayed(label_New);
        enterText(textBox_POName, name, " Parking Operator Name Textbox");
        selectFromSearch(textBox_POLocations, locations, "Parking Operator Locations Textbox");
        clickOnButton(label_New, "Empty Page");
        clickOnButton(button_save, "Save Button");

        By parkingOperatorNameOnGrid = By.xpath("//td[contains(text(),'" + name + "')]");
        waitForElementTobeDisplayed(parkingOperatorNameOnGrid);
        if (isElementDisplayed(parkingOperatorNameOnGrid)) {
            passStep("Parking Operator " + name + " has been displayed on grid");
            passStep("Parking Operator creation is successful ...!!!");
        }

    }
}
