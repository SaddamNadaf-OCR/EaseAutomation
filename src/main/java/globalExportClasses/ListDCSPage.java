package globalExportClasses;
/* 
 * Module : Export Operation
 * Author  : Saddam
 * created date : May 2024
 * Descriptions : List DCS Page
 * changed by : Nil
 * changed date : Nil
 * Purpose of change : Nil 
 * Reviewed by : Nil 
 */
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import utilities.GenericMethods;

public class ListDCSPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_ListDCSResultPage_Heading = "//h3[contains(text(),'List DCS')]";
	public static final String OCR_ListDCSResultPage_NewSearch = "//button[contains(text(),'New Search')]";
	public static final String OCR_ListDCSResultPage_CopyIcon = "//i[@class='fa fa-copy']";
	public static final String OCR_ListDCSResultPage_DeleteIcon = "//i[@class='fa fa-trash-o']";

	/* ******************************* Constructor ****************************** */

	public ListDCSPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	// Click on DCS ID
	public void clickDCSID(String DCSID) {
		clickElement(driver, test, "//a[contains(text(),'" + DCSID + "')]",
				"Clicking on DSC ID :" + DCSID);
	}

	// Click on New Search button
	public void newSearch() {
		clickElement(driver, test, OCR_ListDCSResultPage_NewSearch, "Clicking on New Search Button :");
	}

	// Click on Copy Icon
	public void copyIcon() {
		clickElement(driver, test, OCR_ListDCSResultPage_CopyIcon, "Clicking on Copy Icon :");
	}

	// Click on Delete Icon
	public void deleteIcon() {
		clickElement(driver, test, OCR_ListDCSResultPage_DeleteIcon, "Clicking on Delete ICon :");
	}

	// Heading is Displayed
	public void titleisDisplayed() {
		try {
			if (isDisplayed(driver, OCR_ListDCSResultPage_Heading)) {
				test.log(LogStatus.PASS, "Title is Displayed :");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Title is Not Displayed :");
		}
	}
}
