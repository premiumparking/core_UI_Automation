package pageObjects.OD;

import components.BaseClass;
import org.openqa.selenium.By;

/*
 * Class which contains the web elements and performs text pay jobs page activities (methods)
 *
 * Extends : BaseClass
 *
 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
 */
public class OD_TextPayJobsPage extends BaseClass {

    // ****************** CLASS INSTANCES ****************************//
    OD_HomePage homepage = new OD_HomePage();

    // ****************** WEB ELEMENTS ****************************//
    By label_OperatorDashboard = By.xpath("//span[contains(text(),'Operator Dashboard')]");
    By label_TextPayJobs = By.xpath("//h2[contains(text(),'TextPay Jobs')]");
    By button_New = By.xpath("//a[contains(text(),'New')]");
    By label_NewTextPayJob = By.xpath("//h1[contains(text(),'New Textpay Job')]");
    By textBox_textPay_job_name = By.id("textpay_job_name");
    By textBox_textPay_job_description = By.id("textpay_job_description");
    By button_create_TextPayJob = By.xpath("//input[@value='Save']");

    // ****************** ACTIONS ****************************//

    /*
     * Method to create a new text pay job
     *
     * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
     */
    public void create_TextPayJob(String name) {
        waitForElementTobeDisplayed(button_New);
        clickOnButton(button_New, "Button new");
        waitForElementTobeDisplayed(label_NewTextPayJob);
        enterText(textBox_textPay_job_name, name, "Text Pay Job Name Textbox");
        enterText(textBox_textPay_job_description, "Text Pay Job Test Description", "Text Pay Job Description Textbox");
        clickOnButton(button_create_TextPayJob, "Save Button");

        By textPayJobNameOnGrid = By.xpath("//td[contains(text(),'" + name + "')]");
        waitForElementTobeDisplayed(textPayJobNameOnGrid);
        if (isElementDisplayed(textPayJobNameOnGrid)) {
            passStep("Text Pay Job name " + name + " has been displayed on grid");
            passStep("Text Pay Job creation is successful ...!!!");
        }

    }
}
