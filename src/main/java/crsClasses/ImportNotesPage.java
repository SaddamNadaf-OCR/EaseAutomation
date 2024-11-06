package crsClasses;


import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class ImportNotesPage extends GenericMethods{
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_Notes_Save = "//input[@name='save']";
	public static final String OCR_Notes_SaveAndReturn = "//input[@name='ok.x']";
	public static final String OCR_Notes_SecureNote = "//textarea[@id='editExportNotes_exportNotes_secureNotes']";
	public static final String OCR_Notes_AcessLevel_Public = "//input[@id='editExportNotes_exportNotes_categoryP']";
	public static final String OCR_Notes_AcessLevel_Group = "//input[@id='editExportNotes_exportNotes_categoryG']";
	public static final String OCR_Notes_AcessLevel_Private = "//input[@id='editExportNotes_exportNotes_categoryR']";
	public static final String OCR_Notes_CancleBtn = "//input[@name='cancel.x']";

	/* ******************** Constructor ***************************** */

	public ImportNotesPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************** Actions ********************************* */

	//Click on Save notes button
	public void click_SaveBtn() {
		clickElement(driver, test, OCR_Notes_Save, "Click on Notes SAVE button");
	}

	//Click on Save and Return button
	public void click_SaveAndReturn() {
		clickElement(driver, test, OCR_Notes_SaveAndReturn, "Click on Save and Return button");
	}

	//Enter the secure notes and select the Access level
	public void add_SecureNote(String SecureNote,String AccessLevelNote) {
		typeText(driver, test, OCR_Notes_SecureNote, "Enter the secure Notes : ", SecureNote);
		if(AccessLevelNote.equalsIgnoreCase("public")) {
			if(isSelected(driver, OCR_Notes_AcessLevel_Public)) {
				test.log(LogStatus.PASS, "Access level is selected : "+AccessLevelNote);
			}else {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Access level is not selected : "+AccessLevelNote);
			}			
		}else if(AccessLevelNote.equalsIgnoreCase("Group")) {
			clickElement(driver, test, OCR_Notes_AcessLevel_Group, "Access level is selected : "+AccessLevelNote);
		}else if(AccessLevelNote.equalsIgnoreCase("Private")) {
			clickElement(driver, test, OCR_Notes_AcessLevel_Private, "Access level is selected : "+AccessLevelNote);
		}
	}

	//Add Note is Added to the Result grid or not
	public void addNoteToResultsGrid(String SecureNote) {
		Wait.waitfor(3);		
		String addNote = "//table[@id='gridNote']/tbody/tr/td[contains(text(),'"+SecureNote+"')]";	
		try {
			if(isDisplayed(driver, addNote)) {
				test.log(LogStatus.PASS, "Add Note in add to result grid table : "+SecureNote);
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Fail to Add Note in result grid table : "+SecureNote);
		}
	}

	//Error message in Notes
	public void validationNotes() {
		try {
			if (isDisplayed(driver,"//h4[contains(text(),'Error')]")) {				

				if (isDisplayed(driver,"//li[contains(text(),'Secure notes is a required field')]")) {
					test.log(LogStatus.INFO, "Secure notes is a required field");
				}								
			}
		} catch (Exception e) {
			testFailSshot(driver, test);
			test.log(LogStatus.FAIL, "Error Vaildation is not Displayed by clicking on SAVE & Return button in Notes");					
		}
	}

	//Click on Cancle button
	public void click_CancleNotesBtn() {
		clickElement(driver, test, OCR_Notes_CancleBtn, "Click on Cancle button in Notes");
	}

}
