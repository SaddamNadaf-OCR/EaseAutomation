package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class CreateNewConsigneePage extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_AddConsignee_Save = "//button[@name='save']";
	public static final String OCR_AddConsignee_SaveandReturn = "//button[@name='OK']";
	public static final String OCR_AddConsignee_Cancel = "//button[@name='Cancel']";
	public static final String OCR_AddConsignee_UseForMiliteryGoods = "//input[@id='editConsignee_useForDos']";
	public static final String OCR_AddConsignee_DualUse = "//input[@id='editConsignee_useForDoc']";
	public static final String OCR_AddConsignee_AES = "//input[@id='editConsignee_useForAes']";
	public static final String OCR_AddConsignee_Name = "//input[@id='editConsignee_consignee_consigneeName']";
	public static final String OCR_AddConsignee_Address1 = "//input[@id='editConsignee_consignee_consigneeAddr1']";
	public static final String OCR_AddConsignee_Address2 = "//input[@id='editConsignee_consignee_consigneeAddr2']";
	public static final String OCR_AddConsignee_Address3 = "//input[@id='editConsignee_consignee_consigneeAddr3']";
	public static final String OCR_AddConsignee_City = "//input[@id='editConsignee_consignee_consigneeCity']";
	public static final String OCR_AddConsignee_Country = "//input[@id='editConsignee_consignee_consigneeCountryName']";
	public static final String OCR_AddConsignee_State = "//input[@id='editConsignee_consignee_consigneeStateName']";
	public static final String OCR_AddConsignee_Zip = "//input[@id='editConsignee_consignee_zip']";
	public static final String OCR_AddConsignee_Phone = "//input[@id='editConsignee_consignee_phone']";
	public static final String OCR_AddConsignee_MobileNo = "//input[@id='editConsignee_consignee_mobileNo']";
	public static final String OCR_AddConsignee_Fax = "//input[@id='editConsignee_consignee_fax']";
	public static final String OCR_AddConsignee_Email = "//input[@id='editConsignee_consignee_email']";
	public static final String OCR_AddConsignee_AssuranceGiven = "//select[@id='editConsignee_consignee_assurance']";
	public static final String OCR_AddConsignee_MiletaryEndUse = "//select[@id='editConsignee_consignee_meuser']";
	public static final String OCR_AddConsignee_Remarks = "//textarea[@id='editConsignee_consignee_remarks']";

	
	/* ******************************* Constructor ****************************** */

	public CreateNewConsigneePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

}
