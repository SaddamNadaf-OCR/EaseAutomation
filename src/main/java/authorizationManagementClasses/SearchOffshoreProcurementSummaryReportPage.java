package authorizationManagementClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;

public class SearchOffshoreProcurementSummaryReportPage extends GenericMethods{
	
	public static WebDriver driver;
	public static ExtentTest test;
	
	//..................................Locators........................................//
	public static final String AuthMana_Report_Search="(//button[contains(text(),'Search')])[1]";
	public static final String AuthMana_Report_Reset="(//button[contains(text(),'Reset')])[1]";
	public static final String AuthMana_Report_SbuCode="//select[@name='dosGeneralInfo.sbuCode']";
	public static final String AuthMana_Report_AuthorizationType ="//select[@name='dosGeneralInfo.applFormType']";
	public static final String AuthMana_Report_TransactionID ="//input[@name='dosGeneralInfo.transactionId']";
	public static final String AuthMana_Report_AuthorizationNo ="//input[@name='dosGeneralInfo.licenseNo']";
	public static final String AuthMana_Report_Owner ="//input[@name='offshoreProcurementValue.licenseOwner']";
	public static final String AuthMana_Report_POC = "//input[@name='offshoreProcurementValue.licensePoc']";
	public static final String AuthMana_Report_Status = "//select[@name='dosGeneralInfo.status']";
	public static final String AuthMana_Report_ReportDateFrom="//input[@name='reportStartDate']";
	public static final String AuthMana_Report_ReportDateTo="//input[@name='reportEndDate']";
	public static final String AuthMana_Report_ReportComplete = "//input[@name='reportComplete']";
	public static final String AuthMana_Report_submittedToDos = "//input[@name='submittedToDos']";
	public static final String AuthMana_Report_SortBy="(//select[@name='sortBy'])[1]";
	public static final String AuthMana_Report_direction="(//select[@name='direction'])[1]";
		
	
	//..................................Constructors..................................//
	public SearchOffshoreProcurementSummaryReportPage(WebDriver driver,ExtentTest test) {
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
	public void searchByAllParameters(String SBUCode, String AuthorizationType, String TransactionID, String AuthorizationNo, 
			String Owner, String POC, String Status, String ReportDateFrom, String ReportDateTo, String SortBy, String direction) {
		
		selectByVisibleText(driver, test, AuthMana_Report_SbuCode, "Selecting SBU Code", SBUCode);
		selectByVisibleText(driver, test, AuthMana_Report_AuthorizationType, "Selecting Authorization Type :", AuthorizationType);
		typeText(driver, test, AuthMana_Report_TransactionID, "Entering Transaction ID :", TransactionID);
		typeText(driver, test, AuthMana_Report_AuthorizationNo, "Entering Authorization No :", AuthorizationNo);
		typeText(driver, test, AuthMana_Report_Owner, "Entering Owner :", Owner);
		typeText(driver, test, AuthMana_Report_POC, "Entering POC :", POC);
		selectByVisibleText(driver, test, AuthMana_Report_Status, "Selecting Status :", Status);
		if(ReportDateFrom.length() > 0) {
			clickElement(driver, test, AuthMana_Report_ReportDateFrom, "Clicking on Report Date From :");
			dateOfMonthName(driver, test, "Selecting Report Date From :", ReportDateFrom);
		}
		if(ReportDateTo.length() > 0) {
			clickElement(driver, test, AuthMana_Report_ReportDateTo, "Clicking on Report Date To :");
			dateOfMonthName(driver, test, "Selecting Report DAte To :", ReportDateTo);
		}
		selectByVisibleText(driver, test, AuthMana_Report_SortBy, "Selecting SortBy", SortBy);
		selectByVisibleText(driver, test, AuthMana_Report_direction, "Selecting direction", direction);
	}
}