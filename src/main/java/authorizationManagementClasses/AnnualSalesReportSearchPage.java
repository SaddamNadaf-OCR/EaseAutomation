package authorizationManagementClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;

public class AnnualSalesReportSearchPage extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;
	
	//...................................Locators.......................................//
	public static final String USGASR_Search="//button[contains(text(),'Search')]";
	public static final String USGASR_AddSalesReport="//button[contains(text(),'Add  Sales Report')]";
	public static final String USGASR_Reset="//button[contains(text(),'Reset')]";
	public static final String USGASR_SBU="//select[@name='dosGeneralInfo.sbuCode']";
	public static final String USGASR_TransactionId="//a[contains(text(),'Transaction Id')]";
	public static final String USGASR_transactionIdPopUp="//input[@name='dosGeneralInfoDTO.transactionId']";
	public static final String USGASR_SearchPopup="(//button[@name='Search'])[2]";
	public static final String USGASR_SelectPopup="//button[contains(text(),'Select')]";
	public static final String USGASR_transactionIdTextBox="//input[@name='dosGeneralInfo.transactionId']";
	public static final String USGASR_AuthorizationType="//select[@name='dosGeneralInfo.applFormType']";
	public static final String USGASR_status="//select[@name='dosGeneralInfo.status']";
	public static final String USGASR_SalesreportType="//select[@name='mlaSalesReportValue.reportType']";
	public static final String USGASR_AgreementNumber="//a[contains(text(),'Agreement Number')]";
	public static final String USGASR_AgreementNoTextBox="//input[@name='dosGeneralInfo.licenseNo']";
	public static final String USGASR_Program="(//a[contains(text(),'Program')])[3]";
	public static final String USGASR_programCode="//input[@name='programTab.programCode']";
	public static final String USGASR_programTab="//textarea[@name='dosGeneralInfo.programTab']";
	public static final String USGASR_POC="//a[contains(text(),'POC')]";
	public static final String USGASR_userFirstname="//input[@name='userProfile.userFirstname']";
	public static final String USGASR_POCtext="//input[@name='mlaSalesReportValue.mlaPoc']";
	public static final String USGASR_Segment="(//a[contains(text(),'Segment')])[2]";
	public static final String USGASR_segmentCode="//textarea[@name='dosGeneralInfo.segmentCode']";
	public static final String USGASR_Company="(//a[contains(text(),'Company')])";
	public static final String USGASR_consigneeId="//input[@name='consignee.consigneeId']";
	public static final String USGASR_companyTextBox="//input[@name='mlaSalesReportValue.company']";
	public static final String USGASR_ProductLine="(//a[contains(text(),'Product Line')])";
	public static final String USGASR_prodLineTextBox="//textarea[@name='dosGeneralInfo.prodLine']";
	public static final String USGASR_ProductFamily="(//a[contains(text(),'Product Family')])";
	public static final String USGASR_prodFamilyTextBox="//textarea[@name='dosGeneralInfo.prodFamily']";
	public static final String USGASR_reportYear="//input[@name='mlaSalesReportValue.reportYear']";
	public static final String USGASR_reportDateFrom="//input[@name='reportDateFrom']";
	public static final String USGASR_reportDateTo="//input[@name='reportDateTo']";
	public static final String USGASR_sortBy="//select[@name='sortBy']";
	public static final String USGASR_direction="//select[@name='direction']";
	public static final String USGAR_ClosePopUp="//button[@class='btn-close']";
	
	//.................................Constructor.....................................//
	public AnnualSalesReportSearchPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;		
	}
	
	//...............................Click on Search Tab..............................//
	public void search() {
		clickElement(driver, test, USGASR_Search, "Clicking on search Tab");
	}
	
	//...............................Click on Add Sales Report.........................//
	public void addSalesReports() {
		clickElement(driver, test, USGASR_AddSalesReport, "Click on Add Sales Reports");
	}
	
	//...............................Click on Search Tab..............................//
	public void reset() {
		clickElement(driver, test, USGASR_Reset, "Clicking on Reset Tab");
	}
	
	//............................Click on Search By Parameters..............................//
	public void searchByParameters(String sbu, String TransactionID, String AuthorizationType, String Status, String SalesReportType, 
			String AgreementNo, String Program, String POC, String Segment, String Company, String ProductLine, String ProductFamily,
			String SalesReportYear, String ReportDateFrom, String ReportDateTo, String SortBy, String Direction) {
		
		selectByVisibleText(driver, test, USGASR_SBU, "Selecting the SBU ", sbu);
		if(TransactionID.length() > 0) {
			clickElement(driver, test, USGASR_TransactionId, "Clicking on Transaction ID :");
			try {
				typeText(driver, test, USGASR_transactionIdPopUp, "Entering Transaction ID :", TransactionID);
				clickElement(driver, test, USGASR_SearchPopup, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+TransactionID+"')]", "Selecting Transaction ID :"+TransactionID);
				clickElement(driver, test, USGASR_SelectPopup, "Clicking on Select Tab :");
			}
			catch(Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, USGAR_ClosePopUp, "Click on Close PopUp :");
				e.printStackTrace();
			}
		}else {
			typeText(driver, test, USGASR_transactionIdTextBox, "Entering Transaction ID :", TransactionID);
		}
		selectByVisibleText(driver, test, USGASR_AuthorizationType, "Selecting Authorization Type :", AuthorizationType);
		selectByVisibleText(driver, test, USGASR_status, "Selecting Status :", Status);
		selectByVisibleText(driver, test, USGASR_SalesreportType, "Selecting Sales Report Type :", SalesReportType);
		if(AgreementNo.length() > 0) {
			clickElement(driver, test, USGASR_AgreementNumber, "Clicking on Agreement No :");
			try {
				typeText(driver, test, USGASR_transactionIdPopUp, "Entering Agreement No :", AgreementNo);
				clickElement(driver, test, USGASR_SearchPopup, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+AgreementNo+"')]", "Selecting Agreement No :"+AgreementNo);
				clickElement(driver, test, USGASR_SelectPopup, "Clicking on Select Tab :");
			}
			catch(Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, USGAR_ClosePopUp, "Click on Close PopUp :");
				e.printStackTrace();
			}
		}else {
			typeText(driver, test, USGASR_AgreementNoTextBox, "Entering Transaction ID :", TransactionID);
		}
		if(Program.length() > 0) {
			clickElement(driver, test, USGASR_Program, "Clicking on Program :");
			try {
				typeText(driver, test, USGASR_programCode, "Entering Program :", Program);
				clickElement(driver, test, USGASR_SearchPopup, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Program+"')]", "Selecting Program :"+Program);
				clickElement(driver, test, USGASR_SelectPopup, "Clicking on Select Tab :");
			}
			catch(Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, USGAR_ClosePopUp, "Click on Close PopUp :");
				e.printStackTrace();
			}
		}else {
			typeText(driver, test, USGASR_programTab, "Entering Program :", Program);
		}
		if(POC.length() > 0) {
			clickElement(driver, test, USGASR_POC, "Clicking on POC :");
			try {
				typeText(driver, test, USGASR_userFirstname, "Entering POC :", POC);
				clickElement(driver, test, USGASR_SearchPopup, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+POC+"')]", "Selecting POC :"+POC);
				clickElement(driver, test, USGASR_SelectPopup, "Clicking on Select Tab :");
			}
			catch(Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, USGAR_ClosePopUp, "Click on Close PopUp :");
				e.printStackTrace();
			}
		}else {
			typeText(driver, test, USGASR_POCtext, "Entering POC :", POC);
		}
		if(Segment.length() > 0) {
			clickElement(driver, test, USGASR_Segment, "Clicking on Segment :");
			try {
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Segment+"')]", "Selecting Segment :"+Segment);
				clickElement(driver, test, USGASR_SelectPopup, "Clicking on Select Tab :");
			}
			catch(Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, USGAR_ClosePopUp, "Click on Close PopUp :");
				e.printStackTrace();
			}
		}else {
			typeText(driver, test, USGASR_segmentCode, "Entering Segment :", Segment);
		}
		if(Company.length() > 0) {
			clickElement(driver, test, USGASR_Company, "Clicking on Company :");
			try {
				typeText(driver, test, USGASR_consigneeId, "Entering Company :", Company);
				clickElement(driver, test, USGASR_SearchPopup, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Company+"')]", "Selecting Company :"+Company);
				clickElement(driver, test, USGASR_SelectPopup, "Clicking on Select Tab :");
			}
			catch(Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, USGAR_ClosePopUp, "Click on Close PopUp :");
				e.printStackTrace();
			}
		}else {
			typeText(driver, test, USGASR_companyTextBox, "Entering Company :", Company);
		}
		if(ProductLine.length() > 0) {
			clickElement(driver, test, USGASR_ProductLine, "Clicking on ProductLine :");
			try {
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ProductLine+"')]", "Selecting ProductLine :"+ProductLine);
				clickElement(driver, test, USGASR_SelectPopup, "Clicking on Select Tab :");
			}
			catch(Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, USGAR_ClosePopUp, "Click on Close PopUp :");
				e.printStackTrace();
			}
		}else {
			typeText(driver, test, USGASR_prodLineTextBox, "Entering ProductLine :", ProductLine);
		}
		if(ProductFamily.length() > 0) {
			clickElement(driver, test, USGASR_ProductFamily, "Clicking on ProductFamily :");
			try {
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ProductFamily+"')]", "Selecting ProductFamily :"+ProductFamily);
				clickElement(driver, test, USGASR_SelectPopup, "Clicking on Select Tab :");
			}
			catch(Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, USGAR_ClosePopUp, "Click on Close PopUp :");
				e.printStackTrace();
			}
		}else {
			typeText(driver, test, USGASR_prodFamilyTextBox, "Entering ProductFamily :", ProductFamily);
		}
		typeText(driver, test, USGASR_reportYear, "Entering Sales Report Year :", SalesReportYear);
		if(ReportDateFrom.length() > 0) {
			clickElement(driver, test, USGASR_reportDateFrom, "Clicking on Report Date From :");
			dateOfMonthName(driver, test, "Selecting Report Date From :", ReportDateFrom);
		}
		if(ReportDateTo.length() > 0) {
			clickElement(driver, test, USGASR_reportDateTo, "Clicking on Report Date To :");
			dateOfMonthName(driver, test, "Selecting Report Date To :", ReportDateTo);
		}
		selectByVisibleText(driver, test, USGASR_sortBy, "Selecting Sort By :", SortBy);
		selectByVisibleText(driver, test, USGASR_direction, "Selecting Direction :", Direction);
	}
}
