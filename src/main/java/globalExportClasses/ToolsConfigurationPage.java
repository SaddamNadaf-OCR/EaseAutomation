package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class ToolsConfigurationPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_ToolsConfigurationPage_Tools = "//i[@class='fa fa-wrench']";
	public static final String OCR_ToolsConfigurationPage_SearchBtn = "//button[contains(text(),'Search')]";
	public static final String OCR_ToolsConfigurationPage_ParamValue = "//textarea[@id='editSbuConf_sbuConf_sbuConfValue']";
	public static final String OCR_ToolsConfigurationPage_SaveBtn = "//button[@name='save']";
	
	/* ******************************* Constructor ****************************** */

	public ToolsConfigurationPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

//Under Tools--> Enter SBU configuration and select
	public void select_SBUConfig(String parameter, String paramvalue ) {
		Wait.waitfor(2);
		mouseOver(driver, test, OCR_ToolsConfigurationPage_Tools, "");
		clickElement(driver, test, OCR_ToolsConfigurationPage_Tools, "Click on Tools Configuration icon :");
		Wait.waitfor(2);
		mouseOverAndClick(driver, test, "//a[contains(text(),'SBU Configuration')]", "Click on SBU Configuration option :");
		typeText(driver, test, "//input[@id='resultSbuConf_sbuConf_sbuConfCode']", "Enter parameter : ", parameter);
		clickElement(driver, test, OCR_ToolsConfigurationPage_SearchBtn, "CLick on Search button :");
		Wait.waitfor(2);
		clickElement(driver, test, "//a[contains(text(),'SHIPMENT_REVIEW_LEVEL')]", "Click on Shipment Review Level link :");
		clearText(driver, test, OCR_ToolsConfigurationPage_ParamValue, "Clear existing parameter value :");
		typeText(driver, test, "//textarea[@id='editSbuConf_sbuConf_sbuConfValue']", "Enter parameter value : ", paramvalue);
		clickElement(driver, test, OCR_ToolsConfigurationPage_SaveBtn, "Click on Save button :");
	}
}
