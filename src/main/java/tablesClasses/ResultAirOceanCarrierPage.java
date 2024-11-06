package tablesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import utilities.GenericMethods;
import utilities.Wait;

public class ResultAirOceanCarrierPage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;
	
// -------------------------------Locators-----------------------------------------------//
	public static final String OCR_AirOceanCarrier_Title = "//h3[@class='page-heading']";
	public static final String OCR_Copy_Icon="//i[@class='fa fa-copy']";
	public static final String OCR_Delete_Icon="//i[@class='fa fa-trash-o']";
	public static final String OCR_Code = "//input[@name='carrier.carrierCode']";
	public static final String OCR_Save = "//input[@name='save']";
	public static final String OCR_SaveandReturn = "//input[@name='okx']";

	// ----------------------------------Constructor------------------------------------------//

	public ResultAirOceanCarrierPage(WebDriver driver, ExtentTest test) {
			this.driver = driver;
			this.test = test;
	}
			
	/* ******************** Actions ********************************* */
	// Title of AirOceanCarrier page is displaying or not
	public void AirOceanCarrierIsDisplayed() {
		try {
			isDisplayed(driver, OCR_AirOceanCarrier_Title);
				test.log(LogStatus.PASS, "Result AirOceanCarrier Is Displayed");
			} catch (Exception e) {
				testFailSshot(driver, test);
				test.log(LogStatus.FAIL, "Result AirOceanCarrier  Is Not Displayed");

				}
			}
//....................click on Copy Icon......................//
	public void copyCarrier() {
			clickElement(driver, test, OCR_Copy_Icon, "clicking on Copy Icon :");
			}
//....................click on delete Icon......................//
	public void deleteCarrier() {
			clickElement(driver, test, OCR_Delete_Icon, "clicking on Delete Icon :");
			}
//---------------------------------Code----------------------------------------------------//
	public void enter_Code(String newCode) {
			Wait.waitfor(3);
			typeText(driver, test, OCR_Code, "Enter Code :",newCode);
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
