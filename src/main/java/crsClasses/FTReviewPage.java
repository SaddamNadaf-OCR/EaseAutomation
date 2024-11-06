package crsClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class FTReviewPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_ExportDetermination = "//select[@id='editForeignTravelReviewInfo_foreignTravelGeneralInfoValue_determination']";
	public static final String OCR_ExportDecision = "//select[@id='editForeignTravelReviewInfo_foreignTravelGeneralInfoValue_exportDecision']";
	public static final String OCR_SecurityDecision = "//select[@id='editForeignTravelReviewInfo_foreignTravelGeneralInfoValue_securityDecision']";
	public static final String OCR_ManagerDecision = "//select[@id='editForeignTravelReviewInfo_foreignTravelGeneralInfoValue_managerDecision']";
	public static final String OCR_DirectorDecision = "//select[@id='editForeignTravelReviewInfo_foreignTravelGeneralInfoValue_vpDecision']";
	public static final String OCR_Button_ESavendFinalize = "(//button[contains(text(),'Save & Finalize Decision')])[1]";
	public static final String OCR_Button_SSavendFinalize = "//button[@name='securitySubmit']";
	public static final String OCR_Button_MSavendFinalize = "//button[@name='managerSubmit']";
	public static final String OCR_Button_DSavendFinalize = "//button[@name='vpSubmit']";
	public static final String OCR_Button_AuthorisationNo = "//input[@id='editForeignTravelReviewInfo_foreignTravelGeneralInfoValue_licenseNo']";
	public static final String OCR_ActivityType = "//select[@id='editForeignTravelReviewInfo_activityType']";
	public static final String OCR_AuthorizationType = "//input[@id='editForeignTravelReviewInfo_foreignTravelGeneralInfoValue_itarExemptionNo']";

	/*
	 * ******************************** Constructor ********************************
	 */
	public FTReviewPage(WebDriver driver, ExtentTest test) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.test = test;
	}

	// Selecting Export Reviewer Decision
	public void exportdecision(String EDecision, String Determination) {
		selectByVisibleText(driver, test, OCR_ExportDecision, "Select Export Decision :", EDecision);
		if (EDecision.contains("Approved") || EDecision.contains("Disapproved") || EDecision.contains("Terminated")) {
			selectByVisibleText(driver, test, OCR_ExportDetermination, "Select Export Determination :", Determination);
			Wait.waitfor(3);
		}
	}

	// Enter Agreement No
	public void enter_agreementno(String AgreementNo) {
		typeText(driver, test, OCR_Button_AuthorisationNo, "Enter Agreement No :", AgreementNo);
	}

	// Select ActivityType
	public void selectactivitytype(String ActivityType) {
		selectByVisibleText(driver, test, OCR_ActivityType, "Select ActivityType :", ActivityType);
	}

	// Enter AuthorizationType
	public void enter_authorizationtype(String AuthorizationType) {
		typeText(driver, test, OCR_AuthorizationType, "Enter AuthorizationType :", AuthorizationType);
	}

	// Selecting Security Reviewer Decision
	public void securitydecision(String SDecision) {
		selectByVisibleText(driver, test, OCR_SecurityDecision, "Select Security Decision :", SDecision);
	}

	// Selecting Manager Reviewer Decision
	public void managerdecision(String MDecision) {
		selectByVisibleText(driver, test, OCR_ManagerDecision, "Select Manager Decision :", MDecision);
	}

	// Selecting Director Reviewer Decision
	public void directordecision(String DDecision) {
		selectByVisibleText(driver, test, OCR_DirectorDecision, "Select Director Decision :", DDecision);
	}

	// Click on Export Save and Finalize Button
	public void click_exp_saveandfinalize() {
		scrollToElement(driver, OCR_Button_ESavendFinalize);
		clickElement(driver, test, OCR_Button_ESavendFinalize, "Clicking on Export Save and Finalize Button :");
	}

	// Click on Security Save and Finalize Button
	public void click_sec_saveandfinalize() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(OCR_Button_SSavendFinalize)));
		// clickElement(driver, test, OCR_Button_SSavendFinalize, "Clicking on Security
		// Save and Finalize Button");
	}

	// Click on Manager Save and Finalize Button
	public void click_man_saveandfinalize() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(OCR_Button_MSavendFinalize)));
		// clickElement(driver, test, OCR_Button_MSavendFinalize, "Clicking on Manager
		// Save and Finalize Button");
	}

	// Click on Director Save and Finalize Button
	public void click_dir_saveandfinalize() {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(OCR_Button_DSavendFinalize)));
		// clickElement(driver, test, OCR_Button_MSavendFinalize, "Clicking on Manager
		// Save and Finalize Button");
	}

	public void validate_expreviewerror() {
		try {
			if (isDisplayed(driver, "//h4[contains(text(),'Error')]")) {

				if (isDisplayed(driver, "//li[contains(text(),'Please select an export decision.')]")) {
					test.log(LogStatus.INFO, "Please select an export decision.");
				}

			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL,
					"Error Validation is not Displayed by clicking on SAVE button in Foreign Travel Export Review Page");
		}
	}

	public void validate_exp_authorizationerror() {

		try {
			if (isDisplayed(driver, "//h4[contains(text(),'Error')]")) {

				if (isDisplayed(driver, "//li[contains(text(),'Please enter Authorization no/Agreement Number.")) {
					test.log(LogStatus.INFO, "Please enter Authorization no/Agreement Number.");
				}
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL,
					"Error Validation is not Displayed by clicking on SAVE button in Foreign Travel Export Review Page");
		}

	}

	public void validate_secreviewerror() {
		try {
			if (isDisplayed(driver, "//h4[contains(text(),'Error')]")) {

				if (isDisplayed(driver, "//li[contains(text(),'Please select a security decision.')]")) {
					test.log(LogStatus.INFO, "Please select a security decision.");
				}
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL,
					"Error Validation is not Displayed by clicking on SAVE button in Foreign Travel Security Review Page");
		}
	}

	public void validate_manreviewerror() {
		try {
			if (isDisplayed(driver, "//h4[contains(text(),'Error')]")) {

				if (isDisplayed(driver, "//li[contains(text(),'Please select a manager decision.')]")) {
					test.log(LogStatus.INFO, "Please select a manager decision.");
				}
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL,
					"Error Validation is not Displayed by clicking on SAVE button in Foreign Travel Manager Review Page");
		}

	}

	public void validate_dirreviewerror() {
		try {
			if (isDisplayed(driver, "//h4[contains(text(),'Error')]")) {

				if (isDisplayed(driver, "//li[contains(text(),'Please select a Director decision.')]")) {
					test.log(LogStatus.INFO, "Please select a Director decision.");
				}
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL,
					"Error Validation is not Displayed by clicking on SAVE button in Foreign Travel Director Review Page");
		}
	}

	public void moveToChangeReqTab() {
		clickElement(driver, test, "//a[contains(text(),'Change Request')]", "Clicking on Review Tab: ");
	}
}
