package productClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class HomePageProduct extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_HomePage_SBU = "(//a[@class='nav-link dropdown-item'])[1]";
	public static final String OCR_HomePage_ModuleSelection = "(//a[@class='nav-link dropdown-item'])[2]";
	public static final String OCR_HomePage_WathchlistScreening="(//a[contains(text(),'Watch List Screening')])[1]";
	public static final String OCR_HomePage_ModuleGExport = "//a[contains(text(),'Export Operations')]";
	public static final String OCR_HomePage_Files = "(//a[@class='nav-link dropdown-item'])[5]";
	public static final String OCR_HomePageProduct = "(//a[contains(text(),'Products')])[1]";
	public static final String OCR_HomePage_Report = "(//a[@class='nav-link dropdown-item'])[4]";
	public static final String OCR_HomePage_ProductReport = "//a[contains(text(),'Product Report')]";
	public static final String OCR_HomePage_File =	"(//a[@class='nav-link dropdown-item'])[1]";
	public static final String OCR_HomePage_Fil="(//a[@class='nav-link dropdown-item'])[4]";
	
	/* ******************** Constructor ***************************** */

	public HomePageProduct(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	// Move to SBU Select and module selections
	public void moveTo_SBUSelection(String SBU) {
		mouseOver(driver, test, OCR_HomePage_SBU, "On Mouse Click Select the SBU");
		clickElement(driver, test, "//label[contains(text(),'" + SBU + "')]", "Click on SBU : " + SBU);
		Wait.waitfor(6);
		mouseOver(driver, test, OCR_HomePage_ModuleSelection, "Mouseover to Module Selection");
		Wait.waitfor(6);
		clickElement(driver, test, OCR_HomePage_WathchlistScreening, "Click on watchlist Screening");
	}

	// Click on Files
	public void movetoFiles() {
		mouseOverAndClick(driver, test, OCR_HomePage_Files, "Mouseover to Files");
		Wait.waitfor(3);
		mouseOver(driver, test, OCR_HomePageProduct, "mousehover on product");
		clickElement(driver, test, OCR_HomePageProduct, "Click on Product");
	}

	public void returnToSearchProductPage() {
		mouseOver(driver, test, OCR_HomePage_Files, "Mouseover to Files");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePageProduct, "Click on Product");
	}

	// Click on Reports
	public void movetoReports() {			
		mouseOver(driver, test, OCR_HomePage_Report, "Mouseover to Report");
		clickElement(driver, test, OCR_HomePage_ProductReport, "Click on Product Report: ");
		Wait.waitfor(3);
		clickElement(driver, test, "//label[contains(text(),'Description')]","Click on label Description: ");
	}
	
	public void returnToProductReportPage() {
		mouseOver(driver, test, OCR_HomePage_Report, "Mouseover to Report");
		clickElement(driver, test, OCR_HomePage_ProductReport, "Click on Product Report: ");
	}


}
