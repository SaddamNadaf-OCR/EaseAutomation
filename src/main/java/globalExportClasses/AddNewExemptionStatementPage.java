package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class AddNewExemptionStatementPage extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_AddNewExemptionStatementPage_Country = "//input[@id='editAesExemptionStatement_countryName']";
	public static final String OCR_AddNewExemptionStatementPage_ExemptionCode = "//input[@id='editAesExemptionStatement_aesExemptionStatement_shortDesc']";
	public static final String OCR_AddNewExemptionStatementPage_ExemptionDesc = "//textarea[@id='editAesExemptionStatement_aesExemptionStatement_longDesc']";
	public static final String OCR_AddNewExemptionStatementPage_SaveBtn = "//button[@name='save.x']";
	public static final String OCR_AddNewExemptionStatementPage_SaveReturnBtn = "//button[contains(text(),'Save & Return')]";
	public static final String OCR_AddNewExemptionStatementPage_CancelBtn = "//button[contains(text(),'Cancel')]";
	public static final String OCR_AddNewExemptionStatementPage_No = "//input[@id='editAesExemptionStatement_aesExemptionStatement_aesExemptionNo']";
	

	/* ******************************* Constructor ****************************** */

	public AddNewExemptionStatementPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */
	
	public void enterCountry(String Country) {
		Wait.waitfor(2);
		typeText(driver, test, OCR_AddNewExemptionStatementPage_Country, "Enter country : ", Country);
	}
	
	public void enter_exemptionCode(String ExempCode) {
		Wait.waitfor(2);
		typeText(driver, test, OCR_AddNewExemptionStatementPage_ExemptionCode, "Enter Exemption Code : ", ExempCode);
	}
	
	public void enter_ExempDescription(String ExempDescr) {
		Wait.waitfor(2);
		clearText(driver, test, OCR_AddNewExemptionStatementPage_ExemptionDesc, "CLear existing description :");
		typeText(driver, test, OCR_AddNewExemptionStatementPage_ExemptionDesc, "Enter Exemption Description : ", ExempDescr + randomnumbersbetween1_100());
	}
	
//	public String getExemptDescription(String ExempDescr) {
//		Wait.waitfor(2);
//	return getAttribute(driver, test, "//textarea[@id='editAesExemptionStatement_aesExemptionStatement_longDesc']", ExempDescr, "");
//	}
	
	public String getNo() {
		Wait.waitfor(2);
		return getText(driver, test, "//input[@id='editAesExemptionStatement_aesExemptionStatement_aesExemptionNo']", "");
	}
	
	public void save() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_AddNewExemptionStatementPage_SaveBtn, "Click on Save button : ");
	}
	
	public void saveReturn() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_AddNewExemptionStatementPage_SaveReturnBtn, "Click on Save & Return button : ");
	}
	
	public void cancelbtn() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_AddNewExemptionStatementPage_CancelBtn, "Click on Cancel button : ");
	}
	
	public String getExemptDescription() {
		Wait.waitfor(2);
		return getTextfromTextbox(driver, test, "//textarea[@id='editAesExemptionStatement_aesExemptionStatement_longDesc']", "Getting the Exemption Description : ");
		//return getText(driver, test, OCR_CreateNewExportInfoCodePage_ExportInfoCode, "Getting the Export Info Code : ");
	//	return getAttribute(driver, test, OCR_CreateNewExportInfoCodePage_ExportInfoCode, "value", "Getting the Export Info Code: ");
	}
	
	
	
}
