package tablesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class CreateCommodityTypePage extends GenericMethods {
	
	public WebDriver driver;
	public ExtentTest test;
	
//--------------------------------------Locators--------------------------------------------------------//
	
	public static final String OCR_CommodityTypeCode = "//input[@name='commodityType.commodityCode']";
	public static final String OCR_CommodityTypeDescription = "//input[@name='commodityType.commodityDesc']";
	public static final String OCR_Status = "//select[@name='status']";
	public static final String OCR_Save = "//button[@name='save']";
	public static final String OCR_SaveandReturn = "//button[@name='ok']";
	
// -------------------------------------------Constructor-----------------------------------------//

	public CreateCommodityTypePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}
// --------------------------Code----------------------//
	public void enter_CommodityTypeCode(String CommodityTypeCode, String CommodityTypeDescription, String Status) {
		Wait.waitfor(3);
		typeText(driver, test, OCR_CommodityTypeCode, "Enter CommodityTypeCode :",CommodityTypeCode);
		typeText(driver, test, OCR_CommodityTypeDescription, "enter CommodityTypeDescription", CommodityTypeDescription);
		typeText(driver, test, OCR_Status, "Enter Status :", Status);

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
