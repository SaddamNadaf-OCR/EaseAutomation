package filesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class CreateNewOrderCategoryPage extends GenericMethods {

	public WebDriver driver;
	public ExtentTest test;

	// ---------------------------------Locators--------------------------------------//

	public static final String Create_OrderCategoryType = "//input[@name='orderCategory.orderCategoryType']";
	public static final String Create_OrderCategoryName = "//input[@name='orderCategory.orderCategoryName']";
	public static final String OCR_Save = "//button[@name='save']";
	public static final String OCR_SaveandReturn = "//button[@name='ok']";

	// -----------------------------Constructor---------------------------------------------//

	public CreateNewOrderCategoryPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	// -----------------------------OrderCategoryType-------------------------------------------//

	public void enterOrderCategoryType(String OrderCategoryType, String OrderCategoryName) {

		typeText(driver, test, Create_OrderCategoryType, "Enter OrderCategory Type :", OrderCategoryType);
		typeText(driver, test, Create_OrderCategoryName, "Enter Name :", OrderCategoryName);
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
