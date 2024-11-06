package tablesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class CreateAESDirectInvalidHTSCodesPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;
	
//----------------------------------Locators------------------------------------------------------------------//
	
	public static final String OCR_HTSNumber = "//input[@id='editAesInvalidHts_aesInvalidHts_htsNo']";
	public static final String OCR_Descriptions = "//textarea[@id='editAesInvalidHts_aesInvalidHts_htsDesc']";
	public static final String OCR_Save = "//button[contains(text(),'Save')][1]";
	public static final String OCR_SaveandReturn = "//button[contains(text(),'Save & Return')]";
	
// -------------------------------------------Constructor-----------------------------------------//

	public CreateAESDirectInvalidHTSCodesPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
// --------------------------HTS Code----------------------//
	public void enter_HTSNo(String HTSNo, String Descriptions) {
		Wait.waitfor(3);
		typeText(driver, test, OCR_HTSNumber, "Enter HTSNo :",HTSNo);
		typeText(driver, test, OCR_Descriptions, "Enter Descriptions :", Descriptions);

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
