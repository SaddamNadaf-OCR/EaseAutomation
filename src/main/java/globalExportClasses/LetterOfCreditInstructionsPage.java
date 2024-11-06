package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class LetterOfCreditInstructionsPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_LCI_LCIID = "//input[@id='searchLetterOfCredit_letterOfCredit_lcId']";
	public static final String OCR_LCI_LCIConsigneeCode = "//input[@id='searchLetterOfCredit_letterOfCredit_lcToCode']";
	public static final String OCR_LCI_LCIExporterCode = "//input[@id='searchLetterOfCredit_letterOfCredit_lcFromCode']";
	public static final String OCR_LCI_InvoiceNo = "//input[@id='searchLetterOfCredit_letterOfCredit_invoiceNo']";
	public static final String OCR_LCI_Status = "//select[@id='searchLetterOfCredit_letterOfCredit_status']";
	public static final String OCR_LCI_Search = "//button[contains(text(),'Search')]";
	public static final String OCR_LCI_AddLCI = "//button[contains(text(),'Add Letter Of Credit Instructions')]";
	public static final String OCR_LCI_ResetBtn = "//button[contains(text(),'Reset')]";
	
	
	
	/* ******************************* Constructor ****************************** */

	public LetterOfCreditInstructionsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	// Search Letter of Credit
	public void searchLCI(String LCIID, String LCIConsigneeCode, String LCIExporterCode, String InvoiceNo,
			String Status) {
		typeText(driver, test, OCR_LCI_LCIID, "Enter the LCI ID : ", LCIID);
		typeText(driver, test, OCR_LCI_LCIConsigneeCode, "Enter the LCI Consignee Code : ", LCIConsigneeCode);
		typeText(driver, test, OCR_LCI_LCIExporterCode, "Enter the LCI Exporter  Code : ", LCIExporterCode);
		typeText(driver, test, OCR_LCI_InvoiceNo, "Enter the Invoice No : ", InvoiceNo);
		selectByVisibleText(driver, test, OCR_LCI_Status, "Select the Status : ", Status);
	}

	public void searchLCI(String SBUCode, String LCIID, String LCIConsigneeCode, String LCIConsigneeName,
			String LCIExporterCode, String LCIExporterName, String InvoiceNo, String InvDate, String Status, String Createdby) {
		selectByVisibleText(driver, test, "//select[@id='searchLetterOfCredit_letterOfCredit_sbuCode']",
				"Select SBU : ", SBUCode);
		typeText(driver, test, OCR_LCI_LCIID, "Enter the LCI ID : ", LCIID);
		typeText(driver, test, OCR_LCI_LCIConsigneeCode, "Enter the LCI Consignee Code : ", LCIConsigneeCode);
		typeText(driver, test, "//input[@id='searchLetterOfCredit_letterOfCredit_toName']",
				"Enter LCI Consignee Name : ", LCIConsigneeName);
		typeText(driver, test, OCR_LCI_LCIExporterCode, "Enter the LCI Exporter  Code : ", LCIExporterCode);
		typeText(driver, test, "//input[@id='searchLetterOfCredit_letterOfCredit_fromName']", "Enter the LCIExportername : ", LCIExporterName);
		typeText(driver, test, OCR_LCI_InvoiceNo, "Enter the Invoice No : ", InvoiceNo);
		if (InvDate.length() > 0) {
			clickElement(driver, test, "//input[@id='searchLetterOfCredit_invoiceDate']", "Clicking on Invoice Date :");
			try {
				if (InvDate.equalsIgnoreCase("Today")) {
					clickElement(driver, test, "//button[contains(text(),'Today')]", "Clicking on Today :");
				} else {
					date(driver, test, "Selecting the Date :", InvDate);
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Enable to Select the Date :");
			}
		}
		
		selectByVisibleText(driver, test, OCR_LCI_Status, "Select the Status : ", Status);
		selectByVisibleText(driver, test, "//select[@id='searchLetterOfCredit_letterOfCredit_createdBy']", "Select Created By : ", Createdby);
	}

	// Click on Search Button
	public void clickSearchBtn() {
		clickElement(driver, test, OCR_LCI_Search, "Click on Search");
	}
	
	//click on Reset button
	public void resetBtn()
	{
		Wait.waitfor(2);
		clickElement(driver, test, OCR_LCI_ResetBtn, "Click on Reset button : ");
	}
	// Click on ADD LCI
	public void ClickLCI() {
		clickElement(driver, test, OCR_LCI_AddLCI, "Click on ADD Letter of Credit Instructions");
	}

	// Enter the LCI ID
	public void LCIID(String LCI) {
		// clickElement(driver, test, OCR_LCI_LCIID, LCI);
		typeText(driver, test, OCR_LCI_LCIID, "Enter the LCI ID : ", LCI);
	}
	
	public void sbu(String SbuCode) {
		Wait.waitfor(2);
		selectByVisibleText(driver, test, "//select[@id='searchLetterOfCredit_letterOfCredit_sbuCode']", "Select SBU : ", SbuCode);
	}

}
