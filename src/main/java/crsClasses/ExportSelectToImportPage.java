package crsClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class ExportSelectToImportPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_SelectToImp_Import = "//button[@name='select']";
	public static final String OCR_SelectToImp_Return = "//button[contains(text(),'Return')]";
	public static final String OCR_SelectToImp_SelectAll = "//input[@name='selectBox1']";

	/* ******************** Constructor ***************************** */

	public ExportSelectToImportPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	// Click on Import button
	public void click_Import() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_SelectToImp_Import, "Click on Import button");
	}

	// Click on Return button
	public void click_Return() {
		clickElement(driver, test, OCR_SelectToImp_Return, "Click on Return button");
	}

	// Click on SelectAll button
	public void click_selectAll() {
		clickElement(driver, test, OCR_SelectToImp_SelectAll, "Click on SelectAll button");
		if (isSelected(driver, "//input[@id='itemNo']"))
			test.log(LogStatus.PASS, "Item check box is Selected");
		else
			test.log(LogStatus.FAIL, "Item check box is Not Selected");
		if (isSelected(driver, "//input[@id='countryItemNo']"))
			test.log(LogStatus.PASS, "Country check box is Selected");
		else
			test.log(LogStatus.FAIL, "Country check box is Not Selected");
		if (isSelected(driver, "//input[@id='consigneeItemNo']"))
			test.log(LogStatus.PASS, "Consignee check box is Selected");
		else
			test.log(LogStatus.FAIL, "Consignee  check box is Not Selected");
		if (isSelected(driver, "//input[@id='ffItemNo']"))
			test.log(LogStatus.PASS, "Freight Forwarder check box is Selected");
		else
			test.log(LogStatus.FAIL, "Freight Forwarder check box is Not Selected");
		if (isSelected(driver, "//input[@id='notesItemNo']"))
			test.log(LogStatus.PASS, "Notes check box is Selected");
		else
			test.log(LogStatus.FAIL, "Notes check box is Not Selected");
	}

	// validating the inforamtion after Clicking on import button
	public void validate_SelectToImport() {
		try {
			if (isDisplayed(driver, "//h4[contains(text(),'Information!')]")) {
				if (isDisplayed(driver, "//li[contains(text(),'1 out of 1 Item(s) Imported Successfully.')]")) {
					test.log(LogStatus.INFO, "1 out of 1 Item(s) Imported Successfully.");
				}
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL,
					"Error Vaildation is not Displayed by clicking on Import button in Select to import page");
		}
	}

}
