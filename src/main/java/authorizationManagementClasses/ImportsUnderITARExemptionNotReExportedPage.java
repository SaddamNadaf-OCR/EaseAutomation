package authorizationManagementClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class ImportsUnderITARExemptionNotReExportedPage extends GenericMethods{
	
	public static WebDriver driver;
	public static ExtentTest test;
	
	//..................................Locators........................................//
	public static final String AuthMana_Report_Search="//input[@name='Search']";
	public static final String AuthMana_Report_Reset="//input[@value='Reset']";
	public static final String AuthMana_Report_importShipmentNo = "//input[@name='itarImportExport.importShipmentNo']";
	public static final String AuthMana_Report_importDateFrom ="//input[@name='importFromDate']";
	public static final String AuthMana_Report_importDateTo ="//input[@name='importToDate']";
	public static final String AuthMana_Report_shipperName ="//input[@name='itarImportExport.shipperName']";
	public static final String AuthMana_Report_shipperCountryCode ="//input[@name='itarImportExport.shipperCountryCode']";
	public static final String AuthMana_Report_importLicense ="//input[@name='itarImportExport.importLicense']";
	public static final String AuthMana_Report_importItarExemptionNo="//input[@name='itarImportExport.importItarExemptionNo']";
	
	
	//..................................Constructors..................................//
	public ImportsUnderITARExemptionNotReExportedPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	//................................Click on Search Tab ...............................//
	public void search() {
		clickElement(driver, test, AuthMana_Report_Search, "Clicking on Search Tab");
	}
	
	//................................Click on Reset Tab ...............................//
	public void reset() {
		clickElement(driver, test, AuthMana_Report_Reset, "Clicking on Reset Tab");
	}
	
	//............................Search By Parameters.................................//
	public void searchByParameters(String importShipmentNo, String ImportDateFrom, String ImportDateTo, String shipperName, 
			String shipperCountryCode, String importLicense, String importItarExemptionNo) {
	
		typeText(driver, test, AuthMana_Report_importShipmentNo, "Entering import Shipment No :", importShipmentNo);
		if(ImportDateFrom.length() > 0) {
			clickElement(driver, test, AuthMana_Report_importDateFrom, "Clicking on Import Date From :");
			dateOfMonthName(driver, test, "Selecting Import Date From :", ImportDateFrom);
		}
		if(ImportDateTo.length() > 0) {
			clickElement(driver, test, AuthMana_Report_importDateTo, "Clicking on Import Date To :");
			dateOfMonthName(driver, test, "Selecting Import Date To :", ImportDateTo);
		}
		typeText(driver, test, AuthMana_Report_shipperName, "Entering Shipper Name :", shipperName);
		typeText(driver, test, AuthMana_Report_shipperCountryCode, "Entering shipper Country Code :", shipperCountryCode);
		typeText(driver, test, AuthMana_Report_importLicense, "Entering import License :", importLicense);
		typeText(driver, test, AuthMana_Report_importItarExemptionNo, "Entering import Itar Exemption No :", importItarExemptionNo);
	}
}