package dmsClasses;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;

import utilities.GenericMethods;

public class SearchControlAttributesDetailPage extends GenericMethods {
	public WebDriver driver;
	public ExtentTest test;

	/* ******************************** LOCATORS ******************************** */
	public static final String OCR_ControlAttribDetCode = "//input[@id='resultDocumentAttributeDetails_comDocAttribsDetailsValue_docAttrbsDetailsCode']";
	public static final String OCR_ControlAttribDesc = "//select[@id='resultDocumentAttributeDetails_comDocAttribsDetailsValue_attribCode']";
	public static final String OCR_CtrlAttrDetDesc = "//input[@id='resultDocumentAttributeDetails_comDocAttribsDetailsValue_docAttrbsDetailsDesc']";
	public static final String OCR_Status = "//select[@id='resultDocumentAttributeDetails_comDocAttribsDetailsValue_status']";
	public static final String OCR_SortBy = "//select[@name='sortBy']";
	public static final String OCR_Direction = "//select[@name='direction']";
	public static final String OCR_Button_Search = "//button[contains(text(),'Search')]";
	public static final String OCR_Button_AddCtrlAttribDetail = "//button[contains(text(),'Add Control Attributes Detail')]";

	/* ******************************* Constructor ****************************** */

	public SearchControlAttributesDetailPage(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
	}

	/* ******************************* Actions ********************************* */

	public void search_ctrlattribdetails(String ControlAttribDesc, String ControlAttribDetCode, String CtrlAttrDetDesc,
			String Status, String SortBy, String Direction) {
		selectByVisibleText(driver, test, OCR_ControlAttribDesc, "Selecting Control Attribute Description: ",
				ControlAttribDesc);
		typeText(driver, test, OCR_ControlAttribDetCode, "Enter Control Attribute Detail Code: ", ControlAttribDetCode);
		typeText(driver, test, OCR_CtrlAttrDetDesc, "Enter Control Attribute Detail Description: ", CtrlAttrDetDesc);
		selectByVisibleText(driver, test, OCR_Status, "Select Status: ", Status);
		selectByVisibleText(driver, test, OCR_SortBy, "Select SortBy: ", SortBy);
		selectByVisibleText(driver, test, OCR_Direction, "Select Direction: ", Direction);
	}

	public void search() {
		clickElement(driver, test, OCR_Button_Search, "Clicking on Search Button ");

	}

	public void add_controlattribdet() {
		clickElement(driver, test, OCR_Button_AddCtrlAttribDetail, "Clicking on Add Control Attributes Detail Button");
	}
}
