package crsClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;
import utilities.Wait;

public class HomePageCRs extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_HomePage_ListScreening = "//ul[@class='nav navbar-nav']/li[2]/a";
	public static final String OCR_HomePage_ComplianceRequest = "//a[contains(text(),'Compliance Request')]";
	public static final String OCR_HomePage_ComplianceRequest2 = "(//a[contains(text(),'Compliance Request')])[2]";
	public static final String OCR_HomePage_CRSFeature = "//ul[@class='nav navbar-nav']/li[3]/a";
	public static final String OCR_HomePage_AgreementRequest ="//ul[@class='dropdown-menu menu-width navList']//li[@class='dropdown']//div[@class='slidingDiv']//ul//li//a[contains(text(),'Agreement Request')]";
	public static final String OCR_HomePage_Request ="//i[@class='fa fa-plus-square']";
	public static final String OCR_HomePage_DOSLicensing ="//a[contains(text(),'DOS Licensing')]";
	public static final String OCR_HomePage_Request_PlusIcon ="(//i[@class='fa fa-plus-square'])[1]";
	public static final String OCR_HomePage_ModuleCRS = "(//a[contains(text(),'Compliance Request')])[2]";
	public static final String OCR_HomePage_WorkQueue = "(//i[@class='fa fa-plus-square'])[2]";
	public static final String OCR_HomePage_AgreementWorkQueue = "//a[contains(text(),'Agreement Work Queue')]";
	public static final String OCR_HomePage_ExportWorkQueue = "//a[contains(text(),'Export Work Queue')]";
	public static final String OCR_HomePage_ForeignTravelWorkQueue = "//a[contains(text(),'Foreign Travel Work Queue')]";
	public static final String OCR_HomePage_ImportWorkQueue = "//a[contains(text(),'Import Work Queue')]";
	public static final String OCR_HomePage_Reports = "//ul[@class='nav navbar-nav']/li[4]/a";
	public static final String OCR_HomePage_ComplianceRequestStatusMetrics = "//a[contains(text(),'Compliance Request Status Metrics')]";
	public static final String OCR_HomePage_ExportAuditRequest = "//a[contains(text(),'Export Audit Request')]";
	public static final String OCR_HomePage_ExportRequestDetailsReport = "//a[contains(text(),'Export Request Details Report')]";
	public static final String OCR_HomePage_ExportRequestReferenceReport = "//a[contains(text(),'Export Request Reference Report')]";
	public static final String OCR_HomePage_ExportRequestSummaryReport = "//a[contains(text(),'Export Request Summary Report')]";
	public static final String OCR_HomePage_ForeignTravelReports = "//a[contains(text(),'Foreign Travel Reports')]";
	public static final String OCR_HomePage_CompletedForeignTravelRequests = "//a[contains(text(),'Completed Foreign Travel Requests')]";
	public static final String OCR_HomePage_ForeignTravelAuditReport = "//a[contains(text(),'Foreign Travel Audit Report')]";
	public static final String OCR_HomePage_ForeignTravelSummaryReport = "//a[contains(text(),'Foreign Travel Summary Report')]";
	public static final String OCR_HomePage_OpenForeignTravelRequests = "//a[contains(text(),'Open Foreign Travel Requests')]";
	public static final String OCR_HomePage_TravelDebriefDelinquencyReport = "//a[contains(text(),'Travel Debrief Delinquency Report')]";
	public static final String OCR_HomePage_ProductReport = "//a[contains(text(),'Product Report')]";
	public static final String OCR_HomePage_WebServiceAuditReport = "//a[contains(text(),'Web Service Audit Report')]";
	public static final String OCR_HomePage_Files = "(//li[@class='nav-item dropdown'])[5]";
	public static final String OCR_HomePage_Templates = "//a[contains(text(),'Templates')]";
	public static final String OCR_HomePage_AgreementReq_Template = "(//a[contains(text(),'Agreement Request')])[2]";
	public static final String OCR_HomePage_ExportAuthReq_Template = "(//a[contains(text(),'Export Authorization Request')])[2]";
	public static final String OCR_HomePage_ForeignTravelReq_Template = "(//a[contains(text(),'Foreign Travel Request')])[4]";
	public static final String OCR_HomePage_ImportReq_Template = "(//a[contains(text(),'Import Request')])[2]";
	
	/* ******************** Constructor ***************************** */

	public HomePageCRs(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	// Move to list screening
	public void moveTo_ListScreening() {
		Wait.waitfor(3);
		mouseOver(driver, test, OCR_HomePage_ListScreening, "Mouse over on Watch List Screening");

	}

	// Click on Compliance Request
	public void click_ComplianceRequest() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePage_ComplianceRequest, "Clicking on Compliance Request");
	}

	public void moveto_AgreementRequest() {
		mouseOver(driver, test, OCR_HomePage_ListScreening, "Mouseover to Module Selection");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePage_ComplianceRequest, "Click on CRS Module");
		Wait.waitfor(3);
		mouseOver(driver, test, OCR_HomePage_CRSFeature, "Mouseover to CRS Feature");
		Wait.waitfor(3);
		try {
			clickElement(driver, test, OCR_HomePage_Request, "Click on Request");
			Wait.waitfor(7);
			clickElement(driver, test, OCR_HomePage_AgreementRequest, "Click on Agreement Request");
		} catch (Exception e) {
			Wait.waitfor(7);
			clickElement(driver, test, OCR_HomePage_AgreementRequest, "Click on Agreement Request");
		}
	}

	public void moveto_AgrReq() {
		mouseOver(driver, test, OCR_HomePage_ListScreening, "Mouseover to Module Selection");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePage_ComplianceRequest, "Click on CRS Module :");
		Wait.waitfor(3);
		mouseOver(driver, test, OCR_HomePage_CRSFeature, "Mouseover to CRS Feature");
		clickElement(driver, test, OCR_HomePage_AgreementRequest, "Click on Agreement Request :");
		Wait.waitfor(3);
	}

	// Return to Compliance Request Page
	public void returnToCRPage() {
		Wait.waitfor(3);
		mouseOver(driver, test, OCR_HomePage_ListScreening, "Mouseover to Module Selection :");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePage_ModuleCRS, "Click on Compliance Request :");	
	}

	public void click_DOSLicensing() {
		Wait.waitfor(2);
		clickElement(driver, test, OCR_HomePage_DOSLicensing, "Clicking on DOS Licensing Page :");
	}

	public void moveto_Agreement() {
		mouseOver(driver, test, OCR_HomePage_ListScreening, "Mouseover to Module Selection :");
		clickElement(driver, test, OCR_HomePage_DOSLicensing, "Clicking on DOS Licensing Page :");
		mouseOver(driver, test, OCR_HomePage_CRSFeature, "Mouseover to CRS Feature :");
		clickElement(driver, test, OCR_HomePage_Request, "Click on Request :");
		clickElement(driver, test, OCR_HomePage_AgreementRequest, "Click on Agreement Request :");
	}
	
	//...................Clicking on Agreement Work Queue.............................//
	public void agreementWorkQueue() {
		mouseOver(driver, test, OCR_HomePage_ListScreening, "Mouseover to Module Selection");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePage_ComplianceRequest, "Click on CRS Module");
		Wait.waitfor(3);
		mouseOver(driver, test, OCR_HomePage_CRSFeature, "Mouseover to CRS Feature");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, OCR_HomePage_WorkQueue, "Clicking on Work Queue :");
		Wait.waitfor(2);
		mouseOverAndClick(driver, test, OCR_HomePage_AgreementWorkQueue, "Clicking on Agreement Work Queue :");
	}
	
	//...................Clicking on Export Work Queue.............................//
	public void exportWorkQueue() {
		mouseOver(driver, test, OCR_HomePage_ListScreening, "Mouseover to Module Selection");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePage_ComplianceRequest, "Click on CRS Module");
		Wait.waitfor(3);
		mouseOver(driver, test, OCR_HomePage_CRSFeature, "Mouseover to CRS Feature");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, OCR_HomePage_WorkQueue, "Clicking on Work Queue :");
		Wait.waitfor(2);
		mouseOverAndClick(driver, test, OCR_HomePage_ExportWorkQueue, "Clicking on Export Work Queue :");
	}
	
	//...................Clicking on Foreign Travel Work Queue.............................//
	public void foreignTravelWorkQueue() {
		mouseOver(driver, test, OCR_HomePage_ListScreening, "Mouseover to Module Selection");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePage_ComplianceRequest, "Click on CRS Module");
		Wait.waitfor(3);
		mouseOver(driver, test, OCR_HomePage_CRSFeature, "Mouseover to CRS Feature");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, OCR_HomePage_WorkQueue, "Clicking on Work Queue :");
		Wait.waitfor(2);
		mouseOverAndClick(driver, test, OCR_HomePage_ForeignTravelWorkQueue, "Clicking on Foreign Travel Work Queue :");
	}
	
	//...................Clicking on Foreign Travel Work Queue.............................//
	public void importWorkQueue() {
		mouseOver(driver, test, OCR_HomePage_ListScreening, "Mouseover to Module Selection");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePage_ComplianceRequest, "Click on CRS Module");
		Wait.waitfor(3);
		mouseOver(driver, test, OCR_HomePage_CRSFeature, "Mouseover to CRS Feature");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, OCR_HomePage_WorkQueue, "Clicking on Work Queue :");
		Wait.waitfor(2);
		mouseOverAndClick(driver, test, OCR_HomePage_ImportWorkQueue, "Clicking on Import Work Queue :");
	}
	
	//...................Clicking on Compliance Request Status metrics...........................//
	public void complianceRequestStatusmetrics() {
		mouseOverAndClick(driver, test, OCR_HomePage_Reports, "Clicking on Reports :");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, OCR_HomePage_ComplianceRequestStatusMetrics, "Clicking on Compliance Request Status Metrics :");
	}
	
	//...............................Clicking on Export Audit Request...........................//
	public void exportAuditRequest() {
		mouseOverAndClick(driver, test, OCR_HomePage_Reports, "Clicking on Reports :");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, OCR_HomePage_ExportAuditRequest, "Clicking on Export Audit Request :");
	}
	
	//............................Clicking on Export Request Details Report...........................//
	public void exportRequestDetailsReport() {
		mouseOverAndClick(driver, test, OCR_HomePage_Reports, "Clicking on Reports :");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, OCR_HomePage_ExportRequestDetailsReport, "Clicking on Export Request Details Report :");
	}
	
	//...............................Clicking on Export Request Reference Report...........................//
	public void exportRequestReferenceReport() {
		mouseOverAndClick(driver, test, OCR_HomePage_Reports, "Clicking on Reports :");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, OCR_HomePage_ExportRequestReferenceReport, "Clicking on Export Request Reference Report :");
	}
	
	//...............................Clicking on Export Request Summary Report...........................//
	public void exportRequestSummaryReport() {
		mouseOverAndClick(driver, test, OCR_HomePage_Reports, "Clicking on Reports :");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, OCR_HomePage_ExportRequestSummaryReport, "Clicking on Export Request Summary Report :");
	}
	
	//...............................Clicking on Completed Foreign Travel Requests...........................//
	public void completedForeignTravelRequests() {
		mouseOverAndClick(driver, test, OCR_HomePage_Reports, "Clicking on Reports :");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, OCR_HomePage_ForeignTravelReports, "Clicking on Foreign Travel Reports :");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, OCR_HomePage_CompletedForeignTravelRequests, "Clicking on Completed Foreign Travel Requests :");
	}
	
	//...............................Clicking on Foreign Travel Audit Report...........................//
	public void foreignTravelAuditReport() {
		mouseOverAndClick(driver, test, OCR_HomePage_Reports, "Clicking on Reports :");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, OCR_HomePage_ForeignTravelReports, "Clicking on Foreign Travel Reports :");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, OCR_HomePage_ForeignTravelAuditReport, "Clicking on Foreign Travel Audit Report :");
	}
	
	//...............................Clicking on Foreign Travel Summary Report...........................//
	public void foreignTravelSummaryReport() {
		mouseOverAndClick(driver, test, OCR_HomePage_Reports, "Clicking on Reports :");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, OCR_HomePage_ForeignTravelReports, "Clicking on Foreign Travel Reports :");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, OCR_HomePage_ForeignTravelSummaryReport, "Clicking on Foreign Travel Summary Report :");
	}
	
	//...............................Clicking on Open Foreign Travel Requests...........................//
	public void openForeignTravelRequests() {
		mouseOverAndClick(driver, test, OCR_HomePage_Reports, "Clicking on Reports :");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, OCR_HomePage_ForeignTravelReports, "Clicking on Foreign Travel Reports :");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, OCR_HomePage_OpenForeignTravelRequests, "Clicking on Open Foreign Travel Requests :");
	}
	
	//...............................Clicking on Travel Debrief Delinquency Report...........................//
	public void travelDebriefDelinquencyReport() {
		mouseOverAndClick(driver, test, OCR_HomePage_Reports, "Clicking on Reports :");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, OCR_HomePage_ForeignTravelReports, "Clicking on Foreign Travel Reports :");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, OCR_HomePage_TravelDebriefDelinquencyReport, "Clicking on Travel Debrief Delinquency Report :");
	}
	
	//...............................Clicking on Product Report...........................//
	public void productReport() {
		mouseOverAndClick(driver, test, OCR_HomePage_Reports, "Clicking on Reports :");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, OCR_HomePage_ProductReport, "Clicking on Product Report :");
	}
	
	//...............................Clicking on Web Service Audit Report...........................//
	public void webServiceAuditReport() {
		mouseOverAndClick(driver, test, OCR_HomePage_Reports, "Clicking on Reports :");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, OCR_HomePage_WebServiceAuditReport, "Clicking on Web Service Audit Report :");
	}
	
	//...............................Clicking on Agreement Request Template............................//
	public void AgrReqTemplate() {
		mouseOver(driver, test, OCR_HomePage_ListScreening, "Mouseover to Module Selection");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePage_ComplianceRequest, "Click on CRS Module :");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, OCR_HomePage_Files, "Mouseover to CRS Files :");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePage_Templates, "Click on Templates :");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePage_AgreementReq_Template, "Clickng on Agreement Request Templates :");
	}
	
	//...............................Clicking on Export Authorization Request Template............................//
	public void ExportReqTemplate() {
		mouseOver(driver, test, OCR_HomePage_ListScreening, "Mouseover to Module Selection");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePage_ComplianceRequest, "Click on CRS Module :");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, OCR_HomePage_Files, "Mouseover to CRS Files :");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePage_Templates, "Click on Templates :");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePage_ExportAuthReq_Template, "Clickng on Export Authorization Request Templates :");
	}
	
	//...............................Clicking on Foreign Travel Request Template............................//
	public void FTRReqTemplate() {
		mouseOver(driver, test, OCR_HomePage_ListScreening, "Mouseover to Module Selection");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePage_ComplianceRequest, "Click on CRS Module :");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, OCR_HomePage_Files, "Mouseover to CRS Files :");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePage_Templates, "Click on Templates :");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePage_ForeignTravelReq_Template, "Clickng on Foreign Travel Request Templates :");
	}
	
	//...............................Clicking on Import Request Template............................//
	public void ImportReqTemplate() {
		mouseOver(driver, test, OCR_HomePage_ListScreening, "Mouseover to Module Selection");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePage_ComplianceRequest, "Click on CRS Module :");
		Wait.waitfor(3);
		mouseOverAndClick(driver, test, OCR_HomePage_Files, "Mouseover to CRS Files :");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePage_Templates, "Click on Templates :");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_HomePage_ImportReq_Template, "Clickng on Import Request Templates :");
	}
}
