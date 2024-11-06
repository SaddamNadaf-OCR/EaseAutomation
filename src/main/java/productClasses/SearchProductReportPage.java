package productClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import utilities.GenericMethods;
import utilities.Wait;

public class SearchProductReportPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_SBUCode = "//select[@id='resultProductTableReport_product_sbuCode']";
	public static final String OCR_Status = "//select[@id='resultProductTableReport_product_status']";
	public static final String OCR_PartNo = "//input[@id='resultProductTableReport_product_productCode']";
	public static final String OCR_SKUNO = "//input[@id='resultProductTableReport_product_skuNo']";
	public static final String OCR_PartNoManuf = "//input[@id='resultProductTableReport_partNoManuPartNoNSNModel']";
	public static final String OCR_SourcePartNo = "//input[@id='resultProductTableReport_product_sourceProductId']";
	public static final String OCR_Description = "//textarea[@id='resultProductTableReport_product_productDesc']";
	public static final String OCR_ModelNo = "//input[@id='resultProductTableReport_product_modelNo']";
	public static final String OCR_ProductName = "//input[@id='resultProductTableReport_product_productName']";
	public static final String OCR_MaterialType = "//input[@id='resultProductTableReport_product_bomType']";
	public static final String OCR_ProductLine = "(//a[contains(text(),'Product Line')])[2]";
	public static final String OCR_Program = "//fieldset//a[contains(text(),'Program')]";
	public static final String OCR_ProgramCode = "//input[@id='searchForm_programTab_programCode']";
	public static final String OCR_Site = "(//a[contains(text(),'Site')])[4]";
	public static final String OCR_SiteId = "//input[@id='dosSitePopupForm_dosSite_siteId']";
	public static final String OCR_Hazardous = "//select[@id='resultProductTableReport_product_hazardous']";
	public static final String OCR_FlagReason = "(//a[contains(text(),'Flag Reason')])[2]";
	public static final String OCR_ReasonCode = "//input[@id='flagReasonPopupForm_flagReason_reasonCode']";
	public static final String OCR_NationalStockNo = "//input[@id='resultProductTableReport_product_nationalStockNumber']";
	public static final String OCR_CreatedBy = "(//a[contains(text(),'Created By')])[1]";
	public static final String OCR_CreatedByUN = "//input[@id='searchForm_userProfile_username']";
	public static final String OCR_CreatedDateFrom = "//input[@id='resultProductTableReport_fromPrdCrdOn']";
	public static final String OCR_CreatedDateTo = "//input[@id='resultProductTableReport_toPrdCrdOn']";
	public static final String OCR_ModifiedBy = "(//a[contains(text(),'Modified By')])[1]";
	public static final String OCR_ModifiedbyUN = "//input[@id='searchForm_userProfile_username']";
	public static final String OCR_ModifiedDateFrom = "//input[@id='resultProductTableReport_fromPrdMfdOn']";
	public static final String OCR_ModifiedDateTo = "//input[@id='resultProductTableReport_toPrdMfdOn']";
	public static final String OCR_SortBy = "//select[@name='sortBy']";
	public static final String OCR_Direction = "//select[@name='direction']";
	public static final String OCR_Manufacturer = "//div[@class=\"panel-body\"]//a[contains(text(),'Manufacturer')]";
	public static final String OCR_ManufacturerCode = "//input[@id='searchForm_userDTO_userCode']";
	public static final String OCR_Domestic_Foreign = "//select[@id='resultProductTableReport_product_domesticForeign']";
	public static final String OCR_CountryOfOrigin = "//input[@id='resultProductTableReport_countryMfgName']";
	public static final String OCR_ManufPartNo = "//input[@id='resultProductTableReport_productMfg_mfgPartNo']";
	public static final String OCR_TradeProgSPI = "//input[@id='resultProductTableReport_tradeProgram']";
	public static final String OCR_ManufCreatedBy = "(//a[contains(text(),'Created By')])[2]";
	public static final String OCR_ManufCreatedDateFrom = "//input[@id='resultProductTableReport_fromManuFtrCrdOn']";
	public static final String OCR_ManufCreatedDateTo = "//input[@id='resultProductTableReport_toManuFtrCrdOn']";
	public static final String OCR_ManufModifiedBy = "//div[@id='searchCriteria-Mfg-details']//a[contains(text(),'Modified By')]";
	public static final String OCR_ManufModifiedDateFrom = "//input[@id='resultProductTableReport_fromManuFtrMfdOn']";
	public static final String OCR_ManufModifiedDateTo = "//input[@id='resultProductTableReport_toManuFtrMfdOn']";
	public static final String OCR_CountryOfClassification = "//input[@id='resultProductTableReport_countryExpClsName']";
	public static final String OCR_ExpClassification = "//a[@id='expClsLnk']";
	public static final String OCR_ExpClassifECCN = "//input[@id='searchForm_productClazz_prodClassification']";
	public static final String OCR_TechDataRefNo = "//input[@id='resultProductTableReport_techDataRefNumber']";
	public static final String OCR_AssExpClassification = "//a[contains(text(),'Associated Export Classification')]";
	public static final String OCR_Button_Proceed = "//button[contains(text(),'Proceed')]";
	public static final String OCR_AssExpClassifECCN = "//input[@id='searchForm_productClazz_prodClassification']";
	public static final String OCR_ExpClassCreatedBy = "(//a[contains(text(),'Created By')])[3]";
	public static final String OCR_ExpClassCreatedDateFrom = "//input[@id='resultProductTableReport_frmExpClsCreatedOn']";
	public static final String OCR_ExpClassCreatedDateTo = "//input[@id='resultProductTableReport_toExpClsCreatedOn']";
	public static final String OCR_ExpClassModifiedBy = "(//a[contains(text(),'Modified By')])[3]";
	public static final String OCR_ExpClassModDateFrom = "//input[@id='resultProductTableReport_frmExpClsModifiedOn']";
	public static final String OCR_ExpClassModDateTo = "//input[@id='resultProductTableReport_toExpClsModifiedOn']";
	public static final String OCR_CustCountryOfClassif = "//input[@id='resultProductTableReport_ctryCustmClsName']";
	public static final String OCR_ImportClassif = "//input[@id='resultProductTableReport_product_htsNo']";
	public static final String OCR_ImpClassifHSNo = "//input[@id='hsNo_resultStdHsPopup']";
	public static final String OCR_ConfidenceLevel = "//select[@name='levelCode']";
	public static final String OCR_ImpClassifCreatedBy = "(//a[contains(text(),'Created By')])[4]";
	public static final String OCR_ImpClassifCreatedDateFrom = "//input[@id='resultProductTableReport_frmCustClsCreatedOn']";
	public static final String OCR_ImpClassifCreatedDateTo = "//input[@id='resultProductTableReport_toCustClsCreatedOn']";
	public static final String OCR_ImpClassifModifiedBy = "(//a[contains(text(),'Modified By')])[4]";
	public static final String OCR_ImpClassifModifiedDateFrom = "//input[@id='resultProductTableReport_frmCustClsModifiedOn']";
	public static final String OCR_ImpClassifModifiedDateTo = "//input[@id='resultProductTableReport_toCustClsModifiedOn']";
	public static final String OCR_Button_Search = "//button[contains(text(),'Search')]";
	public static final String OCR_HomePage_ListScreening = "//ul[@class='nav navbar-nav']/li[2]/a";
	public static final String OCR_Button_Select = "//button[contains(text(),'Select')]";
	public static final String OCR_POPupClose = "//div[@id='ocrModal']//button[@class='btn-close']";

	/* ******************** Constructor ***************************** */
	public SearchProductReportPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	public void searchProductDetails(String SBUCode, String Status, String PartNo, String SKUNo, String PartNoManuf,
			String SourcePartNo, String Description, String ModelNo, String ProductName, String MaterialType,
			String ProductLine, String ProgramCode, String SiteId, String Hazardous, String ReasonCode,
			String NationalStockNumber, String CreatedByUN, String CreatedDateFrom, String CreatedDateTo,
			String ModifiedbyUN, String ModifiedDateFrom, String ModifiedDateTo, String SortBy, String Direction) {
		Wait.waitfor(3);
		selectByVisibleText(driver, test, OCR_SBUCode, " Enter SBU Code : ", SBUCode);
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCR_Status, "Enter Status : ", Status);
		Wait.waitfor(2);
		typeText(driver, test, OCR_PartNo, "Enter Part No : ", PartNo);
		Wait.waitfor(2);
		typeText(driver, test, OCR_SKUNO, "Enter SKU No : ", SKUNo);
		Wait.waitfor(2);
		typeText(driver, test, OCR_PartNoManuf, "Enter Part No Manufacturer : ", PartNoManuf);
		Wait.waitfor(2);
		typeText(driver, test, OCR_SourcePartNo, "Enter Source Part No : ", SourcePartNo);
		Wait.waitfor(2);
		typeText(driver, test, OCR_Description, "Enter Description : ", Description);
		Wait.waitfor(2);
		typeText(driver, test, OCR_ModelNo, "Enter Model No : ", ModelNo);
		Wait.waitfor(2);
		typeText(driver, test, OCR_ProductName, "Enter Product Name : ", ProductName);
		Wait.waitfor(2);
		typeText(driver, test, OCR_MaterialType, "Enter Material Type : ", MaterialType);
		Wait.waitfor(2);

	/*	if (ProductLine.length() > 0) {
			Wait.waitfor(10);
			clickElement(driver, test, OCR_ProductLine, "Clicking on Product Line");
			try {
				Wait.waitfor(10);
				String addproductline = "//td[contains(text(),'"+ProductLine+"')]";
				if (isDisplayed(driver, addproductline)) {
					clickElement(driver, test, addproductline, "Click on search record");
					test.log(LogStatus.PASS, "Add Product Line in add to result grid table : " + ProductLine);
					Wait.waitfor(3);
					clickElement(driver, test, OCR_Button_Select, "Clicking on Select Button");
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add the Product Line");
				clickElement(driver, test, OCR_POPupClose, "Close the Pop UP");
			}*/

			if (ProductLine.length() > 0) {
			
				clickElement(driver, test, OCR_ProductLine, "Clicking on Product Line");
				try {
					
						clickElement(driver, test, "//td[contains(text(),'"+ProductLine+"')]", "Click on search record");
					
						clickElement(driver, test, OCR_Button_Select, "Clicking on Select Button");
					}
				 catch (Exception e) {
					testFailSshot(driver, test);
					test.log(LogStatus.FAIL, "Fail to add the Product Line");
					clickElement(driver, test, OCR_POPupClose, "Close the Pop UP");
				}

		

		if (ProgramCode.length() > 0) {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_Program, "Clicking on Program");
			try {
				typeText(driver, test, OCR_ProgramCode, "Enter the Program Code : ", ProgramCode);
				Wait.waitfor(3);
				clickElement(driver, test, "(//button[contains(text(),'Search')])[2]", "Clicking on search button");
				Wait.waitfor(3);
				String addprogram = "//table[@id='gridPopup']/tbody/tr/td[contains(text(),'" + ProgramCode + "')]";
				if (isDisplayed(driver, addprogram)) {
					clickElement(driver, test, addprogram, "Click on search record");
					test.log(LogStatus.PASS, "Add Program add to result grid table : " + ProgramCode);
					clickElement(driver, test, OCR_Button_Select, "Clicking on Select Button");
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add the Flag Reason Code");
				clickElement(driver, test, OCR_POPupClose, "Close the Pop UP");
			}

		}
		if (SiteId.length() > 0) {
			Wait.waitfor(3);
			scrollToElement(driver, OCR_Site);
			clickElement(driver, test, OCR_Site, "Clicking on Site");
			try {
				typeText(driver, test, OCR_SiteId, "Enter Site Id : ", SiteId);
				Wait.waitfor(3);
				clickElement(driver, test, "(//button[contains(text(),'Search')])[2]", "Clicking on Search");
				String addsite = "//table[@id='gridPopup']/tbody/tr/td[contains(text(),'" + SiteId + "')]";
				if (isDisplayed(driver, addsite)) {
					clickElement(driver, test, addsite, "Click on search record");
					test.log(LogStatus.PASS, "Add Site to result grid table : " + SiteId);
					Wait.waitfor(3);
					clickElement(driver, test, OCR_Button_Select, "Clicking on Select Button");
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add the Flag Reason Code");
				clickElement(driver, test, OCR_POPupClose, "Close the Pop UP");
			}
		}
		Wait.waitfor(3);
		selectByVisibleText(driver, test, OCR_Hazardous, "Select hazardous: ", Hazardous);
		Wait.waitfor(3);
		if (ReasonCode.length() > 0) {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_FlagReason, "Clicking on FlagReason");
			try {
				Wait.waitfor(3);
				typeText(driver, test, OCR_ReasonCode, "Enter Reason Code : ", ReasonCode);
				Wait.waitfor(3);
				clickElement(driver, test, "(//button[contains(text(),'Search')])[2]", "Clicking on Search");
				Wait.waitfor(3);
				String addsite = "//table[@id='gridPopup']/tbody/tr/td[contains(text(),'" + ReasonCode + "')]";
				if (isDisplayed(driver, addsite)) {
					clickElement(driver, test, addsite, "Click on search record");
					test.log(LogStatus.PASS, "Add Flag Reason to result grid table : " + ReasonCode);
					clickElement(driver, test, OCR_Button_Select, "Clicking on Select Button");
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add the Flag Reason Code");
				clickElement(driver, test, OCR_POPupClose, "Close the Pop UP");
			}

		}
		typeText(driver, test, OCR_NationalStockNo, "Enter National Stock No : ", NationalStockNumber);
		if (CreatedByUN.length() > 0) {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_CreatedBy, "Created By");
			try {
				typeText(driver, test, OCR_CreatedByUN, "Created By", CreatedByUN);
				Wait.waitfor(3);
				clickElement(driver, test, "(//button[contains(text(),'Search')])[2]", "Clicking on Search Button");
				String addusername = "//table[@id='gridPopup']/tbody/tr/td[contains(text(),'" + CreatedByUN + "')]";

				if (isDisplayed(driver, addusername)) {
					clickElement(driver, test, addusername, "Click on search record");
					test.log(LogStatus.PASS, "Add Created By to result grid table : " + CreatedByUN);
					clickElement(driver, test, OCR_Button_Select, "Clicking on Select Button");
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add the Flag Reason Code");
				clickElement(driver, test, OCR_POPupClose, "Close the Pop UP");
			}

		}
		if (CreatedDateFrom.length() > 0) {
			clickElement(driver, test, OCR_CreatedDateFrom, "Click on Created Date From");
			Wait.waitfor(1);
			date(driver, test, "Selected on Created Date From : ", CreatedDateFrom);
			Wait.waitfor(2);
			clickElement(driver, test, OCR_CreatedDateTo, "Click on Created Date To");
			Wait.waitfor(1);
			date(driver, test, "Selected on Created Date To : ", CreatedDateTo);
		}

		if (ModifiedbyUN.length() > 0) {
			scrollToElement(driver, "//label[contains(text(),'Sort By')]");
			Wait.waitfor(5);
			clickElement(driver, test, OCR_ModifiedBy, "Clicking on Modified By");
			typeText(driver, test, OCR_ModifiedbyUN, "Created By", ModifiedbyUN);
			Wait.waitfor(5);
			clickElement(driver, test, "(//button[contains(text(),'Search')])[2]", "Clicking on Search Button");
			Wait.waitfor(5);
			String addusername = "//table[@id='gridPopup']/tbody/tr/td[contains(text(),'" + ModifiedbyUN + "')]";
			try {
				if (isDisplayed(driver, addusername)) {
					clickElement(driver, test, addusername, "Click on search record");
					test.log(LogStatus.PASS, "Add Created By to result grid table : " + ModifiedbyUN);
					Wait.waitfor(5);
					clickElement(driver, test, OCR_Button_Select, "Clicking on Select Button ");
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add Modified By: ");
				clickElement(driver, test, OCR_POPupClose, "Close the Pop UP");
			}

		}

		if (ModifiedDateFrom.length() > 0) {
			clickElement(driver, test, OCR_ModifiedDateFrom, "Click on Modified Date From");
			date(driver, test, "Selected on Modified Date From : ", ModifiedDateFrom);
			Wait.waitfor(2);
			clickElement(driver, test, OCR_ModifiedDateTo, "Click on Modified Date To");
			date(driver, test, "Selected on Modified Date To : ", ModifiedDateTo);
		}
		selectByVisibleText(driver, test, OCR_SortBy, "Select Sort By: ", SortBy);
		selectByVisibleText(driver, test, OCR_Direction, "Select Direction: ", Direction);
	}}

	public void searchmanufacturerdetails(String ManufacturerCode, String DomesticForeign, String CountryofOrigin,
			String ManfPartNo, String ManfCreatedBy, String ManfCrDateFrom, String ManfCrDateTo, String ManfModifiedBy,
			String ManfModDateFrom, String ManfModDateTo) {
		Wait.waitfor(10);
		scrollToElement(driver, "//label[contains(text(),'Search Manufacturer')]");
		clickElement(driver, test, "//label[contains(text(),'Search Manufacturer')]", "Clicking on Manufacturer tab");
		if (ManufacturerCode.length() > 0) {
			Wait.waitfor(10);
			clickElement(driver, test, OCR_Manufacturer, "Clicking on Manufacturer Link");
			typeText(driver, test, OCR_ManufacturerCode, "Enter Manufacturer Code", ManufacturerCode);
			clickElement(driver, test, "(//button[contains(text(),'Search')])[3]", "Clicking on Search Button:");
			String addmanufcode = "//table[@id='gridPopup']/tbody/tr/td[contains(text(),'" + ManufacturerCode + "')]";
			try {
				if (isDisplayed(driver, addmanufcode)) {
					clickElement(driver, test, addmanufcode, "Click on search record");
					test.log(LogStatus.PASS, "Add Manufacturer Code to result grid table : " + ManufacturerCode);
					clickElement(driver, test, OCR_Button_Select, "Clicking on Select Button:");
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add the Flag Reason Code");
				clickElement(driver, test, OCR_POPupClose, "Close the Pop UP");
			}

		}
		selectByVisibleText(driver, test, OCR_Domestic_Foreign, "Clicking on domestic foreign", DomesticForeign);
		typeText(driver, test, OCR_CountryOfOrigin, "Clicking on CountryOfOrigin: ", CountryofOrigin);
		typeText(driver, test, OCR_ManufPartNo, "Clicking on Manufacturer PartNo ", ManfPartNo);

		if (ManfCreatedBy.length() > 0) {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_ManufCreatedBy, "Manufacturer Created By :");
			try {
				typeText(driver, test, OCR_CreatedByUN, "Created By", ManfCreatedBy);
				Wait.waitfor(5);
				clickElement(driver, test, "(//button[contains(text(),'Search')])[2]", "Clicking on Search Button:");
				String addusername = "//table[@id='gridPopup']/tbody/tr/td[contains(text(),'" + ManfCreatedBy + "')]";

				if (isDisplayed(driver, addusername)) {
					clickElement(driver, test, addusername, "Click on search record");
					test.log(LogStatus.PASS, "Add Created By to result grid table : " + ManfCreatedBy);
					clickElement(driver, test, OCR_Button_Select, "Clicking on Select Button: ");
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add Manufacturer Created By: ");
				clickElement(driver, test, OCR_POPupClose, "Close the Pop UP");
			}

		}
		if (ManfCrDateFrom.length() > 0) {
			clickElement(driver, test, OCR_ManufCreatedDateFrom, "Click on Manufacturer Created Date From");
			date(driver, test, "Selected on Created Date From : ", ManfCrDateFrom);
			clickElement(driver, test, OCR_ManufCreatedDateTo, "Click on Manufacturer Created Date To");
			date(driver, test, "Selected on Created Date To : ", ManfCrDateTo);
		}

		if (ManfModifiedBy.length() > 0) {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_ManufModifiedBy, "Clicking on Modified By");
			try {
				typeText(driver, test, OCR_ModifiedbyUN, "Enter Modified By: ", ManfModifiedBy);
				Wait.waitfor(3);
				clickElement(driver, test, "(//button[contains(text(),'Search')])[2]", "Clicking on Search Button:");
				Wait.waitfor(3);
				String addusername = "//table[@id='gridPopup']/tbody/tr/td[contains(text(),'" + ManfModifiedBy + "')]";
				if (isDisplayed(driver, addusername)) {
					clickElement(driver, test, addusername, "Click on search record");
					test.log(LogStatus.PASS, "Add Created By to result grid table : " + ManfModifiedBy);
					Wait.waitfor(3);
					clickElement(driver, test, OCR_Button_Select, "Clicking on Select Button: ");
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add the Flag Reason Code");
				clickElement(driver, test, OCR_POPupClose, "Close the Pop UP");
			}
		}
		if (ManfModDateFrom.length() > 0) {
			clickElement(driver, test, OCR_ManufModifiedDateFrom, "Click on Modified Date From");
			Wait.waitfor(3);
			System.out.println(ManfModDateFrom);
			date(driver, test, "Selected on Modified Date From : ", ManfModDateFrom);
			Wait.waitfor(3);
			clickElement(driver, test, OCR_ManufModifiedDateTo, "Click on Modified Date To");
			date(driver, test, "Selected on Modified Date To : ", ManfModDateFrom);
		}
		Wait.waitfor(3);
	}

	public void click_manufacturertab() {
		clickElement(driver, test, "//label[contains(text(),'Search Manufacturer')]", "Clicking on Manufacturer tab");
	}

	public void search() {
		scrollToElement(driver, OCR_Button_Search);
		scrollToTop(driver);
		Wait.waitfor(4);
		clickElement(driver, test, OCR_Button_Search, "Clicking on Search Button");
	}

	public void click_ExportClassificationtab() {
		scrollToElement(driver, "//label[contains(text(),'Search Export Classification')]");
		clickElement(driver, test, "//label[contains(text(),'Search Export Classification')]",
				"Clicking on Export Classification Tab: ");
	}

	public void searchexportdetails(String CountryofClassification, String ECCN, String TechDataRefNo,
			String AssExpClassifECCN, String ExpCreatedBy, String ExpCrDateFrom, String ExpCrDateTo,
			String ExpModifiedBy, String ExpModDateFrom, String ExpModDateTo) {
		Wait.waitfor(3);
		scrollToElement(driver, "//label[contains(text(),'Search Export Classification')]");
		clickElement(driver, test, "//label[contains(text(),'Search Export Classification')]",
				"Clicking on Export Classification Tab: ");
		if (CountryofClassification.length() > 0) {
			typeText(driver, test, OCR_CountryOfClassification, "Enter Country Of Classification",
					CountryofClassification);
			Wait.waitfor(3);
			clickElement(driver, test, "//div[contains(text(),'" + CountryofClassification + "')]", "Click");
			Wait.waitfor(3);
			if (ECCN.length() > 0) {
				scrollToElement(driver, "//label[contains(text(),'Search Export Classification')]");
				clickElement(driver, test, OCR_ExpClassification, "Clicking on Export Classification Link");
				Wait.waitfor(5);
				try {
					typeText(driver, test, OCR_ExpClassifECCN, "Enter ECCN", ECCN);
					Wait.waitfor(5);
					clickElement(driver, test, "(//button[contains(text(),'Search')])[3]",
							"Clicking on Search Button:");
					Wait.waitfor(5);
					String addECCN = "//table[@id='gridPopup']/tbody/tr/td[contains(text(),'" + ECCN + "')]";

					if (isDisplayed(driver, addECCN)) {
						clickElement(driver, test, addECCN, "Click on search record");
						test.log(LogStatus.PASS, "Add ECCN to result grid table : " + ECCN);
						Wait.waitfor(3);
						clickElement(driver, test, OCR_Button_Select, "Clicking on Select Button: ");
					}
				} catch (Exception e) {
					testFailSshot(driver, test);
					test.log(LogStatus.FAIL, "Fail to add the ECCN");
					clickElement(driver, test, OCR_POPupClose, "Close the Pop UP");
				}
			}
		}
		typeText(driver, test, OCR_TechDataRefNo, "Enter Tech Data Ref No:", TechDataRefNo);
		Wait.waitfor(3);
		if (ExpCreatedBy.length() > 0) {
			Wait.waitfor(5);
			clickElement(driver, test, OCR_ExpClassCreatedBy, "Export Classification Created By :");
			typeText(driver, test, OCR_CreatedByUN, "Created By", ExpCreatedBy);
			clickElement(driver, test, "(//button[contains(text(),'Search')])[2]", "Clicking on Search Button:");
			Wait.waitfor(5);
			String addusername = "//table[@id='gridPopup']/tbody/tr/td[contains(text(),'" + ExpCreatedBy + "')]";
			try {
				if (isDisplayed(driver, addusername)) {
					clickElement(driver, test, addusername, "Click on search record");
					test.log(LogStatus.PASS, "Add Created By to result grid table : " + ExpCreatedBy);
					clickElement(driver, test, OCR_Button_Select, "Clicking on Select Button: ");
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add the Flag Reason Code");
				clickElement(driver, test, OCR_POPupClose, "Close the Pop UP");
			}

		}
		if (ExpCrDateFrom.length() > 0) {
			clickElement(driver, test, OCR_ExpClassCreatedDateFrom, "Click on Export Created Date From");
			date(driver, test, "Selected on Created Date From : ", ExpCrDateFrom);
			clickElement(driver, test, OCR_ExpClassCreatedDateTo, "Click on Export Created Date To");
			date(driver, test, "Selected on Created Date To : ", ExpCrDateTo);
		}
		if (ExpModifiedBy.length() > 0) {
			clickElement(driver, test, OCR_ExpClassModifiedBy, "Clicking on Modified By");
			Wait.waitfor(5);
			try {
				typeText(driver, test, OCR_ModifiedbyUN, "Created By", ExpModifiedBy);
				Wait.waitfor(5);
				clickElement(driver, test, "(//button[contains(text(),'Search')])[2]", "Clicking on Search Button:");
				Wait.waitfor(5);
				String addusername = "//table[@id='gridPopup']/tbody/tr/td[contains(text(),'" + ExpModifiedBy + "')]";

				if (isDisplayed(driver, addusername)) {
					clickElement(driver, test, addusername, "Click on search record");
					test.log(LogStatus.PASS, "Add Created By to result grid table : " + ExpModifiedBy);
					clickElement(driver, test, OCR_Button_Select, "Clicking on Select Button: ");
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add the Site ");
				clickElement(driver, test, OCR_POPupClose, "Close the Pop UP");
			}

		}
		if (ExpModDateFrom.length() > 0) {
			clickElement(driver, test, OCR_ExpClassModDateFrom, "Click on Export Modified Date From");
			date(driver, test, "Selected on Modified Date From : ", ExpModDateFrom);
			clickElement(driver, test, OCR_ExpClassModDateTo, "Click on Export Modified Date To");
			date(driver, test, "Selected on Modified Date To : ", ExpModDateTo);
		}
		Wait.waitfor(3);
	}

	public void movetocustomclassifcationtab() {
		scrollToElement(driver, "//label[contains(text(),'Search Customs Classification')]");
		clickElement(driver, test, "//label[contains(text(),'Search Customs Classification')]",
				"Clicking on Classification Tab: ");
	}

	public void searchcustumdetails(String CustCountryOfClassif, String ImpClassifHSNo, String CustCreatedBy,
			String CustCrDateFrom, String CustCrDateTo, String CustModifiedBy, String CustModDateFrom,
			String CustModDateTo) {
		Wait.waitfor(3);
		scrollToElement(driver, "//label[contains(text(),'Search Import Classification')]");
		clickElement(driver, test, "//label[contains(text(),'Search Import Classification')]",
				"Clicking on Classification Tab");
		Wait.waitfor(5);
		if (CustCountryOfClassif.length() > 0) {
			
			typeText(driver, test, OCR_CustCountryOfClassif, "Enter Custom Classification", CustCountryOfClassif);
			Wait.waitfor(8);
			clickElement(driver, test, "//div[contains(text(),'" + CustCountryOfClassif + "')]",
					"Click on SmartHint: custom country of  class ");
			Wait.waitfor(8);
			typeText(driver, test, OCR_ImportClassif, "Enter Import Classification HS No", ImpClassifHSNo);
		}
		if (CustCreatedBy.length() > 0) {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_ImpClassifCreatedBy, "Import Classification Created By");
			try {
				typeText(driver, test, OCR_CreatedByUN, "Created By", CustCreatedBy);
				Wait.waitfor(5);
				clickElement(driver, test, "(//button[contains(text(),'Search')])[2]", "Clicking on Search Button:");
				Wait.waitfor(5);
				String addusername = "//table[@id='gridPopup']/tbody/tr/td[contains(text(),'" + CustCreatedBy + "')]";

				if (isDisplayed(driver, addusername)) {
					clickElement(driver, test, addusername, "Click on search record");
					test.log(LogStatus.PASS, "Add Created By to result grid table : " + CustCreatedBy);
					clickElement(driver, test, OCR_Button_Select, "Clicking on Select Button: ");
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add the Flag Reason Code");
				clickElement(driver, test, OCR_POPupClose, "Close the Pop UP");
			}
		}
		if (CustCrDateFrom.length() > 0) {
			clickElement(driver, test, OCR_ImpClassifCreatedDateFrom, "Click on Custom Created Date From");
			date(driver, test, "Selected on Created Date From : ", CustCrDateFrom);
			clickElement(driver, test, OCR_ImpClassifCreatedDateTo, "Click on Custom Created Date To");
			date(driver, test, "Selected on Created Date To : ", CustCrDateTo);
		}
		if (CustModifiedBy.length() > 0) {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_ImpClassifModifiedBy, "Clicking on Modified By");
			try {
				typeText(driver, test, OCR_ModifiedbyUN, "Created By", CustModifiedBy);
				Wait.waitfor(5);
				clickElement(driver, test, "(//button[contains(text(),'Search')])[2]", "Clicking on Search Button:");
				Wait.waitfor(5);
				String addusername = "//table[@id='gridPopup']/tbody/tr/td[contains(text(),'" + CustModifiedBy + "')]";
				if (isDisplayed(driver, addusername)) {
					clickElement(driver, test, addusername, "Click on search record");
					test.log(LogStatus.PASS, "Add Created By to result grid table : " + CustModifiedBy);
					clickElement(driver, test, OCR_Button_Select, "Clicking on Select Button: ");
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add the Custom Modified By:");
				clickElement(driver, test, OCR_POPupClose, "Close the Pop UP");
			}

		}
		if (CustModDateFrom.length() > 0) {
			clickElement(driver, test, OCR_ImpClassifModifiedDateFrom, "Click on Custom Modified Date From");
			Wait.waitfor(3);
			date(driver, test, "Selected on Modified Date From : ", CustModDateFrom);
			clickElement(driver, test, OCR_ImpClassifModifiedDateTo, "Click on Custom Modified Date To");
			date(driver, test, "Selected on Modified Date To : ", CustModDateTo);
		}
	}

}
