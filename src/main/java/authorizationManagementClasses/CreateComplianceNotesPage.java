package authorizationManagementClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;
import utilities.Wait;

public class CreateComplianceNotesPage extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;
	
	//...................................Locators.......................................//
	public static final String CCNP_Save="//input[@name='Save']";
	public static final String CCNP_SaveAndReturn="(//input[@class='primary-btn ocr-cache-search-dynamic-class'])[2]";
	public static final String CCNP_Cancel="//input[@name='Cancel']";
	public static final String CCNP_ContactDate="//input[@id='editComplianceNotes_contactDate']";
	public static final String CCNP_ReferanceNo="//input[@name='complianceNotesValue.caseNo']";
	public static final String CCNP_NotesID="//a[contains(text(),'Notes Id')]";
	public static final String CCNP_SearchPopUp="(//button[contains(text(),'Search')])[1]";
	public static final String CCNP_TemplateName="//td[contains(text(),'MN-#')]";
	public static final String CCNP_Select="(//button[contains(text(),'	Select')])[1]";
	public static final String CCNP_NotesIDTextBox="//input[@id='editComplianceNotes_notesId']";
	public static final String CCNP_BrokeringActivity="//select[@id='editComplianceNotes_complianceNotesValue_brokeringActivity']";
	public static final String CCNP_USAgency="//a[contains(text(),'US Agency')]";
	public static final String CCNP_USAgencyTextBox="//input[@name='complianceNotesValue.usAgency']";
	public static final String CCNP_SelectPopUp="//button[contains(text(),'Select')]";
	public static final String CCNP_Purpose="//select[@name='compPurpose']";
	public static final String CCNP_contactType="//select[@name='complianceNotesValue.contactType']";
	public static final String CCNP_licenseType="//select[@name='complianceNotesValue.licenseType']";
	public static final String CCNP_priority="//select[@name='complianceNotesValue.priority']";
	public static final String CCNP_Classification="(//a[contains(text(),' Classification')])[4]";
	public static final String CCNP_securityClassName="//input[@name='dosSecurityClassPoupDTO.securityClassName']";
	public static final String CCNP_Search="//button[@name='Search']";
	public static final String CCNP_SelectPopUp1="(//button[contains(text(),'Select')])[1]";
	public static final String CCNP_classificationTextBox="//input[@name='complianceNotesValue.classification']";
	public static final String CCNP_AuthorizationNo="//a[contains(text(),'Authorization No')]";
	public static final String CCNP_transactionId="//input[@name='dosGeneralInfoDTO.transactionId']";
	public static final String CCNP_country="//input[@name='complianceNotesValue.country']";
	public static final String CCNP_ProductFamily="//a[contains(text(),' Product Family')]";
	public static final String CCNP_prodFamilyTextbox="//textarea[@name='complianceNotesValue.prodFamily']";
	public static final String CCNP_Program="(//a[contains(text(),'Program')])[3]";
	public static final String CCNP_programCode="//input[@name='programTab.programCode']";
	public static final String CCNP_programtextbox="//textarea[@name='complianceNotesValue.program']";
	public static final String CCNP_Segment="(//a[contains(text(),' Segment')])";
	public static final String CCNP_segmentTextbox="//textarea[@name='complianceNotesValue.segment']";
	public static final String CCNP_ProductLine="(//a[contains(text(),' Product Line')])";
	public static final String CCNP_prodLineTextbox="//textarea[@name='complianceNotesValue.prodLine']";
	public static final String CCNP_usgOfficer="//input[@name='complianceNotesValue.usgOfficer']";
	public static final String CCNP_usgPhoneNo="//input[@name='complianceNotesValue.usgPhoneNo']";
	public static final String CCNP_usgEmail="//input[@name='complianceNotesValue.usgEmail']";
	public static final String CCNP_POC="//a[contains(text(),'POC')]";
	public static final String CCNP_userFirstname="//input[@name='userProfile.userFirstname']";
	public static final String CCNP_pocPhoneNo="//input[@name='complianceNotesValue.pocPhoneNo']";
	public static final String CCNP_pocEmail="//input[@name='complianceNotesValue.pocEmail']";
	public static final String CCNP_ContactBy="//a[contains(text(),' Contact By')]";
	public static final String CCNP_CCNP_userFirstname1="//input[@name='userProfile.userFirstname']";
	public static final String CCNP_contByPhNo="//input[@name='complianceNotesValue.contByPhNo']";
	public static final String CCNP_contByEmail="//input[@name='complianceNotesValue.contByEmail']";
	public static final String CCNP_issueSummary="//textarea[@name='complianceNotesValue.issueSummary']";
	public static final String CCNP_description="//textarea[@name='complianceNotesValue.description']";
	public static final String CCNP_memo="//textarea[@name='complianceNotesValue.memo']";
	public static final String CCNP_categoryPublic="(//input[@name='complianceNotesValue.category'])[1]";
	public static final String CCNP_categoryGroup="(//input[@name='complianceNotesValue.category'])[2]";
	public static final String CCNP_categoryPrivate="(//input[@name='complianceNotesValue.category'])[3]";
	
		
	//.................................Constructor.....................................//
	public CreateComplianceNotesPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;		
	}
	
	//..............................Click on Save Tab....................................//
	public void saveTab() {
		clickElement(driver, test, CCNP_Save, "Clicking on Save Tab");
	}
	
	//........................Click on Save and Return Tab................................//
	public void saveandreturnTab() {
		clickElement(driver, test, CCNP_SaveAndReturn, "Clicking on Save and Return Tab");
	}
	
	//.............................Click on Cancel Tab..................................//
	public void cancelTab() {
		clickElement(driver, test, CCNP_Cancel, "Clicking on Cancel Tab");
	}
	
	//........................Adding Data into Compliance Notes.............................//
	public void complianeNotes(String ReferanceNO, String date, String notesID, String code, String purpose, String contactType,
			String authorizationtype, String priority, String securityClassName, String transactionID, String country, String productfamilyID,
			String Programcode,String programtextbox,String SegmentCode,String segmentTextbox,String ProductLineID, String usgOfficer,
			String usgPhoneNo, String usgEmail, String userFirstname, String userFirstname1,
			String selectList, String issueSummary, String description, String memo) {
		
		typeText(driver, test, CCNP_ReferanceNo, "Entering Referance No :", ReferanceNO+randomnumbers());
		Wait.waitfor(3);
		if(date.length() > 0) {
			clickElement(driver, test, CCNP_ContactDate, "Clicking On Contact Date :");
			System.out.println(date);
			dateOfMonthName(driver, test, "Selecting Date : ", date);
		}
		typeText(driver, test, CCNP_NotesIDTextBox, "Typing Notes ID :", notesID);
		if(code.length()> 0) {
			clickElement(driver, test, CCNP_USAgency, "Clicking on US Agency :");
			try {
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+code +"')]", "Selecting Code From Table :");
				clickElement(driver, test, CCNP_SelectPopUp, "Clicking on Select Tab :");
			} catch (Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				}
			}else {
				typeText(driver, test, CCNP_USAgencyTextBox, "Entering US Agency :", code);
			}
		selectByVisibleText(driver, test, CCNP_Purpose, "Selecting Purpose :", purpose);
		selectByVisibleText(driver, test, CCNP_contactType, "Selecting Contact Type :", contactType);
		selectByVisibleText(driver, test, CCNP_licenseType, "Selecting Authorization Type :", authorizationtype);
		selectByVisibleText(driver, test, CCNP_priority, "Selecting Priority :", priority);
		if(securityClassName.length() > 0) {
			clickElement(driver, test, CCNP_Classification, "Clicking on Classification :");
			try {
				typeText(driver, test, CCNP_securityClassName, "Entering Security Class Name :", securityClassName);
				clickElement(driver, test, CCNP_Search, "Clicking on Search tab :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+securityClassName+"')]", "Selecting Name :");
				clickElement(driver, test, CCNP_SelectPopUp, "Clicking on Select Tab :");
			}
			catch(Exception e) {
				testFailSshot(driver, test);
			}
		}else {
			typeText(driver, test, CCNP_classificationTextBox, "Entering Classification :", securityClassName);
		}
		if(transactionID.length() > 0) {
			clickElement(driver, test, CCNP_AuthorizationNo, "Clicking on US Agency :");
			try {
				typeText(driver, test, CCNP_transactionId, "Entering Transaction Id :", transactionID);
				clickElement(driver, test, CCNP_Search, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+transactionID +"')]", "Selecting transactionID From Table :");
				clickElement(driver, test, CCNP_SelectPopUp, "Clicking on Select Tab :");
			} catch (Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
			}
		}
		typeText(driver, test, CCNP_country, "Entering Country :", country);
		if(productfamilyID.length() > 0) {
			clickElement(driver, test, CCNP_ProductFamily, "Clicking on Classification :");
			try {
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+productfamilyID+"')]", "Selecting Name :");
				clickElement(driver, test, CCNP_SelectPopUp, "Clicking on Select Tab :");
			}catch(Exception e) {
				testFailSshot(driver, test);
			}
		}else {
				typeText(driver, test, CCNP_prodFamilyTextbox, "Entering Product Family :", productfamilyID);
			}
		scrollToBottom(driver);
		if(Programcode.length() > 0) {
			clickElement(driver, test, CCNP_Program, "Clicking on Program :");
			try {
				typeText(driver, test, CCNP_programCode, "Entering Program Code :", Programcode);
				clickElement(driver, test, CCNP_Search, "Clicking on Search Button :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Programcode+"')]", "Selecting Program code :");
				clickElement(driver, test, CCNP_SelectPopUp, "Clicking on Select Tab :");
			}catch(Exception e) {
				testFailSshot(driver, test);
			}
			}else {
				typeText(driver, test, CCNP_programtextbox, "Entering Product Family :", programtextbox);
			}
		if(SegmentCode.length() > 0) {
			clickElement(driver, test, CCNP_Segment, "Clicking on Program :");
			try {
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+SegmentCode+"')]", "Selecting Program code :");
				clickElement(driver, test, CCNP_SelectPopUp, "Clicking on Select Tab :");
			}catch(Exception e) {
				testFailSshot(driver, test);
			}
			}else {
				typeText(driver, test, CCNP_segmentTextbox, "Entering Product Family :", segmentTextbox);
			}
		if(ProductLineID.length() > 0) {
			clickElement(driver, test, CCNP_ProductLine, "Clicking on Program :");
			try {
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ProductLineID+"')]", "Selecting Program Line code :");
				clickElement(driver, test, CCNP_SelectPopUp, "Clicking on Select Tab :");
			}catch(Exception e) {
				testFailSshot(driver, test);
			}
			}else {
				typeText(driver, test, CCNP_prodLineTextbox, "Entering Product Family :", ProductLineID);
			}
		typeText(driver, test, CCNP_usgOfficer, "Entering USG Officer :", usgOfficer);
		typeText(driver, test, CCNP_usgPhoneNo, "ENtering usg Phone No :", usgPhoneNo);
		typeText(driver, test, CCNP_usgEmail, "Entering Email Id :", usgEmail);
		if(userFirstname.length() > 0) {
			clickElement(driver, test, CCNP_POC, "Clicking on POC :");
			try {
				typeText(driver, test, CCNP_userFirstname, "Entering User First Name :", userFirstname);
				clickElement(driver, test, CCNP_Search, "Clicking on Search tab :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+userFirstname+"')]", "Selecting Name :");
				clickElement(driver, test, CCNP_SelectPopUp, "Clicking on Select Tab :");
			}catch(Exception e) {
				testFailSshot(driver, test);
			}
			}else {
				typeText(driver, test, CCNP_classificationTextBox, "Entering Classification :", userFirstname);
			}
		if(userFirstname1.length() > 0) {
			clickElement(driver, test, CCNP_ContactBy, "Clicking on POC :");
			try {
				typeText(driver, test, CCNP_CCNP_userFirstname1, "Entering User First Name :", userFirstname1);
				clickElement(driver, test, CCNP_Search, "Clicking on Search tab :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+userFirstname1+"')]", "Selecting Name :");
				clickElement(driver, test, CCNP_SelectPopUp, "Clicking on Select Tab :");
			}catch(Exception e) {
				testFailSshot(driver, test);
			}
			}else {
				typeText(driver, test, CCNP_classificationTextBox, "Entering Classification :", userFirstname1);
			}
		selectByVisibleText(driver, test, CCNP_BrokeringActivity, "Selecting value from DropDown :", selectList);
		typeText(driver, test, CCNP_issueSummary, "Entering Phone No :", issueSummary);
		typeText(driver, test, CCNP_description, "Entering Email Email :", description);
		typeText(driver, test, CCNP_memo, "Entering Email Email :", memo);
		scrollToTop(driver);
		scrollToElement(driver, CCNP_Save);
	}
	//............................Notes ID By Hyperlink.................................//
	public void notesIDHyperlink() {
		clickElement(driver, test, CCNP_NotesID, "Clicking on NotesID HyperLink :");
		try {
			clickElement(driver, test, CCNP_SearchPopUp, "Clicking on Search Tab :");
			mouseOver(driver, test, CCNP_TemplateName, "Mouse Over to the Template Name :");
			clickElement(driver, test, CCNP_TemplateName, "Clicking on Tempalte Name :");
			clickElement(driver, test, CCNP_Select, "Click on Select :");
		} catch (Exception e) {
			testFailSshot(driver, test);
		}
	}
	
	//........................Getting First Value From DropDown ......................................//
	public void countryFirstValue() {
		getSelectFirstText(driver, test, CCNP_country, "Getting Country First Value :");
	}
}
