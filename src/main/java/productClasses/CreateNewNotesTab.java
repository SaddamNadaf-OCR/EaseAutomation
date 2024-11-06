package productClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;

public class CreateNewNotesTab extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_Notes = "//textarea[@id='editProductNotes_productNotesValue_remarks']";
	public static final String OCR_Button_Save = "//button[@name='save.x']";
	public static final String OCR_Button_SavendReturn = "//button[@name='Ok']";

	/* ******************** Constructor ***************************** */
	public CreateNewNotesTab(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	public void enter_notes(String Notes) {
		typeText(driver, test, OCR_Notes, "Enter Notes", Notes);

	}

	public void save() {
		clickElement(driver, test, OCR_Button_Save, "Clicking on Save Button");
	}

	public void savendreturn() {
		clickElement(driver, test, OCR_Button_SavendReturn, "Clicking on Save and Return Button");
	}

	// Validate Notes Tab
	public void validate_noteerror() {
		try {
			if (isDisplayed(driver, "//h4[contains(text(),'Error')]")) {
				if (isDisplayed(driver, "//li[contains(text(),'Notes is a required field')]")) {
					test.log(LogStatus.INFO, "Notes is a required field");
				}
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Error Validation is not Displayed by clicking on SAVE button in Notes Page");
		}
	}
}
