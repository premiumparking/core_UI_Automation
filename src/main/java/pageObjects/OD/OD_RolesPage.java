package pageObjects.OD;

import components.BaseClass;
import dataModel.OD.Role;
import org.openqa.selenium.By;

/*
 * Class which contains the web elements and performs roles page activities (methods)
 *
 * Extends : BaseClass
 *
 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
 */
public class OD_RolesPage extends BaseClass {
    // ****************** CLASS INSTANCES ****************************//
    OD_HomePage homepage = new OD_HomePage();

    // ****************** WEB ELEMENTS ****************************//
    By label_OperatorDashboard = By.xpath("//span[contains(text(),'Operator Dashboard')]");
    By label_Roles = By.xpath("//h2[contains(text(),'Roles')]");
    By button_New = By.xpath("//a[contains(text(),'New')]");
    By label_NewRole = By.xpath("//h1[contains(text(),'New Role')]");
    By textBox_role_name = By.id("new_role_name");
    By textBox_role_users = By.id("new_role_user_ids-selectized");
    By dd_access_markets = By.id("new_role_roles_permissions_attributes_0_access_level");
    By dd_access_locations = By.id("new_role_roles_permissions_attributes_1_access_level");
    By dd_access_VLocations = By.id("new_role_roles_permissions_attributes_2_access_level");
    By dd_access_events = By.id("new_role_roles_permissions_attributes_3_access_level");
    By dd_access_blackouts = By.id("new_role_roles_permissions_attributes_4_access_level");
    By dd_access_whitelists = By.id("new_role_roles_permissions_attributes_5_access_level");
    By dd_access_discounts = By.id("new_role_roles_permissions_attributes_6_access_level");
    By dd_access_users = By.id("new_role_roles_permissions_attributes_7_access_level");
    By dd_access_profiles = By.id("new_role_roles_permissions_attributes_8_access_level");
    By dd_access_clients = By.id("new_role_roles_permissions_attributes_9_access_level");
    By dd_access_fees = By.id("new_role_roles_permissions_attributes_10_access_level");
    By dd_access_textPayJobs = By.id("new_role_roles_permissions_attributes_11_access_level");
    By dd_access_parkingSpaces = By.id("new_role_roles_permissions_attributes_12_access_level");
    By dd_access_roles = By.id("new_role_roles_permissions_attributes_13_access_level");
    By dd_access_venues = By.id("new_role_roles_permissions_attributes_14_access_level");
    By dd_access_features = By.id("new_role_roles_permissions_attributes_15_access_level");
    By dd_access_bannerMessages = By.id("new_role_roles_permissions_attributes_16_access_level");
    By dd_access_helps = By.id("new_role_roles_permissions_attributes_17_access_level");
    By dd_access_jobs = By.id("new_role_roles_permissions_attributes_18_access_level");
    By dd_access_settings = By.id("new_role_roles_permissions_attributes_19_access_level");
    By dd_access_colorThemes = By.id("new_role_roles_permissions_attributes_20_access_level");
    By dd_access_parkingOperators = By.id("new_role_roles_permissions_attributes_21_access_level");
    By dd_access_staticPageGroups = By.id("new_role_roles_permissions_attributes_22_access_level");
    By dd_access_contactReasons = By.id("new_role_roles_permissions_attributes_23_access_level");
    By dd_access_supportArticles = By.id("new_role_roles_permissions_attributes_24_access_level");
    By dd_access_reservations = By.id("new_role_roles_permissions_attributes_25_access_level");
    By dd_access_validations = By.id("new_role_roles_permissions_attributes_26_access_level");
    By dd_access_subscriptions = By.id("new_role_roles_permissions_attributes_27_access_level");
    By dd_access_locationRevenue = By.id("new_role_roles_permissions_attributes_28_access_level");
    By dd_access_groups = By.id("new_role_roles_permissions_attributes_29_access_level");
    By dd_access_validationAccounts = By.id("new_role_roles_permissions_attributes_30_access_level");
    By dd_access_invoices = By.id("new_role_roles_permissions_attributes_31_access_level");
    By dd_access_rateBots = By.id("new_role_roles_permissions_attributes_32_access_level");
    By dd_access_adjustments = By.id("new_role_roles_permissions_attributes_33_access_level");
    By dd_access_refundRequests = By.id("new_role_roles_permissions_attributes_34_access_level");
    By dd_access_owedBalancePayments = By.id("new_role_roles_permissions_attributes_35_access_level");
    By dd_access_products = By.id("new_role_roles_permissions_attributes_36_access_level");
    By dd_access_parkingPlans = By.id("new_role_roles_permissions_attributes_37_access_level");
    By dd_access_reportGroupDiscounts = By.id("new_role_roles_permissions_attributes_38_access_level");
    By dd_access_checks = By.id("new_role_roles_permissions_attributes_39_access_level");
    By dd_access_bankTransfers = By.id("new_role_roles_permissions_attributes_40_access_level");
    By dd_access_reportDiscounts = By.id("new_role_roles_permissions_attributes_41_access_level");
    By dd_access_reportOccupancy = By.id("new_role_roles_permissions_attributes_42_access_level");
    By dd_access_feedbacks = By.id("new_role_roles_permissions_attributes_43_access_level");
    By dd_access_downloads = By.id("new_role_roles_permissions_attributes_44_access_level");
    By dd_access_walletHistory = By.id("new_role_roles_permissions_attributes_45_access_level");
    By dd_access_textPayConversion = By.id("new_role_roles_permissions_attributes_46_access_level");
    By dd_access_providers = By.id("new_role_roles_permissions_attributes_47_access_level");
    By dd_access_webhooks = By.id("new_role_roles_permissions_attributes_48_access_level");
    By dd_access_enforcement = By.id("new_role_roles_permissions_attributes_49_access_level");
    By dd_access_occupancy = By.id("new_role_roles_permissions_attributes_50_access_level");
    By dd_access_reports = By.id("new_role_roles_permissions_attributes_51_access_level");
    By dd_access_activities = By.id("new_role_roles_permissions_attributes_52_access_level");
    By dd_access_GLCodes = By.id("new_role_roles_permissions_attributes_53_access_level");
    By dd_access_textPayRequests = By.id("new_role_roles_permissions_attributes_54_access_level");
    By dd_access_cashDeposits = By.id("new_role_roles_permissions_attributes_55_access_level");
    By dd_access_partnerProducts = By.id("new_role_roles_permissions_attributes_56_access_level");
    By dd_access_textPayBlasts = By.id("new_role_roles_permissions_attributes_57_access_level");
    By dd_access_passwordPolicies = By.id("new_role_roles_permissions_attributes_58_access_level");

    By button_create_role = By.xpath("//input[@value='Save']");

    // ****************** ACTIONS ****************************//

    /*
     * Method to create a new role
     *
     * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
     */
    public void create_Role(Role role) {
        waitForElementTobeDisplayed(button_New);
        clickOnButton(button_New, "Button new");
        waitForElementTobeDisplayed(label_NewRole);
        enterText(textBox_role_name, role.getRoleName(), "Role Name  Textbox");
        selectFromSearch(textBox_role_users,role.getUsers(),"Role Users TextBox");
        selectDropdown(dd_access_markets, role.getAccessLevel(),"Market Access Dropdown");
        selectDropdown(dd_access_locations, role.getAccessLevel(),"Locations Access Dropdown");
        selectDropdown(dd_access_VLocations, role.getAccessLevel(),"Virtual Locations Access Dropdown");
        selectDropdown(dd_access_events, role.getAccessLevel(),"Events Access Dropdown");
        selectDropdown(dd_access_blackouts, role.getAccessLevel(),"Blackouts Access Dropdown");
        selectDropdown(dd_access_whitelists, role.getAccessLevel(),"Whitelists Access Dropdown");
        selectDropdown(dd_access_discounts, role.getAccessLevel(),"Discounts Access Dropdown");
        selectDropdown(dd_access_users, role.getAccessLevel(),"Users Access Dropdown");
        selectDropdown(dd_access_profiles, role.getAccessLevel(),"Profiles Access Dropdown");
        selectDropdown(dd_access_clients, role.getAccessLevel(),"Clients Access Dropdown");
        selectDropdown(dd_access_fees, role.getAccessLevel(),"Fees Access Dropdown");
        selectDropdown(dd_access_textPayJobs, role.getAccessLevel(),"Text Pay Jobs Access Dropdown");
        selectDropdown(dd_access_parkingSpaces, role.getAccessLevel(),"Parking Spaces Access Dropdown");
        selectDropdown(dd_access_roles, role.getAccessLevel(),"Roles Access Dropdown");
        selectDropdown(dd_access_venues, role.getAccessLevel(),"Venues Access Dropdown");
        selectDropdown(dd_access_features, role.getAccessLevel(),"Features Access Dropdown");
        selectDropdown(dd_access_bannerMessages, role.getAccessLevel(),"Banner Messages Access Dropdown");
        selectDropdown(dd_access_helps, role.getAccessLevel(),"Helps Access Dropdown");
        selectDropdown(dd_access_jobs, role.getAccessLevel(),"Jobs Access Dropdown");
        selectDropdown(dd_access_settings, role.getAccessLevel(),"Settings Access Dropdown");
        selectDropdown(dd_access_colorThemes, role.getAccessLevel(),"Color Themes Access Dropdown");
        selectDropdown(dd_access_parkingOperators, role.getAccessLevel(),"Parking Operators Access Dropdown");
        selectDropdown(dd_access_staticPageGroups, role.getAccessLevel(),"Static Page Groups Access Dropdown");
        selectDropdown(dd_access_contactReasons, role.getAccessLevel(),"Contact Reasons Access Dropdown");
        selectDropdown(dd_access_supportArticles, role.getAccessLevel(),"Support Articles Access Dropdown");
        selectDropdown(dd_access_reservations, role.getAccessLevel(),"Reservations Access Dropdown");
        selectDropdown(dd_access_validations, role.getAccessLevel(),"Validations Access Dropdown");
        selectDropdown(dd_access_subscriptions, role.getAccessLevel(),"Subscriptions Access Dropdown");
        selectDropdown(dd_access_locationRevenue, role.getAccessLevel(),"Location Revenues Access Dropdown");
        selectDropdown(dd_access_groups, role.getAccessLevel(),"Groups Access Dropdown");
        selectDropdown(dd_access_validationAccounts, role.getAccessLevel(),"Validation Accounts Access Dropdown");
        selectDropdown(dd_access_invoices, role.getAccessLevel(),"Invoices Access Dropdown");
        selectDropdown(dd_access_rateBots, role.getAccessLevel(),"Rate Bots Access Dropdown");
        selectDropdown(dd_access_adjustments, role.getAccessLevel(),"Adjustments Access Dropdown");
        selectDropdown(dd_access_refundRequests, role.getAccessLevel(),"Refund Requests Access Dropdown");
        selectDropdown(dd_access_owedBalancePayments, role.getAccessLevel(),"Owed Balance Payments Access Dropdown");
        selectDropdown(dd_access_products, role.getAccessLevel(),"Product Access Dropdown");
        selectDropdown(dd_access_parkingPlans, role.getAccessLevel(),"Parking Plans Access Dropdown");
        selectDropdown(dd_access_reportGroupDiscounts, role.getAccessLevel(),"Report group Discounts Access Dropdown");
        selectDropdown(dd_access_checks, role.getAccessLevel(),"Checks Access Dropdown");
        selectDropdown(dd_access_bankTransfers, role.getAccessLevel(),"Bank Transfers Access Dropdown");
        selectDropdown(dd_access_reportDiscounts, role.getAccessLevel(),"Report Discounts Access Dropdown");
        selectDropdown(dd_access_reportOccupancy, role.getAccessLevel(),"Report Occupancy Access Dropdown");
        selectDropdown(dd_access_feedbacks, role.getAccessLevel(),"Feedbacks Access Dropdown");
        selectDropdown(dd_access_downloads, role.getAccessLevel(),"Downloads Access Dropdown");
        selectDropdown(dd_access_walletHistory, role.getAccessLevel(),"Wallet History Access Dropdown");
        selectDropdown(dd_access_textPayConversion, role.getAccessLevel(),"Text Pay Conversion Access Dropdown");
        selectDropdown(dd_access_providers, role.getAccessLevel(),"Providers Access Dropdown");
        selectDropdown(dd_access_webhooks, role.getAccessLevel(),"Webhooks Access Dropdown");
        selectDropdown(dd_access_enforcement, role.getAccessLevel(),"Enforcement Access Dropdown");
        selectDropdown(dd_access_occupancy, role.getAccessLevel(),"Occupancy Access Dropdown");
        selectDropdown(dd_access_reports, role.getAccessLevel(),"Reports Access Dropdown");
        selectDropdown(dd_access_activities, role.getAccessLevel(),"Activities Access Dropdown");
        selectDropdown(dd_access_GLCodes, role.getAccessLevel(),"GL Codes Access Dropdown");
        selectDropdown(dd_access_textPayRequests, role.getAccessLevel(),"Text Pay Requests Access Dropdown");
        selectDropdown(dd_access_cashDeposits, role.getAccessLevel(),"Cash Deposits Access Dropdown");
        selectDropdown(dd_access_partnerProducts, role.getAccessLevel(),"Partner Products Access Dropdown");
        selectDropdown(dd_access_textPayBlasts, role.getAccessLevel(),"Text Pay Blasts Access Dropdown");
        selectDropdown(dd_access_passwordPolicies, role.getAccessLevel(),"Password Policies Access Dropdown");
        clickOnButton(button_create_role, "Create Role Button");

        By roleNameOnGrid = By.xpath("//a[contains(text(),'" + role.getRoleName() + "')]");
        waitForElementTobeDisplayed(roleNameOnGrid);
        if (isElementDisplayed(roleNameOnGrid)) {
            passStep("Role Name " + role.getRoleName() + " has been displayed on grid");
            passStep("Role creation is successful ...!!!");
        }
    }
}
