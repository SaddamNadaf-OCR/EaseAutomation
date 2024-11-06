package dmsClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;
import utilities.Wait;

public class CreateNewDocumentTypeControlAttributesMappingPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_Module = "//select[@id='module_dropdown_id']";
	public static final String OCR_SetId = "//select[@id='setIds_dropdown_id']";
	public static final String OCR_DocType = "//select[@id='doc_type_dropdown_id']";
	public static final String OCR_ControlAttrib = "//select[@id='doc_attribute_dropdown_id']";
	public static final String OCR_ControlAttribDet = "//select[@id='docAttrDtlCombo']";
	public static final String OCR_SelectControlAttribDetail = "//select[@id='savedDocAttrDtlCombo']";
	public static final String OCR_Button_ForwardAll = "//i[@class='fa fa-angle-double-right']";
	public static final String OCR_Button_BackwardAll = "//i[@class='fa fa-angle-double-left']";
	public static final String OCR_Button_Save = "//button[contains(text(),'Save')]";
	public static final String OCR_Button_SavendReturn = "//button[contains(text(),'Save & Return')]";

	/* ******************************* Constructor ****************************** */

	public CreateNewDocumentTypeControlAttributesMappingPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	public void add_doctypecontrlattribmapping(String Module, String SetId, String DocType, String ControlAttrib) {
		selectByVisibleText(driver, test, OCR_Module, "Select Module", Module);
		selectByVisibleText(driver, test, OCR_SetId, "Select Module", SetId);
		Wait.waitfor(3);
		selectByVisibleText(driver, test, OCR_DocType, "Select Doc Type: ", DocType);
		selectByVisibleText(driver, test, OCR_ControlAttrib, "Select Control Attribute", ControlAttrib);
	}

	public void selectall() {
		clickElement(driver, test, OCR_Button_ForwardAll, "Click on Forward Button");
	}

	public void save() {
		clickElement(driver, test, OCR_Button_Save, "Click on Save Button");
	}

	public void savendreturn() {
		clickElement(driver, test, OCR_Button_SavendReturn, "Click on Save and Return Button");
	}
}
