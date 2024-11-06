package productClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class ResultProductNotesPage extends GenericMethods{
	
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_Button_AddNote = "//button[contains(text(),'Add Note')]";
	
			
	/* ******************** Constructor ***************************** */
	public ResultProductNotesPage(WebDriver driver, ExtentTest test) { 
		this.driver = driver;
		this.test = test;
	}
	 
	public void addnote() {
		clickElement(driver, test, OCR_Button_AddNote, "Clicking on Add Note Button");
	}
	
	public void movetoimagestab() {
		clickElement(driver, test, "//a[@id='tab9']", "Clicking on Image Tab");
	}

}
