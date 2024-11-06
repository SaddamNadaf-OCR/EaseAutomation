package authorizationManagementClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class SearchProvisoActionRequiredReportPage extends GenericMethods{
	
	public static WebDriver driver;
	public static ExtentTest test;
	
	//..................................Locators........................................//
	public static final String AuthMana_Report_Search="(//button[contains(text(),'Search')])[1]";
	public static final String AuthMana_Report_Reset="(//button[contains(text(),'Reset')])[1]";
	public static final String AuthMana_Report_AuthorizationNo="//input[@name='authorizationNo']";
	public static final String AuthMana_Report_SBUCode = "//select[@name='sbuCode']";
	public static final String AuthMana_Report_ProvisoNo ="//input[@name='provisoNo']";
	public static final String AuthMana_Report_ProvisoDescription ="//input[@name='provisoDescription']";
	public static final String AuthMana_Report_fromReqCompletionDate="//input[@name='fromReqCompletionDate']";
	public static final String AuthMana_Report_toReqCompletionDate="//input[@name='toReqCompletionDate']";
	public static final String AuthMana_Report_fromCompleteddate = "//input[@name='fromCompleteddate']";
	public static final String AuthMana_Report_toCompleteddate ="//input[@name='toCompleteddate']";
	public static final String AuthMana_Report_Status ="//select[@name='status']";
	
	
	//..................................Constructors..................................//
	public SearchProvisoActionRequiredReportPage(WebDriver driver,ExtentTest test) {
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
	public void searchByParameters(String AuthorizationNo, String SBUCode, String ProvisoNo, String ProvisoDescription, 
			String FromReqCompletionDate, String ToReqCompletionDate, String CompletionDateFrom, String CompletionDateTo, String Status) {
		
		typeText(driver, test, AuthMana_Report_AuthorizationNo, "Entering Authorization No :", AuthorizationNo);
		selectByVisibleText(driver, test, AuthMana_Report_SBUCode, "Selecting SBU Code :", SBUCode);
		typeText(driver, test, AuthMana_Report_ProvisoNo, "Entering Proviso No :", ProvisoNo);
		typeText(driver, test, AuthMana_Report_ProvisoDescription, "Entering Proviso Description :", ProvisoDescription);
		if(FromReqCompletionDate.length() > 0) {
			clickElement(driver, test, AuthMana_Report_fromReqCompletionDate, "Clicking on Req. Date Completion :");
			dateOfMonthName(driver, test, "Selecting Req. Date Completion From :", FromReqCompletionDate);
		}
		if(ToReqCompletionDate.length() > 0) {
			clickElement(driver, test, AuthMana_Report_toReqCompletionDate, "Clicking on Req. Date Completion To :");
			dateOfMonthName(driver, test, "Selecting Req. Completion To :", ToReqCompletionDate);
		}
		if(CompletionDateFrom.length() > 0) {
			clickElement(driver, test, AuthMana_Report_fromCompleteddate, "Clicking on Completion Date From :");
			dateOfMonthName(driver, test, "Selecting Completion From :", CompletionDateFrom);
		}
		if(CompletionDateTo.length() > 0) {
			clickElement(driver, test, AuthMana_Report_toCompleteddate, "Clicking on Completion Date To :");
			dateOfMonthName(driver, test, "Selecting Completion Date To :", CompletionDateTo);
		}
		selectByVisibleText(driver, test, AuthMana_Report_Status, "Selecting Status :", Status);
	}
}