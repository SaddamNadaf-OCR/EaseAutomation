package authorizationManagementClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;
import utilities.Wait;

public class SearchSublicenseeSummaryReportPage extends GenericMethods{
	
	public static WebDriver driver;
	public static ExtentTest test;
	
	//..................................Locators........................................//
	public static final String AuthMana_Report_Search="(//button[contains(text(),'Search')])[1]";
	public static final String AuthMana_Report_Reset="(//button[contains(text(),'Reset')])[1]";
	public static final String AuthMana_Report_SbuCode="//select[@name='dosGeneralInfo.sbuCode']";
	public static final String AuthMana_Report_AgreementNo="//input[@name='dosGeneralInfo.licenseNo']";
	public static final String AuthMana_Report_TransactionID="//input[@name='dosGeneralInfo.transactionId']";
	public static final String AuthMana_Report_AuthOwner="//input[@name='licenseReviewValue.curLicOwner']";
	public static final String AuthMana_Report_licPoc="//input[@name='licenseReviewValue.licPoc']";
	public static final String AuthMana_Report_NDAName="//input[@name='subLicenseDetailsValue.name']";
	public static final String AuthMana_Report_NDACompany="//input[@name='subLicenseDetailsValue.company']";
	public static final String AuthMana_Report_NDADatesFrom="//input[@name='ndaDatesFrom']";
	public static final String AuthMana_Report_ndaDatesTo="//input[@name='ndaDatesTo']";
	public static final String AuthMana_Report_dateSignedFrom="//input[@name='dateSignedFrom']";
	public static final String AuthMana_Report_dateSignedTo="//input[@name='dateSignedTo']";
	public static final String AuthMana_Report_ReviewerName="//input[@name='dosGeneralInfo.reviewer']";
	public static final String AuthMana_Report_ProductLine="//a[contains(text(),'Product Line')]";
	public static final String AuthMana_Report_SelectPopUp="//button[contains(text(),'Select')]";
	public static final String AuthMana_Report_prodLine="//textarea[@name='dosGeneralInfo.prodLine']";
	public static final String AuthMana_Report_NDAReqCeckBox="//input[@name='ndaRequired']";
	public static final String AuthMana_Report_NDAReceivedCheckbox="//input[@name='ndaReceived']";
	public static final String AuthMana_Report_ProductFamily="//a[contains(text(),'Product Family')]";
	public static final String AuthMana_Report_prodFamily="//textarea[@name='dosGeneralInfo.prodFamily']";
	public static final String AuthMana_Report_AuthorizationType="//select[@name='dosGeneralInfo.applFormType']";
	public static final String AuthMana_Report_SortBy="(//select[@name='sortBy'])[1]";
	public static final String AuthMana_Report_direction="(//select[@name='direction'])[1]";
	
	//..................................Constructors..................................//
	public SearchSublicenseeSummaryReportPage(WebDriver driver,ExtentTest test) {
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
	
	//................................Search By Parameters ...............................//
	public void searchBYSBUCode(String SBUCode, String AgreementNo, String TransactionID, String AuthorizationOwner,
			String LicensePOC, String NDAName, String NDACompany, String ndadateFrom, String ndadateTo, String dateSignedFrom,
			String dateSignedTo, String ReviewerName, String ProductLine, String ProductFamily, String AuthType, String SortBy,
			String direction) {
		
		selectByVisibleText(driver, test, AuthMana_Report_SbuCode, "Selecting SBU Code", SBUCode);
		typeText(driver, test, AuthMana_Report_AgreementNo, "Entering Agreement No", AgreementNo);
		typeText(driver, test, AuthMana_Report_TransactionID, "Entering Transaction ID", TransactionID);
		typeText(driver, test, AuthMana_Report_AuthOwner, "Entering Authorization Owner", AuthorizationOwner);
		typeText(driver, test, AuthMana_Report_licPoc, "Entering License POC", LicensePOC);
		typeText(driver, test, AuthMana_Report_NDAName, "Entering NDA Name", NDAName);
		typeText(driver, test, AuthMana_Report_NDACompany, "Entering NDA Company", NDACompany);
		if(ndadateFrom.length() > 0) {
			clickElement(driver, test, AuthMana_Report_NDADatesFrom, "Cliking on NDA Dates From");
			dateOfMonthName(driver, test, "Selecting NDA Dates", ndadateFrom);
		}
		if(ndadateTo.length() > 0) {
			clickElement(driver, test, AuthMana_Report_ndaDatesTo, "Cliking on NDA Dates From");
			dateOfMonthName(driver, test, "Selecting NDA Dates", ndadateTo);
		}
		if(dateSignedFrom.length() > 0) {
			clickElement(driver, test, AuthMana_Report_dateSignedFrom, "Cliking on NDA Dates From");
			dateOfMonthName(driver, test, "Selecting NDA Dates", dateSignedFrom);
		}
		if(dateSignedTo.length() > 0) {
			clickElement(driver, test, AuthMana_Report_dateSignedTo, "Cliking on NDA Dates From");
			dateOfMonthName(driver, test, "Selecting NDA Dates", dateSignedTo);
		}
		typeText(driver, test, AuthMana_Report_ReviewerName, "Entering Reviewer Name", ReviewerName);
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
			typeText(driver, test, AuthMana_Report_prodFamily, "Entering ProdFamily", ProductFamily);
		}
		selectByVisibleText(driver, test, AuthMana_Report_AuthorizationType, "Selecting Authorization Type", AuthType);
		selectByVisibleText(driver, test, AuthMana_Report_SortBy, "Selecting SortBy", SortBy);
		selectByVisibleText(driver, test, AuthMana_Report_direction, "Selecting direction", direction);
	}	
}
