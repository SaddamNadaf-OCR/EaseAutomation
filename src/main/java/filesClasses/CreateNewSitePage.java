package filesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class CreateNewSitePage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	// ---------------------------------------Locators--------------------------------------------//

	public static final String Create_SiteID = "//input[@name='dosSite.siteId']";
	public static final String Create_SiteName = "//input[@name='dosSite.siteName']";
	public static final String OCR_Save = "//button[@name='save']";
	public static final String OCR_SaveandReturn = "//button[@name='ok']";

	// -------------------------------Constructors----------------------------------------------//

	public CreateNewSitePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	// -----------------------------SiteID-------------------------------------------//

	public void enterSiteID(String SiteID, String SiteName) {

		typeText(driver, test, Create_SiteID, "Enter ProgramCode :", SiteID);
		typeText(driver, test, Create_SiteName, "Enter Description :", SiteName);
	}

	// -------------------------------Save-------------------------------------------------//
	public void save() {
		scrollToElement(driver, OCR_Save);
		Wait.waitfor(3);
		scrollToTop(driver);
		clickElement(driver, test, OCR_Save, "Click on Save Button ");
	}

	// --------------------------------Save&Return-------------------------------------------//
	public void saveandReturn() {
		scrollToElement(driver, OCR_SaveandReturn);
		Wait.waitfor(3);
		scrollToTop(driver);
		clickElement(driver, test, OCR_SaveandReturn, "Click on Save Button ");
	}

}
