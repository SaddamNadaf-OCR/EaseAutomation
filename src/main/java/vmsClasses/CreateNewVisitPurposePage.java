package vmsClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;

public class CreateNewVisitPurposePage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_CNVP_SBUcode = "//select[@name='visitorVisitPurpose.sbuCode']";
	public static final String OCR_CNVP_PurposeID = "//input[@id='editVisitorVisitPurpose_visitorVisitPurpose_purposeId']";
	public static final String OCR_CNVP_PurposeDescription = "//input[@id='editVisitorVisitPurpose_visitorVisitPurpose_purposeDescription']";
	public static final String OCR_CNVP_DetailedDescription = "//textarea[@id='editVisitorVisitPurpose_visitorVisitPurpose_detailedDescription']";
	public static final String OCR_CNVP_SaveAndReturn = "//button[contains(text(),'Save & Return')]";

	/* ******************** Constructor ***************************** */

	public CreateNewVisitPurposePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	// Click on Add Visit Purpose
	public void clickAddVisitPurpose(String SBUcode, String PurposeID, String PurposeDescription,
			String DetailedDescription) {
		selectByVisibleText(driver, test, OCR_CNVP_SBUcode, "Select the SBU Code : ", SBUcode);
		typeText(driver, test, OCR_CNVP_PurposeID, "Enter the Purpose ID : ", PurposeID + randomnumbers());
		typeText(driver, test, OCR_CNVP_PurposeDescription, "Enter the Purpose Description : ", PurposeDescription);
		typeText(driver, test, OCR_CNVP_DetailedDescription, "Enter the Detailed Description : ", DetailedDescription);
	}

	// Click on Save and Return
	public void clickSaveAndReturn() {
		clickElement(driver, test, OCR_CNVP_SaveAndReturn, "Click on Save and Return");
	}

}
