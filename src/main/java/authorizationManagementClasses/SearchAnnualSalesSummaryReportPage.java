package authorizationManagementClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class SearchAnnualSalesSummaryReportPage extends GenericMethods{
	
	public static WebDriver driver;
	public static ExtentTest test;
	
	//..................................Locators........................................//
	public static final String AuthMana_Report_Search="(//button[contains(text(),'Search')])[1]";
	public static final String AuthMana_Report_Reset="(//button[contains(text(),'Reset')])[1]";
	public static final String AuthMana_Report_SbuCode="//select[@name='dosGeneralInfo.sbuCode']";
	public static final String AuthMana_Report_TransactionID="//a[contains(text(),'Transaction ID')]";
	public static final String AuthMana_Report_TransactionIDPopup="//input[@name='dosGeneralInfoDTO.transactionId']";
	public static final String AuthMana_Report_SearchPopUp="//button[@id='searchAgreementNoPopUp']";
	public static final String AuthMana_Report_SelectPopUp="//button[contains(text(),'Select')]";
	public static final String AuthMana_Report_TransactionIDTextBox="//input[@name='dosGeneralInfo.transactionId']";
	public static final String AuthMana_Report_AuthType="//select[@name='dosGeneralInfo.applFormType']";
	public static final String AuthMana_Report_Status="//select[@name='dosGeneralInfo.status']";
	public static final String AuthMana_Report_SalesreportType="//select[@name='mlaSalesReportValue.reportType']";
	public static final String AuthMana_Report_AgreementNumber="//a[contains(text(),'Agreement Number')]";
	public static final String AuthMana_Report_AgreementNoTextbox="//input[@name='dosGeneralInfo.licenseNo']";
	public static final String AuthMana_Report_specialExportProgram="//select[@name='dosGeneralInfo.specialExportProgram']";
	public static final String AuthMana_Report_Programme="(//a[contains(text(),'Programme')])[2]";
	public static final String AuthMana_Report_programCodePopUp="//input[@name='programTab.programCode']";
	public static final String AuthMana_Report_SearchPopUPP="(//button[contains(text(),'Search')])[2]";
	public static final String AuthMana_Report_programTab="//textarea[@name='dosGeneralInfo.programTab']";
	public static final String AuthMana_Report_POC="//a[contains(text(),'POC')]";
	public static final String AuthMana_Report_POCTextBox="//input[@name='mlaSalesReportValue.mlaPoc']";
	public static final String AuthMana_Report_UserFirstName="//input[@name='userProfile.userFirstname']";
	public static final String AuthMana_Report_Segment="(//a[contains(text(),'Segment')])[2]";
	public static final String AuthMana_Report_segmentCode="//textarea[@name='dosGeneralInfo.segmentCode']";
	public static final String AuthMana_Report_Company="//a[contains(text(),'Company')]";
	public static final String AuthMana_Report_CompanyTextBox="//input[@name='mlaSalesReportValue.company']";
	public static final String AuthMana_Report_NamePopUp="//input[@name='consignee.consigneeName']";
	public static final String AuthMana_Report_ProductLine="//a[contains(text(),'Product Line')]";
	public static final String AuthMana_Report_prodLine="//textarea[@name='dosGeneralInfo.prodLine']";
	public static final String AuthMana_Report_ProductFamily="//a[contains(text(),'Product Family')]";
	public static final String AuthMana_Report_prodFamily="//textarea[@name='dosGeneralInfo.prodFamily']";
	public static final String AuthMana_Report_Relatedtoadisclosure="//select[@name='dtcCompliance']";
	public static final String AuthMana_Report_amended="//select[@name='amended']";
	public static final String AuthMana_Report_agreementType="//select[@name='agreementType']";
	public static final String AuthMana_Report_rebaselined="//select[@name='rebaselined']";
	public static final String AuthMana_Report_agreementExecutedDateFrom="//input[@name='agreementExecutedDateFrom']";
	public static final String AuthMana_Report_agreementExecutedDateTo="//input[@name='agreementExecutedDateTo']";	
	public static final String AuthMana_Report_reportReceivedCeckBox="//input[@name='mlaSalesReportValue.reportReceived']";
	public static final String AuthMana_Report_reportedToUsgCheckBox="//input[@name='mlaSalesReportValue.reportedToUsg']";
	public static final String AuthMana_Report_reportYear="//input[@name='reportYear']";
	public static final String AuthMana_Report_reportDateFrom="//input[@name='reportDateFrom']";
	public static final String AuthMana_Report_reportDateTo="//input[@name='reportDateTo']";
	public static final String AuthMana_Report_SortBy="(//select[@name='sortBy'])[1]";
	public static final String AuthMana_Report_direction="(//select[@name='direction'])[1]";
	
	//..................................Constructors..................................//
	public SearchAnnualSalesSummaryReportPage(WebDriver driver,ExtentTest test) {
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
	public void searchBYParameters(String SBUCode, String TransactionID, String AuthorizationType, String Status,
		String SalesreportType, String AgreementNumber, String specialExportProgram, String Programme, String Poc,
		String Segment, String Company, String ProductLine, String ProductFamily, String RelatedToDisclosure, String Amended, String AgreementType, 
		String Rebeselined, String AgreementExecuteDateFrom, String AgreementExecuteDateTo, String SalesReportYear,
		String reportDateFrom, String reportDateTo, String SortBy, String direction) {
	
	selectByVisibleText(driver, test, AuthMana_Report_SbuCode, "Selecting SBU Code", SBUCode);
	if(TransactionID.length() > 0) {
		clickElement(driver, test, AuthMana_Report_TransactionID, "Clicking on Transaction ID");
		try {
			Wait.waitfor(3);
			typeText(driver, test, AuthMana_Report_TransactionIDPopup, "Entering Transaction ID", TransactionID);
			Wait.waitfor(3);
			clickElement(driver, test, AuthMana_Report_SearchPopUp, "Clicking on Search Tab");
			Wait.waitfor(3);
			mouseOverAndClick(driver, test, "//td[contains(text(),'"+TransactionID+"')]", "Selecting Transaction ID");
			Wait.waitfor(3);
			clickElement(driver, test, AuthMana_Report_SelectPopUp, "Clicking on Select tab");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}else {
	typeText(driver, test, AuthMana_Report_TransactionIDTextBox, "Entering Transaction Id", TransactionID);
	}
	selectByVisibleText(driver, test, AuthMana_Report_AuthType, "Selecting Authorization Type", AuthorizationType);
	selectByVisibleText(driver, test, AuthMana_Report_Status, "Selecting Status", Status);
	selectByVisibleText(driver, test, AuthMana_Report_SalesreportType, "Selecting SBU Code", SalesreportType);
	if(AgreementNumber.length() > 0) {
		clickElement(driver, test, AuthMana_Report_AgreementNumber, "Clicking on Agreement Number");
		try {
			Wait.waitfor(3);
			typeText(driver, test, "//input[@name='dosGeneralInfoDTO.licenseNo']", "Entering Transaction ID", AgreementNumber);
			Wait.waitfor(3);
			clickElement(driver, test, AuthMana_Report_SearchPopUp, "Clicking on Search Tab");
			Wait.waitfor(3);
			mouseOverAndClick(driver, test, "//td[contains(text(),'"+AgreementNumber+"')]", "Selecting Transaction ID");
			Wait.waitfor(3);
			clickElement(driver, test, AuthMana_Report_SelectPopUp, "Clicking on Select tab");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}else {
		typeText(driver, test, AuthMana_Report_TransactionIDTextBox, "Entering Agreement Number", AgreementNumber);
		}
	selectByVisibleText(driver, test, AuthMana_Report_specialExportProgram, "Selecting Form Type", specialExportProgram);
	if(Programme.length() > 0) {
		clickElement(driver, test, AuthMana_Report_Programme, "Clicking on Programme");
		try {
			Wait.waitfor(3);
			typeText(driver, test, AuthMana_Report_programCodePopUp, "Entering Transaction ID", Programme);
			Wait.waitfor(3);
			clickElement(driver, test, AuthMana_Report_SearchPopUPP, "Clicking on Search Tab");
			Wait.waitfor(3);
			mouseOverAndClick(driver, test, "//td[contains(text(),'"+Programme+"')]", "Selecting Programme Code");
			Wait.waitfor(3);
			clickElement(driver, test, AuthMana_Report_SelectPopUp, "Clicking on Select tab");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}else {
		typeText(driver, test, AuthMana_Report_programTab, "Entering Programme Code", Programme);
	}
	if(Poc.length() > 0) {
		clickElement(driver, test, AuthMana_Report_POC, "Clicking on Programme");
		try {
			Wait.waitfor(3);
			typeText(driver, test, AuthMana_Report_UserFirstName, "Entering Transaction ID", Poc);
			Wait.waitfor(3);
			clickElement(driver, test, AuthMana_Report_SearchPopUPP, "Clicking on Search Tab");
			Wait.waitfor(3);
			mouseOverAndClick(driver, test, "//td[contains(text(),'"+Poc+"')]", "Selecting Programme Code");
			Wait.waitfor(3);
			clickElement(driver, test, AuthMana_Report_SelectPopUp, "Clicking on Select tab");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}else {
		typeText(driver, test, AuthMana_Report_POCTextBox, "Entering Programme Code", Poc);
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
	if(Company.length() > 0) {
		clickElement(driver, test, AuthMana_Report_Company, "Clicking on Programme");
		try {
			Wait.waitfor(3);
			typeText(driver, test, AuthMana_Report_NamePopUp, "Entering Transaction ID", Company);
			Wait.waitfor(3);
			clickElement(driver, test, AuthMana_Report_SearchPopUPP, "Clicking on Search Tab");
			Wait.waitfor(3);
			mouseOverAndClick(driver, test, "//td[contains(text(),'"+Company+"')]", "Selecting Programme Code");
			Wait.waitfor(3);
			clickElement(driver, test, AuthMana_Report_SelectPopUp, "Clicking on Select tab");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}else {
		typeText(driver, test, AuthMana_Report_CompanyTextBox, "Entering Programme Code", Company);
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
		typeText(driver, test, AuthMana_Report_prodFamily, "Entering ProdFamily", ProductFamily);
	}
	selectByVisibleText(driver, test, AuthMana_Report_Relatedtoadisclosure, "Selecting Related To Disclosure :", RelatedToDisclosure);
	selectByVisibleText(driver, test, AuthMana_Report_amended, "Selected Amended :", Amended);
	selectByVisibleText(driver, test, AuthMana_Report_agreementType, "Selecting Agreement type :", AgreementType);
	selectByVisibleText(driver, test, AuthMana_Report_rebaselined, "selecting Rebeselined :", Rebeselined);
	if(AgreementExecuteDateFrom.length() > 0) {
		clickElement(driver, test, AuthMana_Report_agreementExecutedDateFrom, "Cliking on Agreement Executed Date From :");
		dateOfMonthName(driver, test, "Selecting Agreement Executed Date From :", AgreementExecuteDateFrom);
	}
	if(AgreementExecuteDateTo.length() > 0) {
		clickElement(driver, test, AuthMana_Report_agreementExecutedDateTo, "Clicking on Agreement Executed Date To :");
		dateOfMonthName(driver, test, "Selecting Agreement Executed Date To :", AgreementExecuteDateTo);
	}
	typeText(driver, test, AuthMana_Report_reportYear, "Entering Sales Report Year", SalesReportYear);
	if(reportDateFrom.length() > 0) {
		clickElement(driver, test, AuthMana_Report_reportDateFrom, "Clicking on report Date From");
		dateOfMonthName(driver, test, "Selecting Date From", reportDateFrom);
	}
	if(reportDateTo.length() > 0) {
		clickElement(driver, test, AuthMana_Report_reportDateTo, "Clicking on report Date To");
		dateOfMonthName(driver, test, "Selecting Date From", reportDateTo);
	}
	selectByVisibleText(driver, test, AuthMana_Report_SortBy, "Selecting SortBy", SortBy);
	selectByVisibleText(driver, test, AuthMana_Report_direction, "Selecting direction", direction);
	}
}
