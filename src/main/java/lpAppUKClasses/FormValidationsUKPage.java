package lpAppUKClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class FormValidationsUKPage extends GenericMethods{

	public WebDriver driver;
	public ExtentTest test;

	/************************************Locator*****************************/
	public static final String OCR_FormValidationTab = "//i[@id='VAL']";
	public static final String OCR_FormValidationSection_Decription="//a[contains(text(),'Are the goods going to be shipped on a through air')]";
	public static final String OCR_FormValidationSection_SaveBtn="//button[@id='submitAppl']";

	/********************Constructor***************/

	public FormValidationsUKPage(WebDriver driver, ExtentTest test) {
		this.driver= driver;
		this.test =test;

	}

	public void clickOnFormValidationsTab() {
		clickElement(driver, test, OCR_FormValidationTab, "Click on Form Validation Tab");
	}

	public void clickOnDescriptionLink() {
		clickElement(driver, test, OCR_FormValidationSection_Decription, "Click on Description Link");
	}

	// validations in Form Validation Tab
	public void validateFormValidationError() {
		try {
			Wait.waitfor(3);
			clickElement(driver, test, OCR_FormValidationSection_SaveBtn, "Click on Save Button");
			Wait.waitfor(3);
			if (isDisplayed(driver, "//h4[contains(text(),'Error')]")) {
				if (isDisplayed(driver, "//span[text()='Please select Yes or No.']")) {
					test.log(LogStatus.INFO, "Please select Yes or No");
				}
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Errors is not Displayed by clicking on SAVE button for status: Approved");
		}
	}

}
