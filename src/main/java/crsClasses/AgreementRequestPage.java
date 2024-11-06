package crsClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;

public class AgreementRequestPage extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;
	
	/* ******************************** LOCATORS ******************************** */

	public static final String Result_ResultAgreementWorkQueue = "//h3[@class='page-heading']";
	
	/* ******************************* Constructor ***************************** */
	public AgreementRequestPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	
	//..........................Title of the page is Displayed or not................................//
		public void titleIsDisplayed() {
			try {
				if(isDisplayed(driver, Result_ResultAgreementWorkQueue)) {
					test.log(LogStatus.PASS, "Title is Displayed : Results Authorization ");
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Title is not Displayed : Results Authorization ");
			}
		}
	
		// Request ID is Displayed or not
		public void requestIDIsDisplayed(String RequestID) {
			try {
				String requestID = "//table[@id='grid']//tr//td//a[contains(text(),'" + RequestID + "')]";
				if (isDisplayed(driver, requestID)) {
					test.log(LogStatus.PASS, "Request ID is Displayed in results grid table : " + RequestID);
				}
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Request ID is not Displayed in results grid table : " + RequestID);
			}
		}
}
