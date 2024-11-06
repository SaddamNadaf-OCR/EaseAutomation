package globalExportClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;
import utilities.Wait;

public class CreateNewOrderItemHazmatDetailsPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_ItemHazmat_OCRHazmatIDLink = "//a[@id='unidno-popup']";
	public static final String OCR_ItemHazmat_HazmatClassSearch = "//input[@id='searchForm_hazmat_hazardClassOrDivision']";
	public static final String OCR_ItemHazmat_HazmatSearch = "//button[@name='Search']";
	public static final String OCR_ItemHazmat_HazmatSelect = "//div[@id='resultDIV']//div[1]//div[1]//button[1]";
	public static final String OCR_ItemHazmat_ClosePopUp = "//div[@id='ocrModal']//button[@class='btn-close']";
	public static final String OCR_ItemHazmat_IdentificationNumber = "//input[@id='editInvoiceItem_invoiceItem_identificationNo']";
	public static final String OCR_ItemHazmat_Class = "//input[@id='editInvoiceItem_invoiceItem_classDivision']";
	public static final String OCR_ItemHazmat_Divisoin = "//input[@id='editInvoiceItem_invoiceItem_classOrDivisionDescription']";
	public static final String OCR_ItemHazmat_PackingGroup = "//input[@id='editInvoiceItem_invoiceItem_pckGrp']";
	public static final String OCR_ItemHazmat_PackingInstructions = "//input[@id='editInvoiceItem_invoiceItem_shpNoKindOfPck']";
	public static final String OCR_ItemHazmat_Authorisation = "//input[@id='editInvoiceItem_invoiceItem_pckAuth']";
	public static final String OCR_ItemHazmat_Noandkindofpack = "//input[@id='editInvoiceItem_invoiceItem_shpNoKindOfPck']";
	public static final String OCR_ItemHazmat_GrossWeight = "//input[@id='editInvoiceItem_invoiceItem_grossMass']";
	public static final String OCR_ItemHazmat_Cube = "//input[@id='editInvoiceItem_invoiceItem_cube']";
	public static final String OCR_ItemHazmat_NetWeight = "//input[@id='editInvoiceItem_invoiceItem_netMass']";
	public static final String OCR_ItemHazmat_CCI = "//input[@id='editInvoiceItem_cci']/../div/div";
	public static final String OCR_ItemHazmat_Hazardous = "//input[@id='editInvoiceItem_hazardous']/../div/div";
	public static final String OCR_ItemHazmat_TSCA12 = "//input[@id='editInvoiceItem_tsca']/../div/div";
	public static final String OCR_ItemHazmat_Hazmat = "//input[@id='editInvoiceItem_hazmat']/../div/div";
	public static final String OCR_ItemHazmat_Save = "//button[@id='saveSubmitBtn']";
	public static final String OCR_ItemHazmat_SaveAndReturn = "//button[@id='saveAndReturnInvoiceItem']";

	public static final String OCR_ItemHazmat_Regres_HazmatIDLink = "//a[@id='unidno-popup']";
	public static final String OCR_ItemHazmat_Regres_RegulationOption = "//select[@id='searchForm_hazmat_regulation']";
	public static final String OCR_ItemHazmat_Regres_RegulationSearch = "//button[@name='Search']";
	public static final String OCR_ItemHazmat_Regres_HazmatIDSelectBtn = "(//button[@name='Ok'])[1]";
	public static final String OCR_ItemHazmat_Regres_HazmatCloseBtn = "(//button[@class='btn-close'])[1]";
	public static final String OCR_ItemHazmat_Regres_EnterHazmat = "//input[@id='editInvoiceItem_invoiceItem_unIdNo']";
	public static final String OCR_ItemHazmat_Regres_SelectRegulation = "//select[@id='hzmtRegulationId']";
	public static final String OCR_ItemHazmat_Regres_NoKindOfPckge = "//input[@id='editInvoiceItem_invoiceItem_shpNoKindOfPck']";
	public static final String OCR_ItemHazmat_Regres_PackingGrp = "//input[@id='editInvoiceItem_invoiceItem_pckGrp']";
	public static final String OCR_ItemHazmat_Regres_GrossWt = "//input[@id='editInvoiceItem_invoiceItem_grossMass']";
	public static final String OCR_ItemHazmat_Regres_Auth = "//input[@id='editInvoiceItem_invoiceItem_pckAuth']";
	public static final String OCR_ItemHazmat_Regres_Techname = "//input[@id='editInvoiceItem_invoiceItem_technicalName']";
	public static final String OCR_ItemHazmat_Regres_SubRisk = "//input[@id='editInvoiceItem_invoiceItem_subRisk']";
	public static final String OCR_ItemHazmat_Regres_TransportMode = "//select[@name='invoiceItem.aircraftCategoryType']";
	public static final String OCR_ItemHazmat_Regres_Cube = "//input[@id='editInvoiceItem_invoiceItem_cube']";
	public static final String OCR_ItemHazmat_Regres_NetWt = "//input[@id='editInvoiceItem_invoiceItem_netMass']";
	public static final String OCR_ItemHazmat_Regres_SaveBtn = "//button[@id='saveSubmitBtn']";
	
	
	/* ******************************* Constructor ****************************** */

	public CreateNewOrderItemHazmatDetailsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	// Select the Hazamat Details Switch
	public void select_HazamatDetailsSwitch(String CCI, String Hazardous, String TSCA12, String Hazmat) {
		if (CCI.equalsIgnoreCase("Yes")) {
			clickElement(driver, test, OCR_ItemHazmat_CCI, "Select CCI Switch as Yes");
		} else if (Hazardous.equalsIgnoreCase("Yes")) {
			clickElement(driver, test, OCR_ItemHazmat_Hazardous, "Select Hazardous Switch as Yes");
		} else if (TSCA12.equalsIgnoreCase("Yes")) {
			clickElement(driver, test, OCR_ItemHazmat_TSCA12, "Select the TCSA 12 (b) as Yes");
		} else if (Hazmat.equalsIgnoreCase("Yes")) {
			clickElement(driver, test, OCR_ItemHazmat_Hazmat, "Select the Hazmat as Yes");
		}
	}

	// Add the Hazamat Information
	public void add_HazmatInformation(String SearchHazardClassorDivision, String HazmatIdentifactionNumber,
			String HazmatClass, String HazmatDivision, String HazmatGroup, String HazmatPackingInstruction,
			String HazmatAuthorisation, String HazmatNoAndKindOfPack, String HazmatGrossWeight, String HazmatNetWeight,
			String HazmatCube) {
		Wait.waitfor(3);
		if (SearchHazardClassorDivision.length() > 0) {
			clickElement(driver, test, OCR_ItemHazmat_OCRHazmatIDLink, "Click on OCR Hazmat ID");
			try {
				typeText(driver, test, OCR_ItemHazmat_HazmatClassSearch, "Enter the Search Hazmat Class or Division : ",
						SearchHazardClassorDivision);
				clickElement(driver, test, OCR_ItemHazmat_HazmatSearch, "Click on Search");
				clickElement(driver, test, "//td[contains(text(),'" + SearchHazardClassorDivision + "')]",
						"Select the hazard class or Division : " + SearchHazardClassorDivision);
				clickElement(driver, test, OCR_ItemHazmat_HazmatSelect, "Click on Select");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_ItemHazmat_ClosePopUp, "Click on Pop Up Close button");
			}
		}
		typeText(driver, test, OCR_ItemHazmat_IdentificationNumber, "Enter the Identification Number : ",
				HazmatIdentifactionNumber);
		typeText(driver, test, OCR_ItemHazmat_Class, "Enter the Class : ", HazmatClass);
		typeText(driver, test, OCR_ItemHazmat_Divisoin, "Enter the Division : ", HazmatDivision);
		typeText(driver, test, OCR_ItemHazmat_PackingGroup, "Enter the Packing Group : ", HazmatGroup);
		typeText(driver, test, OCR_ItemHazmat_PackingInstructions, "Enter the Packing Instruction : ",
				HazmatPackingInstruction);
		typeText(driver, test, OCR_ItemHazmat_Authorisation, "Enter the Authorization : ", HazmatAuthorisation);
		typeText(driver, test, OCR_ItemHazmat_Noandkindofpack, "Enter the No and Kind of Pack : ",
				HazmatNoAndKindOfPack);
		typeText(driver, test, OCR_ItemHazmat_GrossWeight, "Enter the Gross Weight : ", HazmatGrossWeight);
		typeText(driver, test, OCR_ItemHazmat_NetWeight, "Enter the Net Weight : ", HazmatNetWeight);
		typeText(driver, test, OCR_ItemHazmat_Cube, "Enter the Cube (m3) : ", HazmatCube);
	}

	// Hazmat details for Regression US
	public void hazmatInfo(String hazmatID, String Regulation, String RegOption, String KindOfPack, String Packgrp,
			String GrsWt, String Auth, String Techname, String SubRisk, String TransMode, String Cube, String NetWet) {

		if (hazmatID.length() > 0) {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_ItemHazmat_Regres_HazmatIDLink,
					"Click on Hazmat ID link");
			selectByVisibleText(driver, test, OCR_ItemHazmat_Regres_RegulationOption,
					"Select Regualtion : ", Regulation);
			Wait.waitfor(3);
			clickElement(driver, test, OCR_ItemHazmat_Regres_RegulationSearch,
					"Click on Search button :");
			try {
				Wait.waitfor(3);
				clickElement(driver, test, "//td[contains(text(),'" + hazmatID + "')]",
						"Select the Hazmat ID : " + hazmatID);
				clickElement(driver, test, OCR_ItemHazmat_Regres_HazmatIDSelectBtn,
						"Click on Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_ItemHazmat_Regres_HazmatCloseBtn,
						"Click on Close popup icon");
			}
		}

		typeText(driver, test, OCR_ItemHazmat_Regres_EnterHazmat, "Enter Hazmat ID : ", hazmatID);
		selectByVisibleText(driver, test, OCR_ItemHazmat_Regres_SelectRegulation,
				"Enter Regulation option : ", RegOption);
		typeText(driver, test, OCR_ItemHazmat_Regres_NoKindOfPckge,
				"Enter No & kind of package : ", KindOfPack);
		typeText(driver, test, OCR_ItemHazmat_Regres_PackingGrp, "Enter packing group : ",
				Packgrp);
		typeText(driver, test, OCR_ItemHazmat_Regres_GrossWt, "Enter Gross Weight : ", GrsWt);
		typeText(driver, test, OCR_ItemHazmat_Regres_Auth, "Enter Authorization : ", Auth);
		typeText(driver, test, OCR_ItemHazmat_Regres_Techname, "Enter Technical name : ",
				Techname);
		typeText(driver, test, OCR_ItemHazmat_Regres_SubRisk, "Enter Sub Risk : ", SubRisk);
		selectByVisibleText(driver, test, OCR_ItemHazmat_Regres_TransportMode,
				"Select Transportation Mode : ", TransMode);
		typeText(driver, test, OCR_ItemHazmat_Regres_Cube, "Enter Cube : ", Cube);
		typeText(driver, test, OCR_ItemHazmat_Regres_NetWt, "Enter Net Weight : ", NetWet);
		Wait.waitfor(2);
		scrollToElement(driver, OCR_ItemHazmat_Regres_SaveBtn);
	}

	// Click on Save
	public void click_SaveItemHazmatDetails() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_ItemHazmat_Save, "Click on Save in Item Hazmat Details");
		Wait.waitfor(2);
	}

	// click on Save and Return
	public void click_SaveAndReturn() {
		clickElement(driver, test, OCR_ItemHazmat_SaveAndReturn, "Click on Save and Return in Item Hazmat Details");
	}
}
