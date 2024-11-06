package vmsClasses;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class ReviewPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/*-------------------------------------------Locators-------------------------------------*/

	public static final String OCR_Button_ApproveDisapproveVisitorsIndividually = "//button[contains(text(),'Approve/Disapprove Visitors Individually')]";
	public static final String OCR_Button_SelectAll = "//input[@name='selectAll']";
	public static final String OCR_SelectVisitorCheckbox = "//input[@id='sequenceNo0']";
	public static final String OCR_WithSelectedBadgeType = "//select[@id='editVmctVisitorReviewerReview_badgeType']";
	public static final String OCR_Button_Approve = "//button[@name='Disapprove']/preceding::button[1]";
	public static final String OCR_Button_Close = "(//button[@class='close'])[1]";
	public static final String OCR_OverallDecision = "//select[@id='editVmctVisitorReviewerReview_visitorReviewerValue_reviewerStatus']";
	public static final String OCR_Button_SaveandFinalize = "//button[contains(text(), 'Save And Finalize')]";
	public static final String OCR_Button_VisitorSubmSave = "//button[contains(text(),'Save')]";
	public static final String OCR_Button_BackwardNavigation = "//button[@name='cancel']/preceding::button[2]";
	public static final String OCR_ReasonForDisapproval_ReturnForRework = "//textarea[@id='editVmctVisitorReviewerReview_visitorReviewerValue_decisionNotes']";
	public static final String OCR_Button_SaveVisitorAck = "(//button[contains(text(),'Save')])[3]";
	public static final String OCR_Button_ForwardNavigation = "//button[@name='save']/preceding::button[1]";
	public static final String OCR_Button_DisApprovedVisitorAck = "//button[@name='Disapprove']";
	public static final String OCR_Button_Cancel = "//button[contains(text(),'Cancel Visitor Request')]/following::button[1]";
	public static final String OCR_Review_close = "//button[@class='close']";
	public static final String OCR_Review_CheckListBtn = "//button[@name='checklistBtn']";

	/*--------------------------------Constructor------------------------------------------*/

	public ReviewPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/*-------------------------------------------Actions-------------------------------------*/

	// Approve or Disapprove Visitor
	public void ApproveorDissapproveVisitor(String WithSelectedBadgeType) {
		/*clickElement(driver, test, OCR_Button_ApproveDisapproveVisitorsIndividually,
				"Clicking on Approve/Disapprove Visitors Individually Button");*/
		Wait.waitfor(5);
		clickElement(driver, test, OCR_Button_SelectAll, "Clicking on Select All Button");
		if (OCR_WithSelectedBadgeType != null) {
		/*	String scroll = "//button[@name='Disapprove']/preceding::button[1]";
			scrollToElement(driver, scroll);*/
			clickElement(driver, test, OCR_Button_Approve, "Clicking on Approve Button");
			Wait.waitfor(7);
			//clickElement(driver, test, OCR_Button_Close, "Clicking on Close Button");
			Wait.waitfor(3);
		} else {
			selectByVisibleText(driver, test, OCR_WithSelectedBadgeType, "Selecting value from Badge type dropdown",
					WithSelectedBadgeType);
			/*String scroll = "//button[@name='Disapprove']/preceding::button[1]";
			scrollToElement(driver, scroll);*/
			clickElement(driver, test, OCR_Button_Approve, "Clicking on Approve Button");
			Wait.waitfor(5);
			//clickElement(driver, test, OCR_Button_Close, "Clicking on Close Button");
			Wait.waitfor(3);
		}
	}

	// Selecting Decision Value
	public void approverequest(String OverallDecision) {
		selectByVisibleText(driver, test, OCR_OverallDecision, "Select Decision value : ", OverallDecision);
	}

	// click on Save and Finalize Button
	public void saveandfinalize() {
		Wait.waitfor(5);
		//clickElement(driver, test, "//input[@name='certCheckbox']", "Click on Check box");
		scrollToElement(driver, OCR_Button_SaveandFinalize);
		clickElement(driver, test, OCR_Button_SaveandFinalize, "Clicking on Save and Finalize Button");
		scrollToTop(driver);
	}

	// Clicking on Backward Navigation button
	public void Movebackward() {
		clickElement(driver, test, OCR_Button_BackwardNavigation, "Clicking on Backward Navigation button");

	}

	// selecting multiple reviewers process
	public void multiplereviewersprocess(String WithSelectedBadgeType, String OverallDecision,
			String ReasonForDisapprovalOrRoR) {
		try {
			List<WebElement> noofreviewers = driver.findElements(
					By.xpath("//div[@class='row hidden ocr-info']/following::a[contains(text(),'Name')]"));
			for (int i = 0; i < noofreviewers.size(); i++) {
				clickElement(driver, test, OCR_Button_ApproveDisapproveVisitorsIndividually,
						"Clicking on Approve/Disapprove Visitors Individually Button");
				Wait.waitfor(8);
				clickElement(driver, test, OCR_Button_SelectAll, "Clicking on Select All Button");
				if (OCR_WithSelectedBadgeType != null) {
					String scroll = "//button[@name='Disapprove']/preceding::button[1]";
					scrollToElement(driver, scroll);
					clickElement(driver, test, OCR_Button_Approve, "Clicking on Approve Button");
					Wait.waitfor(8);
					clickElement(driver, test, OCR_Button_Close, "Clicking on Close Button");
					Wait.waitfor(3);

				} else {
					selectByVisibleText(driver, test, OCR_WithSelectedBadgeType,
							"Selecting value from Badge type dropdown", WithSelectedBadgeType);
					String scroll = "//button[@name='Disapprove']/preceding::button[1]";
					scrollToElement(driver, scroll);
					clickElement(driver, test, OCR_Button_Approve, "Clicking on Approve Button");
					Wait.waitfor(5);
					clickElement(driver, test, OCR_Button_Close, "Clicking on Close Button");
					Wait.waitfor(3);
				}
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_Review_close, "click on cancel");
			test.log(LogStatus.FAIL, "Click on cancel");
		}
		approverequest(OverallDecision);
		if (OverallDecision.contains("Disapproved") || OverallDecision.contains("Returned For Rework")) {
			enterdecision(ReasonForDisapprovalOrRoR);
		}
		saveandfinalize();
		Wait.waitfor(3);
	}
	
	// selecting multiple reviewers process
	public void multiplereviewersprocess1(String WithSelectedBadgeType, String OverallDecision,
			String ReasonForDisapprovalOrRoR) {
		clickElement(driver, test, OCR_Button_SelectAll, "Clicking on Select All Button");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_Button_Approve, "Clicking on Approve Button");
		Wait.waitfor(3);
		approverequest(OverallDecision);
		if (OverallDecision.contains("Disapproved") || OverallDecision.contains("Returned For Rework")) {
			enterdecision(ReasonForDisapprovalOrRoR);
		}
		saveandfinalize();
		Wait.waitfor(3);
	}

	// click on Save button
	public void visitorSubmSave() {
		clickElement(driver, test, OCR_Button_VisitorSubmSave, "click on Save");
	}

	// click on Cancel button
	public void cancel() {
		clickElement(driver, test, OCR_Button_Cancel, "click on Save");
	}

	// Entering Decison for Dispproval or Return For Rework
	public void enterdecision(String ReasonForDisapprovalOrRoR) {
		typeText(driver, test, OCR_ReasonForDisapproval_ReturnForRework,
				"Entering Decison for Dispproval or Return For Rework", ReasonForDisapprovalOrRoR);
	}

	// Validations in visitor Submission
	public void validate_VisitorSubmissionReview() {
		try {
			if (isDisplayed(driver, "//h4[contains(text(),'Error!')]")) {
				test.log(LogStatus.INFO, "Reviewer Name is required.");
				test.log(LogStatus.INFO, "Reviewer Email is required.");
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL,
					"Error Vaildation for visitor Submission is not Displayed by clicking on SAVE button");
			testFailSshot(driver, test);
		}
	}

	// Validations in visitor Submission
	public void validate_SaveAndFinalize() {
		try {
			if (isDisplayed(driver, "//h4[contains(text(),'Error!')]")) {
				if (isDisplayed(driver, "//li[text()='Decision on Visit Request is required.']")) {
					test.log(LogStatus.INFO, "Decision on Visit Request is required.");
				}
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL,
					"Error Vaildation for visitor Submission is not Displayed by clicking on SAVE button");
			testFailSshot(driver, test);
		}
	}

	// click on Approved/DisApprove visitors Individually
	public void click_ApprovedDisapprovedBtn() {
		clickElement(driver, test, OCR_Button_ApproveDisapproveVisitorsIndividually,
				"Clicking on Approve/Disapprove Visitors Individually Button");
	}

	// Validations in visitor Submission
	public void validate_VisitorAcknowledgmnt() {

		try {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_Button_SaveVisitorAck, "click on Save  button in visitor Acknowledgement");
			try {
				if (isDisplayed(driver, "//h4[contains(text(),'Error')]")) {
					if (isDisplayed(driver, "//li[text()='Select at least one from the list to save']")) {
						test.log(LogStatus.INFO, "Select at least one from the list to save");
					}
				}
			} catch (Exception e) {
				test.log(LogStatus.FAIL,
						"Error Vaildation for visitor Acknowledgement is not Displayed by clicking on SAVE button");
				testFailSshot(driver, test);
			}

			clickElement(driver, test, OCR_Button_Approve, "click on Approved button in visitor Acknowledgement");
			try {
				if (isDisplayed(driver, "//h4[contains(text(),'Error')]")) {
					if (isDisplayed(driver, "//li[text()='Select at least one from the list to approve']")) {
						test.log(LogStatus.INFO, "Select at least one from the list to approve");
					}
				}
			} catch (Exception e) {
				test.log(LogStatus.FAIL,
						"Error Vaildation for visitor Acknowledgement is not Displayed by clicking on Approved button");
				testFailSshot(driver, test);
			}

			clickElement(driver, test, OCR_Button_DisApprovedVisitorAck,
					"click on DisApproved button in visitor Acknowledgement");
			try {
				if (isDisplayed(driver, "//h4[contains(text(),'Error')]")) {
					if (isDisplayed(driver, "//li[text()='Select at least one from the list to disapprove']")) {
						test.log(LogStatus.INFO, "Select at least one from the list to DisApproved");
					}
				}
			} catch (Exception e) {
				test.log(LogStatus.FAIL,
						"Error Vaildation for visitor Acknowledgement is not Displayed by clicking on Approved button");
				testFailSshot(driver, test);
			}

			clickElement(driver, test, OCR_Button_SelectAll, "Clicking on Select All Button");
			Wait.waitfor(3);
			clickElement(driver, test, OCR_Button_Approve, "Clicking on Approve Button");
			Wait.waitfor(5);
			clickElement(driver, test, OCR_Button_Close, "Clicking on Close Button");

		} catch (Exception e) {
			test.log(LogStatus.FAIL,
					"visitor Acknowledgement is not Displayed by clicking on Approve/Disapprove Visitors button");
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_Button_Close, "click on Close button");
		}
	}

	// ADD the CheckList Security
	public void submitCheckListSecurity(String packageNameList) {
		clickElement(driver, test, OCR_Review_CheckListBtn, "Click on CheckList button");
		try {
			clickElement(driver, test, "//input[@name='radioResponse~1']", "Click on level1 screening radio button");
			typeText(driver, test, "//textarea[@name='checklistNotes']", "Enter the Remarks : ", "check list Notes");
			clickElement(driver, test, "//button[@name='finalize']", "Click on Finalize");
			Wait.wait(driver, "(//div[@id='ocrModal'])[1]");
			clickElement(driver, test, "//a//button[@name='sendRequest'][contains(text(),'Send Request')]",
					"Click on Send Request");
			selectByVisibleText(driver, test, "//select[@name='packageNameList']", "Select the package Name List : ",
					packageNameList);
			clickElement(driver, test, "//button[contains(text(),'Submit')]", "Click on Submit");
			Wait.wait(driver, "//form[@id='editIntegration']//div[@class='modal-content']");
			Wait.waitfor(3);
			clickElement(driver, test, "(//button[contains(text(),'Close')])[1]", "Click on  Close");
			Wait.wait(driver, "//form[@id='editIntegration']//div[@class='modal-content']");
			Wait.waitfor(3);
			clickElement(driver, test, "(//button[contains(text(),'Close')])[1]", "Click on  Close");
			Wait.waitfor(3);
			clickElement(driver, test, OCR_Button_ApproveDisapproveVisitorsIndividually,
					"Clicking on Approve/Disapprove Visitors Individually Button");
			Wait.waitfor(5);
			Wait.wait(driver, "//div[@class='modal-content']");
			clickElement(driver, test, OCR_Button_SelectAll, "Clicking on Select All Button");
			clickElement(driver, test, OCR_Button_Approve, "Clicking on Approve Button");
			Wait.waitfor(5);
			clickElement(driver, test, OCR_Button_Close, "Clicking on Close Button");
			Wait.waitfor(3);
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_Button_Close, "Clicking on Close Button");
			Wait.waitfor(3);
		}
	}

	// Adding the Host check list
	public void submitCheckListHost(String packageNameList, String OverallDecision) {
		clickElement(driver, test, OCR_Review_CheckListBtn, "Click on CheckList button");
		try {
			clickElement(driver, test, "//input[@id='saveFinalizeChecklist_1~1']",
					"Click on level1 screening radio button");
			clickElement(driver, test, "//input[@id='saveFinalizeChecklist_1~2']",
					"Click on level2 screening radio button");
			clickElement(driver, test, "//input[@id='saveFinalizeChecklist_1~3']",
					"Click on level3 screening radio button");
			clickElement(driver, test, "//button[@name='finalize']", "Click on Finalize");
			Wait.waitfor(5);
			clickElement(driver, test, "//a//button[@name='sendRequest'][contains(text(),'Send Request')]",
					"Click on Send Request");
			Wait.waitfor(5);
			selectByVisibleText(driver, test, "//select[@name='packageNameList']", "Select the package Name List : ",
					packageNameList);
			clickElement(driver, test, "//button[contains(text(),'Submit')]", "Click on Submit");
			Wait.wait(driver, "//form[@id='editIntegration']//div[@class='modal-content']");
			Wait.waitfor(5);
			clickElement(driver, test, "(//button[contains(text(),'Close')])[1]", "Click on  Close");
			Wait.waitfor(5);
			clickElement(driver, test, "(//button[contains(text(),'Close')])[1]", "Click on  Close");
			Wait.waitfor(5);
			clickElement(driver, test, OCR_Button_ApproveDisapproveVisitorsIndividually,
					"Clicking on Approve/Disapprove Visitors Individually Button");
			Wait.waitfor(5);
			Wait.wait(driver, "//div[@class='modal-content']");
			clickElement(driver, test, OCR_Button_SelectAll, "Clicking on Select All Button");
			clickElement(driver, test, OCR_Button_Approve, "Clicking on Approve Button");
			Wait.waitfor(5);
			clickElement(driver, test, OCR_Button_Close, "Clicking on Close Button");
			Wait.waitfor(3);
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_Button_Close, "Clicking on Close Button");
			Wait.waitfor(3);
		}
		selectByVisibleText(driver, test, OCR_OverallDecision, "Select Decision value : ", OverallDecision);
		Wait.waitfor(3);
		/*clickElement(driver, test, "//input[@id='editVmctVisitorReviewerReview_certCheckbox']",
				"Click on  Check box of Host ");*/
		clickElement(driver, test, OCR_Button_SaveandFinalize, "Clicking on Save and Finalize Button");
	}

	// ADD TDFP Certification Statement
	public void submitCheckListTDFP(String packageNameList, String OverallDecision) {
		clickElement(driver, test, OCR_Review_CheckListBtn, "Click on CheckList button");
		try {
			clickElement(driver, test, "//input[@id='2_1']", "Click on level1 screening radio button");
			clickElement(driver, test, "//button[@name='finalize']", "Click on Finalize");
			Wait.waitfor(5);
			clickElement(driver, test, "//a//button[@name='sendRequest'][contains(text(),'Send Request')]",
					"Click on Send Request");
			selectByVisibleText(driver, test, "//select[@name='packageNameList']", "Select the package Name List : ",
					packageNameList);
			clickElement(driver, test, "//button[contains(text(),'Submit')]", "Click on Submit");
			
			Wait.waitfor(5);
			Wait.wait(driver, "(//div[@id='ocrModal'])[1]");
			clickElement(driver, test, "(//button[contains(text(),'Close')])[1]", "Click on  Close");
			Wait.waitfor(7);
			clickElement(driver, test, OCR_Button_Close, "Click on  Close");
			Wait.waitfor(5);
			clickElement(driver, test, OCR_Button_ApproveDisapproveVisitorsIndividually,
					"Clicking on Approve/Disapprove Visitors Individually Button");
			Wait.waitfor(5);
			Wait.wait(driver, "//div[@class='modal-content']");
			clickElement(driver, test, OCR_Button_SelectAll, "Clicking on Select All Button");
			clickElement(driver, test, OCR_Button_Approve, "Clicking on Approve Button");
			Wait.waitfor(5);
			clickElement(driver, test, OCR_Button_Close, "Clicking on Close Button");
			Wait.waitfor(5);
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_Button_Close, "Clicking on Close Button");
			Wait.waitfor(3);
		}
		selectByVisibleText(driver, test, OCR_OverallDecision, "Select Decision value : ", OverallDecision);
		/*clickElement(driver, test, "//input[@id='editVmctVisitorReviewerReview_certCheckbox']",
				"Click on  Check box of Host ");*/
		clickElement(driver, test, OCR_Button_SaveandFinalize, "Clicking on Save and Finalize Button");
	}
	
	//ADD the Export Reviewer Certification Statement
	public void submitCheckListExportReviewer(String packageNameList, String OverallDecision) {
		clickElement(driver, test, OCR_Review_CheckListBtn, "Click on CheckList button");
		try {
			clickElement(driver, test, "//input[@id='saveFinalizeChecklist_3~1']",
					"Click on level1 screening radio button");
			clickElement(driver, test, "//input[@id='saveFinalizeChecklist_3~2']",
					"Click on level2 screening radio button");
			clickElement(driver, test, "//button[@name='finalize']", "Click on Finalize");
			Wait.waitfor(5);
			clickElement(driver, test, "//a//button[@name='sendRequest'][contains(text(),'Send Request')]",
					"Click on Send Request");
			selectByVisibleText(driver, test, "//select[@name='packageNameList']", "Select the package Name List : ",
					packageNameList);
			clickElement(driver, test, "//button[contains(text(),'Submit')]", "Click on Submit");
			Wait.wait(driver, "//form[@id='editIntegration']//div[@class='modal-content']");
			Wait.waitfor(3);
			clickElement(driver, test, "(//button[contains(text(),'Close')])[1]", "Click on  Close");
			Wait.waitfor(5);
			clickElement(driver, test, "(//button[contains(text(),'Close')])[1]", "Click on  Close");
			Wait.waitfor(3);
			clickElement(driver, test, OCR_Button_ApproveDisapproveVisitorsIndividually,
					"Clicking on Approve/Disapprove Visitors Individually Button");
			Wait.waitfor(5);
			Wait.wait(driver, "//div[@class='modal-content']");
			clickElement(driver, test, OCR_Button_SelectAll, "Clicking on Select All Button");
			clickElement(driver, test, OCR_Button_Approve, "Clicking on Approve Button");
			Wait.waitfor(5);
			clickElement(driver, test, OCR_Button_Close, "Clicking on Close Button");
			Wait.waitfor(3);
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_Button_Close, "Clicking on Close Button");
			Wait.waitfor(3);
		}
		selectByVisibleText(driver, test, OCR_OverallDecision, "Select Decision value : ", OverallDecision);
		/*clickElement(driver, test, "//input[@id='editVmctVisitorReviewerReview_certCheckbox']",
				"Click on  Check box of Host ");*/
		clickElement(driver, test, OCR_Button_SaveandFinalize, "Clicking on Save and Finalize Button");
	}
	
	// ADD the CheckList Security
		public void submitCheckListMultiSecurity(String packageNameList) {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", driver.findElement(By.xpath(OCR_Button_ForwardNavigation)));
			Wait.waitfor(5);
			clickElement(driver, test, OCR_Review_CheckListBtn, "Click on CheckList button");
			try {
				//clickElement(driver, test, "//input[@id='1_1']']", "Click on dev 1 radio button");
				Wait.waitfor(3);
				typeText(driver, test, "//textarea[@id='saveFinalizeChecklist_checklistNotes']", "Type text", "Text");
				Wait.waitfor(3);
				clickElement(driver, test, "(//button[@name='Save'])[2]", "Click on save button");
				Wait.waitfor(3);
				clickElement(driver, test, "//button[@name='finalize']", "Click on Finalize");
				Wait.waitfor(5);
				//clickElement(driver, test, "//button[@id='sendRequest']", "Click on Send Request");
				Wait.waitfor(5);
				clickElement(driver, test, "(//button[@class='close'])[1]", "Click on  Close");
				Wait.waitfor(5);
				/*clickElement(driver, test, "(//button[contains(text(),'Close')])[1]", "Click on  Close");
				Wait.waitfor(3);
				clickElement(driver, test, OCR_Button_ApproveDisapproveVisitorsIndividually,
						"Clicking on Approve/Disapprove Visitors Individually Button");
				Wait.waitfor(5);
				Wait.wait(driver, "//div[@class='modal-content']");*/
				clickElement(driver, test, OCR_Button_SelectAll, "Clicking on Select All Button");
				clickElement(driver, test, OCR_Button_Approve, "Clicking on Approve Button");
				Wait.waitfor(5);
				//clickElement(driver, test, OCR_Button_Close, "Clicking on Close Button");
				
			} catch (Exception e) {
				testFailSshot(driver, test);
				clickElement(driver, test, OCR_Button_Close, "Clicking on Close Button");
				Wait.waitfor(3);
			}
		}

	// Validating the Certification Statement
	public void validateCertificationStatementCheckBox() {
		try {
			if (isDisplayed(driver, "//input[@id='editVmctVisitorReviewerReview_certCheckbox']")) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Certification Statement Check box is Enable");
			}
		} catch (Exception e) {
			test.log(LogStatus.INFO, "Certification Statement Check box is Disable");
		}
	}
}
