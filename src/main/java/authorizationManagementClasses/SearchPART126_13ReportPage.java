package authorizationManagementClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class SearchPART126_13ReportPage extends GenericMethods{
	
	public static WebDriver driver;
	public static ExtentTest test;
	
	//..................................Locators........................................//
	public static final String AuthMana_Report_Search="(//button[contains(text(),'Search')])[1]";
	public static final String AuthMana_Report_Reset="(//button[contains(text(),'Reset')])[1]";
	public static final String AuthMana_Report_SbuCode="//select[@name='dosGeneralInfo.sbuCode']";
	public static final String AuthMana_Report_FormType="//select[@name='dosGeneralInfo.applFormType']";
	public static final String AuthMana_Report_Status="//select[@name='selectStatus']";
	public static final String AuthMana_Report_selectCompliance="//select[@name='selectCompliance']";
	public static final String AuthMana_Report_TransactionID="//input[@name='dosGeneralInfo.transactionId']";
	public static final String AuthMana_Report_licenseNo="//input[@name='dosGeneralInfo.licenseNo']";
	public static final String AuthMana_Report_AssociatedAgmt="//a[contains(text(),'Associated Agmt')]";
	public static final String AuthMana_Report_TransactionIDPopup="//input[@name='dosGeneralInfoDTO.transactionId']";
	public static final String AuthMana_Report_SearchPopUp="//button[@id='searchAgreementNoPopUp']";
	public static final String AuthMana_Report_SelectPopUp="//button[contains(text(),'Select')]";
	public static final String AuthMana_Report_Closepopup = "(//button[@class='btn-close'])[1]";
	public static final String AuthMana_Report_AssociatedAgreementTextBox="//input[@name='dosGeneralInfo.associatedAgreement']";
	public static final String AuthMana_Report_AssociatedLicense="//a[contains(text(),'Associated License')]";
	public static final String AuthMana_Report_AssociatedLicenseTexbox="//input[@name='dosGeneralInfo.associatedLicense']";
	public static final String AuthMana_Report_part12613Required="//input[@name='part12613Required']";
	public static final String AuthMana_Report_part12613Submitted="//input[@name='part12613Submitted']";
	public static final String AuthMana_Report_LicenceHardware="//input[@name='hw']";
	public static final String AuthMana_Report_LicenseTechnicalData="//input[@name='td']";
	public static final String AuthMana_Report_LicenseDefenceservice="//input[@name='defService']";
	public static final String AuthMana_Report_LicenseEmployee="//input[@name='emp']";
	public static final String AuthMana_Report_SubmittedDateFrom="//input[@name='fromSubmittedDate']";
	public static final String AuthMana_Report_SubmittedDateTo ="//input[@name='toSubmittedDate']";
	public static final String AuthMana_Report_IssueDateFrom="//input[@name='fromIssueDate']";
	public static final String AuthMana_Report_IssueDateTo="//input[@name='toIssueDate']";
	public static final String AuthMana_Report_ExpiryDateFrom="//input[@name='fromExpiryDate']";
	public static final String AuthMana_Report_ExpiryDateTo="//input[@name='toExpiryDate']";
	public static final String AuthMana_Report_CloseOutDateFrom ="//input[@name='fromCloseOutDate']";
	public static final String AuthMana_Report_CloseOutDateTo ="//input[@name='toCloseOutDate']";
	public static final String AuthMana_Report_Program ="(//a[contains(text(),'Program')])[3]";
	public static final String AuthMana_Report_programCodePopUp="//input[@name='programTab.programCode']";
	public static final String AuthMana_Report_programTab="//textarea[@name='dosGeneralInfo.programTab']";
	public static final String AuthMana_Report_Segment="(//a[contains(text(),'Segment')])[2]";
	public static final String AuthMana_Report_segmentCode="//textarea[@name='dosGeneralInfo.segmentCode']";
	public static final String AuthMana_Report_Site ="//a[contains(text(),'Site')]";
	public static final String AuthMana_Report_SiteID ="//input[@name='dosSite.siteId']";
	public static final String AuthMana_Report_SiteTextBox="//textarea[@name='dosGeneralInfo.site']";
	public static final String AuthMana_Report_Department="//a[contains(text(),'Department')]";
	public static final String AuthMana_Report_DepartmentTextbox="//textarea[@name='dosGeneralInfo.department']";
	public static final String AuthMana_Report_ProductLine="//a[contains(text(),'Product Line')]";
	public static final String AuthMana_Report_prodLine="//textarea[@name='dosGeneralInfo.prodLine']";
	public static final String AuthMana_Report_ProductFamily="//a[contains(text(),'Product Family')]";
	public static final String AuthMana_Report_prodFamilyTextbox="//textarea[@name='dosGeneralInfo.prodFamily']";
	public static final String AuthMana_Report_AuthorizationOwner="//a[contains(text(),' Authorization Owner')]";
	public static final String AuthMana_Report_OwnerFirstName="//input[@name='dosLicenseOwnerPopupDTO.ownerFirstName']";
	public static final String AuthMana_Report_AuthorizationOwnerTextbox ="//input[@name='dosGeneralInfo.licenseOwner']";
	public static final String AuthMana_Report_licenseManager="//input[@name='dosGeneralInfo.licenseManager']";
	public static final String AuthMana_Report_LicenseRequestor="//a[contains(text(),' License Requestor')]";
	public static final String AuthMana_Report_UserFirstName="//input[@name='userProfile.userFirstname']";
	public static final String AuthMana_Report_licenseRequestorTextbox="//input[@name='dosGeneralInfo.licenseRequestor']";
	public static final String AuthMana_Report_Reviewer="(//a[contains(text(),'Reviewer')])[2]";
	public static final String AuthMana_Report_ReviewerTextbox="//input[@name='dosGeneralInfo.reviewer']";
	public static final String AuthMana_Report_PreparedBy="//a[contains(text(),'Prepared By')]";
	public static final String AuthMana_Report_PreparedByTextbox="//input[@name='dosGeneralInfo.nameOfPreparer']";
	public static final String AuthMana_Report_CorporateRep="//a[contains(text(),'Corporate Rep')]";
	public static final String AuthMana_Report_CorporateRepTextbox="//input[@name='dosGeneralInfo.corpRepName']";
	public static final String AuthMana_Report_EmpoweredOfficial="(//a[contains(text(),'Empowered Official')])[2]";
	public static final String AuthMana_Report_EOUserFirstName="//input[@name='empoweredOfficial.userFirstname']";
	public static final String AuthMana_Report_EmpoweredOfficerTextbox="//input[@name='dosGeneralInfo.officer']";
	
	//..................................Constructors..................................//
	public SearchPART126_13ReportPage(WebDriver driver,ExtentTest test) {
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
	public void searchByAllParameters(String SBUCode, String FormType, String Status, String selectCompliance, String TransactionID,
			String LicenseNo, String AssociatedAGMT, String AssociatedLicense, String Part130Required, String Part12613Submitted,
			String LicenseHardware, String LicenseTechnicalData, String LicenseDefenceService, String LicenseEmployee, String SubmittedDateFrom, 
			String SubmittedDateTo, String IssueDateFrom, String IssueDateTo, String ExpiryDateFrom, String ExpiryDateTo, String CloseOutDateFrom, 
			String CloseOutDateTo, String Programme, String Segment, String Site, String Department, String ProductLine, String ProductFamily, 
			String AuthorizationOwner, String licenseManager, String LicenseRequester, String Reviewer, String PreparedBy, String CorparateREP, 
			String EmpoweredOfficial) {
		
		selectByVisibleText(driver, test, AuthMana_Report_SbuCode, "Selecting SBU Code :", SBUCode);
		selectByVisibleText(driver, test, AuthMana_Report_FormType, "Selecting Form Type :", FormType);
		selectByVisibleText(driver, test, AuthMana_Report_Status, "Selecting Status :", Status);
		selectByVisibleText(driver, test, AuthMana_Report_selectCompliance, "Selecting select Compliance : :", selectCompliance);
		typeText(driver, test, AuthMana_Report_TransactionID, "Entering Transaction Id :", TransactionID);
		typeText(driver, test, AuthMana_Report_licenseNo, "Entering License No :", LicenseNo);
		if(AssociatedAGMT.length() > 0) {
			clickElement(driver, test, AuthMana_Report_AssociatedAgmt, "Clicking on AssociatedAGMT :");
			try {
				Wait.waitfor(3);
				typeText(driver, test, AuthMana_Report_TransactionIDPopup, "Entering Associated AGMT :", AssociatedAGMT);
				Wait.waitfor(3);
				clickElement(driver, test, AuthMana_Report_SearchPopUp, "Clicking on Search Tab");
				Wait.waitfor(3);
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+AssociatedAGMT+"')]", "Selecting Associated AGMT :");
				Wait.waitfor(3);
				clickElement(driver, test, AuthMana_Report_SelectPopUp, "Clicking on Select tab");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			typeText(driver, test, AuthMana_Report_AssociatedAgreementTextBox, "Entering Associated AGMT :", AssociatedAGMT);
		}
		if(AssociatedLicense.length() > 0) {
			clickElement(driver, test, AuthMana_Report_AssociatedAgmt, "Clicking on Associated License :");
			try {
				Wait.waitfor(3);
				typeText(driver, test, AuthMana_Report_TransactionIDPopup, "Entering Associated License :", AssociatedLicense);
				Wait.waitfor(3);
				clickElement(driver, test, AuthMana_Report_SearchPopUp, "Clicking on Search Tab");
				Wait.waitfor(3);
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+AssociatedLicense+"')]", "Selecting Associated License :");
				Wait.waitfor(3);
				clickElement(driver, test, AuthMana_Report_SelectPopUp, "Clicking on Select tab");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			typeText(driver, test, AuthMana_Report_AssociatedAgreementTextBox, "Entering Associated License :", AssociatedLicense);
		}
		if(Part130Required.equalsIgnoreCase("yes")) {
			clickElement(driver, test, AuthMana_Report_part12613Required, "Clicking on Part 130 Required :");
		}
		if(Part12613Submitted.equalsIgnoreCase("yes")) {
			clickElement(driver, test, AuthMana_Report_part12613Submitted, "Clicking on Part 130 Submitted :");
		}
		if(LicenseHardware.equalsIgnoreCase("yes")) {
			clickElement(driver, test, AuthMana_Report_LicenceHardware, "Clicking on License Type as Hardware :");
		}
		if(LicenseTechnicalData.equalsIgnoreCase("yes")) {
			clickElement(driver, test, AuthMana_Report_LicenseTechnicalData, "Clicking on License Technical Data :");
		}
		if(LicenseDefenceService.equalsIgnoreCase("yes")) {
			clickElement(driver, test, AuthMana_Report_LicenseDefenceservice, "CLicking on Defecnce Service :");
		}
		if(LicenseEmployee.equalsIgnoreCase("yes")) {
			clickElement(driver, test, AuthMana_Report_LicenseEmployee, "CLicking on Employee EN/DN :");
		}
		if(SubmittedDateFrom.length() > 0) {
			clickElement(driver, test, AuthMana_Report_SubmittedDateFrom, "Clicking on Submitted Date From :");
			dateOfMonthName(driver, test, "Selecting Submitted Date From :", SubmittedDateFrom);
		}
		if(SubmittedDateTo.length() > 0) {
			clickElement(driver, test, AuthMana_Report_SubmittedDateTo, "Clicking on Submitted Date To :");
			dateOfMonthName(driver, test, "Selecting Submitted Date To :", SubmittedDateTo);
		}
		if(IssueDateFrom.length() > 0) {
			clickElement(driver, test, AuthMana_Report_IssueDateFrom, "Clicking on Issue Date From :");
			dateOfMonthName(driver, test, "Selecting Issue Date From :", IssueDateFrom);
		}
		if(IssueDateTo.length() > 0) {
			clickElement(driver, test, AuthMana_Report_IssueDateTo, "Clicking on Issue Date To :");
			dateOfMonthName(driver, test, "Selecting Issue Date To :", IssueDateTo);
		}
		if(ExpiryDateFrom.length() > 0) {
			clickElement(driver, test, AuthMana_Report_ExpiryDateFrom, "Clicking on Expiry Date From :");
			dateOfMonthName(driver, test, "Selecting Expiry Date From :", ExpiryDateFrom);
		}
		if(ExpiryDateTo.length() > 0) {
			clickElement(driver, test, AuthMana_Report_ExpiryDateTo, "Clicking on Expiry Date To :");
			dateOfMonthName(driver, test, "Selecting Expiry Date To :", ExpiryDateTo);
		}
		if(CloseOutDateFrom.length() > 0) {
			clickElement(driver, test, AuthMana_Report_CloseOutDateFrom, "Clicking on Close Out Date From :");
			dateOfMonthName(driver, test, "Selecting Close Out Date From :", CloseOutDateFrom);
		}
		if(CloseOutDateTo.length() > 0) {
			clickElement(driver, test, AuthMana_Report_CloseOutDateTo, "Clicking on Close Out Date To :");
			dateOfMonthName(driver, test, "Selecting Close Out Date To :", CloseOutDateTo);
		}
		if(Programme.length() > 0) {
			clickElement(driver, test, AuthMana_Report_Program, "Clicking on Programme :");
			try {
				Wait.waitfor(3);
				typeText(driver, test, AuthMana_Report_programCodePopUp, "Entering Transaction ID :", Programme);
				Wait.waitfor(3);
				clickElement(driver, test, AuthMana_Report_SearchPopUp, "Clicking on Search Tab :");
				Wait.waitfor(3);
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Programme+"')]", "Selecting Programme Code :");
				Wait.waitfor(3);
				clickElement(driver, test, AuthMana_Report_SelectPopUp, "Clicking on Select tab :");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			typeText(driver, test, AuthMana_Report_programTab, "Entering Programme Code :", Programme);
		}
		if(Segment.length() > 0) {
			clickElement(driver, test, AuthMana_Report_Segment, "Clicking on Segment");
			try {
				Wait.waitfor(3);
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Segment+"')]", "Selecting Segment Code");
				Wait.waitfor(3);
				clickElement(driver, test, AuthMana_Report_SelectPopUp, "Clicking on Select tab");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			typeText(driver, test, AuthMana_Report_segmentCode, "Entering Segment Code", Segment);
		}
		if(Site.length() > 0) {
			clickElement(driver, test, AuthMana_Report_Site, "Clicking on Site :");
			try {
				Wait.waitfor(3);
				typeText(driver, test, AuthMana_Report_SiteID, "Entering Site ID :", Site);
				Wait.waitfor(3);
				clickElement(driver, test, AuthMana_Report_SearchPopUp, "Clicking on Search Tab :");
				Wait.waitfor(3);
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Site+"')]", "Selecting Site :");
				Wait.waitfor(3);
				clickElement(driver, test, AuthMana_Report_SelectPopUp, "Clicking on Select tab");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			typeText(driver, test, AuthMana_Report_SiteTextBox, "Entering Site :", Site);
		}
		if(Department.length() > 0) {
			clickElement(driver, test, AuthMana_Report_Department, "Clicking on Department :");
			try {
				Wait.waitfor(3);
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Department+"')]", "Selecting Department :");
				Wait.waitfor(3);
				clickElement(driver, test, AuthMana_Report_SelectPopUp, "Clicking on Select tab");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			typeText(driver, test, AuthMana_Report_DepartmentTextbox, "Entering Department :", Department);
		}
		if(ProductLine.length() > 0) {
			clickElement(driver, test, AuthMana_Report_prodLine, "Clicking on Transaction ID");
			try {
				Wait.waitfor(3);
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ProductLine+"')]", "Selecting Product Line");
				Wait.waitfor(3);
				clickElement(driver, test, AuthMana_Report_SelectPopUp, "Clicking on Select tab");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			typeText(driver, test, AuthMana_Report_prodLine, "Entering ProdLine", ProductLine);
		}
		if(ProductFamily.length() > 0) {
			clickElement(driver, test, AuthMana_Report_ProductFamily, "Clicking on Product Family");
			try {
				Wait.waitfor(3);
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ProductFamily+"')]", "Selecting Product Family");
				Wait.waitfor(3);
				clickElement(driver, test, AuthMana_Report_SelectPopUp, "Clicking on Select tab");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			typeText(driver, test, AuthMana_Report_prodFamilyTextbox, "Entering ProdFamily", ProductFamily);
		}
		if(AuthorizationOwner.length() > 0) {
			clickElement(driver, test, AuthMana_Report_AuthorizationOwner, "Clicking on Authorization Owner :");
			try {
				Wait.waitfor(3);
				typeText(driver, test, AuthMana_Report_OwnerFirstName, "Entering Authorization Owner :", AuthorizationOwner);
				Wait.waitfor(3);
				clickElement(driver, test, AuthMana_Report_SearchPopUp, "Clicking on Search Tab :");
				Wait.waitfor(3);
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+AuthorizationOwner+"')]", "Selecting AuthorizationOwner :");
				Wait.waitfor(3);
				clickElement(driver, test, AuthMana_Report_SelectPopUp, "Clicking on Select tab");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			typeText(driver, test, AuthMana_Report_AuthorizationOwner, "Entering AuthorizationOwner :", AuthorizationOwner);
		}
		typeText(driver, test, AuthMana_Report_licenseManager, "Entering license Manager :", licenseManager);
		if(LicenseRequester.length() > 0) {
			clickElement(driver, test, AuthMana_Report_LicenseRequestor, "Clicking on License Requester :");
			try {
				Wait.waitfor(3);
				typeText(driver, test, AuthMana_Report_UserFirstName, "Entering License Requester :", LicenseRequester);
				Wait.waitfor(3);
				clickElement(driver, test, AuthMana_Report_SearchPopUp, "Clicking on Search Tab :");
				Wait.waitfor(3);
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+LicenseRequester+"')]", "Selecting License Requester :");
				Wait.waitfor(3);
				clickElement(driver, test, AuthMana_Report_SelectPopUp, "Clicking on Select tab");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			typeText(driver, test, AuthMana_Report_licenseRequestorTextbox, "Entering License Requester :", LicenseRequester);
		}
		if(Reviewer.length() > 0) {
			clickElement(driver, test, AuthMana_Report_Reviewer, "Clicking on Reviewer :");
			try {
				Wait.waitfor(3);
				typeText(driver, test, AuthMana_Report_UserFirstName, "Entering Reviewer :", Reviewer);
				Wait.waitfor(3);
				clickElement(driver, test, AuthMana_Report_SearchPopUp, "Clicking on Search Tab :");
				Wait.waitfor(3);
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Reviewer+"')]", "Selecting Reviewer :");
				Wait.waitfor(3);
				clickElement(driver, test, AuthMana_Report_SelectPopUp, "Clicking on Select tab");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			typeText(driver, test, AuthMana_Report_ReviewerTextbox, "Entering Reviewer :", Reviewer);
		}
		if(PreparedBy.length() > 0) {
			clickElement(driver, test, AuthMana_Report_PreparedBy, "Clicking on Prepared By :");
			try {
				Wait.waitfor(3);
				typeText(driver, test, AuthMana_Report_UserFirstName, "Entering Prepared By :", PreparedBy);
				Wait.waitfor(3);
				clickElement(driver, test, AuthMana_Report_SearchPopUp, "Clicking on Search Tab :");
				Wait.waitfor(3);
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+PreparedBy+"')]", "Selecting Prepared By :");
				Wait.waitfor(3);
				clickElement(driver, test, AuthMana_Report_SelectPopUp, "Clicking on Select tab");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			typeText(driver, test, AuthMana_Report_PreparedByTextbox, "Entering Prepared By :", PreparedBy);
		}
		if(CorparateREP.length() > 0) {
			clickElement(driver, test, AuthMana_Report_CorporateRep, "Clicking on Corparate REP :");
			try {
				Wait.waitfor(3);
				typeText(driver, test, AuthMana_Report_UserFirstName, "Entering Corparate REP :", CorparateREP);
				Wait.waitfor(3);
				clickElement(driver, test, AuthMana_Report_SearchPopUp, "Clicking on Search Tab :");
				Wait.waitfor(3);
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+CorparateREP+"')]", "Selecting Corparate REP :");
				Wait.waitfor(3);
				clickElement(driver, test, AuthMana_Report_SelectPopUp, "Clicking on Select tab");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			typeText(driver, test, AuthMana_Report_CorporateRepTextbox, "Entering Corparate REP :", CorparateREP);
		}
		if(EmpoweredOfficial.length() > 0) {
			clickElement(driver, test, AuthMana_Report_EmpoweredOfficial, "Clicking on Empowered Official :");
			try {
				Wait.waitfor(3);
				typeText(driver, test, AuthMana_Report_EOUserFirstName, "Entering Empowered Official :", EmpoweredOfficial);
				Wait.waitfor(3);
				clickElement(driver, test, AuthMana_Report_SearchPopUp, "Clicking on Search Tab :");
				Wait.waitfor(3);
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+EmpoweredOfficial+"')]", "Selecting Empowered Official :");
				Wait.waitfor(3);
				clickElement(driver, test, AuthMana_Report_SelectPopUp, "Clicking on Select tab");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			typeText(driver, test, AuthMana_Report_EmpoweredOfficerTextbox, "Entering Empowered Official :", EmpoweredOfficial);
		}
	}
}