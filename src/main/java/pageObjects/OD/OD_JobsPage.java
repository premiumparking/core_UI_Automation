package pageObjects.OD;

import components.BaseClass;
import dataModel.OD.Job;
import org.openqa.selenium.By;

/*
 * Class which contains the web elements and performs jobs page activities (methods)
 *
 * Extends : BaseClass
 *
 * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
 */
public class OD_JobsPage extends BaseClass{
    // ****************** WEB ELEMENTS ****************************//
    By label_OperatorDashboard = By.xpath("//span[contains(text(),'Operator Dashboard')]");
    By label_Jobs = By.xpath("//h2[contains(text(),'Jobs')]");
    By button_New = By.xpath("//a[normalize-space()='New']");
    By label_NewJob = By.xpath("//h1[normalize-space()='New Job']");
    By textBox_jobTitle = By.id("job_title");
    By textBox_jobLocation= By.id("job_location");
    By textBox_jobUrl = By.id("job_url");
    By textBox_jobDesc = By.xpath("//div[@contenteditable='true']//p");
    By button_create_job = By.xpath("//div//input[@value='Create Job']");

    // ****************** ACTIONS ****************************//

    /*
     * Method to create a new job
     *
     * Author : Pavan Prasad (pavanprasad.v@comakeit.com)
     */

    public void create_Job(Job job) {
        waitForElementTobeDisplayed(button_New);
        clickOnButton(button_New, "Button new");
        waitForElementTobeDisplayed(label_NewJob);
        enterText(textBox_jobTitle, job.getJobTitle(), "Job Title Textbox");
        enterText(textBox_jobLocation, job.getJobLocation(), "Job Location Textbox");
        enterText(textBox_jobUrl, job.getJobUrl(), "Job Url Textbox");
        enterText(textBox_jobDesc, job.getJobDesc(), "Job Description Textbox");
        clickOnButton(button_create_job, "Button Create Job");

        By jobTitleOnGrid = By.xpath("//td[contains(.,'" + job.getJobTitle() + "')]");
        waitForElementTobeDisplayed(jobTitleOnGrid);
        if (isElementDisplayed(jobTitleOnGrid)) {
            passStep("Job " + job.getJobTitle() + " has been displayed on grid");
            passStep("Job creation is successful ...!!!");
        }

    }
}
