package importOperationClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class EntrySummaryPartyDetails extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_PartyDetails_PartyType = "//select[@id='partyTypeSelect']";
	public static final String OCR_PartyDetails_SourceFile = "//select[@id='soldToPartySource']";
	public static final String OCR_PartyDetails_PartyCodePopup = "//a[@id='partyPopup']";
	public static final String OCR_PartyDetails_BrokerName = "//input[@id='searchForm_broker_brokerName']";
	public static final String OCR_PartyDetails_IDType = "//select[@id='govtTypeSelect']";
	public static final String OCR_PartyDetails_PartytName = "//input[@id='editEntry7501Parties_import7501PartiesValue_partyName']";
	public static final String OCR_PartyDetails_Address1 = "//input[@id='editEntry7501Parties_import7501PartiesValue_partyAddr1']";
	public static final String OCR_PartyDetails_Address2 = "//input[@id='editEntry7501Parties_import7501PartiesValue_partyAddr2']";
	public static final String OCR_PartyDetails_ContactName = "//input[@id='editEntry7501Parties_import7501PartiesValue_importerContactName']";
	public static final String OCR_PartyDetails_ContactPhone = "//input[@id='editEntry7501Parties_import7501PartiesValue_importerContactPhone']";
	public static final String OCR_PartyDetails_City = "//input[@id='editEntry7501Parties_import7501PartiesValue_partyCity']";
	public static final String OCR_PartyDetails_ContactEmail = "//input[@id='editEntry7501Parties_import7501PartiesValue_importercontactEmail']";
	public static final String OCR_PartyDetails_State = "//input[@id='editEntry7501Parties_import7501PartiesValue_partyStateName']";
	public static final String OCR_PartyDetails_Country = "//input[@id='editEntry7501Parties_import7501PartiesValue_partyCountryName']";
	public static final String OCR_PartyDetails_ZipCode = "//input[@id='editEntry7501Parties_import7501PartiesValue_partyZip']";
	public static final String OCR_PartyDetails_CustomsMID = "//input[@id='editEntry7501Parties_import7501PartiesValue_customsId']";
	public static final String OCR_PartyDetails_Search = "//button[@name='Search']";
	public static final String OCR_PartyDetails_Save = "//button[@name='save']";
	public static final String OCR_PartyDetails_Select = "(//button[contains(text(),'Select')])[1]";
	public static final String OCR_POPupClose = "(//button[contains(text(),'Cancel')])[2]";
	public static final String OCR_PartyDetails_SaveAndReturn = "//button[contains(text(),'Save and Return')]";
	public static final String OCR_EntrySummaryDetails_CloseAlert = "(//button[@class='btn-close'])[1]";

	/* ******************** Constructor ***************************** */
	public EntrySummaryPartyDetails(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

	}

	/* ******************** Actions ********************************* */

	// add Party details
	// && SourceFile.equalsIgnoreCase("importer")
	public void addPartyDetails(String PartyType, String SourceFile, String PartyCode, String PartyIdType,
			String PartyName, String PartyAddress1, String PartyAddress2, String PartyContactName,
			String PartyContactPhone, String PartyCity, String PartyContactEmail, String PartyState,
			String PartyCountry, String PartyZipCode, String PartyCustomsMID) {

		selectByVisibleText(driver, test, OCR_PartyDetails_PartyType, "Select Party Type : ", PartyType);
		if (!PartyType.equalsIgnoreCase("importer")) {
			if (SourceFile.equalsIgnoreCase("Vendor"))
				selectByVisibleText(driver, test, "//select[@id='supplierManufacturerSource']",
						"Select Source File Supplier/Manufacturer : ", SourceFile);
			if (PartyType.equalsIgnoreCase("Sold to Party") && SourceFile.equalsIgnoreCase("importer"))
				selectByVisibleText(driver, test, "//select[@id='soldToPartySource']",
						"Select Source File Sold To Party : ", SourceFile);
			if (PartyType.equalsIgnoreCase("Consignee") && SourceFile.equalsIgnoreCase("importer"))
				selectByVisibleText(driver, test, "//select[@id='consigneeSource']", "Select Source Consignee : ",
						SourceFile);
		}
		if (PartyCode.length() > 0) {
			clickElement(driver, test, OCR_PartyDetails_PartyCodePopup, "Click on Party Code Popup");
			try {
				if (PartyType.equalsIgnoreCase("importer")) {
					typeText(driver, test, "//input[@id='searchForm_importer_importerCode']", "Add Importer Code : ",
							PartyCode);
				}
				if (PartyType.equalsIgnoreCase("Supplier/Manufacturer") && SourceFile.equalsIgnoreCase("Vendor")) {
					typeText(driver, test, "//input[@id='searchForm_vendor_vendorCode']", "Add Vendor Code : ",
							PartyCode);
				}
				if (PartyType.equalsIgnoreCase("Sold to Party") && SourceFile.equalsIgnoreCase("importer")) {
					typeText(driver, test, "//input[@id='searchForm_importer_importerCode']", "Add Importer Code : ",
							PartyCode);
				}
				if (PartyType.equalsIgnoreCase("Consignee") && SourceFile.equalsIgnoreCase("importer")) {
					typeText(driver, test, "//input[@id='searchForm_importer_importerCode']", "Add Importer Code : ",
							PartyCode);
				}
				Wait.waitfor(3);
				clickElement(driver, test, OCR_PartyDetails_Search, "Click On Search");
				Wait.waitfor(3);
				String brokerName = "//td[contains(text(),'" + PartyCode + "')]";
				clickElement(driver, test, brokerName, "Select Carrier: " + PartyCode);
				Wait.waitfor(3);
				clickElement(driver, test, OCR_PartyDetails_Select, "Click on select");
				Wait.waitfor(3);
			} catch (Exception e) {
				e.printStackTrace();
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to add Part code");
				clickElement(driver, test, OCR_POPupClose, "Click on Close");
			}
		}

		selectByVisibleText(driver, test, OCR_PartyDetails_IDType, "Select Id Type : ", PartyIdType);
		Wait.waitfor(3);
		typeText(driver, test, OCR_PartyDetails_PartytName, "Enter Party Name : ", PartyName);
		typeText(driver, test, OCR_PartyDetails_Address1, "Enter Address1 : ", PartyAddress1);
		typeText(driver, test, OCR_PartyDetails_Address2, "Enter Address2 : ", PartyAddress2);
		typeText(driver, test, OCR_PartyDetails_ContactName, "Enter Contact Name : ", PartyContactName);
		typeText(driver, test, OCR_PartyDetails_ContactPhone, "Enter Contact Phone : ", PartyContactPhone);
		typeText(driver, test, OCR_PartyDetails_City, "Enter City : ", PartyCity);
		typeText(driver, test, OCR_PartyDetails_ContactEmail, "Enter Contact Email : ", PartyContactEmail);

		String state = "//div[contains(text(),'" + PartyState + "')]";
		typeText(driver, test, OCR_PartyDetails_State, "Enter State : ", PartyState);
		Wait.waitfor(2);
		clickElement(driver, test, state, "Click State :" + PartyState);

		String country = "//div[contains(text(),'" + PartyCountry + "')]";
		typeText(driver, test, OCR_PartyDetails_Country, "Enter Country : ", PartyCountry);
		Wait.waitfor(2);
		clickElement(driver, test, country, "Click Country :" + PartyCountry);

		typeText(driver, test, OCR_PartyDetails_ZipCode, "Enter ZipCode : ", PartyZipCode);
		typeText(driver, test, OCR_PartyDetails_CustomsMID, "Enter CustomsMID : ", PartyCustomsMID);
	}

	// Click on Party Details Save button
	public void savePartyDetails() throws InterruptedException {
		clickElement(driver, test, OCR_PartyDetails_Save, "Click on Party Details Save");
	}

	// Click on Party Details Save and Return button
	public void saveAndReturnPartyDetails() throws InterruptedException {
		clickElement(driver, test, OCR_PartyDetails_SaveAndReturn, "Click on Party Details Save and Return");
	}

	// Click on Alert Popup Close
	public void alertClose() {
		Wait.waitfor(5);
		clickElement(driver, test, OCR_EntrySummaryDetails_CloseAlert, "Click Alert Popup Close");
	}

	// Validation for Supplier Party and at-least one line item
	public void validationSupplierParty() {
		try {
			if (isDisplayed(driver,
					"//table[@class='table table-condensed table-bordered']//td[contains(text(),'Supplier party details is required')]")) {
				test.log(LogStatus.INFO, "Supplier party details is required");
			}
			if (isDisplayed(driver,
					"//table[@class='table table-condensed table-bordered']//td[contains(text(),'There must be at-least one line item present')]")) {
				test.log(LogStatus.INFO, "There must be at-least one line item present");
			}	
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL,
					"Error is not Displayed by clicking on Alert Icon  for Supplier Party and at-least one line item in  Entry Summary");
			alertClose();
		}
	}

	// Validation for Party detail
	public void validationPartyDetails() {
		try {
			if (isDisplayed(driver, "//td[contains(text(),'Importer Of Record Number is required with Party I')]")) {
				test.log(LogStatus.INFO, "Importer Of Record Number is required with Party Identifier ");
			}
			if (isDisplayed(driver, "//td[contains(text(),'Party Type Consignee is Required with Party Identf')]")) {
				test.log(LogStatus.INFO, "Party Type Consignee is Required with Party Identfier ");
			}
			if (isDisplayed(driver, "//td[contains(text(),'Port Of Entry Code is missing in Block Control Header Record B')]")) {
				test.log(LogStatus.INFO, "Port Of Entry Code is missing in Block Control Header Record B')]");
			}
			if (isDisplayed(driver, "//td[contains(text(),'There must be at-least one Bill of Lading record p')]")) {
				test.log(LogStatus.INFO, "There must be at-least one Bill of Lading record present");
			}
			if (isDisplayed(driver, "//td[contains(text(),'Bond Type is required')]")) {
				test.log(LogStatus.INFO, "Bond Type is required");
			}
			if (isDisplayed(driver, "//td[contains(text(),'Date of Export Missing for Item No. 1')]")) {
				test.log(LogStatus.INFO, "Date of Export Missing for Item No. 1");
			}
			if (isDisplayed(driver, "//td[contains(text(),'Exporting Country is required for Item No. 1')]")) {
				test.log(LogStatus.INFO, "Exporting Country is required for Item No. 1");
			}
			if (isDisplayed(driver, "//td[contains(text(),'Supplier Manuf.ID is Required For item No: 1')]")) {
				test.log(LogStatus.INFO, "Supplier Manuf.ID is Required For item No: 1");
			}
			if (isDisplayed(driver, "//td[contains(text(),'Sold To Party is  Missing for Item No: 1  ')]")) {
				test.log(LogStatus.INFO, "Sold To Party is  Missing for Item No: 1 ");
			}
			
			
			if (isDisplayed(driver, "//td[contains(text(),'Port Of Entry and Port of Unlading is Required')]")) {
				test.log(LogStatus.INFO, "Port Of Entry and Port of Unlading is Required");
			}
			if (isDisplayed(driver, "//td[contains(text(),'Mode of Transport is required for entry type: 01')]")) {
				test.log(LogStatus.INFO, "Mode of Transport is required for entry type: 01");
			}
			if (isDisplayed(driver, "//td[contains(text(),'Payment Type is required.')]")) {
				test.log(LogStatus.INFO, "Payment Type is required.");
			}
			if (isDisplayed(driver, "//td[contains(text(),'Voyage/Flight/Trip No. is Required')]")) {
				test.log(LogStatus.INFO, "Voyage/Flight/Trip No. is Required");
			}
			
			
			
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL,
					"Error is not Displayed by clicking on Alert Icon for Party detail in  Entry Summary");
			alertClose();
		}
	}

}