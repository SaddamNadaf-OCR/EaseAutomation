package globalExportClasses;
/* 
 * Module : Export Operation
 * Author  : Saddam
 * created date : May 2024
 * Descriptions : Create New Air Contract Header Page
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

public class CreateNewAirContractHeaderPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_AirContractAddPage_Save = "(//button[contains(text(),'Save')])[1]";
	public static final String OCR_AirContractAddPage_SaveandReturn = "(//button[contains(text(),'Save')])[2]";
	public static final String OCR_AirContractAddPage_Cancel = "//button[@name='cancel']";
	public static final String OCR_AirContractAddPage_ContractCode = "//input[@id='editContractHeader_contractHeader_contractCode']";
	public static final String OCR_AirContractAddPage_SubCode = "//input[@id='editContractHeader_contractSubCode']";
	public static final String OCR_AirContractAddPage_DepartureCode = "//a[contains(text(),'Departure Code')]";
	public static final String OCR_AirContractAddPage_AirportCode = "//input[@id='searchForm_airport_destinationCode']";
	public static final String OCR_AirContractAddPage_SearchPopup = "//button[@name='Search']";
	public static final String OCR_AirContractAddPage_SelectPopup = "//button[@name='Ok']";
	public static final String OCR_AirContractAddPage_ClosePopup = "(//button[@class='btn-close'])[1]";
	public static final String OCR_AirContractAddPage_DestinationCode = "//a[contains(text(),'Destination Code')]";
	public static final String OCR_AirContractAddPage_FreightForwarderCode = "//a[contains(text(),'Forwarder Code')]";
	public static final String OCR_AirContractAddPage_FFCodePopup = "//input[@name='freightForwarder.ffCode']";
	public static final String OCR_AirContractAddPage_CarrierCode = "//a[contains(text(),'Carrier Code')]";
	public static final String OCR_AirContractAddPage_CarrierCodePopup = "//input[@id='searchForm_carrier_carrierCode']";
	public static final String OCR_AirContractAddPage_EffectiveDate = "//input[@name='effDate']";
	public static final String OCR_AirContractAddPage_ExpiryDate = "//input[@name='expiryDate']";
	public static final String OCR_AirContractAddPage_CombineWeight = "//select[@name='contractHeader.combineRates']";
	public static final String OCR_AirContractAddPage_Today = "//button[contains(text(),'Today')]";
	public static final String OCR_AirContractAddPage_Heading = "//h3[contains(text(),'Create New Air Contract Header')]";
	public static final String OCR_AirContractAddPage_ContactCodeMandatoryError = "//li[contains(text(),'Contract Code is Required.')]";
	public static final String OCR_AirContractAddPage_ContactSubCodeMandatoryError = "//li[contains(text(),'Contract Sub Code is Required.')]";
	public static final String OCR_AirContractAddPage_DepartureCodeMandatoryError = "//li[contains(text(),'Departure Code is required.')]";
	public static final String OCR_AirContractAddPage_DestinationCodeMandatoryError = "//li[contains(text(),'Destination Code is required.')]";
	public static final String OCR_AirContractAddPage_FFMandatoryError = "//li[contains(text(),'Freight Forwarder Code is required.')]";

	/* ******************************* Constructor ****************************** */

	public CreateNewAirContractHeaderPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	// Click on Search Button
	public void save() {
		clickElement(driver, test, OCR_AirContractAddPage_Save, "Clicking on Save Button :");
	}

	// Click on Save and Return Button
	public void saveandReturn() {
		clickElement(driver, test, OCR_AirContractAddPage_SaveandReturn, "Clicking on Save and Return Button :");
	}

	// Click on Cancel Button
	public void cancel() {
		clickElement(driver, test, OCR_AirContractAddPage_Cancel,"Clicking on Cancel Button :");
	}
	
	//Add Contract Code
	public void contractCode(String ContractCode) {
		typeText(driver, test, OCR_AirContractAddPage_ContractCode, "Entering Contract Code :", ContractCode);
	}
	
	//Add Sub Code
	public void subcode(String SubCode) {
		typeText(driver, test, OCR_AirContractAddPage_SubCode, "Entering Sub Code :", SubCode+randomnumbersbetween1_100());
	}
	
	//Add the parameters
	public void addParameters(String ContractCode, String SubCode, String DepartureCode, String DestinationCode, 
			String FreightForwarder, String CarrierCode, String CombineWeight) {
		
		typeText(driver, test, OCR_AirContractAddPage_ContractCode, "Entering Contract Code :", ContractCode+randomnumbersbetween1_100());
		Wait.waitfor(2);
		typeText(driver, test, OCR_AirContractAddPage_SubCode, "Entering Sub Code :", SubCode+randomnumbersbetween1_100());
		Wait.waitfor(2);
		clickElement(driver, test, OCR_AirContractAddPage_DepartureCode, "Clicking on Departure Code :");
		try {
			typeText(driver, test, OCR_AirContractAddPage_AirportCode, "Entering Airport Name :", DepartureCode);
			clickElement(driver, test, OCR_AirContractAddPage_SearchPopup, "Clicking on Search popup Button :");
			mouseOverAndClick(driver, test, "//td[contains(text(),'" + DepartureCode + "')]","Selecting Departure Code :");
			clickElement(driver, test, OCR_AirContractAddPage_SelectPopup, "Clicking on Select Button :");
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Enable to Select Departure Code :");
			clickElement(driver, test, OCR_AirContractAddPage_ClosePopup, "Clicking on Close Popup :");
		}
		Wait.waitfor(2);
		clickElement(driver, test, OCR_AirContractAddPage_DestinationCode, "Clicking on Destination Code :");
		try {
			typeText(driver, test, OCR_AirContractAddPage_AirportCode, "Entering Airport Name :",DestinationCode);
			clickElement(driver, test, OCR_AirContractAddPage_SearchPopup, "Clicking on Search popup Button :");
			mouseOverAndClick(driver, test, "//td[contains(text(),'" + DestinationCode + "')]","Selecting Destination Code :");
			clickElement(driver, test, OCR_AirContractAddPage_SelectPopup, "Clicking on Select Button :");
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Enable to Select Destination Code :");
			clickElement(driver, test, OCR_AirContractAddPage_ClosePopup, "Clicking on Close Popup :");
		}
		Wait.waitfor(2);
		clickElement(driver, test, OCR_AirContractAddPage_FreightForwarderCode,"Clicking on Freight Forwarder Code :");
		try {
			typeText(driver, test, OCR_AirContractAddPage_FFCodePopup, "Entering Freight Forwarder Name :",FreightForwarder);
			clickElement(driver, test, OCR_AirContractAddPage_SearchPopup, "Clicking on Search popup Button :");
			mouseOverAndClick(driver, test, "//td[contains(text(),'" + FreightForwarder + "')]","Selecting Freight Forwarder Code :");
			clickElement(driver, test, OCR_AirContractAddPage_SelectPopup, "Clicking on Select Button :");
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Enable to Select Freight Forwarder Code :");
			clickElement(driver, test, OCR_AirContractAddPage_ClosePopup, "Clicking on Close Popup :");
		}
		Wait.waitfor(2);
		clickElement(driver, test, OCR_AirContractAddPage_CarrierCode,"Clicking on Carrier Code :");
		try {
			typeText(driver, test, OCR_AirContractAddPage_CarrierCodePopup, "Entering Carrier Code Name :",CarrierCode);
			clickElement(driver, test, OCR_AirContractAddPage_SearchPopup, "Clicking on Search popup Button :");
			mouseOverAndClick(driver, test, "//td[contains(text(),'" + CarrierCode + "')]","Selecting Carrier Code :");
			clickElement(driver, test, OCR_AirContractAddPage_SelectPopup, "Clicking on Select Button :");
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Enable to Select Carrier Code :");
			clickElement(driver, test, OCR_AirContractAddPage_ClosePopup, "Clicking on Close Popup :");
		}
		Wait.waitfor(2);
		if(CombineWeight.equalsIgnoreCase("Yes")) {
			selectByVisibleText(driver, test, OCR_AirContractAddPage_CombineWeight, "Selecting Combine Weight :", CombineWeight);
		}else {
			selectByVisibleText(driver, test, OCR_AirContractAddPage_CombineWeight, "Selecting Combine Weight :", CombineWeight);
		}
	}
	
	//Heading is Displayed
	public void titleisDisplayed() {
		try {
			if(isDisplayed(driver, OCR_AirContractAddPage_Heading)) {
				test.log(LogStatus.PASS, "Heading is Displayed :");
			}
		}catch(Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Heading is Not Displayed :");
		}
		
	}
	
	//get the Air Contract no
	public String getcontractCode() {
		return getTextfromTextbox(driver, test, OCR_AirContractAddPage_ContractCode, "Getting the Contract Code :");
	}
	
	//Error Validation
		public void errorValidation() {
			try {
				if(isDisplayed(driver, OCR_AirContractAddPage_ContactCodeMandatoryError)) {
					test.log(LogStatus.PASS, "Error Msg is Displayed :");
				}
			}catch(Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Error Msg is Not Displayed :");
			}
			try {
				if(isDisplayed(driver, OCR_AirContractAddPage_ContactSubCodeMandatoryError)) {
					test.log(LogStatus.PASS, "Error Msg is Displayed :");
				}
			}catch(Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Error Msg is Not Displayed :");
			}
			try {
				if(isDisplayed(driver, OCR_AirContractAddPage_DepartureCodeMandatoryError)) {
					test.log(LogStatus.PASS, "Error Msg is Displayed :");
				}
			}catch(Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Error Msg is Not Displayed :");
			}
			try {
				if(isDisplayed(driver, OCR_AirContractAddPage_DestinationCodeMandatoryError)) {
					test.log(LogStatus.PASS, "Error Msg is Displayed :");
				}
			}catch(Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Error Msg is Not Displayed :");
			}
			try {
				if(isDisplayed(driver, OCR_AirContractAddPage_FFMandatoryError)) {
					test.log(LogStatus.PASS, "Error Msg is Displayed :");
				}
			}catch(Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Error Msg is Not Displayed :");
			}
		}

}
