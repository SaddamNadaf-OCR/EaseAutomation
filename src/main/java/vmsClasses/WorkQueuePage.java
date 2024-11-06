package vmsClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;
import utilities.Wait;

public class WorkQueuePage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_WorkQueue_Search = "(//input[@placeholder='Search'])[10]";
	public static final String OCR_WorkQueue_ExportSearch = "(//div[@class='fixed-table-toolbar'])[2]/../div/div[2]/input";
	public static final String OCR_WorkQueue_GO = "(//button[contains(text(),'Go')])[1]";
	public static final String OCR_WorkQueue_ExportTab = "//div[@id='headingThree']";
	public static final String OCR_WorkQueue_SecurityTab = "//div[@id='headingFour']";
	public static final String OCR_WorkQueue_SecuritySearch = "(//div[@class='fixed-table-toolbar'])[3]/../div/div[2]/input";

	/* ******************** Constructor ***************************** */

	public WorkQueuePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	// Export Reviewer Queue
	public void exportReviewerQueue(String BusinessUnit, String VisitorID) {
		clickElement(driver, test, "//button[@id='dropdownMenuButton7']", "Click on Business unit");
		Wait.waitfor(3);
		clickElement(driver, test, "//button[contains(text(),'" + BusinessUnit + "')]", "Select the Business Unit : ");
		Wait.waitfor(3);
		scrollToBottom(driver);
		Wait.waitfor(4);
		clickElement(driver, test, OCR_WorkQueue_ExportTab, "Click on Export Reviewer Queue");
		typeText(driver, test, OCR_WorkQueue_ExportSearch, "Enter the Export Reviewer Queue ID : ", VisitorID);
		Wait.waitfor(3);
		clickElement(driver, test, "//td[contains(text(),'" + VisitorID + "')]/../td[7]/button", "Click on Go");
	}

	// Security Reviewer Queue
	public void securityReviewerQueue(String BusinessUnit, String VisitorID) {
		clickElement(driver, test, "//button[@id='dropdownMenuButton7']", "Click on Business unit");
		Wait.waitfor(3);
		clickElement(driver, test, "//button[contains(text(),'" + BusinessUnit + "')]", "Select the Business Unit : ");
		Wait.waitfor(4);
		scrollToBottom(driver);
		clickElement(driver, test, OCR_WorkQueue_SecurityTab, "Click on Security Queue Tab");
		Wait.waitfor(2);
		typeText(driver, test, OCR_WorkQueue_SecuritySearch, "Enter  Security Reviewer Queue ID : ", VisitorID);
		Wait.waitfor(4);
		clickElement(driver, test, "//td[contains(text(),'" + VisitorID + "')]/../td[7]/button", "Click on Go");
	}

}
