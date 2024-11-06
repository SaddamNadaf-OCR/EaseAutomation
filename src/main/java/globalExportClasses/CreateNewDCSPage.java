package globalExportClasses;
/* 
 * Module : Export Operation
 * Author  : Saddam
 * created date : May 2024
 * Descriptions : Create New DCS Page
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

public class CreateNewDCSPage extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_DCSAddPage_Save = "//button[@name='save.x']";
	public static final String OCR_DCSAddPage_SaveandReturn = "//button[contains(text(),'Save & Return')]";
	public static final String OCR_DCSAddPage_Cancel = "//button[@name='cancel.x']";
	public static final String OCR_DCSAddPage_DSCID = "//input[@name='dcs.dcsId']";
	public static final String OCR_DCSAddPage_ExportingCountry = "//select[@name='dcs.licensedCountry']";
	public static final String OCR_DCSAddPage_ImportingCountry = "//input[@name='dcs.countryName']";
	public static final String OCR_DCSAddPage_Statement = "//textarea[@name='dcs.statement']";
	public static final String OCR_DCSAddPage_DefaultFlag = "//input[@name='defaultFlag']";
	public static final String OCR_DCSAddPage_ShipUltConsignee = "(//input[@name='dcs.nacFlag'])[1]";
	public static final String OCR_DCSAddPage_LicenseEndUser = "(//input[@name='dcs.nacFlag'])[2]";
	public static final String OCR_DCSAddPage_Heading = "//h3[@class='page-heading']";
	public static final String OCR_DCSAddPage_DCSIDisrequiredError = "//span[contains(text(),'DCS ID is required.')]";
	public static final String OCR_DCSAddPage_ExportingCountryisrequiredError = "//span[contains(text(),'Exporting Country is required.')]";

	/* ******************************* Constructor ****************************** */

	public CreateNewDCSPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	// Click on Save Button
	public void save() {
		clickElement(driver, test, OCR_DCSAddPage_Save, "Clicking on Save Button :");
	}

	// Click on Save and Return Button
	public void saveandReturn() {
		clickElement(driver, test, OCR_DCSAddPage_SaveandReturn, "Clicking on Save and Return Button :");
	}

	// Click on Cancel Button
	public void cancel() {
		clickElement(driver, test, OCR_DCSAddPage_Cancel, "Clicking on Cancel Button :");
	}

	// Add DSC ID
	public void DSCID(String DSCID) {
		typeText(driver, test, OCR_DCSAddPage_DSCID, "Entering DSC ID :", DSCID);
	}

	// Enter DCSID Edit
	public void DCSIDEdit(String DCSID) {
		typeText(driver, test, OCR_DCSAddPage_DSCID, "Selecting DSC ID :",DCSID + randomnumbers());
	}

	// Add Exporting Country
	public void subcode(String ExportingCountry) {
		selectByVisibleText(driver, test, OCR_DCSAddPage_ExportingCountry, "Entering Exporting Country :", ExportingCountry);
	}
	
	// Enter Importing Country
	public void importingCountry(String ImportingCountry) {
		typeText(driver, test, OCR_DCSAddPage_ImportingCountry, "Entering Importing Country :",ImportingCountry);
	}
	
	// Enter Statement
	public void statement(String Statement) {
		typeText(driver, test, OCR_DCSAddPage_Statement, "Entering Statement :",Statement);
	}
	
	//Click onDefault Flag
	public void defaultFlag() {
		clickElement(driver, test, OCR_DCSAddPage_DefaultFlag, "Clicking on Default Flag Checkbox :");
	}
	
	//Select Name or Country
	public void nameandCountryDataReferance(String ITARShipment) {
		if(ITARShipment.equalsIgnoreCase("ShipmentUltimantConsignee")) {
			clickElement(driver, test, OCR_DCSAddPage_ShipUltConsignee, "Clicking on Shipment Ultimate Consignee Checkbox :");
		}else {
			clickElement(driver, test, OCR_DCSAddPage_LicenseEndUser, "Clicking on License End user :");
		}
	}

	// Add the parameters
	public void addParameters(String DSCID, String ExportingCountry, String ImportingCountry, String Statement) {

		typeText(driver, test, OCR_DCSAddPage_DSCID, "Entering DSC ID :", DSCID+randomnumbersbetween1_1000());
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCR_DCSAddPage_ExportingCountry, "Entering Exporting Country :", ExportingCountry);
		Wait.waitfor(2);
		typeText(driver, test, OCR_DCSAddPage_ImportingCountry, "Entering Importing Country :",ImportingCountry);
		Wait.waitfor(2);
		typeText(driver, test, OCR_DCSAddPage_Statement, "Entering Statement :",Statement);
		Wait.waitfor(2);
		clickElement(driver, test, OCR_DCSAddPage_DefaultFlag, "Clicking on Default Flag Checkbox :");
	}

	// Heading is Displayed
	public void titleisDisplayed() {
		try {
			if (isDisplayed(driver, OCR_DCSAddPage_Heading)) {
				test.log(LogStatus.PASS, "Heading is Displayed :");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Heading is Not Displayed :");
		}

	}

	// get the Contract Code
	public String getDSCID() {
		return getAttribute(driver, test, OCR_DCSAddPage_DSCID, "", "Getting the Contract Code :");
	}

	// Error Validation
	public void errorValidation() {
		try {
			if (isDisplayed(driver, OCR_DCSAddPage_DCSIDisrequiredError)) {
				test.log(LogStatus.PASS, "DSC ID Required Error Msg is Displayed :");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "DSC ID Required Error Msg is Not Displayed :");
		}
		try {
			if (isDisplayed(driver, OCR_DCSAddPage_ExportingCountryisrequiredError)) {
				test.log(LogStatus.PASS, "Exporting Country is Required Error Msg is Displayed :");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Exporting Country is Required Error Msg is Not Displayed :");
		}
	}

}
