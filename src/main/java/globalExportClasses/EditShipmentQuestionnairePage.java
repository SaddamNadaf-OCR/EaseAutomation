package globalExportClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class EditShipmentQuestionnairePage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_Shipment_Ques_NotApplicable = "//input[@name='notApplicable']";
	public static final String OCR_Shipment_Ques_Save = "//form[@id='editShipment']//button[3]";
	public static final String OCR_Shipment_Ques_SaveAndReturn = "//button[@id='saveandreturn']";

	/* ******************************* Constructor ****************************** */

	public EditShipmentQuestionnairePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	// Click on Not appliacable check box
	public void click_NotApplicable() {
		clickElement(driver, test, "//span[@class='heading-additional']", "");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_Shipment_Ques_NotApplicable, "Click on Not appliacable check box");
	}

	// Click on Save
	public void click_save() {
		clickElement(driver, test, "//span[@class='heading-additional']", "");
		Wait.waitfor(3);
		clickElement(driver, test, OCR_Shipment_Ques_Save, "Click on Save button in Questionnaire");
	}

	// click on Save and Return
	public void click_SaveAndReturn() {
		clickElement(driver, test, OCR_Shipment_Ques_SaveAndReturn, "Click on Save and Return button in Questionnaire");
	}
	
	//validating Questionnaire
	public void validateQuestionnaire() {
		try {
			if (isDisplayed(driver, "//h4[contains(text(),'Error!')]")) {
				if (isDisplayed(driver, "//span[contains(text(),'Question:1 - Please select one of the options.')]")) {
					test.log(LogStatus.INFO, " Question:1 - Please select one of the options.");
				}
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL,
					"Error Vaildation is not Displayed by clicking on SAVE button in Questionnaire");
		}
		
	}

}
