package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;

public class ListDutyReliefActivityDetailsPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_LDRActivity_Title = "//h3[contains(text(),'List Duty Relief Activity Details')]";

	/* ******************************* Constructor ****************************** */

	public ListDutyReliefActivityDetailsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	// List Duty Relief Activity Details Page is displayed
	public void lDRActivityTitle() {
		isDisplayed(driver, OCR_LDRActivity_Title);
		test.log(LogStatus.PASS, "List Duty Relief Activity Details Page is Displayed");
	}

}
