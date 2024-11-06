package globalExportClasses;
/* 
 * Module : Export Operation
 * Author  : Saddam
 * created date : May 2024
 * Descriptions : Search Ocean Contract Page
 * changed by : Nil
 * changed date : Nil
 * Purpose of change : Nil 
 * Reviewed by : Nil 
 */
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;

public class SearchOceanContractPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_OceanContractSearchPage_Search = "//button[contains(text(),'Search')]";
	public static final String OCR_OceanContractSearchPage_Reset = "//button[contains(text(),'Reset')]";
	public static final String OCR_OceanContractSearchPage_AddNewContract = "//button[contains(text(),'Add New Contract')]";
	public static final String OCR_OceanContractSearchPage_SBUCode = "//select[@id='searchOceanContract_oceanContract_sbuCode']";
	public static final String OCR_OceanContractSearchPage_ContractCode = "//input[@id='searchOceanContract_oceanContract_oceanContractCode']";
	public static final String OCR_OceanContractSearchPage_CarrierCode = "//input[@id='searchOceanContract_oceanContract_carrierCode']";
	public static final String OCR_OceanContractSearchPage_PortOfExportCode = "//input[@id='searchOceanContract_oceanContract_portOfExportCode']";
	public static final String OCR_OceanContractSearchPage_PortOfUnloadingCode = "//input[@id='searchOceanContract_oceanContract_portOfUnloadingCode']";
	public static final String OCR_OceanContractSearchPage_CreatedBy = "//select[@id='searchOceanContract_oceanContract_createdBy']";
	public static final String OCR_OceanContractSearchPage_SortBy = "//select[@name='sortBy']";
	public static final String OCR_OceanContractSearchPage_Direction = "//select[@name='direction']";
	public static final String OCR_OceanContractSearchPage_Heading = "//h3[contains(text(),'Search Ocean Contract')]";

	/* ******************************* Constructor ****************************** */

	public SearchOceanContractPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	// Click on Search Button
	public void search() {
		clickElement(driver, test, OCR_OceanContractSearchPage_Search, "Clicking on Search Button :");
	}

	// Click on Reset Button
	public void reset() {
		clickElement(driver, test, OCR_OceanContractSearchPage_Reset, "Clicking on Reset Button :");
	}

	// Click on Add New Contract Button
	public void addOceanContract() {
		clickElement(driver, test, OCR_OceanContractSearchPage_AddNewContract,"Clicking on Add New Contract Button :");
	}

	// Select SBU Code
	public void selectSBU(String SBUCode) {
		selectByVisibleText(driver, test, OCR_OceanContractSearchPage_SBUCode, "Selecting SBU Code :", SBUCode);
	}

	// Enter Contract Code
	public void contractCode(String ContractCode) {
		typeText(driver, test, OCR_OceanContractSearchPage_ContractCode, "Selecting Contract Code :", ContractCode);
	}

	// Enter CarrierCode Code
	public void carrierCodeCode(String CarrierCode) {
		typeText(driver, test, OCR_OceanContractSearchPage_CarrierCode, "Entering Carrier Code :", CarrierCode);
	}

	// Enter Port Of Export Code
	public void portOfExportCode(String PortOfExportCode) {
		typeText(driver, test, OCR_OceanContractSearchPage_PortOfExportCode, "Entering Port Of Export Code :",PortOfExportCode);
	}

	// Select Carrier Code
	public void portOfUnloadingCode(String PortOfUnloadingCode) {
		typeText(driver, test, OCR_OceanContractSearchPage_PortOfUnloadingCode, "Entering Port Of Unloading Code :", PortOfUnloadingCode);
	}

	// Select Created By
	public void createdBy(String CreatedBy) {
		selectByVisibleText(driver, test, OCR_OceanContractSearchPage_CreatedBy, "Selecting Created by :", CreatedBy);
	}

	// Select Sort By Code
	public void sortBy(String SortBy) {
		selectByVisibleText(driver, test, OCR_OceanContractSearchPage_SortBy, "Selecting Sort By :", SortBy);
	}

	// Select Direction Code
	public void direction(String Direction) {
		selectByVisibleText(driver, test, OCR_OceanContractSearchPage_Direction, "Selecting Direction :", Direction);
	}

	// Search By Parameters
	public void searchbyParameters(String SBUCode, String ContractCode, String CarrierCode, String PortOfExportCode,
			String PortOfUnloadingCode, String CreatedBy, String SortBy, String Direction) {

		if (SBUCode.length() > 0) {
			selectByVisibleText(driver, test, OCR_OceanContractSearchPage_SBUCode, "Selecting SBU Code :", SBUCode);
		}
		if (ContractCode.length() > 0) {
			typeText(driver, test, OCR_OceanContractSearchPage_ContractCode, "Selecting Contract Code :",
					ContractCode);
		}
		if (CarrierCode.length() > 0) {
			typeText(driver, test, OCR_OceanContractSearchPage_CarrierCode, "Entering Carrier Code :", CarrierCode);
		}
		if (PortOfExportCode.length() > 0) {
			typeText(driver, test, OCR_OceanContractSearchPage_PortOfExportCode, "Entering Port Of Export Code :",PortOfExportCode);
		}
		if (PortOfUnloadingCode.length() > 0) {
			typeText(driver, test, OCR_OceanContractSearchPage_PortOfUnloadingCode, "Entering Port Of Unloading Code :", PortOfUnloadingCode);
		}
		if (CreatedBy.length() > 0) {
			selectByVisibleText(driver, test, OCR_OceanContractSearchPage_CreatedBy, "Selecting Created by :",
					CreatedBy);
		}
		if (SortBy.length() > 0) {
			selectByVisibleText(driver, test, OCR_OceanContractSearchPage_SortBy, "Selecting Sort By :", SortBy);
		}
		if (Direction.length() > 0) {
			selectByVisibleText(driver, test, OCR_OceanContractSearchPage_Direction, "Selecting Direction :",
					Direction);
		}
	}
}
