package filesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;

public class ResultDocumentTypePage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;

	// -------------------------------Locators-----------------------------------------------//
	public static final String OCR_ResultDocumentType_Title = "//h3[@class='page-heading']";

	// ----------------------------------Constructor------------------------------------------//

	public ResultDocumentTypePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	/* ******************** Actions ********************************* */
	// Title of DocumentType page is displaying or not
	public void ResultDocumentTypeIsDisplayed() {
		try {
			isDisplayed(driver, OCR_ResultDocumentType_Title);
			test.log(LogStatus.PASS, "Result Document Type Is Displayed");
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Result Document Type Is Not Displayed");

		}
	}


}
