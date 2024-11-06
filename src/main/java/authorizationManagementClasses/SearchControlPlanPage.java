package authorizationManagementClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class SearchControlPlanPage extends GenericMethods{
	
	public static WebDriver driver;
	public static ExtentTest test;
	
	//..................................Locators........................................//
	public static final String AuthMana_Report_Search="(//button[contains(text(),'Search')])[1]";
	public static final String AuthMana_Report_Reset="(//button[contains(text(),'Reset')])[1]";
	public static final String AuthMana_Report_SBUCode = "//select[@name='lmsControlPlanValue.sbuCode']";
	public static final String AuthMana_Report_CPType="//select[@name='lmsControlPlanValue.cpType']";
	public static final String AuthMana_Report_BusinessSystem ="//input[@name='lmsCpAuditDetailsValue.system']";
	public static final String AuthMana_Report_AuthorizationNo ="(//a[contains(text(),'Authorization No')])";
	public static final String AuthMana_Report_AuthorizationNoPopup ="//input[@name='dosGeneralInfoDTO.licenseNo']";
	public static final String AuthMana_Report_SearchPopUp="(//button[@name='Search'])[1]";
	public static final String AuthMana_Report_SelectPopUp="(//button[@name='Ok'])[1]";
	public static final String AuthMana_Report_ClosePopup = "(//button[@class='btn-close'])[1]";
	public static final String AuthMana_Report_AuthorizationNoTextbox ="//input[@name='lmsCpAuditDetailsValue.authorizationNo']";
	public static final String AuthMana_Report_AuthorizationType ="//select[@name='lmsCpAuditDetailsValue.authorizationType']";
	public static final String AuthMana_Report_CPID = "(//a[contains(text(),'CP ID')])";
	public static final String AuthMana_Report_CPIDPopup ="(//input[@name='lmsControlPlanValue.cpId'])[2]";
	public static final String AuthMana_Report_CPIDTextbox = "(//input[@name='lmsControlPlanValue.cpId'])[1]";
	public static final String AuthMana_Report_Trainer = "(//a[contains(text(),'Trainer')])";
	public static final String AuthMana_Report_userFirstname = "//input[@name='userProfile.userFirstname']";
	public static final String AuthMana_Report_TrainerTextBox = "//input[@name='lmsCpAuditValue.briefedBy']";
	public static final String AuthMana_Report_Trainee = "(//a[contains(text(),'Trainee')])";
	public static final String AuthMana_Report_TraineeTextbox = "//input[@name='lmsCpAuditDetailsValue.userName']";
	public static final String AuthMana_Report_CPDescription = "//input[@name='lmsControlPlanValue.description']";
	public static final String AuthMana_Report_sortBy = "(//select[@name='sortBy'])[1]";
	public static final String AuthMana_Report_direction ="(//select[@name='direction'])[1]";
	
	
	//..................................Constructors..................................//
	public SearchControlPlanPage(WebDriver driver,ExtentTest test) {
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
	public void searchByParameters(String SBUCode, String CPType, String BusinessSystem, String AuthorizationNo, 
			String AuthorizationType, String CPID, String Trainer, String Trainee, String CPDescription, 
			String SortBy, String Direction) {
		
		selectByVisibleText(driver, test, AuthMana_Report_SBUCode, "Selecting SBU Code :", SBUCode);
		selectByVisibleText(driver, test, AuthMana_Report_CPType, "Selecting CP Type :", CPType);
		typeText(driver, test, AuthMana_Report_BusinessSystem, "Entering Business System :", BusinessSystem);
		if(AuthorizationNo.length() > 0) {
			clickElement(driver, test, AuthMana_Report_AuthorizationNo, "Clicking on Authorization No :");
			try {
				typeText(driver, test, AuthMana_Report_AuthorizationNoPopup, "Entering Authorization Type :", AuthorizationNo);
				clickElement(driver, test, AuthMana_Report_SearchPopUp, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+AuthorizationNo+"')]", "Selecting Authorization No :");
				clickElement(driver, test, AuthMana_Report_SelectPopUp, "Clicking on Select Button :");				
			}catch(Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, AuthMana_Report_ClosePopup, "Clicking on Close Popup :");
			}
		}else {
			typeText(driver, test, AuthMana_Report_AuthorizationNoTextbox, "Entering Authorization No :", AuthorizationNo);
		}
		selectByVisibleText(driver, test, AuthMana_Report_AuthorizationType, "selecting Authorization Type :", AuthorizationType);
		if(CPID.length() > 0) {
			clickElement(driver, test, AuthMana_Report_CPID, "Clicking on CP ID :");
			try {
				typeText(driver, test, AuthMana_Report_CPIDPopup, "Entering CP ID :", CPID);
				clickElement(driver, test, AuthMana_Report_SearchPopUp, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+CPID+"')]", "Selecting CP ID :");
				clickElement(driver, test, AuthMana_Report_SelectPopUp, "Clicking on Select Button :");				
			}catch(Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, AuthMana_Report_ClosePopup, "Clicking on Close Popup :");
			}
		}else {
			typeText(driver, test, AuthMana_Report_CPIDTextbox, "Entering CP ID :", CPID);
		}
		if(Trainer.length() > 0) {
			clickElement(driver, test, AuthMana_Report_Trainer, "Clicking on Trainer :");
			try {
				typeText(driver, test, AuthMana_Report_userFirstname, "Entering Trainer :", Trainer);
				clickElement(driver, test, AuthMana_Report_SearchPopUp, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Trainer+"')]", "Selecting Trainer :");
				clickElement(driver, test, AuthMana_Report_SelectPopUp, "Clicking on Select Button :");				
			}catch(Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, AuthMana_Report_ClosePopup, "Clicking on Close Popup :");
			}
		}else {
			typeText(driver, test, AuthMana_Report_TrainerTextBox, "Entering Trainer :", Trainer);
		}
		if(Trainee.length() > 0) {
			clickElement(driver, test, AuthMana_Report_Trainee, "Clicking on Trainee :");
			try {
				typeText(driver, test, AuthMana_Report_userFirstname, "Entering Trainee :", Trainee);
				clickElement(driver, test, AuthMana_Report_SearchPopUp, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Trainee+"')]", "Selecting Trainee :");
				clickElement(driver, test, AuthMana_Report_SelectPopUp, "Clicking on Select Button :");				
			}catch(Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, AuthMana_Report_ClosePopup, "Clicking on Close Popup :");
			}
		}else {
			typeText(driver, test, AuthMana_Report_TraineeTextbox, "Entering Trainee :", Trainee);
		}
		typeText(driver, test, AuthMana_Report_CPDescription, "Entering CP Description :", CPDescription);
		selectByVisibleText(driver, test, AuthMana_Report_sortBy, "Selecting Sort By :", SortBy);
		selectByVisibleText(driver, test, AuthMana_Report_direction, "Selecting Direction :", Direction);
	}
}