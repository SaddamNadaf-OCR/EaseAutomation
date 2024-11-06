package dmsClasses;

import org.openqa.selenium.WebDriver;
import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;
import utilities.Wait;

public class SearchDocumentTypeControlAttributesPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_Module = "//select[@id='module_dropdown_id']";
	public static final String OCR_SetId = "//select[@id='setIds_dropdown_id']";
	public static final String OCR_DocType = "//select[@id='doc_type_dropdown_id']";
	public static final String OCR_ContrAttrib = "//select[@id='doc_attribute_dropdown_id']";
	public static final String OCR_ContrAttribDet = "//select[@id='doc_attribute_dtl_dropdown_id']";
	public static final String OCR_SortBy = "//select[@id='sort-by-id']";
	public static final String OCR_Direction = "//select[@id='direction-id']";
	public static final String OCR_Button_Search = "//button[@name='Search']";
	public static final String OCR_Button_AddDocTypCtrlAttrib = "//button[contains(text(),'Add Document Type Control Attribute')]";

	/* ******************************* Constructor ****************************** */

	public SearchDocumentTypeControlAttributesPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	public void search_doctypectrlattribdetails(String Module, String SetId, String DocType, String ContrAttrib,
			String ContrAttribDet, String SortBy, String Direction) {

		selectByVisibleText(driver, test, OCR_Module, "Selecting Module: ", Module);
		Wait.waitfor(4);
		selectByVisibleText(driver, test, OCR_SetId, "Select Set ID: ", SetId);
		Wait.waitfor(5);
		selectByVisibleText(driver, test, OCR_DocType, "Selecting Doc type values: ", DocType);
		selectByVisibleText(driver, test, OCR_ContrAttrib, "Selecting Control Attribute: ", ContrAttrib);
		selectByVisibleText(driver, test, OCR_ContrAttribDet, "Selecting Control Attribute Details: ", ContrAttribDet);
		selectByVisibleText(driver, test, OCR_SortBy, "Select SortBy: ", SortBy);
		selectByVisibleText(driver, test, OCR_Direction, "Select Direction: ", Direction);
	}

	public void search() {
		Wait.waitfor(3);
		clickElement(driver, test, OCR_Button_Search, "Clicking on Search Button: ");

	}

	public void add_doctypcontrolattrib() {
		clickElement(driver, test, OCR_Button_AddDocTypCtrlAttrib,
				"Clicking on Add Document type Control Attributes Button:");
	}

}
