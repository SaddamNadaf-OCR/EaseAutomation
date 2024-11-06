package authorizationManagementClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;

public class DS_4071TechDataUSGReportPage extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;
	
	//...................................Locators.......................................//
	public static final String DS4071Tech_Save="(//button[contains(text(),'Save')])[1]";
	public static final String DS4071Tech_SaveAndReturn="(//button[contains(text(),'Save & Return')])[1]";
	public static final String DS4071Tech_Cancel="(//button[contains(text(),'Cancel')])[1]";
	public static final String DS4071Tech_SaveASCheckBox1="//input[@id='editDs4071_formStatusP']";
	public static final String DS4071Tech_SaveASCheckBox2="//input[@id='editDs4071_formStatusC']";
	public static final String DS4071Tech_ReferanceID="//input[@id='editDs4071_ds4071_referenceNo']";
	public static final String DS4071Tech_ExpoAuthID="//input[@id='editDs4071_ds4071_exportAuthId']";
	public static final String DS4071Tech_Exportdate="//input[@id='editDs4071_exportDate']";
	public static final String DS4071Tech_USGReportDate="//input[@id='editDs4071_usgReportDate']";
	public static final String DS4071Tech_Approveddate="//input[@id='editDs4071_approvedDate']";
	public static final String DS4071Tech_RequiestedDate="//input[@id='editDs4071_requestedDate']";
	public static final String DS4071Tech_RegisterCode="//input[@id='editDs4071_ds4071_ddtcNo']";		
	public static final String DS4071Tech_ExportorCode="//input[@id='editDs4071_ds4071_exporterCode']";
	public static final String DS4071Tech_Status="(//select[@class='form-control ocr-cache-search-dynamic-class'])[1]";
	public static final String DS4071Tech_InitialShipmentCheckbo="//input[@id='editDs4071_is']";
	public static final String DS4071Tech_USGReported="//input[@id='editDs4071_usgReported']";
	public static final String DS4071Tech_UserName="//input[@id='editDs4071_ds4071_userName']";
	public static final String DS4071Tech_Email="//input[@id='editDs4071_ds4071_email']";
	public static final String DS4071Tech_Telephone="//input[@id='editDs4071_ds4071_telephone']";
	public static final String DS4071Tech_Reviewer="(//select[@class='form-control ocr-cache-search-dynamic-class'])[2]";
	public static final String DS4071Tech_ReviewerTelephone="//input[@id='editDs4071_ds4071_reviewerTelNo']";
	public static final String DS4071Tech_ReviewerNotes="//textarea[@id='editDs4071_ds4071_reviewerNotes']";
	public static final String DS4071Tech_EmpoweredOfficier="//input[@id='editDs4071_ds4071_emOfficer']";
	public static final String DS4071Tech_Title="//input[@id='editDs4071_ds4071_title']";
	public static final String DS4071Tech_Pin="//input[@id='editDs4071_ds4071_pin']";
	public static final String DS4071Tech_USGOfficier="//input[@id='editDs4071_ds4071_usgOfficer']";
	public static final String DS4071Tech_USGTitle="//input[@id='editDs4071_ds4071_usgTitle']";
	public static final String DS4071Tech_ManufacturerExporterCheckBox="//input[@id='editDs4071_me']";
	public static final String DS4071Tech_USGovermentCheckBox="//input[@id='editDs4071_usgov']";
	public static final String DS4071Tech_SMECheckBox="//input[@id='editDs4071_sme']";
	public static final String DS4071Tech_ForeignEmbassyCheckBox="//input[@id='editDs4071_fe']";
	public static final String DS4071Tech_DDTCCheckBox="//input[@id='editDs4071_re']";
	public static final String DS4071Tech_EligibilityCheckBox="//input[@id='editDs4071_elg']";
	public static final String DS4071Tech_AdditionalReportText="//textarea[@id='editDs4071_ds4071_addReportText']";
	public static final String DS4071Tech_StandardReport="//input[@id='editDs4071_checkStdReport']";
	public static final String DS4071Tech_AgreementNo="//input[@id='editDs4071_ds4071_agreementNo']";
	public static final String DS4071Tech_AuthorizationNo="//input[@id='editDs4071_ds4071_licenseNo']";
	public static final String DS4071Tech_AuthorizationItem="//input[@id='editDs4071_ds4071_licenseItem']";
	public static final String DS4071Tech_ExceptionNo="//input[@id='editDs4071_ds4071_licenseExemptionNo']";
	public static final String DS4071Tech_AuthorizationType="//input[@id='editDs4071_ds4071_licenseType']";
	public static final String DS4071Tech_Country="//input[@id='editDs4071_ds4071_countryName']";
	public static final String DS4071Tech_Program="//textarea[@id='editDs4071_ds4071_programCode']";
	public static final String DS4071Tech_Productdescription="//textarea[@id='editDs4071_ds4071_productDescription']";
	public static final String DS4071Tech_Units="//input[@id='editDs4071_ds4071_units']";
	public static final String DS4071Tech_QTY="//input[@id='editDs4071_ds4071_qty']";
	public static final String DS4071Tech_Value="//input[@id='editDs4071_ds4071_value']";
	public static final String DS4071Tech_USML="//input[@id='editDs4071_ds4071_usml']";
	public static final String DS4071Tech_CommodityCode="//input[@id='editDs4071_ds4071_comCode']";
	public static final String DS4071Tech_ModeOfShipment="(//select[@class='form-control ocr-cache-search-dynamic-class'])[3]";
	public static final String DS4071Tech_PortOfExport="//input[@id='editDs4071_ds4071_port']";
	public static final String DS4071Tech_ShipmentReferanceNo="//input[@id='editDs4071_ds4071_shipRefNo']";
	public static final String DS4071Tech_AddModeCheckBox="//input[@id='editDs4071_checkShipmentMode']";
	public static final String DS4071Tech_AddPortCheckBox="//input[@id='editDs4071_checkPortOfExport']";
	//........................Name and Address of Foreign End User :...............................//
	public static final String DS4071Tech_EUCode="//input[@id='editDs4071_ds4071_endUserId']";
	public static final String DS4071Tech_EUName="//input[@id='editDs4071_ds4071_endUserName']";
	public static final String DS4071Tech_EUAddress1="//input[@id='editDs4071_ds4071_endUserAddr1']";
	public static final String DS4071Tech_EUAddress2="//input[@id='editDs4071_ds4071_endUserAddr2']";
	public static final String DS4071Tech_EUAddress3="//input[@id='editDs4071_ds4071_endUserAddr3']";
	public static final String DS4071Tech_EUCity="//input[@id='editDs4071_ds4071_endUserCity']";
	public static final String DS4071Tech_EUState="//input[@id='editDs4071_ds4071_endUserState']";
	public static final String DS4071Tech_EUCountry="//input[@id='editDs4071_ds4071_endUserCountry']";
	public static final String DS4071Tech_EUZip="//input[@id='editDs4071_ds4071_endUserZip']";
	public static final String DS4071Tech_EUContactName="//input[@id='editDs4071_ds4071_endUserContact']";
	public static final String DS4071Tech_EUPhone="//input[@id='editDs4071_ds4071_endUserPhone']";
	public static final String DS4071Tech_EUEmail="//input[@id='editDs4071_ds4071_endUserEmail']";
	//......................Name and Address of Foreign Consignee :..............................//
	public static final String DS4071Tech_FCCode="//input[@id='editDs4071_ds4071_forConsUserId']";
	public static final String DS4071Tech_FCName="//input[@id='editDs4071_ds4071_forConsName']";
	public static final String DS4071Tech_FCAddress1="//input[@id='editDs4071_ds4071_forConsAddr1']";
	public static final String DS4071Tech_FCAddress2="//input[@id='editDs4071_ds4071_forConsAddr2']";
	public static final String DS4071Tech_FCAddress3="//input[@id='editDs4071_ds4071_forConsAddr3']";
	public static final String DS4071Tech_FCCity="//input[@id='editDs4071_ds4071_forConsCity']";
	public static final String DS4071Tech_FCState="//input[@id='editDs4071_ds4071_forConsState']";
	public static final String DS4071Tech_FCCountry="//input[@id='editDs4071_ds4071_forConsCountry']";
	public static final String DS4071Tech_FCZip="//input[@id='editDs4071_ds4071_forConsZip']";
	public static final String DS4071Tech_FCContactName="//input[@id='editDs4071_ds4071_forConsContact']";
	public static final String DS4071Tech_FCPhone="//input[@id='editDs4071_ds4071_forConsContactPhone']";
	public static final String DS4071Tech_FCEmail="//input[@id='editDs4071_ds4071_forConsEmail']";
	//......................Name and Address of Foreign Intermediate Consignee :...................//
	public static final String DS4071Tech_ICCode="//input[@id='editDs4071_ds4071_indConsUserId']";
	public static final String DS4071Tech_ICName="//input[@id='editDs4071_ds4071_indConsName']";
	public static final String DS4071Tech_ICAddress1="//input[@id='editDs4071_ds4071_indConsAddr1']";
	public static final String DS4071Tech_ICAddress2="//input[@id='editDs4071_ds4071_indConsAddr2']";
	public static final String DS4071Tech_ICAddress3="//input[@id='editDs4071_ds4071_indConsAddr3']";
	public static final String DS4071Tech_ICCity="//input[@id='editDs4071_ds4071_indConsCity']";
	public static final String DS4071Tech_ICState="//input[@id='editDs4071_ds4071_indConsState']";
	public static final String DS4071Tech_ICCountry="//input[@id='editDs4071_ds4071_indConsCountry']";
	public static final String DS4071Tech_ICZip="//input[@id='editDs4071_ds4071_indConsZip']";
	public static final String DS4071Tech_ICContactName="//input[@id='editDs4071_ds4071_indConsContact']";
	public static final String DS4071Tech_ICPhone="//input[@id='editDs4071_ds4071_indConsContactPhone']";
	
	//.......................Name and Address of US Consignor:.................................//
	public static final String DS4071Tech_CCode="//input[@id='editDs4071_ds4071_usConsUserId']";
	public static final String DS4071Tech_CName="//input[@id='editDs4071_ds4071_usConsName']";
	public static final String DS4071Tech_CAddress1="//input[@id='editDs4071_ds4071_usConsAddr1']";
	public static final String DS4071Tech_CAddress2="//input[@id='editDs4071_ds4071_usConsAddr2']";
	public static final String DS4071Tech_CAddress3="//input[@id='editDs4071_ds4071_usConsAddr3']";
	public static final String DS4071Tech_CCity="//input[@id='editDs4071_ds4071_usConsCity']";
	public static final String DS4071Tech_CState="//input[@id='editDs4071_ds4071_usConsState']";
	public static final String DS4071Tech_CCountry="//input[@id='editDs4071_ds4071_usConsCountry']";
	public static final String DS4071Tech_CZip="//input[@id='editDs4071_ds4071_usConsZip']";
	public static final String DS4071Tech_CContactName="//input[@id='editDs4071_ds4071_usConsContact']";
	public static final String DS4071Tech_CPhone="//input[@id='editDs4071_ds4071_usConsContactPhone']";
	
	public static final String DS4071Tech_SaveBottomButton="(//button[contains(text(),'Save')])[3]";
	public static final String DS4071Tech_SaveAndReturnBottomButton="(//button[contains(text(),'Save')])[4]";
	public static final String DS4071Tech_CancelBottomButton="(//button[contains(text(),'Cancel')])[2]";
	
	//.................................Constructor.....................................//
	public DS_4071TechDataUSGReportPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;		
	}
	
	//..............................Export Activity Report..................................//
	public void exportActivity(String referanceID,String exportID,String exportdate, String USGReportDate,String Approveddate,
			String RequiestedDate,String exportCode,String referanceNumber,	String email,String telephone,String reviewerName,
			String empowerdeOfficier) {
		
		typeText(driver, test, DS4071Tech_ReferanceID, "Entering Referance Number", referanceID);
		typeText(driver, test, DS4071Tech_ExpoAuthID, "Entering Referance Number", exportID);
		if(exportdate.length() > 0) {
			clickElement(driver, test, DS4071Tech_Exportdate, "Clicking on Export Date");
			dateOfMonthName(driver, test, "Selecting Date :", exportdate);
		}
		if(USGReportDate.length() > 0) {
			clickElement(driver, test, DS4071Tech_USGReportDate, "Clicking on Export Date");
			dateOfMonthName(driver, test, "Selecting Date :", USGReportDate);
		}
		if(Approveddate.length() > 0) {
			clickElement(driver, test, DS4071Tech_Approveddate, "Clicking on Export Date");
			dateOfMonthName(driver, test, "Selecting Date :", Approveddate);
		}
		if(RequiestedDate.length() > 0) {
			clickElement(driver, test, DS4071Tech_RequiestedDate, "Clicking on Export Date");
			dateOfMonthName(driver, test, "Selecting Date :", RequiestedDate);
		}
		typeText(driver, test, DS4071Tech_ExportorCode, "Entering Referance Number", exportCode);
		typeText(driver, test, DS4071Tech_UserName, "Entering Referance Number", referanceNumber);
		typeText(driver, test, DS4071Tech_Email, "Entering Referance Number", email);
		typeText(driver, test, DS4071Tech_Telephone, "Entering Referance Number", telephone);
		selectByVisibleText(driver, test, DS4071Tech_Reviewer, "Selecting Reviewer Name", reviewerName);
		typeText(driver, test, DS4071Tech_EmpoweredOfficier, "Entering Referance Number", empowerdeOfficier);
	}
	//.....................Click on Save Button...................................//
	public void save() {
		clickElement(driver, test, DS4071Tech_Save, "Clicking on Save Button");
	}
	//.......................Click on Save AND Return Button................................//
	public void saveandReturn() {
		clickElement(driver, test, DS4071Tech_SaveAndReturn, "Clicking on Save and Return Button");
	}
	//.........................Click on Cancel Button..................................//
	public void cancel() {
		clickElement(driver, test, DS4071Tech_Cancel, "Clicking on Cancel Button");
	}
	
	//........................Getting First Value From DropDown ......................................//
	public void countryFirstValue() {
		getSelectFirstText(driver, test, DS4071Tech_CCountry, "Getting Country First Value :");
		getSelectFirstText(driver, test, DS4071Tech_Country, "Getting Country First Value :");
		getSelectFirstText(driver, test, DS4071Tech_EUCountry, "Getting Country First Value :");
		getSelectFirstText(driver, test, DS4071Tech_FCCountry, "Getting Country First Value :");
		getSelectFirstText(driver, test, DS4071Tech_ICCountry, "Getting Country First Value :");
	}

}
