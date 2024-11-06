package authorizationManagementClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;
import utilities.Wait;

public class SearchPart130ReportsPage extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;
	
	//............................Locators..................................//
	public static final String AddPart_Search="//button[@name='Search']";
	public static final String AddPart_Reset="//button[@type='reset']";
	public static final String AddPart_AddPart130Report="//button[@name='Add.x']";
	public static final String AddPart_SBU="//select[@name='part130Value.sbuCode']";
	public static final String AddPart_Part130Ref="//input[@name='part130Value.part130Id']";
	public static final String AddPart_Status="//select[@name='part130Value.status']";
	public static final String AddPart_POA="//input[@name='part130Value.poa']";
	public static final String AddPart_ContactNoHyperLink="//a[contains(text(),'Contract No')]";
	public static final String AddPart_ContractNoPopup="//input[@name='contract.contractNo']";
	public static final String AddPart_SearchPopup="(//button[@name='Search'])[2]";
	public static final String AddPart_SelectPopup="(//button[@name='Ok'])[2]";
	public static final String AddPart_ContactNo="//input[@name='part130Value.contractNo']";
	public static final String AddPart_Recipient="//input[@name='part130LogPaymentValue.recipientName']";
	public static final String AddPart_AgreementNo="//a[contains(text(),'Agreement No')]";
	public static final String AddPart_TransactionID="//input[@name='dosGeneralInfoDTO.transactionId']";
	public static final String AddPart_LicAgreeNo="//input[@name='part130Value.licAggNo']";
	public static final String AddPart_Country="//input[@name='part130LogPaymentValue.recipientCountryName']";
	public static final String AddPart_PartReportSubmitY="//input[@name='part130SubYes']";
	public static final String AddPart_PartReportSubmitN="//input[@name='part130SubNo']";
	public static final String AddPart_DateFrom="//input[@name='dateFrom']";
	public static final String AddPart_DateTo="//input[@name='dateTo']";
	public static final String AddPart_ProgramPopUp="(//a[contains(text(),'Program')])[3]";
	public static final String AddPart_ProgramCode="//input[@name='programTab.programCode']";
	public static final String AddPart_Program="//textarea[@name='part130Value.programCode']";
	public static final String AddPart_SegmentPopUp="(//a[contains(text(),'Segment')])[2]";
	public static final String AddPart_Segment="//textarea[@name='part130Value.segmentCode']";
	public static final String AddPart_SitePopUp="(//a[contains(text(),'Site')])";
	public static final String AddPart_SiteID="//input[@name='dosSite.siteId']";
	public static final String AddPart_Site="//textarea[@name='part130Value.site']";
	public static final String AddPart_DepartmentPopUp="//a[contains(text(),'Department')]";
	public static final String AddPart_Department="//textarea[@name='part130Value.department']";
	
	//....................................Constructor........................................//
	public SearchPart130ReportsPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	//.............................Click on Search Tab......................................//
	public void search() {
		clickElement(driver, test, AddPart_Search, "Clicking on Search Tab");
	}
	
	//.............................Click on Reset Tab.......................................//
	public void reset() {
		clickElement(driver, test, AddPart_Reset, "Clicking on Reset Tab");
	}
	
	//.............................Click on Add Part 130 Report...............................//
	public void addPart130report() {
		clickElement(driver, test, AddPart_AddPart130Report, "Clicking on Add Part 130 Report");
	}
	
	//.............................Search By Parameters....................................//
	public void searchByParameters(String sbu, String Part130RefID, String status, String POA, String ContractNo, 
			String Recipient, String AgreementNo, String Country,String SubmitReport,String ReportDateFrom,String ReportDateTo, 
			String Program, String Segment, String Site, String Department) {
		
		selectByVisibleText(driver, test, AddPart_SBU, "Selecting SBU From DropDown :", sbu);
		typeText(driver, test, AddPart_Part130Ref, "Entring Part 130 Referance ID :", Part130RefID);
		selectByVisibleText(driver, test, AddPart_Status, "Selecting Status :", status);
		typeText(driver, test, AddPart_POA, "Entering POA :", POA);
		if(ContractNo.length() > 0) {
			clickElement(driver, test, AddPart_ContactNoHyperLink, "Clicking on Contract No :");
			try {
				typeText(driver, test, AddPart_ContractNoPopup, "Entering Contract no :", ContractNo);
				clickElement(driver, test, AddPart_SearchPopup, "Clicking on Search tab :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ContractNo+"')]", "Selecting Contract No :");
				clickElement(driver, test, AddPart_SelectPopup, "Clicking on Select Tab :");
			}catch(Exception e) {
				testFailSshot(driver, test);
			}
		}else {
			typeText(driver, test, AddPart_ContactNo, "Entering Contract No :", ContractNo);
		}
		typeText(driver, test, AddPart_Recipient, "Entering Recipient :", Recipient);
		if(AgreementNo.length() > 0) {
			clickElement(driver, test, AddPart_AgreementNo, "Clicking on Agreement No :");
			try {
				typeText(driver, test, AddPart_TransactionID, "Entering Agreement no :", AgreementNo);
				clickElement(driver, test, AddPart_SearchPopup, "Clicking on Search tab :");
				Wait.waitfor(3);
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+AgreementNo+"')]", "Selecting Agreement No :");
				clickElement(driver, test, AddPart_SelectPopup, "Clicking on Select Tab :");
			}catch(Exception e) {
				testFailSshot(driver, test);
			}
		}else {
			typeText(driver, test, AddPart_LicAgreeNo, "Entering Agreement No :", AgreementNo);
		}
		typeText(driver, test, AddPart_Country, "Entering Country :", Country);
		if(SubmitReport.contains("yes")) {
			clickElement(driver, test, AddPart_PartReportSubmitY, "Clicking for Report Yes :");
		}else if(SubmitReport.contains("No")){
			clickElement(driver, test, AddPart_PartReportSubmitN, "Clicking for Report No :");
		}else {
			
		}
		if(ReportDateFrom.length() > 0) {
			clickElement(driver, test, AddPart_DateFrom, "Clicking on Date From :");
			dateOfMonthName(driver, test, "Selecting Date From :", ReportDateFrom);
		}
		if(ReportDateTo.length() > 0) {
			clickElement(driver, test, AddPart_DateTo, "Clicking on Date To :");
			dateOfMonthName(driver, test, "Selecting Date To :", ReportDateTo);
		}
		if(Program.length() > 0) {
			clickElement(driver, test, AddPart_ProgramPopUp, "Clicking on Program No :");
			try {
				typeText(driver, test, AddPart_ProgramCode, "Entering Program no :", Program);
				clickElement(driver, test, AddPart_SearchPopup, "Clicking on Search tab :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Program+"')]", "Selecting Program No :");
				clickElement(driver, test, AddPart_SelectPopup, "Clicking on Select Tab :");
			}catch(Exception e) {
				testFailSshot(driver, test);
			}
		}else {
			typeText(driver, test, AddPart_Program, "Entering Program No :", Program);
		}
		if(Segment.length() > 0) {
			clickElement(driver, test, AddPart_SegmentPopUp, "Clicking on Agreement No :");
			try {
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Segment+"')]", "Selecting Segment No :");
				clickElement(driver, test, AddPart_SelectPopup, "Clicking on Select Tab :");
			}catch(Exception e) {
				testFailSshot(driver, test);
			}
		}else {
			typeText(driver, test, AddPart_Segment, "Entering Segment No :", Segment);
		}
		if(Site.length() > 0) {
			clickElement(driver, test, AddPart_SitePopUp, "Clicking on Site No :");
			try {
				typeText(driver, test, AddPart_SiteID, "Entering Site no :", Site);
				clickElement(driver, test, AddPart_SearchPopup, "Clicking on Search tab :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Site+"')]", "Selecting Site No :");
				clickElement(driver, test, AddPart_SelectPopup, "Clicking on Select Tab :");
			}catch(Exception e) {
				testFailSshot(driver, test);
			}
		}else {
			typeText(driver, test, AddPart_Site, "Entering Site No :", Site);
		}
		if(Department.length() > 0) {
			clickElement(driver, test, AddPart_DepartmentPopUp, "Clicking on Department No :");
			try {
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Department+"')]", "Selecting Department No :");
				clickElement(driver, test, AddPart_SelectPopup, "Clicking on Select Tab :");
			}catch(Exception e) {
				testFailSshot(driver, test);
			}
		}else {
			typeText(driver, test, AddPart_Department, "Entering Department No :", Department);
		}
	}
	
	//........................Getting First Value From DropDown ......................................//
	public void countryFirstValue() {
		getSelectFirstText(driver, test, AddPart_Country, "Getting Country First Value :");
	}
}
