package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class DeclarationDetailsItemDetailsPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_Customs_DDItem_RequestedCPC = "//input[@id='declarationItemDetailsForm_cpc']";
	public static final String OCR_Customs_DDItem_PreviousCPC = "//input[@id='declarationItemDetailsForm_additionalProcedure']";
	public static final String OCR_Customs_DDItem_ProcedureCategory = "//textarea[@id='declarationItemDetailsForm_invoiceItemValue_exportRefundProcedure']";
	public static final String OCR_Customs_DDItem_RatingCLE = "//input[@id='declarationItemDetailsForm_invoiceItemValue_eccnMlEU']";
	public static final String OCR_Customs_DDItem_AddPackageBtn = "//button[@id='addPackageButton']";
	public static final String OCR_Customs_DDItem_AddPrevDocumentBtn = "(//button[contains(text(),'Add Document')])[1]";
	public static final String OCR_Customs_DDItem_AddDocumentBtn = "(//button[contains(text(),'Add Document')])[2]";
	public static final String OCR_Customs_DDItem_SaveBtn = "//button[@id='saveDecTabForm']";
	public static final String OCR_Customs_DDItem_PackingDetailslabel = "//label[contains(text(),'Packing Details')]";
	public static final String OCR_Customs_DDItem_PreviousDocumentlabel = "//label[contains(text(),'Previous Document')]";
	public static final String OCR_Customs_DDItem_Documentslabel = "//label[contains(text(),'Documents')]";
	public static final String OCR_Customs_DDItem_MiscDetailslabel = "//a[@class='miscdetails collapser']//label[contains(text(),'Misc Details')]";
	public static final String OCR_Customs_DDItem_PackageNo = "//input[@id='packageNo']";
	public static final String OCR_Customs_DDItem_NoofPackages = "//input[@id='noOfPackages']";
	public static final String OCR_Customs_DDItem_TypeOfPackage = "//select[@id='typeOfPck']";
	public static final String OCR_Customs_DDItem_MarksAndNos = "//input[@id='marksAndNos']";
	public static final String OCR_Customs_DDItem_Submit = "//a[@id='sData']";
	public static final String OCR_Customs_DDItem_PackageCloseBtn = "//span[@class='ui-icon ui-icon-closethick']";
	public static final String OCR_Customs_DDItem_DocumentType = "//input[@id='preDocumentCode']";
	public static final String OCR_Customs_DDItem_PreDocSaveBtn = "//input[@name='saveNewPreDocs']";
	public static final String OCR_Customs_DDItem_ClosePopUp = "//div[@id='custom-modal']//button[@class='close']";
	public static final String OCR_Customs_DDItem_DocumentCode = "//input[@id='othDocumentCode']";
	public static final String OCR_Customs_DDItem_DocumentReference = "//input[@id='othDocumentReference']";
	public static final String OCR_Customs_DDItem_DocumentDate = "//input[@id='dateOfDocument']";
	public static final String OCR_Customs_DDItem_ExpiryDate = "//input[@id='expiryDate']";
	public static final String OCR_Customs_DDItem_ValueOfExport = "//input[@id='valueOfExport']";
	public static final String OCR_Customs_DDItem_DocSave = "//input[@name='saveNewOthDocs']";
	public static final String OCR_Customs_DDItem_RegNoExternalSystem = "//input[@id='declarationItemDetailsForm_invoiceItemValue_externalSystemRegNumber']";
	public static final String OCR_Customs_DDItem_CommercialReference = "//input[@id='declarationItemDetailsForm_invoiceItemValue_commercialReference']";
	public static final String OCR_Customs_DDItem_InternalRemark = "//input[@id='declarationItemDetailsForm_invoiceItemValue_internalRemark']";

	/* ******************************* Constructor ****************************** */

	public DeclarationDetailsItemDetailsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	// Adding the Header Information
	public void addHeaderInformation(String RequestedCPC, String PreviousCPC, String ProcedureCategory,
			String RatingCLE) {
		typeText(driver, test, OCR_Customs_DDItem_RequestedCPC, "Enter the Requested CPC : ", RequestedCPC);
		typeText(driver, test, OCR_Customs_DDItem_PreviousCPC, "Enter the Previous CPC : ", PreviousCPC);
		typeText(driver, test, OCR_Customs_DDItem_ProcedureCategory, "Enter the Procedure Category : ",
				ProcedureCategory);
		typeText(driver, test, OCR_Customs_DDItem_RatingCLE, "Enter the RatingCLE : ", RatingCLE);
	}

	// Click on Add Packing button
	public void clickPackingButton() {
		clickElement(driver, test, OCR_Customs_DDItem_PackingDetailslabel, "Click on Packing Details label");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_Customs_DDItem_AddPackageBtn, "Click on Add Package button");
	}

	// Click on Add Previous Document button
	public void clickPreviousDocumentBtn() {
		clickElement(driver, test, OCR_Customs_DDItem_PreviousDocumentlabel, "Click on Previous Document label");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_Customs_DDItem_AddPrevDocumentBtn, "Click on Add Document button");
	}

	// Click on Add Document button
	public void clickDocumentBtn() {
		clickElement(driver, test, OCR_Customs_DDItem_Documentslabel, "Click on Document label");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_Customs_DDItem_AddDocumentBtn, "Click on Add Document button");
	}

	// click on Misc Details button
	public void clickMiscDetailsBtn() {
		clickElement(driver, test, OCR_Customs_DDItem_MiscDetailslabel, "Click on Document label");
	}

	// Add Packing details
	public void addPackingDetails(String PackageNo, String NoofPackages, String TypeOfPackage, String MarksAndNos) {
		try {
			typeText(driver, test, OCR_Customs_DDItem_PackageNo, "Enter the Package no : ", PackageNo);
			typeText(driver, test, OCR_Customs_DDItem_NoofPackages, "Enter the No of Packages : ", NoofPackages);
			selectByVisibleText(driver, test, OCR_Customs_DDItem_TypeOfPackage, "Enter the Type Of Package : ",
					TypeOfPackage);
			typeText(driver, test, OCR_Customs_DDItem_MarksAndNos, "Enter the Marks And Nos : ", MarksAndNos);
			clickElement(driver, test, OCR_Customs_DDItem_Submit, "Click on Submit");
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_Customs_DDItem_PackageCloseBtn, "Click on Close pop up");
		}
	}

	// Add Previous Document
	public void addPreviousDocument(String DocumentType) {
		try {
			typeText(driver, test, OCR_Customs_DDItem_DocumentType, "Enter the Document Type : ", DocumentType);
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_Customs_DDItem_ClosePopUp, "Click on Close pop up");
		}
	}

	// Add Document
	public void addDocument(String DocumentCode, String DocumentReference, String DocumentDate, String ExpiryDate,
			String ValueOfExport) {
		try {
			typeText(driver, test, OCR_Customs_DDItem_DocumentCode, "Enter the Document Code : ", DocumentCode);
			typeText(driver, test, OCR_Customs_DDItem_DocumentReference, "Enter the Document Reference : ",
					DocumentReference);
			clickElement(driver, test, OCR_Customs_DDItem_DocumentDate, "Click on DocumentDate");
			date(driver, test, "Select the Document Date : ", DocumentDate);
			clickElement(driver, test, OCR_Customs_DDItem_ExpiryDate, "Click on Expiry Date ");
			date(driver, test, "Select the Expiry Date : ", ExpiryDate);
			typeText(driver, test, OCR_Customs_DDItem_ValueOfExport, "Enter the Value Of Export : ", ValueOfExport);
			clickElement(driver, test, OCR_Customs_DDItem_DocSave, "Click on save");
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_Customs_DDItem_ClosePopUp, "Click on Close pop up");
		}
	}

	// Add Misc Details
	public void addMiscDetails(String RegNoExternalSystem, String CommercialReference, String InternalRemark) {
		typeText(driver, test, OCR_Customs_DDItem_RegNoExternalSystem, "Enter the Reg No External System : ",
				RegNoExternalSystem);
		typeText(driver, test, OCR_Customs_DDItem_CommercialReference, "Enter the Commercial Reference : ",
				CommercialReference);
		typeText(driver, test, OCR_Customs_DDItem_InternalRemark, "Enter the Internal Remark : ", InternalRemark);
	}

}
