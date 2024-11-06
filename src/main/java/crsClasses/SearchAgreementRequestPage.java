package crsClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class SearchAgreementRequestPage extends GenericMethods{

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_SearchAgreementReq_AddRequest = "//button[@id='mybutton']";
	public static final String OCR_SearchAgrReq_SbuID = "//select[@id='resultExportRequest_exportRequestValue_sbuCode']";
	public static final String OCR_SearchAgrReq_AuthorizationID = "//input[@id='resultExportRequest_exportRequestValue_expAuthId']";
	public static final String OCR_SearchAgrReq_SearchBtn = "//button[contains(text(),'Search')]";
	public static final String OCR_SearchAgrReq_RequestId = "//input[@id='resultExportRequest_exportRequestValue_expReqId']";
	public static final String OCR_SearchAgrReq_LicenseAppNo = "//input[@id='resultExportRequest_exportRequestValue_licenseTransactionId']";
	public static final String OCR_SearchAgrReq_LicenseNo = "//input[@id='resultExportRequest_exportRequestValue_licenseNo']";
	public static final String OCR_SearchAgrReq_LicenseType = "//select[@name='exportRequestValue.licenseType']";
	public static final String OCR_SearchAgrReq_Status = "//select[@name='exportRequestValue.status']";
	public static final String OCR_SearchAgrReq_Determination = "//select[@name='exportRequestValue.disposition']";
	public static final String OCR_SearchAgrReq_RequestorName = "//input[@id='resultExportRequest_exportRequestValue_nameOfRequestor']";
	public static final String OCR_SearchAgrReq_ReviewerName = "//select[@id='resultExportRequest_exportRequestValue_approverName']";
	public static final String OCR_RequiredByDate_Today = "//button[contains(text(),'Today')]";
	public static final String OCR_SearchAgrReq_RequestDateFrom ="//input[@id='resultExportRequest_exportDateFrom']";
	public static final String OCR_SearchAgrReq_RequestDateTo ="//input[@id='resultExportRequest_exportDateTo']";
	public static final String OCR_SearchAgrReq_ReviewDateFrom ="//input[@id='resultExportRequest_reviewDateFrom']";
	public static final String OCR_SearchAgrReq_ReviewDateTo="//input[@id='resultExportRequest_reviewDateTo']";
	public static final String OCR_SearchAgrReq_Segment="//textarea[@id='resultExportRequest_exportRequestValue_segment']";
	public static final String OCR_SearchAgrReq_Site="//textarea[@id='resultExportRequest_exportRequestValue_site']";
	public static final String OCR_SearchAgrReq_ProductLine="//textarea[@id='resultExportRequest_exportRequestValue_prodLine']";
	public static final String OCR_SearchAgrReq_ProductFamily="//textarea[@id='resultExportRequest_exportRequestValue_prodFamily']";
	public static final String OCR_SearchAgrReq_Program="//textarea[@id='resultExportRequest_exportRequestValue_program']";
	public static final String OCR_SearchAgrReq_Country="//input[@id='resultExportRequest_countryCode']";
	public static final String OCR_SearchAgrReq_CustomerOrConsignee="//input[@id='resultExportRequest_exportConsigneeValue_consigneeName']";
	public static final String OCR_SearchAgrReq_AgreementType = "//select[@name='exportRequestValue.taa']";
	public static final String OCR_SearchAgrReq_IsthisaRebaselineY="//input[@id='resultExportRequest_exportRequestValue_iblY']";
	public static final String OCR_SearchAgrReq_IsthisaRebaselineN="//input[@id='resultExportRequest_exportRequestValue_iblN']"; 
	public static final String OCR_SearchAgrReq_IsthisanAmendmenttoanexistingAgreementY="//input[@id='resultExportRequest_exportRequestValue_aaggrY']";
	public static final String OCR_SearchAgrReq_IsthisanAmendmenttoanexistingAgreementN="//input[@id='resultExportRequest_exportRequestValue_aaggrN']";
	public static final String OCR_SearchAgrReq_Priority= "//select[@name='exportRequestValue.priority']";
	public static final String OCR_SearchAgrReq_SortBy= "//select[@name='sortBy']";
	public static final String OCR_SearchAgrReq_SubmitDateFrom ="//input[@id='resultExportRequest_submitDate']";
	public static final String OCR_SearchAgrReq_SubmitDateTo ="//input[@id='resultExportRequest_submitDateTo']";
	public static final String OCR_SearchAgrReq_Direction= "//select[@name='direction']";
	public static final String OCR_SearchAgrReq_SalesOrderNo="//input[@id='resultExportRequest_exportRequestValue_salesOrderNo']";


	/* ******************** Constructor ***************************** */

	public SearchAgreementRequestPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	//click on Add Request button	
	public void click_AddRequestBtn(){
		Wait.waitfor(3);
		clickElement(driver, test, OCR_SearchAgreementReq_AddRequest, "Clicking on Add Request button");
	}

	//Select the SBUID and Request ID 
	public void selectSbuID(String SbuID, String RequestID) {
		selectByVisibleText(driver, test, OCR_SearchAgrReq_SbuID, "Select the SBU ID : ", SbuID);
		typeText(driver, test, OCR_SearchAgrReq_RequestId, "Enter the Request ID : ", RequestID);
	}
	
	//Select the SBUID and Request ID 
	public void selectReqID(String RequestID) {
		typeText(driver, test, OCR_SearchAgrReq_RequestId, "Enter the Request ID : ", RequestID);
	}

	//Click on Search button
	public void click_SearchBtn() {
		scrollToTop(driver);
		Wait.waitfor(3);
		clickElement(driver, test, OCR_SearchAgrReq_SearchBtn, "Click on Search button");
	}

	//Search results with different parameters(Smoke Level Test)
	public void searchParameters(String SbuID, String AuthorizationID, String LicenseNo, String LicenseType,
			String Status) {

		selectByVisibleText(driver, test, OCR_SearchAgrReq_SbuID, "Select the SBU ID : ", SbuID);
		typeText(driver, test, OCR_SearchAgrReq_AuthorizationID, "Enter Authorization ID : ",AuthorizationID);
		typeText(driver, test, OCR_SearchAgrReq_LicenseNo, "Enter License App No", LicenseNo);
		selectByVisibleText(driver, test, OCR_SearchAgrReq_LicenseType, "Select the Status : ", LicenseType);
		selectByVisibleText(driver, test, OCR_SearchAgrReq_Status, "Select the Status : ", Status);
	}
	
	//Search results with different parameters(Regression Level Test)(Method overloaded For Regression Test Cases)
	public void searchParameters(String SbuID, String AuthorizationID, String RequestID, String LicenseAppNo, String LicenseNo, 
			String LicenseType, String Status, String Determination, String RequestorName,String ReviewerName, String RequestorDateFrom, 
			String RequestorDateTo,	String ReviewDateFrom, String ReviewDateTo, String Segment, String Site,String ProductLine, 
			String ProductFamily, String Program, String Country, String CustomerOrConsignee, String AgreementType, String Rebaseline, 
			String Amendment, String Priority, String SortBy, String SubmitDateFrom, String SubmitDateTo,String Direction,String SalesOrderNo) {

		selectByVisibleText(driver, test, OCR_SearchAgrReq_SbuID, "Select the SBU ID : ", SbuID);
		typeText(driver, test, OCR_SearchAgrReq_AuthorizationID, "Enter Authorization ID : ",AuthorizationID);
		typeText(driver, test, OCR_SearchAgrReq_RequestId, "Enter RequestID : ", RequestID);
		typeText(driver, test, OCR_SearchAgrReq_LicenseAppNo, "Enter License App No", LicenseAppNo);
		typeText(driver, test, OCR_SearchAgrReq_LicenseNo, "Enter License App No", LicenseNo);
		selectByVisibleText(driver, test, OCR_SearchAgrReq_LicenseType, "Select the Status : ", LicenseType);
		selectByVisibleText(driver, test, OCR_SearchAgrReq_Status, "Select the Status : ", Status);
		selectByVisibleText(driver, test, OCR_SearchAgrReq_Determination, "Enter Determination : ", Determination);
		typeText(driver, test, OCR_SearchAgrReq_RequestorName, "Enter Requestor Name : ", RequestorName);
		selectByVisibleText(driver, test, OCR_SearchAgrReq_ReviewerName, "Select the ReviewerName : ", ReviewerName);
		if(RequestorDateFrom.length() > 0) {
			clickElement(driver, test, OCR_SearchAgrReq_RequestDateFrom, "Clicking on Requestor Date From");
			if (RequestorDateFrom.contains("Today")) {
				clickElement(driver, test, OCR_RequiredByDate_Today, "Clicking on Today: ");
				} else {
					dateOfMonthName(driver, test, "Selecting the Requestor Date From : ", RequestorDateFrom);
				}
		}
		if(RequestorDateTo.length() > 0) {
			clickElement(driver, test, OCR_SearchAgrReq_RequestDateTo, "Clicking on Requestor Date To");
			if (RequestorDateTo.contains("Today")) {
				clickElement(driver, test, OCR_RequiredByDate_Today, "Clicking on Today: ");
				} else {
					dateOfMonthName(driver, test, "Selecting the Requestor Date To : ", RequestorDateTo);
				}
		}
		if(ReviewDateFrom.length() > 0) {
			clickElement(driver, test, OCR_SearchAgrReq_ReviewDateFrom, "Clicking on Review Date From");
			if (ReviewDateFrom.contains("Today")) {
				clickElement(driver, test, OCR_RequiredByDate_Today, "Clicking on Today: ");
				} else {
					dateOfMonthName(driver, test, "Selecting the Review Date From : ", ReviewDateFrom);
				}
		}
		if(ReviewDateTo.length()>0) {
			clickElement(driver, test, OCR_SearchAgrReq_ReviewDateTo, "Clicking on Review Date To");
			if (ReviewDateTo.contains("Today")) {
				clickElement(driver, test, OCR_RequiredByDate_Today, "Clicking on Today: ");
				} else {
					dateOfMonthName(driver, test, "Selecting the Review Date To : ", ReviewDateTo);
				}
		}
		Wait.waitfor(3);
		typeText(driver, test, OCR_SearchAgrReq_Segment, "Enter the Autorization Type : ",Segment);
		typeText(driver, test, OCR_SearchAgrReq_Site, "Enter the Authorization No : ", Site);
		typeText(driver, test, OCR_SearchAgrReq_ProductLine, "Enter the Segment : ",ProductLine);
		typeText(driver, test, OCR_SearchAgrReq_ProductFamily, "Enter the Site : ", ProductFamily);		
		typeText(driver, test, OCR_SearchAgrReq_Program, "Enter Program : ", Program);
		typeText(driver, test, OCR_SearchAgrReq_Country, "Enter Country : ", Country);
		typeText(driver, test, OCR_SearchAgrReq_CustomerOrConsignee, "Enter Customer/Consignee : ", CustomerOrConsignee);
		selectByVisibleText(driver, test, OCR_SearchAgrReq_AgreementType, "Select the ActivityType : ", AgreementType);
		if(Rebaseline.contains("Y")) {
			clickElement(driver, test, OCR_SearchAgrReq_IsthisaRebaselineY,"Clicking on Rebaseline Yes Radio Button: ");
		}
		else if(Rebaseline.contains("N")) {
			clickElement(driver, test, OCR_SearchAgrReq_IsthisaRebaselineN,"Clicking on Rebaseline No Radio Button: ");	
		}
		if(Amendment.contains("Y")) {
			clickElement(driver, test, OCR_SearchAgrReq_IsthisanAmendmenttoanexistingAgreementY,"Clicking on Amendment Yes Radio Button: ");
		}
		else if(Amendment.contains("N")) {
			clickElement(driver, test, OCR_SearchAgrReq_IsthisanAmendmenttoanexistingAgreementN,"Clicking on Amendment No Radio Button: ");	
		}
				
		selectByVisibleText(driver, test, OCR_SearchAgrReq_Priority, "Select the Priority : ", Priority);
		
		selectByVisibleText(driver, test, OCR_SearchAgrReq_SortBy, "Select the Sort By : ",SortBy);
		scrollToElement(driver, "//label[contains(text(), 'Sales Order No.')]");
		Wait.waitfor(3);
		if(SubmitDateFrom.length()> 0) {
			clickElement(driver, test, OCR_SearchAgrReq_SubmitDateFrom, "Clicking on Submit Date From");
			if (SubmitDateFrom.contains("Today")) {
				clickElement(driver, test, OCR_RequiredByDate_Today, "Clicking on Today: ");
				} else {
					dateOfMonthName(driver, test, "Selecting the Submit Date From : ", SubmitDateFrom);
				}
		}
		if(SubmitDateTo.length()>0) {
			clickElement(driver, test, OCR_SearchAgrReq_SubmitDateTo, "Clicking on Submit Date To");
			if (SubmitDateTo.contains("Today")) {
				clickElement(driver, test, OCR_RequiredByDate_Today, "Clicking on Today: ");
				} else {
					dateOfMonthName(driver, test, "Selecting the Submit Date To : ", SubmitDateTo);
				}
			}
		Wait.waitfor(3);
		scrollToElement(driver, "//label[contains(text(), 'Direction')]");
		selectByVisibleText(driver, test, OCR_SearchAgrReq_Direction, "Select the Direction : ", Direction);
		scrollToElement(driver, "//label[contains(text(), 'Sales Order No.')]");
		typeText(driver, test, OCR_SearchAgrReq_SalesOrderNo, "Enter Sales Order No : ", SalesOrderNo);
	}
}
