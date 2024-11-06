package nrcLicensingClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class EditForm7DetailsPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_Form7D_DetailsCodeLink = "(//a[contains(text(),'Code')])[1]";
	public static final String OCR_Form7D_ExporterCode = "//input[@id='searchForm_exporter_expCode']";
	public static final String OCR_Form7D_Search = "//button[@name='Search']";
	public static final String OCR_Form7D_Save = "//button[contains(text(),'Save')]";
	public static final String OCR_Form7D_Select = "(//button[contains(text(),'Select')])[1]";
	public static final String OCR_Form7D_PopUpClose = "(//button[@class='close'])[1]";
	public static final String OCR_Form7D_BAttention = "//input[@id='editNrcForm7_nrcForm7Value_aplcntAttention']";
	public static final String OCR_Form7D_NameApplicantLink = "//a[contains(text(),'Name of Applicant')]";
	public static final String OCR_Form7D_UserFirstName = "//input[@id='searchForm_userProfile_userFirstname']";
	public static final String OCR_Form7D_ContractNumberLink = "//a[contains(text(),'Contract Number')]";
	public static final String OCR_Form7D_ContractNo = "//input[@id='searchForm_contract_contractNo']";
	public static final String OCR_Form7D_Phone = "//input[@id='editNrcForm7_nrcForm7Value_aplcntPhNo']";
	public static final String OCR_Form7D_Fax = "//input[@id='editNrcForm7_nrcForm7Value_aplcntFax']";
	public static final String OCR_Form7D_FirstShipmentDate = "//input[@id='editNrcForm7_firstShipDate']";
	public static final String OCR_Form7D_LastShipmentDate = "//input[@id='editNrcForm7_lastShipDate']";
	public static final String OCR_Form7D_ProposedExpirationDate = "//input[@id='editNrcForm7_expirationDate']";
	public static final String OCR_Form7D_PartCLabel = "//label[contains(text(),'PART C')]";
	public static final String OCR_Form7D_PartDLabel = "//label[contains(text(),'PART D')]";
	public static final String OCR_Form7D_PartELabel = "//label[contains(text(),'PART E')]";
	public static final String OCR_Form7D_NoPartiesExport = "//input[@id='editNrcForm7_chkSE']";
	public static final String OCR_Form7D_NoPartiesForeign = "//input[@id='editNrcForm7_chkIFC']";
	public static final String OCR_Form7D_ExportCodeLink = "//a[@id='seLink']";
	public static final String OCR_Form7D_ExportAttention = "//input[@id='editNrcForm7_expSupplier_consigneeAttention']";
	public static final String OCR_Form7D_FunctionsPerformed = "//textarea[@id='editNrcForm7_expSupplier_functionsPerformed']";
	public static final String OCR_Form7D_ForeignAttention = "//input[@id='editNrcForm7_interForeignConsignee_consigneeAttention']";
	public static final String OCR_Form7D_IntermediatePerformed = "//textarea[@id='editNrcForm7_interForeignConsignee_interFcUses']";
	public static final String OCR_Form7D_ForeignCodeLink = "//a[@id='ifcLink']";
	public static final String OCR_Form7D_UltimateCodeLink = "//a[@id='ufcLink']";
	public static final String OCR_Form7D_UltimateAttention = "//input[@id='editNrcForm7_ultForeignConsignee_consigneeAttention']";
	public static final String OCR_Form7D_UltimateEndUser = "//textarea[@id='editNrcForm7_ultForeignConsignee_ultFcEndUses']";
	public static final String OCR_Form7D_DescriptionRadioactive = "//textarea[@id='editNrcForm7_nrcForm7Value_radioactiveDesc']";
	public static final String OCR_Form7D_TotalActivity = "//textarea[@id='editNrcForm7_nrcForm7Value_maxTotalValue']";
	public static final String OCR_Form7D_Enrichmen = "//textarea[@id='editNrcForm7_nrcForm7Value_maxEnrichment']";
	public static final String OCR_Form7D_Isotope = "//textarea[@id='editNrcForm7_nrcForm7Value_maxIsotope']";
	public static final String OCR_Form7D_ForeignObligations = "//textarea[@id='editNrcForm7_nrcForm7Value_foreignObligations']";
	public static final String OCR_Form7D_ConsigneeCode = "//input[@id='searchForm_consignee_consigneeId']";
	public static final String OCR_Form7D_AddParty = "//button[@id='se']";
	public static final String OCR_Form7D_AddConsignee = "//button[@id='ifc']";
	public static final String OCR_Form7D_FormType = "//select[@id='editNrcForm7_formType']";
	public static final String OCR_Form7D_SelectAdd = "//select[@id='editNrcForm7_formType']";
	public static final String OCR_Form7D_Go = "//button[@id='goOnForms']";
	public static final String OCR_Form7D_AddNote = "//button[contains(text(),'Add Notes')]";
	public static final String OCR_Form7D_SecureNote = "//textarea[@id='editSecureNotes_dosSecureNotes_secureNotes']";
	public static final String OCR_Form7D_SaveAndReturn = "//button[contains(text(),'Save & Return')]";
	public static final String OCR_Form7D_Note_Group = "//input[@id='editSecureNotes_dosSecureNotes_categoryG']";
	public static final String OCR_Form7D_Note_Private = "//input[@id='editSecureNotes_dosSecureNotes_categoryR']";
	public static final String OCR_Form7D_UltimateAddConsignee = "//button[@id='ufc']";
	public static final String OCR_Form7D_Complete = "//input[@id='editNrcForm7_nrcForm7Value_sourceC']";

	public static final String OCR_Form7D_DocumentType = "//select[@id='docTypeId']";
	public static final String OCR_Form7D_UploadDocSaveBtn = "//button[@id='saveButton']";
	public static final String OCR_Form7D_AddDocumentIcon = "//i[@class='fa fa-upload']/../i";
	public static final String OCR_Form7D_AddDocCancleBtn = "//button[@name='cancel'][contains(text(),'Cancel')]";

	/* ******************** Constructor ***************************** */

	public EditForm7DetailsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	// Add the Name and Address of Applicant/License
	public void addApplicantPartB(String ApplicantExporterCode, String PartBAttention, String NameUserFirstName,
			String ContractNo, String Phone, String FAX, String FirstShipmentDate, String LastShipmentDate,
			String ProposedExpirationDate) {
		Wait.waitfor(3);
		if(ApplicantExporterCode.length() > 0) {
			clickElement(driver, test, OCR_Form7D_DetailsCodeLink,"Click on Name and Address of Applicant/Licensee code Link :");
			try {
				typeText(driver, test, OCR_Form7D_ExporterCode, "Enter the Exporter Code : ", ApplicantExporterCode);
				clickElement(driver, test, OCR_Form7D_Search, "Click on Search");
				clickElement(driver, test, "//td[contains(text(),'" + ApplicantExporterCode + "')]","Click on Exporter Code : " + ApplicantExporterCode);
				Wait.waitfor(3);
				clickElement(driver, test, OCR_Form7D_Select, "Click on Select :");
				} catch (Exception e) {
					testFailSshot(driver, test);
					clickElement(driver, test, OCR_Form7D_PopUpClose, "Click on POP Up close :");
					}
			}
		Wait.waitfor(3);
		typeText(driver, test, OCR_Form7D_BAttention, "Enter the Part-B Attention : ", PartBAttention);
		Wait.waitfor(3);
		if(NameUserFirstName.length() > 0) {
			clickElement(driver, test, OCR_Form7D_NameApplicantLink, "Click on Name Applicant Link :");
			try {
				typeText(driver, test, OCR_Form7D_UserFirstName, "Enter the User First Name : ", NameUserFirstName);
				clickElement(driver, test, OCR_Form7D_Search, "Click on Search");
				clickElement(driver, test, "//td[contains(text(),'" + NameUserFirstName + "')]","Click on Name User First Name : " + NameUserFirstName);
				Wait.waitfor(3);
				clickElement(driver, test, OCR_Form7D_Select, "Click on Select :");
				} catch (Exception e) {
					testFailSshot(driver, test);
					clickElement(driver, test, OCR_Form7D_PopUpClose, "Click on POP Up close :");
					}
		}
		scrollToElement(driver, OCR_Form7D_NameApplicantLink);
		Wait.waitfor(4);
		if(ContractNo.length() > 0) {
			clickElement(driver, test, OCR_Form7D_ContractNumberLink, "Click on Contract Number :");
			try {
				typeText(driver, test, OCR_Form7D_ContractNo, "Enter the Contract No : ", ContractNo);
				clickElement(driver, test, OCR_Form7D_Search, "Click on Search :");
				clickElement(driver, test, "//td[contains(text(),'" + ContractNo + "')]",
					"Click on Contract No : " + ContractNo);
				Wait.waitfor(3);
				clickElement(driver, test, OCR_Form7D_Select, "Click on Select :");
				} catch (Exception e) {
					testFailSshot(driver, test);
					clickElement(driver, test, "//button[@class='btn-close']", "Click on POP Up close :");
					}
		}
		Wait.waitfor(3);
		typeText(driver, test, OCR_Form7D_Phone, "Enter the Phone : ", Phone);
		typeText(driver, test, OCR_Form7D_Fax, "Enter the FAX : ", FAX);
		clickElement(driver, test, OCR_Form7D_FirstShipmentDate, "Click on First Shipment Date :");
		date(driver, test, "Select the date : ", FirstShipmentDate);
		Wait.waitfor(3);
		clickElement(driver, test, OCR_Form7D_LastShipmentDate, "Click on Last Shipment Date :");
		date(driver, test, "Select the date : ", LastShipmentDate);
		Wait.waitfor(3);
		clickElement(driver, test, OCR_Form7D_ProposedExpirationDate, "Click on Proposed Expiration Date :");
		date(driver, test, "select the date : ", ProposedExpirationDate);
		Wait.waitfor(3);
	}

	// Adding Part C supplier
	public void addPartCSuppliers(String ExportConsigneeCode, String ExportAttention, String FunctionsPerformed) {
		Wait.waitfor(3);
		scrollToElement(driver, OCR_Form7D_Phone);
		scrollToBottom(driver);
		Wait.waitfor(3);
		// clickElement(driver, test, OCR_Form7D_PartDLabel, "Clicking on Part D Label
		// :");
		clickElement(driver, test, OCR_Form7D_PartCLabel, "Click on Part C label :");
		Wait.waitfor(3);
		scrollToBottom(driver);
		clickElement(driver, test, OCR_Form7D_ExportCodeLink, "click on Export Code link :");

		try {
			typeText(driver, test, OCR_Form7D_ConsigneeCode, "Enter the Consignee Code : ", ExportConsigneeCode);
			clickElement(driver, test, OCR_Form7D_Search, "Click on Search :");
			clickElement(driver, test, "//td[contains(text(),'" + ExportConsigneeCode + "')]",
					"Click on Export Consignee Code : " + ExportConsigneeCode);
			Wait.waitfor(3);
			clickElement(driver, test, OCR_Form7D_Select, "Click on Select :");
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_Form7D_PopUpClose, "Click on POP Up close :");
		}
		Wait.waitfor(3);
		typeText(driver, test, OCR_Form7D_ExportAttention, "Enter the Export Attention : ", ExportAttention);
		typeText(driver, test, OCR_Form7D_FunctionsPerformed, "Enter the Functions Performed : ", FunctionsPerformed);
	}

	// Adding Part C Intermediate Foreign Consignee
	public void addPartCIntermediate(String IForeignConsigneeCode, String ForeignAttention,
			String IntermediatePerformed) {

		scrollToElement(driver, OCR_Form7D_Phone);

		clickElement(driver, test, OCR_Form7D_ForeignCodeLink, "Click on Intermediate Foreign Consignee code link :");
		try {
			Wait.waitfor(3);
			typeText(driver, test, OCR_Form7D_ConsigneeCode, "Enter the Consignee Code : ", IForeignConsigneeCode);
			clickElement(driver, test, OCR_Form7D_Search, "Click on Search");
			clickElement(driver, test, "//td[contains(text(),'" + IForeignConsigneeCode + "')]",
					"Click on Consignee Code : " + IForeignConsigneeCode);
			Wait.waitfor(3);
			clickElement(driver, test, OCR_Form7D_Select, "Click on Select :");
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_Form7D_PopUpClose, "Click on POP Up close :");
		}
		Wait.waitfor(3);
		typeText(driver, test, OCR_Form7D_ForeignAttention, "Enter the Foreign Attention : ", ForeignAttention);
		typeText(driver, test, OCR_Form7D_IntermediatePerformed, "Enter the Functions Performed : ",
				IntermediatePerformed);
	}

	// Adding Part C Ultimate Foreign Consignee
	public void addPartCUltimate(String UltimateConsigneeCode, String UltimateAttention, String UltimateEndUser,
			String DescriptionRadioactive, String TotalActivity, String Enrichmen, String Isotope,
			String ForeignObligations) {
		Wait.waitfor(3);
		scrollToElement(driver, OCR_Form7D_IntermediatePerformed);
		Wait.waitfor(3);
		if(UltimateConsigneeCode.length() > 0) {
			clickElement(driver, test, OCR_Form7D_UltimateCodeLink, "Click on Ultimate Foreign Consignee code link :");
			try {
				typeText(driver, test, OCR_Form7D_ConsigneeCode, "Enter the Consignee Code : ", UltimateConsigneeCode);
				clickElement(driver, test, OCR_Form7D_Search, "Click on Search :");
				clickElement(driver, test, "//td[contains(text(),'" + UltimateConsigneeCode + "')]",
					"Click on Consignee Code : " + UltimateConsigneeCode);
				Wait.waitfor(3);
				clickElement(driver, test, OCR_Form7D_Select, "Click on Select :");
				} catch (Exception e) {
					testFailSshot(driver, test);
					clickElement(driver, test, OCR_Form7D_PopUpClose, "Click on POP Up close :");
				}
			}
		Wait.waitfor(3);
		typeText(driver, test, OCR_Form7D_UltimateAttention, "Enter the Ultimate Attention : ", UltimateAttention);
		typeText(driver, test, OCR_Form7D_UltimateEndUser, "Enter the Functions Performed : ", UltimateEndUser);
		typeText(driver, test, OCR_Form7D_DescriptionRadioactive, "Enter the Description Radioactive : ",
				DescriptionRadioactive);
		Wait.waitfor(3);
		typeText(driver, test, OCR_Form7D_TotalActivity, "Enter the Total Activity : ", TotalActivity);
		typeText(driver, test, OCR_Form7D_Enrichmen, "Enter the Enrichmen : ", Enrichmen);
		typeText(driver, test, OCR_Form7D_Isotope, "Enter the Isotope : ", Isotope);
		typeText(driver, test, OCR_Form7D_ForeignObligations, "Enter the Foreign Obligations : ", ForeignObligations);
	}

	// Add the Part E details
	public void partEDetails(String AdditionalInformation, String Recipients, String AInformation, String NameTitle,
			String AuthDate) {
		Wait.waitfor(3);
		scrollToBottom(driver);
		Wait.waitfor(3);
		scrollToElement(driver, OCR_Form7D_PartELabel);
		clickElement(driver, test, OCR_Form7D_PartELabel, "Click on Part E Label :");
		if (AdditionalInformation.equalsIgnoreCase("yes")) {
			clickElement(driver, test, "//input[@id='editNrcForm7_additionalInfoYes']", "Click on yes check box :");
			typeText(driver, test, "//textarea[@id='editNrcForm7_nrcForm7Value_additionalInformation']",
					"Enter the Additional Information : ", AInformation);
		} else {
			clickElement(driver, test, "//input[@id='editNrcForm7_additionalInfoNo']", "Click on No Check box :");
		}
		if (Recipients.equalsIgnoreCase("yes")) {
			clickElement(driver, test, "//input[@id='editNrcForm7_copiesOfRecipientsYes']", "Click on yes check box :");
		} else {
			clickElement(driver, test, "//input[@id='editNrcForm7_copiesOfRecipientsNo']", "Click on No Check box :");
		}

		clickElement(driver, test, "//input[@id='editNrcForm7_certification']", "click on certification check Box :");

		typeText(driver, test, "//textarea[@id='editNrcForm7_nrcForm7Value_authNameTitle']", "Enter the Name Title : ",
				NameTitle);
		scrollToBottom(driver);
		Wait.waitfor(3);
		clickElement(driver, test, "//input[@id='editNrcForm7_authDate']", "Click on Auth. Date");
		date(driver, test, "Select the Auth. Date : ", AuthDate);
	}

	// Click on Save
	public void clickSave() {
		scrollToElement(driver, OCR_Form7D_Save);
		Wait.waitfor(2);
		scrollToTop(driver);
		Wait.waitfor(2);
		clickElement(driver, test, OCR_Form7D_Save, "click on Save");
		Wait.waitfor(2);
	}

	// click on Complete
	public void clickComplete() {
		scrollToTop(driver);
		clickElement(driver, test, OCR_Form7D_Complete, "Click on Complete");
	}

	// click on Back to General Form
	public void clickBackGF() {
		clickElement(driver, test, "//button[contains(text(),'Back To General Info')]",
				"Click on Back to General Info");
	}

	// Click on Add party
	public void clickAddParty() {
		scrollToBottom(driver);
		Wait.waitfor(3);
		scrollToElement(driver, OCR_Form7D_PartCLabel);
		Wait.waitfor(4);
		clickElement(driver, test, OCR_Form7D_PartCLabel, "click on Part c label");
		Wait.waitfor(3);
		scrollToElement(driver, OCR_Form7D_PartCLabel);
		Wait.waitfor(4);
		clickElement(driver, test, OCR_Form7D_AddParty, "Click on Add Party");
	}

	// Click on Intermediate Add Consignee
	public void clickInterAddConsignee() {
		scrollToBottom(driver);
		Wait.waitfor(3);
		scrollToElement(driver, OCR_Form7D_PartCLabel);
		scrollToBottom(driver);
		Wait.waitfor(4);
		clickElement(driver, test, OCR_Form7D_PartCLabel, "click on Part c label");
		Wait.waitfor(3);
		scrollToElement(driver, OCR_Form7D_PartCLabel);
		Wait.waitfor(4);
		clickElement(driver, test, OCR_Form7D_AddConsignee, "Click on Intermediate Add Consignee");
	}

	// click on Ultimate Add Consignee
	public void clickUltimateAddConsignee() {
		scrollToBottom(driver);
		Wait.waitfor(3);
		scrollToElement(driver, OCR_Form7D_PartCLabel);
		scrollToBottom(driver);
		Wait.waitfor(4);
		clickElement(driver, test, OCR_Form7D_PartCLabel, "click on Part c label");
		Wait.waitfor(3);
		scrollToElement(driver, OCR_Form7D_UltimateAddConsignee);
		Wait.waitfor(4);
		scrollToBottom(driver);
		Wait.waitfor(3);
		clickElement(driver, test, OCR_Form7D_UltimateAddConsignee, "Add Ultimate Add Consignee");
	}

	// Select the note and Add Document
	public void addNote(String SecureNote) {
		scrollToTop(driver);
		clickElement(driver, test, OCR_Form7D_Go, "Click on GO");
		clickElement(driver, test, OCR_Form7D_AddNote, "Click on ADD Note");
		typeText(driver, test, OCR_Form7D_SecureNote, "Enter the Secure Note : ", SecureNote);
		clickElement(driver, test, OCR_Form7D_SaveAndReturn, "Click on SAve and Return");
		Wait.waitfor(3);
	}

	// click on Back to Form 7 Details
	public void clickBackToForm() {
		Wait.waitfor(3);
		clickElement(driver, test, "//button[contains(text(),'Form 7 Details')]", "Click on Back to form 7");
	}

	// Select the ADD Attachments
	public void addAttachments(String Attachments, String DocumentType, String UploadfileName) {
		scrollToTop(driver);
		Wait.waitfor(3);
		clickElement(driver, test, OCR_Form7D_SelectAdd, "Click on Select Options");
		selectByVisibleText(driver, test, OCR_Form7D_SelectAdd, "Select the Attachments : ", Attachments);
		clickElement(driver, test, OCR_Form7D_Go, "Click on GO");
		try {
			if (UploadfileName.length() > 0) {
				selectByVisibleText(driver, test, OCR_Form7D_DocumentType, "Select the Document Type : ", DocumentType);
				Wait.waitfor(4);
				mouseOverAndClick(driver, test, OCR_Form7D_AddDocumentIcon, "Click on upload File Icon");
				uploadFile(driver, test, UploadfileName, "Document is Added : " + UploadfileName);
				Wait.waitfor(4);
			}
			clickElement(driver, test, OCR_Form7D_UploadDocSaveBtn, "Click on Save");
			Wait.waitfor(3);
			if (UploadfileName.length() > 0) {
				clickElement(driver, test, OCR_Form7D_AddDocCancleBtn, "Click on Cancle ");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_Form7D_AddDocCancleBtn, "Click on Cancle ");
		}
		Wait.waitfor(3);

	}

	// Validating the Add Note
	public void validateAddNote() {
		try {
			if (isDisplayed(driver, "//h4[contains(text(),'Error!')]")) {
				if (isDisplayed(driver, "//li[contains(text(),'Secure notes is a required field')]")) {
					test.log(LogStatus.INFO, "Secure notes is a required field");
				}
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL,
					"Error Vaildation is not Displayed by clicking on SAVE button in ADD Secure Notes");
		}
	}

	// Validating the Add Attachments
	public void validateAddAttachment() {
		try {
			if (isDisplayed(driver, "(//h4[contains(text(),'Error!')])[2]")) {
				if (isDisplayed(driver, "//li[contains(text(),'Document Type is required.')]")) {
					test.log(LogStatus.INFO, "Document Type is required.");
				}
				if (isDisplayed(driver, "//li[contains(text(),'Document Name is required.')]")) {
					test.log(LogStatus.INFO, "Document Name is required.");
				}
				clickElement(driver, test, OCR_Form7D_AddDocCancleBtn, "Click on Cancle ");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL,
					"Error Vaildation is not Displayed by clicking on SAVE button in ADD Secure Notes");
			clickElement(driver, test, OCR_Form7D_AddDocCancleBtn, "Click on Cancle ");
		}
	}

	// validations in Form 7 Details
	public void validateForm7DetailsError() {
		try {
			Wait.waitfor(4);
			if (isDisplayed(driver, "//h4[contains(text(),'Error!')]")) {
				if (isDisplayed(driver, "(//li[contains(text(),'Name')])[1]")) {
					test.log(LogStatus.INFO,
							"Please complete '1. Name'. If this block does not require a response, you must enter 'N/A' or 'NONE' in this block and save to continue.");
				}
				if (isDisplayed(driver, "(//li[contains(text(),'Attention')])[1]")) {
					test.log(LogStatus.INFO,
							"Please complete '1. Attention'. If this block does not require a response, you must enter 'N/A' or 'NONE' in this block and save to continue.");
				}
				if (isDisplayed(driver, "(//li[contains(text(),'Address 1')])[1]")) {
					test.log(LogStatus.INFO,
							"Please complete '1. Address 1'. If this block does not require a response, you must enter 'N/A' or 'NONE' in this block and save to continue.");
				}
				if (isDisplayed(driver, "(//li[contains(text(),'Address 2')])[1]")) {
					test.log(LogStatus.INFO,
							"Please complete '1. Address 2'. If this block does not require a response, you must enter 'N/A' or 'NONE' in this block and save to continue.");
				}
				if (isDisplayed(driver, "(//li[contains(text(),'City')])[1]")) {
					test.log(LogStatus.INFO,
							"Please complete '1. City'. If this block does not require a response, you must enter 'N/A' or 'NONE' in this block and save to continue.");
				}
				if (isDisplayed(driver, "(//li[contains(text(),'State')])[1]")) {
					test.log(LogStatus.INFO,
							"Please complete '1. State'. If this block does not require a response, you must enter 'N/A' or 'NONE' in this block and save to continue.");
				}
				if (isDisplayed(driver, "(//li[contains(text(),'Zip')])[1]")) {
					test.log(LogStatus.INFO,
							"Please complete '1. Zip'. If this block does not require a response, you must enter 'N/A' or 'NONE' in this block and save to continue.");
				}
				if (isDisplayed(driver, "//li[contains(text(),'Name of Applicant')]")) {
					test.log(LogStatus.INFO,
							"Please complete '1a. Name of Applicant's Contact'. If this block does not require a response, you must enter 'N/A' or 'NONE' in this block and save to continue.");
				}
				if (isDisplayed(driver, "//li[contains(text(),'Phone')]")) {
					test.log(LogStatus.INFO,
							"Please complete '1c. Phone'. If this block does not require a response, you must enter 'N/A' or 'NONE' in this block and save to continue.");
				}
				if (isDisplayed(driver, "//li[contains(text(),'Fax')]")) {
					test.log(LogStatus.INFO,
							"Please complete '1d. Fax'. If this block does not require a response, you must enter 'N/A' or 'NONE' in this block and save to continue.");
				}
				if (isDisplayed(driver, "//li[contains(text(),'Email Address')]")) {
					test.log(LogStatus.INFO,
							"Please complete '1e. Email Address'. If this block does not require a response, you must enter 'N/A' or 'NONE' in this block and save to continue.");
				}
				if (isDisplayed(driver, "//li[contains(text(),'Contract Number')]")) {
					test.log(LogStatus.INFO,
							"Please complete '3. Contract Number(s)'. If this block does not require a response, you must enter 'N/A' or 'NONE' in this block and save to continue.");
				}
				if (isDisplayed(driver, "//li[contains(text(),'First Shipment Date')]")) {
					test.log(LogStatus.INFO, "Please complete '4. First Shipment Date'.");
				}
				if (isDisplayed(driver, "//li[contains(text(),'Last Shipment Date')]")) {
					test.log(LogStatus.INFO, "Please complete '5. Last Shipment Date'.");
				}
				if (isDisplayed(driver, "//li[contains(text(),'Proposed Expiration Date')]")) {
					test.log(LogStatus.INFO, "Please complete '6. Proposed Expiration Date'.");
				}
				if (isDisplayed(driver, "//li[contains(text(),'7. Name')]")) {
					test.log(LogStatus.INFO,
							"Please complete '7. Name'. If this block does not require a response, you must enter 'N/A' or 'NONE' in this block and save to continue.");
				}
				if (isDisplayed(driver, "//li[contains(text(),'7. Attention')]")) {
					test.log(LogStatus.INFO,
							"Please complete '7. Attention'. If this block does not require a response, you must enter 'N/A' or 'NONE' in this block and save to continue.");
				}
				if (isDisplayed(driver, "//li[contains(text(),'7. Address 1')]")) {
					test.log(LogStatus.INFO,
							"Please complete '7. Address 1'. If this block does not require a response, you must enter 'N/A' or 'NONE' in this block and save to continue.");
				}
				if (isDisplayed(driver, "//li[contains(text(),'7. Address 2')]")) {
					test.log(LogStatus.INFO,
							"Please complete '7. Address 2'. If this block does not require a response, you must enter 'N/A' or 'NONE' in this block and save to continue.");
				}
				if (isDisplayed(driver, "//li[contains(text(),'7. City')]")) {
					test.log(LogStatus.INFO,
							"Please complete '7. City'. If this block does not require a response, you must enter 'N/A' or 'NONE' in this block and save to continue.");
				}
				if (isDisplayed(driver, "//li[contains(text(),'7. State')]")) {
					test.log(LogStatus.INFO,
							"Please complete '7. State'. If this block does not require a response, you must enter 'N/A' or 'NONE' in this block and save to continue.");
				}
				if (isDisplayed(driver, "//li[contains(text(),'7. Zip')]")) {
					test.log(LogStatus.INFO,
							"Please complete '7. Zip'. If this block does not require a response, you must enter 'N/A' or 'NONE' in this block and save to continue.");
				}
				if (isDisplayed(driver, "//li[contains(text(),'Function')]")) {
					test.log(LogStatus.INFO,
							"Please complete '7a. Function(s) Performed'. If this block does not require a response, you must enter 'N/A' or 'NONE' in this block and save to continue.");
				}
				if (isDisplayed(driver, "//li[contains(text(),'8. Name')]")) {
					test.log(LogStatus.INFO,
							"Please complete '8. Name'. If this block does not require a response, you must enter 'N/A' or 'NONE' in this block and save to continue.");
				}
				if (isDisplayed(driver, "//li[contains(text(),'8. Attention')]")) {
					test.log(LogStatus.INFO,
							"Please complete '8. Attention'. If this block does not require a response, you must enter 'N/A' or 'NONE' in this block and save to continue.");
				}
				if (isDisplayed(driver, "//li[contains(text(),'8. Address 1')]")) {
					test.log(LogStatus.INFO,
							"Please complete '8. Address 1'. If this block does not require a response, you must enter 'N/A' or 'NONE' in this block and save to continue.");
				}
				if (isDisplayed(driver, "//li[contains(text(),'8. Address 2')]")) {
					test.log(LogStatus.INFO,
							"Please complete '8. Address 2'. If this block does not require a response, you must enter 'N/A' or 'NONE' in this block and save to continue.");
				}
				if (isDisplayed(driver, "//li[contains(text(),'8. City')]")) {
					test.log(LogStatus.INFO,
							"Please complete '8. City'. If this block does not require a response, you must enter 'N/A' or 'NONE' in this block and save to continue.");
				}
				if (isDisplayed(driver, "//li[contains(text(),'8. State')]")) {
					test.log(LogStatus.INFO,
							"Please complete '8. State'. If this block does not require a response, you must enter 'N/A' or 'NONE' in this block and save to continue.");
				}
				if (isDisplayed(driver, "//li[contains(text(),'8. Zip')]")) {
					test.log(LogStatus.INFO,
							"Please complete '8. Zip'. If this block does not require a response, you must enter 'N/A' or 'NONE' in this block and save to continue.");
				}
				if (isDisplayed(driver, "//li[contains(text(),'8a. Function')]")) {
					test.log(LogStatus.INFO,
							"Please complete '8a. Function(s) Performed'. If this block does not require a response, you must enter 'N/A' or 'NONE' in this block and save to continue.");
				}
				if (isDisplayed(driver, "//li[contains(text(),'9. Name')]")) {
					test.log(LogStatus.INFO,
							"Please complete '9. Name'. If this block does not require a response, you must enter 'N/A' or 'NONE' in this block and save to continue.");
				}
				if (isDisplayed(driver, "//li[contains(text(),'9. Attention')]")) {
					test.log(LogStatus.INFO,
							"Please complete '9. Attention'. If this block does not require a response, you must enter 'N/A' or 'NONE' in this block and save to continue.");
				}
				if (isDisplayed(driver, "//li[contains(text(),'9. Address 1')]")) {
					test.log(LogStatus.INFO,
							"Please complete '9. Address 1'. If this block does not require a response, you must enter 'N/A' or 'NONE' in this block and save to continue.");
				}
				if (isDisplayed(driver, "//li[contains(text(),'9. Address 2')]")) {
					test.log(LogStatus.INFO,
							"Please complete '9. Address 2'. If this block does not require a response, you must enter 'N/A' or 'NONE' in this block and save to continue.");
				}
				if (isDisplayed(driver, "//li[contains(text(),'9. City')]")) {
					test.log(LogStatus.INFO,
							"Please complete '9. City'. If this block does not require a response, you must enter 'N/A' or 'NONE' in this block and save to continue.");
				}
				if (isDisplayed(driver, "//li[contains(text(),'9. State')]")) {
					test.log(LogStatus.INFO,
							"Please complete '9. State'. If this block does not require a response, you must enter 'N/A' or 'NONE' in this block and save to continue.");
				}
				if (isDisplayed(driver, "//li[contains(text(),'9. Zip')]")) {
					test.log(LogStatus.INFO,
							"Please complete '9. Zip'. If this block does not require a response, you must enter 'N/A' or 'NONE' in this block and save to continue.");
				}
				if (isDisplayed(driver, "//li[contains(text(),'9a. Ultimate End Use')]")) {
					test.log(LogStatus.INFO,
							"Please complete '9a. Ultimate End Use(s)'. If this block does not require a response, you must enter 'N/A' or 'NONE' in this block and save to continue.");
				}
				if (isDisplayed(driver, "//li[contains(text(),'Description of Radioactive')]")) {
					test.log(LogStatus.INFO,
							"Please complete '10. Description of Radioactive Materials...'. If this block does not require a response, you must enter 'N/A' or 'NONE' in this block and save to continue.");
				}
				if (isDisplayed(driver, "//li[contains(text(),'10a. Max Total Volume')]")) {
					test.log(LogStatus.INFO,
							"Please complete '10a. Max Total Volume'. If this block does not require a response, you must enter 'N/A' or 'NONE' in this block and save to continue.");
				}
				if (isDisplayed(driver, "//li[contains(text(),'10b. Max Enrichment of Wgt %')]")) {
					test.log(LogStatus.INFO,
							"Please complete '10b. Max Enrichment of Wgt %'. If this block does not require a response, you must enter 'N/A' or 'NONE' in this block and save to continue.");
				}
				if (isDisplayed(driver, "//li[contains(text(),'10c. Max Isotope Wgt(KG)')]")) {
					test.log(LogStatus.INFO,
							"Please complete '10c. Max Isotope Wgt(KG)'. If this block does not require a response, you must enter 'N/A' or 'NONE' in this block and save to continue.");
				}
				if (isDisplayed(driver, "//li[contains(text(),'11. Foreign Obligations')]")) {
					test.log(LogStatus.INFO,
							"Please complete '11. Foreign Obligations'. If this block does not require a response, you must enter 'N/A' or 'NONE' in this block and save to continue.");
				}
				if (isDisplayed(driver, "//li[contains(text(),'17. Additional Information Provid')]")) {
					test.log(LogStatus.INFO, "Please complete '17. Additional Information Provided '.");
				}
				if (isDisplayed(driver, "//li[contains(text(),'17a. Copies Of Recipients')]")) {
					test.log(LogStatus.INFO, "Please complete '17a. Copies Of Recipients' Authorizations Provided'.");
				}
				if (isDisplayed(driver, "//li[contains(text(),'18. Certification')]")) {
					test.log(LogStatus.INFO, "Please complete '18. Certification'.");
				}
				if (isDisplayed(driver, "//li[contains(text(),'18a. Print Name and Title of Auth')]")) {
					test.log(LogStatus.INFO,
							"Please complete '18a. Print Name and Title of Authorized Official'. If this block does not require a response, you must enter 'N/A' or 'NONE' in this block and save to continue.");
				}
				if (isDisplayed(driver, "//li[contains(text(),'18c. Date')]")) {
					test.log(LogStatus.INFO, "Please complete '18c. Date'.");
				}
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL,
					"Error Vaildation is not Displayed by clicking on SAVE  button in Form7 Details Page");
		}
	}

}
