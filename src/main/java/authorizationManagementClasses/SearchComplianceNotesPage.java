package authorizationManagementClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class SearchComplianceNotesPage extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;
	
	//...................................Locators.......................................//
	public static final String SCN_Search="//button[contains(text(),'Search')]";
	public static final String SCN_AddComplianceNotes="//button[contains(text(),'Add Compliance Notes')]";
	public static final String SCN_Reset="//button[contains(text(),'Reset')]";
	public static final String SCN_SBU="//select[@name='complianceNotesValue.sbuCode']";
	public static final String SCN_contactType="//select[@name='complianceNotesValue.contactType']";
	public static final String SCN_NotesID="//input[@name='complianceNotesValue.transactionId']";
	public static final String SCN_ReferanceNo="//input[@name='complianceNotesValue.caseNo']";
	public static final String SCN_Purpose="(//a[contains(text(),'Purpose')])[3]";
	public static final String SCN_SelectPopUp="(//button[@name='Ok'])[1]";
	public static final String SCN_AuthorizationType="(//select[@name='complianceNotesValue.licenseType'])[1]";
	public static final String SCN_AuthorizationNo="(//input[@name='complianceNotesValue.licenseNo'])[1]";
	public static final String SCN_POC="(//a[contains(text(),'POC')])";
	public static final String SCN_userFirstname="(//input[@name='userProfile.userFirstname'])[1]";
	public static final String SCN_SearchPopup="(//button[@name='Search'])[1]";
	public static final String SCN_ClosePopup="(//button[@class='btn-close'])[1]";
	public static final String SCN_POCTextBox="(//input[@name='complianceNotesValue.itcPoc'])[1]";
	public static final String SCN_USAgency="(//a[contains(text(),'US Agency')])";
	public static final String SCN_startDate="(//input[@name='startDate'])[1]";
	public static final String SCN_endDate="(//input[@name='endDate'])[1]";
	public static final String SCN_brokeringActivity="(//select[@name='complianceNotesValue.brokeringActivity'])[1]";
	public static final String SCN_sortBy="(//select[@name='sortBy'])[1]";
	public static final String SCN_direction="(//select[@name='direction'])[1]";
	public static final String SCN_issueSummary="(//textarea[@name='complianceNotesValue.issueSummary'])[1]";
	public static final String SCN_description="(//textarea[@name='complianceNotesValue.description'])[1]";
	
	//.................................Constructor.....................................//
	public SearchComplianceNotesPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;		
	}
	//...................................Search.........................................//
	public void search() {
		clickElement(driver, test, SCN_Search, "Clicking on Search Tab");
	}
	//............................Add Compliance Notes...................................//
	public void addComplianceNotes() {
		clickElement(driver, test, SCN_AddComplianceNotes, "Clicking on Add Compliance Notes Tab");
	}
	//...................................Reset........................................//
	public void reset() {
		clickElement(driver, test, SCN_Reset, "Clicking on Reset Tab");
	}
	//................................Search By Parameters......................................//
	public void searchByParameters(String Sbu,String ContractType,String notesID,String referanceNo,String Purpose,
			String AuthorizationType,String AuthorizationNo,String POC,String USAgency,String Startdate,
			String Enddate, String BroeringActivity, String SortBy, String Direction, String IssueSummary, String Description) {
		
		selectByVisibleText(driver, test, SCN_SBU, "Selecting value of SBU :", Sbu);
		selectByVisibleText(driver, test, SCN_contactType, "Selecting Contract Type :", ContractType);
		typeText(driver, test, SCN_NotesID, "Typing the Notes ID", notesID);
		typeText(driver, test, SCN_ReferanceNo, "Typing the Referance Number", referanceNo);
		if(Purpose.length() > 0) {
			clickElement(driver, test, SCN_Purpose, "Clicking on Purpose :");
			try {
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Purpose+"')]", "Selecting Purpose :");
				clickElement(driver, test, SCN_SelectPopUp, "Clicking on Select Button :");
			}
			catch(Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, SCN_ClosePopup, "Clicking on Close Icon :");
			}
		}
		selectByVisibleText(driver, test, SCN_AuthorizationType, "Selecting Authorization Type :", AuthorizationType);
		typeText(driver, test, SCN_AuthorizationNo, "Entering Authorization No :", AuthorizationNo);
		if(POC.length() > 0) {
			clickElement(driver, test, SCN_POC, "Clicking on POC :");
			try {
				typeText(driver, test, SCN_userFirstname, "Entering POC :", POC);
				clickElement(driver, test, SCN_SearchPopup, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+POC+"')]", "Selecting POC :");
				clickElement(driver, test, SCN_SelectPopUp, "Clicking on Select Button :");
			}
			catch(Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, SCN_ClosePopup, "Clicking on Close Icon :");
			}
		}
		if(USAgency.length() > 0) {
			clickElement(driver, test, SCN_USAgency, "Clicking on US Agency :");
			try {
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+USAgency+"')]", "Selecting US Agency :");
				clickElement(driver, test, SCN_SelectPopUp, "Clicking on Select Button :");
			}
			catch(Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, SCN_ClosePopup, "Clicking on Close PopUp :");
			}
		}
		if(Startdate.length() > 0) {
		clickElement(driver, test, SCN_startDate, "Clicking on Start Date :");	
		dateOfMonthName(driver, test, "Selecting Start Date :", Startdate);
		}
		if(Enddate.length() > 0) {
			clickElement(driver, test, SCN_endDate, "Clicking on End Date :");
			dateOfMonthName(driver, test, "Selecting End Date :", Enddate);
		}
		selectByVisibleText(driver, test, SCN_brokeringActivity, "Selecting Broering Activity :", BroeringActivity);
		selectByVisibleText(driver, test, SCN_sortBy, "Selecting Sort By :", SortBy);
		selectByVisibleText(driver, test, SCN_direction, "Selecting Direction :", Direction);
		typeText(driver, test, SCN_issueSummary, "Entering issue Summary :", IssueSummary);
		typeText(driver, test, SCN_description, "Entering Desription :", Description);
	}
}
