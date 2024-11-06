
package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class ShipmentWizardPage extends GenericMethods{

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	
	public static final String OCR_ShipmentWizard_SBUCode = "//select[@id='selectedSbuCode']";
	public static final String OCR_ShipmentWizard_GoButton = "//button[@id='saveWizard']";
	public static final String OCR_ShipmentWizard_ByShipNo = "//input[@id='editShipmentWizardForm_shipmentNo1']";
	
	public static final String OCR_ShipmentWizard_Search = "//button[@name='statusByRequestor']";
	public static final String OCR_ShipmentWizard_Reset = "//button[contains(text(),'Reset')]";
	public static final String OCR_ShipmentWizard_ShipmentByShipmentNo="//input[@id='editShipmentWizardForm_shipmentNo1']";
	
	public static final String OCR_ShipmentWizard_ByEmailID = "//input[@id='editShipmentWizardForm_emailId']";
	public static final String OCR_ShipmentWizard_ByRequestorName = "//input[@id='editShipmentWizardForm_requestorName']";
	//public static final String OCR_ShipmentWizard_ByShipmentNo = "//input[@id='editShipmentWizardForm_shipmentNo1']";
	public static final String OCR_ShipmentWizard_ByShipmentStatus = "//select[@id='editShipmentWizardForm_shipmentStatus']";
	public static final String OCR_ShipmentWizard_ByPartNumber = "//input[@id='editShipmentWizardForm_partNo']";
	public static final String OCR_ShipmentWizard_BySerialNumber = "//input[@id='editShipmentWizardForm_serialNo']";
	public static final String OCR_ShipmentWizard_ByPO_Customerreference = "//input[@id='editShipmentWizardForm_poCustomerRef']";
	public static final String OCR_ShipmentWizard_BySalesOrderNo = "//input[@id='editShipmentWizardForm_salesOrderNo']";
	public static final String OCR_ShipmentWizard_ByCostCenter = "//input[@id='editShipmentWizardForm_costCenter']";
	
	public static final String OCR_ShipmentWizard_CreateNewShipment = "(//input[@onclick='clicker()'])[1]";
	public static final String OCR_ShipmentWizard_CreateNewShipmentfromTemplate = "(//input[@onclick='clicker()'])[2]";
	public static final String OCR_ShipmentWizard_EditShipmentbyShipmentNo = "(//input[@onclick='clicker()'])[3]";
	public static final String OCR_ShipmentWizard_CreateCustomsFilingEEIfromanAuthorization = "(//input[@onclick='clicker()'])[4]";
	public static final String OCR_ShipmentWizard_AuthorizationNo="//a[@id='licenseno-pop']";
	public static final String OCR_ShipmentWizard_AuthorizationNoOnPopUp="//input[@id='resultLicensePopupData_licenseHeaderDTO_licenseNo']";
	public static final String OCR_ShipmentWizard_SearchButtonOnPopUp="//button[@id='searchAuth']";
	public static final String OCR_ShipmentWizard_SelectButtonOnPopUp="//button[contains(text(), 'Select')]";
	public static final String OCR_ShipmentWizard_SelectButtonforTemplateselection ="//select[@name='templateId']";
	//option[@value='DM_SHIP_001']
	
	
	
	/* ******************************* Constructor ****************************** */

	public ShipmentWizardPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */
	//Select Authorization no on popup
	public void select_AuthorizationNo(String AuthorizationNoOnPopUp) {
		clickElement(driver, test, "//td[contains(text(),'" + AuthorizationNoOnPopUp + "')]", "Select the Product Family : " + AuthorizationNoOnPopUp);
	}
	
	//click on Select Button for Template selection
	public void select_TemplateID(String TemplateID) {
		clickElement(driver, test, OCR_ShipmentWizard_SelectButtonforTemplateselection, "");
		Wait.waitfor(2);
	    clickElement(driver, test, "//option[contains(text(),'" + TemplateID + "')]", "Select the Product Family : " + TemplateID);
	}
		
	//CLick on Search button on popup
	public void Click_searchButtonOnPopup() {
		clickElement(driver, test, OCR_ShipmentWizard_SearchButtonOnPopUp, "CLick on Search button on popup");
	}
	
	//Type Shipment by Shipment No
	public void type_ShipmentByShipmentNo(String ShipmentNumber) {
		typeText(driver, test, OCR_ShipmentWizard_ShipmentByShipmentNo, "Type Shipment by shipment no ", ShipmentNumber);
	}
	
	//Type Shipment Authorization No On PopUp
	public void type_AuthorizationNoOnPopUp(String ShipmentNo) {
		typeText(driver, test, OCR_ShipmentWizard_AuthorizationNoOnPopUp, "Type Shipment by shipment no ", ShipmentNo);
	}
	
	//Click Authorization No hyperlink
	public void Click_AuthorizationNo() {
		clickElement(driver, test, OCR_ShipmentWizard_AuthorizationNo, "Click Authorization No hyperlink");
	}
	
	//Click Select button on popup
	public void Click_SelectButtonOnPopup() {
		clickElement(driver, test, OCR_ShipmentWizard_SelectButtonOnPopUp, "Click Select button on popup");
	}
	
	//Click on Reset Button
	public void Click_Reset() {
		clickElement(driver, test, OCR_ShipmentWizard_Reset, "Click on Reset Button");
	}
	
	public void type_SearchBy(String EmailID, String RequestorName, String PartNO, String ShipmentStatus, String SerialNo, 
			String Customerreference, String SalesOrderNo, String CostCenter) {
		if(EmailID.length() > 0) {
			clearText(driver, test, OCR_ShipmentWizard_ByEmailID, "Clear the email ID that is existing already :");
			typeText(driver, test, OCR_ShipmentWizard_ByEmailID, "Enter the Shipment No : ", EmailID);
		}
		Wait.waitfor(2);
		if(RequestorName.length() > 0) {
			typeText(driver, test, OCR_ShipmentWizard_ByRequestorName, "Type requestor Name", RequestorName);
		}
		Wait.waitfor(2);
		if(PartNO.length() > 0) {
			typeText(driver, test, OCR_ShipmentWizard_ByPartNumber, "Type PartNumber", PartNO);
		}
		Wait.waitfor(2);
		if(ShipmentStatus.length() > 0) {
			selectByVisibleText(driver, test, OCR_ShipmentWizard_ByShipmentStatus, "Select shipment status", ShipmentStatus);
		}
		Wait.waitfor(2);
		if(SerialNo.length() > 0) {
			typeText(driver, test, OCR_ShipmentWizard_BySerialNumber, "Type Serial number", SerialNo);
		}
		Wait.waitfor(2);
		if(Customerreference.length() > 0) {
			typeText(driver, test, OCR_ShipmentWizard_ByPO_Customerreference, "Type Customer reference", Customerreference);
		}
		Wait.waitfor(2);
		if(SalesOrderNo.length() > 0) {
			typeText(driver, test, OCR_ShipmentWizard_BySalesOrderNo, "Type Sales Order Number", SalesOrderNo);
		}
		Wait.waitfor(2);
		if(CostCenter.length() > 0) {
			typeText(driver, test, OCR_ShipmentWizard_ByCostCenter, "Type Cost center", CostCenter);
		}
	}			
		
	//Click on Create New Shipment
	public void Click_CreateNewShipment() {
		clickElement(driver, test, OCR_ShipmentWizard_CreateNewShipment, "Click on Create New Shipment");
	}
	
	//Click on Create New Shipment from Template
	public void Click_CreateNewShipmentfromTemplate() {
		clickElement(driver, test, OCR_ShipmentWizard_CreateNewShipmentfromTemplate, "Click on Create New Shipment from Template");
	}		
				
	//Click on Edit Shipment by Shipment No
	public void Click_EditShipmentbyShipmentNo() {
		clickElement(driver, test, OCR_ShipmentWizard_EditShipmentbyShipmentNo, "Click on Edit Shipment by Shipment No");
	}
	
	//Click on Create Customs Filing EEI from an Authorization
	public void Click_CreateCustomsFilingEEIfromanAuthorization() {
		clickElement(driver, test, OCR_ShipmentWizard_CreateCustomsFilingEEIfromanAuthorization, "Click on Create Customs Filing EEI from an Authorization");
	}		
		
	//select Sbu Code
	public void select_SBUcode(String SBUcode) {
		selectByVisibleText(driver, test, OCR_ShipmentWizard_SBUCode, "Select Sbu Code : ", SBUcode);
	}
	
	// click on Go button
	public void click_GoBtn() {
		clickElement(driver, test, OCR_ShipmentWizard_GoButton, "Click on Go button");
	}
	
	//Enter the Shipment No
	public void type_ShipmentNo(String ShipNo) {
		clearText(driver, test, OCR_ShipmentWizard_ByShipNo, "Clear the shipment that is existing already :");
		typeText(driver, test, OCR_ShipmentWizard_ByShipNo, "Type Ship No", ShipNo);
	}
	
	//Click on Search button 
	public void click_search() {
		clickElement(driver, test, OCR_ShipmentWizard_Search, "Click on Search button");
	}
}
