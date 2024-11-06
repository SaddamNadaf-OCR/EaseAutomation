package dmsClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class SearchEASEDMSPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_FileStoreTypeE = "//input[@id='easeStoreId']";
	public static final String OCR_FileStoreTypeLi = "//input[@id='isLinkId']";
	public static final String OCR_FileStoreTypeLo = "//input[@id='isLocalFtpdocId']";
	public static final String OCR_FileStoreTypeS = "//input[@id='isFtpSerId']";
	public static final String OCR_SBUCode = "//select[@id='sbuList']";
	public static final String OCR_ModuleName = "//select[@id='moduleSelection']";
	public static final String OCR_RefNo = "//input[@id='searchDocDetails_documentDetailsValue_transactionId']";
	public static final String OCR_FTPServerName = "//select[@id='isFtpId']";
	public static final String OCR_DocName = "//input[@id='docNameId']";
	public static final String OCR_URLLink = "//input[@id='docUrlId']";
	public static final String OCR_LocationPath = "//input[@id='docLocalFtpId']";
	public static final String OCR_SetId = "//select[@id='setIdselection']";
	public static final String OCR_DocType = "//select[@id='doc-type-req-mod-id']";
	public static final String OCR_KeyWords = "//input[@id='searchDocDetails_documentDetailsValue_keywordsDms']";
	public static final String OCR_SourceSysDocNo = "//input[@id='searchDocDetails_documentDetailsValue_systemDocNumber']";
	public static final String OCR_Status = "//select[@id='searchDocDetails_documentDetailsValue_status']";
	public static final String OCR_SortBy = "//select[@name='sortBy']";
	public static final String OCR_Direction = "//select[@name='direction']";
	public static final String OCR_Button_Search = "//button[@name='Search']";
	/* ******************************* Constructor ****************************** */

	public SearchEASEDMSPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	public void searcheasedms(String FileStoreType, String SBUCode, String ModuleName, String RefNo, String DocName,
			String URLLink, String LocationPath, String FTPServerName, String SetId, String DocType, String KeyWords,
			String SourceSysDocNo, String Status, String SortBy, String Direction) {
		clickElement(driver, test, OCR_FileStoreTypeE, "");
		if (FileStoreType.contains("E")) {
			typeText(driver, test, OCR_FileStoreTypeE, "Clicking on Ease Radio Button", FileStoreType);
		} else if (FileStoreType.contains("Li")) {
			typeText(driver, test, OCR_FileStoreTypeLi, "Clicking on Link Radio Button", FileStoreType);
		} else if (FileStoreType.contains("Lo")) {
			typeText(driver, test, OCR_FileStoreTypeLo, "Clicking on Local Folder Radio Button", FileStoreType);
		} else if (FileStoreType.contains("S")) {
			Wait.waitfor(3);
			typeText(driver, test, OCR_FileStoreTypeS, "Clicking on Server Radio Button", FileStoreType);
		}
		selectByVisibleText(driver, test, OCR_SBUCode, "Select SBU Code : ", SBUCode);
		Wait.waitfor(3);
		selectByVisibleText(driver, test, OCR_ModuleName, "Select SBU Code : ", ModuleName);
		typeText(driver, test, OCR_RefNo, "Enter Reference No : ", RefNo);
		if (FileStoreType.contains("E")) {
			typeText(driver, test, OCR_DocName, "Enter Document Name:", DocName);
		} else if (FileStoreType.contains("Li")) {
			typeText(driver, test, OCR_URLLink, "Enter URL Link : ", URLLink);
		} else if (FileStoreType.contains("Lo")) {
			typeText(driver, test, OCR_LocationPath, "Enter Location Path:", LocationPath);
		} else if (FileStoreType.contains("S")) {
			Wait.waitfor(3);
			selectByVisibleText(driver, test, OCR_FTPServerName, "Select FTP Server Name : ", FTPServerName);
		}
		selectByVisibleText(driver, test, OCR_SetId, "Select Set Id: ", SetId);
		selectByVisibleText(driver, test, OCR_DocType, "Select Document Type: ", DocType);
		typeText(driver, test, OCR_KeyWords, "Enter KeyWords : ", KeyWords);
		typeText(driver, test, OCR_SourceSysDocNo, "Enter Source system Doc No: ", SourceSysDocNo);
		selectByVisibleText(driver, test, OCR_Status, "Select Status: ", Status);
		selectByVisibleText(driver, test, OCR_SortBy, "Select Sort By: ", SortBy);
		selectByVisibleText(driver, test, OCR_Direction, "Select Direction: ", Direction);

	}

	public void search() {
		clickElement(driver, test, OCR_Button_Search, "Clicking on Search Button");
	}

}
