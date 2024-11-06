package dmsClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;

public class AddNewDocumentServerPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_FTPId = "//input[@id='ftpId']";
	public static final String OCR_FTPURL = "//input[@id='ftpUrl']";
	public static final String OCR_Description = "//input[@id='ftpName']";
	public static final String OCR_Country = "//input[@id='editAccountFtpConfig_']";
	public static final String OCR_UserId = "//input[@id='userName']";
	public static final String OCR_Password = "//input[@id='ftpPassword']";
	public static final String OCR_FTPType = "//input[@id='editAccountFtpConfig_accountFTPConfig_secureFtpN']";
	public static final String OCR_Button_Save = "//button[@name='save']";
	public static final String OCR_Button_SavendReturn = "//button[@name='okx']";

	/* ******************************* Constructor ****************************** */

	public AddNewDocumentServerPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	public void addnewdocserver(String FTPId, String FTPType, String FTPURL, String Description, String Country,
			String UserId, String Password) {
		typeText(driver, test, OCR_FTPId, "Enter FTP Id : ", FTPId);
		if (FTPType.length() > 0) {
			clickElement(driver, test, OCR_FTPType, "Select FTP Type: ");
		}
		typeText(driver, test, OCR_FTPURL, "Enter FTP URL: ", FTPURL);
		typeText(driver, test, OCR_Description, "Enter Description: ", Description);
		typeText(driver, test, OCR_Country, "Enter Country : ", Country);
		typeText(driver, test, OCR_UserId, "Enter UserId : ", UserId);
		typeText(driver, test, OCR_Password, "Enter Password : ", Password);
	}

	public void save() {
		clickElement(driver, test, OCR_Button_Save, "Click on Save Button");
	}

	public void savendreturn() {
		clickElement(driver, test, OCR_Button_SavendReturn, "Click on Save and Return Button");
	}
}
