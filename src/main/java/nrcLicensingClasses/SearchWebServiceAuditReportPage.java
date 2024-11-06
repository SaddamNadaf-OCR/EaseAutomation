package nrcLicensingClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;

public class SearchWebServiceAuditReportPage extends GenericMethods{
	
	public static WebDriver driver;
	public static ExtentTest test;
	
	//..................................Locators........................................//
		public static final String NRC_Report_Search ="//button[contains(text(),'Search')]";
		public static final String NRC_Report_Reset ="//button[contains(text(),'Reset')]";
		public static final String NRC_Report_SBUCode ="//select[@name='sbuCode']";
		public static final String NRC_Report_userID = "//input[@name='userID']";
		public static final String NRC_Report_requestType = "//select[@name='requestType']";
		public static final String NRC_Report_requestDateFrom = "//input[@name='requestDateFrom']";
		public static final String NRC_Report_messageType = "//select[@name='messageType']";
		public static final String NRC_Report_requestDateTo = "//input[@name='requestDateTo']";
		public static final String NRC_Report_status = "//select[@name='status']";
		public static final String NRC_Report_referenceNo ="//input[@name='referenceNo']";
		public static final String NRC_Report_AuditId ="//input[@name='wsAuditId']";
	
	//..................................Constructors..................................//
	public SearchWebServiceAuditReportPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	//...................................Click on Search Button...................................//
	public void search() {
		clickElement(driver, test, NRC_Report_Search, "Clicking on Search button :");
	}
	
	//....................................Click on Reset Button..................................//
	public void reset() {
		clickElement(driver, test, NRC_Report_Reset, "Clicking on Reset Button :");
	}
	
	//..................................Search By Parameters....................................//
	public void searchbyParameters(String SBUCode, String UserID, String RequestDateFrom) {
		
		selectByVisibleText(driver, test, NRC_Report_SBUCode, "Selecting SBU Code :", SBUCode);
		typeText(driver, test, NRC_Report_userID, "Entering User ID :", UserID);
		if(RequestDateFrom.length() > 0) {
			clickElement(driver, test, NRC_Report_requestDateFrom, "Clicking on Request Date From :");
			dateOfMonthName(driver, test, "Selecting Request Date From :", RequestDateFrom);
		}
	}

}
