package filesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class AuthorizationMgmtHomepagePage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_HomePage_SBU = "(//a[@class='nav-link dropdown-item'])[1]";
	public static final String OCR_HomePage_ModuleSelection = "(//a[@class='nav-link dropdown-item'])[2]";
	public static final String OCR_HomePage_WathchlistScreening = "(//a[contains(text(),'Watch List Screening')])[2]";
	public static final String OCR_HomePage_Files = "(//a[@class='nav-link dropdown-item'])[5]";
	public static final String OCR_HomePage_Consignee = "(//a[contains(text(),'Consignees')])[1]";
	public static final String OCR_AddConsignee = "//button[contains(text(),'Add Consignee')]";
	public static final String OCR_HomePage_Report = "(//a[@class='nav-link dropdown-item'])[3]";
	public static final String OCR_HomepageConsigneeSummaryReport = "//a[contains (text(),'Consignee Summary Report')]";
	public static final String OCR_Homepage_Logout = "//i[@class='fa fa-sign-out']";
	public static final String OCRHomepage_alertGotIt = "(//button[@id='enhanced-search-info-gotit'])[1]";
	public static final String OCRHomePage_FreightForwarders = "(//a[contains(text(),'Freight Forwarders')])[4]";
	public static final String OCR_AuthoMangentModule = "(//a[contains (text(),'Authorization Management')])[1]";
	public static final String OCR_authorizationOwners = "//a[contains(text(),'Authorization Owners')]";
	public static final String OCR_BOM = "//a[contains(text(),'Bill Of Material')]";
	public static final String OCR_FlagReason = "//a[contains(text(),'Flag Reasons')]";
	/* ******************** Constructor ***************************** */

	public AuthorizationMgmtHomepagePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	// Move to SBU Select and module selections
	public void moveTo_SBUSelection(String SBU) {
		mouseOver(driver, test, OCR_HomePage_SBU, "move to SBU selection");
		clickElement(driver, test, "//label[contains(text(),'" + SBU + "')]", "Click on SBU : " + SBU);
		Wait.waitfor(3);
		mouseOver(driver, test, OCR_HomePage_ModuleSelection, "Mouseover to Module Selection");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_AuthoMangentModule, "Click on authorization management Module");
	}

	// Click on Files
	public void movetoFiles() {
		mouseOverAndClick(driver, test, OCR_HomePage_Files, "Mouseover to Files");
		Wait.waitfor(3);
		mouseOver(driver, test, OCR_authorizationOwners, "mousehover on authorizationOwner");
		clickElement(driver, test, OCR_authorizationOwners, "Click on authorizationOwner");
	}

	public void movetoBOM() {
		mouseOverAndClick(driver, test, OCR_HomePage_Files, "Mouseover to Files");
		Wait.waitfor(3);
		mouseOver(driver, test, OCR_BOM, "mousehover on authorizationOwner");
		clickElement(driver, test, OCR_BOM, "Click on authorizationOwner");
	}

	public void movetoFlagReason() {
		mouseOverAndClick(driver, test, OCR_HomePage_Files, "Mouseover to Files");
		Wait.waitfor(3);
		mouseOver(driver, test, OCR_FlagReason, "mousehover on authorizationOwner");
		clickElement(driver, test, OCR_FlagReason, "Click on authorizationOwner");

	}

	public void logout() {
		clickElement(driver, test, OCR_Homepage_Logout, "click on logout");

	}

	public void scrollto() {
		scrollToTop(driver);
	}
}
