package importOperationClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;
import utilities.Wait;

public class HomePage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_HomePage_SBU = "//li[@class='dropdown sbu-list']";
	public static final String OCR_HomePage_ModuleSelection = "//li[@class='dropdown active-mod']";
	public static final String OCR_HomePage_ModuleIO = "//ul[@class='dropdown-menu']//a[contains(text(),'Import Operations')]";
	public static final String OCR_HomePage_ModuleIO2 = "(//a[contains(text(),'Import Operations')])[2]";
	public static final String OCR_HomePage_IOFeature = "(//a[@class='dropdown-toggle'])[3]";
	public static final String OCR_HomePage_IOentry = "(//a[contains(text(),'Entry')])[2]";
	public static final String OCR_HomePage_clickCargoRelease = "(//a[contains(text(),'Cargo Release')])[1]";

	/* ******************** Constructor ***************************** */

	public HomePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	// Select SBU & Select Import Module
	public void moveTo_SBUSelection(String SBU) {
		mouseOver(driver, test, OCR_HomePage_SBU, "Mouseover to SBU selection");
		String SBUName = "//label[contains(text(),'" + SBU + "')]";
		clickElement(driver, test, SBUName, "Click on " + SBU);
		Wait.waitfor(2);
		mouseOver(driver, test, OCR_HomePage_ModuleSelection, "Mouseover to Module Selection");
		clickElement(driver, test, OCR_HomePage_ModuleIO, "Click on IO Module");
		Wait.waitfor(3);
	}

	// select Feature and Cargo Release option
	public void SelectFeatureAndEntry() {
		mouseOver(driver, test, OCR_HomePage_IOFeature, "Mouseover to IO Feature");
		clickElement(driver, test, OCR_HomePage_IOentry, "click on entry");
		clickElement(driver, test, OCR_HomePage_clickCargoRelease, "click on Cargo Release");
	}

	// Return to Import Home page
	public void returnHomepageImport() {
		mouseOver(driver, test, OCR_HomePage_ModuleSelection, "Mouseover to Module Selection");
		clickElement(driver, test, OCR_HomePage_ModuleIO2, "Click on IO Module");
	}
}
