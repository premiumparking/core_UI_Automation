package pageObjects.OD;

import components.BaseClass;
import dataModel.OD.PromoCode;
import org.openqa.selenium.By;

/*
 * Class which contains the web elements and performs Promo codes page activities (methods)
 *
 * Extends : BaseClass
 *
 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
 */
public class OD_PromoCodesPage extends BaseClass {
    // ****************** CLASS INSTANCES ****************************//
    OD_HomePage homepage = new OD_HomePage();

    // ****************** WEB ELEMENTS ****************************//
    By label_OperatorDashboard = By.xpath("//span[contains(text(),'Operator Dashboard')]");
    By label_PromoCodes = By.xpath("//h1[contains(text(),'Promo Codes')]");
    By textBox_PromocodeSearch = By.id("discounts_search");
    By button_Find = By.xpath("//input[@value='Find']");
    By button_New = By.xpath("//a[contains(text(),'New')]");
    By label_NewPromoCode = By.xpath("//h1[contains(text(),'New Promo Code')]");
    By radio_auto_generate = By.id("discount_form_generation_type_multiple");
    By textBox_promoCode = By.id("discount_form_promo_code");
    By textBox_amount_of_users = By.id("discount_form_max_use_count");
    By textBox_amount_of_codes = By.id("discount_form_codes_amount");
    By textBox_batch_name = By.id("discount_form_batch_name-selectized");
    By textBox_discount_amount = By.id("discount_form_amount");
    By textBox_discount_type = By.id("discount_form_amount_type");
    By textBox_promoCode_starts = By.id("discount_form_starts_at");
    By textBox_promoCode_ends = By.id("discount_form_ends_at");
    By textBox_promoCode_notes = By.id("discount_form_notes");
    By button_create_promoCode = By.xpath("//input[@value='Save']");
    By button_batch_names = By.xpath("//a[normalize-space()='Batch Names']");

    // ****************** ACTIONS ****************************//

    /*
     * Method to create a new custom Promo Code
     *
     * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
     */
    public void create_CustomPromoCode(PromoCode promoCode) {
        waitForElementTobeDisplayed(button_New);
        clickOnButton(button_New, "Button new");
        waitForElementTobeDisplayed(label_NewPromoCode);
        enterText(textBox_promoCode, promoCode.getPromoCode(), "Promo Code  Textbox");
        enterText(textBox_amount_of_users, promoCode.getAmountOfUsers(), "Amount of Promo Code Users Textbox");
        enterText(textBox_discount_amount, promoCode.getDiscount(), "Promo Code Amount  Textbox");
        selectDropdown(textBox_discount_type,promoCode.getDiscountType(), "Promo Code Discount Type  Dropdown");
        enterText(textBox_promoCode_starts, promoCode.getStartsAt(), "Promo Code Starts Date  Textbox");
        enterText(textBox_promoCode_ends, promoCode.getEndsAt(), "Promo Code Ends Date  Textbox");
        enterText(textBox_promoCode_notes, promoCode.getPromoCodeNotes(), "Promo Code Notes  Textbox");
        clickOnButton(button_create_promoCode, "Create Promo Code Button");

        waitForElementTobeDisplayed(textBox_PromocodeSearch);
        enterText(textBox_PromocodeSearch, promoCode.getPromoCode(), "Search box");
        clickOnButton(button_Find, "Find button");
        waitForPageLoad(3);
        By promoCodeNameOnGrid = By.xpath("//td[contains(text(),'" + promoCode.getPromoCode() + "')]");
        waitForElementTobeDisplayed(promoCodeNameOnGrid);
        if (isElementDisplayed(promoCodeNameOnGrid)) {
            passStep("Promo Code " + promoCode.getPromoCode() + " has been displayed on grid");
            passStep("Promo Code creation is successful ...!!!");
        }
    }

    /*
     * Method to create a new auto generate Promo Code
     *
     * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
     */
    public void create_AutoGeneratePromoCode(PromoCode promoCode) {
        waitForElementTobeDisplayed(button_New);
        clickOnButton(button_New, "Button new");
        waitForElementTobeDisplayed(label_NewPromoCode);
        select_Radiobutton(radio_auto_generate,"Auto Generate Promo Code Radio Button");
        enterText(textBox_amount_of_users, promoCode.getAmountOfUsers(), "Amount of Promo Code Users Textbox");
        enterText(textBox_amount_of_codes, promoCode.getAmountOfCodes(), "Amount of Promo Codes Textbox");
        selectFromSearch(textBox_batch_name, promoCode.getBatchName(), "Batch Name Textbox");
        enterText(textBox_discount_amount, promoCode.getDiscount(), "Promo Code Amount  Textbox");
        selectDropdown(textBox_discount_type,promoCode.getDiscountType(), "Promo Code Discount Type  Dropdown");
        enterText(textBox_promoCode_starts, promoCode.getStartsAt(), "Promo Code Starts Date  Textbox");
        enterText(textBox_promoCode_ends, promoCode.getEndsAt(), "Promo Code Ends Date  Textbox");
        enterText(textBox_promoCode_notes, promoCode.getPromoCodeNotes(), "Promo Code Notes  Textbox");
        clickOnButton(button_create_promoCode, "Create Promo Code Button");

        clickOnButton(button_batch_names, "Batch Names Button");
        By promoCodeBatchNameOnGrid = By.xpath("//td[contains(text(),'" + promoCode.getBatchName() + "')]");
        waitForElementTobeDisplayed(promoCodeBatchNameOnGrid);
        if (isElementDisplayed(promoCodeBatchNameOnGrid)) {
            passStep("Promo Code Batch Name " + promoCode.getBatchName() + " has been displayed on grid");
            passStep("Auto Generated Promo Codes created successfully ...!!!");
        }
    }

}
