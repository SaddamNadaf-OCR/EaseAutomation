package tablesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;

public class ResultAuthorizationTransactionTypesPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;

	// -------------------------------Locators-----------------------------------------------//
	public static final String OCR_AuthorizationTransaction_Title = "//h3[@class='page-heading']";
	public static final String OCR_AddAuthorizationTransactionType = "//button[@name='Add']";

	// ----------------------------------Constructor------------------------------------------//

	public ResultAuthorizationTransactionTypesPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	//Clicking on Add Button
	
	public void AddAuthorizationTransaction() {
		clickElement(driver, test, OCR_AddAuthorizationTransactionType, "Clicking On Add AuthorizationTransaction Button");
	}
	/* ******************** Actions ********************************* */
	// Title of  Authorization Transaction page is displaying or not
	public void AuthorizationTransactionIsDisplayed() {
		try {
			isDisplayed(driver, OCR_AuthorizationTransaction_Title);
			test.log(LogStatus.PASS, "Result AuthorizationTransaction  Is Displayed");
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Result AuthorizationTransaction Is Not Displayed");

		}
	}



}
