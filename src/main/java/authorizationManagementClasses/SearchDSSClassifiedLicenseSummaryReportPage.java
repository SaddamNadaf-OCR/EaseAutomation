package authorizationManagementClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class SearchDSSClassifiedLicenseSummaryReportPage extends GenericMethods{
	
	public static WebDriver driver;
	public static ExtentTest test;
	
	//..................................Locators........................................//
	public static final String AuthMana_Report_Search="(//button[contains(text(),'Search')])[1]";
	public static final String AuthMana_Report_Reset="(//button[contains(text(),'Reset')])[1]";
	public static final String AuthMana_Report_SbuCode="//select[@name='dosGeneralInfo.sbuCode']";
	public static final String AuthMana_Report_AuthorizationType ="//select[@name='dosGeneralInfo.applFormType']";
	public static final String AuthMana_Report_AgreementNo="//input[@name='dosGeneralInfo.licenseNo']";
	public static final String AuthMana_Report_TransactionID="//input[@name='dosGeneralInfo.transactionId']";
	public static final String AuthMana_Report_AuthorizationOwner="//input[@name='licenseReviewValue.curLicOwner']";
	public static final String AuthMana_Report_LicensePOC ="//input[@name='licenseReviewValue.licPoc']";
	public static final String AuthMana_Report_ForeignParty="//input[@name='dosLicenseConsigneeValue.consigneeName']";
	public static final String AuthMana_Report_usgApprFrom="//input[@name='usgApprFrom']";
	public static final String AuthMana_Report_usgApprTo="//input[@name='usgApprTo']";
	public static final String AuthMana_Report_ClassificationLevel="//select[@name='securityClassification']";
	public static final String AuthMana_Report_ProductLine="//a[contains(text(),'Product Line')]";
	public static final String AuthMana_Report_SearchPopUp="//button[@id='searchAgreementNoPopUp']";
	public static final String AuthMana_Report_SelectPopUp="//button[contains(text(),'Select')]";
	public static final String AuthMana_Report_Closepopup = "(//button[@class='btn-close'])[1]";
	public static final String AuthMana_Report_prodLine="//textarea[@name='dosGeneralInfo.prodLine']";
	public static final String AuthMana_Report_ProductFamily="//a[contains(text(),'Product Family')]";
	public static final String AuthMana_Report_prodFamily="//textarea[@name='dosGeneralInfo.prodFamily']";
	public static final String AuthMana_Report_SortBy="(//select[@name='sortBy'])[1]";
	public static final String AuthMana_Report_direction="(//select[@name='direction'])[1]";
		
	
	//..................................Constructors..................................//
	public SearchDSSClassifiedLicenseSummaryReportPage(WebDriver driver,ExtentTest test) {
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
	public void searchByAllParameters(String SBUCode, String AuthorizationType, String AgreementNo, String TransactionID, 
			String AthorizationOwner, String LicensePOC, String ForeignParty, String USGAppDateFrom, String USGAppDateTo, 
			String ClassifiedLevel, String ProductLine, String ProductLFamily, String SortBy, String direction) {
		
		selectByVisibleText(driver, test, AuthMana_Report_SbuCode, "Selecting SBU Code", SBUCode);
		selectByVisibleText(driver, test, AuthMana_Report_AuthorizationType, "Selecting Authorization Type :", AuthorizationType);
		typeText(driver, test, AuthMana_Report_AgreementNo, "Entering Agreement No :", AgreementNo);
		typeText(driver, test, AuthMana_Report_TransactionID, "Entering Transaction Id", TransactionID);
		typeText(driver, test, AuthMana_Report_AuthorizationOwner, "Entering Athorization Owner :", AthorizationOwner);
		typeText(driver, test, AuthMana_Report_LicensePOC, "Entering License POC :", LicensePOC);
		typeText(driver, test, AuthMana_Report_ForeignParty, "Entering Foreign Party :", ForeignParty);
		if(USGAppDateFrom.length() > 0) {
			clickElement(driver, test, AuthMana_Report_usgApprFrom, "Clicking on USG App Form :");
			dateOfMonthName(driver, test, "Selecting USG App Date From :", USGAppDateFrom);
		}
		if(USGAppDateTo.length() > 0) {
			clickElement(driver, test, AuthMana_Report_usgApprTo, "Clicking on USG App Date To :");
			dateOfMonthName(driver, test, "Selecting USG App Date To :", USGAppDateTo);
		}
		selectByVisibleText(driver, test, AuthMana_Report_ClassificationLevel, "Selecting Classified Level :", ClassifiedLevel);
		if(ProductLine.length() > 0) {
			clickElement(driver, test, AuthMana_Report_ProductLine, "Clicking on Product Line ID");
			try {
				Wait.waitfor(3);
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ProductLine+"')]", "Selecting Product Line");
				Wait.waitfor(3);
				clickElement(driver, test, AuthMana_Report_SelectPopUp, "Clicking on Select tab");
			} catch (Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, AuthMana_Report_Closepopup, "CLicking on Close Popup :");
			}
		}else {
			typeText(driver, test, AuthMana_Report_prodLine, "Entering ProdLine", ProductLine);
		}
		if(ProductLFamily.length() > 0) {
			clickElement(driver, test, AuthMana_Report_ProductFamily, "Clicking on ProductL Family :");
			try {
				Wait.waitfor(3);
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ProductLFamily+"')]", "Selecting Product Family");
				Wait.waitfor(3);
				clickElement(driver, test, AuthMana_Report_SelectPopUp, "Clicking on Select tab");
			} catch (Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, AuthMana_Report_Closepopup, "CLicking on Close Popup :");
			}
		}else {
			typeText(driver, test, AuthMana_Report_prodFamily, "Entering ProductL Family", ProductLFamily);
		}
		selectByVisibleText(driver, test, AuthMana_Report_SortBy, "Selecting SortBy", SortBy);
		selectByVisibleText(driver, test, AuthMana_Report_direction, "Selecting direction", direction);
	}
}