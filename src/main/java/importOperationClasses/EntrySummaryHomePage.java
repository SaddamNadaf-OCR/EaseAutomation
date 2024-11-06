package importOperationClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class EntrySummaryHomePage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_EntrySummaryHomePage_SBU = "//ul[@class='nav navbar-nav']/li[1]/a";
	public static final String OCR_EntrySummaryHomePage_ModuleSelection = "//ul[@class='nav navbar-nav']/li[2]/a";
	public static final String OCR_EntrySummaryHomePage_ModuleIO = "//ul[@class='dropdown-menu']//a[contains(text(),'Import Operations')]";
	public static final String OCR_EntrySummaryHomePage_ModuleIO2 = "(//a[contains(text(),'Import Operations')])[2]";
	public static final String OCR_EntrySummaryHomePage_IOFeature = "//ul[@class='nav navbar-nav']/li[3]/a";
	public static final String OCR_EntrySummaryHomePage_IOentry = "(//a[contains(text(),'Entry')])[2]";
	public static final String OCR_EntrySummaryHomePage_clickEntrySummary = "(//a[contains(text(),'Entry Summary')])[1]";

	/* ******************** Constructor ***************************** */

	public EntrySummaryHomePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	// Select SBU & Select Import Operation Module
	public void moveTo_SBUSelection(String SBU) {
		mouseOver(driver, test, OCR_EntrySummaryHomePage_SBU, "Mouseover to SBU selection");
		String SBUName = "//label[contains(text(),'" + SBU + "')]";
		clickElement(driver, test, SBUName, "Click on " + SBU);
		Wait.waitfor(2);
		mouseOver(driver, test, OCR_EntrySummaryHomePage_ModuleSelection, "Mouseover to Module Selection");
		clickElement(driver, test, OCR_EntrySummaryHomePage_ModuleIO, "Click on IO Module");
		Wait.waitfor(3);
	}

	// select Feature , Entry and Entry Summary Option
	public void SelectFeatureAndEntry() {
		mouseOver(driver, test, OCR_EntrySummaryHomePage_IOFeature, "Mouseover to IO Feature");
		clickElement(driver, test, OCR_EntrySummaryHomePage_IOentry, "click on entry");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_EntrySummaryHomePage_clickEntrySummary, "click on Entry Summary");
	}

	// Return to Import Home page
	public void returnHomepageImport() {
		Wait.waitfor(3);
		mouseOver(driver, test, OCR_EntrySummaryHomePage_ModuleSelection, "Mouseover to Module Selection");
		clickElement(driver, test, OCR_EntrySummaryHomePage_ModuleIO2, "Click on IO Module");
	}

}
