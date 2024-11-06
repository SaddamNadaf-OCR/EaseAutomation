package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class ResultShipmentProcessingStatisticsReportPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String Report  = "//h3[@class='page-heading']";
	
	public static final String ExportToExcel  = "(//a[@class='downloadFile'])[1]";
	public static final String ExportToPdf  = "(//a[@class='downloadFile'])[2]";
	public static final String BackToSearchpage  = "//img[@title='Back to Search Page']";
	public static final String ViewChart = "//img[@src='./images/chart.png']";
	public static final String GotoFirstPage = "//img[@src='data/img/first_grey.GIF']";
	public static final String GotoPreviousPage = "//img[@src='data/img/previous_grey.GIF']";
	public static final String GotoNextPage = "//img[@alt='Go To Next Page']";
	public static final String GotoLastPage = "//img[@alt='Go To Last Page']";
	public static final String EnterPgNum = "//input[@id='pageId']";
	public static final String GoBtn = "//img[@src='data/img/go.png']";
	
	/* ******************************* Constructor ****************************** */

	public ResultShipmentProcessingStatisticsReportPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test; 
    }
	/* ******************************* Action ****************************** */
	//..........................Title of the page is Displayed or not................................//
	
    public void titleIsDisplayed() {
        try {
            if(isDisplayed(driver, Report)) {
                test.log(LogStatus.PASS, "Title is Displayed : SHIPMENT PROCESSING STATISTICS REPORT");
            }
        } catch (Exception e) {
            testFailSshot(driver, test);
            test.log(LogStatus.FAIL, "Title is not Displayed : SHIPMENT PROCESSING STATISTICS REPORT");
        }
    }
    
    public void IconsDisplay() {
    	Wait.waitfor(2);
        try {
            if(isDisplayed(driver, ExportToExcel)) {
                test.log(LogStatus.PASS, "Export to Excel Icon is Displayed :");
            }
        }catch(Exception e) {
            testFailSshot(driver, test);
            test.log(LogStatus.FAIL, "Export To Excel Icon is Not Displayed :");
        }
        Wait.waitfor(2);
        try {
            if(isDisplayed(driver, ExportToPdf)) {
                test.log(LogStatus.PASS, "Export to PDF Icon is Displayed :");
            }
        }catch(Exception e) {
            testFailSshot(driver, test);
            test.log(LogStatus.FAIL, "Export To PDF Icon is Not Displayed :");
        }
        Wait.waitfor(2);
        try {
            if(isDisplayed(driver, BackToSearchpage)) {
                test.log(LogStatus.PASS, "Back to search page Icon is Displayed :");
            }
        }catch(Exception e) {
            testFailSshot(driver, test);
            test.log(LogStatus.FAIL, "Back to search page Icon is Not Displayed :");
        }
        Wait.waitfor(2);
//        try {
//            if(isDisplayed(driver, ViewChart)) {
//                test.log(LogStatus.PASS, "View Chart Icon is Displayed :");
//            }
//        }catch(Exception e) {
//            testFailSshot(driver, test);
//            test.log(LogStatus.FAIL, "View Chart Icon is Not Displayed :");
//        }
//        Wait.waitfor(2);
        try {
            if(isDisplayed(driver, GotoFirstPage)) {
                test.log(LogStatus.PASS, "Go to first page Icon is Displayed :");
            }
        }catch(Exception e) {
            testFailSshot(driver, test);
            test.log(LogStatus.FAIL, "Go to first page Icon is Not Displayed :");
        }
        Wait.waitfor(2);
        try {
            if(isDisplayed(driver, GotoPreviousPage)) {
                test.log(LogStatus.PASS, "Go to previous page Icon is Displayed :");
            }
        }catch(Exception e) {
            testFailSshot(driver, test);
            test.log(LogStatus.FAIL, "Go to previous page Icon is Not Displayed :");
        }
        Wait.waitfor(2);
        try {
            if(isDisplayed(driver, GotoNextPage)) {
                test.log(LogStatus.PASS, "Go to next page Icon is Displayed :");
            }
        }catch(Exception e) {
            testFailSshot(driver, test);
            test.log(LogStatus.FAIL, "Go to next page Icon is Not Displayed :");
        }
        Wait.waitfor(2);
        try {
            if(isDisplayed(driver, GotoLastPage)) {
                test.log(LogStatus.PASS, "Go to last page Icon is Displayed :");
            }
        }catch(Exception e) {
            testFailSshot(driver, test);
            test.log(LogStatus.FAIL, "Go to last page Icon is Not Displayed :");
        }
        Wait.waitfor(2);
        try {
            if(isDisplayed(driver, EnterPgNum)) {
                test.log(LogStatus.PASS, "Enter page number textbox is Displayed :");
            }
        }catch(Exception e) {
            testFailSshot(driver, test);
            test.log(LogStatus.FAIL, "Enter page number textbox is Not Displayed :");
        }
        Wait.waitfor(2);
        try {
            if(isDisplayed(driver, GoBtn)) {
                test.log(LogStatus.PASS, "Go button is Displayed :");
            }
        }catch(Exception e) {
            testFailSshot(driver, test);
            test.log(LogStatus.FAIL, "Go button is Not Displayed :");
        }
    }
    
    public void backToSearchBtn() {
    	Wait.waitfor(2);
    	clickElement(driver, test, BackToSearchpage, "Click on Back to Search button to go back to main page :");
    }

    

}
