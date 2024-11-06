package vmsClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class ReviewerPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/*-------------------------------------------Locators-------------------------------------*/

	public static final String OCR_Review_SelectAll = "//input[@name='selectAll']";
	public static final String OCR_Review_Approve = "//button[contains(text(),'Approve')]";
	public static final String OCR_Review_Disapprove = "//button[contains(text(),'Disapprove')]";
	public static final String OCR_Review_OverallDecision = "//select[@name='visitorReviewerValue.reviewerStatus']";
	public static final String OCR_Review_SaveandFinalize = "//button[contains(text(),'Save And Finalize')]";
	public static final String OCR_Review_CertificationStmt = "//input[@id='editVmctVisitorReviewerReview_certCheckbox']";
	public static final String OCR_Review_Reason = "//textarea[@id='editVmctVisitorReviewerReview_visitorReviewerValue_decisionNotes']";
	public static final String OCR_Review_Back = "(//button[contains(text(),'Back')])[1]";
	public static final String OCR_Review_SecurityCheckNotification ="(//button[@id='securityCheck'])";
	public static final String OCR_Review_SendButton ="//button[@id='sendMail']";
	public static final String OCR_Review_CloseIcon ="//button[@class='close']";
	public static final String OCR_Review_BackButton ="//button[@id='cancel']";
	public static final String OCR_Review_OKbutton ="//button[contains(text(), 'OK')]";
	public static final String OCR_Review_VisitorEmail ="//input[@name='visitorsEmail']";

	/*--------------------------------Constructor------------------------------------------*/

	public ReviewerPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/*-------------------------------------------Actions-------------------------------------*/

	
	// Visitor email is displayed
	
	public void visitorEmail_isDisplayed()
	{
		try {
			if(isDisplayed(driver, OCR_Review_VisitorEmail)) {
				test.log(LogStatus.PASS, "Visitor Email is Displayed on Notification popup");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Visitor Email is not Displayed on Notification popup");
		}
	
	}
	
	// Click on Send button
		public void click_SendButton() {
			clickElement(driver, test, OCR_Review_SendButton, "Click on Send button");
		}
		
	// Click on OK button
		public void click_OKButton() {
			clickElement(driver, test, OCR_Review_OKbutton, "Click on OK button");
		}	
		
		//Click on close icon
		public void click_closeIcon() {
			clickElement(driver, test, OCR_Review_CloseIcon, "Click on close icon");
		}
		// Click on back Button
		public void click_backButton() {
			clickElement(driver, test, OCR_Review_BackButton, "Click on back Button");
		}
	// click on Select All button
	public void click_SelectAllBtn() {
		clickElement(driver, test, OCR_Review_SelectAll, "Click on Select All Button");
	}

	// Click on Security Check Notification
		public void click_SecurityCheckNotification() {
			clickElement(driver, test, OCR_Review_SecurityCheckNotification, "Click on Security Check Notification");
		}
		
	// click on Back
	public void click_Back() {
		Wait.waitfor(5);
		clickElement(driver, test, OCR_Review_Back, "Click on Back Button");
	}

	// click on Approve button
	public void click_ApproveBtn() {
		clickElement(driver, test, OCR_Review_Approve, "Click on Approve Button");
	}

	// click on Approve button
	public void click_DisapproveBtn() {
		clickElement(driver, test, OCR_Review_Disapprove, "Click on Disapprove Button");
	}

	// Submit for over all Decision
	public void overDecision(String OverallDecision, String Reason) {
		selectByVisibleText(driver, test, OCR_Review_OverallDecision, "Select Decision value : ", OverallDecision);
		Wait.waitfor(5);
		typeText(driver, test, OCR_Review_Reason, "Enter the Reason : ", Reason);
		scrollToElement(driver, OCR_Review_SaveandFinalize);
	//	clickElement(driver, test, OCR_Review_CertificationStmt, "Click on  Check box of Host ");
		Wait.waitfor(5);
		clickElement(driver, test, OCR_Review_SaveandFinalize, "Clicking on Save and Finalize Button");
		Wait.waitfor(2);
		scrollToTop(driver);
	}
	public void saveAndFinalize() {
		clickElement(driver, test, OCR_Review_SaveandFinalize, "Clicking on Save and Finalize Button");
	}
	// Submit for export over all Decision
	public void exportOverDecision(String OverallDecision, String Reason) {
		selectByVisibleText(driver, test, OCR_Review_OverallDecision, "Select Decision value : ", OverallDecision);
		Wait.waitfor(3);
		typeText(driver, test, OCR_Review_Reason, "Enter the Reason : ", Reason);
		clickElement(driver, test, OCR_Review_SaveandFinalize, "Clicking on Save and Finalize Button");
		Wait.waitfor(3);
	}

	// Click on CheckList button
	public void click_CheckList() {
		clickElement(driver, test, "//button[@name ='checklistBtn']", "Click on checklist button");
		Wait.waitfor(3);
		clickElement(driver, test, "//input[@id='1_1']", "click on Level 1");
		typeText(driver, test, "//textarea[@id='saveFinalizeChecklist_checklistNotes']", "Enter the Remarks: ",
				"Remarks");
		clickElement(driver, test, "//button[contains(text(),'Finalize')]", "Click on Finalize");
		Wait.waitfor(3);
		clickElement(driver, test, "(//button[@name='close'])[1]", "Click on Close");
		Wait.waitfor(3);
	}

	// Alert of successfully submitted the request for Approving
	public void alertApprovedReq() {
		String alert = "//h4[contains(text(),'You approved the request successfully and an email')]";
		try {
			Wait.fluwait(driver, alert);
			if (isDisplayed(driver, alert)) {
				test.log(LogStatus.INFO,
						" You approved the request successfully and an email is sent to the Requestor.");
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Message is not displayed by Approving the request");
			testFailSshot(driver, test);
		}
	}

	// Alert of successfully submitted the request for DisApproved
	public void alertDisApprovedReq() {
		String alert = "//h4[contains(text(),'The Request is disapproved and an email sent to th')]";
		try {
			Wait.fluwait(driver, alert);
			if (isDisplayed(driver, alert)) {
				test.log(LogStatus.INFO, "The Request is disapproved and an email sent to the Requestor. ");
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Message is not displayed by DisApproved the request");
			testFailSshot(driver, test);
		}
	}

	// Alert of successfully submitted the request for Return for Rework
	public void alertReturnForReworkReq() {
		String alert = "//h4[contains(text(),'The Request is returned to the requestor for rewor')]";
		try {
			Wait.fluwait(driver, alert);
			if (isDisplayed(driver, alert)) {
				test.log(LogStatus.INFO,
						" The Request is returned to the requestor for rework and an email is sent to the Requestor.");
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "Message is not displayed by submit the request to Return for Rework");
			testFailSshot(driver, test);
		}
	}

}
