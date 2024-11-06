
package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class ShipWizardShipmentNoInformationPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_ShipmentNoInfo_TrackingNo = "//input[@id='editShipmentWizard_shipment_trackingNo']";
	public static final String OCR_ShipmentNoInfo_CountryofUltimateDestination = "//input[@id='editShipmentWizard_shipment_countryOfUltDest']";
	public static final String OCR_ShipmentNoInfo_SaveAndProceedBtn = "//button[@name='proceed']";
	public static final String OCR_ShipmentNoInfo_SaveBtn = "//button[@name='save']";
	public static final String OCR_ShipmentNoInfo_Exporter = "//table[@id='entityTable']//a[contains(text(),'Exporter')]";
	public static final String OCR_ShipmentNoInfo_Exporter_Code = "//a[@name='entityCodeLink']";
	public static final String OCR_ShipmentNoInfo_Exporter_ExpSearch = "//button[@name='Search']";
	public static final String OCR_ShipmentNoInfo_Exporter_ExpCode = "//input[@id='searchForm_popupValue_code']";
	public static final String OCR_ShipmentNoInfo_Exporter_ExpSelect = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_ShipmentNoInfo_Exporter_Save = "//button[@id='entitySave']";
	public static final String OCR_ShipmentNoInfo_Exporter_PopupClose = "(//button[@class='btn-close'])[1]";
	public static final String OCR_ShipmentNoInfo_UltConsignee = "//a[contains(text(),'Ult. Consignee')]";
	public static final String OCR_ShipmentNoInfo_UltConsignee_Code = "//a[@name='entityCodeLink']";
	public static final String OCR_ShipmentNoInfo_UltConsignee_ID = "//input[@id='resultConsigneeWithContactPopup_popupValue_code']";
	public static final String OCR_ShipmentNoInfo_UltConsignee_Search = "//button[@name='Search']";
	public static final String OCR_ShipmentNoInfo_UltConsignee_Select = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_ShipmentNoInfo_UltConsignee_Save = "//button[@id='entitySave']";
	public static final String OCR_ShipmentNoInfo_UltConsignee_PopupClose = "(//button[@class='btn-close'])[1]";
	public static final String OCR_ShipmentNoInfo_EndUserLink = "//a[contains(text(),'End User')]";
	public static final String OCR_ShipmentNoInfo_FreightForwarder = "//table[@id='entityTable']//a[contains(text(),'Freight Forwarder')]";
	public static final String OCR_ShipmentNoInfo_FF_Code = "//a[@name='entityCodeLink']";
	public static final String OCR_ShipmentNoInfo_FF_FFCode = "//input[@id='resultFfWithContactPopup_popupValue_code']";
	public static final String OCR_ShipmentNoInfo_FF_Search = "//button[@name='Search']";
	public static final String OCR_ShipmentNoInfo_FF_Select = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_ShipmentNoInfo_FF_Save = "//button[@id='entitySave']";
	public static final String OCR_ShipmentNoInfo_FF_PopupClose = "(//button[@class='btn-close'])[1]";
	public static final String OCR_ShipmentNoInfo_IntConsignee = "//a[contains(text(),'Intermediate Consignee')]";
	public static final String OCR_ShipmentNoInfo_IntConsignee_Code = "//a[@name='entityCodeLink']";
	public static final String OCR_ShipmentNoInfo_IntConsignee_Id = "//input[@id='resultConsigneeWithContactPopup_popupValue_code']";
	public static final String OCR_ShipmentNoInfo_IntConsignee_Search = "//button[@name='Search']";
	public static final String OCR_ShipmentNoInfo_IntConsignee_Select = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_ShipmentNoInfo_IntConsignee_Save = "//button[@id='entitySave']";
	public static final String OCR_ShipmentNoInfo_IntConsignee_FFRadio = "//input[@id='intConsEntitySourceF']";
	public static final String OCR_ShipmentNoInfo_IntConsignee_FFCode = "//a[@name='entityCodeLink']";
	public static final String OCR_ShipmentNoInfo_IntConsignee_FFCodeE = "//input[@id='resultFfWithContactPopup_popupValue_code']";
	public static final String OCR_ShipmentNoInfo_InvoiceAndPartyDetails = "//i[@class='fa fa-user-plus fa-2x']";
	public static final String OCR_ShipmentNoInfo_LineItems = "//i[@class='fa fa-list-alt fa-2x']";
	public static final String OCR_ShipmentNoInfo_ShipmentTerms = "//i[@class='fa fa-briefcase fa-2x']";
	public static final String OCR_ShipmentNoInfo_AdditionalCharges = "//i[@class='fa fa-percent fa-2x']";
	public static final String OCR_ShipmentNoInfo_ExportAuthorisations = "//i[@class='fa fa-gavel fa-2x']";
	public static final String OCR_ShipmentNoInfo_TSCAInformation = "//i[@class='fa fa-exclamation-triangle fa-2x']";
	public static final String OCR_ShipmentNoInfo_ScreeningValidations = "//i[@class='fa fa-check-square fa-2x']";
	public static final String OCR_ShipmentNoInfo_Questionnaire = "//nav[@class='main-menu']//i[@class='fa fa-question-circle']";
	public static final String OCR_ShipmentNoInfo_AttachDocsSubmit = "//i[@class='fa fa-file-text fa-2x']";
	public static final String OCR_ShipmentNoInfo_ShipmentNo = "//input[@id='editShipmentWizard_shipment_shipmentNo']";
	
	/* ******************************* Constructor ****************************** */

	public ShipWizardShipmentNoInformationPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	// Adding the ShipmentInfo
	public void addShipmentInfo(String TrackingNo, String UltDestination) {
		typeText(driver, test, OCR_ShipmentNoInfo_TrackingNo, "Enter the TrackingNo : ", TrackingNo);
		typeText(driver, test, OCR_ShipmentNoInfo_CountryofUltimateDestination,
				"Enter the Country of Ult. Destination : ", UltDestination);
	}
	
	// Validating parties to to the transaction for create request via template 
	public void validate_PartiestotheTransaction() {
		try {
			if (isDisplayed(driver, "//td[contains(text(),'Devanand Metangale')]")) {
				if (isDisplayed(driver, "//td[contains(text(),'Afsha Mir')]")) {
					if (isDisplayed(driver, "//td[contains(text(),'Amar Mishra')]")) {
					test.log(LogStatus.INFO, "Parties to the Transaction on requestor information page is displayed");
				}
			}
		}
			} catch (Exception e) {
			test.log(LogStatus.FAIL,"Parties to the Transaction on requestor information page is not displayed");
			testFailSshot(driver, test);		
  }
}
	
	// click on Save and Proceed button
	public void clickSaveAndProceedBtn() {
		scrollToBottom(driver);
		scrollToElement(driver, OCR_ShipmentNoInfo_SaveAndProceedBtn);
		Wait.waitfor(3);
		clickElement(driver, test, OCR_ShipmentNoInfo_SaveAndProceedBtn, "click on Save and Proceed button");
	}

	// click on save
	public void click_SaveBtn() {
		scrollToElement(driver, OCR_ShipmentNoInfo_SaveBtn);
		scrollToBottom(driver);
		scrollToElement(driver, OCR_ShipmentNoInfo_SaveBtn);
		Wait.waitfor(3);
		clickElement(driver, test, OCR_ShipmentNoInfo_SaveBtn, "click on Save button");

	}

	// click on Invoice And Party Details Icon
	public void clickInvoiceAndPartyDetailsIcon() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_ShipmentNoInfo_InvoiceAndPartyDetails,
				"click on Invoice And Party Details Icon");
	}

	// click on Line Items Icon
	public void clickLineItemsIcon() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_ShipmentNoInfo_LineItems, "click on Line Items Icon");
	}

	// click on Shipment Terms Icon
	public void clickShipmentTermsIcon() {
		Wait.wait(driver, "//label[contains(text(),'Loading Content')]");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_ShipmentNoInfo_ShipmentTerms, "click on Shipment Terms Icon");
	}

	// click on Additional Charges Icon
	public void clickAdditionalChargesIcon() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_ShipmentNoInfo_AdditionalCharges, "click on Additional Charges Icon");
	}

	// click on Export Authorisations Icon
	public void clickExportAuthorisationsIcon() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_ShipmentNoInfo_ExportAuthorisations, "click on Export Authorisations Icon");
	}

	// click on TSCA Information Icon
	public void clickTSCAInformationIcon() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_ShipmentNoInfo_TSCAInformation, "click on TSCA Information Icon");
	}

	// click on Screening Validations Icon
	public void clickScreeningValidationsIcon() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_ShipmentNoInfo_ScreeningValidations, "click on Screening Validations Icon");
	}

	// click on Questionnaire Icon
	public void clickQuestionnaireIcon() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_ShipmentNoInfo_Questionnaire, "click on Questionnaire Icon");
	}

	// click on Attach Docs & Submit Icon
	public void clickAttachDocsSubmitIcon() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_ShipmentNoInfo_AttachDocsSubmit, "click on Attach Docs & Submit Icon");
	}

	// Adding the Parties to the Transaction
	public void partiesToTheTransaction(String ExporterCode, String ConsigneeId, String FFCode,
			String IntConsigneePartyType, String EndUser) {
		scrollToElement(driver, "//legend[contains(text(),'Parties to the Transaction')]");
		Wait.waitfor(3);
		if (ExporterCode.length() > 0) {
			clickElement(driver, test, OCR_ShipmentNoInfo_Exporter, "click on Exporter link");
			try {
				clickElement(driver, test, OCR_ShipmentNoInfo_Exporter_Code, "click on exporter code Link");
				Wait.wait(driver, "//label[contains(text(),'Loading Content')]");
				Wait.waitfor(5);
				typeText(driver, test, OCR_ShipmentNoInfo_Exporter_ExpCode, "Enter Exporter Code : ", ExporterCode);
				clickElement(driver, test, OCR_ShipmentNoInfo_Exporter_ExpSearch, "Click On Search");
				String ExpCode = "//td[contains(text(),'" + ExporterCode.trim() + "')]";
				clickElement(driver, test, ExpCode, "Select Exporter Code : " + ExporterCode);
				clickElement(driver, test, OCR_ShipmentNoInfo_Exporter_ExpSelect, "Click on Select");
				Wait.waitfor(2);
				clickElement(driver, test, OCR_ShipmentNoInfo_Exporter_Save, "Click on Save");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_ShipmentNoInfo_Exporter_PopupClose, "Click on Cancel popup icon");
			}
		}
		if (ConsigneeId.length() > 0) {
			Wait.waitfor(3);
			scrollToBottom(driver);
			clickElement(driver, test, OCR_ShipmentNoInfo_UltConsignee, "Click on Ult Consignee Link");
			try {
				Wait.waitfor(3);
				clickElement(driver, test, OCR_ShipmentNoInfo_UltConsignee_Code, "Click on Ult Consignee Code Link");
				Wait.wait(driver, "//label[contains(text(),'Loading Content')]");
				Wait.waitfor(3);
				typeText(driver, test, OCR_ShipmentNoInfo_UltConsignee_ID, "Enter Consignee Id : ", ConsigneeId);
				clickElement(driver, test, OCR_ShipmentNoInfo_UltConsignee_Search, "Click On Search Button");
				String ConsCode = "//td[contains(text(),'" + ConsigneeId.trim() + "')]";
				clickElement(driver, test, ConsCode, "Select Consignee Code : " + ConsigneeId);
				clickElement(driver, test, OCR_ShipmentNoInfo_UltConsignee_Select, "Click on Select Button");
				Wait.waitfor(3);
				clickElement(driver, test, OCR_ShipmentNoInfo_UltConsignee_Save, "Click on Save Button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_ShipmentNoInfo_UltConsignee_PopupClose, "Click on cancel popup icon");
			}
		}
		if (FFCode.length() > 0) {
			scrollToBottom(driver);
			scrollToElement(driver, OCR_ShipmentNoInfo_FreightForwarder);
			Wait.waitfor(3);
			scrollToBottom(driver);
			clickElement(driver, test, OCR_ShipmentNoInfo_FreightForwarder, "Click on Freight Forwarder Link");
			try {
				clickElement(driver, test, OCR_ShipmentNoInfo_FF_Code, "Click on Freight forwarder code Link");
				Wait.wait(driver, "//label[contains(text(),'Loading Content')]");
				Wait.waitfor(3);
				typeText(driver, test, OCR_ShipmentNoInfo_FF_FFCode, "Enter FF Code", FFCode);
				clickElement(driver, test, OCR_ShipmentNoInfo_FF_Search, "Click On Search Button");
				String FFCodeSel = "//td[contains(text(),'" + FFCode.trim() + "')]";
				clickElement(driver, test, FFCodeSel, "Select FF Code : " + FFCode);
				clickElement(driver, test, OCR_ShipmentNoInfo_FF_Select, "Click on Select Button");
				Wait.waitfor(3);
				clickElement(driver, test, OCR_ShipmentNoInfo_FF_Save, "Click on save Button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_ShipmentNoInfo_FF_PopupClose, "Click on Cancel popup icon");
			}
		}
		if (IntConsigneePartyType.length() > 0) {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_ShipmentNoInfo_IntConsignee, "Click On IntConsignee Link");
			Wait.wait(driver, "//label[contains(text(),'Loading Content')]");
			Wait.waitfor(3);
			try {
				clickElement(driver, test, OCR_ShipmentNoInfo_IntConsignee_Code, "Click on IntConsignee code Link");
				typeText(driver, test, OCR_ShipmentNoInfo_IntConsignee_Id, "Enter Consignee Id : ", ConsigneeId);
				clickElement(driver, test, OCR_ShipmentNoInfo_IntConsignee_Search, "Click on Search Button");
				String ConsCode = "//table[@id='gridPopup']/tbody//tr/td[contains(text(),'" + ConsigneeId.trim()
						+ "')]";
				isDisplayed(driver, ConsCode);
				mouseOverAndClick(driver, test, ConsCode, "Select Consignee Code : " + ConsigneeId);
				clickElement(driver, test, OCR_ShipmentNoInfo_IntConsignee_Select, "Click on Select Button");
				Wait.waitfor(3);
				clickElement(driver, test, OCR_ShipmentNoInfo_IntConsignee_Save, "CLick on Save Button");

			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_ShipmentNoInfo_FF_PopupClose, "Click on Cancel popup icon");
			}
		}
		if (EndUser.length() > 0) {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_ShipmentNoInfo_EndUserLink, "Click on End User Link");
			try {
				clickElement(driver, test, OCR_ShipmentNoInfo_UltConsignee_Code, "Click on Consignee Code Link");
				typeText(driver, test, OCR_ShipmentNoInfo_UltConsignee_ID, "Enter Consignee Id : ", EndUser);
				clickElement(driver, test, OCR_ShipmentNoInfo_UltConsignee_Search, "Click On Search Button");
				String ConsCode = "//td[contains(text(),'" + EndUser.trim() + "')]";
				clickElement(driver, test, ConsCode, "Select Consignee Code : " + EndUser);
				clickElement(driver, test, OCR_ShipmentNoInfo_UltConsignee_Select, "Click on Select Button");
				Wait.waitfor(3);
				clickElement(driver, test, OCR_ShipmentNoInfo_UltConsignee_Save, "Click on Save Button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_ShipmentNoInfo_FF_PopupClose, "Click on Cancel popup icon");
			}
		}
	}
	
	//Getting the value of Shipment No
	public String get_ShipmentNo() {
		return getAttribute(driver, test, OCR_ShipmentNoInfo_ShipmentNo, "value", "Getting the Shipment No : ");
	}
	
	//Validating the shipment no Information error
	public void valdatingShipNoInfo() {
		try {
			if (isDisplayed(driver, "//h4[contains(text(),'Error!')]")) {

				if (isDisplayed(driver,
						"//li[contains(text(),'Exporter is required.')]")) {
					test.log(LogStatus.INFO, "Exporter is required.");
				}
				if (isDisplayed(driver,
						"//li[contains(text(),'Ult Consignee is required.')]")) {
					test.log(LogStatus.INFO, "Ult Consignee is required.");
				}
				if (isDisplayed(driver, "//li[contains(text(),'Country of Ultimate Destination is missing')]")) {
					test.log(LogStatus.INFO, "Country of Ultimate Destination is missing");
				}
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL,
					"Error Vaildation is not Displayed by clicking on SAVE button in shipment no Information page");
		}
	
	}
	
	//Getting the ult.consignee entity name
	public String getUltConsignee() {
		String entityName= "//table[@id='entityTable']/tbody/tr[2]/td[3]";
		return getText(driver, test, entityName, "Get the get Ult.Consignee Entity Name : ");
	}
	
	//Validating the Ultimate Consignee On Hold
	public void validationofConsigneeStatus() {
		clickElement(driver, test, OCR_ShipmentNoInfo_UltConsignee, "Click on Ult Consignee Link :");
		String status =getSelectFirstText(driver, test, "//select[@id='tempWlsStatus']", "Getting the Ultimate Consignee Status :");
		try {
			if(status.equalsIgnoreCase("On Hold")) {
				test.log(LogStatus.PASS, "Status is On Hold :");
			}
		}catch(Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Status is Not On Hold :");
		}
		clickElement(driver, test, "(//button[@class='btn-close'])[1]", "Clicking on Close Pop up Icon :");
	}
	
	//Consignee Length Validation Check
	public void consigneeLengthValidationCheck(String ConsigneeId, String ConsigneeAdd1, String ConsigneeAdd2, String ConsigneeAdd3) {
		scrollToElement(driver, OCR_ShipmentNoInfo_UltConsignee);
		clickElement(driver, test, OCR_ShipmentNoInfo_UltConsignee, "Click on Ult Consignee Link");
		try {
			Wait.waitfor(3);
			clearText(driver, test, "(//input[@name='shipment.ultConsName'])[2]", "Clearing the Text :");
			typeText(driver, test, "(//input[@name='shipment.ultConsName'])[2]", "Enter Consignee Id : ", ConsigneeId);
			clearText(driver, test, "(//input[@name='shipment.ultConsAddr1'])[2]", "Clearing the Text :");
			typeText(driver, test, "(//input[@name='shipment.ultConsAddr1'])[2]", "Enter Consignee Address 1 :", ConsigneeAdd1);
			clearText(driver, test, "(//input[@name='shipment.ultConsAddr2'])[2]", "Clearing the Text :");
			typeText(driver, test, "(//input[@name='shipment.ultConsAddr2'])[2]", "Entering Consignee Adrress 2 :", ConsigneeAdd2);
			clearText(driver, test, "(//input[@name='shipment.ultConsAddr3'])[2]", "Clearing the Text :");
			typeText(driver, test, "(//input[@name='shipment.ultConsAddr3'])[2]", "Entering Consignee Address 3 :", ConsigneeAdd3);
			Wait.waitfor(3);
			clickElement(driver, test, OCR_ShipmentNoInfo_UltConsignee_Save, "Click on Save Button");
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_ShipmentNoInfo_UltConsignee_PopupClose, "Click on cancel popup icon");
		}
	}
	
	// Adding the Exporter to the Transaction
	public void addExporter(String ExporterName, String ExportAdd1, String ExportAdd2, String ExportAdd3, 
		String ExportCity, String ExportCountry, String ExportState, String ExportPhoneNo) {
		scrollToElement(driver, "//legend[contains(text(),'Parties to the Transaction')]");
		Wait.waitfor(3);
		if (ExporterName.length() > 0) {
			clickElement(driver, test, OCR_ShipmentNoInfo_Exporter, "click on Exporter link");
			try {
				typeText(driver, test, "(//input[@name='shipment.expName'])[2]", "Entering Exporter name :", ExporterName);
				typeText(driver, test, "(//input[@name='shipment.exporterContactAddr1'])[2]", "Entering Exporter Address 1 :", ExportAdd1);
				typeText(driver, test, "(//input[@name='shipment.exporterContactAddr2'])[2]", "Entering Exporter Address 2 :", ExportAdd2);
				typeText(driver, test, "(//input[@name='shipment.exporterContactAddr3'])[2]", "Entering Exporter Address 3 :", ExportAdd3);
				typeText(driver, test, "(//input[@name='shipment.exporterContactCity'])[2]", "Entering Exporter City :", ExportCity);
				typeText(driver, test, "(//input[@name='shipment.expCountryName'])[2]", "Entering Exporter Country :", ExportCountry);
				typeText(driver, test, "(//input[@name='shipment.exporterContactState'])[2]", "Entering Export State :", ExportState);
				typeText(driver, test, "(//input[@name='shipment.exporterContactPhone'])[2]", "Entering Export Phone No :", ExportPhoneNo);
				clickElement(driver, test, OCR_ShipmentNoInfo_Exporter_Save, "Click on Save");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_ShipmentNoInfo_Exporter_PopupClose, "Click on Cancel popup icon");
			}
		}
	}
	
	// Adding the Ultimate Consignee to the Transaction
	public void addUltimateConsignee(String UltimateConsigneeName, String UltimateConsigneeAdd1, String UltimateConsigneeAdd2, 
			String UltimateConsigneeAdd3, String UltimateConsigneeCity, String UltimateConsigneeCountry, String UltimateConsigneeState, 
			String UltimateConsigneePhoneNo) {
		if (UltimateConsigneeName.length() > 0) {
			clickElement(driver, test, OCR_ShipmentNoInfo_UltConsignee, "Click on Ult Consignee Link");
			try {
				typeText(driver, test, "(//input[@name='shipment.ultConsName'])[2]", "Entering Exporter name :", UltimateConsigneeName);
				typeText(driver, test, "(//input[@name='shipment.ultConsAddr1'])[2]", "Entering Exporter Address 1 :", UltimateConsigneeAdd1);
				typeText(driver, test, "(//input[@name='shipment.ultConsAddr2'])[2]", "Entering Exporter Address 2 :", UltimateConsigneeAdd2);
				typeText(driver, test, "(//input[@name='shipment.ultConsAddr3'])[2]", "Entering Exporter Address 3 :", UltimateConsigneeAdd3);
				typeText(driver, test, "(//input[@name='shipment.ultConsCity'])[2]", "Entering Exporter City :", UltimateConsigneeCity);
				typeText(driver, test, "(//input[@name='shipment.ultConsCountryName'])[2]", "Entering Exporter Country :", UltimateConsigneeCountry);
				typeText(driver, test, "(//input[@name='shipment.ultConsContactState'])[2]", "Entering Export State :", UltimateConsigneeState);
				typeText(driver, test, "(//input[@name='shipment.ultConsContactPhone'])[2]", "Entering Export Phone No :", UltimateConsigneePhoneNo);
				clickElement(driver, test, OCR_ShipmentNoInfo_UltConsignee_Save, "Click on Save Button");
				} catch (Exception e) {
					testFailSshot(driver, test);
					clickElement(driver, test, OCR_ShipmentNoInfo_UltConsignee_PopupClose, "Click on cancel popup icon");
				}
			}
	}
	
	// Adding the InterMediate Consignee to the Transaction
	public void addIntermediateConsignee(String IntermediateConsigneeName, String IntermediateConsigneeAdd1, String IntermediateConsigneeAdd2, 
			String IntermediateConsigneeAdd3, String IntermediateConsigneeCity, String IntermediateConsigneeCountry, String IntermediateConsigneeState, 
			String IntermediateConsigneePhoneNo) {
		if (IntermediateConsigneeName.length() > 0) {
			clickElement(driver, test, OCR_ShipmentNoInfo_IntConsignee, "Click On IntConsignee Link");
			try {
				typeText(driver, test, "(//input[@name='shipment.intConsName'])[2]", "Entering Exporter name :", IntermediateConsigneeName);
				typeText(driver, test, "(//input[@name='shipment.intConsAddr1'])[2]", "Entering Exporter Address 1 :", IntermediateConsigneeAdd1);
				typeText(driver, test, "(//input[@name='shipment.intConsAddr2'])[2]", "Entering Exporter Address 2 :", IntermediateConsigneeAdd2);
				typeText(driver, test, "(//input[@name='shipment.intConsAddr3'])[2]", "Entering Exporter Address 3 :", IntermediateConsigneeAdd3);
				typeText(driver, test, "(//input[@name='shipment.intConsCity'])[2]", "Entering Exporter City :", IntermediateConsigneeCity);
				typeText(driver, test, "(//input[@name='shipment.intConsCountryName'])[2]", "Entering Exporter Country :", IntermediateConsigneeCountry);
				typeText(driver, test, "(//input[@name='shipment.intConsState'])[2]", "Entering Export State :", IntermediateConsigneeState);
				typeText(driver, test, "(//input[@name='shipment.intConsContactPhoneNew'])[2]", "Entering Export Phone No :", IntermediateConsigneePhoneNo);
				clickElement(driver, test, OCR_ShipmentNoInfo_FF_Save, "Click on save Button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_ShipmentNoInfo_FF_PopupClose, "Click on Cancel popup icon");
			}
		}
	}
	
	// Adding the End User to the Transaction
	public void addEndUser(String EndUserName, String EndUserAdd1, String EndUserAdd2, String EndUserAdd3, String EndUserCity, 
			String EndUserCountry, String EndUserState, String EndUserPhoneNo) {
		if (EndUserName.length() > 0) {
			clickElement(driver, test, OCR_ShipmentNoInfo_EndUserLink, "Click on End User Link");
			try {
				typeText(driver, test, "(//input[@name='shipment.endUserName'])[2]", "Entering Exporter name :", EndUserName);
				typeText(driver, test, "(//input[@name='shipment.endUserAddr1'])[2]", "Entering Exporter Address 1 :", EndUserAdd1);
				typeText(driver, test, "(//input[@name='shipment.endUserAddr2'])[2]", "Entering Exporter Address 2 :", EndUserAdd2);
				typeText(driver, test, "(//input[@name='shipment.endUserAddr3'])[2]", "Entering Exporter Address 3 :", EndUserAdd3);
				typeText(driver, test, "(//input[@name='shipment.endUserCity'])[2]", "Entering Exporter City :", EndUserCity);
				typeText(driver, test, "(//input[@name='shipment.endUserCountryName'])[2]", "Entering Exporter Country :", EndUserCountry);
				typeText(driver, test, "(//input[@name='shipment.endUserState'])[2]", "Entering Export State :", EndUserState);
				typeText(driver, test, "(//input[@name='shipment.endUserContactPhone'])[2]", "Entering Export Phone No :", EndUserPhoneNo);
				clickElement(driver, test, OCR_ShipmentNoInfo_IntConsignee_Save, "CLick on Save Button");
			} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_ShipmentNoInfo_FF_PopupClose, "Click on Cancel popup icon");
			}
		}
	}
	
	// Adding the Freight Forwarder to the Transaction
	public void addFreightForwarder(String FreightForwarderName, String FreightForwarderAdd1, String FreightForwarderAdd2, 
			String FreightForwarderAdd3, String FreightForwarderCity, String FreightForwarderCountry, String FreightForwarderState,
			String FreightForwarderPhoneNo) {
		if (FreightForwarderName.length() > 0) {
			clickElement(driver, test, OCR_ShipmentNoInfo_FreightForwarder, "Click on Freight Forwarder Link");
			try {
				typeText(driver, test, "(//input[@name='shipment.ffAgentName'])[2]", "Entering Exporter name :", FreightForwarderName);
				typeText(driver, test, "(//input[@name='shipment.ffAgentAddr1'])[2]", "Entering Exporter Address 1 :", FreightForwarderAdd1);
				typeText(driver, test, "(//input[@name='shipment.ffAgentAddr2'])[2]", "Entering Exporter Address 2 :", FreightForwarderAdd2);
				typeText(driver, test, "(//input[@name='shipment.ffAgentAddr3'])[2]", "Entering Exporter Address 3 :", FreightForwarderAdd3);
				typeText(driver, test, "(//input[@name='shipment.ffAgentCity'])[2]", "Entering Exporter City :", FreightForwarderCity);
				typeText(driver, test, "(//input[@name='shipment.ffAgentCountryName'])[2]", "Entering Exporter Country :", FreightForwarderCountry);
				typeText(driver, test, "(//input[@name='shipment.ffAgentState'])[2]", "Entering Export State :", FreightForwarderState);
				typeText(driver, test, "(//input[@name='shipment.ffContactPhone'])[2]", "Entering Export Phone No :", FreightForwarderPhoneNo);
				clickElement(driver, test, OCR_ShipmentNoInfo_UltConsignee_Save, "Click on Save Button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_ShipmentNoInfo_FF_PopupClose, "Click on Cancel popup icon");
			}
		}
	}
	
	//Accept Alert Msg
	public void alertmsg() {
		try {
			AlertPopUp(driver, test, "Ultimate Consignee Country and Country of Ultimate Destination are not the same. Do you still want to proceed?");
			test.log(LogStatus.PASS, "Alert is Accepted :");
		}catch(Exception e) {
			test.log(LogStatus.INFO, "Alert is Not Displayed :");
		}
	}
}
