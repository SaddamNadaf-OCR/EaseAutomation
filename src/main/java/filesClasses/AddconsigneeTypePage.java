package filesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class AddconsigneeTypePage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_AddConsigneetypebtn = "//button[@name='Add']";
	public static final String OCR_consigneeID = "//input[@name='consigneeType.consigneeTypeId']";
	public static final String OCR_ConsigneeName = "//input[@name='consigneeType.consigneeTypeName']";
	public static final String OCR_AddConsigneetype_Save = "//button[@type='submit']";

	/*
	 * ****************************** Constructor *********************************
	 */
	public AddconsigneeTypePage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

	}
	/* ******************************* Actions ********************************* */

	public void AddConsigneetypeDetails(String ConsigneeID, String ConsigneeName) {
		clickElement(driver, test, OCR_AddConsigneetypebtn, "click on add consignee type button ");
		typeText(driver, test, OCR_consigneeID, "add consignee ID ", ConsigneeID);
		Wait.waitfor(3);
		typeText(driver, test, OCR_ConsigneeName, "Add Consignee Name ", ConsigneeName);
		Wait.waitfor(3);
	}

	// Click on Save Button
	public void Click_ConsigneetypeSave() {
		Wait.waitfor(3);

		clickElement(driver, test, OCR_AddConsigneetype_Save, "Click on Save Button");

	}

}
