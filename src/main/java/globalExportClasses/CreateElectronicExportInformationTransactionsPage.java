package globalExportClasses;
/* 
 * Module : Export Operation
 * Author  : Saddam
 * created date : June 2024
 * Descriptions : Create Electronic Export Information Transactions Page
 * changed by : Nil
 * changed date : Nil
 * Purpose of change : Nil 
 * Reviewed by : Nil 
 */
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import utilities.GenericMethods;
import utilities.Wait;

public class CreateElectronicExportInformationTransactionsPage extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_CreateEEIT_CreateEEITransaction = "//button[contains(text(),'EEI Transactions')]";
	public static final String OCR_CreateEEIT_Cancel = "//button[contains(text(),'Cancel')]";
	public static final String OCR_CreateEEIT_CreateNewEEITransactions = "//input[@value='blank']";
	public static final String OCR_CreateEEIT_CreateNewEEITransactionsFromTemplate = "//input[@value='template']";
	public static final String OCR_CreateEEIT_SelectTemplate = "//select[@id='template']";
	public static final String OCR_CreateEEIT_CreateNewEEITransactionsFromAuthorization = "//input[@value='license']";
	public static final String OCR_CreateEEIT_AuthorizationNo = "//a[contains(text(),'Authorization No')]";
	public static final String OCR_CreateEEIT_AuthorizationNoPopup = "//input[@name='licenseHeaderDTO.licenseNo']";
	public static final String OCR_CreateEEIT_SearchPopup = "//button[@name='Search']";
	public static final String OCR_CreateEEIT_SelectPopup = "//button[@name='Ok']";
	public static final String OCR_CreateEEIT_CancelPopup = "(//button[@class='btn-close'])[1]";
	public static final String OCR_CreateEEIT_CreateNewEEITransactionsFromEntryNo = "//input[@value='entry']";
	public static final String OCR_CreateEEIT_EnteryNo = "//a[contains(text(),'Entry No.')]";
	public static final String OCR_CreateEEIT_EnteryNoPopup = "//input[@name='import7501DetailsDTO.entryNo']";
	
	// * ************************ Constructor ***************************** */

	public CreateElectronicExportInformationTransactionsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Action ****************************** */
	//Clicking on Create EEI Transaction button
	public void createEEITransaction() {
		clickElement(driver, test, OCR_CreateEEIT_CreateEEITransaction, "Clicking on Create EEI Transaction Button :");
	}
	
	//Click on Cancel Button
	public void cancel() {
		clickElement(driver, test, OCR_CreateEEIT_Cancel, "Clicking on Cancel Button :");
	}
	
	//Create New  EEI Transactions Radio Button
	public void newEEITRadioButton() {
		clickElement(driver, test, OCR_CreateEEIT_CreateNewEEITransactions, "Clicking on Create EEI Transaction radio Button :");
	}
	
	//Create New  EEI Transactions  From Template
	public void newTransactionFromtemplate(String SelectTemplate) {
		clickElement(driver, test, OCR_CreateEEIT_CreateNewEEITransactionsFromTemplate, "Clicking on New Transaction From template Radio button :");
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCR_CreateEEIT_SelectTemplate, "Selecting the template :", SelectTemplate);
	}
	
	//Create New  EEI Transactions  From Authorization
	public void newTransactionFromAuthorizationNo(String AuthorizationNo) {
		clickElement(driver, test, OCR_CreateEEIT_CreateNewEEITransactionsFromAuthorization, "Clicking on New Transaction From Authorization No Radio button :");
		Wait.waitfor(2);
		clickElement(driver, test, OCR_CreateEEIT_AuthorizationNo, "Clicking on Authorization No :");
		try {
			typeText(driver, test, OCR_CreateEEIT_AuthorizationNoPopup, "Entering Authorization No :", AuthorizationNo);
			clickElement(driver, test, OCR_CreateEEIT_SearchPopup, "Clicking on Searc Popup Button :");
			mouseOverAndClick(driver, test, "//td[contains(text(),'"+AuthorizationNo+"')]", "Selecting Authorization No :");
			clickElement(driver, test, OCR_CreateEEIT_SelectPopup, "Clicking on Select Popup Button :");
		}catch(Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Enable to select Authorization No :");
			clickElement(driver, test, OCR_CreateEEIT_CancelPopup, "Clicking on Close Popup icon :");
		}
	}

	
	//Create New  EEI Transactions  From Entry No.
	public void newTransactionFromEntryNo(String EntryNo) {
		clickElement(driver, test, OCR_CreateEEIT_CreateNewEEITransactionsFromEntryNo, "Clicking on New Transaction From Entry No Radio button :");
		Wait.waitfor(2);
		clickElement(driver, test, OCR_CreateEEIT_EnteryNo, "Clicking on Entry No :");
		try {
			typeText(driver, test, OCR_CreateEEIT_EnteryNoPopup, "Entering Entry No :", EntryNo);
			clickElement(driver, test, OCR_CreateEEIT_SearchPopup, "Clicking on Searc Popup Button :");
			mouseOverAndClick(driver, test, "//td[contains(text(),'"+EntryNo+"')]", "Selecting Entry No :");
			clickElement(driver, test, OCR_CreateEEIT_SelectPopup, "Clicking on Select Popup Button :");
		}catch(Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Enable to select Entry No :");
			clickElement(driver, test, OCR_CreateEEIT_CancelPopup, "Clicking on Close Popup icon :");
		}
	}
	
	

}
