package authorizationManagementClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;

public class AuthorizationReviewPage extends GenericMethods{
	
	public static WebDriver driver;
	public static ExtentTest test;
	
	//.......................................Locators........................................//
	public static final String Auth_Mana_Save="(//button[@name='save'])[1]";
	public static final String Auth_Mana_SaveandReturn="(//button[@name='ok'])[1]";
	public static final String Auth_Mana_Cancel="(//button[@name='cancel'])[1]";
	public static final String Auth_Mana_AddEditDocument="(//button[@id='documentAttachId'])[1]";
	public static final String Auth_Mana_internalStatus="//select[@name='internalStatus']";
	public static final String Auth_Mana_internalDate="(//input[@name='internalRelDate'])[1]";
	public static final String Auth_Mana_ApproverName="//a[contains(text(),'Approver Name')]";
	public static final String Auth_Mana_userFirstname="//input[@name='userProfile.userFirstname']";
	public static final String Auth_Mana_SearchButtonPopup="//button[@name='Search']";
	public static final String Auth_Mana_SelectButtonPopup="//button[@name='Ok']";
	public static final String Auth_Mana_approverName="//input[@name='licenseReviewValue.approverName']";
	public static final String Auth_Mana_approverTelNo="//input[@name='licenseReviewValue.approverTelNo']";
	public static final String Auth_Mana_approverEmail="//input[@name='licenseReviewValue.approverEmail']";
	public static final String Auth_Mana_AuthorizationElectronicCopyProvidedtoOwner="(//input[@name='licenseReviewValue.originalLicCopyProvToOwner'])[1]";
	public static final String Auth_Mana_dateProvided="(//input[@name='dateProvided'])[1]";
	public static final String Auth_Mana_CurrentAuthorizationOwner="//a[contains(text(),'Current Authorization Owner')]";
	public static final String Auth_Mana_OwnerFirstName="//input[@name='dosLicenseOwnerPopupDTO.ownerFirstName']";
	public static final String Auth_Mana_Change="(//button[contains(text(),'Change')])[1]";
	public static final String Auth_Mana_CurrentAuthorizationPOC="//a[contains(text(),'Current Authorization POC')]";
	public static final String Auth_Mana_Change1="(//button[contains(text(),'Change')])[2]";
	public static final String Auth_Mana_CPOwner="//a[contains(text(),'CP Owner')]";
	public static final String Auth_Mana_Change2="(//button[contains(text(),'Change')])[4]";
	public static final String Auth_Mana_notificationsTab="//a[@id='notificationsTab']";
	public static final String Auth_Mana_notificationSubject="//textarea[@name='licenseReviewValue.notificationSubject']";
	public static final String Auth_Mana_addlNotificationText="//textarea[@name='licenseReviewValue.addlNotificationText']";
	public static final String Auth_Mana_AddUser="//a[contains(text(),'Add User')]"; 
	public static final String Auth_Mana_AddUserTextBox="//input[@name='licenseNotificationValue.userName']";
	public static final String Auth_Mana_role="//select[@name='licenseNotificationValue.role']"; 
	public static final String Auth_Mana_userEmail="//input[@name='licenseNotificationValue.userEmail']";
	public static final String Auth_Mana_SubmittedDate="(//input[@name='dsp83SubmittedDate'])[3]"; 
	public static final String Auth_Mana_contractSubmittedDate="(//input[@name='contractSubmittedDate'])[3]";
	public static final String Auth_Mana_addnlProvisoNotes="//textarea[@name='licenseReviewValue.addnlProvisoNotes']"; 
	//public static final String Auth_Mana_internalStatus="//select[@name='internalStatus']";
	//public static final String Auth_Mana_internalStatus="//select[@name='internalStatus']"; 
	//public static final String Auth_Mana_internalStatus="//select[@name='internalStatus']";
	//public static final String Auth_Mana_internalStatus="//select[@name='internalStatus']"; 
	//public static final String Auth_Mana_internalStatus="//select[@name='internalStatus']";
	//public static final String Auth_Mana_internalStatus="//select[@name='internalStatus']"; 
	//public static final String Auth_Mana_internalStatus="//select[@name='internalStatus']";
	//public static final String Auth_Mana_internalStatus="//select[@name='internalStatus']"; 
	//public static final String Auth_Mana_internalStatus="//select[@name='internalStatus']";
	//public static final String Auth_Mana_internalStatus="//select[@name='internalStatus']"; 
	//public static final String Auth_Mana_internalStatus="//select[@name='internalStatus']";
	//public static final String Auth_Mana_internalStatus="//select[@name='internalStatus']"; 
	//public static final String Auth_Mana_internalStatus="//select[@name='internalStatus']";
	//public static final String Auth_Mana_internalStatus="//select[@name='internalStatus']"; 
	//public static final String Auth_Mana_internalStatus="//select[@name='internalStatus']";
	//public static final String Auth_Mana_internalStatus="//select[@name='internalStatus']"; 
	//public static final String Auth_Mana_internalStatus="//select[@name='internalStatus']";
	
	//.............................Constructor.................................//
	public AuthorizationReviewPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	//................................Click on Save.....................................//
	public void save() {
		clickElement(driver, test, Auth_Mana_Save, "Clicking on Save Button :");
	}
	
	//...............................Click on Save and Return Butoon ........................//
	public void saveandreturn() {
		clickElement(driver, test, Auth_Mana_SaveandReturn, "Clicking on Save and Return Button :");
	}
	
	//...............................Click on Cancel Button ..............................//
	public void cancel() {
		clickElement(driver, test, Auth_Mana_Cancel, "Clicking on Cancel Tab :");
	}
	
	//.................................Click on Add/Edit Documents..........................//
	public void addEditDocuments() {
		clickElement(driver, test, Auth_Mana_AddEditDocument, "Clicking on Add Edit Documents :");
	}
	//................................Authorization Details ...................................//
	public void authorizationDetails(String InternalStatus, String Internaldate,String ApprovarName, String TelecomNo, String Email, 
			String dateProvided,String CurrentAuthOwner, String CurrentAuthPOC, String CPOwner) {
		selectByVisibleText(driver, test, Auth_Mana_internalStatus, "Selecting Internal Status :", InternalStatus);
		if(Internaldate.length() > 0) {
			clickElement(driver, test, Auth_Mana_internalDate, "Clicking on Internal Date :");
			dateOfMonthName(driver, test, "Selecting Internal Date :", Internaldate);
		}
		if(ApprovarName.length() > 0) {
			clickElement(driver, test, Auth_Mana_ApproverName, "Clicking on Approver Name :");
			try {
				typeText(driver, test, Auth_Mana_userFirstname, "Entering User First Name :", ApprovarName);
				clickElement(driver, test, Auth_Mana_SearchButtonPopup, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ ApprovarName +"')]", "Selecting Approver Name :");
				clickElement(driver, test, Auth_Mana_SelectButtonPopup, "Clicking on Select Tab :");
			}catch(Exception e) {
				e.printStackTrace();
				testFailSshot(driver, test);
			}
		}else {
			typeText(driver, test, Auth_Mana_approverName, "Entering Approver Name :", ApprovarName);
		}
		typeText(driver, test, Auth_Mana_approverTelNo, "Entering Approver Tel No :", TelecomNo);
		typeText(driver, test, Auth_Mana_approverEmail, "Entering Approver Email :", Email);
		clickElement(driver, test, Auth_Mana_AuthorizationElectronicCopyProvidedtoOwner, "Clicking on Authorization :");
		clickElement(driver, test, Auth_Mana_dateProvided, "Clicking on Date Provided :");
		dateOfMonthName(driver, test, "Selecting Date Provided :", dateProvided);
		scrollToBottom(driver);
		if(CurrentAuthOwner.length() > 0) {
			clickElement(driver, test, Auth_Mana_CurrentAuthorizationOwner, "Clicking on Current Auth Owner Name :");
			try {
				typeText(driver, test, Auth_Mana_OwnerFirstName, "Entering User First Name :", CurrentAuthOwner);
				clickElement(driver, test, Auth_Mana_SearchButtonPopup, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ CurrentAuthOwner +"')]", "Selecting Current Auth Owner Name :");
				clickElement(driver, test, Auth_Mana_SelectButtonPopup, "Clicking on Select Tab :");
			}catch(Exception e) {
				e.printStackTrace();
				testFailSshot(driver, test);
			}
		}
		scrollToBottom(driver);
		if(CurrentAuthPOC.length() > 0) {
			clickElement(driver, test, Auth_Mana_CurrentAuthorizationOwner, "Clicking on Current Auth POC Name :");
			try {
				typeText(driver, test, Auth_Mana_userFirstname, "Entering User First Name :", CurrentAuthPOC);
				clickElement(driver, test, Auth_Mana_SearchButtonPopup, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ CurrentAuthPOC +"')]", "Selecting Current Auth POC Name :");
				clickElement(driver, test, Auth_Mana_SelectButtonPopup, "Clicking on Select Tab :");
			}catch(Exception e) {
				e.printStackTrace();
				testFailSshot(driver, test);
			}
		}
		scrollToBottom(driver);
		if(CPOwner.length() > 0) {
			clickElement(driver, test, Auth_Mana_CPOwner, "Clicking on CP Owner Name :");
			try {
				typeText(driver, test, Auth_Mana_userFirstname, "Entering User First Name :", CPOwner);
				clickElement(driver, test, Auth_Mana_SearchButtonPopup, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ CPOwner +"')]", "Selecting CP Owner Name :");
				clickElement(driver, test, Auth_Mana_SelectButtonPopup, "Clicking on Select Tab :");
			}catch(Exception e) {
				e.printStackTrace();
				testFailSshot(driver, test);
			}
		}
	}
	
	//.................................Notification ........................................//
	public void notification(String NotificationSubject, String NotificationText, String AddUser, String Role, String UserEmail) {
		clickElement(driver, test, Auth_Mana_notificationsTab, "Clicking on Notification Section :");
		typeText(driver, test, Auth_Mana_notificationSubject, "Entering Notification Subject :", NotificationSubject);
		typeText(driver, test, Auth_Mana_addlNotificationText, "Entering Notification Text :", NotificationText);
		if(AddUser.length() > 0) {
			clickElement(driver, test, Auth_Mana_AddUser, "Clicking on Add User Name :");
			try {
				typeText(driver, test, Auth_Mana_userFirstname, "Entering User First Name :", AddUser);
				clickElement(driver, test, Auth_Mana_SearchButtonPopup, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ AddUser +"')]", "Selecting Add User Name :");
				clickElement(driver, test, Auth_Mana_SelectButtonPopup, "Clicking on Select Tab :");
			}catch(Exception e) {
				e.printStackTrace();
				testFailSshot(driver, test);
			}
		}else {
			typeText(driver, test, Auth_Mana_AddUserTextBox, "Entering Add User :", AddUser);
		}
		selectByVisibleText(driver, test, Auth_Mana_role, "Selecting Role :", Role);
		typeText(driver, test, Auth_Mana_userEmail, "Entering User Email :", UserEmail);
	}
	
	//.................................Provisos................................//
	public void provisos(String Submitdate, String ContractSubmitdate, String ProvisoNotes) {
		clickElement(driver, test, Auth_Mana_SubmittedDate, "Clicking on Submitted Date :");
		dateOfMonthName(driver, test, "Selecting Submitted Date :", Submitdate);
		clickElement(driver, test, Auth_Mana_contractSubmittedDate, "Clicking Contract Submit Date :");
		dateOfMonthName(driver, test, "Selecting Contract Submit Date :", ContractSubmitdate);
		typeText(driver, test, Auth_Mana_addnlProvisoNotes, "Entering Add Proviso Notes :", ProvisoNotes);
	}
	
	//...............................Authorization Reports................................//
	public void authorizationReport() {
		
	}
}
