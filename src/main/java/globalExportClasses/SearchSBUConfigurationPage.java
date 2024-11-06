package globalExportClasses;

/* 
 * Module : Export Operation
 * Author  : Saddam
 * created date : July 2024
 * Descriptions : Search SBU Configuration Page
 * changed by : Nil
 * changed date : Nil
 * Purpose of change : Nil 
 * Reviewed by : Nil 
 */
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;

public class SearchSBUConfigurationPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_SBUConfi_SearchButton = "//button[contains(text(),'Search')]";
	public static final String OCR_SBUConfi_ResetButton = "//button[contains(text(),'Reset')]";
	public static final String OCR_SBUConfi_ModuleID = "//select[@id='resultSbuConf_sbuConf_modId']";
	public static final String OCR_SBUConfi_SBU = "//select[@id='resultSbuConf_selSbu']";
	public static final String OCR_SBUConfi_ParameterName = "//input[@name='sbuConf.sbuConfCode']";
	public static final String OCR_SBUConfi_ParameterValue = "//textarea[@name='sbuConf.sbuConfValue']";
	public static final String OCR_SBUConfi_ParameterDescription = "//textarea[@name='sbuConf.sbuConfDesc']";
	public static final String OCR_SBUConfi_SortBy = "//select[@name='sortBy']";
	public static final String OCR_SBUConfi_Direction = "//select[@name='direction']";

	/* ******************************* Constructor ****************************** */

	public SearchSBUConfigurationPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	// Click on Search Button
	public void search() {
		clickElement(driver, test, OCR_SBUConfi_SearchButton, "Clicking on Search Button :");
	}

	// Click on Reset Button
	public void reset() {
		clickElement(driver, test, OCR_SBUConfi_ResetButton, "Clicking on Reset Button :");
	}

	// Selecting Module ID
	public void selectModuleID(String ModuleID) {
		selectByVisibleText(driver, test, OCR_SBUConfi_ModuleID, "Selecting Module ID :", ModuleID);
	}

	// Selecting SBU
	public void selectSBU(String SBU) {
		selectByVisibleText(driver, test, OCR_SBUConfi_SBU, "Selecting SBU Parameter :", SBU);
	}

	// Entering Parameter Name
	public void parameterName(String ParameterName) {
		typeText(driver, test, OCR_SBUConfi_ParameterName, "Entering Parameter Namen :", ParameterName);
	}

	// Entering Parameter Value
	public void parameterValue(String ParameterValue) {
		typeText(driver, test, OCR_SBUConfi_ParameterValue, "Entering Parameter Value :", ParameterValue);
	}

	// Entering Parameter Description
	public void parameterDescription(String ParameterDescription) {
		typeText(driver, test, OCR_SBUConfi_ParameterDescription, "Entering Parameter Description :", ParameterDescription);
	}

	// Select Sort By
	public void sortBy(String SortBy) {
		selectByVisibleText(driver, test, OCR_SBUConfi_SortBy, "Selecting Sort By :", SortBy);
	}

	// Select Direction
	public void direction(String Direction) {
		selectByVisibleText(driver, test, OCR_SBUConfi_Direction, "Selecting Direction :", Direction);
	}

}
