package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class CreateNewDutyReliefAuthorizationDetailsPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_CreateDRAuth_RefID = "//input[@id='editDutyReliefGeneralInfo_dutyReliAuthDetails_referenceID']";
	public static final String OCR_CreateDRAuth_DRType = "//select[@id='editDutyReliefGeneralInfo_dutyReliAuthDetails_reliefType']";
	public static final String OCR_CreateDRAuth_Category = "//select[@id='editDutyReliefGeneralInfo_dutyReliAuthDetails_reliefCategory']";
	public static final String OCR_CreateDRAuth_AuthNo = "//input[@id='editDutyReliefGeneralInfo_dutyReliAuthDetails_reliefAuthNo']";
	public static final String OCR_CreateDRAuth_ValidFromDate = "//input[@id='editDutyReliefGeneralInfo_validFromDate']";
	public static final String OCR_CreateDRAuth_ValidToDate = "//input[@id='editDutyReliefGeneralInfo_validToDate']";
	public static final String OCR_CreateDRAuth_AuthItems = "//select[@id='editDutyReliefGeneralInfo_dutyReliAuthDetails_authorizationHasItems']";
	public static final String OCR_CreateDRAuth_ReliefPeriodDDMMYYYY = "//select[@id='editDutyReliefGeneralInfo_dutyReliAuthDetails_reliefPeriodType']";
	public static final String OCR_CreateDRAuth_SaveBtn = "//button[@id='saveBtn']";
	public static final String OCR_CreateDRAuth_LineItemDetailsTab = "//a[contains(text(),'Line Item Details')]";

	/* ******************************* Constructor ****************************** */

	public CreateNewDutyReliefAuthorizationDetailsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	// Enter mandatory fields on Header Details section
	public void headerDetailsInfo(String RefID, String DRType, String Category, String AuthNo, String ValidFrDate,
			String ValidToDate, String AuthItem, String ReliefDate) {
		clearText(driver, test, OCR_CreateDRAuth_RefID, "Clear already existing text");
		typeText(driver, test, OCR_CreateDRAuth_RefID, "Enter Reference ID : ", RefID + randomnumbers());
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCR_CreateDRAuth_DRType, "Select Duty Relief Type : ", DRType);
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCR_CreateDRAuth_Category, "Select Category : ", Category);
		Wait.waitfor(2);
		typeText(driver, test, OCR_CreateDRAuth_AuthNo, "Enter Authorization Number : ", AuthNo + randomnumbers());
		Wait.waitfor(2);
		clickElement(driver, test, OCR_CreateDRAuth_ValidFromDate, "Click on valid from Date calender");
		date(driver, test, "Select the valid From Date : ", ValidFrDate);
		Wait.waitfor(2);
		clickElement(driver, test, OCR_CreateDRAuth_ValidToDate, "Click on valid To Date Calender");
		date(driver, test, "Select the valid To Date : ", ValidToDate);
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCR_CreateDRAuth_AuthItems, "Select Authorization Items as Yes or No : ",
				AuthItem);
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCR_CreateDRAuth_ReliefPeriodDDMMYYYY,
				"Select Relief Period Day/Month/Year : ", ReliefDate);

	}

	public void saveBtn() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_CreateDRAuth_SaveBtn, "Click on Save button");
	}

	public void lineItemDetails() {
		clickElement(driver, test, OCR_CreateDRAuth_LineItemDetailsTab, "Click on Line Item Details tab");
	}

}
