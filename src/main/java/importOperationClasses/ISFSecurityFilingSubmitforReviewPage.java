package importOperationClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;

public class ISFSecurityFilingSubmitforReviewPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_ISFSecurityFilingSubmitforReview_ApproveBtn = "//button[@id='approveISF']";
	public static final String OCR_ISFSecurityFilingSubmitforReview_SubmitForReviewBtn = "//button[@id='submitReview']";
	public static final String OCR_ISFSecurityFilingSubmitforReview_Name = "//select[@id='editIsfSubmission_importReviewerId']";
	public static final String OCR_ISFSecurityFilingSubmitforReview_ClickAlertIcon = "//i[@class='fa fa-exclamation-triangle']";
	public static final String OCR_ISFSecurityFilingSubmitforReview_ClickCustomResponseTab = "//a[contains(text(),'Custom Response')]";
	public static final String OCR_ISFSecurityFilingSubmitforReview_CancelBtn = "//button[@id='cancelISF']";
	public static final String OCR_ISFSecurityFilingSubmitforReview_ClosePopUpBtn = "//button[@class='close']";
	public static final String OCR_ISFSecurityFilingSubmitforReview_PhoneNo = "//input[@id='editIsfSubmission_importIsf10DetailsValue_importReviewerPhone']";
	public static final String OCR_ISFSecurityFilingSubmitforReview_Comments = "//textarea[@id='editIsfSubmission_importReviewerComments']";
	public static final String OCR_ISFSecurityFilingSubmitforReview_ValidationStatusError = "//li[contains(text(),'No Validation Errors')]";
	public static final String OCR_ISFSecurityFilingSubmitforReview_FilingStatus = "//b[contains(text(),'Filing Status :')]/../../div[2]/font/b"; 
	public static final String OCR_ISFSecurityFilingSubmitforReview_DateAndTime = "(//table[@class='table table-condensed table-bordered']//tr[2]/td[5])[1]";
	public static final String OCR_ISFSecurityFilingSubmitforReview_ISFDeatilsTab = "//button[contains(text(),'Security Filing (ISF) Details')]";
	
	/* ******************** Constructor ***************************** */
	public ISFSecurityFilingSubmitforReviewPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */
	
	//Add Import Coordinator
	public void addImportCoordinator(String Name, String PhoneNo, String Comments) {
		selectByVisibleText(driver, test, OCR_ISFSecurityFilingSubmitforReview_Name, "Add Import Coordinator Name: ", Name);
		typeText(driver, test, OCR_ISFSecurityFilingSubmitforReview_PhoneNo, "Add Phone No.", PhoneNo);
		typeText(driver, test, OCR_ISFSecurityFilingSubmitforReview_Comments, "Add Comments: ", Comments);
	}
	
	//Click on Approve
	public void clickApprove() {
		clickElement(driver, test, OCR_ISFSecurityFilingSubmitforReview_ApproveBtn, "Click on Approve Button");
	}
	
	//Click on ISF Details Tab
	public void clickISFDeatils() {
		clickElement(driver, test, OCR_ISFSecurityFilingSubmitforReview_ISFDeatilsTab, "Click on ISF Deatils Tab");
	}
	
	//Click on Alert Icon
	public void clickAlert() {
		clickElement(driver, test, OCR_ISFSecurityFilingSubmitforReview_ClickAlertIcon, "Click on Alert Icon");
	}
	
	//Click on Close Alert Icon
	public void closeAlet() {
		clickElement(driver, test, OCR_ISFSecurityFilingSubmitforReview_ClosePopUpBtn, "Click on Close Alert Icon");
	}
	
	//Click on Custom Response Tab
	public void clickCustomResonsetab() {
		clickElement(driver, test, OCR_ISFSecurityFilingSubmitforReview_ClickCustomResponseTab, "Click on Custom Response Tab");
	}
	
	//Check Screening Status
	public void validationCheck() {
		try {
			if (isDisplayed(driver,
					OCR_ISFSecurityFilingSubmitforReview_ValidationStatusError)) {
				test.log(LogStatus.INFO, "Success No Validation Errors");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Error is Displayed by clicking on Alert Icon for ISF");
			closeAlet();
		}
	}
	
	//Custom Response 
	public void getCustomResponse() {
		try {
		 getText(driver, test, OCR_ISFSecurityFilingSubmitforReview_FilingStatus, "Get Customs Filing Status : ");
		 getText(driver, test, OCR_ISFSecurityFilingSubmitforReview_DateAndTime, "Get Response Date And Time : ");
		 clickElement(driver, test,OCR_ISFSecurityFilingSubmitforReview_ClosePopUpBtn , "Close Alert Icon");
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test,OCR_ISFSecurityFilingSubmitforReview_ClosePopUpBtn, "Close Alert Icon");
		}
	}
}
