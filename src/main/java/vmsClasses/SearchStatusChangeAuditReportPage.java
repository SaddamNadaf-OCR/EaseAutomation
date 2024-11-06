package vmsClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class SearchStatusChangeAuditReportPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;
	// ------------------------------Locators------------------------------------

	public static final String OCR_StatusChangeAudit_Search = "//button[contains(text(),'Search')]";
	public static final String OCR_StatusChangeAudit_Reset = "//button[contains(text(),'Reset')]";
	public static final String OCR_StatusChangeAudit_SBUcode = "//select[@id='sbuCode']";
	public static final String OCR_StatusChangeAudit_VisitorRequestId = "//input[@id='resultAuditStatusChangeVrsReport_visitorGeneralInfoValue_visitorId']";

	public static final String OCR_StatusChangeAudit_VisitorCategory = "//select[@id='resultAuditStatusChangeVrsReport_visitCategory']";
	public static final String OCR_StatusChangeAudit_MeetingCategory = "";
	public static final String OCR_StatusChangeAudit_Programs = "//textarea[@id='resultAuditStatusChangeVrsReport_visitorGeneralInfoValue_program']";
	public static final String OCR_StatusChangeAudit_TDYSegment = "//textarea[@id='resultAuditStatusChangeVrsReport_visitorGeneralInfoValue_segment']";
	public static final String OCR_StatusChangeAudit_ProductFamily = "//textarea[@id='resultAuditStatusChangeVrsReport_visitorGeneralInfoValue_productFamily']";
	public static final String OCR_StatusChangeAudit_ProductLine = "//textarea[@id='resultAuditStatusChangeVrsReport_visitorGeneralInfoValue_productLine']";
	public static final String OCR_StatusChangeAudit_Sites = "//div[@class='ms-trigger'][1])";
	public static final String OCR_StatusChangeAudit_SortBy = "//select[@name='sortBy']";
	public static final String OCR_StatusChangeAudit_Direction = "//select[@name='direction']";
	public static final String OCR_StatusChangeAudit_SiteTextBox = "//input[@xpath='1']";
	public static final String OCR_StatusChangeAudit_TitleofReport = "//h3[contains(text(),'Status Changed Audit Report')]";

	/* ******************** Constructor ***************************** */

	public SearchStatusChangeAuditReportPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

	}
	/* ******************** Actions ********************************* */

	public void clickSearchbutton() {
		scrollToElement(driver, OCR_StatusChangeAudit_Search);
		clickElement(driver, test, OCR_StatusChangeAudit_Search, "Click on search button");
	}

	public void clickResetButton() {
		clickElement(driver, test, OCR_StatusChangeAudit_Reset, "Click on reset button");
	}

	public void searchParameters(String SBUCode, String VisitorCategory, String RequestID, String site, String SortBy,
			String Direction)

	{
		selectByVisibleText(driver, test, OCR_StatusChangeAudit_SBUcode, "Select SBU code", SBUCode);
		Wait.waitfor(4);
		selectByVisibleText(driver, test, OCR_StatusChangeAudit_VisitorCategory, "Selecting Visitor Category",
				VisitorCategory);
		Wait.waitfor(2);
		typeText(driver, test, OCR_StatusChangeAudit_VisitorRequestId, "Add Visitor request ID", RequestID);
		if (site.length() > 0) {
			typeText(driver, test, OCR_StatusChangeAudit_SiteTextBox, "Type site name", site);

		}

		Wait.waitfor(2);

		selectByVisibleText(driver, test, OCR_StatusChangeAudit_SortBy, "Add SortBy ", SortBy);

		selectByVisibleText(driver, test, OCR_StatusChangeAudit_Direction, "select Direction ", Direction);

	}

}
