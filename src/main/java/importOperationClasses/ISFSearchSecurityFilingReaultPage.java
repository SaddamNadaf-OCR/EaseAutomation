package importOperationClasses;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;

public class ISFSearchSecurityFilingReaultPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_Search_ISF_ResultTitle = "//h3[@class='page-heading']";
	public static final String OCR_Search_ISF_NewSearch = "//button[contains(text(),'New Search')]";

	/* ******************** Constructor ***************************** */

	public ISFSearchSecurityFilingReaultPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	// verify the Search ISF Page is Display or not
	public void searchISFResultDisplay() {
		String pageTitle = getText(driver, test, OCR_Search_ISF_ResultTitle, "Title of the Page : ");
		if (pageTitle.contains("List ISF Forms")) {
			test.log(LogStatus.PASS, "ISF Search Security Filing Reault Page is Display");
		} else {
			test.log(LogStatus.FAIL, "ISF Search Security Filing Reault Page Fail");
			testFailSshot(driver, test);
			Assert.assertTrue(false);
		}
	}

	public void newSearch() {
		clickElement(driver, test, OCR_Search_ISF_NewSearch, "Click new search");
	}
}
