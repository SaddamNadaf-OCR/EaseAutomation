
package globalExportClasses;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class ShipWizardShipmentItemsPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_ShipmentItems_AddItem = "//button[contains(text(),'Add Item')]";
	public static final String OCR_ShipmentItems_LineItems= "//i[@class='fa fa-list-alt fa-2x']";
	public static final String OCR_ShipmentItems_SaveBtn = "//button[@id='buttonSave']";
	public static final String OCR_ShipmentItems_SaveAndReturn = "//button[@id='invWizardSaveReturn']";
	public static final String OCR_ShipmentItems_PartNoLink = "//a[@id='partno-popup']";
	public static final String OCR_ShipmentItems_PartNo = "//input[@id='searchForm_product_productCode']";
	public static final String OCR_ShipmentItems_Search = "//button[@name='Search']";
	public static final String OCR_ShipmentItems_Select = "(//button[contains(text(),'Select')])[1]";
	public static final String OCR_ShipmentItems_MLCategoryLink = "//a[contains(text(),'ML Category')]";
	public static final String OCR_ShipmentItems_MLCategoryExportClassfictn = "//input[@id='searchForm_ukItemsDTO_prodClassification']";
	public static final String OCR_ShipmentItems_TariffCodePrimaryUOM = "//input[@id='editInvoiceItemWizard_invoiceItem_htsScheduleBNo']";
	public static final String OCR_ShipmentItems_ExportClassificationLink = "//div[@id='general-info']//div[2]//label[2]//a[1]";
	public static final String OCR_ShipmentItems_ExportClassification = "//input[@id='editInvoiceItemWizard_invoiceItem_exportClassEccnUsml']";
	public static final String OCR_ShipmentItems_ImportHTSUOM = "//input[@id='editInvoiceItemWizard_invoiceItem_importHts']";
	public static final String OCR_ShipmentItems_ControlAgency = "//input[@id='editInvoiceItemWizard_invoiceItem_controllingAgency']";
	public static final String OCR_ShipmentItems_USExportClassificationLink = "//a[@id='productClass-us-Popup']";
	public static final String OCR_ShipmentItems_USExportClassificationECCN = "//input[@id='searchForm_productClazz_prodClassification']";
	public static final String OCR_ShipmentItems_SalesOrderNo = "//input[@id='editInvoiceItemWizard_invoiceItem_salesOrderNo']";
	public static final String OCR_ShipmentItems_SalesOrderItemNo = "//input[@id='editInvoiceItemWizard_invoiceItem_salesOrderItemNo']";
	public static final String OCR_ShipmentItems_DeliveryOrderNo = "//input[@id='editInvoiceItemWizard_invoiceItem_deliveryOrderNo']";
	public static final String OCR_ShipmentItems_DeliveryOrderItemNo = "//input[@id='editInvoiceItemWizard_invoiceItem_deliveryOrderItemNo']";
	public static final String OCR_ShipmentItems_CountryofOrigin = "//input[@id='cooName']";
	public static final String OCR_ShipmentItems_ManufacturerLink = "//a[@id='getManufacturer']";
	public static final String OCR_ShipmentItems_ProductDescription = "//textarea[@id='editInvoiceItemWizard_invoiceItem_description']";
	public static final String OCR_ShipmentItems_SerialNumbers = "//textarea[@id='editInvoiceItemWizard_invoiceItem_serialNo']";
	public static final String OCR_ShipmentItems_PopUpClose = "//button[@class='btn-close']";
	public static final String OCR_ShipmentItems_CustomsInvoiceQuantity = "//input[@id='editInvoiceItemWizard_invoiceItem_primaryNetQuantity']";
	public static final String OCR_ShipmentItems_CustomsInvoiceUnits = "//input[@id='editInvoiceItemWizard_invoiceItem_invoiceUnitOfQuantity']";
	public static final String OCR_ShipmentItems_ItemUnitPrice = "//input[@id='editInvoiceItemWizard_invoiceItem_prodUnitPrice']";
	public static final String OCR_ShipmentItems_QuantityOrdered = "//input[@id='editInvoiceItemWizard_invoiceItem_qtyOrdered']";
	public static final String OCR_ShipmentItems_TotalItemValue = "//input[@id='editInvoiceItemWizard_invoiceItem_prodInvoiceValue']";
	public static final String OCR_ShipmentItems_DiscountRate = "//input[@id='editInvoiceItemWizard_invoiceItem_discount']";
	public static final String OCR_ShipmentItems_WholesaleRate = "//input[@id='editInvoiceItemWizard_invoiceItem_wholesaleRate']";
	public static final String OCR_ShipmentItems_QuantityLabel = "//label[contains(text(),'Quantity & Pricing Information')]";
	public static final String OCR_ShipmentItems_PackingInformationLabel = "//label[contains(text(),'Packing Information')]";
	public static final String OCR_ShipmentItems_GrossWeight = "//input[@id='editInvoiceItemWizard_invoiceItem_grossWeight']";
	public static final String OCR_ShipmentItems_NetWeight = "//input[@id='editInvoiceItemWizard_invoiceItem_netWeight']";
	public static final String OCR_ShipmentItems_MarksAndNos = "//input[@id='editInvoiceItemWizard_invoiceItem_marksAndNos']";
	public static final String OCR_ShipmentItems_Dimensions = "//input[@id='editInvoiceItemWizard_invoiceItem_dimensions']";
	public static final String OCR_ShipmentItems_NoOfPkgs = "//input[@id='editInvoiceItemWizard_invoiceItem_noOfPackages']";
	public static final String OCR_ShipmentItems_AlternateUOM = "//input[@id='editInvoiceItemWizard_invoiceItem_alternateUom']";
	public static final String OCR_ShipmentItems_Skids = "//input[@id='editInvoiceItemWizard_invoiceItem_skids']";
	public static final String OCR_ShipmentItems_Length = "//input[@id='editInvoiceItemWizard_invoiceItem_length']";
	public static final String OCR_ShipmentItems_Width = "//input[@id='editInvoiceItemWizard_invoiceItem_width']";
	public static final String OCR_ShipmentItems_Height = "//input[@id='editInvoiceItemWizard_invoiceItem_height']";
	public static final String OCR_ShipmentItems_Weight = "//input[@id='editInvoiceItemWizard_invoiceItem_weight']";
	public static final String OCR_ShipmentItems_ExtendedWeight = "//input[@id='editInvoiceItemWizard_invoiceItem_extendedWeight']";
	public static final String OCR_ShipmentItems_Factor = "//input[@id='editInvoiceItemWizard_invoiceItem_factor']";
	public static final String OCR_ShipmentItems_Cubic = "//input[@id='editInvoiceItemWizard_invoiceItem_cubic']";
	public static final String OCR_ShipmentItems_BatchInformationLabel = "//label[contains(text(),'Batch Information')]";
	public static final String OCR_ShipmentItems_AddBatchBtn = "//button[@id='addBatch']";
	public static final String OCR_ShipmentItems_BatchNumber = "//input[@id='editBatchHeader_batchDetailValue_batchNo']";
	public static final String OCR_ShipmentItems_BatchCountryOfOrigin = "//input[@id='editBatchHeader_']";
	public static final String OCR_ShipmentItems_BatchQuantity = "//input[@id='editBatchHeader_batchDetailValue_batchPrimaryQty']";
	public static final String OCR_ShipmentItems_BatchExpiryDate = "//input[@id='editBatchHeader_batchDetailValue_batchRemark1']";
	public static final String OCR_ShipmentItems_BatchSterilityDate = "//input[@id='editBatchHeader_batchDetailValue_batchRemark2']";
	public static final String OCR_ShipmentItems_BatchSubmit = "//button[@id='save']";
	public static final String OCR_ShipmentItems_ItemCopyicon ="(//i[@class='fa fa-copy'])[2]";
	public static final String OCR_ShipmentItems_ItemDeleteIcon ="(//i[@class='fa fa-trash-o'])[1]";

	/* ******************************* Constructor ****************************** */

	public ShipWizardShipmentItemsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */
	
	
	// click on Add items button
	public void click_AddItem() {
		clickElement(driver, test, OCR_ShipmentItems_AddItem, "Click on Add Item button");
	}
	
	// click on  items Copy icon --------Added by Deva
		public void click_ItemCopyIcon() {
			clickElement(driver, test, OCR_ShipmentItems_ItemCopyicon, " click on  items Copy icon ");
			test.log(LogStatus.PASS, "Clicked On Item Copy Icon");
		}
		
	// click on Item Delete Icon -----Added by Deva
		public void click_ItemDeleteIcon() {
			clickElement(driver, test, OCR_ShipmentItems_ItemDeleteIcon, "click on Item Delate Icon");
			Wait.waitfor(2);
			AlertPopUp(driver, test, "Are you sure you wish to delete?");
			Wait.waitfor(2);
			test.log(LogStatus.PASS, "Clicked On Item Delete Icon");
		}
		
	// click on Line items button -----------Added by Deva
		public void click_LineItems() {
			clickElement(driver, test, OCR_ShipmentItems_LineItems, "Click on Line Items button");
		}

	// click on Save btn
	public void clickSaveBtn() {
		scrollToTop(driver);
		scrollToTop(driver);
		clickElement(driver, test, OCR_ShipmentItems_SaveBtn, "Click on Save button");
	}

	// Click on Save AND Return
	public void clickSaveAndReturn() {
		scrollToTop(driver);scrollToTop(driver);
		clickElement(driver, test, OCR_ShipmentItems_SaveAndReturn, "Click on Save and Return button");
	}

	// Add item genernal informations
	public void addItemGeneralInfo(String PartNo, String MLCategoryExportClassification, String TariffCode,
			String ReportingClassification, String ImportHTSUOM, String USExportClassificationECCN, String ControlAgency, String SalesOrderNo,
			String SalesOrderItemNo, String DeliveryOrderNo, String DeliveryOrderItemNo, String SerialNumbers) {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_ShipmentItems_PartNoLink, "Click on Part No Link");
		try {
			typeText(driver, test, OCR_ShipmentItems_PartNo, "Enter the Part No : ", PartNo);
			clickElement(driver, test, OCR_ShipmentItems_Search, "Click on Search button");
			Wait.waitfor(3);
			clickElement(driver, test, "//td[contains(text(),'" + PartNo + "')]", "Click on Part No : " + PartNo);
			clickElement(driver, test, OCR_ShipmentItems_Select, "Click on Select Button");
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_ShipmentItems_PopUpClose, "Click on POP UP close");
		}
		if (MLCategoryExportClassification.length() > 0) {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_ShipmentItems_MLCategoryLink, "Click on ML category link");
			try {
				typeText(driver, test, OCR_ShipmentItems_MLCategoryExportClassfictn,
						"Enter the MLCategory Export Classification : ", MLCategoryExportClassification);
				clickElement(driver, test, OCR_ShipmentItems_Search, "Click on Search button");
				Wait.waitfor(5);
				clickElement(driver, test, "//td[contains(text(),'" + MLCategoryExportClassification + "')]",
						"Click on MLCategory Export Classification : " + MLCategoryExportClassification);
				clickElement(driver, test, OCR_ShipmentItems_Select, "Click on Select Button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_ShipmentItems_PopUpClose, "Click on POP UP close");
			}
		}
		typeText(driver, test, OCR_ShipmentItems_TariffCodePrimaryUOM, "Enter the Tariff Code & Primary UOM : ",
				TariffCode);

//		if (ExportClassification.length() > 0) {
//			Wait.waitfor(3);
//			clickElement(driver, test, OCR_ShipmentItems_ExportClassificationLink,
//					"Click on Export Classification Link ");
//			try {
//				typeText(driver, test, OCR_ShipmentItems_MLCategoryExportClassfictn,
//						"Enter the Export Classification : ", ExportClassification);
//				clickElement(driver, test, OCR_ShipmentItems_Search, "Click on Search button");
//				Wait.waitfor(3);
//				clickElement(driver, test, "//td[contains(text(),'" + ExportClassification + "')]",
//						"Click on Export Classification : " + ExportClassification);
//				clickElement(driver, test, OCR_ShipmentItems_Select, "Click on Select Button");
//			} catch (Exception e) {
//				testFailSshot(driver, test);
//				clickElement(driver, test, OCR_ShipmentItems_PopUpClose, "Click on POP UP close");
//			}
//		}
		typeText(driver, test, OCR_ShipmentItems_ExportClassification, "Enter Reporting Classification : ", ReportingClassification);
		typeText(driver, test, OCR_ShipmentItems_ImportHTSUOM, "Enter the Import HTS / UOM : ", ImportHTSUOM);
		Wait.waitfor(2);
		if (USExportClassificationECCN.length() > 0) {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_ShipmentItems_USExportClassificationLink,
					"Click on US Export Classification Link");
			try {
				typeText(driver, test, OCR_ShipmentItems_USExportClassificationECCN,
						"Enter the Export Classification ECCN : ", USExportClassificationECCN);
				clickElement(driver, test, OCR_ShipmentItems_Search, "Click on Search button");
				Wait.waitfor(3);
				clickElement(driver, test, "//td[contains(text(),'" + USExportClassificationECCN + "')]",
						"Click on Export Classification : " + USExportClassificationECCN);
				clickElement(driver, test, OCR_ShipmentItems_Select, "Click on Select Button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_ShipmentItems_PopUpClose, "Click on POP UP close");
			}
		}
		typeText(driver, test, OCR_ShipmentItems_ControlAgency, "Enter Controlling Agency : ", ControlAgency);
		typeText(driver, test, OCR_ShipmentItems_SalesOrderNo, "Enter the Sales Order No : ", SalesOrderNo);
		typeText(driver, test, OCR_ShipmentItems_SalesOrderItemNo, "Enter the Sales Order Item No : ",
				SalesOrderItemNo);
		typeText(driver, test, OCR_ShipmentItems_DeliveryOrderNo, "Enter the Delivery order no : ", DeliveryOrderNo);
		typeText(driver, test, OCR_ShipmentItems_DeliveryOrderItemNo, "Enter the Delivery Order Item  No : ",
				DeliveryOrderItemNo);
		typeText(driver, test, OCR_ShipmentItems_SerialNumbers, "Enter the Serial Numbers: ", SerialNumbers);
	}

	// Add the quantity and pricing informations
	public void addQuantityAndPricingInfo(String CustomsInvoiceQuantity,String Units, String UnitPrice ,String QuantityOrdered, String TotalItemValue,
			String DiscountRate, String WholesaleRate) throws Exception {
		scrollToBottom(driver);
		scrollToBottom(driver);
		clickElement(driver, test, OCR_ShipmentItems_QuantityLabel, "click on Quantity and pricing informations Label");
		typeText(driver, test, OCR_ShipmentItems_CustomsInvoiceQuantity, "Enter the Customs Invoice Quantity : ",
				CustomsInvoiceQuantity);
		typeText(driver, test, OCR_ShipmentItems_CustomsInvoiceUnits, "Enter the units : ", Units);
		typeText(driver, test, OCR_ShipmentItems_ItemUnitPrice, "Enter Item Unit Price : ", UnitPrice);
		typeText(driver, test, OCR_ShipmentItems_QuantityOrdered, "Enter the Quantity Ordered : ", QuantityOrdered);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		Wait.waitfor(3);
		typeText(driver, test, OCR_ShipmentItems_TotalItemValue, "Enter the Total Item Value : ", TotalItemValue);
		r.keyRelease(KeyEvent.VK_TAB);
		Wait.waitfor(3);
		typeText(driver, test, OCR_ShipmentItems_DiscountRate, "Enter the Discount Rate : ", DiscountRate);
		typeText(driver, test, OCR_ShipmentItems_WholesaleRate, "Enter the Wholesale Rate : ", WholesaleRate);
	}

	// Add the Packing Informations
	public void addPackingInfo(String GrossWeight, String NetWeight, String MarksAndNos, String Dimensions,
			String NoOfPkgs, String AlternateUOM, String Skids, String PackingLenghtWidthHight,
			String PackingWeightExWeight, String Factor, String Cubic) {
		scrollToElement(driver, OCR_ShipmentItems_PackingInformationLabel);
		clickElement(driver, test, OCR_ShipmentItems_PackingInformationLabel, "Click on Packing Information Label");
		typeText(driver, test, OCR_ShipmentItems_GrossWeight, "Enter the Gross Weight : ", GrossWeight);
		typeText(driver, test, OCR_ShipmentItems_NetWeight, "Enter the Net Weight : ", NetWeight);
		typeText(driver, test, OCR_ShipmentItems_MarksAndNos, "Enter the Marks And Nos : ", MarksAndNos);
		typeText(driver, test, OCR_ShipmentItems_Dimensions, "Enter the Dimensions : ", Dimensions);
		typeText(driver, test, OCR_ShipmentItems_NoOfPkgs, "Enter the No Of Pkgs : ", NoOfPkgs);
		typeText(driver, test, OCR_ShipmentItems_AlternateUOM, "Enter the Alternate UOM : ", AlternateUOM);
		typeText(driver, test, OCR_ShipmentItems_Skids, "Enter the Skids : ", Skids);
		ArrayList<String> LWH = GenericMethods.stringtoken(PackingLenghtWidthHight);
		typeText(driver, test, OCR_ShipmentItems_Length, "Enter the lenght : ", LWH.get(0));
		typeText(driver, test, OCR_ShipmentItems_Width, "Enter the Width : ", LWH.get(1));
		typeText(driver, test, OCR_ShipmentItems_Height, "Enter the Height : ", LWH.get(2));
		ArrayList<String> WeightExW = GenericMethods.stringtoken(PackingWeightExWeight);
		typeText(driver, test, OCR_ShipmentItems_Weight, "Enter the Weight : ", WeightExW.get(0));
		typeText(driver, test, OCR_ShipmentItems_ExtendedWeight, "Enter the Extended Weight : ", WeightExW.get(1));
		typeText(driver, test, OCR_ShipmentItems_Factor, "Enter the Factor : ", Factor);
		typeText(driver, test, OCR_ShipmentItems_Cubic, "Enter the Cubic : ", Cubic);
	}

	// Adding Batch informations
	public void addBatchInfo(String BatchNumber, String BatchCountryOfOrigin, String BatchQuantity,
			String BatchExpiryDate, String BatchSterilityDate) {
		scrollToBottom(driver);
		clickElement(driver, test, OCR_ShipmentItems_BatchInformationLabel, "Click on Batch Information Label");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_ShipmentItems_AddBatchBtn, "Click on Batch Info Button");
		try {
			Wait.waitfor(3);
			typeText(driver, test, OCR_ShipmentItems_BatchNumber, "Enter the Batch Number : ", BatchNumber);
			typeText(driver, test, OCR_ShipmentItems_BatchCountryOfOrigin, "Enter the Batch Country Of Origin : ",
					BatchCountryOfOrigin);
			typeText(driver, test, OCR_ShipmentItems_BatchQuantity, "Enter the Batch Quantity : ", BatchQuantity);
			clickElement(driver, test, OCR_ShipmentItems_BatchExpiryDate, "click on Batch Expiry Date");
			date(driver, test, "Select the Batch Expiry Date : ", BatchExpiryDate);
			clickElement(driver, test, OCR_ShipmentItems_BatchSterilityDate, "Click on Batch Sterility Date");
			date(driver, test, "Select the Batch Sterility Date : ", BatchSterilityDate);
			clickElement(driver, test, OCR_ShipmentItems_BatchSubmit, "Click on Submit");
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_ShipmentItems_PopUpClose, "Click on POP UP close");
		}
	}

	// Validating the line items mandatorty fields
	public void validateLineItems() {
		try {
			if (isDisplayed(driver, "//h4[contains(text(),'Error!')]")) {

				if (isDisplayed(driver,
						"//li[contains(text(),'Custom Invoice Quantity (Quantity & Pricing Inform')]")) {
					test.log(LogStatus.INFO, "Custom Invoice Quantity (Quantity & Pricing Information) is required.");
				}
				if (isDisplayed(driver,
						"//li[contains(text(),'Product Description (General Information) is requi')]")) {
					test.log(LogStatus.INFO, "Product Description (General Information) is required");
				}
				if (isDisplayed(driver, "//li[contains(text(),'Item Unit Price is required.')]")) {
					test.log(LogStatus.INFO, "Item Unit Price is required.");
				}
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Error Vaildation is not Displayed by clicking on SAVE button in line items page");
		}
	}

	// Validating the Packing details multiple package toggle selection
	public void validatingPackingDetails(String PartNo, String CustomsInvoiceQuantity) {

		
		clickElement(driver, test, OCR_ShipmentItems_PartNoLink, "Click on Part No Link");
		try {
			typeText(driver, test, OCR_ShipmentItems_PartNo, "Enter the Part No : ", PartNo);
			clickElement(driver, test, OCR_ShipmentItems_Search, "Click on Search button");
			Wait.waitfor(3);
			clickElement(driver, test, "//td[contains(text(),'" + PartNo + "')]", "Click on Part No : " + PartNo);
			clickElement(driver, test, OCR_ShipmentItems_Select, "Click on Select Button");
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_ShipmentItems_PopUpClose, "Click on POP UP close");
		}
		Wait.waitfor(3);
		clickElement(driver, test, OCR_ShipmentItems_QuantityLabel, "click on Quantity and pricing informations Label");
		typeText(driver, test, OCR_ShipmentItems_CustomsInvoiceQuantity, "Enter the Customs Invoice Quantity : ",
				CustomsInvoiceQuantity);
		clickSaveBtn();
		try {
			if (isDisplayed(driver, "//div[@class='lcs_switch lcs_off lcs_checkbox_switch']")) {
				test.log(LogStatus.INFO, "Multiple Packing details toggle selection is No");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Multiple Packing details toggle selection is Yes");
		}
		Wait.waitfor(3);
		clickElement(driver, test, "//div[@class='lcs_switch lcs_off lcs_checkbox_switch']",
				"Click on Multiple Package Toggle");
		try {
			if (isDisplayed(driver, "//div[@class='lcs_switch lcs_checkbox_switch lcs_on']")) {
				test.log(LogStatus.INFO, "Multiple Packing details toggle selection is Yes");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Multiple Packing details toggle selection is No");
		}
		Wait.waitfor(3);
	}
	
	//adding the product description and Customs Invoice Quantity
	public void addMandatoryItemDetails(String ProductDescription, String CustomsInvoiceQuantity, String ItemUnitPrice) {
		typeText(driver, test, OCR_ShipmentItems_ProductDescription, "Enter the Product Descriptions : ", ProductDescription);
		clickElement(driver, test, OCR_ShipmentItems_QuantityLabel, "Click on Quantity & Pricing Information");
		typeText(driver, test, OCR_ShipmentItems_CustomsInvoiceQuantity, "Enter the Customs Invoice Quantity : ", CustomsInvoiceQuantity);
		typeText(driver, test, OCR_ShipmentItems_ItemUnitPrice, "Enter the Item Unit Price : ", ItemUnitPrice);
	}
	
	//Click on Copy Icon From Grid
	public void clickCopyIcon() {
		clickElement(driver, test, "//i[@class='fa fa-copy']", "Clicking on Copy Icon From Grid :");
	}
	
	//Click on Delete Icon From Grid
	public void clickDeleteIcon() {
		clickElement(driver, test, "(//i[@class='fa fa-trash-o'])[3]", "Clicking on Delete Icon From Grid :");
	}
	
	//Validate Delete Items Number
	public void itemNumberValidation() {
		try {
			if(isDisplayed(driver, "")) {
				test.log(LogStatus.PASS, "Serial No 1 is Displayed in Grid :");
				if(isDisplayed(driver, "")) {
					test.log(LogStatus.PASS, "Serial No 2 is Displayed in Grid :");
					if(isDisplayed(driver, "")) {
						test.log(LogStatus.PASS, "Serial No 4 is Displayed in Grid :");
					}
				}
			}
		}catch(Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Deleted Items are Not Displaying Dynamically Renumbering :");
		}
	}
}
