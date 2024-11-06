package importOperationClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class EntrySummaryItemDetailsPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_ESItem_AddItems = "//button[@id='addEntItems']";
	public static final String OCR_ESItem_GoBtn = "//button[@id='go']";
	public static final String OCR_ESItem_PartNoLink = "//a[@id='partNo']";
	public static final String OCR_ESItem_PartNo = "//input[@id='searchForm_product_productCode']";
	public static final String OCR_ESItem_Search = "//button[@name='Search']";
	public static final String OCR_ESItem_Select = "(//button[@name='Ok'])[1]";
	public static final String OCR_ESItem_Close = "//button[@class='close']";
	public static final String OCR_ESItem_SupplierPartNo = "//input[@id='editImport7501ItemDetails_import7501ItemDetailsValue_supplierPartNo']";
	public static final String OCR_ESItem_SourceSystemPartNo = "//input[@id='editImport7501ItemDetails_import7501ItemDetailsValue_sourceSystemPartNo']";
	public static final String OCR_ESItem_ProductName = "//textarea[@id='editImport7501ItemDetails_import7501ItemDetailsValue_productName']";
	public static final String OCR_ESItem_IdentificationQualifier = "//select[@id='editImport7501ItemDetails_import7501ItemDetailsValue_identificationQualifier']";
	public static final String OCR_ESItem_IdentificationNo = "//textarea[@id='editImport7501ItemDetails_import7501ItemDetailsValue_serialNo']";
	public static final String OCR_ESItem_ArticleSet = "//select[@id='editImport7501ItemDetails_import7501ItemDetailsValue_articleSet']";
	public static final String OCR_ESItem_GrossWeight = "//input[@id='editImport7501ItemDetails_itemGrossWeight']";
	public static final String OCR_ESItem_RelatedParty = "//select[@id='editImport7501ItemDetails_import7501ItemDetailsValue_relatedPartyFlag']";
	public static final String OCR_ESItem_SupplierManufIDlink = "//a[@id='supplierManuId']";
	public static final String OCR_ESItem_CountryOfOrigin = "//input[@id='editImport7501ItemDetails_import7501ItemDetailsValue_countryOfOriginName']";
	public static final String OCR_ESItem_ProvinceOfOrigin = "//input[@id='editImport7501ItemDetails_import7501ItemDetailsValue_provinceOfOriginName']";
	public static final String OCR_ESItem_ExportingCountry = "//input[@id='editImport7501ItemDetails_import7501ItemDetailsValue_countryOfExportName']";
	public static final String OCR_ESItem_ForeignPortOfLadingLink = "//a[@id='foreignPortofLading']";
	public static final String OCR_ESItem_DateOfExport = "//input[@id='editImport7501ItemDetails_exportDate']";
	public static final String OCR_ESItem_SoldToParty = "//select[@id='editImport7501ItemDetails_import7501ItemDetailsValue_soldToPartyCode']";
	public static final String OCR_ESItem_DeliverToParty = "//select[@id='editImport7501ItemDetails_import7501ItemDetailsValue_deliverToPartyCode']";
	public static final String OCR_ESItem_TradePrivilegesInformation = "//label[contains(text(),'Privileges Information')]";
	public static final String OCR_ESItem_TradeProgramSPILink = "//a[@id='tradeProgramSpi']";
	public static final String OCR_ESItem_FeeExemptionCode = "//select[@id='editImport7501ItemDetails_import7501ItemDetailsValue_feeExemptionCode']";
	public static final String OCR_ESItem_NAFTANetCost = "//select[@id='editImport7501ItemDetails_import7501ItemDetailsValue_naftaNetCost']";
	public static final String OCR_ESItem_FTZMerchandiseStatus = "//select[@id='editImport7501ItemDetails_import7501ItemDetailsValue_ftzMerchStatus']";
	public static final String OCR_ESItem_FTZLineItemQuantity = "//input[@id='ftzLineItemQuantityId']";
	public static final String OCR_ESItem_ApplyTradeProgramPrivileges = "//select[@id='editImport7501ItemDetails_import7501ItemDetailsValue_applyProgramPrivilege']";
	public static final String OCR_ESItem_ProductClaimSPILink = "//input[@id='editImport7501ItemDetails_import7501ItemDetailsValue_productClaim']";
	public static final String OCR_ESItem_EligibleForDutyDrawback = "//select[@id='editImport7501ItemDetails_import7501ItemDetailsValue_eligibleForDutyDb']";
	public static final String OCR_ESItem_PrivilegedFTZMerchFilingDate = "//input[@id='editImport7501ItemDetails_privFtzMerchFilingDate']";
	public static final String OCR_ESItem_PreviousFTZHSNoLink = "//a[@id='prevFTZHsNoId']";
	public static final String OCR_ESItem_HSNo = "//input[@id='hsNo_resultStdHsPopup']";
	public static final String OCR_ESItem_TariffRulingType = "//select[@id='editImport7501ItemDetails_import7501ItemDetailsValue_htsRulingType']";
	public static final String OCR_ESItem_HSRuling = "//input[@id='editImport7501ItemDetails_import7501ItemDetailsValue_htsRuling']";
	public static final String OCR_ESItem_Primary = "//a[@id='impClassId']";
	public static final String OCR_ESItem_InvoiceValue = "//input[@id='editImport7501ItemDetails_invoiceCurncyValue']";
	public static final String OCR_ESItem_InvoiceQtyUOM = "//input[@id='editImport7501ItemDetails_quantity']";
	public static final String OCR_ESItem_ItemValue = "//input[@id='editImport7501ItemDetails_invoiceValue']";
	public static final String OCR_ESItem_Charges = "//input[@id='editImport7501ItemDetails_charges']";
	public static final String OCR_ESItem_EnteredValue = "//input[@id='editImport7501ItemDetails_enteredValue']";
	public static final String OCR_ESItem_DutyAmount = "//input[@id='editImport7501ItemDetails_dutyIrTax']";
	public static final String OCR_ESItem_ApplicableAssistValue = "//input[@id='editImport7501ItemDetails_assistsValue']";
	public static final String OCR_ESItem_SaveBtn = "//button[@name='save']";
	public static final String OCR_ESItem_SaveAndReturnBtn = "//button[contains(text(),'Save & Return')]";
	public static final String OCR_ESItem_BillofLading = "//button[@id='add7501Bol']";
	public static final String OCR_ESItem_RefreshValue = "//button[contains(text(),'Refresh Values')]";
	public static final String OCR_ESItem_BOL_Tab = "//label[contains(text(),'Bill of Lading')]";
	public static final String OCR_ESItem_ManifestUOM = "//input[@id='edit7501EntryLineSummary_import7501DetailsValue_manifestUom']";
	public static final String OCR_ESItem_CloseAlert = "//button[@class='close']";

	/* ******************** Constructor ***************************** */

	public EntrySummaryItemDetailsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	// Adding the Item Information
	public void addItemInformation(String PartNo, String SupplierPartNo, String SourceSystemPartNo, String ProductName,
			String IdentificationQualifier, String IdentificationNo, String ArticleSet, String GrossWeight,
			String RelatedParty, String SupplierManufID, String CountryofOrigin, String ProvinceOfOrigin,
			String ExportingCountry, String ForeignPortOfLadingID, String DateOfExport, String SoldToParty,
			String DeliverToParty) {
		clickElement(driver, test, OCR_ESItem_PartNoLink, "Click on Part No Link");
		try {
			Wait.waitfor(3);
			typeText(driver, test, OCR_ESItem_PartNo, "Enter the Part No : ", PartNo);
			clickElement(driver, test, OCR_ESItem_Search, "CLick on Search Button");
			clickElement(driver, test, "//td[contains(text(),'" + PartNo + "')]", "Click on Part No : ");
			clickElement(driver, test, OCR_ESItem_Select, "Click on Select");
		} catch (Exception e) {
			testFailSshot(driver, test);

		}
		typeText(driver, test, OCR_ESItem_SupplierPartNo, "Enter the Supplier Part No : ", SupplierPartNo);
		typeText(driver, test, OCR_ESItem_SourceSystemPartNo, "Enter the Source System Part No : ", SourceSystemPartNo);
		typeText(driver, test, OCR_ESItem_ProductName, "Enter the Product Name : ", ProductName);
		selectByVisibleText(driver, test, OCR_ESItem_IdentificationQualifier, "Select the Identification Qualifier : ",
				IdentificationQualifier);
		typeText(driver, test, OCR_ESItem_IdentificationNo, "Enter the Identification No : ", IdentificationNo);
		selectByVisibleText(driver, test, OCR_ESItem_ArticleSet, "Select the Article Set : ", ArticleSet);
		typeText(driver, test, OCR_ESItem_GrossWeight, "Enter the Gross Weight : ", GrossWeight);
		selectByVisibleText(driver, test, OCR_ESItem_RelatedParty, "Select the Related Party : ", RelatedParty);
		clickElement(driver, test, OCR_ESItem_SupplierManufIDlink, "Click on Supplier Manuf.ID Link");
		try {
			clickElement(driver, test, "//td[contains(text(),'" + SupplierManufID + "')]",
					"Click on Supplier Manuf.ID : " + SupplierManufID);
			clickElement(driver, test, OCR_ESItem_Select, "Click on Select button");
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_ESItem_Close, "click on Close");
		}
		scrollToElement(driver, OCR_ESItem_SupplierManufIDlink);
		Wait.waitfor(3);
		typeText(driver, test, OCR_ESItem_CountryOfOrigin, "Enter the Country of Origin : ", CountryofOrigin);
		typeText(driver, test, OCR_ESItem_ProvinceOfOrigin, "Enter the Province Of Origin :  ", ProvinceOfOrigin);
		Wait.waitfor(3);
		typeText(driver, test, OCR_ESItem_ExportingCountry, "Enter the Exporting Country :", ExportingCountry);
		Wait.waitfor(3);
		if (ForeignPortOfLadingID.length() > 0) {
			clickElement(driver, test, OCR_ESItem_ForeignPortOfLadingLink, "Click on Foreign Port Of Lading Link");
			try {
				typeText(driver, test, "//input[@id='searchForm_ports_portId']", "Enter the Port ID : ",
						ForeignPortOfLadingID);
				clickElement(driver, test, "//button[@name='Search']", "Click on Search");
				clickElement(driver, test, "//td[contains(text(),'" + ForeignPortOfLadingID + "')]",
						"Click on Foreign Port Of Lading ID : " + ForeignPortOfLadingID);
				clickElement(driver, test, OCR_ESItem_Select, "Click on Select button");
				Wait.waitfor(3);
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_ESItem_Close, "click on Close");
			}
		}
		scrollToElement(driver, OCR_ESItem_SupplierManufIDlink);
		clickElement(driver, test, OCR_ESItem_DateOfExport, "Click on Date of Export");
		date(driver, test, "Select the Date : ", DateOfExport);
		selectByVisibleText(driver, test, OCR_ESItem_SoldToParty, "Select the Sold To Party : ", SoldToParty);
		selectByVisibleText(driver, test, OCR_ESItem_DeliverToParty, "Select the Deliver To Party : ", DeliverToParty);
	}

	// Adding the Trade / Privileges Information
	public void addTradePrivilegesInformation(String SIPCode, String FeeExemptionCode, String NAFTANetCost,
			String FTZMerchandiseStatus, String FTZLineItemQuantity, String ApplyTradeProgramPrivileges,
			String ClaimSPICode, String EligibleForDutyDrawback, String PrivilegedFTZMerchFilingDate,
			String PreviousFTZHSNo) {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_ESItem_TradePrivilegesInformation, "Click on Trade / Privileges Information");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_ESItem_TradeProgramSPILink, "Click on Trade Program SPI Link");
		try {
			clickElement(driver, test, "//td[contains(text(),'" + SIPCode + "')]", "Click on SIP Code : " + SIPCode);
			clickElement(driver, test, OCR_ESItem_Select, "Click on Select button");
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_ESItem_Close, "click on Close");
		}
		selectByVisibleText(driver, test, OCR_ESItem_FeeExemptionCode, "Select the Fee Exemption Code: ",
				FeeExemptionCode);
		selectByVisibleText(driver, test, OCR_ESItem_NAFTANetCost, "Select the NAFTA Net Cost : ", NAFTANetCost);
		selectByVisibleText(driver, test, OCR_ESItem_FTZMerchandiseStatus, "Select the FTZ Merchandise Status",
				FTZMerchandiseStatus);
		typeText(driver, test, OCR_ESItem_FTZLineItemQuantity, "Enter the FTZ Line Item Quantity : ",
				FTZLineItemQuantity);
		selectByVisibleText(driver, test, OCR_ESItem_ApplyTradeProgramPrivileges,
				"Select the Apply Trade Program Privileges : ", ApplyTradeProgramPrivileges);
		Wait.waitfor(3);
		clickElement(driver, test, OCR_ESItem_ProductClaimSPILink, "Click on Product Claim SPI Link");
		try {
			clickElement(driver, test, "//td[contains(text(),'" + ClaimSPICode + "')]",
					"Click on Product Claim SPI Code : " + ClaimSPICode);
			clickElement(driver, test, OCR_ESItem_Select, "Click on Select button");
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_ESItem_Close, "click on Close");
		}
		Wait.waitfor(3);
		selectByVisibleText(driver, test, OCR_ESItem_EligibleForDutyDrawback,
				"Select the Eligible For Duty Drawback : ", EligibleForDutyDrawback);
		clickElement(driver, test, OCR_ESItem_PrivilegedFTZMerchFilingDate,
				"Click on Privileged FTZ Merch Filing Date");
		date(driver, test, "Select the Privileged FTZ Merch Filing Date : ", PrivilegedFTZMerchFilingDate);
		Wait.waitfor(3);
		clickElement(driver, test, OCR_ESItem_PreviousFTZHSNoLink, "Click on Previous FTZ HS No Link");
		try {
			typeText(driver, test, OCR_ESItem_HSNo, "Enter the HSNO : ", PreviousFTZHSNo);
			clickElement(driver, test, OCR_ESItem_Search, "Click on Search");
			clickElement(driver, test, "//td[contains(text(),'" + PreviousFTZHSNo + "')]",
					"Click on HS NO : " + PreviousFTZHSNo);
			clickElement(driver, test, OCR_ESItem_Select, "Click on Select button");
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, "//button[@class='btn-close']", "click on Close");
		}
	}

	// Add the Tariff Details
	public void addtariffDetails(String TariffRulingType, String HSRuling, String HSNO, String PrimaryQty1,
			String PrimaryValue) {
		scrollToElement(driver, OCR_ESItem_SoldToParty);
		Wait.waitfor(4);
		selectByVisibleText(driver, test, OCR_ESItem_TariffRulingType, "Select the Tariff Ruling Type : ",
				TariffRulingType);
		typeText(driver, test, OCR_ESItem_HSRuling, "Enter the H S Ruling : ", HSRuling);
		if (HSNO.length() > 0) {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_ESItem_Primary, "Click on Primary Hs no Link");
			try {
				typeText(driver, test, OCR_ESItem_HSNo, "Add HS no : ", HSNO);
				clickElement(driver, test, "//button[@id='searchHsDtlBtn']", "Click on Search Btn");
				String PrimaryHsNo = "//div[contains(text(),'" + HSNO + "')]";
				Wait.waitfor(4);
				clickElement(driver, test, PrimaryHsNo, "Select Primary Hs NO :" + HSNO);
				Wait.waitfor(4);
				clickElement(driver, test, "//button[@id='slctBtn']", "Click on Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to Primary Hs No");
				clickElement(driver, test, OCR_ESItem_Close, "click on Close");
			}
		}
		scrollToElement(driver, OCR_ESItem_SoldToParty);
		typeText(driver, test, "//input[@id='editImport7501ItemDetails_primaryQty']", "Enter the primary Qty : ",
				PrimaryQty1);
		typeText(driver, test, "//input[@id='editImport7501ItemDetails_primaryEntVal']", "Enter the primary Value ",
				PrimaryValue);
		scrollToElement(driver, OCR_ESItem_SaveBtn);
		clickElement(driver, test, OCR_ESItem_SaveBtn, "click on save");
	}

	// Add the Invoice Quantity & Price
	public void addInvoiceQuantityPrice(String InvoiceValue, String InvoiceQtyUOM, String ItemValue, String Charges,
			String EnteredValue, String DutyAmount, String ApplicableAssistValue) {
		Wait.waitfor(5);
		scrollToElement(driver, OCR_ESItem_Primary);
		Wait.waitfor(3);
		clearText(driver, test, OCR_ESItem_InvoiceValue, "Clear the Invoice Value");
		typeText(driver, test, OCR_ESItem_InvoiceValue, "Enter the Invoice Value : ", InvoiceValue);
		typeText(driver, test, OCR_ESItem_InvoiceQtyUOM, "Enter the Invoice Qty UOM : ", InvoiceQtyUOM);
		typeText(driver, test, OCR_ESItem_ItemValue, "Enter the Item Value : ", ItemValue);
		typeText(driver, test, OCR_ESItem_Charges, "Enter the Charges : ", Charges);
		typeText(driver, test, OCR_ESItem_EnteredValue, "Enter the Entered Value : ", EnteredValue);
		typeText(driver, test, OCR_ESItem_DutyAmount, "Enter the Duty Amount :", DutyAmount);
		typeText(driver, test, OCR_ESItem_ApplicableAssistValue, "Enter the Applicable Assist Value :",
				ApplicableAssistValue);
		scrollToElement(driver, OCR_ESItem_SaveBtn);
		clickElement(driver, test, OCR_ESItem_SaveAndReturnBtn, "click on save & return");
	}

	// Click on Save
	public void clickSave() {
		Wait.waitfor(3);
		clickElement(driver, test,OCR_ESItem_SupplierPartNo , "Click on outside in page ");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_ESItem_SaveBtn, "Click on Save");
	}

	// Click on Save And Return
	public void clickSaveSaveAndReturn() {
		Wait.waitfor(3);
		clickElement(driver, test,OCR_ESItem_SupplierPartNo , "Click on outside in page ");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_ESItem_SaveAndReturnBtn, "Click on Save And Return");
	}

	// Click on Save
	public void clickEntrySummaryDetailTab() {
		clickElement(driver, test, "//a[contains(text(),'Entry Summary Details')]",
				"Click on Entry Summary Detail Tab");
	}

	// Click on Add item
	public void clickAddItem() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_ESItem_AddItems, "Click on Add Item");
	}

	// Click on Go button
	public void clickGO() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_ESItem_GoBtn, "Click on GO Button");
	}

	// Click on Bill of lading button
	public void clickBillofLading() {
		Wait.waitfor(3);
		scrollToElement(driver, OCR_ESItem_BOL_Tab);
		clickElement(driver, test, OCR_ESItem_BOL_Tab, "Click on  Bill of Lading tab");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_ESItem_BillofLading, "Click on  Bill of Lading Button");
	}

	// Click on Refresh Value button
	public void clickRefreshValue(String ManifestUOM) {
		Wait.waitfor(5);
		scrollToElement(driver, OCR_ESItem_RefreshValue);
		clickElement(driver, test, OCR_ESItem_RefreshValue, "Click on Refresh Value Button");
		Wait.waitfor(3);
		typeText(driver, test, OCR_ESItem_ManifestUOM, "Add ManifestUOM : ", ManifestUOM);
		Wait.waitfor(3);
		scrollToElement(driver, OCR_ESItem_SaveBtn);
		clickElement(driver, test, OCR_ESItem_SaveBtn, "Click on Save");

	}

	// Click on Alert Pop up Close
	public void alertClose() {
		Wait.waitfor(5);
		clickElement(driver, test, OCR_ESItem_CloseAlert, "Click Alert Popup Close");
	}

	// Validation for BOL Details
	public void validationCBillOfLadingDeatils() {
		try {
			if (isDisplayed(driver,
					"//table[@class='table table-condensed table-bordered']//td[contains(text(),'There must be at-least one Bill of Lading record p')]")) {
				test.log(LogStatus.INFO, "There must be at-least one Bill of Lading record Present");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Error is not Displayed by clicking on Alert Icon for Entry Summary");
			alertClose();
		}
	}

	// Validation for ManifestUOM
	public void validationManifestUOM() {
		try {
			if (isDisplayed(driver,
					"//table[@class='table table-condensed table-bordered']//td[contains(text(),'required for this Mode O')]")) {
				test.log(LogStatus.INFO, "Manifest Quantity/UOM is required for this Mode Of Transport 10");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Error is not Displayed by clicking on Alert Icon for Entry Summary");
			alertClose();
		}
	}

	// Validation for HS number
	public void validationHsNo() {
		try {
			if (isDisplayed(driver, "//h4[contains(text(),'Error!')]")) {
				if (isDisplayed(driver, "//li[contains(text(),'Primary HS Required')]")) {
					test.log(LogStatus.INFO, "Primary HS Required");
				}
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Error is not Displayed by clicking on SAVE button");
		}
	}

	// Validation for HS Qty 1
	public void validationHsQty1() {
		try {
			if (isDisplayed(driver, "//h4[contains(text(),'Error!')]")) {
				if (isDisplayed(driver, "//span[contains(text(),'Primary HTS Quantity1 is required.')]")) {
					test.log(LogStatus.INFO, "Primary HTS Quantity1 is required.");
				}
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL,
					"Error is not Displayed by clicking on SAVE button in Item Details for Entry Summary Details");
		}
	}

	// Validation for total duty and value
	public void validationTotalValueDty() {
		try {
			if (isDisplayed(driver,
					"//table[@class='table table-condensed table-bordered']//td[contains(text(),'Total Duty is required')]")) {
				test.log(LogStatus.INFO, "Total Duty is required");
			}
			if (isDisplayed(driver,
					"//table[@class='table table-condensed table-bordered']//td[contains(text(),'Total Entered Value is required')]")) {
				test.log(LogStatus.INFO, "Total Entered Value is required");
			}
			if (isDisplayed(driver,
					"//table[@class='table table-condensed table-bordered']//td[contains(text(),'Entered Value for Primary HS is Missing')]")) {
				test.log(LogStatus.INFO, "Entered Value for Primary HS is Missing");
			}
			if (isDisplayed(driver,
					"//table[@class='table table-condensed table-bordered']//td[contains(text(),'Fees Amount should be required')]")) {
				test.log(LogStatus.INFO, "Fees Amount should be required");
			}
			if (isDisplayed(driver,
					"//table[@class='table table-condensed table-bordered']//td[contains(text(),'Country of Origin is Missing')]")) {
				test.log(LogStatus.INFO, "Country of Origin is Missing");
			}

		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Error is not Displayed for total duty and value in Entry Summary Details");
		}
	}

	// Click on Item No
	public void clickItemNo(String CountryofOrigin) {
		Wait.waitfor(3);
		clickElement(driver, test, "//tbody/tr[@id='1']/td[6]", "Click on Item number");
		typeText(driver, test, OCR_ESItem_CountryOfOrigin, "Enter the Country of Origin : ", CountryofOrigin);
	}

}
