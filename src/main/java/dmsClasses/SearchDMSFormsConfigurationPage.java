package dmsClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class SearchDMSFormsConfigurationPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_DMSFormConfig = "//a[contains(text(),'DMS Forms Configuration')]";
	public static final String OCR_HomePage_ListScreening = "//ul[@class='nav navbar-nav']/li[2]/a";
	public static final String OCR_ConfigurationType = "//select[@id='resultDmsFormsConfiguration_configType']";
	public static final String OCR_SBU = "//select[@id='resultDmsFormsConfiguration_dmsFormsConfiguration_sbuCode']";
	public static final String OCR_Module = "//select[@id='resultDmsFormsConfiguration_dmsFormsConfiguration_module']";
	public static final String OCR_FormSet = "//select[@id='resultDmsFormsConfiguration_dmsFormsConfiguration_formSetId']";
	public static final String OCR_UrlPattern = "//input[@id='resultDmsFormsConfiguration_dmsFormsConfiguration_urlPattern']";
	public static final String OCR_Attrib1 = "//input[@id='resultDmsFormsConfiguration_dmsFormsConfiguration_folderName']";
	public static final String OCR_Status = "//select[@id='resultDmsFormsConfiguration_dmsFormsConfiguration_status']";
	public static final String OCR_Button_Search = "//button[contains(text(),'Search')]";
	public static final String OCR_Button_AddDMSFormConfig = "//button[@name='Add']";

	/* ******************************* Constructor ****************************** */

	public SearchDMSFormsConfigurationPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	public void select_configtype(String ConfigType) {
		selectByVisibleText(driver, test, OCR_ConfigurationType, "Select Configuration Type: ", ConfigType);
	}

	public void select_sbu(String SBU) {
		selectByVisibleText(driver, test, OCR_SBU, "Select SBU: ", SBU);
	}

	public void select_module(String Module) {
		selectByVisibleText(driver, test, OCR_Module, "Select Module: ", Module);
	}

	public void select_formset(String Formset) {
		selectByVisibleText(driver, test, OCR_FormSet, "Select FormSet: ", Formset);
	}

	public void enter_urlpattern(String UrlPattern) {
		typeText(driver, test, OCR_UrlPattern, "Select UrlPattern: ", UrlPattern);
	}

	public void enter_attrib1(String Attrib1) {
		typeText(driver, test, OCR_Attrib1, "Enter Attribute 1: ", Attrib1);
	}

	public void select_status(String Status) {
		selectByVisibleText(driver, test, OCR_Status, "Select FormSet: ", Status);
	}

	public void search() {
		clickElement(driver, test, OCR_Button_Search, " Clicking on Search Button");
	}

	public void click_adddmsformconfig() {
		clickElement(driver, test, OCR_Button_AddDMSFormConfig, "Clicking on Add DMS Form Config");
	}

}