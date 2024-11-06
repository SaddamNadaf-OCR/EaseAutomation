package globalExportClasses;

/* 
 * Module : Export Operation
 * Author  : Saddam
 * created date : May 2024
 * Descriptions : Search Ground Contract Header Page
 * changed by : Nil
 * changed date : Nil
 * Purpose of change : Nil 
 * Reviewed by : Nil 
 */
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;

public class SearchGroundContractHeaderPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_GroundContractSearchPage_Search = "//button[contains(text(),'Search')]";
	public static final String OCR_GroundContractSearchPage_Reset = "//button[contains(text(),'Reset')]";
	public static final String OCR_GroundContractSearchPage_AddNewContractHeader = "//button[contains(text(),'Add New Contract Header')]";
	public static final String OCR_GroundContractSearchPage_SBUCode = "//select[@id='searchGroundContractHeader_groundContractHeader_sbuCode']";
	public static final String OCR_GroundContractSearchPage_ContractCode = "//input[@id='searchGroundContractHeader_groundContractHeader_contractCode']";
	public static final String OCR_GroundContractSearchPage_DepartureCode = "//input[@id='searchGroundContractHeader_groundContractHeader_departureCode']";
	public static final String OCR_GroundContractSearchPage_FreightForwarderCode = "//input[@id='searchGroundContractHeader_groundContractHeader_ffCode']";
	public static final String OCR_GroundContractSearchPage_CarrierCode = "//input[@id='searchGroundContractHeader_groundContractHeader_grCarrierCode']";
	public static final String OCR_GroundContractSearchPage_CreatedBy = "//select[@id='searchGroundContractHeader_groundContractHeader_createdBy']";
	public static final String OCR_GroundContractSearchPage_SortBy = "//select[@name='sortBy']";
	public static final String OCR_GroundContractSearchPage_Direction = "//select[@name='direction']";
	public static final String OCR_GroundContractSearchPage_Heading = "//h3[contains(text(),'Search Ground Contract Header')]";

	/* ******************************* Constructor ****************************** */

	public SearchGroundContractHeaderPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	// Click on Search Button
	public void search() {
		clickElement(driver, test, OCR_GroundContractSearchPage_Search, "Clicking on Search Button :");
	}

	// Click on Reset Button
	public void reset() {
		clickElement(driver, test, OCR_GroundContractSearchPage_Reset, "Clicking on Reset Button :");
	}

	// Click on Add New Contract Header Button
	public void addGroundContract() {
		clickElement(driver, test, OCR_GroundContractSearchPage_AddNewContractHeader,
				"Clicking on Add New Contract Header Button :");
	}

	// Select SBU Code
	public void selectSBU(String SBUCode) {
		selectByVisibleText(driver, test, OCR_GroundContractSearchPage_SBUCode, "Selecting SBU Code :", SBUCode);
	}

	// Enter Contract Code
	public void contractCode(String ContractCode) {
		typeText(driver, test, OCR_GroundContractSearchPage_ContractCode, "Selecting Contract Code :", ContractCode);
	}

	// Enter Departure Code
	public void departureCode(String DepartureCode) {
		typeText(driver, test, OCR_GroundContractSearchPage_DepartureCode, "Entering Departure Code :", DepartureCode);
	}

	// Enter Freight Forwarder Name
	public void freightForwarder(String FreightForwarder) {
		typeText(driver, test, OCR_GroundContractSearchPage_FreightForwarderCode, "Entering Freight Forwarder Name :",
				FreightForwarder);
	}

	// Select Carrier Code
	public void carrierCode(String CarrierCode) {
		typeText(driver, test, OCR_GroundContractSearchPage_CarrierCode, "Entering Carrier Code Name :", CarrierCode);
	}

	// Select Created By
	public void createdBy(String CreatedBy) {
		selectByVisibleText(driver, test, OCR_GroundContractSearchPage_CreatedBy, "Selecting Created by :", CreatedBy);
	}

	// Select Sort By Code
	public void sortBy(String SortBy) {
		selectByVisibleText(driver, test, OCR_GroundContractSearchPage_SortBy, "Selecting Sort By :", SortBy);
	}

	// Select SBU Code
	public void direction(String Direction) {
		selectByVisibleText(driver, test, OCR_GroundContractSearchPage_Direction, "Selecting Direction :", Direction);
	}

	// Search By Parameters
	public void searchbyParameters(String SBUCode, String ContractCode, String DepartureCode, String FreightForwarder,
			String CarrierCode, String CreatedBy, String SortBy, String Direction) {

		if (SBUCode.length() > 0) {
			selectByVisibleText(driver, test, OCR_GroundContractSearchPage_SBUCode, "Selecting SBU Code :", SBUCode);
		}
		if (ContractCode.length() > 0) {
			typeText(driver, test, OCR_GroundContractSearchPage_ContractCode, "Selecting Contract Code :",
					ContractCode);
		}
		if (DepartureCode.length() > 0) {
			typeText(driver, test, OCR_GroundContractSearchPage_DepartureCode, "Entering Airport Name :",
					DepartureCode);
		}
		if (FreightForwarder.length() > 0) {
			typeText(driver, test, OCR_GroundContractSearchPage_FreightForwarderCode,
					"Entering Freight Forwarder Name :", FreightForwarder);
		}
		if (CarrierCode.length() > 0) {
			typeText(driver, test, OCR_GroundContractSearchPage_CarrierCode, "Entering Carrier Code Name :",
					CarrierCode);
		}
		if (CreatedBy.length() > 0) {
			selectByVisibleText(driver, test, OCR_GroundContractSearchPage_CreatedBy, "Selecting Created by :",
					CreatedBy);
		}
		if (SortBy.length() > 0) {
			selectByVisibleText(driver, test, OCR_GroundContractSearchPage_SortBy, "Selecting Sort By :", SortBy);
		}
		if (Direction.length() > 0) {
			selectByVisibleText(driver, test, OCR_GroundContractSearchPage_Direction, "Selecting Direction :",
					Direction);
		}
	}
}
