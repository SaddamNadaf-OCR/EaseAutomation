package filesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class CreateNewRegionPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	// -------------------------------Locators-----------------------------------------------//

	public static final String Create_RegionID = "//input[@name='region.regionId']";
	public static final String Create_RegionName = "//input[@name='region.regionName']";
	public static final String OCR_Save = "(//button[@class='primary-btn'])[1]";
	public static final String OCR_SaveandReturn = "//button[@class='primary-btn'][2]";

	// -----------------------------Constructor---------------------------------------------//

	public CreateNewRegionPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	// -----------------------------RegionID-------------------------------------------//

	public void enterRegionID(String RegionID, String RegionName) {

		typeText(driver, test, Create_RegionID, "Enter RegionID :", RegionID);
		typeText(driver, test, Create_RegionName, "Enter Description :", RegionName);
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
