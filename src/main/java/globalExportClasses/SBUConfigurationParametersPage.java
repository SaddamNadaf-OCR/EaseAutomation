package globalExportClasses;
/* 
 * Module : Export Operation
 * Author  : Saddam
 * created date : July 2024
 * Descriptions : SBU Configuration Parameters Page
 * changed by : Nil
 * changed date : Nil
 * Purpose of change : Nil 
 * Reviewed by : Nil 
 */
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;

public class SBUConfigurationParametersPage extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_SBUConfi_NewSearchButton = "//button[contains(text(),'New Search')]";
	public static final String OCR_SBUConfi_Grid = "//div[@id='gbox_grid']";
	public static final String OCR_SBUConfi_Heading = "//h3[contains(text(),'SBU Configuration Parameters')]";

	/* ******************************* Constructor ****************************** */

	public SBUConfigurationParametersPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */
	
	//Click on New Search Button
	public void newSearch() {
		clickElement(driver, test, OCR_SBUConfi_NewSearchButton, "Clicking on New Search Button :");
	}
	
	//Grid is Displayed
	public void gridValidation() {
		try {
			if(isDisplayed(driver, OCR_SBUConfi_Grid)) {
				test.log(LogStatus.PASS, "Result Grid is Displayed :");
			}
		}catch(Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Result Grid is Not Displayed :");
		}
	}
	
	//Heading Validation
	public void headingValiation() {
		try {
			if(isDisplayed(driver, OCR_SBUConfi_Heading)) {
				test.log(LogStatus.PASS, "Result Page Heading is Displayed :");
			}
		}catch(Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Result Page Heading is Not Displaying :");
		}
	}
	
	//Click on Grid Value
	public void clickonParameterValue(String ParameterName) {
		clickElement(driver, test, "//a[contains(text(),'"+ParameterName+"')]", "Clicking on Searched Parametes :");
	}
}
