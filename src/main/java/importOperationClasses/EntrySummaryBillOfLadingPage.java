package importOperationClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class EntrySummaryBillOfLadingPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_BillOfLading_BillNo = "//input[@id='edit7501Bol_import7501BolValue_bolNo']";
	public static final String OCR_BillOfLading_BillType = "//select[@id='edit7501Bol_import7501BolValue_bolType']";
	public static final String OCR_BillOfLading_ParentBillNo = "//input[@id='edit7501Bol_import7501BolValue_masterBolNo']";
	public static final String OCR_BillOfLading_IssuerCodeLink = "//a[@id='issuerPopup']";
	public static final String OCR_BillOfLading_CarrierCode = "//input[@id='searchForm_carrier_carrierCode']";
	public static final String OCR_BillOfLading_SearchPopUp = "//button[@name='Search']";
	public static final String OCR_BillOfLading_SelectPopUp = "(//button[contains(text(),'Select')])[1]";
	public static final String OCR_BillOfLading_ClosePopUp = "(//button[@class='close'])[1]";
	public static final String OCR_BillOfLading_Qty = "//input[@id='edit7501Bol_quantity']";
	public static final String OCR_BillOfLading_UOM = "//input[@id='edit7501Bol_import7501BolValue_uom']";
	public static final String OCR_BillOfLading_EquipmentNumber = "//input[@id='edit7501Bol_import7501BolValue_equipNumber']";
	public static final String OCR_BillOfLading_NonAMSIndicator = "//select[@id='edit7501Bol_import7501BolValue_nonamsindicator']";
	public static final String OCR_BillOfLading_DateOfArrival = "//input[@id='edit7501Bol_arrivalDate']";
	public static final String OCR_BillOfLading_ConveyanceName = "//input[@id='edit7501Bol_import7501BolValue_conveyanceName']";
	public static final String OCR_BillOfLading_Save = "//button[@name='save']";
	public static final String OCR_BillOfLading_SaveAndReturn = "//button[@name='saveAndReturn']";
	public static final String OCR_BillOfLading_CloseAlert = "//button[@class='close']";

	/* ******************** Constructor ***************************** */
	public EntrySummaryBillOfLadingPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	// Click Save & Return
	public void clickSaveandReturn() {
		clickElement(driver, test, OCR_BillOfLading_SaveAndReturn, "Click on Save and Return");
	}

	// Click on save
	public void clickSave() {
		clickElement(driver, test, OCR_BillOfLading_Save, "Click on Save");
	}

	// Add BOL Details
	public void bolDetails(String BillNo, String BillType, String ParentBillNo, String CarrierCode, String Quantity,
			String UOM, String EquipmentNumber, String NonAMSIndicator, String DateOfArrival, String ConveyanceName) {
		typeText(driver, test, OCR_BillOfLading_BillNo, "Add Bill NO : ", BillNo + randomnumbers());
		selectByVisibleText(driver, test, OCR_BillOfLading_BillType, "Add Bill Type : ", BillType);
		typeText(driver, test, OCR_BillOfLading_ParentBillNo, "Add Parent Bill No : ", ParentBillNo);
		Wait.waitfor(3);
		if (CarrierCode.length() > 0) {
			clickElement(driver, test, OCR_BillOfLading_IssuerCodeLink, "Click on Issuer Code");
			try {
				Wait.waitfor(3);
				typeText(driver, test, OCR_BillOfLading_CarrierCode, "Add Carrier Code : ", CarrierCode);
				clickElement(driver, test, OCR_BillOfLading_SearchPopUp, "Click On Search");
				String Carrier = "//td[contains(text(),'" + CarrierCode + "')]";
				clickElement(driver, test, Carrier, "Select Carrier : " + CarrierCode);
				clickElement(driver, test, OCR_BillOfLading_SelectPopUp, "Click on select");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to ADD Carrier");
				clickElement(driver, test, OCR_BillOfLading_ClosePopUp, "Click on Close");
			}
		}
		typeText(driver, test, OCR_BillOfLading_Qty, "Add Quantity : ", Quantity);
		typeText(driver, test, OCR_BillOfLading_UOM, "Add UOM : ", UOM);
		typeText(driver, test, OCR_BillOfLading_EquipmentNumber, "Add Equipment Number : ", EquipmentNumber);
		typeText(driver, test, OCR_BillOfLading_NonAMSIndicator, "Add NonAMSIndicator : ", NonAMSIndicator);
		typeText(driver, test, OCR_BillOfLading_DateOfArrival, "Add DateOfArrival : ", DateOfArrival);
		typeText(driver, test, OCR_BillOfLading_ConveyanceName, "Add ConveyanceName : ", ConveyanceName);
	}

	// Click on Alert Popup Close
	public void alertClose() {
		Wait.waitfor(5);
		clickElement(driver, test, OCR_BillOfLading_CloseAlert, "Click Alert Popup Close");
	}

	// Validation for Bol Details
	public void validationBolDetails() {
		try {
			if (isDisplayed(driver, "//h4[contains(text(),'Error')]")) {
				if (isDisplayed(driver, "//li[contains(text(),'Bill No/IT Number')]")) {
					test.log(LogStatus.INFO, "Bill No/IT Number");
				}
				if (isDisplayed(driver, "//li[contains(text(),'Bill Type is required')]")) {
					test.log(LogStatus.INFO, "Bill Type is required");
				}
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL,
					"Error is not Displayed by clicking on SAVE button in Cargo Release Bill of Lading");
		}
	}

	// Validation for BOL iN Alert
	public void validationIssuer() {
		try {
			if (isDisplayed(driver,
					"//table[@class='table table-condensed table-bordered']//td[contains(text(),'Issuer Code is required for Bill Type: Master Bill')]")) {
				test.log(LogStatus.INFO, "Issuer Code is required for Bill Type: Master Bill");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Error is not Displayed by clicking on Alert Icon for Entry Summary");
			alertClose();
		}
	}

}
