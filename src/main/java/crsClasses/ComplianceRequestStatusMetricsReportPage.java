package crsClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;

public class ComplianceRequestStatusMetricsReportPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	
	public static final String CRS_Reports_Search = "(//button[contains(text(),'Search')])[1]"; 
	public static final String CRS_Reports_Reset = "(//button[contains(text(),'Reset')])[1]";
	public static final String CRS_Reports_SBUCode = "//select[@name='complianceRequestForm.sbuCode']";
	public static final String CRS_Reports_RequestID = "//input[@name='complianceRequestForm.expReqId']";
	public static final String CRS_Reports_CRSStatus = "//select[@name='complianceRequestForm.status']";
	public static final String CRS_Reports_Determination = "//select[@name='complianceRequestForm.disposition']";
	public static final String CRS_Reports_RequesterName = "//input[@name='complianceRequestForm.nameOfRequestor']";
	public static final String CRS_Reports_ExportFocalPoint = "//a[contains(text(),'Export Focal Point')]";
	public static final String CRS_Reports_UserFirstName = "//input[@name='userProfile.userFirstname']";
	public static final String CRS_Reports_SearchPopUp = "//button[@name='Search']";
	public static final String CRS_Reports_SelectPopUp = "(//button[@name='Ok'])[1]";
	public static final String CRS_Reports_ClosePopup = "//button[@class='btn-close']";
	public static final String CRS_Reports_ReasonforReturn = "//a[contains(text(),' Reason for Return')]";
	public static final String CRS_Reports_ReasonForReturnPopUp = "//input[@name='turnbackCategoryValue.turnbackCode']";
	public static final String CRS_Reports_ReasonForReturnTextBox = "//input[@name='complianceRequestForm.trnbackDesc']";
	public static final String CRS_Reports_TechnicalFocalPoint = "//a[contains(text(),' Technical Focal Point')]";
	public static final String OCR_Reports_TFPUserFirstName = "//input[@name='userProfile.userFirstname']";
	public static final String CRS_Reports_CRDateInitiatedFrom = "//input[@name='fromDateInitiatedCR']";
	public static final String CRS_Reports_CRDateInitiatedTo = "//input[@name='toDateInitiatedCR']";
	public static final String CRS_Reports_CRSubmittedFrom = "//input[@name='fromSubmittedCR']";
	public static final String CRS_Reports_CRSubmittedTo = "//input[@name='toSubmittedCR']";
	public static final String CRS_Reports_CRDetermainationDateFrom = "//input[@name='fromDetermainationDate']";
	public static final String CRS_Reports_CRDetermainationDateTo = "(//button[contains(text(),'Search')])[1]";
	
	
	//.........................................Constructor .........................................//
	public ComplianceRequestStatusMetricsReportPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	//...................................Click on Search Button...................................//
	public void search() {
		clickElement(driver, test, CRS_Reports_Search, "Clicking on Search button :");
	}
	
	//....................................Click on Reset Button..................................//
	public void reset() {
		clickElement(driver, test, CRS_Reports_Reset, "Clicking on Reset Button :");
	}
	
	//....................................Search By Parameters ..................................//
	public void searchByParameters(String SBUCode, String RequestID, String Status, String Determination, String RequesterName, 
			String ExportFocalPoint, String ReasonForReturn, String TechnicalFocalPoint, String DateInitiatedFrom, String DateInitiatedTo, 
			String DateSubmittedFrom, String DateSubmittedTo, String DetermainationDateFrom, String DetermainationDateTo) {
		
		selectByVisibleText(driver, test, CRS_Reports_SBUCode, "Selecting SBU :", SBUCode);
		typeText(driver, test, CRS_Reports_RequestID, "Entering Compliance Request ID :", RequestID);
		selectByVisibleText(driver, test, CRS_Reports_CRSStatus, "Selecting CRS Status :", Status);
		selectByVisibleText(driver, test, CRS_Reports_Determination, "Selecting Determination :", Determination);
		typeText(driver, test, CRS_Reports_RequesterName, "Entering Requester Name :", RequesterName);
		if(ExportFocalPoint.length() > 0) {
			clickElement(driver, test, CRS_Reports_ExportFocalPoint, "Clicking on Export Focal Point :");
			try {
				typeText(driver, test, CRS_Reports_UserFirstName, "Entering Export Focal Point User First Name :", ExportFocalPoint);
				clickElement(driver, test, CRS_Reports_SearchPopUp, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ExportFocalPoint+"')]", "Selecting Export Focal Point :"+ExportFocalPoint);
				clickElement(driver, test, CRS_Reports_SelectPopUp, "Clicking on Select Tab :");
			}
			catch(Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, CRS_Reports_ClosePopup, "Click on Close PopUp :");
				e.printStackTrace();
			}
		}
		if(ReasonForReturn.length() > 0) {
			clickElement(driver, test, CRS_Reports_ReasonforReturn, "Clicking on Reason For Return :");
			try {
				typeText(driver, test, CRS_Reports_ReasonForReturnPopUp, "Entering Reason For Return :", ReasonForReturn);
				clickElement(driver, test, CRS_Reports_SearchPopUp, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ReasonForReturn+"')]", "Selecting Reason For Return :"+ReasonForReturn);
				clickElement(driver, test, CRS_Reports_SelectPopUp, "Clicking on Select Tab :");
			}
			catch(Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, CRS_Reports_ClosePopup, "Click on Close PopUp :");
				e.printStackTrace();
			}
		}else {
			typeText(driver, test, CRS_Reports_ReasonForReturnTextBox, "Entering Reason For Return :", ReasonForReturn);
		}
		if(TechnicalFocalPoint.length() > 0) {
			clickElement(driver, test, CRS_Reports_TechnicalFocalPoint, "Clicking on Technical Focal Point :");
			try {
				typeText(driver, test, OCR_Reports_TFPUserFirstName, "Entering Technical Focal Point :", TechnicalFocalPoint);
				clickElement(driver, test, CRS_Reports_SearchPopUp, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+TechnicalFocalPoint+"')]", "Selecting Technical Focal Point :"+TechnicalFocalPoint);
				clickElement(driver, test, CRS_Reports_SelectPopUp, "Clicking on Select Tab :");
			}
			catch(Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, CRS_Reports_ClosePopup, "Click on Close PopUp :");
				e.printStackTrace();
			}
		}
		if(DateInitiatedFrom.length() > 0) {
			clickElement(driver, test, CRS_Reports_CRDateInitiatedFrom, "Clicking on CR Date Initiated From :");
			dateOfMonthName(driver, test, "Selecting Date Of Initiated From :", DateInitiatedFrom);
		}
		if(DateInitiatedTo.length() > 0) {
			clickElement(driver, test, CRS_Reports_CRDateInitiatedTo, "Clicking on CR Date Intiated To :");
			dateOfMonthName(driver, test, "Selecting Date Initiated To :", DateInitiatedTo);
		}
		if(DateSubmittedFrom.length() > 0) {
			clickElement(driver, test, CRS_Reports_CRSubmittedFrom, "Clicking on CR Date Submitted From :");
			dateOfMonthName(driver, test, "Selecting Submitted Date From :", DateSubmittedFrom);
		}
		if(DateSubmittedTo.length() > 0) {
			clickElement(driver, test, CRS_Reports_CRSubmittedTo, "Clicking on CR Date Submitted To :");
			dateOfMonthName(driver, test, "Selecting Submitted Date To :", DateSubmittedTo);
		}
		if(DetermainationDateFrom.length() > 0) {
			clickElement(driver, test, CRS_Reports_CRDetermainationDateFrom, "Clicking on CR Determination Date From :");
			dateOfMonthName(driver, test, "Selecting Determaination Date From :", DetermainationDateFrom);
		}
		if(DetermainationDateTo.length() > 0) {
			clickElement(driver, test, CRS_Reports_CRDetermainationDateTo, "Clicking on CR Determination Date To :");
			dateOfMonthName(driver, test, "Selecting Determaination Date To :", DetermainationDateTo);
		}
	}

}
