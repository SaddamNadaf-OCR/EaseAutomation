package nrcLicensingClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class HomePageNrcLicense extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_HomePage_SBU = "//ul[@class='nav navbar-nav']/li[1]/a";
	public static final String OCR_HomePage_ModuleSelection = "//ul[@class='nav navbar-nav']/li[2]/a";
	public static final String OCR_HomePage_ModuleNrcLicense = "//a[contains(text(),'NRC Licensing')]";
	public static final String OCR_HomePage_ReturnModuleNrcLicense = "(//a[contains(text(),'NRC Licensing')])[2]";
	public static final String OCR_HomePage_AddApplication = "//button[@id='mybutton']";
	public static final String OCR_HomePage_New = "//button[contains(text(),'New')]";
	public static final String OCR_HomePage_NrcReport = "//ul[@class='nav navbar-nav']/li[4]/a";
	public static final String OCR_HomePage_AdhocReport = "//a[contains(text(),'Ad hoc Application Report')]";
	public static final String OCR_HomePage_AuditReport = "//a[contains(text(),'Web Service Audit Report')]";
	public static final String OCR_HomePage_Feature = "//ul[@class='nav navbar-nav']/li[3]/a";
	public static final String OCR_HomePage_NRCForm = "(//a[contains(text(),'NRC Form 7')])[1]";


	/* ******************** Constructor ***************************** */

	public HomePageNrcLicense(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	// Move to SBU Select and module selections
	public void moveTo_SBUSelection(String SBU) {
		mouseOver(driver, test, OCR_HomePage_SBU, "On Mouse Click Select the SBU :");
		clickElement(driver, test, "//label[contains(text(),'" + SBU + "')]", "Click on SBU : " + SBU);
		Wait.waitfor(3);
		mouseOver(driver, test, OCR_HomePage_ModuleSelection, "Mouseover to Module Selection :");
		clickElement(driver, test, OCR_HomePage_ModuleNrcLicense, "Click on NRC License Module :");
	}

	public void movetoAdhocApplicationReport() {
		Wait.waitfor(3);
		mouseOver(driver, test, OCR_HomePage_NrcReport, "Mouseover to Nrc Report :");
		clickElement(driver, test, OCR_HomePage_AdhocReport, "Click on Ad hoc Application Report :");
	}

	public void moveToFeature() {
		Wait.waitfor(3);
		mouseOver(driver, test, OCR_HomePage_Feature, "Mouseover to NRC Feature :");
		clickElement(driver, test, OCR_HomePage_NRCForm, "Click on NRC Form 7 :");
	}

	public void movetoWebserviceAuditApplicationReport() {
		mouseOver(driver, test, OCR_HomePage_NrcReport, "Mouseover to Nrc Report :");
		clickElement(driver, test, OCR_HomePage_AuditReport, "Click on Web Service Audit Application Report :");
	}

	public void NrcreturnPage() {
		mouseOver(driver, test, OCR_HomePage_ModuleSelection, "Mouse over on Watch List Screening :");
		clickElement(driver, test, OCR_HomePage_ReturnModuleNrcLicense, "click on NRC License Module :");
	}

	// click on Add Applications
	public void click_AddApplication() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePage_AddApplication, "Click on Add Applications :");
	}

	// Click on New button
	public void clickNew() {
		clickElement(driver, test, OCR_HomePage_New, "Click on New button :");
	}
}
