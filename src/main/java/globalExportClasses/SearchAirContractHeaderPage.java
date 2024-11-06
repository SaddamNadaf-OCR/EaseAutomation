package globalExportClasses;

/* 
 * Module : Export Operation
 * Author  : Saddam
 * created date : May 2024
 * Descriptions : Search Air Contract Header Page
 * changed by : Nil
 * changed date : Nil
 * Purpose of change : Nil 
 * Reviewed by : Nil 
 */
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import utilities.GenericMethods;

public class SearchAirContractHeaderPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_AirContractSearchPage_Search = "//button[contains(text(),'Search')]";
	public static final String OCR_AirContractSearchPage_Reset = "//button[contains(text(),'Reset')]";
	public static final String OCR_AirContractSearchPage_AddNewContractHeader = "//button[contains(text(),'Add New Contract Header')]";
	public static final String OCR_AirContractSearchPage_SBUCode = "//select[@id='sbu']";
	public static final String OCR_AirContractSearchPage_ContractCode = "//input[@id='searchContractHeader_contractHeader_contractCode']";
	public static final String OCR_AirContractSearchPage_DepartureCode = "//a[contains(text(),'Departure Code')]";
	public static final String OCR_AirContractSearchPage_AirportName = "//textarea[@id='searchForm_airport_destinationName']";
	public static final String OCR_AirContractSearchPage_SearchPopup = "//button[@name='Search']";
	public static final String OCR_AirContractSearchPage_SelectPopup = "//button[@name='Ok']";
	public static final String OCR_AirContractSearchPage_ClosePopup = "(//button[@class='btn-close'])[1]";
	public static final String OCR_AirContractSearchPage_DepartureCodetextbox = "//input[@id='searchContractHeader_contractHeader_departureCode']";
	public static final String OCR_AirContractSearchPage_DestinationCode = "//a[contains(text(),'Destination Code')]";
	public static final String OCR_AirContractSearchPage_DestinationCodeTextbox = "//input[@id='searchContractHeader_contractHeader_destinationCode']";
	public static final String OCR_AirContractSearchPage_FreightForwarderCode = "//a[contains(text(),'Freight Forwarder Code')]";
	public static final String OCR_AirContractSearchPage_FFCodePopup = "//input[@id='searchForm_freightForwarder_ffCode']";
	public static final String OCR_AirContractSearchPage_FFTextbox = "//input[@id='searchContractHeader_contractHeader_ffCode']";
	public static final String OCR_AirContractSearchPage_CarrierCode = "//a[contains(text(),'Carrier Code')]";
	public static final String OCR_AirContractSearchPage_CarrierCodePopup = "//input[@id='searchForm_carrier_carrierCode']";
	public static final String OCR_AirContractSearchPage_CCTextbox = "//input[@id='searchContractHeader_contractHeader_carrierCode']";
	public static final String OCR_AirContractSearchPage_CreatedBy = "//select[@id='searchContractHeader_contractHeader_createdBy']";
	public static final String OCR_AirContractSearchPage_SortBy = "//select[@name='sortBy']";
	public static final String OCR_AirContractSearchPage_Direction = "//select[@name='direction']";
	public static final String OCR_AirContractSearchPage_Heading = "//h3[contains(text(),'Search Air Contract Header')]";

	/* ******************************* Constructor ****************************** */

	public SearchAirContractHeaderPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	// Click on Search Button
	public void search() {
		clickElement(driver, test, OCR_AirContractSearchPage_Search, "Clicking on Search Button :");
	}

	// Click on Reset Button
	public void reset() {
		clickElement(driver, test, OCR_AirContractSearchPage_Reset, "Clicking on Reset Button :");
	}

	// Click on Add New Contract Header Button
	public void addAirContract() {
		clickElement(driver, test, OCR_AirContractSearchPage_AddNewContractHeader,
				"Clicking on Add New Contract Header Button :");
	}

	// Select SBU Code
	public void selectSBU(String SBUCode) {
		selectByVisibleText(driver, test, OCR_AirContractSearchPage_SBUCode, "Selecting SBU Code :", SBUCode);
	}

	// Select Contract Code
	public void contractCode(String ContractCode) {
		typeText(driver, test, OCR_AirContractSearchPage_ContractCode, "Selecting Contract Code :",ContractCode);
	}

	// Select Departure Code
	public void departureCode(String DepartureCode) {
		if (DepartureCode.length() > 0) {
			clickElement(driver, test, OCR_AirContractSearchPage_DepartureCode, "Clicking on Departure Code :");
			try {
				typeText(driver, test, OCR_AirContractSearchPage_AirportName, "Entering Airport Name :", DepartureCode);
				clickElement(driver, test, OCR_AirContractSearchPage_SearchPopup, "Clicking on Search popup Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'" + DepartureCode + "')]",
						"Selecting Departure Code :");
				clickElement(driver, test, OCR_AirContractSearchPage_SelectPopup, "Clicking on Select Button :");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Enable to Select Departure Code :");
				clickElement(driver, test, OCR_AirContractSearchPage_ClosePopup, "Clicking on Close Popup :");
			}
		}
	}

	// Select Destination Code
	public void destinationCode(String DestinationCode) {
		if (DestinationCode.length() > 0) {
			clickElement(driver, test, OCR_AirContractSearchPage_DestinationCode, "Clicking on Destination Code :");
			try {
				typeText(driver, test, OCR_AirContractSearchPage_AirportName, "Entering Airport Name :",
						DestinationCode);
				clickElement(driver, test, OCR_AirContractSearchPage_SearchPopup, "Clicking on Search popup Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'" + DestinationCode + "')]",
						"Selecting Destination Code :");
				clickElement(driver, test, OCR_AirContractSearchPage_SelectPopup, "Clicking on Select Button :");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Enable to Select Destination Code :");
				clickElement(driver, test, OCR_AirContractSearchPage_ClosePopup, "Clicking on Close Popup :");
			}
		}
	}

	// Select Freight Forwarder Name
	public void freightForwarder(String FreightForwarder) {
		if (FreightForwarder.length() > 0) {
			clickElement(driver, test, OCR_AirContractSearchPage_FreightForwarderCode,
					"Clicking on Freight Forwarder Code :");
			try {
				typeText(driver, test, OCR_AirContractSearchPage_FFCodePopup, "Entering Freight Forwarder Name :",
						FreightForwarder);
				clickElement(driver, test, OCR_AirContractSearchPage_SearchPopup, "Clicking on Search popup Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'" + FreightForwarder + "')]",
						"Selecting Freight Forwarder Code :");
				clickElement(driver, test, OCR_AirContractSearchPage_SelectPopup, "Clicking on Select Button :");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Enable to Select Freight Forwarder Code :");
				clickElement(driver, test, OCR_AirContractSearchPage_ClosePopup, "Clicking on Close Popup :");
			}
		}
	}

	// Select Carrier Code
	public void carrierCode(String CarrierCode) {
		if (CarrierCode.length() > 0) {
			clickElement(driver, test, OCR_AirContractSearchPage_CarrierCode,
					"Clicking on Carrier Code :");
			try {
				typeText(driver, test, OCR_AirContractSearchPage_CarrierCodePopup, "Entering Carrier Code Name :",
						CarrierCode);
				clickElement(driver, test, OCR_AirContractSearchPage_SearchPopup, "Clicking on Search popup Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'" + CarrierCode + "')]",
						"Selecting Carrier Code :");
				clickElement(driver, test, OCR_AirContractSearchPage_SelectPopup, "Clicking on Select Button :");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Enable to Select Carrier Code :");
				clickElement(driver, test, OCR_AirContractSearchPage_ClosePopup, "Clicking on Close Popup :");
			}
		}
	}
	
	//Select Created By
	public void createdBy(String CreatedBy) {
		selectByVisibleText(driver, test, OCR_AirContractSearchPage_CreatedBy, "Selecting Created by :", CreatedBy);
	}

	// Select Sort By Code
	public void sortBy(String SortBy) {
		selectByVisibleText(driver, test, OCR_AirContractSearchPage_SortBy, "Selecting Sort By :", SortBy);
	}

	// Select SBU Code
	public void direction(String Direction) {
		selectByVisibleText(driver, test, OCR_AirContractSearchPage_Direction, "Selecting Direction :", Direction);
	}

	// Search By Parameters
	public void searchbyParameters(String SBUCode, String ContractCode, String DepartureCode, String DestinationCode, 
			String FreightForwarder, String CarrierCode, String CreatedBy, String SortBy, String Direction) {
		if(SBUCode.length() > 0) {
			selectByVisibleText(driver, test, OCR_AirContractSearchPage_SBUCode, "Selecting SBU Code :", SBUCode);
		}
		if(ContractCode.length() > 0) {
			typeText(driver, test, OCR_AirContractSearchPage_ContractCode, "Selecting Contract Code :",ContractCode);
		}
		if (DepartureCode.length() > 0) {
			clickElement(driver, test, OCR_AirContractSearchPage_DepartureCode, "Clicking on Departure Code :");
			try {
				typeText(driver, test, OCR_AirContractSearchPage_AirportName, "Entering Airport Name :", DepartureCode);
				clickElement(driver, test, OCR_AirContractSearchPage_SearchPopup, "Clicking on Search popup Button :");
				clickElement(driver, test, "//td[contains(text(),'" + DepartureCode + "')]","Selecting Departure Code :");
				clickElement(driver, test, OCR_AirContractSearchPage_SelectPopup, "Clicking on Select Button :");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Enable to Select Departure Code :");
				clickElement(driver, test, OCR_AirContractSearchPage_ClosePopup, "Clicking on Close Popup :");
			}
		}
		if (DestinationCode.length() > 0) {
			clickElement(driver, test, OCR_AirContractSearchPage_DestinationCode, "Clicking on Destination Code :");
			try {
				typeText(driver, test, OCR_AirContractSearchPage_AirportName, "Entering Airport Name :",DestinationCode);
				clickElement(driver, test, OCR_AirContractSearchPage_SearchPopup, "Clicking on Search popup Button :");
				clickElement(driver, test, "//td[contains(text(),'" + DestinationCode + "')]","Selecting Destination Code :");
				clickElement(driver, test, OCR_AirContractSearchPage_SelectPopup, "Clicking on Select Button :");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Enable to Select Destination Code :");
				clickElement(driver, test, OCR_AirContractSearchPage_ClosePopup, "Clicking on Close Popup :");
			}
		}
		if (FreightForwarder.length() > 0) {
			clickElement(driver, test, OCR_AirContractSearchPage_FreightForwarderCode,
					"Clicking on Freight Forwarder Code :");
			try {
				typeText(driver, test, OCR_AirContractSearchPage_FFCodePopup, "Entering Freight Forwarder Name :",FreightForwarder);
				clickElement(driver, test, OCR_AirContractSearchPage_SearchPopup, "Clicking on Search popup Button :");
				clickElement(driver, test, "//td[contains(text(),'" + FreightForwarder + "')]","Selecting Freight Forwarder Code :");
				clickElement(driver, test, OCR_AirContractSearchPage_SelectPopup, "Clicking on Select Button :");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Enable to Select Freight Forwarder Code :");
				clickElement(driver, test, OCR_AirContractSearchPage_ClosePopup, "Clicking on Close Popup :");
			}
		}
		if (CarrierCode.length() > 0) {
			clickElement(driver, test, OCR_AirContractSearchPage_CarrierCode,
					"Clicking on Carrier Code :");
			try {
				typeText(driver, test, OCR_AirContractSearchPage_CarrierCodePopup, "Entering Carrier Code Name :",
						CarrierCode);
				clickElement(driver, test, OCR_AirContractSearchPage_SearchPopup, "Clicking on Search popup Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'" + CarrierCode + "')]",
						"Selecting Carrier Code :");
				clickElement(driver, test, OCR_AirContractSearchPage_SelectPopup, "Clicking on Select Button :");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Enable to Select Carrier Code :");
				clickElement(driver, test, OCR_AirContractSearchPage_ClosePopup, "Clicking on Close Popup :");
			}
		}
		if(CreatedBy.length() > 0) {
			selectByVisibleText(driver, test, OCR_AirContractSearchPage_CreatedBy, "Selecting Created by :", CreatedBy);
		}
		if(SortBy.length() > 0) {
			selectByVisibleText(driver, test, OCR_AirContractSearchPage_SortBy, "Selecting Sort By :", SortBy);
		}
		if(Direction.length() > 0) {
			selectByVisibleText(driver, test, OCR_AirContractSearchPage_Direction, "Selecting Direction :", Direction);
		}
	}
}
