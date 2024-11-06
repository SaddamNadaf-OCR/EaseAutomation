package globalExportClasses;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class SalesCreateNewOrderItemPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	
	public static final String OCR_SalesCreateNewOrderItemPage_PartNoLink = "//a[@id='partno-popup']";
	public static final String OCR_SalesCreateNewOrderItemPage_PartNo = "//input[@id='searchForm_product_productCode']";
	public static final String OCR_SalesCreateNewOrderItemPage_ProdDesc = "//textarea[@id='editInvoiceItem_invoiceItem_description']";
	public static final String OCR_SalesCreateNewOrderItemPage_COO = "//input[@id='cooName']";
	public static final String OCR_SalesCreateNewOrderItemPage_QtyPricingLabel = "//font[contains(text(),'Quantity & Pricing Information')]";
	public static final String OCR_SalesCreateNewOrderItemPage_CustomInvQty = "//input[@id='primaryNetQuantity']";
	public static final String OCR_SalesCreateNewOrderItemPage_UOM = "//input[@id='editInvoiceItem_invoiceItem_invoiceUnitOfQuantity']";
	public static final String OCR_SalesCreateNewOrderItemPage_ItemUnitPrice = "//input[@id='editInvoiceItem_invoiceItem_prodUnitPrice']";
	public static final String OCR_SalesCreateNewOrderItemPage_ClassificationInfoLabel = "//font[contains(text(),'Classification Information')]";
	public static final String OCR_SalesCreateNewOrderItemPage_ExportClassification = "//input[@id='editInvoiceItem_invoiceItem_exportClassEccnUsml']";
	public static final String OCR_SalesCreateNewOrderItemPage_HTS = "//input[@id='editInvoiceItem_invoiceItem_htsScheduleBNo']";
	public static final String OCR_SalesCreateNewOrderItemPage_PrimaryUOM = "//input[@id='editInvoiceItem_invoiceItem_primaryUnit']";
	public static final String OCR_SalesCreateNewOrderItemPage_USExportClass = "//input[@id='editInvoiceItem_invoiceItem_usExportClass']";
	public static final String OCR_SalesCreateNewOrderItemPage_ClassificationInfoSaveBtn = "//button[@id='saveFromClassBlock']";
	public static final String OCR_SalesCreateNewOrderItemPage_ExportAuthInfoLabel = "//font[contains(text(),'Export Authorisation Information')]";
	public static final String OCR_SalesCreateNewOrderItemPage_AuthorisationNo = "//input[@id='editInvoiceItem_invoiceItem_licenseNo']";
	public static final String OCR_SalesCreateNewOrderItemPage_AuthItemNo = "//input[@id='editInvoiceItem_invoiceItem_licenseItemNo']";
	public static final String OCR_SalesCreateNewOrderItemPage_AuthType = "//textarea[@id='editInvoiceItem_invoiceItem_licenseType']";
	public static final String OCR_SalesCreateNewOrderItemPage_AuthTxnType = "//input[@id='editInvoiceItem_invoiceItem_licenseTxnType']";
	public static final String OCR_SalesCreateNewOrderItemPage_AuthExpiryDate = "//input[@id='editInvoiceItem_licenseDate']";
	public static final String OCR_SalesCreateNewOrderItemPage_AdditionalAuthLabel = "//font[contains(text(),'Additional Authorisation')]";
	public static final String OCR_SalesCreateNewOrderItemPage_AddAdditionalAuthBtn = "//button[@id='addAuthorisation']";
	public static final String OCR_SalesCreateNewOrderItemPage_AdditionalAuthNo = "//input[@id='invoiceItem.licenseNo']";
	public static final String OCR_SalesCreateNewOrderItemPage_AdditionalAuthItemNo = "//input[@id='invoiceItem.licenseItemNo']";
	public static final String OCR_SalesCreateNewOrderItemPage_PopUpSaveBtn = "//button[@name='Save']";
	public static final String OCR_SalesCreateNewOrderItemPage_PackingInfoLabel = "//font[contains(text(),'Packing Information')]";
	public static final String OCR_SalesCreateNewOrderItemPage_HUNoContainerIDLink = "//a[@id='getHuNoBasePopUp']";
	public static final String OCR_SalesCreateNewOrderItemPage_InvCartonRadioBtn = "//input[@id='searchForm_cartonTypeinvoiceCarton']";
	public static final String OCR_SalesCreateNewOrderItemPage_SelectBtn = "(//button[@name='Ok'])[1]";
	public static final String OCR_SalesCreateNewOrderItemPage_ContainerIDClosePopUp = "(//button[@class='btn-close'])[1]";
	public static final String OCR_SalesCreateNewOrderItemPage_BatchInfoLabel = "//font[contains(text(),'Batch Information')]";
	public static final String OCR_SalesCreateNewOrderItemPage_AddbatchInfoBtn = "//button[@id='addBatch']";
	public static final String OCR_SalesCreateNewOrderItemPage_BatchNo = "//input[@id='editBatchHeader_batchDetailValue_batchNo']";
	public static final String OCR_SalesCreateNewOrderItemPage_BatchCOO = "//input[@id='editBatchHeader_']";
	public static final String OCR_SalesCreateNewOrderItemPage_BatchSaveBtn = "//button[@id='save']";
	public static final String OCR_SalesCreateNewOrderItemPage_SaveBtn = "//button[@id='saveSubmitBtn']";
	public static final String OCR_SalesCreateNewOrderItemPage_AdditionalTransactionDetails = "//i[@class='fa fa-th']";
	public static final String OCR_SalesCreateNewOrderItemPage_HazmatDetails = "//a[contains(text(),'Hazmat Details')]";

	/* ******************************* Constructor ****************************** */

	public SalesCreateNewOrderItemPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	// General information section
	public void generalInformation(String ProductDesc, String COO) {
		typeText(driver, test, OCR_SalesCreateNewOrderItemPage_ProdDesc, "Enter Product description : ", ProductDesc);
		typeText(driver, test, OCR_SalesCreateNewOrderItemPage_COO, "Enter Country of Origin : ", COO);
	}
	
	// General information section US
		public void generalInformationUS(String PartNo) {
			clickElement(driver, test, OCR_SalesCreateNewOrderItemPage_PartNoLink, "Click on Part No link");
			try {
				typeText(driver, test, OCR_SalesCreateNewOrderItemPage_PartNo, "Enter the Part No : ", PartNo);
				Wait.waitfor(3);
				clickElement(driver, test, "//div[@id='searchDIV']//button[2]", "Click on Search button");
				clickElement(driver, test, "//td[contains(text(),'" + PartNo + "')]", "Select the PartNo : " + PartNo);
				clickElement(driver, test, OCR_SalesCreateNewOrderItemPage_SelectBtn, "Click on Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_SalesCreateNewOrderItemPage_ContainerIDClosePopUp, "Click on Cancel popup icon");
			}
		
		}
	

	// Quantity and pricing information
	public void qytPricingInfo(String CustInvQty, String UOM, String UnitPrice) {
		scrollToElement(driver, OCR_SalesCreateNewOrderItemPage_QtyPricingLabel);
		clickElement(driver, test, OCR_SalesCreateNewOrderItemPage_QtyPricingLabel,
				" Click on Quantity & Pricing Information");
		typeText(driver, test, OCR_SalesCreateNewOrderItemPage_CustomInvQty, "Enter Custom invoice Quantity : ",
				CustInvQty);
		typeText(driver, test, OCR_SalesCreateNewOrderItemPage_UOM, "Enter Unit Of Measure : ", UOM);
		typeText(driver, test, OCR_SalesCreateNewOrderItemPage_ItemUnitPrice, "Enter Item Unit Price : ", UnitPrice);

	}

	// classification information
	public void classificationInfo(String ExportClassification, String HTS, String PrimaryUOM, String USExport) {

		clickElement(driver, test, OCR_SalesCreateNewOrderItemPage_ClassificationInfoLabel,
				"Click on Classification Information Label");
		typeText(driver, test, OCR_SalesCreateNewOrderItemPage_ExportClassification, "Enter Export Classification : ",
				ExportClassification);
		typeText(driver, test, OCR_SalesCreateNewOrderItemPage_HTS, "Enter HTS : ", HTS);
		typeText(driver, test, OCR_SalesCreateNewOrderItemPage_PrimaryUOM, "Enter Primary UOM : ", PrimaryUOM);
		typeText(driver, test, OCR_SalesCreateNewOrderItemPage_USExportClass, "Enter US Export Classification : ",
				USExport);
	}

	// classification information US
	public void classificationInfoUS(String ControllingAgency, String ExportClassification, String HTS,
			String PrimaryUOM) {
		Wait.waitfor(3);
		scrollToElement(driver, OCR_SalesCreateNewOrderItemPage_ClassificationInfoLabel);
		clickElement(driver, test, OCR_SalesCreateNewOrderItemPage_ClassificationInfoLabel,
				"Click on Classification Information Label");
		clickElement(driver, test, "//a[@id='controllingAgency-Popup']", "Click on Controlling Agency Link ");
		clickElement(driver, test, "//td[contains(text(),'" + ControllingAgency + "')]",
				"Select the Controlling Agency : " + ControllingAgency);
		clickElement(driver, test, OCR_SalesCreateNewOrderItemPage_SelectBtn, "Click on Select button");
		scrollToElement(driver, OCR_SalesCreateNewOrderItemPage_ClassificationInfoLabel);
		typeText(driver, test, "//input[@id='editInvoiceItem_invoiceItem_exportClassEccnUsml']",
				"Enter Export Classification : ", ExportClassification);
		typeText(driver, test, OCR_SalesCreateNewOrderItemPage_HTS, "Enter HTS : ", HTS);
		typeText(driver, test, OCR_SalesCreateNewOrderItemPage_PrimaryUOM, "Enter Primary UOM : ", PrimaryUOM);
	}

	public void classificationInfoSaveBtn() {
		scrollToElement(driver, OCR_SalesCreateNewOrderItemPage_ClassificationInfoSaveBtn);
		Wait.waitfor(2);
		clickElement(driver, test, OCR_SalesCreateNewOrderItemPage_ClassificationInfoSaveBtn,
				"Click On Classification Info Save Button");

	}

	// Export Authorization information
	public void exportAuthInfo(String AuthNo, String AuthItemNo, String AuthType, String AuthTxnType,
			String AuthExpiryDate) {
		scrollToElement(driver, OCR_SalesCreateNewOrderItemPage_ExportAuthInfoLabel);
		clickElement(driver, test, OCR_SalesCreateNewOrderItemPage_ExportAuthInfoLabel,
				"Click on Export Authorization Informatio label");
		typeText(driver, test, OCR_SalesCreateNewOrderItemPage_AuthorisationNo, "Enter Authorization Number : ",
				AuthNo);
		typeText(driver, test, OCR_SalesCreateNewOrderItemPage_AuthItemNo, "Enter Authorization Item No : ",
				AuthItemNo);
		clickElement(driver, test, OCR_SalesCreateNewOrderItemPage_AuthType, " ");
		Wait.waitfor(3);
		/*Alert a1 = driver.switchTo().alert();
		a1.accept();*/
		typeText(driver, test, OCR_SalesCreateNewOrderItemPage_AuthType, "Enter Authorization Type : ", AuthType);
		typeText(driver, test, OCR_SalesCreateNewOrderItemPage_AuthTxnType, "Enter Authorization Transaction Type : ",
				AuthTxnType);

		if (AuthExpiryDate.length() > 0) {
			Wait.waitfor(2);
			clickElement(driver, test, OCR_SalesCreateNewOrderItemPage_AuthExpiryDate,
					"Click on Authorization Expiry Date");
			date(driver, test, "Select the Date of Export : ", AuthExpiryDate);
		}

	}

	// Export Authorization information us
	public void exportAuthInfoUS(String AuthNo, String AuthItemNo, String AuthType, String AuthTxnType,
			String AuthExpiryDate) {
		scrollToElement(driver, "//font[contains(text(),'Export Authorization Information')]");
		clickElement(driver, test, "//font[contains(text(),'Export Authorization Information')]",
				"Click on Export Authorization Informatio label");
		typeText(driver, test, OCR_SalesCreateNewOrderItemPage_AuthorisationNo, "Enter Authorization Number : ",
				AuthNo);
		typeText(driver, test, OCR_SalesCreateNewOrderItemPage_AuthItemNo, "Enter Authorization Item No : ",
				AuthItemNo);
		clickElement(driver, test, OCR_SalesCreateNewOrderItemPage_AuthType, " ");
		Wait.waitfor(3);
		typeText(driver, test, OCR_SalesCreateNewOrderItemPage_AuthType, "Enter Authorization Type : ", AuthType);
		typeText(driver, test, OCR_SalesCreateNewOrderItemPage_AuthTxnType, "Enter Authorization Transaction Type : ",
				AuthTxnType);
		if (AuthExpiryDate.length() > 0) {
			Wait.waitfor(2);
			clickElement(driver, test, OCR_SalesCreateNewOrderItemPage_AuthExpiryDate,
					"Click on Authorization Expiry Date");
			date(driver, test, "Select the Date of Export : ", AuthExpiryDate);
		}
	}

	// Additional Authorization Information
	public void additionalAuthInfo(String AdditionalAuthNo, String AdditionalAuthItemNo) {
		scrollToElement(driver, OCR_SalesCreateNewOrderItemPage_AdditionalAuthLabel);
		Wait.waitfor(3);
		clickElement(driver, test, OCR_SalesCreateNewOrderItemPage_AdditionalAuthLabel,
				"Click on Additional Authorization information label");
		clickElement(driver, test, OCR_SalesCreateNewOrderItemPage_AddAdditionalAuthBtn,
				"Click on Add Additional Authorization button");
		typeText(driver, test, OCR_SalesCreateNewOrderItemPage_AdditionalAuthNo, "Enter Additional Authorization No : ",
				AdditionalAuthNo);
		typeText(driver, test, OCR_SalesCreateNewOrderItemPage_AdditionalAuthItemNo,
				"Enter Additional Authorization Item no : ", AdditionalAuthItemNo);
		clickElement(driver, test, OCR_SalesCreateNewOrderItemPage_PopUpSaveBtn, "Click on Save Button");
	}

	// Additional Authorisation Information us
	public void additionalAuthInfoUS(String AdditionalAuthNo, String AdditionalAuthItemNo) {
		scrollToElement(driver, "//font[contains(text(),'Additional Authorization')]");
		Wait.waitfor(3);
		clickElement(driver, test, "//font[contains(text(),'Additional Authorization')]",
				"Click on Additional Authorization information label");
		clickElement(driver, test, OCR_SalesCreateNewOrderItemPage_AddAdditionalAuthBtn,
				"Click on Add Additional Authorization button");
		typeText(driver, test, OCR_SalesCreateNewOrderItemPage_AdditionalAuthNo, "Enter Additional Authorization No : ",
				AdditionalAuthNo);
		typeText(driver, test, OCR_SalesCreateNewOrderItemPage_AdditionalAuthItemNo,
				"Enter Additional Authorization Item no : ", AdditionalAuthItemNo);
		clickElement(driver, test, OCR_SalesCreateNewOrderItemPage_PopUpSaveBtn, "Click on Save Button");

	}

	// Packing Details Information
	public void packingInfo(String HUContainerID) {
		scrollToElement(driver, OCR_SalesCreateNewOrderItemPage_PackingInfoLabel);
		Wait.waitfor(2);
		clickElement(driver, test, OCR_SalesCreateNewOrderItemPage_PackingInfoLabel,
				"Click on Packing information label");
		if (HUContainerID.length() > 0) {
			Wait.waitfor(5);
			try {
				clickElement(driver, test, OCR_SalesCreateNewOrderItemPage_HUNoContainerIDLink,
						"select HU No/ Container ID from link");
				clickElement(driver, test, OCR_SalesCreateNewOrderItemPage_InvCartonRadioBtn,
						"Click on Invoice Carton Radio Button");

				// for selecting HU No/ContainerID among various options
				String ContID = "//td[contains(text(),'" + HUContainerID + "')]";
				clickElement(driver, test, ContID,
						"select the HU No/ContainerID among various options : " + HUContainerID);
				clickElement(driver, test, OCR_SalesCreateNewOrderItemPage_SelectBtn, "click on Select button");

			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_SalesCreateNewOrderItemPage_ContainerIDClosePopUp,
						"Click on Close popup icon");
			}

		}
	}

	// Batch Information
	public void batchInfo(String BatchNo, String BatchCOO) {
		scrollToElement(driver, OCR_SalesCreateNewOrderItemPage_BatchInfoLabel);
		clickElement(driver, test, OCR_SalesCreateNewOrderItemPage_BatchInfoLabel, "Click on Batch information label");
		clickElement(driver, test, OCR_SalesCreateNewOrderItemPage_AddbatchInfoBtn, "Click on Add Batch Info Button");
		typeText(driver, test, OCR_SalesCreateNewOrderItemPage_BatchNo, "Enter Batch No : ", BatchNo);
		typeText(driver, test, OCR_SalesCreateNewOrderItemPage_BatchCOO, "Enter COuntry Of Origin : ", BatchCOO);
		clickElement(driver, test, "//input[@id='editBatchHeader_batchDetailValue_batchPrimaryQty']", "");
		clickElement(driver, test, OCR_SalesCreateNewOrderItemPage_BatchSaveBtn, "Click on Submit Button");
	}

	public void saveBtn() {
		scrollToElement(driver, OCR_SalesCreateNewOrderItemPage_SaveBtn);
		clickElement(driver, test, OCR_SalesCreateNewOrderItemPage_SaveBtn,
				"Click on Save button on Sales Create Order Item Page");
	}

	public void hazmatDetails() {
		clickElement(driver, test, OCR_SalesCreateNewOrderItemPage_AdditionalTransactionDetails,
				"Click on Additional Transaction Details");
		clickElement(driver, test, OCR_SalesCreateNewOrderItemPage_HazmatDetails, "Click on Hazmat Details");

	}
}
