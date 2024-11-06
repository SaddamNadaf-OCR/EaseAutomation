package lpAppUKClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;
import utilities.Wait;

public class HomeLpUKPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_HomePage_SBU = "//li[@class='nav-item dropdown sbu-list']";
	public static final String OCR_HomePage_ModuleSelection = "(//a[@class='nav-link dropdown-item'])[2]";
	public static final String OCR_HomePage_ModuleLP = "//a[contains(text(),'License/Permit Application')]";
	public static final String OCR_HomePage_ModuleLP2 = "(//a[contains(text(),'License/Permit Application')])[2]";
	public static final String OCR_HomePage_LpFeature = "(//a[@class='nav-link dropdown-item'])[3]";
	public static final String OCR_HomePage_AddViewEditLicensePermit = "//a[contains(text(),'Add/View/Edit License/Permit')]";

	/* ******************** Constructor ***************************** */

	public HomeLpUKPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	// MouseOver to SBU Select and Module Selection and Click on Add/View/Edit License Permit
		public void moveTo_SBUSelection(String SBU) {
			mouseOver(driver, test, OCR_HomePage_SBU, "Mouseover to SBU selection");
			String SBUName = "//label[contains(text(),'" + SBU + "')]";		
			clickElement(driver, test, SBUName, "Click on SBU " +SBU);
			Wait.waitfor(2);
			mouseOver(driver, test, OCR_HomePage_ModuleSelection, "Mouseover to Module Selection");		
			clickElement(driver, test, OCR_HomePage_ModuleLP, "Click on LP Module");
			Wait.waitfor(2);
			mouseOver(driver, test, OCR_HomePage_LpFeature, "Mouseover to LP Feature");
			clickElement(driver, test, OCR_HomePage_AddViewEditLicensePermit, "Click on Add/View/Edit License Permit");
		}

	// Return to LP Home page
	public void returnHomepageLP() {
		mouseOver(driver, test, OCR_HomePage_ModuleSelection, "Mouseover to Module Selection");
		clickElement(driver, test, OCR_HomePage_ModuleLP2, "Click on LP Module");
	}

}
