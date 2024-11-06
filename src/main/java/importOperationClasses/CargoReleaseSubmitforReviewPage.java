package importOperationClasses;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class CargoReleaseSubmitforReviewPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_Submit_ClickApprove = "//button[@id='approveSE']";
	public static final String OCR_Submit_ClickSubmitForReview = "//button[@id='submitReview']";
	public static final String OCR_Submit_Cancel = "//button[@id='cancelSE']";
	public static final String OCR_Submit_Name = "//select[@id='editSeSubmission_importReviewerId']";
	public static final String OCR_Submit_GotoCRDetailsTab = "//a[@class='simplifiedEntryDetails']";
	public static final String OCR_Submit_ClickAlertIcon = "//i[@class='fa fa-exclamation-triangle']";
	public static final String OCR_Submit_ClickAlertPopupClose = "//button[@class='close']";
	public static final String OCR_Submit_DataStatus = "//label[contains(text(),'Data Screening Status:')]/../div[2]/font";
	public static final String OCR_Submit_ClosePopUp = "//button[@class='close']";
	public static final String OCR_Submit_CustomResponseTab = "//body/div[@id='content-cont']/div[2]/div[1]/form[1]/div[2]/div[1]/div[1]/div[2]/ul[1]/li[2]/a[1]";
	public static final String OCR_Submit_CustomFilingStatus = "//label[contains(text(),'Customs Filing Status:')]/../div[2]/font";

	/* ******************** Constructor ***************************** */
	public CargoReleaseSubmitforReviewPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	// Select Import Coordinator Name
	public void addName(String Name) {
		selectByVisibleText(driver, test, OCR_Submit_Name, "Select Name : ", Name);
	}

	// Click on Approve Button
	public void clickApprove() {
		Wait.waitfor(10);
		clickElement(driver, test, OCR_Submit_ClickApprove, "Click on Approve Button");
	}

	// Click on Submit for Review
	public void clickSubmitForReview() {
		clickElement(driver, test, OCR_Submit_ClickSubmitForReview, "Click on Submit for Review");
	}

	// Click on Cancel Button
	public void clickOnCancel() {
		clickElement(driver, test, OCR_Submit_Cancel, "Click on Cancel Button");
	}

	// Click on Cargo Release Details Tab
	public void clickCReleaseDetailsTab() {
		clickElement(driver, test, OCR_Submit_GotoCRDetailsTab, "Click on Cargo Release Details Tab");
	}

	// Click on Alert Icon
	public void alertIcon() {
		Wait.waitfor(20);
		clickElement(driver, test, OCR_Submit_ClickAlertIcon, "Click on alert icon");
	}

	// Click on Alert Popup Close
	public void alertClose() {
		Wait.waitfor(5);
		clickElement(driver, test, OCR_Submit_ClickAlertPopupClose, "Click Alert Popup Close");
	}

	// Click on Custom Response Tab
	public void customResponseTab() {
		clickElement(driver, test, OCR_Submit_CustomResponseTab, "Click on custom Response tab");
	}

	// Check data Screening status
	public void getDataScrenningAndApprove() {
		String datascreening = getText(driver, test, OCR_Submit_DataStatus, "Get Data Screening Status : ");
		try {
			if (datascreening.equalsIgnoreCase("Passed")) {
				clickElement(driver, test, OCR_Submit_ClickAlertPopupClose, "Close Validation Alert PopUp");
				clickApprove();
			}
		} catch (Exception e) {
			test.log(LogStatus.INFO, "Screening Staus fail");
			testFailSshot(driver, test);
			Assert.assertTrue(false);
		}
	}

	// Check Custom Response
	public void getCustomResponse() {
		String customresponse = getText(driver, test, OCR_Submit_CustomFilingStatus, "Get Customs Filing Status: ");
		try {
			if (customresponse.equalsIgnoreCase("Passed")) {
				clickElement(driver, test, OCR_Submit_ClickAlertPopupClose, "Close Validation Alert PopUp");
			}
		} catch (Exception e) {
			test.log(LogStatus.INFO, "Customs Filing Status: Rejected/Pending Customs Response");
			testFailSshot(driver, test);
			Assert.assertTrue(false);
		}
	}

}
