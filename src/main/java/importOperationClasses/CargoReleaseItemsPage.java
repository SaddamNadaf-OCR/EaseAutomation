package importOperationClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class CargoReleaseItemsPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_CR_Items_AddBOLBtn = "//button[@name='addBol']";
	public static final String OCR_CR_Items_AddItemsBtn = "//button[contains(text(),'Add Items')]";
	public static final String OCR_CR_Items_ClickItemOne = "//a[contains(text(),'1')]";
	public static final String OCR_CR_Items_ClickSubmitTab = "//a[@class='submit']";
	public static final String OCR_CR_Items_ClickBol1 = "(//a[contains(text(),'1')])[1]";
	public static final String OCR_CR_Items_ClickAlertIcon = "//i[@class='fa fa-exclamation-triangle']";
	public static final String OCR_CR_Items_CloseAlertPopup = "//button[@class='close']";
	public static final String OCR_CR_Items_CloseAlert = "(//button[@class='close'])[2]";
	public static final String OCR_CR_Items_CloseAlert3 = "(//button[@class='close'])[3]";
	public static final String OCR_CR_Items_CloseAlert4 = "(//button[@class='close'])[4]";

	/* ******************** Constructor ***************************** */
	public CargoReleaseItemsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	// Click Alert Icon
	public void clickAlertIcon() {
		Wait.waitfor(4);
		clickElement(driver, test, OCR_CR_Items_ClickAlertIcon, "Click on alert icon ");
	}

	// Close Alert Pop Up
	public void closeAlertPopUp() {
		Wait.waitfor(4);
		clickElement(driver, test, OCR_CR_Items_CloseAlertPopup, "Close Alert Pop Up ");
	}

	// Close Alert Pop Up
	public void closeAlertSec() {
		Wait.waitfor(4);
		clickElement(driver, test, OCR_CR_Items_CloseAlert, "Close Alert Pop Up ");
	}

	// Close Alert Pop Up
	public void closeAlertTh() {
		Wait.waitfor(4);
		clickElement(driver, test, OCR_CR_Items_CloseAlert3, "Close Alert Pop Up ");
	}

	// Close Alert Pop Up
	public void closeAlert4th() {
		Wait.waitfor(4);
		clickElement(driver, test, OCR_CR_Items_CloseAlert4, "Close Alert Pop Up ");
	}

	// Click Bills of Lading
	public void clkBillOfLading() {
		Wait.waitfor(4);
		clickElement(driver, test, OCR_CR_Items_AddBOLBtn, "Click on add BOI ");
	}

	// Click Item Details
	public void clkAddItems() {
		clickElement(driver, test, OCR_CR_Items_AddItemsBtn, "Click on Add Items");
	}

	// Click Item 1

	public void clkAddItems1() {
		clickElement(driver, test, OCR_CR_Items_ClickItemOne, "Click on 1st Items");
	}

	// Click on Submit Tab
	public void submitTab() {
		clickElement(driver, test, OCR_CR_Items_ClickSubmitTab, "Click on Submit Tab");
	}

	// Click BOL 1
	public void clickBOL1() {
		clickElement(driver, test, OCR_CR_Items_ClickBol1, "Click on BOL 1");
	}

	// Validation for Bill of Lading Details
	public void validationBillOfLading() {
		try {
			if (isDisplayed(driver, "//td[contains(text(),'Bill of lading is missing')]")) {
				test.log(LogStatus.INFO, "Bill of lading is missing");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Error is not Displayed by clicking on Alert Icon for Cargo Release");
		}
	}

	// Validation for issuer code
	public void validationIssuerCode() {
		try {
			if (isDisplayed(driver,
					"//table[@class='table table-condensed table-bordered']//td[contains(text(),'Issuer Code is mandatory for item no. 1')]")) {
				test.log(LogStatus.INFO, "Issuer Code is mandatory for item no. 1");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Error is not Displayed by clicking on Alert Icon for Cargo Release");
		}
	}

	// Validation for House Bill
	public void validationHouseBill() {
		try {
			if (isDisplayed(driver, "(//td[contains(text(),'House bill is required')])[2]")) {
				test.log(LogStatus.INFO, "House bill is required");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Error is not Displayed by clicking on Alert Icon for Cargo Release");
		}
	}

	// Validation for Item Details
	public void validationItemDetails() {
		try {
			if (isDisplayed(driver,
					"//table[@class='table table-condensed table-bordered']//td[contains(text(),'Item details is missing')]")) {
				test.log(LogStatus.INFO, "Item details is missing");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Error is not Displayed by clicking on Alert Icon for Cargo Release");
		}
	}

	// Validation for Country of orgin, Consignee , Manufacturer AND Primary Value

	public void validationInItemsDetails() {
		try {
			if (isDisplayed(driver,
					"//table[@class='table table-condensed table-bordered']//td[contains(text(),'Country of orgin missing for Line Item : 1')]")) {
				test.log(LogStatus.INFO, "Country of orgin missing for Line Item : 1");
			}
			if (isDisplayed(driver,
					"//table[@class='table table-condensed table-bordered']//td[contains(text(),'Consignee is required for item no. 1')]")) {
				test.log(LogStatus.INFO, "Consignee is required for item no. 1");
			}
			if (isDisplayed(driver,
					"//table[@class='table table-condensed table-bordered']//td[contains(text(),'Manufacturer is required for item no. 1')]")) {
				test.log(LogStatus.INFO, "Manufacturer is required for item no. 1");
			}
			if (isDisplayed(driver,
					"//table[@class='table table-condensed table-bordered']//td[contains(text(),'Primary Value is required if action code is Add OR')]")) {
				test.log(LogStatus.INFO, "Primary Value is required if action code is Add OR Replace for item no. 1");
			}

		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Error is not Displayed by clicking on Alert Icon for Cargo Release");
		}
	}	

}
