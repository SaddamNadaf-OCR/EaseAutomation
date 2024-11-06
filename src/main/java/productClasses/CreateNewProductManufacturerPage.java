package productClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import utilities.GenericMethods;
import utilities.Wait;

public class CreateNewProductManufacturerPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_Button_AddProductManufacturer = "//button[@id='btnAddProdManufacturer']";
	public static final String OCR_ManufacturerId = "//a[contains(text(),'Manufacturer Id')]";
	public static final String OCR_Button_Search = "//button[contains(text(),'Search')]";
	public static final String OCR_Button_Select = "//button[contains(text(),'Select')]";
	public static final String OCR_Button_Save = "//button[contains(text(),'Save')]";
	public static final String OCR_CAGECode = "//input[@id='editProductManufacturer_productManufacturer_cageCode']";
	public static final String OCR_ModuleNo = "//input[@id='editProductManufacturer_productManufacturer_mfgModelNo']";
	public static final String OCR_CountryofOrigin = "//input[@id='countryOrigin']";
	public static final String OCR_Facility = "//textarea[@id='editProductManufacturer_productManufacturer_mfgFacility']";
	public static final String OCR_ContactName = "//input[@id='editProductManufacturer_productManufacturer_mfgContactName']";
	public static final String OCR_ContactEmail = "//input[@id='editProductManufacturer_productManufacturer_mfgContactEmail']";
	public static final String OCR_ContactTelephone = "//input[@id='editProductManufacturer_productManufacturer_mfgContactPhone']";
	public static final String OCR_JurisdictionMG = "//input[@id='editProductManufacturer_productManufacturer_mfgJurisdictionY']";
	public static final String OCR_JurisdictionDU = "//input[@id='editProductManufacturer_productManufacturer_mfgJurisdictionN']";
	public static final String OCR_JurisdictionND = "//input[@id='editProductManufacturer_productManufacturer_mfgJurisdictionD']";
	public static final String OCR_CountryofClassification = "//input[@id='editProductManufacturer_productManufacturer_countryOfClassName']";
	public static final String OCR_ExportClassification = "//a[@id='exportLink']";
	public static final String OCR_ScheduleB = "//a[contains(text(),'Schedule B')]";
	public static final String OCR_HTSCode = "//input[@id='editProductManufacturer_productManufacturer_mfgCustomsClass']";
	public static final String OCR_HTSUnit = "//a[contains(text(),'HS Unit')]";
	public static final String OCR_Button_ADCVD = "//button[@name='addAddCvd']";
	public static final String OCR_ADCVDCountry = "//input[@id='editAddCvdDetails_addCvdcountryName']";
	public static final String OCR_ADCVDCaseType = "//select[@id='editAddCvdDetails_productManuAdcvdDtlsValue_caseType']";
	public static final String OCR_ADCVDCaseNo = "//input[@id='editAddCvdDetails_productManuAdcvdDtlsValue_caseNo']";
	public static final String OCR_ADCVDEffDateFrom = "//input[@id='editAddCvdDetails_effFromDate']";
	public static final String OCR_ADCVDEffDateTo = "//input[@id='editAddCvdDetails_effToDate']";
	public static final String OCR_AssistValue = "//a[contains( text(),'Assist Value')]";
	public static final String OCR_Button_AssistDeclaration = "//button[@id='addAssistDecl']";
	public static final String OCR_Button_AddCountryCont = "//button[contains( text(),'Add Country Content')]";
	public static final String OCR_CountryContent = "//input[@id='editProductCooPopUp_productCoo_countryOfOriginName']";
	public static final String OCR_Button_AddFTA = "//button[contains( text(),'Add FTA')]";
	public static final String OCR_FTA_TradePrgCountry = "//input[@id='editProductTradeProgram_countryName']";
	public static final String OCR_FTACode = "//input[@id='isDisable']";
	public static final String OCR_FTAEligible = "//select[@id='editProductTradeProgram_eligible']";
	public static final String OCR_Button_SaveFTA = "(//button[contains(text(),'Save')])[3]";
	public static final String OCR_Button_SavendReturnFTA = "(//button[contains(text(),'Save')])[4]";
	public static final String OCR_POPUpClose = "//div[@id='ocrModal']//button[@class='btn-close']";
	public static final String OCR_acvdtypebutton = "//button[@name='addAddCvd']";
	/* ******************** Constructor ***************************** */

	public CreateNewProductManufacturerPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	public void click_manufacturerid() {
		clickElement(driver, test, OCR_ManufacturerId, "Click on Manufacturer Id");
	}

	public void search() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_Button_Search, "Click on Search Button");
	}

	public void select() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_Button_Select, "Click on Select Button");
		Wait.waitfor(3);
	}

	// Add Manufacturer is Added to the Result grid or not
	public void addmanufacturerToResultsGrid(String ManufacturerCode) {
		Wait.waitfor(3);
		try {
			typeText(driver, test, "//input[@id='searchForm_userDTO_userCode']", "Enter the Manufacturer Code : ",
					ManufacturerCode);
			search();
			String addManuf = "//table[@id='gridPopup']/tbody/tr/td[contains(text(),'" + ManufacturerCode + "')]";
			if (isDisplayed(driver, addManuf)) {
				clickElement(driver, test, addManuf, "Click on search record");
				test.log(LogStatus.PASS, "Add FlagReason in add to result grid table : " + ManufacturerCode);
				select();
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Fail to Add FlagReason in result grid table : " + ManufacturerCode);
			clickElement(driver, test, OCR_POPUpClose, "Click on POP up close Icon");
		}
	}

	public void enter_countryoforigin(String CountryOfOrigin) {
		typeText(driver, test, OCR_CountryofOrigin, "Enter Country Of Origin : ", CountryOfOrigin);

	}

	public void enter_contactname(String ContactName) {
		typeText(driver, test, OCR_ContactName, "Enter Contact Name : ", ContactName);
	}

	public void enter_contactemail(String ContactEmail) {
		typeText(driver, test, OCR_ContactEmail, "Enter Contact Email : ", ContactEmail);
	}

	public void select_jurisdiction(String JurisdictionDet) {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_JurisdictionMG, "Select Military Goods Radio Button: ");
		/*if (JurisdictionDet.contains("Military Goods")) {
			clickElement(driver, test, OCR_JurisdictionMG, "Select Military Goods Radio Button: ");
		} else if (JurisdictionDet.contains("DU")) {
			clickElement(driver, test, OCR_JurisdictionDU, "Select Dual Use Radio Button: ");
		} else if (JurisdictionDet.contains("DU")) {
			clickElement(driver, test, OCR_JurisdictionND, "Select Not Determined Radio Button: ");
		}*/
	}

	public void enter_countryofclassification(String CountryOfClassification) {
		typeText(driver, test, OCR_CountryofClassification, "Enter Country of Classification : ",
				CountryOfClassification);
	}

	public void click_exportclassification() {
		clickElement(driver, test, OCR_ExportClassification, "Click on Export Classification");
	}

	// Add ExportClassification is Added to the Result grid or not
	public void addexpclassifToResultsGrid(String ExportClassification) {
		Wait.waitfor(3);
		try {
			search();
			String addEc = "//table[@id='gridPopup']/tbody/tr/td[contains(text(),'" + ExportClassification + "')]";
			if (isDisplayed(driver, addEc)) {
				clickElement(driver, test, addEc, "Click on search record");
				test.log(LogStatus.PASS,
						"Add Export Classification in add to result grid table : " + ExportClassification);
				select();
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Fail to Add FlagReason in result grid table : " + ExportClassification);
			clickElement(driver, test, OCR_POPUpClose, "Click on POP up close Icon");
		}
	}

	public void click_scheduleb() {
		clickElement(driver, test, OCR_ScheduleB, "Click on Schedule B Classification");
	}

	// Add ScheduleB is Added to the Result grid or not
	public void addScheduleBToResultsGrid(String ScheduleB) {
		Wait.waitfor(3);
		try {
			search();
			String addscheduleb = "//table[@id='gridPopup']/tbody/tr/td[contains(text(),'" + ScheduleB + "')]";
			if (isDisplayed(driver, addscheduleb)) {
				clickElement(driver, test, addscheduleb, "Click on search record");
				test.log(LogStatus.PASS, "Add Schedule B in add to result grid table : " + ScheduleB);
				select();
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Fail to Add FlagReason in result grid table : " + ScheduleB);
			clickElement(driver, test, OCR_POPUpClose, "Click on POP up close Icon");
		}
	}

	public void enter_htscode(String HTSCode) {
		typeText(driver, test, OCR_HTSCode, "Enter the HTS Code : ", HTSCode);
	}

	// Add hts code is Added to the Result grid or not
	public void addhtscodeToResultsGrid(String HTSCode) {
		Wait.waitfor(3);
		String addhtscode = "//table[@id='gridPopup']/tbody/tr/td[contains(text(),'" + HTSCode + "')]";
		try {
			if (isDisplayed(driver, addhtscode)) {
				clickElement(driver, test, addhtscode, "Click on search record");
				test.log(LogStatus.PASS, "Add Schedule B in add to result grid table : " + HTSCode);
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Fail to Add FlagReason in result grid table : " + HTSCode);
		}
	}

	public void click_htsunit() {
		clickElement(driver, test, OCR_HTSUnit, "Click on HTS Unit");

	}

	// Add hts unit is Added to the Result grid or not
	public void addhtsunitToResultsGrid(String HTSUnit) {
		Wait.waitfor(3);
		String addhtsunit = "//table[@id='gridPopup']/tbody/tr/td[contains(text(),'" + HTSUnit + "')]";
		try {
			if (isDisplayed(driver, addhtsunit)) {
				clickElement(driver, test, addhtsunit, "Click on search record");
				test.log(LogStatus.PASS, "Add Schedule B in add to result grid table : " + HTSUnit);
				select();
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Fail to Add FlagReason in result grid table : " + HTSUnit);
			clickElement(driver, test, OCR_POPUpClose, "Click on POP up close Icon");
		}
	}

	public void save() {
		scrollToElement(driver, OCR_Button_Save);
		scrollToTop(driver);
		Wait.waitfor(3);
		clickElement(driver, test, OCR_Button_Save, "Click on Save Button");
	}

	public void adcvd_save() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", driver.findElement(By.xpath("//button[@id='entitySave']")));
	}

	public void addcvd() {
		scrollToElement(driver, "//legend[contains(text(), 'Anti-Dumping & Countervailing Case Details')]");
		clickElement(driver, test, OCR_Button_ADCVD, "Click on AD/CVD");
	}

	public void addAntiDumpingCountervailingCaseDetails(String ADCVDCountry, String ADCVDCaseType, String ADCVDCaseNo,
			String ADCVDEfDateFrom, String ADCVDEfDateTo) {
		try {
			typeText(driver, test, OCR_ADCVDCountry, "Enter Country : ", ADCVDCountry);
			selectByVisibleText(driver, test, OCR_ADCVDCaseType, "Select Case Type : ", ADCVDCaseType);
			typeText(driver, test, OCR_ADCVDCaseNo, "Enter Case no : ", ADCVDCaseNo);
			clickElement(driver, test, OCR_ADCVDEffDateFrom, "Click on ADCVD Ef Date From");
			date(driver, test, "Select the Eff Date From : ", ADCVDEfDateFrom);
			clickElement(driver, test, OCR_ADCVDEffDateTo, "Click on ADCVDEf Date To");
			date(driver, test, "Select the EFF Date To : ", ADCVDEfDateTo);
			Wait.waitfor(3);
			clickElement(driver, test, "//button[@id='entitySave']", "Click on Save");
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Fail to Add Anti Dumping Countervailing Case Details");
			clickElement(driver, test, OCR_POPUpClose, "Click on POP up close Icon");
		}
	}

	public void click_assistvalue() {
		clickElement(driver, test, OCR_AssistValue, "Click on Assist Value");
	}

	public void addcountrycont() {
		scrollToElement(driver, "//legend[contains(text(),'Country Content Details')]");
		clickElement(driver, test, OCR_Button_AddCountryCont, "Click on Add Country Content");
	}

	public void enter_countrycont(String CountryContent) {
		try {
			typeText(driver, test, OCR_CountryContent, "Enter Country Content : ", CountryContent);
			Wait.waitfor(3);
			clickElement(driver, test, "//button[@id='entitySave']", "Click on Save");
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Fail to Add Country Content Details");
			clickElement(driver, test, OCR_POPUpClose, "Click on POP up close Icon");
		}
	}

	public void click_addfta() {
		scrollToElement(driver, "//legend[contains(text(),'Product Trade Program')]");
		clickElement(driver, test, OCR_Button_AddFTA, "Click on Add Fta Button");
		//AlertPopUp(driver, test, "Please classify the product HTS Code before entering a Trade Program.");
	}

	public void addProductTradeProgram(String TradePrgCountry, String FTACode, String Eligible) {
		try {
			typeText(driver, test, OCR_FTA_TradePrgCountry, "Enter Country Content : ", TradePrgCountry);
			typeText(driver, test, OCR_FTACode, "Enter FTA Code : ", FTACode);
			selectByVisibleText(driver, test, OCR_FTAEligible, "Select Eligible : ", Eligible);
			Wait.waitfor(3);
			clickElement(driver, test, OCR_Button_SaveFTA, "Click on Save Button");
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Fail to Add Product Trade Program");
			clickElement(driver, test, OCR_POPUpClose, "Click on POP up close Icon");
		}
	}

	public void ftasavendreturn() {
		scrollToElement(driver, OCR_Button_SavendReturnFTA);
		scrollToTop(driver);
		Wait.waitfor(3);
		clickElement(driver, test, OCR_Button_SavendReturnFTA, "Click on Save and return Button");
	}

	public void movetosubcomponenttab() {
		scrollToElement(driver, "//a[@id='tab4']");
		scrollToTop(driver);
		Wait.waitfor(3);
		clickElement(driver, test, "//a[@id='tab4']", "Click on Sub Component Tab");
	}

	public void validatemanuferror() {
		try {
			if (isDisplayed(driver, "//h4[contains(text(),'Error')]")) {
				if (isDisplayed(driver, "//li[contains(text(),'Country of Origin is required')]")) {
					test.log(LogStatus.INFO, "Country of Origin is required");
				}
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL,
					"Error Validation is not Displayed by clicking on SAVE button in Manufacturer Details Page");
		}
	}

	public void scrolltoADVCbutton() {
		scrollToElement(driver, OCR_ContactName);
	}
	public void scrolltotopofscrn() {
		scrollToTop(driver);
}}
