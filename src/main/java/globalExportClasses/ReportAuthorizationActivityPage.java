package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class ReportAuthorizationActivityPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_SEARCH = "(//button[contains(text(),'Search')])[1]";
	public static final String OCR_SEARCH2 = "(//button[contains(text(),'Search')])[2]";
	public static final String OCR_SEARCH3 = "(//button[contains(text(),'Search')])[3]";
	public static final String OCR_RESET = "(//button[@type='reset'])[1]";
	public static final String OCR_SBUCODE = "(//select[@name='licenseHeader.sbuCode'])[1]";
	public static final String OCR_AuthorizationType = "(//a[contains(text(),'Authorization Type')])[2]";
	public static final String OCR_SearchPopUpButton = "(//button[@name='Search'])[1]";
	public static final String OCR_AuthType_PopUp = "(//textarea[@name='licenseTypes.licenseType'])[1]";
	public static final String OCR_SelectOk = "(//button[@name='Ok'])[1]";
	public static final String Ocr_ClosePopUp = "(//button[@class='btn-close'])[1]";
	public static final String OCR_AuthorizationNo = "//input[@name='licenseHeader.licenseNo']";
	public static final String OCR_AuthStatus = "//select[@name='licenseStatus']";
	public static final String OCR_ActivityType = "//select[@name='activityType']";
	public static final String OCR_salesOrderNo = "//input[@name='licenseItem.salesOrderNo']";
	public static final String OCR_UltConsingnee = "//input[@name='licenseConsignee.licConsName']";
	public static final String OCR_ContractNo = "//input[@name='licenseHeader.contractNo']";
	public static final String OCR_ReferenceNo = "//input[@name='licenseHeader.referenceNo']";
	public static final String OCR_TECC = "//input[@name='licenseHeader.tecc']";
	public static final String OCR_IssueDatefrom = "//input[@name='fromIssueDate']";
	public static final String OCR_IssueDateTo = "//input[@name='toIssueDate']";
	public static final String OCR_Segment = "(//a[contains(text(),'Segment')])[2]";
	public static final String OCR_Originator = "//input[@name='licenseHeader.originator']";
	public static final String OCR_ExpireDay = "//input[@name='noofdays']";
	public static final String OCR_createdBy1 = "(//select[@name='licenseHeader.createdBy'])[1]";
	public static final String OCR_ExpireDateFrom = "//input[@name='fromExpireDate']";
	public static final String OCR_ExpireDateTo = "//input[@name='toExpireDate']";
	public static final String OCR_SalesOrderNo1 = "//input[@name='licenseHeader.salesOrderNo']";
	public static final String OCR_CaseNo = "//input[@name='licenseHeader.caseNo']";
	public static final String OCR_Country1 = "(//input[@name=''])[1]";

	// ******Selection criteria based on Authorization Item***************//

	public static final String OCR_SbuCode2 = "(//select[@name='licenseHeader.sbuCode'])[2]";
	public static final String OCR_ItemNo = "//input[@name='licenseItem.itemNo']";
	public static final String OCR_PartNo = "//input[@name='licenseItem.productCd']";
	public static final String OCR_activityTypeItem = "//select[@name='activityTypeItem']";
	public static final String OCR_Description = "//textarea[@name='licenseItem.description']";
	public static final String OCR_Quantity = "//input[@name='licenseItem.licenseQuantity']";
	public static final String OCR_licenseValue = "//input[@name='licenseValue']";
	public static final String OCR_AuthQty = "//input[@name='licenseItem.transactionQuantity']";
	public static final String OCR_transactionValue = "//input[@name='transactionValue']";
	public static final String OCR_createdBy2 = "(//select[@name='licenseHeader.createdBy'])[2]";
	public static final String OCR_SalesOrderNo2 = "//input[@name='licenseItem.salesOrderNo']";
	public static final String OCR_SO_ItemNO = "//input[@name='licenseItem.salesOrderLineItem']";
	public static final String OCR_Country2 = "(//input[@name=''])[2]";
	public static final String OCR_ECCN = "//input[@name='licenseItem.prodClassification']";

	// ***********************Selection criteria based on Authorization
	// Activity**********************//
	public static final String OCR_SBUCODE3 = "//select[@name='licenseTransaction.sbuCode']";
	public static final String OCR_ActivityDateFrom = "//input[@name='fromTransactionDate']";
	public static final String OCR_ActivityDateTo = "//input[@name='toTransactionDate']";
	public static final String OCR_activityType = "//select[@name='activityTypetxn']";
	public static final String OCR_CreatedBy = "//select[@name='licenseTransaction.createdBy']";
	public static final String OCR_Today = "//button[@data-handler='today']";

	// * ******************************* Constructor ******************************
	// *//

	public ReportAuthorizationActivityPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	/* ******************************* Action ****************************** */

	// clicking on Search
	public void search() {
		clickElement(driver, test, OCR_SEARCH, "Click on Search :");
	}

	// clicking on Search2
	public void search2() {
		clickElement(driver, test, OCR_SEARCH2, "Click on Search :");
	}

	// Click on Reset
	public void reset() {
		clickElement(driver, test, OCR_RESET, "Click on Reset :");
	}

	// Regression
	public void searchByParameters(String Sbu, String AuthTypeLink, String AuthNO, String AuthStatus, String ActivityType, 
			String UltConsingnee, String RefNo, String FromDate, String EndDate, String Segment, String Expiredays, String ExpireDateFrom, 
			String ExpireDateTo, String SalesOrderNo) {

		if (Sbu.length() > 0) {
			selectByVisibleText(driver, test, OCR_SBUCODE, "Select Sbu", Sbu);
		}
		if (AuthTypeLink.length() > 0) {
			clickElement(driver, test, OCR_AuthorizationType, "Click on Authorization Type Link");
			try {
				Wait.waitfor(2);
				typeText(driver, test, OCR_AuthType_PopUp, "Enter Authorization Type : ", AuthTypeLink);
				clickElement(driver, test, OCR_SearchPopUpButton, "Click on Pop-Up Search button");
				clickElement(driver, test, "//td[contains(text(),'" + AuthTypeLink + "')]",
						"Select the Authorization Type : " + AuthTypeLink);
				clickElement(driver, test, OCR_SelectOk, "Click on Select button");
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, Ocr_ClosePopUp, "Click on Close popup icon");

			}
			if (AuthNO.length() > 0) {
				typeText(driver, test, OCR_AuthorizationNo, "Enter Auth NO", AuthNO);
			}
			if (AuthStatus.length() > 0) {
				selectByVisibleText(driver, test, OCR_AuthStatus, "Auth Status", AuthStatus);
			}
			if (ActivityType.length() > 0) {
				selectByVisibleText(driver, test, OCR_ActivityType, "Select Activity Type", ActivityType);
			}
			if (UltConsingnee.length() > 0) {
				typeText(driver, test, OCR_UltConsingnee, "Enter UltConsingee :", UltConsingnee);
			}
			if (RefNo.length() > 0) {
				typeText(driver, test, OCR_ReferenceNo, "Enter Reference No :", RefNo);
			}
			if (FromDate.length() > 0) {
				clickElement(driver, test, OCR_IssueDatefrom, "Click on From date");
				if (FromDate.equalsIgnoreCase("Today")) {
					clickElement(driver, test, OCR_Today, "Selecting Today");
				} else {
					date(driver, test, "Select date", FromDate);
				}
			}
			if (EndDate.length() > 0) {
				clickElement(driver, test, OCR_IssueDateTo, "Click on End date");
				if (EndDate.equalsIgnoreCase("Today")) {
					clickElement(driver, test, OCR_Today, "Selecting Today");
				} else {
					date(driver, test, "Select date", EndDate);
				}
			}
			if (Segment.length() > 0) {
				clickElement(driver, test, OCR_Segment, "Click on Authorization Type Link");

				try {

					Wait.waitfor(2);
					clickElement(driver, test, "//td[contains(text(),'" + Segment + "')]",
							"Select the Authorization Type : " + Segment);
					clickElement(driver, test, OCR_SelectOk, "Click on Select button");
				} catch (Exception e) {
					testFailSshot(driver, test);
					clickElement(driver, test, Ocr_ClosePopUp, "Click on Close popup icon");

				}
			}
			typeText(driver, test, OCR_ExpireDay, "Enter Expireday :", Expiredays);
			if (ExpireDateFrom.length() > 0) {
				clickElement(driver, test, OCR_ExpireDateFrom, "Click on Expire From date");
				if (ExpireDateFrom.equalsIgnoreCase("Today")) {
					clickElement(driver, test, OCR_Today, "Selecting Today");
				} else {
					date(driver, test, "Select date", ExpireDateFrom);
				}
			}
			if (ExpireDateTo.length() > 0) {
				clickElement(driver, test, OCR_ExpireDateTo, "Click on Expire End date");
				if (ExpireDateTo.equalsIgnoreCase("Today")) {
					clickElement(driver, test, OCR_Today, "Selecting Today");
				} else {
					date(driver, test, "Select date", ExpireDateTo);
				}
			}
			typeText(driver, test, OCR_SalesOrderNo1, "Enter SalesOrder No  :", SalesOrderNo);
		}
	}

	public void Searchbyparameter2(String Sbucode2, String ItemNO, String PartNo, String activityTypeItem,
			String Description, String Quantity, String AuthQty, String AuthValue, String SOItemNO, String Country2,
			String ECCN) {

		selectByVisibleText(driver, test, OCR_SbuCode2, "Select sbu Code : ", Sbucode2);
		typeText(driver, test, OCR_ItemNo, "Enter Item no :", ItemNO);
		typeText(driver, test, OCR_PartNo, "Enter PartNo :", PartNo);
		selectByVisibleText(driver, test, OCR_activityTypeItem, "ActivityType", activityTypeItem);
		typeText(driver, test, OCR_Description, "Enter Description : ", Description);
		typeText(driver, test, OCR_Quantity, "Enter Quantity  :", Quantity);
		typeText(driver, test, OCR_AuthQty, "Enter Auth Qty  :", AuthQty);
		typeText(driver, test, OCR_transactionValue, "Enter Authorization Value  : ", AuthValue);
		typeText(driver, test, OCR_SO_ItemNO, "Enter SO ITEM NO  :", SOItemNO);
		typeText(driver, test, OCR_Country2, "Enter Country Name  :", Country2);
		typeText(driver, test, OCR_ECCN, "Enter ECCN :", ECCN);
	}

	// Search by parameter
	public void parameter(String Sbu, String AuthType, String AuthNO, String AuthStatus, String ActivityType,
			String salesOrderNo) {
		selectByVisibleText(driver, test, OCR_SBUCODE, "Select Sbu", Sbu);
		typeText(driver, test, OCR_AuthorizationType, "Enter Auth Type", AuthType);
		typeText(driver, test, OCR_AuthorizationNo, "Enter Auth NO", AuthNO);
		selectByVisibleText(driver, test, OCR_AuthStatus, "Auth Status", AuthStatus);
		selectByVisibleText(driver, test, OCR_ActivityType, "Select Activity Type", ActivityType);
		typeText(driver, test, OCR_salesOrderNo, "enter Sales Order No", salesOrderNo);
		scrollToElement(driver, OCR_SEARCH);
	}
}
