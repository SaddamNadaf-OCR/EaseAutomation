package filesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class HomePage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	// --------------------------------------------Locators--------------------------------------//

	public static final String OCR_HomePage_SBU = "(//a[@class='nav-link dropdown-item'])[1]";
	public static final String OCR_HomePage_ModuleSelection = "(//a[@data-hover='dropdown'])[2]";
	public static final String OCR_HomePage_ModuleGExport = "(//a[contains(text(),'Export Operations')])[1]";
	public static final String OCR_HomePage_ModuleWLS = "(//a[contains(text(),'Watch List Screening')])[1]";
	public static final String OCR_HomePage_ModuleAM = "(//a[contains(text(),'Authorization Management')])[1]";
	public static final String OCR_HomePage_ModuleIM = "(//a[contains(text(),'Incident Management')])[1]";
	public static final String OCR_HomePage_ModuleLS = "(//a[contains(text(),'License Screening')])[1]";
	public static final String OCR_HomePage_ModuleIO2 = "(//a[contains(text(),'Import Operations')])[2]";
	public static final String OCR_HomePage_ModuleIO = "(//a[contains(text(),'Import Operations')])[1]";
	public static final String OCR_HomePage_ModuleFTZ2 = "(//a[contains(text(),'Foreign Trade Zone')])[2]";
	public static final String OCR_HomePage_ModuleFTZ = "(//a[contains(text(),'Foreign Trade Zone')])[1]";
	public static final String OCR_HomePage_FilesFTZ = "(//a[@class='nav-link dropdown-item'])[5]";
	public static final String OCR_HomePage_FilesWLS = "(//a[@class='nav-link dropdown-item'])[5]";
	public static final String OCR_HomePage_FilesAM = "(//a[@class='nav-link dropdown-item'])[5]";
	public static final String OCR_HomePage_FilesIO = "(//a[@class='nav-link dropdown-item'])[4]";
	public static final String OCR_HomePage_FilesCA = "(//a[@data-hover='dropdown'])[5]";
	public static final String OCR_HomePage_FilesEO = "(//a[@class='nav-link dropdown-item'])[4]";
	public static final String OCR_HomePage_FilesLS = "(//a[@class='nav-link dropdown-item'])[5]";
	public static final String OCR_HomePageGroundCarrier = "//a[contains(text(),'Ground Carrier')]";
	public static final String OCR_HomePageCharges = "//a[contains(text(),'Charges')]";
	public static final String OCR_HomePageContracts = "//a[contains(text(),'Contracts')]";
	public static final String OCR_HomePageBondedCarrierDetails = "//a[contains(text(),'Bonded Carrier Details')]";
	public static final String OCR_HomePageCorrectiveAction = "(//a[contains(text(),'Corrective Action')])[5]";
	public static final String OCR_HomePageDocumentType = "(//a[contains(text(),'Document Type')])[1]";
	public static final String OCR_HomePageOrderCategory = "//a[contains(text(),'Order Category')]";
	public static final String OCR_HomePageProductFamily = "//a[contains(text(),'Product Family')]";
	public static final String OCR_HomePageProductLines = "//a[contains(text(),'Product Lines')]";
	public static final String OCR_HomePageProgram = "//a[contains(text(),'Programs')]";
	public static final String OCR_HomePageRegion = "(//a[contains(text(),'Region')])[3]";
	public static final String OCR_HomePage_Segments = "//a[contains(text(),'Segments')]";
	public static final String OCR_HomePageRestrictedValues = "//a[contains(text(),'Restricted Values')]";
	public static final String OCR_HomePageSite = "(//a[contains(text(),'Site')])[1]";
	public static final String OCR_HomePageImporters = "//a[contains(text(),'Importers')]";
	public static final String OCR_HomePageTruckers = "(//a[contains(text(),'Truckers')])[4]";
	public static final String OCR_HomePageShipper = "(//a[contains(text(),'Shippers')])[4]";
	public static final String OCR_HomePageInstructionsAndStatements = "//a[contains(text(),'Instructions & Statements')]";
	public static final String OCR_HomePageSpecialInstructionNotes = "//a[contains(text(),'Special Instructions Notes')]";
	public static final String OCR_HomePageSystemGeneratedNumber = "(//a[contains(text(),'System Generated Numbers')])";
	public static final String OCR_HomePagepayment = "(//a[contains(text(),'Payment')])[1]";
	public static final String OCR_HomePagepriority = "(//a[contains(text(),'Priority')])[1]";
	public static final String OCR_HomePage_Report = "(//a[@class='nav-link dropdown-item'])[3]";
	public static final String OCR_HomePage_ProductReport = "//a[contains(text(),'Product Report')]";

	// ----------------------------------Constructor------------------------------------------//

	public HomePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	// Move to SBU Select and module selections Charges,Importer,Instructions & Statements
	public void moveTo_SBUSelectionIO(String SBU) {
		mouseOver(driver, test, OCR_HomePage_SBU, "On Mouse Click Select the SBU");
		clickElement(driver, test, OCR_HomePage_SBU, "clickingonSBU :" + SBU);
		Wait.waitfor(3);
		mouseOver(driver, test, OCR_HomePage_ModuleSelection, "Mouseover to Module Selection");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePage_ModuleIO, "Click on IO Module");
	}

	// Move to SBU Select and module selections Trucker,Shipper
	public void moveTo_SBUSelectionWLS(String SBU) {
		mouseOver(driver, test, OCR_HomePage_SBU, "On Mouse Click Select the SBU");
		clickElement(driver, test, OCR_HomePage_SBU, "clickingonSBU :" + SBU);
		Wait.waitfor(3);
		mouseOver(driver, test, OCR_HomePage_ModuleSelection, "Mouseover to Module Selection");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePage_ModuleWLS, "Click on WLS Module");
	}

	// Move to SBU Select and module selections Bonded Carrier details
	public void moveTo_SBUSelectionFTZ(String SBU) {
		mouseOver(driver, test, OCR_HomePage_SBU, "On Mouse Click Select the SBU");
		clickElement(driver, test, OCR_HomePage_SBU, "clickingonSBU :" + SBU);
		Wait.waitfor(3);
		mouseOver(driver, test, OCR_HomePage_ModuleSelection, "Mouseover to Module Selection");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePage_ModuleFTZ, "Click on FTZ Module");
	}

	// Move to SBU Select and module selections 'Contracts'
	public void moveTo_SBUSelectionAM(String SBU) {
		mouseOver(driver, test, OCR_HomePage_SBU, "On Mouse Click Select the SBU");
		clickElement(driver, test, OCR_HomePage_SBU, "clickingonSBU :" + SBU);
		Wait.waitfor(3);
		mouseOver(driver, test, OCR_HomePage_ModuleSelection, "Mouseover to Module Selection");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePage_ModuleAM, "Click on AM Module");
	}

	// Move to SBU Select and module selections Corrective Action
	public void moveTo_SBUSelectionIM(String SBU) {
		mouseOver(driver, test, OCR_HomePage_SBU, "On Mouse Click Select the SBU");
		clickElement(driver, test, OCR_HomePage_SBU, "clickingonSBU :" + SBU);
		Wait.waitfor(3);
		mouseOver(driver, test, OCR_HomePage_ModuleSelection, "Mouseover to Module Selection");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePage_ModuleIM, "Click on Incident Management Module");
	}

	// Move to SBU Select and module selections Document Type
	public void moveTo_SBUSelectionLS(String SBU) {
		mouseOver(driver, test, OCR_HomePage_SBU, "On Mouse Click Select the SBU");
		clickElement(driver, test, OCR_HomePage_SBU, "clickingonSBU :" + SBU);
		Wait.waitfor(3);
		mouseOver(driver, test, OCR_HomePage_ModuleSelection, "Mouseover to Module Selection");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePage_ModuleLS, "Click on License Screening Module");
	}

	// Move to SBU Select and module selections Ground Carrier,Priority
	public void moveTo_SBUSelectionEO(String SBU) {
		mouseOver(driver, test, OCR_HomePage_SBU, "On Mouse Click Select the SBU");
		clickElement(driver, test, OCR_HomePage_SBU, "clickingonSBU :" + SBU);
		Wait.waitfor(3);
		mouseOver(driver, test, OCR_HomePage_ModuleSelection, "Mouseover to Module Selection");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePage_ModuleGExport, "Click on Global Export Module");
	}

	// -------------------------------------------------------------------------------------------------------------------------//
	// ---Moves to Files---//

	// Click on Charges
	public void movetoCharges() {
		mouseOver(driver, test, OCR_HomePage_FilesIO, "Mouseover to Files");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePageCharges, "Click on Charges");
	}

	// Click on Bonded Carrier details
	public void movetoFiles() {
		mouseOver(driver, test, OCR_HomePage_FilesFTZ, "Mouseover to Files");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePageBondedCarrierDetails, "Click on Bonded Carrier Details");
	}

	public void movetoContracts() {
		mouseOver(driver, test, OCR_HomePage_FilesAM, "Mouseover to Files");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePageContracts, "Click on Contracts");
	}

	public void movetoCorrectiveAction() {
		mouseOver(driver, test, OCR_HomePage_FilesCA, "Mouseover to Files");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePageCorrectiveAction, "Click on CorrectiveAction");
	}

	public void movetoDocumentType() {
		mouseOver(driver, test, OCR_HomePage_FilesLS, "Mouseover to Files");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePageDocumentType, "Click on DocumentType");
	}

	public void movetoGroundCarrier() {
		mouseOver(driver, test, OCR_HomePage_FilesEO, "Mouseover to Files");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePageGroundCarrier, "Click on Ground Carrier");
	}

	public void movetoOrderCategory() {
		mouseOver(driver, test, OCR_HomePage_FilesEO, "Mouseover to Files");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePageOrderCategory, "Click on Order Category");
	}

	public void movetoProductFamily() {
		mouseOver(driver, test, OCR_HomePage_FilesEO, "Mouseover to Files");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePageProductFamily, "Click on Product Family");
	}

	public void movetoProductLines() {
		mouseOver(driver, test, OCR_HomePage_FilesEO, "Mouseover to Files");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePageProductLines, "Click on Product Line");
	}

	public void movetoProgram() {
		mouseOver(driver, test, OCR_HomePage_FilesEO, "Mouseover to Files");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePageProgram, "Click on Program");
	}

	public void movetoRegion() {
		mouseOver(driver, test, OCR_HomePage_FilesEO, "Mouseover to Files");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePageRegion, "Click on Region");
	}

	public void movetoSegment() {
		mouseOver(driver, test, OCR_HomePage_FilesEO, "Mouseover to Files");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePage_Segments, "Click on Segment");
	}

	public void movetoRestrictedValues() {
		mouseOver(driver, test, OCR_HomePage_FilesEO, "Mouseover to Files");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePageRestrictedValues, "Click on Restricted Values");
	}
	
	public void movetopriority() {
		mouseOver(driver, test, OCR_HomePage_FilesEO, "Mouseover to Files");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePagepriority, "Click on Priority");
	}

	public void movetoSite() {
		mouseOver(driver, test, OCR_HomePage_FilesIO, "Mouseover to Files");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePageSite, "Click on Site");
	}

	public void movetoImporters() {
		mouseOver(driver, test, OCR_HomePage_FilesIO, "Mouseover to Files");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePageImporters, "Click on Importers");
	}
	
	public void movetoTruckers() {
		mouseOver(driver, test, OCR_HomePage_FilesWLS, "Mouseover to Files");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePageTruckers, "Click on Truckers");
	}
	
	public void movetoShippers() {
		mouseOver(driver, test, OCR_HomePage_FilesWLS, "Mouseover to Files");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePageShipper, "Click on Product");
	}

	public void movetoInstructionsAndStatements() {
		mouseOver(driver, test, OCR_HomePage_FilesIO, "Mouseover to Files");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePageInstructionsAndStatements, "Click on Instructions & Statements");
	}

	public void movetoSpecialInstructionNotes() {
		mouseOver(driver, test, OCR_HomePage_FilesIO, "Mouseover to Files");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePageSpecialInstructionNotes, "Click on Special Instruction Notes");
	}

	public void movetoSystemGeneratedNumber() {
		mouseOver(driver, test, OCR_HomePage_FilesIO, "Mouseover to Files");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePageSystemGeneratedNumber, "Click on System Generated Numbers");
	}
	
	public void movetoPayment() {
		mouseOver(driver, test, OCR_HomePage_FilesIO, "Mouseover to Files");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePagepayment, "Click on Payment");
	}

	// --------------------------------------------------HomePage--------------------------------------------------------------------//
	public void returnToFTZHomePage() {
		mouseOver(driver, test, OCR_HomePage_ModuleSelection, "Mouseover to module selection");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePage_ModuleFTZ2, "Click on FTZ module");
	}

	public void returnToIOHomePage() {
		mouseOver(driver, test, OCR_HomePage_ModuleSelection, "Mouseover to module selection");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, OCR_HomePage_ModuleIO2, "Click on IO module");
	}

	public void returnToAMHomePage() {
		mouseOver(driver, test, OCR_HomePage_ModuleSelection, "Mouseover to module selection");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, "(//a[contains(text(),'Authorization Management')])[2]", "Click on AM module");
	}

	public void returnToIMHomePage() {
		mouseOver(driver, test, OCR_HomePage_ModuleSelection, "Mouseover to module selection");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, "(//a[contains(text(),'Incident Management')])[2]", "Click on IM module");
	}

	public void returnToLSHomePage() {
		mouseOver(driver, test, OCR_HomePage_ModuleSelection, "Mouseover to module selection");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, "(//a[contains(text(),'License Screening')])[2]", "Click on LS module");
	}

	public void returnToGExportHomePage() {
		mouseOver(driver, test, OCR_HomePage_ModuleSelection, "Mouseover to module selection");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, "(//a[contains(text(),'Export Operations')])[2]", "Click on EO module");
	}
	
	public void returnToWLSHomePage() {
		mouseOver(driver, test, OCR_HomePage_ModuleSelection, "Mouseover to module selection");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, "(//a[contains(text(),'Watch List Screening')])[2]", "Click on WLS module");
	}
	//-----------------------------------------------------------------------------------------------------------------//

	// Click on Reports
	public void movetoReports() {
		mouseOver(driver, test, OCR_HomePage_Report, "Mouseover to Report");
		clickElement(driver, test, OCR_HomePage_ProductReport, "Click on Product Report: ");
		Wait.waitfor(3);
		clickElement(driver, test, "//label[contains(text(),'Description')]", "Click on label Description: ");
	}

	public void returnToProductReportPage() {
		mouseOver(driver, test, OCR_HomePage_Report, "Mouseover to Report");
		clickElement(driver, test, OCR_HomePage_ProductReport, "Click on Product Report: ");
	}

}
