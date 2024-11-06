package bulkUpdateClassificationClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class SearchBulkProductPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_SearchBulkProduct_SBUCode = "//select[@id='resultProductMassControl_product_sbuCode']";
	public static final String OCR_SearchBulkProduct_Status = "//select[@id='resultProductMassControl_product_status']";
	public static final String OCR_SearchBulkProduct_PartNoPopup = "//a[contains(text(),'Part No.')]";
	public static final String OCR_SearchBulkProduct_PartNo = "//input[@id='searchForm_product_productCode']";
	public static final String OCR_SearchBulkProduct_Search = "//button[@name='Search']";
	public static final String OCR_SearchBulkProduct_SearchPopup = "//button[@id='searchHsDtlBtn']";
	public static final String OCR_SearchBulkProduct_Select = "(//button[contains(text(),'Select')])[1]";
	public static final String OCR_POPupClose = "(//button[contains(text(),'Cancel')])[2]";
	public static final String OCR_SearchBulkProduct_ModelNo = "//input[@id='resultProductMassControl_product_modelNo']";
	public static final String OCR_SearchBulkProduct_PartDescription = "//textarea[@id='resultProductMassControl_product_productDesc']";
	public static final String OCR_SearchBulkProduct_NationalStockNo = "//input[@id='resultProductMassControl_product_nationalStockNumber']";
	public static final String OCR_SearchBulkProduct_FlagReasonPopup = "//body/div[@id='content-cont']/form[@id='resultProductMassControl']/div[3]/div[1]/div[6]/fieldset[1]/div[4]/label[1]/a[1]";
	public static final String OCR_SearchBulkProduct_FlagReasonCode = "//input[@id='flagReasonPopupForm_flagReason_reasonCode']";
	public static final String OCR_SearchBulkProduct_Manufacturer = "//input[@id='resultProductMassControl_product_manufacturer']";
	public static final String OCR_SearchBulkProduct_CreatedBy = "//select[@id='resultProductMassControl_product_createdBy']";
	public static final String OCR_SearchBulkProduct_CreatedDateFrom = "//input[@id='resultProductMassControl_fromPrdCrdOn']";
	public static final String OCR_SearchBulkProduct_CreatedDateTo = "//input[@id='resultProductMassControl_toPrdCrdOn']";
	public static final String OCR_SearchBulkProduct_CountryofClassification = "//select[@id='resultProductMassControl_countryCode']";
	public static final String OCR_SearchBulkProduct_ModifiedDateFrom = "//input[@id='resultProductMassControl_fromPrdMfdOn']";
	public static final String OCR_SearchBulkProduct_ModifiedDateTo = "//input[@id='resultProductMassControl_toPrdMfdOn']";
	public static final String OCR_SearchBulkProduct_SkuNo = "//input[@id='resultProductMassControl_product_skuNo']";
	public static final String OCR_SearchBulkProduct_ExportClassificationPopoup = "//a[@id='expClsLnk']";
	public static final String OCR_SearchBulkProduct_ExportClassificationEccn = "//input[@id='searchForm_productClazz_prodClassification']";
	public static final String OCR_SearchBulkProduct_ExportMissingClassification = "//input[@id='resultProductMassControl_missingExpClass']";
	public static final String OCR_SearchBulkProduct_ExportInvalidClassification = "//input[@id='resultProductMassControl_invalidExpClass']";
	public static final String OCR_SearchBulkProduct_ExportAuthorityPopup = "//a[@id='expAuthPopUp']";
	public static final String OCR_SearchBulkProduct_ImportClassificationPopup = "//a[@id='htsNoLnk']";
	public static final String OCR_SearchBulkProduct_ImportClassificationHsNo = "//input[@id='hsNo_resultStdHsPopup']";
	public static final String OCR_SearchBulkProduct_ImportClassificationEffectiveDate = "//input[@id='effectiveDate_resultStdHsPopup']";
	public static final String OCR_SearchBulkProduct_ImportMissingClassification = "//input[@id='resultProductMassControl_missingImpClass']";
	public static final String OCR_SearchBulkProduct_ImportInvalidClassification = "//input[@id='resultProductMassControl_invalidImpClass']";
	public static final String OCR_SearchBulkProduct_StatisticalClassificationPopup = "//a[@id='schedulebLink']";
	public static final String OCR_SearchBulkProduct_StatisticalClassificationHtsNo = "//input[@id='searchForm_schbhtsNo']";
	public static final String OCR_SearchBulkProduct_StatisticalClassificationSearch = "(//button[contains(text(),'Search')])[2]";
	public static final String OCR_SearchBulkProduct_StatisticalPopupClose = "(//button[contains(text(),'Cancel')])[2]";
	public static final String OCR_SearchBulkProduct_StatisticalMissingClassification = "//input[@id='resultProductMassControl_missingSchBClass']";
	public static final String OCR_SearchBulkProduct_StatisticalInvalidClassification = "//input[@id='resultProductMassControl_invalidSchBClass']";
	public static final String OCR_SearchBulkProduct_SortBy = "//select[contains(@name,'sortBy')]";
	public static final String OCR_SearchBulkProduct_Direction = "//select[contains(@name,'direction')]";
	public static final String OCR_SearchBulkProduct = "//body/div[@id='content-cont']/form[@id='resultProductMassControl']/div[3]/div[1]/div[2]/div[1]/button[1]";
	public static final String OCR_SearchBulkProduct_SearchButton = "(//button[contains(text(),'Search')])[1]";
	/****************************************************************************************************************************/
	public static final String OCR_UpdateBulkProduct_SelectProduct = "//a[contains(text(),'CA_TEST01')]/../../td[1]";
	public static final String OCR_UpdateBulkProduct_CountryClassification = "//select[@id='massControlCountryCode']";
	public static final String OCR_UpdateBulkProduct_Status = "//select[@id='status']";
	public static final String OCR_UpdateBulkProduct_NewExportClassificationLink = "//a[@id='eccnPopup']";
	public static final String OCR_UpdateBulkProduct_NewExportClassificationEccnNo = "//input[@id='searchForm_productClazz_prodClassification']";
	public static final String OCR_UpdateBulkProduct_NewExportClassificationSetEmptyCheckbox = "//input[@id='resultProductMassControl_newEccnEmpty']";
	public static final String OCR_UpdateBulkProduct_NewExportAuthorityLink = "//a[@id='expAuthPopUp']";
	public static final String OCR_UpdateBulkProduct_NewExportAuthoritySetEmptyCheckbox = "//input[@id='resultProductMassControl_expauth']";
	public static final String OCR_UpdateBulkProduct_NewImportClassificationLink = "//a[@id='htsCode']";
	public static final String OCR_UpdateBulkProduct_NewImportClassificationHsNo = "//input[@id='hsNo_resultStdHsPopup']";
	public static final String OCR_UpdateBulkProduct_NewImportClassificationSetEmptyCheckbox = "//input[@id='resultProductMassControl_newHtsEmpty']";
	public static final String OCR_UpdateBulkProduct_ReasonForChange = "//textarea[@id='resultProductMassControl_reasonForChange']";
	public static final String OCR_UpdateBulkProduct_NewStatisticalClassificationLink = "//a[@id='schedulebLink']";
	public static final String OCR_UpdateBulkProduct_NewStatisticalClassificationHtsNo = "//input[@id='searchForm_schbhtsNo']";
	public static final String OCR_UpdateBulkProduct_NewStatisticalClassificationSearch = "(//button[contains(text(),'Search')])[2]";
	public static final String OCR_UpdateBulkProduct_NewStatisticalClassificationSetEmptyCheckbox = "//input[@id='resultProductMassControl_newSchBEmpty']";
	public static final String OCR_UpdateBulkProduct_PartDescription = "//textarea[@id='newCommonDesc']";
	public static final String OCR_UpdateBulkProduct_PartDescriptionApplyButton = "//button[contains(text(),'Apply')]";
	public static final String OCR_UpdateBulkProduct_FlagReasonLink = "(//a[contains(text(),'Flag Reason')])[2]";
	public static final String OCR_UpdateBulkProduct_RemoveFlagCheckbox = "//input[@id='resultProductMassControl_removeFlagReason']";
	public static final String OCR_SearchBulkProduct_UpdateButton = "//button[contains(text(),'Update')]";
	
	
	
	
	/* ******************** Constructor ***************************** */
	public SearchBulkProductPage(WebDriver driver, ExtentTest test) {

		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */
	
	public void searchProductDetails(String SBUCode, String Status, String PartNo, String ModelNo,
			String PartDescription, String NationalStockNumber, String FlagReasonCode, String Manufacturer, String CreatedBy, String CreatedDateFrom, String CreatedDateTo, String CountryOfClassification,
			String ModifiedDateFrom, String ModifiedDateTo, String SKUNo, String ExportClassificationEccnNo, String ExportClassification, String ExportAuthorityCode,
			String ImportClassificationHSNo, String ImportClassificationEffectiveDate, String ImportClassification, String StatisticalClassificationHtsNo, String StatisticalClassification, 
			String SortBy, String Direction) throws InterruptedException {
		
		selectByVisibleText(driver, test, OCR_SearchBulkProduct_SBUCode, "Select Sbu Code ", SBUCode);
		selectByVisibleText(driver, test, OCR_SearchBulkProduct_Status, "Select Status ", Status);
		
		if (PartNo.length() > 0) {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_SearchBulkProduct_PartNoPopup, "Click PartNo Popup");
			try {
				typeText(driver, test, OCR_SearchBulkProduct_PartNo, "Enter PartNo ", PartNo);
				clickElement(driver, test, OCR_SearchBulkProduct_Search, "Click Search Button");
				String partNo = "(//td[contains(text(),'" + PartNo + "')])[1]";
				clickElement(driver, test, partNo, "Click PartNo :" + PartNo);
				clickElement(driver, test, OCR_SearchBulkProduct_Select, "Click Program Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add the Site ");
				clickElement(driver, test, OCR_POPupClose, "Close the Pop UP");
			}
		}
		
		typeText(driver, test, OCR_SearchBulkProduct_ModelNo, "Enter Model No ", ModelNo);
		typeText(driver, test, OCR_SearchBulkProduct_PartDescription, "Enter Part Description ", PartDescription);
		typeText(driver, test, OCR_SearchBulkProduct_NationalStockNo, "Enter National StockNo ", NationalStockNumber);
		
		if (FlagReasonCode.length() > 0) {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_SearchBulkProduct_FlagReasonPopup, "Click Flag Reason Popup");
			try {
				typeText(driver, test, OCR_SearchBulkProduct_FlagReasonCode, "Enter Flag Reason Code ", FlagReasonCode);
				clickElement(driver, test, OCR_SearchBulkProduct_Search, "Click Search Button");
				String reasonCode = "//td[contains(text(),'" + FlagReasonCode + "')]";
				clickElement(driver, test, reasonCode, "Click Flag Reason Code :" + FlagReasonCode);
				clickElement(driver, test, OCR_SearchBulkProduct_Select, "Click Program Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add the Flag Reason Code");
				clickElement(driver, test, OCR_POPupClose, "Close the Pop UP");
			}
		}
		
		typeText(driver, test, OCR_SearchBulkProduct_Manufacturer, "Enter Manufacturer ", Manufacturer);
		selectByVisibleText(driver, test, OCR_SearchBulkProduct_CreatedBy, "Select Created By ", CreatedBy);
		
		if (CreatedDateFrom.length() > 0) {
			clickElement(driver, test, OCR_SearchBulkProduct_CreatedDateFrom,
					"Click on Created Date From");
			date(driver, test, "Selected on Created Date From : ", CreatedDateFrom);
			Wait.waitfor(2);
			clickElement(driver, test, OCR_SearchBulkProduct_CreatedDateTo, "Click on Created Date To");
			date(driver, test, "Selected on Created Date To : ", CreatedDateTo);
		}
		
		selectByVisibleText(driver, test, OCR_SearchBulkProduct_CountryofClassification, "Select Country Of Classification ", CountryOfClassification);
		
		if (ModifiedDateFrom.length() > 0) {
			clickElement(driver, test, OCR_SearchBulkProduct_ModifiedDateFrom,
					"Click on Modified Date From");
			date(driver, test, "Selected on Modified Date From : ", ModifiedDateFrom);
			Wait.waitfor(2);
			clickElement(driver, test, OCR_SearchBulkProduct_ModifiedDateTo, "Click on Modified Date To");
			date(driver, test, "Selected on Modified Date To : ", ModifiedDateTo);
		}
		
		typeText(driver, test, OCR_SearchBulkProduct_SkuNo, "Enter SkuNo ", SKUNo);
		
		if (ExportClassificationEccnNo.length() > 0) {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_SearchBulkProduct_ExportClassificationPopoup, "Click Export Classification Popup");
			try {
				typeText(driver, test, OCR_SearchBulkProduct_ExportClassificationEccn, "Enter Export Classification Eccn No ", ExportClassificationEccnNo);
				clickElement(driver, test, OCR_SearchBulkProduct_Search, "Click Search Button");
				String eccnNo = "//td[contains(text(),'" + ExportClassificationEccnNo + "')]";
				clickElement(driver, test, eccnNo, "Click Eccn No :" + ExportClassificationEccnNo);
				clickElement(driver, test, OCR_SearchBulkProduct_Select, "Click Program Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add the Flag Reason Code");
				clickElement(driver, test, OCR_POPupClose, "Close the Pop UP");
			}
		}
		
		else if (ExportClassification.equalsIgnoreCase("Missing")){
			clickElement(driver, test, OCR_SearchBulkProduct_ExportMissingClassification, "Click Export Missing Classification");
			
		}
		else if (ExportClassification.equalsIgnoreCase("Invalid")){
			clickElement(driver, test, OCR_SearchBulkProduct_ExportInvalidClassification, "Click Export Invalid Classification");
		}
		
		
		/*if(ExportMissingClassification.length() > 0) {
			clickElement(driver, test, OCR_SearchBulkProduct_ExportMissingClassification, "Click Export Missing Classification");
		}
		
		if(ExportInvalidClassification.length() > 0) {
			clickElement(driver, test, OCR_SearchBulkProduct_ExportInvalidClassification, "Click Export Invalid Classification");
		}*/
		
		if (ExportAuthorityCode.length() > 0) {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_SearchBulkProduct_ExportAuthorityPopup, "Click Export Authority Popup");
			try {
				String authCode = "//td[contains(text(),'" + ExportAuthorityCode + "')]";
				clickElement(driver, test, authCode, "Click Export Authority Code :" + ExportAuthorityCode);
				clickElement(driver, test, OCR_SearchBulkProduct_Select, "Click Program Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add the Flag Reason Code");
				clickElement(driver, test, OCR_POPupClose, "Close the Pop UP");
			}
		}
		
		if (ImportClassificationHSNo.length() > 0) {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_SearchBulkProduct_ImportClassificationPopup, "Click Import Classification Popup");
			Wait.waitfor(3);
			try {
				typeText(driver, test, OCR_SearchBulkProduct_ImportClassificationHsNo, "Enter Import Classification Hs No ", ImportClassificationHSNo);
				clickElement(driver, test, OCR_SearchBulkProduct_ImportClassificationEffectiveDate, "Click on Effective Date To");
				date(driver, test, "Selected on Effective Date To : ", ImportClassificationEffectiveDate);
				Wait.waitfor(2);
				clickElement(driver, test, OCR_SearchBulkProduct_StatisticalClassificationSearch, "Click Search Button");
				String hsNo = "//div[contains(text(),'" + ImportClassificationHSNo + "')]";
				clickElement(driver, test, hsNo, "Click Hs No :" + ImportClassificationHSNo);
				clickElement(driver, test, OCR_SearchBulkProduct_Select, "Click Program Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add the Flag Reason Code");
				clickElement(driver, test, OCR_POPupClose, "Close the Pop UP");
			}
		}
		
		else if (ImportClassification.equalsIgnoreCase("Missing")){
			clickElement(driver, test, OCR_SearchBulkProduct_ImportMissingClassification, "Click Import Missing Classification");
			
		}
		else if (ImportClassification.equalsIgnoreCase("Invalid")){
			clickElement(driver, test, OCR_SearchBulkProduct_ImportInvalidClassification, "Click Import Invalid Classification");
		}
		
		/*if(ImportMissingClassification.length() > 0) {
			clickElement(driver, test, OCR_SearchBulkProduct_ImportMissingClassification, "Click Import Missing Classification");
		}
		
		if(ImportInvalidClassification.length() > 0) {
			clickElement(driver, test, OCR_SearchBulkProduct_ImportInvalidClassification, "Click Import Invalid Classification");
		}*/
		
		if (StatisticalClassificationHtsNo.length() > 0) {
			Wait.waitfor(2);
			clickElement(driver, test, OCR_SearchBulkProduct_StatisticalClassificationPopup, "Click Statistical Classification Popup");
			Wait.waitfor(5);
			try {
				typeText(driver, test, OCR_SearchBulkProduct_StatisticalClassificationHtsNo, "Enter Statistical Classification Hts No ", StatisticalClassificationHtsNo);
				clickElement(driver, test, OCR_SearchBulkProduct_StatisticalClassificationSearch, "Click Search Button");
				String htsNo = "//td[contains(text(),'" + StatisticalClassificationHtsNo + "')]";
				clickElement(driver, test, htsNo, "Click Statistical Hts No :" + StatisticalClassificationHtsNo);
				clickElement(driver, test, OCR_SearchBulkProduct_Select, "Click Program Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add the Flag Reason Code");
				clickElement(driver, test, OCR_SearchBulkProduct_StatisticalPopupClose, "Close the Pop UP");
			}
		}
		
		else if (StatisticalClassification.equalsIgnoreCase("Missing")){
			clickElement(driver, test, OCR_SearchBulkProduct_StatisticalMissingClassification, "Click Statistical Missing Classification");
			
		}
		else if (StatisticalClassification.equalsIgnoreCase("Invalid")){
			clickElement(driver, test, OCR_SearchBulkProduct_StatisticalInvalidClassification, "Click Statistical Invalid Classification");
		}
		
		/*if(StatisticalMissingClassification.length() > 0) {
			clickElement(driver, test, OCR_SearchBulkProduct_StatisticalMissingClassification, "Click Statistical Missing Classification");
		}
		
		if(StatisticalInvalidClassification.length() > 0) {
			clickElement(driver, test, OCR_SearchBulkProduct_StatisticalInvalidClassification, "Click Statistical Invalid Classification");
		}*/
		
		if (OCR_SearchBulkProduct_SortBy.length() > 0) {
		scrollToElement(driver, OCR_SearchBulkProduct_SortBy);
		selectByVisibleText(driver, test, OCR_SearchBulkProduct_SortBy, "Select SortBy ", SortBy);
		Wait.waitfor(3);
		}
		
		if (OCR_SearchBulkProduct_Direction.length() > 0) {
			scrollToElement(driver, OCR_SearchBulkProduct_SortBy);
		selectByVisibleText(driver, test, OCR_SearchBulkProduct_Direction, "Select Direction ", Direction);
		Wait.waitfor(3);
		}
		
	}
	
	
	public void updateProductDetails(String UpdatePartNo, String UpdateCountryOfClassification, String UpdateStatus, String UpdateNewExportClassificationEccnNo,
			String UpdateNewExportAuthorityCode, String UpdateNewImportClassificationHsNo, String UpdateReasonForChange, String UpdateNewStatisticalClassificationHtsNo,
			String UpdatePartDescription, String UpdateFlagReasonCode) throws InterruptedException {
		
		if (UpdatePartNo.length() > 0) {
			Wait.waitfor(3);
			String selectPartNo = "//a[contains(text(),'" + UpdatePartNo + "')]/../../td[2]";
			clickElement(driver, test, selectPartNo, "Select Part No :" + UpdatePartNo);
			
		}
		
//		clickElement(driver, test, OCR_UpdateBulkProduct_SelectProduct, "Click Product Check box");
		selectByVisibleText(driver, test, OCR_UpdateBulkProduct_CountryClassification, "Select Update CountryOfClassification ", UpdateCountryOfClassification);
		selectByVisibleText(driver, test, OCR_UpdateBulkProduct_Status, "Select Update Status ", UpdateStatus);
	
	
	if (UpdateNewExportClassificationEccnNo.length() > 0) {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_UpdateBulkProduct_NewExportClassificationLink, "Click New Export Classification Popup");
		try {
			typeText(driver, test, OCR_UpdateBulkProduct_NewExportClassificationEccnNo, "Enter New Export Classification Eccn No ", UpdateNewExportClassificationEccnNo);
			clickElement(driver, test, OCR_SearchBulkProduct_Search, "Click Search Button");
			String neweccnNo = "//td[contains(text(),'" + UpdateNewExportClassificationEccnNo + "')]";
			clickElement(driver, test, neweccnNo, "Click Eccn No :" + UpdateNewExportClassificationEccnNo);
			clickElement(driver, test, OCR_SearchBulkProduct_Select, "Click Program Select button");
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Fail to add the Flag Reason Code");
			clickElement(driver, test, OCR_POPupClose, "Close the Pop UP");
		}
	}
	
	if (UpdateNewExportAuthorityCode.length() > 0) {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_UpdateBulkProduct_NewExportAuthorityLink, "Click Export Authority Popup");
		try {
			String authCode = "//td[contains(text(),'" + UpdateNewExportAuthorityCode + "')]";
			clickElement(driver, test, authCode, "Click Export Authority Code :" + UpdateNewExportAuthorityCode);
			clickElement(driver, test, OCR_SearchBulkProduct_Select, "Click Program Select button");
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Fail to add the Flag Reason Code");
			clickElement(driver, test, OCR_POPupClose, "Close the Pop UP");
		}
	}
	
	if (UpdateNewImportClassificationHsNo.length() > 0) {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_UpdateBulkProduct_NewImportClassificationLink, "Click Import Classification Popup");
		try {
			typeText(driver, test, OCR_UpdateBulkProduct_NewImportClassificationHsNo, "Enter New Import Classification Eccn No ", UpdateNewImportClassificationHsNo);
			clickElement(driver, test, OCR_SearchBulkProduct_SearchPopup, "Click Search Button");
			String hsNo = "//div[contains(text(),'" + UpdateNewImportClassificationHsNo + "')]";
			clickElement(driver, test, hsNo, "Click Import HsNo :" + UpdateNewImportClassificationHsNo);
			clickElement(driver, test, OCR_SearchBulkProduct_Select, "Click Program Select button");
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Fail to add the Flag Reason Code");
			clickElement(driver, test, OCR_POPupClose, "Close the Pop UP");
		}
	}
	
	typeText(driver, test, OCR_UpdateBulkProduct_ReasonForChange, "Enter Reason For Change ", UpdateReasonForChange);
	
	if (UpdateNewStatisticalClassificationHtsNo.length() > 0) {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_UpdateBulkProduct_NewStatisticalClassificationLink, "Click Statistical Classification Popup");
		Wait.waitfor(6);
		try {
			typeText(driver, test, OCR_UpdateBulkProduct_NewStatisticalClassificationHtsNo, "Enter New Statistical Classification Hts No ", UpdateNewStatisticalClassificationHtsNo);
			clickElement(driver, test, OCR_UpdateBulkProduct_NewStatisticalClassificationSearch, "Click Search Button");
			String htsNo = "//td[contains(text(),'" + UpdateNewStatisticalClassificationHtsNo + "')]";
			clickElement(driver, test, htsNo, "Click Statistical HtsNo :" + UpdateNewStatisticalClassificationHtsNo);
			clickElement(driver, test, OCR_SearchBulkProduct_Select, "Click Program Select button");
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Fail to add the Flag Reason Code");
			clickElement(driver, test, OCR_POPupClose, "Close the Pop UP");
		}
	}
	
	
	if (UpdatePartDescription.length() > 0) {
		typeText(driver, test, OCR_UpdateBulkProduct_PartDescription, "Enter Part Description ", UpdatePartDescription);
		clickElement(driver, test, OCR_UpdateBulkProduct_PartDescriptionApplyButton, "Click Apply button");
		
	}
	
	if (UpdateFlagReasonCode.length() > 0) {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_UpdateBulkProduct_FlagReasonLink, "Click Flag Reason Popup");
		try {
			typeText(driver, test, OCR_SearchBulkProduct_FlagReasonCode, "Enter Flag Reason Code ", UpdateFlagReasonCode);
			clickElement(driver, test, OCR_SearchBulkProduct_Search, "Click Search Button");
			String reasonCode = "//td[contains(text(),'" + UpdateFlagReasonCode + "')]";
			clickElement(driver, test, reasonCode, "Click Flag Reason Code :" + UpdateFlagReasonCode);
			clickElement(driver, test, OCR_SearchBulkProduct_Select, "Click Program Select button");
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Fail to add the Flag Reason Code");
			clickElement(driver, test, OCR_POPupClose, "Close the Pop UP");
		}
	}

}
	
	public void click_BulkProductUpdate(String UpdatePartNo) throws InterruptedException {
		if (UpdatePartNo.length() > 0) {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_SearchBulkProduct_UpdateButton, "Click on Update Button");
		}}
	
	public void click_BulkProductSearch() throws InterruptedException {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_SearchBulkProduct_SearchButton, "Click on Search Button");
	}
}
