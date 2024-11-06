package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;

public class ListDutyReliefAuthorizationDetailsPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_LDRA_Title = "//h3[contains(text(),'List Duty Relief Authorization Details')]";

	/* ******************************* Constructor ****************************** */

	public ListDutyReliefAuthorizationDetailsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	// Result ListDuty Relief Authorization Details Page is displayed
	public void lDRAuthTitle() {
		isDisplayed(driver, OCR_LDRA_Title);
		test.log(LogStatus.PASS, "ListDuty Relief Authorization Details Page is Displayed");
	}

}
