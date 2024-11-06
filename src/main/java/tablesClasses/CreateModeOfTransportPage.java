package tablesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class CreateModeOfTransportPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;
	
//------------------------------------------Locators-----------------------------------------------------------------//
	
	public static final String OCR_MOTCode = "//input[@name='mot.motCode']";
	public static final String OCR_Country = "//input[@id='editModeOfTransport_']";
	public static final String OCR_MOTID = "//input[@name='mot.motId']";
	public static final String OCR_MOTDesc = "//input[@name='mot.motDes']";
	public static final String OCR_MOTType = "//select[@name='typeOfTransportCode']";
	public static final String OCR_Save = "//button[@name='save']";
	public static final String OCR_SaveandReturn = "//button[@name='ok']";
	
// -------------------------------------------Constructor-----------------------------------------//

	public CreateModeOfTransportPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

//--------------------------Code------------------------------------------------//
	public void enter_MOTCode(String MOTCode, String Country, String MOTID, String MOTDesc, String MOTType) {
		Wait.waitfor(3);
		typeText(driver, test, OCR_MOTCode, "Enter MOTCode :",MOTCode);
		typeText(driver, test, OCR_Country, "Enter Country :", Country);
		typeText(driver, test, OCR_MOTID, "Enter MOTID :", MOTID);
		typeText(driver, test, OCR_MOTDesc, "Enter MOTDesc :", MOTDesc);
		selectByVisibleText(driver, test, OCR_MOTType, "Select MOTType :", MOTType);

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
