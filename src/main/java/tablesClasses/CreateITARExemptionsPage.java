package tablesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class CreateITARExemptionsPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;
	
//------------------------------------------Locators-----------------------------------------------------------------//
	
	public static final String OCR_Country = "//input[@id='editItarExemption_']";
	public static final String OCR_Activity = "//select[@name='itarExemption.activityType']";
	public static final String OCR_Authorization = "//input[@name='itarExemption.itarExemptionNo']";
	public static final String OCR_Description = "//textarea[@name='itarExemption.description']";
	public static final String OCR_TransactionType = "//select[@name='itarExemption.temporaryType']";
	public static final String OCR_Save = "//button[@name='save']";
	public static final String OCR_SaveandReturn = "//button[@name='okx']";
	
// -------------------------------------------Constructor-----------------------------------------//

	public CreateITARExemptionsPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

//--------------------------Code------------------------------------------------//
	public void enter_ITARCode(String Country, String Activity, String Authorization, String Description, String TransactionType) {
		Wait.waitfor(3);
		typeText(driver, test, OCR_Country, "Enter Country :",Country);
		selectByVisibleText(driver, test, OCR_Activity, "selecting Activity by dropdown :", Activity );
		typeText(driver, test, OCR_Authorization, "Enter Authorization :", Authorization);
		typeText(driver, test, OCR_Description, "Enter Description :", Description);
		selectByVisibleText(driver, test, OCR_TransactionType, "selecting TransactionType by dropdown :", TransactionType );
				

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
