package authorizationManagementClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class Part130SupplementalReportPage extends GenericMethods{
	
	public static WebDriver driver;
	public static ExtentTest test;
	
	//..................................Locators........................................//
	public static final String AuthMana_Report_Search="(//button[contains(text(),'Search')])[1]";
	public static final String AuthMana_Report_Reset="(//button[contains(text(),'Reset')])[1]";
	public static final String AuthMana_Report_SbuCode="//select[@name='part130Value.sbuCode']";
	public static final String AuthMana_Report_Part130RefID="//input[@name='part130Value.part130Id']";
	public static final String AuthMana_Report_Status = "//select[@name='part130Value.status']";
	public static final String AuthMana_Report_POA = "//input[@name='part130Value.poa']";
	public static final String AuthMana_Report_ContactNo="//a[contains(text(),'Contract No')]";
	public static final String AuthMana_Report_ContactNoPopup = "//input[@name='contract.contractNo']";
	public static final String AuthMana_Report_SearchPopUp="(//button[contains(text(),'Search')])[2]";
	public static final String AuthMana_Report_SelectPopUp="//button[contains(text(),'Select')]";
	public static final String AuthMana_Report_Closepopup = "(//button[@class='btn-close'])[1]";
	public static final String AuthMana_Report_ContactNoTextBox ="//input[@name='part130Value.contractNo']";
	public static final String AuthMana_Report_Recipient = "//input[@name='recipient']";
	public static final String AuthMana_Report_AgreementNo="//a[contains(text(),'Agreement No')]";
	public static final String AuthMana_Report_AgreementNoPopup ="//input[@name='dosGeneralInfoDTO.licenseNo']";
	public static final String AuthMana_Report_AgreementNoTextBox ="//input[@name='part130Value.licAggNo']";	
	public static final String AuthMana_Report_Country = "//input[@name='countryName']";
	public static final String AuthMana_Report_addedDateFrom = "//input[@name='addedDateFrom']";
	public static final String AuthMana_Report_addedDateTo = "//input[@name='addedDateTo']";
	public static final String AuthMana_Report_Part130CompletedYes = "//input[@name='part130ReportYes']";
	public static final String AuthMana_Report_Part130CompletedNo = "//input[@name='part130ReportNo']";
	public static final String AuthMana_Report_SubmittedDateFrom="//input[@name='dateFrom']";
	public static final String AuthMana_Report_SubmittedDateTo ="//input[@name='dateTo']";
	public static final String AuthMana_Report_Program ="(//a[contains(text(),'Program')])[3]";
	public static final String AuthMana_Report_programCodePopUp="//input[@name='programTab.programCode']";
	public static final String AuthMana_Report_programTab="//textarea[@name='part130Value.programCode']";
	public static final String AuthMana_Report_Segment="(//a[contains(text(),'Segment')])[2]";
	public static final String AuthMana_Report_segmentCode="//textarea[@name='part130Value.segmentCode']";
	public static final String AuthMana_Report_Site ="//a[contains(text(),'Site')]";
	public static final String AuthMana_Report_SiteID ="//input[@name='dosSite.siteId']";
	public static final String AuthMana_Report_SiteTextBox="//textarea[@name='part130Value.site']";
	public static final String AuthMana_Report_Department="//a[contains(text(),'Department')]";
	public static final String AuthMana_Report_DepartmentTextbox="//textarea[@name='part130Value.department']";
	public static final String AuthMana_Report_sortBy="//select[@name='sortBy']";
	public static final String AuthMana_Report_direction="//select[@name='direction']";
	
	//..................................Constructors..................................//
	public Part130SupplementalReportPage(WebDriver driver,ExtentTest test) {
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
	
	//................................Search By All Parameters ...............................//
	public void searchByAllParameters(String SBUCode, String Part130RefID, String Status, String POA, String ContactNo, 
			String Recipient, String AgreementNo, String Country, String AddedDateFrom, String AddedDateTo, String ReportYes, 
			String ReportNo, String SubmittedDateFrom, String SubmittedDateTo, String Programme, String Segment, 
			String Site, String Department, String SortBy, String Direction) {
		
		selectByVisibleText(driver, test, AuthMana_Report_SbuCode, "Selecting SBU Code :", SBUCode);
		typeText(driver, test, AuthMana_Report_Part130RefID, "Entering Part 130 Ref ID :", Part130RefID);
		selectByVisibleText(driver, test, AuthMana_Report_Status, "Selecting Status :", Status);
		typeText(driver, test, AuthMana_Report_POA, "Entering POA :", POA);
		if(ContactNo.length() > 0) {
			clickElement(driver, test, AuthMana_Report_ContactNo, "Clicking on Contact No :");
			try {
				Wait.waitfor(3);
				typeText(driver, test, AuthMana_Report_ContactNoPopup, "Entering Contact No :", ContactNo);
				Wait.waitfor(3);
				clickElement(driver, test, AuthMana_Report_SearchPopUp, "Clicking on Search Tab");
				Wait.waitfor(3);
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ContactNo+"')]", "Selecting Contact No :");
				Wait.waitfor(3);
				clickElement(driver, test, AuthMana_Report_SelectPopUp, "Clicking on Select tab");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			typeText(driver, test, AuthMana_Report_ContactNoTextBox, "Entering Contact No :", ContactNo);
		}
		typeText(driver, test, AuthMana_Report_Recipient, "Entering Recipient :", Recipient);
		if(AgreementNo.length() > 0) {
			clickElement(driver, test, AuthMana_Report_AgreementNo, "Clicking on Agreement No :");
			try {
				Wait.waitfor(3);
				typeText(driver, test, AuthMana_Report_AgreementNoPopup, "Entering Agreement No :", AgreementNo);
				Wait.waitfor(3);
				clickElement(driver, test, AuthMana_Report_SearchPopUp, "Clicking on Search Tab");
				Wait.waitfor(3);
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+AgreementNo+"')]", "Selecting Agreement No :");
				Wait.waitfor(3);
				clickElement(driver, test, AuthMana_Report_SelectPopUp, "Clicking on Select tab");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			typeText(driver, test, AuthMana_Report_AgreementNoTextBox, "Entering Agreement No :", AgreementNo);
		}
		typeText(driver, test, AuthMana_Report_Country, "Entering Country :", Country);
		if(AddedDateFrom.length() > 0) {
			clickElement(driver, test, AuthMana_Report_addedDateFrom, "Clicking on Added Date From :");
			dateOfMonthName(driver, test, "Selecting Added Date From :", AddedDateFrom);
		}
		if(AddedDateTo.length() > 0) {
			clickElement(driver, test, AuthMana_Report_addedDateTo, "Clicking on Added Date To :");
			dateOfMonthName(driver, test, "Selecting Added Date To :", AddedDateTo);
		}
		if(ReportYes.length() > 0) {
			clickElement(driver, test, AuthMana_Report_Part130CompletedYes, "Clicking on Part Report Submitted Yes :");
		}
		if(ReportNo.length() > 0) {
			clickElement(driver, test, AuthMana_Report_Part130CompletedNo, "Clicking on Part Report Submitted No :");
		}
		if(SubmittedDateFrom.length() > 0) {
			clickElement(driver, test, AuthMana_Report_SubmittedDateFrom, "Clicking on Submitted Date From :");
			dateOfMonthName(driver, test, "Selecting Submitted Date From :", SubmittedDateFrom);
		}
		if(SubmittedDateTo.length() > 0) {
			clickElement(driver, test, AuthMana_Report_SubmittedDateTo, "Clicking on Submitted Date To :");
			dateOfMonthName(driver, test, "Selecting Submitted Date To :", SubmittedDateTo);
		}
		
		if(Programme.length() > 0) {
			clickElement(driver, test, AuthMana_Report_Program, "Clicking on Programme :");
			try {
				Wait.waitfor(3);
				typeText(driver, test, AuthMana_Report_programCodePopUp, "Entering Transaction ID :", Programme);
				Wait.waitfor(3);
				clickElement(driver, test, AuthMana_Report_SearchPopUp, "Clicking on Search Tab :");
				Wait.waitfor(3);
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Programme+"')]", "Selecting Programme Code :");
				Wait.waitfor(3);
				clickElement(driver, test, AuthMana_Report_SelectPopUp, "Clicking on Select tab :");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			typeText(driver, test, AuthMana_Report_programTab, "Entering Programme Code :", Programme);
		}
		if(Segment.length() > 0) {
			clickElement(driver, test, AuthMana_Report_Segment, "Clicking on Segment");
			try {
				Wait.waitfor(3);
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Segment+"')]", "Selecting Segment Code");
				Wait.waitfor(3);
				clickElement(driver, test, AuthMana_Report_SelectPopUp, "Clicking on Select tab");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			typeText(driver, test, AuthMana_Report_segmentCode, "Entering Segment Code", Segment);
		}
		if(Site.length() > 0) {
			clickElement(driver, test, AuthMana_Report_Site, "Clicking on Site :");
			try {
				Wait.waitfor(3);
				typeText(driver, test, AuthMana_Report_SiteID, "Entering Site ID :", Site);
				Wait.waitfor(3);
				clickElement(driver, test, AuthMana_Report_SearchPopUp, "Clicking on Search Tab :");
				Wait.waitfor(3);
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Site+"')]", "Selecting Site :");
				Wait.waitfor(3);
				clickElement(driver, test, AuthMana_Report_SelectPopUp, "Clicking on Select tab");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			typeText(driver, test, AuthMana_Report_SiteTextBox, "Entering Site :", Site);
		}
		if(Department.length() > 0) {
			clickElement(driver, test, AuthMana_Report_Department, "Clicking on Department :");
			try {
				Wait.waitfor(3);
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Department+"')]", "Selecting Department :");
				Wait.waitfor(3);
				clickElement(driver, test, AuthMana_Report_SelectPopUp, "Clicking on Select tab");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			typeText(driver, test, AuthMana_Report_DepartmentTextbox, "Entering Department :", Department);
		}
		selectByVisibleText(driver, test, AuthMana_Report_sortBy, "Selecting Sort By :", SortBy);
		selectByVisibleText(driver, test, AuthMana_Report_direction, "Selecting Direction :", Direction);
	}
}