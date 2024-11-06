package dmsClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class HomePage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_DMSFormConfig = "//a[contains(text(),'DMS Forms Configuration')]";
	public static final String OCR_HomePage_ListScreening = "//ul[@class='nav navbar-nav']/li[2]/a";

	/* ******************************* Constructor ****************************** */

	public HomePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	// Move to list screening
	public void moveTo_ListScreening() {
		mouseOver(driver, test, OCR_HomePage_ListScreening, "Mouse over on Watch List Screening");
	}

	// Move to Tools
	public void movetoTools() {
		mouseOver(driver, test, "//i[@class='fa fa-wrench']", "Mouse Hover to Tools");
	}

	// Move to DMS Form Configuration
	public void movetodmsconfig() {
		clickElement(driver, test, OCR_DMSFormConfig, "Clicking on DMS Form Configuration");
	}

}
