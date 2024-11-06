package authorizationManagementClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class SearchAuthorizationReviewPendingActionsReportPage extends GenericMethods{
	
	public static WebDriver driver;
	public static ExtentTest test;
	
	//..................................Locators........................................//
	public static final String AuthMana_Report_Search="(//button[contains(text(),'Search')])[1]";
	public static final String AuthMana_Report_Reset="(//button[contains(text(),'Reset')])[1]";
	public static final String AuthMana_Report_SBUCode = "//select[@name='dosGeneralInfo.sbuCode']";
	public static final String AuthMana_Report_ActivityType="//select[@name='activityType']";
	public static final String AuthMana_Report_AuthorizationType ="(//a[contains(text(),'Authorization Type')])[2]";
	public static final String AuthMana_Report_AuthorizationTypePopup ="//textarea[@name='licenseTypes.licenseType']";
	public static final String AuthMana_Report_SearchPopUp="(//button[@name='Search'])[1]";
	public static final String AuthMana_Report_SelectPopUp="(//button[@name='Ok'])[1]";
	public static final String AuthMana_Report_ClosePopup = "(//button[@class='btn-close'])[1]";
	public static final String AuthMana_Report_AuthorizationTypeTextbox ="//textarea[@name='dosGeneralInfo.applFormType']";
	public static final String AuthMana_Report_TransactionID ="//input[@name='dosGeneralInfo.transactionId']";
	public static final String AuthMana_Report_LicenseNo = "//input[@name='dosGeneralInfo.licenseNo']";
	public static final String AuthMana_Report_ApproverName ="//a[contains(text(),'Approver Name')]";
	public static final String AuthMana_Report_userFirstname ="//input[@name='userProfile.userFirstname']";
	public static final String AuthMana_Report_ApproverNameTextbox = "//input[@name='licenseReviewValue.approverName']";
	public static final String AuthMana_Report_LicensePOC = "//a[contains(text(),'License POC')]";
	public static final String AuthMana_Report_LicensePOCTextbox = "//input[@name='licenseReviewValue.licPoc']";
	public static final String AuthMana_Report_Program = "(//a[contains(text(),'Program')])[3]";
	public static final String AuthMana_Report_ProgramCode ="//input[@name='programTab.programCode']";
	public static final String AuthMana_Report_ProgramTextbox ="//textarea[@name='licenseReviewValue.program']";
	public static final String AuthMana_Report_Segment = "(//a[contains(text(),'Segment')])[2]";
	public static final String AuthMana_Report_SegmentTextbox = "//textarea[@name='licenseReviewValue.segment']";
	public static final String AuthMana_Report_InternalRelDateFrom = "//input[@name='fromInternalRelDate']";
	public static final String AuthMana_Report_InternalRelDateTo = "//input[@name='toInternalRelDate']";
	public static final String AuthMana_Report_sortBy = "(//select[@name='sortBy'])[1]";
	public static final String AuthMana_Report_direction ="(//select[@name='direction'])[1]";
	
	
	//..................................Constructors..................................//
	public SearchAuthorizationReviewPendingActionsReportPage(WebDriver driver,ExtentTest test) {
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
	public void searchByParameters(String SBUCode, String ActivityType, String AuthorizationType, String TransactionID, 
			String LicenseNo, String ApproverName, String LicensePOC, String Program, String Segment, String SortBy, String Direction) {
		
		selectByVisibleText(driver, test, AuthMana_Report_SBUCode, "Selecting SBU Code :", SBUCode);
		selectByVisibleText(driver, test, AuthMana_Report_ActivityType, "Selecting Activity Type :", ActivityType);
		if(AuthorizationType.length() > 0) {
			clickElement(driver, test, AuthMana_Report_AuthorizationType, "Clicking on Authorization Type :");
			try {
				typeText(driver, test, AuthMana_Report_AuthorizationTypePopup, "Entering Authorization Type :", AuthorizationType);
				clickElement(driver, test, AuthMana_Report_SearchPopUp, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+AuthorizationType+"')]", "Selecting Authorization Type :");
				clickElement(driver, test, AuthMana_Report_SelectPopUp, "Clicking on Select Button :");				
			}catch(Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, AuthMana_Report_ClosePopup, "Clicking on Close Popup :");
			}
		}else {
			typeText(driver, test, AuthMana_Report_AuthorizationTypeTextbox, "Entering Authorization Type :", AuthorizationType);
		}
		typeText(driver, test, AuthMana_Report_TransactionID, "Entering Transaction ID :", TransactionID);
		typeText(driver, test, AuthMana_Report_LicenseNo, "Entering License No :", LicenseNo);
		if(ApproverName.length() > 0) {
			clickElement(driver, test, AuthMana_Report_ApproverName, "Clicking on Approver Name :");
			try {
				typeText(driver, test, AuthMana_Report_userFirstname, "Entering Approver Name :", ApproverName);
				clickElement(driver, test, AuthMana_Report_SearchPopUp, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ApproverName+"')]", "Selecting Approver Name :");
				clickElement(driver, test, AuthMana_Report_SelectPopUp, "Clicking on Select Button :");				
			}catch(Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, AuthMana_Report_ClosePopup, "Clicking on Close Popup :");
			}
		}else {
			typeText(driver, test, AuthMana_Report_ApproverNameTextbox, "Entering Approver Name :", ApproverName);
		}
		if(LicensePOC.length() > 0) {
			clickElement(driver, test, AuthMana_Report_LicensePOC, "Clicking on License POC :");
			try {
				typeText(driver, test, AuthMana_Report_userFirstname, "Entering License POC :", LicensePOC);
				clickElement(driver, test, AuthMana_Report_SearchPopUp, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+LicensePOC+"')]", "Selecting License POC :");
				clickElement(driver, test, AuthMana_Report_SelectPopUp, "Clicking on Select Button :");				
			}catch(Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, AuthMana_Report_ClosePopup, "Clicking on Close Popup :");
			}
		}else {
			typeText(driver, test, AuthMana_Report_LicensePOCTextbox, "Entering License POC :", LicensePOC);
		}
		if(Program.length() > 0) {
			clickElement(driver, test, AuthMana_Report_Program, "Clicking on Program :");
			try {
				typeText(driver, test, AuthMana_Report_ProgramCode, "Entering Program :", LicensePOC);
				clickElement(driver, test, AuthMana_Report_SearchPopUp, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Program+"')]", "Selecting Program :");
				clickElement(driver, test, AuthMana_Report_SelectPopUp, "Clicking on Select Button :");				
			}catch(Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, AuthMana_Report_ClosePopup, "Clicking on Close Popup :");
			}
		}else {
			typeText(driver, test, AuthMana_Report_ProgramTextbox, "Entering Program :", Program);
		}
		if(Segment.length() > 0) {
			clickElement(driver, test, AuthMana_Report_Segment, "Clicking on Segment :");
			try {
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Segment+"')]", "Selecting Segment :");
				clickElement(driver, test, AuthMana_Report_SelectPopUp, "Clicking on Select Button :");				
			}catch(Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, AuthMana_Report_ClosePopup, "Clicking on Close Popup :");
			}
		}else {
			typeText(driver, test, AuthMana_Report_SegmentTextbox, "Entering Segment :", Segment);
		}
		selectByVisibleText(driver, test, AuthMana_Report_sortBy, "Selecting Sort By :", SortBy);
		selectByVisibleText(driver, test, AuthMana_Report_direction, "Selecting Direction :", Direction);
	}
}