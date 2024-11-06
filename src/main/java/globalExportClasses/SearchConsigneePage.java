package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class SearchConsigneePage extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_Consignee_Search = "//button[contains(text(),'Search')]";
	public static final String OCR_Consignee_Reset = "//button[contains(text(),'Reset')]";
	public static final String OCR_Consignee_AddConsignee = "//button[contains(text(),'Add Consignee')]";
	public static final String OCR_Consignee_SBU = "//select[@name='consignee.sbuCode']";
	public static final String OCR_Consignee_MiliteryGoods = "//input[@id='searchConsignee_useForDos']";
	public static final String OCR_Consignee_DualUse = "//input[@id='searchConsignee_useForDoc']";
	public static final String OCR_Consignee_AES = "//input[@id='searchConsignee_useForAes']";
	public static final String OCR_Consignee_ID = "//input[@id='searchConsignee_consignee_consigneeId']";
	public static final String OCR_Consignee_Status = "//select[@id='searchConsignee_consignee_status']";
	public static final String OCR_Consignee_Name = "//input[@id='searchConsignee_consignee_consigneeName']";
	public static final String OCR_Consignee_onholdSubStatusId = "//select[@id='searchConsignee_consignee_onholdSubStatusId']";
	public static final String OCR_Consignee_Country = "//input[@id='searchConsignee_countryName']";
	public static final String OCR_Consignee_Zip = "//input[@id='searchConsignee_consignee_zip']";
	public static final String OCR_Consignee_Active = "//select[@id='searchConsignee_consignee_active']";
	public static final String OCR_Consignee_MT = "//select[@id='searchConsignee_consignee_mt']";
	public static final String OCR_Consignee_CB = "//select[@id='searchConsignee_consignee_cb']";
	public static final String OCR_Consignee_NS = "//select[@id='searchConsignee_consignee_ns']";
	public static final String OCR_Consignee_FC = "//select[@id='searchConsignee_consignee_fc']";
	public static final String OCR_Consignee_Related = "//select[@id='searchConsignee_consignee_related']";
	public static final String OCR_Consignee_EG = "//select[@id='searchConsignee_consignee_np']";
	public static final String OCR_Consignee_RS = "//select[@id='searchConsignee_consignee_rs']";
	public static final String OCR_Consignee_CC = "//select[@id='searchConsignee_consignee_cc']";
	public static final String OCR_Consignee_AT = "//select[@id='searchConsignee_consignee_at']";
	public static final String OCR_Consignee_SalesPerson = "//input[@id='searchConsignee_consignee_salesPerson']";
	public static final String OCR_Consignee_TypeOfConsignee = "//select[@id='searchConsignee_consignee_typeOfConsignee']";
	public static final String OCR_Consignee_OwnByGoverment = "//select[@id='searchConsignee_consignee_ownedByGovt']";
	public static final String OCR_Consignee_interactWithGovt = "//select[@id='searchConsignee_consignee_interactWithGovt']";
	public static final String OCR_Consignee_aviationMilNucEndUse = "//select[@id='searchConsignee_consignee_aviationMilNucEndUse']";
	
	/* ******************************* Constructor ****************************** */

	public SearchConsigneePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	//Click on Search button
	public void search() {
		clickElement(driver, test, OCR_Consignee_Search, "Clicking on Search Button :");
	}
	
	//Click on Reset button
	public void reset() {
		clickElement(driver, test, OCR_Consignee_Reset, "Clicking on Reset Button :");
	}
	
	//Click on Add Consignee
	public void addConsignee() {
		clickElement(driver, test, OCR_Consignee_AddConsignee, "Clicking on Add Consignee Button :");
	}
	
	//Search by Parameters
	public void searchByparameters(String SBU, String UseFor, String ConsigneeID, String ConsigneeStatus, String ConsigneeName, 
			String SubStatus, String Country, String Zip, String Active, String MT, String CB, String NS, String FC, String Related, 
			String EG, String RS, String CC, String AT, String SalesPerson, String TypeOfConsignee, String OwnByGoverment, 
			String interactWithGovt, String aviationMilNucEndUse ) {
		if(SBU.length() > 0) {
			selectByVisibleText(driver, test, OCR_Consignee_SBU, "Selecting SBU :", SBU);
		}
		if(UseFor.equalsIgnoreCase("Militery Goods")) {
			clickElement(driver, test, OCR_Consignee_MiliteryGoods, "Clicking on Militery Goods :");
		}else if(UseFor.equalsIgnoreCase("Dual Use")) {
			clickElement(driver, test, OCR_Consignee_DualUse, "Clicking on Dual Use :");
		}else {
			clickElement(driver, test, OCR_Consignee_AES, "Clicking on AES :");
		}
		if(ConsigneeID.length() > 0) {
			typeText(driver, test, OCR_Consignee_ID, "Entering Consignee ID :", ConsigneeID);
		}
		if(ConsigneeStatus.length() >0) {
			selectByVisibleText(driver, test, OCR_Consignee_Status, "Selecting Consignee Status :", ConsigneeStatus);
		}
		if(ConsigneeName.length() > 0) {
			typeText(driver, test, OCR_Consignee_Name, "Entering Consignee Name :", ConsigneeName);
		}
		if(SubStatus.length() > 0) {
			selectByVisibleText(driver, test, OCR_Consignee_onholdSubStatusId, "Selecting On Hold Sub Status :", SubStatus);
		}
		if(Country.length() > 0) {
			typeText(driver, test, OCR_Consignee_Country, "Entering Country :", Country);
		}
		if(Zip.length() > 0) {
			typeText(driver, test, OCR_Consignee_Zip, "Entering ZIP :", Zip);
		}
		if(Active.length() > 0) {
			selectByVisibleText(driver, test, OCR_Consignee_Active, "Selecting Active :", Active);
		}
		if(MT.length() > 0) {
			selectByVisibleText(driver, test, OCR_Consignee_MT, "Selecting MT :", MT);
		}
		if(CB.length() > 0) {
			selectByVisibleText(driver, test, OCR_Consignee_CB, "Selecting CB :", CB);
		}
		if(NS.length() > 0) {
			selectByVisibleText(driver, test, OCR_Consignee_NS, "Selecting NS :", NS);
		}
		if(FC.length() > 0) {
			selectByVisibleText(driver, test, OCR_Consignee_FC, "Selecting FC :", FC);
		}
		if(Related.length() > 0) {
			selectByVisibleText(driver, test, OCR_Consignee_Related, "Selecting Related :", Related);
		}
		if(EG.length() > 0) {
			selectByVisibleText(driver, test, OCR_Consignee_EG, "Selecting EG :", EG);
		}
		if(RS.length() > 0) {
			selectByVisibleText(driver, test, OCR_Consignee_RS, "Selecting RS :", RS);
		}
		if(CC.length() > 0) {
			selectByVisibleText(driver, test, OCR_Consignee_CC, "Selecting CC :", CC);
		}
		if(AT.length() > 0) {
			selectByVisibleText(driver, test, OCR_Consignee_AT, "Selecting AT :", AT);
		}
		if(SalesPerson.length() > 0) {
			typeText(driver, test, OCR_Consignee_SalesPerson, "Entering Sales Person :", SalesPerson);
		}
		if(TypeOfConsignee.length() > 0) {
			selectByVisibleText(driver, test, OCR_Consignee_TypeOfConsignee, "Selecting Type Of Consignee :", TypeOfConsignee);
		}
		if(OwnByGoverment.length() > 0) {
			selectByVisibleText(driver, test, OCR_Consignee_OwnByGoverment, "Selecting Own By Goverment :", OwnByGoverment);
		}
		if(interactWithGovt.length() > 0) {
			selectByVisibleText(driver, test, OCR_Consignee_interactWithGovt, "Selecting interact With Govt :", interactWithGovt);
		}
		if(aviationMilNucEndUse.length() > 0) {
			selectByVisibleText(driver, test, OCR_Consignee_aviationMilNucEndUse, "Selecting Aviation, Military or Nuclear end-use :", aviationMilNucEndUse);
		}
	}

}
