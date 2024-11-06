package authorizationManagementClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;
import utilities.Wait;

public class Search3rdCountryDualNationalSummaryReportPage extends GenericMethods{
	
	public static WebDriver driver;
	public static ExtentTest test;
	
	//..................................Locators........................................//
	public static final String AuthMana_Report_Search="//button[contains(text(),'Search')]";
	public static final String AuthMana_Report_Reset="//button[contains(text(),'Reset')]";
	public static final String AuthMana_Report_SbuCode="//select[@name='dosGeneralInfo.sbuCode']";
	public static final String AuthMana_Report_AgreementNo="//input[@name='dosGeneralInfo.licenseNo']";
	public static final String AuthMana_Report_TransactionId="//input[@name='dosGeneralInfo.transactionId']";
	public static final String AuthMana_Report_AuthOwner="//input[@name='licenseReviewValue.curLicOwner']";
	public static final String AuthMana_Report_licencePoc="//input[@name='licenseReviewValue.licPoc']";
	public static final String AuthMana_Report_NDAName="//input[@name='subLicenseDetailsValue.name']";
	public static final String AuthMana_Report_NDAcompany="//input[@name='subLicenseDetailsValue.company']";
	public static final String AuthMana_Report_NDADatesFrom="//input[@name='ndaDatesFrom']";
	public static final String AuthMana_Report_NDADatesTo="//input[@name='ndaDatesTo']";
	public static final String AuthMana_Report_ReviewerName="//input[@name='dosGeneralInfo.reviewer']";
	public static final String AuthMana_Report_ProductLine="//a[contains(text(),'Product Line')]";
	public static final String AuthMana_Report_SelectPopUp="//button[@name='Ok']";
	public static final String AuthMana_Report_cancelPopUp="//button[@name='cancel']";
	public static final String AuthMana_Report_prodLineTextbox="//textarea[@name='dosGeneralInfo.prodLine']";
	public static final String AuthMana_Report_ProductFamily="//a[contains(text(),'Product Family')]";
	public static final String AuthMana_Report_prodFamilyTextBox="//textarea[@name='dosGeneralInfo.prodFamily']";
	public static final String AuthMana_Report_AuthType="//select[@name='dosGeneralInfo.applFormType']";
	public static final String AuthMana_Report_sortBy="//select[@name='sortBy']";
	public static final String AuthMana_Report_direction="//select[@name='direction']";
	
	
	//..................................Constructors..................................//
	public Search3rdCountryDualNationalSummaryReportPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	//..................................Click on Search Tab ...........................//
	public void search() {
		clickElement(driver, test, AuthMana_Report_Search, "Clicking on Search Tab");
	}
	
	//..................................Click on Reset Tab ...........................//
	public void reset() {
		clickElement(driver, test, AuthMana_Report_Reset, "Clicking on Search Tab");
	}
		
	//..................................Search By All Parameters ...........................//
	public void searchParameters(String sbuCode, String AgreementNo, String TransactionId, String AuthOwner, String licencePoc,
			String NDAName, String NDAcompany, String NDADatesFrom, String NDADatesTo, String ReviewerName, String producrLineID,
			String ProductFamily, String AuthType, String SortBy, String Direction) {
		
		selectByVisibleText(driver, test, AuthMana_Report_SbuCode, "Selecting SBU Code From DropDown", sbuCode);
		typeText(driver, test, AuthMana_Report_AgreementNo, "Entering Agreement No", AgreementNo);
		typeText(driver, test, AuthMana_Report_TransactionId, "Entering Transaction Id", TransactionId);
		typeText(driver, test, AuthMana_Report_AuthOwner, "Entering Authorization Owner", AuthOwner);
		typeText(driver, test, AuthMana_Report_licencePoc, "Entering licence Poc", licencePoc);
		typeText(driver, test, AuthMana_Report_NDAName, "Entering NDA Name", NDAName);
		typeText(driver, test, AuthMana_Report_NDAcompany, "Entering NDA company", NDAcompany);
		if(NDADatesFrom.length() > 0) {
			clickElement(driver, test, AuthMana_Report_NDADatesFrom, "Clicking on NDA Dates From");
			dateOfMonthName(driver, test, "Selecting NDA Dates From :", NDADatesFrom);
		}
		if(NDADatesTo.length() > 0) {
			clickElement(driver, test, AuthMana_Report_NDADatesTo, "Clicking on NDA Dates To");
			dateOfMonthName(driver, test, "Selecting NDA Dates To :", NDADatesTo);
		}
		typeText(driver, test, AuthMana_Report_ReviewerName, "Entering Reviewer Name", ReviewerName);
		if(producrLineID.length() > 0) {
			clickElement(driver, test, AuthMana_Report_ProductLine, "Clicking on Product Line");
			try {
				Wait.waitfor(3);
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+producrLineID+"')]", "Selecting Product Line ID");
				Wait.waitfor(3);
				clickElement(driver, test, AuthMana_Report_SelectPopUp, "Clicking on Select Tab");
				Wait.waitfor(3);
			} catch (Exception e) {
				e.printStackTrace();
				testFailSshot(driver, test);
				clickElement(driver, test, AuthMana_Report_cancelPopUp, "Clicking on Cancel Tab");
		}
		}else {
			typeText(driver, test, AuthMana_Report_prodLineTextbox, "Entering ProductLine Id", producrLineID);
		}
		if(ProductFamily.length() > 0) {
			clickElement(driver, test, AuthMana_Report_ProductFamily, "Clicking on Product Family");
			try {
				Wait.waitfor(3);
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ProductFamily+"')]", "Selecting Product Family ID");
				Wait.waitfor(3);
				clickElement(driver, test, AuthMana_Report_SelectPopUp, "Clicking on Select Tab");
				Wait.waitfor(3);
			} catch (Exception e) {
				e.printStackTrace();
				testFailSshot(driver, test);
				clickElement(driver, test, AuthMana_Report_cancelPopUp, "Clicking on Cancel Tab");
			}
		}else {
			typeText(driver, test, AuthMana_Report_prodFamilyTextBox, "Entering Product Family Id", ProductFamily);
		}
		selectByVisibleText(driver, test, AuthMana_Report_AuthType, "Selecting Authorization Type From DropDown", AuthType);
		selectByVisibleText(driver, test, AuthMana_Report_sortBy, "Selecting Sort By From DropDown", SortBy);
		selectByVisibleText(driver, test, AuthMana_Report_direction, "Selecting SBU Code From DropDown", Direction);
		}
}
