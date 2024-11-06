package authorizationManagementClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class OpenLicenseReturnReportPage extends GenericMethods{
	
	public static WebDriver driver;
	public static ExtentTest test;
	
	//..................................Locators........................................//
	public static final String AuthMana_Report_SbuCode="//select[@name='selSbu']";
	public static final String AuthMana_Report_TransactionDatefrom ="//input[@name='fromDate']";
	public static final String AuthMana_Report_TransactionDateTo ="//input[@name='toDate']";
	public static final String AuthMana_Report_GenerateReport ="//button[@name='Save']";
	public static final String AuthMana_Report_ExcelSheet = "//i[@title='Download Excel Template']";
	
	//..................................Constructors..................................//
	public OpenLicenseReturnReportPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	//................................Click on Search Tab ...............................//
	public void search() {
		clickElement(driver, test, AuthMana_Report_GenerateReport, "Clicking on Generate Report button :");
	}
	
	//..............................Click on Excel Sheet ...................................//
	public void excelsheet() {
		clickElement(driver, test, AuthMana_Report_ExcelSheet, "Clicking on Excel Sheet :");
	}
	
	//................................Search By All Parameters ...............................//
	public void searchByAllParameters(String SBUCode, String TransactionDateFrom, String TransactionDateTo) {
		
		selectByVisibleText(driver, test, AuthMana_Report_SbuCode, "Selecting SBU Code", SBUCode);
		if(TransactionDateFrom.length() > 0) {
			clickElement(driver, test, AuthMana_Report_TransactionDatefrom, "Clicking on Transaction Date From :");
			dateOfMonthName(driver, test, "Selecting Transaction Date From :", TransactionDateFrom);
		}
		if(TransactionDateTo.length() > 0) {
			clickElement(driver, test, AuthMana_Report_TransactionDateTo, "Clicking on Transaction Date To :");
			dateOfMonthName(driver, test, "Selecting Transaction Date To :", TransactionDateTo);
		}
	}
}