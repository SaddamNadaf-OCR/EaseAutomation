package lpAppBelgiumClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;

public class ApplicantStatementPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_ApplicationStatement_ApplicantDate = "//input[@id='applicantDate_id']";
	public static final String OCR_ApplicantStatement_YesCheckbox = "//input[@id='Yes']";
	public static final String OCR_ApplicantStatement_NoCheckbox = "//input[@id='No']";
	public static final String OCR_ApplicantSign_Save = "//input[@id='validateApplicantForm']";

	/* ******************************* Constructor ****************************** */

	public ApplicantStatementPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	// Add Application Statement function
	public void applicationStatement(String applicantDate, String applicantStatmentChkBox) {
		if (applicantStatmentChkBox.equalsIgnoreCase("Yes")) {
			clickElement(driver, test, OCR_ApplicantStatement_YesCheckbox, "Click on YES Check Box");

		} else {
			clickElement(driver, test, OCR_ApplicantStatement_NoCheckbox, "Click on NO Check Box");
		}
		clickElement(driver, test, OCR_ApplicationStatement_ApplicantDate, "Select Applicant Date");
		date(driver, test, "Select the Applicant Date : ", applicantDate);
		test.log(LogStatus.PASS, "Selecting Applicant Date: " + applicantDate);
	}

	// click on save button in applicant Signature
	public void applicantStatmentsaveBtn() {
		clickElement(driver, test, OCR_ApplicantSign_Save, "click on save button");
	}

	//validate Applicant's statement
	public void validateApplicantStatement() {
		try {
			if (isDisplayed(driver,"//h4[contains(text(),'Error')]")) {	

				if (isDisplayed(driver,"//li[text()='Date is required.']")) {
					test.log(LogStatus.INFO, "Date is required.");
				} 
				if (isDisplayed(driver,"//li[text()='Please select Yes or No.']")) {
					test.log(LogStatus.INFO, "Please select Yes or No.");
				} 
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Error Vaildation is not Displayed by clicking on SAVE button in Applicant's statement");					
		}
	}
}
