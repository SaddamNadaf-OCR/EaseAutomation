package globalTradeControlClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import utilities.GenericMethods;
import utilities.Wait;

public class SearchTradeControlScreeningPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_GtcSearch_ReferenceNo = "//input[@id='resultExportControlScreening_gtcGeneralInfoValue_referenceNo']";
	public static final String OCR_GtcSearch_ClientReferenceNo = "//input[@id='resultExportControlScreening_gtcGeneralInfoValue_clientRefNo']";
	public static final String OCR_GtcSearch = "(//button[@type='submit'])[1]";
	public static final String OCR_GtcNewScreening = "(//button[contains(text(),'New Screening')])[1]";
	public static final String OCR_GtcSbucode = "//select[@id='resultExportControlScreening_gtcGeneralInfoValue_sbuCode']";
	public static final String OCR_GtcExportCountry = "//input[@id='resultExportControlScreening_gtcGeneralInfoValue_exportCountry']";
	public static final String OCR_GtcImportCountry = "//input[@id='resultExportControlScreening_gtcGeneralInfoValue_importCountry']";
	public static final String OCR_GtcStatus = "//select[@id='resultExportControlScreening_controlDecision']";
	public static final String OCR_GtcFromDate = "//input[@name='screenedOnFrom']";
	public static final String OCR_GtcToDate = "//input[@name='screenedOnTo']";
	public static final String OCR_GtcReviewer = "//select[@id='resultExportControlScreening_gtcGeneralInfoValue_reviewerUserId']";
	public static final String OCR_GtcManager = "//select[@id='resultExportControlScreening_gtcGeneralInfoValue_managerUserId']";
	public static final String OCR_GtcEntityName = "//input[@id='resultExportControlScreening_gtcEntityDetailsValue_entityName']";
	public static final String OCR_GtcEntityAddress = "//input[@id='resultExportControlScreening_gtcEntityDetailsValue_entityAddress1']";
	public static final String OCR_GtcClickPartNo = "//a[contains(text(),'Part No')]";
	public static final String OCR_GtcSendvaluePartNo = "//input[@id='searchForm_product_productCode']";
	public static final String OCR_GtcPartNoSearch = "//button[@name='Search']";
	public static final String OCR_GtcPartNoSelect = "(//button[contains(text(),'Select')])[1]";
	public static final String OCR_Gtc_ProductCancel = "(//button[contains(text(),'Cancel')])[2]";
	public static final String OCR_GtcExportClassification = "//a[@id='ecnPopup']";
	public static final String OCR_GtcHSNo = "//input[@id='hsNo_resultStdHsPopup']";
	public static final String OCR_GtcHSNoSearch = "//button[@id='searchHsDtlBtn']";
	public static final String OCR_GtcRecordsWithHittsOnly = "//select[@id='resultExportControlScreening_recordsWithHittsOnly']";
	public static final String OCR_GtcLicenseRequired = "//select[@id='resultExportControlScreening_gtcPartNoDetailsValue_licenseRequired']";
	public static final String OCR_GtcExpOrExmReq = "//select[@id='resultExportControlScreening_expOrExmReq']";
	public static final String OCR_GtcReportingRequired = "//select[@id='resultExportControlScreening_reportingRequired']";
	public static final String OCR_GtcSortBy = "//select[@name='sortBy']";
	public static final String OCR_GtcDirection = "//select[@name='direction']";

	/* ******************************* Constructor ****************************** */

	public SearchTradeControlScreeningPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	//Enter the  ReferenceNo and client reference no
	public void enter_ClientReferenceNo(String ReferenceNo,String ClientReferenceNo) {	
		typeText(driver, test, OCR_GtcSearch_ReferenceNo, "Enter Reference No : ", ReferenceNo);
		typeText(driver, test, OCR_GtcSearch_ClientReferenceNo, "Enter Client Reference No : ", ClientReferenceNo);
	}

	// Enter the SearchDetails
	public void enter_SearchDetails(String SBUCode, String ReferenceNo, String ClientReferenceNo, 
			String CountryofExport, String CountryofImport, String Status, String CreatedDateFrom, 
			String CreatedDateTo, String Reviewer, String Manager, String EntityName, String EntityAddress,
			String PartNo, String HSNo, String RecordswithWLShits, String ExportLicenseRequired, 
			String ExemptionRequired, String ReportingRequired, String SortBy, String Direction){
		selectByVisibleText(driver, test, OCR_GtcSbucode, "Select the SBU Code : ", SBUCode);
		typeText(driver, test, OCR_GtcSearch_ReferenceNo, "Enter Reference No : ", ReferenceNo);
		typeText(driver, test, OCR_GtcSearch_ClientReferenceNo, "Enter Client Reference No : ", ClientReferenceNo);
		typeText(driver, test, OCR_GtcExportCountry, "Enter Export Country : ", CountryofExport);
		typeText(driver, test, OCR_GtcImportCountry, "Enter Import Country : ", CountryofImport);
		selectByVisibleText(driver, test, OCR_GtcStatus, "Select Status : ", Status);
		
		if (CreatedDateFrom.length() > 0) {
			clickElement(driver, test, OCR_GtcFromDate, "click on Submit Created Date From");
			date(driver, test, "Selected on Submit Created Date From : " , CreatedDateFrom);
			test.log(LogStatus.PASS, "Selected on Submit Created Date From : " + CreatedDateFrom);
			clickElement(driver, test, OCR_GtcToDate, "click on Submit Created Date To");
			date(driver, test, "Selected on Submit Created Date To : " , CreatedDateTo);
			test.log(LogStatus.PASS, "Selected on Submit Created Date To : " + CreatedDateTo);
		}
		selectByVisibleText(driver, test, OCR_GtcReviewer, "Select Reviewer : ", Reviewer);
		selectByVisibleText(driver, test, OCR_GtcManager, "Select Manager : ", Manager);
		typeText(driver, test, OCR_GtcEntityName, "Enter Entity Name : ", EntityName);
		typeText(driver, test, OCR_GtcEntityAddress, "Enter Entity Address : ", EntityAddress);

		if(PartNo.length()>0) {
			try {
			clickElement(driver, test, OCR_GtcClickPartNo, "Click Part No");
			typeText(driver, test, OCR_GtcSendvaluePartNo, "Enter Part No : ", PartNo);
			clickElement(driver, test, OCR_GtcPartNoSearch, "Click on Search");
			Wait.waitfor(5);
			String partno = "//td[contains(text(),'"+PartNo+"')]";
			clickElement(driver, test, partno, "Click Part No :" +PartNo);
			clickElement(driver, test, OCR_GtcPartNoSelect, "Click on Select button");
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Fail to add Product");
			clickElement(driver, test, OCR_Gtc_ProductCancel, "Close the Product Pop UP");
		}}

		if(HSNo.length()>0) {
			try {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_GtcExportClassification, "Click Export Classification");
			Wait.waitfor(3);
			typeText(driver, test, OCR_GtcHSNo, "Enter HS No", HSNo);
			clickElement(driver, test, OCR_GtcHSNoSearch, "Click Search");
			Wait.waitfor(5);
			String exportclass = "//div[contains(text(),'"+HSNo+"')]";
			clickElement(driver, test, exportclass, "Click HS No :" +HSNo);
			clickElement(driver, test, OCR_GtcPartNoSelect, "Click on Select button");
			}
			catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add Export Classification");
				clickElement(driver, test, OCR_Gtc_ProductCancel, "Close the Export Classification Pop UP");
			}
			
		}
		selectByVisibleText(driver, test, OCR_GtcRecordsWithHittsOnly, "Select Records with WLS hits : ", RecordswithWLShits);
		selectByVisibleText(driver, test, OCR_GtcLicenseRequired, "Select Records with Export License : ", ExportLicenseRequired);
		selectByVisibleText(driver, test, OCR_GtcExpOrExmReq, "Select Records with Exemption Required : ", ExemptionRequired);
		selectByVisibleText(driver, test, OCR_GtcReportingRequired, "Select Records Reporting Required : ", ReportingRequired);
		selectByVisibleText(driver, test, OCR_GtcSortBy, "Select Records with SortBy : ", SortBy);
		selectByVisibleText(driver, test, OCR_GtcDirection, "Select Records with Direction : ", Direction);
	}

	// Click on Search Button
	public void click_GtcSearch() throws InterruptedException {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_GtcSearch, "Click on Search Button");
	}

	// Click New Screening
	public void click_GtcNewScreening(){
		clickElement(driver, test, OCR_GtcNewScreening, "Click NewScreening Button");
	}
}
