package filesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class createNewSegmentPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	// ----------------------------------------Locator-------------------------------------------//

	public static final String Create_SegmentCode = "//input[@name='lesSegment.segmentCode']";
	public static final String Create_SegmentName = "//input[@name='lesSegment.segmentName']";
	public static final String OCR_Save = "//input[@name='save']";
	public static final String OCR_SaveandReturn = "//input[@name='ok']";

	// ------------------------------Constructor-----------------------------------------//

	public createNewSegmentPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	// -------------------------------SegmentCode---------------------------------------//

	public void enterSegmentCode(String SegmentCode, String SegmentName) {

		typeText(driver, test, Create_SegmentCode, "Enter SegmentCode :", SegmentCode);
		typeText(driver, test, Create_SegmentName, "Enter SegmentName :", SegmentName);
	}

	// -------------------------------Save-------------------------------------------------//
	public void save() {
		scrollToElement(driver, OCR_Save);
		Wait.waitfor(3);
		scrollToTop(driver);
		clickElement(driver, test, OCR_Save, "Click on Save Button ");
	}

	// --------------------------------Save&Return-------------------------------------------//
	public void saveandReturn() {
		scrollToElement(driver, OCR_SaveandReturn);
		Wait.waitfor(3);
		scrollToTop(driver);
		clickElement(driver, test, OCR_SaveandReturn, "Click on Save Button ");
	}

}
