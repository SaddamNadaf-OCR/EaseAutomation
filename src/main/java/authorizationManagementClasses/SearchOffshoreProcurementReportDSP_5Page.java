package authorizationManagementClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;

public class SearchOffshoreProcurementReportDSP_5Page extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;
	
	//...................................Locators.......................................//
	public static final String DSP_5_Search="//button[contains(text(),'Search')]";
	public static final String DSP_5_Reset="//button[contains(text(),'Reset')]";
	public static final String DSP_5_AddOffshore="//button[contains(text(),'Add Offshore Procurement Report')]";
	public static final String DSP_5_SBU="//select[@name='dosGeneralInfo.sbuCode']";
	public static final String DSP_5_Type="//select[@name='dosGeneralInfo.applFormType']";
	public static final String DSP_5_TransactionID="//input[@name='dosGeneralInfo.transactionId']";
	public static final String DSP_5_licenseNo="//input[@name='dosGeneralInfo.licenseNo']";
	public static final String DSP_5_licenseOwner="//input[@name='offshoreProcurementValue.licenseOwner']";
	public static final String DSP_5_licensePoc="//input[@name='offshoreProcurementValue.licensePoc']";
	public static final String DSP_5_status="//select[@name='dosGeneralInfo.status']";
	public static final String DSP_5_reportStartDate="//input[@name='reportStartDate']";
	public static final String DSP_5_reportEndDate="//input[@name='reportEndDate']";
	public static final String DSP_5_reportComplete="//input[@name='reportComplete']";
	public static final String DSP_5_submittedToDos="//input[@name='submittedToDos']";
	public static final String DSP_5_sortBy="//select[@name='sortBy']";
	public static final String DSP_5_direction="//select[@name='direction']";

	//.................................Constructor.....................................//
	public SearchOffshoreProcurementReportDSP_5Page(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;		
	}
	
	//...........................Click on Search Button................................//
	public void search() {
		clickElement(driver, test, DSP_5_Search, "Clicking on Search Button");
	}
	
	//............................Click on Reset Tab...................................//
	public void reset() {
		clickElement(driver, test, DSP_5_Reset, "Clicking on Reset button");
	}
	
	//...........................Click on Add Shore Report............................//
	public void addshore() {
		clickElement(driver, test, DSP_5_AddOffshore, "Clicking on Add Shore Button");
	}
	
	//...........................Search By Parameters............................//
	public void searchByParameters(String SelectSBU,String type,String transactionID, String LicenseNo, String Owner, 
			String POC, String Status, String ReportDateFrom,String ReportDateTo,String ReportCompleted, String SubmittedToDOS,
			String SortBy, String Direction) {
		
		selectByVisibleText(driver, test, DSP_5_SBU, "Selecting SBU From DropDown", SelectSBU);
		selectByVisibleText(driver, test, DSP_5_Type, "Selecting Type From DropDown", type);
		typeText(driver, test, DSP_5_TransactionID, "Typing transaction ID", transactionID);
		typeText(driver, test, DSP_5_licenseNo, "Entering Authorization/Agreement Number :", LicenseNo);
		typeText(driver, test, DSP_5_licenseOwner, "Entering Owner :", Owner);
		typeText(driver, test, DSP_5_licensePoc, "Entering POC :", POC);
		selectByVisibleText(driver, test, DSP_5_status, "Selecting Status :", Status);
		if(ReportDateFrom.length() > 0) {
			clickElement(driver, test, DSP_5_reportStartDate, "Clicking on Report Date From :");
			dateOfMonthName(driver, test, "Selecting Report Date From :", ReportDateFrom);
		}
		if(ReportDateTo.length() > 0) {
			clickElement(driver, test, DSP_5_reportEndDate, "Clicking on Report Date To :");
			dateOfMonthName(driver, test, "Selecting Report Date To :", ReportDateTo);
		}
		if(ReportCompleted.contains("yes")) {
			clickElement(driver, test, DSP_5_reportComplete, "Clicking on Report Completed Check Box :");
		}
		if(SubmittedToDOS.contains("yes")) {
			clickElement(driver, test, DSP_5_submittedToDos, "Clicking on Submitted To DOS Check Box :");
		}
		selectByVisibleText(driver, test, DSP_5_sortBy, "Selecting Sort By :", SortBy);
		selectByVisibleText(driver, test, DSP_5_direction, "Selecting Direction :", Direction);
	}
}
