package filesClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class AddOwnerPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */

	public static final String OCR_Homepage_module = "//ul[@class='nav navbar-nav']/li[2]/a";
	public static final String OCR_AddOwnerButton = "//button[@name='Add']";
	public static final String OCR_EmpLName = "//input[@id='editDosLicenseOwner_dosLicenseOwner_ownerLastName']";
	public static final String OCR_EmpFName = "//input[@id='editDosLicenseOwner_dosLicenseOwner_ownerFirstName']";
	public static final String OCR_BtnSave = "//button[@name='save']";

	/*
	 * ****************************** Constructor *********************************
	 */
	public AddOwnerPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;

	}

	/* ******************************* Actions ********************************* */
	public void SearchAuthowner(String EMPLName, String EMPFName) {
		clickElement(driver, test, OCR_AddOwnerButton, "Click on add Ownwer button");
		typeText(driver, test, OCR_EmpLName, "Add last name:", EMPLName);
		typeText(driver, test, OCR_EmpFName, "Add First Name:", EMPFName);
	}

	public void clickonSave() {
		clickElement(driver, test, OCR_BtnSave, "click on save");
	}

}