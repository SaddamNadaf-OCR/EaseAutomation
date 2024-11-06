package crsClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class SearchExportImportAuditReportPage extends GenericMethods {
	
	public static WebDriver driver;
	public static ExtentTest test;
	
	//..................................Locators........................................//
	public static final String CRS_Report_Search ="//button[contains(text(),'Search')]";
	public static final String CRS_Report_Reset ="//button[contains(text(),'Reset')]";
	public static final String CRS_Report_RequestID ="//input[@name='expImpStatusAuditValue.expReqId']";
	public static final String CRS_Report_ExportFocalPoint ="//a[contains(text(),'Export Focal Point')]";
	public static final String CRS_Report_UserFirstName = "//input[@name='userProfile.userFirstname']";
	public static final String CRS_Report_SearchPopup = "//button[@name='Search']";
	public static final String CRS_Report_SelectPopup = "(//button[@name='Ok'])[1]";
	public static final String CRS_Report_ClosePopup = "(//button[@class='btn-close'])[1]";
	public static final String CRS_Reports_TechnicalFocalPoint = "//a[contains(text(),'Technical Focal Point')]";
	public static final String CRS_Reports_ReasonforReturn = "//a[contains(text(),' Reason for Return')]";
	public static final String CRS_Reports_ReasonForReturnTextBoxpopup = "//input[@name='turnbackCategoryValue.turnbackCode']";
	public static final String CRS_Reports_ReasonForReturnTextbox = "//input[@name='turnbackDesc']";
	public static final String CRS_Reports_sortBy = "//select[@name='sortBy']";
	public static final String CRS_Reports_direction = "//select[@name='direction']";
	
	//..................................Constructors..................................//
	public SearchExportImportAuditReportPage(WebDriver driver,ExtentTest test) {
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
	
	//....................................Search By Parameters......................................//
	public void searchByParameters(String RequestID, String ExportFocalPoint, String TechnicalFocalPoint, 
			String ReasonForReturn, String SortBy, String Direction) {
		
		typeText(driver, test, CRS_Report_RequestID, "Entering Request ID :", RequestID);
		if(ExportFocalPoint.length() > 0) {
			clickElement(driver, test, CRS_Report_ExportFocalPoint, "Clicking on Export Focal Point :");
			try {
				typeText(driver, test, CRS_Report_UserFirstName, "Entering Export Focal Point User First Name :", ExportFocalPoint);
				clickElement(driver, test, CRS_Report_SearchPopup, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ExportFocalPoint+"')]", "Selecting Export Focal Point :"+ExportFocalPoint);
				clickElement(driver, test, CRS_Report_SelectPopup, "Clicking on Select Tab :");
			}
			catch(Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, CRS_Report_ClosePopup, "Click on Close PopUp :");
				e.printStackTrace();
			}
		}
		if(TechnicalFocalPoint.length() > 0) {
			clickElement(driver, test, CRS_Reports_TechnicalFocalPoint, "Clicking on Technical Focal Point :");
			try {
				typeText(driver, test, CRS_Report_UserFirstName, "Entering Technical Focal Point User First Name :", TechnicalFocalPoint);
				clickElement(driver, test, CRS_Report_SearchPopup, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+TechnicalFocalPoint+"')]", "Selecting Technical Focal Point :"+TechnicalFocalPoint);
				clickElement(driver, test, CRS_Report_SelectPopup, "Clicking on Select Tab :");
			}
			catch(Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, CRS_Report_ClosePopup, "Click on Close PopUp :");
				e.printStackTrace();
			}
		}
		if(ReasonForReturn.length() > 0) {
			clickElement(driver, test, CRS_Reports_ReasonforReturn, "Clicking on Reason For Return :");
			try {
				typeText(driver, test, CRS_Reports_ReasonForReturnTextBoxpopup, "Entering Reason For Return :", ReasonForReturn);
				clickElement(driver, test, CRS_Report_SearchPopup, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ReasonForReturn+"')]", "Selecting Reason For Return :"+ReasonForReturn);
				clickElement(driver, test, CRS_Report_SelectPopup, "Clicking on Select Tab :");
			}
			catch(Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, CRS_Report_ClosePopup, "Click on Close PopUp :");
				e.printStackTrace();
			}
		}else {
			typeText(driver, test, CRS_Reports_ReasonForReturnTextbox, "Entering Reason For Return :", ReasonForReturn);
		}
		selectByVisibleText(driver, test, CRS_Reports_sortBy, "Selecting Sort By :", SortBy);
		selectByVisibleText(driver, test, CRS_Reports_direction, "Selecting Direction :", Direction);
	}

}
