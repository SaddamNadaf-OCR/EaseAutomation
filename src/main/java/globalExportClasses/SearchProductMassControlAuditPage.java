package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class SearchProductMassControlAuditPage extends GenericMethods{

	public WebDriver driver;
	public ExtentTest test;
	
	/* ******************************** LOCATORS ******************************** */
	
	
	public static final String OCR_SearchProductMassControlAuditPage_SBU = "//select[@id='resultProductMassControlAudit_sbuCode']";
	public static final String OCR_SearchProductMassControlAuditPage_Status = "//select[@id='resultProductMassControlAudit_status']";
	public static final String OCR_SearchProductMassControlAuditPage_SearchBtn = "//button[contains(text(),'Search')]";
	public static final String OCR_SearchProductMassControlAuditPage_ValidateHeading = "//h3[contains(text(),'PRODUCT MASS CONTROL AUDIT REPORT')]";
	public static final String OCR_ProductMassControlAudit_fromDate = "//input[@id='resultProductMassControlAudit_fromDate']";
	public static final String OCR_ProductMassControlAudit_fromDate_EndDate = "//input[@id='resultProductMassControlAudit_toDate']";
	public static final String OCR_ProductMassControlAudit_ProductLine= "//input[@name='htsSchbEccnHistoryValue.productCode']";
	public static final String OCR_ProductMassControlAudit_Country= "(//input[@name=''])[1]";
	public static final String OCR_ProductMassControlAudit_ExportClass = "//input[@name='htsSchbEccnHistoryValue.newEccn']";
	public static final String OCR_ProductMassControlAudit_CurrentExportClas ="//input[@name='htsSchbEccnHistoryValue.newExportAuthority']";
	public static final String OCR_ProductMassControlAudit_ImportClass = "//input[@name='htsSchbEccnHistoryValue.newHtsCode']";
	public static final String OCR_ProductMassControlAudit_ChangedBy ="//input[@name='htsSchbEccnHistoryValue.userId']";
	/* ******************************* Constructor ****************************** */

	public SearchProductMassControlAuditPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */
	public void selectSBU(String sbuCode) {
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCR_SearchProductMassControlAuditPage_SBU, "Select SBU Code : ", sbuCode);
		
	}
	
	public void selectStatus(String Status) {
		Wait.waitfor(2);
		selectByVisibleText(driver, test, OCR_SearchProductMassControlAuditPage_Status, "Select Status : ", Status);
		
	}
	
	public void SearchBtn() {
		
		clickElement(driver, test, OCR_SearchProductMassControlAuditPage_SearchBtn, "Click on Search Button");
		Wait.waitfor(5);
	}
	public void serachbyparameter (String sbuCode, String Status, String ProductLine, String Country, 
			String NewExpClass, String CurrentExpClass, String ImportClass, String ChangedBy) {
		selectByVisibleText(driver, test, OCR_SearchProductMassControlAuditPage_SBU, "Select SBU Code :", sbuCode);
		selectByVisibleText(driver, test, OCR_SearchProductMassControlAuditPage_Status, "Select Status :", Status);
        typeText(driver, test, OCR_ProductMassControlAudit_ProductLine, "Enter Product line", ProductLine);
        typeText(driver, test, OCR_ProductMassControlAudit_Country, "Select Country :", Country);
        typeText(driver, test,OCR_ProductMassControlAudit_ExportClass , "New Export Class :", NewExpClass);
        typeText(driver, test, OCR_ProductMassControlAudit_CurrentExportClas, "Current Export Class", CurrentExpClass);
        typeText(driver, test, OCR_ProductMassControlAudit_ImportClass, "Import CLass :", ImportClass);
        typeText(driver, test, OCR_ProductMassControlAudit_ChangedBy, "Changed By :", ChangedBy);
	}

	public void validateHeading() {
		isDisplayed(driver, OCR_SearchProductMassControlAuditPage_ValidateHeading);
		Wait.waitfor(3);
		test.log(LogStatus.PASS, "Search Product Mass Control Audit page is Displayed");
		Wait.waitfor(3);
	}
	

	
}
