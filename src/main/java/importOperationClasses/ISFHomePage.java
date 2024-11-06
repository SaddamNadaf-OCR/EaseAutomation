package importOperationClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class ISFHomePage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_ISFHomePage_SBU = "//li[@class='dropdown sbu-list']";
	public static final String OCR_ISFHomePage_ModuleSelection = "//li[@class='dropdown active-mod']";
	public static final String OCR_ISFHomePage_ModuleIO = "//ul[@class='dropdown-menu']//a[contains(text(),'Import Operations')]";
	public static final String OCR_ISFHomePage_ModuleIO2 = "(//a[contains(text(),'Import Operations')])[2]";
	public static final String OCR_ISFHomePage_IOFeature = "(//a[@class='dropdown-toggle'])[3]";
	public static final String OCR_ISFHomePage_IOentry = "(//a[contains(text(),'Entry')])[1]";
	public static final String OCR_ISFHomePage_ClickISF = "(//a[contains(text(),'Security Filing (ISF)')])[1]";

	/* ******************** Constructor ***************************** */

	public ISFHomePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	// Select SBU & Select Import Module

	public void moveTo_SBUSelection(String SBU) {
		mouseOver(driver, test, OCR_ISFHomePage_SBU, "Mouseover to SBU selection");
		Wait.waitfor(3);
		String SBUName = "//label[contains(text(),'" + SBU + "')]";
		Wait.waitfor(3);
		clickElement(driver, test, SBUName, "Click on " + SBU);
		Wait.waitfor(3);
		mouseOver(driver, test, OCR_ISFHomePage_ModuleSelection, "Mouseover to Module Selection");
		clickElement(driver, test, OCR_ISFHomePage_ModuleIO, "Click on IO Module");
		Wait.waitfor(3);
	}

	// select Feature and Security Filing (ISF) option
	public void SelectFeatureAndPreEntry() {
		mouseOver(driver, test, OCR_ISFHomePage_IOFeature, "Mouseover to IO Feature");
		Wait.waitfor(5);
		clickElement(driver, test, OCR_ISFHomePage_IOentry, "click on Pre-entry");
		Wait.waitfor(5);
		clickElement(driver, test, OCR_ISFHomePage_ClickISF, "click on Security Filing (ISF)");
		Wait.waitfor(5);
	}

	// Return to Import Home page
	public void returnHomepageImport() {
		Wait.waitfor(3);
		mouseOver(driver, test, OCR_ISFHomePage_ModuleSelection, "Mouseover to Module Selection");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_ISFHomePage_ModuleIO2, "Click on IO Module");
	}
}
