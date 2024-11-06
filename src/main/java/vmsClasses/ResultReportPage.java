package vmsClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;


public class ResultReportPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

public static final String OCR_SVAR_TitleofReport ="//h3[contains(text(),'Visitor Request AdHoc Report')]";
public static final String OCR_DebrifIncident_TitleofReport ="//h3[contains(text(),'Debrief Incidents Report')]";
public static final String OCR_MetrixVisitor_SummaryReportByCountryofCitizenship_TitleofReport ="//h3[contains(text(),'Visitor Summary Report By Country of Citizenship')]";
public static final String OCR_MetrixVisitor_SummaryReportBySite_TitleofReport ="//h3[contains(text(),'Visitor Summary Report By Site')]";
public static final String OCR_MetrixVisitor_SummaryReportBySegment_TitleofReport ="//h3[contains(text(),'Visitor Summary Report By Segment')]";
public static final String OCR_MetrixVisitor_VisitorSummaryReportByCountryOfIncorporation_TitleofReport ="//h3[contains(text(),'Visitor Summary Report By Country Of Incorporation')]";
public static final String OCR_MetrixVisitor_VisitorSummaryReportByCountryRepresented_TitleofReport ="//h3[contains(text(),'Visitor Summary Report By Representing Country')]";
public static final String OCR_DebriefPending_TitleofReport ="//h3[contains(text(),'Debrief Pending Report')]";
public static final String OCR_StatusChangeAudit_TitleofReport = "//h3[contains(text(),'Status Changed Audit Report')]";
public static final String OCR_VisitoSummaryReport_TitleofReport ="//h3[contains(text(),'Visitor Request Summary Report')]";
public static final String OCR_VisitorComprehensiveReport_TitleofReport ="//h3[contains(text(),'Visitor Comprehensive Report')]";
public static final String OCR_VisitorsDiscrepancyReport_TitleofReport ="//h3[contains(text(),'Result Visitors Discrepancy Report')]";
public static final String OCR_VisitorsLogReport_TitleofReport ="//h3[contains(text(),'Visitor Log Report')]";
public static final String OCR_VisitorsRegistrationReport_TitleofReport = "//h3[contains(text(),'Visitor Registration Report')]";
public static final String OCR_MatrixReportbyprogram_TitleofReport ="//h3[contains(text(),'Visitor Summary Report By Program')]";
public static final String OCR_MatrixReportExportAuthority_TitleofReport="//h3[contains(text(),'Visitor Summary Report By License No:')]";
/* ******************** Constructor ***************************** */

public ResultReportPage(WebDriver driver, ExtentTest test) {
	this.driver = driver;
	this.test = test;
	
}
public void titleIsDisplayedVisitorRegistration() {
	try {
		if(isDisplayed(driver, OCR_VisitorsRegistrationReport_TitleofReport)) {
			test.log(LogStatus.PASS, "Title is Displayed : Result visitor Registration Report");
		}
	} catch (Exception e) {
		testFailSshot(driver, test);
		test.log(LogStatus.FAIL, "Title is not Displayed : Result visitor Registration Report");
	}
}
public void titleIsDisplayedVisitorLog() {
	try {
		if(isDisplayed(driver, OCR_VisitorsLogReport_TitleofReport)) {
			test.log(LogStatus.PASS, "Title is Displayed : Result Visitor Log Report");
		}
	} catch (Exception e) {
		testFailSshot(driver, test);
		test.log(LogStatus.FAIL, "Title is not Displayed : Result Visitor Log Report");
	}
}
	
public void titleIsDisplayedVisitorDiscrepancy() {
	try {
		if(isDisplayed(driver, OCR_VisitorsDiscrepancyReport_TitleofReport)) {
			test.log(LogStatus.PASS, "Title is Displayed : Result Visitors Discrepancy Report");
		}
	} catch (Exception e) {
		testFailSshot(driver, test);
		test.log(LogStatus.FAIL, "Title is not Displayed : Result Visitors Discrepancy Report");
	}
}
	public void titleIsDisplayedVisitorComprehensive() {
	try {
		if(isDisplayed(driver, OCR_VisitorComprehensiveReport_TitleofReport)) {
			test.log(LogStatus.PASS, "Title is Displayed : Results  Visitor Comprehensive Report");
		}
	} catch (Exception e) {
		testFailSshot(driver, test);
		test.log(LogStatus.FAIL, "Title is not Displayed : Results Visitor Comprehensive Report");
	}
}

public void titleIsDisplayedVisitorSummary() {
	try {
		if(isDisplayed(driver, OCR_VisitoSummaryReport_TitleofReport)) {
			test.log(LogStatus.PASS, "Title is Displayed : Results  Visitor Request Summary Report");
		}
	} catch (Exception e) {
		testFailSshot(driver, test);
		test.log(LogStatus.FAIL, "Title is not Displayed : Results Visitor Request Summary Report");
	}
}


public void titleIsDisplayedStatusChangedAudit() {
	try {
		if(isDisplayed(driver, OCR_StatusChangeAudit_TitleofReport)) {
			test.log(LogStatus.PASS, "Title is Displayed : Results  Status Changed Audit Report");
		}
	} catch (Exception e) {
		testFailSshot(driver, test);
		test.log(LogStatus.FAIL, "Title is not Displayed : Results Status Changed Audit Report");
	}
}

public void titleIsDisplayedDebriefPending() {
	try {
		if(isDisplayed(driver, OCR_DebriefPending_TitleofReport)) {
			test.log(LogStatus.PASS, "Title is Displayed : Results Debrief Pending");
		}
	} catch (Exception e) {
		testFailSshot(driver, test);
		test.log(LogStatus.FAIL, "Title is not Displayed : Results Debrief Pending Reports");
	}
} 
public void titleIsDisplayedByCountryOfIncorporation() {
	try {
		if(isDisplayed(driver, OCR_MetrixVisitor_VisitorSummaryReportByCountryOfIncorporation_TitleofReport)) {
			test.log(LogStatus.PASS, "Title is Displayed : Visitor Summary Report By Country Of Incorporation");
		}
	} catch (Exception e) {
		testFailSshot(driver, test);
		test.log(LogStatus.FAIL, "Title is not Displayed : Visitor Summary Report By Country Of Incorporation");
	}
} 
	public void titleIsDisplayedAR() {
		try {
			if(isDisplayed(driver, OCR_SVAR_TitleofReport)) {
				test.log(LogStatus.PASS, "Title is Displayed : Results Adhoc Reports");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Title is not Displayed : Results Adhoc Reports");
		}
	} 
	
	public void titleIsDisplayedMatrixbyProgram() {
		try {
			if(isDisplayed(driver, OCR_MatrixReportbyprogram_TitleofReport)) {
				test.log(LogStatus.PASS, "Title is Displayed : Results Matrix Reports by Program");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Title is not Displayed : Results Matrix Reports By Program");
		}
	} 
	
	public void titleIsDisplayedMatrixbyExportAuthority() {
		try {
			Wait.fluwait(driver, OCR_MatrixReportExportAuthority_TitleofReport);
			if(isDisplayed(driver, OCR_MatrixReportExportAuthority_TitleofReport)) {
				test.log(LogStatus.PASS, "Title is Displayed : Results Matrix Reports by Export Authority");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Title is not Displayed : Results Matrix Reports By Export Authority");
		}
	} 
	
	public void titleIsDisplayedDR() {
		try {
			if(isDisplayed(driver, OCR_DebrifIncident_TitleofReport)) {
				test.log(LogStatus.PASS, "Title is Displayed : Results Debrief Reports");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Title is not Displayed : Results Debrief Reports");
		}
	} 
	
	public void titleIsDisplayedByCitizenship() {
		try {
			if(isDisplayed(driver, OCR_MetrixVisitor_SummaryReportByCountryofCitizenship_TitleofReport)) {
				test.log(LogStatus.PASS, "Title is Displayed : Results Metrix By Citizenship");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Title is not Displayed : Results Metrix By Citizenship");
		}
	} 
	
	public void titleIsDisplayedBySite() {
		try {
			if(isDisplayed(driver, OCR_MetrixVisitor_SummaryReportBySite_TitleofReport)) {
				test.log(LogStatus.PASS, "Title is Displayed : Results Metrix By Site");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Title is not Displayed : Results Metrix By Site");
		}
	} 
	
	public void titleIsDisplayedBySegment() {
		try {
			if(isDisplayed(driver, OCR_MetrixVisitor_SummaryReportBySegment_TitleofReport)) {
				test.log(LogStatus.PASS, "Title is Displayed : Results Metrix By Segment");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Title is not Displayed : Results Metrix By Segment");
		}
	}
public void titleIsDisplayedByCountryRepresented() {
	try {
		if(isDisplayed(driver, OCR_MetrixVisitor_VisitorSummaryReportByCountryRepresented_TitleofReport)) {
			test.log(LogStatus.PASS, "Title is Displayed : Visitor Summary Report By Country Represented");
		}
	} catch (Exception e) {
		testFailSshot(driver, test);
		test.log(LogStatus.FAIL, "Title is not Displayed : Visitor Summary Report By Country Represented");
	}
} 
}
