package crsClasses;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class ExportAddRequestorDetailsPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* *****************************Locators********************************** */

	public static final String OCR_ExportRequest_TemplatePageNewRequestBtn = "//button[contains(text(),'New Request')]";
	public static final String OCR_ExportRequest_Template = "//select[@name='templateName']";
	public static final String OCR_ExportRequest_SelectBtn = "//button[contains(text(),'Select')]";
	public static final String OCR_Export_RequestorDetailsTab = "//span[contains(text(),'Requestor Details')]";
	public static final String OCR_ExportRequestId = "//input[@id='editExportRequest_exportRequestValue_expReqId']";
	public static final String OCR_ExportRequiredByDate = "//input[@id='editExportRequest_expReqByDate']";
	public static final String OCR_ExportRequest_EndValidityDate = "//input[@id='editExportRequest_endValidityDate']";
	public static final String OCR_ExportRequest_PODate = "//input[@id='editExportRequest_poDate']";
	public static final String OCR_ExportRequest_BusinessUnitSBU = "//select[@id='editExportRequest_sbuCode']";
	public static final String OCR_ExportRequest_IntiatedDate = "//input[@id='editExportRequest_dateInitiated']";
	public static final String OCR_ExportRequest_AuthorizationCountryForExport = "//input[@id='editExportRequest_exportRequestValue_exportCountryName']";
	public static final String OCR_ExportReuest_RequestorNamePopuplink = "(//a[contains(text(),'Name')])[1]";
	public static final String OCR_ExportReuest_RequestorUserFName = "//input[@id='searchForm_userProfile_userFirstname']";
	public static final String OCR_ExportRequest_UserPopUp_SearchBtn = "//button[@name='Search']";
	public static final String OCR_ExportRequest_UserPopUp_SelectBtn = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_ExportRequest_UserPopUpClose = "//button[@class='close']";
	public static final String OCR_ExportRequest_RequestorName = "//input[@id='userFullName']";
	public static final String OCR_ExportRequest_RequestorEmail = "//input[@id='editExportRequest_exportRequestValue_requestorEmail']";
	public static final String OCR_ExportRequest_RequestorPhone = "//input[@id='editExportRequest_exportRequestValue_requestorTelNo']";
	public static final String OCR_ExportRequest_LicenseOwnerLink = "(//a[contains(text(),'Owner')])[2]";
	public static final String OCR_ExportRequest_LicenseOwnerFName = "//input[@id='searchForm_dosLicenseOwnerPopupDTO_ownerFirstName']";
	public static final String OCR_ExportRequest_LicenseOwnerSearchBtn = "//button[@name='Search']";
	public static final String OCR_ExportRequest_LicenseOwnerSelectBtn = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_ExportRequest_LicenseOwner = "//input[@id='ownerFullName']";
	public static final String OCR_ExportRequest_LOEmpID = "//input[@id='editExportRequest_exportRequestValue_reqEmpId']";
	public static final String OCR_ExportRequest_LOEmail = "//input[@id='editExportRequest_exportRequestValue_licOwnerEmail']";
	public static final String OCR_ExportRequest_LOPhone = "//input[@id='editExportRequest_exportRequestValue_licOwnerTelNo']";
	public static final String OCR_ExportRequest_Owner_SameAsRequestorCheckbox = "//input[@id='editExportRequest_sameAsRequestorOwner']";
	public static final String OCR_ExportRequest_LicenseManagerLink = "//a[contains(text(),'Manager')]";
	public static final String OCR_ExportRequest_LicenseManagerUserFName = "//input[@id='searchForm_userProfile_userFirstname']";
	public static final String OCR_ExportRequest_LicenseManagerUserSearchBtn = "//button[@name='Search']";
	public static final String OCR_ExportRequest_LicenseManagerUserSelect = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_ExportRequest_LicenseManager = "//input[@id='userLMFullName']";
	public static final String OCR_ExportRequest_LMEmail = "//input[@id='editExportRequest_exportRequestValue_licManagerEmail']";
	public static final String OCR_ExportRequest_LMPhone = "//input[@id='editExportRequest_exportRequestValue_licManagerTelNo']";
	public static final String OCR_ExportRequest_Manager_SameAsRequestorCheckbox = "//input[@id='editExportRequest_sameAsRequestorManager']";
	public static final String OCR_ExportRequest_ExporterView = "//a[@class='accordion-toggle']//label[contains(text(),'Exporter')]";
	public static final String OCR_ExportRequest_Exporterlink = "//a[contains(text(),'Exporter')]";
	public static final String OCR_ExportRequest_ExporterCode = "//input[@id='searchForm_exporter_expCode']";
	public static final String OCR_ExportRequest_ExporterPopUpStatusBtn = "//select[@id='searchForm_exporter_status']";
	public static final String OCR_ExportRequest_ExporterPopUpSearchBtn = "//button[@name='Search']";
	public static final String OCR_ExportRequest_ExporterPopUpSelectBtn = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_ExportRequest_Purposedropdown = "//select[@id='licPurpose']";
	public static final String OCR_ExportRequest_SummaryPurposeofExportRequest = "//textarea[@id='editExportRequest_exportRequestValue_descLicPurpose']";
	public static final String OCR_ExportRequest_SaveBtn = "(//input[@name='saveGenInfo'])[2]";
	public static final String OCR_ExportRequest_SBUnit = "//select[@id='editExportRequest_sbuCode']";
	public static final String OCR_GeneralInfo_TypeOfExportLink = "//span[contains(text(),'Type of Export')]";
	public static final String OCR_GeneralDescriptionLink = "//li[@class='GeneralDescriptionSubTab']";
	public static final String OCR_ExportRequest_ExportInfo = "//a[@class='expInfo']";
	public static final String OCR_ExportRequest_CountryBtn = "//input[@id='addCountryId']";
	public static final String OCR_ExportRequest_ItemLink = "//span[contains(text(),'Items')]";
	public static final String OCR_ExportRequest_AddItemBtn = "//input[@id='addItemId']";
	public static final String OCR_ExportRequest_PartiesLink = "//span[contains(text(),'Parties')]";
	public static final String OCR_ExportRequest_AddPartyBtn = "//input[@id='addPartyId']";
	public static final String OCR_ExportRequest_FreightForwarderLink = "//span[contains(text(),'Freight Forwarders')]";
	public static final String OCR_ExportRequest_AddFreightForwaarderBtn = "//input[@id='freightForwardId']";
	public static final String OCR_ExportRequest_PortsLink = "//span[contains(text(),'Ports')]";
	public static final String OCR_ExportRequest_AddPortBtn = "//input[@id='addPortId']";
	public static final String OCR_ExportRequest_SourceManufacturerLink = "//span[contains(text(),'Source /Manufacturer')]";
	public static final String OCR_ExportRequest_AddSourceMigBtn = "//input[@id='addSourceMfgId']";
	public static final String OCR_ExportRequest_AddDocumentLink = "//span[contains(text(),'Documents')]";
	public static final String OCR_ExportRequest_AddDocumentBtn = "//button[@id='addDocumentId']";
	public static final String OCR_ExportRequest_AdditionalInfoLink = "//a[@class='misc']";
	public static final String OCR_ExportRequest_QuestionnaireLink = " //li[@class='QuestionnaireSubTab selected'] ";
	public static final String OCR_ExportRequest_ContractsLink = "//span[contains(text(),'Contracts')]";
	public static final String OCR_ExportRequest_AdditionalQuestionsLink = "//span[contains(text(),'Additional Questions')]";
	public static final String OCR_ExportRequest_SubmitRequestLink = "//a[@class='subReq']";
	public static final String OCR_ExportRequest_Submit_AddNoteBtn = "//input[@id='addNotesId']";
	public static final String OCR_ExportRequest_SubmitReq_SubmitTab = "//span[contains(text(),'Submit')]";
	public static final String OCR_ExportRequest_SubmitReq_EFocalPointName = "(//a[contains(text(),' Name')])[1]";
	public static final String OCR_ExportRequest_SubmitReq_EUserName = "//input[@id='searchForm_userProfile_userFirstname']";
	public static final String OCR_ExportRequest_SubmitReq_SubmitForReviewBtn = "//input[@name='saveSubmit']";
	public static final String OCR_ExportRequest_ExportStatus = "//a[@class='disp']";
	public static final String OCR_ExportRequest_TStatus_Decision = "//select[@id='editStatusInfo_tdfpStatus']";
	public static final String OCR_ExportRequest_EStatus_Decision = "//select[@id='editStatusInfo_ecfpStatus']";
	public static final String OCR_ExportRequest_EStatus_Determination = "//select[@id='editStatusInfo_disposition']";
	public static final String OCR_ExportRequest_TStatus_SaveAndFinalize = "//input[@name='saveTdfp']";
	public static final String OCR_ExportRequest_EStatus_SaveAndFinalize = "//input[@name='saveEdfp']";
	public static final String OCR_ExportRequest_RequestID = "//span[@class='status']/label/font";
	public static final String OCR_ExportRequest_Status = "//span[@class='status']/label/font[2]";
	public static final String OCR_ExportRequest_ImportIntoAA = "//span[contains(text(),'Import Into Authorization Application')]";
	public static final String OCR_ExportRequest_AuthorizationType = "//select[@id='licenseTypeId']";
	public static final String OCR_ExportRequest_UseExportReqID = "//input[@name='useExpId']";
	public static final String OCR_ExportRequest_SaveImportinfo = "//input[@name='saveImportInfo']";
	public static final String OCR_ExportRequest_TransationID = "//input[@id='editExportRequest1_exportRequestValue_licenseTransactionId']";
	public static final String OCR_ExportRequest_ImportAll = "//input[@name='imprtAll']";
	public static final String OCR_ExportRequest_SubmitReq_ETechnicalPointName = "//body/div[@id='content-cont']/div[6]/form[2]/div[1]/div[2]/div[2]/fieldset[1]/div[1]/label[1]/a[1]";
	public static final String OCR_ExportRequest_SubmitReq_EName = "//input[@name='userProfile.userFirstname']";
	public static final String OCR_ExportRequest_EFPName = "//a[@id='ecfpLinkForTE']";
	public static final String OCR_ExportRequest_TemplateName = "//input[@name='expTempId']";

	/************************* constructor ***********************/
	public ExportAddRequestorDetailsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	// Adding New Request
	public void addNewRequest() {
		clickElement(driver, test, OCR_ExportRequest_TemplatePageNewRequestBtn,
				"click on New Request on Template Page :");
	}

	// select the required template
	public void select_template(String templateName) {
		selectByVisibleText(driver, test, OCR_ExportRequest_Template, "Selct the template : ", templateName);
		Wait.waitfor(3);
		clickElement(driver, test, OCR_ExportRequest_SelectBtn, "Click on select button :");
	}

	// Add the required template Name
	public void add_template(String templateName) {
		typeText(driver, test, OCR_ExportRequest_TemplateName, "Adding Template Name :",
				templateName + randomnumbersbetween1_100());
	}

	// Adding Requestor
	public void addRequestor(String RequestorUserFirstName, String RequestorName, String RequestorEmail,
			String RequestorPhone) {
		if (RequestorUserFirstName.length() > 0) {
			clickElement(driver, test, OCR_ExportReuest_RequestorNamePopuplink, "click on requestor Name link :");
			try {
				typeText(driver, test, OCR_ExportReuest_RequestorUserFName, "Enter user first name : ",
						RequestorUserFirstName);
				clickElement(driver, test, OCR_ExportRequest_UserPopUp_SearchBtn, "click on user Search button :");
				String userFName = "(//td[contains(text(),'" + RequestorUserFirstName + "')])[1]";
				clickElement(driver, test, userFName, "Select the user first name : " + RequestorUserFirstName);
				clickElement(driver, test, OCR_ExportRequest_UserPopUp_SelectBtn, "Click on user Select button :");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_ExportRequest_UserPopUpClose, "Click on Cancle icon :");
			}
		} else {
			typeText(driver, test, OCR_ExportRequest_RequestorName, "Enter requestor name : ", RequestorName);
			typeText(driver, test, OCR_ExportRequest_RequestorEmail, "Enter requestor Email : ", RequestorEmail);
			typeText(driver, test, OCR_ExportRequest_RequestorPhone, "Enter requestor phone : ", RequestorPhone);
		}
	}

	// Adding license owner
	public void addLicenseOwner(String LOSameAsRequestor, String LOFirstName, String LicenseOwner, String LOEmpID,
			String LOEmail, String LOPhone) {
		Wait.waitfor(3);
		if (!LOSameAsRequestor.equalsIgnoreCase("Yes")) {
			if (LOFirstName.length() > 0) {
				clickElement(driver, test, OCR_ExportRequest_LicenseOwnerLink, "Click on License owner link :");
				try {
					clickElement(driver, test, "(//input[@name='searchBy'])[1]",
							"Clicking on Search From Authorization Owner Radio Button :");
					typeText(driver, test, OCR_ExportRequest_LicenseOwnerFName, "Enter license owner First Name : ",
							LOFirstName);
					clickElement(driver, test, OCR_ExportRequest_LicenseOwnerSearchBtn, "Click on Search button :");
					String LOFName = "//td[contains(text(),'" + LOFirstName + "')]";
					clickElement(driver, test, "//td[contains(text(),'" + LOFirstName + "')]",
							"Select owner first name : " + LOFirstName);
					clickElement(driver, test, OCR_ExportRequest_LicenseOwnerSelectBtn, "Click on owner Select :");
				} catch (Exception e) {
					testFailSshot(driver, test);
					clickElement(driver, test, OCR_ExportRequest_UserPopUpClose, "Click on Cancle icon :");
				}
			} else {
				typeText(driver, test, OCR_ExportRequest_LicenseOwner, "Enter license owner : ", LicenseOwner);
				typeText(driver, test, OCR_ExportRequest_LOEmpID, "Enter license owner Employee ID : ", LOEmpID);
				typeText(driver, test, OCR_ExportRequest_LOEmail, "Enter license owner Email : ", LOEmail);
				typeText(driver, test, OCR_ExportRequest_LOPhone, "Enter license owner Phone : ", LOPhone);
			}
		} else {
			clickElement(driver, test, OCR_ExportRequest_Owner_SameAsRequestorCheckbox,
					"click on license owner Same as requestor checkbox :");
		}
	}

	// Adding license Manager
	public void addLicenseManager(String LMSameAsRequestor, String LMFirstName, String LicenseManager, String LMEmail,
			String LMPhone) {
		Wait.waitfor(3);
		if (!LMSameAsRequestor.equalsIgnoreCase("Yes")) {
			if (LMFirstName.length() > 0) {
				clickElement(driver, test, OCR_ExportRequest_LicenseManagerLink, "Click on License Manager Link :");
				try {
					typeText(driver, test, OCR_ExportRequest_LicenseManagerUserFName,
							"Click on License Manager User First Name : ", LMFirstName);
					clickElement(driver, test, OCR_ExportRequest_LicenseManagerUserSearchBtn,
							"Click on User Search button :");
					String lmFirstName = "//td[contains(text(),'" + LMFirstName + "')]";
					clickElement(driver, test, lmFirstName, "Select the user first name : " + LMFirstName);
					clickElement(driver, test, OCR_ExportRequest_LicenseManagerUserSelect,
							"Click on User Select button :");
				} catch (Exception e) {
					testFailSshot(driver, test);
					clickElement(driver, test, OCR_ExportRequest_UserPopUpClose, "Click on Cancle icon :");
				}
			} else {
				typeText(driver, test, OCR_ExportRequest_LicenseManager, "Enter license manger : ", LicenseManager);
				typeText(driver, test, OCR_ExportRequest_LMEmail, "Enter License Manager Email : ", LMEmail);
				typeText(driver, test, OCR_ExportRequest_LMPhone, "Enter License Manager Phone : ", LMPhone);
			}
		} else {
			clickElement(driver, test, OCR_ExportRequest_Manager_SameAsRequestorCheckbox,
					"Click on License Manager Same as Requestor checkbox :");
		}
	}

	// Adding the Exporter
	public void addExporter(String ExpoterStatus, String ExporterCode) {
		scrollToElement(driver, "//legend[contains(text(),'Export Request')]");
		Wait.waitfor(3);
		try {
			if (!isDisplayed(driver, OCR_ExportRequest_Exporterlink)) {
				clickElement(driver, test, OCR_ExportRequest_ExporterView, "Click on Exporter :");
			}
		} catch (Exception e1) {
			Wait.waitfor(2);
		}
		Wait.waitfor(3);
		clickElement(driver, test, OCR_ExportRequest_Exporterlink, "click on Exporter Link :");
		try {
			if (isDisplayed(driver, "//h4[contains(text(),'Exporter')]")) {
				test.log(LogStatus.PASS, "Exporter Popup is Displayed :");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Exporter Popup is Not Displayed :");
		}
		try {
			typeText(driver, test, OCR_ExportRequest_ExporterCode, "Enter Exporter code : ", ExporterCode);
			Wait.waitfor(3);
			selectByVisibleText(driver, test, OCR_ExportRequest_ExporterPopUpStatusBtn, "Select Approve as Status : ",
					ExpoterStatus);
			Wait.waitfor(3);
			clickElement(driver, test, OCR_ExportRequest_ExporterPopUpSearchBtn, "click on Search button :");
			Wait.waitfor(3);
			String ExpCode = "//td[contains(text(),'" + ExporterCode + "')]";
			clickElement(driver, test, ExpCode, "Select the Exporter Code : " + ExporterCode);
			Wait.waitfor(3);
			clickElement(driver, test, OCR_ExportRequest_ExporterPopUpSelectBtn, "Click on Select button :");
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_ExportRequest_UserPopUpClose, "Click on Cancle icon :");
		}
	}

	// Adding the purpose
	public void addPurpose(String Purpose, String Summary) {
		Wait.waitfor(3);
		scrollToElement(driver, OCR_ExportRequest_Purposedropdown);
		selectByVisibleText(driver, test, OCR_ExportRequest_Purposedropdown, "Select Purpose : ", Purpose);
		typeText(driver, test, OCR_ExportRequest_SummaryPurposeofExportRequest, "summary purpose of Export Request : ",
				Summary);
		Wait.waitfor(3);
	}

	// click on Save button
	public void saveExportRequest() {
		scrollToElement(driver, "//div[@class='top-empty-row']");
		Wait.waitfor(4);
		clickElement(driver, test, OCR_ExportRequest_SaveBtn, "Click on save button :");
	}

	// Click on Type of Export Link
	public void clickTypeofExportLink() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_GeneralInfo_TypeOfExportLink, "Click on Type of Export Link :");
	}

	// Click on General Description Link
	public void clickOnGeneralDescription() {
		clickElement(driver, test, OCR_GeneralDescriptionLink, "Click on General Description Link :");
	}

	// click on Export info
	public void click_ExportInfo() {
		Wait.waitfor(3);
		scrollToTop(driver);
		clickElement(driver, test, "//input[@id='editExportRequest_exportRequestValue_otherSite']",
				"mouse over to Export info :");
		Wait.waitfor(4);
		clickElement(driver, test, OCR_ExportRequest_ExportInfo, "Click on Export Info :");
	}

	// click on Export info
	public void click_ExportInfoTab() {
		Wait.waitfor(3);
		scrollToTop(driver);
		Wait.waitfor(4);
		clickElement(driver, test, OCR_ExportRequest_ExportInfo, "Click on Export Info :");
	}

	// click on Add Country button
	public void clickOnCountryLink() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_ExportRequest_CountryBtn, "click on Add Country button :");
	}

	// Adding the Add items
	public void addItemLink() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_ExportRequest_ItemLink, "click on Item Link :");
		clickElement(driver, test, OCR_ExportRequest_AddItemBtn, "click on Add Item Button :");
	}

	// Adding the add parties
	public void addPartiesLink() {
		clickElement(driver, test, "//label[contains(text(),'Request Id :')]", "");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_ExportRequest_PartiesLink, "Click on Parties Link :");
		clickElement(driver, test, OCR_ExportRequest_AddPartyBtn, "click on add party button :");
	}

	// Adding the add freight forwarders
	public void addFreightFowarders() {
		clickElement(driver, test, OCR_ExportRequest_FreightForwarderLink, "click on Freight Forwarder Tab :");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_ExportRequest_AddFreightForwaarderBtn,
				"Click on Add Freight Forwarder Button :");
	}

	// Adding the add ports
	public void addPorts() {
		clickElement(driver, test, OCR_ExportRequest_PortsLink, "click on Ports Tab :");
		clickElement(driver, test, OCR_ExportRequest_AddPortBtn, "click on Add Port Button :");
	}

	// Adding the source manufacturer
	public void addSourceManufacturer() {
		clickElement(driver, test, OCR_ExportRequest_SourceManufacturerLink, "click on Source Manufacturer Tab :");
		clickElement(driver, test, OCR_ExportRequest_AddSourceMigBtn, "click on Add SourceManufacturer Button :");
	}

	// Adding Add Document
	public void addDocument() {
		clickElement(driver, test, OCR_ExportRequest_AddDocumentLink, "click on Document Tab :");
		clickElement(driver, test, OCR_ExportRequest_AddDocumentBtn, "click on Add Document Button :");
	}

	// Adding Additional info
	public void addAdditionalInfo() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_ExportRequest_AdditionalInfoLink, "Click on Additional Info Tab :");
	}

	// Click on add questionnaire
	public void addQuestionnaire() {
		clickElement(driver, test, OCR_ExportRequest_QuestionnaireLink, "Click on Questionnaire Tab :");
	}

	// Click on Contracts Link
	public void addContracts() {
		// clickElement(driver, test, "(//a[@class='dropdown-item'])[50]", "");
		Wait.waitfor(2);
		clickElement(driver, test, OCR_ExportRequest_ContractsLink, "Click on Contracts Tab :");
	}

	// click on Additional Question Link
	public void addAdditionalQuestions() {
		clickElement(driver, test, OCR_ExportRequest_AdditionalQuestionsLink, "click on Additional Question Tab :");
	}

	// Click on Submit Request
	public void submitRequest() {
		clickElement(driver, test, OCR_ExportRequest_SubmitRequestLink, "Click on Submit Request :");
	}

	// Click on ADD Notes button
	public void addNotesBtn() {
		clickElement(driver, test, OCR_ExportRequest_Submit_AddNoteBtn, "Click on ADD Notes button :");
	}

	// Click on Submit Tab
	public void click_submitTab() {
		clickElement(driver, test, OCR_ExportRequest_SubmitReq_SubmitTab, "Click on Submit Tab :");
	}

	// Adding the Export focal point
	public void Add_ExportFocalPoint(String ExportFocalUserName) {
		if (isEnabled(driver, OCR_ExportRequest_SubmitReq_EFocalPointName)) {
			clickElement(driver, test, OCR_ExportRequest_SubmitReq_EFocalPointName, "Click on name link :");
			try {
				typeText(driver, test, OCR_ExportRequest_SubmitReq_EUserName, "Enter the user First Name : ",
						ExportFocalUserName);
				clickElement(driver, test, OCR_ExportRequest_UserPopUp_SearchBtn, "Click on Search button :");
				String user = "//div[@class='ocr-modal-base']//td[contains(text(),'" + ExportFocalUserName + "')]";
				Wait.waitfor(3);
				clickElement(driver, test, user, "Click on user First name : " + ExportFocalUserName);
				clickElement(driver, test, OCR_ExportRequest_UserPopUp_SelectBtn, "Click on Select button :");
				Wait.waitfor(3);
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_ExportRequest_UserPopUpClose, "Click on Cancle icon :");
			}
		}
	}

	// Adding the Technical focal point
	public void Add_TechnicalFocalPoint(String ExportFocalUserName) {
		if (isEnabled(driver, OCR_ExportRequest_SubmitReq_ETechnicalPointName)) {
			clickElement(driver, test, OCR_ExportRequest_SubmitReq_ETechnicalPointName, "Click on name link :");
			try {
				typeText(driver, test, OCR_ExportRequest_SubmitReq_EName, "Enter the user First Name : ",
						ExportFocalUserName);
				clickElement(driver, test, OCR_ExportRequest_UserPopUp_SearchBtn, "Click on Search button :");
				String user = "//div[@class='ocr-modal-base']//td[contains(text(),'" + ExportFocalUserName + "')]";
				Wait.waitfor(3);
				clickElement(driver, test, user, "Click on user First name : " + ExportFocalUserName);
				clickElement(driver, test, OCR_ExportRequest_UserPopUp_SelectBtn, "Click on Select button :");
				Wait.waitfor(3);
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_ExportRequest_UserPopUpClose, "Click on Cancle icon :");
			}
		}
	}

	// Click on Submit For Review button
	public void click_submitForReview() {
		clickElement(driver, test, OCR_ExportRequest_SubmitReq_SubmitForReviewBtn,
				"Click on Submit For Review button :");
	}

	// Click on Export Status Tab
	public void click_ExportStatus() {
		clickElement(driver, test, OCR_ExportRequest_ExportStatus, "Click on Export Status Tab :");
	}

	// Adding the Export focal point Name
	public void Add_ExportFocalPointName(String ExportFocalUserName) {
		clickElement(driver, test, OCR_ExportRequest_EFPName, "Clicking on Export Focal Point Name Link :");
		try {
			typeText(driver, test, OCR_ExportRequest_SubmitReq_EUserName, "Enter the user First Name : ",
					ExportFocalUserName);
			clickElement(driver, test, OCR_ExportRequest_UserPopUp_SearchBtn, "Click on Search button :");
			String user = "//div[@class='ocr-modal-base']//td[contains(text(),'" + ExportFocalUserName + "')]";
			Wait.waitfor(3);
			clickElement(driver, test, user, "Click on user First name : " + ExportFocalUserName);
			clickElement(driver, test, OCR_ExportRequest_UserPopUp_SelectBtn, "Click on Select button :");
			Wait.waitfor(3);
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_ExportRequest_UserPopUpClose, "Click on Cancle icon :");
		}
	}

	// Adding the Export Status
	public void add_ExportStatus(String Decision, String Determination) {
		selectByVisibleText(driver, test, OCR_ExportRequest_EStatus_Decision, "Select the Decision : ", Decision);
		selectByVisibleText(driver, test, OCR_ExportRequest_EStatus_Determination, "Select the Determination : ",
				Determination);
		click_SaveAndFinalizeBtn();
	}

	// Technical Focal Point Decision
	public void techFocusDecion(String Decision) {
		selectByVisibleText(driver, test, OCR_ExportRequest_TStatus_Decision,
				"Selecting Technical Focal Point Decision :", Decision);
		Wait.waitfor(3);
		clickElement(driver, test, OCR_ExportRequest_TStatus_SaveAndFinalize, "Clicking on Save and Finaliz Button :");
	}

	// click on Save and Finalize Decision button
	public void click_SaveAndFinalizeBtn() {
		clickElement(driver, test, OCR_ExportRequest_EStatus_SaveAndFinalize,
				"Click on Save and Finalize Decision button :");
	}

	// Getting the Request ID
	public String get_RequestID() {
		return getText(driver, test, OCR_ExportRequest_RequestID, "Get the Actual text of Request ID : ");
	}

	// Getting the Status
	public String get_Status() {
		return getText(driver, test, OCR_ExportRequest_Status, "Get the Actual text of Status : ");
	}

	// Add Items is Added to the Result grid or not
	public void exportInfoAddItemToResultsGrid(String PartNo) {
		Wait.waitfor(3);
		String addItem = "//table[@id='gridPopup1']/tbody/tr/td[contains(text(),'" + PartNo + "')]";
		try {
			if (isDisplayed(driver, addItem)) {
				test.log(LogStatus.PASS, "Add Item in add to result grid table : " + PartNo);
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Fail to Add Item in result grid table : " + PartNo);
		}
	}

	// Add Parties is Added to the Result grid or not
	public void exportInfoaddPartiesToResultsGrid(String PartiesCode) {
		Wait.waitfor(3);
		String addParties = "//table[@id='gridconsignee']/tbody/tr/td[contains(text(),'" + PartiesCode + "')]";
		try {
			if (isDisplayed(driver, addParties)) {
				test.log(LogStatus.PASS, "Add Parties in add to result grid table : " + PartiesCode);
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Fail to Add Parties in result grid table : " + PartiesCode);
		}
	}

	// Add Freight Forwarder is Added to the Result grid or not
	public void exportInfoaddFreightForwarderToResultsGrid(String FFCode) {
		Wait.waitfor(3);
		String addFreightForwarder = "//table[@id='gridff']/tbody/tr/td[contains(text(),'" + FFCode + "')]";
		try {
			if (isDisplayed(driver, addFreightForwarder)) {
				test.log(LogStatus.PASS, "Add Freight Forwarder in add to result grid table : " + FFCode);
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Fail to Add Freight Forwarder in result grid table : " + FFCode);
		}
	}

	// Add Port is Added to the Result grid or not
	public void exportInfoaddPortToResultsGrid(String PortID) {
		Wait.waitfor(3);
		String addPortID = "//table[@id='gridport']/tbody/tr/td[contains(text(),'" + PortID + "')]";
		try {
			if (isDisplayed(driver, addPortID)) {
				test.log(LogStatus.PASS, "Add Port in add to result grid table : " + PortID);
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Fail to Add Port in result grid table : " + PortID);
		}
	}

	// Add Source and manufacturer is Added to the Result grid or not
	public void exportInfoSourceManfturToResultsGrid(String ManufacturerCode) {
		Wait.waitfor(3);
		String addPortID = "//table[@id='gridmfg']/tbody/tr/td[contains(text(),'" + ManufacturerCode + "')]";
		try {
			if (isDisplayed(driver, addPortID)) {
				test.log(LogStatus.PASS,
						"Add Source and manufacturer in add to result grid table : " + ManufacturerCode);
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Fail to Add Source and manufacturer in result grid table : " + ManufacturerCode);
		}
	}

	// Add Document is Added to the Result grid or not
	public void exportInfoDocumentToResultsGrid(String UploadfileName) {
		Wait.waitfor(3);
		String addPortID = "//table[@id='docAttachGrid']/tbody/tr/td[contains(text(),'" + UploadfileName + "')]";
		try {
			if (isDisplayed(driver, addPortID)) {
				test.log(LogStatus.PASS, "Add Document in add to result grid table : " + UploadfileName);
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Fail to Add Document in result grid table : " + UploadfileName);
		}
	}

	// Alert for return for rework
	public void alertReturnedForRework() {
		AlertPopUp(driver, test, "Do you wish to continue without Reviewer Remarks or Reason for Return?");
	}

	// Error validation for Requestor Name
	public void validateRequestorName() {
		AlertPopUp(driver, test, "Please enter Requestor Name :");
	}

	// Error validation for Email
	public void validteRequestorEmail() {
		AlertPopUp(driver, test, "Please enter Requestor Email Address :");
	}

	// Error validation in Submit Request
	public void validate_SubmitReq() {
		try {
			if (isDisplayed(driver, "//h4[contains(text(),'Error!')]")) {
				if (isDisplayed(driver, "//li[contains(text(),'Please Select Export Focal Point')]")) {
					test.log(LogStatus.INFO, "Please Select Export Focal Point");
				}
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL,
					"Error Vaildation is not Displayed by clicking on SAVE & Return button in Submit Request :");
		}
	}

	// Error validation in Export Focal Point
	public void validate_ExportFocalPoint() {
		try {
			if (isDisplayed(driver, "//h4[contains(text(),'Error!')]")) {
				if (isDisplayed(driver, "//li[contains(text(),'Please select an Export Focal Point Decision')]")) {
					test.log(LogStatus.INFO, "Please select an Export Focal Point Decision :");
				}
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL,
					"Error Vaildation is not Displayed by clicking on SAVE & Return button in Export Focal Point :");
		}
	}

	// Click on Import into Authorization Application
	public void click_importIntoAuthorizationApp() {
		clickElement(driver, test, OCR_ExportRequest_ImportIntoAA, "Click on Import into Authorization Application");
	}

	// Select the Authorization Application
	public void select_AuthorizationType(String AuthorizationType) {
		selectByVisibleText(driver, test, OCR_ExportRequest_AuthorizationType, "Select the Authorization Type : ",
				AuthorizationType);
	}

	// Click on Use Export Request ID
	public void click_UseExportReqID() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_ExportRequest_UseExportReqID, "Click on Use Export Request ID");
	}

	// Click on Save import Info and Alert for create a new license Application
	public void click_SaveImportInfo() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_ExportRequest_SaveImportinfo, "Click on Save import Info");
		AlertPopUp(driver, test, "This will create a new License Application and link the Export Request "
				+ "for the ability to import information. Would you like to proceed?");
	}

	// Get the text of Transation ID
	public String get_TransationID() {
		Wait.waitfor(4);
		return getAttribute(driver, test, OCR_ExportRequest_TransationID, "value", "Actual Transation ID : ");
	}

	// Click on Import All and Accept the Alert
	public void click_ImportAll() {
		clickElement(driver, test, OCR_ExportRequest_ImportAll, "Click on Import All");
		AlertPopUp(driver, test, "Do you wish to import all?");
	}

	// Save & Finalize Desicion Button Enabled or Disabled
	public Boolean saveandFinalizedEnabled() {
		return isEnabled(driver, "//input[@name='saveTdfp']");
	}

	// Technical Focal Point is Enabled or Disabled
	public Boolean technicalFocalPoint() {
		return isEnabled(driver, "//a[@id='tdfpLink']");
	}
}