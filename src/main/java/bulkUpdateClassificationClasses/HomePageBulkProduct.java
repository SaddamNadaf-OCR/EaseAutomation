package bulkUpdateClassificationClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class HomePageBulkProduct extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_HomePage_SBU = "//a[@class='dropdown-toggle']";
	public static final String OCR_HomePage_ModuleSelection = "(//a[@class='dropdown-toggle'])[2]";
	public static final String OCR_HomePage_ModuleGExport = "//a[contains(text(),'Export Operations')]";
	public static final String OCR_HomePage_Tools = "(//a[@class='dropdown-toggle'])[8]";
	public static final String OCR_HomePageBulkUpdateClassification = "//a[contains(text(),'Bulk Update Classification')]";

	/* ******************** Constructor ***************************** */

	public HomePageBulkProduct(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	// Move to SBU Select and module selections
	public void moveTo_SBUSelection(String SBU) {
		mouseOver(driver, test, OCR_HomePage_SBU, "On Mouse Click Select the SBU");
		clickElement(driver, test, "//label[contains(text(),'" + SBU + "')]", "Click on SBU : " + SBU);
		mouseOver(driver, test, OCR_HomePage_ModuleSelection, "Mouseover to Module Selection");
		clickElement(driver, test, OCR_HomePage_ModuleGExport, "Click on Global Export Module");
	}
	
	// Click on Tools
		public void movetoTools() {
			mouseOver(driver, test, OCR_HomePage_Tools, "Mouseover to Tools");
			Wait.waitfor(3);
			clickElement(driver, test, OCR_HomePageBulkUpdateClassification, "Click on Bulk Update Classification");
		}

		public void returnToBulkUpdateClassificationPage() {
			mouseOver(driver, test, OCR_HomePage_Tools, "Mouseover to Tools");
			Wait.waitfor(3);
			clickElement(driver, test, OCR_HomePageBulkUpdateClassification, "Click on Bulk Update Classification");
		}

}
