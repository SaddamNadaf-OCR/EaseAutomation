package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class CreateNewDutyReliefAuthorizationsActivityLogPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_CreateDRAA_ReliefType = "//select[@id='reliefTypeId']";
	public static final String OCR_CreateDRAA_DutyReliefAuthNo = "//input[@id='reliefAuthNo']";
	public static final String OCR_CreateDRAA_AuthorizationItemNo = "// input[@id='editDutyLog_relifeItemAuthNo']";
	public static final String OCR_CreateDRAA_ShipmentType = "//select[@id='shpmtType']";
	public static final String OCR_CreateDRAA_TransactionDate = "//input[@id='transactionDate']";
	public static final String OCR_CreateDRAA_ReferenceNo = "//input[@id='refNo']";
	public static final String OCR_CreateDRAA_ReferenceItemNo = "//input[@id='editDutyLog_referenceItemNo']";
	public static final String OCR_CreateDRAA_DueDate = "//input[@id='dueDate']";
	public static final String OCR_CreateDRAA_Description = "//textarea[@id='editDutyLog_activityLogValue_partDescription']";
	public static final String OCR_CreateDRAA_Quantity = "//input[@id='editDutyLog_qty']";
	public static final String OCR_CreateDRAA_UOM = "//input[@id='editDutyLog_activityLogValue_uom']";
	public static final String OCR_CreateDRAA_Save = "//button[@id='saveBtn']";
	public static final String OCR_CreateDRAA_SaveAndReturn = "//button[@id='saveReturnBtn']";

	/* ******************************* Constructor ****************************** */

	public CreateNewDutyReliefAuthorizationsActivityLogPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	// Item Details
	public void addItemDetails(String ReliefType, String DutyReliefAuthorizationNo, String AutorizationsNo,
			String ShipmentType, String TransactionDate, String ReferenceNo, String ReferenceItemNo, String DueDate,
			String Description, String Quantity, String UOM) {
		selectByVisibleText(driver, test, OCR_CreateDRAA_ReliefType, "Select the Relief Type : ", ReliefType);
		typeText(driver, test, OCR_CreateDRAA_DutyReliefAuthNo, "Enter the Duty Relief Authorization No : ",
				DutyReliefAuthorizationNo);
		typeText(driver, test, OCR_CreateDRAA_AuthorizationItemNo, "Enter the Autorizations No : ", AutorizationsNo);
		selectByVisibleText(driver, test, OCR_CreateDRAA_ShipmentType, "Select the Shipment Type : ", ShipmentType);
		Wait.waitfor(3);
		clickElement(driver, test, OCR_CreateDRAA_TransactionDate, "Click On Transaction Date");
		date(driver, test, "Select the Transaction Date : ", TransactionDate);
		typeText(driver, test, OCR_CreateDRAA_ReferenceNo, "Enter the Reference No : ", ReferenceNo + randomnumbers());
		typeText(driver, test, OCR_CreateDRAA_ReferenceItemNo, "Enter the Reference Item No : ", ReferenceItemNo);
		scrollToBottom(driver);
		clickElement(driver, test, OCR_CreateDRAA_DueDate, "Click on Due Date");
		date(driver, test, "Select the Due Date : ", DueDate);
		typeText(driver, test, OCR_CreateDRAA_Description, "Enter the Description : ", Description);
		typeText(driver, test, OCR_CreateDRAA_Quantity, "Enter the Quantity : ", Quantity);
		typeText(driver, test, OCR_CreateDRAA_UOM, "Enter the UOM : ", UOM);
	}


	// Click on Save And return
	public void clickSaveReturn() {
		scrollToElement(driver, OCR_CreateDRAA_SaveAndReturn);
		clickElement(driver, test, OCR_CreateDRAA_SaveAndReturn, "Click on Save And Return");
	}

}
