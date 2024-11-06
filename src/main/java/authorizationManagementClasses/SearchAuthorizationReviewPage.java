package authorizationManagementClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;

public class SearchAuthorizationReviewPage extends GenericMethods{
	
	public static WebDriver driver;
	public static ExtentTest test;
	
	//....................................Locators......................................//
	public static final String Auth_Mana_Search="//button[contains(text(),'Search')]";
	public static final String Auth_Mana_Reset="//button[contains(text(),'Reset')]";
	public static final String Auth_Mana_AddAuthorizationReview="//button[contains(text(),'Add Authorization Review')]";
	public static final String Auth_Mana_SBUCODE="//select[@id='dosGeneralInfo.sbuCode']";
	public static final String Auth_Mana_ActivityType="//select[@id='resultLicenseReviewform_licenseReviewValue_activityType']";
	public static final String Auth_Mana_AuthorizationType="//select[@id='resultLicenseReviewform_applFormType']";
	public static final String Auth_Mana_TransactionID="//input[@id='resultLicenseReviewform_dosGeneralInfo_transactionId']";
	public static final String Auth_Mana_AuthorizationNo="//input[@id='resultLicenseReviewform_dosGeneralInfo_licenseNo']";
	public static final String Auth_Mana_CaseNo="//input[@id='resultLicenseReviewform_dosGeneralInfo_caseNo']";
	public static final String Auth_Mana_AuthorizationOwnerPopUp="(//a[contains(text(),'Authorization Owner')])[4]";
	public static final String Auth_Mana_ownerFirstName="//input[@name='dosLicenseOwnerPopupDTO.ownerFirstName']";
	public static final String Auth_Mana_SearchPopUp="//button[@name='Search']";
	public static final String Auth_Mana_SelectPopUp="//button[@name='Ok']";
	public static final String Auth_Mana_ClosePopUp="//button[@class='btn-close']"; 
	public static final String Auth_Mana_AuthorizatiomOwner="//input[@id='resultLicenseReviewform_dosGeneralInfo_licenseOwner']";
	public static final String Auth_Mana_CreatedByPopUp="//a[contains(text(),'Created By')]";
	public static final String Auth_Mana_UserFirstNamePopUp="//input[@name='userProfile.userFirstname']";
	public static final String Auth_Mana_CreatedBy="//input[@id='resultLicenseReviewform_dosGeneralInfo_createdBy']";
	public static final String Auth_Mana_PreferedByPopUp="//a[contains(text(),'Prepared By')]";
	public static final String Auth_Mana_PreferedBy="//input[@id='resultLicenseReviewform_dosGeneralInfo_nameOfPreparer']";
	public static final String Auth_Mana_IssueDateFrom="//input[@id='resultLicenseReviewform_fromIssueDate']";
	public static final String Auth_Mana_IssueDateTo="//input[@id='resultLicenseReviewform_toIssueDate']";
	public static final String Auth_Mana_AuthorizationExpiry="//input[@name='noofdays']";
	public static final String Auth_Mana_ExpiryDateFrom="//input[@id='resultLicenseReviewform_fromExpiryDate']";
	public static final String Auth_Mana_ExpiryDateto="//input[@id='resultLicenseReviewform_toExpiryDate']";
	public static final String Auth_Mana_Status="//select[@name='postLicenseStatus']";
	public static final String Auth_Mana_internalStatus="//select[@name='internalStatus']";
	public static final String Auth_Mana_ApprovalNamePopUp="//a[contains(text(),'Approver Name')]";
	public static final String Auth_Mana_ApprovalName="//input[@id='resultLicenseReviewform_licenseReviewValue_approverName']";
	public static final String Auth_Mana_SegementPopUp="(//a[contains(text(),'Segment')])[2]";
	public static final String Auth_Mana_Segement="//textarea[@id='resultLicenseReviewform_dosGeneralInfo_segmentCode']";
	public static final String Auth_Mana_ProgramPopUp="(//a[contains(text(),'Programme')])[2]";
	public static final String Auth_Mana_ProgramCodePopUp="//input[@name='programTab.programCode']";
	public static final String Auth_Mana_Program="//textarea[@id='resultLicenseReviewform_dosGeneralInfo_programTab']";
	public static final String Auth_Mana_ProductLinePopUp="//a[contains(text(),'Product Line')]";
	public static final String Auth_Mana_ProductLine="//textarea[@id='resultLicenseReviewform_dosGeneralInfo_prodLine']";
	public static final String Auth_Mana_ProductFamilyPopUp="//a[contains(text(),'Product Family')]";
	public static final String Auth_Mana_ProductFamily="//textarea[@id='resultLicenseReviewform_dosGeneralInfo_prodFamily']";
	public static final String Auth_Mana_EmpoweredOfficialPopUp="(//a[contains(text(),'Empowered Official')])[2]";
	public static final String Auth_Mana_FirstName="//input[@name='empoweredOfficial.userFirstname']";
	public static final String Auth_Mana_EmpoweredOfficial="//input[@id='resultLicenseReviewform_licenseReviewValue_empOfficial']";
	public static final String Auth_Mana_ECCU_USMLPopUp="//a[contains(text(),'ECCN/USML')]";
	public static final String Auth_Mana_ECCNUSMLName="//input[@name='productClazz.prodClassification']";
	public static final String Auth_Mana_ECCU_USML="//input[@id='resultLicenseReviewform_prodClassification']";
	public static final String Auth_Mana_CPIDPopUp="//a[contains(text(),'CP ID')]";
	public static final String Auth_Mana_CPIDNAme="//input[@name='lmsControlPlanValue.cpId']";
	public static final String Auth_Mana_CPID="//input[@id='resultLicenseReviewform_cpId']";
	public static final String Auth_Mana_SortBy="//select[@name='sortBy']";
	public static final String Auth_Mana_Direction="//select[@name='direction']";
	
	//.............................Constructor.................................//
	public SearchAuthorizationReviewPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	//............................Search......................................//
	public void search() {
		clickElement(driver, test, Auth_Mana_Search, "Clicking on Search Tab");
	}
	
	//........................Click on Reset Tab................................//
	public void reset() {
		clickElement(driver, test, Auth_Mana_Reset, "Clicking on Reset Tab");
	}
	
	//.......................Click on Add Authorization Review.....................//
	public void addAuthorizationReview() {
		clickElement(driver, test, Auth_Mana_AddAuthorizationReview, "Clicking on Add Authorization Review");
	}
	
	//..............................Search Parameters...................................//
	public void searchBYParameters(String sbu,String activityType,String authorizationType, String transactionID,String authorizationNo,
			String caseNo,String AuthoOwner,String CreatedBy,String PrepairedBy,String IssueDateFrom,String IssueDateTo,String AuthoExpiry,
			String ExpiryDateFrom,String ExpiryDateTo,String Status,String InternalStatus,String ApproverName,String Segment,
			String Program,String ProductLine,String ProductFamily,String EmpoweredOfficial,String ECCN_USML,String CPID, String SortBy,
			String Direction) {
		
		selectByVisibleText(driver, test, Auth_Mana_SBUCODE, "Selecting SBU :", sbu);
		selectByVisibleText(driver, test, Auth_Mana_ActivityType, "Selecting Activity Type :", activityType);
		selectByVisibleText(driver, test, Auth_Mana_AuthorizationType, "Selecting Authorization Type :", authorizationType);
		typeText(driver, test, Auth_Mana_TransactionID, "Selecting Transaction ID :", transactionID);
		typeText(driver, test, Auth_Mana_AuthorizationNo, "Selecting Authorization No :", authorizationNo);
		typeText(driver, test, Auth_Mana_CaseNo, "Selecting Authorization No :", caseNo);
		if(AuthoOwner.length() > 0) {
			clickElement(driver, test, Auth_Mana_AuthorizationOwnerPopUp, "Clicking on Authorization Owner :");
			try {
				typeText(driver, test, Auth_Mana_ownerFirstName, "Entering Authorization Owner first Name :", AuthoOwner);
				clickElement(driver, test, Auth_Mana_SearchPopUp, "Clicking on Search Tab :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+AuthoOwner+"')]", "Clicking on Authorization owner name :");
				clickElement(driver, test, Auth_Mana_SelectPopUp, "Clicking on Select button :");
			}catch(Exception e) {
				e.printStackTrace();
				testFailSshot(driver, test);
				clickElement(driver, test, Auth_Mana_ClosePopUp, "Clicking on Close Popup icon :");
			}
		}else {
			typeText(driver, test, Auth_Mana_AuthorizatiomOwner, "Entering Authorization Owner Name in TextBox :", AuthoOwner);
		}
		if(CreatedBy.length() > 0) {
			clickElement(driver, test, Auth_Mana_CreatedByPopUp, "Clicking on Created By :");
			try {
				typeText(driver, test, Auth_Mana_UserFirstNamePopUp, "Entering Created By Name :", CreatedBy);
				clickElement(driver, test, Auth_Mana_SearchPopUp, "Clicking on Search Tab :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+CreatedBy+"')]", "Clicking on Created By name :");
				clickElement(driver, test, Auth_Mana_SelectPopUp, "Clicking on Select button :");
			}catch(Exception e) {
				e.printStackTrace();
				testFailSshot(driver, test);
				clickElement(driver, test, Auth_Mana_ClosePopUp, "Clicking on Close Popup icon :");
			}
		}else {
			typeText(driver, test, Auth_Mana_CreatedBy, "Entering Created By Name in TextBox :", CreatedBy);
		}
		if(PrepairedBy.length() > 0) {
			clickElement(driver, test, Auth_Mana_PreferedByPopUp, "Clicking on Created By :");
			try {
				typeText(driver, test, Auth_Mana_UserFirstNamePopUp, "Entering Prepaired By Name :", PrepairedBy);
				clickElement(driver, test, Auth_Mana_SearchPopUp, "Clicking on Search Tab :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+PrepairedBy+"')]", "Clicking on Prepaired By name :");
				clickElement(driver, test, Auth_Mana_SelectPopUp, "Clicking on Select button :");
			}catch(Exception e) {
				e.printStackTrace();
				testFailSshot(driver, test);
				clickElement(driver, test, Auth_Mana_ClosePopUp, "Clicking on Close Popup icon :");
			}
		}else {
			typeText(driver, test, Auth_Mana_PreferedBy, "Entering Prepaired By Name in TextBox :", PrepairedBy);
		}
		if(IssueDateFrom.length() > 0) {
		clickElement(driver, test, Auth_Mana_IssueDateFrom, "Clicking on Issue Date From :");
		dateOfMonthName(driver, test, "Selecting Issue Date From :", IssueDateFrom);
		}
		if(IssueDateTo.length() > 0) {
		clickElement(driver, test, Auth_Mana_IssueDateTo, "Clicking on Issue Date To :");
		dateOfMonthName(driver, test, "Selecting Issue Date To :", IssueDateTo);
		}
		typeText(driver, test, Auth_Mana_AuthorizationExpiry, "Entering Authorization Will Expiry Within :", AuthoExpiry);
		if(ExpiryDateFrom.length() > 0) {
		clickElement(driver, test, Auth_Mana_ExpiryDateFrom, "Clicking on Expiry Date From :");
		dateOfMonthName(driver, test, "Selecting Expiry Date From :", ExpiryDateFrom);
		}
		if(ExpiryDateTo.length() > 0) {
		clickElement(driver, test, Auth_Mana_ExpiryDateto, "Clicking on Expiry Date To :");
		dateOfMonthName(driver, test, "Selecting Expiry Date To :", ExpiryDateTo);
		}
		scrollToBottom(driver);
		selectByVisibleText(driver, test, Auth_Mana_Status, "Selecting Status :", Status);
		selectByVisibleText(driver, test, Auth_Mana_internalStatus, "Selecting Internal Status :", InternalStatus);
		if(ApproverName.length() > 0) {
			clickElement(driver, test, Auth_Mana_ApprovalNamePopUp, "Clicking on Approver Name :");
			try {
				typeText(driver, test, Auth_Mana_UserFirstNamePopUp, "Entering Approver Name :", ApproverName);
				clickElement(driver, test, Auth_Mana_SearchPopUp, "Clicking on Search Tab :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ApproverName+"')]", "Clicking on Approver name :");
				clickElement(driver, test, Auth_Mana_SelectPopUp, "Clicking on Select button :");
			}catch(Exception e) {
				e.printStackTrace();
				testFailSshot(driver, test);
			}
		}else {
			typeText(driver, test, Auth_Mana_ApprovalName, "Entering Approver Name in TextBox :", ApproverName);
		}
		if(Segment.length() > 0) {
			clickElement(driver, test, Auth_Mana_SegementPopUp, "Clicking on Segment :");
			try {
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Segment+"')]", "Clicking on Segment name :");
				clickElement(driver, test, Auth_Mana_SelectPopUp, "Clicking on Select button :");
			}catch(Exception e) {
				e.printStackTrace();
				testFailSshot(driver, test);
			}
		}else {
			typeText(driver, test, Auth_Mana_Segement, "Entering Segment Name in TextBox :", Segment);
		}
		if(Program.length() > 0) {
			clickElement(driver, test, Auth_Mana_ProgramPopUp, "Clicking on Program :");
			try {
				typeText(driver, test, Auth_Mana_ProgramCodePopUp, "Entering Program Name :", Program);
				clickElement(driver, test, Auth_Mana_SearchPopUp, "Clicking on Search Tab :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Program+"')]", "Clicking on Program name :");
				clickElement(driver, test, Auth_Mana_SelectPopUp, "Clicking on Select button :");
			}catch(Exception e) {
				e.printStackTrace();
				testFailSshot(driver, test);
			}
		}else {
			typeText(driver, test, Auth_Mana_Program, "Entering Program Name in TextBox :", Program);
		}
		if(ProductLine.length() > 0) {
			clickElement(driver, test, Auth_Mana_ProductLinePopUp, "Clicking on Product Line :");
			try {
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ProductLine+"')]", "Clicking on ProductLine name :");
				clickElement(driver, test, Auth_Mana_SelectPopUp, "Clicking on Select button :");
			}catch(Exception e) {
				e.printStackTrace();
				testFailSshot(driver, test);
			}
		}else {
			typeText(driver, test, Auth_Mana_ProductLine, "Entering ProductLine Name in TextBox :", ProductLine);
		}
		if(ProductFamily.length() > 0) {
			clickElement(driver, test, Auth_Mana_ProductFamilyPopUp, "Clicking on Created By :");
			try {
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ProductFamily+"')]", "Clicking on Product Family name :");
				clickElement(driver, test, Auth_Mana_SelectPopUp, "Clicking on Select button :");
			}catch(Exception e) {
				e.printStackTrace();
				testFailSshot(driver, test);
			}
		}else {
			typeText(driver, test, Auth_Mana_ProductFamily, "Entering Product Family Name in TextBox :", ProductFamily);
		}
		if(EmpoweredOfficial.length() > 0) {
			clickElement(driver, test, Auth_Mana_EmpoweredOfficialPopUp, "Clicking on Empowered Official :");
			try {
				typeText(driver, test, Auth_Mana_FirstName, "Entering Empowered Official Name :", EmpoweredOfficial);
				clickElement(driver, test, Auth_Mana_SearchPopUp, "Clicking on Search Tab :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+EmpoweredOfficial+"')]", "Clicking on Empowered Official name :");
				clickElement(driver, test, Auth_Mana_SelectPopUp, "Clicking on Select button :");
			}catch(Exception e) {
				e.printStackTrace();
				testFailSshot(driver, test);
			}
		}else {
			typeText(driver, test, Auth_Mana_EmpoweredOfficial, "Entering Empowered Official Name in TextBox :", EmpoweredOfficial);
		}
		if(ECCN_USML.length() > 0) {
			clickElement(driver, test, Auth_Mana_ECCU_USMLPopUp, "Clicking on ECCN_USML :");
			try {
				typeText(driver, test, Auth_Mana_ECCNUSMLName, "Entering ECCN_USML Name :", ECCN_USML);
				clickElement(driver, test, Auth_Mana_SearchPopUp, "Clicking on Search Tab :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ECCN_USML+"')]", "Clicking on ECCN_USML name :");
				clickElement(driver, test, Auth_Mana_SelectPopUp, "Clicking on Select button :");
			}catch(Exception e) {
				e.printStackTrace();
				testFailSshot(driver, test);
			}
		}else {
			typeText(driver, test, Auth_Mana_ECCU_USML, "Entering ECCN_USML Name in TextBox :", ECCN_USML);
		}
		if(CPID.length() > 0) {
			clickElement(driver, test, Auth_Mana_CPIDPopUp, "Clicking on CPID :");
			try {
				typeText(driver, test, Auth_Mana_CPIDNAme, "Entering CPID Name :", CPID);
				clickElement(driver, test, Auth_Mana_SearchPopUp, "Clicking on Search Tab :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+CPID+"')]", "Clicking on CPID name :");
				clickElement(driver, test, Auth_Mana_SelectPopUp, "Clicking on Select button :");
			}catch(Exception e) {
				e.printStackTrace();
				testFailSshot(driver, test);
			}
		}else {
			typeText(driver, test, Auth_Mana_CPID, "Entering CPID Name in TextBox :", CPID);
		}
		selectByVisibleText(driver, test, Auth_Mana_SortBy, "Selecting Sort By :", SortBy);
		selectByVisibleText(driver, test, Auth_Mana_Direction, "Selecting Direction :", Direction);
		scrollToTop(driver);
		scrollToElement(driver, Auth_Mana_Search);
	}
}