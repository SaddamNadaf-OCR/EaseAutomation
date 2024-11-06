package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class SearchExdsAuditStatusReportPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;
	
	/* ******************************** LOCATORS ******************************** */
	
	public static final String OCR_SearchExdsAuditStatusReportPage_SBU = "//select[@id='selectSbu']";
	public static final String OCR_SearchExdsAuditStatusReportPage_RefNo = "//input[@id='resultExdsAuditStatusReport_invoiceNo']";
	public static final String OCR_SearchExdsAuditStatusReportPage_FormType = "//select[@name='formType']";
	public static final String OCR_SearchExdsAuditStatusReportPage_WorkStatus = "//select[@name='workStatus']";
	public static final String OCR_SearchExdsAuditStatusReportPage_Searchbtn = "//button[contains(text(),'Search')]";
	public static final String OCR_SearchExdsAuditStatusReportPage_WLStatus ="//select[@name='wlsStatus']";
	public static final String OCR_SearchExdsAuditStatusReportPage_lrStatus ="//select[@name='lrStatus']";
	public static final String OCR_SearchExdsAuditStatusReportPage_FromDate = "//input[@name='fromDate']";
	public static final String OCR_SearchExdsAuditStatusReportPage_Todate = "//input[@name='toDate']";
	public static final String OCR_SearchExdsAuditStatusReportPage_StatusChangedBy= "//select[@name='createdBy']";
	public static final String OCR_SearchExdsAuditStatusReportPage_Reset = "//button[@type='reset']";
	public static final String OCR_Today = "//button[@data-handler='today']";
	
	public static final String OCR_SearchExdsAuditStatusReportPage_ValidateHeading = "//h3[contains(text(),'EXPORT DOCUMENTS STATUS CHANGE REPORT')]";
	/* ******************************* Constructor ****************************** */

	public SearchExdsAuditStatusReportPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */
	public void selectSBU(String SbuCode) {
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCR_SearchExdsAuditStatusReportPage_SBU, "Select SBU Code : ", SbuCode);
		
	}
	
	public void enterRefNo(String RefNo) {
		Wait.waitfor(2);
		typeText(driver, test, OCR_SearchExdsAuditStatusReportPage_RefNo, "Enter Reference Number : ", RefNo);
		
	}
	
	/*public void selectFormType(String FormType) {
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCR_SearchExdsAuditStatusReportPage_FormType, "Select Form Type : ", FormType);
	}*/
	
	
	public void selectWorkStatus(String WorkStatus) {
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCR_SearchExdsAuditStatusReportPage_WorkStatus, "Select Work Status : ", WorkStatus);
	}
	public void searchbyparameter(String SbuCode, String RefNo, String FormType, String WorkStatus, String WLStatus, String LRStatus, 
			String FromDate, String EndDate, String StatusChangedBy){
		if (SbuCode.length()>0){
			typeText(driver, test, OCR_SearchExdsAuditStatusReportPage_SBU, "Select SBU Code : ", SbuCode);

		}
		if (RefNo.length()>0){
			typeText(driver, test, OCR_SearchExdsAuditStatusReportPage_RefNo, "Enter Reference No : ", RefNo);

		}
		if (FormType.length()>0) {
			selectByVisibleText(driver, test, OCR_SearchExdsAuditStatusReportPage_FormType, "From Type :", FormType);	
		}
		if(WorkStatus.length()>0) {
			selectByVisibleText(driver, test, OCR_SearchExdsAuditStatusReportPage_WorkStatus, "Select Work Status : ", WorkStatus);
		}
		if (WLStatus.length()>0) {
			selectByVisibleText(driver, test, OCR_SearchExdsAuditStatusReportPage_WLStatus, "WLS Status : ", WLStatus);

		}
		if (LRStatus.length()>0) {
			selectByVisibleText(driver, test, OCR_SearchExdsAuditStatusReportPage_lrStatus, "LR STATUS :", LRStatus);

		}
		if (FromDate.length() > 0) {
			clickElement(driver, test,OCR_SearchExdsAuditStatusReportPage_FromDate , "Click on From date");
			if (FromDate.equalsIgnoreCase("Today")) {
				clickElement(driver, test, OCR_Today, "Selecting Today");     
			} else {
				date(driver, test, "Select date", FromDate);
			}
		}
		if (EndDate.length() > 0) {
			clickElement(driver, test, OCR_SearchExdsAuditStatusReportPage_Todate, "Click on End date");
			if (EndDate.equalsIgnoreCase("Today")) {
				clickElement(driver, test, OCR_Today, "Selecting Today");
			} else {
				date(driver, test, "Select date", EndDate);
			}
		}
		if(StatusChangedBy.length()>0) {
		 selectByVisibleText(driver, test, OCR_SearchExdsAuditStatusReportPage_StatusChangedBy, "Status Changed By :", StatusChangedBy);

		}
	}
	
	public void SearchBtn() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_SearchExdsAuditStatusReportPage_Searchbtn, "Click on Search Button");
	}

		public void validateHeading() {
			Wait.waitfor(3);
			isDisplayed(driver, OCR_SearchExdsAuditStatusReportPage_ValidateHeading);
			Wait.waitfor(3);
			test.log(LogStatus.PASS, "EXPORT DOCUMENTS STATUS CHANGE REPORT page is Displayed");
			Wait.waitfor(3);
		}
		

	
	
	
}
