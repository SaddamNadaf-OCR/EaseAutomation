//Added By Nancy---------------------------
package vmsClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class VisitorRequestNotesPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/*-------------------------------------------Locators-------------------------------------*/

	public static final String OCR_Button_AddNotes = "//button[contains(text(),'Add Notes')]";
	public static final String OCR_Button_NotesDescription = "//textarea[@id='editVisitorNotes_visitorNotesValue_secureNotes']";
	public static final String OCR_Button_SaveandReturn = "//button[contains(text(),'Save & Return')]";
	public static final String OCR_NotesTypeLink = "//a[contains(text(),'General')]";
	public static final String OCR_Button_ForwardNavigation = "//button[@id='next-btn-upper']";
	public static final String OCR_Button_Save = "//button[contains(text(),'Save')]";

	/*--------------------------------Constructor------------------------------------------*/
	public VisitorRequestNotesPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/*-------------------------------------------Actions-------------------------------------*/

	// click on Add note
	public void click_AddNoteBtn() {
		clickElement(driver, test, OCR_Button_AddNotes, "Clicking on Add Notes Button");
	}

	// Add Notes and Verify Notes type column is showing 'General' or not in the
	// result grid
	public void add_notes(String Notes) {
		typeText(driver, test, OCR_Button_NotesDescription, "Enter Notes Description : ", Notes);
		clickElement(driver, test, OCR_Button_SaveandReturn, "Clicking on Save and Return Button");
		Wait.waitfor(5);
		try {
			if (driver.findElement(By.xpath(OCR_NotesTypeLink)).isDisplayed()) {
				test.log(LogStatus.PASS, "Notes type column is showing 'General' in the result grid ");
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Notes type column is not showing 'General' in the result grid ");
		}
	}

	// Verify Add Notes button is enable or not when request is approved
	public void Enable_AddNotes() {
		if (isEnabled(driver, "//button[contains(text(), 'Add Notes')]")) {
			Wait.waitfor(3);
			test.log(LogStatus.PASS, "Add Notes button is enable when request is approved");
		} else {
			test.log(LogStatus.FAIL, "Add Notes button is disble when request is approved");
		}
	}

	// click on Save
	public void click_save() {
		clickElement(driver, test, OCR_Button_Save, "Click on Note Save button");
	}

	// validate NOTES
	public void validate_Notes() {
		try {
			if (isDisplayed(driver, "//h4[contains(text(),'Error!')]")) {
				if (isDisplayed(driver, "//li[text()='Secure notes is a required field']")) {
					test.log(LogStatus.INFO, "Secure notes is a required field");
				}
			}
		} catch (Exception e) {
			test.log(LogStatus.FAIL,
					"Error Vaildation for ADD Notes is not Displayed by clicking on SAVE & Return button");

		}
	}

	// click on Forward navigation button
	public void movetonextpage() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_Button_ForwardNavigation, "Clicking on Forward Navigation Button");
	}

}
