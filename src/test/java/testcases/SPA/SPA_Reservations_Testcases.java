package testcases.SPA;

import components.BaseClass;
import dataModel.SPA.Vehicle;
import org.testng.annotations.Test;
import pageObjects.SPA.SPA_AccountsPage;
import pageObjects.SPA.SPA_HomePage;
import pageObjects.SPA.SPA_LocationPage;
import pageObjects.SPA.SPA_LoginPage;
import utils.XML_Operations;

public class SPA_Reservations_Testcases extends BaseClass{
    // ****************** CLASS INSTANCES ****************************//
    XML_Operations xml_Ops = new XML_Operations();
    SPA_HomePage spaHomePage = new SPA_HomePage();
    SPA_LoginPage spaLoginPage = new SPA_LoginPage();
    SPA_AccountsPage accountsPage = new SPA_AccountsPage();
    SPA_LocationPage locationPage = new SPA_LocationPage();

    // ****************** TEST SCRIPTS ****************************//

    /*
     * TC_01_Purchase_Reservation_With_NewCard_and_NewVehicle
     * TC_02_Purchase_Reservation_With_NewCard_and_ExistingVehicle
     * TC_03_Purchase_Reservation_With_ExistingCard_and_NewVehicle
     * TC_04_Purchase_Reservation_With_ExistingCard_and_ExistingVehicle
     * TC_05_Purchase_Reservation_With_PromoCode_and_NewVehicle
     * TC_06_Purchase_Reservation_With_PromoCode_and_ExistingVehicle
     * TC_07_Purchase_Future_Reservation_With_NewCard_and_NewVehicle
     * TC_08_Purchase_Future_Reservation_With_NewCard_and_ExistingVehicle
     * TC_09_Purchase_Future_Reservation_With_ExistingCard_and_NewVehicle
     * TC_10_Purchase_Future_Reservation_With_ExistingCard_and_ExistingVehicle
     * TC_11_Purchase_Future_Reservation_With_PromoCode_and_NewVehicle
     * TC_12_Purchase_Future_Reservation_With_PromoCode_and_ExistingVehicle
     *
     */

    /*
     * This is a test case to purchase reservation with new vehicle and new payment method
     *
     * Author : Pavan Prasad(pavanprasad.v@comakeit.com)
     */
    @Test(groups = { "smoke", "regression" })
    public void TC_01_Purchase_Session_With_NewCard_and_NewVehicle() {
        Boolean newCard = true, newVehicle = true, newSession = false, newReservation = true, newPromoCode = false, payButton = true;

        spaLoginPage = launch_SPA_Application();
        accountsPage = spaLoginPage.login();
        spaHomePage = accountsPage.navigateToHomePage();
        Vehicle vehicle = xml_Ops.getVehicleTestData();
        vehicle.setLicensePlateNumber(getRandomLicencePlate());
        locationPage = spaHomePage.navigate_To_LocationPage(vehicle.getLocationNumber());

        locationPage.purchase_Reservation(vehicle, newVehicle, newCard, newPromoCode, payButton);
        locationPage.verify_Purchase_Details(vehicle, newSession, newReservation);
    }

    @Test(groups = { "smoke", "regression" })
    public void TC_02_Purchase_Reservation_With_NewCard_and_ExistingVehicle() {
        Boolean newCard = true, newVehicle = false, newSession = false, newReservation = true, newPromoCode = false, payButton = true;

        spaLoginPage = launch_SPA_Application();
        accountsPage = spaLoginPage.login();
        spaHomePage = accountsPage.navigateToHomePage();
        Vehicle vehicle = xml_Ops.getVehicleTestData();
        vehicle.setLicensePlateNumber("S286K");
        locationPage = spaHomePage.navigate_To_LocationPage(vehicle.getLocationNumber());

        locationPage.purchase_Reservation(vehicle, newVehicle, newCard, newPromoCode, payButton);
        locationPage.verify_Purchase_Details(vehicle, newSession, newReservation);
    }

    @Test(groups = { "smoke", "regression" })
    public void TC_03_Purchase_Reservation_With_ExistingCard_and_NewVehicle() {
        Boolean newCard = false, newVehicle = true, newSession = false, newReservation = true, newPromoCode = false, payButton = true;

        spaLoginPage = launch_SPA_Application();
        accountsPage = spaLoginPage.login();
        spaHomePage = accountsPage.navigateToHomePage();
        Vehicle vehicle = xml_Ops.getVehicleTestData();
        vehicle.setLicensePlateNumber(getRandomLicencePlate());
        locationPage = spaHomePage.navigate_To_LocationPage(vehicle.getLocationNumber());

        locationPage.purchase_Reservation(vehicle, newVehicle, newCard, newPromoCode, payButton);
        locationPage.verify_Purchase_Details(vehicle, newSession, newReservation);
    }

    @Test(groups = { "smoke", "regression" })
    public void TC_04_Purchase_Reservation_With_ExistingCard_and_ExistingVehicle() {
        Boolean newCard = false, newVehicle = false, newSession = false, newReservation = true, newPromoCode = false, payButton = true;

        spaLoginPage = launch_SPA_Application();
        accountsPage = spaLoginPage.login();
        spaHomePage = accountsPage.navigateToHomePage();
        Vehicle vehicle = xml_Ops.getVehicleTestData();
        vehicle.setLicensePlateNumber("P118N");
        locationPage = spaHomePage.navigate_To_LocationPage(vehicle.getLocationNumber());

        locationPage.purchase_Reservation(vehicle, newVehicle, newCard, newPromoCode, payButton);
        locationPage.verify_Purchase_Details(vehicle, newSession, newReservation);
    }

    @Test(groups = { "smoke", "regression" })
    public void TC_05_Purchase_Reservation_With_PromoCode_and_NewVehicle() {
        Boolean newCard = false, newVehicle = true, newSession = false, newReservation = true, newPromoCode = true, payButton = false;

        spaLoginPage = launch_SPA_Application();
        accountsPage = spaLoginPage.login();
        spaHomePage = accountsPage.navigateToHomePage();
        Vehicle vehicle = xml_Ops.getVehicleTestData();
        vehicle.setLicensePlateNumber(getRandomLicencePlate());
        locationPage = spaHomePage.navigate_To_LocationPage(vehicle.getLocationNumber());

        locationPage.purchase_Reservation(vehicle, newVehicle, newCard, newPromoCode, payButton);
        locationPage.verify_Purchase_Details(vehicle, newSession, newReservation);
    }

    @Test(groups = { "smoke", "regression" })
    public void TC_06_Purchase_Reservation_With_PromoCode_and_ExistingVehicle() {
        Boolean newCard = false, newVehicle = false, newSession = false, newReservation = true, newPromoCode = true, payButton = false;

        spaLoginPage = launch_SPA_Application();
        accountsPage = spaLoginPage.login();
        spaHomePage = accountsPage.navigateToHomePage();
        Vehicle vehicle = xml_Ops.getVehicleTestData();
        vehicle.setLicensePlateNumber("G865N");
        locationPage = spaHomePage.navigate_To_LocationPage(vehicle.getLocationNumber());

        locationPage.purchase_Reservation(vehicle, newVehicle, newCard, newPromoCode, payButton);
        locationPage.verify_Purchase_Details(vehicle, newSession, newReservation);
    }
}
