package testcases.SPA;

import components.BaseClass;
import dataModel.SPA.Vehicle;
import org.testng.annotations.Test;
import pageObjects.SPA.SPA_AccountsPage;
import pageObjects.SPA.SPA_HomePage;
import pageObjects.SPA.SPA_LocationPage;
import pageObjects.SPA.SPA_LoginPage;
import utils.XML_Operations;

public class SPA_OnBoarding_Testcases extends BaseClass {
    // ****************** CLASS INSTANCES ****************************//
    XML_Operations xml_Ops = new XML_Operations();
    SPA_HomePage spaHomePage = new SPA_HomePage();
    SPA_LoginPage spaLoginPage = new SPA_LoginPage();
    SPA_AccountsPage accountsPage = new SPA_AccountsPage();
    SPA_LocationPage locationPage = new SPA_LocationPage();

    // ****************** TEST DATA ****************************//
    Vehicle vehicle = (Vehicle) xml_Ops.getTestData("vehicle");

    // ****************** TEST SCRIPTS ****************************//

    /*
     * TC_01_SignUp_With_Email_By_SignIn_Flow
     * TC_02_SignUp_With_Email_By_SignUp_Flow
     * TC_03_SignIn_With_Existing_Email
     * TC_04_Verify_Location_Is_Fetched_By_Searching_With_Number
     * TC_05_Verify_Location_Is_Fetched_By_Searching_With_Name
     * TC_06_Verify_Location_Is_Fetched_By_Partial_Searching
     * TC_07_Verify_Location_Is_Fetched_By_Searching_With_Address
     *
     */

    /*
     * This is a test case to sign up with email by sign in flow
     *
     * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
     */
    @Test(groups = { "smoke", "regression" })
    public void TC_01_SignUp_With_Email_By_SignIn_Flow() {

        vehicle.setIsItSignUpFlow(false);
        vehicle.setEmail("test_" + getTimestamp() + "@yopmail.com");
        spaLoginPage = launch_SPA_Application();
        accountsPage = spaLoginPage.signup(vehicle);
    }

    /*
     * This is a test case to sign up with email by sign up flow
     *
     * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
     */
    @Test(groups = { "smoke", "regression" })
    public void TC_02_SignUp_With_Email_By_SignUp_Flow() {

        vehicle.setIsItSignUpFlow(true);
        vehicle.setEmail("test_" + getTimestamp() + "@yopmail.com");
        spaLoginPage = launch_SPA_Application();
        accountsPage = spaLoginPage.signup(vehicle);
    }

    /*
     * This is a test case to sign in with existing email
     *
     * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
     */
    @Test(groups = { "smoke", "regression" })
    public void TC_03_SignIn_With_Existing_Email() {

        spaLoginPage = launch_SPA_Application();
        accountsPage = spaLoginPage.login();
    }

    /*
     * This is a test case to verify location is fetched by searching with number
     *
     * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
     */
    @Test(groups = { "smoke", "regression" })
    public void TC_04_Verify_Location_Is_Fetched_By_Searching_With_Number() {

        spaLoginPage = launch_SPA_Application();
        accountsPage = spaLoginPage.login();
        spaHomePage = accountsPage.navigateToHomePage();
        locationPage = spaHomePage.navigate_To_LocationPage(getRandomLocation());
    }

    /*
     * This is a test case to verify location is fetched by searching with name
     *
     * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
     */
    @Test(groups = { "smoke", "regression" })
    public void TC_05_Verify_Location_Is_Fetched_By_Searching_With_Name() {

        spaLoginPage = launch_SPA_Application();
        accountsPage = spaLoginPage.login();
        spaHomePage = accountsPage.navigateToHomePage();
        locationPage = spaHomePage.navigate_To_LocationPage("Phoenix");
    }

    /*
     * This is a test case to verify location is fetched by partial searching
     *
     * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
     */
    @Test(groups = { "smoke", "regression" })
    public void TC_06_Verify_Location_Is_Fetched_By_Partial_Searching() {

        spaLoginPage = launch_SPA_Application();
        accountsPage = spaLoginPage.login();
        spaHomePage = accountsPage.navigateToHomePage();
        locationPage = spaHomePage.navigate_To_LocationPage("notre");
    }

    /*
     * This is a test case to verify location is fetched by searching with address
     *
     * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
     */
    @Test(groups = { "smoke", "regression" })
    public void TC_07_Verify_Location_Is_Fetched_By_Searching_With_Address() {

        spaLoginPage = launch_SPA_Application();
        accountsPage = spaLoginPage.login();
        spaHomePage = accountsPage.navigateToHomePage();
        locationPage = spaHomePage.navigate_To_LocationPage("101 Magazine street");
    }

    /*
     * This is a test case to open location screen through map label
     *
     * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
     */
    @Test(groups = { "smoke", "regression" })
    public void TC_08_Open_Location_Screen_Through_Maps_Label() {

        spaLoginPage = launch_SPA_Application();
        accountsPage = spaLoginPage.login();
        spaHomePage = accountsPage.navigateToHomePage();
        locationPage = spaHomePage.navigate_To_LocationPage_ThroughMaps("New Orleans");
    }

    /*
     * This is a test case to open location screen through markets dropdown
     *
     * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
     */
    @Test(groups = { "smoke", "regression" })
    public void TC_09_Open_Location_Screen_Through_Markets_Dropdown() {

        spaLoginPage = launch_SPA_Application();
        accountsPage = spaLoginPage.login();
        spaHomePage = accountsPage.navigateToHomePage();
        locationPage = spaHomePage.navigate_To_LocationPage_ThroughMarkets("New Orleans");
    }
}
