package crsClasses;

import org.openqa.selenium.WebDriver;
//Added By Saddam
//On 26/03/2024
//Select to Import All Document in Agreement Request Page
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import utilities.GenericMethods;

public class SelectToImportPage extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;

	/********************** Loactors *******************************/
	public static final String OCR_SelectToImport_Return = "//button[@name='cancel']";
	public static final String OCR_SelectToImport_Import = "//button[@name='select']";
	public static final String OCR_SelectToImport_SelectAll = "//input[@name='selectBox1']";
	public static final String OCR_SelectToImport_Error = "//div[@class='alert fade in alert-danger']";
	public static final String OCR_SelectToImport_Success = "//div[@class='alert fade in alert-info']";

	/* ******************** Constructor ***************************** */

	public SelectToImportPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	//Click on Return Button
	public void returnButton() {
		clickElement(driver, test, OCR_SelectToImport_Return, "Clicking on Return Button :");
	}
	
	//Click on Import Button
	public void importButton() {
		clickElement(driver, test, OCR_SelectToImport_Import, "Clicking on Import Button :");
	}
	
	//Click on Select All Button
	public void selectAllButton() {
		clickElement(driver, test, OCR_SelectToImport_SelectAll, "Clicking on Select All Button :");
	}
	
	//Error is Displayed
	public void error() {
		try {
			if(isDisplayed(driver, OCR_SelectToImport_Error)) {
				test.log(LogStatus.PASS, "Error is Displayed : Plz Add Required Document :");
	        }
	    } catch (Exception e) {
	           testFailSshot(driver, test);
	           test.log(LogStatus.FAIL, "Error is not Displayed : All Documents are Imported Successfully :");
	  }
	}
	
	//Error is Displayed
	public void successmsg() {
		try {
			if(isDisplayed(driver, OCR_SelectToImport_Success)) {
				test.log(LogStatus.PASS, "Success msg is Displayed : All Documents are Successfully Imported :");
	        }
	    } catch (Exception e) {
	           testFailSshot(driver, test);
	           test.log(LogStatus.FAIL, "Error is Displayed : All Documents are Not Imported Successfully :");
	  }
	}
}
