package importOperationClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class CargoReleaseBillofLadingPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_BOLDetails_SaveAndReturn = "//button[@name='ok']";
	public static final String OCR_BOLDetails_Save = "//button[@name='save']";
	public static final String OCR_BOLDetails_BillNo = "//input[@id='editSimplifiedEntryBol_importSeBolValue_bolNo']";
	public static final String OCR_BOLDetails_BillType = "//select[@id='editSimplifiedEntryBol_importSeBolValue_bolType']";
	public static final String OCR_BOLDetails_ParentBillNo = "//input[@id='editSimplifiedEntryBol_importSeBolValue_parentBolNo']";
	public static final String OCR_BOLDetails_IssuerCodeLink = "//a[contains(text(),'Issuer Code')]";
	public static final String OCR_BOLDetails_CarrierCode = "//input[@id='searchForm_carrier_carrierCode']";
	public static final String OCR_BOLDetails_SearchBtn = "//button[@name='Search']";
	public static final String OCR_BOLDetails_SelectBtn = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_BOLDetails_CloseBtn = "//button[@class='close']";
	public static final String OCR_BOLDetails_Qty = "//input[@id='editSimplifiedEntryBol_quantity']";
	public static final String OCR_BOLDetails_UOM = "//input[@id='editSimplifiedEntryBol_importSeBolValue_uom']";
	public static final String OCR_BOLDetails_EquipmentNo = "//input[@id='editSimplifiedEntryBol_importSeBolValue_equipmentNumber']";
	public static final String OCR_BOLDetails_NonAMSIndicator = "//select[@id='editSimplifiedEntryBol_nonamsindicator']";
	public static final String OCR_BOLDetails_ConveyanceName = "//input[@id='editSimplifiedEntryBol_importSeBolValue_conveyanceName']";
	public static final String OCR_BOLDetails_VoyageFlightTripNumber = "//input[@id='editSimplifiedEntryBol_importSeBolValue_voyageFlightTripNumber']";
	public static final String OCR_BOLDetails_DateOfArrival = "//input[@id='editSimplifiedEntryBol_dateofArrival']";

	/* ******************** Constructor ***************************** */
	public CargoReleaseBillofLadingPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	// Click on Save & Return

	public void saveandReturn() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_BOLDetails_SaveAndReturn, "Click on save and return");
	}

	// Click on Save

	public void save() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_BOLDetails_Save, "Click on Save");
	}

	// add multiple bill type

	public void addBillType(String BillType) {
		selectByVisibleText(driver, test, OCR_BOLDetails_BillType, "select party type : ", BillType);
	}

	// add BOL details
	public void addBOI(String BillNo, String ParentBillNo, String CarrierCode, String Qty, String UOM,
			String EquipmentNo, String NonAMSIndicator, String ConveyanceName, String VoyageFlightTripNumber,
			String DateOfArrival) {
		typeText(driver, test, OCR_BOLDetails_BillNo, "Add Bill No : ", BillNo + randomnumbers());
		typeText(driver, test, OCR_BOLDetails_ParentBillNo, "Add parent bill no : ", ParentBillNo);
		if (CarrierCode.length() > 0) {
			clickElement(driver, test, OCR_BOLDetails_IssuerCodeLink, "Click on Issuer Code");
			try {
				typeText(driver, test, OCR_BOLDetails_CarrierCode, "Add Vendor Code : ", CarrierCode);
				clickElement(driver, test, OCR_BOLDetails_SearchBtn, "Click On Search");
				String Carrier = "//td[contains(text(),'" + CarrierCode + "')]";
				clickElement(driver, test, Carrier, "Select Carrier: " + CarrierCode);
				clickElement(driver, test, OCR_BOLDetails_SelectBtn, "Click on select");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to ADD Carrier");
				clickElement(driver, test, OCR_BOLDetails_CloseBtn, "Click on Close");
			}
		}
		Wait.waitfor(3);
		typeText(driver, test, OCR_BOLDetails_Qty, "Add Quantity : ", Qty);
		typeText(driver, test, OCR_BOLDetails_UOM, "Add UOM : ", UOM);
		typeText(driver, test, OCR_BOLDetails_EquipmentNo, "Add Equipment No : ", EquipmentNo);
		selectByVisibleText(driver, test, OCR_BOLDetails_NonAMSIndicator, "Select NonAMS Indicator : ",
				NonAMSIndicator);
		typeText(driver, test, OCR_BOLDetails_ConveyanceName, "Add ConveyanceName : ", ConveyanceName);
		typeText(driver, test, OCR_BOLDetails_VoyageFlightTripNumber, "Add VoyageFlightTripNumber : ",
				VoyageFlightTripNumber);
		typeText(driver, test, OCR_BOLDetails_DateOfArrival, "add Date of Arrival : ", DateOfArrival);
	}

	// Validation for Bill Type and Bill No

	public void validationBillTypeBillNo() {
		try {
			if (isDisplayed(driver, "//h4[contains(text(),'Error')]")) {
				if (isDisplayed(driver, "//li[contains(text(),'Bill No. is required')]")) {
					test.log(LogStatus.INFO, "Bill No. is required");
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

}
