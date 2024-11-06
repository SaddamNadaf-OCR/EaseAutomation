package authorizationManagementClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class SearchENCEncryptionReportPage extends GenericMethods{
	
	public static WebDriver driver;
	public static ExtentTest test;
	
	//..................................Locators........................................//
	public static final String AuthMana_Report_Search="(//button[contains(text(),'Search')])[1]";
	public static final String AuthMana_Report_Reset="(//button[contains(text(),'Reset')])[1]";
	public static final String AuthMana_Report_SbuCode="//select[@name='selectSbu']";
	public static final String AuthMana_Report_ShipmentWorkStatus="//select[@name='selectShipmentWorkStatus']";
	public static final String AuthMana_Report_shipmentNo ="//input[@name='shipment.shipmentNo']";
	public static final String AuthMana_Report_ExporterCode="//a[contains(text(),'Exporter Code')]";
	public static final String AuthMana_Report_ExporterCodePopup ="//input[@name='exporter.expCode']";
	public static final String AuthMana_Report_SearchPopUp="(//button[@name='Search'])[2]";
	public static final String AuthMana_Report_SelectPopUp="//button[contains(text(),'Select')]";
	public static final String AuthMana_Report_Closepopup = "(//button[@class='btn-close'])[1]";
	public static final String AuthMana_Report_ExporterCodeTextBox="//input[@name='shipment.exporterCode']";
	public static final String AuthMana_Report_DateOfExportFrom = "//input[@name='fromDateOfExport']";
	public static final String AuthMana_Report_DateOfExportTo ="//input[@name='toDateOfExport']";
	public static final String AuthMana_Report_ECCNCategory = "//a[contains(text(),'ECCN Category')]";
	public static final String AuthMana_Report_ECCNPopup = "//input[@name='productClazz.prodClassification']";
	public static final String AuthMana_Report_ECCNTextbox = "//input[@name='productClassification']";
	public static final String AuthMana_Report_ProductFamily = "//a[contains(text(),'Product Family')]";
	public static final String AuthMana_Report_ProductFamilyTextbox = "//textarea[@name='shipment.productFamilyName']";
	public static final String AuthMana_Report_Program = "(//a[contains(text(),'Program')])[3]";
	public static final String AuthMana_Report_Programcode = "//input[@name='programTab.programCode']";
	public static final String AuthMana_Report_ProgramTextBox = "//textarea[@name='shipment.programDesc']";
	public static final String AuthMana_Report_UltimateConsignee="//a[contains(text(),'Ultimate Consignee')]";
	public static final String AuthMana_Report_UltimateConsigneePopup="//input[@name='consignee.consigneeId']";
	public static final String AuthMana_Report_UltimateConsigneeTextbox="//input[@name='shipment.ultConsName']";
	public static final String AuthMana_Report_CountryOfUltDest="//select[@name='selectCountryOfUltDest']";
	public static final String AuthMana_Report_Region ="//select[@name='selectRegion']";
	public static final String AuthMana_Report_Site ="//select[@name='selectSite']";
	public static final String AuthMana_Report_PartNo="//a[contains(text(),'Part No.')]";
	public static final String AuthMana_Report_PartNoPopup="//input[@name='product.productCode']";
	public static final String AuthMana_Report_PartNoTextBox="//input[@name='partNo']";		
	
	//..................................Constructors..................................//
	public SearchENCEncryptionReportPage(WebDriver driver,ExtentTest test) {
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
	public void searchByAllParameters(String SBUCode, String ShipmentWorkStatus, String shipmentNo, String ExporterCode, 
			String DateOfExportFrom, String DateOfExportTo, String ECCNCategory, String ProductFamily, String Program, 
			String UltimateConsignee, String CountrysOfUltDestination, String Region, String Site, String PartNo) {
		
		selectByVisibleText(driver, test, AuthMana_Report_SbuCode, "Selecting SBU Code", SBUCode);
		selectByVisibleText(driver, test, AuthMana_Report_ShipmentWorkStatus, "Selecting Shipment Work Status :", ShipmentWorkStatus);
		typeText(driver, test, AuthMana_Report_shipmentNo, "Entering Shipment No :", shipmentNo);
		if(ExporterCode.length() > 0) {
			clickElement(driver, test, AuthMana_Report_ExporterCode, "Clicking on Exporter Code :");
			try {
				typeText(driver, test, AuthMana_Report_ExporterCodePopup, "Entering Exporter Code :", ExporterCode);
				clickElement(driver, test, AuthMana_Report_SearchPopUp, "Clicking on Search Button :");
				Wait.waitfor(3);
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ExporterCode+"')]", "Selecting Exporter Code :");
				Wait.waitfor(3);
				clickElement(driver, test, AuthMana_Report_SelectPopUp, "Clicking on Select tab");
			} catch (Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, AuthMana_Report_Closepopup, "CLicking on Close Popup :");
			}
		}else {
			typeText(driver, test, AuthMana_Report_ExporterCodeTextBox, "Entering Exporter Code :", ExporterCode);
		}
		if(DateOfExportFrom.length() > 0) {
			clickElement(driver, test, AuthMana_Report_DateOfExportFrom, "Clicking on Date of Export From :");
			dateOfMonthName(driver, test, "Selecting Date of Export From :", DateOfExportFrom);
		}
		if(DateOfExportTo.length() > 0) {
			clickElement(driver, test, AuthMana_Report_DateOfExportTo, "Clicking on Date of Export To :");
			dateOfMonthName(driver, test, "Selecting Date of Export To :", DateOfExportTo);
		}
		if(ECCNCategory.length() > 0) {
			clickElement(driver, test, AuthMana_Report_ECCNCategory, "Clicking on ECCN Category :");
			try {
				typeText(driver, test, AuthMana_Report_ECCNPopup, "Entering ECCN Category :", ECCNCategory);
				clickElement(driver, test, AuthMana_Report_SearchPopUp, "Clicking on Search Button :");
				Wait.waitfor(3);
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ECCNCategory+"')]", "Selecting ECCN Category :");
				Wait.waitfor(3);
				clickElement(driver, test, AuthMana_Report_SelectPopUp, "Clicking on Select tab");
			} catch (Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, AuthMana_Report_Closepopup, "CLicking on Close Popup :");
			}
		}else {
			typeText(driver, test, AuthMana_Report_ECCNTextbox, "Entering ECCN Category :", ECCNCategory);
		}
		if(ProductFamily.length() > 0) {
			clickElement(driver, test, AuthMana_Report_ProductFamily, "Clicking on Product Family :");
			try {
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+ProductFamily+"')]", "Selecting Product Family :");
				Wait.waitfor(3);
				clickElement(driver, test, AuthMana_Report_SelectPopUp, "Clicking on Select tab");
			} catch (Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, AuthMana_Report_Closepopup, "CLicking on Close Popup :");
			}
		}else {
			typeText(driver, test, AuthMana_Report_ProductFamilyTextbox, "Entering Product Family :", ProductFamily);
		}		
		if(Program.length() > 0) {
			clickElement(driver, test, AuthMana_Report_Program, "Clicking on Program :");
			try {
				typeText(driver, test, AuthMana_Report_Programcode, "Entering Program :", Program);
				clickElement(driver, test, AuthMana_Report_SearchPopUp, "Clicking on Search Button :");
				Wait.waitfor(3);
				mouseOverAndClick(driver, test, "//td[contains(text(),'"+Program+"')]", "Selecting Program :");
				Wait.waitfor(3);
				clickElement(driver, test, AuthMana_Report_SelectPopUp, "Clicking on Select tab");
			} catch (Exception e) {
				testFailSshot(driver, test);
				e.printStackTrace();
				clickElement(driver, test, AuthMana_Report_Closepopup, "CLicking on Close Popup :");
			}
		}else {
			typeText(driver, test, AuthMana_Report_ProgramTextBox, "Entering Program :", Program);
		}
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
		selectByVisibleText(driver, test, AuthMana_Report_CountryOfUltDest, "Selecting Country of Ultimate Destination :", CountrysOfUltDestination);
		selectByVisibleText(driver, test, AuthMana_Report_Region, "Selecting Region :", Region);
		selectByVisibleText(driver, test, AuthMana_Report_Site, "Selecting Site :", Site);		
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