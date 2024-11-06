package globalExportClasses;

import org.eclipse.jetty.io.ManagedSelector.Selectable;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class CreateNewDutyReliefAuthorizationsActivityLog extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_CreateNewDutyReliefAuthorizationsActivityLog_ReliefType = "//select[@id='reliefTypeId']";
	public static final String OCR_CreateNewDutyReliefAuthorizationsActivityLog_DRANo = "//input[@id='reliefAuthNo']";
	public static final String OCR_CreateNewDutyReliefAuthorizationsActivityLog_AuthItemNo = "//input[@id='editDutyLog_relifeItemAuthNo']";
	public static final String OCR_CreateNewDutyReliefAuthorizationsActivityLog_ShipType = "//select[@id='shpmtType']";
	public static final String OCR_CreateNewDutyReliefAuthorizationsActivityLog_RefNoLink = "//a[@id='refNoLink']";
	public static final String OCR_CreateNewDutyReliefAuthorizationsActivityLog_ExportInvNo = "//input[@id='resultExportInvoicePopUp_shipmentDTO_invoiceNo']";
	public static final String OCR_CreateNewDutyReliefAuthorizationsActivityLog_SearchBtn = "//button[@name='Search']";
	public static final String OCR_CreateNewDutyReliefAuthorizationsActivityLog_SelectBtn = "(//button[@name='Ok'])[1]";
	public static final String OCR_CreateNewDutyReliefAuthorizationsActivityLog_ClosePopUpBtn = "(//button[@class='btn-close'])[1]";
	public static final String OCR_CreateNewDutyReliefAuthorizationsActivityLog_CustomDeclarationNo = "//input[@id='editDutyLog_activityLogValue_customsDeclarationNo']";
	public static final String OCR_CreateNewDutyReliefAuthorizationsActivityLog_TransactionDate = "//input[@id='transactionDate']";
	public static final String OCR_CreateNewDutyReliefAuthorizationsActivityLog_RefItemNo = "//input[@id='editDutyLog_referenceItemNo']";
	public static final String OCR_CreateNewDutyReliefAuthorizationsActivityLog_CDItemNo = "//input[@id='editDutyLog_customDecItmNo']";
	public static final String OCR_CreateNewDutyReliefAuthorizationsActivityLog_DueDate = "//input[@id='dueDate']";
	public static final String OCR_CreateNewDutyReliefAuthorizationsActivityLog_PartNoLink = "//a[@id='partNopopup']";
	public static final String OCR_CreateNewDutyReliefAuthorizationsActivityLog_PartNo = "//input[@id='searchForm_product_productCode']";
	public static final String OCR_CreateNewDutyReliefAuthorizationsActivityLog_PartNoSearch = "//button[@name='Search']";
	public static final String OCR_CreateNewDutyReliefAuthorizationsActivityLog_PartNoSelectBtn = "(//button[@name='Ok'])[1]";
	public static final String OCR_CreateNewDutyReliefAuthorizationsActivityLog_CloseBtn = "(//button[@class='btn-close'])[1]";
	public static final String OCR_CreateNewDutyReliefAuthorizationsActivityLog_Qty = "//input[@id='editDutyLog_qty']";
	public static final String OCR_CreateNewDutyReliefAuthorizationsActivityLog_UOM = "//input[@id='editDutyLog_activityLogValue_uom']";
	public static final String OCR_CreateNewDutyReliefAuthorizationsActivityLog_SaveReturnBtn = "//button[@id='saveReturnBtn']";

	/* ******************************* Constructor ****************************** */

	public CreateNewDutyReliefAuthorizationsActivityLog(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	// Select the Relief Type
	public void selectReliefType(String ReliefType) {
		selectByVisibleText(driver, test, OCR_CreateNewDutyReliefAuthorizationsActivityLog_ReliefType,
				"Select Relief Type : ", ReliefType);
	}

	public void addItemDetails(String DRANo, String AuthItemNo, String ShipType, String ReferenceNo,
			String CustomDeclarationNo, String TransactionDate, String RefItemNo, String CDItemNo, String DueDate,
			String PartNum, String ItemQty, String ItemUOM) {
		
		clearText(driver, test, OCR_CreateNewDutyReliefAuthorizationsActivityLog_DRANo, "Clear the existing value");
		typeText(driver, test, OCR_CreateNewDutyReliefAuthorizationsActivityLog_DRANo,
				"Enter Duty Relief Authorization Number : ", DRANo);
	//	typeText(driver, test, OCR_CreateNewDutyReliefAuthorizationsActivityLog_DRANo, "Append with Random DRANo : ",
	//			randomnumbers());
		Wait.waitfor(2);
		typeText(driver, test, OCR_CreateNewDutyReliefAuthorizationsActivityLog_AuthItemNo,
				"Enter Authorization Item No : ", AuthItemNo);
		selectByVisibleText(driver, test, OCR_CreateNewDutyReliefAuthorizationsActivityLog_ShipType,
				"Select Shipment Type : ", ShipType);
		try {
			if (ReferenceNo.length() > 0) {
				Wait.waitfor(2);
				clickElement(driver, test, OCR_CreateNewDutyReliefAuthorizationsActivityLog_RefNoLink,
						"Click on Reference No Link");
				typeText(driver, test, OCR_CreateNewDutyReliefAuthorizationsActivityLog_ExportInvNo,
						"Enter Export Invoice No : ", ReferenceNo);
				clickElement(driver, test, OCR_CreateNewDutyReliefAuthorizationsActivityLog_SearchBtn,
						"Click on Search Button");
				clickElement(driver, test, "(//td[@aria-describedby='gridPopup_invoiceNo'])[1]", ReferenceNo);
				clickElement(driver, test, OCR_CreateNewDutyReliefAuthorizationsActivityLog_SelectBtn,
						"Click on Select button");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_CreateNewDutyReliefAuthorizationsActivityLog_ClosePopUpBtn,
					"Click on Close popup icon");
		}

		typeText(driver, test, OCR_CreateNewDutyReliefAuthorizationsActivityLog_CustomDeclarationNo,
				"Enter Customs Declaration No : ", CustomDeclarationNo);
		typeText(driver, test, OCR_CreateNewDutyReliefAuthorizationsActivityLog_CustomDeclarationNo,
				"Append with Random Customs Declaration No : ", randomnumbers());
		Wait.waitfor(2);
		clickElement(driver, test, OCR_CreateNewDutyReliefAuthorizationsActivityLog_TransactionDate,
				"Click on Transaction Date");
		date(driver, test, "Select the date : ", TransactionDate);
		typeText(driver, test, OCR_CreateNewDutyReliefAuthorizationsActivityLog_RefItemNo, "Enter Reference Item No : ",
				RefItemNo);
		typeText(driver, test, OCR_CreateNewDutyReliefAuthorizationsActivityLog_CDItemNo,
				"Enter Customs Declaration Item No : ", CDItemNo);
		clickElement(driver, test, OCR_CreateNewDutyReliefAuthorizationsActivityLog_DueDate, "Click on Due Date field");
		Wait.waitfor(2);
		date(driver, test, "Select the Date : ", DueDate);
		try {
			Wait.waitfor(2);
			if (PartNum.length() > 0) {
				Wait.waitfor(2);
				clickElement(driver, test, OCR_CreateNewDutyReliefAuthorizationsActivityLog_PartNoLink,
						"Click on Part No link");
				typeText(driver, test, OCR_CreateNewDutyReliefAuthorizationsActivityLog_PartNo, "Enter Part No : ",
						PartNum);
				clickElement(driver, test, OCR_CreateNewDutyReliefAuthorizationsActivityLog_PartNoSearch,
						"Click on Search Button");
				Wait.waitfor(2);
				clickElement(driver, test, "//td[contains(text(),'" + PartNum + "')]", "Click on Part No : " + PartNum);
				clickElement(driver, test, OCR_CreateNewDutyReliefAuthorizationsActivityLog_PartNoSelectBtn,
						"Click on Select Button");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_CreateNewDutyReliefAuthorizationsActivityLog_CloseBtn,
					"Click on Close popup icon");
		}
		scrollToElement(driver, OCR_CreateNewDutyReliefAuthorizationsActivityLog_Qty);
		typeText(driver, test, OCR_CreateNewDutyReliefAuthorizationsActivityLog_Qty, "Enter Quantity : ", ItemQty);
		typeText(driver, test, OCR_CreateNewDutyReliefAuthorizationsActivityLog_UOM, "Enter UOM : ", ItemUOM);

	}

	public void saveReturn() {
		scrollToElement(driver, OCR_CreateNewDutyReliefAuthorizationsActivityLog_SaveReturnBtn);
		clickElement(driver, test, OCR_CreateNewDutyReliefAuthorizationsActivityLog_SaveReturnBtn,
				"Click on Save and Return button");
	}

}
