package testcases.SPA;

import components.BaseClass;
import components.Constants;
import dataModel.SPA.Vehicle;
import org.testng.annotations.Test;
import pageObjects.SPA.SPA_HomePage;
import pageObjects.SPA.SPA_LoginPage;
import pageObjects.SPA.SPA_SessionsPage;
import utils.XML_Operations;

public class Sessions_Testcases extends BaseClass {
    // ****************** CLASS INSTANCES ****************************//
    XML_Operations xml_Ops = new XML_Operations();
    SPA_HomePage spaHomePage = new SPA_HomePage();
    SPA_LoginPage spaLoginPage = new SPA_LoginPage();
    SPA_SessionsPage spaSessionsPage = new SPA_SessionsPage();

    // ****************** TEST SCRIPTS ****************************//
    /*
     * This is a test case to purchase session
     *
     * Author : Pavan Prasad(pavanprasad.v@comakeit.com)
     */
    @Test(groups = { "smoke", "regression" })
    public void TC_01_Purchase_Session() {

        spaLoginPage = launch_SPA_Application();
        spaHomePage = spaLoginPage.login();
        Vehicle vehicle = xml_Ops.getVehicleTestData();
        vehicle.setLicensePlateNumber(vehicle.getLicensePlateNumber() + getTimestamp());
        spaSessionsPage.purchase_Session(Constants.CardNumber, Constants.Expiry_Date, Constants.CVC, vehicle);



    }
}
