package crsClasses;


import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;
import utilities.Wait;

public class ImportSearchImportRequestPage extends GenericMethods{
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_SearchImpReq_AddReqBtn = "//button[@id='mybutton']";
	public static final String OCR_SearchImpReq_SbuID = "//select[@id='resultExportRequest_exportRequestValue_sbuCode']";
	public static final String OCR_SearchImpReq_RequestID = "//input[@id='resultExportRequest_exportRequestValue_expReqId']";
	public static final String OCR_SearchImpReq_SearchBtn = "//button[contains(text(),'Search')]";
	public static final String OCR_SearchImpReq_Status = "//select[@name='exportRequestValue.status']";
	public static final String OCR_SearchImpReq_RequestorName = "//input[@id='resultExportRequest_exportRequestValue_nameOfRequestor']";
	public static final String OCR_SearchImpReq_AuthorizationID = "//input[@id='resultExportRequest_exportRequestValue_expAuthId']";
	public static final String OCR_SearchImpReq_LicenseAppNo = "//input[@id='resultExportRequest_exportRequestValue_licenseTransactionId']";
	public static final String OCR_SearchImpReq_Determination = "//select[@name='exportRequestValue.disposition']";
	public static final String OCR_SearchImpReq_ReviewerName = "//select[@id='resultExportRequest_exportRequestValue_approverName']";
	public static final String OCR_SearchImpReq_RequestorDateFrom = "//input[@id='resultExportRequest_exportDateFrom']";
	public static final String OCR_SearchImpReq_RequestorDateTo = "//input[@id='resultExportRequest_exportDateTo']";
	public static final String OCR_SearchImpReq_ReviewDateFrom = "//input[@id='resultExportRequest_reviewDateFrom']";
	public static final String OCR_SearchImpReq_ReviewDateTo = "//input[@id='resultExportRequest_reviewDateTo']";
	public static final String OCR_SearchImpReq_ActivityType = "//select[@id='activityId']";
	public static final String OCR_SearchImpReq_AutorizationType = "//input[@id='resultExportRequest_exportRequestValue_itarNo']";
	public static final String OCR_SearchImpReq_AuthorizationNo = "//input[@id='resultExportRequest_exportRequestValue_licenseNo']";
	public static final String OCR_SearchImpReq_Segment = "//textarea[@id='resultExportRequest_exportRequestValue_segment']";
	public static final String OCR_SearchImpReq_Site = "//textarea[@id='resultExportRequest_exportRequestValue_site']";
	public static final String OCR_SearchImpReq_ProductLine = "//textarea[@id='resultExportRequest_exportRequestValue_prodLine']";
	public static final String OCR_SearchImpReq_ProductFamily = "//textarea[@id='resultExportRequest_exportRequestValue_prodFamily']";
	public static final String OCR_SearchImpReq_Program = "//textarea[@id='resultExportRequest_exportRequestValue_program']";
	public static final String OCR_SearchImpReq_Country = "//input[@id='resultExportRequest_countryCode']";
	public static final String OCR_SearchImpReq_Customer = "//input[@id='resultExportRequest_exportConsigneeValue_consigneeName']";
	public static final String OCR_SearchImpReq_OSRnumber = "//input[@id='resultExportRequest_exportRequestValue_osrNo']";
	public static final String OCR_SearchImpReq_Priority = "//select[@name='exportRequestValue.priority']";
	public static final String OCR_SearchImpReq_SubmitDateFrom = "//input[@id='resultExportRequest_submitDate']";
	public static final String OCR_SearchImpReq_SubmitDateTo = "//input[@id='resultExportRequest_submitDateTo']";
	public static final String OCR_SearchImpReq_SalesOrderNo = "//input[@id='resultExportRequest_exportRequestValue_salesOrderNo']";

	/* ******************** Constructor ***************************** */

	public ImportSearchImportRequestPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	// Click on Add Request Btn
	public void click_AddRequest(){
		Wait.waitfor(2);
		clickElement(driver, test, OCR_SearchImpReq_AddReqBtn, "Clicking on Add Request button");
	}

	//Select the SBUID and Request ID 
	public void selectSbuID(String SbuID, String RequestID) {
		selectByVisibleText(driver, test, OCR_SearchImpReq_SbuID, "Select the SBU ID : ", SbuID);
		typeText(driver, test, OCR_SearchImpReq_RequestID, "Enter the Request ID : ", RequestID);
	}

	//Click on Search button
	public void click_SearchBtn() {
		clickElement(driver, test, OCR_SearchImpReq_SearchBtn, "Click on Search button");
	}

	//Search results with different parameters(Smoke Level Test Cases)
	public void searchParameters(String SbuID, String AuthorizationID, String LicenseAppNo, 
			String Status, String Determination) {
		
		selectByVisibleText(driver, test, OCR_SearchImpReq_SbuID, "Select the SBU ID : ", SbuID);
		typeText(driver, test, OCR_SearchImpReq_AuthorizationID, "Enter Authorization ID : ",AuthorizationID);
		typeText(driver, test, OCR_SearchImpReq_LicenseAppNo, "Eneter License App No", LicenseAppNo);
		selectByVisibleText(driver, test, OCR_SearchImpReq_Status, "Select the Status : ", Status);
		selectByVisibleText(driver, test, OCR_SearchImpReq_Determination, "Enter Determination : ", Determination);
	}
	
	//Search results with different parameters(Regression Level Test Cases)
		public void searchParameters(String SbuID, String AuthorizationID, String RequestID, String LicenseAppNo, 
				String Status, String Determination, String RequestorName,String ReviewerName, String RequestorDateFrom, String RequestorDateTo,
				String ReviewDateFrom, String ReviewDateTo, String ActivityType, String AutorizationType, String AuthorizationNo, String Segment,
				String Site, String ProductLine, String ProductFamily, String Program, String Country, String Customer, String OSRnumber,
				String Priority, String SubmitDateFrom, String SubmitDateTo, String SalesOrderNo) {
			
			selectByVisibleText(driver, test, OCR_SearchImpReq_SbuID, "Select the SBU ID : ", SbuID);
			typeText(driver, test, OCR_SearchImpReq_AuthorizationID, "Enter Authorization ID : ",AuthorizationID);
			typeText(driver, test, OCR_SearchImpReq_RequestID, "Enter RequestID : ", RequestID);
			typeText(driver, test, OCR_SearchImpReq_LicenseAppNo, "Eneter License App No", LicenseAppNo);
			selectByVisibleText(driver, test, OCR_SearchImpReq_Status, "Select the Status : ", Status);
			selectByVisibleText(driver, test, OCR_SearchImpReq_Determination, "Enter Determination : ", Determination);
			typeText(driver, test, OCR_SearchImpReq_RequestorName, "Enter Requestor Name : ", RequestorName);
			selectByVisibleText(driver, test, OCR_SearchImpReq_ReviewerName, "Select the ReviewerName : ", ReviewerName);
			if(RequestorDateFrom.length()>0) {
				Wait.waitfor(3);
				clickElement(driver, test, OCR_SearchImpReq_RequestorDateFrom, "Click on Requestor Date From");
				date(driver, test, "Select the Requestor Date : ", RequestorDateFrom);
				clickElement(driver, test, OCR_SearchImpReq_RequestorDateTo, "Click on Requestor Date To");
				date(driver, test, "Select the Requestor Date To : ", RequestorDateTo);
			}
			if(ReviewDateFrom.length()>0) {
				Wait.waitfor(3);
				clickElement(driver, test, OCR_SearchImpReq_ReviewDateFrom, "Click on Review Date from");
				date(driver, test, "Select the Review Date From : ", ReviewDateFrom);
				clickElement(driver, test, OCR_SearchImpReq_ReviewDateTo, "Click on Review Date To ");
				date(driver, test, "Select the Review Date To : ", ReviewDateTo);
			}
			selectByVisibleText(driver, test, OCR_SearchImpReq_ActivityType, "Select the ActivityType : ", ActivityType);
			typeText(driver, test, OCR_SearchImpReq_AutorizationType, "Enter the Autorization Type : ", AutorizationType);
			typeText(driver, test, OCR_SearchImpReq_AuthorizationNo, "Enter the Authorization No : ", AuthorizationNo);
			typeText(driver, test, OCR_SearchImpReq_Segment, "Enter the Segment : ", Segment);
			typeText(driver, test, OCR_SearchImpReq_Site, "Enter the Site : ", Site);
			typeText(driver, test, OCR_SearchImpReq_ProductLine, "Enter the ProductLine : ", ProductLine);
			typeText(driver, test, OCR_SearchImpReq_ProductFamily, "Enter product Family : ",ProductFamily);
			typeText(driver, test, OCR_SearchImpReq_Program, "Enter Program : ", Program);
			typeText(driver, test, OCR_SearchImpReq_Country, "Enter Country : ", Country);
			typeText(driver, test, OCR_SearchImpReq_Customer, "Enter Customer/Consignee : ", Customer);
			typeText(driver, test, OCR_SearchImpReq_OSRnumber, "Enter OSR Number : ", OSRnumber);
			selectByVisibleText(driver, test, OCR_SearchImpReq_Priority, "Select the Priority : ", Priority);
			if(SubmitDateFrom.length()>0) {
				Wait.waitfor(3);
				clickElement(driver, test, OCR_SearchImpReq_SubmitDateFrom , "Click on Submit Date From");
				date(driver, test, "Select the Submit Date From : ", SubmitDateFrom);
				clickElement(driver, test, OCR_SearchImpReq_SubmitDateTo , "Click on Submit Date To ");
				date(driver, test, "Select the Submit Date To : ", SubmitDateTo);
			}
			typeText(driver, test, OCR_SearchImpReq_SalesOrderNo, "Enter Sales Order No : ", SalesOrderNo);
		}

}
