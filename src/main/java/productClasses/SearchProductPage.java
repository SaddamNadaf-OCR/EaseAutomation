package productClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import utilities.GenericMethods;
import utilities.Wait;

public class SearchProductPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_HomePage_ListScreening = "//ul[@class='nav navbar-nav']/li[2]/a";
	public static final String OCR_ExportOPerationsHomePage = "(//a[contains(text(),'Export Operations')])[1]";
	public static final String OCR_SearchProduct_Files = "//ul[@class='nav navbar-nav']/li[5]/a";
	public static final String OCR_SearchProduct_Product = "(//a[contains(text(),'Products')])[1]";
	public static final String OCR_SearchProduct_SBUCode = "//select[@id='searchProduct_product_sbuCode']";
	public static final String OCR_SearchProduct_SourceSysPartNo = "//input[@id='searchProduct_product_sourceProductId']";
	public static final String OCR_SearchProduct_PartNo = "//input[@id='searchProduct_product_productCode']";
	public static final String OCR_SearchProduct_SKUNo = "//input[@id='searchProduct_product_skuNo']";
	public static final String OCR_SearchProduct_Description = "//textarea[@id='searchProduct_product_productDesc']";
	public static final String OCR_SearchProduct_ModelNo = "//input[@id='searchProduct_product_modelNo']";
	public static final String OCR_SearchProduct_ProductLine = "(//textarea[@id='searchProduct_product_prodLineId']/../../label/a)[1]";
	public static final String OCR_SearchProduct_ProductSelect = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_SearchProduct_Program = "//fieldset//a[contains(text(),'Program')]";
	public static final String OCR_SearchProduct_ProgramCode = "//input[@id='searchForm_programTab_programCode']";
	public static final String OCR_SearchProduct_SearchButton = "//button[@name='Search']";
	public static final String OCR_SearchProduct_Site = "//textarea[@id='searchProduct_product_workSite']/../../label/a";
	public static final String OCR_SearchProduct_SiteName = "//input[@id='dosSitePopupForm_dosSite_siteName']";
	public static final String OCR_SearchProduct_Hazardous = "//select[@id='searchProduct_product_hazardous']";
	public static final String OCR_SearchProduct_Flagreason = "(//a[contains(text(),'Flag Reason')])[2]";
	public static final String OCR_SearchProduct_FlagReasonCode = "//input[@id='flagReasonPopupForm_flagReason_reasonCode']";
	public static final String OCR_SearchProduct_NationalStockNo = "//input[@id='searchProduct_product_nationalStockNumber']";
	public static final String OCR_SearchProduct_MaterialType = "//input[@id='searchProduct_product_bomType']";
	public static final String OCR_SearchProduct_CommodityType = "//select[@name='product.productType']";
	public static final String OCR_SearchProduct_ProductAuditSearchCreatedBy = "//input[@id='searchProduct_product_createdBy']/../../label/a";
	public static final String OCR_SearchProduct_CreatedByUsername = "//input[@id='searchForm_userProfile_username']";
	public static final String OCR_SearchProduct_ProductAuditSearchCreatedDateFrom = "//input[@id='searchProduct_fromPrdCrdOn']";
	public static final String OCR_SearchProduct_ProductAuditSearchCreatedDateTo = "//input[@id='searchProduct_toPrdCrdOn']";
	public static final String OCR_SearchProduct_ProductAuditSearchModifiedBy = "//input[@id='searchProduct_product_modifiedBy']/../../label/a";
	public static final String OCR_SearchProduct_ProductAuditSearchModifiedDateFrom = "//input[@id='searchProduct_fromPrdMfdOn']";
	public static final String OCR_SearchProduct_ProductAuditSearchModifiedDateTo = "//input[@id='searchProduct_toPrdMfdOn']";
	public static final String OCR_SearchProduct_SortBy = "//select[@name='sortBy']";
	public static final String OCR_SearchProduct_Direction = "//select[@name='direction']";
	public static final String OCR_SearchManufacturer_Manufacturer = "//input[@id='searchProduct_product_manufacturer']/../../label/a";
	public static final String OCR_SearchManufacturer_ManufacturerUserName = "//input[@id='searchForm_userDTO_userName']";
	public static final String OCR_SearchManufacturer_DomesticForeign = "//select[@id='searchProduct_product_domesticForeign']";
	public static final String OCR_SearchManufacturer_CountryOfOrgin = "//input[@id='searchProduct_countryMfgName']";
	public static final String OCR_SearchManufacturer_ManfPartNo = "//input[@id='searchProduct_productMfg_mfgPartNo']";
	public static final String OCR_SearchManufacturer_TradeProgramSPI = "//input[@id='searchProduct_tradeProgram']/../../label/a";
	public static final String OCR_SearchManufacturer_SpecialProgram = "//input[@id='resultProductFtaGspProgram_productFtaGspProgramValue_specialProgName']";
	public static final String OCR_SearchManufacturer_CageCode = "//input[@id='searchProduct_productMfg_cageCode']";
	public static final String OCR_SearchManufacturer_CreatedBy = "//input[@id='searchProduct_productMfg_createdBy']/../../label/a";
	public static final String OCR_SearchManufacturer_CreatedByUser = "//input[@id='searchForm_userProfile_username']";
	public static final String OCR_SearchManufacturer_CreatedDateFrom = "//input[@id='searchProduct_fromManuFtrCrdOn']";
	public static final String OCR_SearchManufacturer_CreatedDateTo = "//input[@id='searchProduct_toManuFtrCrdOn']";
	public static final String OCR_SearchManufacturer_ModifiedBy = "//input[@id='searchProduct_productMfg_modifiedBy']/../../label/a";
	public static final String OCR_SearchManufacturer_ModifiedByUser = "//input[@id='searchForm_userProfile_username']";
	public static final String OCR_SearchManufacturer_ModifiedDateFrom = "//input[@id='searchProduct_fromManuFtrMfdOn']";
	public static final String OCR_SearchManufacturer_ModifiedDateTo = "//input[@id='searchProduct_toManuFtrMfdOn']";
	public static final String OCR_SearchExportClassification_CountryofClassification = "//input[@id='searchProduct_countryExpClsName']";
	public static final String OCR_SearchExportClassification_ExportClassification = "//a[@id='expClsLnk']";
	public static final String OCR_SearchExportClassification_EccnUsml = "//input[@id='searchForm_productClazz_prodClassification']";
	public static final String OCR_SearchExportClassification_ECRReviewCompleted = "//select[@name='ecrreviewcompleted']";
	public static final String OCR_SearchExportClassification_ATFForm9Required = "//select[@id='searchProduct_product_batf']";
	public static final String OCR_SearchExportClassification_Sme = "//select[@name='sme']";
	public static final String OCR_SearchExportClassification_TechDataReferenceNumber = "//input[@id='searchProduct_techDataRefNumber']";
	public static final String OCR_SearchExportClassification_AssociatedExportClassification = "//a[@id='assClsLnk']";
	public static final String OCR_SearchExportClassification_SelectCountry = "//input[@id='addClassTypePopupFormId_countryName']";
	public static final String OCR_SearchExportClassification_Proceed = "//button[@name='proceed']";
	public static final String OCR_SearchExportClassification_CreatedBy = "//input[@id='searchProduct_expClsCreatedBy']/../../label/a";
	public static final String OCR_SearchExportClassification_CreatedByUser = "//input[@id='searchForm_userProfile_username']";
	public static final String OCR_SearchExportClassification_FromCreatedDate = "//input[@id='searchProduct_frmExpClsCreatedOn']";
	public static final String OCR_SearchExportClassification_ToCreatedDate = "//input[@id='searchProduct_toExpClsCreatedOn']";
	public static final String OCR_SearchExportClassification_ModifiedBy = "//input[@id='searchProduct_expClsModifiedBy']/../../label/a";
	public static final String OCR_SearchExportClassification_ModifiedByUser = "//input[@id='searchForm_userProfile_username']";
	public static final String OCR_SearchExportClassification_ModifiedDateFrom = "//input[@id='searchProduct_frmExpClsModifiedOn']";
	public static final String OCR_SearchExportClassification_ModifiedDateTo = "//input[@id='searchProduct_toExpClsModifiedOn']";
	public static final String OCR_SearchCustomsClassification_CountryofClassification = "//input[@id='searchProduct_ctryCustmClsName']";
	public static final String OCR_SearchCustomsClassification_HSCode = "//a[@id='htsNoLnk']";
	public static final String OCR_SearchCustomsClassification_HSCodeSearch = "//button[@id='searchHsDtlBtn']";
	public static final String OCR_SearchCustomsClassification_HSNo = "//input[@id='hsNo_resultStdHsPopup']";
	public static final String OCR_SearchCustomsClassification_HSNoSearch = "//button[@id='searchHsDtlBtn']";
	public static final String OCR_SearchCustomsClassification_HSNoSelect = "(//button[@id='slctBtn']//.)[1]";
	public static final String OCR_SearchCustomsClassification_ConfidenceLevel = "//select[@name='levelCode']";
	public static final String OCR_SearchCustomsClassification_InvalidHSCode = "//select[@name='invalidHTS']";
	public static final String OCR_SearchCustomsClassification_StatisticalReportingClassification = "//a[@id='schedulebLink']";
	public static final String OCR_SearchCustomsClassification_CustomHTSNo = "//input[@id='searchForm_schbhtsNo']";
	public static final String OCR_SearchCustomsClassification_HTSSearch = "//button[@class='primary-btn popupSearchButton']";
	public static final String OCR_SearchCustomsClassification_InvalidStatisticalReportingClassification = "//select[@name='invalidScheduleB']";
	public static final String OCR_SearchCustomsClassification_CreatedBy = "//div[@id='searchCriteria-CustmCls-details']//a[contains(text(),'Created By')]";
	public static final String OCR_SearchCustomsClassification_CustomUser = "//input[@id='searchForm_userProfile_username']";
	public static final String OCR_SearchCustomsClassification_FromCreatedBy = "//input[@id='searchProduct_frmCustClsCreatedOn']";
	public static final String OCR_SearchCustomsClassification_ToCreatedBy = "//input[@id='searchProduct_toCustClsCreatedOn']";
	public static final String OCR_SearchCustomsClassification_ModifiedBy = "//div[@id='searchCriteria-CustmCls-details']//a[contains(text(),'Modified By')]";
	public static final String OCR_SearchCustomsClassification_ModifiedUser = "//input[@id='searchForm_userProfile_username']";
	public static final String OCR_SearchCustomsClassification_FromModifiedDate = "//input[@id='searchProduct_frmCustClsModifiedOn']";
	public static final String OCR_SearchCustomsClassification_ToModifiedDate = "//input[@id='searchProduct_toCustClsModifiedOn']";
	public static final String OCR_SearchAdditionalInformation_Classification = "//input[@name='6_CUSTOMFIELD']";
	public static final String OCR_SearchAdditionalInformation_DrawingNumber = "//input[@name='8_CUSTOMFIELD']";
	public static final String OCR_SearchAdditionalInformation_Test = "//input[@name='30_CUSTOMFIELD']";
	public static final String OCR_ProductSearchButton = "(//button[contains(text(),'Search')])[1]";
	public static final String OCR_HeaderSearchManufacturer = "//label[contains(text(),'Search Manufacturer')]";
	public static final String OCR_HeaderSearchExportClassification = "//label[contains(text(),'Search Export Classification')]";
	public static final String OCR_HeaderSearchImportClassification = "//label[contains(text(),'Search Import Classification')]";
	public static final String OCR_HeaderAdditionalInformation = "//label[contains(text(),'Additional Information')]";
	public static final String OCR_AddProduct = "//button[contains(text(),'Add Product')]";
	public static final String OCR_POPupClose = "(//button[@class='btn-close'])[1]";
	public static final String OCR_USMILClassification = "//input[@id='searchProduct_customsClassValue_usmilClassification']/../../label/a";
	public static final String OCR_USMILClassificationNumber = "//input[@id='searchForm_comMunitionsImportListValue_categoryNo']";

	/* ******************** Constructor ***************************** */
	public SearchProductPage(WebDriver driver, ExtentTest test) {

		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	// Enter Search Products
	public void searchProductDetails(String SBUCode, String SourceSystemPartNo, String PartNo, String SKUNo,
			String Description, String ModelNo, String ProductLineName, String ProgramCode, String SiteName,
			String Hazardous, String FlagReasonCode, String NationalStockNumber, String MaterialType, String Type,
			String ProductCreatedByUser, String ProductCreatedDateFrom, String ProductCreatedDateTo,
			String ProductModifiedByUser, String ProductModifiedDateFrom, String ProductModifiedDateTo, String SortBy,
			String Direction) throws InterruptedException {

		selectByVisibleText(driver, test, OCR_SearchProduct_SBUCode, "Select Sbu Code ", SBUCode);
		typeText(driver, test, OCR_SearchProduct_SourceSysPartNo, "Enter Source System Part No ", SourceSystemPartNo);
		typeText(driver, test, OCR_SearchProduct_PartNo, "Enter Part No ", PartNo);
		typeText(driver, test, OCR_SearchProduct_SKUNo, "Enter SKU No ", SKUNo);
		typeText(driver, test, OCR_SearchProduct_Description, "Enter Description ", Description);
		typeText(driver, test, OCR_SearchProduct_ModelNo, "Enter Model No ", ModelNo);

		if (ProductLineName.length() > 0) {
			Wait.waitfor(5);
			clickElement(driver, test, OCR_SearchProduct_ProductLine, "Click Product Line");
			try {
				String prodlinename = "//td[contains(text(),'" + ProductLineName + "')]";
				clickElement(driver, test, prodlinename, "Click Product line name :" + ProductLineName);
				clickElement(driver, test, OCR_SearchProduct_ProductSelect, "Click Product Line Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add the product Lines");
				clickElement(driver, test, OCR_POPupClose, "Close the Pop UP");
			}
		}

		if (ProgramCode.length() > 0) {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_SearchProduct_Program, "Click Program");
			try {
				typeText(driver, test, OCR_SearchProduct_ProgramCode, "Enter Program Code", ProgramCode);
				clickElement(driver, test, OCR_SearchProduct_SearchButton, "Click Search Button");
				String progcode = "//td[contains(text(),'" + ProgramCode + "')]";
				clickElement(driver, test, progcode, "Click Product Code :" + ProgramCode);
				clickElement(driver, test, OCR_SearchProduct_ProductSelect, "Click Program Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add the program code");
				clickElement(driver, test, OCR_POPupClose, "Close the Pop UP");
			}
		}

		if (SiteName.length() > 0) {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_SearchProduct_Site, "Click Site");
			try {
				typeText(driver, test, OCR_SearchProduct_SiteName, "Enter Site Name", SiteName);
				clickElement(driver, test, OCR_SearchProduct_SearchButton, "Click Search Button");
				String siteName = "//td[contains(text(),'" + SiteName + "')]";
				clickElement(driver, test, siteName, "Click Site Name :" + SiteName);
				clickElement(driver, test, OCR_SearchProduct_ProductSelect, "Click Program Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add the Site ");
				clickElement(driver, test, OCR_POPupClose, "Close the Pop UP");
			}
		}

		selectByVisibleText(driver, test, OCR_SearchProduct_Hazardous, "Select Hazardous ", Hazardous);

		if (FlagReasonCode.length() > 0) {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_SearchProduct_Flagreason, "Click Flag Reason");
			try {
				typeText(driver, test, OCR_SearchProduct_FlagReasonCode, "Enter Flag Reason Code ", FlagReasonCode);
				clickElement(driver, test, OCR_SearchProduct_SearchButton, "Click Search Button");
				String reasonCode = "//td[contains(text(),'" + FlagReasonCode + "')]";
				clickElement(driver, test, reasonCode, "Click Flag Reason Code :" + FlagReasonCode);
				clickElement(driver, test, OCR_SearchProduct_ProductSelect, "Click Program Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add the Flag Reason Code");
				clickElement(driver, test, OCR_POPupClose, "Close the Pop UP");
			}
		}

		typeText(driver, test, OCR_SearchProduct_NationalStockNo, "Enter National Stock No ", NationalStockNumber);
		typeText(driver, test, OCR_SearchProduct_MaterialType, "Enter Material Type ", MaterialType);
		selectByVisibleText(driver, test, OCR_SearchProduct_CommodityType, "Select commodity Type ", Type);
		scrollToBottom(driver);
		if (ProductCreatedByUser.length() > 0) {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_SearchProduct_ProductAuditSearchCreatedBy, "Click Created By");
			try {
				typeText(driver, test, OCR_SearchProduct_CreatedByUsername, "Enter CreatedBy Username ",
						ProductCreatedByUser);
				clickElement(driver, test, OCR_SearchProduct_SearchButton, "Click Search Button");
				String user = "//td[contains(text(),'" + ProductCreatedByUser + "')]";
				clickElement(driver, test, user, "Click Created User :" + ProductCreatedByUser);
				clickElement(driver, test, OCR_SearchProduct_ProductSelect, "Click Program Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add the Created By User");
				clickElement(driver, test, OCR_POPupClose, "Close the Pop UP");
			}
		}

		if (ProductCreatedDateFrom.length() > 0) {
			clickElement(driver, test, OCR_SearchProduct_ProductAuditSearchCreatedDateFrom,
					"Click on Created Date From");
			Wait.waitfor(1);
			date(driver, test, "Selected on Created Date From : ", ProductCreatedDateFrom);
			Wait.waitfor(2);
			clickElement(driver, test, OCR_SearchProduct_ProductAuditSearchCreatedDateTo, "Click on Created Date To");
			Wait.waitfor(1);
			date(driver, test, "Selected on Created Date To : ", ProductCreatedDateTo);
		}
		scrollToBottom(driver);
		if (ProductModifiedByUser.length() > 0) {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_SearchProduct_ProductAuditSearchModifiedBy, "Click Modified By");
			try {
				clickElement(driver, test, OCR_SearchProduct_SearchButton, "Click Search Button");
				String modifiedUser = "//td[contains(text(),'" + ProductModifiedByUser + "')]";
				clickElement(driver, test, modifiedUser, "Click Modified User :" + ProductModifiedByUser);
				clickElement(driver, test, OCR_SearchProduct_ProductSelect, "Click Program Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add the Modified By User");
				clickElement(driver, test, OCR_POPupClose, "Close the Pop UP");
			}
		}

		if (ProductModifiedDateFrom.length() > 0) {
			clickElement(driver, test, OCR_SearchProduct_ProductAuditSearchModifiedDateFrom,
					"Click on Modified Date From");
			date(driver, test, "Selected on Modified Date From : ", ProductModifiedDateFrom);
			Wait.waitfor(2);
			clickElement(driver, test, OCR_SearchProduct_ProductAuditSearchModifiedDateTo, "Click on Modified Date To");
			date(driver, test, "Selected on Modified Date To : ", ProductModifiedDateTo);
		}

		selectByVisibleText(driver, test, OCR_SearchProduct_SortBy, "Select Sort By ", SortBy);
		selectByVisibleText(driver, test, OCR_SearchProduct_Direction, "Select Direction ", Direction);
	}

	public void searchManufacturerDetails(String ManufacturerUserName, String DomesticForeign, String CountryOfOrigin,
			String ManfPartNo, String SpecialTradeProgramName, String CageCode, String ManufacturerCreatedByUser,
			String ManufacturerCreatedDateFrom, String ManufacturerCreatedDateTo, String ManufacturerModifiedByUser,
			String ManufacturerModifiedDateFrom, String ManufacturerModifiedDateTo) throws InterruptedException {
		
		scrollToElement(driver, OCR_HeaderSearchManufacturer);
		clickElement(driver, test, OCR_HeaderSearchManufacturer, "Click Header Search Manufacturer");
		if (ManufacturerUserName.length() > 0) {
			clickElement(driver, test, OCR_SearchManufacturer_Manufacturer, "Click on Manufacturer");
			try {
				typeText(driver, test, OCR_SearchManufacturer_ManufacturerUserName, "Enter Manufacturer UserName ",
						ManufacturerUserName);
				clickElement(driver, test, OCR_SearchProduct_SearchButton, "Click Search Button");
				String manufactureruser = "//div[contains(text(),'" + ManufacturerUserName + "')]";
				clickElement(driver, test, manufactureruser, "Click Manufacturer User :" + ManufacturerUserName);
				clickElement(driver, test, OCR_SearchProduct_ProductSelect, "Click Program Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add the Manufacturer");
				clickElement(driver, test, OCR_POPupClose, "Close the Pop UP");
			}
		}

		selectByVisibleText(driver, test, OCR_SearchManufacturer_DomesticForeign, "Select Domestic/Foreign ",
				DomesticForeign);
		typeText(driver, test, OCR_SearchManufacturer_CountryOfOrgin, "Enter Country Of Orgin ", CountryOfOrigin);
		typeText(driver, test, OCR_SearchManufacturer_ManfPartNo, "Enter Manf Part No ", ManfPartNo);

		if (SpecialTradeProgramName.length() > 0) {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_SearchManufacturer_TradeProgramSPI, "Click on Trade Program SPI");
			try {
				typeText(driver, test, OCR_SearchManufacturer_SpecialProgram, "Enter Special Program Name ",
						SpecialTradeProgramName);
				clickElement(driver, test, OCR_SearchProduct_SearchButton, "Click Search Button");
				String tradeProgName = "//td[contains(text(),'" + SpecialTradeProgramName + "')]";
				clickElement(driver, test, tradeProgName,
						"Click Special Trade Program Name :" + SpecialTradeProgramName);
				clickElement(driver, test, OCR_SearchProduct_ProductSelect, "Click Program Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add the Special Trade Program");
				clickElement(driver, test, OCR_POPupClose, "Close the Pop UP");
			}
		}

		typeText(driver, test, OCR_SearchManufacturer_CageCode, "Enter Cage Code ", CageCode);

		if (ManufacturerCreatedByUser.length() > 0) {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_SearchManufacturer_CreatedBy, "Click Created By");
			try {
				typeText(driver, test, OCR_SearchManufacturer_CreatedByUser, "Enter CreatedBy Username ",
						ManufacturerCreatedByUser);
				clickElement(driver, test, OCR_SearchProduct_SearchButton, "Click Search Button");
				String manfuser = "//td[contains(text(),'" + ManufacturerCreatedByUser + "')]";
				clickElement(driver, test, manfuser, "Click Manufacturer Created User :" + ManufacturerCreatedByUser);
				clickElement(driver, test, OCR_SearchProduct_ProductSelect, "Click Program Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add the Manufacturer Created By User");
				clickElement(driver, test, OCR_POPupClose, "Close the Pop UP");
			}
		}

		if (ManufacturerCreatedDateFrom.length() > 0) {
			clickElement(driver, test, OCR_SearchManufacturer_CreatedDateFrom,
					"Click on Manufacturer Created Date From");
			date(driver, test, "Selected on Created Date From : ", ManufacturerCreatedDateFrom);
			clickElement(driver, test, OCR_SearchManufacturer_CreatedDateTo, "Click on Manufacturer Created Date To");
			date(driver, test, "Selected on Created Date To : ", ManufacturerCreatedDateTo);
		}

		if (ManufacturerModifiedByUser.length() > 0) {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_SearchManufacturer_ModifiedBy, "Click Modified By");
			try {
				typeText(driver, test, OCR_SearchManufacturer_ModifiedByUser, "Enter ModifiedBy Username ",
						ManufacturerModifiedByUser);
				clickElement(driver, test, OCR_SearchProduct_SearchButton, "Click Search Button");
				String manfmodifiedUser = "//td[contains(text(),'" + ManufacturerModifiedByUser + "')]";
				clickElement(driver, test, manfmodifiedUser, "Click Modified User :" + ManufacturerModifiedByUser);
				clickElement(driver, test, OCR_SearchProduct_ProductSelect, "Click Program Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add the Manufacturer Modified By User");
				clickElement(driver, test, OCR_POPupClose, "Close the Pop UP");
			}
		}

		if (ManufacturerModifiedDateFrom.length() > 0) {
			clickElement(driver, test, OCR_SearchManufacturer_ModifiedDateFrom,
					"Click on Modified Date From");
			date(driver, test, "Selected on Modified Date From : ", ManufacturerModifiedDateFrom);
			clickElement(driver, test, OCR_SearchManufacturer_ModifiedDateTo, "Click on Modified Date To");
			date(driver, test, "Selected on Modified Date To : ", ManufacturerModifiedDateTo);
		}
		Wait.waitfor(3);
	}

	public void searchExportClassification(String ExportCountryOfClassification, String ExportProductClassification,
			String ECRReviewCompleted, String ATFForm9Required, String Sme, String TechDataReferenceNumber,
			String AssociatedProductClassification, String ExportCreatedByUser, String ExportCreatedDateFrom,
			String ExportCreatedDateTo, String ExportModifiedByUser, String ExportModifiedDateFrom,
			String ExportModifiedDateTo) throws InterruptedException, Exception {
		Wait.waitfor(3);
		scrollToElement(driver, OCR_HeaderSearchExportClassification);
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HeaderSearchExportClassification, "Click Header Export Classification");

		if (ExportCountryOfClassification.length() > 0) {
			typeText(driver, test, OCR_SearchExportClassification_CountryofClassification,
					"Enter Country of Classification ", ExportCountryOfClassification);
			Wait.waitfor(2);
			//String country = "//div[contains(text(),'" + ExportCountryOfClassification + "')]";
			//Wait.waitfor(2);
			//clickElement(driver, test, country, "Click on country : " + country);
			
			Wait.waitfor(2);
			if (ExportProductClassification.length() > 0) {
				clickElement(driver, test, OCR_SearchExportClassification_ExportClassification,
						"Click on Export Classification");
				try {
					typeText(driver, test, OCR_SearchExportClassification_EccnUsml, "Enter Export Product EccnUsml No ",
							ExportProductClassification);
					clickElement(driver, test, OCR_SearchProduct_SearchButton, "Click Search Button");
					String prodclassification = "//td[contains(text(),'" + ExportProductClassification + "')]";
					clickElement(driver, test, prodclassification,
							"Click Product Classification :" + ExportProductClassification);
					clickElement(driver, test, OCR_SearchProduct_ProductSelect, "Click Program Select button");
				} catch (Exception e) {
					testFailSshot(driver, test);
					test.log(LogStatus.FAIL, "Fail to add the Export Product Classification");
					clickElement(driver, test, OCR_POPupClose, "Close the Pop UP");
				}
			}

			selectByVisibleText(driver, test, OCR_SearchExportClassification_ECRReviewCompleted,
					"Select ECR Review Completed ", ECRReviewCompleted);
			selectByVisibleText(driver, test, OCR_SearchExportClassification_ATFForm9Required,
					"Select ATF Form9 Required ", ATFForm9Required);
			selectByVisibleText(driver, test, OCR_SearchExportClassification_Sme, "Select SME ", Sme);
			typeText(driver, test, OCR_SearchExportClassification_TechDataReferenceNumber,
					"Enter Tech Data Reference Number ", TechDataReferenceNumber);

			if (AssociatedProductClassification.length() > 0) {
				clickElement(driver, test, OCR_SearchExportClassification_AssociatedExportClassification,
						"Click on AssociatedExportClassification");
				try {
					clickElement(driver, test, OCR_SearchExportClassification_Proceed, "Click Proceed Button");
					Wait.waitfor(1);
					typeText(driver, test, OCR_SearchExportClassification_EccnUsml,
							"Enter Associated Product EccnUsml No ", AssociatedProductClassification);
					clickElement(driver, test, OCR_SearchProduct_SearchButton, "Click Search Button");
					String associateprodclassification = "//td[contains(text(),'" + AssociatedProductClassification
							+ "')]";
					clickElement(driver, test, associateprodclassification,
							"Click Associated Product Classification Name :" + AssociatedProductClassification);
					clickElement(driver, test, OCR_SearchProduct_ProductSelect, "Click Program Select button");
				} catch (Exception e) {
					testFailSshot(driver, test);
					test.log(LogStatus.FAIL, "Fail to add the Associated Product Classification");
					clickElement(driver, test, OCR_POPupClose, "Close the Pop UP");
				}
			}

			if (ExportCreatedByUser.length() > 0) {
				clickElement(driver, test, OCR_SearchExportClassification_CreatedBy, "Click Created By");
				try {
					Wait.waitfor(3);
					typeText(driver, test, OCR_SearchExportClassification_CreatedByUser, "Enter CreatedBy Username ",
							ExportCreatedByUser);
					clickElement(driver, test, OCR_SearchProduct_SearchButton, "Click Search Button");
					String exportuser = "//td[contains(text(),'" + ExportCreatedByUser + "')]";
					clickElement(driver, test, exportuser, "Click Export Created User :" + ExportCreatedByUser);
					clickElement(driver, test, OCR_SearchProduct_ProductSelect, "Click Program Select button");
				} catch (Exception e) {
					testFailSshot(driver, test);
					test.log(LogStatus.FAIL, "Fail to add the Export Created By User");
					clickElement(driver, test, OCR_POPupClose, "Close the Pop UP");
				}
			}

			if (ExportCreatedDateFrom.length() > 0) {
				clickElement(driver, test, OCR_SearchExportClassification_FromCreatedDate,
						"Click on Export Created Date From");
				date(driver, test, "Selected on Created Date From : ", ExportCreatedDateFrom);
				clickElement(driver, test, OCR_SearchExportClassification_ToCreatedDate,
						"Click on Export Created Date To");
				date(driver, test, "Selected on Created Date To : ", ExportCreatedDateTo);
			}

			if (ExportModifiedByUser.length() > 0) {
				clickElement(driver, test, OCR_SearchExportClassification_ModifiedBy, "Click Modified By");
				try {
					Wait.waitfor(3);
					typeText(driver, test, OCR_SearchExportClassification_ModifiedByUser, "Enter ModifiedBy Username ",
							ExportModifiedByUser);
					clickElement(driver, test, OCR_SearchProduct_SearchButton, "Click Search Button");
					String exportmodifiedUser = "//td[contains(text(),'" + ExportModifiedByUser + "')]";
					clickElement(driver, test, exportmodifiedUser,
							"Click Export Modified User :" + ExportModifiedByUser);
					clickElement(driver, test, OCR_SearchProduct_ProductSelect, "Click Program Select button");
				} catch (Exception e) {
					testFailSshot(driver, test);
					test.log(LogStatus.FAIL, "Fail to add the Export Modified By User");
					clickElement(driver, test, OCR_POPupClose, "Close the Pop UP");
				}
			}

			if (ExportModifiedDateFrom.length() > 0) {
				clickElement(driver, test, OCR_SearchExportClassification_ModifiedDateFrom,
						"Click on Export Modified Date From");
				date(driver, test, "Selected on Modified Date From : ", ExportModifiedDateFrom);
				test.log(LogStatus.PASS, "Selected on Modified Date From : " + ExportModifiedDateFrom);
				clickElement(driver, test, OCR_SearchExportClassification_ModifiedDateTo,
						"Click on Export Modified Date To");
				date(driver, test, "Selected on Modified Date To : ", ExportModifiedDateTo);
				test.log(LogStatus.PASS, "Selected on Modified Date To : " + ExportModifiedDateTo);
			}
			Wait.waitfor(3);
		}
	}

	public void searchImportClassification(String ImportClassificationCountry, String ImportClassification,
			String ConfidenceLevel, String InvalidHSCode, String StatisticalClassification,String USMILClassification,
			String InvalidStatisticalReportingClassification, String CustomCreatedByUser, String CustomCreatedDateFrom,
			String CustomCreatedDateTo, String CustomModifiedByUser, String CustomModifiedDateFrom,
			String CustomModifiedDateTo) throws InterruptedException, Exception {
		Wait.waitfor(3);
		scrollToElement(driver, OCR_HeaderSearchImportClassification);
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HeaderSearchImportClassification, "Click Import Classification");
		Wait.waitfor(2);
		if (ImportClassificationCountry.length() > 0) {
			typeText(driver, test, OCR_SearchCustomsClassification_CountryofClassification,
					"Enter Country of Classification ", ImportClassificationCountry);
			Wait.waitfor(2);
			//String country = "//div[contains(text(),'" + ImportClassificationCountry + "')]";
			//clickElement(driver, test, country, "Click on country : " + country);
			Wait.waitfor(2);
			if (ImportClassification.length() > 0) {
				Wait.waitfor(2);
				clickElement(driver, test, OCR_SearchCustomsClassification_HSCode, "Click on HS Code");
				try {
					typeText(driver, test, OCR_SearchCustomsClassification_HSNo, "Enter HS No ", ImportClassification);
					clickElement(driver, test, OCR_SearchCustomsClassification_HSNoSearch, "Click Search Button");
					String customHSNo = "//div[contains(text(),'" + ImportClassification + "')]";
					clickElement(driver, test, customHSNo, "Click HS No :" + ImportClassification);
					Wait.waitfor(2);
					clickElement(driver, test, OCR_SearchCustomsClassification_HSNoSelect, "Click HS No Select button");
					Wait.waitfor(2);
				} catch (Exception e) {
					testFailSshot(driver, test);
					test.log(LogStatus.FAIL, "Fail to add the Import Classification");
					clickElement(driver, test, OCR_POPupClose, "Close the Pop UP");
				}
			}

			selectByVisibleText(driver, test, OCR_SearchCustomsClassification_ConfidenceLevel,
					"Select Confidence Level ", ConfidenceLevel);
			selectByVisibleText(driver, test, OCR_SearchCustomsClassification_InvalidHSCode, "Select Invalid HS Code ",
					InvalidHSCode);

			if (StatisticalClassification.length() > 0) {
				Wait.waitfor(2);
				clickElement(driver, test, OCR_SearchCustomsClassification_StatisticalReportingClassification,
						"Click on Statistical Reporting Classification");
				try {
					typeText(driver, test, OCR_SearchCustomsClassification_CustomHTSNo, "Enter Custom HTS No ",
							StatisticalClassification);
					clickElement(driver, test, OCR_SearchCustomsClassification_HTSSearch, "Click HTS Search Button");
					String htscode = "//td[contains(text(),'" + StatisticalClassification + "')]";
					clickElement(driver, test, htscode, "Click HTS Code :" + StatisticalClassification);
					clickElement(driver, test, OCR_SearchProduct_ProductSelect, "Click Program Select button");
				} catch (Exception e) {
					testFailSshot(driver, test);
					test.log(LogStatus.FAIL, "Fail to add the Statistical Reporting Classification");
					clickElement(driver, test, OCR_POPupClose, "Close the Pop UP");
				}
			}
			scrollToBottom(driver);
			selectByVisibleText(driver, test, OCR_SearchCustomsClassification_InvalidStatisticalReportingClassification,
					"Enter Invalid Statistical Reporting Classification", InvalidStatisticalReportingClassification);
			if (USMILClassification.length() > 0) {
				Wait.waitfor(15);
				clickElement(driver, test, OCR_USMILClassification, "Click on USMIL Classification");
				try {
					typeText(driver, test, OCR_USMILClassificationNumber, "Enter USMIL Classification No ",
							USMILClassification);
					clickElement(driver, test, OCR_SearchCustomsClassification_HTSSearch, "Click HTS Search Button");
					String htscode = "//td[contains(text(),'" + USMILClassification + "')]";
					clickElement(driver, test, htscode, "Click HTS Code :" + USMILClassification);
					clickElement(driver, test, OCR_SearchProduct_ProductSelect, "Click Program Select button");
				} catch (Exception e) {
					testFailSshot(driver, test);
					test.log(LogStatus.FAIL, "Fail to add USMIL Classification");
					clickElement(driver, test, OCR_POPupClose, "Close the Pop UP");
				}
				scrollToBottom(driver);
			}
			scrollToElement(driver, OCR_SearchCustomsClassification_CreatedBy);
			Wait.waitfor(3);
			if (CustomCreatedByUser.length() > 0) {
				Wait.waitfor(3);
				clickElement(driver, test, OCR_SearchCustomsClassification_CreatedBy, "Click Created By");
				try {
					typeText(driver, test, OCR_SearchCustomsClassification_CustomUser, "Enter User ",
							CustomCreatedByUser);
					clickElement(driver, test, OCR_SearchProduct_SearchButton, "Click Search Button");
					String customuser = "//td[contains(text(),'" + CustomCreatedByUser + "')]";
					clickElement(driver, test, customuser, "Click Created by User Name :" + CustomCreatedByUser);
					clickElement(driver, test, OCR_SearchProduct_ProductSelect, "Click Program Select button");
				} catch (Exception e) {
					testFailSshot(driver, test);
					test.log(LogStatus.FAIL, "Fail to add the Custom Created By User");
					clickElement(driver, test, OCR_POPupClose, "Close the Pop UP");
				}
			}

			if (CustomCreatedDateFrom.length() > 0) {
				Wait.waitfor(3);
				clickElement(driver, test, OCR_SearchCustomsClassification_FromCreatedBy,
						"Click on Custom Created Date From");
				date(driver, test, "Selected on Created Date From : ", CustomCreatedDateFrom);
				test.log(LogStatus.PASS, "Selected on Created Date From : " + CustomCreatedDateFrom);
				clickElement(driver, test, OCR_SearchCustomsClassification_ToCreatedBy,
						"Click on Custom Created Date To");
				date(driver, test, "Selected on Created Date To : ", CustomCreatedDateTo);
				test.log(LogStatus.PASS, "Selected on Created Date To : " + CustomCreatedDateTo);
			}

			if (CustomModifiedByUser.length() > 0) {
				Wait.waitfor(3);
				clickElement(driver, test, OCR_SearchCustomsClassification_ModifiedBy, "Click Modified By");
				try {
					typeText(driver, test, OCR_SearchCustomsClassification_ModifiedUser, "Enter User ",
							CustomModifiedByUser);
					clickElement(driver, test, OCR_SearchProduct_SearchButton, "Click Search Button");
					String modifieduser = "//td[contains(text(),'" + CustomModifiedByUser + "')]";
					clickElement(driver, test, modifieduser, "Click Modified by User Name :" + CustomModifiedByUser);
					clickElement(driver, test, OCR_SearchProduct_ProductSelect, "Click Program Select button");
				} catch (Exception e) {
					testFailSshot(driver, test);
					test.log(LogStatus.FAIL, "Fail to add the Custom Created By User");
					clickElement(driver, test, OCR_POPupClose, "Close the Pop UP");
				}
			}

			if (CustomModifiedDateFrom.length() > 0) {
				Wait.waitfor(3);
				clickElement(driver, test, OCR_SearchCustomsClassification_FromModifiedDate,
						"Click on Custom Modified Date From");
				date(driver, test, "Selected on Modified Date From : ", CustomModifiedDateFrom);
				test.log(LogStatus.PASS, "Selected on Modified Date From : " + CustomModifiedDateFrom);
				clickElement(driver, test, OCR_SearchCustomsClassification_ToModifiedDate,
						"Click on Custom Modified Date To");
				date(driver, test, "Selected on Modified Date To : ", CustomModifiedDateTo);
				test.log(LogStatus.PASS, "Selected on Modified Date To : " + CustomModifiedDateTo);
			}
			scrollToBottom(driver);
			Wait.waitfor(2);
		}
	}

	// Click on Search Button
	public void click_ProductSearch() throws InterruptedException {
		Wait.waitfor(3);
		scrollToElement(driver, OCR_ProductSearchButton);
		scrollToTop(driver);
		Wait.waitfor(3);
		clickElement(driver, test, OCR_ProductSearchButton, "Click on Search Button");
	}

	public void clickAddProduct() {
		clickElement(driver, test, OCR_AddProduct, "Click on Add Product");
	}

	public void searchthroughpartno(String PartNo) {
		typeText(driver, test, OCR_SearchProduct_PartNo, "Enter Part No:", PartNo);

	}

}
