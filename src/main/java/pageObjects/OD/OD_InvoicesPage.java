package pageObjects.OD;

import components.BaseClass;
import dataModel.OD.Invoice;
import org.openqa.selenium.By;

/*
 * Class which contains the web elements and performs invoices page activities (methods)
 *
 * Extends : BaseClass
 *
 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
 */
public class OD_InvoicesPage extends BaseClass {
    // ****************** CLASS INSTANCES ****************************//
    OD_HomePage homepage = new OD_HomePage();

    // ****************** WEB ELEMENTS ****************************//
    By label_OperatorDashboard = By.xpath("//span[contains(text(),'Operator Dashboard')]");
    By label_Invoices = By.xpath("//h1[contains(text(),'Invoices')]");
    By button_New = By.xpath("//a[contains(text(),'New')]");
    By label_NewInvoice = By.xpath("//h2[contains(text(),'New Invoice')]");
    By textBox_invoicePayer = By.id("invoice_form_payer_uid-selectized");
    By button_confirm = By.xpath("//input[@value='Confirm']");
    By textBox_invoiceLocation = By.id("post_payment_form_location_id-selectized");
    By textBox_invoiceStartsAt = By.id("post_payment_form_resource_starts_at");
    By textBox_invoiceEndsAt = By.id("post_payment_form_resource_ends_at");
    By textBox_dollarAmount = By.id("post_payment_form_resource_amount");
    By button_create_invoice = By.xpath("//input[@value='Add Location Rental']");
    By label_create_invoice = By.xpath("(//h1)[1]");

    // ****************** ACTIONS ****************************//

    /*
     * Method to create a new invoice
     *
     * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
     */
    public void create_Invoice(Invoice invoice) {
        waitForElementTobeDisplayed(button_New);
        clickOnButton(button_New, "Button new");
        waitForElementTobeDisplayed(label_NewInvoice);
        selectFromSearch(textBox_invoicePayer, invoice.getInvoicePayer(), "Invoice Payer  Textbox");
        waitForPageLoad(2);
        clickOnButton(button_confirm, "Confirm Button");
        invoice.setInvoiceNumber(getElementText(label_create_invoice));
        String invoiceNumber = invoice.getInvoiceNumber().split(" ")[2].trim();
        passStep(getElementText(label_create_invoice));
        enterText(textBox_invoiceEndsAt, invoice.getInvoiceEndsAt(), "Ends Date  Textbox");
        enterText(textBox_invoiceStartsAt, invoice.getInvoiceStartsAt(), "Starts Date Textbox");
        selectFromSearch(textBox_invoiceLocation, invoice.getInvoiceLocation(), "Invoice Location  Textbox");
        enterText(textBox_dollarAmount, invoice.getInvoiceDollarAmount(), "Invoice Dollar Amount  Textbox");
        clickOnButton(button_create_invoice, "Create Invoice Button");

        By invoiceNumberAfterCreation = By.xpath("//h1[contains(text(),'Invoice " + invoiceNumber + "')]");
        waitForElementTobeDisplayed(invoiceNumberAfterCreation);
        if (isElementDisplayed(invoiceNumberAfterCreation)) {
            passStep("Invoice with number " + invoiceNumber + " has been displayed ");
            passStep("Invoice creation is successful ...!!!");
        }
    }
}
