package vmsClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class ChangeRequestPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/*-------------------------------------------Locators-------------------------------------*/

	public static final String OCR_Button_AddChangeRequest = "//button[contains(text(),'Add Change Request')]";
	public static final String OCR_DateFromTo = "//input[@id='selectDateChangeType']";
	public static final String OCR_AddEditVisitorOrganization = "//input[@id='selectIndCompChangeType']";
	public static final String OCR_EditOtherDetails = "//input[@id='selectOtherChangeType']";
	public static final String OCR_ReasonForChange = "//textarea[@id='editVisitorChangeRequest_visitorChangeRequestValue_reasonForChange']";
	public static final String OCR_Button_SubmitChange = "//button[contains(text(),'Submit Change')]";
	public static final String OCR_Button_VisitDateFrom = "//input[@id='editVisitorChangeRequest_visitDateFrom']";
	public static final String OCR_Button_VisitDateTo = "//input[@id='editVisitorChangeRequest_visitDateTo']";
	public static final String OCR_ChnageRequest_DateFrom_Today = "//button[contains(text(),'Today')]";

	/*--------------------------------Constructor------------------------------------------*/

	public ChangeRequestPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/*-------------------------------------------Actions-------------------------------------*/

	// Clicking on Add Change Request Button
	public void addchangerequest() {
		clickElement(driver, test, OCR_Button_AddChangeRequest, "Clicking on Add Change Request Button:");
	}

	// selected the Change request, Extend Visit Date and Reason For Change
	public void selectchangerequest(String ChangeRequest, String DateFrom, String DateTo, String ReasonForChange) {
		if (ChangeRequest.contains("D")) {
			clickElement(driver, test, OCR_DateFromTo, "Select Date From To check box");
			Wait.waitfor(3);
			clickElement(driver, test, OCR_Button_VisitDateFrom, "Clicking on Visit Date From");
			if (DateFrom.contains("Today")) {
				clickElement(driver, test, OCR_ChnageRequest_DateFrom_Today, "Clicking on Today Button");
			} else {
				date(driver, test, "Selecting the From date : ", DateFrom);
			}
			clickElement(driver, test, OCR_Button_VisitDateTo, "Clicking on Visit Date From");
			date(driver, test, "Selecting the To date : ", DateTo);
		}
		if (ChangeRequest.contains("A")) {
			clickElement(driver, test, OCR_AddEditVisitorOrganization,
					"Select Add/Edit Visitor Organization check box");
		}
		if (ChangeRequest.contains("O")) {
			clickElement(driver, test, OCR_EditOtherDetails, "Select edit Other details check box");
		}
		Wait.waitfor(3);
		typeText(driver, test, OCR_ReasonForChange, "Enter Reason for change : ", ReasonForChange);

	}

	// click on Submit Change button
	public void submitchange() {
		clickElement(driver, test, OCR_Button_SubmitChange, "Clicking on Submit Change Button");
	}

	// validating the Change Request
	public void validate_ChangeRequest(String ReasonForChange) {
		try {
			if (isDisplayed(driver, "//h4[contains(text(),'Error!')]")) {
				if (isDisplayed(driver, "//li[text()='Please Enter Reason For Change Requested']")) {
					test.log(LogStatus.INFO, "Please Enter Reason For Change Requested");
				}
				if (isDisplayed(driver, "//li[text()='Please Mark The Type of Change Request ']")) {
					test.log(LogStatus.INFO, "Please Mark The Type of Change Request ");
				}
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL,
					"Error Vaildation for Change Request is not Displayed by clicking on Submit Change button");
			testFailSshot(driver, test);
		}
		typeText(driver, test, OCR_ReasonForChange, "Enter Reason for change", ReasonForChange);
		submitchange();
		try {
			if (isDisplayed(driver, "//h4[contains(text(),'Error!')]")) {
				if (isDisplayed(driver, "//li[text()='Please Mark The Type of Change Request ']")) {
					test.log(LogStatus.INFO, "Please Mark The Type of Change Request ");
				}
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL,
					"Error Vaildation for Change Request is not Displayed by clicking on Submit Change button");
			testFailSshot(driver, test);
		}
		clickElement(driver, test, OCR_EditOtherDetails, "Select Other Change radio button");
	}

	// Alert of successfully submitted the Change Request
	public void alertSubmitForChange(String RequestID) {
		String alert = "//h4[contains(text(),'You created the change request successfully for th')]";
		try {
			Wait.fluwait(driver, alert);
			if (isDisplayed(driver, alert)) {
				test.log(LogStatus.INFO,
						" You created the change request successfully for the Request ID " + RequestID);
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Message is not displayed by clicking on Submit for review button");
			testFailSshot(driver, test);
		}
	}

}
