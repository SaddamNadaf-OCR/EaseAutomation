package dmsClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;
import utilities.Wait;

public class CreateNewDMSFormsConfigPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_ConfigType = "//select[@id='editDmsFormsConfiguration_configType']";
	public static final String OCR_Status = "//select[@id='editDmsFormsConfiguration_dmsFormsConfiguration_status']";
	public static final String OCR_SBU = "//select[@id='editDmsFormsConfiguration_dmsFormsConfiguration_sbuCode']";
	public static final String OCR_Module = "//select[@id='editDmsFormsConfiguration_dmsFormsConfiguration_module']";
	public static final String OCR_FormSet = "//select[@id='editDmsFormsConfiguration_dmsFormsConfiguration_formSetId']";
	public static final String OCR_Attrib1 = "//input[@id='editDmsFormsConfiguration_dmsFormsConfiguration_folderName']";
	public static final String OCR_URLPattern = "//input[@id='editDmsFormsConfiguration_dmsFormsConfiguration_urlPattern']";
	public static final String OCR_Button_Save = "//button[contains(text(),'Save')]";
	public static final String OCR_Button_SavendReturn = "//button[contains(text(),'Save & Return')]";

	/* ******************************* Constructor ****************************** */

	public CreateNewDMSFormsConfigPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	public void createnewdmsform(String ConfigType, String SBU, String Module, String Attrib1, String URLPattern) {
		selectByVisibleText(driver, test, OCR_ConfigType, "Select Configuration Type", ConfigType);
		Wait.waitfor(3);
		if (ConfigType.contains("SBU Level")) {
			selectByVisibleText(driver, test, OCR_SBU, "Select SBU : ", SBU);
			Wait.waitfor(3);
		}
		// selectByVisibleText(driver, test, OCR_Status,"Select Status: ", Status);
		Wait.waitfor(3);
		selectByVisibleText(driver, test, OCR_Module, "Select SBU : ", Module);
		Wait.waitfor(3);
		typeText(driver, test, OCR_Attrib1, "Enter Attribute1 : ", Attrib1);
		Wait.waitfor(3);
		typeText(driver, test, OCR_URLPattern, "Enter URL Pattern: ", URLPattern);
		Wait.waitfor(3);
		clickElement(driver, test, OCR_Button_SavendReturn, "Clicking on Save and Return Button:");
	}
}