package authorizationManagementClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;

public class CreateNewCloseOutPage extends GenericMethods{
	
	public static WebDriver driver;
	public static ExtentTest test;
	
	//......................................Locators............................................//
	public static final String CreateCloseOut_Save="//button[@id='saveBtn']";
	public static final String CreateCloseOut_SaveandReturn="//button[@id='okBtn']";
	public static final String CreateCloseOut_Cancel="//button[contains(text(),'Cancel')]";
	public static final String CreateCloseOut_CloseOutId="//input[@id='editLicenseExpiry_licenseExpiry_licenseCloseOutId']";
	public static final String CreateCloseOut_AuthorizationNo="//input[@id='editLicenseExpiry_licenseExpiry_licenseNo']";
	public static final String CreateCloseOut_transactionId="//input[@id='editLicenseExpiry_licenseExpiry_transactionId']";
	public static final String CreateCloseOut_AuthorizationType="//select[@name='licenseType']";
	public static final String CreateCloseOut_Status="//select[@name='licenseStatus']";
	public static final String CreateCloseOut_activityType="//select[@name='licenseExpiry.activityType']";
	public static final String CreateCloseOut_expireDate="//input[@id='editLicenseExpiry_expireDate']";
	public static final String CreateCloseOut_CloseOutDate="//input[@name='exhaustDate']";
	public static final String CreateCloseOut_ViewAuthorizationTransaction="//button[@name='View']";
	
	//..............................Exhausted Authorization...........................................//
	public static final String CreateCloseOut_AuthorizationValue="//input[@id='editLicenseExpiry_ve-1']";
	public static final String CreateCloseOut_AuthorizationQuentity="//input[@id='editLicenseExpiry_qe-1']";
	
	//................................Expired Authorization.............................................//
	public static final String CreateCloseOut_LicencebalanceValue="//input[@id='editLicenseExpiry_bv-1']";
	public static final String CreateCloseOut_LicencebalanceQuentity="//input[@id='editLicenseExpiry_bq-1']";
	public static final String CreateCloseOut_LicenseExpiry="//input[@id='editLicenseExpiry_qv-1']";
	
	//.................................Suspend Authorization............................................//
	public static final String CreateCloseOut_LicenceAgreementUSGCountry="//input[@id='editLicenseExpiry_cend-1']";
	public static final String CreateCloseOut_LicenceAgreementsuspendedUSG="//input[@id='editLicenseExpiry_usg-1']";
	
	//.....................................Revoked Authorization............................................//
	public static final String CreateCloseOut_LicenceAgreementrevokedUSG="//input[@id='editLicenseExpiry_revokedLic-1']";
	
	
	public static final String CreateCloseOut_TerminateLicense="//input[@id='editLicenseExpiry_tl-1']";
	public static final String CreateCloseOut_LicenceAgreementNotConcludedExecuted="//input[@id='editLicenseExpiry_ce-1']";
	public static final String CreateCloseOut_LicenceAgreementSuperseded="//input[@id='editLicenseExpiry_ssed-1']";
	public static final String CreateCloseOut_LicenceAgreementTerminatedbyOwner="//input[@id='editLicenseExpiry_to-1']";
	public static final String CreateCloseOut_ReplacementLicenceNo="//input[@id='editLicenseExpiry_licenseExpiry_replacementNo']";
	public static final String CreateCloseOut_ReplacementTransID="//input[@id='editLicenseExpiry_licenseExpiry_replacementTransId']";
	public static final String CreateCloseOut_OwnerName="//input[@id='editLicenseExpiry_licenseExpiry_ownerName']";
	
	//......................................USG Reporting Block............................................//
	public static final String CreateCloseOut_AuthorizationClosureReportSubmittedUSG="//input[@id='editLicenseExpiry_lic-1']";
	public static final String CreateCloseOut_USGOfficer="//input[@id='editLicenseExpiry_licenseExpiry_usgOfficer']";
	public static final String CreateCloseOut_EmpoweredOfficer="//input[@id='editLicenseExpiry_licenseExpiry_reportedBy']";
	public static final String CreateCloseOut_UseStandardReport="//input[@id='editLicenseExpiry_sr-1']";
	public static final String CreateCloseOut_SubmittedDate="//input[@id='editLicenseExpiry_usgSubmittedDate']";
	public static final String CreateCloseOut_usgTitle="//input[@id='editLicenseExpiry_licenseExpiry_usgTitle']";
	public static final String CreateCloseOut_Title="//input[@id='editLicenseExpiry_licenseExpiry_reportedByTitle']";
	public static final String CreateCloseOut_UseDigitalSignatureImage="//input[@id='editLicenseExpiry_dsi-1']";
	public static final String CreateCloseOut_ReportDate="//input[@id='editLicenseExpiry_usgReportDate']";
	public static final String CreateCloseOut_ExporterCode="//input[@id='editLicenseExpiry_licenseExpiry_exporterCode']";
	public static final String CreateCloseOut_reportText="//textarea[@id='editLicenseExpiry_reportText']";
	
	//.....................................Notify Users.............................................//
	public static final String CreateCloseOut_Owner="//input[@id='editLicenseExpiry_lo']";
	public static final String CreateCloseOut_Manager="//input[@id='editLicenseExpiry_lm-1']";
	public static final String CreateCloseOut_Requestor="//input[@id='editLicenseExpiry_lr-1']";
	public static final String CreateCloseOut_NotifyUserEmailList="//input[@id='editLicenseExpiry_userList']";
	public static final String CreateCloseOut_UseStandardCloseOutEmail="//input[@id='editLicenseExpiry_coe']";
	public static final String CreateCloseOut_additionalNotes="//textarea[@id='editLicenseExpiry_additionalNotes']";
	public static final String CreateCloseOut_AddToInternalNotes="//input[@id='editLicenseExpiry_in']";
	public static final String CreateCloseOut_saveBtn1="//button[@id='saveBtn1']";
	public static final String CreateCloseOut_okBtn1="//button[@id='okBtn1']";
	
	//..................................Constructor............................................//
	public CreateNewCloseOutPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	//.............................Create New Close Out ........................................//
	public void newCloseOut(String closeOutid,String authorizationNo,String transactionId,String expirydate,String CloseOutdate) {
		typeText(driver, test, CreateCloseOut_CloseOutId, "Enetering CloseOut Id :", closeOutid);
		typeText(driver, test, CreateCloseOut_AuthorizationNo, "Entering Authorization no :", authorizationNo);
		typeText(driver, test, CreateCloseOut_transactionId, "Entering Transaction Id :", transactionId);
		if(expirydate.length() > 0) {
		clickElement(driver, test, CreateCloseOut_expireDate, "Clicking on Expiry Date :");
		dateOfMonthName(driver, test, "Selecting Expiry Date :", expirydate);
		}
		if(CloseOutdate.length() > 0) {
		clickElement(driver, test, CreateCloseOut_CloseOutDate, "Clicking on CloseOut Date :");
		dateOfMonthName(driver, test, "Selecting Close-Out Date :", CloseOutdate);
		}
	}
	
	//..........................Click on Save Button ...........................................//
	public void save() {
		clickElement(driver, test, CreateCloseOut_Save, "Clicking on Save Button :");
	}
	
	//..........................Click on Save And Return Button ...........................................//
	public void saveandreturn() {
		clickElement(driver, test, CreateCloseOut_SaveandReturn, "Clicking on Save and Return Button :");
	}
	
	//..........................Click on Cancel Button ...........................................//
	public void cancel() {
		clickElement(driver, test, CreateCloseOut_Cancel, "Clicking on Cancel Button :");
	}

}
