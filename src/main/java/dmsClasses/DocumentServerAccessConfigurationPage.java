package dmsClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class DocumentServerAccessConfigurationPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_FTPName = "//select[@id='ftpName']";
	public static final String OCR_Attribute = "//input[@id='attribute']";
	public static final String OCR_AccessType = "//select[@id='accessType']";
	public static final String OCR_Status = "//select[@id='resultFtpAccessConfiguration_ftpAccessConfigValue_status']";
	public static final String OCR_SortBy = "//select[@id='resultFtpAccessConfiguration_sortBy']";
	public static final String OCR_Button_Search = "//button[contains(text(),'Search')]";
	public static final String OCR_Button_AddDocServerAccess = "//button[@name='Add']";
	public static final String OCR_Button_AddFromExcel = "//button[@id='uploadButton']";

	/* ******************************* Constructor ****************************** */

	public DocumentServerAccessConfigurationPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	public void search_docserveracessconfig(String FTPName, String AccessType, String Attribute, String Status,
			String SortBy) {
		selectByVisibleText(driver, test, OCR_FTPName, "Selecting FTP Name: ", FTPName);
		selectByVisibleText(driver, test, OCR_AccessType, "Select Access Type ", AccessType);
		typeText(driver, test, OCR_Attribute, "Enter Attribute : ", Attribute);
		selectByVisibleText(driver, test, OCR_Status, "Select Direction: ", Status);
		selectByVisibleText(driver, test, OCR_SortBy, "Select SortBy: ", SortBy);
	}

	public void search() {
		clickElement(driver, test, OCR_Button_Search, "Clicking on Search Button");
	}

	public void adddocserveracess() {
		clickElement(driver, test, OCR_Button_AddDocServerAccess, "Clicking on Add Document Server Access Button");
	}

	public void addfromexcel() {
		clickElement(driver, test, OCR_Button_AddFromExcel, "Clicking on Add From Excel Button");
	}
}
