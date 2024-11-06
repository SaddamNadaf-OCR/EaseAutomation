package dmsClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class CreateNewControlAttributesPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_ControlAttribCode = "//input[@id='editDocumentAttribute_comDocAttrbsValue_attribCode']";
	public static final String OCR_ControlAttribDesc = "//input[@id='editDocumentAttribute_comDocAttrbsValue_attribDesc']";
	public static final String OCR_Button_Save = "//input[@name='save']";
	public static final String OCR_Button_SavendReturn = "//input[@name='ok']";
	public static final String OCR_Button_Cancel = "//input[@name='cancel']";

	/* ******************************* Constructor ****************************** */

	public CreateNewControlAttributesPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	public void add_controlattributes(String ControlAttribCode, String ControlAttribDesc) {
		typeText(driver, test, OCR_ControlAttribCode, "Enter Control Attributes Code : ", ControlAttribCode);
		typeText(driver, test, OCR_ControlAttribDesc, "Enter Control Attributes Description : ", ControlAttribDesc);
		clickElement(driver, test, OCR_Button_Save, "Clicking on Save Button: ");
	}

	public void cancel() {
		clickElement(driver, test, OCR_Button_Cancel, "Clicking on Cancel Button");
	}
}