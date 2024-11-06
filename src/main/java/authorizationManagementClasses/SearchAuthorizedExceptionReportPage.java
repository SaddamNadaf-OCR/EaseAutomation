package authorizationManagementClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class SearchAuthorizedExceptionReportPage extends GenericMethods{
	
	public static WebDriver driver;
	public static ExtentTest test;
	
	//..................................Locators........................................//
	public static final String AuthMana_Report_Search="(//button[contains(text(),'Search')])[1]";
	public static final String AuthMana_Report_Reset="(//button[contains(text(),'Reset')])[1]";
	public static final String AuthMana_Report_SbuCode="//select[@name='licenseHeader.sbuCode']";
	public static final String AuthMana_Report_AuthorizationNo ="//a[contains(text(),'Authorization No.')]";
	public static final String AuthMana_Report_AuthorizationNoPopup="//input[@name='licenseHeaderDTO.licenseNo']";
	public static final String AuthMana_Report_SearchPopUp="//button[@name='Search']";
	public static final String AuthMana_Report_SelectPopUp="//button[contains(text(),'Select')]";
	public static final String AuthMana_Report_Closepopup = "(//button[@class='btn-close'])[1]";
	public static final String AuthMana_Report_AuthTextbox = "//input[@name='licenseHeader.licenseNo']";
	public static final String AuthMana_Report_Exception="//select[@name='licenseHeader.licenseType']";
	public static final String AuthMana_Report_Program="//a[contains(text(),'  Program')]";
	public static final String AuthMana_Report_ProgramCode="//input[@name='programTab.programCode']";
	public static final String AuthMana_Report_ProgramTextBox = "//textarea[@name='licenseHeader.programCode']";
	public static final String AuthMana_Report_EndUser ="//input[@name='licEuCons']";
	public static final String AuthMana_Report_Country="//input[@name='']";
	public static final String AuthMana_Report_ECCN_USML="//a[contains(text(),'ECCN/USML')]";
	public static final String AuthMana_Report_ECCN_USMLpopup ="//input[@name='productClazz.prodClassification']";
	public static final String AuthMana_Report_ECCN_USMLTextBox="//input[@name='licenseItem.prodClassification']";
	public static final String AuthMana_Report_SortBy="(//select[@name='sortBy'])[1]";
	public static final String AuthMana_Report_direction="(//select[@name='direction'])[1]";
		
	
	//..................................Constructors..................................//
	public SearchAuthorizedExceptionReportPage(WebDriver driver,ExtentTest test) {
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
	public void searchByAllParameters(String SBUCode, String AuthorizationNo, String Exception, String Program, String EndUser, String Country, String ECCNUSML, String SortBy, String direction) {
		
		selectByVisibleText(driver, test, AuthMana_Report_SbuCode, "Selecting SBU Code", SBUCode);
		if(AuthorizationNo.length() > 0) {
			clickElement(driver, test, AuthMana_Report_AuthorizationNo, "Clicking on Authorization No :");
			try {
				typeText(driver, test, AuthMana_Report_AuthorizationNoPopup, "Entering Authoization No :", AuthorizationNo);
				clickElement(driver, test, AuthMana_Report_SearchPopUp, "Clicking on Search Button :");
				Wait.waitfor(3);
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+AuthorizationNo+"')]", "Selecting Authorization No :");
				Wait.waitfor(3);
				clickElement(driver, test, AuthMana_Report_SelectPopUp, "Clicking on Select tab");
			} catch (Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, AuthMana_Report_Closepopup, "CLicking on Close Popup :");
			}
		}else {
			typeText(driver, test, AuthMana_Report_AuthTextbox, "Entering Authorization No :", AuthorizationNo);
		}
		selectByVisibleText(driver, test, AuthMana_Report_Exception, "Selecting Exception :", Exception);
		if(Program.length() > 0) {
			clickElement(driver, test, AuthMana_Report_Program, "Clicking on Program :");
			try {
				typeText(driver, test, AuthMana_Report_ProgramCode, "Entering Program No :", Program);
				clickElement(driver, test, AuthMana_Report_SearchPopUp, "Clicking on Search Button :");
				Wait.waitfor(3);
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Program+"')]", "Selecting Program No :");
				Wait.waitfor(3);
				clickElement(driver, test, AuthMana_Report_SelectPopUp, "Clicking on Select tab");
			} catch (Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, AuthMana_Report_Closepopup, "CLicking on Close Popup :");
			}
		}else {
			typeText(driver, test, AuthMana_Report_ProgramTextBox, "Entering Program :", Program);
		}
		typeText(driver, test, AuthMana_Report_EndUser, "Entering End User :", EndUser);
		typeText(driver, test, AuthMana_Report_Country, "Entering Country Name :", Country);
		if(ECCNUSML.length() > 0) {
			clickElement(driver, test, AuthMana_Report_ECCN_USML, "Clicking on ECCNUSML :");
			try {
				typeText(driver, test, AuthMana_Report_ECCN_USMLpopup, "Entering ECCNUSML No :", ECCNUSML);
				clickElement(driver, test, AuthMana_Report_SearchPopUp, "Clicking on Search Button :");
				Wait.waitfor(3);
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ECCNUSML+"')]", "Selecting ECCNUSML No :");
				Wait.waitfor(3);
				clickElement(driver, test, AuthMana_Report_SelectPopUp, "Clicking on Select tab");
			} catch (Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, AuthMana_Report_Closepopup, "CLicking on Close Popup :");
			}
		}else {
			typeText(driver, test, AuthMana_Report_ECCN_USMLTextBox, "Entering ECCNUSML :", ECCNUSML);
		}
		selectByVisibleText(driver, test, AuthMana_Report_SortBy, "Selecting SortBy", SortBy);
		selectByVisibleText(driver, test, AuthMana_Report_direction, "Selecting direction", direction);
	}
}