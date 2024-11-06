package vmsClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;

public class SearchVisitPurposePage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_SVP_AddVisitPurpose = "//button[@id='mybutton']";
	
	/* ******************** Constructor ***************************** */

	public SearchVisitPurposePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	//Click on Add Visit Purpose
	public void clickAddVisitPurpose() {
		clickElement(driver, test, OCR_SVP_AddVisitPurpose, "Click on Add Visit Purpose");
	}

}
