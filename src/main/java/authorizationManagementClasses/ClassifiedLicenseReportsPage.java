package authorizationManagementClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class ClassifiedLicenseReportsPage extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;
	
	//...................................Locators.......................................//
	public static final String CR_Save="(//button[@name='Save'])[1]";
	public static final String CR_SaveandReturn="(//button[@name='Search'])[1]";
	public static final String CR_Cancel="(//button[@name='Cancel'])[1]";
	public static final String CR_usgOfficer="//input[@name='classifiedLicenseReportValue.usgOfficer']";
	public static final String CR_usgTitle="//input[@name='classifiedLicenseReportValue.usgTitle']";
	public static final String CR_empoweredOfficer="//input[@name='classifiedLicenseReportValue.empoweredOfficer']";
	public static final String CR_empoweredTitle="//input[@name='classifiedLicenseReportValue.empoweredTitle']";
	public static final String CR_Exporter="(//a[contains(text(),'Exporter')])[2]";
	public static final String CR_expCode="//input[@name='exporter.expCode']";
	public static final String CR_SearchPopup="(//button[@name='Search'])[2]";
	public static final String CR_SelectPopup="(//button[@name='Ok'])[1]";
	public static final String CR_ClosePopup="(//button[@class='btn-close'])[1]";
	public static final String CR_ddtcCode="//input[@name='classifiedLicenseReportValue.ddtcCode']";
	public static final String CR_dateSubmitted="//input[@name='dateSubmitted']";
	public static final String CR_reportDate="//input[@name='reportDate']";
	public static final String CR_markCopyToDos="(//input[@name='classifiedLicenseReportValue.markCopyToDos'])";
	public static final String CR_addlReportText="(//textarea[@name='classifiedLicenseReportValue.addlReportText'])";
	public static final String CR_remarks="(//textarea[@name='classifiedLicenseReportValue.remarks'])";
	
	//.................................Constructor.....................................//
	public ClassifiedLicenseReportsPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;		
	}
	
	//.......................Click on Save Button ..................................//
	public void save() {
		clickElement(driver, test, CR_Save, "CLicking on Save Button :");
	}
	
	//..........................Click on Save and Return .............................//
	public void saveandreturn() {
		clickElement(driver, test, CR_SaveandReturn, "Clicking on Save and Return Button :");
	}
	
	//..........................Click on Cancel Button ...............................//
	public void cancel() {
		clickElement(driver, test, CR_Cancel, "Clicking on Cancel Button :");
	}
	
	//.......................Entering Data into Report ................................//
	public void classifiedReport(String USGOfficer, String USGTitle, String EmpoweredOfficer, String EmpoweredTitle,String Exporter, 
			String DDTCCode,String Submitdate,String Reportdate, String ReportText, String Remark) {
		
		typeText(driver, test, CR_usgOfficer, "Entering USG Officer Name :", USGOfficer);
		typeText(driver, test, CR_usgTitle, "Entering USg Title :", USGTitle);
		typeText(driver, test, CR_empoweredOfficer, "Entering Empowered Officer :", EmpoweredOfficer);
		typeText(driver, test, CR_empoweredTitle, "Entering Empowered Title :", EmpoweredTitle);
		if(Exporter.length() > 0) {
			clickElement(driver, test, CR_Exporter, "Clicking on Exporter :");
			try {
				typeText(driver, test, CR_expCode, "Entering Exporter Code :", Exporter);
				clickElement(driver, test, CR_SearchPopup, "Clicking on Search Poup :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Exporter+"')]", "Selecting Exporter Code :");
				clickElement(driver, test, CR_SelectPopup, "Clicking on Select PopUp :");
			}catch(Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, CR_ClosePopup, "Clicking on Close PopUp :");
			}
		}
		typeText(driver, test, CR_ddtcCode, "Entering DDTC Code :", DDTCCode);
		scrollToBottom(driver);
		if(Submitdate.length() > 0) {
			clickElement(driver, test, CR_dateSubmitted, "Clicking on Date Submited :");
			dateOfMonthName(driver, test, "Selecting Date Submitted :", Submitdate);
		}
		if(Reportdate.length() > 0) {
			clickElement(driver, test, CR_reportDate, "Clicking on Report Date :");
			dateOfMonthName(driver, test, "Selecting Report Date :", Reportdate);
		}
		clickElement(driver, test, CR_markCopyToDos, "Clicking on Mark Copy To Dos :");
		typeText(driver, test, CR_addlReportText, "Entering Additional Report Text :", ReportText);
		typeText(driver, test, CR_remarks, "Entering Remark Text :", Remark);
		scrollToElement(driver, CR_Save);
	}
}
