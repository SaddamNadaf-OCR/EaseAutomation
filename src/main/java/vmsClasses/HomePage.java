package vmsClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;
import utilities.Wait;

public class HomePage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_HomePage_SBUSelection = "//ul[@class='nav navbar-nav']/li[1]/a";
	public static final String OCR_HomePage_ListScreening = "//ul[@class='nav navbar-nav']/li[2]/a";
	public static final String OCR_HomePage_LogOut = "//i[@class='fa fa-sign-out']";
	public static final String OCR_HomePage_VisitorManagement = "//a[contains(text(),'Visitor Management')]";
	public static final String OCR_HomePage_VisitorManagement2 = "(//a[contains(text(),'Visitor Management')])[2]";
	public static final String OCR_HomePage_Tables = "//ul[@class='nav navbar-nav']/li[6]/a";
	public static final String OCR_HomePage_VisitPurpose = "//a[contains(text(),'Visit Purpose')]";
	
	/* ******************** Constructor ***************************** */

	public HomePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	// Move to SBU Select and module selections
	public void moveTo_SBUSelection(String SBU) {
		mouseOver(driver, test, OCR_HomePage_SBUSelection, "Mouse over on SBU Selections");
		Wait.waitfor(3);
		clickElement(driver, test, "//label[contains(text(),'" + SBU + "')]", "Click on SBU : " + SBU);
		Wait.waitfor(4);
		mouseOver(driver, test, OCR_HomePage_ListScreening, "Mouse over on Module Selection");
		Wait.waitfor(2);
	}

	// Click on visitor management
	public void click_VisitorManagemtn() throws InterruptedException {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_HomePage_VisitorManagement, "Clicking on Visitor Management");
	}

	// Return to visitor management page
	public void returnPage() {
		
		scrollToElement(driver, OCR_HomePage_ListScreening);
		Wait.waitfor(3);
		mouseOver(driver, test, OCR_HomePage_ListScreening, "Mouse over on Watch List Screening");
		Wait.waitfor(4);
		clickElement(driver, test, OCR_HomePage_VisitorManagement, "click on Visitor Management");
	}

	// Click on LOG Out Icon
	public void clickLogOut() {
		clickElement(driver, test, OCR_HomePage_LogOut, "Click on Log Out");
	}

	// Click on LOG Out icon and click on log out
	public void click_LogOutPortal() {
		clickElement(driver, test, OCR_HomePage_LogOut, "Click on Log Out Icon");
		clickElement(driver, test, "//a[contains(text(),'Sign out')]", "Click on Log Out");
	}
	
	// Mouse over to Tables and Select the Visit purpose
	public void clickVisitPurpose() {
		mouseOver(driver, test, OCR_HomePage_Tables, "Mouse Over to Tables");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePage_VisitPurpose, "Click on Visit Purpose");
		Wait.waitfor(3);
	}
	
	

}
