package authorizationManagementClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;
import utilities.Wait;

public class SearchAnnualStatusSummaryReportPage extends GenericMethods{
	
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
	public static final String AuthMana_Report_AgreementNumber="//a[contains(text(),'Agreement Number')]";
	public static final String AuthMana_Report_AgreementNoTextbox="//input[@name='dosGeneralInfo.licenseNo']";
	public static final String AuthMana_Report_FormType="//select[@name='dosGeneralInfo.applFormType']";
	public static final String AuthMana_Report_Status="//select[@name='dosGeneralInfo.status']";
	public static final String AuthMana_Report_fromExpireDate="//input[@name='fromExpireDate']";
	public static final String AuthMana_Report_toExpireDate="//input[@name='toExpireDate']";
	public static final String AuthMana_Report_Programme="(//a[contains(text(),'Programme')])[2]";
	public static final String AuthMana_Report_programCodePopUp="//input[@name='programTab.programCode']";
	public static final String AuthMana_Report_SearchPopUPP="(//button[contains(text(),'Search')])[2]";
	public static final String AuthMana_Report_programTab="//textarea[@name='dosGeneralInfo.programTab']";
	public static final String AuthMana_Report_Segment="(//a[contains(text(),'Segment')])[2]";
	public static final String AuthMana_Report_segmentCode="//textarea[@name='dosGeneralInfo.segmentCode']";
	public static final String AuthMana_Report_ProductLine="//a[contains(text(),'Product Line')]";
	public static final String AuthMana_Report_prodLine="//textarea[@name='dosGeneralInfo.prodLine']";
	public static final String AuthMana_Report_ProductFamily="//a[contains(text(),'Product Family')]";
	public static final String AuthMana_Report_prodFamily="//textarea[@name='dosGeneralInfo.prodFamily']";
	public static final String AuthMana_Report_ReportYear="//input[@name='reportYear']";
	public static final String AuthMana_Report_SortBy="(//select[@name='sortBy'])[1]";
	public static final String AuthMana_Report_direction="(//select[@name='direction'])[1]";
	
	//..................................Constructors..................................//
	public SearchAnnualStatusSummaryReportPage(WebDriver driver,ExtentTest test) {
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
	public void searchBYParaeters(String SBUCode, String TransactionID, String AgreementNumber, String FormType, String Status,
			String ExpirationdateFrom, String ExpirationdateTo, String Programme, String Segment, String ProductLine, String ProductFamily,
			String reportYear, String SortBy, String direction) {
		
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
		selectByVisibleText(driver, test, AuthMana_Report_FormType, "Selecting Form Type", FormType);
		selectByVisibleText(driver, test, AuthMana_Report_Status, "Selecting Status", Status);
		if(ExpirationdateFrom.length() > 0){
			clickElement(driver, test, AuthMana_Report_fromExpireDate, "Clicking on Expiration Date From");
			dateOfMonthName(driver, test, "Selecting Date From", ExpirationdateFrom);
		}
		if(ExpirationdateTo.length() > 0) {
		    clickElement(driver, test, AuthMana_Report_toExpireDate, "Clicking on Expiration Date From");
			dateOfMonthName(driver, test, "Selecting Date From", ExpirationdateTo);
		}
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
		typeText(driver, test, AuthMana_Report_ReportYear, "Entering Report Year", reportYear);
		selectByVisibleText(driver, test, AuthMana_Report_SortBy, "Selecting SortBy", SortBy);
		selectByVisibleText(driver, test, AuthMana_Report_direction, "Selecting direction", direction);
	}
}
