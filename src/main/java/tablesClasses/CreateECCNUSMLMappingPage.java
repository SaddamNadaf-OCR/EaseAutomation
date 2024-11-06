package tablesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class CreateECCNUSMLMappingPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;
	
//------------------------------------------Locators-----------------------------------------------------------------//
	
	public static final String OCR_USML = "//input[@name='eccnUsmlMapping.usml']";
	public static final String OCR_ECCN = "//input[@name='eccnUsmlMapping.eccn']";
	public static final String OCR_Save = "//input[@name='save']";
	public static final String OCR_SaveandReturn = "//input[@name='ok']";
	
// -------------------------------------------Constructor-----------------------------------------//

	public CreateECCNUSMLMappingPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

//--------------------------Code------------------------------------------------//
	public void enter_ECCNCode(String USML, String ECCN) {
		Wait.waitfor(3);
		typeText(driver, test, OCR_USML, "Enter USML :",USML);
		typeText(driver, test, OCR_ECCN, "enter ECCN", ECCN);

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
