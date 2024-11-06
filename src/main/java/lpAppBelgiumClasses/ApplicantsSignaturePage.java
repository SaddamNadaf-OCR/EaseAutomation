package lpAppBelgiumClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class ApplicantsSignaturePage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_ApplicationSign_ApplicantDate = "//input[@id='applicantDate_id']";	
	public static final String OCR_ApplicationSign_FirstAndLastName = 
			"//input[@id='editApplicateStatementForm_authorisationAdditionalInfoValue_endUse']";
	public static final String OCR_ApplicantSign_CertifacteSave = "//input[@id='validateCertificationForm']";	

	/* ******************************* Constructor ****************************** */

	public ApplicantsSignaturePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	// Add Application Statement function
	public void applicationSignature(String applicantDate,String FirstAndLastName) {	
		Wait.waitfor(3);
		scrollToElement(driver, OCR_ApplicationSign_ApplicantDate);
		scrollToBottom(driver);
		clickElement(driver, test, OCR_ApplicationSign_ApplicantDate, "Select Applicant Date");
		date(driver, test, "Selecting Applicant Date: " , applicantDate);
		typeText(driver, test, OCR_ApplicationSign_FirstAndLastName, "Enter the First & last name : ", FirstAndLastName);
	}

	// click on Certifacte save button in applicant Signature
		public void applicantSignCertifactesaveBtn() {
			Wait.waitfor(3);
			scrollToElement(driver, OCR_ApplicantSign_CertifacteSave);
			scrollToTop(driver);
			Wait.waitfor(3);
			clickElement(driver, test, OCR_ApplicantSign_CertifacteSave, "click on save button");
		}

	//validating Applicant's statement
	public void validateApplicantStatement() {
		try {
			if (isDisplayed(driver,"//h4[contains(text(),'Error')]")) {	
				if (isDisplayed(driver,"//li[text()='Date is required.']")) {
					test.log(LogStatus.INFO, "Date is required.");
				} 				
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Error Vaildation is not Displayed by clicking on SAVE button in Applicant's statement");					
		}
	}
	
}
