package pageObjects.OD;

import components.BaseClass;
import dataModel.OD.Client;
import org.openqa.selenium.By;

/*
 * Class which contains the web elements and performs clients page activities (methods)
 *
 * Extends : BaseClass
 *
 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
 */
public class OD_ClientsPage extends BaseClass {
    // ****************** CLASS INSTANCES ****************************//
    OD_HomePage homepage = new OD_HomePage();

    // ****************** WEB ELEMENTS ****************************//
    By label_OperatorDashboard = By.xpath("//span[contains(text(),'Operator Dashboard')]");
    By label_Clients = By.xpath("//h2[contains(text(),'Clients')]");
    By button_New = By.xpath("//a[contains(text(),'New')]");
    By label_NewClient = By.xpath("//h1[contains(text(),'New Client')]");
    By textBox_client_name = By.id("client_name");
    By textBox_primary_admin = By.id("client_primary_admin-selectized");
    By textBox_default_locations = By.id("client_location_ids-selectized");
    By button_create_client = By.xpath("//input[@value='Save']");

    // ****************** ACTIONS ****************************//

    /*
     * Method to create a new client
     *
     * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
     */
    public void create_client(Client client) {
        waitForElementTobeDisplayed(button_New);
        clickOnButton(button_New, "Button new");
        waitForElementTobeDisplayed(label_NewClient);
        enterText(textBox_client_name, client.getClientName(), "Client Name  Textbox");
        selectFromSearch(textBox_default_locations,client.getLocations(),"Default Locations Dropdown");
        selectFromSearch(textBox_primary_admin,client.getPrimaryAdmin(),"Primary Admin Dropdown");
        clickOnButton(button_create_client, "Create Client Button");

        By clientNameOnGrid = By.xpath("//td[contains(text(),'" + client.getClientName() + "')]");
        waitForElementTobeDisplayed(clientNameOnGrid);
        if (isElementDisplayed(clientNameOnGrid)) {
            passStep("Client Name " + client.getClientName() + " has been displayed on grid");
            passStep("Client creation is successful ...!!!");
        }
    }
}
