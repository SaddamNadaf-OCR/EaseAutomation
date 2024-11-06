package crsClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;

public class ResultAgreementRequestPage extends GenericMethods{
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_ResultIR_Title = "//h3[@class='page-heading']";


	/* ******************** Constructor ***************************** */

	public ResultAgreementRequestPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	//Title of the page is Displayed or not
	public void titleIsDisplayed() {
		try {
			if(isDisplayed(driver, OCR_ResultIR_Title)) {
				test.log(LogStatus.PASS, "Title is Displayed : Results Agreement request ");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Title is not Displayed : Results Agreement request ");
		}
	} 
}


