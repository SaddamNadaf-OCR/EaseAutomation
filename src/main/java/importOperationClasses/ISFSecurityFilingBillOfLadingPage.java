package importOperationClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;

public class ISFSecurityFilingBillOfLadingPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_SecurityFilingBillOfLading_BillNo = "//input[@id='editIsf10Bol_importIsf10BolValue_bolNo']";
	public static final String OCR_SecurityFilingBillOfLading_BillType = "//select[@id='editIsf10Bol_importIsf10BolValue_bolType']";
	public static final String OCR_SecurityFilingBillOfLading_ParentBillNo = "//input[@id='editIsf10Bol_importIsf10BolValue_parentBolNo']";
	public static final String OCR_SecurityFilingBillOfLading_IssuerCodeLink = "//a[@id='issuerCodePopup']";
	public static final String OCR_SecurityFilingBillOfLading_CarrierCode = "//input[@id='searchForm_carrier_carrierCode']";
	public static final String OCR_SecurityFilingBillOfLading_SearchPopUp = "//button[@name='Search']";
	public static final String OCR_SecurityFilingBillOfLading_SelectPopUp = "//button[contains(text(),'Select')][1]";
	public static final String OCR_SecurityFilingBillOfLading_ClosePopUp = "//button[@class='close']";
	public static final String OCR_SecurityFilingBillOfLading_Qty = "//input[@id='editIsf10Bol_quantity']";
	public static final String OCR_SecurityFilingBillOfLading_UOM = "//input[@id='editIsf10Bol_importIsf10BolValue_uom']";
	public static final String OCR_SecurityFilingBillOfLading_BillStatus = "//select[@id='editIsf10Bol_importIsf10BolValue_bolStatus']";
	public static final String OCR_SecurityFilingBillOfLading_Save = "//button[@id='save']";
	public static final String OCR_SecurityFilingBillOfLading_SaveAndReturn = "//button[@id='saveAndReturn']";
	
	/* ******************** Constructor ***************************** */
	public ISFSecurityFilingBillOfLadingPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */
	
	//Click Save & Return
	public void clickSaveandReturn() {
		clickElement(driver, test, OCR_SecurityFilingBillOfLading_SaveAndReturn, "Click on Save and Return");
	}
	
	//Click on save
	public void clickSave() {
		clickElement(driver, test, OCR_SecurityFilingBillOfLading_Save, "Click on Save");
	}
	
	//Add Different Bill Type
	public void billType(String BillType ) {
		selectByVisibleText(driver, test, OCR_SecurityFilingBillOfLading_BillType, "Add Bill Type : ", BillType);
	}
	
	//Add BOL Details
	public void bolDetails(String BillNo, String ParentBillNo, String CarrierCode, String Qty, String UOM, String BillStatus) {
		typeText(driver, test, OCR_SecurityFilingBillOfLading_BillNo, "Add Bill NO : ", BillNo + randomnumbers());
		typeText(driver, test, OCR_SecurityFilingBillOfLading_ParentBillNo, "Add Parent Bill No : ", ParentBillNo);
		if (CarrierCode.length() > 0) {
			clickElement(driver, test, OCR_SecurityFilingBillOfLading_IssuerCodeLink, "Click on Issuer Code");
			try {
				typeText(driver, test, OCR_SecurityFilingBillOfLading_CarrierCode, "Add Carrier Code : ", CarrierCode);
				clickElement(driver, test, OCR_SecurityFilingBillOfLading_SearchPopUp, "Click On Search");
				String Carrier = "//td[contains(text(),'" + CarrierCode + "')]";
				clickElement(driver, test, Carrier, "Select Carrier : " + CarrierCode);
				clickElement(driver, test, OCR_SecurityFilingBillOfLading_SelectPopUp, "Click on select");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to ADD Carrier");
				clickElement(driver, test, OCR_SecurityFilingBillOfLading_ClosePopUp, "Click on Close");
			}
		}
		typeText(driver, test, OCR_SecurityFilingBillOfLading_Qty, "Add Quantity : ", Qty);
		typeText(driver, test, OCR_SecurityFilingBillOfLading_UOM, "Add UOM : ", UOM);
		selectByVisibleText(driver, test, OCR_SecurityFilingBillOfLading_BillStatus, "Select Bill Status : ", BillStatus);
	}
	
	// Validation for Bill Type and Bill No

		public void validationBillTypeBillNo() {
			try {
				if (isDisplayed(driver, "//h4[contains(text(),'Error')]")) {
					if (isDisplayed(driver, "//li[contains(text(),'Bill No. Required')]")) {
						test.log(LogStatus.INFO, "Bill No. is required");
					}
					if (isDisplayed(driver, "//li[contains(text(),'Bill Type is required')]")) {
						test.log(LogStatus.INFO, "Bill Type is required");
					}
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL,
						"Error is not Displayed by clicking on SAVE button in ISF Bill of Lading");
			}
		}
		
}
