package tablesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class CreateConfidenceLevelPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;
	
//--------------------------Locators----------------------------------------------//
	
	public static final String OCR_ConfidenceLevel = "//input[@name='confidenceLevel.levelCode']";
	public static final String OCR_Name = "//input[@name='confidenceLevel.levelName']";
	public static final String OCR_Save = "//button[@name='save']";
	public static final String OCR_SaveandReturn = "//button[@name='ok']";
	
// -------------------------------------------Constructor-----------------------------------------//

	public CreateConfidenceLevelPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		}
// --------------------------Confidence Level----------------------//
	public void enter_ConfidenceLevel(String ConfidenceLevel, String Name) {
		Wait.waitfor(3);
		typeText(driver, test, OCR_ConfidenceLevel, "Enter ConfidenceLevel :",ConfidenceLevel);
		typeText(driver, test, OCR_Name, "enter Name", Name);
		

			}

// --------------------------------Save--------------------------------------------//

	public void save() {
		scrollToElement(driver, OCR_Save);
		Wait.waitfor(3);
		scrollToTop(driver);
		clickElement(driver, test, OCR_Save, "Click on Save Button ");
	}
// -------------------------------------SaveandReturn---------------------//

	public void saveandReturn() {
		scrollToElement(driver, OCR_SaveandReturn);
		Wait.waitfor(3);
		scrollToTop(driver);
		clickElement(driver, test, OCR_SaveandReturn, "Click on Save Button ");
	}


}
