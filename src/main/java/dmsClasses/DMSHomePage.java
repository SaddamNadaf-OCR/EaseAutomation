package dmsClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;
import utilities.Wait;

public class DMSHomePage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_DMSFormConfig = "//a[contains(text(),'DMS Forms Configuration')]";
	public static final String OCR_HomePage_ListScreening = "//ul[@class='nav navbar-nav']/li[2]/a";
	public static final String OCR_DocAccessConfig = "//a[contains(text(),'Document Access Configuration')]";
	public static final String OCR_ControlAttributes = "//a[contains(text(),'Control Attributes')]";
	public static final String OCR_ContAttribDetails = "//a[contains(text(),'Control Attributes Detail')]";
	public static final String OCR_DocTypContAttribDet = "//a[contains(text(),'Document Type Control Attributes Detail')]";
	public static final String OCR_UserContAttribDet = "//a[contains(text(),'User Control Attributes Detail')]";
	public static final String OCR_DocServerConfig = "//a[contains(text(),'Document Server Configuration')]";
	public static final String OCR_DocServerAcessConfig = "//a[contains(text(),'Document Server Access Configuration')]";
	public static final String OCR_HomePage_SBU = "//a[@class='dropdown-toggle']";
	public static final String OCR_HomePage_ModuleSelection = "(//a[@class='dropdown-toggle'])[2]";
	public static final String OCR_HomePage_ModuleGExport = "//a[contains(text(),'Export Operations')]";
	public static final String OCR_HomePage_ModuleExport = "(//a[contains(text(),'Export Operations')])[2]";
	public static final String OCR_HomePage_ModuleCRS = "//ul[@class='dropdown-menu']//a[contains(text(),'Compliance Request')]";
	public static final String OCR_EaseDMS = "//a[contains(text(),'EASE DMS')]";

	/* ******************************* Constructor ****************************** */

	public DMSHomePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	// Move to list screening
	public void moveTo_ListScreening() {
		mouseOver(driver, test, OCR_HomePage_ListScreening, "Mouse over on Watch List Screening");
	}

	// Move to SBU Select and module selections
	public void moveTo_SBUSelection(String SBU) {
		mouseOver(driver, test, OCR_HomePage_SBU, "On Mouse Click Select the SBU");
		clickElement(driver, test, "//label[contains(text(),'" + SBU + "')]", "Click on SBU : " + SBU);
		mouseOver(driver, test, OCR_HomePage_ModuleSelection, "Mouseover to Module Selection");
		clickElement(driver, test, OCR_HomePage_ModuleGExport, "Click on Global Export Module");
	}

	// Move to Tools
	public void movetoTools() {
		mouseOver(driver, test, "//i[@class='fa fa-wrench']", "Mouse Hover to Tools ");
	}

	// Move to DMS Form Configuration
	public void movetodmsconfig() {
		clickElement(driver, test, OCR_DMSFormConfig, "Clicking on DMS Form Configuration");
	}

	// Clicking on Document Access Configuration
	public void movetoDocAccessConfig() {
		mouseOverAndClick(driver, test, OCR_DocAccessConfig, "Clicking on Document Access Configuration");
		Wait.waitfor(3);
	}

	// Clicking on Doc Server Access Configuration
	public void click_OCR_DocServerAcessConfig() {
		clickElement(driver, test, OCR_DocServerAcessConfig, "Clicking on Document Server  Acess Configuration: ");
	}

	// Clicking on Control Attributes
	public void movetocontrolattrib() {
		movetoDocAccessConfig();
		clickElement(driver, test, OCR_ControlAttributes, "Click on Control Attributes");
		clickElement(driver, test, "//label[contains(text(),'Control Attributes Code')]", "Click outside Tools");

	}

	// Clicking on Control Attributes Detail
	public void movetocontrolattribdetails() {
		movetoDocAccessConfig();
		clickElement(driver, test, OCR_ContAttribDetails, "Click on Control Attributes Details");
		clickElement(driver, test, "//label[contains(text(),'Control Attributes')]", "Click outside Tools");

	}

	// Clicking on Document type control attributes
	public void movetodoctypctrlattrib() {
		movetoDocAccessConfig();
		clickElement(driver, test, OCR_DocTypContAttribDet, "Click on Document Type Control Attributes ");
		clickElement(driver, test, "//label[contains(text(),'Control Attributes')]", "Click outside Tools");
	}

	// Clicking on User control Attributes
	public void movetouserctrlaccattrib() {
		movetoDocAccessConfig();
		clickElement(driver, test, OCR_UserContAttribDet, "Click on User Control Acess Attributes ");
		clickElement(driver, test, "//label[contains(text(),'Control Attributes')]", "Click outside Tools");
	}

	// Clicking on Doc Server Configuration
	public void movetodocserverconfig() {
		movetoDocAccessConfig();
		clickElement(driver, test, OCR_DocServerConfig, "Click on Document Server Configuration ");
		clickElement(driver, test, "//div[@class='form-content']", "Click outside Tools");
	}

	// Clicking on Doc Server Access Configuration
	public void movetodocserveraccconfig() {
		movetoDocAccessConfig();
		clickElement(driver, test, OCR_DocServerAcessConfig, "Click on Document Server Acess Configuration ");
		clickElement(driver, test, "//div[@class='form-content']", "Click outside Tools");
	}

	public void return_ExportHome() {
		mouseOver(driver, test, OCR_HomePage_ModuleSelection, "Mouseover to Module Selection");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePage_ModuleExport, "Click on Export Operation");
	}

	// Move to SBU Select and module selections
	public void moveTo_CRS(String SBU) {
		mouseOver(driver, test, OCR_HomePage_SBU, "On Mouse Click Select the SBU");
		clickElement(driver, test, "//label[contains(text(),'" + SBU + "')]", "Click on SBU : " + SBU);
		mouseOver(driver, test, OCR_HomePage_ModuleSelection, "Mouseover to Module Selection");
		clickElement(driver, test, OCR_HomePage_ModuleCRS, "Click on Compliance Request Module");
	}

	// Clicking on Doc Server Access Configuration
	public void moveto_EaseDMS() {
		clickElement(driver, test, OCR_EaseDMS, " Clicking on Ease DMS");
	}

}
