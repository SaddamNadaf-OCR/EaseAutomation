package vmsClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class SearchVisitorRegReportPage extends GenericMethods{
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */ 

	public static final String OCR_Reports_VisitorID ="//input[@id='resultVisitorRegistrationReport_visitorId']";
	public static final String OCR_Reports_LogVisitorID ="//input[@id='resultVistorsLogVrsReport_visitorGeneralInfoValue_visitorId']";
	public static final String OCR_Reports_SearchButton ="(//button[@class= 'primary-btn'])[1]";

	/* ******************** Constructor ***************************** */

	public SearchVisitorRegReportPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	// Enter Visitor request id 
	public void ReportsVID(String vid){
		typeText(driver, test, OCR_Reports_VisitorID, "Enter Visitor ID under reports: ", vid);
	}
	//Enter Visitor Request id under visitor log report screen
	
	public void LogReportsVID(String vid){
		typeText(driver, test, OCR_Reports_LogVisitorID, "Enter Visitor ID under log reports: ", vid);
	}
	
	// Click on search button on reports
	public void click_SearchReport() {
		Wait.waitfor(5);
		clickElement(driver, test, OCR_Reports_SearchButton, "Clicking on search button on reports");
	
	}
	
	// Validating No records found message in Visitor log report screen
		public void validating_Norecordsfound() throws Exception {
			try {
				if (isDisplayed(driver,"//label[contains(text(), 'No Records found.')]")) {
					test.log(LogStatus.PASS, "No Records found for the entered request id because of that visitor is On Hold");
				}

			} catch (Exception e) {
				test.log(LogStatus.FAIL, "Error message is not displayed for the selected request id");
				testFailSshot(driver, test);		
			}
		}

	//Getting the visitor first name
	public String getFirstName(String FirstName) {
		String ReportFN = "//div[@class='jasper-report']//table//tr//td/p/span[contains(text(),'"+FirstName+"')]";
		return getText(driver, test, ReportFN, "getting the Visitor first name under reprots : ");

	}
}