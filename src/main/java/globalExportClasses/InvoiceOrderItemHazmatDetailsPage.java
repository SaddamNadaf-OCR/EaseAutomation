package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class InvoiceOrderItemHazmatDetailsPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_InvoiceOrderItemHazmatDetailsPage_HazmatID = "//input[@id='editInvoiceItem_invoiceItem_unIdNo']";
	public static final String OCR_InvoiceOrderItemHazmatDetailsPage_HazmatSaveBtn = "//button[@id='saveSubmitBtn']";
	public static final String OCR_InvoiceOrderItemHazmatDetailsPage_AdditionalTransactionDetails = "//i[@class='fa fa-th']";
	public static final String OCR_InvoiceOrderItemHazmatDetailsPage_SubCompDetails = "//a[contains(text(),'Sub Component')]";
	
	public static final String OCR_InvoiceOrderItemHazmatDetailsPage_Regres_HazmatIDLink = "//a[@id='unidno-popup']";
	public static final String OCR_InvoiceOrderItemHazmatDetailsPage_Regres_RegulationOption = "//select[@id='searchForm_hazmat_regulation']";
	public static final String OCR_InvoiceOrderItemHazmatDetailsPage_Regres_RegulationSearch = "//button[@name='Search']";
	public static final String OCR_InvoiceOrderItemHazmatDetailsPage_Regres_HazmatIDSelectBtn = "(//button[@name='Ok'])[1]";
	public static final String OCR_InvoiceOrderItemHazmatDetailsPage_Regres_HazmatCloseBtn = "(//button[@class='btn-close'])[1]";
	public static final String OCR_InvoiceOrderItemHazmatDetailsPage_Regres_SelectRegulation = "//select[@id='hzmtRegulationId']";
	public static final String OCR_InvoiceOrderItemHazmatDetailsPage_Regres_NoKindOfPckge = "//input[@id='editInvoiceItem_invoiceItem_shpNoKindOfPck']";
	public static final String OCR_InvoiceOrderItemHazmatDetailsPage_Regres_PackingGrp = "//input[@id='editInvoiceItem_invoiceItem_pckGrp']";
	public static final String OCR_InvoiceOrderItemHazmatDetailsPage_Regres_GrossWt = "//input[@id='editInvoiceItem_invoiceItem_grossMass']";
	public static final String OCR_InvoiceOrderItemHazmatDetailsPage_Regres_Auth = "//input[@id='editInvoiceItem_invoiceItem_pckAuth']";
	public static final String OCR_InvoiceOrderItemHazmatDetailsPage_Regres_Techname = "//input[@id='editInvoiceItem_invoiceItem_technicalName']";
	public static final String OCR_InvoiceOrderItemHazmatDetailsPage_Regres_SubRisk = "//input[@id='editInvoiceItem_invoiceItem_subRisk']";
	public static final String OCR_InvoiceOrderItemHazmatDetailsPage_Regres_TransportMode = "//select[@name='invoiceItem.aircraftCategoryType']";
	public static final String OCR_InvoiceOrderItemHazmatDetailsPage_Regres_Cube = "//input[@id='editInvoiceItem_invoiceItem_cube']";
	public static final String OCR_InvoiceOrderItemHazmatDetailsPage_Regres_NetWt = "//input[@id='editInvoiceItem_invoiceItem_netMass']";
	public static final String OCR_InvoiceOrderItemHazmatDetailsPage_Regres_SaveBtn = "//button[@id='saveSubmitBtn']";
	
	
	/* ******************************* Constructor ****************************** */

	public InvoiceOrderItemHazmatDetailsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */
	public void hazmatInfo(String hazmatID) {
		typeText(driver, test, OCR_InvoiceOrderItemHazmatDetailsPage_HazmatID, "Enter Hazmat ID : ", hazmatID);
	}
	
	//Hazmat details for Regression US
	public void hazmatInfo(String hazmatID, String Regulation, String RegOption, String KindOfPack, String Packgrp, String GrsWt, String Auth, String Techname, String SubRisk, String TransMode, String Cube, String NetWet) {
		
		if (hazmatID.length() > 0) {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_InvoiceOrderItemHazmatDetailsPage_Regres_HazmatIDLink, "Click on Hazmat ID link");
			selectByVisibleText(driver, test, OCR_InvoiceOrderItemHazmatDetailsPage_Regres_RegulationOption, "Select Regualtion : ", Regulation);
			Wait.waitfor(3);
			clickElement(driver, test, OCR_InvoiceOrderItemHazmatDetailsPage_Regres_RegulationSearch, "Click on Search button :");
			try {
				Wait.waitfor(3);
				clickElement(driver, test, "//td[contains(text(),'" + hazmatID + "')]", "Select the Hazmat ID : " + hazmatID);
				clickElement(driver, test, OCR_InvoiceOrderItemHazmatDetailsPage_Regres_HazmatIDSelectBtn, "Click on Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_InvoiceOrderItemHazmatDetailsPage_Regres_HazmatCloseBtn,
						"Click on Close popup icon");
			}
		}
		
		typeText(driver, test, OCR_InvoiceOrderItemHazmatDetailsPage_HazmatID, "Enter Hazmat ID : ", hazmatID);
		selectByVisibleText(driver, test, OCR_InvoiceOrderItemHazmatDetailsPage_Regres_SelectRegulation, "Enter Regulation option : ", RegOption);
		typeText(driver, test, OCR_InvoiceOrderItemHazmatDetailsPage_Regres_NoKindOfPckge, "Enter No & kind of package : ", KindOfPack);
		typeText(driver, test, OCR_InvoiceOrderItemHazmatDetailsPage_Regres_PackingGrp, "Enter packing group : ", Packgrp);
		typeText(driver, test, OCR_InvoiceOrderItemHazmatDetailsPage_Regres_GrossWt, "Enter Gross Weight : ", GrsWt);
		typeText(driver, test, OCR_InvoiceOrderItemHazmatDetailsPage_Regres_Auth, "Enter Authorization : ", Auth);
		typeText(driver, test, OCR_InvoiceOrderItemHazmatDetailsPage_Regres_Techname, "Enter Technical name : ", Techname);
		typeText(driver, test, OCR_InvoiceOrderItemHazmatDetailsPage_Regres_SubRisk, "Enter Sub Risk : ", SubRisk);
		selectByVisibleText(driver, test, OCR_InvoiceOrderItemHazmatDetailsPage_Regres_TransportMode, "Select Transportation Mode : ", TransMode);
		typeText(driver, test, OCR_InvoiceOrderItemHazmatDetailsPage_Regres_Cube, "Enter Cube : ", Cube);
		typeText(driver, test, OCR_InvoiceOrderItemHazmatDetailsPage_Regres_NetWt, "Enter Net Weight : ", NetWet);
		Wait.waitfor(2);
		scrollToElement(driver, OCR_InvoiceOrderItemHazmatDetailsPage_Regres_SaveBtn);
	}
	
	public void hazmatSaveBtn() {
		
		scrollToElement(driver, OCR_InvoiceOrderItemHazmatDetailsPage_Regres_SaveBtn);
		Wait.waitfor(2);
		clickElement(driver, test, OCR_InvoiceOrderItemHazmatDetailsPage_HazmatSaveBtn, "Click on Save button");
	}
	
	public void subComponentDetails() {
		scrollToElement(driver, OCR_InvoiceOrderItemHazmatDetailsPage_AdditionalTransactionDetails);
		clickElement(driver, test, OCR_InvoiceOrderItemHazmatDetailsPage_AdditionalTransactionDetails, "Click on Additional Transaction Details");
		clickElement(driver, test, OCR_InvoiceOrderItemHazmatDetailsPage_SubCompDetails, "Click on Sub Component Details");
		
	}


}
