package authorizationManagementClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;

public class SearchDS4071TechDataUSGReportsPage extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;
	
	//...................................Locators.......................................//
	public static final String DS4071_Search="//button[contains(text(),'Search')]";
	public static final String DS4071_Reset="//button[contains(text(),'Reset')]";
	public static final String DS4071_Add4071TechData="//button[contains(text(),'Add DS-4071 Tech Data')]";
	public static final String DS4071_sbuCode="//select[@name='ds4071.sbuCode']";
	public static final String DS4071_referenceNo="//input[@name='ds4071.referenceNo']";
	public static final String DS4071_exportAuthId="//input[@name='ds4071.exportAuthId']";
	public static final String DS4071_AuthorizationType="(//a[contains(text(),'Authorization Type')])[2]";
	public static final String DS4071_licenseType="//textarea[@name='licenseTypes.licenseType']";
	public static final String DS4071_SearchPopup="(//button[@name='Search'])[2]";
	public static final String DS4071_SelectPopUp="(//button[@name='Ok'])";
	public static final String DS4071_ClosePopup="(//button[@class='btn-close'])[1]";
	public static final String DS4071_licenseTypeTextBox="//input[@name='ds4071.licenseType']";
	public static final String DS4071_AuthorizationNo="//a[contains(text(),'Authorization No.')]";
	public static final String DS4071_licenseNo="//input[@name='licenseHeaderDTO.licenseNo']";
	public static final String DS4071_licenseNoTextBox="//input[@name='ds4071.licenseNo']";
	public static final String DS4071_ExemptionNo="//a[contains(text(),'Exemption No')]";
	public static final String DS4071_licenseExemptionNo="//input[@name='ds4071.licenseExemptionNo']";
	public static final String DS4071_AgreementNo="//a[contains(text(),'Agreement No')]";
	public static final String DS4071_transactionId="//input[@name='dosGeneralInfoDTO.transactionId']";
	public static final String DS4071_agreementNo="//input[@name='ds4071.agreementNo']";
	public static final String DS4071_InitialShipment="//input[@name='is']";
	public static final String DS4071_usgReported="//input[@name='usgReported']";
	public static final String DS4071_Status="//select[@name='licenseStatus']";
	public static final String DS4071_countryName="//input[@name='ds4071.countryName']";
	public static final String DS4071_fromExportDate="//input[@name='fromExportDate']";
	public static final String DS4071_toExportDate="//input[@name='toExportDate']";
	public static final String DS4071_fromUsgReportDate="//input[@name='fromUsgReportDate']";
	public static final String DS4071_toUsgReportDate="//input[@name='toUsgReportDate']";
	public static final String DS4071_Program="//a[contains(text(),' Program')]";
	public static final String DS4071_programCode="//input[@name='programTab.programCode']";
	public static final String DS4071_programCodeTextbox="//textarea[@name='ds4071.programCode']";
	public static final String DS4071_endUserName="//input[@name='ds4071.endUserName']";
	public static final String DS4071_shipmentMode="//select[@name='shipmentMode']";
	public static final String DS4071_PortofExport="//a[contains(text(),'Port of Export')]";
	public static final String DS4071_portId="//input[@name='ports.portId']";
	public static final String DS4071_port="//input[@name='ds4071.port']";
	public static final String DS4071_shipRefNo="//input[@name='ds4071.shipRefNo']";
	public static final String DS4071_emOfficer="//input[@name='ds4071.emOfficer']";
	public static final String DS4071_UserName="//a[contains(text(),'User Name')]";
	public static final String DS4071_userFirstname="//input[@name='userProfile.userFirstname']";
	public static final String DS4071_userNameTextbox="//input[@name='ds4071.userName']";
	public static final String DS4071_sortBy="(//select[@name='sortBy'])[1]";
	public static final String DS4071_direction="(//select[@name='direction'])[1]";
	
	//.................................Constructor.....................................//
	public SearchDS4071TechDataUSGReportsPage(WebDriver driver,ExtentTest test) {
		this.driver = driver;
		this.test = test;		
	}
	
	//........................Click on Search Tab.................................//
	public void search() {
		clickElement(driver, test, DS4071_Search, "Clicking on Search Tab");
	}
	
	//.........................Click on Reset Tab................................//
	public void reset() {
		clickElement(driver, test, DS4071_Reset, "Clicking on Reset Tab");
	}
	
	//........................Click on Add DS4071 Data Tab........................//
	public void add4071() {
		clickElement(driver, test, DS4071_Add4071TechData, "Clicking on Add Button");
	}
	
	//........................Search by Parameters..............................//
	public void searchByParameters(String sbuCode, String ReferanceNo, String ExportAuthNo,String AuthorizationType, 
			String AuthorizationNo, String ExemptionNo, String AgreementNo, String InitialShipment, String USGReport, 
			String Status, String Country, String ExportdateFrom, String ExportdateTo, String UsgReportDateFrom, 
			String UsgReportDateto, String Program, String EndUserName, String ShipmentMode, String PortOfExport, 
			String ShipRefNo, String EmOfficer, String UserName, String SortBy, String Direction) {
		
		selectByVisibleText(driver, test, DS4071_sbuCode, "Selecting SBU Code :", sbuCode);
		typeText(driver, test, DS4071_referenceNo, "Entering Referance no :", ReferanceNo);
		typeText(driver, test, DS4071_exportAuthId, "Entering Export Authorization No :", ExportAuthNo);
		if(AuthorizationType.length() > 0) {
			clickElement(driver, test, DS4071_AuthorizationType, "Clicking on Authorization Type :");
			try {
				typeText(driver, test, DS4071_licenseType, "Entering License type :", AuthorizationType);
				clickElement(driver, test, DS4071_SearchPopup, "Clicking on Search Tab :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+AuthorizationType+"')]", "Selecting Authorization Type :");
				clickElement(driver, test, DS4071_SelectPopUp, "Clicking on Select Button :");
			}catch(Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, DS4071_ClosePopup, "Clicking on CLose Popup :");
				e.printStackTrace();
			}
		}else {
			typeText(driver, test, DS4071_licenseTypeTextBox, "Enterring Authorization type :", AuthorizationType);
		}
		if(AuthorizationNo.length() > 0) {
			clickElement(driver, test, DS4071_AuthorizationNo, "Clicking on Authorization No :");
			try {
				typeText(driver, test, DS4071_licenseNo, "Entering License No :", AuthorizationNo);
				clickElement(driver, test, DS4071_SearchPopup, "Clicking on Search Tab :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+AuthorizationNo+"')]", "Selecting Authorization No :");
				clickElement(driver, test, DS4071_SelectPopUp, "Clicking on Select Button :");
			}catch(Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, DS4071_ClosePopup, "Clicking on Close Popup :");
				e.printStackTrace();
			}
		}else {
			typeText(driver, test, DS4071_licenseNoTextBox, "Enterring Authorization No :", AuthorizationNo);
		}
		if(ExemptionNo.length() > 0) {
			clickElement(driver, test, DS4071_ExemptionNo, "Clicking on Exemption No :");
			try {
				typeText(driver, test, DS4071_licenseType, "Entering Exemption No :", ExemptionNo);
				clickElement(driver, test, DS4071_SearchPopup, "Clicking on Search Tab :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ExemptionNo+"')]", "Selecting Exemption No :");
				clickElement(driver, test, DS4071_SelectPopUp, "Clicking on Select Button :");
			}catch(Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, DS4071_ClosePopup, "Clicking on Close Popup :");
				e.printStackTrace();
			}
		}else {
			typeText(driver, test, DS4071_licenseExemptionNo, "Enterring Exemption No :", ExemptionNo);
		}
		if(AgreementNo.length() > 0) {
			clickElement(driver, test, DS4071_AgreementNo, "Clicking on Agreement No :");
			try {
				typeText(driver, test, DS4071_transactionId, "Entering Agreement No :", AgreementNo);
				clickElement(driver, test, DS4071_SearchPopup, "Clicking on Search Tab :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+AgreementNo+"')]", "Selecting Agreement No :");
				clickElement(driver, test, DS4071_SelectPopUp, "Clicking on Select Button :");
			}catch(Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, DS4071_ClosePopup, "Clicking on Close Popup :");
				e.printStackTrace();
			}
		}else {
			typeText(driver, test, DS4071_agreementNo, "Enterring Agreement No :", AgreementNo);
		}
		if(InitialShipment.equalsIgnoreCase("Yes")) {
			clickElement(driver, test, DS4071_InitialShipment, "Clicking on Initial Shipment :");
		}
		if(USGReport.equalsIgnoreCase("Yes")) {
			clickElement(driver, test, DS4071_usgReported, "Clicking on usg Reported :");
		}
		selectByVisibleText(driver, test, DS4071_Status, "Selecting Status :", Status);
		typeText(driver, test, DS4071_countryName, "Entering Country Name :", Country);
		if(ExportdateFrom.length() > 0) {
			clickElement(driver, test, DS4071_fromExportDate, "Clicking on Export Date From :");
			dateOfMonthName(driver, test, "Selecting Export Date From :", ExportdateFrom);
		}
		if(ExportdateTo.length() > 0) {
			clickElement(driver, test, DS4071_toExportDate, "Clicking on Export Date To :");
			dateOfMonthName(driver, test, "Selecting Export Date To :", ExportdateTo);
		}
		if(UsgReportDateFrom.length() > 0) {
			clickElement(driver, test, DS4071_fromUsgReportDate, "Clicking on Usg Report Date From :");
			dateOfMonthName(driver, test, "Selecting Usg Report Date From :", UsgReportDateFrom);
		}
		if(UsgReportDateto.length() > 0) {
			clickElement(driver, test, DS4071_toUsgReportDate, "Clicking on Usg Report Date To :");
			dateOfMonthName(driver, test, "Selecting Usg Report Date To :", UsgReportDateto);
		}
		
		if(Program.length() > 0) {
			clickElement(driver, test, DS4071_Program, "Clicking on Program No :");
			try {
				typeText(driver, test, DS4071_programCode, "Entering Program No :", Program);
				clickElement(driver, test, DS4071_SearchPopup, "Clicking on Search Tab :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Program+"')]", "Selecting Program No :");
				clickElement(driver, test, DS4071_SelectPopUp, "Clicking on Select Button :");
			}catch(Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, DS4071_ClosePopup, "Clicking on CLose Popup :");
				e.printStackTrace();
			}
		}else {
			typeText(driver, test, DS4071_programCodeTextbox, "Enterring Program No :", Program);
		}
		typeText(driver, test, DS4071_endUserName, "Entering Foreign End User :", EndUserName);
		selectByVisibleText(driver, test, DS4071_shipmentMode, "Selecting Shipment Mode :", ShipmentMode);
		if(PortOfExport.length() > 0) {
			clickElement(driver, test, DS4071_PortofExport, "Clicking on Port Of Export No :");
			try {
				typeText(driver, test, DS4071_portId, "Entering Port Of Export No :", PortOfExport);
				clickElement(driver, test, DS4071_SearchPopup, "Clicking on Search Tab :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+PortOfExport+"')]", "Selecting Port Of Export No :");
				clickElement(driver, test, DS4071_SelectPopUp, "Clicking on Select Button :");
			}catch(Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, DS4071_ClosePopup, "Clicking on Close Popup :");
				e.printStackTrace();
			}
		}else {
			typeText(driver, test, DS4071_port, "Enterring Port Of Export No :", PortOfExport);
		}
		typeText(driver, test, DS4071_shipRefNo, "Entering Shipment Referance No :", ShipRefNo);
		typeText(driver, test, DS4071_emOfficer, "Entering Empowered Officier :", EmOfficer);
		if(UserName.length() > 0) {
			clickElement(driver, test, DS4071_UserName, "Clicking on User Name :");
			try {
				typeText(driver, test, DS4071_userFirstname, "Entering User Name :", UserName);
				clickElement(driver, test, DS4071_SearchPopup, "Clicking on Search Tab :");
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+UserName+"')]", "Selecting UserName :");
				clickElement(driver, test, DS4071_SelectPopUp, "Clicking on Select Button :");
			}catch(Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, DS4071_ClosePopup, "Clicking on Close Popup ");
				e.printStackTrace();
			}
		}else {
			typeText(driver, test, DS4071_userNameTextbox, "Enterring UserName :", UserName);
		}
		selectByVisibleText(driver, test, DS4071_sortBy, "Selecting Sort By :", SortBy);
		selectByVisibleText(driver, test, DS4071_direction, "Selecting Direction :", Direction);
	}
}
