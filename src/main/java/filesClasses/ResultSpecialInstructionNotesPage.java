package filesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;

public class ResultSpecialInstructionNotesPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	// -------------------------------Locators-----------------------------------------------//
	public static final String OCR_ResultNotes_Title = "//h3[@class='page-heading']";

	// ----------------------------------Constructor------------------------------------------//

	public ResultSpecialInstructionNotesPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */
	// Title of Special Instruction Notes is displaying or not
	public void ResultNotesIsDisplayed() {
		try {
			isDisplayed(driver, OCR_ResultNotes_Title);
			test.log(LogStatus.PASS, "Result  Notes Is Displayed");
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Result Notes Is Not Displayed");

		}
	}

}
