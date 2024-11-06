package crsClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class AgreementReqGeneralInfoPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_BuisnessUnit = "//select[@id='editExportRequest_sbuCode']";
	public static final String OCR_RequiredByDate = "//input[@id='editExportRequest_expReqByDate']";
	public static final String OCR_RequiredByDate_Today = "//button[contains(text(),'Today')]";
	public static final String OCR_RequestorName = "//input[@id='requestorFullName']";
	public static final String OCR_RequestorEmail = "//input[@id='editExportRequest_exportRequestValue_requestorEmail']";
	public static final String OCR_RequestorPhone = "//input[@id='editExportRequest_exportRequestValue_requestorTelNo']";
	public static final String OCR_RequestorEmployeeId = "//input[@id='editExportRequest_exportRequestValue_reqEmpId']";
	public static final String OCR_AOSameAsRequestor = "//input[@id='editExportRequest_sameAsRequestorOwner']";
	public static final String OCR_AgreementOwnerName = "//input[@id='ownerFullName']";
	public static final String OCR_AgreementOwnerEmail = "//input[@id='editExportRequest_exportRequestValue_licOwnerEmail']";
	public static final String OCR_AgreementOwnerPhone = "//input[@id='editExportRequest_exportRequestValue_licOwnerTelNo']";
	public static final String OCR_AgreementOwnerEmployeeId = "//input[@id='editExportRequest_exportRequestValue_ownerEmpId']";
	public static final String OCR_AMSameAsRequestor = "//input[@id='editExportRequest_sameAsRequestorManager']";
	public static final String OCR_AgreementManagerName = "//input[@id='managerFullName']";
	public static final String OCR_AgreementManagerEmail = "//input[@id='editExportRequest_exportRequestValue_licManagerEmail']";
	public static final String OCR_AgreementManagerPhone = "//input[@id='editExportRequest_exportRequestValue_licManagerTelNo']";
	public static final String OCR_AgreementManagerEmployeeId = "//input[@id='editExportRequest_exportRequestValue_licMgrEmpId']";
	public static final String OCR_AgreementTypeTAA = "//input[@id='editExportRequest_taaT']";
	public static final String OCR_TAAYes = "//input[@id='editExportRequest_iblY']";
	public static final String OCR_TAANo = "//input[@id='editExportRequest_iblN']";
	public static final String OCR_AgreementTypeMLA = "//input[@id='editExportRequest_taaM']";
	public static final String OCR_MLAYes = "//input[@id='editExportRequest_aaggrY']";
	public static final String OCR_MLANo = "//input[@id='editExportRequest_aaggrN']";
	public static final String OCR_AgreementTypeWDA = "//input[@id='editExportRequest_taaW']";
	public static final String OCR_Button_AgreementNo = "//button[contains(text(),'Agreement No')]";
	public static final String OCR_AgreementNo = "//input[@id='editExportRequest_exportRequestValue_agreementNo']";
	public static final String OCR_AgreementPurpose = "//select[@id='editExportRequest_exportRequestValue_licPurpose']";
	public static final String OCR_SummaryandPurposeOfAgreement = "//textarea[@id='editExportRequest_exportRequestValue_descLicPurpose']";
	public static final String OCR_Site = "//body/div[@id='content-cont']/form[@id='editExportRequest']/div[3]/div[1]/div[6]/div[1]/fieldset[1]/div[3]/div[5]/fieldset[1]/div[3]/label[1]/a[1]";
	public static final String OCR_Segment = "//select[@id='editExportRequest_exportRequestValue_segment']";
	public static final String OCR_Department = "//select[@id='editExportRequest_exportRequestValue_department']";
	public static final String OCR_ProductFamily = "//select[@id='editExportRequest_exportRequestValue_prodFamily']";
	public static final String OCR_Program = "//select[@id='editExportRequest_exportRequestValue_program']";
	public static final String OCR_ProductLine = "//select[@id='editExportRequest_exportRequestValue_prodLine']";
	public static final String OCR_ContractNo = "//input[@id='editExportRequest_exportRequestValue_contractNo']";
	public static final String OCR_PurchaseOrderNo = "//input[@id='editExportRequest_exportRequestValue_purchaseOrderNo']";
	public static final String OCR_FMSCaseNo = "//input[@id='editExportRequest_exportRequestValue_fmsCaseNo']";
	public static final String OCR_Button_Save = "//button[contains(text(),'Save')]";
	public static final String OCR_AReq_RequestID = "//span[@class='status']/label/font";
	public static final String OCR_Button_ForwardNavigation = "//button[@id='next-btn']";
	public static final String OCR_GeneralDesc_Site = "(//a[contains(text(),'Site')])[2]";
	public static final String OCR_GeneralDesc_SiteSearchBtn = "//button[@name='Search']";
	public static final String OCR_GeneralDesc_SitePopSelectBtn = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_GeneralDesc_PopUpCloseBtn = "//button[@class='btn-close']";
	public static final String OCR_GeneralDesc_Segment = "(//a[contains(text(),'Segment')])[2]";
	public static final String OCR_GeneralDesc_SegentsSelectBtn = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR__GeneralDesc_Department = "(//a[contains(text(),'Department')])[2]";
	public static final String OCR_GeneralDesc_Department_SelectBtn = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_GeneralDesc_Program = "(//a[contains(text(),'Program')])[2]";
	public static final String OCR_GeneralDesc_ProgramSearchBtn = "//button[@name='Search']";
	public static final String OCR_GeneralDesc_ProgramSelectBtn = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_GeneralDesc_ProductFamily = "(//a[contains(text(),'Product Family')])[2]";
	public static final String OCR_GeneralDesc_ProductFamilySelectBtn = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_GeneralDesc_ProductLines = "(//a[contains(text(),'Product Line')])[2]";
	public static final String OCR_GeneralDesc_ProductlinesSelectBtn = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_GeneralDesc_TemplateName = "//input[@name='expTempId']";
	public static final String OCR_AReq_TemplateName = "(//span[@class='status']/label/font)[1]";

	/* ******************** Constructor ***************************** */
	public AgreementReqGeneralInfoPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	// Select SBU
	public void select_BuisnessUnit(String BuisnessUnit) {
		selectByVisibleText(driver, test, OCR_BuisnessUnit, "Selecting Buisness Unit: ", BuisnessUnit);
	}

	// Enter Required By Date
	public void enter_RequiredByDate(String RequiredByDate) {
		clickElement(driver, test, OCR_RequiredByDate, "Clicking on Required By Date");
		if (RequiredByDate.contains("Today")) {
			clickElement(driver, test, OCR_RequiredByDate_Today, "Clicking on Today: ");
		} else {
			date(driver, test, "Selecting the Required By Date : ", RequiredByDate);
		}

	}

	// Enter Requestor Details
	public void enter_RequestorDetails(String RequestorName, String RequestorEmail, String RequestorPhone,
			String RequestorEMPId) {
		clearText(driver, test, OCR_RequestorName, "Clearing Existing Data");
		typeText(driver, test, OCR_RequestorName, "Entering Requestor Name: ", RequestorName);
		clearText(driver, test, OCR_RequestorEmail, "Clearing Existing Data");
		typeText(driver, test, OCR_RequestorEmail, "Entering Requestor Email: ", RequestorEmail);
		clearText(driver, test, OCR_RequestorPhone, "Clearing Existing Data");
		typeText(driver, test, OCR_RequestorPhone, "Entering Requestor Phone: ", RequestorPhone);
		clearText(driver, test, OCR_RequestorEmployeeId, "Clearing Existing Data");
		typeText(driver, test, OCR_RequestorEmployeeId, "Entering Requestor EmployeeId: ", RequestorEMPId);
	}

	// Enter Agreement Owner Details
	public void enter_AgreementOwnerDetails(String AOName, String AOEmail, String AOPhone, String AOEMPId) {
		typeText(driver, test, OCR_AgreementOwnerName, "Entering Agreement Owner Name: ", AOName);
		typeText(driver, test, OCR_AgreementOwnerEmail, "Entering Agreement Owner Email: ", AOEmail);
		typeText(driver, test, OCR_AgreementOwnerPhone, "Entering Agreement Owner Phone: ", AOPhone);
		typeText(driver, test, OCR_AgreementOwnerEmployeeId, "Entering Agreement Owner EmployeeId: ", AOEMPId);
	}

	// Enter Agreement Manager Details
	public void enter_AgreementManagerrDetails(String AMName, String AMEmail, String AMPhone, String AMEMPId) {
		typeText(driver, test, OCR_AgreementManagerName, "Entering Agreement Manager Name: ", AMName);
		typeText(driver, test, OCR_AgreementManagerEmail, "Entering Agreement Manager Email: ", AMEmail);
		typeText(driver, test, OCR_AgreementManagerPhone, "Entering Agreement Manager Phone: ", AMPhone);
		typeText(driver, test, OCR_AgreementManagerEmployeeId, "Entering Agreement Manager EmployeeId: ", AMEMPId);
	}

	// Select Same as Requestor checkbox
	public void select_AO_SameAsRequestor() {
		clickElement(driver, test, OCR_AOSameAsRequestor, "Clicking on Same as Requestor CheckBox");
	}

	// Select Same as Requestor checkbox
	public void select_AM_SameAsRequestor() {
		clickElement(driver, test, OCR_AMSameAsRequestor, "Clicking on Same as Requestor CheckBox");
	}

	// Select Agreement Type radio button
	public void enter_AgreementType_TAA(String TAA) {
		clickElement(driver, test, OCR_AgreementTypeTAA, "Clicking on AgreementType TAA");
		if (TAA.contains("Yes")) {
			clickElement(driver, test, OCR_TAAYes, "Selecting Yes Radio Button");
		} else if (TAA.contains("No")) {
			clickElement(driver, test, OCR_TAANo, "Selecting No Radio Button");
		}
	}

	// Select MLA Radio Button and select Yes or No Checkbox
	public void enter_AgreementType_MLA(String MLA) {
		scrollToBottom(driver);
		clickElement(driver, test, OCR_AgreementTypeMLA, "Clicking on AgreementType TAA");
		if (MLA.contains("Yes")) {
			clickElement(driver, test, OCR_MLAYes, "Selecting Yes Radio Button");
		} else if (MLA.contains("No")) {
			clickElement(driver, test, OCR_MLANo, "Selecting No Radio Button");
		}
	}

	// Select Agreement Type as WDA
	public void enter_AgreementType_WDA() {
		clickElement(driver, test, OCR_AgreementTypeWDA, "Selecting AgreementType WDA");
	}

	// Add Agreement No
	public void add_AgreementNo(String AgreementNo) {
		clickElement(driver, test, OCR_Button_AgreementNo, "Click on Agreement No Button");
		Wait.waitfor(3);
		clickElement(driver, test, "//button[contains(text(),'Search')]", "Clicking on Search Button: ");
		Wait.waitfor(3);
		clickElement(driver, test,
				"//div[@id='content-cont']//div[@class='ocr-modal-base']//div[@class='ocr-modal-cont']//form[@id='searchForm']//div[@id='ocrModal']//div[@class='modal-dialog']//div[@class='modal-content']//div[@class='modal-body']//div[@id='resultDIV']//div[@class='row']//div[contains(@class,'col-xs-12')]//div[@id='gbox_gridPopup']//div[@id='gview_gridPopup']//div[@class='ui-jqgrid-bdiv']//div//tr[@id='1']//td[@class='ui-state-default jqgrid-rownum'][contains(text(),'1')]",
				"Clicking on Searched record:");
		Wait.waitfor(3);
		clickElement(driver, test, "//button[contains(text(),'Select')]", "Clicking on Select Button: ");
		// typeText(driver, test, OCR_AgreementNo, "Entering Agreement No: ",
		// AgreementNo);
	}

	// Select Agreement Purpose
	public void enter_AgreementPurpose(String AgreementPurpose) {
		selectByVisibleText(driver, test, OCR_AgreementPurpose, "Selecting Agreement Purpose : ", AgreementPurpose);
	}

	// Enter Summary and Purpose of Agreement
	public void enter_SummaryandPurposeofAgreement(String SummaryandPurposeofAgreement) {
		typeText(driver, test, OCR_SummaryandPurposeOfAgreement, "Entering Summary and Purpose of Agreement : ",
				SummaryandPurposeofAgreement);
	}

	// Enter Site
	public void select_Site(String SiteId) {
		try {
			scrollToElement(driver, OCR_GeneralDesc_Site);
			if (SiteId.length() > 0) {
				//scrollToBottom(driver);
				clickElement(driver, test, OCR_GeneralDesc_Site, "click on Site Link");
				String SitId = "//td[contains(text(),'" + SiteId + "')]";
				clickElement(driver, test, "(//td[@aria-describedby='gridPopup_siteId'])[1]", "Select the Site Id : "+SiteId);
				clickElement(driver, test, OCR_GeneralDesc_SitePopSelectBtn, "click on Select Button ");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_GeneralDesc_PopUpCloseBtn, "CLick on POP Close button");
		}
		
		//Site is Displayed
		try {
			if(isDisplayed(driver, OCR_GeneralDesc_Site)) {
				test.log(LogStatus.PASS, "Site is Displayed :");
			}
		}catch(Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Site is Not Displayed :");
		}
	}

	// Enter Segment
	public void select_Segment(String Segment) {
		try {
			if (Segment.length() > 0) {
				Wait.waitfor(3);
				clickElement(driver, test, OCR_GeneralDesc_Segment, "Click on Segment Link");
				String Seg = "//td[contains(text(),'" + Segment + "')]";
				clickElement(driver, test, "(//td[@aria-describedby='gridPopup_segmentCode'])[1]", "Select the Segment : " + Segment);
				clickElement(driver, test, OCR_GeneralDesc_SegentsSelectBtn, "click on Select Button");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_GeneralDesc_PopUpCloseBtn, "CLick on POP Close button");
		}
		
		//Segment is Displayed
		try {
			if(isDisplayed(driver, OCR_GeneralDesc_Segment)) {
				test.log(LogStatus.PASS, "Segment is Displayed :");
			}
		}catch(Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Segment is Not Displayed :");
		}
	}

	// Select the Department
	public void select_Department(String Department) {
		try {
			if (Department.length() > 0) {
				Wait.waitfor(3);
				clickElement(driver, test, OCR__GeneralDesc_Department, "click on Department Link");
				String Depart = "//td[contains(text(),'" + Department + "')]";
				clickElement(driver, test, "(//td[@aria-describedby='gridPopup_centerId'])[1]", "Select a Department : " + Department);
				clickElement(driver, test, OCR_GeneralDesc_Department_SelectBtn, "click on select button");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_GeneralDesc_PopUpCloseBtn, "CLick on POP Close button");
		}
		
		//Department is Displayed
		try {
			if(isDisplayed(driver, OCR__GeneralDesc_Department)) {
				test.log(LogStatus.PASS, "Department is Displayed :");
			}
		}catch(Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Department is Not Displayed :");
		}
	}

	// Select the Program
	public void select_Program(String Program) {
		try {
			if (Program.length() > 0) {
				Wait.waitfor(3);
				clickElement(driver, test, OCR_GeneralDesc_Program, "Click on Program Link");
				clickElement(driver, test, OCR_GeneralDesc_ProgramSearchBtn, "Click on Search Button ");
				String Prog = "//td[contains(text(), '" + Program + "')]";
				clickElement(driver, test, "(//td[@aria-describedby='gridPopup_programCode'])[1]", "Select a Program : " + Program);
				clickElement(driver, test, OCR_GeneralDesc_ProgramSelectBtn, "Click on Select Button");
			}
			else {
				typeText(driver, test, "//textarea[@name='exportRequestValue.program']", "Entering Program By Manually :", Program);
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_GeneralDesc_PopUpCloseBtn, "CLick on POP Close button");
		}
		
		//Program is Displayed
		try {
			if(isDisplayed(driver, OCR_GeneralDesc_Program)) {
				test.log(LogStatus.PASS, "Program is Displayed :");
			}
		}catch(Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Program is Not Displayed :");
		}
	}

	// Select the ProductFamily
	public void select_ProductFamily(String ProductFamily) {
		try {
			if (ProductFamily.length() > 0) {
				Wait.waitfor(3);
				clickElement(driver, test, OCR_GeneralDesc_ProductFamily, "click on product family Link");
				String ProductF = "//td[contains(text(), '" + ProductFamily + "')]";
				clickElement(driver, test, "(//td[@aria-describedby='gridPopup_familyId'])[1]", "Select product family : " + ProductFamily);
				clickElement(driver, test, OCR_GeneralDesc_ProductFamilySelectBtn, "Click on Select Button");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_GeneralDesc_PopUpCloseBtn, "CLick on POP Close button");
		}
		
		//Product Family is Displayed
		try {
			if(isDisplayed(driver, OCR_GeneralDesc_ProductFamily)) {
				test.log(LogStatus.PASS, "Product Family is Displayed :");
			}
		}catch(Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Product Family is Not Displayed :");
		}
	}

	// Select the ProductLines
	public void select_ProductLines(String ProductLines) {
		try {
			if (ProductLines.length() > 0) {
				Wait.waitfor(3);
				clickElement(driver, test, OCR_GeneralDesc_ProductLines, "Click on product Line Link");
				String ProductL = "//td[contains(text(),'" + ProductLines + "')]";
				clickElement(driver, test, "(//td[@aria-describedby='gridPopup_prodLineId'])[1]", "Select Product Line : " + ProductLines);
				clickElement(driver, test, OCR_GeneralDesc_ProductlinesSelectBtn, "Click on Select Button");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_GeneralDesc_PopUpCloseBtn, "CLick on POP Close button");
		}
		
		//Product Line is Displayed
		try {
			if(isDisplayed(driver, OCR_GeneralDesc_ProductLines)) {
				test.log(LogStatus.PASS, "Product Line is Displayed :");
			}
		}catch(Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Product Line is Not Displayed :");
		}
	}

	// Enter Buisness Details
	public void enter_BusinessDetails(String ContractNo, String PurchaseOrderNo, String FMSCaseNo) {
		scrollToBottom(driver);
		typeText(driver, test, OCR_ContractNo, "Entering Contract No: ", ContractNo);
		typeText(driver, test, OCR_PurchaseOrderNo, "Entering Purchase Order No: ", PurchaseOrderNo);
		typeText(driver, test, OCR_FMSCaseNo, "Entering FMS Case No: ", FMSCaseNo);
		scrollToTop(driver);
		scrollToElement(driver, OCR_Button_Save);
	}

	// Validate General Info Tab
	public void validate_AgrGeneralInfoError() {
		try {
			if (isDisplayed(driver, "//h4[contains(text(),'Error')]")) {

				if (isDisplayed(driver, "//li[contains(text(),'Please select Business Unit ')]")) {
					test.log(LogStatus.INFO, "Please select Business Unit");
				}
				if (isDisplayed(driver, "//li[contains(text(),'Please enter Requester name ')]")) {
					test.log(LogStatus.INFO, "Please enter Requester name ");
				}
				if (isDisplayed(driver, "//li[contains(text(),'Please enter Requester email ')]")) {
					test.log(LogStatus.INFO, "Please enter Requester email");
				}
				if (isDisplayed(driver,
						"//li[contains(text(),'Please select Technical Assistance Agreement (TAA)/Manufacturing License Agreement (MLA)/Warehouse Distribution Agreement (WDA)')]")) {
					test.log(LogStatus.INFO,
							"Please select Technical Assistance Agreement (TAA)/Manufacturing License Agreement (MLA)/Warehouse Distribution Agreement (WDA)");
				}
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL,
					"Error Vaildation is not Displayed by clicking on SAVE button in General Info Page");
		}
	}

	// Validate Agreement type
	public void validate_AgreemenTypeError() {
		try {
			if (isDisplayed(driver, "//h4[contains(text(),'Error')]")) {

				if (isDisplayed(driver,
						"//li[contains(text(),'Both Rebaseline and Amendment cannot be selected as Yes ')]")) {
					test.log(LogStatus.INFO, "Both Rebaseline and Amendment cannot be selected as Yes ");
				}
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL,
					"Error Vaildation is not Displayed by clicking on SAVE button in General Info Page");
		}
	}

	// Move to Agreement Details Page
	public void moveto_AgreementDetailsPage() {
		clickElement(driver, test, "//a[contains(text(), 'Agreement Details')]", "Clicking on Agreement Details ");
	}

	// Move to Questionnairre Page
	public void moveto_QuestionnairrePage() {
		clickElement(driver, test, "//a[@class='questionnairemain']", "Clicking on Questionnaire ");
	}

	// Click on Save Button
	public void click_SaveButton() {
		scrollToElement(driver, OCR_Button_Save);
		Wait.waitfor(3);
		//scrollToTop(driver);
		clickElement(driver, test, OCR_BuisnessUnit, "");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_Button_Save, "Clicking on Save Button: ");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_BuisnessUnit, "");
	}

	// Click on Forward Button
	public void moveForward() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(OCR_Button_ForwardNavigation)));
	}
	
	// Click on Types Of Export
	public void typesOfExport() {
		clickElement(driver, test, "//span[contains(text(),'Type of Export')]", "Clicking on Types Of Export Tab :");
	}

	// Move to Documents Page
	public void moveto_DocumentsPage() {
		clickElement(driver, test, "//a[contains(text(), 'Documents/Notes')]", "Clicking on Documents/Notes Page ");
	}

	// Move to Submit Page
	public void moveto_SubmitPage() {
		clickElement(driver, test, "//a[contains(text(), 'Submit')]", "Clicking on Submit Page ");
	}

	// Getting the Request ID
	public String get_RequestID() {
		return getText(driver, test, OCR_AReq_RequestID, "Get the Actual text of Request ID : ");
	}
	
	//Template Name
	public void templateName(String TemplateName) {
		typeText(driver, test, OCR_GeneralDesc_TemplateName, "Entering Template Name :", TemplateName+randomnumbers());
	}
	
	// Getting the Request ID
	public String get_TemplateName() {
		return getText(driver, test, OCR_AReq_TemplateName, "Get the Actual Template Name : ");
	}

}
