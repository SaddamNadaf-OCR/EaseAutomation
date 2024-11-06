package crsClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class ForeignTravelAuditReportPage extends GenericMethods{
	
	public static WebDriver driver;
	public static ExtentTest test;
	
	//..................................Locators........................................//
	public static final String CRS_Report_Search ="//button[contains(text(),'Search')]";
	public static final String CRS_Report_Reset ="//button[contains(text(),'Reset')]";
	public static final String CRS_Report_foreignTravelId ="//input[@name='foreignTravelId']";
	public static final String CRS_Report_SortBy ="//select[@name='sortBy']";
	public static final String CRS_Report_direction ="//select[@name='direction']";
	
	//..................................Constructors..................................//
	public ForeignTravelAuditReportPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	//...................................Click on Search Button...................................//
	public void search() {
		clickElement(driver, test, CRS_Report_Search, "Clicking on Search button :");
	}
	
	//....................................Click on Reset Button..................................//
	public void reset() {
		clickElement(driver, test, CRS_Report_Reset, "Clicking on Reset Button :");
	}
	
	//.................................Search By Parameters.....................................//
	public void searchByParameters(String ForeignTravelID, String SortBy, String Direction) {
		typeText(driver, test, CRS_Report_foreignTravelId, "Entering Foreign Travel ID :", ForeignTravelID);
		selectByVisibleText(driver, test, CRS_Report_SortBy, "Selecting Sort By :", SortBy);
		selectByVisibleText(driver, test, CRS_Report_direction, "Selecting Direction :", Direction);
	}

}
