package filesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class CreateNewPriorityPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	// --------------------------------Locators---------------------------------------------------//

	public static final String Create_PriorityType = "//input[@name='priority.priorityType']";
	public static final String Create_PriorityName = "//input[@name='priority.priorityName']";
	public static final String OCR_Save = "//button[@name='save']";
	public static final String OCR_SaveandReturn = "//button[@name='ok']";

	// -----------------------------Constructor---------------------------------------------//

	public CreateNewPriorityPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	// -----------------------------Priority Type-----------------------------------------------//
	

	public void enterPriorityType(String PriorityType, String PriorityName) {

		typeText(driver, test, Create_PriorityType, "Enter Priority Type :", PriorityType);
		typeText(driver, test, Create_PriorityName, "Enter Priority Name :", PriorityName);
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
