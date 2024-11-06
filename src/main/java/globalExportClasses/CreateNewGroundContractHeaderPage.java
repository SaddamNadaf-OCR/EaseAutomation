package globalExportClasses;

/* 
 * Module : Export Operation
 * Author  : Saddam
 * created date : May 2024
 * Descriptions : Create New Ground Contract Header Page
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

public class CreateNewGroundContractHeaderPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_GroundContractAddPage_Save = "(//button[contains(text(),'Save')])[1]";
	public static final String OCR_GroundContractAddPage_SaveandReturn = "(//button[contains(text(),'Save')])[2]";
	public static final String OCR_GroundContractAddPage_Cancel = "//button[@name='cancel']";
	public static final String OCR_GroundContractAddPage_ContractCode = "//input[@id='editGroundContractHeader_groundContractHeader_contractCode']";
	public static final String OCR_GroundContractAddPage_SubCode = "//input[@id='editGroundContractHeader_contractSubCode']";
	public static final String OCR_GroundContractAddPage_DepartureCode = "//a[contains(text(),'Departure Code')]";
	public static final String OCR_GroundContractAddPage_AirportCode = "//input[@id='searchForm_airport_destinationCode']";
	public static final String OCR_GroundContractAddPage_SearchPopup = "//button[@name='Search']";
	public static final String OCR_GroundContractAddPage_SelectPopup = "//button[@name='Ok']";
	public static final String OCR_GroundContractAddPage_ClosePopup = "(//button[@class='btn-close'])[1]";
	public static final String OCR_GroundContractAddPage_FreightForwarderCode = "//a[contains(text(),'Forwarder Code')]";
	public static final String OCR_GroundContractAddPage_FFCodePopup = "//input[@name='freightForwarder.ffCode']";
	public static final String OCR_GroundContractAddPage_CarrierCode = "//a[contains(text(),'Carrier Code')]";
	public static final String OCR_GroundContractAddPage_CarrierCodePopup = "//input[@id='searchForm_groundCarrier_grCarrierCode']";
	public static final String OCR_GroundContractAddPage_EffectiveDate = "//input[@name='effDate']";
	public static final String OCR_GroundContractAddPage_ExpiryDate = "//input[@name='expiryDate']";
	public static final String OCR_GroundContractAddPage_CombineWeight = "//select[@name='groundContractHeader.combineRates']";
	public static final String OCR_GroundContractAddPage_Today = "//button[contains(text(),'Today')]";
	public static final String OCR_GroundContractAddPage_Heading = "//h3[@class='page-heading']";
	public static final String OCR_GroundContractAddPage_ContactCodeMandatoryError = "//li[contains(text(),'Contract Code is Required.')]";
	public static final String OCR_GroundContractAddPage_ContactSubCodeMandatoryError = "//li[contains(text(),'Contract Sub Code is Required.')]";
	public static final String OCR_GroundContractAddPage_DepartureCodeMandatoryError = "//li[contains(text(),'Departure Code is Required.')]";
	public static final String OCR_GroundContractAddPage_FreightForwarderCodeMandatoryError = "//li[contains(text(),'Freight Forwarder Code is Required.')]";
	public static final String OCR_GroundContractAddPage_GroundCarrierCodeMandatoryError = "//li[contains(text(),'Ground Carrier Code is required. ')]";

	/* ******************************* Constructor ****************************** */

	public CreateNewGroundContractHeaderPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	// Click on Search Button
	public void save() {
		clickElement(driver, test, OCR_GroundContractAddPage_Save, "Clicking on Save Button :");
	}

	// Click on Save and Return Button
	public void saveandReturn() {
		clickElement(driver, test, OCR_GroundContractAddPage_SaveandReturn, "Clicking on Save and Return Button :");
	}

	// Click on Cancel Button
	public void cancel() {
		clickElement(driver, test, OCR_GroundContractAddPage_Cancel, "Clicking on Cancel Button :");
	}

	// Add Contract Code
	public void contractCode(String ContractCode) {
		typeText(driver, test, OCR_GroundContractAddPage_ContractCode, "Entering Contract Code :", ContractCode);
	}

	// Enter Contract Code
	public void contractCodeEdit(String ContractCode) {
		typeText(driver, test, OCR_GroundContractAddPage_ContractCode, "Selecting Contract Code :",
				ContractCode + randomnumbers());
	}

	// Add Sub Code
	public void subcode(String SubCode) {
		typeText(driver, test, OCR_GroundContractAddPage_SubCode, "Entering Sub Code :", SubCode);
	}

	// Add the parameters
	public void addParameters(String ContractCode, String SubCode, String DepartureCode, String FreightForwarder,
			String CarrierCode, String CombineWeight) {

		typeText(driver, test, OCR_GroundContractAddPage_ContractCode, "Entering Contract Code :", ContractCode+randomnumbersbetween1_1000());
		Wait.waitfor(2);
		typeText(driver, test, OCR_GroundContractAddPage_SubCode, "Entering Sub Code :", SubCode);
		Wait.waitfor(2);
		clickElement(driver, test, OCR_GroundContractAddPage_DepartureCode, "Clicking on Departure Code :");
		try {
			typeText(driver, test, OCR_GroundContractAddPage_AirportCode, "Entering Airport Name :", DepartureCode);
			clickElement(driver, test, OCR_GroundContractAddPage_SearchPopup, "Clicking on Search popup Button :");
			mouseOverAndClick(driver, test, "//td[contains(text(),'" + DepartureCode + "')]",
					"Selecting Departure Code :");
			clickElement(driver, test, OCR_GroundContractAddPage_SelectPopup, "Clicking on Select Button :");
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Enable to Select Departure Code :");
			clickElement(driver, test, OCR_GroundContractAddPage_ClosePopup, "Clicking on Close Popup :");
		}
		Wait.waitfor(2);
		clickElement(driver, test, OCR_GroundContractAddPage_FreightForwarderCode,
				"Clicking on Freight Forwarder Code :");
		try {
			typeText(driver, test, OCR_GroundContractAddPage_FFCodePopup, "Entering Freight Forwarder Name :",
					FreightForwarder);
			clickElement(driver, test, OCR_GroundContractAddPage_SearchPopup, "Clicking on Search popup Button :");
			mouseOverAndClick(driver, test, "//td[contains(text(),'" + FreightForwarder + "')]",
					"Selecting Freight Forwarder Code :");
			clickElement(driver, test, OCR_GroundContractAddPage_SelectPopup, "Clicking on Select Button :");
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Enable to Select Freight Forwarder Code :");
			clickElement(driver, test, OCR_GroundContractAddPage_ClosePopup, "Clicking on Close Popup :");
		}
		Wait.waitfor(2);
		clickElement(driver, test, OCR_GroundContractAddPage_CarrierCode, "Clicking on Carrier Code :");
		try {
			typeText(driver, test, OCR_GroundContractAddPage_CarrierCodePopup, "Entering Carrier Code Name :",
					CarrierCode);
			clickElement(driver, test, OCR_GroundContractAddPage_SearchPopup, "Clicking on Search popup Button :");
			mouseOverAndClick(driver, test, "//td[contains(text(),'" + CarrierCode + "')]", "Selecting Carrier Code :");
			clickElement(driver, test, OCR_GroundContractAddPage_SelectPopup, "Clicking on Select Button :");
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Enable to Select Carrier Code :");
			clickElement(driver, test, OCR_GroundContractAddPage_ClosePopup, "Clicking on Close Popup :");
		}
		Wait.waitfor(2);
		if (CombineWeight.equalsIgnoreCase("Yes")) {
			selectByVisibleText(driver, test, OCR_GroundContractAddPage_CombineWeight, "Selecting Combine Weight :",
					CombineWeight);
		} else {
			selectByVisibleText(driver, test, OCR_GroundContractAddPage_CombineWeight, "Selecting Combine Weight :",
					CombineWeight);
		}
	}

	// Heading is Displayed
	public void titleisDisplayed() {
		try {
			if (isDisplayed(driver, OCR_GroundContractAddPage_Heading)) {
				test.log(LogStatus.PASS, "Heading is Displayed :");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Heading is Not Displayed :");
		}

	}

	// get the Air Contract no
	public String getcontractCode() {
		return getText(driver, test, OCR_GroundContractAddPage_ContractCode, "Getting the Contract Code :");
	}

	// Error Validation
	public void errorValidation() {
		try {
			if (isDisplayed(driver, OCR_GroundContractAddPage_ContactCodeMandatoryError)) {
				test.log(LogStatus.PASS, "Error Msg is Displayed :");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Error Msg is Not Displayed :");
		}
		try {
			if (isDisplayed(driver, OCR_GroundContractAddPage_ContactSubCodeMandatoryError)) {
				test.log(LogStatus.PASS, "Error Msg is Displayed :");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Error Msg is Not Displayed :");
		}
		try {
			if (isDisplayed(driver, OCR_GroundContractAddPage_DepartureCodeMandatoryError)) {
				test.log(LogStatus.PASS, "Error Msg is Displayed :");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Error Msg is Not Displayed :");
		}
		try {
			if (isDisplayed(driver, OCR_GroundContractAddPage_FreightForwarderCodeMandatoryError)) {
				test.log(LogStatus.PASS, "Error Msg is Displayed :");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Error Msg is Not Displayed :");
		}
		try {
			if (isDisplayed(driver, OCR_GroundContractAddPage_GroundCarrierCodeMandatoryError)) {
				test.log(LogStatus.PASS, "Error Msg is Displayed :");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Error Msg is Not Displayed :");
		}
	}
}
