package globalExportClasses;

//import org.apache.tools.ant.types.resources.comparators.Exists;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class AirwayBillNumberTemplatepage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_SEARCH  = "//button[@name='Search']";
	public static final String OCR_BillType = "//select[@id='editAwbUniqueId_awbUniqueId_billType']";
	public static final String OCR_CarrierCode = "//a[contains(text(),'Carrier Code')]";
	public static final String OCR_FFCode = "//a[contains(text(),'Freight Forwarder Code')]";
	public static final String OCR_DestinationCode = "//a[contains(text(),'Destination Code')]";
	public static final String OCR_Startvalue = "//input[@id='editAwbUniqueId_awbUniqueId_stRangeA']";
	public static final String OCR_RangeA = "//input[@id='editAwbUniqueId_stRangeNum']";
	public static final String OCR_Endvalue = "//input[@id='editAwbUniqueId_awbUniqueId_endRangeA']";
	public static final String OCR_RangeB = "//input[@id='editAwbUniqueId_endRangeNum']";
	public static final String OCR_SaveButton = "(//button[contains(text(),'Save')])[1]";
	public static final String OCR_SaveReturnButton = "(//button[contains(text(),'Save & Return')])[1]";
	public static final String OCR_CancelButton = "(//button[contains(text(),'Cancel')])[1]";
	public static final String OCR_Errormsg = "//h4[contains(text(),'Error!')]";
	
	
	
	
	
	/* ******************************* Constructor ****************************** */

	public AirwayBillNumberTemplatepage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test; 
    }
	/* ******************************* Action ****************************** */
	public void billType(String BillType) {
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCR_BillType, "Select Bill Type : ", BillType);
	}
	
	public void carrierCode(String CarrierCode) {
	if(CarrierCode.length() > 0) {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_CarrierCode, "CLick on Carrier Code link : ");
		typeText(driver, test, "//input[@id='searchForm_carrier_carrierCode']", "Enter Carrier Code : ", CarrierCode);
		clickElement(driver, test, "//button[@class='primary-btn popupSearchButton']", "Search Carrier Code : ");
		clickElement(driver, test, "//td[contains(text(),'"+ CarrierCode +"')]",  CarrierCode);
		clickElement(driver, test, "(//button[@name='Ok'])[1]", "Select carrier code : ");
	}
	}
	public void ffCode(String FFCode) {
	if(FFCode.length() > 0) {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_FFCode, "CLick on FF Code link : ");
		typeText(driver, test, "//input[@id='searchForm_freightForwarder_ffCode']", "Enter FF Code : ", FFCode);
		clickElement(driver, test, "//button[@class='primary-btn popupSearchButton']", "Search FF Code : ");
		clickElement(driver, test, "//td[contains(text(),'"+ FFCode +"')]",  FFCode);
		clickElement(driver, test, "(//button[@name='Ok'])[1]", "Select FF code : ");
	}
	}
	public void destCode(String DestCode) {
	if(DestCode.length() > 0) {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_DestinationCode, "CLick on Destination Code link : ");
		typeText(driver, test, "//input[@id='searchForm_airport_destinationCode']", "Enter Destination Code : ", DestCode);
		clickElement(driver, test, "//button[@class='primary-btn popupSearchButton']", "Search Destination Code : ");
		clickElement(driver, test, "//td[contains(text(),'"+ DestCode +"')]",  DestCode);
		clickElement(driver, test, "(//button[@name='Ok'])[1]", "Select Destination code : ");
	}
	}
	
	public void startValue(String startValue, String RangeA) {
		Wait.waitfor(2);
		typeText(driver, test, OCR_Startvalue, "Enter start value : ", startValue);
		Wait.waitfor(2);
		typeText(driver, test, OCR_RangeA, "Enter Range A : ", RangeA + randomnumbers());
		
	}
	
	//fetch the RangeA value
	public String RangeAValue() {
		Wait.waitfor(2);
		return getText(driver, test, OCR_RangeA, "Fetch Range A value");
	}
	
	public void endValue(String endValue, String RangeB) {
		Wait.waitfor(2);
		typeText(driver, test, OCR_Endvalue, "Enter end value : ", endValue);
		Wait.waitfor(2);
		typeText(driver, test, OCR_RangeB, "Enter Range B : ", RangeB + randomnumbers());
	//	typeText(driver, test, OCR_RangeB, "Enter  Random Range B : ", randomnumbers());
	}
	
	public void saveBtn() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_SaveButton, "Click on Save button : ");
	}
	
	public void saveReturnBtn() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_SaveReturnButton, "Click on Save And Return button : ");
	}
	
	public void CancelBtn() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_CancelButton, "Click on Cancel button : ");
	}

	public void NoOfDigits(String Digit) {
		Wait.waitfor(2);
		typeText(driver, test, "//input[@id='editAwbUniqueId_noOfDigits']", "Enter No Of digits : ", Digit + randomnumbers());
	//	typeText(driver, test, "//input[@id='editAwbUniqueId_noOfDigits']", "Enter  Random NoOfDigit : ", randomnumbers());
	}
	
	public void newSearchBtn() {
		Wait.waitfor(2);
		clickElement(driver, test, "//button[@name='New Search']", "Click on New Search button : ");
	}
	
	public void addAWBBtn() {
		Wait.waitfor(2);
		clickElement(driver, test, "//button[contains(text(),'Add AWB Unique ID')]", "Click on Add AWB unique ID button : ");
	}
	
	public void heading() {
		Wait.waitfor(2);
		 try {
	            if(isDisplayed(driver, "//h3[@class='page-heading']")) {
	                test.log(LogStatus.PASS, "Title is Displayed : Airway Bill Number Template");
	            }
	        } catch (Exception e) {
	            testFailSshot(driver, test);
	            test.log(LogStatus.FAIL, "Title is not Displayed : Airway Bill Number Template");
	        }
		
	}
	
	public void clickAwb() {
		Wait.waitfor(2);
		clickElement(driver, test, "(//a[contains(text(),'AWB')])[2]", "Click on AWB link : ");
	}
	
	public void copyAWB() {
		Wait.waitfor(2);
		clickElement(driver, test, "//i[@class='fa fa-copy']", "Click on Copy icon : ");
	}
	
	public void deleteAWB() {
		Wait.waitfor(2);
		clickElement(driver, test, "//i[@class='fa fa-trash-o']", "CLick on Delete icon : ");
	}
	
	public void duplicateErrorMsg() {
		Wait.waitfor(2);
		String errorMsg = getText(driver, test, "//span[contains(text(),'Duplicate Record.')]", "Duplicate record error message is displayed.");
	 
		try {
			if(errorMsg.equalsIgnoreCase("Duplicate Record.")) {
				test.log(LogStatus.PASS, "Duplicate error message displays. This test script passes since System does not allow duplicate AWB creation :");
			
			}
		}catch(Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Duplicate error message does not display. This test script fails :");
		}
	
	
	}
	
	public void validateMandatoryChecks() {
		Wait.waitfor(2);
		String errorMsg = getText(driver, test, "//h4[contains(text(),'Error!')]", "Error message is displayed");
		
		try {
			if(errorMsg.equalsIgnoreCase("Error!")) {
				test.log(LogStatus.PASS, "Error message displays to enter mandatory fields before saving a record.");
			}
		}catch(Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Error message is not displayed.");
		}
	}
	
}
