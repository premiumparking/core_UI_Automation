package pageObjects.OD;

import components.BaseClass;
import dataModel.OD.PartnerSale;
import org.openqa.selenium.By;

/*
 * Class which contains the web elements and performs partner sales page activities (methods)
 *
 * Extends : BaseClass
 *
 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
 */
public class OD_PartnerSalesPage extends BaseClass{
    // ****************** CLASS INSTANCES ****************************//
    OD_HomePage homepage = new OD_HomePage();

    // ****************** WEB ELEMENTS ****************************//
    By label_OperatorDashboard = By.xpath("//span[contains(text(),'Operator Dashboard')]");
    By label_PartnerSales = By.xpath("//h2[contains(text(),'Partner Sales')]");
    By button_New = By.xpath("//a[contains(text(),'New')]");
    By label_NewPartner = By.xpath("//h1[contains(text(),'New Partner')]");
    By textBox_companyName = By.id("partner_product_company_name");
    By textBox_productName = By.id("partner_product_name");
    By textBox_partnerUrl = By.id("partner_product_url");
    By textBox_partnerEmail = By.id("partner_product_email");
    By textBox_partnerProducts = By.id("partner_product_products-selectized");
    By textBox_partnerChannels = By.id("partner_product_channels-selectized");
    By textBox_startsAt = By.id("partner_product_starts_at");
    By textBox_endsAt = By.id("partner_product_ends_at");
    By textBox_partnerBanner = By.id("partner_product_banner");
    By textBox_partnerLogo = By.id("partner_product_logo");
    By button_create_partner = By.xpath("//input[@value='Save']");

    // ****************** ACTIONS ****************************//

    /*
     * Method to create a new partner product
     *
     * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
     */
    public void create_partnerProduct(PartnerSale partnerSale) {
        waitForElementTobeDisplayed(button_New);
        clickOnButton(button_New, "Button new");
        waitForElementTobeDisplayed(label_NewPartner);
        enterText(textBox_companyName, partnerSale.getCompanyName(), "Company Name Textbox");
        enterText(textBox_productName, partnerSale.getProductName(), "Product Name Textbox");
        enterText(textBox_partnerUrl, partnerSale.getUrl(), "Partner URL Textbox");
        enterText(textBox_partnerEmail, partnerSale.getEmail(), "Partner Email Textbox");
        selectFromSearch(textBox_partnerProducts, partnerSale.getProducts(), "Partner Products  Textbox");
        selectFromSearch(textBox_partnerChannels, partnerSale.getChannels(), "Partner Channels  Textbox");
        enterText(textBox_startsAt, partnerSale.getStartsAt(), "Partner Starts At Textbox");
        enterText(textBox_endsAt, partnerSale.getEndsAt(), "Partner Ends At Textbox");
        enterText(textBox_partnerBanner, partnerSale.getBanner(), "Partner Banner ");
        enterText(textBox_partnerLogo, partnerSale.getLogo(), "Partner Logo");
        clickOnButton(button_create_partner, "Save Button");

        By productNameOnGrid = By.xpath("//h1[contains(text(),'Invoice " + partnerSale.getProductName() + "')]");
        waitForElementTobeDisplayed(productNameOnGrid);
        if (isElementDisplayed(productNameOnGrid)) {
            passStep("Product Name " + partnerSale.getProductName() + " has been displayed on grid ");
            passStep("Partner Product creation is successful ...!!!");
        }
    }
}
