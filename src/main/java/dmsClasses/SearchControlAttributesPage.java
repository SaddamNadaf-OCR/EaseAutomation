package dmsClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import utilities.GenericMethods;
import utilities.Wait;

public class SearchControlAttributesPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_ContAttribCode = "//input[@id='resultDocumentAttribute_comDocAttrbsValue_attribCode']";
	public static final String OCR_ContAttribDes = "//input[@id='resultDocumentAttribute_comDocAttrbsValue_attribDesc']";
	public static final String OCR_Status = "//select[@id='resultDocumentAttribute_comDocAttrbsValue_status']";
	public static final String OCR_SortBy = "//select[@name='sortBy']";
	public static final String OCR_Direction = "//select[@name='direction']";
	public static final String OCR_Button_Search = "//button[contains(text(),'Search')]";
	public static final String OCR_Button_AddContAttrib = "//button[@name='Add']";

	/* ******************************* Constructor ****************************** */

	public SearchControlAttributesPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	public void search_controlattributes(String ControlAttribCode, String ContAttribDes, String Status, String SortBy,
			String Direction) {
		typeText(driver, test, OCR_ContAttribCode, "Enter Control Attribute Code : ", ControlAttribCode);
		Wait.waitfor(3);
		typeText(driver, test, OCR_ContAttribDes, "Enter Control Attribute Description:", ContAttribDes);
		selectByVisibleText(driver, test, OCR_Status, "Select Status: ", Status);
		Wait.waitfor(3);
		selectByVisibleText(driver, test, OCR_SortBy, "Select Sort By: ", SortBy);
		selectByVisibleText(driver, test, OCR_Direction, "Select Status: ", Direction);
	}

	public void search() {
		clickElement(driver, test, OCR_Button_Search, "Clicking on Search Button");

	}

	public void add_controlattrib() {
		clickElement(driver, test, OCR_Button_AddContAttrib, "Clicking on Add Control Attributes");
	}

}
