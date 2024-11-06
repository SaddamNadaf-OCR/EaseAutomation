package globalExportClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;

public class DeclarationDetailsNotesPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_Customs_DDNotes_Note = "//textarea[@id='notes']" ;
	public static final String OCR_Customs_DDNotes_Save = "//button[@id='saveDecTabForm']";

	/* ******************************* Constructor ****************************** */

	public DeclarationDetailsNotesPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */
	
	//Add the notes 
	public void addNotes(String DDNotes) {
		typeText(driver, test, OCR_Customs_DDNotes_Note, "Enter the notes : ", DDNotes);
		clickElement(driver, test, OCR_Customs_DDNotes_Save, "Click on Save button");
	}

}
