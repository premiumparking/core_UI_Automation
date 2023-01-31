package pageObjects.OD;

import components.BaseClass;
import dataModel.OD.CashDeposit;
import org.openqa.selenium.By;

/*
 * Class which contains the web elements and performs cash deposits page activities (methods)
 *
 * Extends : BaseClass
 *
 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
 */
public class OD_CashDepositsPage extends BaseClass{

    // ****************** WEB ELEMENTS ****************************//
    By label_OperatorDashboard = By.xpath("//span[contains(text(),'Operator Dashboard')]");
    By label_CashDeposits = By.xpath("//h1[contains(text(),'Cash Deposits')]");
    By button_New = By.xpath("//a[normalize-space()='New']");
    By label_NewCashDeposit = By.xpath("//h1[normalize-space()='New Cash Deposit']");
    By textBox_bag_number = By.id("cash_deposit_bag_number");
    By textBox_pull_date = By.id("cash_deposit_business_date_on");
    By textBox_market_group = By.id("cash_deposit_market_id-selectized");
    By dd_cdLocation = By.id("cash_deposit_location_id");
    By textBox_employee_name = By.id("cash_deposit_cashier_id-selectized");
    By textBox_shift = By.id("cash_deposit_shift");
    By textBox_attachments = By.id("cash_deposit_files");
    By button_save_cash_deposit = By.xpath("//div//input[@value='Save']");

    // ****************** ACTIONS ****************************//

    /*
     * Method to create a new cash deposit
     *
     * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
     */

    public void create_CashDeposit(CashDeposit cashDeposit) {
        waitForElementTobeDisplayed(button_New);
        clickOnButton(button_New, "Button new");
        waitForElementTobeDisplayed(label_NewCashDeposit);
        enterText(textBox_bag_number, cashDeposit.getBagNumber(), "Bag Number Textbox");
        enterText(textBox_pull_date, cashDeposit.getPullDate(), "Pull Date Textbox");
        selectFromSearch(textBox_market_group, cashDeposit.getMarketGroup(), "Cash Deposit Market Group");
        waitForPageLoad(3);
        selectDropdown(dd_cdLocation, cashDeposit.getCdLocation(), "Cash Deposit Location");
        selectFromSearch(textBox_employee_name, cashDeposit.getEmployeeName(), "Employee Name Textbox");
        enterText(textBox_shift, cashDeposit.getShift(), "Shift Textbox");
        enterText(textBox_attachments, System.getProperty("user.dir") + cashDeposit.getAttachments(), "Attachments Textbox");
        clickOnButton(button_save_cash_deposit, "Button Create Cash Deposit");

        By cashDepositBagNumberOnGrid = By.xpath("//td[contains(.,'" + cashDeposit.getBagNumber() + "')]");
        waitForElementTobeDisplayed(cashDepositBagNumberOnGrid);
        if (isElementDisplayed(cashDepositBagNumberOnGrid)) {
            passStep("Cash Deposit Bag Number " + cashDeposit.getBagNumber() + " has been displayed on grid");
            passStep("Cash Deposit creation is successful ...!!!");
        }

    }
}
