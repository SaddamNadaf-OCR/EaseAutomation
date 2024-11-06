package authorizationManagementClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;
import utilities.Wait;

public class SearchAgreementReportsPage extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;
	
	//...................................Locators.......................................//
	public static final String USGAR_Search="//button[contains(text(),'Search')]";
	public static final String USGAR_AddAgrimentReport="(//button[contains(text(),'Add Agreement Report')])[1]";
	public static final String USGAR_Reset="//button[contains(text(),'Reset')]";
	public static final String USGAR_SBU="//select[@name='agreementReports.sbuCode']";
	public static final String USGAR_AgrimentNoPopUp="//label[contains(text(),'Agreement Type')] ";
	public static final String USGAR_SearchPopUp="(//button[contains(text(),'Search')])[3]";
	public static final String USGAR_SelectPopUp="(//button[contains(text(),'Select')])[1]";
	public static final String USGAR_ClosePopUp="//button[@class='btn-close']";
	public static final String USGAR_AgrimentNo="//input[@name='agreementReports.agreementNo']";
	public static final String USGAR_TransactionID="//input[@name='agreementReports.transactionId']";
	public static final String USGAR_AgreementType="//select[@name='agreementReports.agreementType']";
	public static final String USGAR_usgStatus="//select[@name='agreementReports.usgStatus']";
	public static final String USGAR_fromUsgReportDate="//input[@name='fromUsgReportDate']";
	public static final String USGAR_toUsgReportDate="//input[@name='toUsgReportDate']";
	public static final String USGAR_AnnualStatusReportCompleted="//input[@name='msr']";
	public static final String USGAR_AgreementNonConcludedReportCompleted="//input[@name='mncr']";
	public static final String USGAR_AgreementConformedReportCompleted="//input[@name='cr']";
	public static final String USGAR_MLAConformedReportCompleted="//input[@name='mcr']";
	public static final String USGAR_AgreementAmendmentReportCompleted="//input[@name='ar']";
	public static final String USGAR_AgreementTerminationReportCompleted="//input[@name='atc']";
	public static final String USGAR_EmpoweredOfficial="//input[@name='agreementReports.empoweredOfficial']";
	public static final String USGAR_sortBy="//select[@name='sortBy']";
	public static final String USGAR_direction="//select[@name='direction']";
	
	//.................................Constructor.....................................//
	public SearchAgreementReportsPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;		
	}
	
	//...............................Search Tab.......................................//
	public void search() {
		clickElement(driver, test, USGAR_Search, "Clicking on Search Tab");
	}
	
	//..............................Add Agreement Report...........................//
	public void addagreementreport() {
		clickElement(driver, test, USGAR_AddAgrimentReport, "Clicking on Add Agreement Report");
	}
	
	//................................Reset Tab.....................................//
	public void reset() {
		clickElement(driver, test, USGAR_Reset, "Clicking on Reset Button");
	}
	
	//.............................Search By SBU .................................//
	public void searchBYParameters(String sbu,String agreementNo,String transactionNo, String AgreementType, String USGStatus,
			String ReportDateFrom, String ReportDateTo, String AnnualStatusReport, String AgreementNonConclude, String AgreementConfirmed, String MLAConfirmed, String AgreementAmendment, String AgreementTermination, String EmpoweredOfficial, String SortBy, String Direction) {
		selectByVisibleText(driver, test, USGAR_SBU, "Selecting the SBU", sbu);
		if(agreementNo.length() > 0) {
			clickElement(driver, test, USGAR_AgrimentNoPopUp, "Clicking on Agreement PopUp :");
			try {
				clickElement(driver, test, USGAR_SearchPopUp, "Clickinh Search in PopUp :");
				Wait.waitfor(2);
				selectByVisibleText(driver, test, "//td[contains(text(),'"+agreementNo+"')]", "Selecting the Data From Table :", agreementNo);
				Wait.waitfor(2);
				clickElement(driver, test, USGAR_SelectPopUp, "Clicking on Select From PopUp :");
			} catch (Exception e) {
				clickElement(driver, test, USGAR_ClosePopUp, "Click on Close PopUp :");
			}
		}else {
			typeText(driver, test, USGAR_AgrimentNo, "Typing Agreement Number", agreementNo);
		}
		typeText(driver, test, USGAR_TransactionID, "Typing Transaction Number", transactionNo);
		selectByVisibleText(driver, test, USGAR_AgreementType, "Selecting Agreement Type :", AgreementType);
		selectByVisibleText(driver, test, USGAR_usgStatus, "Selecting USG Status :", USGStatus);
		clickElement(driver, test, USGAR_fromUsgReportDate, "Clicking on Report Date From :");
		dateOfMonthName(driver, test, "Selecting Report Date :", ReportDateFrom);
		clickElement(driver, test, USGAR_toUsgReportDate, "Clicking on Report Date To :");
		dateOfMonthName(driver, test, "Selecting Report Date To :", ReportDateTo);
		if(AnnualStatusReport.contains("y")) {
			clickElement(driver, test, USGAR_AnnualStatusReportCompleted, "Clicking on Check Box :");
		}else {
			
		}
		if(AgreementNonConclude.contains("y")) {
			clickElement(driver, test, USGAR_AgreementNonConcludedReportCompleted, "Clicking on Check Box :");
		}else {
			
		}
		if(AgreementConfirmed.contains("y")) {
			clickElement(driver, test, USGAR_AgreementConformedReportCompleted, "Clicking on Check Box :");
		}else {
			
		}
		if(MLAConfirmed.contains("y")) {
			clickElement(driver, test, USGAR_MLAConformedReportCompleted, "Clicking on Check Box :");
		}else {
			
		}
		if(AgreementAmendment.contains("y")) {
			clickElement(driver, test, USGAR_AgreementAmendmentReportCompleted, "Clicking on Check Box :");
		}else {
			
		}
		if(AgreementTermination.contains("y")) {
			clickElement(driver, test, USGAR_AgreementTerminationReportCompleted, "Clicking on Check Box :");
		}else {
			
		}
		typeText(driver, test, USGAR_EmpoweredOfficial, "Entering Empowered Official :", EmpoweredOfficial);
		selectByVisibleText(driver, test, USGAR_sortBy, "Selecting Sort By :", SortBy);
		selectByVisibleText(driver, test, USGAR_direction, "Selecting Direction :", Direction);
	}
	
}
