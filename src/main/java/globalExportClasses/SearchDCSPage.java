package globalExportClasses;
/* 
 * Module : Export Operation
 * Author  : Saddam
 * created date : May 2024
 * Descriptions : Search DCS Page
 * changed by : Nil
 * changed date : Nil
 * Purpose of change : Nil 
 * Reviewed by : Nil 
 */
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;

public class SearchDCSPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_DCSSearchPage_Search = "//button[contains(text(),'Search')]";
	public static final String OCR_DCSSearchPage_Reset = "//button[contains(text(),'Reset')]";
	public static final String OCR_DCSSearchPage_AddNewDCS = "//button[contains(text(),'Add New DCS')]";
	public static final String OCR_DCSSearchPage_SBUCode = "//select[@id='resultDcs_dcs_sbuCode']";
	public static final String OCR_DCSSearchPage_DCSID = "//input[@id='resultDcs_dcs_dcsId']";
	public static final String OCR_DCSSearchPage_ExportingCountry = "//select[@id='resultDcs_dcs_licensedCountry']";
	public static final String OCR_DCSSearchPage_ImportingCountry = "//input[@id='resultDcs_dcs_countryName']";
	public static final String OCR_DCSSearchPage_PortOfUnloadingCode = "//input[@id='searchOceanContract_oceanContract_portOfUnloadingCode']";
	public static final String OCR_DCSSearchPage_Heading = "//h3[contains(text(),'Search DCS')]";

	/* ******************************* Constructor ****************************** */

	public SearchDCSPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	// Click on Search Button
	public void search() {
		clickElement(driver, test, OCR_DCSSearchPage_Search, "Clicking on Search Button :");
	}

	// Click on Reset Button
	public void reset() {
		clickElement(driver, test, OCR_DCSSearchPage_Reset, "Clicking on Reset Button :");
	}

	// Click on Add New DCS Button
	public void addDCSID() {
		clickElement(driver, test, OCR_DCSSearchPage_AddNewDCS, "Clicking on Add New DCS Button :");
	}

	// Select SBU Code
	public void selectSBU(String SBUCode) {
		selectByVisibleText(driver, test, OCR_DCSSearchPage_SBUCode, "Selecting SBU Code :", SBUCode);
	}

	// Enter Contract Code
	public void DCSID(String DCSID) {
		typeText(driver, test, OCR_DCSSearchPage_DCSID, "Entering DCS ID :", DCSID);
	}

	// Enter Exporting Country
	public void exportingCountry(String ExportingCountry) {
		selectByVisibleText(driver, test, OCR_DCSSearchPage_ExportingCountry, "Selecting Exporting Country :", ExportingCountry);
	}

	// Enter Importing Country
	public void ImportingCountry(String ImportingCountry) {
		typeText(driver, test, OCR_DCSSearchPage_ImportingCountry, "Entering Importing Country :",ImportingCountry);
	}

	// Search By Parameters
	public void searchbyParameters(String SBUCode, String DCSID, String ExportingCountry, String ImportingCountry) {

		if (SBUCode.length() > 0) {
			selectByVisibleText(driver, test, OCR_DCSSearchPage_SBUCode, "Selecting SBU Code :", SBUCode);
		}
		if (DCSID.length() > 0) {
			typeText(driver, test, OCR_DCSSearchPage_DCSID, "Entering DSC ID :", DCSID);
		}
		if (ExportingCountry.length() > 0) {
			selectByVisibleText(driver, test, OCR_DCSSearchPage_ExportingCountry, "Selecting Exporting Country :", ExportingCountry);
		}
		if (ImportingCountry.length() > 0) {
			typeText(driver, test, OCR_DCSSearchPage_ImportingCountry, "Entering Importing Country :",ImportingCountry);
		}
	}
	
	//Heading is Displayed
	public void TitleisDisplayed() {
		try {
			if(isDisplayed(driver, OCR_DCSSearchPage_Heading)) {
				test.log(LogStatus.PASS, "Heading is Displayed :");
			}
		}catch(Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Heading is Not Displayed :");
		}
	}
}
