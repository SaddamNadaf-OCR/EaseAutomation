package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class AddNewMasterAirwayBillPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	
	public static final String OCR_addMAWBNO = "//input[@name='mawb.mawbno']";
	public static final String OCR_FFCODE =  "//input[@name='mawb.ffCode']";
	public static final String OCR_ConsigneeCode = "//input[@name='mawb.consigneeId']";
	public static final String OCR_SaveButton ="//button[@name='save']";
	public static final String OCR_Carrier = "//a[@class='mawbCarrier']";
	public static final String OCR_CarrierCode = "//input[@name='mawb.carriercode1']";
	public static final String OCR_CarrierSave ="//button[@name='saveCarrier']";	
	public static final String OCR_Charges = "//a[@class='mawbCharges']";
	public static final String OCR_SaveReturn ="//button[@name='saveandreturn']";
	
	/* ******************************* Constructor ****************************** */

	public AddNewMasterAirwayBillPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test; 
	}
	/* ******************************* Action ****************************** */
	// MAWB ADD DATA
	public void mawbADD (String MAWBNO, String FFCODE, String ConsigneeCode) {
		typeText(driver, test, OCR_addMAWBNO, "Enter MAWBNO", MAWBNO+randomnumbers());
		typeText(driver, test, OCR_FFCODE, "Enter FF CODE", FFCODE);
		typeText(driver, test, OCR_ConsigneeCode, "Enter Consignee CODE", ConsigneeCode);
		clickElement(driver, test, OCR_SaveButton, "click on save");
	}
	//Add by carrier parameter	
		public void carrier (String CarrierCode) {
			clickElement(driver, test, OCR_Carrier, "Click on Carrier");
			typeText(driver, test, OCR_CarrierCode, "Enter Carrier Code", CarrierCode);
			clickElement(driver, test, OCR_CarrierSave, "Click on Save");
				
		}
		//Add by Charges parameter	
		public void charges () {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_Charges, "Click on Charges");
			clickElement(driver, test, OCR_SaveReturn, "Click on Save and Return");
		}
	}
		
