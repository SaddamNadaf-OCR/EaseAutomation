package lpreports;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class ProductReportPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_SearchProductReport_SBUCode = "//select[@id='resultProductTableReport_product_sbuCode']";
	public static final String OCR_SearchProductReport_Status = "//select[@id='resultProductTableReport_product_status']";
	public static final String OCR_SearchProductReport_PartNo = "//input[@id='resultProductTableReport_product_productCode']";
	public static final String OCR_SearchProductReport_SKUNo = "//input[@id='resultProductTableReport_product_skuNo']";
	public static final String OCR_SearchProductReport_ManufPartNo = "//input[@id='resultProductTableReport_partNoManuPartNoNSNModel']";
	public static final String OCR_SearchProductReport_SourceSysPartNo = "//input[@id='resultProductTableReport_product_sourceProductId']";
	public static final String OCR_SearchProductReport_Description = "//input[@id='resultProductTableReport_product_productDesc']";
	public static final String OCR_SearchProductReport_ModelNo = "//input[@id='resultProductTableReport_product_modelNo']";
	public static final String OCR_SearchProductReport_ProductName = "//input[@id='resultProductTableReport_product_productName']";
	public static final String OCR_SearchProductReport_MaterialType = "//input[@id='resultProductTableReport_product_bomType']";
	public static final String OCR_SearchProductReport_ProductLineLink = "//a[contains(text(),'Product Line')]";
	public static final String OCR_SearchProductReport_ProductLineSelect = "(//button[contains(text(),'Select')])[1]";
	public static final String OCR_SearchProductReport_ProductLineCancel = "(//button[contains(text(),'Cancel')])[1]";
	public static final String OCR_SearchProductReport_ProgramLink = "//fieldset//a[contains(text(),'Program')]";
	public static final String OCR_SearchProductReport_ProgramCode = "//input[@id='searchForm_programTab_programCode']";
	public static final String OCR_SearchProductReport_SearchButton = "//button[@name='Search']";
	public static final String OCR_SearchProductReport_ProgramCodeCancel = "(//button[contains(text(),'Cancel')])[2]";
	public static final String OCR_SearchProductReport_SiteLink = "//a[contains(text(),'Site')]";
	public static final String OCR_SearchProductReport_SiteName = "//input[@id='dosSitePopupForm_dosSite_siteName']";
	public static final String OCR_SearchProductReport_Hazardous = "//select[@id='resultProductTableReport_product_hazardous']";
	public static final String OCR_SearchProductReport_FlagreasonLink = "//label[@class='col-xs-2 control-label']//a[contains(text(),'Flag Reason')]";
	public static final String OCR_SearchProductReport_FlagReasonCode = "//input[@id='flagReasonPopupForm_flagReason_reasonCode']";
	public static final String OCR_SearchProductReport_NationalStockNo = "//input[@id='resultProductTableReport_product_nationalStockNumber']";
	public static final String OCR_SearchProductReport_ProductAuditSearchCreatedByLink = "//fieldset//a[contains(text(),'Created By')]";
	public static final String OCR_SearchProductReport_CreatedByUsername = "//input[@id='searchForm_userProfile_username']";
	public static final String OCR_SearchProductReport_ProductAuditSearchCreatedDateFrom = "//input[@id='resultProductTableReport_fromPrdCrdOn']";
	public static final String OCR_SearchProductReport_ProductAuditSearchCreatedDateTo = "//input[@id='resultProductTableReport_toPrdCrdOn']";
	public static final String OCR_SearchProductReport_ProductAuditSearchModifiedByLink = "//fieldset//a[contains(text(),'Modified By')]";
	public static final String OCR_SearchProductReport_ProductAuditSearchModifiedDateFrom = "//input[@id='resultProductTableReport_fromPrdMfdOn']";
	public static final String OCR_SearchProductReport_ProductAuditSearchModifiedDateTo = "//input[@id='resultProductTableReport_toPrdMfdOn']";
	public static final String OCR_SearchProductReport_SortBy = "//select[@name='sortBy']";
	public static final String OCR_SearchProductReport_Direction = "//select[@name='direction']";
	public static final String OCR_SearchManufacturerReport_ManufacturerLink = "//label[@class='col-xs-2 control-label']//a[contains(text(),'Manufacturer')]";
	public static final String OCR_SearchManufacturerReport_ManufacturerUserName = "//input[@id='searchForm_userDTO_userName']";
	public static final String OCR_SearchManufacturerReport_DomesticForeign = "//select[@id='resultProductTableReport_product_domesticForeign']";
	public static final String OCR_SearchManufacturerReport_CountryOfOrgin = "//input[@id='resultProductTableReport_countryMfgName']";
	public static final String OCR_SearchManufacturerReport_ManfPartNo = "//input[@id='resultProductTableReport_productMfg_mfgPartNo']";
	public static final String OCR_SearchManufacturerReport_TradeProgramSPILink = "//a[contains(text(),'Trade Program SPI')]";
	public static final String OCR_SearchManufacturerReport_SpecialProgram = "//input[@id='resultProductFtaGspProgram_productFtaGspProgramValue_specialProgName']";
	public static final String OCR_SearchManufacturerReport_CreatedByLink = "//div[@id='searchCriteria-Mfg-details']//a[contains(text(),'Created By')]";
	public static final String OCR_SearchManufacturerReport_CreatedByUser = "//input[@id='searchForm_userProfile_username']";
	public static final String OCR_SearchManufacturerReport_CreatedDateFrom = "//input[@id='resultProductTableReport_fromManuFtrCrdOn']";
	public static final String OCR_SearchManufacturerReport_CreatedDateTo = "//input[@id='resultProductTableReport_toManuFtrCrdOn']";
	public static final String OCR_SearchManufacturerReport_ModifiedByLink = "//div[@id='searchCriteria-Mfg-details']//a[contains(text(),'Modified By')]";
	public static final String OCR_SearchManufacturerReport_ModifiedByUser = "//input[@id='searchForm_userProfile_username']";
	public static final String OCR_SearchManufacturerReport_ModifiedDateFrom = "//input[@id='resultProductTableReport_fromManuFtrMfdOn']";
	public static final String OCR_SearchManufacturerReport_ModifiedDateTo = "//input[@id='resultProductTableReport_toManuFtrMfdOn']";
	public static final String OCR_SearchExportClassificationReport_CountryofClassification = "//input[@id='resultProductTableReport_countryExpClsName']";
	public static final String OCR_SearchExportClassificationReport_ExportClassificationLink = "//a[@id='expClsLnk']";
	public static final String OCR_SearchExportClassificationReport_ExportClassificationNo = "//input[@id='searchForm_ukItemsDTO_prodClassification']";
	public static final String OCR_SearchExportClassificationReport_ECRReviewCompleted = "//select[@name='ecrreviewcompleted']";
	public static final String OCR_SearchExportClassificationReport_ATFForm9Required = "//select[@id='resultProductTableReport_product_batf']";
	public static final String OCR_SearchExportClassificationReport_Sme = "//select[@name='sme']";
	public static final String OCR_SearchExportClassificationReport_TechDataReferenceNumber = "//input[@id='resultProductTableReport_techDataRefNumber']";
	public static final String OCR_SearchExportClassificationReport_AssociatedExportClassificationLink = "//a[@id='assClsLnk']";
	public static final String OCR_SearchExportClassificationReport_EccnUsml = "//input[@id='searchForm_productClazz_prodClassification']";
	public static final String OCR_SearchExportClassificationReport_SelectCountry = "//input[@id='addClassTypePopupFormId_countryName']";
	public static final String OCR_SearchExportClassificationReport_Proceed = "//button[@name='proceed']";
	public static final String OCR_SearchExportClassificationReport_CreatedByLink = "//div[@id='searchCriteria-ExpCls-details']//a[contains(text(),'Created By')]";
	public static final String OCR_SearchExportClassificationReport_CreatedByUser = "//input[@id='searchForm_userProfile_username']";
	public static final String OCR_SearchExportClassificationReport_FromCreatedDate = "//input[@id='resultProductTableReport_frmExpClsCreatedOn']";
	public static final String OCR_SearchExportClassificationReport_ToCreatedDate = "//input[@id='resultProductTableReport_toExpClsCreatedOn']";
	public static final String OCR_SearchExportClassificationReport_ModifiedByLink = "//div[@id='searchCriteria-ExpCls-details']//a[contains(text(),'Modified By')]";
	public static final String OCR_SearchExportClassificationReport_ModifiedByUser = "//input[@id='searchForm_userProfile_username']";
	public static final String OCR_SearchExportClassificationReport_ModifiedDateFrom = "//input[@id='resultProductTableReport_frmExpClsModifiedOn']";
	public static final String OCR_SearchExportClassificationReport_ModifiedDateTo = "//input[@id='resultProductTableReport_toExpClsModifiedOn']";
	public static final String OCR_SearchCustomsClassificationReport_CountryofClassification = "//input[@id='resultProductTableReport_ctryCustmClsName']";
	public static final String OCR_SearchCustomsClassificationReport_ImportClassificationLink = "//a[@id='htsNoLnk']";
	public static final String OCR_SearchCustomsClassificationReport_HSCodeSearch = "//button[@id='searchHsDtlBtn']";
	public static final String OCR_SearchCustomsClassificationReport_HSNo = "//input[@id='hsNo_resultStdHsPopup']";
	public static final String OCR_SearchCustomsClassificationReport_HSNoSearch = "//button[@id='searchHsDtlBtn']";
	public static final String OCR_SearchCustomsClassificationReport_HSNoSelect = "//button[@id='slctBtn']";
	public static final String OCR_SearchCustomsClassificationReport_ConfidenceLevel = "//select[@name='levelCode']";
	public static final String OCR_SearchCustomsClassificationReport_ScheduleBNoLink = "//a[@id='schedulebLink']";
	public static final String OCR_SearchCustomsClassificationReport_CustomHTSNo = "//input[@id='searchForm_schbhtsNo']";
	public static final String OCR_SearchCustomsClassificationReport_HTSSearch = "//button[@class='primary-btn popupSearchButton']";
	public static final String OCR_SearchCustomsClassificationReport_CreatedByLink = "//div[@id='searchCriteria-CustmCls-details']//a[contains(text(),'Created By')]";
	public static final String OCR_SearchCustomsClassificationReport_CustomUser = "//input[@id='searchForm_userProfile_username']";
	public static final String OCR_SearchCustomsClassificationReport_FromCreatedBy = "//input[@id='resultProductTableReport_frmCustClsCreatedOn']";
	public static final String OCR_SearchCustomsClassificationReport_ToCreatedBy = "//input[@id='resultProductTableReport_toCustClsCreatedOn']";
	public static final String OCR_SearchCustomsClassificationReport_ModifiedByLink = "//div[@id='searchCriteria-CustmCls-details']//a[contains(text(),'Modified By')]";
	public static final String OCR_SearchCustomsClassificationReport_ModifiedUser = "//input[@id='searchForm_userProfile_username']";
	public static final String OCR_SearchCustomsClassificationReport_FromModifiedDate = "//input[@id='resultProductTableReport_frmCustClsModifiedOn']";
	public static final String OCR_SearchCustomsClassificationReport_ToModifiedDate = "//input[@id='resultProductTableReport_toCustClsModifiedOn']";
	public static final String OCR_SearchAdditionalInformationReport_Classification = "//input[@name='6_CUSTOMFIELD']";
	public static final String OCR_SearchAdditionalInformationReport_DrawingNumber = "//input[@name='8_CUSTOMFIELD']";
	public static final String OCR_SearchAdditionalInformationReport_Test = "//input[@name='30_CUSTOMFIELD']";
	public static final String OCR_ProductReportSearchButton = "(//button[contains(text(),'Search')])[1]";
	public static final String OCR_HeaderSearchManufacturer = "//label[contains(text(),'Search Manufacturer')]";
	public static final String OCR_HeaderSearchExportClassification = "//label[contains(text(),'Search Export Classification')]";
	public static final String OCR_HeaderSearchCustomsClassification = "//label[contains(text(),'Search Customs Classification')]";
	public static final String OCR_HeaderAdditionalInformation = "//label[contains(text(),'Additional Information')]";
	public static final String OCR_AddProduct = "//button[contains(text(),'Add Product')]";
	public static final String OCR_POPupClose = "//div[@id='ocrModal']//button[@class='close']";
	public static final String OCR_RequiredByDate_Today = "//button[contains(text(),'Today')]";

	/* ******************** Constructor ***************************** */
	public ProductReportPage(WebDriver driver, ExtentTest test) {

		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	// Enter Search Products
	public void searchProductDetails(String SBUCode, String Status, String PartNo, String SKUNo,
			String ManufacturerPartNo, String SourceSystemPartNo, String Description, String ModelNo,
			String ProductName, String MaterialType, String ProductLineName, String ProgramCode, String SiteName,
			String Hazardous, String FlagReasonCode, String NationalStockNumber, String ProductCreatedByUser,
			String ProductCreatedDateFrom, String ProductCreatedDateTo, String ProductModifiedByUser,
			String ProductModifiedDateFrom, String ProductModifiedDateTo, String SortBy, String Direction)
			throws InterruptedException {

		selectByVisibleText(driver, test, OCR_SearchProductReport_SBUCode, "Select Sbu Code :", SBUCode);
		selectByVisibleText(driver, test, OCR_SearchProductReport_Status, "Select Status :", Status);
		Wait.waitfor(3);
		typeText(driver, test, OCR_SearchProductReport_PartNo, "Enter Part No :", PartNo);
		typeText(driver, test, OCR_SearchProductReport_SKUNo, "Enter SKU No :", SKUNo);
		typeText(driver, test, OCR_SearchProductReport_ManufPartNo, "Enter Manufacturer PartNo :", ManufacturerPartNo);
		typeText(driver, test, OCR_SearchProductReport_SourceSysPartNo, "Enter Source System PartNo :",
				SourceSystemPartNo);
		typeText(driver, test, OCR_SearchProductReport_Description, "Enter Description :", Description);
		typeText(driver, test, OCR_SearchProductReport_ModelNo, "Enter ModelNo :", ModelNo);
		typeText(driver, test, OCR_SearchProductReport_ProductName, "Enter ProductName :", ProductName);
		typeText(driver, test, OCR_SearchProductReport_MaterialType, "Enter MaterialType :", MaterialType);

		if (ProductLineName.length() > 0) {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_SearchProductReport_ProductLineLink, "Click Product Line Link");
			try {
				String prodlinename = "//td[contains(text(),'" + ProductLineName + "')]";
				clickElement(driver, test, prodlinename, "Click Product line name :" + ProductLineName);
				clickElement(driver, test, OCR_SearchProductReport_ProductLineSelect,
						"Click Product Line Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add the product Lines");
				clickElement(driver, test, OCR_SearchProductReport_ProductLineCancel, "Close the Pop UP");
			}
		}

		if (ProgramCode.length() > 0) {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_SearchProductReport_ProgramLink, "Click Program Link");
			try {
				typeText(driver, test, OCR_SearchProductReport_ProgramCode, "Enter Program Code :", ProgramCode);
				clickElement(driver, test, OCR_SearchProductReport_SearchButton, "Click Search Button");
				String progcode = "//td[contains(text(),'" + ProgramCode + "')]";
				clickElement(driver, test, progcode, "Click Product Code :" + ProgramCode);
				clickElement(driver, test, OCR_SearchProductReport_ProductLineSelect, "Click Program Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add the product code");
				clickElement(driver, test, OCR_SearchProductReport_ProgramCodeCancel, "Close the Pop UP");
			}
		}

		if (SiteName.length() > 0) {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_SearchProductReport_SiteLink, "Click Site Link");
			try {
				typeText(driver, test, OCR_SearchProductReport_SiteName, "Enter Site Name :", SiteName);
				clickElement(driver, test, OCR_SearchProductReport_SearchButton, "Click Search Button");
				String siteName = "//td[contains(text(),'" + SiteName + "')]";
				clickElement(driver, test, siteName, "Click Site Name :" + SiteName);
				clickElement(driver, test, OCR_SearchProductReport_ProductLineSelect, "Click Program Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add the Site ");
				clickElement(driver, test, OCR_SearchProductReport_ProgramCodeCancel, "Close the Pop UP");
			}
		}

		selectByVisibleText(driver, test, OCR_SearchProductReport_Hazardous, "Select Hazardous :", Hazardous);

		if (FlagReasonCode.length() > 0) {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_SearchProductReport_FlagreasonLink, "Click Flag Reason");
			try {
				typeText(driver, test, OCR_SearchProductReport_FlagReasonCode, "Enter Flag Reason Code :",
						FlagReasonCode);
				clickElement(driver, test, OCR_SearchProductReport_SearchButton, "Click Search Button");
				String reasonCode = "//td[contains(text(),'" + FlagReasonCode + "')]";
				clickElement(driver, test, reasonCode, "Click Flag Reason Code :" + FlagReasonCode);
				clickElement(driver, test, OCR_SearchProductReport_ProductLineSelect, "Click Program Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add the Flag Reason Code");
				clickElement(driver, test, OCR_SearchProductReport_ProgramCodeCancel, "Close the Pop UP");
			}
		}

		typeText(driver, test, OCR_SearchProductReport_NationalStockNo, "Enter National Stock No :",
				NationalStockNumber);

		if (ProductCreatedByUser.length() > 0) {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_SearchProductReport_ProductAuditSearchCreatedByLink, "Click Created By");
			try {
				typeText(driver, test, OCR_SearchProductReport_CreatedByUsername, "Enter CreatedBy Username :",
						ProductCreatedByUser);
				clickElement(driver, test, OCR_SearchProductReport_SearchButton, "Click Search Button");
				String user = "//td[contains(text(),'" + ProductCreatedByUser + "')]";
				clickElement(driver, test, user, "Click Created User :" + ProductCreatedByUser);
				clickElement(driver, test, OCR_SearchProductReport_ProductLineSelect, "Click Program Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add the Created By User");
				clickElement(driver, test, OCR_SearchProductReport_ProgramCodeCancel, "Close the Pop UP");
			}
		}
		if(ProductCreatedDateFrom.length() > 0) {
			clickElement(driver, test, OCR_SearchProductReport_ProductAuditSearchCreatedDateFrom, "Clicking on Product Created Date From");
			if (ProductCreatedDateFrom.contains("Today")) {
				clickElement(driver, test, OCR_RequiredByDate_Today, "Clicking on Today: ");
				} else {
					dateOfMonthName(driver, test, "Selecting the Product Created Date From : ", ProductCreatedDateFrom);
				}
		}
		if(ProductCreatedDateTo.length() > 0) {
			clickElement(driver, test, OCR_SearchProductReport_ProductAuditSearchCreatedDateTo, "Clicking on Product Created Date To");
			if (ProductCreatedDateTo.contains("Today")) {
				clickElement(driver, test, OCR_RequiredByDate_Today, "Clicking on Today: ");
				} else {
					dateOfMonthName(driver, test, "Selecting the Product Created Date To : ", ProductCreatedDateTo);
				}
		}
		if (ProductModifiedByUser.length() > 0) {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_SearchProductReport_ProductAuditSearchModifiedByLink, "Click Modified By");
			try {
				typeText(driver, test, OCR_SearchProductReport_CreatedByUsername, "Enter CreatedBy Username :",
						ProductModifiedByUser);
				clickElement(driver, test, OCR_SearchProductReport_SearchButton, "Click Search Button");
				String modifiedUser = "//td[contains(text(),'" + ProductModifiedByUser + "')]";
				clickElement(driver, test, modifiedUser, "Click Modified User :" + ProductModifiedByUser);
				clickElement(driver, test, OCR_SearchProductReport_ProductLineSelect, "Click Program Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add the Modified By User");
				clickElement(driver, test, OCR_SearchProductReport_ProgramCodeCancel, "Close the Pop UP");
			}
		}
		if(ProductModifiedDateFrom.length() > 0) {
			clickElement(driver, test, OCR_SearchProductReport_ProductAuditSearchModifiedDateFrom, "Clicking on Product Modified Date From");
			if (ProductModifiedDateFrom.contains("Today")) {
				clickElement(driver, test, OCR_RequiredByDate_Today, "Clicking on Today: ");
				} else {
					dateOfMonthName(driver, test, "Selecting the Product Modified Date From : ", ProductModifiedDateFrom);
				}
		}
		if(ProductModifiedDateTo.length() > 0) {
			clickElement(driver, test, OCR_SearchProductReport_ProductAuditSearchModifiedDateTo, "Clicking on Product Modified Date To");
			if (ProductModifiedDateTo.contains("Today")) {
				clickElement(driver, test, OCR_RequiredByDate_Today, "Clicking on Today: ");
				} else {
					dateOfMonthName(driver, test, "Selecting the Product Modified Date To : ", ProductModifiedDateTo);
				}
		}
		selectByVisibleText(driver, test, OCR_SearchProductReport_SortBy, "Select Sort By :", SortBy);
		selectByVisibleText(driver, test, OCR_SearchProductReport_Direction, "Select Direction :", Direction);
	}
	
	// Enter Search Products
		public void searchProductDetails(String SBUCode, String Status, String PartNo, String SKUNo,
				String ManufacturerPartNo) throws InterruptedException {

			selectByVisibleText(driver, test, OCR_SearchProductReport_SBUCode, "Select Sbu Code :", SBUCode);
			selectByVisibleText(driver, test, OCR_SearchProductReport_Status, "Select Status :", Status);
			Wait.waitfor(3);
			typeText(driver, test, OCR_SearchProductReport_PartNo, "Enter Part No :", PartNo);
			typeText(driver, test, OCR_SearchProductReport_SKUNo, "Enter SKU No :", SKUNo);
			typeText(driver, test, OCR_SearchProductReport_ManufPartNo, "Enter Manufacturer PartNo :", ManufacturerPartNo);
			
		}

	public void searchManufacturerDetails(String ManufacturerUserName, String DomesticForeign, String CountryOfOrigin,
			String ManfPartNo, String SpecialTradeProgramName, String ManufacturerCreatedByUser,
			String ManufacturerCreatedDateFrom, String ManufacturerCreatedDateTo, String ManufacturerModifiedByUser,
			String ManufacturerModifiedDateFrom, String ManufacturerModifiedDateTo) throws InterruptedException {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_HeaderSearchManufacturer, "Click Header Search Manufacturer");
		Wait.waitfor(2);
		if (ManufacturerUserName.length() > 0) {
			clickElement(driver, test, OCR_SearchManufacturerReport_ManufacturerLink, "Click on Manufacturer Link");
			try {
				typeText(driver, test, OCR_SearchManufacturerReport_ManufacturerUserName,
						"Enter Manufacturer UserName :", ManufacturerUserName);
				clickElement(driver, test, OCR_SearchProductReport_SearchButton, "Click Search Button");
				String manufactureruser = "//div[contains(text(),'" + ManufacturerUserName + "')]";
				clickElement(driver, test, manufactureruser, "Click Manufacturer User :" + ManufacturerUserName);
				clickElement(driver, test, OCR_SearchProductReport_ProductLineSelect, "Click Program Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add the Manufacturer");
				clickElement(driver, test, OCR_SearchProductReport_ProgramCodeCancel, "Close the Pop UP");
			}
		}

		selectByVisibleText(driver, test, OCR_SearchManufacturerReport_DomesticForeign, "Select Domestic/Foreign :",
				DomesticForeign);
		typeText(driver, test, OCR_SearchManufacturerReport_CountryOfOrgin, "Enter Country Of Orgin :",
				CountryOfOrigin);
		typeText(driver, test, OCR_SearchManufacturerReport_ManfPartNo, "Enter Manf Part No :", ManfPartNo);

		if (SpecialTradeProgramName.length() > 0) {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_SearchManufacturerReport_TradeProgramSPILink, "Click on Trade Program SPI");
			try {
				typeText(driver, test, OCR_SearchManufacturerReport_SpecialProgram, "Enter Special Program Name :",
						SpecialTradeProgramName);
				clickElement(driver, test, OCR_SearchProductReport_SearchButton, "Click Search Button");
				String tradeProgName = "//td[contains(text(),'" + SpecialTradeProgramName + "')]";
				clickElement(driver, test, tradeProgName,
						"Click Special Trade Program Name :" + SpecialTradeProgramName);
				clickElement(driver, test, OCR_SearchProductReport_ProductLineSelect, "Click Program Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add the Special Trade Program");
				clickElement(driver, test, OCR_SearchProductReport_ProgramCodeCancel, "Close the Pop UP");
			}
		}

		if (ManufacturerCreatedByUser.length() > 0) {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_SearchManufacturerReport_CreatedByLink, "Click Created By");
			try {
				typeText(driver, test, OCR_SearchManufacturerReport_CreatedByUser, "Enter CreatedBy Username :",
						ManufacturerCreatedByUser);
				clickElement(driver, test, OCR_SearchProductReport_SearchButton, "Click Search Button");
				String manfuser = "//td[contains(text(),'" + ManufacturerCreatedByUser + "')]";
				clickElement(driver, test, manfuser, "Click Manufacturer Created User :" + ManufacturerCreatedByUser);
				clickElement(driver, test, OCR_SearchProductReport_ProductLineSelect, "Click Program Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add the Manufacturer Created By User");
				clickElement(driver, test, OCR_SearchProductReport_ProgramCodeCancel, "Close the Pop UP");
			}
		}
		if(ManufacturerCreatedDateFrom.length() > 0) {
			clickElement(driver, test, OCR_SearchManufacturerReport_CreatedDateFrom, "Clicking on Manufacturer Created Date From");
			if (ManufacturerCreatedDateFrom.contains("Today")) {
				clickElement(driver, test, OCR_RequiredByDate_Today, "Clicking on Today: ");
				} else {
					dateOfMonthName(driver, test, "Selecting the Manufacturer Created Date From : ", ManufacturerCreatedDateFrom);
				}
		}
		if(ManufacturerCreatedDateTo.length() > 0) {
			clickElement(driver, test, OCR_SearchManufacturerReport_CreatedDateTo, "Clicking on Manufacturer Created Date To");
			if (ManufacturerCreatedDateTo.contains("Today")) {
				clickElement(driver, test, OCR_RequiredByDate_Today, "Clicking on Today: ");
				} else {
					dateOfMonthName(driver, test, "Selecting the Manufacturer Created Date To : ", ManufacturerCreatedDateTo);
				}
		}
		if (ManufacturerModifiedByUser.length() > 0) {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_SearchManufacturerReport_ModifiedByLink, "Click Modified By");
			try {
				typeText(driver, test, OCR_SearchManufacturerReport_ModifiedByUser, "Enter ModifiedBy Username :",
						ManufacturerModifiedByUser);
				clickElement(driver, test, OCR_SearchProductReport_SearchButton, "Click Search Button");
				String manfmodifiedUser = "//td[contains(text(),'" + ManufacturerModifiedByUser + "')]";
				clickElement(driver, test, manfmodifiedUser, "Click Modified User :" + ManufacturerModifiedByUser);
				clickElement(driver, test, OCR_SearchProductReport_ProductLineSelect, "Click Program Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add the Manufacturer Modified By User");
				clickElement(driver, test, OCR_SearchProductReport_ProgramCodeCancel, "Close the Pop UP");
			}
		}
		if(ManufacturerModifiedDateFrom.length() > 0) {
			clickElement(driver, test, OCR_SearchManufacturerReport_ModifiedDateFrom, "Clicking on Manufacturer Modified Date From");
			if (ManufacturerModifiedDateFrom.contains("Today")) {
				clickElement(driver, test, OCR_RequiredByDate_Today, "Clicking on Today: ");
				} else {
					dateOfMonthName(driver, test, "Selecting the Manufacturer Modified Date From : ", ManufacturerModifiedDateFrom);
				}
		}
		if(ManufacturerModifiedDateTo.length() > 0) {
			clickElement(driver, test, OCR_SearchManufacturerReport_ModifiedDateTo, "Clicking on Manufacturer Modified Date To");
			if (ManufacturerModifiedDateTo.contains("Today")) {
				clickElement(driver, test, OCR_RequiredByDate_Today, "Clicking on Today: ");
				} else {
					dateOfMonthName(driver, test, "Selecting the Manufacturer Modified Date To : ", ManufacturerModifiedDateTo);
				}
		}
		Wait.waitfor(3);
	}

	public void searchExportClassification(String ExportCountryOfClassification, String ExportProductClassification,
			String TechDataReferenceNumber, String AssociatedProductClassification, String ExportCreatedByUser,
			String ExportCreatedDateFrom, String ExportCreatedDateTo, String ExportModifiedByUser,
			String ExportModifiedDateFrom, String ExportModifiedDateTo) throws InterruptedException, Exception {

		clickElement(driver, test, OCR_HeaderSearchExportClassification, "Click Header Export Classification");
		Wait.waitfor(2);
		scrollToElement(driver, OCR_HeaderSearchCustomsClassification);
		Wait.waitfor(3);

		if (ExportCountryOfClassification.length() > 0) {
			typeText(driver, test, OCR_SearchExportClassificationReport_CountryofClassification,
					"Enter Country of Classification :", ExportCountryOfClassification);
			Wait.waitfor(2);
			String country = "//div[contains(text(),'" + ExportCountryOfClassification + "')]";
			clickElement(driver, test, country, "Click on country : " + country);

			if (ExportProductClassification.length() > 0) {
				clickElement(driver, test, OCR_SearchExportClassificationReport_ExportClassificationLink,
						"Click on Export Classification");
				try {
					typeText(driver, test, OCR_SearchExportClassificationReport_ExportClassificationNo,
							"Enter Export Classification No :", ExportProductClassification);
					clickElement(driver, test, OCR_SearchProductReport_SearchButton, "Click Search Button");
					String prodclassification = "//td[contains(text(),'" + ExportProductClassification + "')]";
					clickElement(driver, test, prodclassification,
							"Click Product Classification :" + ExportProductClassification);
					clickElement(driver, test, OCR_SearchProductReport_ProductLineSelect,
							"Click Program Select button");
				} catch (Exception e) {
					testFailSshot(driver, test);
					test.log(LogStatus.FAIL, "Fail to add the Export Product Classification");
					clickElement(driver, test, OCR_SearchProductReport_ProgramCodeCancel, "Close the Pop UP");
				}
			}
			typeText(driver, test, OCR_SearchExportClassificationReport_TechDataReferenceNumber,
					"Enter Tech Data Reference Number :", TechDataReferenceNumber);

			if (AssociatedProductClassification.length() > 0) {
				clickElement(driver, test, OCR_SearchExportClassificationReport_AssociatedExportClassificationLink,
						"Click on AssociatedExportClassification");
				try {
					clickElement(driver, test, OCR_SearchExportClassificationReport_Proceed, "Click Proceed Button");
					Wait.waitfor(1);
					typeText(driver, test, OCR_SearchExportClassificationReport_EccnUsml,
							"Enter Associated Product EccnUsml No :", AssociatedProductClassification);
					clickElement(driver, test, OCR_SearchProductReport_SearchButton, "Click Search Button");
					String associateprodclassification = "//td[contains(text(),'" + AssociatedProductClassification
							+ "')]";
					clickElement(driver, test, associateprodclassification,
							"Click Associated Product Classification Name :" + AssociatedProductClassification);
					clickElement(driver, test, OCR_SearchProductReport_ProductLineSelect,
							"Click Program Select button");
				} catch (Exception e) {
					testFailSshot(driver, test);
					test.log(LogStatus.FAIL, "Fail to add the Associated Product Classification");
					clickElement(driver, test, OCR_SearchProductReport_ProgramCodeCancel, "Close the Pop UP");
				}
			}

			if (ExportCreatedByUser.length() > 0) {
				clickElement(driver, test, OCR_SearchExportClassificationReport_CreatedByLink, "Click Created By");
				try {
					typeText(driver, test, OCR_SearchExportClassificationReport_CreatedByUser,
							"Enter CreatedBy Username :", ExportCreatedByUser);
					clickElement(driver, test, OCR_SearchProductReport_SearchButton, "Click Search Button");
					String exportuser = "//td[contains(text(),'" + ExportCreatedByUser + "')]";
					clickElement(driver, test, exportuser, "Click Export Created User :" + ExportCreatedByUser);
					clickElement(driver, test, OCR_SearchProductReport_ProductLineSelect,
							"Click Program Select button");
				} catch (Exception e) {
					testFailSshot(driver, test);
					test.log(LogStatus.FAIL, "Fail to add the Export Created By User");
					clickElement(driver, test, OCR_SearchProductReport_ProgramCodeCancel, "Close the Pop UP");
				}
			}
			if(ExportCreatedDateFrom.length() > 0) {
				clickElement(driver, test, OCR_SearchExportClassificationReport_FromCreatedDate, "Clicking on Export Created Date From");
				if (ExportCreatedDateFrom.contains("Today")) {
					clickElement(driver, test, OCR_RequiredByDate_Today, "Clicking on Today: ");
					} else {
						dateOfMonthName(driver, test, "Selecting the Export Created Date From : ", ExportCreatedDateFrom);
					}
			}
			if(ExportCreatedDateTo.length() > 0) {
				clickElement(driver, test, OCR_SearchExportClassificationReport_ToCreatedDate, "Clicking on Export Created Date To");
				if (ExportCreatedDateTo.contains("Today")) {
					clickElement(driver, test, OCR_RequiredByDate_Today, "Clicking on Today: ");
					} else {
						dateOfMonthName(driver, test, "Selecting the Export Created Date To : ", ExportCreatedDateTo);
					}
			}
			if (ExportModifiedByUser.length() > 0) {
				clickElement(driver, test, OCR_SearchExportClassificationReport_ModifiedByLink, "Click Modified By");
				try {
					typeText(driver, test, OCR_SearchExportClassificationReport_ModifiedByUser,
							"Enter ModifiedBy Username :", ExportModifiedByUser);
					clickElement(driver, test, OCR_SearchProductReport_SearchButton, "Click Search Button");
					String exportmodifiedUser = "//td[contains(text(),'" + ExportModifiedByUser + "')]";
					clickElement(driver, test, exportmodifiedUser,
							"Click Export Modified User :" + ExportModifiedByUser);
					clickElement(driver, test, OCR_SearchProductReport_ProductLineSelect,
							"Click Program Select button");
				} catch (Exception e) {
					testFailSshot(driver, test);
					test.log(LogStatus.FAIL, "Fail to add the Export Modified By User");
					clickElement(driver, test, OCR_SearchProductReport_ProgramCodeCancel, "Close the Pop UP");
				}
			}
			if(ExportModifiedDateFrom.length() > 0) {
				clickElement(driver, test, OCR_SearchExportClassificationReport_ModifiedDateFrom, "Clicking on Export Modified Date From");
				if (ExportModifiedDateFrom.contains("Today")) {
					clickElement(driver, test, OCR_RequiredByDate_Today, "Clicking on Today: ");
					} else {
						dateOfMonthName(driver, test, "Selecting the Export Modified Date From : ", ExportModifiedDateFrom);
					}
			}
			if(ExportModifiedDateTo.length() > 0) {
				clickElement(driver, test, OCR_SearchExportClassificationReport_ModifiedDateTo, "Clicking on Export Modified Date To");
				if (ExportModifiedDateTo.contains("Today")) {
					clickElement(driver, test, OCR_RequiredByDate_Today, "Clicking on Today: ");
					} else {
						dateOfMonthName(driver, test, "Selecting the Export Modified Date To : ", ExportModifiedDateTo);
					}
			}
			Wait.waitfor(3);
		}
	}

	public void searchCustomsClassification(String CustomsCountryOfClassification, String CustomsHSNo,
			String ConfidenceLevel, String CustomCreatedByUser, String CustomCreatedDateFrom,
			String CustomCreatedDateTo, String CustomModifiedByUser, String CustomModifiedDateFrom,
			String CustomModifiedDateTo) throws InterruptedException, Exception {
		scrollToElement(driver, OCR_HeaderSearchExportClassification);
		clickElement(driver, test, OCR_HeaderSearchCustomsClassification, "Click Search Customs Classification");
		Wait.waitfor(2);
		if (CustomsCountryOfClassification.length() > 0) {
			typeText(driver, test, OCR_SearchCustomsClassificationReport_CountryofClassification,
					"Enter Country of Classification :", CustomsCountryOfClassification);
			Wait.waitfor(2);
			String country = "//div[contains(text(),'" + CustomsCountryOfClassification + "')]";
			clickElement(driver, test, country, "Click on country : " + country);
			Wait.waitfor(2);
			if (CustomsHSNo.length() > 0) {
				Wait.waitfor(2);
				clickElement(driver, test, OCR_SearchCustomsClassificationReport_ImportClassificationLink,
						"Click on Import Classification Link");
				try {
					typeText(driver, test, OCR_SearchCustomsClassificationReport_HSNo, "Enter HS No :", CustomsHSNo);
					clickElement(driver, test, OCR_SearchCustomsClassificationReport_HSCodeSearch,
							"Click Search Button");
					String customHSNo = "//div[contains(text(),'" + CustomsHSNo + "')]";
					clickElement(driver, test, customHSNo, "Click HS No :" + CustomsHSNo);
					clickElement(driver, test, OCR_SearchCustomsClassificationReport_HSNoSelect,
							"Click HS No Select button");
				} catch (Exception e) {
					testFailSshot(driver, test);
					test.log(LogStatus.FAIL, "Fail to add the Import Classification");
					clickElement(driver, test, OCR_SearchProductReport_ProgramCodeCancel, "Close the Pop UP");
				}
			}
		}

		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCR_SearchCustomsClassificationReport_ConfidenceLevel,
				"Select Confidence Level :", ConfidenceLevel);

		if (CustomCreatedByUser.length() > 0) {
			Wait.waitfor(5);
			clickElement(driver, test, OCR_SearchCustomsClassificationReport_CreatedByLink, "Click Created By");
			try {
				typeText(driver, test, OCR_SearchCustomsClassificationReport_CustomUser, "Enter User :",
						CustomCreatedByUser);
				clickElement(driver, test, OCR_SearchProductReport_SearchButton, "Click Search Button");
				String customuser = "//td[contains(text(),'" + CustomCreatedByUser + "')]";
				clickElement(driver, test, customuser, "Click Created by User Name :" + CustomCreatedByUser);
				clickElement(driver, test, OCR_SearchProductReport_ProductLineSelect, "Click Program Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add the Custom Created By User");
				clickElement(driver, test, OCR_SearchProductReport_ProgramCodeCancel, "Close the Pop UP");
			}
		}
		if(CustomCreatedDateFrom.length() > 0) {
			clickElement(driver, test, OCR_SearchCustomsClassificationReport_FromCreatedBy, "Clicking on Custom Created Date From");
			if (CustomCreatedDateFrom.contains("Today")) {
				clickElement(driver, test, OCR_RequiredByDate_Today, "Clicking on Today: ");
				} else {
					dateOfMonthName(driver, test, "Selecting the Custom Created Date From : ", CustomCreatedDateFrom);
				}
		}
		if(CustomCreatedDateTo.length() > 0) {
			clickElement(driver, test, OCR_SearchCustomsClassificationReport_ToCreatedBy, "Clicking on Custom Created Date To");
			if (CustomCreatedDateTo.contains("Today")) {
				clickElement(driver, test, OCR_RequiredByDate_Today, "Clicking on Today: ");
				} else {
					dateOfMonthName(driver, test, "Selecting the Custom Created Date To : ", CustomCreatedDateTo);
				}
		}
		if (CustomModifiedByUser.length() > 0) {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_SearchCustomsClassificationReport_ModifiedByLink, "Click Modified By");
			try {
				typeText(driver, test, OCR_SearchCustomsClassificationReport_ModifiedUser, "Enter User :",
						CustomModifiedByUser);
				clickElement(driver, test, OCR_SearchProductReport_SearchButton, "Click Search Button");
				String modifieduser = "//td[contains(text(),'" + CustomModifiedByUser + "')]";
				clickElement(driver, test, modifieduser, "Click Modified by User Name :" + CustomModifiedByUser);
				clickElement(driver, test, OCR_SearchProductReport_ProductLineSelect, "Click Program Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add the Custom Created By User");
				clickElement(driver, test, OCR_SearchProductReport_ProgramCodeCancel, "Close the Pop UP");
			}
		}
		if(CustomModifiedDateFrom.length() > 0) {
			clickElement(driver, test, OCR_SearchCustomsClassificationReport_FromModifiedDate, "Clicking on Custom Modified Date From");
			if (CustomModifiedDateFrom.contains("Today")) {
				clickElement(driver, test, OCR_RequiredByDate_Today, "Clicking on Today: ");
				} else {
					dateOfMonthName(driver, test, "Selecting the Custom Modified Date From : ", CustomModifiedDateFrom);
				}
		}
		if(CustomModifiedDateTo.length() > 0) {
			clickElement(driver, test, OCR_SearchCustomsClassificationReport_ToModifiedDate, "Clicking on Custom Modified Date To");
			if (CustomModifiedDateTo.contains("Today")) {
				clickElement(driver, test, OCR_RequiredByDate_Today, "Clicking on Today: ");
				} else {
					dateOfMonthName(driver, test, "Selecting the Custom Modified Date To : ", CustomModifiedDateTo);
				}
		}
		scrollToBottom(driver);
		Wait.waitfor(2);
	}

	// Click on Search Button
	public void click_ReportSearch() throws InterruptedException {
		Wait.waitfor(2);
		scrollToTop(driver);
		Wait.waitfor(2);
		clickElement(driver, test, OCR_ProductReportSearchButton, "Click on Search Button");
	}

	// Verify the Page Title is Displayed or not
	public void displayOfTitle() {
		try {
			if (isDisplayed(driver, "//h3[@class='page-heading']")) {
				test.log(LogStatus.PASS, "Result Product Report Page is Dispalyed");
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Result Product Report Page is not Dispalyed");
			testFailSshot(driver, test);
			Assert.assertTrue(false);
		}
	}

}
