package importOperationClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class EntryCreateNewEntrySummaryPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */ 
	
	public static final String OCR_CreateNewEntrySummary_GoBtn = "//button[contains(text(),'Go')]";
	public static final String OCR_CreateNewEntrySummary_CancelBtn = "//button[contains(text(),'Cancel')]";
	public static final String OCR_CreateNewEntrySummary_CreateNewEntrySummaryRadioBtn = "//input[@id='sch']";
	public static final String OCR_CreateNewEntrySummary_SelectSBU = "//select[@id='createEntrySummaryForm_selSbu']";
	
	/* ******************** Constructor ***************************** */

	public EntryCreateNewEntrySummaryPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */
	
	//Click on Go Button
	public void clkGoBtn() {
		clickElement(driver, test, OCR_CreateNewEntrySummary_GoBtn, "Click on Go");
	}
	
}
