//-----------Added By Nancy--------------------------//
package vmsClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class VisitorSubmissionPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/*-------------------------------------------Locators-------------------------------------*/

	public static final String OCR_HostReviewerName = "//div[@id='hostLink']/label/a";
	public static final String OCR_TDFPReviewerName = "//div[@id='tdfplink']/label/a";
	public static final String OCR_ExportControlReviewerName = "//div[@id='ecfplink']/label/a";
	public static final String OCR_SecurityReviewerName = "//div[@id='securitylink']/label/a";
	public static final String OCR_UserFirstName = "//input[@id='searchForm_userProfile_userFirstname']";
	public static final String OCR_Button_Search = "//button[contains(text(),'Search')]";
	public static final String OCR_ReviewerSearchRecord = "//table[@id='gridPopup']//tr[@id='1']";
	public static final String OCR_Button_Select = "//button[contains(text(),'Select')]";
	public static final String OCR_Button_SubmitForReview = "//button[contains(text(),'Submit For Review')]";
	public static final String OCR_Button_ForwardNavigation = "//button[@name='save']/preceding::button[1]";
	public static final String OCR_Button_AddReviewers = "//button[contains(text(),'Add Reviewers')]";
	public static final String OCR_ReviewerType = "//select[@id='reviewerType']";
	public static final String OCR_ReviewerName = "//select[@id='reviewerName']";
	public static final String OCR_Button_SaveAndReturn = "//button[contains(text(),'Save & Return')]";
	public static final String OCR_Button_Save = "//button[contains(text(),'Save')]";
	public static final String OCR_ErrorMsg = "//ul/li[contains(text(),'This Reviewer already exists. Enter unique Reviewer.')]";
	public static final String OCR_SubmitForReviewAndApproved = "(//button[@name='submitAndApprove'])[1]";

	/*--------------------------------Constructor------------------------------------------*/
	public VisitorSubmissionPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
	/*-------------------------------------------Actions-------------------------------------*/

	// Select Host reviewer name and email id
	public void add_HostReviewer(String HostUserFirstName) {
		clickElement(driver, test, OCR_HostReviewerName, "Clicking on Name link");
		Wait.waitfor(3);
		typeText(driver, test, OCR_UserFirstName, "Enter User First Name : ", HostUserFirstName);
		clickElement(driver, test, OCR_Button_Search, "Click on Search Button");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_ReviewerSearchRecord, "Click on Searched Record");
		clickElement(driver, test, OCR_Button_Select, "Clicking on Select Button");
		Wait.waitfor(3);
	}

	// Select TDFP Reviewer name and email id
	public void add_TDFPReviewer(String TDFPUserFirstName) {
		clickElement(driver, test, OCR_TDFPReviewerName, "Clicking on Name link");
		Wait.waitfor(3);
		typeText(driver, test, OCR_UserFirstName, "Enter User First Name : ", TDFPUserFirstName);
		clickElement(driver, test, OCR_Button_Search, "Click on Search Button");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_ReviewerSearchRecord, "Click on Searched Record");
		clickElement(driver, test, OCR_Button_Select, "Clicking on Select Button");
		Wait.waitfor(3);
	}

	// Select ExportControl Reviewer name and email id
	public void add_ExportControlReviewer(String ExportUserFirstName) {
		clickElement(driver, test, OCR_ExportControlReviewerName, "Clicking on Name link");
		Wait.waitfor(3);
		typeText(driver, test, OCR_UserFirstName, "Enter User First Name : ", ExportUserFirstName);
		clickElement(driver, test, OCR_Button_Search, "Click on Search Button");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_ReviewerSearchRecord, "Click on Searched Record");
		clickElement(driver, test, OCR_Button_Select, "Clicking on Select Button");
		Wait.waitfor(3);
	}

	// Select Security Reviewer name and email id
	public void add_SecurityReviewer(String SecurityUserFirstName) {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_SecurityReviewerName, "Clicking on Name link");
		Wait.waitfor(3);
		typeText(driver, test, OCR_UserFirstName, "Enter User First Name : ", SecurityUserFirstName);
		clickElement(driver, test, OCR_Button_Search, "Click on Search Button");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_ReviewerSearchRecord, "Click on Searched Record");
		clickElement(driver, test, OCR_Button_Select, "Clicking on Select Button");
		Wait.waitfor(3);
	}

	// Click on Submit For Review
	public void submitforreview() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_Button_SubmitForReview, "Clicking on Submit For Review Button");
		Wait.waitfor(5);
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(OCR_Button_ForwardNavigation)));
	}

	// Click on Submit For Review
	public void submitforreviewer() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_Button_SubmitForReview, "Clicking on Submit For Review Button");
		Wait.waitfor(5);
	}

	// Click on Submit For Review and Approved
	public void submitforreviewerAndApproved() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_SubmitForReviewAndApproved, "Clicking on Submit For Review and Approved Button");
		Wait.waitfor(5);
	}

	// Add additional reviewer
	public void add_additionalreviewer(String ReviewerType, String ReviewerName) {
		clickElement(driver, test, OCR_Button_AddReviewers, "Clicking on Additional Reviewers:");
		Wait.waitfor(3);
		selectByVisibleText(driver, test, OCR_ReviewerType, "Enter Reviewer type:", ReviewerType);
		Wait.waitfor(3);
		selectByVisibleText(driver, test, OCR_ReviewerName, "Enter Reviewer Name:", ReviewerName);
	}

	// click on Save and return button
	public void saveandreturn() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_Button_SaveAndReturn, "Clicking on Save and Return Button:");
	}

	// click on Save button
	public void save() {
		clickElement(driver, test, OCR_Button_Save, "Clicking on Save Button");
	}

	// Getting the error Message
	public String get_errormessage() {
		Wait.waitfor(3);
		return getText(driver, test, OCR_ErrorMsg, "Error Message is Displayed : ");
	}

	// Alert of successfully submitted the request for review
	public void alertSubmitForReview() {
		String alert = "//h4[contains(text(),'You successfully submitted the request for review.')]";
		try {
			Wait.fluwait(driver, alert);
			if (isDisplayed(driver, alert)) {
				test.log(LogStatus.INFO, "You successfully submitted the request for review.");
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Message is not displayed by clicking on Submit for review button");
			testFailSshot(driver, test);
		}
	}

	// Get the text of Equipment Requested
	public void getEquipmentRequest(String FirstName, String SecondName) {
		String firstEqu = getText(driver, test, "(//td[contains(text(),'" + FirstName + "')])[1]/../td[9]",
				"Get the Equipments : ");
		String secondEqu = getText(driver, test, "(//td[contains(text(),'" + SecondName + "')])[1]/../td[9]",
				"Get the Equipments : ");
		if (!firstEqu.equals(secondEqu)) {
			test.log(LogStatus.PASS, " First Visitor person equipment are not copied to other visitor persons");
		} else {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "First Visitor person equipment gets copied to other visitor persons");
		}
	}

}
