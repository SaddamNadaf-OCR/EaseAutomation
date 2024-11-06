package importOperationClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;
import utilities.Wait;

public class EntrySummarySubmitforReviewPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_SubmitForReview_Approved = "//button[contains(text(),'Approve')]";
	public static final String OCR_SubmitForReview_DeclarationIcon = "//i[@class='fa fa-certificate']";
	public static final String OCR_SubmitForReview_triangleIcon = "//i[@class='fa fa-exclamation-triangle']";
	public static final String OCR_SubmitForReview_AgentRBtn = "//input[@id='certificationDeclarationPopup_US-ETRY-001US-ETRY-001-001']";
	public static final String OCR_SubmitForReview_MerchandiseRtn = "//input[@id='certificationDeclarationPopup_US-ETRY-002US-ETRY-002-001']";
	public static final String OCR_SubmitForReview_FlagBtn = "//input[@id='certificationDeclarationPopup_declarationFlag']";
	public static final String OCR_SubmitForReview_SaveAndReturn = "//button[contains(text(),'Save & Return')]";
	public static final String OCR_SubmitForReview_CustomResponseTab = "//a[contains(text(),'Custom Response')]";
	public static final String OCR_SubmitForReview_CustomFilingStatus = "(//div[@class='col-4 col-form-label'])[2]//b";
	public static final String OCR_SubmitForReview_PopUpClose = "//button[@class='btn-close']";
	public static final String OCR_SubmitForReview_CancleBtn = "//button[@id='cancelb']";

	/* ******************** Constructor ***************************** */
	public EntrySummarySubmitforReviewPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	// Click on Approved
	public void clickApproved() {
		clickElement(driver, test, OCR_SubmitForReview_Approved, "Click on Approved");
	}

	// Fill Declaration
	public void fillDeclaration() {
		clickElement(driver, test, OCR_SubmitForReview_DeclarationIcon, "Click on Declaration Icon");
		try {
			clickElement(driver, test, OCR_SubmitForReview_AgentRBtn,
					"Select the Entry Declaration - Importer / Agent");
			clickElement(driver, test, OCR_SubmitForReview_MerchandiseRtn,
					"Select the Entry Declaration - Merchandise Value ");
			clickElement(driver, test, OCR_SubmitForReview_FlagBtn,
					"Select the Use Current User Details and Current Date");
			clickElement(driver, test, OCR_SubmitForReview_SaveAndReturn, "Click on Save And Return");
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_SubmitForReview_CancleBtn, "Click on Cancle button");
		}
		Wait.waitfor(3);
	}

	// Get the Custom Filing Status
	public String getCustomFilingStatus() {
		clickElement(driver, test, OCR_SubmitForReview_triangleIcon, "Click on Triangle Icon");
		try {
			clickElement(driver, test, OCR_SubmitForReview_CustomResponseTab, "Click on Custom Response Tab");
			String customFilingStatus = getText(driver, test, OCR_SubmitForReview_CustomFilingStatus, "Get the Custom Filing Status : ");
			return customFilingStatus;
		} catch (Exception e) {
			testFailSshot(driver, test);
			clickElement(driver, test, OCR_SubmitForReview_PopUpClose, "Click on Pop Up Close button");
		}
		Wait.waitfor(3);
		return null;
		
	}

}
