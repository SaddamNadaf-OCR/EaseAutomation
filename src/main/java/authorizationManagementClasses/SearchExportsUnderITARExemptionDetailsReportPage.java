package authorizationManagementClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class SearchExportsUnderITARExemptionDetailsReportPage extends GenericMethods{
	
	public static WebDriver driver;
	public static ExtentTest test;
	
	//..................................Locators........................................//
	public static final String AuthMana_Report_Search="(//button[contains(text(),'Search')])[1]";
	public static final String AuthMana_Report_Reset="(//button[contains(text(),'Reset')])[1]";
	public static final String AuthMana_Report_SbuCode="//select[@name='selectSbu']";
	public static final String AuthMana_Report_shipmentNo ="//input[@name='shipment.shipmentNo']";
	public static final String AuthMana_Report_DestinationCountry ="//select[@name='selectCountryOfUltDest']";
	public static final String AuthMana_Report_ShipmentWorkStatus="//select[@name='selectShipmentWorkStatus']";
	public static final String AuthMana_Report_UltimateConsignee="//a[contains(text(),'Ultimate Consignee')]";
	public static final String AuthMana_Report_UltimateConsigneePopup="//input[@name='consignee.consigneeId']";
	public static final String AuthMana_Report_SearchPopUp="(//button[@name='Search'])[2]";
	public static final String AuthMana_Report_SelectPopUp="//button[contains(text(),'Select')]";
	public static final String AuthMana_Report_Closepopup = "(//button[@class='btn-close'])[1]";
	public static final String AuthMana_Report_UltimateConsigneeTextbox="//input[@name='shipment.ultConsName']";
	public static final String AuthMana_Report_AuthorizationType = "(//a[contains(text(),'Authorization Type')])[2]";
	public static final String AuthMana_Report_AuthorizationTypePopup ="//textarea[@name='licenseTypes.licenseType']";
	public static final String AuthMana_Report_AuthorizationTypeTextBox="//textarea[@name='itarExemptionNo']";
	public static final String AuthMana_Report_CreatedDateFrom = "//input[@name='fromCreatedDate']";
	public static final String AuthMana_Report_CreatedDateTo ="//input[@name='toCreatedDate']";
	public static final String AuthMana_Report_DateOfExportFrom = "//input[@name='fromDateOfExport']";
	public static final String AuthMana_Report_DateOfExportTo ="//input[@name='toDateOfExport']";
	public static final String AuthMana_Report_PartNo="//a[contains(text(),'Part No.')]";
	public static final String AuthMana_Report_PartNoPopup="//input[@name='product.productCode']";
	public static final String AuthMana_Report_PartNoTextBox="//input[@name='partNo']";
		
	
	//..................................Constructors..................................//
	public SearchExportsUnderITARExemptionDetailsReportPage(WebDriver driver,ExtentTest test) {
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
	public void searchByAllParameters(String SBUCode, String shipmentNo, String DestinationCountry, String ShipmentWorkStatus, 
			String UltimateConsignee, String AuthorizationType, String CreatedDateFrom, String CreatedDateTo, String DateOfExportFrom, 
			String DateOfExportTo, String PartNo) {
		
		selectByVisibleText(driver, test, AuthMana_Report_SbuCode, "Selecting SBU Code", SBUCode);
		typeText(driver, test, AuthMana_Report_shipmentNo, "Entering Shipment No :", shipmentNo);
		selectByVisibleText(driver, test, AuthMana_Report_DestinationCountry, "Selecting Destination Country :", DestinationCountry);
		selectByVisibleText(driver, test, AuthMana_Report_ShipmentWorkStatus, "Selecting Shipment Work Status :", ShipmentWorkStatus);
		if(UltimateConsignee.length() > 0) {
			clickElement(driver, test, AuthMana_Report_UltimateConsignee, "Clicking on Ultimate Consignee :");
			try {
				typeText(driver, test, AuthMana_Report_UltimateConsigneePopup, "Entering Ultimate Consignee No :", UltimateConsignee);
				clickElement(driver, test, AuthMana_Report_SearchPopUp, "Clicking on Search Button :");
				Wait.waitfor(3);
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+UltimateConsignee+"')]", "Selecting Ultimate Consignee No :");
				Wait.waitfor(3);
				clickElement(driver, test, AuthMana_Report_SelectPopUp, "Clicking on Select tab");
			} catch (Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, AuthMana_Report_Closepopup, "CLicking on Close Popup :");
			}
		}else {
			typeText(driver, test, AuthMana_Report_UltimateConsigneeTextbox, "Entering Ultimate Consignee :", UltimateConsignee);
		}
		if(AuthorizationType.length() > 0) {
			clickElement(driver, test, AuthMana_Report_AuthorizationType, "Clicking on Authorization Type :");
			try {
				typeText(driver, test, AuthMana_Report_AuthorizationTypePopup, "Entering Authorization Type :", AuthorizationType);
				clickElement(driver, test, AuthMana_Report_SearchPopUp, "Clicking on Search Button :");
				Wait.waitfor(3);
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+AuthorizationType+"')]", "Selecting Authorization Type :");
				Wait.waitfor(3);
				clickElement(driver, test, AuthMana_Report_SelectPopUp, "Clicking on Select tab");
			} catch (Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, AuthMana_Report_Closepopup, "CLicking on Close Popup :");
			}
		}else {
			typeText(driver, test, AuthMana_Report_AuthorizationTypeTextBox, "Entering Authorization Type :", AuthorizationType);
		}
		if(CreatedDateFrom.length() > 0) {
			clickElement(driver, test, AuthMana_Report_CreatedDateFrom, "Clicking on Created Date From :");
			dateOfMonthName(driver, test, "Selecting Created Date From :", CreatedDateFrom);
		}
		if(CreatedDateTo.length() > 0) {
			clickElement(driver, test, AuthMana_Report_CreatedDateTo, "Clicking on Created Date To :");
			dateOfMonthName(driver, test, "Selecting Created Date To :", CreatedDateTo);
		}
		if(DateOfExportFrom.length() > 0) {
			clickElement(driver, test, AuthMana_Report_DateOfExportFrom, "Clicking on Date of Export From :");
			dateOfMonthName(driver, test, "Selecting Date of Export From :", DateOfExportFrom);
		}
		if(DateOfExportTo.length() > 0) {
			clickElement(driver, test, AuthMana_Report_DateOfExportTo, "Clicking on Date of Export To :");
			dateOfMonthName(driver, test, "Selecting Date of Export To :", DateOfExportTo);
		}
		if(PartNo.length() > 0) {
			clickElement(driver, test, AuthMana_Report_PartNo, "Clicking on Part No :");
			try {
				typeText(driver, test, AuthMana_Report_PartNoPopup, "Entering Part No :", PartNo);
				clickElement(driver, test, AuthMana_Report_SearchPopUp, "Clicking on Search Button :");
				Wait.waitfor(3);
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+PartNo+"')]", "Selecting Part No :");
				Wait.waitfor(3);
				clickElement(driver, test, AuthMana_Report_SelectPopUp, "Clicking on Select tab");
			} catch (Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, AuthMana_Report_Closepopup, "CLicking on Close Popup :");
			}
		}else {
			typeText(driver, test, AuthMana_Report_PartNoTextBox, "Entering Part No :", PartNo);
		}
	}
}