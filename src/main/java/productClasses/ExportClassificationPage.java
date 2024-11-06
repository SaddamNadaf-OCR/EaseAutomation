package productClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class ExportClassificationPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_ExportClassification = "(//label[1]/a[contains(text(), 'Export Classification')])[1]";
	public static final String OCR_Jurisdiction = "//select[@id='jurisdictionId']";
	public static final String OCR_ClassificationDate = "//input[@id='editProductExportClass_classificationDt']";
	public static final String OCR_ControllingAgencies = "//a[contains(text(),'Controlling Agencies')]";
	public static final String OCR_OCRCode = "//input[@id='editProductExportClass_productExportClazz_subProduct']";
	public static final String OCR_DateRevised = "//input[@id='editProductExportClass_revisedDt']";
	public static final String OCR_NewExportClassification = "//input[@id='editProductExportClass_productExportClazz_newClassification']";
	public static final String OCR_DateOfApplicability = "//input[@id='editProductExportClass_dateOfChange']";
	public static final String OCR_CCI = "//input[@id='editProductExportClass_userCheckbox1']";
	public static final String OCR_FDANumber = "//input[@id='editProductExportClass_productExportClazz_userDefinedField2']";
	public static final String OCR_TechDataRefNo = "//input[@id='editProductExportClass_productExportClazz_techDataRefNumber']";
	public static final String OCR_SME = "//select[@id='editProductExportClass_productExportClazz_sme']";
	public static final String OCR_ForeignVesselAircraft = "//select[@id='editProductExportClass_productExportClazz_ufva']";
	public static final String OCR_MDE = "//select[@id='editProductExportClass_productExportClazz_equipment']";
	public static final String OCR_MEU = "//select[@id='editProductExportClass_productExportClazz_meu']";
	public static final String OCR_CCPortion = "//select[@id='editProductExportClass_productExportClazz_ccPortion']";
	public static final String OCR_ATFForm9Req = "//select[@id='editProductExportClass_batf']";
	public static final String OCR_FCCNo = "//input[@id='editProductExportClass_productExportClazz_fccNo']";
	public static final String OCR_AppValue = "//input[@id='editProductExportClass_appValue']";
	public static final String OCR_VectorRate = "//input[@id='editProductExportClass_productExportClazz_vectorRate']";
	public static final String OCR_CTP = "//input[@id='editProductExportClass_productExportClazz_ctp']";
	public static final String OCR_ClassifDate = "//input[@id='schbDateId']";
	public static final String OCR_ScheduleBClassif = "//input[@id='editProductExportClass_productCustomsClassValue_schb']";
	public static final String OCR_NewRepClassif = "//input[@id='editProductExportClass_productCustomsClassValue_newSchb']";
	public static final String OCR_DateOfAppl = "//input[@id='editProductExportClass_newSchbApplDate']";
	public static final String OCR_AustgroupApp = "//select[@id='editProductExportClass_productExportClazz_ecrAgApplicable']";
	public static final String OCR_AustgroupCat = "//input[@id='editProductExportClass_productExportClazz_ecrAgCategory']";
	public static final String OCR_AustgroupSubCat = "//input[@id='editProductExportClass_productExportClazz_ecrAgSubCategory']";
	public static final String OCR_MTCRApp = "//select[@id='editProductExportClass_productExportClazz_mtcrApplicable']";
	public static final String OCR_MTCRCat = "//input[@id='editProductExportClass_productExportClazz_mtcrCategory']";
	public static final String OCR_MTCRSubCat = "//input[@id='editProductExportClass_productExportClazz_mtcrSubCategory']";
	public static final String OCR_NSGApp = "//select[@id='editProductExportClass_productExportClazz_ecrNsgApplicable']";
	public static final String OCR_NSGCat = "//input[@id='editProductExportClass_productExportClazz_ecrNsgCategory']";
	public static final String OCR_NSGSubCat = "//input[@id='editProductExportClass_productExportClazz_ecrNsgSubCategory']";
	public static final String OCR_WAApp = "//select[@id='editProductExportClass_productExportClazz_ecrWassenaarApplicable']";
	public static final String OCR_WAACat = "//input[@id='editProductExportClass_productExportClazz_ecrWassenaarCategory']";
	public static final String OCR_WAASubCat = "//input[@id='editProductExportClass_productExportClazz_ecrWassenaarSubCategory']";
	public static final String OCR_Button_Save = "(//button[contains(text(),'Save')])[1]";
	public static final String OCR_Button_Search = "//button[contains(text(),'Search')]";
	public static final String OCR_Button_Select = "//button[contains(text(),'Select')]";
	public static final String OCR_Button_SavendReturn = "//button[contains(text(),'Save & Return')]";
	public static final String OCR_Button_Cancel = "//button[contains(text(),'Cancel')]";
	public static final String OCR_ImportClassification = "//a[contains(text(),'Import Classification')]";
	public static final String OCR_Button_AddExpRuling = "//button[contains(text(),'Add Export Ruling')]";
	public static final String OCR_RulingType = "//select[@id='rulingtype']";
	public static final String OCR_RulingNo = "//input[@id='editExportRuling_rulingNo']";
	public static final String OCR_POPUpClose = "(//i[@class='fa fa-times'])[1]";
	public static final String OCR_ExportClassDate = "//input[@id='editProductExportClass_classificationDt']";
	public static final String OCR_ExpClssDteOfapplic="//input[@id='editProductExportClass_dateOfChange']";
	public static final String OCR_PrevExportClassfcn="(//a[@data-ocr-role='modal-link']/../../label/a)[5]";
	public static final String OCR_ExpClassification_ECCN="(//input[@id='searchForm_productClazz_prodClassification'])[1]";
public static final String OCR_ExpClassfcnSearchButton="(//button[@class='primary-btn popupSearchButton'])[1]";
public static final String OCR_EXportECCN_Select="(//button[@class='primary-btn recordFromPopup'])[1]";
public static final String OCR_NewExpClassification="(//a[@data-ocr-role='modal-link']/../../label/a)[6]";
public static final String OCR_ExpControlDeatailsHeader="//label[contains(text(),'Export Control Details')]";
public static final String OCR_AdditionalcontrolHeader="//label[contains(text(),'Additional Controls')]";
public static final String OCR_RulingtypeHeader="//label[contains(text(),'Ruling Details')]";
public static final String OCR_AutorityCode="//a[@id='authorityLink']";
public static final String OCR_AutorizaionCode="//textarea[@id='licTypePopupForm_licenseTypes_licenseType']";
public static final String OCR_ExpAuthirtyPopupClose="(//button[@class='btn-close'])[1]";
public static final String OCR_StatClassDetailHeader="//label[contains(text(),'Statistical Classification Details')]";
	/* ******************** Constructor ***************************** */
	public ExportClassificationPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	public void click_eclassification() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_ExportClassification, "Clicking on ExportClassification");
	}

	// Add classification to the Result grid or not
	public void addEClassifToResultsGrid(String EClassification) {
		Wait.waitfor(3);
		try {
			typeText(driver, test, "//div[@id='content-cont']//input[@id='searchForm_productClazz_prodClassification']",
					"Enter the ECCN : ", EClassification);
			search();
			String addEC = "//table[@id='gridPopup']/tbody/tr/td[contains(text(),'" + EClassification + "')]";
			if (isDisplayed(driver, addEC)) {
				clickElement(driver, test, addEC, "Click on search record");
				test.log(LogStatus.PASS, "Add export classification "
						+ " : " + EClassification);
				select();
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Fail to Add FlagReason in result grid table : " + EClassification);
			clickElement(driver, test, OCR_POPUpClose, "Click on POP up close Icon");
		}
	}

	public void select_jurisdiction(String Jurisdiction) {
		selectByVisibleText(driver, test, OCR_Jurisdiction, "Select Jurisdiction", Jurisdiction);
	}

	public void save() {
		Wait.waitfor(3);
		scrollToTop(driver);
		Wait.waitfor(3);
		clickElement(driver, test, OCR_Button_Save, "Click on Save Button");
	}

	public void click_importclassification() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_ImportClassification, "Click on Import Classification");
	}

	public void click_controllingagencies() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_ControllingAgencies, "Click on Controlling Agency: ");
	}

	// Add Controlling Agency is Added to the Result grid or not
	public void addcontrlagencyToResultsGrid(String ControllingAgency) {
		Wait.waitfor(3);
		String addCA = "//table[@id='gridPopup']/tbody/tr/td[contains(text(),'" + ControllingAgency + "')]";
		try {
			if (isDisplayed(driver, addCA)) {
				clickElement(driver, test, addCA, "Click on search record");
				test.log(LogStatus.PASS, "Add FlagReason in add to result grid table : " + ControllingAgency);
				select();
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Fail to Add FlagReason in result grid table : " + ControllingAgency);
			clickElement(driver, test, OCR_POPUpClose, "Click on POP up close Icon");
		}
	}

	public void exportclassDate(String ExportclassDate) {
		if (ExportclassDate.length() > 0) {
			clickElement(driver, test, OCR_ExportClassDate, "Click on Export classification date");
			date(driver, test, "Selected on export classification date : ", ExportclassDate);
			test.log(LogStatus.PASS, "Selected on export classification date : " + ExportclassDate);
		}}
		public void exclssdtofapplicab(String exclssDTofapplicab) {
			
			if(exclssDTofapplicab.length()>0) {
				clickElement(driver, test, OCR_ExpClssDteOfapplic, "click on export classification date of applicability");
			date(driver, test, "Select export classification date of applicability : ", exclssDTofapplicab);
			test.log(LogStatus.PASS,"Select export classification date of applicability : ", exclssDTofapplicab);
			}
		}
	
	public void previousexportclassfcn(String prevECCNNO ) {
	if (prevECCNNO.length() > 0) {

		Wait.waitfor(3);
		clickElement(driver, test, OCR_PrevExportClassfcn, "click on previous export classification");
		try {
			Wait.waitfor(5);
			typeText(driver, test, OCR_ExpClassification_ECCN, "Enter  ECCN NO.", prevECCNNO);
			Wait.waitfor(3);
			clickElement(driver, test, OCR_ExpClassfcnSearchButton, "Click on search button");
			Wait.waitfor(3);
			String ECCNO = "//td[contains(text(),'" + prevECCNNO + "')]";
			Wait.waitfor(3);
			clickElement(driver, test, ECCNO, "Click User :" + prevECCNNO);
			Wait.waitfor(3);
			clickElement(driver, test, OCR_EXportECCN_Select, "Click on search ECCN Select button");
		} catch (Exception e) {
			
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Fail to add previous export classification ");
			clickElement(driver, test, OCR_POPUpClose, "Close the popup");
		}}
	}
	public void Newexportclassfcn(String NewECCNNO ) {
	if (NewECCNNO.length() > 0) {

			Wait.waitfor(3);
			clickElement(driver, test, OCR_NewExpClassification, "click on previous export classification");
			Wait.waitfor(3);
			try {
				typeText(driver, test, OCR_ExpClassification_ECCN, "Enter  ECCN NO.", NewECCNNO);
				Wait.waitfor(3);
				clickElement(driver, test, OCR_ExpClassfcnSearchButton, "Click on search button");
				Wait.waitfor(3);
				String ECCNO = "//td[contains(text(),'" + NewECCNNO + "')]";
				Wait.waitfor(3);
				clickElement(driver, test, ECCNO, "Click User :" + NewECCNNO);
				Wait.waitfor(3);
				clickElement(driver, test, OCR_EXportECCN_Select, "Click on search ECCN Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add new export classification ");
				clickElement(driver, test, OCR_POPUpClose, "Close the popup");
			}}}
	
	public void ScrolltoExpControldetails() {
	scrollToElement(driver, OCR_ExpControlDeatailsHeader);
	//scrollToElement(driver, OCR_RulingtypeHeader);
	clickElement(driver, test, OCR_ExpControlDeatailsHeader, "click on export control details header");
	Wait.waitfor(3);
	//clickElement(driver, test, OCR_AdditionalcontrolHeader, "click on additional control header");
	}
	public void ExportAuthority(String ExpAuthority) {
		
			if (ExpAuthority.length() > 0) {

				Wait.waitfor(5);
				clickElement(driver, test, OCR_AutorityCode, "click on Authority Code");
				try {
					Wait.waitfor(5);
					typeText(driver, test, OCR_AutorizaionCode, "Enter CODE.", ExpAuthority);
					Wait.waitfor(3);
					clickElement(driver, test, OCR_ExpClassfcnSearchButton, "Click on search button");
					Wait.waitfor(3);
					String Exauth = "//td[contains(text(),'" + ExpAuthority + "')]";
					Wait.waitfor(3);
					clickElement(driver, test, Exauth, "Click User :" + ExpAuthority);
					Wait.waitfor(3);
					clickElement(driver, test, OCR_EXportECCN_Select, "Click on  Select button");
				} catch (Exception e) {
					
					testFailSshot(driver, test);
					test.log(LogStatus.FAIL, "Fail to add previous export classification ");
					clickElement(driver, test, OCR_ExpAuthirtyPopupClose, "Close the popup");
				}}
	}
			public void StatClassDetailheader() {
				scrollToElement(driver, OCR_StatClassDetailHeader);
				Wait.waitfor(5);
				clickElement(driver, test, OCR_StatClassDetailHeader, "click on statistical classifiaction details");
				
			}
	
	public void click_addexprulng() {
		clickElement(driver, test, OCR_Button_AddExpRuling, "Clicking on Add Export Ruling Button: ");
	}

	public void select_rulingtype(String RulingType) {
		selectByVisibleText(driver, test, OCR_RulingType, "Select Ruling Type", RulingType);
	}

	public void enter_rulingno(String RulingNo) {
		typeText(driver, test, OCR_RulingNo, "Enter Ruling No", RulingNo);
	}

	public void search() {
		// TODO Auto-generated method stub
		clickElement(driver, test, OCR_Button_Search, "Clicking on Search Button");
	}

	public void select() {
		// TODO Auto-generated method stub
		clickElement(driver, test, OCR_Button_Select, "Clicking on Select Button");
	}

	public void cancel() {
		clickElement(driver, test, OCR_Button_Cancel, "Clicking on Cancel Button");
	}

	// Validate Export Classification Details Tab
	public void validate_ExpClassifDetError() {
		try {
			if (isDisplayed(driver, "//h4[contains(text(),'Error')]")) {

				if (isDisplayed(driver, "//li[contains(text(),'Export  Classification')]")) {
					test.log(LogStatus.INFO,
							"Export Classification Or Statistical Reporting Classification is required to save.");
				}

			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL,
					"Error Validation is not Displayed by clicking on SAVE button in Export Classification Details Page");
		}
	}

	public void validate_JurisdictionError() {

		try {
			if (isDisplayed(driver, "//h4[contains(text(),'Error')]")) {

				if (isDisplayed(driver, "//li[contains(text(),'Export Control Juridiction is required')]")) {
					test.log(LogStatus.INFO, "Export Control Juridiction is required");
				}

			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL,
					"Error Validation is not Displayed by clicking on SAVE button in Export Classification Details Page");
		}
	}

	public void enter_ocrcode(String OCRCode) {
		typeText(driver, test, OCR_OCRCode, "Enter OCR Code", OCRCode);
	}

	public void enter_MethodOfDetermination(String MethodOfDetermination) {
		typeText(driver, test, "//textarea[@id='editProductExportClass_productExportClazz_expDeterMethod']",
				"Enter the Method Of Determination : ", MethodOfDetermination);
	}

	public void enter_RationaleForClassification(String RationaleForClassification) {
		typeText(driver, test, "//textarea[@id='editProductExportClass_productExportClazz_expRationaleClassfn']",
				"Enter the Rationale For Classification : ", RationaleForClassification);
	}

	public void enter_SMethodOfDetermination(String SMethodOfDetermination) {
		typeText(driver, test, "//textarea[@id='editProductExportClass_productCustomsClassValue_schbDeterMethod']",
				"Enter the Statistical Method Of Determination : ", SMethodOfDetermination);
	}

	public void enter_SRationaleForClassification(String SRationaleForClassification) {
		typeText(driver, test, "//textarea[@id='editProductExportClass_productCustomsClassValue_schbRationaleClassfn']",
				"Enter the Statistical Rationale For Classification : ", SRationaleForClassification);
	}
	public void scrolltoTop() {
		scrollToTop(driver);
	}
}


