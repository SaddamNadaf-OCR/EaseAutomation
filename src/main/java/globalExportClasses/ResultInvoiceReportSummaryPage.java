package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;

public class ResultInvoiceReportSummaryPage extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String Report  = "//h3[@class='page-heading']";
	
	/* ******************************* Constructor ****************************** */

	public ResultInvoiceReportSummaryPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test; 
    }
	/* ******************************* Action ****************************** */
	
	//..........................Title of the page is Displayed or not................................//
    public void titleIsDisplayed() {
        try {
            if(isDisplayed(driver, Report)) {
                test.log(LogStatus.PASS, "Title is Displayed : List Of Invoices");
            }
        } catch (Exception e) {
            testFailSshot(driver, test);
            test.log(LogStatus.FAIL, "Title is not Displayed : List Of Invoices");
        }
    }

}
