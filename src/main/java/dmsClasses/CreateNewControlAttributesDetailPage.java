package dmsClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class CreateNewControlAttributesDetailPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_CtrlAttribDesc = "//select[@id='atribCo']";
	public static final String OCR_CtrlAttribDetCode = "//input[@id='editDocumentAttributeDetails_docAttrbsDetailsCode']";
	public static final String OCR_CtrlAttribDetDesc = "//input[@id='editDocumentAttributeDetails_comDocAttribsDetailsValue_docAttrbsDetailsDesc']";
	public static final String OCR_Button_Save = "//input[@name='save']";
	public static final String OCR_Button_Cancel = "//input[@name='cancel']";

	/* ******************************* Constructor ****************************** */

	public CreateNewControlAttributesDetailPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */
	public void add_controlattributesdet(String ControlAttribDesc, String ControlAttribDetailCode,
			String ControlAttribDetDesc) {
		selectByVisibleText(driver, test, OCR_CtrlAttribDesc, "Select Control Attribute Description :  ",
				ControlAttribDesc);
		typeText(driver, test, OCR_CtrlAttribDetCode, "Enter Control Attributes Detail Code : ",
				ControlAttribDetailCode);
		typeText(driver, test, OCR_CtrlAttribDetDesc, "Enter Control Attributes Detail Description : ",
				ControlAttribDetDesc);
		clickElement(driver, test, OCR_Button_Save, "Clicking on Save Button");
	}

	public void cancel() {
		clickElement(driver, test, OCR_Button_Cancel, "Clicking on Cancel Button");
	}
}
