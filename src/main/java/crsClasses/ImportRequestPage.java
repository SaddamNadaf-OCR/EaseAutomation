package crsClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import utilities.GenericMethods;
import utilities.Wait;

public class ImportRequestPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_ImpReq_BusinessUnit = "//select[@id='editExportRequest_sbuCode']";
	public static final String OCR_ImpReq_ImportReqByDate = "//input[@id='editExportRequest_expReqByDate']";
	public static final String OCR_RequiredByDate_Today = "//button[contains(text(),'Today')]";
	public static final String OCR_ImpReq_RequestorNamelink = "(//a[contains(text(),'Name')])[1]";
	public static final String OCR_ImpReq_RequestorUserFName = "//input[@id='searchForm_userProfile_userFirstname']";
	public static final String OCR_ImpReq_RequestorUserSearchBtn = "//button[@name='Search']";
	public static final String OCR_ImpReq_RequestorUserSelectBtn = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_ImpReq_CancleBtn = "//div[@class='row-btn-row']//button[contains(text(),'Cancel')]";
	public static final String OCR_ImpReq_PopUPCancleIcon = "//button[@class='close']";
	public static final String OCR_ImpReq_RequestorName = "//input[@id='userFullName']";
	public static final String OCR_ImpReq_RequestorEmail = "//input[@id='editExportRequest_exportRequestValue_requestorEmail']";
	public static final String OCR_ImpReq_RequestorPhone = "//input[@id='editExportRequest_exportRequestValue_requestorTelNo']";
	public static final String OCR_ImpReq_LOSameAsRequestor = "//input[@id='editExportRequest_sameAsRequestorOwner']";
	public static final String OCR_ImpReq_LicenseOwnerLink = "//a[contains(text(),'Authorization Owner')]";
	public static final String OCR_ImpReq_LicenseOwnerFName = "//input[@id='searchForm_dosLicenseOwnerPopupDTO_ownerFirstName']";
	public static final String OCR_ImpReq_LicenseOwnerSearchBtn = "//button[@name='Search']";
	public static final String OCR_ImpReq_LicenseOwnerSelectBtn = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_ImpReq_LicenseOwner = "//input[@id='ownerFullName']";
	public static final String OCR_ImpReq_LicenseOwnerEmpId = "//input[@id='editExportRequest_exportRequestValue_reqEmpId']";
	public static final String OCR_ImpReq_LicenseOwnerEmail = "//input[@id='editExportRequest_exportRequestValue_licOwnerEmail']";
	public static final String OCR_ImpReq_LicenseOwnerPhone = "//input[@id='editExportRequest_exportRequestValue_licOwnerTelNo']";
	public static final String OCR_ImpReq_LMSameAsRequestor = "//input[@id='editExportRequest_sameAsRequestorManager']";
	public static final String OCR_ImpReq_LicenseManagerLink = "//a[contains(text(),'License Manager')]";
	public static final String OCR_ImpReq_LicenseManagerUserFName = "//input[@id='searchForm_userProfile_userFirstname']";
	public static final String OCR_ImpReq_LicenseManagerUserSearchBtn = "//button[@name='Search']";
	public static final String OCR_ImpReq_LicenseManagerUserSelect = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_ImpReq_LicenseManager = "//input[@id='userLMFullName']";
	public static final String OCR_ImpReq_LicenseManagerEmail = "//input[@id='editExportRequest_exportRequestValue_licManagerEmail']";
	public static final String OCR_ImpReq_LicenseManagerPhone = "//input[@id='editExportRequest_exportRequestValue_licManagerTelNo']";
	public static final String OCR_ImpReq_LicensePurpose = "//select[@id='editExportRequest_exportRequestValue_licPurpose']";
	public static final String OCR_ImpReq_SummaryPurposeIReq = "//textarea[@id='editExportRequest_exportRequestValue_descLicPurpose']";
	public static final String OCR_ImpReq_Save = "//input[@name='saveGenInfo']";
	public static final String OCR_ImpReq_TypeOfImport = "//span[contains(text(),'Type of Import')]";
	public static final String OCR_ImpReq_RequestID = "(//span[@class='status']/label/font)[1]";
	public static final String OCR_ImpReq_Status = "//span[@class='status']/label/font[2]";
	public static final String OCR_ImpReq_ServicesOther = "//textarea[@id='editExportRequest_exportRequestValue_techOther']";
	public static final String OCR_ImpReq_SaveTypeOfImport = "//input[@name='saveTypeOfExport']";
	public static final String OCR_ImpReq_GeneralDescptn = "//span[contains(text(),'General Description')]";
	public static final String OCR_ImpReq_GD_Site = "//textarea[@id='editExportRequest_exportRequestValue_site']";
	public static final String OCR_ImpReq_GD_Department = "//textarea[@id='editExportRequest_exportRequestValue_department']";
	public static final String OCR_ImpReq_GD_Program = "//textarea[@id='editExportRequest_exportRequestValue_program']";
	public static final String OCR_ImpReq_GD_Segment = "//textarea[@id='editExportRequest_exportRequestValue_segment']";
	public static final String OCR_ImpReq_GD_ProductFamily = "//textarea[@id='editExportRequest_exportRequestValue_prodFamily']";
	public static final String OCR_ImpReq_GD_ProductLine = "//textarea[@id='editExportRequest_exportRequestValue_prodLine']";
	public static final String OCR_ImpReq_GD_OtherSite = "//input[@id='editExportRequest_exportRequestValue_otherSite']";
	public static final String OCR_ImpReq_GD_OtherDepartment = "//input[@id='editExportRequest_exportRequestValue_otherDepartment']";
	public static final String OCR_ImpReq_GD_OtherProgram = "//input[@id='editExportRequest_exportRequestValue_otherProgram']";
	public static final String OCR_ImpReq_GD_OtherSegment = "//input[@id='editExportRequest_exportRequestValue_otherSegment']";
	public static final String OCR_ImpReq_GD_OtherProductFamily = "//input[@id='editExportRequest_exportRequestValue_otherProdFamily']";
	public static final String OCR_ImpReq_GD_OtherProductLine = "//input[@id='editExportRequest_exportRequestValue_otherProdLine']";
	public static final String OCR_ImpReq_GD_SalesOrderNo = "//input[@id='editExportRequest_exportRequestValue_salesOrderNo']";
	public static final String OCR_ImpReq_GD_PurchaseOrderNo = "//input[@id='editExportRequest_exportRequestValue_purchaseOrderNo']";
	public static final String OCR_ImpReq_GD_ContractNo = "//input[@id='editExportRequest_exportRequestValue_contractNo']";
	public static final String OCR_ImpReq_GD_FMSCaseNo = "//input[@id='editExportRequest_exportRequestValue_fmsCaseNo']";
	public static final String OCR_ImpReq_GD_InternalTrackingNo = "//input[@id='editExportRequest_exportRequestValue_trackingNo']";
	public static final String OCR_ImpReq_GD_SaveGeneralDescription = "//input[@name='saveGenDesc']";
	public static final String OCR_ImpReq_ImportInfoTab = "//a[@class='expInfo']";
	public static final String OCR_ImpReq_IF_AddCountryBtn = "//input[@id='addCountryId']";
	public static final String OCR_ImpReq_IF_ItemsTab = "//span[contains(text(),'Items')]";
	public static final String OCR_ImpReq_IF_PartiesTab = "//span[contains(text(),'Parties')]";
	public static final String OCR_ImpReq_IF_FreightForwardersTab = "//span[contains(text(),'Freight Forwarders')]";
	public static final String OCR_ImpReq_IF_PortsTab = "//span[contains(text(),'Ports')]";
	public static final String OCR_ImpReq_IF_DocumentsTab = "//span[contains(text(),'Documents')]";
	public static final String OCR_ImpReq_DocumentType = "//select[@id='docTypeId']";
	public static final String OCR_ImpReq_UploadFile = "//i[@class='fa fa-upload']";
	public static final String OCR_ImpReq_LocalFolderRadioBtn = "//input[@id='editDCSFileAttach_fileStoreTypeisLocalFtp']";
	public static final String OCR_ImpReq_LocationPath = "//input[@id='textUrl']";
	public static final String OCR_ImpReq_UploadDocSaveBtn = "//button[@id='saveButton']";
	public static final String OCR_ImpReq_DocPopUpClose = "//form[@id='editDCSFileAttach']//button[@class='btn-close']";
	public static final String OCR_ImpReq_IF_AddItemBtn = "//input[@id='addItemId']";
	public static final String OCR_ImpReq_IF_AddPartyBtn = "//input[@id='addPartyId']";
	public static final String OCR_ImpReq_IF_AddFreightForwdBtn = "//input[@id='freightForwardId']";
	public static final String OCR_ImpReq_IF_AddPortBtn = "//input[@id='addPortId']";
	public static final String OCR_ImpReq_IF_viewOrEditDocBtn = "//button[@id='addDocumentId']";
	public static final String OCR_ImpReq_AdditionalInfoTab = "//a[@class='misc']";
	public static final String OCR_ImpReq_AddInfo_Contracts = "//span[contains(text(),'Contracts')]";
	public static final String OCR_ImpReq_SubmitReqTab = "//a[@class='subReq']";
	public static final String OCR_ImpReq_SubReq_AddNoteBtn = "//input[@id='addNotesId']";
	public static final String OCR_ImpReq_SubReq_SubmitTab = "//span[contains(text(),'Submit')]";
	public static final String OCR_ImpReq_SubReq_NameOfImportRep = "//select[@id='editExportRequest_reviewManager']";
	public static final String OCR_ImpReq_SubReq_SubmitForReviewBtn = "(//input[@name='saveSubmit'])[2]";
	public static final String OCR_ImpReq_ImportStatusTab = "//a[@class='disp']";
	public static final String OCR_ImpReq_ImpStatus_Status = "//select[@id='editExportRequest_status']";
	public static final String OCR_ImpReq_ImpStatus_Determination = "//select[@id='editExportRequest_disposition']";
	public static final String OCR_ImpReq_ImpStatus_Phone = "//input[@id='editExportRequest_exportRequestValue_approverTelNo']";
	public static final String OCR_ImpReq_ImpStatus_Priority = "//select[@id='editExportRequest_exportRequestValue_priority']";
	public static final String OCR_ImpReq_ImpStatus_SaveBtn = "//input[@name='saveStatusInfo']";
	public static final String OCR_ImpReq_ImpStatus_CancleBtn = "(//button[@name='cancel'])[15]";
	public static final String OCR_ImpReq_Doc_CancleBtn = "//div[@class='col-xs-6']//button[@name='cancel']";
	public static final String OCR_ImpReq_ImpStatus_ImpIntoLA = "//span[contains(text(),'Import Into License Application')]";
	public static final String OCR_ImpReq_ImpStatus_LicenseType = "//select[@id='licenseTypeId']";
	public static final String OCR_ImpReq_ImpStatus_TemplateNameLink = "//a[@id='templateNameHREFId']";
	public static final String OCR_ImpReq_ImpStatus_TemplateNameSelectBtn = "//div[@id='resultDIV']//button[1]";
	public static final String OCR_ImpReq_ImpStatus_UseImpReqID = "//div[@id='useExpIdButton']";
	public static final String OCR_ImpReq_ImpStatus_items = "//input[@id='editExportRequest_exportRequestValue_importItems-1']";
	public static final String OCR_ImpReq_ImpStatus_Country = "//input[@id='editExportRequest_exportRequestValue_importCountry-1']";
	public static final String OCR_ImpReq_ImpStatus_FreightForwarder = "//input[@id='editExportRequest_exportRequestValue_importFf-1']";
	public static final String OCR_ImpReq_ImpStatus_Notes = "//input[@id='editExportRequest_exportRequestValue_importAll-1']";
	public static final String OCR_ImpReq_ImpStatus_Documents = "//input[@id='editExportRequest_exportRequestValue_importDocument-1']";
	public static final String OCR_ImpReq_ImpStatus_ImportAllBtn = "//input[@name='imprtAll']";
	public static final String OCR_ImpReq_ImpStatus_SaveImportInfo = "//input[@name='saveImportInfo']";
	public static final String OCR_ImpReq_ImpStatus_TransationID = "//input[@id='editExportRequest_exportRequestValue_licenseTransactionId']";
	public static final String OCR_ImpReq_TemplateName = "//input[@name='expTempId']";
	public static final String OCR_Button_ForwardNavigation = "//button[@id='next-btn']";
	public static final String OCR_ImReq_ImportIntoLicense = "//span[contains(text(),'Import Into License Application')]";

	/* ******************** Constructor ***************************** */

	public ImportRequestPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	// Adding Import request
	public void addImportRequest(String BusinessUnit, String ImportRequiredDate) {
		selectByVisibleText(driver, test, OCR_ImpReq_BusinessUnit, "Select the business unit : ", BusinessUnit);
		clickElement(driver, test, OCR_ImpReq_ImportReqByDate, "click on import required By Date");
		if (ImportRequiredDate.contains("Today")) {
			clickElement(driver, test, OCR_RequiredByDate_Today, "Clicking on Today: ");
		} else {
			date(driver, test, "Selected the Import request Date : ", ImportRequiredDate);
		}
		
	}
	
	// Add the required template Name
	public void add_template(String templateName) {
		typeText(driver, test, OCR_ImpReq_TemplateName, "Adding Template Name :", templateName+randomnumbersbetween1_100());
	}


	// Add Requestor
	public void addRequestor(String RequestorUserFirstName, String RequestorName, String RequestorEmail,
			String RequestorPhone) {
		if (RequestorUserFirstName.length() > 0) {
			clickElement(driver, test, OCR_ImpReq_RequestorNamelink, "click on requestor Name link");
			try {
				typeText(driver, test, OCR_ImpReq_RequestorUserFName, "Enter user first name : ",
						RequestorUserFirstName);
				clickElement(driver, test, OCR_ImpReq_RequestorUserSearchBtn, "click on user Search button");
				String userFName = "(//td[contains(text(),'" + RequestorUserFirstName + "')])[1] ";
				clickElement(driver, test, userFName, "Select the user first name : " + RequestorUserFirstName);
				clickElement(driver, test, OCR_ImpReq_RequestorUserSelectBtn, "Click on user Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_ImpReq_PopUPCancleIcon, "Click on Cancle icon");
			}
		} else {
			typeText(driver, test, OCR_ImpReq_RequestorName, "Enter requestor name : ", RequestorName);
			typeText(driver, test, OCR_ImpReq_RequestorEmail, "Enter requestor Email : ", RequestorEmail);
			typeText(driver, test, OCR_ImpReq_RequestorPhone, "Enter requestor phone : ", RequestorPhone);
		}
	}

	// Add license owner
	public void addLicenseOwner(String LOSameAsRequestor, String LOFirstName, String LicenseOwner, String LOEmpID,
			String LOEmail, String LOPhone) {
		Wait.waitfor(3);
		if (!LOSameAsRequestor.equalsIgnoreCase("Yes")) {
			if (LOFirstName.length() > 0) {
				clickElement(driver, test, OCR_ImpReq_LicenseOwnerLink, "Click on License owner link");
				try {
					typeText(driver, test, OCR_ImpReq_LicenseOwnerFName, "Enter license owner First Name : ",
							LOFirstName);
					clickElement(driver, test, OCR_ImpReq_LicenseOwnerSearchBtn, "Click on Search button");
					String LOFName = "//td[contains(text(),'" + LOFirstName + "')]";
					clickElement(driver, test, LOFName, "Select owner first name : " + LOFirstName);
					clickElement(driver, test, OCR_ImpReq_LicenseOwnerSelectBtn, "Click on owner Select");
				} catch (Exception e) {
					testFailSshot(driver, test);
					clickElement(driver, test, OCR_ImpReq_PopUPCancleIcon, "Click on Cancle icon");
				}
			} else {
				typeText(driver, test, OCR_ImpReq_LicenseOwner, "Enter license owner : ", LicenseOwner);
				typeText(driver, test, OCR_ImpReq_LicenseOwnerEmpId, "Enter license owner Employee ID : ", LOEmpID);
				typeText(driver, test, OCR_ImpReq_LicenseOwnerEmail, "Enter license owner Email : ", LOEmail);
				typeText(driver, test, OCR_ImpReq_LicenseOwnerPhone, "Enter license owner Phone : ", LOPhone);
			}
		} else {
			clickElement(driver, test, OCR_ImpReq_LOSameAsRequestor,
					"click on license owner Same as requestor checkbox");
		}
	}

	// Add license Manager
	public void addLicenseManager(String LMSameAsRequestor, String LMFirstName, String LicenseManager, String LMEmail,
			String LMPhone) {
		Wait.waitfor(3);
		if (!LMSameAsRequestor.equalsIgnoreCase("Yes")) {
			if (LMFirstName.length() > 0) {
				clickElement(driver, test, OCR_ImpReq_LicenseManagerLink, "Click on License Manager Link");
				try {
					typeText(driver, test, OCR_ImpReq_LicenseManagerUserFName,
							"Click on License Manager User First Name : ", LMFirstName);
					clickElement(driver, test, OCR_ImpReq_LicenseManagerUserSearchBtn, "Click on User Search button");
					String lmFirstName = "//td[contains(text(),'" + LMFirstName + "')]";
					clickElement(driver, test, lmFirstName, "Select the user first name : " + LMFirstName);
					clickElement(driver, test, OCR_ImpReq_LicenseManagerUserSelect, "Click on User Select button");
				} catch (Exception e) {
					testFailSshot(driver, test);
					clickElement(driver, test, OCR_ImpReq_PopUPCancleIcon, "Click on Cancle icon");
				}
			} else {
				typeText(driver, test, OCR_ImpReq_LicenseManager, "Enter license manger : ", LicenseManager);
				typeText(driver, test, OCR_ImpReq_LicenseManagerEmail, "Enter License Manager Email : ", LMEmail);
				typeText(driver, test, OCR_ImpReq_LicenseManagerPhone, "Enter License Manager Phone : ", LMPhone);
			}
		} else {
			clickElement(driver, test, OCR_ImpReq_LMSameAsRequestor,
					"Click on License Manager Same as Requestor checkbox");
		}
	}

	// Select the License Purpose
	public void licensePurpose(String Licensepurpose, String SummaryPurposeImpReq) {
		selectByVisibleText(driver, test, OCR_ImpReq_LicensePurpose, "Select the License purpose : ", Licensepurpose);
		typeText(driver, test, OCR_ImpReq_SummaryPurposeIReq, "Enter the Summary Purpose Import Req : ",
				SummaryPurposeImpReq);
	}

	// click on save button
	public void click_Save() {
		scrollToElement(driver, "//div[@class='top-empty-row']");
		clickElement(driver, test, OCR_ImpReq_Save, "Click on Save button");
	}

	// click on Cancle button
	public void click_Cancle() {
		clickElement(driver, test, OCR_ImpReq_CancleBtn, "Click on Cancle button");
	}
	
	//Click on Forward Button
	public void moveForward() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript ("arguments[0].click();" , driver.findElement(By.xpath(OCR_Button_ForwardNavigation)));
	}

	// click on type of Import
	public void click_TypeOfExport() {
		Wait.waitfor(4);
		clickElement(driver, test, "//select[@id='editExportRequest_sbuCode']", "mouse over to Type of import");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, OCR_ImpReq_TypeOfImport, "Click on Type of import Tab");
	}

	// Getting the Request ID
	public String get_RequestID() {
		return getText(driver, test, OCR_ImpReq_RequestID, "Get the Actual text of Request ID : ");
	}

	// Getting the Status
	public String get_Status() {
		return getText(driver, test, OCR_ImpReq_Status, "Get the Actual text of Status : ");
	}

	// select the type of import
	public void click_typeOfImport() {
		clickElement(driver, test, "//input[@id='editExportRequest_exportRequestValue_permExpHwAndTechData-1']",
				"click on Permanent Import - Hardware and Technical data checkBox");
	}

	// select the Technical Data import
	public void technicalDataImport() {
		clickElement(driver, test, "//input[@id='editExportRequest_exportRequestValue_expProdBluePrints-1']",
				"click on  Import - Product Blue Prints/ Drawings checkBox");
	}

	// Enter the Services
	public void services(String Services) {
		typeText(driver, test, OCR_ImpReq_ServicesOther, "Enter Services : ", Services);
		scrollToTop(driver);
	}

	// Click on save type of import
	public void click_saveTypeOfImport() {
		clickElement(driver, test, OCR_ImpReq_SaveTypeOfImport, "click on Save Type Of Import");
	}

	// Click on GeneralDescription Tab
	public void click_GeneralDescription() {
		clickElement(driver, test, "//h3[@class='page-heading']", "mouse over to General Description");
		clickElement(driver, test, OCR_ImpReq_GeneralDescptn, "click on GeneralDescription Tab");
	}

	// Add General Description
	public void addGeneralDescption(String Site, String Department, String Program, String Segment,
			String ProductFamily, String ProductLine, String Othersite, String OtherDepartment, String OtherProgram,
			String OtherSegment, String OtherProductFamily, String OtherProductLine, String SalesOrderNo,
			String PurchaseOrderNo, String ContractNo, String FMSCaseNo, String InternalTrackingNo) {
		typeText(driver, test, OCR_ImpReq_GD_Site, "Select the site : ", Site);
		typeText(driver, test, OCR_ImpReq_GD_Department, "Select the Department : ", Department);
		typeText(driver, test, OCR_ImpReq_GD_Program, "Select the Program : ", Program);
		typeText(driver, test, OCR_ImpReq_GD_Segment, "Select the Segment : ", Segment);
		typeText(driver, test, OCR_ImpReq_GD_ProductFamily, "Select the ProductFamily : ", ProductFamily);
		typeText(driver, test, OCR_ImpReq_GD_ProductLine, "Select the ProductLine : ", ProductLine);
		typeText(driver, test, OCR_ImpReq_GD_OtherSite, "Enter the Othersite : ", Othersite);
		typeText(driver, test, OCR_ImpReq_GD_OtherDepartment, "Enter the OtherDepartment : ", OtherDepartment);
		typeText(driver, test, OCR_ImpReq_GD_OtherProgram, "Enter the OtherProgram : ", OtherProgram);
		typeText(driver, test, OCR_ImpReq_GD_OtherSegment, "Enter the OtherSegment : ", OtherSegment);
		typeText(driver, test, OCR_ImpReq_GD_OtherProductFamily, "Enter the OtherProductFamily : ", OtherProductFamily);
		typeText(driver, test, OCR_ImpReq_GD_OtherProductLine, "Enter the OtherProductLine : ", OtherProductLine);
		typeText(driver, test, OCR_ImpReq_GD_SalesOrderNo, "Enter the SalesOrderNo : ", SalesOrderNo);
		typeText(driver, test, OCR_ImpReq_GD_PurchaseOrderNo, "Enter the PurchaseOrderNo : ", PurchaseOrderNo);
		typeText(driver, test, OCR_ImpReq_GD_ContractNo, "Enter the ContractNo : ", ContractNo);
		typeText(driver, test, OCR_ImpReq_GD_FMSCaseNo, "Enter the FMSCaseNo : ", FMSCaseNo);
		typeText(driver, test, OCR_ImpReq_GD_InternalTrackingNo, "Enter the InternalTrackingNo : ", InternalTrackingNo);
	}

	// Click on save General Description button
	public void click_saveGeneralDescriptionBtn() {
		scrollToTop(driver);
		clickElement(driver, test, OCR_ImpReq_GD_SaveGeneralDescription, "click on Save General Description button");
	}

	// Click on Import Info Tab
	public void click_ImportInfoTab() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_ImpReq_ImportInfoTab, "click on Import Info Tab");
	}

	// Click on Add Country button
	public void click_AddCountry() {
		clickElement(driver, test, OCR_ImpReq_IF_AddCountryBtn, "click on Add Country");
	}

	// Add countries is Added to the Result grid or not
	public void addcountryToResultsGrid(String AddCountry) {
		Wait.waitfor(4);
		String addcountry = "//table[@id='grid']/tbody/tr/td[contains(text(),'" + AddCountry + "')]";
		try {
			if (isDisplayed(driver, addcountry)) {
				test.log(LogStatus.PASS, "Add Country in add to result grid table : " + AddCountry);
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Fail to Add Country in result grid table : " + AddCountry);
		}

	}

	// Click on Items Tab
	public void click_ItemsTab() {
		clickElement(driver, test, OCR_ImpReq_IF_ItemsTab, "click on Items Tab");
	}

	// Click on Add Items button
	public void click_AddItemsBtn() {
		clickElement(driver, test, OCR_ImpReq_IF_AddItemBtn, "Click on Add items button");
	}

	// Add Items is Added to the Result grid or not
	public void addItemToResultsGrid(String PartNo) {
		Wait.waitfor(3);
		String addItem = "//table[@id='gridItem']/tbody/tr/td[contains(text(),'" + PartNo + "')]";
		try {
			if (isDisplayed(driver, addItem)) {
				test.log(LogStatus.PASS, "Add Item in add to result grid table : " + PartNo);
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Fail to Add Item in result grid table : " + PartNo);
		}
	}

	// Click on Parties Tab
	public void click_PartiesTab() {
		clickElement(driver, test, OCR_ImpReq_IF_PartiesTab, "click on Parties Tab");
	}

	// Click on Add Parties button
	public void click_AddPartiesBtn() {
		clickElement(driver, test, OCR_ImpReq_IF_AddPartyBtn, "click on Add Parties button");
	}

	// Add Parties is Added to the Result grid or not
	public void addPartiesToResultsGrid(String PartiesCode) {
		Wait.waitfor(3);
		String addParties = "//table[@id='gridParty']/tbody/tr/td[contains(text(),'" + PartiesCode + "')]";
		try {
			if (isDisplayed(driver, addParties)) {
				test.log(LogStatus.PASS, "Add Parties in add to result grid table : " + PartiesCode);
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Fail to Add Parties in result grid table : " + PartiesCode);
		}
	}

	// Click on Freight Forwarders Tab
	public void click_FreightForwardersTab() {
		clickElement(driver, test, OCR_ImpReq_IF_FreightForwardersTab, "click on Freight Forwarders Tab");
	}

	// Click on Freight Forwarders Tab
	public void click_AddFreightForwdBtn() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_ImpReq_IF_AddFreightForwdBtn, "click on Add Freight Forwarders button");
	}

	// Add Freight Forwarder is Added to the Result grid or not
	public void addFreightForwarderToResultsGrid(String FFCode) {
		Wait.waitfor(3);
		String addFreightForwarder = "//table[@id='gridFreightForwarder']/tbody/tr/td[contains(text(),'" + FFCode
				+ "')]";
		try {
			if (isDisplayed(driver, addFreightForwarder)) {
				test.log(LogStatus.PASS, "Add Freight Forwarder in add to result grid table : " + FFCode);
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Fail to Add Freight Forwarder in result grid table : " + FFCode);
		}
	}

	// Click on Ports Tab
	public void click_PortsTab() {
		clickElement(driver, test, OCR_ImpReq_IF_PortsTab, "click on Ports Tab");
	}

	// Click on Add Ports button
	public void click_AddPortsBtn() {
		clickElement(driver, test, OCR_ImpReq_IF_AddPortBtn, "click on Add Ports button");
	}

	// Add Port is Added to the Result grid or not
	public void addPortToResultsGrid(String PortID) {
		Wait.waitfor(3);
		String addPortID = "//table[@id='gridPort']/tbody/tr/td[contains(text(),'" + PortID + "')]";
		try {
			if (isDisplayed(driver, addPortID)) {
				test.log(LogStatus.PASS, "Add Port in add to result grid table : " + PortID);
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Fail to Add Port in result grid table : " + PortID);
		}
	}

	// Click on Document Tab
	public void click_DocumentTab() {
		clickElement(driver, test, OCR_ImpReq_IF_DocumentsTab, "click on Documents Tab");
	}

	// click on view/Add Document button
	public void click_AddDocumentBtn() {
		clickElement(driver, test, OCR_ImpReq_IF_viewOrEditDocBtn, "Click on View/Add Document buttton");
	}

	// Adding a document
	public void addDocument(String DocumentType, String UploadfileName, String DocumentLocationPath) {
		try {
			if (UploadfileName.length() > 0) {
				selectByVisibleText(driver, test, OCR_ImpReq_DocumentType, "Select the Document Type : ", DocumentType);
				mouseOverAndClick(driver, test, OCR_ImpReq_UploadFile, "click on Upload File button");
				uploadFile(driver, test, UploadfileName, "Document is Added : " + UploadfileName);
			}
			if (DocumentLocationPath.length() > 0) {
				clickElement(driver, test, OCR_ImpReq_LocalFolderRadioBtn, "click on Local Folder Radio button");
				selectByVisibleText(driver, test, OCR_ImpReq_DocumentType, "Select the Document : ", DocumentType);
				typeText(driver, test, OCR_ImpReq_LocationPath, "Enter local path : ", DocumentLocationPath);
				clickElement(driver, test, OCR_ImpReq_UploadDocSaveBtn, "click on Document save");
			}
			/*String resultGid = "//table[@id='gridPopup']//tr//td[contains(text(),'" + DocumentType + "')]";
			isDisplayed(driver, resultGid);
			test.log(LogStatus.PASS, "Document type is added in the Grid table : " + DocumentType);
			Wait.waitfor(4);*/
			clickElement(driver, test, OCR_ImpReq_UploadDocSaveBtn, "click on Document save");
			//isDisplayed(driver, resultGid);
			Wait.waitfor(5);
			clickElement(driver, test, OCR_ImpReq_DocPopUpClose, "Click on Document Pop up close");
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_ImpReq_DocPopUpClose, "Click on Document Pop up close");
		}
	}

	// Error message in Document
	public void validationDocument() {
		try {
			if (isDisplayed(driver, "(//h4[contains(text(),'Error')])[2]")) {
				if (isDisplayed(driver, "//li[contains(text(),'Document Type is required.')]")) {
					test.log(LogStatus.INFO, "Document Type is required.");
				}
				if (isDisplayed(driver, "//li[contains(text(),'Document Name is required.')]")) {
					test.log(LogStatus.INFO, "Document Name is required.");
				}
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL,
					"Error Vaildation is not Displayed by clicking on SAVE & Return button in Document");
		}
	}

	// Click on Add Documnet Save button
	public void click_SaveAddDocumentBtn() {
		clickElement(driver, test, OCR_ImpReq_UploadDocSaveBtn, "click on Document save");
	}

	// Click on Add Documnet Cancle button
	public void click_CancleAddDocumentBtn() {
		clickElement(driver, test, OCR_ImpReq_Doc_CancleBtn, "Click on Add Documnet Cancle button");
	}

	// Click on Additional Info Tab
	public void click_AdditionalInfoTab() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_ImpReq_AdditionalInfoTab, "click on Additional Info Tab");
	}

	// Click on Contracts Tab in Additional Info
	public void click_ContractsTab() {
		clickElement(driver, test, OCR_ImpReq_AddInfo_Contracts, "Click on Contacts Tab");
	}

	// Click on Submit Request Tab
	public void click_SubmitReqTab() {
		clickElement(driver, test, OCR_ImpReq_SubmitReqTab, "click on Submit Request Tab");
	}

	// Click on Add Note button
	public void click_AddNoteBtn() {
		clickElement(driver, test, OCR_ImpReq_SubReq_AddNoteBtn, "Click on Add Notes button");
	}

	// click on Submit Tab in Submit request
	public void click_SubmitTab() {
		clickElement(driver, test, OCR_ImpReq_SubReq_SubmitTab, "Click on Submit Tab in Submit request");
	}

	// Select the Import Rep
	public void select_ImportRep(String ImportRepresentative) {
		selectByVisibleText(driver, test, OCR_ImpReq_SubReq_NameOfImportRep,
				"Select the Name of import Representative : ", ImportRepresentative);
	}

	// click on Submit for Review
	public void click_SubmitForReview() {
		clickElement(driver, test, OCR_ImpReq_SubReq_SubmitForReviewBtn, "Click on Submit For Review");
	}

	// click on Import Status Tab
	public void click_ImportStatusTab() {
		clickElement(driver, test, OCR_ImpReq_ImportStatusTab, "Click on Import Status Tab");
	}

	// Add import Status informations
	public void addImportStatusInfo(String ImportStatus, String Determination, String ApproverPhone, String Priority) {
		selectByVisibleText(driver, test, OCR_ImpReq_ImpStatus_Status, "Select the Status : ", ImportStatus);
		selectByVisibleText(driver, test, OCR_ImpReq_ImpStatus_Determination, "Select the Determination : ",
				Determination);
		typeText(driver, test, OCR_ImpReq_ImpStatus_Phone, "Enter the phone no : ", ApproverPhone);
		selectByVisibleText(driver, test, OCR_ImpReq_ImpStatus_Priority, "Select the priority : ", Priority);
	}

	// click on Save button in Import Status
	public void click_ImportStatusSaveButton() {
		clickElement(driver, test, OCR_ImpReq_ImpStatus_SaveBtn, "Click on import status Save button");
	}

	// click on Cancel button in Import Status
	public void click_ImportStatusCancleButton() {
		clickElement(driver, test, OCR_ImpReq_ImpStatus_CancleBtn, "Click on import status Cancle button");
	}

	// click on import into license Application
	public void importIntoLicenseApp() {
		clickElement(driver, test, OCR_ImpReq_ImpStatus_ImpIntoLA, "click on Import Into License Application");
	}

	// Select the license Type and license Transaction ID
	public void addImportIntoLA(String LicenseType, String TemplateName) {
		selectByVisibleText(driver, test, OCR_ImpReq_ImpStatus_LicenseType, "Select the License Type : ", LicenseType);
		if (TemplateName.length() > 0) {
			clickElement(driver, test, OCR_ImpReq_ImpStatus_TemplateNameLink, "Click on Template Name Link");
			String templateName = "//td[contains(text(),'" + TemplateName + "')]";
			clickElement(driver, test, templateName, "Click on Template Name : " + TemplateName);
			clickElement(driver, test, OCR_ImpReq_ImpStatus_TemplateNameSelectBtn,
					"Click on Template Name Select button");
		} else {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_ImpReq_ImpStatus_UseImpReqID, "Click on Use import request ID");
		}
	}

	// click on Save import info
	public void click_saveImportInfo() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_ImpReq_ImpStatus_SaveImportInfo, "Click on Save import info");
	}

	// Click on import items,Country,FreightForward,Notes,Documents check box
	public void import_IntoLicenseApp(String ImportInfo) {
		if (ImportInfo.equalsIgnoreCase("items")) {
			clickElement(driver, test, OCR_ImpReq_ImpStatus_items, "Click on Import items CheckBox");
		} else if (ImportInfo.equalsIgnoreCase("Country")) {
			clickElement(driver, test, OCR_ImpReq_ImpStatus_Country, "Click on Import Country CheckBox");
		} else if (ImportInfo.equalsIgnoreCase("FreightForward")) {
			clickElement(driver, test, OCR_ImpReq_ImpStatus_FreightForwarder,
					"Click on Import FreightForward CheckBox");
		} else if (ImportInfo.equalsIgnoreCase("Notes")) {
			clickElement(driver, test, OCR_ImpReq_ImpStatus_Notes, "Click on Import Notes CheckBox");
		} else if (ImportInfo.equalsIgnoreCase("Documents")) {
			clickElement(driver, test, OCR_ImpReq_ImpStatus_Documents, "Click on Import Documents CheckBox");
		}
	}

	// Click on importAll Button
	public void click_ImportAllBtn() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_ImpReq_ImpStatus_ImportAllBtn, "Click on ImportAll Button");
		AlertPopUp(driver, test, "Do you wish to import all?");
	}

	// Get the text of Transation ID
	public String get_TransationID() {
		Wait.waitfor(4);
		return getAttribute(driver, test, OCR_ImpReq_ImpStatus_TransationID, "value", "Actual Transation ID : ");
	}

	// Error validation in import request Sbu
	public void sbuValidation() {
		AlertPopUp(driver, test, "Please select a SBU");
	}

	// Error validation in import request Requestor Name
	public void reqNameValidation() {
		AlertPopUp(driver, test, "Please enter Requestor Name");
	}

	// Error validation in import request Requestor Email
	public void reqEmailValidation() {
		AlertPopUp(driver, test, "Please enter Requestor Email Address");
	}

	// Error validation in import request Submit for review
	public void submitForReviewValidation() {
		AlertPopUp(driver, test, "Please select an Import Representative");
	}
	
	//Navigating to Import into License Application
	public void importIntoLicenseApplication() {
		clickElement(driver, test, OCR_ImReq_ImportIntoLicense, "Clicking on Import Into License Application Tab :");
	}

}
