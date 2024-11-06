package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;

public class ReportShipmentAgainstLicPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_SEARCH = "(//button[contains(text(),'Search')])";
	public static final String OCR_RESET = "(//button[@type='reset'])";
	public static final String OCR_Country = "//select[@name='encryptedCountryCode']";
	public static final String OCR_SBUCODE = "//select[@name='shipment.sbuCode']";
	public static final String OCR_AuthorizationNo = "//a[contains(text(),'Authorization No')]";
	public static final String OCR_AuthorizationNoPopup = "//input[@name='licenseHeaderDTO.licenseNo']";
	public static final String OCR_SearchPopup = "(//button[@name='Search'])[2]";
	public static final String OCR_SelectPopup = "(//button[@name='Ok'])";
	public static final String OCR_ClosePopup = "(//button[@class='btn-close'])[2]";
	public static final String OCR_AuthorizationNoTextBox = "//input[@name='licenseNo']";
	public static final String OCR_LicenseType = "//a[contains(text(),'License Type')]";
	public static final String OCR_AuthorizationType = "//textarea[@id='licTypePopupForm_licenseTypes_licenseType']";
	public static final String OCR_LicenseTypeTextBox = "//textarea[@id='searchProductManufacturerReport_licenseType']";
	public static final String OCR_fromDateOfExport = "//input[@name='fromDateOfExport']";
	public static final String OCR_toDateOfExport = "//input[@name='toDateOfExport']";
	public static final String OCR_Today ="//button[contains(text(),'Today')]";
	public static final String OCR_UltimateConsignee = "//a[contains(text(),'Ultimate Consignee')]";
	public static final String OCR_consigneeId = "//input[@name='consignee.consigneeId']";
	public static final String OCR_ultConsName = "//input[@name='shipment.ultConsName']";
	public static final String OCR_UltDestination = "//input[@name='shipment.countryOfUltDest']";

	// * ************************** Constructor ******************************//

	public ReportShipmentAgainstLicPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	/* ******************************* Action ****************************** */

	// clicking on Search
	public void search() {
		clickElement(driver, test, OCR_SEARCH, "Click on Search :");
	}

	// Click on Reset
	public void reset() {
		clickElement(driver, test, OCR_RESET, "Click on Reset :");
	}

	// Search by parameter
	public void parameter(String Country, String Sbu, String AuthorizationNo, String LicenseType, String DateOfExportFrom, 
			String DateOfExportTo, String UltimateConsignee, String UltDestination) {
		if(Country.length() > 0) {
			selectByVisibleText(driver, test, OCR_Country, "Selecting Country :", Country);
		}
		if(Sbu.length() > 0) {
			selectByVisibleText(driver, test, OCR_SBUCODE, "Select SBUCode", Sbu);
		}
		if(AuthorizationNo.length() > 0) {
			clickElement(driver, test, OCR_AuthorizationNo, "Clicking on Authorization No :");
			try {
				typeText(driver, test, OCR_AuthorizationNoPopup, "Enterong Authorization No :", AuthorizationNo);
				clickElement(driver, test, OCR_SearchPopup, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+AuthorizationNo+"')]", "Selecting Authorization No :");
				clickElement(driver, test, OCR_SelectPopup, "Clicking on Select Popup Button :");
			}catch(Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Enable to Select Authorization No :");
				clickElement(driver, test, OCR_ClosePopup, "Clicking on Close Popup :");
			}
		}else {
			typeText(driver, test, OCR_AuthorizationNo, "Enter AuthNo", AuthorizationNo);
		}
		if(LicenseType.length() > 0) {
			clickElement(driver, test, OCR_LicenseType, "Clicking on License Type :");
			try {
				typeText(driver, test, OCR_AuthorizationType, "Enterong License Type :", LicenseType);
				clickElement(driver, test, OCR_SearchPopup, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+LicenseType+"')]", "Selecting License Type :");
				clickElement(driver, test, OCR_SelectPopup, "Clicking on Select Popup Button :");
			}catch(Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Enable to Select License Type :");
				clickElement(driver, test, OCR_ClosePopup, "Clicking on Close Popup :");
			}
		}else {
			typeText(driver, test, OCR_LicenseType, "Enter LIC TYPE", LicenseType);
		}
		if(DateOfExportFrom.length() > 0) {
			clickElement(driver, test, OCR_fromDateOfExport, "Clicking on From Date Of Export :");
			try {
				if(DateOfExportFrom.equalsIgnoreCase("Today")) {
					clickElement(driver, test, OCR_Today, "Clicking on Today :");
				}else {
					date(driver, test, "Selecting Date Of Export From :", DateOfExportFrom);
					
				}
			}catch(Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Enable to Select the Date Of Export From :");
			}
		}
		if(DateOfExportTo.length() > 0) {
			clickElement(driver, test, OCR_toDateOfExport, "Clicking on To Date Of Export :");
			try {
				if(DateOfExportTo.equalsIgnoreCase("Today")) {
					clickElement(driver, test, OCR_Today, "Clicking on Today :");
				}else {
					date(driver, test, "Selecting Date Of Export To :", DateOfExportTo);
				}
			}catch(Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Enable to Select the Date Of Export To :");
			}
		}
		if(UltimateConsignee.length() > 0) {
			clickElement(driver, test, OCR_UltimateConsignee, "Clicking on Ultimate Consignee :");
			try {
				typeText(driver, test, OCR_consigneeId, "Enterong Ultimate Consignee :", UltimateConsignee);
				clickElement(driver, test, OCR_SearchPopup, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+UltimateConsignee+"')]", "Selecting Ultimate Consignee :");
				clickElement(driver, test, OCR_SelectPopup, "Clicking on Select Popup Button :");
			}catch(Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Enable to Select Ultimate Consignee :");
				clickElement(driver, test, OCR_ClosePopup, "Clicking on Close Popup :");
			}
		}else {
			typeText(driver, test, OCR_ultConsName, "Enter Ultimate Consignee", UltimateConsignee);
		}
		if(UltDestination.length() > 0) {
			typeText(driver, test, OCR_UltDestination, "Ult Destination", UltDestination);
		}
		scrollToElement(driver, OCR_SEARCH);
	}
}
