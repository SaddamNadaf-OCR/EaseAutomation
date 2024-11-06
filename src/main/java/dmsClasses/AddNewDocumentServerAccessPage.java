package dmsClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class AddNewDocumentServerAccessPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_FTPName = "//select[@id='ftpName']";
	public static final String OCR_AccessType = "//select[@id='accessType']";
	public static final String OCR_AccountNo = "//a[contains(text(),'Account No')]";
	public static final String OCR_AttributeSBU = "//select[@name='ftpAttributeSbu']";
	public static final String OCR_AttributeUser = "//input[@id='accessTypeUser']";
	public static final String OCR_Button_Save = "//button[@name='save']";
	public static final String OCR_Button_SavendReturn = "//button[@name='okx']";
	public static final String OCR_Button_Select = "//button[contains(text(),'Select')]";
	public static final String OCR_POPUpClose = "//div[@id='ocrModal']//button[@class='close']";

	/* ******************************* Constructor ****************************** */

	public AddNewDocumentServerAccessPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	public void addnewdocserveracess(String AccountNo, String FTPName, String AccessType, String Attribute) {
		if (AccountNo.length() > 0) {
			clickElement(driver, test, OCR_AccountNo, "Clicking on Account No");
			typeText(driver, test, "//input[@id='stdAccountInfoPopup_accountInfo_accountNo']", "Enter Account No: ",
					AccountNo);
			clickElement(driver, test, "//button[contains(text(),'Search')]", "Click on search button");
			String addaccount = "//table[@id='gridPopup']/tbody/tr[2]/td[contains(text(),'" + AccountNo + "')]";
			try {
				if (isDisplayed(driver, addaccount)) {
					clickElement(driver, test, addaccount, "Click on search record");
					test.log(LogStatus.PASS, "Add Product Line in add to result grid table : " + AccountNo);
					Wait.waitfor(2);
					clickElement(driver, test, OCR_Button_Select, "Click on Select Button");
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Fail to Add Product Line in result grid table : " + AccountNo);
				clickElement(driver, test, OCR_POPUpClose, "Click on POP up close Icon");
			}
		}
		selectByVisibleText(driver, test, OCR_FTPName, "Select FTP Name : ", FTPName);
		selectByVisibleText(driver, test, OCR_AccessType, "Select AccessType : ", AccessType);
		if (AccessType.contains("SBU")) {
			Wait.waitfor(5);
			selectByVisibleText(driver, test, OCR_AttributeSBU, "Select Attribute: ", Attribute);
		} else {
			typeText(driver, test, OCR_AttributeUser, "Enter Attribute: ", Attribute);
		}
	}

	public void save() {
		clickElement(driver, test, OCR_Button_Save, "Click on Save Button");
	}

	public void savendreturn() {
		clickElement(driver, test, OCR_Button_SavendReturn, "Click on Save and Return Button");
	}

}
