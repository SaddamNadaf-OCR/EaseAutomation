package vmsClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;
import utilities.Wait;

public class VisitorManagementPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_VM_VisitorReq = "//a[contains(text(),'Create Visitor Request')]";
	public static final String OCR_VM_RapidVisitorReq = "//a[contains(text(),'Create Rapid Request')]";

	/* ******************** Constructor ***************************** */

	public VisitorManagementPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	// Click on visitor Request
	public void click_VisitorRequest() throws InterruptedException {
		Wait.waitfor(4);
		clickElement(driver, test, OCR_VM_VisitorReq, "Clicking on Visitor Request");
		Wait.waitfor(3);
		// clickElement(driver, test, "//button[contains(text(),'GO')]", "Click on Go");
	}

	// Click on visitor Request
	public void click_RapidVisitorRequest() throws InterruptedException {
		Wait.waitfor(4);
		clickElement(driver, test, OCR_VM_RapidVisitorReq, "Clicking on Create Rapid Request");
		Wait.waitfor(3);
		// clickElement(driver, test, "//button[contains(text(),'GO')]", "Click on Go");
	}
}
