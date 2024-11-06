package globalExportClasses;
/* 
 * Module : Export Operation
 * Author  : Saddam
 * created date : May 2024
 * Descriptions : Create New Ocean Contract Header Page
 * changed by : Nil
 * changed date : Nil
 * Purpose of change : Nil 
 * Reviewed by : Nil 
 */
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import utilities.GenericMethods;
import utilities.Wait;

public class CreateNewOceanContractHeaderPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_OceanContractAddPage_Save = "//input[@value='Save']";
	public static final String OCR_OceanContractAddPage_SaveandReturn = "//input[@value='Save & Return']";
	public static final String OCR_OceanContractAddPage_Cancel = "//input[@value='Cancel']";
	public static final String OCR_OceanContractAddPage_ContractCode = "//input[@name='oceanContractCode']";
	public static final String OCR_OceanContractAddPage_DestCountryCode = "//input[@name='countryName']";
	public static final String OCR_OceanContractAddPage_CarrierCode = "//a[contains(text(),'Carrier Code')]";
	public static final String OCR_OceanContractAddPage_CarrierCodePopup = "//input[@id='searchForm_carrier_carrierCode']";
	public static final String OCR_OceanContractAddPage_SearchPopup = "//button[@name='Search']";
	public static final String OCR_OceanContractAddPage_SelectPopup = "//button[@name='Ok']";
	public static final String OCR_OceanContractAddPage_ClosePopup = "(//button[@class='btn-close'])[1]";
	public static final String OCR_OceanContractAddPage_DeparturePortCode = "//a[contains(text(),'Departure Port Code')]";
	public static final String OCR_OceanContractAddPage_PortIDPopup = "//input[@name='ports.portId']";
	public static final String OCR_OceanContractAddPage_DestinationPortCode = "//a[contains(text(),'Destination Port Code')]";
	public static final String OCR_OceanContractAddPage_Heading = "//h3[@class='page-heading']";
	public static final String OCR_OceanContractAddPage_ContactCodeMandatoryError = "//li[contains(text(),'Contract Code is Required.')]";
	public static final String OCR_OceanContractAddPage_ContactSubCodeMandatoryError = "//li[contains(text(),'Contract Sub Code is Required.')]";

	/* ******************************* Constructor ****************************** */

	public CreateNewOceanContractHeaderPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	// Click on Save Button
	public void save() {
		clickElement(driver, test, OCR_OceanContractAddPage_Save, "Clicking on Save Button :");
	}

	// Click on Save and Return Button
	public void saveandReturn() {
		clickElement(driver, test, OCR_OceanContractAddPage_SaveandReturn, "Clicking on Save and Return Button :");
	}

	// Click on Cancel Button
	public void cancel() {
		clickElement(driver, test, OCR_OceanContractAddPage_Cancel, "Clicking on Cancel Button :");
	}

	// Add Contract Code
	public void contractCode(String ContractCode) {
		typeText(driver, test, OCR_OceanContractAddPage_ContractCode, "Entering Contract Code :", ContractCode);
	}

	// Enter Contract Code
	public void contractCodeEdit(String ContractCode) {
		typeText(driver, test, OCR_OceanContractAddPage_ContractCode, "Selecting Contract Code :",
				ContractCode + randomnumbersbetween1_100());
	}

	// Add Destination Country Code
	public void subcode(String DestCountryCode) {
		typeText(driver, test, OCR_OceanContractAddPage_DestCountryCode, "Entering Dest Country Code :", DestCountryCode);
	}

	// Add the parameters
	public void addParameters(String ContractCode, String DestCountryCode, String CarrierCode, String DeparturePortCode,
			String DestinationPortCode) {

		typeText(driver, test, OCR_OceanContractAddPage_ContractCode, "Entering Contract Code :",ContractCode + randomnumbersbetween1_1000());
		Wait.waitfor(2);
		typeText(driver, test, OCR_OceanContractAddPage_DestCountryCode, "Entering Dest Country Code :", DestCountryCode);
		Wait.waitfor(2);
		clickElement(driver, test, OCR_OceanContractAddPage_CarrierCode, "Clicking on Carrier Code :");
		try {
			typeText(driver, test, OCR_OceanContractAddPage_CarrierCodePopup, "Entering Carrier Code :", CarrierCode);
			clickElement(driver, test, OCR_OceanContractAddPage_SearchPopup, "Clicking on Search popup Button :");
			mouseOverAndClick(driver, test, "//td[contains(text(),'" + CarrierCode + "')]",
					"Selecting Departure Code :");
			clickElement(driver, test, OCR_OceanContractAddPage_SelectPopup, "Clicking on Select Button :");
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Enable to Select Carrier Code :");
			clickElement(driver, test, OCR_OceanContractAddPage_ClosePopup, "Clicking on Close Popup :");
		}
		Wait.waitfor(2);
		clickElement(driver, test, OCR_OceanContractAddPage_DeparturePortCode,"Clicking on Departure Port Code :");
		try {
			typeText(driver, test, OCR_OceanContractAddPage_PortIDPopup, "Entering Port ID :",DeparturePortCode);
			clickElement(driver, test, OCR_OceanContractAddPage_SearchPopup, "Clicking on Search popup Button :");
			mouseOverAndClick(driver, test, "//td[contains(text(),'" + DeparturePortCode + "')]","Selecting Departure Port Code :");
			clickElement(driver, test, OCR_OceanContractAddPage_SelectPopup, "Clicking on Select Button :");
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Enable to Select Departure Port Code :");
			clickElement(driver, test, OCR_OceanContractAddPage_ClosePopup, "Clicking on Close Popup :");
		}
		Wait.waitfor(2);
		clickElement(driver, test, OCR_OceanContractAddPage_DestinationPortCode, "Clicking on Destination Port Code :");
		try {
			typeText(driver, test, OCR_OceanContractAddPage_PortIDPopup, "Entering Carrier Code Name :",DestinationPortCode);
			clickElement(driver, test, OCR_OceanContractAddPage_SearchPopup, "Clicking on Search popup Button :");
			mouseOverAndClick(driver, test, "//td[contains(text(),'" + DestinationPortCode + "')]", "Selecting Destination Port Code :");
			clickElement(driver, test, OCR_OceanContractAddPage_SelectPopup, "Clicking on Select Button :");
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Enable to Select Destination Port Code :");
			clickElement(driver, test, OCR_OceanContractAddPage_ClosePopup, "Clicking on Close Popup :");
		}
	}

	// Heading is Displayed
	public void titleisDisplayed() {
		try {
			if (isDisplayed(driver, OCR_OceanContractAddPage_Heading)) {
				test.log(LogStatus.PASS, "Heading is Displayed :");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Heading is Not Displayed :");
		}

	}

	// get the Contract Code
	public String getcontractCode() {
		return getTextfromTextbox(driver, test, OCR_OceanContractAddPage_ContractCode, "Getting the Contract Code :"); 
	}

	// Error Validation
	public void errorValidation() {
		try {
			if (isDisplayed(driver, OCR_OceanContractAddPage_ContactCodeMandatoryError)) {
				test.log(LogStatus.PASS, "Error Msg is Displayed :");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Error Msg is Not Displayed :");
		}
	}
}
