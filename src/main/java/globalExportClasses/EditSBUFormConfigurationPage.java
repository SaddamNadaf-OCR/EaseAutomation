package globalExportClasses;
/* 
 * Module : Export Operation
 * Author  : Saddam
 * created date : July 2024
 * Descriptions : Edit SBU Form Configuration Page
 * changed by : Nil
 * changed date : Nil
 * Purpose of change : Nil 
 * Reviewed by : Nil 
 */
import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;

public class EditSBUFormConfigurationPage extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_EditSBUConfi_SaveButton = "(//button[contains(text(),'Save')])[1]";
	public static final String OCR_EditSBUConfi_SaveandReturnButton = "(//button[contains(text(),'Save')])[2]";
	public static final String OCR_EditSBUConfi_CancelButton = "(//button[contains(text(),'Cancel')])[1]";
	public static final String OCR_EditSBUConfi_ParameterValue = "//textarea[@id='editSbuConf_sbuConf_sbuConfValue']";
	public static final String OCR_EditSBUConfi_Heading = "//h3[@class='page-heading']";

	/* ******************************* Constructor ****************************** */

	public EditSBUFormConfigurationPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */
	
	//CLick on Save Button
	public void saveButton() {
		clickElement(driver, test, OCR_EditSBUConfi_SaveButton, "Clicking on Save Button :");
	}
	
	//Click on Save and Return Button
	public void saveandReturn() {
		clickElement(driver, test, OCR_EditSBUConfi_SaveandReturnButton, "Clicking on Save and Return Button :");
	}
	
	//Click on Cancel Button
	public void cancelButton() {
		clickElement(driver, test, OCR_EditSBUConfi_CancelButton, "Clicking on Cancel Button :");
	}
	
	//Enter Parameter value
	public void parameterValue(String ParameterValue) {
		clearText(driver, test, OCR_EditSBUConfi_ParameterValue, "Clearing the Text :");
		typeText(driver, test, OCR_EditSBUConfi_ParameterValue, "Entering Parameter value :", ParameterValue);
	}
	
	//Validate Page Heading
	public void pageHeading() {
		try {
			if(isDisplayed(driver, OCR_EditSBUConfi_Heading)) {
				test.log(LogStatus.PASS, "Page Heading is Displayed :");
			}
		}catch(Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Page Heading is Not Displayed :");
		}
	}
}
